/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 *     Adolfo Sanchez-Barbudo Herrera - Bug 456900, 457239
 ******************************************************************************/

package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.xtext.util.EmfFormatter;
import org.junit.Before;
import org.junit.Test;

public class QVTiInterpreterTests extends LoadTestCase
{
	protected static class MyQVT extends QVTimperative
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}

		public @NonNull MyQvtiExecutor createEvaluator(@NonNull URI txURI, QVTiIncrementalExecutor.@NonNull Mode mode) throws IOException {
			return new MyQvtiExecutor(getEnvironmentFactory(), txURI, mode);
		}
	}

	/**
	 * The Class MyQvtiEvaluator provides helper methods for loading and creating models used in the test
	 */
	private static class MyQvtiExecutor extends QVTiIncrementalExecutor
	{

		/** The typed model validation resource map. */
		protected final @NonNull Map<ImperativeTypedModel, Resource> typedModelValidationResourceMap = new HashMap<>();

		/**
		 * Instantiates a new my Qvti evaluator.
		 *
		 * @param metamodelManager the meta model manager
		 * @param fileNamePrefix the file name prefix
		 * @param transformationFileName the transformation file name
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public MyQvtiExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @NonNull Mode mode) throws IOException {
			super(environmentFactory, QVTimperativeUtil.loadTransformation(environmentFactory, txURI, environmentFactory.keepDebug()), mode);
		}

		public void checkModels(@Nullable ModelNormalizer modelNormalizer) throws IOException, InterruptedException {
			for (Entry<ImperativeTypedModel, Resource> entry : typedModelValidationResourceMap.entrySet()) { // Validate against reference models
				ImperativeTypedModel typedModel = ClassUtil.nonNullState(entry.getKey());
				Resource expectedModel = entry.getValue();
				assert expectedModel != null;
				Resource actualModel = getModelsManager().getModel(typedModel);
				assert actualModel != null;
				if (modelNormalizer != null) {
					modelNormalizer.normalize(expectedModel);
					modelNormalizer.normalize(actualModel);
				}
				assertSameModel(expectedModel, actualModel);
			}
		}

		/**
		 * Associates a typed model, identified by typedModelName, with a new resource with
		 * name modelFileName, in the current project.
		 *
		 * @param typedModelName the name of the typed model
		 * @param modelFileName the model file name
		 *
		 * @see #loadModel(String, String)
		 *
		public void createModel(@NonNull String typedModelName, @NonNull String modelFileName) {
			createModel(typedModelName, getModelsURI(fileNamePrefix + "/" + modelFileName), null);
		} */

		/**
		 * Associates a typed model, identified by typedModelName, with an existing resource
		 * with name modelFileName, in the current project.
		 *
		 * @param name the name
		 * @param modelFileName the model file name
		 *
		 * @see #createModel(String, String)
		 *
		public void loadModel(@NonNull String name, @NonNull String modelFileName) {
			loadModel(name, getModelsURI(fileNamePrefix + "/" + modelFileName));
		} */

		/**
		 * Loads a reference model, identified by modelFileName, as a resource. The reference
		 * model is used to validate if the generated model is correct, i.e. the output
		 * and reference model must be equal.
		 *
		 * @param name the name
		 * @param modelFileName the model file name
		 */
		//		public void loadReference(@NonNull String name, @NonNull String modelFileName) {
		//			loadReference(name, getModelsURI(fileNamePrefix + "/" + modelFileName));
		//		}
		public void loadReference(@NonNull String name, @NonNull URI modelURI) {
			ImperativeTypedModel typedModel = (ImperativeTypedModel) NameUtil.getNameable(transformation.getModelParameter(), name);
			if (typedModel == null) {
				throw new IllegalStateException("Unknown TypedModel '" + name + "'");
			}
			Resource resource = environmentFactory.getResourceSet().getResource(modelURI, true);
			typedModelValidationResourceMap.put(typedModel, resource);
		}

		public void saveExecutionGraph(@NonNull URI graphmlURI) throws Exception, IOException {
			URIConverter uriConverter = getEnvironmentFactory().getResourceSet().getURIConverter();
			GraphMLBuilder s = new GraphMLBuilder();
			//FIXME	        	getTransformationStatus().accept(new EvaluationStatus2GraphVisitor(s));
			OutputStream outputStream = uriConverter.createOutputStream(graphmlURI);
			Writer writer = new OutputStreamWriter(outputStream);
			writer.append(s.toString());
			writer.close();
		}

		/**
		 * Test.
		 *
		 * @throws Exception the exception
		 */
		public void test() throws Exception {
			boolean result = execute();
			assertTrue(getClass().getSimpleName() + " should not return null.", result);
		}

		public void writeExecutionGraphMLfile(@NonNull URI graphmlURI) {
			URIConverter uriConverter = getEnvironmentFactory().getResourceSet().getURIConverter();
			try {
				OutputStream outputStream = uriConverter.createOutputStream(graphmlURI);
				GraphMLStringBuilder s = new GraphMLStringBuilder();
				createGraph(s);
				outputStream.write(s.toString().getBytes());
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

	protected void assertLoadable(@NonNull URI asURI) throws Exception {
		assertLoadable(getTestProject(), asURI);
	}

	protected void assertLoadable(@NonNull TestProject testProject, @NonNull URI asURI) throws Exception {
		ProjectManager projectManager = getTestProjectManager();
		OCL ocl = OCL.newInstance(projectManager); //EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(false) : new StandaloneProjectMap(false));


		ResourceSet asResourceSet = ocl.getMetamodelManager().getASResourceSet();
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLstdlib.install();
			((OCLInternal)ocl).getMetamodelManager().getASmetamodel();
		}
		Resource resource = asResourceSet.getResource(asURI, true);
		assert resource != null;
		EcoreUtil.resolveAll(resource);
		assertNoUnresolvedProxies("Loading", resource);
		assertNoResourceErrors("Loading", resource);
		ocl.dispose();
	}

	protected @NonNull MyQVT createQVT() throws Exception {
		ProjectManager projectManager = getTestProjectManager();
		MyQVT myQVT = new MyQVT(new QVTiEnvironmentFactory(projectManager, null));
		return myQVT;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		XtextCompilerUtil.doQVTimperativeSetup();
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
	public void testQVTiInterpreter_Graph2GraphMinimal() throws Exception {
		URI txURI = getModelsURI("Graph2GraphMinimal/Graph2GraphMinimal.qvti");
		URI txASURI = getTestURIWithExtension(txURI, "qvtias");
		MyQVT myQVT = createQVT();
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		MyQvtiExecutor testEvaluator = myQVT.createEvaluator(txURI, QVTiIncrementalExecutor.Mode.LAZY);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(txASURI);
		//
		testEvaluator.loadModel("upperGraph", getModelsURI("Graph2GraphMinimal/SimpleGraph.xmi"));
		testEvaluator.createModel("middle", getTestURI("Graph2Graph.xmi"));
		testEvaluator.createModel("lowerGraph", getTestURI("Graph2GraphMinimal.xmi"));
		testEvaluator.loadReference("lowerGraph", getModelsURI("Graph2GraphMinimal/Graph2GraphMinimalValidate.xmi"));
		testEvaluator.test();
		testEvaluator.saveModels(getTestURI("middle.xmi"));
		testEvaluator.checkModels(null);
		testEvaluator.saveExecutionGraph(getTestURI("Graph2GraphMinimal_LAZY.graphml"));
		testEvaluator.dispose();
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
	public void testQVTiInterpreter_Graph2GraphHierarchical() throws Exception {
		URI txURI = getModelsURI("Graph2GraphHierarchical/Graph2GraphHierarchical.qvti");
		URI txASURI = getTestURIWithExtension(txURI, "qvtias");
		MyQVT myQVT = createQVT();
		MyQvtiExecutor testEvaluator = myQVT.createEvaluator(txURI, QVTiIncrementalExecutor.Mode.LAZY);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(txASURI);
		//
		testEvaluator.loadModel("upperGraph", getModelsURI("Graph2GraphMinimal/SimpleGraph.xmi"));
		testEvaluator.createModel("middle", getTestURI("Graph2Graph.xmi"));
		testEvaluator.createModel("lowerGraph", getTestURI("Graph2GraphHierarchical.xmi"));
		testEvaluator.loadReference("lowerGraph", getModelsURI("Graph2GraphHierarchical/Graph2GraphHierarchicalValidate.xmi"));
		testEvaluator.test();
		testEvaluator.saveModels(getTestURI("middle.xmi"));
		testEvaluator.checkModels(null);
		testEvaluator.saveExecutionGraph(getTestURI("Graph2GraphMinimal_LAZY.graphml"));
		testEvaluator.dispose();
		myQVT.dispose();
	}

	@Test
	public void testQVTiInterpreter_Graph2GraphHierarchicalLoad() throws Exception {
		URI asURI = getModelsURI("Graph2GraphHierarchical" + "/"  + "Graph2GraphHierarchical.ref.qvtias");
		assertLoadable(asURI);
	}

	/**
	 * Test hsv 2 hsl.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testQVTiInterpreter_HSV2HSL() throws Exception {
		MyQVT myQVT = createQVT();
		URI txURI = getModelsURI("HSV2HSL/HSV2HSL.qvti");
		URI txASURI = getTestURIWithExtension(txURI, "qvtias");
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		MyQvtiExecutor testEvaluator = myQVT.createEvaluator(txURI, QVTiIncrementalExecutor.Mode.LAZY);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(txASURI);
		//
		testEvaluator.loadModel("hsv", getModelsURI("HSV2HSL/HSVNode.xmi"));
		testEvaluator.createModel("middle", getTestURI("HSL2HSLNode.xmi"));
		testEvaluator.createModel("hsl", getTestURI("HSLNode.xmi"));
		testEvaluator.loadReference("hsl", getModelsURI("HSV2HSL/HSLNodeValidate.xmi"));
		testEvaluator.test();
		testEvaluator.saveModels(getTestURI("middle.xmi"));
		testEvaluator.checkModels(null);
		testEvaluator.saveExecutionGraph(getTestURI("HSV2HSL_LAZY.graphml"));
		testEvaluator.dispose();
		myQVT.dispose();
	}

	/**
	 * Test tree2talltree using the INCREMENTAL evaluator.
	 */
	@Test
	public void testQVTiInterpreter_Tree2TallTreeIncremental() throws Exception {
		URI txURI = getModelsURI("Tree2TallTree/Tree2TallTree.qvti");
		URI txASURI = getTestURIWithExtension(txURI, "qvtias");
		MyQVT myQVT = createQVT();
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		MyQvtiExecutor testEvaluator = myQVT.createEvaluator(txURI, QVTiIncrementalExecutor.Mode.INCREMENTAL);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(txASURI);
		//
		testEvaluator.loadModel("tree", getModelsURI("Tree2TallTree/samples/Tree.xmi"));
		testEvaluator.createModel("tree2talltree", getTestURI("Tree2TallTree.xmi"));
		testEvaluator.createModel("talltree", getTestURI("TallTree.xmi"));
		testEvaluator.loadReference("talltree", getModelsURI("Tree2TallTree/samples/TallTreeValidate.xmi"));
		testEvaluator.test();
		testEvaluator.saveModels(getTestURI("middle.xmi"));
		testEvaluator.checkModels(null);
		testEvaluator.writeExecutionGraphMLfile(getTestURI("Tree2TallTree-execution.graphml"));
		testEvaluator.saveExecutionGraph(getTestURI("Tree2TallTree_INCREMENTAL.graphml"));
		testEvaluator.dispose();
		myQVT.dispose();
	}

	/**
	 * Test tree2talltree using the LAZY evaluator.
	 */
	@Test
	public void testQVTiInterpreter_Tree2TallTreeLazy() throws Exception {
		//		AbstractTransformer.INVOCATIONS.setState(true);
		URI txURI = getModelsURI("Tree2TallTree/Tree2TallTree.qvti");
		URI txASURI = getTestURIWithExtension(txURI, "qvtias");
		MyQVT myQVT = createQVT();
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		MyQvtiExecutor testEvaluator = myQVT.createEvaluator(txURI, QVTiIncrementalExecutor.Mode.LAZY);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(txASURI);
		//
		testEvaluator.loadModel("tree", getModelsURI("Tree2TallTree/samples/Tree.xmi"));
		testEvaluator.createModel("tree2talltree", getTestURI("Tree2TallTree.xmi"));
		testEvaluator.createModel("talltree", getTestURI("TallTree.xmi"));
		testEvaluator.loadReference("talltree", getModelsURI("Tree2TallTree/samples/TallTreeValidate.xmi"));
		testEvaluator.test();
		testEvaluator.saveModels(getTestURI("middle.xmi"));
		testEvaluator.checkModels(null);
		testEvaluator.saveExecutionGraph(getTestURI("Tree2TallTree_LAZY.graphml"));
		testEvaluator.dispose();
		myQVT.dispose();
	}

	/**
	 * Test class to rdbms.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testQVTiInterpreter_ManualUML2RDBMS() throws Exception {
		URI txURI = getModelsURI("ManualUML2RDBMS/ManualUML2RDBMS.qvti");
		URI txASURI = getTestURIWithExtension(txURI, "qvtias");
		MyQVT myQVT = createQVT();
		TestUtil.doCompleteOCLSetup();
		URI oclURI = getResourceURI("org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl");
		//  CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metamodelManager);
		@SuppressWarnings("unused")
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), oclURI, myQVT.getEnvironmentFactory());

		MyQvtiExecutor testEvaluator = myQVT.createEvaluator(txURI, QVTiIncrementalExecutor.Mode.LAZY);
		testEvaluator.saveTransformation(txASURI, null);
		//assertNoValidationErrors("Pivot validation errors", testEvaluator.pivotResource.getContents().get(0));
		assertLoadable(txASURI);
		//
		testEvaluator.loadModel("uml", getModelsURI("ManualUML2RDBMS/ManualUMLPeople.xmi"));
		testEvaluator.createModel("middle", getTestURI("ManualUML2RDBMS.xmi"));
		testEvaluator.createModel("rdbms", getTestURI("ManualRDBMSPeople.xmi"));
		testEvaluator.loadReference("rdbms", getModelsURI("ManualUML2RDBMS/ManualRDBMSPeopleValidate.xmi"));
		testEvaluator.test();
		testEvaluator.saveModels(getTestURI("middle.xmi"));
		testEvaluator.checkModels(ManualRDBMSNormalizer.INSTANCE);
		testEvaluator.saveExecutionGraph(getTestURI("ManualUML2RDBMS_LAZY.graphml"));
		testEvaluator.dispose();
		myQVT.dispose();
	}

	/**
	 * Test class to rdbms.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testQVTiInterpreter_SimpleUML2RDBMS() throws Exception {
		URI txURI = getModelsURI("SimpleUML2RDBMS/SimpleUML2RDBMS.qvti");
		URI txASURI = getTestURIWithExtension(txURI, "qvtias");
		MyQVT myQVT = createQVT();
		TestUtil.doCompleteOCLSetup();
		URI oclURI = getResourceURI("org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl");
		QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
		//  CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metaModelManager);
		@SuppressWarnings("unused")
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), oclURI, environmentFactory);

		MyQvtiExecutor testEvaluator = new MyQvtiExecutor(environmentFactory, txURI, QVTiIncrementalExecutor.Mode.LAZY);
		testEvaluator.saveTransformation(txASURI, null);
		//assertNoValidationErrors("Pivot validation errors", testEvaluator.pivotResource.getContents().get(0));
		assertLoadable(txASURI);
		//
		testEvaluator.loadModel("uml", getModelsURI("SimpleUML2RDBMS/SimpleUMLPeople.xmi"));
		testEvaluator.createModel("middle", getTestURI("SimpleUML2RDBMS.xmi"));
		testEvaluator.createModel("rdbms", getTestURI("SimpleRDBMSPeople.xmi"));
		testEvaluator.loadReference("rdbms", getModelsURI("SimpleUML2RDBMS/SimpleRDBMSPeopleValidate.xmi"));
		testEvaluator.test();
		testEvaluator.saveModels(getTestURI("middle.xmi"));
		testEvaluator.checkModels(SimpleRDBMSNormalizer.INSTANCE);
		testEvaluator.saveExecutionGraph(getTestURI("SimpleUML2RDBMS_LAZY.graphml"));
		testEvaluator.dispose();
		myQVT.dispose();
	}


	@Test
	public void testQVTiInterpreter_ClassesCS2AS_bug456900() throws Exception {
		URI txURI = getModelsURI("ClassesCS2AS/bug456900/ClassesCS2AS.qvti");
		URI txASURI = getTestURIWithExtension(txURI, "qvtias");
		MyQVT myQVT = createQVT();
		QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
		//		environmentFactory.setEvaluationTracingEnabled(true);
		MyQvtiExecutor testEvaluator = new MyQvtiExecutor(environmentFactory, txURI, QVTiIncrementalExecutor.Mode.LAZY);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(txASURI);
		//
		testEvaluator.loadModel("leftCS", getModelsURI("ClassesCS2AS/bug456900/example_input.xmi"));
		testEvaluator.createModel("rightAS", getTestURI("example_output.xmi"));
		testEvaluator.loadReference("rightAS", getModelsURI("ClassesCS2AS/bug456900/example_output_ref.xmi"));
		testEvaluator.test();
		testEvaluator.saveModels(getTestURI("middle.xmi"));
		testEvaluator.checkModels(null);
		testEvaluator.saveExecutionGraph(getTestURI("ClassesCS2AS_LAZY.graphml"));
		testEvaluator.dispose();
		myQVT.dispose();
	}

	@Test
	public void testQVTiInterpreter_ClassesCS2AS_bug457239() throws Exception {
		TestUtil.doCompleteOCLSetup();
		URI txURI = getModelsURI("ClassesCS2AS/bug457239/ClassesCS2AS.qvti");
		URI txASURI = getTestURIWithExtension(txURI, "qvtias");
		MyQVT myQVT = createQVT();
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		MyQvtiExecutor testEvaluator = new MyQvtiExecutor(myQVT.getEnvironmentFactory(), txURI, QVTiIncrementalExecutor.Mode.LAZY);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(txASURI);
		//
		testEvaluator.loadModel("leftCS", getModelsURI("ClassesCS2AS/bug457239/example_input.xmi"));
		testEvaluator.createModel("rightAS", getTestURI("example_output.xmi"));
		testEvaluator.loadReference("rightAS", getModelsURI("ClassesCS2AS/bug457239/example_output_ref.xmi"));
		testEvaluator.test();
		testEvaluator.saveModels(getTestURI("middle.xmi"));
		testEvaluator.checkModels(null);
		testEvaluator.saveExecutionGraph(getTestURI("ClassesCS2AS_LAZY.graphml"));
		testEvaluator.dispose();
		myQVT.dispose();
	}

	@Test
	public void testQVTiInterpreter_ClassesCS2AS_bug457239b() throws Exception {
		TestUtil.doCompleteOCLSetup();
		MyQVT myQVT = createQVT();
		URI txURI = getModelsURI("ClassesCS2AS/bug457239/ClassesCS2ASv2_AS.qvtias");
		assertLoadable(ClassUtil.nonNullState(txURI));

		QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
		QVTiIncrementalExecutor testExecutor =  new QVTiIncrementalExecutor(environmentFactory,
			(ImperativeTransformation) ClassUtil.nonNullState(loadTransformation(environmentFactory.getMetamodelManager(), txURI)),
			QVTiIncrementalExecutor.Mode.LAZY);

		URI csModelURI = getModelsURI("ClassesCS2AS/bug457239/example_input.xmi");
		URI asModelURI = getTestURI("example_output.xmi");
		URI refAsModelURI = getModelsURI("ClassesCS2AS/bug457239/exampleV2_output_ref.xmi");

		testExecutor.loadModel("leftCS", ClassUtil.nonNullState(csModelURI));
		testExecutor.createModel("rightAS", ClassUtil.nonNullState(asModelURI), null);
		testExecutor.execute();
		testExecutor.saveModels(DefaultCompilerOptions.defaultSavingOptions);
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
