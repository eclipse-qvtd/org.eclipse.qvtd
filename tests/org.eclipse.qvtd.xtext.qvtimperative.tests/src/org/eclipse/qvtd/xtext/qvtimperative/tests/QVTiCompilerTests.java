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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.library.executor.ExecutorManager;
import org.eclipse.ocl.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.evaluation.AbstractTransformation;
import org.eclipse.ocl.pivot.evaluation.DomainEvaluator;
import org.eclipse.ocl.pivot.evaluation.DomainModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.validation.ComposedEValidator;
import org.eclipse.ocl.pivot.validation.PivotEObjectValidator;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.CS2ASResourceAdapter;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
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
	
	private static final class TxEvaluator extends ExecutorManager {
		private TxEvaluator(@NonNull CompleteEnvironment environment) {
			super(environment);
		}

		@NonNull
		public DomainEvaluator createNestedEvaluator() {
			throw new UnsupportedOperationException();
		}

		@NonNull
		public IdResolver getIdResolver() {
			return ((CompleteEnvironmentInternal)environment).getMetaModelManager().getIdResolver();
		}

		@NonNull
		public DomainModelManager getModelManager() {
			throw new UnsupportedOperationException();
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
//		CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metaModelManager);
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, metaModelManager);
//		CompleteOCLEObjectValidator completeOCLEObjectValidator3 = new CompleteOCLEObjectValidator(QVTbasePackage.eINSTANCE, oclURI, metaModelManager);
//		completeOCLEObjectValidator1.initialize();
		completeOCLEObjectValidator2.initialize();
//		completeOCLEObjectValidator3.initialize();
		PivotEObjectValidator.install(ClassUtil.nonNullState(pivotResource.getResourceSet()), ClassUtil.nonNullState(metaModelManager));
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTbasePackage.eINSTANCE));
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE));
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE));
	    
		assertNoValidationErrors("Pivot validation errors", pivotResource.getContents().get(0));
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
	    pivotResource.save(options);
	    
		return pivotResource;
	}

	public void testCG_HSV2HLS_qvti() throws Exception {
		URI transformURI = getProjectFileURI("HSV2HLS/HSV2HLS.qvti");
		URI genModelURI = getProjectFileURI("HSV2HLS/HSV2HLS.genmodel");
		URI inputModelURI = getProjectFileURI("HSV2HLS/HSVNode.xmi");
		URI outputModelURI = getProjectFileURI("HSV2HLS/HLSNode.xmi");
		URI referenceModelURI = getProjectFileURI("HSV2HLS/HLSNodeValidate.xmi");
		EPackage.Registry.INSTANCE.put(HSVTreePackage.eNS_URI, HSVTreePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(HSV2HLSPackage.eNS_URI, HSV2HLSPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(HLSTreePackage.eNS_URI, HLSTreePackage.eINSTANCE);
		Class<? extends AbstractTransformation> txClass = generateCode(transformURI, genModelURI, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");
		
		Constructor<? extends AbstractTransformation> txConstructor = txClass.getConstructor(DomainEvaluator.class);
		DomainEvaluator evaluator = new TxEvaluator(ClassUtil.nonNullState(metaModelManager.getCompleteEnvironment()));
		AbstractTransformation tx = txConstructor.newInstance(evaluator);
		Resource inputResource = resourceSet.getResource(inputModelURI, true);
		tx.addRootObjects("hsv", ClassUtil.nonNullState(inputResource.getContents()));
		tx.run();
		Resource outputResource = resourceSet.createResource(outputModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("hls"));
		outputResource.save(null);
		Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
		assert referenceResource != null;
        assertSameModel(referenceResource, outputResource);
	}
	
	public void testCG_ClassesCS2AS_qvti() throws Exception {
		URI transformURI = getProjectFileURI("ClassesCS2AS/ClassesCS2AS.qvti");
		URI genModelURI = getProjectFileURI("ClassesCS2AS/ClassesCS2AS.genmodel");
		generateCode(transformURI, genModelURI, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");		
	}

	public void testCG_ClassToRDBMS_qvti() throws Exception {
		URI transformURI = getProjectFileURI("ClassToRDBMS/ClassToRDBMSSchedule.qvti");
		URI genModelURI = getProjectFileURI("ClassToRDBMS/UMLtoRDBMS.genmodel");
		URI inputModelURI = getProjectFileURI("ClassToRDBMS/SimpleUMLPeople.xmi");
		URI outputModelURI = getProjectFileURI("ClassToRDBMS/SimpleRDBMSPeople.xmi");
		URI referenceModelURI = getProjectFileURI("ClassToRDBMS/SimpleRDBMSPeopleValidate.xmi");
		EPackage.Registry.INSTANCE.put(SimpleumlPackage.eNS_URI, SimpleumlPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(UmltordbmsPackage.eNS_URI, UmltordbmsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(SimplerdbmsPackage.eNS_URI, SimplerdbmsPackage.eINSTANCE);
		Class<? extends AbstractTransformation> txClass = generateCode(transformURI, genModelURI, "../org.eclipse.qvtd.xtext.qvtimperative.tests/src-gen/");
		
		Constructor<? extends AbstractTransformation> txConstructor = txClass.getConstructor(DomainEvaluator.class);
		DomainEvaluator evaluator = new TxEvaluator(ClassUtil.nonNullState(metaModelManager.getCompleteEnvironment()));
		AbstractTransformation tx = txConstructor.newInstance(evaluator);
		Resource inputResource = resourceSet.getResource(inputModelURI, true);
		tx.addRootObjects("uml", ClassUtil.nonNullState(inputResource.getContents()));
		tx.run();
		Resource outputResource = resourceSet.createResource(outputModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("rdbms"));
		outputResource.save(null);
		Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
		assert referenceResource != null;
        assertSameModel(referenceResource, outputResource);
	}

	protected Class<? extends AbstractTransformation> generateCode(@NonNull URI transformURI, @NonNull URI genModelURI, @Nullable String savePath) throws Exception {
		OCLstdlibTables.LIBRARY.getClass();		// Ensure coherent initialization
		metaModelManager = new MetaModelManager();
		resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
		metaModelManager.configureLoadFirstStrategy();
		Resource genResource = resourceSet.getResource(genModelURI, true);
		for (EObject eObject : genResource.getContents()) {
			if (eObject instanceof GenModel) {
				metaModelManager.addGenModel((GenModel)eObject);
			}
		}
		MetaModelManagerResourceSetAdapter.getAdapter(ClassUtil.nonNullState(resourceSet), metaModelManager);
		Resource resource = doLoad_ConcreteWithOCL(transformURI);
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof ImperativeModel) {
				for (org.eclipse.ocl.pivot.Package asPackage : ((ImperativeModel)eObject).getOwnedPackages()) {
					for (org.eclipse.ocl.pivot.Class asClass : asPackage.getOwnedClasses()) {
						if (asClass instanceof Transformation) {
							QVTiCodeGenerator cg = new QVTiCodeGenerator(ClassUtil.nonNullState(metaModelManager), (Transformation)asClass);
							QVTiCodeGenOptions options = cg.getOptions();
							options.setUseNullAnnotations(true);
							options.setPackagePrefix("cg");
							cg.generateClassFile();
							if (savePath != null) {
								cg.saveSourceFile(savePath);
							}
							Class<? extends AbstractTransformation> txClass = compileTransformation(cg);
							return txClass;
						}
					}
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Class<? extends AbstractTransformation> compileTransformation(@NonNull QVTiCodeGenerator cg) throws Exception {
		String qualifiedName = cg.getQualifiedName();
		String javaCodeSource = cg.generateClassFile();
		try {
			Class<?> txClass = OCL2JavaFileObject.loadClass(qualifiedName, javaCodeSource);
			return (Class<? extends AbstractTransformation>) txClass;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
}
