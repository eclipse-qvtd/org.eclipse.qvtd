/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTc2QVTu;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTm2QVTp;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTu2QVTm;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.etl.scheduling.ClassRelationships;
import org.eclipse.qvtd.compiler.internal.etl.scheduling.QVTp2QVTg;
import org.eclipse.qvtd.compiler.internal.scheduler.RootScheduledRegion;
import org.eclipse.qvtd.compiler.internal.scheduler.Scheduler;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public abstract class AbstractCompilerChain implements CompilerChain
{
	private static final @NonNull Map<@NonNull String, @NonNull String> step2extension = new HashMap<@NonNull String, @NonNull String>();
	static {
		step2extension.put(QVTR_STEP, "qvtras");
		step2extension.put(TRACE_STEP, "ecore.oclas");
		step2extension.put(QVTC_STEP, "qvtcas");
		step2extension.put(QVTU_STEP, "qvtu.qvtcas");
		step2extension.put(QVTM_STEP, "qvtm.qvtcas");
		step2extension.put(QVTP_STEP, "qvtp.qvtcas");
		step2extension.put(QVTS_STEP, "qvts.xmi");
		step2extension.put(QVTI_STEP, "qvtias");
		step2extension.put(JAVA_STEP, "java");
		step2extension.put(CLASS_STEP, "class");
	}
	
	protected static class JavaResult
	{
		@NonNull File file;
		@NonNull String code;
		@NonNull String qualifiedClassName;
		@NonNull String classPath;
		
		public JavaResult(@NonNull File file, @NonNull String code, @NonNull String qualifiedClassName, @NonNull String classPath) {
			super();
			this.file = file;
			this.code = code;
			this.qualifiedClassName = qualifiedClassName;
			this.classPath = classPath;
		}
	}
	
	public static void assertNoResourceErrors(@NonNull String prefix, @NonNull Resource resource) {
		String message = PivotUtil.formatResourceDiagnostics(resource.getErrors(), prefix, "\n\t");
		if (message != null)
			assert false : message;
	}
	
	public static void assertNoValidationErrors(@NonNull String prefix, @NonNull Resource resource) {
		for (EObject eObject : resource.getContents()) {
			assertNoValidationErrors(prefix, eObject);
		}
	}

	public static void assertNoValidationErrors(@NonNull String string, EObject eObject) {
		Map<Object, Object> validationContext = LabelUtil.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject, validationContext);
		List<Diagnostic> children = diagnostic.getChildren();
		if (children.size() <= 0) {
			return;
		}
		StringBuilder s = new StringBuilder();
		s.append(children.size() + " validation errors");
		for (Diagnostic child : children){
			s.append("\n\t");
			if (child.getData().size() > 0) {
				Object data = child.getData().get(0);
				if (data instanceof Element) {
					for (EObject eScope = (Element)data; eScope instanceof Element; eScope = eScope.eContainer()) {
						ModelElementCS csElement = ElementUtil.getCsElement((Element)eScope);
						if (csElement != null) {
							ICompositeNode node = NodeModelUtils.getNode(csElement);
							if (node != null) {
								Resource eResource = csElement.eResource();
								if (eResource != null) {
									s.append(eResource.getURI().lastSegment() + ":");
								}
								int startLine = node.getStartLine();
								s.append(startLine + ":");
							}
							s.append(((Element)data).eClass().getName() + ": ");
							break;
						}
					}
				}
			}
			s.append(child.getMessage());
		}
		assert false : s.toString();
	}

	public static @Nullable String getDefaultExtension(@NonNull String key) {
		return step2extension.get(key);
	}

	protected final @NonNull QVTiEnvironmentFactory environmentFactory;
	protected final @NonNull ResourceSet asResourceSet;
	
	/**
	 * The compilation chain options are potentially 3-layered. The outer layer is indexed by the
	 * compilation step output such as QVTI_KEY. The next layer is indexed by the role such as VALIDATE_KEY.
	 * For SAVE_OPTIONS_KEY there is a futher level of indexing for each EMF save option.
	 * 
	 * If there is no step entry or no key entry, a default is taken from the DEFAULT_STEP.
	 */
	protected final @NonNull Map<@NonNull String, @NonNull Map<@NonNull Key<?>, @Nullable Object>> options;
	
	protected final @NonNull URI txURI;
	protected final @NonNull URI prefixURI;
	
	private @Nullable List<@NonNull Listener> listeners = null;
	
	protected AbstractCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI,
			@Nullable Map<@NonNull String, @NonNull Map<@NonNull Key<?>, @Nullable Object>> options) {
		this.environmentFactory = environmentFactory;
		this.asResourceSet = environmentFactory.getMetamodelManager().getASResourceSet();
    	this.txURI = txURI;
    	this.prefixURI = txURI.trimFileExtension();
		this.options = options != null ? options : new HashMap<@NonNull String, @NonNull Map<@NonNull Key<?>, @Nullable Object>>();
	}

	@Override
	public void addListener(@NonNull Listener listener) {
		List<@NonNull Listener> listeners2 = listeners;
		if (listeners2 == null) {
			listeners = listeners2 = new ArrayList<@NonNull Listener>();
		}
		if (!listeners2.contains(listener)) {
			listeners2.add(listener);
		}
	}

	@Override
	public @NonNull Class<? extends Transformer> build(@NonNull String enforcedOutputName, @NonNull String ... genModelFiles) throws Exception {
		Transformation asTransformation = compile(enforcedOutputName);
		JavaResult javaResult = qvti2java(asTransformation, genModelFiles);
		Class<? extends Transformer> txClass = java2class(javaResult);
		return txClass;
	}

	@Override
	public abstract @NonNull Transformation compile(@NonNull String enforcedOutputName) throws IOException;

	protected void compiled(@NonNull String stepKey, @NonNull Object object) {
		List<@NonNull Listener> listeners2 = listeners;
		if (listeners2 != null) {
			for (Listener listener : listeners2) {
				listener.compiled(stepKey, object);
			}
		}
	}
	
	protected @NonNull QVTuConfiguration createQVTuConfiguration(@NonNull Resource cResource, QVTuConfiguration.Mode mode, @NonNull String enforcedOutputName) throws IOException {
		Transformation transformation = getTransformation(cResource);
		List<@NonNull String> inputNames = new ArrayList<@NonNull String>();
		for (TypedModel typedModel : transformation.getModelParameter()) {
			String modelName = typedModel.getName();
			if ((modelName != null) && !modelName.equals(enforcedOutputName)) {
				inputNames.add(modelName);
			}
		}
		return new QVTuConfiguration(QVTuConfiguration.Mode.ENFORCE, inputNames, Collections.singletonList(enforcedOutputName));
	}

	protected @NonNull Resource createResource(@NonNull URI uri) throws IOException {
		Resource resource = asResourceSet.createResource(uri);
		if (resource == null) {
			throw new IOException("Failed to create " + uri);
		}
		return resource;
	}

	@Override
	public void dispose() {}

	public <T> @Nullable T getOption(@NonNull String stepKey, @NonNull Key<T> optionKey) {
		Map<@NonNull Key<?>, @Nullable Object> stepOptions = options.get(stepKey);
		if ((stepOptions == null) && !options.containsKey(stepOptions)) {
			stepOptions = options.get(DEFAULT_STEP);
		}
		@Nullable Object saveOptions = null;
		if (stepOptions != null) {
			saveOptions = stepOptions.get(optionKey);
			if ((saveOptions == null) && !options.containsKey(optionKey)) {
				Map<@NonNull Key<?>, @Nullable Object> defaultOptions = options.get(DEFAULT_STEP);
				if (defaultOptions != null){
					saveOptions =  defaultOptions.get(optionKey);
				}
			}
		}
		@SuppressWarnings("unchecked") T castSaveOptions = (T) saveOptions;
		return castSaveOptions;
	}

	protected @NonNull Resource getResource(@NonNull URI uri) throws IOException {
		Resource resource = asResourceSet.getResource(uri, true);
		if (resource == null) {
			throw new IOException("Failed to get " + uri);
		}
		assertNoResourceErrors("get", resource);
    	assertNoValidationErrors("get validation", resource);
		return resource;
	}
	
	private @NonNull Schedule getSchedule(@NonNull Resource gResource) throws IOException {
		for (EObject eContent : gResource.getContents()) {
			if (eContent instanceof Schedule) {
	    		return (Schedule) eContent;
			}
		}
		throw new IOException("No Schedule element in " + gResource.getURI());
	}

	public @NonNull Transformation getTransformation(Resource resource) throws IOException {
		for (EObject eContent : resource.getContents()) {
			if (eContent instanceof BaseModel) {
	    		for (org.eclipse.ocl.pivot.Package aPackage : ((BaseModel)eContent).getOwnedPackages()) {
	    			for (org.eclipse.ocl.pivot.Class aClass : aPackage.getOwnedClasses()) {
	    				if (aClass instanceof Transformation) {
		                    return (Transformation) aClass;
		    			}
	    			}
	    		}
			}
		}
		throw new IOException("No Transformation element in " + resource.getURI());
	}
	
	protected @NonNull URI getURI(@NonNull String stepKey, @NonNull Key<URI> uriKey) {
		URI uri = getOption(stepKey, URI_KEY);
		return uri != null ? uri : prefixURI.appendFileExtension(step2extension.get(stepKey));
	}

	protected @NonNull Class<? extends Transformer> java2class(@NonNull JavaResult javaResult) throws Exception {
//		URI javaURI = getURI(JAVA_STEP, URI_KEY);
//		URI classURI = getURI(CLASS_STEP, URI_KEY);
		File explicitClassPath = new File("../org.eclipse.qvtd.xtext.qvtcore.tests/bin");
//		String qualifiedClassName = cg.getQualifiedName();
		OCL2JavaFileObject.saveClass(javaResult.classPath, javaResult.qualifiedClassName, javaResult.code);	
		@SuppressWarnings("unchecked")
		Class<? extends Transformer> txClass = (Class<? extends Transformer>) OCL2JavaFileObject.loadExplicitClass(explicitClassPath, javaResult.qualifiedClassName);
		assert txClass != null;
		compiled(CLASS_STEP, txClass);
		return txClass;
	}
		
	private void loadGenModel(@NonNull URI genModelURI) {
		ResourceSet resourceSet = environmentFactory.getResourceSet();
		MetamodelManagerInternal metamodelManager = environmentFactory.getMetamodelManager();
		Resource csGenResource = resourceSet.getResource(genModelURI, true);
		for (EObject eObject : csGenResource.getContents()) {
			if (eObject instanceof GenModel) {
				GenModel genModel = (GenModel)eObject;
				genModel.reconcile();
				metamodelManager.addGenModel(genModel);
			}
		}
	}

	protected @NonNull Resource qvtc2qvtp(@NonNull Resource cResource, @NonNull QVTuConfiguration qvtuConfiguration) throws IOException {
		Resource uResource = qvtc2qvtu(cResource, qvtuConfiguration);
		Resource mResource = qvtu2qvtm(uResource);
    	Resource pResource = qvtm2qvtp(mResource);
		return pResource;
	}

	protected @NonNull Resource qvtc2qvtu(@NonNull Resource cResource, @NonNull QVTuConfiguration qvtuConfiguration) throws IOException {
		URI qvtuURI = getURI(QVTU_STEP, URI_KEY);
		Resource uResource = createResource(qvtuURI);
        QVTc2QVTu qvtc2qvtu = new QVTc2QVTu(environmentFactory, qvtuConfiguration);
        qvtc2qvtu.transform(cResource, uResource);
		saveResource(uResource, QVTU_STEP);
		return uResource;
	}

	protected @NonNull Resource qvtg2qvti(@NonNull Resource pResource, @NonNull Resource gResource, @NonNull QVTp2QVTg qvtp2qvtg) throws IOException {
		URI qvtiURI = getURI(QVTI_STEP, URI_KEY);
		Schedule schedule = getSchedule(gResource);
		Scheduler scheduler = new Scheduler(environmentFactory, schedule, qvtp2qvtg);
		RootScheduledRegion rootRegion = scheduler.qvtp2qvts();
		compiled(QVTS_STEP, gResource);			// FIXME
//		saveResource(sResource, QVTS_STEP);
		Resource iResource = scheduler.qvts2qvti(rootRegion, qvtiURI, scheduler.getSymbolNameReservation());
		saveResource(iResource, QVTI_STEP);
		return iResource;
	}

	protected @NonNull JavaResult qvti2java(@NonNull Transformation asTransformation, @NonNull String ... genModelFiles) throws IOException {
		URI javaURI = getURI(JAVA_STEP, URI_KEY);
		ResourceSet resourceSet = environmentFactory.getResourceSet();
		resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
		if (genModelFiles != null) {
			for (String genModelFile : genModelFiles) {
				URI genModelURI = URI.createURI(genModelFile).resolve(txURI);
				loadGenModel(genModelURI);
			}
		}
		QVTiCodeGenerator cg = new QVTiCodeGenerator(environmentFactory, asTransformation);
		QVTiCodeGenOptions options = cg.getOptions();
		options.setUseNullAnnotations(true);
		options.setPackagePrefix("cg");
		String javaCodeSource = cg.generateClassFile();
		URI normalizedURI = resourceSet.getURIConverter().normalize(javaURI);
		File javaFile = cg.saveSourceFile(ClassUtil.nonNullState(normalizedURI.toFileString()));
//		cg.saveSourceFile("../org.eclipse.qvtd.xtext.qvtcore.tests/test-gen/");
		compiled(JAVA_STEP, javaFile);
		File explicitClassPath = new File("../org.eclipse.qvtd.xtext.qvtcore.tests/bin");
		return new JavaResult(javaFile, javaCodeSource, cg.getQualifiedName(), String.valueOf(explicitClassPath));
	}

    protected @NonNull Resource qvtm2qvtp(@NonNull Resource mResource) throws IOException {
		URI qvtpURI = getURI(QVTP_STEP, URI_KEY);
		Resource pResource = createResource(qvtpURI);
        QVTm2QVTp tx = new QVTm2QVTp(environmentFactory);
        tx.transform(mResource, pResource);
		saveResource(pResource, QVTP_STEP);
        return pResource;
    }

	protected @NonNull Resource qvtp2qvtg(@NonNull Resource pResource, @NonNull QVTp2QVTg qvtp2qvtg) throws IOException {
		URI qvtgURI = getURI(QVTS_STEP, URI_KEY);
		RootDomainUsageAnalysis domainUsageAnalysis = qvtp2qvtg.getDomainUsageAnalysis();
		Resource gResource = createResource(qvtgURI);
		Transformation asTransformation = getTransformation(pResource);
		domainUsageAnalysis.analyzeTransformation(asTransformation);
		qvtp2qvtg.run(pResource, gResource);
		gResource.getContents().add(domainUsageAnalysis.getPrimitiveTypeModel());
		saveResource(gResource, QVTG_STEP);
		return gResource;
	}

	protected @NonNull Transformation qvtp2qvti(@NonNull Resource pResource) throws IOException {
		RootDomainUsageAnalysis domainAnalysis = new QVTcoreDomainUsageAnalysis(environmentFactory);
		ClassRelationships classRelationships = new ClassRelationships(environmentFactory);
		QVTp2QVTg qvtp2qvtg = new QVTp2QVTg(domainAnalysis, classRelationships);
		Resource gResource = qvtp2qvtg(pResource, qvtp2qvtg);
		Resource iResource = qvtg2qvti(pResource, gResource, qvtp2qvtg);
		return getTransformation(iResource);
	}
	
	protected @NonNull Resource qvtu2qvtm(@NonNull Resource uResource) throws IOException {
		URI qvtmURI = getURI(QVTM_STEP, URI_KEY);
		Resource mResource = createResource(qvtmURI);
		QVTu2QVTm qvtu2qvtm = new QVTu2QVTm(environmentFactory);
		qvtu2qvtm.transform(uResource, mResource);
		saveResource(mResource, QVTM_STEP);
		return mResource;
	}

	@Override
	public void removeListener(@NonNull Listener listener) {
		List<@NonNull Listener> listeners2 = listeners;
		if (listeners2 != null) {
			listeners2.remove(listener);
		}
	}

	protected void saveResource(@NonNull Resource resource, @NonNull String stepKey) throws IOException {
		Map<?, ?> saveOptions = getOption(stepKey, SAVE_OPTIONS_KEY);
		if (saveOptions != null) {
			resource.save(saveOptions);
		}
		assertNoResourceErrors(stepKey, resource);
		if (getOption(stepKey, VALIDATE_KEY) == Boolean.TRUE) {
	        assertNoValidationErrors(stepKey, resource);
		}
		compiled(stepKey, resource);
	}

	@Override
	public <@NonNull T> void setOption(@NonNull String stepKey, @NonNull Key<T> optionKey, @Nullable T object) {
		Map<@NonNull Key<?>, @Nullable Object> stepOptions = options.get(stepKey);
		if (stepOptions == null) {
			stepOptions = new HashMap<@NonNull Key<?>, @Nullable Object>();
			options.put(stepKey, stepOptions);
		}
		stepOptions.put(optionKey, object);
	}
}
