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
package org.eclipse.qvtd.build.cs2as.tests;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.build.cs2as.OCL2QVTiBroker;
import org.eclipse.qvtd.build.cs2as.qvti.CS2ASJavaCompiler;
import org.eclipse.qvtd.build.cs2as.qvti.QVTiFacade;
import org.eclipse.qvtd.build.cs2as.tests.models.example2.java.classescs2as_qvtp_qvtias_Manual;
import org.eclipse.qvtd.build.etl.EtlTask;
import org.eclipse.qvtd.build.etl.MtcBroker;
import org.eclipse.qvtd.build.etl.PivotModel;
import org.eclipse.qvtd.build.etl.QvtMtcExecutionException;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationEvaluator;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationExecutor;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiPivotEvaluator;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author asbh500
 * 
 *
 */
public class OCL2QVTiTestCases extends LoadTestCase {
	
	private static final boolean CREATE_GRAPHML = false; // Note. You need Epsilon with Bug 458724 fix to have output graphml models serialised
	private static final String TESTS_GEN_PATH = "../org.eclipse.qvtd.build.cs2as.tests/tests-gen/";
	private static final String TESTS_PACKAGE_NAME = "cg";
	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("org.eclipse.qvtd.build.cs2as.tests/src/org/eclipse/qvtd/build/cs2as/tests/models", true);

	
	// For testing purpose
	private static class OCL2QVTiBrokerTester extends OCL2QVTiBroker {

		public OCL2QVTiBrokerTester(URI baseURI, String oclDocName, OCL metaModelManager)
				throws Exception {
			super(baseURI, oclDocName, metaModelManager, TestsXMLUtil.defaultSavingOptions);
		}
		
		
		public OCL2QVTiBrokerTester(URI baseURI, String oclDocName, OCL metaModelManager, boolean middleFolded)
				throws Exception {
			super(baseURI, oclDocName, metaModelManager, TestsXMLUtil.defaultSavingOptions, middleFolded);
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
	
	@NonNull private QVTiFacade myQVT;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		QVTimperativeStandaloneSetup.doSetup();		
		CompleteOCLStandaloneSetup.doSetup(); // To be able to add QVTimperative.ocl validation
		
		myQVT = createQVT();
	}
	
	@Override
	@After
	protected void tearDown() throws Exception {
		myQVT.dispose();
		super.tearDown();
	}
	
	protected @NonNull QVTiFacade createQVT() {
		return QVTiFacade.createInstance(getProjectMap(), null);
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
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "Source2Target.ocl");
		
		// Create a fresh qvt, to avoid meta-model schizophrenia when referring Environment.ecore 
		myQVT.dispose();
		myQVT = createQVT();		
		myQVT.getEnvironmentFactory().configureLoadStrategy(StandaloneProjectMap.LoadGeneratedPackageStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
				
		Transformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), qvtiTransf.getModelFileUri());		
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model1");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model2");
	}
	
	
	@Test
	public void testExample2_Interpreted() throws Exception {
				
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "classescs2as.ocl");
		
		// Create a fresh qvt, to avoid meta-model schizophrenia when referring Environment.ecore 
		myQVT.dispose();		
		myQVT = createQVT();
		myQVT.getEnvironmentFactory().configureLoadStrategy(StandaloneProjectMap.LoadGeneratedPackageStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
		
		Transformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), qvtiTransf.getModelFileUri());
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model1");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model2");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model3");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model4");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model5");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model6");
    	executeModelsTX_Interpreted(myQVT, tx, baseURI, "model7");
	}
	
//	@Test
//	public void testExample3_Interpreted() throws Exception {
//		MyQVT myQVT = createQVT();
//		URI baseURI = TESTS_BASE_URI.appendSegment("example3");
//
//		OCL2QVTiBroker mtc = new OCL2QVTiBroker(baseURI, "KiamaRewrite.ocl", myQVT, TestsXMLUtil.defaultSavingOptions);
//    	mtc.execute();
//    	PivotModel qvtiTransf = mtc.getiModel();
//    	URI txURI = ClassUtil.nonNullState(qvtiTransf.getResource().getURI());
//    	assertValidQVTiModel(txURI);
//    	
//    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model1");
//    	
//        myQVT.dispose();
//	}
	
	
	@Test
	public void testExample4_() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example4");
				
		executeOCL2QVTi_MTC(myQVT, baseURI, "SimplerKiama.ocl");
	}
	
	@Test
	public void testExample1_CG() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example1");

		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "Source2Target.ocl");

		Class<? extends TransformationExecutor> txClass = new CS2ASJavaCompiler()
			.compileTransformation(myQVT, qvtiTransf.getTransformation(), TESTS_GEN_PATH, TESTS_PACKAGE_NAME);
		// Create a fresh qvt, to avoid meta-model schizophrenia when referring Environment.ecore 
		myQVT.dispose();
		myQVT = createQVT();

		executeModelsTX_CG(myQVT, txClass, baseURI, "model1");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model2");
	
	}
		
		
	@Test
	public void testExample2_CG() throws Exception {
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
			
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "classescs2as.ocl");
		
		Class<? extends TransformationExecutor> txClass = new CS2ASJavaCompiler()
			.compileTransformation(myQVT, qvtiTransf.getTransformation(), TESTS_GEN_PATH, TESTS_PACKAGE_NAME);
		
		
		// Execute CGed transformation
		// Create a fresh qvt, to avoid meta-model schizophrenia when referring Environment.ecore
		myQVT.dispose();
		myQVT = createQVT();
		
		executeModelsTX_CG(myQVT, txClass, baseURI, "model1");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model2");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model3");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model4");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model5");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model6");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model7");
	}
	
	@Test
	public void testExample2_CG_and_LookupVisitor() throws Exception {
		
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");

		Class<? extends TransformationExecutor> txClass = classescs2as_qvtp_qvtias_Manual.class;

		
		// Execute CGed transformation
		// Create a fresh qvt, to avoid meta-model schizophrenia when referring Environment.ecore
		
		executeModelsTX_CG(myQVT, txClass, baseURI, "model1");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model2");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model3");
		executeModelsTX_CG(myQVT, txClass, baseURI, "model4");
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
		
		OCL2QVTiBrokerTester mtc = new OCL2QVTiBrokerTester(baseURI, "classescs2as.ocl", myQVT, false);
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
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTbasePackage.eINSTANCE));
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE));
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE));
		
		assertValidModel(asURI, asResourceSet);
	}
	
	protected PivotModel executeOCL2QVTi_MTC(QVTiFacade qvt, URI baseURI, String oclDocName) throws Exception {
		
		OCL2QVTiBroker mtc = new OCL2QVTiBroker(baseURI, oclDocName, qvt, TestsXMLUtil.defaultSavingOptions);
    	mtc.execute();
    	
    	if (CREATE_GRAPHML) {
    		launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment(oclDocName.replace(".ocl", "Schedule_complete.graphml")).toString(), false);
    		launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment(oclDocName.replace(".ocl", "Schedule_pruned.graphml")).toString(), true);
    	}
    	
    	PivotModel qvtiTransf = mtc.getiModel();
    	
    	URI txURI = ClassUtil.nonNullState(qvtiTransf.getResource().getURI());
    	assertValidQVTiModel(txURI);
    	return qvtiTransf;
	}
	
	//
	// Execute the transformation with the interpreter
	//
	protected void executeModelsTX_CG(QVTiFacade qvt, Class<? extends TransformationExecutor> txClass, URI baseURI, String modelName) throws Exception {
		
		TransformationEvaluator evaluator = qvt.createTxEvaluator(txClass);
		TransformationExecutor tx = evaluator.getExecutor();
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

	protected void executeModelsTX_Interpreted(QVTiFacade qvt, Transformation tx, URI baseURI, String modelName) throws Exception {
		
		URI samplesBaseUri = baseURI.appendSegment("samples");
		URI csModelURI = samplesBaseUri.appendSegment(String.format("%s_input.xmi", modelName));
		URI asModelURI = samplesBaseUri.appendSegment(String.format("%s_output_Interpreted.xmi", modelName));
		URI expectedAsModelURI = samplesBaseUri.appendSegment(String.format("%s_output_ref.xmi", modelName));
		saveEmptyModel(asModelURI);
		
		QVTiPivotEvaluator testEvaluator = qvt.createEvaluator(tx);
		testEvaluator.saveTransformation(null);
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
		    properties.put(XmlModel.PROPERTY_MODEL_FILE, graphMlURI); // TODO when use new APi when released
		    properties.put(XmlModel.PROPERTY_XSD_FILE, new File("schema/ygraphml.xsd").getAbsolutePath());
		    properties.put(XmlModel.PROPERTY_READONLOAD, "false");
		    properties.put(XmlModel.PROPERTY_STOREONDISPOSAL, "true");
		    xmlModel.load(properties);
		    return xmlModel;
		} catch (EolModelLoadingException e) {
			throw new QvtMtcExecutionException("Error loading graphml transformation", e);
		}
		
	}
}
