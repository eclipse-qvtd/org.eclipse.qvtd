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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTc2QVTu;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTm2QVTp;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTu2QVTm;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.etl.scheduling.ClassRelationships;
import org.eclipse.qvtd.compiler.internal.etl.scheduling.QVTp2QVTg;
import org.eclipse.qvtd.compiler.internal.scheduler.ScheduledRegion;
import org.eclipse.qvtd.compiler.internal.scheduler.Scheduler;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public abstract class AbstractCompilerChain 
{
	public static class Key<T>
	{
		protected final @NonNull String name;
		
		public Key(@NonNull String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}	
	}
	
	public static interface Listener
	{
		void compiled(@NonNull String step, @NonNull Resource resource);
	}
	
	public static final @NonNull String DEFAULT_STEP = "default";
	public static final @NonNull String QVTC_STEP = "QVTc";
	public static final @NonNull String QVTG_STEP = "QVTg";
	public static final @NonNull String QVTI_STEP = "QVTi";
	public static final @NonNull String QVTM_STEP = "QVTm";
	public static final @NonNull String QVTP_STEP = "QVTp";
	public static final @NonNull String QVTR_STEP = "QVTr";
	public static final @NonNull String QVTS_STEP = "QVTs";
	public static final @NonNull String QVTU_STEP = "QVTu";
	
	public static final @NonNull Key<Boolean> CHECK_KEY = new Key<Boolean>("check");
	public static final @NonNull Key<Map<?,?>> SAVE_OPTIONS_KEY = new Key<Map<?,?>>("save");
	public static final @NonNull Key<URI> URI_KEY = new Key<URI>("uri");
	public static final @NonNull Key<Boolean> VALIDATE_KEY = new Key<Boolean>("validate");

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

	protected final @NonNull EnvironmentFactory environmentFactory;
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
	
	protected AbstractCompilerChain(@NonNull EnvironmentFactory environmentFactory, @NonNull URI txURI, @Nullable Map<@NonNull String, @NonNull Map<@NonNull Key<?>, @Nullable Object>> options) {
		this.environmentFactory = environmentFactory;
		this.asResourceSet = environmentFactory.getMetamodelManager().getASResourceSet();
    	this.txURI = txURI;
    	this.prefixURI = txURI.trimFileExtension();
//    	this.qvtcURI = prefixURI.appendFileExtension("qvtcas");
		this.options = options != null ? options : new HashMap<@NonNull String, @NonNull Map<@NonNull Key<?>, @Nullable Object>>();
	}

	public void addListener(@NonNull Listener listener) {
		List<@NonNull Listener> listeners2 = listeners;
		if (listeners2 == null) {
			listeners = listeners2 = new ArrayList<@NonNull Listener>();
		}
		if (!listeners2.contains(listener)) {
			listeners2.add(listener);
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

	public void dispose() {}

	public abstract Transformation execute(@NonNull String text) throws IOException;

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
	
	protected @NonNull URI getURI(@NonNull String stepKey, @NonNull Key<URI> uriKey, @NonNull String defaultSuffix) {
		URI uri = getOption(stepKey, URI_KEY);
		return uri != null ? uri : prefixURI.appendFileExtension(defaultSuffix);
	}

	protected @NonNull Resource qvtc2qvtp(@NonNull Resource cResource, @NonNull QVTuConfiguration qvtuConfiguration) throws IOException {
		Resource uResource = qvtc2qvtu(cResource, qvtuConfiguration);
		Resource mResource = qvtu2qvtm(uResource);
    	Resource pResource = qvtm2qvtp(mResource);
		return pResource;
	}

	protected @NonNull Resource qvtc2qvtu(@NonNull Resource cResource, @NonNull QVTuConfiguration qvtuConfiguration) throws IOException {
		URI qvtuURI = getURI(QVTU_STEP, URI_KEY, "qvtu.qvtcas");
		Resource uResource = createResource(qvtuURI);
        for (EObject e : cResource.getContents()) {
            CoreModel newE = (CoreModel) EcoreUtil.copy(e);
            newE.setExternalURI(((CoreModel) e).getExternalURI().replace(".qvtc", ".qvtu.qvtc"));
            newE.setName(((CoreModel) e).getName().replace(".qvtc", ".qvtu"));
            uResource.getContents().add(newE);
        }
        QVTc2QVTu ctou = new QVTc2QVTu(environmentFactory, qvtuConfiguration);
        for (EObject e : ClassUtil.nullFree(uResource.getContents())) {
        	ctou.execute((CoreModel) e);
        }
		saveResource(uResource, QVTU_STEP);
		return uResource;
	}

	protected @NonNull Resource qvtg2qvti(@NonNull Resource pResource, @NonNull Resource gResource, @NonNull QVTp2QVTg qvtp2qvtg) throws IOException {
		URI qvtiURI = getURI(QVTI_STEP, URI_KEY, "qvtias");
		Schedule schedule = getSchedule(gResource);
		Scheduler scheduler = new Scheduler(environmentFactory, schedule, qvtp2qvtg);
		ScheduledRegion rootRegion = scheduler.qvtp2qvts();
//		saveResource(sResource, QVTS_STEP);
		Resource iResource = scheduler.qvts2qvti(rootRegion, qvtiURI);
		saveResource(iResource, QVTI_STEP);
		return iResource;
	}

    protected @NonNull Resource qvtm2qvtp(@NonNull Resource mResource) throws IOException {
		URI qvtpURI = getURI(QVTP_STEP, URI_KEY, "qvtp.qvtcas");
		Resource pResource = createResource(qvtpURI);
        QVTm2QVTp tx = new QVTm2QVTp(environmentFactory);
        tx.transform(mResource, pResource);
		saveResource(pResource, QVTP_STEP);
        return pResource;
    }

	protected @NonNull Resource qvtp2qvtg(@NonNull Resource pResource, @NonNull QVTp2QVTg qvtp2qvtg) throws IOException {
		URI qvtgURI = getURI(QVTS_STEP, URI_KEY, "qvts.xmi");
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
		URI qvtmURI = getURI(QVTM_STEP, URI_KEY, "qvtm.qvtcas");
		Resource mResource = createResource(qvtmURI);
		for (EObject e : uResource.getContents()) {
			CoreModel newE = (CoreModel) EcoreUtil.copy(e);
			newE.setExternalURI(((CoreModel) e).getExternalURI()
				.replace(".qvtu.qvtc", ".qvtm.qvtc"));
			newE.setName(((CoreModel) e).getName().replace(".qvtu", ".qvtm"));
			mResource.getContents().add(newE);
		}
		QVTu2QVTm utom = new QVTu2QVTm(environmentFactory);
		for (EObject e : mResource.getContents()) {
			utom.execute((CoreModel) e);
		}
		saveResource(mResource, QVTM_STEP);
		return mResource;
	}

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
		List<@NonNull Listener> listeners2 = listeners;
		if (listeners2 != null) {
			for (Listener listener : listeners2) {
				listener.compiled(stepKey, resource);
			}
		}
	}

	public <T> void setOption(@NonNull String stepKey, @NonNull Key<T> optionKey, @Nullable T object) {
		Map<@NonNull Key<?>, @Nullable Object> stepOptions = options.get(stepKey);
		if (stepOptions == null) {
			stepOptions = new HashMap<@NonNull Key<?>, @Nullable Object>();
			options.put(stepKey, stepOptions);
		}
		stepOptions.put(optionKey, object);
	}
}
