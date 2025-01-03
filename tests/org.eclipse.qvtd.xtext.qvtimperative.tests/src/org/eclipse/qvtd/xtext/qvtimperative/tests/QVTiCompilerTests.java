/*******************************************************************************
 * Copyright (c) 2012, 2023 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.tools.JavaFileObject;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
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
import org.eclipse.ocl.pivot.validation.ValidationRegistryAdapter;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.Execution2GraphVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
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
import org.osgi.framework.Bundle;

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

		public MyQVT(@NonNull TestProject testProject, @NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
			this.testProject = testProject;
		}

		private Class<? extends Transformer> compileTransformation(@NonNull File explicitClassPath, @NonNull QVTiCodeGenerator cg, @NonNull JavaClasspath classpath) throws Exception {
			String qualifiedClassName = cg.getQualifiedName();
			String javaCodeSource = cg.generateClassFile();
			String string = explicitClassPath.toString();
			assert string != null;
			//			String message = OCL2JavaFileObject.saveClass(string, qualifiedClassName, javaCodeSource, extraClasspathProjects);
			List<@NonNull JavaFileObject> compilationUnits = Collections.singletonList(new OCL2JavaFileObject(qualifiedClassName, javaCodeSource));
			String message = JavaFileUtil.compileClasses(compilationUnits, qualifiedClassName, string, classpath);
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

		public @NonNull Resource doLoad_ConcreteWithOCL(@NonNull URI inputURI) throws Exception {
			URI cstURI = testProject.getOutputFile(ClassUtil.nonNullState(inputURI.appendFileExtension("xmi").lastSegment())).getURI();//TestUtil.getFileURI(getClass(), cstName);
			URI pivotURI = testProject.getOutputFile(ClassUtil.nonNullState(inputURI.appendFileExtension(QVTimperativeUtil.QVTIAS_FILE_EXTENSION).lastSegment())).getURI();//TestUtil.getFileURI(getClass(), pivotName);
			BaseCSResource xtextResource = (BaseCSResource) getResourceSet().getResource(inputURI, true);
			assert xtextResource != null;
			assertNoResourceErrors("Load failed", xtextResource);
			ASResource asResource = xtextResource.getASResource();
			//			assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
			//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
			assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
			//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
			TestUtil.saveAsXMI(xtextResource, cstURI, getSaveOptions());

			TestUtil.doCompleteOCLSetup();
			URI oclURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true);
			//			CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metamodelManager);
			QVTiEnvironmentFactory environmentFactory = getEnvironmentFactory();
			CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), oclURI);
			//			CompleteOCLEObjectValidator completeOCLEObjectValidator3 = new CompleteOCLEObjectValidator(QVTbasePackage.eINSTANCE, oclURI, metamodelManager);
			//			completeOCLEObjectValidator1.initialize();
			completeOCLEObjectValidator2.initialize(environmentFactory);
			//			completeOCLEObjectValidator3.initialize();
			ResourceSet asResourceSet = asResource.getResourceSet();
			assert asResourceSet != null;
			ValidationRegistryAdapter asValidationRegistry = ValidationRegistryAdapter.getAdapter(asResourceSet);
			//	PivotEObjectValidator.install(ClassUtil.nonNullState(asResourceSet), environmentFactory);
			PivotEObjectValidator.install(asValidationRegistry, ClassUtil.nonNullState(QVTbasePackage.eINSTANCE), null);
			PivotEObjectValidator.install(asValidationRegistry, ClassUtil.nonNullState(QVTcorePackage.eINSTANCE), null);
			PivotEObjectValidator.install(asValidationRegistry, ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), null);

			assertNoValidationErrors("Pivot validation errors", asResource.getContents().get(0));
			if (asResource.isSaveable()) {
				asResource.setURI(pivotURI);
				asResource.save(getSaveOptions());
			}
			return asResource;
		}

		protected @NonNull Class<? extends Transformer> generateCode(@NonNull ImperativeTransformation iTransformation, boolean isIncremental) throws Exception {
			QVTiCodeGenerator cg = new QVTiCodeGenerator(getEnvironmentFactory(), iTransformation);
			QVTiCodeGenOptions options = cg.getOptions();
			options.setIsIncremental(isIncremental);
			options.setUseNullAnnotations(true);
			//			options.setPackagePrefix("cg_qvtimperative_tests");
			cg.generateClassFile();
			TestFile srcPath = testProject.getOutputFolder(JavaFileUtil.TEST_SRC_FOLDER_NAME + "/");
			TestFile binPath = testProject.getOutputFolder(JavaFileUtil.TEST_BIN_FOLDER_NAME + "/");
			//			cg.saveSourceFile("../org.eclipse.qvtd.xtext.qvtimperative.tests/test-gen/");
			cg.saveSourceFile(srcPath.getFileString());
			JavaClasspath classpath = CompilerUtil.createDefaultQVTiClasspath();
			classpath.addClass(getClass());
			// System.out.println("projectNames => " + projectNames);
			// List<@NonNull String> classpathList = classpath.getClasspathProjectList();
			// System.out.println("classpathList => " + classpathList);

			Class<? extends Transformer> txClass = compileTransformation(binPath.getFile(), cg, classpath);
			if (txClass == null) {
				TestCase.fail("Failed to compile transformation");
				throw new UnsupportedOperationException();
			}
			return txClass;
		}

		public static @NonNull List<@NonNull String> my_createClassPathProjectList(@NonNull URIConverter uriConverter, @NonNull List<@NonNull String> projectNames) {
			List<@NonNull String> classpathProjectList = new ArrayList<@NonNull String>();
			for (@NonNull String projectName : projectNames) {
				File path = my_getProjectBinFolder(uriConverter, projectName);
				if (path != null) {
					classpathProjectList.add(String.valueOf(path));
				}
			}
			//		}
			return classpathProjectList;
		}

		private static final @NonNull String MAVEN_TYCHO_BIN_FOLDER_NAME = "target/classes";
		private static final @NonNull String REGULAR_BIN_FOLDER_NAME = "bin";

		/**
		 * Return the file system folder suitable for use as a javac classpath entry.
		 *
		 * For workspace projects this is the "bin" folder. For plugins it is the jar file.
		 */
		public static @Nullable File my_getProjectBinFolder(@NonNull URIConverter uriConverter, @NonNull String projectName) {
			Class<?> class1 = QVTiCompilerTests.class;
			String modifiedProjectName = projectName.replace('.', '/');
			URL projectResource = class1.getResource("/" + modifiedProjectName);
			if (projectResource != null) {
				String projectString = projectResource.toString();
				String pathString = projectString.substring(0, projectString.length() - modifiedProjectName.length());
				URI pathURI = URI.createURI(pathString);
				return new File(pathURI.isFile() ? pathURI.toFileString() : pathURI.toString());
			}
			//			String externalForm = resource2.toExternalForm();
			//			java.net.URI uri2;
			//			try {
			//				uri2 = resource2.toURI();
			//			} catch (URISyntaxException e) {
			//				// TODO Auto-generated catch block
			//				e.printStackTrace();
			//			}
			//			String string = resource2.toString();
			String path = null;
			String binDir = CGUtil.isMavenSurefire() || CGUtil.isTychoSurefire() ? MAVEN_TYCHO_BIN_FOLDER_NAME : REGULAR_BIN_FOLDER_NAME;  // FIXME determine "bin" from JDT
			URI platformURI = URI.createPlatformResourceURI("/" + projectName + "/", true);
			URI pathURI = uriConverter.normalize(platformURI);
			String location = null;
			if (EMFPlugin.IS_ECLIPSE_RUNNING) {
				Bundle bundle = Platform.getBundle(projectName);
				if (bundle != null) {
					try {
						File bundleFilePath = my_getOSGIClassPath(bundle);
						location = bundle.getLocation();
						path = bundleFilePath.toString();
					} catch (IOException e) {
						// Doesn't fail for sensible names.
					}
				}
				if (path == null) {					// platform:/resource
					IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
					IResource project = workspaceRoot.findMember(projectName);
					if (project != null) {
						location = String.valueOf(project.getLocation());
						path = location + "/" + JavaFileUtil.TEST_BIN_FOLDER_NAME;
					}
				}
			}
			else if (pathURI.isArchive()) {
				path = pathURI.toString();
				if (path.startsWith("archive:file:") && path.endsWith("!/")) {
					path = path.substring(13, path.length()-2);
				}
			}
			else {
				path = pathURI.toFileString();
				if (path != null) {
					if (!new File(path + "/META-INF").exists()) {
						path = path + JavaFileUtil.TEST_BIN_FOLDER_NAME;
					}
					else {
						path = path + binDir;
					}
				}
			}
			if (JavaFileUtil.CLASS_PATH.isActive()) {
				StringBuilder s = new StringBuilder();
				s.append(projectName);
				s.append(" => ");
				s.append(pathURI);
				s.append(" => ");
				if (location != null) {
					s.append(location);
					s.append(" => ");
				}
				s.append(path);
				System.out.println(s.toString());
			}
			return path != null ? new File(path) : null;
		}

		/**
		 * Return the absolute path to the 'bin' folder of a workspace bundle or the jar of a plugin.
		 */
		public static @NonNull File my_getOSGIClassPath(@NonNull Bundle bundle) throws IOException {
			//
			//  We could be helpful and use the classes from  a project, but that would be really confusing
			//  since template classes would come from the development project whereas referenced classes
			//  would come from the run-time plugin. Ignore the project files.
			//
			File bundleFile = FileLocator.getBundleFile(bundle);
			if (bundleFile.isDirectory()) {
				File outputPath = my_getOutputClassPath(bundleFile);
				if (outputPath != null) {
					return outputPath;
				}
			}
			return bundleFile;
		}

		/**
		 * Search the .classpath of bundle to locate the output classpathEntry and return the corresponding path
		 * or null if no .classpath or output classpathentry.
		 */
		private static @Nullable File my_getOutputClassPath(@NonNull File bundleDirectory) throws IOException {
			if (CGUtil.isMavenSurefire() || CGUtil.isTychoSurefire()) {
				return new File(bundleDirectory, MAVEN_TYCHO_BIN_FOLDER_NAME);
			}
			File classpathEntry = new File(bundleDirectory, ".classpath");
			if (classpathEntry.isFile()) {
				URI uri = URI.createFileURI(classpathEntry.toString());
				Resource resource = new GenericXMLResourceFactoryImpl().createResource(uri);
				resource.load(null);
				for (EObject eRoot : resource.getContents()) {
					EClass eDocumentRoot = eRoot.eClass();
					EStructuralFeature classpathentryRef = eDocumentRoot.getEStructuralFeature("classpathentry");
					EStructuralFeature kindRef = eDocumentRoot.getEStructuralFeature("kind");
					EStructuralFeature pathRef = eDocumentRoot.getEStructuralFeature("path");
					for (EObject eObject : eRoot.eContents()) {
						for (EObject eChild : eObject.eContents()) {
							if (eChild.eContainmentFeature() == classpathentryRef) {
								if ("output".equals(eChild.eGet(kindRef))) {
									String outputPath = String.valueOf(eChild.eGet(pathRef));
									return new File(bundleDirectory, outputPath);
								}
							}
						}
					}
				}
			}
			return null;
		}

		public void execute(@NonNull Transformer tx) throws Exception {
			tx.analyzeInputResources();
			tx.run();
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}

		public @NonNull Resource loadInput(@NonNull Transformer tx, @NonNull String inputModelName, URI inputModelURI) {
			Resource inputResource = ClassUtil.nonNullState(getResourceSet().getResource(inputModelURI, true));
			tx.getTypedModelInstance(inputModelName).addInputResource(inputResource);
			return inputResource;
		}

		public @NonNull ImperativeTransformation loadTransformation(@NonNull URI transformURI, @NonNull URI genModelURI) throws Exception {
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
							if (asClass instanceof ImperativeTransformation) {
								return (ImperativeTransformation)asClass;
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
			outputResource.getContents().addAll(tx.getTypedModelInstance(outputModelName).getRootEObjects());
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

	public QVTimperativeTestFileSystemHelper testFileSystemHelper = null;

	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTimperative.newInstance(getTestProjectManager(), null);
	}

	protected @NonNull MyQVT createQVT() throws Exception {
		return new MyQVT(getTestProject(), new MyQVTiEnvironmentFactory(getTestProjectManager(), null));
	}

	@Override
	protected @NonNull QVTimperativeTestFileSystemHelper getTestFileSystemHelper() {
		QVTimperativeTestFileSystemHelper testFileSystemHelper2 = testFileSystemHelper;
		if (testFileSystemHelper2 == null) {
			testFileSystemHelper = testFileSystemHelper2 = new QVTimperativeTestFileSystemHelper();
		}
		return testFileSystemHelper2;
	}

	@Override
	protected void setUp() throws Exception {
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
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
		ImperativeTransformation iTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(iTransformation, false);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "hsv", inputModelURI);
		myQVT.execute(tx);
		myQVT.saveOutput(tx, "hsl", outputModelURI, referenceModelURI, null);
		myQVT.dispose();
		cleanup("http://www.eclipse.org/qvt/examples/0.1/HSVTree",
			"http://www.eclipse.org/qvt/examples/0.1/HSVtoHSL",
				"http://www.eclipse.org/qvt/examples/0.1/HSLTree");
	}

	public void testQVTiCompiler_ClassesCS2AS_CG() throws Exception {
		URI transformURI = getModelsURI("ClassesCS2AS/ClassesCS2AS.qvti");
		URI genModelURI = getModelsURI("ClassesCS2AS/ClassesCS2AS.genmodel");
		//
		MyQVT myQVT = createQVT();
		ImperativeTransformation iTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		myQVT.generateCode(iTransformation, false);
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
		ImperativeTransformation iTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(iTransformation, false);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "leftCS", inputModelURI);
		myQVT.execute(tx);
		myQVT.saveOutput(tx, "rightAS", outputModelURI, referenceModelURI, null);
		myQVT.dispose();
		cleanup("http://tracesmodel/1.0/classescstraces",
			"http://ocldependencyanalysis/classescs/1.0",
				"http://ocldependencyanalysis/classes/1.0");
	}

	public void testQVTiCompiler_ManualUML2RDBMS_CG() throws Exception {
		EPackage.Registry.INSTANCE.put(manualuml2rdbms.rdbms.RDBMSPackage.eNS_URI, manualuml2rdbms.rdbms.RDBMSPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(manualuml2rdbms.uml2rdbms.UML2RDBMSPackage.eNS_URI, manualuml2rdbms.uml2rdbms.UML2RDBMSPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(manualuml2rdbms.uml.UMLPackage.eNS_URI, manualuml2rdbms.uml.UMLPackage.eINSTANCE);
		URI modelsProjectURI = getModelsURI("ManualUML2RDBMS");
		URI transformURI = modelsProjectURI.appendSegment("ManualUML2RDBMS.qvti");
		URI genModelURI = modelsProjectURI.appendSegment("ManualUML2RDBMS.genmodel");
		URI inputModelURI = modelsProjectURI.appendSegment("ManualUMLPeople.xmi");
		URI referenceModelURI = modelsProjectURI.appendSegment("ManualRDBMSPeopleValidate.xmi");
		//
		URI outputModelURI = getTestURI("ManualRDBMSPeople.xmi");
		//
		MyQVT myQVT = createQVT();
		ImperativeTransformation iTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(iTransformation, false);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "uml", inputModelURI);
		myQVT.execute(tx);
		myQVT.saveOutput(tx, "rdbms", outputModelURI, referenceModelURI, ManualRDBMSNormalizer.INSTANCE);
		myQVT.dispose();
		cleanup(manualuml2rdbms.uml.UMLPackage.eNS_URI,
			manualuml2rdbms.uml2rdbms.UML2RDBMSPackage.eNS_URI,
			manualuml2rdbms.rdbms.RDBMSPackage.eNS_URI);
	}

	public void testQVTiCompiler_SimpleUML2RDBMS_CG() throws Exception {
		EPackage.Registry.INSTANCE.put(simpleuml2rdbms.rdbms.RDBMSPackage.eNS_URI, simpleuml2rdbms.rdbms.RDBMSPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage.eNS_URI, simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(simpleuml2rdbms.uml.UMLPackage.eNS_URI, simpleuml2rdbms.uml.UMLPackage.eINSTANCE);
		URI modelsProjectURI = getModelsURI("SimpleUML2RDBMS");
		URI transformURI = modelsProjectURI.appendSegment("SimpleUML2RDBMS.qvti");
		URI genModelURI = modelsProjectURI.appendSegment("SimpleUML2RDBMS.genmodel");
		URI inputModelURI = modelsProjectURI.appendSegment("SimpleUMLPeople.xmi");
		URI referenceModelURI = modelsProjectURI.appendSegment("SimpleRDBMSPeopleValidate.xmi");
		//
		URI outputModelURI = getTestURI("SimpleRDBMSPeople.xmi");
		//
		MyQVT myQVT = createQVT();
		ImperativeTransformation iTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(iTransformation, false);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "uml", inputModelURI);
		myQVT.execute(tx);
		myQVT.saveOutput(tx, "rdbms", outputModelURI, referenceModelURI, SimpleRDBMSNormalizer.INSTANCE);
		myQVT.dispose();
		cleanup(simpleuml2rdbms.uml.UMLPackage.eNS_URI,
			simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage.eNS_URI,
			simpleuml2rdbms.rdbms.RDBMSPackage.eNS_URI);
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
		ImperativeTransformation iTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(iTransformation, false);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "tree", inputModelURI);
		myQVT.execute(tx);
		myQVT.saveOutput(tx, "talltree", outputModelURI, referenceModelURI, null);
		Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("Tree2TallTree-execution.graphml"));
		myQVT.dispose();
		cleanup(TreePackage.eNS_URI);
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
		ImperativeTransformation iTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(iTransformation, true);
		Transformer tx = myQVT.createTransformer(txClass);
		Resource inputResource = myQVT.loadInput(tx, "tree", inputModelURI);
		myQVT.execute(tx);
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
		cleanup(TreePackage.eNS_URI);
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
		ImperativeTransformation iTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(iTransformation, true);
		Transformer tx = myQVT.createTransformer(txClass);
		Resource inputResource = myQVT.loadInput(tx, "tree", inputModelURI);
		myQVT.execute(tx);
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
		cleanup("http://www.eclipse.org/qvt/examples/0.1/List2List",
			"http://www.eclipse.org/qvt/examples/0.1/Tree",
				"http://www.eclipse.org/qvt/examples/0.1/TallTree");
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
		ImperativeTransformation iTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(iTransformation, true);
		Transformer tx = myQVT.createTransformer(txClass);
		Resource inputResource = myQVT.loadInput(tx, "tree", inputModelURI);
		myQVT.execute(tx);
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
		cleanup(TreePackage.eNS_URI);
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
		myQVT.execute(tx);
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
		myQVT.execute(tx);
		myQVT.saveOutput(tx, "talltree", outputModelURI, referenceModelURI, null);
		myQVT.dispose();
	} */
}
