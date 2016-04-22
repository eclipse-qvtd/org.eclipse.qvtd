/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTm2QVTp;
import org.eclipse.qvtd.compiler.internal.scheduler.Scheduler;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.JavaSourceFileObject;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtcore.tests.QVTcTestUtil;
import org.eclipse.qvtd.xtext.qvtimperative.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtimperative.tests.QVTiTestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests that QVTc files can be compiled and executed.
 */
public class QVTrCompilerTests extends LoadTestCase
{
	private static final @NonNull String PROJECT_NAME = "org.eclipse.qvtd.xtext.qvtrelation.tests";
	private static final @NonNull URI TESTS_BASE_URI = URI.createPlatformResourceURI("/" + PROJECT_NAME + "/bin/" + PROJECT_NAME.replace(".",  "/"), true);

	protected static class MyQVT extends QVTimperative
	{
		protected final @NonNull String testFolderName;
		protected final @NonNull URI testFolderURI;
		protected final @NonNull URI samplesBaseUri;
		private QVTrCompilerChain compilerChain = null;
		private BasicQVTiExecutor interpretedExecutor = null;
		private QVTiTransformationExecutor generatedExecutor = null;
		private Set<@NonNull String> nsURIs = new HashSet<@NonNull String>();
    	private Collection<@NonNull GenPackage> usedGenPackages = null;
		
		public MyQVT(@NonNull String testFolderName, @NonNull EPackage... eInstances) {
			super(new QVTiEnvironmentFactory(getProjectMap(), null));
			this.testFolderName = testFolderName;
			this.testFolderURI = TESTS_BASE_URI.appendSegment(testFolderName);
	        this.samplesBaseUri = testFolderURI.appendSegment("samples");
			installEPackages(eInstances);
		}

		public void addUsedGenPackage(@NonNull String resourcePath, @Nullable String fragment) {
	    	if (usedGenPackages == null) {
	    		usedGenPackages = new ArrayList<@NonNull GenPackage>();
	    	}
	    	URI uri = URI.createPlatformResourceURI(resourcePath, false);
	    	if (fragment != null) {
	    		uri = uri.appendFragment(fragment);
	    	}
			usedGenPackages.add((@NonNull GenPackage)getResourceSet().getEObject(uri, true));
		}

		public @NonNull Transformation compileTransformation(@NonNull String testFileName, @NonNull String outputName, @NonNull String basePrefix, @NonNull String middleNsURI) throws Exception {
			Map<@NonNull String, @NonNull Map<AbstractCompilerChain.Key<?>, Object>> options = new HashMap<@NonNull String, @NonNull Map<AbstractCompilerChain.Key<?>, Object>>();
			URI prefixURI = testFolderURI.appendSegment(testFileName);
			compilerChain = new QVTrCompilerChain(getEnvironmentFactory(), prefixURI, options);
			compilerChain.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, getSaveOptions());
			Map<@NonNull String, @Nullable String> traceOptions = new HashMap<@NonNull String, @Nullable String>();
			traceOptions.put(CompilerChain.TRACE_NS_URI, middleNsURI);
			compilerChain.setOption(CompilerChain.TRACE_STEP, CompilerChain.TRACE_OPTIONS_KEY, traceOptions);
			Map<@NonNull String, @Nullable String> genModelOptions = new HashMap<@NonNull String, @Nullable String>();
			genModelOptions.put(CompilerChain.GENMODEL_BASE_PREFIX, basePrefix);
			genModelOptions.put(CompilerChain.GENMODEL_COPYRIGHT_TEXT, "Copyright (c) 2015, 2016 Willink Transformations and others.\n;All rights reserved. This program and the accompanying materials\n;are made available under the terms of the Eclipse Public License v1.0\n;which accompanies this distribution, and is available at\n;http://www.eclipse.org/legal/epl-v10.html\n;\n;Contributors:\n;  E.D.Willink - Initial API and implementation");
			compilerChain.setOption(CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_USED_GENPACKAGES_KEY, usedGenPackages);
			compilerChain.setOption(CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_OPTIONS_KEY, genModelOptions);
	    	return compilerChain.compile(outputName);
		}

		public @NonNull Class<? extends Transformer> createGeneratedClass(@NonNull Transformation asTransformation, @NonNull String @NonNull... genModelFiles) throws Exception {
			ResourceSet resourceSet = getResourceSet();
			resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
			for (String genModelFile : genModelFiles) {
				URI genModelURI = testFolderURI.appendSegment(genModelFile);
				loadGenModel(genModelURI);
			}
			QVTiCodeGenerator cg = new QVTiCodeGenerator(getEnvironmentFactory(), asTransformation);
			QVTiCodeGenOptions options = cg.getOptions();
			options.setUseNullAnnotations(true);
//			options.setPackagePrefix("cg");
			cg.generateClassFile();
			cg.saveSourceFile("../" + PROJECT_NAME + "/test-gen/");
			File explicitClassPath = new File("../" + PROJECT_NAME + "/bin");
			String qualifiedClassName = cg.getQualifiedName();
			String javaCodeSource = cg.generateClassFile();
			OCL2JavaFileObject.saveClass(explicitClassPath.toString(), qualifiedClassName, javaCodeSource);	
			@SuppressWarnings("unchecked")
			Class<? extends Transformer> txClass = (Class<? extends Transformer>) OCL2JavaFileObject.loadExplicitClass(explicitClassPath, qualifiedClassName);
			if (txClass == null) {
				TestCase.fail("Failed to compile transformation");
				throw new UnsupportedOperationException();
			}
			return txClass;
		}
		
		public void createGeneratedExecutor(@NonNull Transformation asTransformation, @NonNull String @NonNull... genModelFiles) throws Exception {
			Class<? extends Transformer> txClass = createGeneratedClass(asTransformation, genModelFiles);
			createGeneratedExecutor(txClass);
		}

		public QVTiTransformationExecutor createGeneratedExecutor(Class<? extends Transformer> txClass)  throws Exception {
			return generatedExecutor = new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
		}

		public @NonNull BasicQVTiExecutor createInterpretedExecutor(@NonNull Transformation asTransformation) throws Exception {
			interpretedExecutor = new QVTiIncrementalExecutor(getEnvironmentFactory(), asTransformation, QVTiIncrementalExecutor.Mode.LAZY);
			return interpretedExecutor;
		}

		public void createModel(@NonNull String modelName, @NonNull String modelFile) {
	        URI modelURI = samplesBaseUri.appendSegment(modelFile);
	    	interpretedExecutor.createModel(modelName, modelURI, null);
		}

		@Override
		public synchronized void dispose() {
			super.dispose();
			if (interpretedExecutor != null) {
				interpretedExecutor.dispose();
			}
			if (compilerChain != null) {
				compilerChain.dispose();
			}
			/**
			 * Remove the eInstances from the EPackage.Registry.INSTANCE so that global registrations from the calling test
			 * do not confuse subsequent tests that may want to use dynamic models.
			 */
			for (String nsURI : nsURIs) {
				EPackage.Registry.INSTANCE.remove(nsURI);
			}
		}

		public void executeTransformation() throws Exception {
			if (interpretedExecutor != null) {
		        interpretedExecutor.execute();
		        interpretedExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);
			}
			else {
				generatedExecutor.getTransformer().run();
			}
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}

		public @NonNull Map<Object, Object> getSaveOptions() {		
			Map<Object, Object> saveOptions = new HashMap<Object, Object>(TestsXMLUtil.defaultSavingOptions);
			saveOptions.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
			return saveOptions;
		}

		/**
		 * Explicitly install the eInstances that would normally make it into the ProjectMap from extension point registrations.
		 * Test models are not registered via extension point so we have to do this manually.
		 */
		public void installEPackages(EPackage... eInstances) {
			ResourceSetImpl resourceSet = (ResourceSetImpl) getResourceSet();
			for (EPackage eInstance : eInstances) {
				nsURIs.add(eInstance.getNsURI());
				resourceSet.getURIResourceMap().put(testFolderURI.appendSegment(eInstance.getName()+".ecore"), eInstance.eResource());
			}
		}
				
		private void loadGenModel(@NonNull URI genModelURI) {
			ResourceSet resourceSet = getResourceSet();
			MetamodelManagerInternal metamodelManager = getMetamodelManager();
			Resource csGenResource = resourceSet.getResource(genModelURI, true);
			for (EObject eObject : csGenResource.getContents()) {
				if (eObject instanceof GenModel) {
					GenModel genModel = (GenModel)eObject;
					genModel.reconcile();
					metamodelManager.addGenModel(genModel);
				}
			}
		}

		public void loadInput(@NonNull String modelName, @NonNull String modelFile) {
	        URI modelURI = samplesBaseUri.appendSegment(modelFile);
	        if (interpretedExecutor != null) {
				interpretedExecutor.loadModel(modelName, modelURI);
	        }
	        else {
	        	Resource inputResource = getResourceSet().getResource(modelURI, true);
				generatedExecutor.getTransformer().addRootObjects(modelName, ClassUtil.nonNullState(inputResource.getContents()));
	        }
		}

		public void saveOutput(@NonNull String modelName, @NonNull String modelFile, @Nullable String expectedFile, @Nullable ModelNormalizer normalizer) throws IOException, InterruptedException {
	        URI modelURI = samplesBaseUri.appendSegment(modelFile);
	        URI referenceModelURI = samplesBaseUri.appendSegment(expectedFile);
			ResourceSet resourceSet = getResourceSet();
			Resource outputResource;
	        if (interpretedExecutor != null) {
		        outputResource = interpretedExecutor.saveModel(modelName, modelURI, null, getSaveOptions());
	        }
	        else {
				outputResource = resourceSet.createResource(modelURI);
				outputResource.getContents().addAll(generatedExecutor.getTransformer().getRootEObjects(modelName));
				outputResource.save(getSaveOptions());
	        }
			Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
			assert referenceResource != null;
			if (normalizer != null) {
				normalizer.normalize(referenceResource);
				normalizer.normalize(outputResource);
			}
	        assertSameModel(referenceResource, outputResource);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Before
    public void setUp() throws Exception {

		BaseLinkingService.DEBUG_RETRY.setState(true);
		super.setUp();
		OCLstdlib.install();
		QVTrTestUtil.doQVTrelationSetup();
		QVTcTestUtil.doQVTcoreSetup();
		QVTiTestUtil.doQVTimperativeSetup();
//		QVTrelationPivotStandaloneSetup.doSetup();
//		QVTimperativePivotStandaloneSetup.doSetup();
    }

	 /* (non-Javadoc)
     * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#tearDown()
     */
    @After
    public void tearDown() throws Exception {
		super.tearDown();
    }

	@Test
    public void testQVTrCompiler_SeqToStm() throws Exception {
		AbstractTransformer.EXCEPTIONS.setState(true);
		AbstractTransformer.INVOCATIONS.setState(true);
		Scheduler.DEBUG_GRAPHS.setState(true);;
    	MyQVT myQVT = new MyQVT("seq2stm");
    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	try {
	    	Transformation asTransformation = myQVT.compileTransformation("SeqToStm.qvtr", "stm", PROJECT_NAME + ".seq2stm", "http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/seq2stm/SeqToStm");
	    	myQVT.createInterpretedExecutor(asTransformation);
	    	myQVT.loadInput("seqDgm", "Seq.xmi");
	    	myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "Seq2Stmc_trace.xmi");
	    	myQVT.createModel("stm", "Stmc_Interpreted.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("stm", "Stmc_Interpreted.xmi", "Stmc_expected.xmi", null);
		}
		finally {
	    	myQVT.dispose();
		}
    }

	@Test
    public void testQVTrCompiler_SeqToStm_CG() throws Exception {
		AbstractTransformer.EXCEPTIONS.setState(true);
		AbstractTransformer.INVOCATIONS.setState(true);
		Scheduler.DEBUG_GRAPHS.setState(true);;
    	QVTm2QVTp.PARTITIONING.setState(true);
    	MyQVT myQVT = new MyQVT("seq2stm"); //, SeqMMPackage.eINSTANCE, StmcMMPackage.eINSTANCE, PSeqToStmPackage.eINSTANCE);
    	try {
	    	String projectTestName = PROJECT_NAME + ".seq2stm";
			Transformation asTransformation = myQVT.compileTransformation("SeqToStm.qvtr", "stm", projectTestName, "http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/seq2stm/SeqToStm");
			JavaSourceFileObject.compileClasses("../" + PROJECT_NAME + "/test-gen/" + projectTestName.replace(".",  "/"), "../" + PROJECT_NAME + "/bin");
	    	Class<?> seqmmClass = Class.forName(projectTestName + ".SeqMM.SeqMMPackage");
	    	Field seqmmField = seqmmClass.getDeclaredField("eINSTANCE");
	    	EPackage seqmmEPackage = (EPackage) seqmmField.get(null);
	    	myQVT.getResourceSet().getPackageRegistry().put(seqmmEPackage.getNsURI(), seqmmEPackage);
	    	Class<? extends Transformer> txClass = myQVT.createGeneratedClass(asTransformation, "SeqToStm.genmodel");
	    	//
	        myQVT.createGeneratedExecutor(txClass);
	    	myQVT.loadInput("seqDgm", "Seq.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("stm", "Stmc_CG.xmi", "Stmc_expected.xmi", null);
		}
		finally {
	    	myQVT.dispose();
		}
    }

	@Test
    public void testQVTrCompiler_SimplerRel2Core_CG() throws Exception {
//		AbstractTransformer.EXCEPTIONS.setState(true);
//		AbstractTransformer.INVOCATIONS.setState(true);
 //   	QVTm2QVTp.PARTITIONING.setState(true);
    	MyQVT myQVT = new MyQVT("rel2core");
    	try {
	    	String projectTestName = PROJECT_NAME + ".rel2core";
	    	myQVT.addUsedGenPackage("org.eclipse.ocl.pivot/model/Pivot.genmodel", "//pivot");
			myQVT.addUsedGenPackage("org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.genmodel", "//qvtbase");
			myQVT.addUsedGenPackage("org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.genmodel", "//qvtrelation");
			myQVT.addUsedGenPackage("org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.genmodel", "//qvttemplate");
	    	Transformation asTransformation = myQVT.compileTransformation("SimplerRelToCorePivotizedBeautyfied.qvtr", "core", projectTestName, "http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/rel2core/SeqToStm");
			JavaSourceFileObject.compileClasses("../" + PROJECT_NAME + "/test-gen/" + projectTestName.replace(".",  "/"), "../" + PROJECT_NAME + "/bin");
//	    	myQVT.installClassName(projectTestName + ".SeqMM.SeqMMPackage");
//	    	myQVT.installClassName(projectTestName + ".PSeqToStm.PSeqToStmPackage");
	    	Class<? extends Transformer> txClass = myQVT.createGeneratedClass(asTransformation, "SimplerRelToCorePivotizedBeautyfied.genmodel");
	    	//
	        myQVT.createGeneratedExecutor(txClass);
	    	myQVT.loadInput("relations", "Rel2Core.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("core", "Rel2Core_CG.xmi", "Rel2Core_expected.xmi", null);
	    	//
//	        myQVT.createGeneratedExecutor(txClass);
//	    	myQVT.loadInput("seqDgm", "SeqUM.xmi");
//	    	myQVT.executeTransformation();
//			myQVT.saveOutput("stm", "StmcUM_CG.xmi", "StmcUM_expected.xmi", null);
		}
		finally {
	    	myQVT.dispose();
		}
    }
}
