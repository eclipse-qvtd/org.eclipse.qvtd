package org.eclipse.qvtd.build.etl.tests;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.build.etl.MtcBroker;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiPivotEvaluator;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QVTdMtcTests extends LoadTestCase
{
	protected class MyQVT extends OCL
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}

		public @NonNull MyQvtiEvaluator createEvaluator(@NonNull String fileNamePrefix, @NonNull Transformation transformation) throws IOException {
			return new MyQvtiEvaluator(getEnvironmentFactory(), fileNamePrefix, transformation);
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}
	}
	
	protected static class MyQVTiEnvironmentFactory extends QVTiEnvironmentFactory
	{
		public MyQVTiEnvironmentFactory(@Nullable ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
			super(projectMap, externalResourceSet);
	    	setEvaluationTracingEnabled(true);
		}
	}
	
	/**
	 * The Class MyQvtiEvaluator provides helper methods for loading and creating models used in the test
	 */
	private class MyQvtiEvaluator extends QVTiPivotEvaluator
	{
		
		/** The typed model validation resource map. */
		protected final @NonNull Map<TypedModel, Resource> typedModelValidationResourceMap = new HashMap<TypedModel, Resource>();
		
		/** The file name prefix. */
		private final @NonNull String fileNamePrefix;

		/**
		 * Instantiates a new my Qvti evaluator.
		 *
		 * @param metamodelManager the meta model manager
		 * @param fileNamePrefix the file name prefix
		 * @param transformationFileName the transformation file name
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public MyQvtiEvaluator(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull String fileNamePrefix, @NonNull Transformation transformation) throws IOException {
			super(environmentFactory, transformation);
			this.fileNamePrefix = fileNamePrefix + "/";
		}
		
		/**
		 * Associates a typed model, identified by typedModelName, with a new resource with
		 * name modelFileName, in the current project.
		 *
		 * @param typedModelName the name of the typed model
		 * @param modelFileName the model file name
		 * 
		 * @see #loadModel(String, String)
		 */
		public void createModel(@NonNull String typedModelName, @NonNull String modelFileName) {
			URI modelREsource = getProjectFileURI(fileNamePrefix + modelFileName);
			if (modelREsource.segmentsList().contains("bin")) {
				modelREsource = URI.createURI(modelREsource.toString().replaceAll("/bin/", "/src/"));
			}
			createModel(typedModelName, modelREsource, null);
		}

		/**
		 * Associates a typed model, identified by typedModelName, with an existing resource
		 * with name modelFileName, in the current project.
		 *
		 * @param name the name
		 * @param modelFileName the model file name
		 * 
		 * @see #createModel(String, String)
		 */
		public void loadModel(@NonNull String name, @NonNull String modelFileName) {
			URI modelREsource = getProjectFileURI(fileNamePrefix + modelFileName);
			if (modelREsource.segmentsList().contains("bin")) {
				modelREsource = URI.createURI(modelREsource.toString().replaceAll("/bin/", "/src/"));
			}
			loadModel(name, modelREsource);
		}

		/**
		 * Loads a reference model, identified by modelFileName, as a resource. The reference
		 * model is used to validate if the generated model is correct, i.e. the output
		 * and reference model must be equal.
		 *
		 * @param name the name
		 * @param modelFileName the model file name
		 *
		public void loadReference(@NonNull String name, @NonNull String modelFileName) {
	        TypedModel typedModel = ClassUtil.getNamedElement(transformation.getModelParameter(), name);
	        if (typedModel == null) {
	        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
	        }
			URI modelURI = getProjectFileURI(fileNamePrefix + modelFileName);
	        Resource resource = metamodelManager.getExternalResourceSet().getResource(modelURI, true);
	        typedModelValidationResourceMap.put(typedModel, resource);
		}*/

		/**
		 * Test.
		 *
		 * @throws Exception the exception
		 */
		public void test() throws Exception {
	    	boolean result = execute();
	        assertTrue(getClass().getSimpleName() + " should not return null.", result);
	        saveModels(getProjectFileURI(fileNamePrefix + "middle.xmi"));
	        for (Entry<TypedModel, Resource> entry : typedModelValidationResourceMap.entrySet()) { // Validate against reference models
	        	TypedModel typedModel = ClassUtil.nonNullState(entry.getKey());
	        	Resource expectedModel = entry.getValue();
	        	Resource actualModel = modelManager.getModel(typedModel);
	            assertSameModel(expectedModel, actualModel);
	        }
	    }
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
		QVTcorePivotStandaloneSetup.doSetup();
		QVTimperativePivotStandaloneSetup.doSetup();
		OCLstdlib.install();
//		metamodelManager = new MyQVTiEnvironmentFactory(null).getMetamodelManager();
//        EnvironmentFactoryResourceSetAdapter.getAdapter(ClassUtil.nonNullState(resourceSet), metamodelManager.getEnvironmentFactory());
    }
	
	 /* (non-Javadoc)
     * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#tearDown()
     */
    @After
    public void tearDown() throws Exception {
		super.tearDown();
    }
    
    
/*    @Test
    public void testUmlToRdbms() throws Exception {
    	MyQVT myQVT = createQVT();
    	URL r = this.getClass().getResource("UmlToRdbms/UmlToRdbms.qvtcas");
		String qvtcasUri = MtcBroker.changeResourceToSource(r.toURI().toString());
    	MtcBroker mtc = new MtcBroker(qvtcasUri, this.getClass(), myQVT.getEnvironmentFactory());
    	mtc.execute();
    	Diagnostic diagnostic = Diagnostician.INSTANCE.validate(mtc.getuModel().getRooteObject());
    	// TODO do we want perfect or can we tolerate info and warnings?
        //assertEquals(Diagnostic.OK, diagnostic.getSeverity());
    	assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getmModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getpModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getsModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getiModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        
        MyQvtiEvaluator testEvaluator = myQVT.createEvaluator("UmlToRdbms",mtc.getiModel().getTransformation());
    	testEvaluator.saveTransformation(null);
        testEvaluator.loadModel("uml", "SimpleUMLPeople.xmi");
        testEvaluator.createModel("middle", "UML2RDBMS.xmi");
        testEvaluator.createModel("rdbms", "SimpleRDBMSPeople.xmi");
        //testEvaluator.loadReference("hls", "HLSNodeValidate.xmi");
        System.out.println("Executing QVTi transformation on test models.");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        mtc.disposeModels();
        myQVT.dispose();
    } */
    /*
    @Test
    public void testUpperToLower() throws Exception {
    	
    	URL r = this.getClass().getResource("UpperToLower/UpperToLower.qvtcas");
		String qvtcasUri = MtcBroker.changeResourceToSource(r.toURI().toString());
    	MtcBroker mtc = new MtcBroker(qvtcasUri, this.getClass(), metamodelManager);
    	mtc.execute();
    	Diagnostic diagnostic = Diagnostician.INSTANCE.validate(mtc.getuModel().getRooteObject());
    	assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getmModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getpModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getsModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getiModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(metamodelManager, "UpperToLower",mtc.getiModel().getTransformation());
    	testEvaluator.saveTransformation(null);
        testEvaluator.loadModel("upperGraph", "SimpleGraph.xmi");
        testEvaluator.createModel("middle", "Graph2Graph.xmi");
        testEvaluator.createModel("lowerGraph", "SimpleGraphLower.xmi");
        testEvaluator.loadReference("lowerGraph", "SimpleGraphLowerValidate.xmi");
        System.out.println("Executing QVTi transformation on test models.");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = DomainUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        mtc.disposeModels();
    }
    
    @Test
    public void testHSVToHLS() throws Exception {
    	
    	URL r = this.getClass().getResource("HSV2HLS/HSV2HLS.qvtcas");
		String qvtcasUri = MtcBroker.changeResourceToSource(r.toURI().toString());
    	MtcBroker mtc = new MtcBroker(qvtcasUri, this.getClass(), metamodelManager);
    	mtc.execute();
    	Diagnostic diagnostic = Diagnostician.INSTANCE.validate(mtc.getuModel().getRooteObject());
    	assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getmModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getpModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getsModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getiModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(metamodelManager, "HSV2HLS",mtc.getiModel().getTransformation());
    	testEvaluator.saveTransformation(null);
        testEvaluator.loadModel("hsv", "HSVNode.xmi");
        testEvaluator.createModel("middle", "HSV2HLS.xmi");
        testEvaluator.createModel("hls", "HLSNode.xmi");
        testEvaluator.loadReference("hls", "HLSNodeValidate.xmi");
        System.out.println("Executing QVTi transformation on test models.");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = DomainUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        mtc.disposeModels();
        
    }
    */
	
}
