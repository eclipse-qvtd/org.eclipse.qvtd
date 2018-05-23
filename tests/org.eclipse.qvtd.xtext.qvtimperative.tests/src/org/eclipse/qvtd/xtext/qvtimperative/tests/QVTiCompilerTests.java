/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.tools.JavaFileObject;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.pivot.tests.PivotTestCase.GlobalStateMemento;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.ocl.pivot.validation.ComposedEValidator;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.Execution2GraphVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.ObjectManager;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationManagerInternal;
import org.eclipse.qvtd.runtime.internal.evaluation.ModificationMonitor;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;

import com.google.common.collect.Iterables;
import junit.framework.TestCase;
import tree2talltree.tree.TreePackage;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiCompilerTests extends LoadTestCase
{
	@SuppressWarnings("unused")private static ComposedEValidator makeSureRequiredBundleIsLoaded = null;

	public static @NonNull Map<Object, Object> getSaveOptions() {
		return DefaultCompilerOptions.defaultSavingOptions;
	}

	protected static class MyQVT extends OCLInternal
	{
		protected final @NonNull TestProject testProject;
		private GlobalStateMemento globalStateMemento = new GlobalStateMemento();

		public MyQVT(@NonNull TestProject testProject, @NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
			this.testProject = testProject;
		}

		private Class<? extends Transformer> compileTransformation(@NonNull File explicitClassPath, @NonNull QVTiCodeGenerator cg, @NonNull List<@NonNull String> extraClasspathProjects) throws Exception {
			String qualifiedClassName = cg.getQualifiedName();
			String javaCodeSource = cg.generateClassFile();
			String string = explicitClassPath.toString();
			assert string != null;
			//			String message = OCL2JavaFileObject.saveClass(string, qualifiedClassName, javaCodeSource, extraClasspathProjects);
			List<@NonNull JavaFileObject> compilationUnits = Collections.singletonList(new OCL2JavaFileObject(qualifiedClassName, javaCodeSource));
			String message = JavaFileUtil.compileClasses(compilationUnits, qualifiedClassName, string, extraClasspathProjects);
			if (message != null) {
				fail(message);
			}
			@SuppressWarnings("unchecked")
			Class<? extends Transformer> txClass = (Class<? extends Transformer>) OCL2JavaFileObject.loadExplicitClass(explicitClassPath, qualifiedClassName, getClass().getClassLoader());
			return txClass;
		}

		public @NonNull Transformer createTransformer(@NonNull Class<? extends Transformer> txClass) throws ReflectiveOperationException {
			QVTiTransformationExecutor executor = new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
			return executor.getTransformer();
		}

		@Override
		public synchronized void dispose() {
			super.dispose();
			globalStateMemento.restoreGlobalState();
			globalStateMemento = null;
		}

		public @NonNull Resource doLoad_ConcreteWithOCL(@NonNull URI inputURI) throws Exception {
			URI cstURI = testProject.getOutputFile(ClassUtil.nonNullState(inputURI.appendFileExtension("xmi").lastSegment())).getURI();//TestUtil.getFileURI(getClass(), cstName);
			URI pivotURI = testProject.getOutputFile(ClassUtil.nonNullState(inputURI.appendFileExtension("qvtias").lastSegment())).getURI();//TestUtil.getFileURI(getClass(), pivotName);
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
			URI oclURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true);
			//			CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metamodelManager);
			CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), oclURI, getEnvironmentFactory());
			//			CompleteOCLEObjectValidator completeOCLEObjectValidator3 = new CompleteOCLEObjectValidator(QVTbasePackage.eINSTANCE, oclURI, metamodelManager);
			//			completeOCLEObjectValidator1.initialize();
			completeOCLEObjectValidator2.initialize();
			//			completeOCLEObjectValidator3.initialize();
			PivotEObjectValidator.install(ClassUtil.nonNullState(asResource.getResourceSet()), getEnvironmentFactory());
			PivotEObjectValidator.install(ClassUtil.nonNullState(QVTbasePackage.eINSTANCE), null);
			PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcorePackage.eINSTANCE), null);
			PivotEObjectValidator.install(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), null);

			assertNoValidationErrors("Pivot validation errors", asResource.getContents().get(0));
			asResource.save(getSaveOptions());
			return asResource;
		}

		protected @NonNull Class<? extends Transformer> generateCode(@NonNull Transformation asTransformation, boolean isIncremental) throws Exception {
			QVTiCodeGenerator cg = new QVTiCodeGenerator(getEnvironmentFactory(), asTransformation);
			QVTiCodeGenOptions options = cg.getOptions();
			options.setIsIncremental(isIncremental);
			options.setUseNullAnnotations(true);
			//			options.setPackagePrefix("cg_qvtimperative_tests");
			cg.generateClassFile();
			TestFile srcPath = testProject.getOutputFolder(JavaFileUtil.TEST_SRC_FOLDER_NAME);
			TestFile binPath = testProject.getOutputFolder(JavaFileUtil.TEST_BIN_FOLDER_NAME);
			//			cg.saveSourceFile("../org.eclipse.qvtd.xtext.qvtimperative.tests/test-gen/");
			cg.saveSourceFile(srcPath.getFileString());
			List<@NonNull String> projectNames = CompilerUtil.createClasspathProjectNameList("org.eclipse.qvtd.xtext.qvtimperative.tests");
			// System.out.println("projectNames => " + projectNames);
			List<@NonNull String> classpathList = JavaFileUtil.createClassPathProjectList(asTransformation.eResource().getResourceSet().getURIConverter(), projectNames);
			// System.out.println("classpathList => " + classpathList);

			Class<? extends Transformer> txClass = compileTransformation(binPath.getFile(), cg, classpathList);
			if (txClass == null) {
				TestCase.fail("Failed to compile transformation");
				throw new UnsupportedOperationException();
			}
			return txClass;
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}

		public @NonNull Resource loadInput(@NonNull Transformer tx, @NonNull String inputModelName, URI inputModelURI) {
			Resource inputResource = getResourceSet().getResource(inputModelURI, true);
			tx.addRootObjects(inputModelName, ClassUtil.nonNullState(inputResource.getContents()));
			return inputResource;
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
			outputResource.getContents().addAll(tx.getRootEObjects(outputModelName));
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

	protected void checkCleared(@NonNull TransformationExecutor executor) {
		AbstractInvocationManagerInternal invocationManager = (AbstractInvocationManagerInternal)executor.getTransformer().getInvocationManager();
		Iterable<@NonNull Invocation> allInvocations = invocationManager.debugGetAllInvocations();
		assertEquals("All invocations post-clear", 1, Iterables.size(allInvocations));
		for (@NonNull Interval interval : invocationManager.getIntervals()) {
			for (@NonNull Connection connection : interval.getConnections()) {
				assertEquals("Connection '" + connection.getName() + "' post-clear", 0, connection.debugGetSize());
			}
		}
		ObjectManager objectManager = executor.getTransformer().getObjectManager();
		Iterable<@NonNull ? extends Object> allObjects = objectManager.getObjects();
		assertEquals("All objects post-clear", 0, Iterables.size(allObjects));
	}

	protected @NonNull MyQVT createQVT() throws Exception {
		return new MyQVT(getTestProject(), new MyQVTiEnvironmentFactory(getTestProjectManager(), null));
	}

	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		//		JavaFileUtil.CLASS_PATH.setState(true);
		TestUtil.doCompleteOCLSetup();
		XtextCompilerUtil.doQVTimperativeSetup();
		super.setUp();
	}

	public void testQVTiCompiler_HSV2HLS_CG() throws Exception {
		URI modelsProjectURI = getModelsURI("HSV2HSL");
		URI transformURI = modelsProjectURI.appendSegment("HSV2HSL.qvti");
		URI genModelURI = modelsProjectURI.appendSegment("HSV2HSL.genmodel");
		URI inputModelURI = modelsProjectURI.appendSegment("HSVNode.xmi");
		URI referenceModelURI = modelsProjectURI.appendSegment("HSLNodeValidate.xmi");
		//
		URI outputModelURI = getTestURI("HSLNode.xmi");
		//
		MyQVT myQVT = createQVT();
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation, false);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "hsv", inputModelURI);
		tx.run();
		myQVT.saveOutput(tx, "hsl", outputModelURI, referenceModelURI, null);
		myQVT.dispose();
	}

	public void testQVTiCompiler_ClassesCS2AS_CG() throws Exception {
		URI transformURI = getModelsURI("ClassesCS2AS/ClassesCS2AS.qvti");
		URI genModelURI = getModelsURI("ClassesCS2AS/ClassesCS2AS.genmodel");
		//
		MyQVT myQVT = createQVT();
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		myQVT.generateCode(asTransformation, false);
		myQVT.dispose();
	}

	public void testQVTiCompiler_ClassesCS2AS_bug459225_CG() throws Exception {
		URI modelsProjectURI = getModelsURI("ClassesCS2AS");
		URI submodelsProjectURI = modelsProjectURI.appendSegment("bug459225");
		URI transformURI = submodelsProjectURI.appendSegment("ClassesCS2AS.qvti");
		URI genModelURI = modelsProjectURI.appendSegment("ClassesCS2AS.genmodel");
		URI inputModelURI = submodelsProjectURI.appendSegment("example_input.xmi");
		URI referenceModelURI = submodelsProjectURI.appendSegment("example_output_ref.xmi");
		//
		URI outputModelURI = getTestURI("example_output.xmi");
		//
		MyQVT myQVT = createQVT();
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation, false);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "leftCS", inputModelURI);
		tx.run();
		myQVT.saveOutput(tx, "rightAS", outputModelURI, referenceModelURI, null);
		myQVT.dispose();
	}

	public void testQVTiCompiler_ManualUML2RDBMS_CG() throws Exception {
		URI modelsProjectURI = getModelsURI("ManualUML2RDBMS");
		URI transformURI = modelsProjectURI.appendSegment("ManualUML2RDBMS.qvti");
		URI genModelURI = modelsProjectURI.appendSegment("ManualUML2RDBMS.genmodel");
		URI inputModelURI = modelsProjectURI.appendSegment("ManualUMLPeople.xmi");
		URI referenceModelURI = modelsProjectURI.appendSegment("ManualRDBMSPeopleValidate.xmi");
		//
		URI outputModelURI = getTestURI("ManualRDBMSPeople.xmi");
		//
		MyQVT myQVT = createQVT();
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation, false);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "uml", inputModelURI);
		tx.run();
		myQVT.saveOutput(tx, "rdbms", outputModelURI, referenceModelURI, ManualRDBMSNormalizer.INSTANCE);
		myQVT.dispose();
	}

	public void testQVTiCompiler_SimpleUML2RDBMS_CG() throws Exception {
		URI modelsProjectURI = getModelsURI("SimpleUML2RDBMS");
		URI transformURI = modelsProjectURI.appendSegment("SimpleUML2RDBMS.qvti");
		URI genModelURI = modelsProjectURI.appendSegment("SimpleUML2RDBMS.genmodel");
		URI inputModelURI = modelsProjectURI.appendSegment("SimpleUMLPeople.xmi");
		URI referenceModelURI = modelsProjectURI.appendSegment("SimpleRDBMSPeopleValidate.xmi");
		//
		URI outputModelURI = getTestURI("SimpleRDBMSPeople.xmi");
		//
		MyQVT myQVT = createQVT();
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation, false);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "uml", inputModelURI);
		tx.run();
		myQVT.saveOutput(tx, "rdbms", outputModelURI, referenceModelURI, SimpleRDBMSNormalizer.INSTANCE);
		myQVT.dispose();
	}

	public void testQVTiCompiler_Tree2TallTree_CG() throws Exception {
		EPackage.Registry.INSTANCE.put(TreePackage.eNS_URI, TreePackage.eINSTANCE);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		URI modelsProjectURI = getModelsURI("Tree2TallTree");
		URI samplesProjectURI = modelsProjectURI.appendSegment("samples");
		URI transformURI = modelsProjectURI.appendSegment("Tree2TallTree.qvti");
		URI genModelURI = modelsProjectURI.appendSegment("Tree2TallTree.genmodel");
		URI inputModelURI = samplesProjectURI.appendSegment("Tree.xmi");
		URI referenceModelURI = samplesProjectURI.appendSegment("TallTreeValidate.xmi");
		//
		URI outputModelURI = getTestURI("Tree2TallTree.xmi");
		//
		MyQVT myQVT = createQVT();
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation, false);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "tree", inputModelURI);
		tx.run();
		myQVT.saveOutput(tx, "talltree", outputModelURI, referenceModelURI, null);
		Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("Tree2TallTree-execution.graphml"));
		myQVT.dispose();
	}

	public void testQVTiCompiler_Tree2TallTree_Changed_CG() throws Exception {
		EPackage.Registry.INSTANCE.put(TreePackage.eNS_URI, TreePackage.eINSTANCE);
		URI modelsProjectURI = getModelsURI("Tree2TallTree");
		URI samplesProjectURI = modelsProjectURI.appendSegment("samples");
		URI transformURI = modelsProjectURI.appendSegment("Tree2TallTree.qvti");
		URI genModelURI = modelsProjectURI.appendSegment("Tree2TallTree.genmodel");
		URI inputModelURI = samplesProjectURI.appendSegment("Tree.xmi");
		URI referenceModelURI = samplesProjectURI.appendSegment("TallTreeValidate.xmi");
		URI changedReferenceModelURI = samplesProjectURI.appendSegment("TallTreeValidateChanged.xmi");
		//
		URI outputModelURI = getTestURI("Tree2TallTree.xmi");
		URI changedOutputModelURI = getTestURI("samples/Tree2TallTreeChanged.xmi");
		//
		MyQVT myQVT = createQVT();
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation, true);
		Transformer tx = myQVT.createTransformer(txClass);
		Resource inputResource = myQVT.loadInput(tx, "tree", inputModelURI);
		tx.run();
		Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("Tree2TallTree-inc.graphml"));
		myQVT.saveOutput(tx, "talltree", outputModelURI, referenceModelURI, null);
		TransformationExecutor executor = tx.getExecutor();
		TypedModelInstance treeModel = tx.getTypedModelInstance("tree");
		@SuppressWarnings("unused") ModificationMonitor monitor = ModificationMonitor.getModificationMonitor(treeModel, inputResource, executor);
		int gotOne = 0;
		for (EObject eObject : new TreeIterable(inputResource)) {
			EClass eClass = eObject.eClass();
			if ("Node".equals(eClass.getName())) {
				EAttribute nameAttribute = (EAttribute) eClass.getEStructuralFeature("name");
				Object name = eObject.eGet(nameAttribute);
				if ("n1.1".equals(name)) {
					gotOne++;
					eObject.eSet(nameAttribute, "x1.1");
				}
			}
		}
		assert gotOne == 1;
		executor.getTransformer().getInvocationManager().flush();
		Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("Tree2TallTree-incChanged.graphml"));
		myQVT.saveOutput(tx, "talltree", changedOutputModelURI, changedReferenceModelURI, null);
		myQVT.dispose();
	}

	public void testQVTiCompiler_Tree2TallTree_Copied_CG() throws Exception {
		//		AbstractTransformer.INVOCATIONS.setState(true);
		URI modelsProjectURI = getModelsURI("Tree2TallTree");
		URI samplesProjectURI = modelsProjectURI.appendSegment("samples");
		URI transformURI = modelsProjectURI.appendSegment("Tree2TallTree.qvti");
		URI genModelURI = modelsProjectURI.appendSegment("Tree2TallTree.genmodel");
		URI inputModelURI = samplesProjectURI.appendSegment("Tree.xmi");
		URI referenceModelURI = samplesProjectURI.appendSegment("TallTreeValidate.xmi");
		URI clearedReferenceModelURI = samplesProjectURI.appendSegment("TallTreeValidateCleared.xmi");
		//
		URI outputModelURI = getTestURI("Tree2TallTree.xmi");
		URI clearedOutputModelURI = getTestURI("Tree2TallTreeCleared.xmi");
		URI copiedOutputModelURI = getTestURI("Tree2TallTreeCopied.xmi");
		//
		MyQVT myQVT = createQVT();
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation, true);
		Transformer tx = myQVT.createTransformer(txClass);
		Resource inputResource = myQVT.loadInput(tx, "tree", inputModelURI);
		tx.run();
		Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("Tree2TallTree-inc.graphml"));
		myQVT.saveOutput(tx, "talltree", outputModelURI, referenceModelURI, null);
		TransformationExecutor executor = tx.getExecutor();
		TypedModelInstance treeModel = tx.getTypedModelInstance("tree");
		@SuppressWarnings("unused") ModificationMonitor monitor = ModificationMonitor.getModificationMonitor(treeModel, inputResource, executor);
		List<@NonNull EObject> contents = inputResource.getContents();
		List<@NonNull EObject> oldContents = new ArrayList<>(contents);
		Collection<@NonNull EObject> newContents = EcoreUtil.copyAll(oldContents);
		contents.clear();

		checkCleared(executor);
		InvocationManager invocationManager = executor.getTransformer().getInvocationManager();

		//		oldContents.addAll(newContents);
		invocationManager.flush();
		Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("Tree2TallTree-incCleared.graphml"));
		myQVT.saveOutput(tx, "talltree", clearedOutputModelURI, clearedReferenceModelURI, null);

		contents.addAll(newContents);
		invocationManager.flush();
		Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("Tree2TallTree-incCopied.graphml"));
		myQVT.saveOutput(tx, "talltree", copiedOutputModelURI, referenceModelURI, null);


		myQVT.dispose();
	}

	public void testQVTiCompiler_Tree2TallTree_Deleted_CG() throws Exception {
		EPackage.Registry.INSTANCE.put(TreePackage.eNS_URI, TreePackage.eINSTANCE);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		URI modelsProjectURI = getModelsURI("Tree2TallTree");
		URI samplesProjectURI = modelsProjectURI.appendSegment("samples");
		URI transformURI = modelsProjectURI.appendSegment("Tree2TallTree.qvti");
		URI genModelURI = modelsProjectURI.appendSegment("Tree2TallTree.genmodel");
		URI inputModelURI = samplesProjectURI.appendSegment("Tree.xmi");
		URI referenceModelURI = samplesProjectURI.appendSegment("TallTreeValidate.xmi");
		URI deletedReferenceModelURI = samplesProjectURI.appendSegment("TallTreeValidateDeleted.xmi");
		//
		URI outputModelURI = getTestURI("Tree2TallTree.xmi");
		URI deletedOutputModelURI = getTestURI("Tree2TallTreeDeleted.xmi");
		//
		MyQVT myQVT = createQVT();
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation, true);
		Transformer tx = myQVT.createTransformer(txClass);
		Resource inputResource = myQVT.loadInput(tx, "tree", inputModelURI);
		tx.run();
		Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("Tree2TallTree-inc.graphml"));
		myQVT.saveOutput(tx, "talltree", outputModelURI, referenceModelURI, null);
		TransformationExecutor executor = tx.getExecutor();
		TypedModelInstance treeModel = tx.getTypedModelInstance("tree");
		ModificationMonitor monitor = ModificationMonitor.getModificationMonitor(treeModel,inputResource, executor);
		int gotOne = 0;
		for (EObject eObject : new TreeIterable(inputResource)) {
			EClass eClass = eObject.eClass();
			if ("Node".equals(eClass.getName())) {
				EAttribute nameAttribute = (EAttribute) eClass.getEStructuralFeature("name");
				Object name = eObject.eGet(nameAttribute);
				if ("n1.1.1".equals(name)) {
					gotOne++;
					PivotUtilInternal.resetContainer(eObject);
				}
			}
		}
		assert gotOne == 1;
		executor.getTransformer().getInvocationManager().flush();
		Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("Tree2TallTree-incDeleted.graphml"));
		myQVT.saveOutput(tx, "talltree", deletedOutputModelURI, deletedReferenceModelURI, null);
		monitor.dispose();
		myQVT.dispose();
	}

	/*	public void testQVTiCompiler_Tree2TallTree_Incremental_CG2() throws Exception {
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT();
		URI genModelURI = getTestModelsFileURI("Tree2TallTree/Tree2TallTree.genmodel");
		URI transformURI = getTestModelsFileURI("Tree2TallTree/Tree2TallTree.qvti");
		URI inputModelURI = getTestModelsFileURI("Tree2TallTree/Tree.xmi");
		URI outputModelURI = getTestModelsFileURI("Tree2TallTree/Tree2TallTree.xmi");
		URI outputModelURI2 = getTestModelsFileURI("Tree2TallTree/Tree2TallTree2.xmi");
		URI referenceModelURI = getTestModelsFileURI("Tree2TallTree/TallTreeValidate.xmi");
		URI referenceModelURI2 = getTestModelsFileURI("Tree2TallTree/TallTreeValidate2.xmi");
		Class<? extends Transformer> txClass = Tree2TallTree.class;
		Transformer tx = myQVT.createTransformer(txClass);
		Resource inputResource = myQVT.loadInput(tx, "tree", inputModelURI);
		tx.run();
		Execution2GraphVisitor.writeGraphMLfile(tx, getTestModelsFileURI("Tree2TallTree/graphs/Tree2TallTree-inc.graphml"));
		myQVT.saveOutput(tx, "talltree", outputModelURI, referenceModelURI, null);
		TransformationExecutor executor = tx.getExecutor();
		ModificationMonitor monitor = ModificationMonitor.getModificationMonitor(inputResource, executor);
		int gotOne = 0;
		for (EObject eObject : new TreeIterable(inputResource)) {
			EClass eClass = eObject.eClass();
			if ("Node".equals(eClass.getName())) {
				EAttribute nameAttribute = (EAttribute) eClass.getEStructuralFeature("name");
				Object name = eObject.eGet(nameAttribute);
				if ("n1.1".equals(name)) {
					gotOne++;
					eObject.eSet(nameAttribute, "x1.1");
				}
			}
		}
		assert gotOne == 1;
		executor.getTransformer().getInvocationManager().flush();
		Execution2GraphVisitor.writeGraphMLfile(tx, getTestModelsFileURI("Tree2TallTree/graphs/Tree2TallTree-inc2.graphml"));
		myQVT.saveOutput(tx, "talltree", outputModelURI2, referenceModelURI2, null);
		myQVT.dispose();
	} */

	/*	public void testQVTiCompiler_Tree2TallTreeInstall_CG() throws Exception {
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT();
		URI genModelURI = getTestModelsFileURI("Tree2TallTree/Tree2TallTree.genmodel");
		URI transformURI = getTestModelsFileURI("Tree2TallTree/Tree2TallTreeInstall.qvti");

		URI inputModelURI = getTestModelsFileURI("Tree2TallTree/samples/Tree.xmi");
		URI outputModelURI = getTestModelsFileURI("Tree2TallTree/samples/Tree2TallTree.xmi");
		URI referenceModelURI = getTestModelsFileURI("Tree2TallTree/samples/TallTreeValidate.xmi");
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation, true);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "tree", inputModelURI);
		tx.run();
		myQVT.saveOutput(tx, "talltree", outputModelURI, referenceModelURI, null);
		myQVT.dispose();
	} */
}
