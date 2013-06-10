/*******************************************************************************
 * Copyright (c) 2012, 2013 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/

package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;
import org.eclipse.xtext.util.EmfFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test001 is a set if simple tests on the QVTi API.
 * @author hhoyos
 *
 */
public class QVTiInterpreterTests extends LoadTestCase
{
	private final class MyQvtiEvaluator extends QVTiXtextEvaluator
	{
		protected final @NonNull Map<TypedModel, Resource> typedModelValidationResourceMap = new HashMap<TypedModel, Resource>();
		private final @NonNull String fileNamePrefix;

		public MyQvtiEvaluator(@NonNull MetaModelManager metaModelManager, @NonNull String fileNamePrefix, @NonNull String transformationFileName) throws IOException {
			super(metaModelManager, getProjectFileURI(fileNamePrefix + "/"  + transformationFileName));
			this.fileNamePrefix = fileNamePrefix + "/";
	    	setEvaluationTracingEnabled(true);
		}

		public void createModel(@NonNull String name, @NonNull String modelFileName) {
			createModel(name, getProjectFileURI(fileNamePrefix + modelFileName));
		}

		public void loadModel(@NonNull String name, @NonNull String modelFileName) {
			loadModel(name, getProjectFileURI(fileNamePrefix + modelFileName));
		}

		public void loadReference(@NonNull String name, @NonNull String modelFileName) {
	        TypedModel typedModel = DomainUtil.getNamedElement(transformation.getModelParameter(), name);
	        if (typedModel == null) {
	        	throw new IllegalStateException("Unknown TypedModel '" + name + "'");
	        }
			URI modelURI = getProjectFileURI(fileNamePrefix + modelFileName);
	        Resource resource = metaModelManager.getExternalResourceSet().getResource(modelURI, true);
	        typedModelValidationResourceMap.put(typedModel, resource);
		}

		public void test() throws Exception {
	    	boolean result = execute();
	        assertTrue(getClass().getSimpleName() + " should not return null.", result);
	        saveModels(getProjectFileURI(fileNamePrefix + "middle.xmi"));
	        for (Entry<TypedModel, Resource> entry : typedModelValidationResourceMap.entrySet()) { // Validate against reference models
	        	TypedModel typedModel = entry.getKey();
	        	Resource expectedModel = entry.getValue();
	        	Resource actualModel = modelManager.getModel(typedModel);
	            assertSameModel(expectedModel, actualModel);
	        }
	    }
	}
	
//	public static interface Normalizer {
//		void denormalize();
//	}
	
	public static void assertSameModel(Resource expectedResource, Resource actualResource) throws IOException, InterruptedException {
//		Set<Normalizer> normalizations = normalize(expectedResource);
		String expected = EmfFormatter.listToStr(expectedResource.getContents());
		String actual = EmfFormatter.listToStr(actualResource.getContents());
		assertEquals(expected, actual);
//		for (Normalizer normalizer : normalizations) {
//			normalizer.denormalize();
//		}
	}
	
	@Before
    public void setUp() throws Exception {
	    
		EssentialOCLLinkingService.DEBUG_RETRY = true;
		super.setUp();
		QVTimperativeStandaloneSetup.doSetup();
		metaModelManager = new MetaModelManager();
        MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
    }
 
    @After
    public void tearDown() throws Exception {
		super.tearDown();
    }
    
    /*
     * Minimal 1 object to 1 object QVTi transformation
     */
    @Test
    public void testGraph2GraphMinimal() throws Exception {
    	MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(metaModelManager, "Graph2GraphMinimal", "Graph2GraphMinimal.qvti");
        testEvaluator.loadModel("upperGraph", "SimpleGraph.xmi");
        testEvaluator.createModel("lowerGraph", "Graph2GraphMinimal.xmi");
        testEvaluator.loadReference("lowerGraph", "Graph2GraphMinimalValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
    }

    /*
     * Hierarchical N object to N object QVTi transformation working.
     */
    @Test
    public void testGraph2GraphHierarchical() throws Exception {
    	MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(metaModelManager, "Graph2GraphHierarchical", "Graph2GraphHierarchical.qvti");
    	testEvaluator.loadModel("upperGraph", "../Graph2GraphMinimal/SimpleGraph.xmi");
        testEvaluator.createModel("lowerGraph", "Graph2GraphHierarchical.xmi");
        testEvaluator.loadReference("lowerGraph", "Graph2GraphHierarchicalValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
    }

    @Test
    public void testHSV2HLS() throws Exception {
    	MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(metaModelManager, "HSV2HLS", "HSV2HLS.qvti");
    	testEvaluator.loadModel("hsv", "HSVNode.xmi");
        testEvaluator.createModel("hls", "HLSNode.xmi");
        testEvaluator.loadReference("hls", "HLSNodeValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
    }

    @Test
    public void testClassToRDBMS() throws Exception {
    	MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(metaModelManager, "ClassToRDBMS", "ClassToRDBMSSchedule.qvti");
    	testEvaluator.loadModel("uml", "SimpleUMLPeople.xmi");
        testEvaluator.createModel("rdbms", "SimpleRDBMSPeople.xmi");
        //testEvaluator.loadReference("rdbms", "SimpleRDBMSPeopleValidate.xmi");
        testEvaluator.test();
        testEvaluator.dispose();
    }
}
