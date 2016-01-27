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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.tx.TransformationExecutor;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.junit.Before;
import org.junit.Test;

import cg._classescs2as_qvtp_qvtias.classescs2as_qvtp_qvtias;

/**
 * @author asbh500
 * 
 *
 */
public class ExecutionBenchmarks extends LoadTestCase {
	
	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models", true);
	private static int NUM_OF_EXECUTIONS = 10;
	
	protected class MyQVT extends OCL
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}

		public @NonNull BasicQVTiExecutor createEvaluator(@NonNull Transformation transformation) {
			return new BasicQVTiExecutor(getEnvironmentFactory(), transformation);
		}

		public @NonNull TransformationExecutor createEvaluator(@NonNull Class<? extends Transformer> txClass) throws ReflectiveOperationException {
			return new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
		}
		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		QVTimperativeStandaloneSetup.doSetup();
		CompleteOCLStandaloneSetup.doSetup(); // To be able to add QVTimperative.ocl validation
	}
	
	protected @NonNull MyQVT createQVT() {
		return new MyQVT(new QVTiEnvironmentFactory(getProjectMap(), null));
	}
	
	@Test
	public void testExample2_Interpreted() throws Exception {
	
	
		Map<String, List<Integer>> results =  new LinkedHashMap<String, List<Integer>>();
		for (int i = 0; i < NUM_OF_EXECUTIONS; i++){
			MyQVT myQVT = createQVT();
			ResourceSet resourceSet = myQVT.getResourceSet();
			resourceSet.getResource(URI.createURI(example2.classes.ClassesPackage.eNS_URI, true), true);
			resourceSet.getResource(URI.createURI(example2.classescs.ClassescsPackage.eNS_URI, true), true);
			resourceSet.getResource(URI.createURI(example2.classes.lookup.EnvironmentPackage.eNS_URI, true), true);
	
			URI baseURI = TESTS_BASE_URI.appendSegment("example2");
			URI txURI = baseURI.appendSegment("classescs2as.qvtias");
			
			Transformation qvtiTransf = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), txURI);
			assert qvtiTransf != null;
			trackExample_Interpreted(myQVT, qvtiTransf, baseURI, "model1", results);
			trackExample_Interpreted(myQVT, qvtiTransf, baseURI, "model2", results);
			trackExample_Interpreted(myQVT, qvtiTransf, baseURI, "model3", results);
			trackExample_Interpreted(myQVT, qvtiTransf, baseURI, "model4", results);
			trackExample_Interpreted(myQVT, qvtiTransf, baseURI, "model5", results);
			trackExample_Interpreted(myQVT, qvtiTransf, baseURI, "model6", results);
			trackExample_Interpreted(myQVT, qvtiTransf, baseURI, "model7", results);
			myQVT.dispose();
			
		}
		
		
		processResults("Example2_Interpreted.csv" ,results);
	}
	
		
		
	@Test
	public void testExample2_CG() throws Exception {
		
		Map<String, List<Integer>> results =  new LinkedHashMap<String, List<Integer>>();
		for (int i = 0; i < NUM_OF_EXECUTIONS; i++){
			MyQVT myQVT = createQVT();
			
			URI baseURI = TESTS_BASE_URI.appendSegment("example2");
			
			trackExample_CG(myQVT, classescs2as_qvtp_qvtias.class, baseURI, "model1", results);
			trackExample_CG(myQVT, classescs2as_qvtp_qvtias.class, baseURI, "model2", results);
			trackExample_CG(myQVT, classescs2as_qvtp_qvtias.class, baseURI, "model3", results);
			trackExample_CG(myQVT, classescs2as_qvtp_qvtias.class, baseURI, "model4", results);
			trackExample_CG(myQVT, classescs2as_qvtp_qvtias.class, baseURI, "model5", results);
			trackExample_CG(myQVT, classescs2as_qvtp_qvtias.class, baseURI, "model6", results);
			trackExample_CG(myQVT, classescs2as_qvtp_qvtias.class, baseURI, "model7", results);
			
			myQVT.dispose();
			
		}
		
		processResults("Example2_CG.csv" ,results);
	}
	
//	@Test
//	public void testExample2_CG_withLookupVisitor() throws Exception {
//		
//		Map<String, List<Integer>> results =  new LinkedHashMap<String, List<Integer>>();
//		
//		for (int i = 0; i < NUM_OF_EXECUTIONS; i++){
//			MyQVT myQVT = createQVT();
//			
//			URI baseURI = TESTS_BASE_URI.appendSegment("example2");
//			
//			Class<? extends TransformationExecutor> txClass = classescs2as_qvtp_qvtias_Manual.class;
//			Constructor<? extends TransformationExecutor> txConstructor = ClassUtil.nonNullState(txClass.getConstructor(Evaluator.class));
//			
//			trackExample_CG(myQVT, txConstructor, baseURI, "model1", results);
//			trackExample_CG(myQVT, txConstructor, baseURI, "model2", results);
//			trackExample_CG(myQVT, txConstructor, baseURI, "model3", results);
//			trackExample_CG(myQVT, txConstructor, baseURI, "model4", results);
//			trackExample_CG(myQVT, txConstructor, baseURI, "model5", results);
//			trackExample_CG(myQVT, txConstructor, baseURI, "model6", results);
//			trackExample_CG(myQVT, txConstructor, baseURI, "model7", results);
//			
//			myQVT.dispose();
//			
//		}
//
//		processResults("Example2_CG_withLookupVisitor.csv" ,results);
//	}
	
	
	private void trackExample_CG(MyQVT qvt, @NonNull Class<? extends Transformer> txClass, URI baseURI, String modelName,
			Map<String, List<Integer>> results)  throws Exception  {
		
		long initStamp = System.currentTimeMillis();
		executeModelsTX_CG(qvt, txClass, baseURI, modelName);
		long finalStamp = System.currentTimeMillis();
		trackResults(results, modelName, initStamp, finalStamp);
		System.out.println("Iteration on " +modelName+": " + (finalStamp - initStamp) + " ms");
	}
	
	private void trackExample_Interpreted(MyQVT qvt, @NonNull Transformation tx, URI baseURI, String modelName,
			Map<String, List<Integer>> results)  throws Exception  {
		

		long initStamp = System.currentTimeMillis();		
		executeModelsTX_Interpreted(qvt, tx, baseURI, modelName);
		long finalStamp = System.currentTimeMillis();
		trackResults(results, modelName, initStamp, finalStamp);
		System.out.println("Iteration on " +modelName+": " + (finalStamp - initStamp) + " ms");
	}
	
	private void trackResults(Map<String, List<Integer>> allResults, String modelName, long initStamp, long finalStamp) {
		
		List<Integer> modelResults = allResults.get(modelName);
		if (modelResults == null) {
			modelResults = new ArrayList<Integer>();
			allResults.put(modelName, modelResults);
		}
		modelResults.add((int)(finalStamp - initStamp));
	}
	
	
	private void processResults(String fileName, Map<String, List<Integer>> allResults) throws Exception {
		
		File file = new File( fileName);
		FileWriter fWriter = new FileWriter(file);
		fWriter.write("Model Name,Execution Time,Model Mean\n");

		for (String modelName : allResults.keySet()) {
			List<Integer> modelResults = allResults.get(modelName);
			if (modelResults != null) {
				modelResults.remove(0);	// We eliminate the first result with the warm-up
				for (Integer time : modelResults) {
					fWriter.write(modelName+","+time.toString()+",\n");
				}
			}
		}
			
		fWriter.close();
	}
	
	
	private static float mean(List<Integer> list) {
		int result = 0; 
		for (Integer value : list) {
			result += value;
		}
		return result / list.size();		
	}
	
	//
	// Execute the transformation with the interpreter
	//
	protected void executeModelsTX_CG(MyQVT qvt, @NonNull Class<? extends Transformer> txClass, URI baseURI, String modelName) throws Exception {
		
		TransformationExecutor evaluator = qvt.createEvaluator(txClass);
		Transformer tx = evaluator.getTransformer();
		URI samplesBaseUri = baseURI.appendSegment("samples");
    	URI csModelURI = samplesBaseUri.appendSegment(String.format("%s_input.xmi", modelName));
    	URI asModelURI = samplesBaseUri.appendSegment(String.format("%s_output_CG.xmi", modelName));
    	
    	ResourceSet rSet = qvt.getResourceSet();
		Resource inputResource = rSet.getResource(csModelURI, true);
		tx.addRootObjects("leftCS", ClassUtil.nonNullState(inputResource.getContents()));
		boolean success = tx.run();
		Resource outputResource = rSet.createResource(asModelURI);
		outputResource.getContents().addAll(tx.getRootObjects("rightAS"));
		outputResource.save(TestsXMLUtil.defaultSavingOptions);
		assertTrue(success);
	}

	//
	// Execute the transformation with the CGed transformation
	//

	protected void executeModelsTX_Interpreted(MyQVT qvt, @NonNull Transformation tx, URI baseURI, String modelName) throws Exception {
		
		URI samplesBaseUri = baseURI.appendSegment("samples");
		URI csModelURI = samplesBaseUri.appendSegment(String.format("%s_input.xmi", modelName));
		URI asModelURI = samplesBaseUri.appendSegment(String.format("%s_output_Interpreted.xmi", modelName));
		
		BasicQVTiExecutor testEvaluator = qvt.createEvaluator(tx);
		testEvaluator.saveTransformation(null);
	    testEvaluator.loadModel("leftCS", csModelURI);
	    testEvaluator.createModel("rightAS", asModelURI, null);
	    boolean success = testEvaluator.execute();
	    testEvaluator.saveModels(TestsXMLUtil.defaultSavingOptions);
	    testEvaluator.dispose();
	    assertTrue(success);
	}

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
	
	
}
