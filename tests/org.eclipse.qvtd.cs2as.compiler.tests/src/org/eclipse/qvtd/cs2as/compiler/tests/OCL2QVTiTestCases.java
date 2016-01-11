/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.tests;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.xml.XmlModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.tx.TransformationExecutor;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.compiler.internal.etl.EtlTask;
import org.eclipse.qvtd.compiler.internal.etl.MtcBroker;
import org.eclipse.qvtd.compiler.internal.etl.PivotModel;
import org.eclipse.qvtd.compiler.internal.etl.QvtMtcExecutionException;
import org.eclipse.qvtd.compiler.internal.scheduler.Scheduler;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompilerParameters;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerImpl;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerParametersImpl;
import org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTiBroker;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import example1.source.SourcePackage;
import example1.target.TargetPackage;
import example2.classes.ClassesPackage;
import example2.classescs.ClassescsPackage;
import example4.kiamaas.KiamaasPackage;
import example4.kiamacs.KiamacsPackage;

/**
 * @author asbh500
 *
 *
 */
public class OCL2QVTiTestCases extends LoadTestCase {

	private static final boolean CREATE_GRAPHML = false; // Note. You need Epsilon with Bug 458724 fix to have output graphml models serialised
	private static final String TESTS_GEN_PATH = "../org.eclipse.qvtd.cs2as.compiler.tests/tests-gen/";
	private static final String TESTS_PACKAGE_NAME = "cg";
	private static final String DEBUG_SEGMENT = "debug";
	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models", true);

	/**
	 * InstallMap supervises installation of test model declarations not available from the plugin extension points.
	 */
	@SuppressWarnings("serial")
	protected class InstallMap extends HashMap<EPackage, URI>
	{
		private final @NonNull URI baseURI;
		
		public InstallMap(@NonNull URI baseURI) {
			this.baseURI = baseURI;
		}
		public void install(@NonNull EPackage ePackage) {
			ResourceSetImpl resourceSet = (ResourceSetImpl) myQVT.getResourceSet();
			URI nsUri = URI.createURI(ePackage.getNsURI());
			resourceSet.getURIResourceMap().put(nsUri, ePackage.eResource());
			EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
			put(ePackage, nsUri);
		}

		public void install(@NonNull EPackage ePackage, @NonNull String relativeEcoreFileName) {
			ResourceSetImpl resourceSet = (ResourceSetImpl) myQVT.getResourceSet();
			URI fileURI = baseURI.appendSegment(relativeEcoreFileName);
			resourceSet.getURIResourceMap().put(fileURI, ePackage.eResource());
			EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
			put(ePackage, fileURI);
		}

		public void uninstall() {
			for (EPackage ePackage : keySet()) {
				EPackage.Registry.INSTANCE.remove(ePackage.getNsURI());
			}
		}
	}

	// For testing purpose
	private static class OCL2QVTiBrokerTester extends OCL2QVTiBroker {

		public OCL2QVTiBrokerTester(URI baseURI, String oclDocName, OCL metaModelManager)
				throws Exception {
			super(baseURI, oclDocName, metaModelManager, TestsXMLUtil.defaultSavingOptions);
		}


		public OCL2QVTiBrokerTester(URI baseURI, String oclDocName, OCL metaModelManager, boolean middleFolded)
				throws Exception {
			super(baseURI, oclDocName, metaModelManager, TestsXMLUtil.defaultSavingOptions, middleFolded, null);
		}

		// For testing purpose
		@Override
		protected PivotModel runOCL2QVTp_MiddleModel(URI oclDocURI, URI qvtiFileURI, URI tracesMMURI)
				throws QvtMtcExecutionException {
			return super.runOCL2QVTp_MiddleModel(oclDocURI, qvtiFileURI, tracesMMURI);
		}

		// For testing purpose
		@Override
		protected PivotModel runOCL2QVTp_MiddleFolded(URI oclDocURI, URI qvtiFileURI)
				throws QvtMtcExecutionException {
			return super.runOCL2QVTp_MiddleFolded(oclDocURI, qvtiFileURI);
		}
	}

	@NonNull private QVTimperative myQVT;

	protected void loadGenModel(@NonNull URI genModelURI) {
		ResourceSet resourceSet = myQVT.getResourceSet();
		MetamodelManagerInternal metamodelManager = myQVT.getMetamodelManager();
		Resource csGenResource = resourceSet.getResource(genModelURI, true);
		for (EObject eObject : csGenResource.getContents()) {
			if (eObject instanceof GenModel) {
				GenModel genModel = (GenModel)eObject;
				genModel.reconcile();
				metamodelManager.addGenModel(genModel);
			}
		}
	}
	
	protected void loadEcoreFile(URI fileURI, EPackage ePackage) {
		ResourceSet rSet = myQVT.getResourceSet();
		rSet.getPackageRegistry().put(fileURI.toString(), ePackage);
	}
	
	protected void loadGenModels(URI baseURI, String... genModelNames) {
		if (genModelNames != null) {
			for (String genModelName : genModelNames) {
				loadGenModel(baseURI.appendSegment(genModelName));
			}
		}
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		QVTimperativeStandaloneSetup.doSetup(); // To be able to add QVTimperative.ocl validation
		CompleteOCLStandaloneSetup.doSetup();
		myQVT = createQVT();
	}

	@Override
	@After
	protected void tearDown() throws Exception {
		myQVT.dispose();
		super.tearDown();
	}

	protected @NonNull QVTimperative createQVT() {
		return QVTimperative.newInstance(getProjectMap(), null);
	}


	@Test
	public void testExample1_OCL2QVTp() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example1");
		URI oclDocURI = baseURI.appendSegment("Source2Target.ocl.oclas");
		URI qvtpFileURI = baseURI.appendSegment("Source2Target.qvtp.qvtias");

		OCL2QVTiBrokerTester mtc = new OCL2QVTiBrokerTester(baseURI, "Source2Target.ocl", myQVT);
		mtc.runOCL2QVTp_MiddleFolded(oclDocURI, qvtpFileURI);
		// Test the QVTp transformation can be loaded
		assertValidQVTiModel(qvtpFileURI);
	}

	@Test
	public void testExample1_Interpreted() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example1");
		loadGenModels(baseURI, "SourceMM1.genmodel", "TargetMM1.genmodel");

		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "Source2Target.ocl");

		myQVT.dispose();
		myQVT = createQVT();
		// We need to load the metamodel ecore files to properly use the proper PackageImpl
		loadEcoreFile(baseURI.appendSegment("SourceMM1.ecore"), SourcePackage.eINSTANCE);
		loadEcoreFile(baseURI.appendSegment("TargetMM1.ecore"), TargetPackage.eINSTANCE);
		
		Transformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), qvtiTransf.getModelFileUri());
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model1");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model2");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model3");
	}
	
	@Test
	public void testExample2_Interpreted() throws Exception {
		testCaseAppender.uninstall();			// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		loadGenModels(baseURI, "ClassesCS.genmodel", "Classes.genmodel");
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "classescs2as.ocl");
		
		myQVT.dispose();
		myQVT = createQVT();
		// We need to load the metamodel ecore files to properly use the proper PackageImpl
		loadEcoreFile(baseURI.appendSegment("ClassesCS.ecore"), ClassescsPackage.eINSTANCE);
		loadEcoreFile(baseURI.appendSegment("Classes.ecore"), ClassesPackage.eINSTANCE);
		
		Transformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), qvtiTransf.getModelFileUri());
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model1");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model2");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model3");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model4");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model5");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model6");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model7");
	}
	
	@Test
	public void testNewExample2_Interpreted() throws Exception {
		testCaseAppender.uninstall();			// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		loadGenModels(baseURI, "ClassesCS.genmodel", "Classes.genmodel");
		
		Transformation qvtiTransf = executeNewOCL2QVTi_MTC(myQVT, baseURI, "classescs2as.ocl");
		URI txURI = qvtiTransf.eResource().getURI();
		
		myQVT.dispose();
		myQVT = createQVT();
		loadEcoreFile(baseURI.appendSegment("ClassesCS.ecore"), ClassescsPackage.eINSTANCE);
		loadEcoreFile(baseURI.appendSegment("Classes.ecore"), ClassesPackage.eINSTANCE);
		Transformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), txURI);
//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model1");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model2");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model3");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model4");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model5");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model6");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model7");
	}
	
	@Test
	public void testExample2_V2_Interpreted() throws Exception {

		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		loadGenModels(baseURI, "ClassesCS.genmodel", "Classes.genmodel");
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "classescs2asV2.ocl");
		
		myQVT.dispose();
		myQVT = createQVT();
		// We need to load the metamodel ecore files to properly use the proper PackageImpl
		loadEcoreFile(baseURI.appendSegment("ClassesCS.ecore"), ClassescsPackage.eINSTANCE);
		loadEcoreFile(baseURI.appendSegment("Classes.ecore"), ClassesPackage.eINSTANCE);
		
		Transformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), qvtiTransf.getModelFileUri());
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model1V2");
	}
	
	@Test
	public void testNewExample2_V2_Interpreted() throws Exception {
		testCaseAppender.uninstall();	// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		loadGenModels(baseURI, "ClassesCS.genmodel", "Classes.genmodel");
		
		Transformation qvtiTransf = executeNewOCL2QVTi_MTC(myQVT, baseURI, "classescs2asV2.ocl");
		URI txURI = qvtiTransf.eResource().getURI();
		
		myQVT.dispose();
		myQVT = createQVT();
		loadEcoreFile(baseURI.appendSegment("ClassesCS.ecore"), ClassescsPackage.eINSTANCE);
		loadEcoreFile(baseURI.appendSegment("Classes.ecore"), ClassesPackage.eINSTANCE);
		Transformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), txURI);
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model1V2");
	}
	
	
	
	/* Commented. This doesn't work with normal scheduler. It needs to use the new scheduler
//	@Test
//	public void testExample3_Interpreted() throws Exception {
//
//		URI baseURI = TESTS_BASE_URI.appendSegment("example3");
//		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "KiamaRewrite.ocl");
//    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model1");
//	}
*/	
	
	/* Commented. This doesn't work with normal scheduler. It needs to use the new scheduler
	@Test
	public void testExample4_Interpreted() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example4");
		InstallMap installMap = new InstallMap(baseURI);
		installMap.install(KiamacsPackage.eINSTANCE, "SimplerKiamaCS.ecore");
		installMap.install(KiamaasPackage.eINSTANCE, "SimplerKiamaAS.ecore");
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "SimplerKiama.ocl");
		
		// Create a fresh qvt, to avoid meta-model schizophrenia when referring Environment.ecore 
		myQVT.dispose();
		myQVT = createQVT();		
		myQVT.getEnvironmentFactory().configureLoadStrategy(StandaloneProjectMap.LoadGeneratedPackageStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
				
		Transformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), qvtiTransf.getModelFileUri());		
// FIXME BUG 484278 model0 has an invalid model TopCS.node[1] has a null value.
//    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model0");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model1");
// FIXME fails    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model2");
//    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model3");
    	installMap.uninstall();
	}*/
	
	@Test
	public void testNewExample4_Interpreted() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example4");
		loadGenModels(baseURI, "SimplerKiamaAS.genmodel", "SimplerKiamaCS.genmodel");
		Transformation qvtiTransf = executeNewOCL2QVTi_MTC(myQVT, baseURI, "SimplerKiama.ocl");
		URI txURI = qvtiTransf.eResource().getURI();
		
		myQVT.dispose();
		myQVT = createQVT();
		loadEcoreFile(baseURI.appendSegment("SimplerKiamaCS.ecore"), KiamacsPackage.eINSTANCE);
		loadEcoreFile(baseURI.appendSegment("SimplerKiamaAS.ecore"), KiamaasPackage.eINSTANCE);
		
		Transformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), txURI);
//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
// FIXME BUG 484278 model0 has an invalid model TopCS.node[1] has a null value.		
//    	executeModelsTX_Interpreted(myQVT, qvtiTransf, baseURI, "model0");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model1");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model2");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model3");
	}
	
	@Test
	public void testExample5_Interpreted() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example5");
		loadGenModels(baseURI, "SourceBaseMM.genmodel", "TargetBaseMM.genmodel");
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "Source2TargetBase.ocl");
		
		Transformation tx = qvtiTransf.getTransformation();
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model1");
    	
		myQVT.dispose();
		myQVT = createQVT();

		loadGenModels(baseURI, "SourceBaseMM.genmodel", "TargetBaseMM.genmodel", 
				"SourceDerivedMM.genmodel", "TargetDerivedMM.genmodel");
		List<String> oclDocs = new ArrayList<String>();
		oclDocs.add("Source2TargetDerived.ocl");
		oclDocs.add("Source2TargetBase.ocl");
		qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, oclDocs);
		
		tx = qvtiTransf.getTransformation();	
		executeModelsTX_Interpreted(myQVT, tx, baseURI, "model2");
	}
	
/*	@Test
	public void testNewExample4_CG2() throws Exception {
		AbstractTransformer.INVOCATIONS.setState(true);;
		URI testBaseURI = TESTS_BASE_URI.appendSegment("example4");
		install(testBaseURI, KiamacsPackage.eINSTANCE, KiamaasPackage.eINSTANCE);

		QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
		environmentFactory.configureLoadStrategy(StandaloneProjectMap.LoadGeneratedPackageStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
		environmentFactory.setEvaluationTracingEnabled(true);
				
		executeModelsTX_CG(myQVT, SimplerKiama_qvtp_qvtias.class, testBaseURI, "model0");
		executeModelsTX_CG(myQVT, SimplerKiama_qvtp_qvtias.class, testBaseURI, "model1");
		executeModelsTX_CG(myQVT, SimplerKiama_qvtp_qvtias.class, testBaseURI, "model2");
		executeModelsTX_CG(myQVT, SimplerKiama_qvtp_qvtias.class, testBaseURI, "model3");
		uninstall(KiamacsPackage.eINSTANCE, KiamaasPackage.eINSTANCE);
	} */
	
	@Test
	public void testExample1_CG() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example1");
		loadGenModels(baseURI, "SourceMM1.genmodel", "TargetMM1.genmodel");
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "Source2Target.ocl");

		CS2ASJavaCompilerParameters cgParams = new CS2ASJavaCompilerParametersImpl(
				"example1.target.lookup.util.TargetLookupSolver",
				"example1.target.lookup.util.TargetLookupResult", TESTS_GEN_PATH, TESTS_PACKAGE_NAME);
		Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl()
			.compileTransformation(myQVT, qvtiTransf.getTransformation(), cgParams);
		// Create a fresh qvt, to avoid meta-model schizophrenia when referring Environment.ecore 
		myQVT.dispose();
		myQVT = createQVT();

		executeModelsTX_CG(myQVT, txClass, baseURI, "model1");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model2");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model3");

	}


	@Test
	public void testExample2_CG() throws Exception {
		testCaseAppender.uninstall();			// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		loadGenModels(baseURI, "ClassesCS.genmodel", "Classes.genmodel");
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "classescs2as.ocl");
		CS2ASJavaCompilerParameters cgParams = new CS2ASJavaCompilerParametersImpl(
				"example2.classes.lookup.util.ClassesLookupSolver",
				"example2.classes.lookup.util.ClassesLookupResult",
				TESTS_GEN_PATH, TESTS_PACKAGE_NAME);
//		cgParams.setIsIncremental(true);
		Transformation transformation = qvtiTransf.getTransformation();
		Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl().compileTransformation(myQVT, transformation, cgParams);
		executeModelsTX_CG(myQVT, txClass, baseURI, "model1");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model2");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model3");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model4");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model5");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model6");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model7");
	}

	@Test
	public void testNewExample2_CG() throws Exception {
//		Scheduler.EDGE_ORDER.setState(true);
//		Scheduler.REGION_DEPTH.setState(true);
//		Scheduler.REGION_ORDER.setState(true);
//		Scheduler.REGION_TRAVERSAL.setState(true);
//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
//		Scheduler.DEPENDENCY_ANALYSIS.setState(true);
//		AbstractTransformer.INVOCATIONS.setState(true);
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		loadGenModels(baseURI, "ClassesCS.genmodel", "Classes.genmodel");
		Transformation qvtiTransf = executeNewOCL2QVTi_MTC(myQVT, baseURI, "classescs2as.ocl");
		CS2ASJavaCompilerParameters cgParams = new CS2ASJavaCompilerParametersImpl(
				"example2.classes.lookup.util.ClassesLookupSolver",
				"example2.classes.lookup.util.ClassesLookupResult",
				TESTS_GEN_PATH, TESTS_PACKAGE_NAME);
		Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl().compileTransformation(myQVT, qvtiTransf, cgParams);
		executeModelsTX_CG(myQVT, txClass, baseURI, "model1");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model2");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model3");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model4");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model5");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model6");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model7");
	}

	@Test
	public void testNewExample2_V2_CG() throws Exception {
		Scheduler.DUMP_CLASS_TO_CONSUMING_NODES.setState(true);
		Scheduler.DUMP_CLASS_TO_CONTAINING_PROPERTIES.setState(true);
		Scheduler.DUMP_CLASS_TO_REALIZED_NODES.setState(true);
		Scheduler.DUMP_INPUT_MODEL_TO_DOMAIN_USAGE.setState(true);
		Scheduler.DUMP_PROPERTY_TO_CONSUMING_CLASSES.setState(true);
//		Scheduler.EDGE_ORDER.setState(true);
//		Scheduler.REGION_DEPTH.setState(true);
//		Scheduler.REGION_ORDER.setState(true);
//		Scheduler.REGION_TRAVERSAL.setState(true);
//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
//		Scheduler.DEPENDENCY_ANALYSIS.setState(true);
//		AbstractTransformer.INVOCATIONS.setState(true);
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		loadGenModels(baseURI, "ClassesCS.genmodel", "Classes.genmodel");
		Transformation qvtiTransf = executeNewOCL2QVTi_MTC(myQVT, baseURI, "classescs2asV2.ocl");
		CS2ASJavaCompilerParameters cgParams = new CS2ASJavaCompilerParametersImpl(
				"example2.classes.lookup.util.ClassesLookupSolver",
				"example2.classes.lookup.util.ClassesLookupResult",
				TESTS_GEN_PATH, TESTS_PACKAGE_NAME);
		Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl().compileTransformation(myQVT, qvtiTransf, cgParams);
		executeModelsTX_CG(myQVT, txClass, baseURI, "model1V2");
	}

	@Test
	public void testExample2_V2_CG() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		loadGenModels(baseURI, "ClassesCS.genmodel", "Classes.genmodel");
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "classescs2asV2.ocl");

		CS2ASJavaCompilerParameters cgParams = new CS2ASJavaCompilerParametersImpl(
				"example2.classes.lookup.util.ClassesLookupSolver",
				"example2.classes.lookup.util.ClassesLookupResult",
				TESTS_GEN_PATH, TESTS_PACKAGE_NAME);
		Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl()
			.compileTransformation(myQVT, qvtiTransf.getTransformation(), cgParams);


		// Execute CGed transformation
		// Create a fresh qvt, to avoid meta-model schizophrenia when referring Environment.ecore
		myQVT.dispose();
		myQVT = createQVT();

		executeModelsTX_CG(myQVT, txClass, baseURI, "model1V2");
	}
	
	@Test
	public void testNewExample4_CG() throws Exception {
//		CommonSubexpressionEliminator.CSE_BUILD.setState(true);
//		CommonSubexpressionEliminator.CSE_PLACES.setState(true);
//		CommonSubexpressionEliminator.CSE_PRUNE.setState(true);
//		CommonSubexpressionEliminator.CSE_PULL_UP.setState(true);
//		CommonSubexpressionEliminator.CSE_PUSH_UP.setState(true);
//		CommonSubexpressionEliminator.CSE_REWRITE.setState(true);
//		Scheduler.EDGE_ORDER.setState(true);
//		Scheduler.REGION_DEPTH.setState(true);
//		Scheduler.REGION_ORDER.setState(true);
//		Scheduler.REGION_TRAVERSAL.setState(true);
//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
//		AbstractTransformer.INVOCATIONS.setState(true);
		URI baseURI = TESTS_BASE_URI.appendSegment("example4");
		loadGenModels(baseURI, "SimplerKiamaAS.genmodel", "SimplerKiamaCS.genmodel");
		Transformation qvtiTransf = executeNewOCL2QVTi_MTC(myQVT, baseURI, "SimplerKiama.ocl");
		CS2ASJavaCompilerParameters cgParams = new CS2ASJavaCompilerParametersImpl("","",
				TESTS_GEN_PATH, TESTS_PACKAGE_NAME);
		Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl().compileTransformation(myQVT, qvtiTransf, cgParams);
//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
// FIXME BUG 484278 model0 has an invalid model TopCS.node[1] has a null value.
//		executeModelsTX_CG(myQVT, txClass, testBaseURI, "model0");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model1");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model2");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model3");
	}
	
	/* Commented. This doesn't work with normal scheduler. It needs to use the new scheduler 
	@Test
	public void testExample3_CG() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example3");

		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "KiamaRewrite.ocl");

		CS2ASJavaCompilerParameters cgParams = new CS2ASJavaCompilerParametersImpl(
				"",
				"",
				TESTS_GEN_PATH, TESTS_PACKAGE_NAME);
		Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl()
			.compileTransformation(myQVT, qvtiTransf.getTransformation(), cgParams);

		// To avoid metamodel schizophrenia
		myQVT.dispose();
		myQVT = createQVT();
		
		// Execute CGed transformation
		executeModelsTX_CG(myQVT, txClass, baseURI, "model1");
	}*/
	
	/* Commented. This doesn't work with normal scheduler. It needs to use the new scheduler 
	@Test
	public void testExample4_CG() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example4");

		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "SimplerKiama.ocl");

		CS2ASJavaCompilerParameters cgParams = new CS2ASJavaCompilerParametersImpl(
				"",
				"",
				TESTS_GEN_PATH, TESTS_PACKAGE_NAME);
		Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl()
			.compileTransformation(myQVT, qvtiTransf.getTransformation(), cgParams);

		// To avoid metamodel schizophrenia
		myQVT.dispose();
		myQVT = createQVT();

		// Execute CGed transformation
		executeModelsTX_CG(myQVT, txClass, baseURI, "model1");
	}*/
	
	@Test
	public void testExample5_CG() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example5");
		loadGenModels(baseURI, "SourceBaseMM.genmodel", "TargetBaseMM.genmodel");
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "Source2TargetBase.ocl");

		CS2ASJavaCompilerParameters cgParams = new CS2ASJavaCompilerParametersImpl(
				"",
				"",
				TESTS_GEN_PATH, TESTS_PACKAGE_NAME);
		Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl()
			.compileTransformation(myQVT, qvtiTransf.getTransformation(), cgParams);
		
		// Execute CGed transformation
		executeModelsTX_CG(myQVT, txClass, baseURI, "model1");
		
		myQVT.dispose();
		myQVT = createQVT();
		loadGenModels(baseURI, "SourceBaseMM.genmodel", "TargetBaseMM.genmodel", 
				"SourceDerivedMM.genmodel", "TargetDerivedMM.genmodel");
 
		List<String> oclDocs = new ArrayList<String>();
		oclDocs.add("Source2TargetDerived.ocl");
		oclDocs.add("Source2TargetBase.ocl");
		qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, oclDocs);
		txClass = new CS2ASJavaCompilerImpl()
				.compileTransformation(myQVT, qvtiTransf.getTransformation(), cgParams);
			
		// Execute CGed transformation
		executeModelsTX_CG(myQVT, txClass, baseURI, "model2");
	}
	
	@Test
	public void testExample2_OCL2QVTp_MiddleModel() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		URI oclDocURI = baseURI.appendSegment("classescs2as.ocl.oclas");
		URI qvtpFileURI = baseURI.appendSegment("classescs2as.qvtp.qvtias");
		URI tracesMMURI = baseURI.appendSegment("classescs2as.ecore.oclas");

		OCL2QVTiBrokerTester mtc = new OCL2QVTiBrokerTester(baseURI, "classescs2as.ocl", myQVT, false);
		mtc.runOCL2QVTp_MiddleModel(oclDocURI, qvtpFileURI, tracesMMURI);
		// Test the QVTp transformation can be loaded
		assertValidQVTiModel(qvtpFileURI);
	}
	
	@Test
	public void testExample2_OCL2QVTp_MiddleFolded() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		URI oclDocURI = baseURI.appendSegment("classescs2as.ocl.oclas");
		URI qvtpFileURI = baseURI.appendSegment("classescs2as.qvtp.qvtias");

		OCL2QVTiBrokerTester mtc = new OCL2QVTiBrokerTester(baseURI, "classescs2as.ocl", myQVT);
		mtc.runOCL2QVTp_MiddleFolded(oclDocURI, qvtpFileURI);
		// Test the QVTp transformation can be loaded
		assertValidQVTiModel(qvtpFileURI);
	}

	/*
	protected static void assertValidModel(@NonNull URI asURI) {
		EnvironmentFactory factory =  OCL.createEnvironmentFactory(new StandaloneProjectMap());
        ResourceSet asResourceSet = factory.getResourceSet();
        // MetaModelManager.initializeASResourceSet(asResourceSet);
        assertValidModel(asURI, asResourceSet);
	}
	*/
	protected static void assertValidModel(URI asURI, ResourceSet rSet) {
		Resource resource = rSet.getResource(asURI, true);
        EcoreUtil.resolveAll(resource);

		String rUriString = resource.getURI().toString();
		assertNoUnresolvedProxies("Validating a resource: " + rUriString, resource);
        assertNoResourceErrors("Loading a resource" + rUriString, resource);
        //assertNoValidationErrors("Loading a resource" + rUriString, resource);
	}


	protected static void assertValidQVTiModel(@NonNull URI asURI ) {
	    
		OCLInternal ocl =  OCLInternal.newInstance();
		EnvironmentFactoryInternal factory = ocl.getEnvironmentFactory();
		factory.configureLoadFirstStrategy();
		ResourceSet asResourceSet = ocl.getMetamodelManager().getASResourceSet();

		URI oclURI = ClassUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true));

		CompleteOCLEObjectValidator validator = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, factory);
		validator.initialize();
		PivotEObjectValidator.install(asResourceSet, factory);
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTbasePackage.eINSTANCE), null);
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), null);
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), null);

		assertValidModel(asURI, asResourceSet);
	}

	protected PivotModel executeOCL2QVTi_MTC(QVTimperative qvt, URI baseURI, String oclDocName) throws Exception {

		return executeOCL2QVTi_MTC(qvt, baseURI, Collections.singletonList(oclDocName));
	}
	
	protected PivotModel executeOCL2QVTi_MTC(QVTimperative qvt, URI baseURI, List<String> oclDocs) throws Exception {
				
		OCL2QVTiBroker mtc = new OCL2QVTiBroker(baseURI, oclDocs, qvt, TestsXMLUtil.defaultSavingOptions);
		mtc.setCreateGraphml(CREATE_GRAPHML);
    	mtc.execute();
    	if (CREATE_GRAPHML) {
    		String oclDocName = oclDocs.get(0); // We will get the first oclDoc as the reference name
    		launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment(DEBUG_SEGMENT).appendSegment(oclDocName.replace(".ocl", "Schedule_complete.graphml")).toString(), false);
    		launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment(DEBUG_SEGMENT).appendSegment(oclDocName.replace(".ocl", "Schedule_pruned.graphml")).toString(), true);
    	}

    	PivotModel qvtiTransf = mtc.getiModel();

    	URI txURI = ClassUtil.nonNullState(qvtiTransf.getResource().getURI());
    	assertValidQVTiModel(txURI);

    	
		URI inputURI = txURI;
		URI serializedURI = txURI.trimFileExtension().appendFileExtension("serialized.qvti");
		doSerialize(inputURI, serializedURI);
    	
    	
    	return qvtiTransf;
	}

	protected Transformation executeNewOCL2QVTi_MTC(QVTimperative qvt, URI baseURI, String oclDocName) throws Exception {
		
		OCL2QVTiBroker mtc = new OCL2QVTiBroker(baseURI, oclDocName, qvt, TestsXMLUtil.defaultSavingOptions);
		mtc.setCreateGraphml(CREATE_GRAPHML);
    	mtc.newExecute();    	
    	if (CREATE_GRAPHML) {
    		launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment(DEBUG_SEGMENT).appendSegment(oclDocName.replace(".ocl", "Schedule_complete.graphml")).toString(), false);
    		launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment(DEBUG_SEGMENT).appendSegment(oclDocName.replace(".ocl", "Schedule_pruned.graphml")).toString(), true);
    	}
    	
    	Resource iResource = mtc.getiResource();
    	Transformation qvtiTransf = mtc.getTransformation(iResource);
    	
    	URI txURI = ClassUtil.nonNullState(iResource.getURI());
    	assertValidQVTiModel(txURI);

    	
		URI inputURI = txURI;
		URI serializedURI = txURI.trimFileExtension().appendFileExtension("serialized.qvti");
		doSerialize(inputURI, serializedURI);
    	
    	
    	return qvtiTransf;
	}
	
	//
	// Execute the transformation with the interpreter
	//
	protected void executeModelsTX_CG(QVTimperative qvt, Class<? extends Transformer> txClass, URI baseURI, String modelName) throws Exception {
		TransformationExecutor evaluator = new QVTiTransformationExecutor(qvt.getEnvironmentFactory(), txClass);
		Transformer tx = evaluator.getTransformer();
		URI samplesBaseUri = baseURI.appendSegment("samples");
    	URI csModelURI = samplesBaseUri.appendSegment(String.format("%s_input.xmi", modelName));
    	URI asModelURI = samplesBaseUri.appendSegment(String.format("%s_output_CG.xmi", modelName));
    	URI expectedAsModelURI = samplesBaseUri.appendSegment(String.format("%s_output_ref.xmi", modelName));
    	saveEmptyModel(asModelURI);

    	ResourceSet rSet = qvt.getResourceSet();
		Resource inputResource = rSet.getResource(csModelURI, true);
		tx.addRootObjects("leftCS", ClassUtil.nonNullState(inputResource.getContents()));
		assertTrue(tx.run());
		Resource outputResource = rSet.createResource(asModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("rightAS"));
		outputResource.save(TestsXMLUtil.defaultSavingOptions);

		Resource expected =  rSet.getResource(expectedAsModelURI, true);
		assertSameModel(expected, rSet.getResource(asModelURI, true));
	}

	//
	// Execute the transformation with the CGed transformation
	//

	protected void executeModelsTX_Interpreted(QVTimperative qvt, Transformation tx, URI baseURI, String modelName) throws Exception {

		URI samplesBaseUri = baseURI.appendSegment("samples");
		URI csModelURI = samplesBaseUri.appendSegment(String.format("%s_input.xmi", modelName));
		URI asModelURI = samplesBaseUri.appendSegment(String.format("%s_output_Interpreted.xmi", modelName));
		URI expectedAsModelURI = samplesBaseUri.appendSegment(String.format("%s_output_ref.xmi", modelName));
		saveEmptyModel(asModelURI);

		BasicQVTiExecutor testEvaluator = new QVTiIncrementalExecutor(qvt.getEnvironmentFactory(), tx, QVTiIncrementalExecutor.Mode.LAZY);
		//testEvaluator.saveTransformation(null);
	    testEvaluator.loadModel("leftCS", csModelURI);
	    testEvaluator.createModel("rightAS", asModelURI, null);
	    boolean success = testEvaluator.execute();
	    testEvaluator.saveModels(TestsXMLUtil.defaultSavingOptions);
	    testEvaluator.dispose();
	    assertTrue(success);
	    ResourceSet rSet = qvt.getResourceSet();
	    Resource expected =  rSet.getResource(expectedAsModelURI, true);
	    assertSameModel(expected, rSet.getResource(asModelURI, true));
	}


	// QVTiPivotEvaluator only saves models when something is created. If the transformation
	// does nothing and nothing is created, the output model is not saved. Then I have to ensure
	// that an empty model is serialized for the sake of the of the test cases results. The comparison
	// between output model and the reference one, might be done with a previous output model
	// TODO report QVTd bug
	protected void saveEmptyModel( URI modelURI) throws IOException {

		ResourceSet rSet = new ResourceSetImpl();
		StandaloneProjectMap.getAdapter(rSet);
		Resource r = rSet.createResource(modelURI);
		r.save(TestsXMLUtil.defaultSavingOptions);
	}


	protected Transformation getTransformation(ResourceSet rSet, URI qvtiURI) {

		Resource resource = rSet.getResource(qvtiURI, true);
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof ImperativeModel) {
				for (org.eclipse.ocl.pivot.Package pPackage : ((ImperativeModel)eObject).getOwnedPackages()) {
					for (org.eclipse.ocl.pivot.Class pClass : pPackage.getOwnedClasses()) {
						if (pClass instanceof Transformation) {
							return  (Transformation) pClass;
						}
					}
				}
			}
		}
		return null;
	}	

	/**
	 * Explicitly install the eInstances that would normally make it into the ProjectMap from extension point registrations.
	 * Test models are not registered via extension point so we have to do this manually.
	 *
	private void install(@NonNull URI testBaseURI, @NonNull EPackage... eInstances) {
		ResourceSetImpl resourceSet = (ResourceSetImpl) myQVT.getResourceSet();
		for (EPackage eInstance : eInstances) {
			resourceSet.getURIResourceMap().put(testBaseURI.appendSegment(eInstance.getName()+".ecore"), eInstance.eResource());
		}
	} */

	/**
	 * Explicitly remove the eInstances from the EPackage.Registry.INSTANCE so that global registrations from the calling test
	 * do not confuse subsequent tests that may want to use dynamic models.
	 *
	private void uninstall(@NonNull EPackage... eInstances) {
		for (EPackage eInstance : eInstances) {
			EPackage.Registry.INSTANCE.remove(eInstance.getNsURI());
		}
	} */
	
	private void launchQVTs2GraphMlTx(PivotModel qvtsModel, String graphMlURI, boolean pruneQVTs) throws QvtMtcExecutionException {
		
		try {
			// Since pruning might modify QVTs model, we will ensure it's not stored on disposal
			qvtsModel.setStoredOnDisposal(false);
			EtlTask etl = new EtlTask(MtcBroker.class.getResource("extras/QVTsToGraphML.etl").toURI());
			XmlModel graphMl = createGraphMlModel(graphMlURI);
			etl.addModel(qvtsModel);
			etl.addModel(graphMl);
			etl.execute(Collections.singletonList(new Variable("pruneModel", pruneQVTs, EolPrimitiveType.Boolean)));
		} catch (URISyntaxException e) {
			throw new QvtMtcExecutionException("Exception launching QVTs 2 GraphMl transformation", e);
		}
		
	}
	
	private XmlModel createGraphMlModel(String graphMlURI) throws QvtMtcExecutionException {
		
		try {
			XmlModel xmlModel = new XmlModel();
		    StringProperties properties = new StringProperties();
		    properties.put(XmlModel.PROPERTY_NAME, "GML");
		    properties.put(XmlModel.PROPERTY_ALIASES, "GML");
		    properties.put(XmlModel.PROPERTY_MODEL_URI, graphMlURI);
		    properties.put(XmlModel.PROPERTY_XSD_FILE, new File("schema/ygraphml.xsd").getAbsolutePath());
		    properties.put(XmlModel.PROPERTY_READONLOAD, "false");
		    properties.put(XmlModel.PROPERTY_STOREONDISPOSAL, "true");
		    xmlModel.load(properties);
		    return xmlModel;
		} catch (EolModelLoadingException e) {
			throw new QvtMtcExecutionException("Error loading graphml transformation", e);
		}
		
	}
	
// FIXME move following clones to a Util class
	public static @NonNull XtextResource pivot2cs(@NonNull OCL ocl, @NonNull ResourceSet resourceSet, @NonNull ASResource asResource, @NonNull URI outputURI) throws IOException {
		XtextResource xtextResource = ClassUtil.nonNullState((XtextResource) resourceSet.createResource(outputURI, QVTimperativeCSPackage.eCONTENT_TYPE));
		ocl.as2cs(asResource, (CSResource) xtextResource);
		assertNoResourceErrors("Conversion failed", xtextResource);
		//
		//	CS save
		//		
		URI savedURI = ClassUtil.nonNullState(asResource.getURI());
		asResource.setURI(outputURI.trimFileExtension().trimFileExtension().appendFileExtension(PivotConstants.OCL_AS_FILE_EXTENSION));
		asResource.save(TestsXMLUtil.defaultSavingOptions);
		asResource.setURI(savedURI);
		
		assertNoDiagnosticErrors("Concrete Syntax validation failed", xtextResource);
		try {		
			xtextResource.save(TestsXMLUtil.defaultSavingOptions);
		}
		catch (Exception e) {
			e.printStackTrace();
			URI xmiURI = outputURI.appendFileExtension(".xmi");
			Resource xmiResource = resourceSet.createResource(xmiURI);
			xmiResource.getContents().addAll(xtextResource.getContents());
			xmiResource.save(TestsXMLUtil.defaultSavingOptions);
			fail(e.toString());
		}
		return xtextResource;
	}

	public XtextResource doSerialize(@NonNull URI inputURI, @NonNull URI serializedURI) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		//
		//	Load QVTiAS
		//		
		OCL ocl = QVTbase.newInstance(OCL.NO_PROJECTS);
		try {
			ASResource asResource = loadQVTiAS(ocl, inputURI);
			assertNoResourceErrors("Normalisation failed", asResource);
			assertNoUnresolvedProxies("Normalisation invalid", asResource);
			assertNoValidationErrors("Normalisation invalid", asResource);
			//
			//	Pivot to CS
			//		
			XtextResource xtextResource = pivot2cs(ocl, resourceSet, asResource, serializedURI);
			resourceSet.getResources().clear();
			return xtextResource;
		}
		finally {
			ocl.dispose();
			ocl = null;
		}
	}


	protected ASResource loadQVTiAS(@NonNull OCL ocl, @NonNull URI inputURI) {
		Resource asResource = ocl.getMetamodelManager().getASResourceSet().getResource(inputURI, true);
//		List<String> conversionErrors = new ArrayList<String>();
//		RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
//		Resource eResource = documentCS.eResource();
		assertNoResourceErrors("Load failed", asResource);
//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
//		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
//		xtextResource.getContents().add(documentCS);
		return (ASResource) asResource;
	}

}
