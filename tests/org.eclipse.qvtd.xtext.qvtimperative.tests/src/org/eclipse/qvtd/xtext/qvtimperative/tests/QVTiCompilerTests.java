/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
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
import org.eclipse.ocl.examples.codegen.dynamic.Java5Facade;
import org.eclipse.ocl.examples.domain.evaluation.AbstractTransformation;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorManager;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.validation.PivotEObjectValidator;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
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
	private static final class TxEvaluator extends ExecutorManager {
		private TxEvaluator(@NonNull MetaModelManager metaModelManager) {
			super(metaModelManager);
		}

		@NonNull
		public DomainEvaluator createNestedEvaluator() {
			throw new UnsupportedOperationException();
		}

		@NonNull
		public IdResolver getIdResolver() {
			return ((MetaModelManager)standardLibrary).getIdResolver();
		}

		@NonNull
		public DomainModelManager getModelManager() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	protected void setUp() throws Exception {
		EssentialOCLLinkingService.DEBUG_RETRY = true;
		super.setUp();
		QVTimperativeStandaloneSetup.doSetup();
	}

	protected Resource doLoad_Concrete(@NonNull URI inputURI) throws IOException {
		String inputName = inputURI.lastSegment();
		String cstName = inputName + ".xmi";
		String pivotName = inputName + ".pivot";
		URI cstURI = getProjectFileURI(cstName);
		URI pivotURI = getProjectFileURI(pivotName);
		CS2PivotResourceAdapter adapter = null;
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.getResource(inputURI, true);
		assert xtextResource != null;
		assertNoResourceErrors("Load failed", xtextResource);
		adapter = CS2PivotResourceAdapter.getAdapter(xtextResource, null);
		Resource pivotResource = adapter.getPivotResource(xtextResource);
//		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		saveAsXMI(xtextResource, cstURI);
		pivotResource.setURI(pivotURI);
	    
	    CompleteOCLStandaloneSetup.doSetup();
	    URI oclURI = DomainUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true));
//		CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metaModelManager);
		CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(DomainUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, metaModelManager);
//		CompleteOCLEObjectValidator completeOCLEObjectValidator3 = new CompleteOCLEObjectValidator(QVTbasePackage.eINSTANCE, oclURI, metaModelManager);
//		completeOCLEObjectValidator1.initialize();
		completeOCLEObjectValidator2.initialize();
//		completeOCLEObjectValidator3.initialize();
		PivotEObjectValidator.install(DomainUtil.nonNullState(pivotResource.getResourceSet()), DomainUtil.nonNullState(metaModelManager));
		PivotEObjectValidator.install(DomainUtil.nonNullState(QVTbasePackage.eINSTANCE));
		PivotEObjectValidator.install(DomainUtil.nonNullState(QVTcoreBasePackage.eINSTANCE));
		PivotEObjectValidator.install(DomainUtil.nonNullState(QVTimperativePackage.eINSTANCE));
	    
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
		EPackage.Registry.INSTANCE.put(HSVTreePackage.eNS_URI, HSVTreePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(HSV2HLSPackage.eNS_URI, HSV2HLSPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(HLSTreePackage.eNS_URI, HLSTreePackage.eINSTANCE);
		Class<? extends AbstractTransformation> txClass = generateCode(transformURI, genModelURI, "src-gen/");
		
		Constructor<? extends AbstractTransformation> txConstructor = txClass.getConstructor(DomainEvaluator.class);
		DomainEvaluator evaluator = new TxEvaluator(DomainUtil.nonNullState(metaModelManager));
		AbstractTransformation tx = txConstructor.newInstance(evaluator);
		Resource inputResource = resourceSet.getResource(inputModelURI, true);
		tx.addRootObjects("hsv", DomainUtil.nonNullState(inputResource.getContents()));
		tx.run();
		Resource outputResource = resourceSet.createResource(outputModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("hls"));
		outputResource.save(null);
	}

	public void testCG_ClassToRDBMS_qvti() throws Exception {
		URI transformURI = getProjectFileURI("ClassToRDBMS/ClassToRDBMSSchedule.qvti");
		URI genModelURI = getProjectFileURI("ClassToRDBMS/UMLToRDBMS.genmodel");
		URI inputModelURI = getProjectFileURI("ClassToRDBMS/SimpleUMLPeople.xmi");
		URI outputModelURI = getProjectFileURI("ClassToRDBMS/SimpleRDBMSPeople.xmi");
		EPackage.Registry.INSTANCE.put(SimpleumlPackage.eNS_URI, SimpleumlPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(UmltordbmsPackage.eNS_URI, UmltordbmsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(SimplerdbmsPackage.eNS_URI, SimplerdbmsPackage.eINSTANCE);
		Class<? extends AbstractTransformation> txClass = generateCode(transformURI, genModelURI, "src-gen/");
		
		Constructor<? extends AbstractTransformation> txConstructor = txClass.getConstructor(DomainEvaluator.class);
		DomainEvaluator evaluator = new TxEvaluator(DomainUtil.nonNullState(metaModelManager));
		AbstractTransformation tx = txConstructor.newInstance(evaluator);
		Resource inputResource = resourceSet.getResource(inputModelURI, true);
		tx.addRootObjects("uml", DomainUtil.nonNullState(inputResource.getContents()));
		tx.run();
		Resource outputResource = resourceSet.createResource(outputModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("rdbms"));
		outputResource.save(null);
	}

	protected Class<? extends AbstractTransformation> generateCode(@NonNull URI transformURI, @NonNull URI genModelURI, @Nullable String savePath) throws Exception {
		OCLstdlibTables.LIBRARY.getClass();		// Ensure coherent initialization
		metaModelManager = new MetaModelManager();
		resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
		Resource genResource = resourceSet.getResource(genModelURI, true);
		for (EObject eObject : genResource.getContents()) {
			if (eObject instanceof GenModel) {
				metaModelManager.addGenModel((GenModel)eObject);
			}
		}
		MetaModelManagerResourceSetAdapter.getAdapter(DomainUtil.nonNullState(resourceSet), metaModelManager);
		Resource resource = doLoad_Concrete(transformURI);
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof ImperativeModel) {
				for (org.eclipse.ocl.examples.pivot.Package pPackage : ((ImperativeModel)eObject).getNestedPackage()) {
					if (pPackage instanceof Transformation) {
						QVTiCodeGenerator cg = new QVTiCodeGenerator(DomainUtil.nonNullState(metaModelManager), (Transformation)pPackage);
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
		return null;
	}

	@SuppressWarnings("unchecked")
	public Class<? extends AbstractTransformation> compileTransformation(@NonNull QVTiCodeGenerator cg) throws Exception {
		String qualifiedName = cg.getQualifiedName();
		String javaCodeSource = cg.generateClassFile();
		try {
			Class<?> txClass = Java5Facade.loadClass(qualifiedName, javaCodeSource);
			return (Class<? extends AbstractTransformation>) txClass;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
}
