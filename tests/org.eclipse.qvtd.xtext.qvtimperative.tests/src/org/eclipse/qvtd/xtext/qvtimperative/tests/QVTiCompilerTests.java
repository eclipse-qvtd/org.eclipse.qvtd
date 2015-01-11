/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerResourceSetAdapter;
import org.eclipse.ocl.pivot.internal.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.validation.ComposedEValidator;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.CS2ASResourceAdapter;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
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
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;

import test.hls.HLSTree.HLSTreePackage;
import test.hsv.HSVTree.HSVTreePackage;
import test.middle.HSV2HLS.HSV2HLSPackage;
import test.simplerdbms.SimplerdbmsPackage;
import test.simpleuml.SimpleumlPackage;
import test.umltordbms.UmltordbmsPackage;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiCompilerTests extends LoadTestCase
{
	@SuppressWarnings("unused")private static ComposedEValidator makeSureRequiredBundleIsLoaded = null;

	public class MyTransformationEvaluator extends AbstractTransformationEvaluator
	{
		public MyTransformationEvaluator(@NonNull Constructor<? extends TransformationExecutor> txConstructor)
				throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
			super(ClassUtil.nonNullState(metamodelManager.getCompleteEnvironment()), txConstructor);
		}
	}
	
	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		super.setUp();
		QVTimperativeStandaloneSetup.doSetup();
	}

	public Resource doLoad_ConcreteWithOCL(@NonNull URI inputURI) throws IOException {
		String inputName = inputURI.lastSegment();
		String cstName = inputName + ".xmi";
		String pivotName = inputName + ".pivot";
		URI cstURI = getProjectFileURI(cstName);
		URI pivotURI = getProjectFileURI(pivotName);
		CS2ASResourceAdapter adapter = null;
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.getResource(inputURI, true);
		assert xtextResource != null;
		assertNoResourceErrors("Load failed", xtextResource);
		adapter = xtextResource.getCS2ASAdapter(null);
		Resource pivotResource = adapter.getASResource(xtextResource);
//		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		saveAsXMI(xtextResource, cstURI);
		pivotResource.setURI(pivotURI);
	    
	    CompleteOCLStandaloneSetup.doSetup();
	    URI oclURI = ClassUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true));
//		CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metamodelManager);
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, metamodelManager);
//		CompleteOCLEObjectValidator completeOCLEObjectValidator3 = new CompleteOCLEObjectValidator(QVTbasePackage.eINSTANCE, oclURI, metamodelManager);
//		completeOCLEObjectValidator1.initialize();
		completeOCLEObjectValidator2.initialize();
//		completeOCLEObjectValidator3.initialize();
		PivotEObjectValidator.install(ClassUtil.nonNullState(pivotResource.getResourceSet()), ClassUtil.nonNullState(metamodelManager));
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTbasePackage.eINSTANCE));
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE));
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE));
	    
		assertNoValidationErrors("Pivot validation errors", pivotResource.getContents().get(0));
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
	    pivotResource.save(options);
	    
		return pivotResource;
	}

	protected @NonNull Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = new HashMap<Object, Object>();
        saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
        saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
        saveOptions.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
        saveOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		return saveOptions;
	}

	public void testCG_HSV2HLS_qvti() throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		Registry packageRegistry = resourceSet.getPackageRegistry();
		packageRegistry.put(HSVTreePackage.eNS_URI, HSVTreePackage.eINSTANCE);
		packageRegistry.put(HSV2HLSPackage.eNS_URI, HSV2HLSPackage.eINSTANCE);
		packageRegistry.put(HLSTreePackage.eNS_URI, HLSTreePackage.eINSTANCE);
		URI transformURI = getProjectFileURI("HSV2HLS/HSV2HLS.qvti");
		URI genModelURI = getProjectFileURI("HSV2HLS/HSV2HLS.genmodel");
		URI inputModelURI = getProjectFileURI("HSV2HLS/HSVNode.xmi");
		URI outputModelURI = getProjectFileURI("HSV2HLS/HLSNode.xmi");
		URI referenceModelURI = getProjectFileURI("HSV2HLS/HLSNodeValidate.xmi");
		Transformation asTransformation = loadTransformation(transformURI, genModelURI);
		assert asTransformation != null;
		Class<? extends TransformationExecutor> txClass = generateCode(asTransformation, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");
		Constructor<? extends TransformationExecutor> txConstructor = ClassUtil.nonNullState(txClass.getConstructor(Evaluator.class));
		TransformationEvaluator evaluator = new MyTransformationEvaluator(txConstructor);
		TransformationExecutor tx = evaluator.getExecutor();
		Resource inputResource = resourceSet.getResource(inputModelURI, true);
		tx.addRootObjects("hsv", ClassUtil.nonNullState(inputResource.getContents()));
		tx.run();
		Resource outputResource = resourceSet.createResource(outputModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("hls"));
		outputResource.save(getSaveOptions());
		Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
		assert referenceResource != null;
        assertSameModel(referenceResource, outputResource);
	}
	
	public void testCG_ClassesCS2AS_qvti() throws Exception {
		URI transformURI = getProjectFileURI("ClassesCS2AS/ClassesCS2AS.qvti");
		URI genModelURI = getProjectFileURI("ClassesCS2AS/ClassesCS2AS.genmodel");
		Transformation asTransformation = loadTransformation(transformURI, genModelURI);
		assert asTransformation != null;
		generateCode(asTransformation, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");
	}

	public void testCG_ClassToRDBMS_qvti() throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		Registry packageRegistry = resourceSet.getPackageRegistry();
		packageRegistry.put(SimpleumlPackage.eNS_URI, SimpleumlPackage.eINSTANCE);
		packageRegistry.put(UmltordbmsPackage.eNS_URI, UmltordbmsPackage.eINSTANCE);
		packageRegistry.put(SimplerdbmsPackage.eNS_URI, SimplerdbmsPackage.eINSTANCE);
		URI transformURI = getProjectFileURI("ClassToRDBMS/ClassToRDBMSSchedule.qvti");
		URI genModelURI = getProjectFileURI("ClassToRDBMS/UMLtoRDBMS.genmodel");
		URI inputModelURI = getProjectFileURI("ClassToRDBMS/SimpleUMLPeople.xmi");
		URI outputModelURI = getProjectFileURI("ClassToRDBMS/SimpleRDBMSPeople.xmi");
		URI referenceModelURI = getProjectFileURI("ClassToRDBMS/SimpleRDBMSPeopleValidate.xmi");
		Transformation asTransformation = loadTransformation(transformURI, genModelURI);
		assert asTransformation != null;
		Class<? extends TransformationExecutor> txClass = generateCode(asTransformation, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");
		Constructor<? extends TransformationExecutor> txConstructor = ClassUtil.nonNullState(txClass.getConstructor(Evaluator.class));
		TransformationEvaluator evaluator = new MyTransformationEvaluator(txConstructor);
		TransformationExecutor tx = evaluator.getExecutor();
		Resource inputResource = resourceSet.getResource(inputModelURI, true);
		tx.addRootObjects("uml", ClassUtil.nonNullState(inputResource.getContents()));
		tx.run();
		Resource outputResource = resourceSet.createResource(outputModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("rdbms"));
		outputResource.save(getSaveOptions());
		Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
		assert referenceResource != null;
        assertSameModel(referenceResource, outputResource);
	}

	protected Class<? extends TransformationExecutor> generateCode(@NonNull Transformation asTransformation, @Nullable String savePath) throws Exception {
		QVTiCodeGenerator cg = new QVTiCodeGenerator(ClassUtil.nonNullState(metamodelManager), asTransformation);
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

	protected Transformation loadTransformation(@NonNull URI transformURI, @NonNull URI genModelURI) throws Exception {
		OCLstdlibTables.LIBRARY.getClass();		// Ensure coherent initialization
		metamodelManager = new PivotEnvironmentFactory(null, null).getMetamodelManager();
		resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
		metamodelManager.configureLoadFirstStrategy();
		Resource genResource = resourceSet.getResource(genModelURI, true);
		for (EObject eObject : genResource.getContents()) {
			if (eObject instanceof GenModel) {
				GenModel genModel = (GenModel)eObject;
				genModel.reconcile();
				metamodelManager.addGenModel(genModel);
			}
		}
		MetamodelManagerResourceSetAdapter.getAdapter(ClassUtil.nonNullState(resourceSet), metamodelManager);
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
		return null;
	}
}
