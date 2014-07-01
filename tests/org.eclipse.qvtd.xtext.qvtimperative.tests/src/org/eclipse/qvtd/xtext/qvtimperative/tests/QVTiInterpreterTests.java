/*******************************************************************************
 * Copyright (c) 2012, 2014 The University of York, Willink Transformations and others.
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

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
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
	private final class MyQVTiEnvironmentFactory extends QVTiEnvironmentFactory
	{
		public MyQVTiEnvironmentFactory(@Nullable EPackage.Registry reg, @NonNull MetaModelManager metaModelManager) {
			super(reg, metaModelManager);
	    	setEvaluationTracingEnabled(true);
		}
	}
	
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
			super(new MyQVTiEnvironmentFactory(null, metaModelManager), getProjectFileURI(fileNamePrefix + "/"  + transformationFileName));
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
		
	/**
	 * Assert same model.
	 *
	 * @param expectedResource the expected resource
	 * @param actualResource the actual resource
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public static void assertSameModel(Resource expectedResource, Resource actualResource) throws IOException, InterruptedException {
		String expected = EmfFormatter.listToStr(expectedResource.getContents());
		String actual = EmfFormatter.listToStr(actualResource.getContents());
		assertEquals(expected, actual);
	}

	protected static void assertLoadable(@NonNull URI asURI) {
        ResourceSet asResourceSet = new ResourceSetImpl();
        if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLstdlib.install();
	        MetaModelManager.initializeASResourceSet(asResourceSet);
        }
        Resource resource = asResourceSet.getResource(asURI, true);
        EcoreUtil.resolveAll(resource);
        assertNoUnresolvedProxies("Loading", resource);
        assertNoResourceErrors("Loading", resource);
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
        testEvaluator.createModel("middle", "Graph2Graph.xmi");
        testEvaluator.createModel("lowerGraph", "Graph2GraphMinimal.xmi");
        testEvaluator.loadReference("lowerGraph", "Graph2GraphMinimalValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = DomainUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
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
        testEvaluator.createModel("middle", "Graph2Graph.xmi");
        testEvaluator.createModel("lowerGraph", "Graph2GraphHierarchical.xmi");
        testEvaluator.loadReference("lowerGraph", "Graph2GraphHierarchicalValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = DomainUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
    }
    
    @Test
    public void testGraph2GraphHierarchicalLoad() throws Exception {
    	URI asURI = getProjectFileURI("Graph2GraphHierarchical" + "/"  + "Graph2GraphHierarchical.ref.qvtias");
    	assertLoadable(asURI);
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
        testEvaluator.createModel("middle", "HLS2HLSNode.xmi");
        testEvaluator.createModel("hls", "HLSNode.xmi");
        testEvaluator.loadReference("hls", "HLSNodeValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = DomainUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
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
        @SuppressWarnings("unused")
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(DomainUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, metaModelManager);
        
        MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(DomainUtil.nonNullState(metaModelManager), "ClassToRDBMS", "ClassToRDBMSSchedule.qvti");
    	testEvaluator.saveTransformation(null);
        //assertNoValidationErrors("Pivot validation errors", testEvaluator.pivotResource.getContents().get(0));
        testEvaluator.loadModel("uml", "SimpleUMLPeople.xmi");
        testEvaluator.createModel("middle", "UML2RDBMS.xmi");
        testEvaluator.createModel("rdbms", "SimpleRDBMSPeople.xmi");
        //testEvaluator.loadReference("rdbms", "SimpleRDBMSPeopleValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = DomainUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
    }
}
