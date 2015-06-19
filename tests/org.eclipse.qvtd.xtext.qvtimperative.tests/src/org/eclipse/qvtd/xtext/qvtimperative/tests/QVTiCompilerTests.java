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

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.evaluation.Executor;
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
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationEvaluator;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationEvaluator;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationExecutor;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtimperative.tests.ManualUML2RDBMS.ManualRDBMSNormalizer;
import org.eclipse.qvtd.xtext.qvtimperative.tests.SimpleUML2RDBMS.SimpleRDBMSNormalizer;

import test.hls.HLSTree.HLSTreePackage;
import test.hsv.HSVTree.HSVTreePackage;
import test.middle.HSV2HLS.HSV2HLSPackage;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiCompilerTests extends LoadTestCase
{
	@SuppressWarnings("unused")private static ComposedEValidator makeSureRequiredBundleIsLoaded = null;
	
	protected static class MyQVT extends OCLInternal
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}

		public @NonNull TxEvaluator createEvaluator(Constructor<? extends TransformationExecutor> txConstructor) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
			return new TxEvaluator(getCompleteEnvironment(), txConstructor);
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}
	}
	
	protected static class MyQVTiEnvironmentFactory extends QVTiEnvironmentFactory
	{
		public MyQVTiEnvironmentFactory(@NonNull ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
			super(projectMap, externalResourceSet);
	    	setEvaluationTracingEnabled(true);
		}
	}
	
	protected static class TxEvaluator extends AbstractTransformationEvaluator {
		private TxEvaluator(@NonNull CompleteEnvironment environment, Constructor<? extends TransformationExecutor> txConstructor) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
			super(environment, txConstructor);
		}
	}

	protected @NonNull MyQVT createQVT() {
		return new MyQVT(new MyQVTiEnvironmentFactory(getProjectMap(), null));
	}

	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTiTestUtil.doQVTimperativeSetup();
		super.setUp();
	}

	public Resource doLoad_ConcreteWithOCL(@NonNull MyQVT myQVT, @NonNull URI inputURI) throws IOException {
		String inputName = inputURI.lastSegment();
		String cstName = inputName + ".xmi";
		String pivotName = inputName + ".pivot";
		URI cstURI = getProjectFileURI(cstName);
		URI pivotURI = getProjectFileURI(pivotName);
		BaseCSResource xtextResource = (BaseCSResource) myQVT.getResourceSet().getResource(inputURI, true);
		assert xtextResource != null;
		assertNoResourceErrors("Load failed", xtextResource);
		ASResource asResource = xtextResource.getASResource();
//		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		saveAsXMI(xtextResource, cstURI);
		asResource.setURI(pivotURI);
	    
	    TestUtil.doCompleteOCLSetup();
	    URI oclURI = ClassUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true));
//		CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metamodelManager);
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, myQVT.getEnvironmentFactory());
//		CompleteOCLEObjectValidator completeOCLEObjectValidator3 = new CompleteOCLEObjectValidator(QVTbasePackage.eINSTANCE, oclURI, metamodelManager);
//		completeOCLEObjectValidator1.initialize();
		completeOCLEObjectValidator2.initialize();
//		completeOCLEObjectValidator3.initialize();
		PivotEObjectValidator.install(ClassUtil.nonNullState(asResource.getResourceSet()), myQVT.getEnvironmentFactory());
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTbasePackage.eINSTANCE), null);
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), null);
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), null);
	    
		assertNoValidationErrors("Pivot validation errors", asResource.getContents().get(0));
		asResource.save(getSaveOptions());
		return asResource;
	}

	protected @NonNull Map<Object, Object> getSaveOptions() {		
		return TestsXMLUtil.defaultSavingOptions;
	}

	public void testCG_HSV2HLS_qvti() throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		Registry packageRegistry = resourceSet.getPackageRegistry();
		packageRegistry.put(HSVTreePackage.eNS_URI, HSVTreePackage.eINSTANCE);
		packageRegistry.put(HSV2HLSPackage.eNS_URI, HSV2HLSPackage.eINSTANCE);
		packageRegistry.put(HLSTreePackage.eNS_URI, HLSTreePackage.eINSTANCE);
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("HSV2HLS/HSV2HLS.qvti");
		URI genModelURI = getProjectFileURI("HSV2HLS/HSV2HLS.genmodel");
		URI inputModelURI = getProjectFileURI("HSV2HLS/HSVNode.xmi");
		URI outputModelURI = getProjectFileURI("HSV2HLS/HLSNode.xmi");
		URI referenceModelURI = getProjectFileURI("HSV2HLS/HLSNodeValidate.xmi");
		Transformation asTransformation = loadTransformation(myQVT, transformURI, genModelURI);
		assert asTransformation != null;
		Class<? extends TransformationExecutor> txClass = generateCode(myQVT, asTransformation, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");
		Constructor<? extends TransformationExecutor> txConstructor = ClassUtil.nonNullState(txClass.getConstructor(Executor.class));
		TxEvaluator executor = myQVT.createEvaluator(txConstructor);
		TransformationExecutor tx = executor.getTransformationExecutor();
		Resource inputResource = resourceSet.getResource(inputModelURI, true);
		tx.addRootObjects("hsv", ClassUtil.nonNullState(inputResource.getContents()));
		tx.run();
		Resource outputResource = resourceSet.createResource(outputModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("hls"));
		outputResource.save(getSaveOptions());
		Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
		assert referenceResource != null;
        assertSameModel(referenceResource, outputResource);
        myQVT.dispose();
	}
	
	public void testCG_ClassesCS2AS_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("ClassesCS2AS/ClassesCS2AS.qvti");
		URI genModelURI = getProjectFileURI("ClassesCS2AS/ClassesCS2AS.genmodel");
		Transformation asTransformation = loadTransformation(myQVT, transformURI, genModelURI);
		assert asTransformation != null;
		generateCode(myQVT, asTransformation, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");		
        myQVT.dispose();
	}
	
	public void testCG_ClassesCS2AS_bug459225() throws Exception {
	    TestUtil.doCompleteOCLSetup();
		MyQVT myQVT = createQVT();
		ResourceSet resourceSet = new ResourceSetImpl();
		Registry packageRegistry = resourceSet.getPackageRegistry();
		packageRegistry.put(HSVTreePackage.eNS_URI, HSVTreePackage.eINSTANCE);
		packageRegistry.put(HSV2HLSPackage.eNS_URI, HSV2HLSPackage.eINSTANCE);
		packageRegistry.put(HLSTreePackage.eNS_URI, HLSTreePackage.eINSTANCE);
		
		URI transformURI = getProjectFileURI("ClassesCS2AS/bug459225/ClassesCS2AS.qvti");
		URI genModelURI = getProjectFileURI("ClassesCS2AS/ClassesCS2AS.genmodel");
		URI inputModelURI = getProjectFileURI("ClassesCS2AS/bug459225/example_input.xmi");
		URI outputModelURI = getProjectFileURI("ClassesCS2AS/bug459225/example_output.xmi");
		URI referenceModelURI = getProjectFileURI("ClassesCS2AS/bug459225/example_output_ref.xmi");
		Transformation asTransformation = loadTransformation(myQVT, transformURI, genModelURI);
		assert asTransformation != null;
		Class<? extends TransformationExecutor> txClass = generateCode(myQVT, asTransformation, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");	
		
		Constructor<? extends TransformationExecutor> txConstructor = ClassUtil.nonNullState(txClass.getConstructor(Executor.class));
		TxEvaluator executor = myQVT.createEvaluator(txConstructor);
		TransformationExecutor tx = executor.getTransformationExecutor();
		Resource inputResource = resourceSet.getResource(inputModelURI, true);
		tx.addRootObjects("leftCS", ClassUtil.nonNullState(inputResource.getContents()));
		tx.run();
		Resource outputResource = resourceSet.createResource(outputModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("rightAS"));
		outputResource.save(getSaveOptions());
		Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
		assert referenceResource != null;
		assertSameModel(referenceResource, outputResource);
		myQVT.dispose();
	}

	public void testCG_ManualUML2RDBMS_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		ResourceSet resourceSet = myQVT.getResourceSet();
//		Resource umlResource = resourceSet.getResource(URI.createURI(manualuml2rdbms.uml.UMLPackage.eNS_URI, false), false);
//		Resource rdbmsResource = resourceSet.getResource(URI.createURI(manualuml2rdbms.rdbms.RDBMSPackage.eNS_URI, false), false);
//		Resource uml2rdbmsResource = resourceSet.getResource(URI.createURI(manualuml2rdbms.uml2rdbms.UML2RDBMSPackage.eNS_URI, false), false);
		URI transformURI = getProjectFileURI("ManualUML2RDBMS/ManualUML2RDBMS.qvti");
		URI genModelURI = getProjectFileURI("ManualUML2RDBMS/ManualUML2RDBMS.genmodel");
		URI inputModelURI = getProjectFileURI("ManualUML2RDBMS/ManualUMLPeople.xmi");
		URI outputModelURI = getProjectFileURI("ManualUML2RDBMS/ManualRDBMSPeople.xmi");
		URI referenceModelURI = getProjectFileURI("ManualUML2RDBMS/ManualRDBMSPeopleValidate.xmi");
		Transformation asTransformation = loadTransformation(myQVT, transformURI, genModelURI);
		assert asTransformation != null;
		Class<? extends TransformationExecutor> txClass = generateCode(myQVT, asTransformation, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");
		Constructor<? extends TransformationExecutor> txConstructor = ClassUtil.nonNullState(txClass.getConstructor(Executor.class));
		TransformationEvaluator executor = myQVT.createEvaluator(txConstructor);
		TransformationExecutor tx = executor.getTransformationExecutor();
		Resource inputResource = resourceSet.getResource(inputModelURI, true);
		tx.addRootObjects("uml", ClassUtil.nonNullState(inputResource.getContents()));
		tx.run();
		Resource outputResource = resourceSet.createResource(outputModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("rdbms"));
		outputResource.save(getSaveOptions());
		Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
		assert referenceResource != null;
		ManualRDBMSNormalizer.INSTANCE.normalize(referenceResource);
		ManualRDBMSNormalizer.INSTANCE.normalize(outputResource);
        assertSameModel(referenceResource, outputResource);
        myQVT.dispose();
	}

	public void testCG_SimpleUML2RDBMS_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		ResourceSet resourceSet = myQVT.getResourceSet();
//		Resource umlResource = resourceSet.getResource(URI.createURI(manualuml2rdbms.uml.UMLPackage.eNS_URI, false), false);
//		Resource rdbmsResource = resourceSet.getResource(URI.createURI(manualuml2rdbms.rdbms.RDBMSPackage.eNS_URI, false), false);
//		Resource uml2rdbmsResource = resourceSet.getResource(URI.createURI(manualuml2rdbms.uml2rdbms.UML2RDBMSPackage.eNS_URI, false), false);
		URI transformURI = getProjectFileURI("SimpleUML2RDBMS/SimpleUML2RDBMS.qvti");
		URI genModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleUML2RDBMS.genmodel");
		URI inputModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleUMLPeople.xmi");
		URI outputModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleRDBMSPeople.xmi");
		URI referenceModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleRDBMSPeopleValidate.xmi");
		Transformation asTransformation = loadTransformation(myQVT, transformURI, genModelURI);
		assert asTransformation != null;
		Class<? extends TransformationExecutor> txClass = generateCode(myQVT, asTransformation, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");
		Constructor<? extends TransformationExecutor> txConstructor = ClassUtil.nonNullState(txClass.getConstructor(Executor.class));
		TransformationEvaluator executor = myQVT.createEvaluator(txConstructor);
		TransformationExecutor tx = executor.getTransformationExecutor();
		Resource inputResource = resourceSet.getResource(inputModelURI, true);
		tx.addRootObjects("uml", ClassUtil.nonNullState(inputResource.getContents()));
		tx.run();
		Resource outputResource = resourceSet.createResource(outputModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("rdbms"));
		outputResource.save(getSaveOptions());
		Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
		assert referenceResource != null;
		SimpleRDBMSNormalizer.INSTANCE.normalize(referenceResource);
		SimpleRDBMSNormalizer.INSTANCE.normalize(outputResource);
        assertSameModel(referenceResource, outputResource);
        myQVT.dispose();
	}

	/**
	 * FIXME CSE places varaible too early.
	 * @throws Exception
	 *
	public void testCG_SimpleUML2RDBMS_qvti() throws Exception {
    	MyQVT myQVT = createQVT();
		ResourceSet resourceSet = myQVT.getResourceSet();
//		Resource umlResource = resourceSet.getResource(URI.createURI(manualuml2rdbms.uml.UMLPackage.eNS_URI, false), false);
//		Resource rdbmsResource = resourceSet.getResource(URI.createURI(manualuml2rdbms.rdbms.RDBMSPackage.eNS_URI, false), false);
//		Resource uml2rdbmsResource = resourceSet.getResource(URI.createURI(manualuml2rdbms.uml2rdbms.UML2RDBMSPackage.eNS_URI, false), false);
		URI transformURI = getProjectFileURI("SimpleUML2RDBMS/SimpleUML2RDBMS.qvti");
		URI genModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleUML2RDBMS.genmodel");
		URI inputModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleUMLPeople.xmi");
		URI outputModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleRDBMSPeople.xmi");
		URI referenceModelURI = getProjectFileURI("SimpleUML2RDBMS/SimpleRDBMSPeopleValidate.xmi");
		Transformation asTransformation = loadTransformation(myQVT, transformURI, genModelURI);
		assert asTransformation != null;
		Class<? extends TransformationExecutor> txClass = generateCode(myQVT, asTransformation, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");
		Constructor<? extends TransformationExecutor> txConstructor = ClassUtil.nonNullState(txClass.getConstructor(Evaluator.class));
		TransformationEvaluator executor = myQVT.createEvaluator(txConstructor);
		TransformationExecutor tx = executor.getTransformationExecutor();
		Resource inputResource = resourceSet.getResource(inputModelURI, true);
		tx.addRootObjects("uml", ClassUtil.nonNullState(inputResource.getContents()));
		tx.run();
		Resource outputResource = resourceSet.createResource(outputModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("rdbms"));
		outputResource.save(getSaveOptions());
		Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
		assert referenceResource != null;
		SimpleRDBMSNormalizer.INSTANCE.normalize(referenceResource);
		SimpleRDBMSNormalizer.INSTANCE.normalize(outputResource);
        assertSameModel(referenceResource, outputResource);
        myQVT.dispose();
	} */
	
	@SuppressWarnings("unchecked")
	public Class<? extends TransformationExecutor> compileTransformation(@NonNull QVTiCodeGenerator cg) throws Exception {
		String qualifiedName = cg.getQualifiedName();
		String javaCodeSource = cg.generateClassFile();
		try {
			Class<?> txClass = OCL2JavaFileObject.loadClass(qualifiedName, javaCodeSource);
			return (Class<? extends TransformationExecutor>) txClass;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	protected Class<? extends TransformationExecutor> generateCode(@NonNull MyQVT myQVT, @NonNull Transformation asTransformation, @Nullable String savePath) throws Exception {
		QVTiCodeGenerator cg = new QVTiCodeGenerator(myQVT.getEnvironmentFactory(), asTransformation);
		QVTiCodeGenOptions options = cg.getOptions();
		options.setUseNullAnnotations(true);
		options.setPackagePrefix("cg");
		cg.generateClassFile();
		if (savePath != null) {
			cg.saveSourceFile(savePath);
		}
		Class<? extends TransformationExecutor> txClass = compileTransformation(cg);
		return txClass;
	}

	protected Transformation loadTransformation(@NonNull MyQVT myQVT, @NonNull URI transformURI, @NonNull URI genModelURI) throws Exception {
		OCLstdlibTables.LIBRARY.getClass();		// Ensure coherent initialization
		ResourceSet resourceSet = myQVT.getResourceSet();
		resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
		MetamodelManagerInternal metamodelManager = myQVT.getMetamodelManager();
		myQVT.getEnvironmentFactory().configureLoadFirstStrategy();
		Resource genResource = resourceSet.getResource(genModelURI, true);
		for (EObject eObject : genResource.getContents()) {
			if (eObject instanceof GenModel) {
				GenModel genModel = (GenModel)eObject;
				genModel.reconcile();
				metamodelManager.addGenModel(genModel);
			}
		}
		Resource resource = doLoad_ConcreteWithOCL(myQVT, transformURI);
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
		return null;
	}
}
