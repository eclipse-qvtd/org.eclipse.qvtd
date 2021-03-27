/*******************************************************************************
 * Copyright (c) 2012, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.pivot.tests.PivotTestCaseWithAutoTearDown.AbstractTestThread;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.QVTiCompilerChain;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.xtext.util.EmfFormatter;
import org.junit.Before;
import org.junit.Test;

public class QVTiInterpreterTests extends LoadTestCase
{
	protected class MyQVT extends AbstractTestQVT
	{
		private @NonNull ModeFactory modeFactory;

		public MyQVT(@NonNull ProjectManager projectManager, @NonNull TestProject testProject, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI, @NonNull ModeFactory modeFactory) throws IOException {
			super(projectManager, testProject, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
			this.modeFactory = modeFactory;
		}

		public @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
			QVTimperativeEnvironmentThreadFactory environmentThreadFactory = createQVTimperativeEnvironmentThreadFactory();
			return checkOutput(environmentThreadFactory, actualURI, expectedURI, normalizer);
		}

		@Override
		protected @NonNull AbstractCompilerChain createCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
			return new QVTiCompilerChain(projectManager, txURI, intermediateFileNamePrefixURI/*getTestURIWithExtension(txURI, null)*/, createCompilerOptions());
		}

		@Override
		protected @NonNull BasicQVTiExecutor createInterpretedExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation transformation) throws Exception {
			return new BasicQVTiExecutor(environmentFactory, transformation, modeFactory);
		}

		@Override
		protected @NonNull String getBasePrefix() {
			return "org.eclipse.qvtd.xtext.qvtimperative.tests";
		}

		@Override
		protected @NonNull ProjectManager getTestProjectManager(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) {
			return QVTiInterpreterTests.this.getTestProjectManager(pathFromCurrentWorkingDirectoryToFileSystem);
		}

		public @NonNull ImperativeTransformation loadTransformation() throws IOException {
			QVTiEnvironmentFactory environmentFactory = getEnvironmentFactory();
			return QVTimperativeUtil.loadTransformation(environmentFactory, txURI, environmentFactory.keepDebug());
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

		public void writeExecutionGraphMLfile(@NonNull URI graphmlURI) {
			URIConverter uriConverter = getEnvironmentFactory().getResourceSet().getURIConverter();
			try {
				OutputStream outputStream = uriConverter.createOutputStream(graphmlURI);
				GraphMLStringBuilder s = new GraphMLStringBuilder();
				((BasicQVTiExecutor)getExecutor()).createGraph(s);
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

	protected <EF extends EnvironmentFactoryInternal> void assertLoadable(@NonNull QVTbase qvt, @NonNull URI asURI) throws Exception {
		//	qvt.deactivate();
		assertLoadable(getTestProject(), asURI);
		//	qvt.activate();
	}

	protected void assertLoadable(@NonNull TestProject testProject, @NonNull URI asURI) throws Exception {
		QVTimperativeEnvironmentThreadFactory environmentThreadFactory = createQVTimperativeEnvironmentThreadFactory();
		AbstractTestThread<Object, @NonNull QVTiEnvironmentFactory, @Nullable OCLInternal> checkThread = new AbstractTestThread<Object, @NonNull QVTiEnvironmentFactory, @Nullable OCLInternal>("Loadable-Check", environmentThreadFactory)
		{
			@Override
			public Object runWithThrowable() throws Exception {
				PivotMetamodelManager metamodelManager = getEnvironmentFactory().getMetamodelManager();
				ResourceSet asResourceSet = metamodelManager.getASResourceSet();
				if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
					OCLstdlib.install();
					metamodelManager.getASmetamodel();
				}
				Resource resource = asResourceSet.getResource(asURI, true);
				assert resource != null;
				EcoreUtil.resolveAll(resource);
				assertNoUnresolvedProxies("Loading", resource);
				assertNoResourceErrors("Loading", resource);
				//	ocl.dispose();
				return null;
			}
		};
		checkThread.syncExec();
	}

	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTimperative.newInstance(getTestProjectManager(), null);
	}

	private @NonNull MyQVT createQVT(@NonNull String modelTestName, @NonNull URI txURI, @NonNull ModeFactory modeFactory) throws Exception {
		ProjectManager testProjectManager = getTestProjectManager();
		URI intermediateFileNamePrefixURI = getTestURI(modelTestName);
		URI srcFileURI = getTestFileURI(JavaFileUtil.TEST_SRC_FOLDER_NAME + "/");
		URI binFileURI = getTestFileURI(JavaFileUtil.TEST_BIN_FOLDER_NAME + "/");
		return new MyQVT(testProjectManager, getTestProject(), getTestBundleURI(), txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI, modeFactory);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
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
		URI txASURI = getTestURIWithExtension(txURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		URI inputURI = getModelsURI("Graph2GraphMinimal/SimpleGraph.xmi");
		URI outputURI = getTestURI("Graph2GraphMinimal.xmi");
		URI traceURI = getTestURI("Graph2Graph.xmi");
		MyQVT myQVT = createQVT("Graph2GraphMinimal", txURI, ModeFactory.LAZY);
		ImperativeTransformation iTransformation = myQVT.loadTransformation();
		BasicQVTiExecutor testEvaluator = myQVT.createInterpretedExecutor(iTransformation);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(myQVT, txASURI);
		//
		myQVT.addInputURI("upperGraph", inputURI);
		assertTrue(myQVT.executeTransformation());
		myQVT.addOutputURI("lowerGraph", outputURI);
		myQVT.addOutputURI("middle", traceURI);
		myQVT.saveModels(null);
		myQVT.saveExecutionGraph(getTestURI("Graph2GraphMinimal_LAZY.graphml"));
		myQVT.checkOutput(outputURI, getModelsURI("Graph2GraphMinimal/Graph2GraphMinimalValidate.xmi"), null);
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
		URI txASURI = getTestURIWithExtension(txURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		URI inputURI = getModelsURI("Graph2GraphMinimal/SimpleGraph.xmi");
		URI outputURI = getTestURI("Graph2GraphHierarchical.xmi");
		URI traceURI = getTestURI("Graph2Graph.xmi");
		MyQVT myQVT = createQVT("Graph2GraphHierarchical", txURI, ModeFactory.LAZY);
		ImperativeTransformation iTransformation = myQVT.loadTransformation();
		BasicQVTiExecutor testEvaluator = myQVT.createInterpretedExecutor(iTransformation);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(myQVT, txASURI);
		//
		myQVT.addInputURI("upperGraph", inputURI);
		assertTrue(myQVT.executeTransformation());
		myQVT.addOutputURI("lowerGraph", outputURI);
		myQVT.addOutputURI("middle", traceURI);
		myQVT.saveModels(null);
		myQVT.saveExecutionGraph(getTestURI("Graph2GraphMinimal_LAZY.graphml"));
		myQVT.checkOutput(outputURI, getModelsURI("Graph2GraphHierarchical/Graph2GraphHierarchicalValidate.xmi"), null);
		myQVT.dispose();
	}

	@Test
	public void testQVTiInterpreter_Graph2GraphHierarchicalLoad() throws Exception {
		URI asURI = getModelsURI("Graph2GraphHierarchical" + "/"  + "Graph2GraphHierarchical.ref.qvtias");
		assertLoadable(getTestProject(), asURI);
	}

	/**
	 * Test hsv 2 hsl.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testQVTiInterpreter_HSV2HSL() throws Exception {
		URI txURI = getModelsURI("HSV2HSL/HSV2HSL.qvti");
		URI txASURI = getTestURIWithExtension(txURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		URI inputURI = getModelsURI("HSV2HSL/HSVNode.xmi");
		URI outputURI = getTestURI("HSLNode.xmi");
		URI traceURI = getTestURI("HSV2HSLNode.xmi");
		MyQVT myQVT = createQVT("HSV2HSL", txURI, ModeFactory.LAZY);
		ImperativeTransformation iTransformation = myQVT.loadTransformation();
		BasicQVTiExecutor testEvaluator = myQVT.createInterpretedExecutor(iTransformation);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(myQVT, txASURI);
		//
		myQVT.addInputURI("hsv", inputURI);
		assertTrue(myQVT.executeTransformation());
		myQVT.addOutputURI("hsl", outputURI);
		myQVT.addOutputURI("middle", traceURI);
		myQVT.saveModels(null);
		myQVT.saveExecutionGraph(getTestURI("HSV2HSL_LAZY.graphml"));
		myQVT.checkOutput(outputURI, getModelsURI("HSV2HSL/HSLNodeValidate.xmi"), null);
		myQVT.dispose();
	}

	/**
	 * Test tree2talltree using the INCREMENTAL evaluator.
	 */
	@Test
	public void testQVTiInterpreter_Tree2TallTreeIncremental() throws Exception {
		URI txURI = getModelsURI("Tree2TallTree/Tree2TallTree.qvti");
		URI txASURI = getTestURIWithExtension(txURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		URI inputURI = getModelsURI("Tree2TallTree/samples/Tree.xmi");
		URI outputURI = getTestURI("TallTree.xmi");
		URI traceURI = getTestURI("Tree2TallTree.xmi");
		MyQVT myQVT = createQVT("Tree2TallTree", txURI, ModeFactory.INCREMENTAL);
		ImperativeTransformation iTransformation = myQVT.loadTransformation();
		BasicQVTiExecutor testEvaluator = myQVT.createInterpretedExecutor(iTransformation);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(myQVT, txASURI);
		//
		myQVT.addInputURI("tree", inputURI);
		assertTrue(myQVT.executeTransformation());
		myQVT.addOutputURI("talltree", outputURI);
		myQVT.addOutputURI("tree2talltree", traceURI);
		myQVT.saveModels(null);
		myQVT.writeExecutionGraphMLfile(getTestURI("Tree2TallTree-execution.graphml"));
		myQVT.saveExecutionGraph(getTestURI("Tree2TallTree_INCREMENTAL.graphml"));
		myQVT.checkOutput(outputURI, getModelsURI("Tree2TallTree/samples/TallTreeValidate.xmi"), null);
		myQVT.dispose();
	}

	/**
	 * Test tree2talltree using the LAZY evaluator.
	 */
	@Test
	public void testQVTiInterpreter_Tree2TallTreeLazy() throws Exception {
		//		AbstractTransformer.INVOCATIONS.setState(true);
		URI txURI = getModelsURI("Tree2TallTree/Tree2TallTree.qvti");
		URI txASURI = getTestURIWithExtension(txURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		URI inputURI = getModelsURI("Tree2TallTree/samples/Tree.xmi");
		URI outputURI = getTestURI("TallTree.xmi");
		URI traceURI = getTestURI("Tree2TallTree.xmi");
		MyQVT myQVT = createQVT("Tree2TallTree", txURI, ModeFactory.LAZY);
		ImperativeTransformation iTransformation = myQVT.loadTransformation();
		BasicQVTiExecutor testEvaluator = myQVT.createInterpretedExecutor(iTransformation);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(myQVT, txASURI);
		//
		myQVT.addInputURI("tree", inputURI);
		assertTrue(myQVT.executeTransformation());
		myQVT.addOutputURI("talltree", outputURI);
		myQVT.addOutputURI("tree2talltree", traceURI);
		myQVT.saveModels(null);
		myQVT.saveExecutionGraph(getTestURI("Tree2TallTree_LAZY.graphml"));
		myQVT.checkOutput(outputURI, getModelsURI("Tree2TallTree/samples/TallTreeValidate.xmi"), null);
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
		URI txASURI = getTestURIWithExtension(txURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		URI inputURI = getModelsURI("ManualUML2RDBMS/ManualUMLPeople.xmi");
		URI outputURI = getTestURI("ManualRDBMSPeople.xmi");
		URI traceURI = getTestURI("ManualUML2RDBMS.xmi");
		MyQVT myQVT = createQVT("ManualUML2RDBMS", txURI, ModeFactory.LAZY);
		TestUtil.doCompleteOCLSetup();
		URI oclURI = getResourceURI("org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl");
		//  CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metamodelManager);
		@SuppressWarnings("unused")
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), oclURI);

		ImperativeTransformation iTransformation = myQVT.loadTransformation();
		BasicQVTiExecutor testEvaluator = myQVT.createInterpretedExecutor(iTransformation);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(myQVT, txASURI);
		//
		myQVT.addInputURI("uml", inputURI);
		assertTrue(myQVT.executeTransformation());
		myQVT.addOutputURI("rdbms", outputURI);
		myQVT.addOutputURI("middle", traceURI);
		myQVT.saveModels(null);
		myQVT.saveExecutionGraph(getTestURI("ManualUML2RDBMS_LAZY.graphml"));
		myQVT.checkOutput(outputURI, getModelsURI("ManualUML2RDBMS/ManualRDBMSPeopleValidate.xmi"), ManualRDBMSNormalizer.INSTANCE);
		myQVT.dispose();
		cleanup("http://www.eclipse.org/qvt/examples/0.1/ManualUML",
			"http://www.eclipse.org/qvt/examples/0.1/ManualUML2RDBMS",
				"http://www.eclipse.org/qvt/examples/0.1/ManualRDBMS");
	}

	/**
	 * Test class to rdbms.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testQVTiInterpreter_SimpleUML2RDBMS() throws Exception {
		URI txURI = getModelsURI("SimpleUML2RDBMS/SimpleUML2RDBMS.qvti");
		URI txASURI = getTestURIWithExtension(txURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		URI inputURI = getModelsURI("SimpleUML2RDBMS/SimpleUMLPeople.xmi");
		URI outputURI = getTestURI("SimpleRDBMSPeople.xmi");
		URI traceURI = getTestURI("SimpleUML2RDBMS.xmi");
		MyQVT myQVT = createQVT("SimpleUML2RDBMS", txURI, ModeFactory.LAZY);
		TestUtil.doCompleteOCLSetup();
		URI oclURI = getResourceURI("org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl");
		//  CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metaModelManager);
		@SuppressWarnings("unused")
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), oclURI);

		ImperativeTransformation iTransformation = myQVT.loadTransformation();
		BasicQVTiExecutor testEvaluator = myQVT.createInterpretedExecutor(iTransformation);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(myQVT, txASURI);
		//
		myQVT.addInputURI("uml", inputURI);
		assertTrue(myQVT.executeTransformation());
		myQVT.addOutputURI("rdbms", outputURI);
		myQVT.addOutputURI("middle", traceURI);
		myQVT.saveModels(null);
		myQVT.saveExecutionGraph(getTestURI("SimpleUML2RDBMS_LAZY.graphml"));
		myQVT.checkOutput(outputURI, getModelsURI("SimpleUML2RDBMS/SimpleRDBMSPeopleValidate.xmi"), SimpleRDBMSNormalizer.INSTANCE);
		myQVT.dispose();
		cleanup("http://www.eclipse.org/qvt/examples/0.1/SimpleUML",
			"http://www.eclipse.org/qvt/examples/0.1/SimpleUML2RDBMS",
				"http://www.eclipse.org/qvt/examples/0.1/SimpleRDBMS");
	}


	@Test
	public void testQVTiInterpreter_ClassesCS2AS_bug456900() throws Exception {
		URI txURI = getModelsURI("ClassesCS2AS/bug456900/ClassesCS2AS.qvti");
		URI txASURI = getTestURIWithExtension(txURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		URI inputURI = getModelsURI("ClassesCS2AS/bug456900/example_input.xmi");
		URI outputURI = getTestURI("example_output.xmi");
		MyQVT myQVT = createQVT("ClassesCS2AS", txURI, ModeFactory.LAZY);
		ImperativeTransformation iTransformation = myQVT.loadTransformation();
		BasicQVTiExecutor testEvaluator = myQVT.createInterpretedExecutor(iTransformation);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(myQVT, txASURI);
		//
		myQVT.addInputURI("leftCS", inputURI);
		assertTrue(myQVT.executeTransformation());
		myQVT.addOutputURI("rightAS", outputURI);
		//	myQVT.saveOutput("middle", getTestURI("middle.xmi"));
		myQVT.saveModels(null);
		myQVT.saveExecutionGraph(getTestURI("ClassesCS2AS_LAZY.graphml"));
		myQVT.checkOutput(outputURI, getModelsURI("ClassesCS2AS/bug456900/example_output_ref.xmi"), null);
		myQVT.dispose();
	}

	@Test
	public void testQVTiInterpreter_ClassesCS2AS_bug457239() throws Exception {
		TestUtil.doCompleteOCLSetup();
		URI txURI = getModelsURI("ClassesCS2AS/bug457239/ClassesCS2AS.qvti");
		URI txASURI = getTestURIWithExtension(txURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		URI inputURI = getModelsURI("ClassesCS2AS/bug457239/example_input.xmi");
		URI outputURI = getTestURI("example_output.xmi");
		MyQVT myQVT = createQVT("ClassesCS2AS", txURI, ModeFactory.LAZY);
		ImperativeTransformation iTransformation = myQVT.loadTransformation();
		BasicQVTiExecutor testEvaluator = myQVT.createInterpretedExecutor(iTransformation);
		testEvaluator.saveTransformation(txASURI, null);
		assertLoadable(myQVT, txASURI);
		//
		myQVT.addInputURI("leftCS", inputURI);
		assertTrue(myQVT.executeTransformation());
		myQVT.addOutputURI("rightAS", outputURI);
		//	myQVT.saveOutput("middle", getTestURI("middle.xmi"));
		myQVT.saveModels(null);
		myQVT.saveExecutionGraph(getTestURI("ClassesCS2AS_LAZY.graphml"));
		myQVT.checkOutput(outputURI, getModelsURI("ClassesCS2AS/bug457239/example_output_ref.xmi"), null);
		myQVT.dispose();
	}

	@Test
	public void testQVTiInterpreter_ClassesCS2AS_bug457239b() throws Exception {
		TestUtil.doCompleteOCLSetup();
		URI txURI = getModelsURI("ClassesCS2AS/bug457239/ClassesCS2ASv2_AS.qvtias");
		URI inputURI = getModelsURI("ClassesCS2AS/bug457239/example_input.xmi");
		URI outputURI = getTestURI("example_output.xmi");
		MyQVT myQVT = createQVT("ClassesCS2AS", txURI, ModeFactory.LAZY);
		ImperativeTransformation iTransformation = myQVT.loadTransformation();
		myQVT.createInterpretedExecutor(iTransformation);
		//
		myQVT.addInputURI("leftCS", inputURI);
		assertTrue(myQVT.executeTransformation());
		myQVT.addOutputURI("rightAS", outputURI);
		myQVT.saveModels(null);
		myQVT.checkOutput(outputURI, getModelsURI("ClassesCS2AS/bug457239/exampleV2_output_ref.xmi"), null);
		myQVT.dispose();
	}
}
