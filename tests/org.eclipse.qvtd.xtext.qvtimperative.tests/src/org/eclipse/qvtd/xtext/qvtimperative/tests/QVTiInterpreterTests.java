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
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.compiler.CompilationResult;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentStrategy;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThread;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.xtext.util.EmfFormatter;
import org.junit.Before;
import org.junit.Test;

public class QVTiInterpreterTests extends LoadTestCase
{
	protected abstract class QVTiInterpretationThread extends QVTimperativeEnvironmentThread<Object>
	{
		protected final @NonNull CompilationResult compilationResult;
		protected final @NonNull ModeFactory modeFactory;
		private BasicQVTiExecutor executor;
		private boolean suppressFailureDiagnosis = false;				// FIXME BUG 511028

		protected QVTiInterpretationThread(@NonNull CompilationResult compilationResult, @NonNull ModeFactory modeFactory) {
			super("QVTi-Interpretation", createQVTimperativeEnvironmentThreadFactory());
			this.compilationResult = compilationResult;
			this.modeFactory = modeFactory;
		}

		protected @Nullable Resource addInputURI(@NonNull String modelName, @NonNull URI modelURI) {
			return executor.addInputURI(modelName, modelURI);
		}

		protected @NonNull Resource addOutputURI(@NonNull String modelName, @NonNull URI modelURI) {
			return executor.addOutputURI(modelName, modelURI);
		}

		@Override
		protected @NonNull QVTimperativeEnvironmentFactory createEnvironmentFactory() {
			QVTimperativeEnvironmentFactory environmentFactory = compilationResult.getEnvironmentFactory();
			environmentFactory.setCreateStrategy(QVTimperativeEnvironmentStrategy.INSTANCE);
			ThreadLocalExecutor.attachEnvironmentFactory(environmentFactory);
			return environmentFactory;
		}

		protected void createInterpretedExecutor() throws Exception {
			QVTimperativeEnvironmentFactory environmentFactory = getEnvironmentFactory();
			ImperativeTransformation transformation = getTransformation();
			EntryPoint entryPoint = QVTimperativeUtil.getDefaultEntryPoint(transformation);
			this.executor = new BasicQVTiExecutor(environmentFactory, entryPoint, modeFactory);
		}

		protected boolean executeTransformation() throws Exception {
			if (suppressFailureDiagnosis) {
				executor.setSuppressFailureDiagnosis(true);
			}
			Boolean success = executor.execute(null);
			return success == Boolean.TRUE;
		}

		//	public @NonNull BasicQVTiExecutor getExecutor() {
		//		assert executor != null;
		//		return executor;
		//	}

		private @NonNull ImperativeTransformation getTransformation() {
			return compilationResult.getResult();
		}

		private @NonNull URIConverter getURIConverter() {
			return getEnvironmentFactory().getResourceSet().getURIConverter();
		}

		protected void saveExecutionGraph(@NonNull URI graphmlURI) throws Exception, IOException {
			GraphMLBuilder s = new GraphMLBuilder();
			//FIXME	        	getTransformationStatus().accept(new EvaluationStatus2GraphVisitor(s));
			OutputStream outputStream = getURIConverter().createOutputStream(graphmlURI);
			Writer writer = new OutputStreamWriter(outputStream);
			writer.append(s.toString());
			writer.close();
		}

		protected void saveModels(@Nullable Map<?, ?> saveOptions) throws IOException {
			executor.getModelsManager().saveModels(saveOptions);
		}

		protected void saveTransformation(URI saveURI, Map<?,?> options) throws IOException {
			ASResource resource = (ASResource)getTransformation().eResource();
			//    	new AS2ID().assignIds(resource.getResourceSet());
			if (saveURI != null) {
				resource.setURI(saveURI);
			}
			resource.setSaveable(true);
			resource.save(options);
		}

		protected void writeExecutionGraphMLfile(@NonNull URI graphmlURI) {
			try {
				OutputStream outputStream = getURIConverter().createOutputStream(graphmlURI);
				GraphMLStringBuilder s = new GraphMLStringBuilder();
				executor.createGraph(s);
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
		QVTimperativeEnvironmentThreadFactory threadFactory = createQVTimperativeEnvironmentThreadFactory();
		QVTimperativeEnvironmentThread<Object> checkThread = new QVTimperativeEnvironmentThread<Object>("QVTiLoadCheck", threadFactory)
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
		checkThread.invoke();
	}

	protected @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
		QVTimperativeEnvironmentThreadFactory threadFactory = createQVTimperativeEnvironmentThreadFactory();
		QVTimperativeEnvironmentThread<@NonNull Resource> checkThread = new QVTimperativeEnvironmentThread<@NonNull Resource>("QVTiOutputCheck", threadFactory)
		{
			@Override
			protected OCLInternal createOCL() {
				OCL ocl = QVTbase.newInstance(getTestProjectManager());
				ocl.getEnvironmentFactory().setSeverity(PivotPackage.Literals.VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP, StatusCodes.Severity.IGNORE);
				return (OCLInternal) ocl;
			}

			@Override
			public @NonNull Resource runWithThrowable() throws Exception {
				ResourceSet actualResourceSet = createTestResourceSet();
				Resource actualResource = ClassUtil.nonNullState(actualResourceSet.getResource(actualURI, true));
				EcoreUtil.resolveAll(actualResourceSet);
				if (expectedURI != null) {
					String actualFileStem = actualURI.trimFileExtension().lastSegment();
					String expectedFileStem = expectedURI.trimFileExtension().lastSegment();
					if ((actualFileStem != null) && (expectedFileStem != null) && !actualFileStem.equals(expectedFileStem) && actualFileStem.startsWith(expectedFileStem)) {
						String suffix = actualFileStem.substring(expectedFileStem.length());
						for (Resource resource : actualResourceSet.getResources()) {
							URI resourceURI = resource.getURI();
							String fileExtension = resourceURI.fileExtension();
							URI trimmedURI = resourceURI.trimFileExtension();
							String fileStem = trimmedURI.lastSegment();
							if ((fileStem != null) && fileStem.endsWith(suffix) ) {
								String trimmedFileStem = fileStem.substring(0, fileStem.length() - suffix.length());
								resource.setURI(trimmedURI.trimSegments(1).appendSegment(trimmedFileStem).appendFileExtension(fileExtension));
							}
						}
					}
					checkOutput(actualResource, expectedURI, normalizer);
				}
				return actualResource;
			}
		};
		return checkThread.invoke();
	}

	private void checkOutput(@NonNull Resource outputResource, @NonNull URI referenceModelURI, @Nullable ModelNormalizer normalizer) throws IOException, InterruptedException {
		ResourceSet referenceResourceSet = createTestResourceSet();
		Resource referenceResource = referenceResourceSet.getResource(referenceModelURI, true);
		assert referenceResource != null;
		EcoreUtil.resolveAll(referenceResourceSet);
		if (normalizer != null) {
			assert !referenceResource.getContents().isEmpty() : referenceResource.getURI() + " has no contents";
			assert !outputResource.getContents().isEmpty() : outputResource.getURI() + " has no contents";
			normalizer.normalize(referenceResource);
			normalizer.normalize(outputResource);
		}
		LoadTestCase.assertSameModel(referenceResource, outputResource);
	}

	private @NonNull ResourceSet createTestResourceSet() {
		ResourceSet actualResourceSet = new ResourceSetImpl();
		getTestProjectManager().initializeResourceSet(actualResourceSet);
		return actualResourceSet;
	}

	public @NonNull CompilationResult loadTransformation(@NonNull URI txURI) throws Exception {
		QVTimperativeEnvironmentThreadFactory threadFactory = createQVTimperativeEnvironmentThreadFactory();
		QVTimperativeEnvironmentThread<@NonNull ImperativeTransformation> loadThread = new QVTimperativeEnvironmentThread<@NonNull ImperativeTransformation>("Load", threadFactory)
		{
			@Override
			protected @NonNull ImperativeTransformation runWithThrowable() throws Exception {
				QVTimperativeEnvironmentFactory environmentFactory = getEnvironmentFactory();
				ImperativeTransformation transformation = QVTimperativeUtil.loadTransformation(environmentFactory, txURI, environmentFactory.keepDebug());
				syncSuspend(transformation);
				return transformation;
			}
		};
		ImperativeTransformation transformation = loadThread.invoke();
		return new CompilationResult(loadThread, transformation);
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
		CompilationResult compilationResult = loadTransformation(txURI);
		QVTiInterpretationThread interpretationThread = new QVTiInterpretationThread(compilationResult, ModeFactory.LAZY)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createInterpretedExecutor();
				saveTransformation(txASURI, null);
				assertLoadable(txASURI);
				//
				addInputURI("upperGraph", inputURI);
				assertTrue(executeTransformation());
				addOutputURI("lowerGraph", outputURI);
				addOutputURI("middle", traceURI);
				saveModels(null);
				saveExecutionGraph(getTestURI("Graph2GraphMinimal_LAZY.graphml"));
				checkOutput(outputURI, getModelsURI("Graph2GraphMinimal/Graph2GraphMinimalValidate.xmi"), null);
				return null;
			}
		};
		interpretationThread.invoke();
		compilationResult.dispose();
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
		CompilationResult compilationResult = loadTransformation(txURI);
		QVTiInterpretationThread interpretationThread = new QVTiInterpretationThread(compilationResult, ModeFactory.LAZY)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createInterpretedExecutor();
				saveTransformation(txASURI, null);
				assertLoadable(txASURI);
				//
				addInputURI("upperGraph", inputURI);
				assertTrue(executeTransformation());
				addOutputURI("lowerGraph", outputURI);
				addOutputURI("middle", traceURI);
				saveModels(null);
				saveExecutionGraph(getTestURI("Graph2GraphMinimal_LAZY.graphml"));
				checkOutput(outputURI, getModelsURI("Graph2GraphHierarchical/Graph2GraphHierarchicalValidate.xmi"), null);
				return null;
			}
		};
		interpretationThread.invoke();
		compilationResult.dispose();
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
		URI txURI = getModelsURI("HSV2HSL/HSV2HSL.qvti");
		URI txASURI = getTestURIWithExtension(txURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		URI inputURI = getModelsURI("HSV2HSL/HSVNode.xmi");
		URI outputURI = getTestURI("HSLNode.xmi");
		URI traceURI = getTestURI("HSV2HSLNode.xmi");
		CompilationResult compilationResult = loadTransformation(txURI);
		QVTiInterpretationThread interpretationThread = new QVTiInterpretationThread(compilationResult, ModeFactory.LAZY)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createInterpretedExecutor();
				saveTransformation(txASURI, null);
				assertLoadable(txASURI);
				//
				addInputURI("hsv", inputURI);
				assertTrue(executeTransformation());
				addOutputURI("hsl", outputURI);
				addOutputURI("middle", traceURI);
				saveModels(null);
				saveExecutionGraph(getTestURI("HSV2HSL_LAZY.graphml"));
				checkOutput(outputURI, getModelsURI("HSV2HSL/HSLNodeValidate.xmi"), null);
				return null;
			}
		};
		interpretationThread.invoke();
		compilationResult.dispose();
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
		CompilationResult compilationResult = loadTransformation(txURI);
		QVTiInterpretationThread interpretationThread = new QVTiInterpretationThread(compilationResult, ModeFactory.INCREMENTAL)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createInterpretedExecutor();
				saveTransformation(txASURI, null);
				assertLoadable(txASURI);
				//
				addInputURI("tree", inputURI);
				assertTrue(executeTransformation());
				addOutputURI("talltree", outputURI);
				addOutputURI("tree2talltree", traceURI);
				saveModels(null);
				writeExecutionGraphMLfile(getTestURI("Tree2TallTree-execution.graphml"));
				saveExecutionGraph(getTestURI("Tree2TallTree_INCREMENTAL.graphml"));
				checkOutput(outputURI, getModelsURI("Tree2TallTree/samples/TallTreeValidate.xmi"), null);
				return null;
			}
		};
		interpretationThread.invoke();
		compilationResult.dispose();
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
		CompilationResult compilationResult = loadTransformation(txURI);
		QVTiInterpretationThread interpretationThread = new QVTiInterpretationThread(compilationResult, ModeFactory.LAZY)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createInterpretedExecutor();
				saveTransformation(txASURI, null);
				assertLoadable(txASURI);
				//
				addInputURI("tree", inputURI);
				assertTrue(executeTransformation());
				addOutputURI("talltree", outputURI);
				addOutputURI("tree2talltree", traceURI);
				saveModels(null);
				saveExecutionGraph(getTestURI("Tree2TallTree_LAZY.graphml"));
				checkOutput(outputURI, getModelsURI("Tree2TallTree/samples/TallTreeValidate.xmi"), null);
				return null;
			}
		};
		interpretationThread.invoke();
		compilationResult.dispose();
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
		TestUtil.doCompleteOCLSetup();
		URI oclURI = getResourceURI("org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl");
		//  CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metamodelManager);
		@SuppressWarnings("unused")
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), oclURI);

		CompilationResult compilationResult = loadTransformation(txURI);
		QVTiInterpretationThread interpretationThread = new QVTiInterpretationThread(compilationResult, ModeFactory.LAZY)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createInterpretedExecutor();
				saveTransformation(txASURI, null);
				assertLoadable(txASURI);
				//
				addInputURI("uml", inputURI);
				assertTrue(executeTransformation());
				addOutputURI("rdbms", outputURI);
				addOutputURI("middle", traceURI);
				saveModels(null);
				saveExecutionGraph(getTestURI("ManualUML2RDBMS_LAZY.graphml"));
				checkOutput(outputURI, getModelsURI("ManualUML2RDBMS/ManualRDBMSPeopleValidate.xmi"), ManualRDBMSNormalizer.INSTANCE);
				return null;
			}
		};
		interpretationThread.invoke();
		compilationResult.dispose();
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
		TestUtil.doCompleteOCLSetup();
		URI oclURI = getResourceURI("org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl");
		//  CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metaModelManager);
		@SuppressWarnings("unused")
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), oclURI);

		CompilationResult compilationResult = loadTransformation(txURI);
		QVTiInterpretationThread interpretationThread = new QVTiInterpretationThread(compilationResult, ModeFactory.LAZY)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createInterpretedExecutor();
				saveTransformation(txASURI, null);
				assertLoadable(txASURI);
				//
				addInputURI("uml", inputURI);
				assertTrue(executeTransformation());
				addOutputURI("rdbms", outputURI);
				addOutputURI("middle", traceURI);
				saveModels(null);
				saveExecutionGraph(getTestURI("SimpleUML2RDBMS_LAZY.graphml"));
				checkOutput(outputURI, getModelsURI("SimpleUML2RDBMS/SimpleRDBMSPeopleValidate.xmi"), SimpleRDBMSNormalizer.INSTANCE);
				return null;
			}
		};
		interpretationThread.invoke();
		compilationResult.dispose();
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
		CompilationResult compilationResult = loadTransformation(txURI);
		QVTiInterpretationThread interpretationThread = new QVTiInterpretationThread(compilationResult, ModeFactory.LAZY)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createInterpretedExecutor();
				saveTransformation(txASURI, null);
				assertLoadable(txASURI);
				//
				addInputURI("leftCS", inputURI);
				assertTrue(executeTransformation());
				addOutputURI("rightAS", outputURI);
				//	saveOutput("middle", getTestURI("middle.xmi"));
				saveModels(null);
				saveExecutionGraph(getTestURI("ClassesCS2AS_LAZY.graphml"));
				checkOutput(outputURI, getModelsURI("ClassesCS2AS/bug456900/example_output_ref.xmi"), null);
				return null;
			}
		};
		interpretationThread.invoke();
		compilationResult.dispose();
	}

	@Test
	public void testQVTiInterpreter_ClassesCS2AS_bug457239() throws Exception {
		TestUtil.doCompleteOCLSetup();
		URI txURI = getModelsURI("ClassesCS2AS/bug457239/ClassesCS2AS.qvti");
		URI txASURI = getTestURIWithExtension(txURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		URI inputURI = getModelsURI("ClassesCS2AS/bug457239/example_input.xmi");
		URI outputURI = getTestURI("example_output.xmi");
		CompilationResult compilationResult = loadTransformation(txURI);
		QVTiInterpretationThread interpretationThread = new QVTiInterpretationThread(compilationResult, ModeFactory.LAZY)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createInterpretedExecutor();
				saveTransformation(txASURI, null);
				assertLoadable(txASURI);
				//
				addInputURI("leftCS", inputURI);
				assertTrue(executeTransformation());
				addOutputURI("rightAS", outputURI);
				//	saveOutput("middle", getTestURI("middle.xmi"));
				saveModels(null);
				saveExecutionGraph(getTestURI("ClassesCS2AS_LAZY.graphml"));
				checkOutput(outputURI, getModelsURI("ClassesCS2AS/bug457239/example_output_ref.xmi"), null);
				return null;
			}
		};
		interpretationThread.invoke();
		compilationResult.dispose();
	}

	@Test
	public void testQVTiInterpreter_ClassesCS2AS_bug457239b() throws Exception {
		TestUtil.doCompleteOCLSetup();
		URI txURI = getModelsURI("ClassesCS2AS/bug457239/ClassesCS2ASv2_AS.qvtias");
		URI inputURI = getModelsURI("ClassesCS2AS/bug457239/example_input.xmi");
		URI outputURI = getTestURI("example_output.xmi");
		CompilationResult compilationResult = loadTransformation(txURI);
		QVTiInterpretationThread interpretationThread = new QVTiInterpretationThread(compilationResult, ModeFactory.LAZY)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createInterpretedExecutor();
				addInputURI("leftCS", inputURI);
				assertTrue(executeTransformation());
				addOutputURI("rightAS", outputURI);
				saveModels(null);
				checkOutput(outputURI, getModelsURI("ClassesCS2AS/bug457239/exampleV2_output_ref.xmi"), null);
				return null;
			}
		};
		interpretationThread.invoke();
		compilationResult.dispose();
	}
}
