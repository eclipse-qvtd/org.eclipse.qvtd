/*******************************************************************************
 * Copyright (c) 2017, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.atl.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.dsls.core.EMFTCSInjector;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceFactoryImpl;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.pivot.qvtimperative.model.QVTimperativeLibrary;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.junit.Test;

/**
 * Tests that ATL-based examples work.
 */
public class ATLExampleTests extends LoadTestCase
{
	protected static class MyQVT extends AbstractTestQVT
	{
		public final static @NonNull Map<Object, Object> defaultSavingOptions;

		// FIXME use a better default strategy for the saving options
		static {
			defaultSavingOptions = new HashMap<Object, Object>();
			defaultSavingOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
			defaultSavingOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
			defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
			defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
			defaultSavingOptions.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
			defaultSavingOptions.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
		}

		public MyQVT(@NonNull ProjectManager projectManager, @NonNull TestProject testProject, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI) throws IOException {
			super(projectManager, testProject, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
			environmentFactory.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
			//			getMetamodelManager().getASResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());	// FIXME wrong ResourceSet
			// Ensure ATL parser support is on classpath
			AtlParser.class.getName();
			EMFModel.class.getName();
			EMFTCSInjector.class.getName();
			EmftvmFactory.class.getName();
		}

		protected void checkOutput(@NonNull Resource outputResource, @NonNull URI referenceModelURI) throws IOException, InterruptedException {
			Resource referenceResource = outputResource.getResourceSet().getResource(referenceModelURI, true);
			assert referenceResource != null;
			assertSameModel(referenceResource, outputResource);
		}

		public @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
			QVTrelationEnvironmentThreadFactory environmentThreadFactory = new QVTrelationEnvironmentThreadFactory(getTestProjectManager());
			return checkOutput(environmentThreadFactory, actualURI, expectedURI, normalizer);
		}

		@Override
		protected @NonNull AbstractCompilerChain createCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
			return new QVTrCompilerChain(projectManager, txURI, intermediateFileNamePrefixURI, options);
		}

		@Override
		protected @NonNull String getBasePrefix() {
			return "org.eclipse.qvtd.atl.tests";
		}

		@Override
		public @NonNull Map<Object, Object> getSaveOptions() {
			Map<Object, Object> saveOptions = new HashMap<>(defaultSavingOptions);
			saveOptions.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
			return saveOptions;
		}
	}

	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTrelation.newInstance(getTestProjectManager(), null);
	}

	protected @NonNull MyQVT createQVT(@NonNull String resultPrefix, @NonNull URI txURI) throws Exception {
		ProjectManager testProjectManager = getTestProjectManager();
		URI intermediateFileNamePrefixURI = getTestURI(resultPrefix);
		URI srcFileURI = getTestFileURI(JavaFileUtil.TEST_SRC_FOLDER_NAME + "/");
		URI binFileURI = getTestFileURI(JavaFileUtil.TEST_BIN_FOLDER_NAME + "/");
		return new MyQVT(testProjectManager, getTestProject(), getTestBundleURI(), txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
	}

	protected void doATLExampleTest_CG(@NonNull String resultPrefix, @NonNull URI atlURI) throws Throwable {
		MyQVT myQVT = createQVT(resultPrefix, atlURI);
		try {
			Class<?> txClass = Class.forName("org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr");		// FIXME Use direct reference once generation works redliably
			@SuppressWarnings("unchecked")
			@NonNull Class<? extends Transformer> txCastClass = (Class<? extends Transformer>)txClass;
			myQVT.createGeneratedExecutor(txCastClass);
			URI atlXMIURI = getTestURIWithExtension(atlURI, "xmi");
			Resource atlResource = myQVT.addInputURI("atl", atlURI);
			assert atlResource != null;
			EList<@NonNull EObject> contents = atlResource.getContents();
			assert !contents.isEmpty() : "ATL's ANTLR cannot co-exist with Xext's ANTLR - run test separately";
			Resource atlXmiResource = atlResource.getResourceSet().createResource(atlXMIURI);
			atlXmiResource.getContents().addAll(contents);
			atlXmiResource.save(XMIUtil.createSaveOptions());
			contents.addAll(atlXmiResource.getContents());
			String name = atlURI.trimFileExtension().lastSegment();
			URI outputURI = getTestURIWithExtension(atlURI.trimSegments(1).appendSegment(name + "_CG.qvtras"), QVTrelationUtil.QVTRAS_FILE_EXTENSION);
			try {
				myQVT.executeTransformation();
				myQVT.addOutputURI("qvtr", outputURI);
				myQVT.saveModels(null);
				myQVT.checkOutput(outputURI, atlURI.trimSegments(1).appendSegment(name + "_expected.qvtras"), null);
			}
			catch (InvalidEvaluationException e) {
				myQVT.addOutputURI("qvtr", outputURI);
				myQVT.saveModels(null);
				throw e;
			}
		}
		finally {
			myQVT.dispose();
		}
	}

	@Override
	protected void setUp() throws Exception {
		QVTimperativeLibrary.install();
		XtextCompilerUtil.doQVTrelationSetup();
		super.setUp();
	}

	@Test
	public void testATL2QVTr_Families2Persons_CG() throws Throwable {
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//		QVTrelationToStringVisitor.FACTORY.getClass();
		doATLExampleTest_CG("Families2Persons", getModelsURI("families2persons/Families2Persons.atl"));
	}

	/*	@Test
	public void testATLExample_Families2PersonsMini_CG() throws Exception {
		AbstractTransformer.EXCEPTIONS.setState(true);
		AbstractTransformer.INVOCATIONS.setState(true);
		//		PivotStandaloneSetup.init();
		QVTimperativeLibrary.install();
		QVTrelationToStringVisitor.FACTORY.getClass();
		doATLExampleTest_CG("Families2PersonsMini");
	} */
}
