/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     Horacio Hoyos - More tests
 *******************************************************************************/
package org.eclipse.qvtd.build.etl.tests;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.build.etl.tests.UpperToLower.UpperToLowerNormalizer;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
//import org.eclipse.qvtd.build.etl.tests.UpperToLowerHete.UpperToLowerNormalizer;
import org.eclipse.qvtd.compiler.internal.etl.MtcBroker;
import org.eclipse.qvtd.compiler.internal.etl.utils.MtcUtil;
import org.eclipse.qvtd.compiler.internal.schedule2qvti.QVTs2QVTiVisitor;
import org.eclipse.qvtd.compiler.internal.scheduler.Scheduler;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.tests.ModelNormalizer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import build.test.hls.HLSTree.HLSTreePackage;
import build.test.hsv.HSVTree.HSVTreePackage;
import build.test.middle.HSV2HLS.HSV2HLSPackage;
import junit.framework.TestCase;

public class QVTdMtcTests extends LoadTestCase {

	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("/org.eclipse.qvtd.build.etl.tests/bin/org/eclipse/qvtd/build/etl/tests", true);
	@NonNull private MyQVT myQVT;

	public static void assertSameModel(@NonNull Resource expectedResource, @NonNull Resource actualResource) throws IOException, InterruptedException {
		TestUtil.assertSameModel(expectedResource, actualResource);
	}


	protected static void assertLoadable(@NonNull URI asURI) {
		OCL ocl = OCL.newInstance();
        ResourceSet asResourceSet = ocl.getMetamodelManager().getASResourceSet();
//        ResourceSet asResourceSet = OCL.createEnvironmentFactory(null).getMetamodelManager().getASResourceSet();
        if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLstdlib.install();
//	        MetamodelManager.initializeASResourceSet(asResourceSet);
        }
        Resource resource = asResourceSet.getResource(asURI, true);
        EcoreUtil.resolveAll(resource);
        assertNoUnresolvedProxies("Loading", resource);
        assertNoResourceErrors("Loading", resource);
        ocl.dispose();
	}
	
	protected @NonNull MyQVT createQVT() {
		return new MyQVT(new MyQVTiEnvironmentFactory(getProjectMap(), null));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Before
    public void setUp() throws Exception {

		BaseLinkingService.DEBUG_RETRY.setState(true);
		super.setUp();
		OCLstdlib.install();
		QVTcoreStandaloneSetup.doSetup();
		QVTcorePivotStandaloneSetup.doSetup();
		QVTimperativePivotStandaloneSetup.doSetup();
		myQVT = createQVT();

    }

	 /* (non-Javadoc)
     * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#tearDown()
     */
    @After
    public void tearDown() throws Exception {
    	myQVT.dispose();
		super.tearDown();
    }

    /*
     * 	UmlToRdbms has a loop from NonLeafAttribute in mapping complexAttributeComplexAttributes_LM,
     *  probably breakable by classComplexAttributes_LM, but still we can't schedule it.
    */

//    @Test -- too slow and not a full test anyway
    public void zztestUmlToRdbms() throws Exception {

    	URI testBaseURI = TESTS_BASE_URI.appendSegment("UmlToRdbms");;
//    	URI samplesBaseUri = testBaseURI.appendSegment("samples");
    	MtcBroker mtc = new MtcBroker(testBaseURI, "UmlToRdbms.qvtcas", myQVT.getEnvironmentFactory(), TestsXMLUtil.defaultSavingOptions);
    	mtc.setCreateGraphml(true);
    	mtc.execute();
    	//mtc.executeQvtpQvtsToQvti();
    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
        assertNoValidationErrors("QVTi validation", mtc.getiModel().getRooteObject());
        // Run the QVTi transformation in interpreter mode
//    	URI inputURI = samplesBaseUri.appendSegment("SimpleUMLPeople.xmi");
//    	URI outputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople.xmi");
//    	URI middleURI = samplesBaseUri.appendSegment("SimpleUMLtoRDBMS_trace.xmi");
//    	URI expectedOutputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople_expected.xmi");
    	
/* Fails because scheduler uses realized variable in expressions 
    	BasicQVTiExecutor qvtiExecutor = new BasicQVTiExecutor(myQVT.getEnvironmentFactory(), mtc.getTransformation(mtc.getiModel().getResource()));
    	qvtiExecutor.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	qvtiExecutor.loadModel("uml", inputURI);
    	qvtiExecutor.createModel("middle", middleURI, null);
    	qvtiExecutor.createModel("rdbms", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        qvtiExecutor.execute();
        qvtiExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);
        
        Resource expected =  myQVT.getEnvironmentFactory().getResourceSet().getResource(expectedOutputURI, true);
        Resource actual =  myQVT.getEnvironmentFactory().getResourceSet().getResource(outputURI, true);
        assertSameModel(expected, actual);
       
        qvtiExecutor.dispose(); */
        mtc.disposeModels();
    }

//    @Test -- Fails with Epsilon errors, not worth fixing
    public void zztestUpperToLower() throws Exception {
    	QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
        ResourceSet resourceSet = environmentFactory.getResourceSet();
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("UpperToLower");;
		MtcBroker mtc = new MtcBroker(testBaseURI, "UpperToLower.qvtcas", environmentFactory, TestsXMLUtil.defaultSavingOptions);
    	mtc.setCreateGraphml(true);
    	mtc.execute();
    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
        assertNoValidationErrors("QVTi validation", mtc.getiModel().getRooteObject());

        URI samplesBaseUri = testBaseURI.appendSegment("samples");
        URI inputURI = samplesBaseUri.appendSegment("SimpleGraph.xmi");
    	URI outputURI = samplesBaseUri.appendSegment("SimpleGraphLower.xmi");
    	URI middleURI = samplesBaseUri.appendSegment("UpperToLower_trace.xmi");
    	URI expectedOutputURI = samplesBaseUri.appendSegment("SimpleGraphLower_expected.xmi");
    	Resource iResource = ClassUtil.nonNullState(mtc.getiModel().getResource());
		BasicQVTiExecutor qvtiExecutor = new BasicQVTiExecutor(environmentFactory, mtc.getTransformation(iResource));
    	qvtiExecutor.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	qvtiExecutor.loadModel("upperGraph", inputURI);
    	qvtiExecutor.createModel("middle", middleURI, null);
    	qvtiExecutor.createModel("lowerGraph", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        boolean success = qvtiExecutor.execute();
        qvtiExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);
        qvtiExecutor.dispose();
        assertTrue(success);
		Resource expected =  resourceSet.getResource(expectedOutputURI, true);
        Resource actual =  resourceSet.getResource(outputURI, true);
        System.out.println(" size = " + actual.getContents().get(0).eContents().size());
//        new UpperToLowerNormalizer().normalize(expected);
//        new UpperToLowerNormalizer().normalize(actual);
        assertSameModel(expected, actual);
        mtc.disposeModels();
    }
    
    @Test
    public void testNewHSVToHLS() throws Exception {
		AbstractTransformer.INVOCATIONS.setState(true);
    	QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
    	environmentFactory.setEvaluationTracingEnabled(true);
        ResourceSet resourceSet = environmentFactory.getResourceSet();
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("HSV2HLS");;
		MtcBroker mtc = new MtcBroker(testBaseURI, "HSV2HLS.qvtcas", environmentFactory, TestsXMLUtil.defaultSavingOptions);
    	mtc.setCreateGraphml(true);
    	Resource iResource = mtc.newExecute();
    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
//        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
        assertNoValidationErrors("QVTi validation", iResource);

        URI samplesBaseUri = testBaseURI.appendSegment("samples");
        URI inputURI = samplesBaseUri.appendSegment("SolarizedHSV.xmi");
    	URI outputURI = samplesBaseUri.appendSegment("SolarizedHLS.xmi");
    	URI middleURI = samplesBaseUri.appendSegment("HSV2HLS_trace.xmi");
    	URI expectedOutputURI = samplesBaseUri.appendSegment("SolarizedHLS_expected.xmi");
    	BasicQVTiExecutor qvtiExecutor = new QVTiIncrementalExecutor(environmentFactory, mtc.getTransformation(iResource), QVTiIncrementalExecutor.Mode.LAZY);
//		BasicQVTiExecutor qvtiExecutor = new BasicQVTiExecutor(environmentFactory, mtc.getTransformation(iResource));
    	qvtiExecutor.loadModel("hsv", inputURI);
    	qvtiExecutor.createModel("middle", middleURI, null);
    	qvtiExecutor.createModel("hls", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        qvtiExecutor.execute();
        qvtiExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);

		Resource expected =  resourceSet.getResource(expectedOutputURI, true);
        Resource actual =  resourceSet.getResource(outputURI, true);
        assertSameModel(expected, actual);

        qvtiExecutor.dispose();
        mtc.disposeModels();
    }
	
	protected static class MyQVT extends OCLInternal
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}
		
		@SuppressWarnings("unchecked")
		private Class<? extends Transformer> compileTransformation(@NonNull File explicitClassPath, @NonNull QVTiCodeGenerator cg) throws Exception {
			String qualifiedClassName = cg.getQualifiedName();
			String javaCodeSource = cg.generateClassFile();
			OCL2JavaFileObject.saveClass(explicitClassPath.toString(), qualifiedClassName, javaCodeSource);	
			Class<?> txClass = OCL2JavaFileObject.loadExplicitClass(explicitClassPath, qualifiedClassName);
			return (Class<? extends Transformer>) txClass;
		}

		public @NonNull Transformer createTransformer(@NonNull Class<? extends Transformer> txClass) throws ReflectiveOperationException {
			QVTiTransformationExecutor executor = new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
			return executor.getTransformer();
		}

		public @NonNull Resource doLoad_ConcreteWithOCL(@NonNull URI inputURI) throws IOException {
			URI cstURI = inputURI.appendFileExtension("xmi");//TestUtil.getFileURI(getClass(), cstName);
			URI pivotURI = inputURI.appendFileExtension("qvtias");//TestUtil.getFileURI(getClass(), pivotName);
			BaseCSResource xtextResource = (BaseCSResource) getResourceSet().getResource(inputURI, true);
			assert xtextResource != null;
			assertNoResourceErrors("Load failed", xtextResource);
			ASResource asResource = xtextResource.getASResource();
//			assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
			assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
			TestUtil.saveAsXMI(xtextResource, cstURI, getSaveOptions());
			asResource.setURI(pivotURI);
		    
		    TestUtil.doCompleteOCLSetup();
		    URI oclURI = ClassUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true));
//			CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metamodelManager);
			CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, getEnvironmentFactory());
//			CompleteOCLEObjectValidator completeOCLEObjectValidator3 = new CompleteOCLEObjectValidator(QVTbasePackage.eINSTANCE, oclURI, metamodelManager);
//			completeOCLEObjectValidator1.initialize();
			completeOCLEObjectValidator2.initialize();
//			completeOCLEObjectValidator3.initialize();
			PivotEObjectValidator.install(ClassUtil.nonNullState(asResource.getResourceSet()), getEnvironmentFactory());
			PivotEObjectValidator.install(ClassUtil.nonNullState(QVTbasePackage.eINSTANCE), null);
			PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), null);
			PivotEObjectValidator.install(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), null);
		    
			assertNoValidationErrors("Pivot validation errors", asResource.getContents().get(0));
			asResource.save(getSaveOptions());
			return asResource;
		}

		protected @NonNull Class<? extends Transformer> generateCode(@NonNull Transformation asTransformation) throws Exception {
			QVTiCodeGenerator cg = new QVTiCodeGenerator(getEnvironmentFactory(), asTransformation);
			QVTiCodeGenOptions options = cg.getOptions();
			options.setUseNullAnnotations(true);
			options.setPackagePrefix("cg");
			cg.generateClassFile();
			cg.saveSourceFile("../org.eclipse.qvtd.build.etl.tests/src-gen/");
			Class<? extends Transformer> txClass = compileTransformation(new File("../org.eclipse.qvtd.build.etl.tests/bin"), cg);
			if (txClass == null) {
				TestCase.fail("Failed tto compile transformation");
				throw new UnsupportedOperationException();
			}
			return txClass;
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}

		public void loadInput(@NonNull Transformer tx, @NonNull String inputModelName, URI inputModelURI) {
			Resource inputResource = getResourceSet().getResource(inputModelURI, true);
			tx.addRootObjects(inputModelName, ClassUtil.nonNullState(inputResource.getContents()));
		}

		public @NonNull Transformation loadTransformation(@NonNull URI transformURI, @NonNull URI genModelURI) throws Exception {
			OCLstdlibTables.LIBRARY.getClass();		// Ensure coherent initialization
			ResourceSet resourceSet = getResourceSet();
			resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
			MetamodelManagerInternal metamodelManager = getMetamodelManager();
			getEnvironmentFactory().configureLoadFirstStrategy();
			Resource genResource = resourceSet.getResource(genModelURI, true);
			for (EObject eObject : genResource.getContents()) {
				if (eObject instanceof GenModel) {
					GenModel genModel = (GenModel)eObject;
					genModel.reconcile();
					metamodelManager.addGenModel(genModel);
				}
			}
			Resource resource = doLoad_ConcreteWithOCL(transformURI);
			for (EObject eObject : resource.getContents()) {
				if (eObject instanceof ImperativeModel) {
					for (org.eclipse.ocl.pivot.Package asPackage : ((ImperativeModel)eObject).getOwnedPackages()) {
						for (org.eclipse.ocl.pivot.Class asClass : asPackage.getOwnedClasses()) {
							if (asClass instanceof Transformation) {
								return (Transformation)asClass;
							}
						}
					}
				}
			}
			TestCase.fail("Failed to load '" + transformURI + "', '" + genModelURI + "'");
			throw new UnsupportedOperationException();	// Never gets here
		}

		public void saveOutput(@NonNull Transformer tx, @NonNull String outputModelName, @NonNull URI outputModelURI, @Nullable URI referenceModelURI, @Nullable ModelNormalizer normalizer) throws IOException, InterruptedException {
			ResourceSet resourceSet = getResourceSet();
			Resource outputResource = resourceSet.createResource(outputModelURI);
			outputResource.getContents().addAll(tx.getRootObjects(outputModelName));
			outputResource.save(getSaveOptions());
			Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
			assert referenceResource != null;
			if (normalizer != null) {
				normalizer.normalize(referenceResource);
				normalizer.normalize(outputResource);
			}
	        assertSameModel(referenceResource, outputResource);
		}
	}
	
	protected static class MyQVTiEnvironmentFactory extends QVTiEnvironmentFactory
	{
		public MyQVTiEnvironmentFactory(@NonNull ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
			super(projectMap, externalResourceSet);
	    	setEvaluationTracingEnabled(true);
		}
	}

	public static @NonNull Map<Object, Object> getSaveOptions() {		
		return TestsXMLUtil.defaultSavingOptions;
	}

	/**
	 * Explicitly install the eInstances that would normally make it into the ProjectMap from extension point registrations.
	 * Test models are not registered via extension point so we have to do this manually.
	 */
	private void install(@NonNull URI testBaseURI, @NonNull EPackage... eInstances) {
		ResourceSetImpl resourceSet = (ResourceSetImpl) myQVT.getResourceSet();
		for (EPackage eInstance : eInstances) {
			resourceSet.getURIResourceMap().put(testBaseURI.appendSegment(eInstance.getName()+".ecore"), eInstance.eResource());
		}
	}

	/**
	 * Explicitly remove the eInstances from the EPackage.Registry.INSTANCE so that global registrations from the calling test
	 * do not confuse subsequent tests that may want to use dynamic models.
	 */
	private void uninstall(@NonNull EPackage... eInstances) {
		for (EPackage eInstance : eInstances) {
			EPackage.Registry.INSTANCE.remove(eInstance.getNsURI());
		}
	}
    
    @Test
    public void testNewHSVToHLS_CG() throws Exception {
		AbstractTransformer.INVOCATIONS.setState(true);
		Scheduler.EDGE_ORDER.setState(true);
		Scheduler.REGION_DEPTH.setState(true);
		Scheduler.REGION_ORDER.setState(true);
		Scheduler.REGION_TRAVERSAL.setState(true);
		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("HSV2HLS");;
        URI samplesBaseUri = testBaseURI.appendSegment("samples");
		install(testBaseURI, HSV2HLSPackage.eINSTANCE, HSVTreePackage.eINSTANCE, HLSTreePackage.eINSTANCE);
		try {
	    	QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
			environmentFactory.setEvaluationTracingEnabled(true);
			MtcBroker mtc = new MtcBroker(testBaseURI, "HSV2HLS.qvtcas", environmentFactory, TestsXMLUtil.defaultSavingOptions);
	    	mtc.setCreateGraphml(true);
	    	Resource iResource = mtc.newExecute();
	    	Transformation asTransformation = mtc.getTransformation(iResource);
	    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
	    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
	        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
	//	    assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
	        assertNoValidationErrors("QVTi validation", iResource);
	
			URI genModelURI = testBaseURI.appendSegment("HSV2HLS.genmodel");
			ResourceSet resourceSet = myQVT.getResourceSet();
			resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
			MetamodelManagerInternal metamodelManager = myQVT.getMetamodelManager();
			Resource genResource = resourceSet.getResource(genModelURI, true);
			for (EObject eObject : genResource.getContents()) {
				if (eObject instanceof GenModel) {
					GenModel genModel = (GenModel)eObject;
					genModel.reconcile();
					metamodelManager.addGenModel(genModel);
				}
			}
	
	        URI inputURI = samplesBaseUri.appendSegment("SolarizedHSV.xmi");
	    	URI outputURI = samplesBaseUri.appendSegment("SolarizedHLS.xmi");
	//    	URI middleURI = samplesBaseUri.appendSegment("HSV2HLS_trace.xmi");
	    	URI expectedOutputURI = samplesBaseUri.appendSegment("SolarizedHLS_expected.xmi");
			Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation);
			Transformer tx = myQVT.createTransformer(txClass);
			myQVT.loadInput(tx, "hsv", inputURI);
			tx.run();
			myQVT.saveOutput(tx, "hls", outputURI, expectedOutputURI, null);
			myQVT.dispose();
			mtc.disposeModels();
		}
		finally {
			uninstall(HSV2HLSPackage.eINSTANCE, HSVTreePackage.eINSTANCE, HLSTreePackage.eINSTANCE);	// Avoid confusing other tests
		}
	}


/*    @Test -- fails through lack of multi-headed support, which may not be needed if better partitioned
    public void testNewUmlToRdbms() throws Exception {
    	QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
        ResourceSet resourceSet = environmentFactory.getResourceSet();
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("UmlToRdbms");;
    	URI samplesBaseUri = testBaseURI.appendSegment("samples");
		MtcBroker mtc = new MtcBroker(testBaseURI, "UmlToRdbms.qvtcas", environmentFactory, TestsXMLUtil.defaultSavingOptions);
    	mtc.setCreateGraphml(true);
    	mtc.newExecute();
    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
//        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
        assertNoValidationErrors("QVTi validation", mtc.getiResource());

    	URI inputURI = samplesBaseUri.appendSegment("SimpleUMLPeople.xmi");
    	URI outputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople.xmi");
    	URI middleURI = samplesBaseUri.appendSegment("SimpleUMLtoRDBMS_trace.xmi");
    	URI expectedOutputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople_expected.xmi");
    	BasicQVTiExecutor qvtiExecutor = new BasicQVTiExecutor(environmentFactory, mtc.getTransformation(mtc.getiResource()));
    	qvtiExecutor.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	qvtiExecutor.loadModel("uml", inputURI);
    	qvtiExecutor.createModel("middle", middleURI, null);
    	qvtiExecutor.createModel("rdbms", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        qvtiExecutor.execute();
        
		Resource expected =  resourceSet.getResource(expectedOutputURI, true);
        Resource actual =  resourceSet.getResource(outputURI, true);
        assertSameModel(expected, actual);
       
        mtc.disposeModels();
    } */

    @Test
    public void testNewUpperToLower() throws Exception {
    	QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
    	QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
//    	environmentFactory.configureLoadFirstStrategy();
        ResourceSet resourceSet = environmentFactory.getResourceSet();
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("UpperToLower");;
		MtcBroker mtc = new MtcBroker(testBaseURI, "UpperToLower.qvtcas", environmentFactory, TestsXMLUtil.defaultSavingOptions);
    	mtc.setCreateGraphml(true);
    	mtc.newExecute();
    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
//        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
        assertNoValidationErrors("QVTi validation", mtc.getiResource());

        URI samplesBaseUri = testBaseURI.appendSegment("samples");
        URI inputURI = samplesBaseUri.appendSegment("SimpleGraph.xmi");
    	URI outputURI = samplesBaseUri.appendSegment("SimpleGraphLower.xmi");
    	URI middleURI = samplesBaseUri.appendSegment("UpperToLower_trace.xmi");
    	URI expectedOutputURI = samplesBaseUri.appendSegment("SimpleGraphLower_expected.xmi");
//		BasicQVTiExecutor qvtiExecutor = new BasicQVTiExecutor(environmentFactory, mtc.getTransformation(mtc.getiResource()));
    	BasicQVTiExecutor qvtiExecutor = new QVTiIncrementalExecutor(environmentFactory, mtc.getTransformation(mtc.getiResource()), QVTiIncrementalExecutor.Mode.LAZY);
    	qvtiExecutor.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	qvtiExecutor.loadModel("upperGraph", inputURI);
    	qvtiExecutor.createModel("middle", middleURI, null);
    	qvtiExecutor.createModel("lowerGraph", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        qvtiExecutor.execute();
        qvtiExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);

		Resource expected = resourceSet.getResource(expectedOutputURI, true);
		Resource actual = resourceSet.getResource(outputURI, true);
		new UpperToLowerNormalizer().normalize(expected);
		new UpperToLowerNormalizer().normalize(actual);
		assertSameModel(expected, actual);
		qvtiExecutor.dispose();
		mtc.disposeModels();
    }

    @Test
    public void testNewUpperToLower_CG() throws Exception {
    	Scheduler.EDGE_ORDER.setState(true);
//    	Scheduler.REGION_DEPTH.setState(true);
    	Scheduler.REGION_LOCALITY.setState(true);
    	Scheduler.REGION_ORDER.setState(true);
    	Scheduler.REGION_STACK.setState(true);
    	Scheduler.REGION_TRAVERSAL.setState(true);
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("UpperToLower");;
		MtcBroker mtc = null;
		Transformation asTransformation = null;
	   	{
	    	QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
			mtc = new MtcBroker(testBaseURI, "UpperToLower.qvtcas", environmentFactory, TestsXMLUtil.defaultSavingOptions);
	    	mtc.setCreateGraphml(true);
	    	Resource iResource = mtc.newExecute();
			asTransformation = mtc.getTransformation(iResource);
	    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
	    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
	        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
//	        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
	        assertNoValidationErrors("QVTi validation", iResource);
	   	}

        URI samplesBaseUri = testBaseURI.appendSegment("samples");
        URI inputURI = samplesBaseUri.appendSegment("SimpleGraph.xmi");
    	URI outputURI = samplesBaseUri.appendSegment("SimpleGraphLower.xmi");
//    	URI middleURI = samplesBaseUri.appendSegment("UpperToLower_trace.xmi");
		URI genModelURI = testBaseURI.appendSegment("SimpleGraph2Graph.genmodel");
		URI expectedOutputURI = samplesBaseUri.appendSegment("SimpleGraphLower_expected.xmi");
    	
    	{
	    	MyQVT myQVT = createQVT();
			ResourceSet resourceSet = myQVT.getResourceSet();
			resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
			MetamodelManagerInternal metamodelManager = myQVT.getMetamodelManager();
			myQVT.getEnvironmentFactory().configureLoadFirstStrategy();
			Resource genResource = resourceSet.getResource(genModelURI, true);
			for (EObject eObject : genResource.getContents()) {
				if (eObject instanceof GenModel) {
					GenModel genModel = (GenModel)eObject;
					genModel.reconcile();
					metamodelManager.addGenModel(genModel);
				}
			}
	
			myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
			Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation);
			Transformer tx = myQVT.createTransformer(txClass);
			myQVT.loadInput(tx, "upperGraph", inputURI);
			tx.run();
			myQVT.saveOutput(tx, "lowerGraph", outputURI, expectedOutputURI, UpperToLowerNormalizer.INSTANCE);
	        myQVT.dispose();
    	}
        mtc.disposeModels();
    }
    
    @Test
    public void testNewFamilies2Persons() throws Exception {
		AbstractTransformer.INVOCATIONS.setState(true);
    	QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
//    	environmentFactory.setEvaluationTracingEnabled(true);
        ResourceSet resourceSet = environmentFactory.getResourceSet();
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("Families2Persons");;
		MtcBroker mtc = new MtcBroker(testBaseURI, "Families2Persons.qvtcas", environmentFactory, TestsXMLUtil.defaultSavingOptions);
    	mtc.setCreateGraphml(true);
    	Resource iResource = mtc.newExecute();
    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
//        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
        assertNoValidationErrors("QVTi validation", iResource);

        URI SAMPLES_BASE_URI = URI.createPlatformResourceURI("/org.eclipse.qvtd.build.etl.tests/src/org/eclipse/qvtd/build/etl/tests", true);
        URI samplesURI = SAMPLES_BASE_URI.appendSegment("Families2Persons");
        URI samplesBaseUri = samplesURI.appendSegment("samples");
        URI inputURI = samplesBaseUri.appendSegment("FamiliesBig.xmi");
        URI expectedOutputURI = samplesBaseUri.appendSegment("Persons_expected.xmi");
        String genSamples = MtcUtil.changeTargetToBinFolder(samplesBaseUri.toPlatformString(true));
        URI genSamplesUri = URI.createPlatformResourceURI(genSamples, true);
        URI outputURI = genSamplesUri.appendSegment("Persons.xmi");
        URI middleURI = genSamplesUri.appendSegment("Families2Persons_trace.xmi");
//		BasicQVTiExecutor qvtiExecutor = new BasicQVTiExecutor(environmentFactory, mtc.getTransformation(mtc.getiResource()));
    	BasicQVTiExecutor qvtiExecutor = new QVTiIncrementalExecutor(environmentFactory, mtc.getTransformation(mtc.getiResource()), QVTiIncrementalExecutor.Mode.LAZY);
    	qvtiExecutor.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	qvtiExecutor.loadModel("family", inputURI);
    	qvtiExecutor.createModel("middle", middleURI, null);
    	qvtiExecutor.createModel("person", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        qvtiExecutor.execute();
        qvtiExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);

		Resource expected = resourceSet.getResource(expectedOutputURI, true);
		Resource actual = resourceSet.getResource(outputURI, true);
		new UpperToLowerNormalizer().normalize(expected);
		new UpperToLowerNormalizer().normalize(actual);
		assertSameModel(expected, actual);
		qvtiExecutor.dispose();
		mtc.disposeModels();
    }

}
