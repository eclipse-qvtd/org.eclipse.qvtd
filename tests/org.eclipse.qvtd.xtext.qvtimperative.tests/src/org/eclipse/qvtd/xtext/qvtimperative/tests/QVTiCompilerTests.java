/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
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
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.validation.ComposedEValidator;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtimperative.tests.ManualUML2RDBMS.ManualRDBMSNormalizer;
import org.eclipse.qvtd.xtext.qvtimperative.tests.SimpleUML2RDBMS.SimpleRDBMSNormalizer;

import junit.framework.TestCase;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiCompilerTests extends LoadTestCase
{
	@SuppressWarnings("unused")private static ComposedEValidator makeSureRequiredBundleIsLoaded = null;

	public static @NonNull Map<Object, Object> getSaveOptions() {		
		return TestsXMLUtil.defaultSavingOptions;
	}
	
	protected static class MyQVT extends OCLInternal
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}
		
		private Class<? extends Transformer> compileTransformation(@NonNull File explicitClassPath, @NonNull QVTiCodeGenerator cg) throws Exception {
			String qualifiedClassName = cg.getQualifiedName();
			String javaCodeSource = cg.generateClassFile();
			String string = explicitClassPath.toString();
			assert string != null;
			OCL2JavaFileObject.saveClass(string, qualifiedClassName, javaCodeSource);	
			@SuppressWarnings("unchecked")
			Class<? extends Transformer> txClass = (Class<? extends Transformer>) OCL2JavaFileObject.loadExplicitClass(explicitClassPath, qualifiedClassName);
			return txClass;
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
			options.setPackagePrefix("cg_qvtimperative_tests");
			cg.generateClassFile();
			cg.saveSourceFile("../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");
			Class<? extends Transformer> txClass = compileTransformation(new File("../org.eclipse.qvtd.xtext.qvtimperative.tests/bin"), cg);
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
	
	protected @NonNull MyQVT createQVT() {
		return new MyQVT(new MyQVTiEnvironmentFactory(getProjectMap(), null));
	}
	
//	protected @NonNull URI getProjectFileURI(String classRelativeName) {
//		assert classRelativeName != null;
//		return TestUtil.getFileURI(QVTiCompilerTests.class, classRelativeName);
//	}

	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
	    TestUtil.doCompleteOCLSetup();
		QVTiTestUtil.doQVTimperativeSetup();
		super.setUp();
	}

	public void testCG_HSV2HLS_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("HSV2HLS/HSV2HLS.qvti");
		URI genModelURI = getProjectFileURI("HSV2HLS/HSV2HLS.genmodel");
		URI inputModelURI = getProjectFileURI("HSV2HLS/HSVNode.xmi");
		URI outputModelURI = getProjectFileURI("HSV2HLS/HLSNode.xmi");
		URI referenceModelURI = getProjectFileURI("HSV2HLS/HLSNodeValidate.xmi");
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "hsv", inputModelURI);
		tx.run();
		myQVT.saveOutput(tx, "hls", outputModelURI, referenceModelURI, null);
        myQVT.dispose();
	}
	
	public void testCG_ClassesCS2AS_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("ClassesCS2AS/ClassesCS2AS.qvti");
		URI genModelURI = getProjectFileURI("ClassesCS2AS/ClassesCS2AS.genmodel");
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		myQVT.generateCode(asTransformation);		
        myQVT.dispose();
	}
	
	public void testCG_ClassesCS2AS_bug459225() throws Exception {
		MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("ClassesCS2AS/bug459225/ClassesCS2AS.qvti");
		URI genModelURI = getProjectFileURI("ClassesCS2AS/ClassesCS2AS.genmodel");
		URI inputModelURI = getProjectFileURI("ClassesCS2AS/bug459225/example_input.xmi");
		URI outputModelURI = getProjectFileURI("ClassesCS2AS/bug459225/example_output.xmi");
		URI referenceModelURI = getProjectFileURI("ClassesCS2AS/bug459225/example_output_ref.xmi");
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation);	
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "leftCS", inputModelURI);
		tx.run();
		myQVT.saveOutput(tx, "rightAS", outputModelURI, referenceModelURI, null);
		myQVT.dispose();
	}

	public void testCG_ManualUML2RDBMS_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("ManualUML2RDBMS/ManualUML2RDBMS.qvti");
		URI genModelURI = getProjectFileURI("ManualUML2RDBMS/ManualUML2RDBMS.genmodel");
		URI inputModelURI = getProjectFileURI("ManualUML2RDBMS/ManualUMLPeople.xmi");
		URI outputModelURI = getProjectFileURI("ManualUML2RDBMS/ManualRDBMSPeople.xmi");
		URI referenceModelURI = getProjectFileURI("ManualUML2RDBMS/ManualRDBMSPeopleValidate.xmi");
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "uml", inputModelURI);
		tx.run();
		myQVT.saveOutput(tx, "rdbms", outputModelURI, referenceModelURI, ManualRDBMSNormalizer.INSTANCE);
        myQVT.dispose();
	}

	public void testCG_SimpleUML2RDBMS_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("SimpleUML2RDBMS/SimpleUML2RDBMS.qvti");
		URI genModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleUML2RDBMS.genmodel");
		URI inputModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleUMLPeople.xmi");
		URI outputModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleRDBMSPeople.xmi");
		URI referenceModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleRDBMSPeopleValidate.xmi");
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "uml", inputModelURI);
		tx.run();
		myQVT.saveOutput(tx, "rdbms", outputModelURI, referenceModelURI, SimpleRDBMSNormalizer.INSTANCE);
        myQVT.dispose();
	}

	public void testCG_Tree2TallTree_qvti() throws Exception {
//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT();
		URI genModelURI = getProjectFileURI("Tree2TallTree/Tree2TallTree.genmodel");
		URI transformURI = getProjectFileURI("Tree2TallTree/Tree2TallTree.qvti");
		URI inputModelURI = getProjectFileURI("Tree2TallTree/Tree.xmi");
		URI outputModelURI = getProjectFileURI("Tree2TallTree/Tree2TallTree.xmi");
		URI referenceModelURI = getProjectFileURI("Tree2TallTree/TallTreeValidate.xmi");
		Transformation asTransformation = myQVT.loadTransformation(transformURI, genModelURI);
		Class<? extends Transformer> txClass = myQVT.generateCode(asTransformation);
		Transformer tx = myQVT.createTransformer(txClass);
		myQVT.loadInput(tx, "tree", inputModelURI);
		tx.run();
		myQVT.saveOutput(tx, "talltree", outputModelURI, referenceModelURI, null);
        myQVT.dispose();
	}
}
