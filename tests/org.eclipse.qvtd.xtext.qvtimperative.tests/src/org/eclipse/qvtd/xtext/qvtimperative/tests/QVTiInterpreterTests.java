/*******************************************************************************
 * Copyright (c) 2012, 2015 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 *     Adolfo Sanchez-Barbudo Herrera - Bug 456900, 457239 
 ******************************************************************************/

package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtimperative.tests.ManualUML2RDBMS.ManualRDBMSNormalizer;
import org.eclipse.qvtd.xtext.qvtimperative.tests.SimpleUML2RDBMS.SimpleRDBMSNormalizer;
import org.eclipse.xtext.util.EmfFormatter;
import org.junit.Before;
import org.junit.Test;

/**
 * Test001 is a set if simple tests on the QVTi API.
 * @author Horacio Hoyos
 *
 */
public class QVTiInterpreterTests extends LoadTestCase
{
	protected class MyQVT extends QVTimperative
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}

		public @NonNull MyQvtiExecutor createEvaluator(@NonNull String fileNamePrefix, @NonNull String transformationFileName) throws IOException {
			return new MyQvtiExecutor(getEnvironmentFactory(), fileNamePrefix, transformationFileName);
		}

		public @NonNull MyQvtiExecutor createEvaluator(@NonNull String fileNamePrefix, @NonNull String transformationFileName, QVTiIncrementalExecutor.@NonNull Mode mode) throws IOException {
			return new MyQvtiExecutor(getEnvironmentFactory(), fileNamePrefix, transformationFileName, mode);
		}

		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}
	}
	
	/**
	 * The Class MyQvtiEvaluator provides helper methods for loading and creating models used in the test
	 */
	private class MyQvtiExecutor extends QVTiIncrementalExecutor
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
		public MyQvtiExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull String fileNamePrefix, @NonNull String transformationFileName) throws IOException {
			this(environmentFactory, fileNamePrefix, transformationFileName, QVTiIncrementalExecutor.Mode.LAZY);
		}
		public MyQvtiExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull String fileNamePrefix, @NonNull String transformationFileName, @NonNull Mode mode) throws IOException {
			super(environmentFactory, getProjectFileURI(fileNamePrefix + "/"  + transformationFileName), mode);
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
	        TypedModel typedModel = NameUtil.getNameable(transformation.getModelParameter(), name);
	        if (typedModel == null) {
	        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
	        }
			URI modelURI = getProjectFileURI(fileNamePrefix + modelFileName);
	        Resource resource = environmentFactory.getResourceSet().getResource(modelURI, true);
	        typedModelValidationResourceMap.put(typedModel, resource);
		}

		/**
		 * Test.
		 *
		 * @throws Exception the exception
		 */
		public void test() throws Exception {
	    	test(null);
	    }
		public void test(@Nullable ModelNormalizer modelNormalizer) throws Exception {
	        try {
		    	boolean result = execute();
		        assertTrue(getClass().getSimpleName() + " should not return null.", result);
				Map<Object, Object> saveOptions = XMIUtil.createSaveOptions();
				saveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		        saveModels(getProjectFileURI(fileNamePrefix + "middle.xmi"), saveOptions);
		        for (Entry<TypedModel, Resource> entry : typedModelValidationResourceMap.entrySet()) { // Validate against reference models
		        	TypedModel typedModel = ClassUtil.nonNullState(entry.getKey());
		        	Resource expectedModel = entry.getValue();
		        	assert expectedModel != null;
		        	Resource actualModel = getModelManager().getModel(typedModel);
		        	assert actualModel != null;
		        	if (modelNormalizer != null) {
		        		modelNormalizer.normalize(expectedModel);
		        		modelNormalizer.normalize(actualModel);
		        	}
		            assertSameModel(expectedModel, actualModel);
		        }
	        }
	        finally {
	        	GraphMLBuilder s = new GraphMLBuilder();
//FIXME	        	getTransformationStatus().accept(new EvaluationStatus2GraphVisitor(s));
		    	File projectFile = getProjectFile();
	    		File graphFile = new File(projectFile.toString() + "/" + fileNamePrefix + transformation.getName() + "_" + mode + ".graphml");
	    		FileWriter writer = new FileWriter(graphFile);
	    		writer.append(s.toString());
	        	writer.close();
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
		OCL ocl = OCL.newInstance(OCL.NO_PROJECTS);
        ResourceSet asResourceSet = ocl.getMetamodelManager().getASResourceSet();
//        ResourceSet asResourceSet = OCL.createEnvironmentFactory(OCL.NO_PROJECTS).getMetamodelManager().getASResourceSet();
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
//		return new MyQVT(new TestQVTiEnvironmentFactory(OCL.NO_PROJECTS, null));
		return new MyQVT(new QVTiEnvironmentFactory(OCL.NO_PROJECTS, null));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Before
    public void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTiTestUtil.doQVTimperativeSetup();
		super.setUp();
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
    	MyQVT myQVT = createQVT();
    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	MyQvtiExecutor testEvaluator = myQVT.createEvaluator("Graph2GraphMinimal", "Graph2GraphMinimal.qvti");
    	testEvaluator.saveTransformation(null);
        testEvaluator.loadModel("upperGraph", "SimpleGraph.xmi");
        testEvaluator.createModel("middle", "Graph2Graph.xmi");
        testEvaluator.createModel("lowerGraph", "Graph2GraphMinimal.xmi");
        testEvaluator.loadReference("lowerGraph", "Graph2GraphMinimalValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        myQVT.dispose();
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
    	MyQVT myQVT = createQVT();
    	MyQvtiExecutor testEvaluator = myQVT.createEvaluator("Graph2GraphHierarchical", "Graph2GraphHierarchical.qvti");
    	testEvaluator.saveTransformation(null);
    	testEvaluator.loadModel("upperGraph", "../Graph2GraphMinimal/SimpleGraph.xmi");
        testEvaluator.createModel("middle", "Graph2Graph.xmi");
        testEvaluator.createModel("lowerGraph", "Graph2GraphHierarchical.xmi");
        testEvaluator.loadReference("lowerGraph", "Graph2GraphHierarchicalValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        myQVT.dispose();
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
    	MyQVT myQVT = createQVT();
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	MyQvtiExecutor testEvaluator = myQVT.createEvaluator("HSV2HLS", "HSV2HLS.qvti");
    	testEvaluator.saveTransformation(null);
    	testEvaluator.loadModel("hsv", "HSVNode.xmi");
        testEvaluator.createModel("middle", "HLS2HLSNode.xmi");
        testEvaluator.createModel("hls", "HLSNode.xmi");
        testEvaluator.loadReference("hls", "HLSNodeValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        myQVT.dispose();
    }

    /**
     * Test tree2talltree using the INCREMENTAL evaluator.
     * FIXME suspended till INCREMENTAL properly implemented
    @Test
    public void testTree2TallTreeIncremental() throws Exception {
    	MyQVT myQVT = createQVT();
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	MyQvtiExecutor testEvaluator = myQVT.createEvaluator("Tree2TallTree", "Tree2TallTree.qvti", QVTiIncrementalExecutor.Mode.INCREMENTAL);
    	testEvaluator.saveTransformation(null);
    	testEvaluator.loadModel("tree", "Tree.xmi");
        testEvaluator.createModel("tree2talltree", "Tree2TallTree.xmi");
        testEvaluator.createModel("talltree", "TallTree.xmi");
        testEvaluator.loadReference("talltree", "TallTreeValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        myQVT.dispose();
    } */

    /**
     * Test tree2talltree using the LAZY evaluator.
     */
    @Test
    public void testTree2TallTreeLazy() throws Exception {
//		AbstractTransformer.INVOCATIONS.setState(true);
    	MyQVT myQVT = createQVT();
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	MyQvtiExecutor testEvaluator = myQVT.createEvaluator("Tree2TallTree", "Tree2TallTree.qvti", QVTiIncrementalExecutor.Mode.LAZY);
    	testEvaluator.saveTransformation(null);
    	testEvaluator.loadModel("tree", "Tree.xmi");
        testEvaluator.createModel("tree2talltree", "Tree2TallTree.xmi");
        testEvaluator.createModel("talltree", "TallTree.xmi");
        testEvaluator.loadReference("talltree", "TallTreeValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        myQVT.dispose();
    }
    
    /**
     * Test class to rdbms.
     *
     * @throws Exception the exception
     */
    @Test
    public void testManualUML2RDBMS() throws Exception {
    	MyQVT myQVT = createQVT();
	    TestUtil.doCompleteOCLSetup();
        URI oclURI = ClassUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true));
        //  CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metamodelManager);
        @SuppressWarnings("unused")
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, myQVT.getEnvironmentFactory());
        
        MyQvtiExecutor testEvaluator = myQVT.createEvaluator("ManualUML2RDBMS", "ManualUML2RDBMS.qvti");
    	testEvaluator.saveTransformation(null);
        //assertNoValidationErrors("Pivot validation errors", testEvaluator.pivotResource.getContents().get(0));
        testEvaluator.loadModel("uml", "ManualUMLPeople.xmi");
        testEvaluator.createModel("middle", "ManualUML2RDBMS.xmi");
        testEvaluator.createModel("rdbms", "ManualRDBMSPeople.xmi");
        testEvaluator.loadReference("rdbms", "ManualRDBMSPeopleValidate.xmi");
        testEvaluator.test(ManualRDBMSNormalizer.INSTANCE);
        testEvaluator.dispose();
        URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        myQVT.dispose();
    }
    
    /**
     * Test class to rdbms.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSimpleUML2RDBMS() throws Exception {
    	MyQVT myQVT = createQVT();
	    TestUtil.doCompleteOCLSetup();
        URI oclURI = ClassUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true));
        QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
		//  CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metaModelManager);
        @SuppressWarnings("unused")
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, environmentFactory);
        
        MyQvtiExecutor testEvaluator = new MyQvtiExecutor(environmentFactory, "SimpleUML2RDBMS", "SimpleUML2RDBMS.qvti");
    	testEvaluator.saveTransformation(null);
        //assertNoValidationErrors("Pivot validation errors", testEvaluator.pivotResource.getContents().get(0));
        testEvaluator.loadModel("uml", "SimpleUMLPeople.xmi");
        testEvaluator.createModel("middle", "SimpleUML2RDBMS.xmi");
        testEvaluator.createModel("rdbms", "SimpleRDBMSPeople.xmi");
        testEvaluator.loadReference("rdbms", "SimpleRDBMSPeopleValidate.xmi");
        testEvaluator.test(SimpleRDBMSNormalizer.INSTANCE);
        testEvaluator.dispose();
        
        URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        myQVT.dispose();
    }
    
    
    @Test
    public void testClassesCS2AS_bug456900() throws Exception {
    	MyQVT myQVT = createQVT();
        QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
        MyQvtiExecutor testEvaluator = new MyQvtiExecutor(environmentFactory, "ClassesCS2AS/bug456900", "ClassesCS2AS.qvti");
    	testEvaluator.saveTransformation(null);
        testEvaluator.loadModel("leftCS", "example_input.xmi");
        testEvaluator.createModel("rightAS", "example_output.xmi");
        testEvaluator.loadReference("rightAS", "example_output_ref.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        myQVT.dispose();
    }
    
    @Test
    public void testClassesCS2AS_bug457239() throws Exception {
	    TestUtil.doCompleteOCLSetup();
    	MyQVT myQVT = createQVT();
    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
        MyQvtiExecutor testEvaluator = new MyQvtiExecutor(myQVT.getEnvironmentFactory(), "ClassesCS2AS/bug457239", "ClassesCS2AS.qvti");
    	testEvaluator.saveTransformation(null);
        
        testEvaluator.loadModel("leftCS", "example_input.xmi");
        testEvaluator.createModel("rightAS", "example_output.xmi");
        testEvaluator.loadReference("rightAS", "example_output_ref.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
    	URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        myQVT.dispose();
    }
    
    @Test
    public void testClassesCS2AS_bug457239b() throws Exception {
	    TestUtil.doCompleteOCLSetup();
    	MyQVT myQVT = createQVT();
    	URI baseURI = URI.createURI("platform:/resource/org.eclipse.qvtd.xtext.qvtimperative.tests/src/org/eclipse/qvtd/xtext/qvtimperative/tests/ClassesCS2AS/bug457239");
    	URI txURI = baseURI.appendSegment("ClassesCS2ASv2_AS.qvtias"); 
    	assertLoadable(ClassUtil.nonNullState(txURI));
     
    	QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
    	BasicQVTiExecutor testExecutor =  new BasicQVTiExecutor(environmentFactory,
    				ClassUtil.nonNullState(loadTransformation(environmentFactory.getMetamodelManager(), txURI)));
    	    	
    	URI csModelURI = baseURI.appendSegment("example_input.xmi");
    	URI asModelURI = baseURI.appendSegment("example_output.xmi");
    	URI refAsModelURI = baseURI.appendSegment("exampleV2_output_ref.xmi");
    	
    	testExecutor.loadModel("leftCS", ClassUtil.nonNullState(csModelURI));
    	testExecutor.createModel("rightAS", ClassUtil.nonNullState(asModelURI), null);
    	testExecutor.execute();
    	testExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);
    	testExecutor.dispose();
        
        ResourceSet rSet = environmentFactory.getResourceSet();
        assertSameModel(rSet.getResource(refAsModelURI, true),
        				rSet.getResource(asModelURI, true));
        myQVT.dispose();
    }
    
   static  protected Transformation loadTransformation(MetamodelManager metamodelManager, URI txURI) {
    	Resource txResource = metamodelManager.getASResourceSet().getResource(txURI, true);
    	ImperativeModel iModel = (ImperativeModel) txResource.getContents().get(0);
    	for (org.eclipse.ocl.pivot.Package p : iModel.getOwnedPackages()) {
    		for (org.eclipse.ocl.pivot.Class c : p.getOwnedClasses()) {
    			if (c instanceof Transformation){
    				return (Transformation) c;
    			}
    		}
    	}
    	return null;
    }
	
}
