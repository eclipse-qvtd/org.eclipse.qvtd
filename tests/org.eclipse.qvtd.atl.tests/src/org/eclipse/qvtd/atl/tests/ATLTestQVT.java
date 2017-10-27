/*******************************************************************************
 * Copyright (c) 2012, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.atl.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.dsls.core.EMFTCSInjector;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceImpl;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationASResourceFactory;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.xtext.util.EmfFormatter;
import junit.framework.TestCase;

public class ATLTestQVT extends QVTimperative
{
	public class AtlResourceFactoryImpl_514599 extends AtlResourceFactoryImpl		// FIXME workaround BUG 514599
	{
		@Override
		public Resource createResource(URI uri) {
			return new AtlResourceImpl_514599(uri);
		}
	}

	public static class AtlResourceImpl_514599 extends AtlResourceImpl		// FIXME workaround BUG 514599
	{
		public AtlResourceImpl_514599(URI uri) {
			super(uri);
		}

		@Override
		protected Charset getCharset() throws IOException {
			final URI uri = getURI();
			if (uri != null && uri.isPlatformResource() && EMFPlugin.IS_ECLIPSE_RUNNING) {
				final IWorkspaceRoot wr = ResourcesPlugin.getWorkspace().getRoot();
				final IResource r = wr.findMember(uri.toPlatformString(true));
				if (r instanceof IFile) {
					try {
						return Charset.forName(((IFile)r).getCharset());
					} catch (CoreException e) {
						throw new ATLIOException(e);
					}
				}
			}
			return Charset.defaultCharset();
		}

		/**
		 * Registers any dynamic EPackage URIs in <code>res</code>.
		 *
		 * @param res
		 *            the resource containing the EPackages
		 * @throws IOException
		 *             if the nsURIs from EPackages from r are already registered by other EPackages
		 */
		@Override
		protected void registerEPackages(final Resource res) throws IOException {
			final ResourceSet rs = getResourceSet();
			final Registry r = rs.getPackageRegistry();
			for (EObject o : res.getContents()) {
				if (o instanceof EPackage) {
					EPackage p = (EPackage)o;
					Object existing = r.get(p.getNsURI());
					if (existing instanceof EPackage.Descriptor) {
						existing = ((EPackage.Descriptor)existing).getEPackage();
					}
					if (existing != null && existing != p) {
						throw new IOException(String.format("EPackage with URI \"%s\" already registered by another EPackage instance",
							p.getNsURI()));
					}
					r.put(p.getNsURI(), p);
				}
			}
		}
	}

	static final @NonNull String PROJECT_NAME = "org.eclipse.qvtd.atl.tests";
	//	static final @NonNull URI TESTS_BASE_URI = URI.createPlatformResourceURI("/" + PROJECT_NAME + "/bin/" + PROJECT_NAME.replace(".",  "/"), true);

	private static StandaloneProjectMap projectMap = null;

	public static @NonNull StandaloneProjectMap getProjectMap() {
		StandaloneProjectMap projectMap2 = projectMap;
		if (projectMap2 == null) {
			projectMap = projectMap2 = EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(false) : new StandaloneProjectMap(false);
		}
		return projectMap2;
	}

	public final static @NonNull Map<Object, Object> defaultSavingOptions;

	// FIXME use a better default strategy for the saving options
	static {
		defaultSavingOptions = new HashMap<Object, Object>();
		defaultSavingOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		defaultSavingOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		defaultSavingOptions.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
		defaultSavingOptions.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
	}

	public static void assertSameModel(@NonNull Resource expectedResource, @NonNull Resource actualResource) throws IOException, InterruptedException {
		String expected = EmfFormatter.listToStr(expectedResource.getContents());
		String actual = EmfFormatter.listToStr(actualResource.getContents());
		TestCase.assertEquals(expected, actual);
	}

	//	protected final @NonNull URI testFolderURI;
	private BasicQVTiExecutor interpretedExecutor = null;
	private QVTiTransformationExecutor generatedExecutor = null;

	public ATLTestQVT(@NonNull String testFolderName) {
		super(new QVTiEnvironmentFactory(getProjectMap(), null));
		//		this.testFolderURI = TESTS_BASE_URI.appendSegment(testFolderName);
		getMetamodelManager().getASResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl_514599());	// FIXME wrong ResourceSet
		// Ensure ATL parser support is classpath
		AtlParser.class.getName();
		EMFModel.class.getName();
		EMFTCSInjector.class.getName();
		EmftvmFactory.class.getName();
	}

	protected void checkOutput(@NonNull Resource outputResource, @NonNull URI referenceModelURI) throws IOException, InterruptedException {
		Resource referenceResource = outputResource.getResourceSet().getResource(referenceModelURI, true);
		assert referenceResource != null;
		assertSameModel(referenceResource, outputResource);
	}

	public QVTiTransformationExecutor createGeneratedExecutor(@NonNull Class<? extends Transformer> txClass)  throws Exception {
		return generatedExecutor = new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
	}

	//	public @Nullable Resource createModel(@NonNull String modelName, @NonNull String modelFile) {
	//		URI modelURI = testFolderURI.appendSegment(modelFile);
	//		return interpretedExecutor.createModel(modelName, modelURI, null);
	//	}

	@Override
	public synchronized void dispose() {
		super.dispose();
		if (interpretedExecutor != null) {
			interpretedExecutor.dispose();
		}
	}

	public Transformer executeTransformation() throws Exception {
		if (interpretedExecutor != null) {
			interpretedExecutor.execute();
			interpretedExecutor.saveModels(defaultSavingOptions);
			return null;
		}
		else {
			Transformer transformer = generatedExecutor.getTransformer();
			//			transformer.run();						// FIXME BUG 511028
			if (!transformer.run()) {
				InvocationManager invocationManager = transformer.getInvocationManager();
				invocationManager.flush();
				//				if (!suppressFailureDiagnosis) {						// FIXME BUG 511028
				StringBuilder s = new StringBuilder();
				invocationManager.diagnoseWorkLists(s);
				throw new InvalidEvaluationException("Failed to execute" + s.toString());
				//				}
			}
			return transformer;
		}
	}

	public @NonNull Collection<@NonNull ? extends Object> getRootObjects(@NonNull String modelName) {
		if (interpretedExecutor != null) {
			return interpretedExecutor.getRootObjects(modelName);
		}
		else {
			return generatedExecutor.getTransformer().getRootObjects(modelName);
		}
	}

	public @NonNull Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = new HashMap<>(defaultSavingOptions);
		saveOptions.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
		return saveOptions;
	}

	public @Nullable Resource loadInput(@NonNull String modelName, @NonNull URI modelURI) {
		if (interpretedExecutor != null) {
			return interpretedExecutor.loadModel(modelName, modelURI);
		}
		else {
			ResourceSet resourceSet = environmentFactory.getMetamodelManager().getASResourceSet();		// FIXME get package registrations in exteranl RespurcSet
			PivotUtil.initializeLoadOptionsToSupportSelfReferences(resourceSet);
			Resource inputResource = resourceSet.getResource(modelURI, true);
			generatedExecutor.getTransformer().addRootObjects(modelName, ClassUtil.nonNullState(inputResource.getContents()));
			return inputResource;
		}
	}

	public @NonNull URI makeWriteable(@NonNull URI uri) {
		assert uri.isPlatformResource();
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			String projectName = uri.segment(1);
			/*			Bundle bundle = Platform.getBundle(projectName);
			String location = bundle.getLocation();
			if (location.startsWith("initial@")) {
				try {
					bundle.start();
				} catch (BundleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				location = bundle.getLocation();
			}
			assert location.startsWith("reference:file:") : "Unexpected prefix for " + location + " for " + projectName;
			assert location.endsWith("/") : "Unexpected suffix for " + location + " for " + projectName;
			URI locationURI = URI.createFileURI(location.substring(15, location.length()-1));
			assert locationURI != null;
			for (int i = 2; i < uri.segmentCount(); i++) {
				locationURI = locationURI.appendSegment(uri.segment(i));
			} */
			File projectFile;
			try {
				projectFile = File.createTempFile("qvtdtest", uri.lastSegment());
				projectFile.deleteOnExit();
				uri = URI.createFileURI(projectFile.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			// FIXME delete any old file
		}
		return uri;
	}

	// FIXME null referenceModelURI used as proxy rescue
	public @NonNull Resource saveOutput(@NonNull String modelName, @NonNull URI modelURI, @Nullable URI referenceModelURI) throws IOException, InterruptedException {
		ResourceSet resourceSet = /*getResourceSet()*/environmentFactory.getMetamodelManager().getASResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("qvtras", new QVTrelationASResourceFactory());
		Resource outputResource;
		URI writeableModelURI = makeWriteable(modelURI);
		if (interpretedExecutor != null) {
			interpretedExecutor.setExternalURI(modelName, modelURI);
			outputResource = interpretedExecutor.saveModel(modelName, writeableModelURI, null, getSaveOptions());
		}
		else {
			generatedExecutor.getTransformer().setExternalURI(modelName, modelURI);
			outputResource = resourceSet.createResource(writeableModelURI);
			outputResource.getContents().addAll(generatedExecutor.getTransformer().getRootEObjects(modelName));
			if (referenceModelURI == null) {
				Map<EObject, Collection<Setting>> find = EcoreUtil.UnresolvedProxyCrossReferencer.find(outputResource);
				for (EObject eObject : find.keySet()) {
					assert eObject != null;
					outputResource.getContents().add(eObject);
					Collection<Setting> settings = find.get(eObject);
					assert settings != null;
					for (Setting s : settings) {
						@SuppressWarnings("unused") EObject eObject2 = s.getEObject();
						@SuppressWarnings("unused") EStructuralFeature eStructuralFeature = s.getEStructuralFeature();
					}
					((InternalEObject)eObject).eSetProxyURI(null);
				};
			}
			//			((XMLResource)outputResource).getEObjectToIDMap().clear();
			//			((XMLResource)outputResource).getIDToEObjectMap().clear();
			outputResource.save(getSaveOptions());
		}
		assert outputResource != null;
		if (referenceModelURI != null) {
			checkOutput(outputResource, referenceModelURI);
		}
		return outputResource;
	}
}