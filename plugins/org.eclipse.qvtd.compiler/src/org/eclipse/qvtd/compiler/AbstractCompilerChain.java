/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.JavaFileObject;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.ExplicitClassLoader;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.codegen.dynamic.JavaSourceFileObject;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTc2QVTu;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvti.QVTs2QVTi;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.QVTs2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtu2qvtm.QVTu2QVTm;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

import com.google.common.collect.Iterables;

public abstract class AbstractCompilerChain extends CompilerUtil implements CompilerChain
{
	private static final @NonNull Map<@NonNull String, @NonNull String> step2fileExtension = new HashMap<>();
	static {
		step2fileExtension.put(UMLX_STEP, "umlx");
		step2fileExtension.put(QVTR_STEP, "qvtras");
		step2fileExtension.put(TRACE_STEP, "trace.ecore");
		step2fileExtension.put(GENMODEL_STEP, "genmodel");
		step2fileExtension.put(QVTC_STEP, "qvtcas");
		step2fileExtension.put(QVTU_STEP, "qvtu.qvtcas");
		step2fileExtension.put(QVTM_STEP, "qvtm.qvtcas");
		step2fileExtension.put(QVTS_STEP, "qvtsas");
		step2fileExtension.put(QVTI_STEP, "qvtias");
		step2fileExtension.put(JAVA_STEP, "java");
		step2fileExtension.put(CLASS_STEP, "class");
	}

	protected static class JavaResult
	{
		@NonNull File file;
		@NonNull String code;
		@NonNull String qualifiedClassName;
		@NonNull String classPath;

		public JavaResult(@NonNull File file, @NonNull String code, @NonNull String qualifiedClassName, @NonNull String classPath) {
			super();
			this.file = file;
			this.code = code;
			this.qualifiedClassName = qualifiedClassName;
			this.classPath = classPath;
		}
	}

	protected static class Java2ClassCompilerStep extends AbstractCompilerStep
	{
		public Java2ClassCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, CLASS_STEP);
		}

		public @NonNull Class<? extends Transformer> execute(@NonNull URI txURI, @NonNull JavaResult javaResult) throws Exception {
			JavaClasspath classpath = basicGetOption(CLASSPATH_KEY);
			assert classpath != null;
			//	JavaFileObject compilationUnit = new OCL2JavaFileObject(javaResult.qualifiedClassName, javaResult.code);
			java.net.URI uri = new File(javaResult.file, javaResult.qualifiedClassName.replace(".", "/") + ".java").getCanonicalFile().toURI();
			JavaFileObject compilationUnit = new JavaSourceFileObject(uri);
			List<@NonNull JavaFileObject> compilationUnits = Collections.singletonList(compilationUnit);
			String problemMessage = JavaFileUtil.compileClasses(compilationUnits, javaResult.qualifiedClassName, javaResult.classPath, classpath);
			if (problemMessage != null) {
				throw new CompilerChainException(problemMessage);
			}
			File classFilePath = new File(javaResult.classPath);
			List<@NonNull String> packagePaths = JavaFileUtil.gatherPackageNames(classFilePath, null);
			ClassLoader testClassLoader = compilerChain.getClass().getClassLoader();
			ExplicitClassLoader classLoader = new ExplicitClassLoader(classFilePath, packagePaths, testClassLoader);
			@SuppressWarnings("unchecked")
			Class<? extends Transformer> txClass = (Class<? extends Transformer>) classLoader.loadClass(javaResult.qualifiedClassName);
			assert txClass != null;
			compiled(txClass);
			return txClass;
		}
	}

	protected static class QVTc2QVTuCompilerStep extends AbstractCompilerStep
	{
		public QVTc2QVTuCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTU_STEP);
		}

		public @NonNull Resource execute(@NonNull Resource cResource, @NonNull QVTuConfiguration qvtuConfiguration) throws IOException {
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTcEnvironmentFactory.CREATE_STRATEGY);
			try {
				//				QVTuConfiguration qvtuConfiguration = compilerChain.getOption(QVTU_STEP, QVTU_CONFIGURATION_KEY);
				//				assert qvtuConfiguration != null;
				Resource uResource = createResource();
				QVTc2QVTu tx = new QVTc2QVTu(environmentFactory, qvtuConfiguration);
				tx.transform(cResource, uResource);
				return saveResource(uResource);
			}
			finally {
				environmentFactory.setCreateStrategy(savedStrategy);
			}
		}
	}

	protected static class QVTi2JavaCompilerStep extends AbstractCompilerStep
	{
		public QVTi2JavaCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, JAVA_STEP);
		}

		protected @NonNull JavaResult execute(@NonNull URI txURI, @NonNull Transformation asTransformation, @NonNull String ... genModelFiles) throws Exception {
			ResourceSet resourceSet = environmentFactory.getResourceSet();
			URI javaFileURI = compilerChain.getURI(JAVA_STEP, URI_KEY);
			URI classFileURI = compilerChain.getURI(CLASS_STEP, URI_KEY);
			resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
			if (genModelFiles != null) {
				for (String genModelFile : genModelFiles) {
					URI resolvedURI = URI.createURI(genModelFile).resolve(txURI);
					loadGenModel(resolvedURI);
				}
			}
			URI genModelURI = compilerChain.basicGetURI(GENMODEL_STEP, URI_KEY);
			if (genModelURI != null) {
				URI resolvedURI = genModelURI.resolve(txURI);
				loadGenModel(resolvedURI);

			}
			QVTiCodeGenerator cg = new QVTiCodeGenerator(environmentFactory, asTransformation);
			QVTiCodeGenOptions options = cg.getOptions();
			options.setUseNullAnnotations(true);
			String javaExtraPrefix = compilerChain.basicGetOption(JAVA_STEP, JAVA_EXTRA_PREFIX_KEY);
			if (javaExtraPrefix != null) {
				options.setPackagePrefix(javaExtraPrefix);
			}
			Boolean javaIsGeneratedDebug = compilerChain.basicGetOption(JAVA_STEP, JAVA_GENERATED_DEBUG_KEY);
			options.setIsGeneratedDebug(javaIsGeneratedDebug == Boolean.TRUE);
			Boolean javaIsIncremental = compilerChain.basicGetOption(JAVA_STEP, JAVA_INCREMENTAL_KEY);
			options.setIsIncremental(javaIsIncremental == Boolean.TRUE);
			String javaCodeSource;
			try {
				javaCodeSource = cg.generateClassFile();
			}
			catch (Exception e) {
				CompilerUtil.throwExceptionWithProblems(cg, e);
				javaCodeSource = "";		// Never happens but suppresses JDT error.
			}
			String javaFilePath = ClassUtil.nonNullState(javaFileURI.toFileString());
			String classFilePath = ClassUtil.nonNullState(classFileURI.toFileString());
			new File(classFilePath).mkdirs();
			File javaFile = cg.saveSourceFile(javaFilePath);		// use stream to avoid normalizing
			compiled(javaFile);
			return new JavaResult(javaFile, javaCodeSource, cg.getQualifiedName(), classFilePath);
		}

		private void loadGenModel(@NonNull URI genModelURI) {
			ResourceSet resourceSet = environmentFactory.getResourceSet();
			MetamodelManagerInternal metamodelManager = environmentFactory.getMetamodelManager();
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

	protected static class QVTm2QVTsCompilerStep extends AbstractCompilerStep
	{
		public QVTm2QVTsCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTS_STEP);
			//			QVTm2QVTs.DEBUG_GRAPHS.setState(getOption(CompilerChain.DEBUG_KEY) == Boolean.TRUE);
		}

		public @NonNull ScheduleManager execute(@NonNull Resource pResource) throws IOException {
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTcEnvironmentFactory.CREATE_STRATEGY);
			try {
				Resource sResource = createResource();
				CompilerOptions.StepOptions schedulerOptions = compilerChain.basicGetOptions(CompilerChain.QVTS_STEP);
				Transformation asTransformation = AbstractCompilerChain.getTransformation(pResource);
				QVTm2QVTs qvtm2qvts = new QVTm2QVTs(this, environmentFactory, schedulerOptions);
				ScheduleManager scheduleManager = qvtm2qvts.getScheduleManager();
				sResource.getContents().add(scheduleManager.getScheduleModel());
				scheduleManager.addTransformation(asTransformation);
				Map<@NonNull RootRegion, Iterable<@NonNull MappingRegion>> rootRegion2activeRegions = qvtm2qvts.transform();
				throwCompilerChainExceptionForErrors();
				String rootName = ClassUtil.nonNullState(pResource.getURI().trimFileExtension().trimFileExtension().lastSegment());
				QVTs2QVTs qvts2qvts = new QVTs2QVTs(this, scheduleManager, rootName);
				Iterable<@NonNull RootRegion> rootRegions = qvts2qvts.transform(scheduleManager, rootRegion2activeRegions);
				for (@NonNull RootRegion rootRegion : rootRegions) {
					rootRegion.setReferredTransformation(asTransformation);
				}
				throwCompilerChainExceptionForErrors();
				saveResource(sResource);
				return scheduleManager;
			}
			finally {
				environmentFactory.setCreateStrategy(savedStrategy);
			}
		}
	}

	protected static class QVTs2QVTiCompilerStep extends AbstractCompilerStep
	{
		public QVTs2QVTiCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTI_STEP);
		}

		public @NonNull ImperativeTransformation execute(@NonNull ScheduleManager scheduleManager) throws IOException {
			// Default QVTi strategy ok.
			Resource iResource = createResource();
			ScheduleModel scheduleModel = scheduleManager.getScheduleModel();
			QVTs2QVTi tx = new QVTs2QVTi(scheduleManager, this, environmentFactory);
			Model model = PivotUtil.createModel(ImperativeModel.class, QVTimperativePackage.Literals.IMPERATIVE_MODEL, null);
			for (@NonNull RootRegion rootRegion : QVTscheduleUtil.getOwnedRootRegions(scheduleModel)) {
				tx.transform(model, rootRegion);
			}
			iResource.getContents().add(model);
			saveResource(iResource);
			ImperativeTransformation transformation = (ImperativeTransformation) getTransformation(iResource);
			throwCompilerChainExceptionForErrors();
			return transformation;
		}
	}

	protected static class QVTu2QVTmCompilerStep extends AbstractCompilerStep
	{
		public QVTu2QVTmCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTM_STEP);
		}

		public @NonNull Resource execute(@NonNull Resource uResource) throws IOException {
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTcEnvironmentFactory.CREATE_STRATEGY);
			try {
				Resource mResource = createResource();
				QVTu2QVTm tx = new QVTu2QVTm(environmentFactory);
				tx.transform(uResource, mResource);
				return saveResource(mResource);
			}
			finally {
				environmentFactory.setCreateStrategy(savedStrategy);
			}
		}
	}

	public static void checkForProxyURIs(@NonNull Resource resource) throws CompilerChainException {
		Map<EObject, Collection<Setting>> unresolvedCrossReferences = EcoreUtil.UnresolvedProxyCrossReferencer.find(resource);
		if ((unresolvedCrossReferences != null) && (unresolvedCrossReferences.size() > 0)) {
			List<@NonNull String> proxyURIs = new ArrayList<>();
			for (EObject eObject : unresolvedCrossReferences.keySet()) {
				proxyURIs.add(String.valueOf(EcoreUtil.getURI(eObject)));
			}
			Collections.sort(proxyURIs);
			StringBuilder s = new StringBuilder();
			s.append("Unresolved proxyURIs in " + resource.getURI());
			for (@NonNull String proxyURI : proxyURIs) {
				s.append("\n\t" + proxyURI);
			}
			throw new CompilerChainException(s.toString());
		}
	}

	public static @Nullable String getDefaultFileExtension(@NonNull String key) {
		return step2fileExtension.get(key);
	}

	public static @NonNull Transformation getTransformation(Resource resource) throws IOException {
		List<@NonNull Transformation> asTransformations = new ArrayList<>();
		for (EObject eContent : resource.getContents()) {
			if (eContent instanceof BaseModel) {
				QVTbaseUtil.getAllTransformations(ClassUtil.nullFree(((BaseModel)eContent).getOwnedPackages()), asTransformations);
			}
		}
		if (asTransformations.size() == 1) {
			return asTransformations.get(0);
		}
		else if (asTransformations.size() == 1) {
			throw new IOException("No Transformation element in " + resource.getURI());
		}
		else {
			throw new IOException("Multiple Transformation elements in " + resource.getURI());
		}
	}

	protected final @NonNull QVTiEnvironmentFactory environmentFactory;
	protected final @NonNull ResourceSet asResourceSet;

	/**
	 * The compilation chain options are potentially 3-layered. The outer layer is indexed by the
	 * compilation step output such as QVTI_KEY. The next layer is indexed by the role such as VALIDATE_KEY.
	 * For SAVE_OPTIONS_KEY there is a futher level of indexing for each EMF save option.
	 *
	 * If there is no step entry or no key entry, a default is taken from the DEFAULT_STEP.
	 */
	protected final @NonNull CompilerOptions options;

	/**
	 * The fully qualified file name of the model-to-model transformation
	 */
	protected final @NonNull URI txURI;

	/**
	 * The fully qualified file name prefix from which default intermediate filenames are created by appending a file extension
	 */
	protected final @NonNull URI intermediateFileNamePrefixURI;

	private @Nullable List<@NonNull Listener> listeners = null;

	protected final @NonNull Java2ClassCompilerStep java2classCompilerStep;
	protected final @NonNull QVTc2QVTuCompilerStep qvtc2qvtuCompilerStep;
	protected final @NonNull QVTu2QVTmCompilerStep qvtu2qvtmCompilerStep;
	protected final @NonNull QVTm2QVTsCompilerStep qvtm2qvtsCompilerStep;
	protected final @NonNull QVTs2QVTiCompilerStep qvts2qvtiCompilerStep;
	protected final @NonNull QVTi2JavaCompilerStep qvti2javaCompilerStep;

	protected AbstractCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
		this.environmentFactory = environmentFactory;
		this.asResourceSet = environmentFactory.getMetamodelManager().getASResourceSet();
		this.txURI = txURI;
		this.intermediateFileNamePrefixURI = intermediateFileNamePrefixURI;
		this.options = options;
		this.java2classCompilerStep = createJava2ClassCompilerStep();
		this.qvtc2qvtuCompilerStep = createQVTc2QVTuCompilerStep();
		this.qvtu2qvtmCompilerStep = createQVTu2QVTmCompilerStep();
		this.qvtm2qvtsCompilerStep = createQVTm2QVTsCompilerStep();
		this.qvts2qvtiCompilerStep = createQVTs2QVTiCompilerStep();
		this.qvti2javaCompilerStep = createQVTi2JavaCompilerStep();
	}

	@Override
	public void addListener(@NonNull Listener listener) {
		List<@NonNull Listener> listeners2 = listeners;
		if (listeners2 == null) {
			listeners = listeners2 = new ArrayList<>();
		}
		if (!listeners2.contains(listener)) {
			listeners2.add(listener);
		}
	}

	@Override
	public <T> @Nullable T basicGetOption(@NonNull String stepKey, CompilerOptions.@NonNull Key<T> optionKey) {
		return options.basicGetOption(stepKey, optionKey);
	}

	@Override
	public CompilerOptions.@Nullable StepOptions basicGetOptions(@NonNull String stepKey) {
		return options.basicGetOptions(stepKey);
	}

	@Override
	public @Nullable URI basicGetURI(@NonNull String stepKey, CompilerOptions.@NonNull Key<URI> uriKey) {
		return basicGetOption(stepKey, URI_KEY);
	}

	@Override
	public @NonNull Class<? extends Transformer> build(@NonNull String enforcedOutputName, @NonNull String ... genModelFiles) throws Exception {
		ImperativeTransformation asTransformation = compile(enforcedOutputName);
		return generate(asTransformation, genModelFiles);
	}

	@Override
	public final @NonNull ImperativeTransformation compile(@NonNull String outputName) throws IOException {
		return compile(Collections.singletonList(outputName));
	}

	@Override
	public void compiled(@NonNull String stepKey, @NonNull Object object) {
		List<@NonNull Listener> listeners2 = listeners;
		if (listeners2 != null) {
			for (Listener listener : listeners2) {
				listener.compiled(stepKey, object);
			}
		}
	}

	protected @NonNull Java2ClassCompilerStep createJava2ClassCompilerStep() {
		return new Java2ClassCompilerStep(this);
	}

	protected @NonNull QVTc2QVTuCompilerStep createQVTc2QVTuCompilerStep() {
		return new QVTc2QVTuCompilerStep(this);
	}

	protected @NonNull QVTi2JavaCompilerStep createQVTi2JavaCompilerStep() {
		return new QVTi2JavaCompilerStep(this);
	}

	protected @NonNull QVTm2QVTsCompilerStep createQVTm2QVTsCompilerStep() {
		return new QVTm2QVTsCompilerStep(this);
	}

	protected @NonNull QVTs2QVTiCompilerStep createQVTs2QVTiCompilerStep() {
		return new QVTs2QVTiCompilerStep(this);
	}

	protected @NonNull QVTu2QVTmCompilerStep createQVTu2QVTmCompilerStep() {
		return new QVTu2QVTmCompilerStep(this);
	}

	protected @NonNull QVTuConfiguration createQVTuConfiguration(@NonNull Resource cResource, QVTuConfiguration.Mode mode, @NonNull String enforcedOutputName) throws IOException {
		return createQVTuConfiguration(cResource, mode, Collections.singletonList(enforcedOutputName));
	}

	protected @NonNull QVTuConfiguration createQVTuConfiguration(@NonNull Resource cResource, QVTuConfiguration.Mode mode, @NonNull Iterable<@NonNull String> enforcedOutputNames) throws IOException {
		Transformation transformation = getTransformation(cResource);
		List<@NonNull TypedModel> inputTypedModels = new ArrayList<>();
		List<@NonNull TypedModel> outputTypedModels = new ArrayList<>();
		List<@NonNull TypedModel> intermediateTypedModels = new ArrayList<>();
		for (@NonNull TypedModel typedModel : QVTcoreUtil.getModelParameters(transformation)) {
			if (!typedModel.isIsTrace()) {
				String modelName = typedModel.getName();
				if (Iterables.contains(enforcedOutputNames, modelName)) {
					if (outputTypedModels.size() > 1) {
						//	throw new CompilerChainException("Ambiguous output domain(s) ''{0}''", enforcedOutputNames);
						System.out.println("Ambiguous output domain(s) " + enforcedOutputNames);
					}
					outputTypedModels.add(typedModel);
				}
				else {
					//					inputNames.add(modelName);
					inputTypedModels.add(typedModel);
				}
				for (@NonNull TypedModel dependsOn : QVTcoreUtil.getDependsOns(typedModel)) {
					if (!intermediateTypedModels.contains(dependsOn)) {
						intermediateTypedModels.add(dependsOn);
					}
				}
			}
		}
		if (outputTypedModels.isEmpty()) {
			throw new CompilerChainException("Unknown output domain(s) ''{0}''", enforcedOutputNames);
		}
		inputTypedModels.removeAll(intermediateTypedModels);
		return new QVTuConfiguration(QVTuConfiguration.Mode.ENFORCE, inputTypedModels, intermediateTypedModels, outputTypedModels);
	}

	@Override
	public @NonNull Resource createResource(@NonNull URI uri) throws IOException {
		Resource resource = asResourceSet.createResource(uri);
		if (resource == null) {
			throw new IOException("Failed to create " + uri);
		}
		return resource;
	}

	@Override
	public void dispose() {}

	public @NonNull Class<? extends Transformer> generate(@NonNull ImperativeTransformation asTransformation, @NonNull String... genModelFiles) throws Exception {
		JavaResult javaResult = qvti2java(asTransformation, genModelFiles);
		return java2class(javaResult);
	}

	@Override
	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	/*	@Override
	public @Nullable File getTraceClassesFolder() {
		String classFilePath;
		URI traceURI = getURI(QVTrCompilerChain.TRACE_STEP, QVTrCompilerChain.URI_KEY);
		String binProjectName = QVTr2QVTc.getProjectName(traceURI);
		if (EcorePlugin.IS_ECLIPSE_RUNNING) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject binProject = root.getProject(binProjectName);
			IFolder binFolder = binProject.getFolder(JavaFileUtil.TEST_BIN_FOLDER_NAME);
			File binFile = URIUtil.toFile(binFolder.getLocationURI());
			classFilePath = binFile.toString()/*.replace(".", "/")* /.replace("\\", "/");		// FIXME deduce/parameterize bin
		}
		else {
			URI classFileURI = basicGetOption(QVTrCompilerChain.CLASS_STEP, QVTrCompilerChain.URI_KEY);
			if (classFileURI != null) {
				classFilePath = classFileURI.toFileString();
			}
		}
		return null;
	} */

	@Override
	public @NonNull URI getURI(@NonNull String stepKey, CompilerOptions.@NonNull Key<URI> uriKey) {
		URI uri = basicGetOption(stepKey, URI_KEY);
		return uri != null ? uri : intermediateFileNamePrefixURI.appendFileExtension(step2fileExtension.get(stepKey));
	}

	protected @NonNull Class<? extends Transformer> java2class(@NonNull JavaResult javaResult) throws Exception {
		return java2classCompilerStep.execute(txURI, javaResult);
	}

	protected @NonNull Resource qvtc2qvtm(@NonNull Resource cResource, @NonNull QVTuConfiguration qvtuConfiguration) throws IOException {
		Resource uResource = qvtc2qvtuCompilerStep.execute(cResource, qvtuConfiguration);
		return qvtu2qvtmCompilerStep.execute(uResource);
	}

	protected @NonNull JavaResult qvti2java(@NonNull Transformation asTransformation, @NonNull String ... genModelFiles) throws Exception {
		return qvti2javaCompilerStep.execute(txURI, asTransformation, genModelFiles);
	}

	protected @NonNull ImperativeTransformation qvtm2qvti(@NonNull Resource pResource) throws IOException {
		ScheduleManager scheduleManager = qvtm2qvtsCompilerStep.execute(pResource);
		return qvts2qvtiCompilerStep.execute(scheduleManager);
	}

	@Override
	public void removeListener(@NonNull Listener listener) {
		List<@NonNull Listener> listeners2 = listeners;
		if (listeners2 != null) {
			listeners2.remove(listener);
		}
	}

	@Override
	public void saveResource(@NonNull Resource asResource, @NonNull String stepKey) throws IOException {
		Map<?, ?> saveOptions = basicGetOption(stepKey, CompilerChain.SAVE_OPTIONS_KEY);
		if (saveOptions != null) {
			asResource.save(saveOptions);
		}
		assertNoResourceSetErrors(stepKey, asResource);
		if (basicGetOption(stepKey, CompilerChain.VALIDATE_KEY) == Boolean.TRUE) {
			assertNoValidationErrors(stepKey, asResource);
		}
	}
}
