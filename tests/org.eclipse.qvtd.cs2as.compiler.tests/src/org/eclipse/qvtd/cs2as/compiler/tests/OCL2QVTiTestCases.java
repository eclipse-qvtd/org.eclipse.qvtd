/*******************************************************************************
 * Copyright (c) 2014, 2021 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.tests;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.pivot.tests.PivotTestCaseWithAutoTearDown.AbstractTestThread;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemOwner;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompilerParameters;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerImpl;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerParametersImpl;
import org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTiCompilerChain;
import org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTm;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThread;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT.PartitionUsage;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.QVTbaseTestFileSystemHelper;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

// Manual load tests rely on previous generation of the class to load. - testExample1_CGManual
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OCL2QVTiTestCases extends LoadTestCase
{
	//	private static final boolean CREATE_GRAPHML = false; // Note. You need Epsilon with Bug 458724 fix to have output graphml models serialised
	private static boolean NO_MERGES = true;				// Set true to suppress the complexities of merging

	protected abstract class AbstractOCL2QVTiThread<R> extends QVTimperativeEnvironmentThread<R>
	{
		protected final @NonNull String modelTestName;
		protected final @NonNull PartitionUsage partitionUsage = new PartitionUsage();

		protected AbstractOCL2QVTiThread(@NonNull QVTimperativeEnvironmentThreadFactory environmentThreadFactory, @NonNull String threadName, @NonNull String modelTestName) {
			super(environmentThreadFactory, threadName);
			this.modelTestName = modelTestName;
		}

		protected void assertRegionCount(@NonNull Class<? extends Region> partitionClass, int count) {
			QVTruntimeUtil.errPrintln("assertRegionCount suppressed");
		}

		protected @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
			QVTimperativeEnvironmentThreadFactory environmentThreadFactory = createQVTimperativeEnvironmentThreadFactory() ;
			AbstractTestThread<@NonNull Resource, @NonNull QVTimperativeEnvironmentFactory, @Nullable OCLInternal> checkThread = new AbstractTestThread<@NonNull Resource, @NonNull QVTimperativeEnvironmentFactory, @Nullable OCLInternal>("Check-Output", environmentThreadFactory)
			{
				@Override
				protected OCLInternal createOCL() {
					OCL ocl = QVTbase.newInstance(getTestProjectManager());
					ocl.getEnvironmentFactory().setSeverity(PivotPackage.Literals.VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP, StatusCodes.Severity.IGNORE);
					return (OCLInternal) ocl;
				}

				@Override
				public @NonNull Resource runWithThrowable() throws Exception {
					ResourceSet actualResourceSet = createTestResourceSet();
					//		if (PivotUtilInternal.isASURI(modelURI)) {
					//			resourceSet = environmentFactory.getMetamodelManager().getASResourceSet();	// Need PivotSave to allocate xmi:ids
					//		}
					//		else {
					//			resourceSet = getResourceSet();
					//		}
					Resource actualResource = ClassUtil.nonNullState(actualResourceSet.getResource(actualURI, true));
					EcoreUtil.resolveAll(actualResourceSet);
					if (expectedURI != null) {
						String actualFileStem = actualURI.trimFileExtension().lastSegment();
						String expectedFileStem = expectedURI.trimFileExtension().lastSegment();
						if ((actualFileStem != null) && (expectedFileStem != null) && !actualFileStem.equals(expectedFileStem) && actualFileStem.startsWith(expectedFileStem)) {
							String suffix = actualFileStem.substring(expectedFileStem.length());
							for (Resource resource : actualResourceSet.getResources()) {
								URI resourceURI = resource.getURI();
								String fileExtension = resourceURI.fileExtension();
								URI trimmedURI = resourceURI.trimFileExtension();
								String fileStem = trimmedURI.lastSegment();
								if ((fileStem != null) && fileStem.endsWith(suffix) ) {
									String trimmedFileStem = fileStem.substring(0, fileStem.length() - suffix.length());
									resource.setURI(trimmedURI.trimSegments(1).appendSegment(trimmedFileStem).appendFileExtension(fileExtension));
								}
							}
						}
						checkOutput(actualResource, expectedURI, normalizer);
					}
					return actualResource;
				}
			};
			return checkThread.invoke();
		}

		private void checkOutput(@NonNull Resource outputResource, @NonNull URI referenceModelURI, @Nullable ModelNormalizer normalizer) throws IOException, InterruptedException {
			ResourceSet referenceResourceSet = createTestResourceSet();
			Resource referenceResource = referenceResourceSet.getResource(referenceModelURI, true);
			assert referenceResource != null;
			EcoreUtil.resolveAll(referenceResourceSet);
			if (normalizer != null) {
				assert !referenceResource.getContents().isEmpty() : referenceResource.getURI() + " has no contents";
				assert !outputResource.getContents().isEmpty() : outputResource.getURI() + " has no contents";
				normalizer.normalize(referenceResource);
				normalizer.normalize(outputResource);
			}
			LoadTestCase.assertSameModel(referenceResource, outputResource);
		}

		private @NonNull ResourceSet createTestResourceSet() {
			ResourceSet actualResourceSet = new ResourceSetImpl();
			getEnvironmentFactory().getProjectManager().initializeResourceSet(actualResourceSet);
			return actualResourceSet;
		}

		protected @NonNull ImperativeTransformation generateTransformation(@NonNull String mainOclDoc, @NonNull String... extendedOclDocs) throws Exception {
			DefaultCompilerOptions compilerOptions = createCompilerOptions();
			TestFileSystemOwner testFileSystemOwner = getTestFileSystemOwner();
			ProjectManager projectManager = testFileSystemOwner.getTestProjectManager();
			ResourceSet resourceSet = getEnvironmentFactory().getResourceSet();
			URI mainOclDocURI = testFileSystemOwner.getModelsURI(modelTestName + "/" + mainOclDoc);
			@NonNull URI[] oclDocURIs = new @NonNull URI[extendedOclDocs.length];
			for (int i=0; i < extendedOclDocs.length; i++) {
				oclDocURIs[i] = testFileSystemOwner.getModelsURI(modelTestName + "/" + extendedOclDocs[i]);
			}
			OCL2QVTiCompilerChain compiler = new OCL2QVTiCompilerChain(projectManager, resourceSet, compilerOptions, mainOclDocURI, testFileSystemOwner.getTestURIWithExtension(mainOclDocURI, null), oclDocURIs)
			{
				@Override
				protected @NonNull QVTm2QVTsCompilerStep createQVTm2QVTsCompilerStep() {
					return new QVTm2QVTsCompilerStep(this)
					{
						@Override
						public @NonNull ScheduleManager execute(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull Resource pResource, @NonNull TypedModelsConfiguration typedModelsConfiguration) throws IOException {
							ScheduleManager scheduleManager = super.execute(environmentFactory, pResource, typedModelsConfiguration);
							partitionUsage.instrumentPartition(scheduleManager);
							return scheduleManager;
						}
					};
				}
			};
			ImperativeTransformation iTransformation = compiler.compile(OCL2QVTm.RIGHT_MODEL_TYPE_NAME);
			URI txURI = iTransformation.eResource().getURI();
			if (txURI != null) {
				URI inputURI = txURI;
				URI serializedURI = testFileSystemOwner.getTestURIWithExtension(inputURI, "serialized.qvti");
				AbstractTestQVT.doSerialize(projectManager, inputURI, serializedURI);
			}
			return iTransformation;
		}

		protected @NonNull URI generateTransformationURI(@NonNull String mainOclDoc, @NonNull String... extendedOclDocs) throws Exception {
			ImperativeTransformation iTransformation = generateTransformation(mainOclDoc, extendedOclDocs);
			URI uri = iTransformation.eResource().getURI();
			assert uri != null;
			return uri;
		}

		protected void loadEcoreFile(URI fileURI, EPackage ePackage) {
			ResourceSet rSet = getEnvironmentFactory().getResourceSet();
			rSet.getPackageRegistry().put(fileURI.toString(), ePackage);
			EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
		}

		protected void loadGenModel(@NonNull URI genModelURI) {
			ResourceSet resourceSet = getEnvironmentFactory().getResourceSet();
			MetamodelManagerInternal metamodelManager = getEnvironmentFactory().getMetamodelManager();
			Resource csGenResource = resourceSet.getResource(genModelURI, true);
			for (EObject eObject : csGenResource.getContents()) {
				if (eObject instanceof GenModel) {
					GenModel genModel = (GenModel)eObject;
					genModel.reconcile();
					metamodelManager.addGenModel(genModel);
				}
			}
		}
	}

	public abstract class OCL2QVTiCodeGenerationThread extends AbstractOCL2QVTiThread<@NonNull Class<? extends Transformer>>
	{
		protected OCL2QVTiCodeGenerationThread(@NonNull String modelTestName) {
			super(createQVTimperativeEnvironmentThreadFactory(), "OCL2QVTi-CodeGeneration", modelTestName);
		}

		protected @NonNull Class<? extends Transformer> compileTransformation(@NonNull ImperativeTransformation iTransformation, @NonNull CS2ASJavaCompilerParameters cgParams) throws Exception {
			//	QVTimperativeEnvironmentThreadFactory threadFactory = createQVTimperativeEnvironmentThreadFactory();
			//	QVTimperativeEnvironmentThread<@NonNull Class<? extends CS2ASTransformer>> compilationThread = new QVTimperativeEnvironmentThread<@NonNull Class<? extends CS2ASTransformer>>(threadFactory, "OCL2QVTi-Compilation")
			//	{
			//		@Override
			//		protected @NonNull Class<? extends CS2ASTransformer> runWithThrowable() throws Exception {
			CS2ASJavaCompilerImpl cs2as2java = new CS2ASJavaCompilerImpl();
			return cs2as2java.compileTransformation(getEnvironmentFactory(), iTransformation, cgParams);
			//		}
			//	};
			//	return compilationThread.invoke();
		}

		@Override
		protected @NonNull QVTimperativeEnvironmentFactory createEnvironmentFactory() {
			QVTimperativeEnvironmentFactory environmentFactory = super.createEnvironmentFactory();
			//			installEPackages(eInstances);
			//
			// http://www.eclipse.org/emf/2002/Ecore is referenced by just about any model load
			// Ecore.core is referenced from Ecore.genmodel that is used by the CG to coordinate Ecore objects with their Java classes
			// therefore suppress diagnostics about confusing usage.
			//
			getProjectManager().configureLoadFirst(environmentFactory.getResourceSet(), EcorePackage.eNS_URI);	// XXX transitive usedGenModels
			return environmentFactory;
		}
	}

	public abstract class OCL2QVTiCodeExecutionThread extends AbstractOCL2QVTiThread<Object>
	{
		protected final @NonNull Class<? extends Transformer> txClass;
		private QVTiTransformationExecutor executor;
		private boolean suppressFailureDiagnosis = false;				// FIXME BUG 511028

		protected OCL2QVTiCodeExecutionThread(@NonNull Class<? extends Transformer> txClass, @NonNull String modelTestName) {
			super(createQVTimperativeEnvironmentThreadFactory(), "OCL2QVTi-Execution", modelTestName);
			this.txClass = txClass;
		}

		protected @Nullable Resource addInputURI(@NonNull String modelName, @NonNull URI modelURI) {
			return executor.addInputURI(modelName, modelURI);
		}

		protected @NonNull Resource addOutputURI(@NonNull String modelName, @NonNull URI modelURI) {
			return executor.addOutputURI(modelName, modelURI);
		}

		protected @NonNull QVTiTransformationExecutor createGeneratedExecutor(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull Class<? extends Transformer> txClass) throws ReflectiveOperationException {
			QVTiTransformationExecutor generatedExecutor = new QVTiTransformationExecutor(environmentFactory, txClass);
			this.executor = generatedExecutor;
			return generatedExecutor;
		}

		//
		// Execute the transformation with the code generator
		//
		protected void executeModelTest(@NonNull String modelName) throws Exception {
			String inputURIstring = modelTestName + "/samples/" + modelName + "_input.xmi";
			String outURIstring = modelName + "_output_CG.xmi";
			String refURIstring = modelTestName + "/samples/" + modelName + "_output_ref.xmi";
			this.executor = createGeneratedExecutor(getEnvironmentFactory(), txClass);
			addInputURI(OCL2QVTm.LEFT_MODEL_TYPE_NAME, getModelsURI(inputURIstring));
			assertTrue(executeTransformation());
			addOutputURI(OCL2QVTm.RIGHT_MODEL_TYPE_NAME, getTestURI(outURIstring));
			saveModels(null);
			checkOutput(getTestURI(outURIstring), getModelsURI(refURIstring), null);
		}

		protected boolean executeTransformation() throws Exception {
			if (suppressFailureDiagnosis) {
				executor.setSuppressFailureDiagnosis(true);
			}
			Boolean success = executor.execute(null);
			return success == Boolean.TRUE;
		}

		protected void saveModels(@Nullable Map<?, ?> saveOptions) throws IOException {
			executor.getModelsManager().saveModels(saveOptions);
		}
	}

	public abstract class OCL2QVTiTxGenerationThread extends AbstractOCL2QVTiThread<@NonNull URI>
	{
		protected OCL2QVTiTxGenerationThread(@NonNull String modelTestName) {
			super(createQVTimperativeEnvironmentThreadFactory(), "OCL2QVTi-TxGeneration", modelTestName);
		}

		@Override
		protected @NonNull QVTimperativeEnvironmentFactory createEnvironmentFactory() {
			QVTimperativeEnvironmentFactory environmentFactory = super.createEnvironmentFactory();
			//			installEPackages(eInstances);
			//
			// http://www.eclipse.org/emf/2002/Ecore is referenced by just about any model load
			// Ecore.core is referenced from Ecore.genmodel that is used by the CG to coordinate Ecore objects with their Java classes
			// therefore suppress diagnostics about confusing usage.
			//
			getProjectManager().configureLoadFirst(environmentFactory.getResourceSet(), EcorePackage.eNS_URI);	// XXX transitive usedGenModels
			return environmentFactory;
		}
	}

	public abstract class OCL2QVTiTxInterpretationThread extends AbstractOCL2QVTiThread<Object>
	{
		protected @NonNull URI txURI;
		private ImperativeTransformation iTransformation;
		private BasicQVTiExecutor executor;
		private boolean suppressFailureDiagnosis = false;				// FIXME BUG 511028

		protected OCL2QVTiTxInterpretationThread(@NonNull URI txURI, @NonNull String modelTestName) {
			super(createQVTimperativeEnvironmentThreadFactory(), "OCL2QVTi-TxInterpretation", modelTestName);
			this.txURI = txURI;
		}

		protected @Nullable Resource addInputURI(@NonNull String modelName, @NonNull URI modelURI) {
			return executor.addInputURI(modelName, modelURI);
		}

		protected @NonNull Resource addOutputURI(@NonNull String modelName, @NonNull URI modelURI) {
			return executor.addOutputURI(modelName, modelURI);
		}

		protected @NonNull BasicQVTiExecutor createInterpretedExecutor() throws Exception {
			assert iTransformation != null;
			EntryPoint entryPoint = QVTimperativeUtil.getDefaultEntryPoint(iTransformation);
			BasicQVTiExecutor interpretedExecutor = new BasicQVTiExecutor(getEnvironmentFactory(), entryPoint, ModeFactory.LAZY);	// XXX redundant argument
			this.executor = interpretedExecutor;
			return interpretedExecutor;
		}

		//
		// Execute the transformation with the QVTi interpreter
		//
		protected void executeModelTest(@NonNull String modelName) throws Exception {
			String inputURIstring = modelTestName + "/samples/" + modelName + "_input.xmi";
			String outURIstring = modelName + "_output_Interpreted.xmi";
			String refURIstring = modelTestName + "/samples/" + modelName + "_output_ref.xmi";
			createInterpretedExecutor();
			addInputURI(OCL2QVTm.LEFT_MODEL_TYPE_NAME, getModelsURI(inputURIstring));
			assertTrue(executeTransformation());
			addOutputURI(OCL2QVTm.RIGHT_MODEL_TYPE_NAME, getTestURI(outURIstring));
			saveModels(null);
			checkOutput(getTestURI(outURIstring), getModelsURI(refURIstring), null);
		}

		protected boolean executeTransformation() throws Exception {
			if (suppressFailureDiagnosis) {
				executor.setSuppressFailureDiagnosis(true);
			}
			Boolean success = executor.execute(null);
			return success == Boolean.TRUE;
		}

		protected void loadTransformation() {
			Resource resource = getEnvironmentFactory().getMetamodelManager().getASResourceSet().getResource(txURI, true);
			for (EObject eObject : resource.getContents()) {
				if (eObject instanceof ImperativeModel) {
					for (org.eclipse.ocl.pivot.Package pPackage : ((ImperativeModel)eObject).getOwnedPackages()) {
						for (org.eclipse.ocl.pivot.Class pClass : pPackage.getOwnedClasses()) {
							if (pClass instanceof ImperativeTransformation) {
								iTransformation = (ImperativeTransformation) pClass;
								return;
							}
						}
					}
				}
			}
			throw new IllegalStateException("No transformation");
		}

		protected void saveModels(@Nullable Map<?, ?> saveOptions) throws IOException {
			executor.getModelsManager().saveModels(saveOptions);
		}
	}

	protected class MyQVT extends AbstractTestQVT
	{
		protected final @NonNull PartitionUsage partitionUsage = new PartitionUsage();
		protected final @NonNull String modelTestName;
		protected final @NonNull String modelSamples;

		public MyQVT(@NonNull ProjectManager projectManager, @NonNull TestProject testProject, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI, @NonNull String modelTestName, @NonNull String modelSamples) throws IOException {
			super(projectManager, testProject, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
			this.modelTestName = modelTestName;
			this.modelSamples = modelSamples;
		}

		public @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
			QVTimperativeEnvironmentThreadFactory environmentThreadFactory = createQVTimperativeEnvironmentThreadFactory() ;
			return checkOutput(environmentThreadFactory, actualURI, expectedURI, normalizer);
		}

		@Override
		protected @NonNull AbstractCompilerChain createCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
			try {
				return new OCL2QVTiCompilerChain(getTestProjectManager(), getResourceSet(), createCompilerOptions(), txURI, getTestURIWithExtension(txURI, null));
			} catch (CompilerChainException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IllegalStateException(e);
			}
		}

		@Override
		protected @NonNull DefaultCompilerOptions createCompilerOptions() {
			DefaultCompilerOptions options = super.createCompilerOptions();
			options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.SAVE_OPTIONS_KEY, DefaultCompilerOptions.defaultSavingOptions);
			options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.DEBUG_KEY, true);
			// TODO problem when validating options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.VALIDATE_KEY, true);
			options.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_EARLY_MERGE, NO_MERGES);
			options.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_LATE_CONSUMER_MERGE, NO_MERGES);
			return options;
		}

		@Override
		protected @NonNull ResourceSet createTestResourceSet() {
			return super.createTestResourceSet();
		}

		//
		// Execute the transformation with the QVTi interpreter
		//
		protected void executeModelsTX_Interpreted(@NonNull ImperativeTransformation tx, @NonNull String modelName) throws Exception {
			String inputURIstring = modelTestName + "/" + modelSamples + "/" + modelName + "_input.xmi";
			String outURIstring = modelName + "_output_Interpreted.xmi";
			String refURIstring = modelTestName + "/" + modelSamples + "/" + modelName + "_output_ref.xmi";
			createInterpretedExecutor(getEnvironmentFactory(), tx);
			addInputURI(OCL2QVTm.LEFT_MODEL_TYPE_NAME, getModelsURI(inputURIstring));
			assertTrue(executeTransformation());
			addOutputURI(OCL2QVTm.RIGHT_MODEL_TYPE_NAME, getTestURI(outURIstring));
			saveModels(null);
			checkOutput(getTestURI(outURIstring), getModelsURI(refURIstring), null);
		}

		@Override
		protected @NonNull String getBasePrefix() {
			return "org.eclipse.qvtd.cs2as.compiler.tests";
		}

		@Override
		protected @NonNull ProjectManager getTestProjectManager(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) {
			return OCL2QVTiTestCases.this.getTestProjectManager(pathFromCurrentWorkingDirectoryToFileSystem);
		}
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

	protected static void assertValidQVTiModel(@NonNull URI asURI) {

		// We don't generate QVTi models anymore. Perhaps do a QVTc validation if there is a QVTcore.ocl file
	}

	protected @NonNull Class<? extends Transformer> compileTransformation(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation iTransformation, @NonNull CS2ASJavaCompilerParameters cgParams) throws Exception {
		//	QVTimperativeEnvironmentThreadFactory threadFactory = createQVTimperativeEnvironmentThreadFactory();
		//	QVTimperativeEnvironmentThread<@NonNull Class<? extends CS2ASTransformer>> compilationThread = new QVTimperativeEnvironmentThread<@NonNull Class<? extends CS2ASTransformer>>(threadFactory, "OCL2QVTi-Compilation")
		//	{
		//		@Override
		//		protected @NonNull Class<? extends CS2ASTransformer> runWithThrowable() throws Exception {
		CS2ASJavaCompilerImpl cs2as2java = new CS2ASJavaCompilerImpl();
		return cs2as2java.compileTransformation(environmentFactory, iTransformation, cgParams);
		//		}
		//	};
		//	return compilationThread.invoke();
	}

	//	protected @NonNull CompilerOptions createCompilerOptions() {
	//		return new AbstractCompilerOptions() {};
	//	}

	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTimperative.newInstance(getTestProjectManager(), null);
	}

	protected @NonNull DefaultCompilerOptions createCompilerOptions() {
		DefaultCompilerOptions compilerOptions = new DefaultCompilerOptions();
		compilerOptions.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.DEBUG_KEY, true);
		compilerOptions.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.SAVE_OPTIONS_KEY, DefaultCompilerOptions.defaultSavingOptions);
		compilerOptions.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.DEBUG_KEY, true);
		// TODO problem when validating options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.VALIDATE_KEY, true);
		compilerOptions.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_EARLY_MERGE, NO_MERGES);
		compilerOptions.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_LATE_CONSUMER_MERGE, NO_MERGES);
		return compilerOptions;
	}

	private @NonNull CS2ASJavaCompilerParameters createParameters(@NonNull String lookupSolverClassName, @NonNull String lookupResultClassName) throws IOException {
		CS2ASJavaCompilerParametersImpl cgParams = new CS2ASJavaCompilerParametersImpl(lookupSolverClassName, lookupResultClassName,
			getTestProject().getOutputFile(JavaFileUtil.TEST_SRC_FOLDER_NAME).getFileString());
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			JavaClasspath classpath = CompilerUtil.createDefaultQVTiClasspath();
			classpath.addClass(getClass()/*getTestBundleName()*/);
			cgParams.setClasspath(classpath);
		}
		cgParams.setClassLoader(getClass().getClassLoader());
		return cgParams;
	}

	private @NonNull MyQVT createQVT(@NonNull String modelTestName, @NonNull URI txURI, @NonNull String modelSamples) throws Exception {
		//		return new MyQVT(getTestProjectManager(), modelTestName, modelSamples);
		ProjectManager testProjectManager = getTestProjectManager();
		URI intermediateFileNamePrefixURI = getTestURI(modelTestName);
		URI srcFileURI = getTestFileURI(JavaFileUtil.TEST_SRC_FOLDER_NAME + "/");
		URI binFileURI = getTestFileURI(JavaFileUtil.TEST_BIN_FOLDER_NAME + "/");
		return new MyQVT(testProjectManager, getTestProject(), getTestBundleURI(), txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI, modelTestName, modelSamples);
	}

	@Override
	protected @NonNull TestFileSystemHelper getTestFileSystemHelper() {
		QVTbaseTestFileSystemHelper testFileSystemHelper = new QVTbaseTestFileSystemHelper();
		testFileSystemHelper.addRequiredBundle("org.eclipse.qvtd.cs2as.compiler.tests");
		return testFileSystemHelper;
	}

	protected @NonNull TestFileSystemOwner getTestFileSystemOwner() {
		return this;
	}

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		QVTm2QVTs.DEBUG_GRAPHS.setState(true);;
		XtextCompilerUtil.doQVTimperativeSetup(); // To be able to add QVTimperative.ocl validation
		XtextCompilerUtil.doQVTcoreSetup();
		TestUtil.doCompleteOCLSetup();
	}

	@Override
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testOCL2QVTi_Source2Target_CG() throws Throwable {
		OCL2QVTiCodeGenerationThread compilationThread = new OCL2QVTiCodeGenerationThread("Source2Target")
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("Source2Target/SourceMM1.genmodel"));
				loadGenModel(getModelsURI("Source2Target/TargetMM1.genmodel"));
				loadEcoreFile(getModelsURI("Source2Target/EnvExample1.ecore"), example1.target.lookup.EnvironmentPackage.eINSTANCE);
				ImperativeTransformation iTransformation = generateTransformation("Source2Target.ocl");
				assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 23 : 19);
				//		myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 2);
				//		myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 0);
				//		myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
				CS2ASJavaCompilerParameters cgParams = createParameters("example1.target.lookup.util.TargetLookupSolver",
						"example1.target.lookup.util.TargetLookupResult");
				return compileTransformation(iTransformation, cgParams);
			}
		};
		Class<? extends Transformer> txClass = compilationThread.invoke();
		OCL2QVTiCodeExecutionThread executionThread = new OCL2QVTiCodeExecutionThread(txClass, "Source2Target")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				executeModelTest("model1");
				executeModelTest("model2");
				executeModelTest("model3");
				return null;
			}
		};
		executionThread.invoke();
		cleanup("http://cs2as/tests/example1/env/1.0",
			example1.source.SourcePackage.eNS_URI,
			example1.target.TargetPackage.eNS_URI);
	}

	/*	@Test
	public void testOCL2QVTi_Source2Target_CGManual() throws Exception {
		MyQVT myQVT = createQVT("Source2Target", getModelsURI("Source2Target/Source2TargetBase.ocl"), "samples");
		try {
			myQVT.loadEcoreFile("SourceMM1.ecore", example1.source.SourcePackage.eINSTANCE);
			myQVT.loadEcoreFile("TargetMM1.ecore", example1.target.TargetPackage.eINSTANCE);
			String testProjectName = getClass().getSimpleName() + "__" + "testOCL2QVTi_Source2Target_CG";
			TestProject testProject = getTestFileSystem().getTestProject(testProjectName, false);
			File file = testProject.getOutputFolder(JavaFileUtil.TEST_BIN_FOLDER_NAME).getFile();
			ExplicitClassLoader explicitClassLoader = new ExplicitClassLoader(file, "_Source2Target_qvtm_qvtcas", getClass().getClassLoader());
			@SuppressWarnings({"null", "unchecked"})
			@NonNull Class<? extends Transformer> txClass = (Class<? extends Transformer>) explicitClassLoader.loadClass("_Source2Target_qvtm_qvtcas.Source2Target_qvtm_qvtcas");
			OCL2QVTiCodeExecutionThread executionThread = new OCL2QVTiCodeExecutionThread(txClass)
			{
				@Override
				protected Object runWithThrowable() throws Exception {
					executeModelsTX_CG("model1");
					executeModelsTX_CG("model2");
					executeModelsTX_CG("model3");
					return null;
				}
			};
			executionThread.invoke();
		}
		finally {
			myQVT.dispose();
			EPackage.Registry.INSTANCE.remove(example1.source.SourcePackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example1.target.TargetPackage.eNS_URI);
		}
	} */

	@Test
	public void testOCL2QVTi_Source2Target_Interpreted() throws Throwable {
		testCaseAppender.uninstall();			// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		OCL2QVTiTxGenerationThread generationThread = new OCL2QVTiTxGenerationThread("Source2Target")
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("Source2Target/SourceMM1.genmodel"));
				loadGenModel(getModelsURI("Source2Target/TargetMM1.genmodel"));
				return generateTransformationURI("Source2Target.ocl");
			}
		};
		URI txURI = generationThread.invoke();
		OCL2QVTiTxInterpretationThread interpretationThread = new OCL2QVTiTxInterpretationThread(txURI, "Source2Target")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEcoreFile(getModelsURI("Source2Target/SourceMM1.ecore"), example1.source.SourcePackage.eINSTANCE);
				loadEcoreFile(getModelsURI("Source2Target/TargetMM1.ecore"), example1.target.TargetPackage.eINSTANCE);
				loadTransformation();
				//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
				executeModelTest("model1");
				executeModelTest("model2");
				executeModelTest("model3");
				return null;
			}
		};
		interpretationThread.invoke();
		EPackage.Registry.INSTANCE.remove(example1.source.SourcePackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example1.target.TargetPackage.eNS_URI);
	}

	@Test
	public void testOCL2QVTi_Source2Target_OCL2QVTm() throws Exception {
		MyQVT myQVT = createQVT("Source2Target", getModelsURI("Source2Target/Source2Target.ocl"), "samples");
		URI oclDocURI = getModelsURI("Source2Target/Source2Target.ocl");
		URI qvtmFileURI = getTestURI("Source2Target.qvtm.qvtcas");

		OCL2QVTiCompilerChain mtc = new OCL2QVTiCompilerChain(getTestProjectManager(), myQVT.getResourceSet(), createCompilerOptions(), oclDocURI, getTestURIWithExtension(oclDocURI, "tmp"));
		mtc.ocl2qvtmCompilerStep.ocl2qvtm(oclDocURI.appendFileExtension("oclas"));
		// Test the QVTm transformation can be loaded
		assertValidQVTiModel(qvtmFileURI);
		myQVT.dispose();
	}

	@Test
	public void testOCL2QVTi_SimpleClasses_CG() throws Throwable {
		OCL2QVTiCodeGenerationThread compilationThread = new OCL2QVTiCodeGenerationThread("SimpleClasses")
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("SimpleClasses/ClassesCS.genmodel"));
				loadGenModel(getModelsURI("SimpleClasses/Classes.genmodel"));
				loadEcoreFile(getModelsURI("SimpleClasses/EnvExample2.ecore"), example2.classes.lookup.EnvironmentPackage.eINSTANCE);
				ImperativeTransformation iTransformation = generateTransformation("classescs2as.ocl");
				assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 9 : 3);
				//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 2);
				//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 1);
				//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
				CS2ASJavaCompilerParameters cgParams = createParameters(
					"example2.classes.lookup.util.ClassesLookupSolver",
						"example2.classes.lookup.util.ClassesLookupResult");
				return compileTransformation(iTransformation, cgParams);
			}
		};
		Class<? extends Transformer> txClass = compilationThread.invoke();
		OCL2QVTiCodeExecutionThread executionThread = new OCL2QVTiCodeExecutionThread(txClass, "SimpleClasses")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				executeModelTest("model1");
				executeModelTest("model2");
				executeModelTest("model3");
				executeModelTest("model4");
				executeModelTest("model5");
				executeModelTest("model6");
				executeModelTest("model7");
				return null;
			}
		};
		executionThread.invoke();
		cleanup("http://cs2as/tests/example2/env/1.0",
			example2.classescs.ClassescsPackage.eNS_URI,
			example2.classes.ClassesPackage.eNS_URI);
	}

	@Test
	public void testOCL2QVTi_SimpleClasses_Interpreted() throws Throwable {
		testCaseAppender.uninstall();			// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		//		MyQVT myQVT = createQVT("SimpleClasses", getModelsURI("SimpleClasses/classescs2as.ocl"), "samples");
		OCL2QVTiTxGenerationThread generationThread = new OCL2QVTiTxGenerationThread("SimpleClasses")
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("SimpleClasses/ClassesCS.genmodel"));
				loadGenModel(getModelsURI("SimpleClasses/Classes.genmodel"));
				return generateTransformationURI("classescs2as.ocl");
			}
		};
		URI txURI = generationThread.invoke();
		OCL2QVTiTxInterpretationThread interpretationThread = new OCL2QVTiTxInterpretationThread(txURI, "SimpleClasses")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEcoreFile(getModelsURI("SimpleClasses/Classes.ecore"), example2.classes.ClassesPackage.eINSTANCE);
				loadEcoreFile(getModelsURI("SimpleClasses/ClassesCS.ecore"), example2.classescs.ClassescsPackage.eINSTANCE);
				loadEcoreFile(getModelsURI("SimpleClasses/classescs2as.ecore"), example2.classescstraces.ClassescstracesPackage.eINSTANCE);
				loadTransformation();
				executeModelTest("model1");
				executeModelTest("model2");
				executeModelTest("model3");
				//    	executeModelTest("model4");
				//    	executeModelTest("model5");
				//    	executeModelTest("model6");
				//    	executeModelTest("model7");
				return null;
			}
		};
		interpretationThread.invoke();
		EPackage.Registry.INSTANCE.remove(example2.classes.ClassesPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example2.classescs.ClassescsPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example2.classescstraces.ClassescstracesPackage.eNS_URI);
	}

	@Test
	public void testOCL2QVTi_StructuredClasses_CG() throws Throwable {
		OCL2QVTiCodeGenerationThread compilationThread = new OCL2QVTiCodeGenerationThread("StructuredClasses")
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("SimpleClasses/ClassesCS.genmodel"));
				loadGenModel(getModelsURI("SimpleClasses/Classes.genmodel"));
				ImperativeTransformation iTransformation = generateTransformation("classescs2asV2.ocl");
				assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 30 : 15);
				//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 5);
				//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 2);
				//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
				CS2ASJavaCompilerParameters cgParams = createParameters(
					"example2.classes.lookup.util.ClassesLookupSolver",
						"example2.classes.lookup.util.ClassesLookupResult");
				return compileTransformation(iTransformation, cgParams);
			}
		};
		Class<? extends Transformer> txClass = compilationThread.invoke();
		OCL2QVTiCodeExecutionThread executionThread = new OCL2QVTiCodeExecutionThread(txClass, "StructuredClasses")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEcoreFile(getModelsURI("SimpleClasses/Classes.ecore"), example2.classes.ClassesPackage.eINSTANCE);
				loadEcoreFile(getModelsURI("SimpleClasses/ClassesCS.ecore"), example2.classescs.ClassescsPackage.eINSTANCE);
				loadEcoreFile(getModelsURI("SimpleClasses/classescs2as.ecore"), example2.classescstraces.ClassescstracesPackage.eINSTANCE);
				executeModelTest("model1V2");
				executeModelTest("model2V2");
				executeModelTest("model3V2");
				executeModelTest("model4V2");
				return null;
			}
		};
		executionThread.invoke();
		EPackage.Registry.INSTANCE.remove(example2.classes.ClassesPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example2.classescs.ClassescsPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example2.classescstraces.ClassescstracesPackage.eNS_URI);
	}

	@Test
	public void testOCL2QVTi_StructuredClasses_Interpreted() throws Throwable {
		testCaseAppender.uninstall();	// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		OCL2QVTiTxGenerationThread generationThread = new OCL2QVTiTxGenerationThread("StructuredClasses")
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("SimpleClasses/ClassesCS.genmodel"));
				loadGenModel(getModelsURI("SimpleClasses/ClassesCS.genmodel"));
				return generateTransformationURI("classescs2asV2.ocl");
			}
		};
		URI txURI = generationThread.invoke();
		OCL2QVTiTxInterpretationThread interpretationThread = new OCL2QVTiTxInterpretationThread(txURI, "StructuredClasses")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEcoreFile(getModelsURI("SimpleClasses/Classes.ecore"), example2.classes.ClassesPackage.eINSTANCE);
				loadEcoreFile(getModelsURI("SimpleClasses/ClassesCS.ecore"), example2.classescs.ClassescsPackage.eINSTANCE);
				loadEcoreFile(getModelsURI("SimpleClasses/classescs2as.ecore"), example2.classescstraces.ClassescstracesPackage.eINSTANCE);
				loadTransformation();
				executeModelTest("model1V2");
				executeModelTest("model2V2");
				executeModelTest("model3V2");
				executeModelTest("model4V2");
				return null;
			}
		};
		interpretationThread.invoke();
		EPackage.Registry.INSTANCE.remove(example2.classes.ClassesPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example2.classescs.ClassescsPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example2.classescstraces.ClassescstracesPackage.eNS_URI);
	}

	//  Note supported anymore
	//	@Test
	//	public void testExample2_OCL2QVTm_MiddleModel() throws Exception {
	//		MyQVT myQVT = createQVT("example2");
	//		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
	//		URI oclDocURI = baseURI.appendSegment("classescs2as.ocl.oclas");
	//		URI qvtmFileURI = baseURI.appendSegment("classescs2as.qvtm.qvtcas");
	//		URI tracesMMURI = baseURI.appendSegment("classescs2as.ecore.oclas");
	//
	//		OCL2QVTiBrokerTester mtc = new OCL2QVTiBrokerTester(baseURI, "classescs2as.ocl", myQVT, false);
	//		mtc.runOCL2QVTm_MiddleModel(oclDocURI, qvtmFileURI, tracesMMURI);
	//		// Test the QVTm transformation can be loaded
	//		assertValidQVTiModel(qvtmFileURI);
	//		myQVT.dispose();
	//	}

	@Test
	public void testOCL2QVTi_SimpleClasses_OCL2QVTm_MiddleFolded() throws Exception {
		MyQVT myQVT = createQVT("SimpleClasses", getModelsURI("SimpleClasses/classescs2as.ocl"), "samples");
		URI oclDocURI = getModelsURI("SimpleClasses/classescs2as.ocl");
		URI qvtmFileURI = getTestURI("classescs2as.qvtm.qvtcas");
		OCL2QVTiCompilerChain mtc = new OCL2QVTiCompilerChain(getTestProjectManager(), myQVT.getResourceSet(), createCompilerOptions(), oclDocURI, getTestURIWithExtension(oclDocURI, "tmp"));
		mtc.ocl2qvtmCompilerStep.ocl2qvtm(oclDocURI.appendFileExtension("oclas"));
		// Test the QVTm transformation can be loaded
		assertValidQVTiModel(qvtmFileURI);
		myQVT.dispose();
	}

	@Test
	public void testOCL2QVTi_KiamaRewrite_CG() throws Throwable {
		OCL2QVTiCodeGenerationThread compilationThread = new OCL2QVTiCodeGenerationThread("KiamaRewrite")
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("KiamaRewrite/KiamaAS.genmodel"));
				loadGenModel(getModelsURI("KiamaRewrite/KiamaCS.genmodel"));
				ImperativeTransformation iTransformation = generateTransformation("KiamaRewrite.ocl");
				assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 11 : 6);
				//		myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 1);
				//		myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 1);
				//		myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
				CS2ASJavaCompilerParameters cgParams = createParameters("","");
				//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
				// FIXME BUG 484278 model0 has an invalid model TopCS.node[1] has a null value.
				//		executeModelsTX_CG(myQVT, txClass, testBaseURI, "model0");
				return compileTransformation(iTransformation, cgParams);
			}
		};
		Class<? extends Transformer> txClass = compilationThread.invoke();
		OCL2QVTiCodeExecutionThread executionThread = new OCL2QVTiCodeExecutionThread(txClass, "KiamaRewrite")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				executeModelTest("model1");
				return null;
			}
		};
		executionThread.invoke();
		EPackage.Registry.INSTANCE.remove(example3.kiamaas.KiamaasPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example3.kiamacs.KiamacsPackage.eNS_URI);
	}

	/*	@Test
	public void testExample3_CG2() throws Exception {
		EPackage.Registry.INSTANCE.put(example3.kiamaas.KiamaasPackage.eNS_URI, example3.kiamaas.KiamaasPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(example3.kiamacs.KiamacsPackage.eNS_URI, example3.kiamacs.KiamacsPackage.eINSTANCE);
		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT("example3");
		Class<? extends Transformer> txClass = KiamaRewrite_qvtm_qvtcas.class;
			OCL2QVTiCodeExecutionThread executionThread = new OCL2QVTiCodeExecutionThread(txClass)
			{
				@Override
				protected Object runWithThrowable() throws Exception {
					executeModelsTX_CG("model1");
					return null;
				}
			};
			executionThread.invoke();
		myQVT.dispose();
		EPackage.Registry.INSTANCE.remove(example3.kiamaas.KiamaasPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example3.kiamacs.KiamacsPackage.eNS_URI);
	} */

	@Test
	public void testOCL2QVTi_KiamaRewrite_Interpreted() throws Throwable {
		OCL2QVTiTxGenerationThread generationThread = new OCL2QVTiTxGenerationThread("KiamaRewrite")
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("KiamaRewrite/KiamaAS.genmodel"));
				loadGenModel(getModelsURI("KiamaRewrite/KiamaCS.genmodel"));
				return generateTransformationURI("KiamaRewrite.ocl");
			}
		};
		URI txURI = generationThread.invoke();
		OCL2QVTiTxInterpretationThread interpretationThread = new OCL2QVTiTxInterpretationThread(txURI, "KiamaRewrite")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				executeModelTest("model1");
				return null;
			}
		};
		interpretationThread.invoke();
	}

	@Test
	public void testOCL2QVTi_SimplerKiama_CG() throws Throwable {
		OCL2QVTiCodeGenerationThread compilationThread = new OCL2QVTiCodeGenerationThread("SimplerKiama")
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("SimplerKiama/SimplerKiamaAS.genmodel"));
				loadGenModel(getModelsURI("SimplerKiama/SimplerKiamaCS.genmodel"));
				ImperativeTransformation iTransformation = generateTransformation("SimplerKiama.ocl");
				assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 9 : 7);
				//		myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 1);
				//		myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 0);
				//		myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
				CS2ASJavaCompilerParameters cgParams = createParameters("","");
				//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
				// FIXME BUG 484278 model0 has an invalid model TopCS.node[1] has a null value.
				//		executeModelsTX_CG(myQVT, txClass, testBaseURI, "model0");
				return compileTransformation(iTransformation, cgParams);
			}
		};
		Class<? extends Transformer> txClass = compilationThread.invoke();
		OCL2QVTiCodeExecutionThread executionThread = new OCL2QVTiCodeExecutionThread(txClass, "SimplerKiama")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				executeModelTest("model1");
				executeModelTest("model2");
				executeModelTest("model3");
				return null;
			}
		};
		executionThread.invoke();
		EPackage.Registry.INSTANCE.remove(example4.kiamacs.KiamacsPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example4.kiamaas.KiamaasPackage.eNS_URI);
	}

	@Test
	public void testOCL2QVTi_SimplerKiama_Interpreted() throws Throwable {
		OCL2QVTiTxGenerationThread generationThread = new OCL2QVTiTxGenerationThread("SimplerKiama")
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("SimplerKiama/SimplerKiamaAS.genmodel"));
				loadGenModel(getModelsURI("SimplerKiama/SimplerKiamaCS.genmodel"));
				return generateTransformationURI("SimplerKiama.ocl");
				//				assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 11 : 6);
				//		myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 1);
				//		myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 1);
				//		myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
			}
		};
		URI txURI = generationThread.invoke();
		OCL2QVTiTxInterpretationThread interpretationThread = new OCL2QVTiTxInterpretationThread(txURI, "SimplerKiama")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
				// FIXME BUG 484278 model0 has an invalid model TopCS.node[1] has a null value.
				//    	executeModelTest("model0");
				executeModelTest("model1");
				executeModelTest("model2");
				executeModelTest("model3");
				return null;
			}
		};
		interpretationThread.invoke();
	}

	@Test
	public void testOCL2QVTi_BaseAndDerived_CG() throws Throwable {
		OCL2QVTiCodeGenerationThread compilationThread1 = new OCL2QVTiCodeGenerationThread("BaseAndDerived")
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("BaseAndDerived/SourceBaseMM.genmodel"));
				loadGenModel(getModelsURI("BaseAndDerived/TargetBaseMM.genmodel"));
				ImperativeTransformation iTransformation = generateTransformation("Source2TargetBase.ocl");
				assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 9 : 5);
				//		myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 2);
				//		myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 0);
				//		myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
				CS2ASJavaCompilerParameters cgParams = createParameters("", "");
				return compileTransformation(iTransformation, cgParams);
			}
		};
		Class<? extends Transformer> txClass1 = compilationThread1.invoke();
		OCL2QVTiCodeExecutionThread executionThread1 = new OCL2QVTiCodeExecutionThread(txClass1, "BaseAndDerived")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				executeModelTest("model1");
				return null;
			}
		};
		executionThread1.invoke();
		OCL2QVTiCodeGenerationThread compilationThread2 = new OCL2QVTiCodeGenerationThread("BaseAndDerived")
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("BaseAndDerived/SourceBaseMM.genmodel"));
				loadGenModel(getModelsURI("BaseAndDerived/TargetBaseMM.genmodel"));
				loadGenModel(getModelsURI("BaseAndDerived/SourceDerivedMM.genmodel"));
				loadGenModel(getModelsURI("BaseAndDerived/TargetDerivedMM.genmodel"));
				ImperativeTransformation iTransformation = generateTransformation("Source2TargetDerived.ocl", "Source2TargetBase.ocl");
				CS2ASJavaCompilerParameters cgParams = createParameters("", "");
				return compileTransformation(iTransformation, cgParams);
			}
		};
		Class<? extends Transformer> txClass2 = compilationThread2.invoke();
		OCL2QVTiCodeExecutionThread executionThread2 = new OCL2QVTiCodeExecutionThread(txClass2, "BaseAndDerived")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				executeModelTest("model2");
				return null;
			}
		};
		executionThread2.invoke();
		EPackage.Registry.INSTANCE.remove(example5.sbase.SbasePackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example5.sderived.SderivedPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example5.tbase.TbasePackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example5.tderived.TderivedPackage.eNS_URI);
	}

	@Test
	public void testOCL2QVTi_BaseAndDerived_Interpreted() throws Throwable {
		OCL2QVTiTxGenerationThread generationThread1 = new OCL2QVTiTxGenerationThread("BaseAndDerived")
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("BaseAndDerived/SourceBaseMM.genmodel"));
				loadGenModel(getModelsURI("BaseAndDerived/TargetBaseMM.genmodel"));
				return generateTransformationURI("Source2TargetBase.ocl");
			}
		};
		URI txURI1 = generationThread1.invoke();
		OCL2QVTiTxInterpretationThread interpretationThread1 = new OCL2QVTiTxInterpretationThread(txURI1, "BaseAndDerived")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				executeModelTest("model1");
				return null;
			}
		};
		interpretationThread1.invoke();
		OCL2QVTiTxGenerationThread generationThread2 = new OCL2QVTiTxGenerationThread("BaseAndDerived")
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				loadGenModel(getModelsURI("BaseAndDerived/SourceBaseMM.genmodel"));
				loadGenModel(getModelsURI("BaseAndDerived/TargetBaseMM.genmodel"));
				loadGenModel(getModelsURI("BaseAndDerived/SourceDerivedMM.genmodel"));
				loadGenModel(getModelsURI("BaseAndDerived/TargetDerivedMM.genmodel"));
				return generateTransformationURI("Source2TargetDerived.ocl", "Source2TargetBase.ocl");
			}
		};
		URI txURI2 = generationThread2.invoke();
		OCL2QVTiTxInterpretationThread interpretationThread2 = new OCL2QVTiTxInterpretationThread(txURI2, "BaseAndDerived")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				executeModelTest("model2");
				return null;
			}
		};
		interpretationThread2.invoke();
	}
}
