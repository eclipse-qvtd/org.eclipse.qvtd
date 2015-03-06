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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.build.cs2as.OCL2QVTiBroker;
import org.eclipse.qvtd.build.etl.EtlTask;
import org.eclipse.qvtd.build.etl.MtcBroker;
import org.eclipse.qvtd.build.etl.PivotModel;
import org.eclipse.qvtd.build.etl.QvtMtcExecutionException;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationEvaluator;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationEvaluator;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationExecutor;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiPivotEvaluator;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.junit.Before;
import org.junit.Test;

/**
 * @author asbh500
 * 
 *
 */
public class OCL2QVTiTestCases extends LoadTestCase {
	
	private static final String TESTS_GEN_PATH = "../org.eclipse.qvtd.build.cs2as.tests/tests-gen/";
	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("org.eclipse.qvtd.build.cs2as.tests/src/org/eclipse/qvtd/build/cs2as/tests/models", true);
	
	protected class MyQVT extends OCL
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}

		public @NonNull QVTiPivotEvaluator createEvaluator(Transformation transformation) {
			return new QVTiPivotEvaluator(getEnvironmentFactory(), transformation);
		}

		public @NonNull TxEvaluator createEvaluator(Constructor<? extends TransformationExecutor> txConstructor) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
			return new TxEvaluator(getCompleteEnvironment(), txConstructor);
		}
		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}
	}
	
	protected static class TxEvaluator extends AbstractTransformationEvaluator {
		private TxEvaluator(@NonNull CompleteEnvironment environment, Constructor<? extends TransformationExecutor> txConstructor) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
			super(environment, txConstructor);
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
	
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		QVTimperativeStandaloneSetup.doSetup();		
		CompleteOCLStandaloneSetup.doSetup(); // To be able to add QVTimperative.ocl validation
		
		// myQVT = createQVT();
		// QVTiEnvironmentFactory factory = myQVT.getEnvironmentFactory(); 
		// factory.setEvaluationTracingEnabled(true);
		// factory.configureLoadFirstStrategy(); // Since the models might use a different URI to refer the same meta-model
	}
	
	protected @NonNull MyQVT createQVT() {
		return new MyQVT(new QVTiEnvironmentFactory(getProjectMap(), null));
	}
	
	
	@Test
	public void testExample1_OCL2QVTp() throws Exception {
		MyQVT myQVT = createQVT();
		URI baseURI = TESTS_BASE_URI.appendSegment("example1");
		URI oclDocURI = baseURI.appendSegment("Source2Target.ocl.oclas");
		URI qvtpFileURI = baseURI.appendSegment("Source2Target.qvtp.qvtias");
		
		OCL2QVTiBrokerTester mtc = new OCL2QVTiBrokerTester(baseURI, "Source2Target.ocl", myQVT);
		mtc.runOCL2QVTp_MiddleFolded(oclDocURI, qvtpFileURI);
		// Test the QVTp transformation can be loaded
		assertValidQVTiModel(qvtpFileURI);
		myQVT.dispose();
	}
	
	@Test
	public void testExample1_Interpreted() throws Exception {
		MyQVT myQVT = createQVT();
		ResourceSet resourceSet = myQVT.getResourceSet();		
		resourceSet.getResource(URI.createURI(example1.source.SourcePackage.eNS_URI, true), true);
		resourceSet.getResource(URI.createURI(example1.target.TargetPackage.eNS_URI, true), true);
		resourceSet.getResource(URI.createURI(example1.env.EnvironmentPackage.eNS_URI, true), true);
		
		URI baseURI = TESTS_BASE_URI.appendSegment("example1");

		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "Source2Target.ocl");
		
//    	launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment("Source2TargetSchedule_complete.graphml").toString(), false);
//    	launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment("Source2TargetSchedule_pruned.graphml").toString(), true);
		
    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model1");
    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model2");
    	
        myQVT.dispose();
        
	}
	
	
	@Test
	public void testExample2_Interpreted() throws Exception {
		StandaloneProjectMap.PROJECT_MAP_ADD_EPACKAGE.setState(true);
//		StandaloneProjectMap.PROJECT_MAP_ADD_GEN_MODEL.setState(true);
		StandaloneProjectMap.PROJECT_MAP_ADD_GENERATED_PACKAGE.setState(true);
//		StandaloneProjectMap.PROJECT_MAP_ADD_URI_MAP.setState(true);
		StandaloneProjectMap.PROJECT_MAP_CONFIGURE.setState(true);
		StandaloneProjectMap.PROJECT_MAP_GET.setState(true);
		StandaloneProjectMap.PROJECT_MAP_INSTALL.setState(true);
		StandaloneProjectMap.PROJECT_MAP_RESOLVE.setState(true);
		MyQVT myQVT = createQVT();
		ResourceSet resourceSet = myQVT.getResourceSet();
		resourceSet.getResource(URI.createURI(example2.classes.ClassesPackage.eNS_URI, true), true);
		resourceSet.getResource(URI.createURI(example2.classescs.ClassescsPackage.eNS_URI, true), true);
		resourceSet.getResource(URI.createURI(example2.env.EnvironmentPackage.eNS_URI, true), true);
	    System.out.println("MyQVT created");
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");

		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "classescs2as.ocl");

//    	launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment("classescs2asSchedule_complete.graphml").toString(), false);
//    	launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment("classescs2asSchedule_pruned.graphml").toString(), true);
    	
	    System.out.println("MyQVT execute model1");
    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model1");
	    System.out.println("MyQVT execute model2");
    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model2");
    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model3");
    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model4");
    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model5");
    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model6");
    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model7");

        myQVT.dispose();
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
//    	//launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment("KiamaRewriteSchedule_complete.graphml").toString(), false);
//    	//launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment("KiamaRewriteSchedule_pruned.graphml").toString(), true);
//    	
//    	executeModelsTX_Interpreted(myQVT, qvtiTransf.getTransformation(), baseURI, "model1");
//    	
//        myQVT.dispose();
//	}
	
	
	@Test
	public void testExample4_() throws Exception {
		MyQVT myQVT = createQVT();
		URI baseURI = TESTS_BASE_URI.appendSegment("example4");
				
		executeOCL2QVTi_MTC(myQVT, baseURI, "SimplerKiama.ocl");
		    	
    	//launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment("SimplerKiamaSchedule_complete.graphml").toString(), false);
    	//launchQVTs2GraphMlTx(mtc.getsModel(), baseURI.appendSegment("SimplerKiamaSchedule_pruned.graphml").toString(), true);
				
    	myQVT.dispose();
	}
	
	@Test
	public void testExample1_CG() throws Exception {
		MyQVT myQVT = createQVT();
		URI baseURI = TESTS_BASE_URI.appendSegment("example1");

		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "Source2Target.ocl");

	
		Class<? extends TransformationExecutor> txClass = generateCode(myQVT, qvtiTransf.getTransformation(), TESTS_GEN_PATH);
		myQVT.dispose();
		
		// Create a fresh qvt, to avoid meta-model schizophrenia when referring Environment.ecore 
		MyQVT myQVT2 = createQVT();
		
		Constructor<? extends TransformationExecutor> txConstructor = ClassUtil.nonNullState(txClass.getConstructor(Evaluator.class));

		executeModelsTX_CG(myQVT2, txConstructor, baseURI, "model1");		
		executeModelsTX_CG(myQVT2, txConstructor, baseURI, "model2");
	
        myQVT2.dispose();
	}
		
		
	@Test
	public void testExample2_CG() throws Exception {
		MyQVT myQVT = createQVT();
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
			
		PivotModel qvtiTransf = executeOCL2QVTi_MTC(myQVT, baseURI, "classescs2as.ocl");
		
    	//
    	// Generate the transformation java code
    	// 
//		ResourceSet asRset = myQVT.getMetamodelManager().getASResourceSet();
//		Class<? extends TransformationExecutor> txClass = generateCode(getTransformation(asRset, baseURI.appendSegment("classescs2as.qvtias")) , middleGenModelURI, TESTS_GEN_PATH);
		Class<? extends TransformationExecutor> txClass = generateCode(myQVT, qvtiTransf.getTransformation(), TESTS_GEN_PATH);
//		Class<? extends TransformationExecutor> txClass = classescs2as_qvtp_qvtias.class;
		myQVT.dispose();
		
		// Execute CGed transformation
		// Create a fresh qvt, to avoid meta-model schizophrenia when referring Environment.ecore 
		MyQVT myQVT2 = createQVT();
		Constructor<? extends TransformationExecutor> txConstructor = ClassUtil.nonNullState(txClass.getConstructor(Evaluator.class));
		
		executeModelsTX_CG(myQVT2, txConstructor, baseURI, "model1");
		executeModelsTX_CG(myQVT2, txConstructor, baseURI, "model2");
		executeModelsTX_CG(myQVT2, txConstructor, baseURI, "model3");
		executeModelsTX_CG(myQVT2, txConstructor, baseURI, "model4");
		executeModelsTX_CG(myQVT2, txConstructor, baseURI, "model5");
		executeModelsTX_CG(myQVT2, txConstructor, baseURI, "model6");
		executeModelsTX_CG(myQVT2, txConstructor, baseURI, "model7");
		
        myQVT2.dispose();
	}
	
	@Test
	public void testExample2_OCL2QVTp_MiddleModel() throws Exception {
		MyQVT myQVT = createQVT();		
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		URI oclDocURI = baseURI.appendSegment("classescs2as.ocl.oclas");
		URI qvtpFileURI = baseURI.appendSegment("classescs2as.qvtp.qvtias");
		URI tracesMMURI = baseURI.appendSegment("classescs2as.ecore.oclas");
		
		OCL2QVTiBrokerTester mtc = new OCL2QVTiBrokerTester(baseURI, "classescs2as.ocl", myQVT, false);
		mtc.runOCL2QVTp_MiddleModel(oclDocURI, qvtpFileURI, tracesMMURI);
		// Test the QVTp transformation can be loaded
		assertValidQVTiModel(qvtpFileURI);
		myQVT.dispose();
	}
	
	@Test
	public void testExample2_OCL2QVTp_MiddleFolded() throws Exception {
		MyQVT myQVT = createQVT();
		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
		URI oclDocURI = baseURI.appendSegment("classescs2as.ocl.oclas");
		URI qvtpFileURI = baseURI.appendSegment("classescs2as.qvtp.qvtias");
		
		OCL2QVTiBrokerTester mtc = new OCL2QVTiBrokerTester(baseURI, "classescs2as.ocl", myQVT, false);
		mtc.runOCL2QVTp_MiddleFolded(oclDocURI, qvtpFileURI);
		// Test the QVTp transformation can be loaded
		assertValidQVTiModel(qvtpFileURI);
		myQVT.dispose();
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
	
	protected PivotModel executeOCL2QVTi_MTC(MyQVT qvt, URI baseURI, String oclDocName) throws Exception {
		
		OCL2QVTiBroker mtc = new OCL2QVTiBroker(baseURI, oclDocName, qvt, TestsXMLUtil.defaultSavingOptions);
    	mtc.execute();
    	PivotModel qvtiTransf = mtc.getiModel();
    	
    	URI txURI = ClassUtil.nonNullState(qvtiTransf.getResource().getURI());
    	assertValidQVTiModel(txURI);
    	
    	return qvtiTransf;
	}
	
	//
	// Execute the transformation with the interpreter
	//
	protected void executeModelsTX_CG(MyQVT qvt, Constructor<? extends TransformationExecutor> txConstructor, URI baseURI, String modelName) throws Exception {
		
		TransformationEvaluator evaluator = qvt.createEvaluator(txConstructor);
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

	protected void executeModelsTX_Interpreted(MyQVT qvt, Transformation tx, URI baseURI, String modelName) throws Exception {
		
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
	
	// Copied from QVTiCompilerTest
	protected Class<? extends AbstractTransformationExecutor> generateCode(@NonNull MyQVT qvt, @NonNull Transformation transformation, @Nullable String savePath) throws Exception {
				
		QVTiCodeGenerator cg = new QVTiCodeGenerator(qvt.getEnvironmentFactory(), transformation);
		QVTiCodeGenOptions options = cg.getOptions();
		options.setUseNullAnnotations(true);
		options.setPackagePrefix("cg");
		cg.generateClassFile();
		if (savePath != null) {
			cg.saveSourceFile(savePath);
		}
		return  compileTransformation(cg);
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
	
	// Copied from QVTiCompilerTest
	@SuppressWarnings("unchecked")
	protected Class<? extends AbstractTransformationExecutor> compileTransformation(@NonNull QVTiCodeGenerator cg) throws Exception {
		String qualifiedName = cg.getQualifiedName();
		String javaCodeSource = cg.generateClassFile();
		try {
			Class<?> txClass = OCL2JavaFileObject.loadClass(qualifiedName, javaCodeSource);
			return (Class<? extends AbstractTransformationExecutor>) txClass;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
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
		    properties.put(XmlModel.PROPERTY_MODEL_FILE, graphMlURI);
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
