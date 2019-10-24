/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.ModelsManager;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.evaluation.TypedModelInstance;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.junit.Before;
import org.junit.Test;

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

		public @NonNull BasicQVTiExecutor createEvaluator(@NonNull ImperativeTransformation transformation) {
			BasicQVTiExecutor incrementalExecutor = new BasicQVTiExecutor(getEnvironmentFactory(), transformation, ModeFactory.LAZY);
			return incrementalExecutor;
		}

		public @NonNull TransformationExecutor createEvaluator(@NonNull Class<? extends Transformer> txClass) throws ReflectiveOperationException {
			return new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
		}
		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}
	}

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		QVTimperativeStandaloneSetup.doSetup();
		CompleteOCLStandaloneSetup.doSetup(); // To be able to add QVTimperative.ocl validation
	}

	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTimperative.newInstance(getTestProjectManager(), null);
	}

	protected @NonNull MyQVT createQVT() throws Exception {
		return new MyQVT(new QVTiEnvironmentFactory(getTestProjectManager(), null));
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

			ImperativeTransformation qvtiTransf = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), txURI);
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
			@SuppressWarnings("unchecked")
			Class<? extends Transformer> txClass = (Class<? extends Transformer>) Class.forName("cg._classescs2as_qvtm_qvtcas.classescs2as_qvtm_qvtcas");
			assert txClass != null;
			trackExample_CG(myQVT, txClass, baseURI, "model1", results);
			trackExample_CG(myQVT, txClass, baseURI, "model2", results);
			trackExample_CG(myQVT, txClass, baseURI, "model3", results);
			trackExample_CG(myQVT, txClass, baseURI, "model4", results);
			trackExample_CG(myQVT, txClass, baseURI, "model5", results);
			trackExample_CG(myQVT, txClass, baseURI, "model6", results);
			trackExample_CG(myQVT, txClass, baseURI, "model7", results);

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
	//			Class<? extends TransformationExecutor> txClass = classescs2as_qvtm_qvtias_Manual.class;
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

	private void trackExample_Interpreted(MyQVT qvt, @NonNull ImperativeTransformation transformation, URI baseURI, String modelName,
			Map<String, List<Integer>> results)  throws Exception  {
		long initStamp = System.currentTimeMillis();
		executeModelsTX_Interpreted(qvt, transformation, baseURI, modelName);
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


	@SuppressWarnings("unused")
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
		URI samplesBaseUri = baseURI.appendSegment("samples");
		URI csModelURI = samplesBaseUri.appendSegment(String.format("%s_input.xmi", modelName));
		URI asModelURI = samplesBaseUri.appendSegment(String.format("%s_output_CG.xmi", modelName));
		TransformationExecutor evaluator = qvt.createEvaluator(txClass);
		Transformer tx = evaluator.getTransformer();
		ModelsManager modelsManager = tx.getModelsManager();
		TypedModelInstance inputTypedModelInstance = modelsManager.getTypedModelInstance("leftCS");
		TypedModelInstance outputTypedModelInstance = modelsManager.getTypedModelInstance("rightAS");

		ResourceSet rSet = qvt.getResourceSet();
		Resource inputResource = ClassUtil.nonNullState(rSet.getResource(csModelURI, true));
		inputTypedModelInstance.addInputResource(inputResource);
		boolean success = tx.run();
		Resource outputResource = ClassUtil.nonNullState(rSet.createResource(asModelURI));
		outputTypedModelInstance.addOutputResource(outputResource);
		modelsManager.saveModels(DefaultCompilerOptions.defaultSavingOptions);
		assertTrue(success);
	}

	//
	// Execute the transformation with the CGed transformation
	//

	protected void executeModelsTX_Interpreted(MyQVT qvt, @NonNull ImperativeTransformation transformation, URI baseURI, String modelName) throws Exception {
		URI samplesBaseUri = baseURI.appendSegment("samples");
		URI csModelURI = samplesBaseUri.appendSegment(String.format("%s_input.xmi", modelName));
		URI asModelURI = samplesBaseUri.appendSegment(String.format("%s_output_Interpreted.xmi", modelName));

		BasicQVTiExecutor testEvaluator = qvt.createEvaluator(transformation);
		testEvaluator.saveTransformation(null, null);
		ModelsManager modelsManager = testEvaluator.getModelsManager();
		TypedModelInstance inputTypedModelInstance = modelsManager.getTypedModelInstance("leftCS");
		TypedModelInstance outputTypedModelInstance = modelsManager.getTypedModelInstance("rightAS");
		ResourceSet rSet = qvt.getResourceSet();
		Resource inputResource = ClassUtil.nonNullState(rSet.getResource(csModelURI, true));
		inputTypedModelInstance.addInputResource(inputResource);
		boolean success = testEvaluator.execute(null);
		Resource outputResource = ClassUtil.nonNullState(rSet.createResource(asModelURI));
		outputTypedModelInstance.addOutputResource(outputResource);
		modelsManager.saveModels(DefaultCompilerOptions.defaultSavingOptions);
		testEvaluator.dispose();
		assertTrue(success);
	}

	protected void saveEmptyModel( URI modelURI) throws IOException {

		ResourceSet rSet = new ResourceSetImpl();
		StandaloneProjectMap.getAdapter(rSet);
		Resource r = rSet.createResource(modelURI);
		r.save(DefaultCompilerOptions.defaultSavingOptions);
	}

	protected ImperativeTransformation getTransformation(ResourceSet rSet, URI qvtiURI) {

		Resource resource = rSet.getResource(qvtiURI, true);
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof ImperativeModel) {
				for (org.eclipse.ocl.pivot.Package pPackage : ((ImperativeModel)eObject).getOwnedPackages()) {
					for (org.eclipse.ocl.pivot.Class pClass : pPackage.getOwnedClasses()) {
						if (pClass instanceof ImperativeTransformation) {
							return  (ImperativeTransformation) pClass;
						}
					}
				}
			}
		}
		return null;
	}


}
