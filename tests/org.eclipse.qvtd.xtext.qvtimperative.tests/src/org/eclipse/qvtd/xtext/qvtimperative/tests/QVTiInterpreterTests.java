/*******************************************************************************
 * Copyright (c) 2012, 2013 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/

package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeASResourceFactory;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;
import org.eclipse.xtext.util.EmfFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test001 is a set if simple tests on the QVTi API.
 * @author Horacio Hoyos
 *
 */
public class QVTiInterpreterTests extends LoadTestCase
{
	
	/**
	 * The Class MyQvtiEvaluator provides helper methods for loading and creating models used in the test
	 */
	private final class MyQvtiEvaluator extends QVTiXtextEvaluator
	{
		
		/** The typed model validation resource map. */
		protected final @NonNull Map<TypedModel, Resource> typedModelValidationResourceMap = new HashMap<TypedModel, Resource>();
		
		/** The file name prefix. */
		private final @NonNull String fileNamePrefix;

		/**
		 * Instantiates a new my Qvti evaluator.
		 *
		 * @param metaModelManager the meta model manager
		 * @param fileNamePrefix the file name prefix
		 * @param transformationFileName the transformation file name
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public MyQvtiEvaluator(@NonNull MetaModelManager metaModelManager, @NonNull String fileNamePrefix, @NonNull String transformationFileName) throws IOException {
			super(metaModelManager, getProjectFileURI(fileNamePrefix + "/"  + transformationFileName));
			this.fileNamePrefix = fileNamePrefix + "/";
	    	setEvaluationTracingEnabled(true);
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
			createModel(typedModelName, getProjectFileURI(fileNamePrefix + modelFileName), null);
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
			loadModel(name, getProjectFileURI(fileNamePrefix + modelFileName));
		}

		/**
		 * Loads a reference model, identified by modelFileName, as a resource. The reference
		 * model is used to validate if the generated model is correct, i.e. the output
		 * and reference model must be equal.
		 *
		 * @param name the name
		 * @param modelFileName the model file name
		 */
		public void loadReference(@NonNull String name, @NonNull String modelFileName) {
	        TypedModel typedModel = DomainUtil.getNamedElement(transformation.getModelParameter(), name);
	        if (typedModel == null) {
	        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
	        }
			URI modelURI = getProjectFileURI(fileNamePrefix + modelFileName);
	        Resource resource = metaModelManager.getExternalResourceSet().getResource(modelURI, true);
	        typedModelValidationResourceMap.put(typedModel, resource);
		}

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
	        	TypedModel typedModel = DomainUtil.nonNullState(entry.getKey());
	        	Resource expectedModel = entry.getValue();
	        	Resource actualModel = modelManager.getModel(typedModel);
	            assertSameModel(expectedModel, actualModel);
	        }
	    }
	}
	
//	public static interface Normalizer {
//		void denormalize();
//	}
	
	/**
 * Assert same model.
 *
 * @param expectedResource the expected resource
 * @param actualResource the actual resource
 * @throws IOException Signals that an I/O exception has occurred.
 * @throws InterruptedException the interrupted exception
 */
public static void assertSameModel(Resource expectedResource, Resource actualResource) throws IOException, InterruptedException {
//		Set<Normalizer> normalizations = normalize(expectedResource);
		String expected = EmfFormatter.listToStr(expectedResource.getContents());
		String actual = EmfFormatter.listToStr(actualResource.getContents());
		assertEquals(expected, actual);
//		for (Normalizer normalizer : normalizations) {
//			normalizer.denormalize();
//		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Before
    public void setUp() throws Exception {
	    
		EssentialOCLLinkingService.DEBUG_RETRY = true;
		super.setUp();
		QVTimperativeStandaloneSetup.doSetup();
		metaModelManager = new MetaModelManager();
        MetaModelManagerResourceSetAdapter.getAdapter(DomainUtil.nonNullState(resourceSet), metaModelManager);
    }
 
    /* (non-Javadoc)
     * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#tearDown()
     */
    @After
    public void tearDown() throws Exception {
		super.tearDown();
    }
    
    /*
     * Minimal 1 object to 1 object QVTi transformation
     */
    /**
     * Test graph 2 graph minimal.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGraph2GraphMinimal() throws Exception {
    	MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(DomainUtil.nonNullState(metaModelManager), "Graph2GraphMinimal", "Graph2GraphMinimal.qvti");
    	testEvaluator.saveTransformation(null);
        testEvaluator.loadModel("upperGraph", "SimpleGraph.xmi");
        testEvaluator.createModel("lowerGraph", "Graph2GraphMinimal.xmi");
        testEvaluator.loadReference("lowerGraph", "Graph2GraphMinimalValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
    }

    /*
     * Hierarchical N object to N object QVTi transformation working.
     */
    /**
     * Test graph 2 graph hierarchical.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGraph2GraphHierarchical() throws Exception {
    	MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(DomainUtil.nonNullState(metaModelManager), "Graph2GraphHierarchical", "Graph2GraphHierarchical.qvti");
    	testEvaluator.saveTransformation(null);
    	testEvaluator.loadModel("upperGraph", "../Graph2GraphMinimal/SimpleGraph.xmi");
        testEvaluator.createModel("lowerGraph", "Graph2GraphHierarchical.xmi");
        testEvaluator.loadReference("lowerGraph", "Graph2GraphHierarchicalValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = testEvaluator.getTransformation().eResource().getURI();
        ResourceSet resourceSet = new ResourceSetImpl();
        MetaModelManager.initializeASResourceSet(resourceSet);
//        ASResourceFactoryRegistry.INSTANCE.configureResourceSet(resourceSet);
//        QVTimperativePivotStandaloneSetup.initializeResourceFactory(resourceSet.getResourceFactoryRegistry());
        Resource txResource = resourceSet.getResource(txURI, true);
        assert ((ASResource)txResource).getASResourceFactory() instanceof QVTimperativeASResourceFactory;
        EcoreUtil.resolveAll(txResource);
    }
    @Test
    public void testGraph2GraphHierarchicalLoad() throws Exception {
    	OCLstdlib.install();
    	URI txURI = getProjectFileURI("Graph2GraphHierarchical" + "/"  + "Graph2GraphHierarchical.qvti");
    	URI asURI = URI.createURI(txURI.toString() + "as");
//    	MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(DomainUtil.nonNullState(metaModelManager), "Graph2GraphHierarchical", "Graph2GraphHierarchical.qvti");
//    	testEvaluator.saveTransformation(null);
//    	testEvaluator.loadModel("upperGraph", "../Graph2GraphMinimal/SimpleGraph.xmi");
//        testEvaluator.createModel("lowerGraph", "Graph2GraphHierarchical.xmi");
//       testEvaluator.loadReference("lowerGraph", "Graph2GraphHierarchicalValidate.xmi");
//        testEvaluator.test();
//        testEvaluator.dispose();
        
//        URI txURI = testEvaluator.getTransformation().eResource().getURI();
        ResourceSet asResourceSet = new ResourceSetImpl();
        MetaModelManager.initializeASResourceSet(asResourceSet);
        Resource txResource = asResourceSet.getResource(asURI, true);
        assert ((ASResource)txResource).getASResourceFactory() instanceof QVTimperativeASResourceFactory;
        EcoreUtil.resolveAll(txResource);
    }

    /**
     * Test hsv 2 hls.
     *
     * @throws Exception the exception
     */
    @Test
    public void testHSV2HLS() throws Exception {
    	MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(DomainUtil.nonNullState(metaModelManager), "HSV2HLS", "HSV2HLS.qvti");
    	testEvaluator.saveTransformation(null);
    	testEvaluator.loadModel("hsv", "HSVNode.xmi");
        testEvaluator.createModel("hls", "HLSNode.xmi");
        testEvaluator.loadReference("hls", "HLSNodeValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
    }
    
    /**
     * Test class to rdbms.
     *
     * @throws Exception the exception
     */
    @Test
    public void testClassToRDBMS() throws Exception {
        CompleteOCLStandaloneSetup.doSetup();
        URI oclURI = DomainUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true));
        //  CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metaModelManager);
        CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(DomainUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, metaModelManager);
        
        MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(DomainUtil.nonNullState(metaModelManager), "ClassToRDBMS", "ClassToRDBMSSchedule.qvti");
    	testEvaluator.saveTransformation(null);
        //assertNoValidationErrors("Pivot validation errors", testEvaluator.pivotResource.getContents().get(0));
        testEvaluator.loadModel("uml", "SimpleUMLPeople.xmi");
        testEvaluator.createModel("rdbms", "SimpleRDBMSPeople.xmi");
        //testEvaluator.loadReference("rdbms", "SimpleRDBMSPeopleValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
    }
}
