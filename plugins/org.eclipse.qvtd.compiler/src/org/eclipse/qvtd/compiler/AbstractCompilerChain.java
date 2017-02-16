/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTc2QVTu;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.compiler.internal.qvts2qvti.QVTs2QVTi;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.QVTs2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtu2qvtm.QVTu2QVTm;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.compiler.internal.utilities.JavaSourceFileObject;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

public abstract class AbstractCompilerChain extends CompilerUtil implements CompilerChain
{
	private static final @NonNull Map<@NonNull String, @NonNull String> step2extension = new HashMap<>();
	static {
		step2extension.put(UMLX_STEP, "umlx");
		step2extension.put(QVTR_STEP, "qvtras");
		step2extension.put(TRACE_STEP, "trace.ecore");
		step2extension.put(GENMODEL_STEP, "genmodel");
		step2extension.put(QVTC_STEP, "qvtcas");
		step2extension.put(QVTU_STEP, "qvtu.qvtcas");
		step2extension.put(QVTM_STEP, "qvtm.qvtcas");
		step2extension.put(QVTS_STEP, "qvts");
		step2extension.put(QVTI_STEP, "qvtias");
		step2extension.put(JAVA_STEP, "java");
		step2extension.put(CLASS_STEP, "class");
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
			List<@NonNull String> classpathProjects;
			if (EcorePlugin.IS_ECLIPSE_RUNNING) {
				String projectName = txURI.segment(1);
				classpathProjects = JavaSourceFileObject.createClasspathProjectList(projectName, "org.eclipse.emf.common", "org.eclipse.emf.ecore", "org.eclipse.jdt.annotation", "org.eclipse.ocl.pivot", "org.eclipse.osgi", "org.eclipse.qvtd.runtime");
			}
			else {
				classpathProjects = null;
			}
			JavaSourceFileObject.compileClass(javaResult.qualifiedClassName, javaResult.code, javaResult.classPath, classpathProjects);
			File explicitClassPath = new File(javaResult.classPath);
			@SuppressWarnings("unchecked")
			Class<? extends Transformer> txClass = (Class<? extends Transformer>) JavaSourceFileObject.loadExplicitClass(explicitClassPath, javaResult.qualifiedClassName);
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
			URI javaURI = compilerChain.getURI(JAVA_STEP, URI_KEY);
			URI classURI = compilerChain.getURI(CLASS_STEP, URI_KEY);
			ResourceSet resourceSet = environmentFactory.getResourceSet();
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
			String javaExtraPrefix = compilerChain.getOption(JAVA_STEP, JAVA_EXTRA_PREFIX_KEY);
			if (javaExtraPrefix != null) {
				options.setPackagePrefix(javaExtraPrefix);
			}
			Boolean javaIsIncremental = compilerChain.getOption(JAVA_STEP, JAVA_INCREMENTAL_KEY);
			options.setIsIncremental(javaIsIncremental == Boolean.TRUE);
			String javaCodeSource;
			try {
				javaCodeSource = cg.generateClassFile();
			}
			catch (Exception e) {
				CompilerUtil.throwExceptionWithProblems(cg, e);
				javaCodeSource = "";		// Never happens but suppresses JDT error.
			}
			URI normalizedURI = resourceSet.getURIConverter().normalize(javaURI);
			String javaFileName;
			File explicitClassPath;
			if (EcorePlugin.IS_ECLIPSE_RUNNING) {
				URI createPlatformResourceURI = URI.createPlatformResourceURI("", false);
				URI dURI = normalizedURI.deresolve(createPlatformResourceURI);
				IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(dURI.toString()));
				File file = URIUtil.toFile(iFile.getLocationURI());
				javaFileName = ClassUtil.nonNullState(file.toString());
				IFile iBinFolder = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(classURI.deresolve(createPlatformResourceURI).toString()));
				File binFolder = URIUtil.toFile(iBinFolder.getLocationURI());
				explicitClassPath = binFolder;
			}
			else {
				javaFileName = ClassUtil.nonNullState(normalizedURI.toFileString());
				URI normalizedClassURI = resourceSet.getURIConverter().normalize(classURI);
				explicitClassPath = new File(normalizedClassURI.toFileString());
			}
			File javaFile = cg.saveSourceFile(javaFileName);
			compiled(javaFile);
			return new JavaResult(javaFile, javaCodeSource, cg.getQualifiedName(), String.valueOf(explicitClassPath));
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
			QVTm2QVTs.DEBUG_GRAPHS.setState(getOption(CompilerChain.DEBUG_KEY) == Boolean.TRUE);
		}

		public @NonNull ScheduledRegion execute(@NonNull Resource pResource) throws IOException {
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTcEnvironmentFactory.CREATE_STRATEGY);
			try {
				//				Resource sResource = createResource();
				Map<@NonNull Key<? extends Object>, @Nullable Object> schedulerOptions = getOption(CompilerChain.SCHEDULER_OPTIONS_KEY);
				Transformation asTransformation = AbstractCompilerChain.getTransformation(pResource);
				QVTm2QVTs qvtm2qvts = new QVTm2QVTs(this, environmentFactory, asTransformation, schedulerOptions);
				List<@NonNull Region> activeRegions = qvtm2qvts.transform();
				throwCompilerChainExceptionForErrors();
				String rootName = ClassUtil.nonNullState(asTransformation.eResource().getURI().trimFileExtension().trimFileExtension().lastSegment());
				QVTs2QVTs qvts2qvts = new QVTs2QVTs(this, qvtm2qvts, rootName);
				ScheduledRegion scheduledRegion = qvts2qvts.transform(qvtm2qvts, activeRegions);
				ScheduleModel scheduleModel = RegionUtil.getScheduleModel(scheduledRegion);
				throwCompilerChainExceptionForErrors();
				compiled(scheduleModel);			// FIXME
				//				sResource.getContents().add(scheduleModel);
				//				saveResource(sResource);
				return scheduledRegion;
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

		public @NonNull ImperativeTransformation execute(@NonNull ScheduledRegion rootRegion) throws IOException {
			// Default QVTi strategy ok.
			Resource iResource = createResource();
			QVTs2QVTi tx = new QVTs2QVTi(this, environmentFactory);
			Model model = tx.transform(rootRegion);
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

	@Override
	public @Nullable URI basicGetURI(@NonNull String stepKey, @NonNull Key<URI> uriKey) {
		return getOption(stepKey, URI_KEY);
	}

	public static @Nullable String getDefaultExtension(@NonNull String key) {
		return step2extension.get(key);
	}

	/**
	 * Return the optionsKey sub-option of the stepKey option of the overall options.
	 * If no stepKey options are available the sub-option of the DEFAULT_KEY is returned.
	 */
	public static <T> @Nullable T getOption(@NonNull Map<@NonNull String, @NonNull Map<@NonNull Key<Object>, @Nullable Object>> options,
			@NonNull String stepKey, @NonNull Key<T> optionKey) {
		@SuppressWarnings("unchecked")
		Map<@NonNull String, @NonNull Map<@NonNull Key<T>, @Nullable T>> castOptions = (Map<@NonNull String, @NonNull Map<@NonNull Key<T>, @Nullable T>>)(Object)options;
		Map<@NonNull Key<T>, @Nullable T> stepOptions = castOptions.get(stepKey);
		if ((stepOptions == null) && !options.containsKey(stepOptions)) {
			stepOptions = castOptions.get(DEFAULT_STEP);
		}
		//		return stepOptions != null ? stepOptions.get(optionsKey) : null;
		@Nullable Object optionValue = null;
		if (stepOptions != null) {
			optionValue = stepOptions.get(optionKey);
			if ((optionValue == null) && !options.containsKey(optionKey)) {
				Map<@NonNull Key<Object>, @Nullable Object> defaultOptions = options.get(DEFAULT_STEP);
				if (defaultOptions != null){
					optionValue =  defaultOptions.get(optionKey);
				}
			}
		}
		@SuppressWarnings("unchecked") T castValue = (T) optionValue;
		return castValue;
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

	/**
	 * Set the optionsKey sub-option of the stepKey option of the overall options to optionValue.
	 * If no stepKey options are available the sub-option of the DEFAULT_KEY is returned.
	 */
	public static <T> void setOption(@NonNull Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options,
			@NonNull String stepKey, @NonNull Key<T> optionsKey, @Nullable T optionValue) {
		@SuppressWarnings("unchecked")
		Map<@NonNull String, @NonNull Map<@NonNull Key<T>, @Nullable T>> castOptions = (Map<@NonNull String, @NonNull Map<@NonNull Key<T>, @Nullable T>>)(Object)options;
		Map<@NonNull Key<T>, @Nullable T> stepOptions = castOptions.get(stepKey);
		if (stepOptions == null) {
			stepOptions = new HashMap<>();
			castOptions.put(stepKey, stepOptions);
		}
		stepOptions.put(optionsKey, optionValue);
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
	protected final @NonNull Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options;

	protected final @NonNull URI txURI;
	protected final @NonNull URI prefixURI;

	private @Nullable List<@NonNull Listener> listeners = null;

	protected final @NonNull Java2ClassCompilerStep java2classCompilerStep;
	protected final @NonNull QVTc2QVTuCompilerStep qvtc2qvtuCompilerStep;
	protected final @NonNull QVTu2QVTmCompilerStep qvtu2qvtmCompilerStep;
	protected final @NonNull QVTm2QVTsCompilerStep qvtm2qvtsCompilerStep;
	protected final @NonNull QVTs2QVTiCompilerStep qvts2qvtiCompilerStep;
	protected final @NonNull QVTi2JavaCompilerStep qvti2javaCompilerStep;

	protected AbstractCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI,
			@Nullable Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
		this.environmentFactory = environmentFactory;
		this.asResourceSet = environmentFactory.getMetamodelManager().getASResourceSet();
		this.txURI = txURI;
		this.prefixURI = txURI.trimSegments(1).appendSegment("temp").appendSegment(txURI.trimFileExtension().lastSegment());
		this.options = options != null ? options : new HashMap<>();
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
	public @NonNull Class<? extends Transformer> build(@NonNull String enforcedOutputName, @NonNull String ... genModelFiles) throws Exception {
		ImperativeTransformation asTransformation = compile(enforcedOutputName);
		return generate(asTransformation, genModelFiles);
	}

	@Override
	public abstract @NonNull ImperativeTransformation compile(@NonNull String enforcedOutputName) throws IOException;

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
		Transformation transformation = getTransformation(cResource);
		List<@NonNull TypedModel> inputTypedModels = new ArrayList<>();
		List<@NonNull TypedModel> outputTypedModels = new ArrayList<>();
		List<@NonNull TypedModel> intermediateTypedModels = new ArrayList<>();
		for (@NonNull TypedModel typedModel : QVTcoreUtil.getModelParameters(transformation)) {
			String modelName = typedModel.getName();
			if (modelName != null) {
				if (modelName.equals(enforcedOutputName)) {
					if (outputTypedModels.size() > 1) {
						throw new CompilerChainException("Ambiguous output domain ''{0}''", enforcedOutputName);
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
			throw new CompilerChainException("Unknown output domain ''{0}''", enforcedOutputName);
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

	@Override
	public <T> @Nullable T getOption(@NonNull String stepKey, @NonNull Key<T> optionKey) {
		Map<@NonNull Key<Object>, @Nullable Object> stepOptions = options.get(stepKey);
		if ((stepOptions == null) && !options.containsKey(stepOptions)) {
			stepOptions = options.get(DEFAULT_STEP);
		}
		@Nullable Object optionValue = null;
		if (stepOptions != null) {
			optionValue = stepOptions.get(optionKey);
			if ((optionValue == null) && !options.containsKey(optionKey)) {
				Map<@NonNull Key<Object>, @Nullable Object> defaultOptions = options.get(DEFAULT_STEP);
				if (defaultOptions != null){
					optionValue =  defaultOptions.get(optionKey);
				}
			}
		}
		@SuppressWarnings("unchecked") T castValue = (T) optionValue;
		return castValue;
	}

	@Override
	public @NonNull URI getURI(@NonNull String stepKey, @NonNull Key<URI> uriKey) {
		URI uri = getOption(stepKey, URI_KEY);
		return uri != null ? uri : prefixURI.appendFileExtension(step2extension.get(stepKey));
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
		ScheduledRegion rootRegion = qvtm2qvtsCompilerStep.execute(pResource);
		return qvts2qvtiCompilerStep.execute(rootRegion);
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
		Map<?, ?> saveOptions = getOption(stepKey, CompilerChain.SAVE_OPTIONS_KEY);
		if (saveOptions != null) {
			asResource.save(saveOptions);
		}
		assertNoResourceErrors(stepKey, asResource);
		if (getOption(stepKey, CompilerChain.VALIDATE_KEY) == Boolean.TRUE) {
			assertNoValidationErrors(stepKey, asResource);
		}
	}

	@Override
	public <T> void setOption(@NonNull String stepKey, @NonNull Key<T> optionKey, @Nullable T object) {
		Map<@NonNull Key<Object>, @Nullable Object> stepOptions = options.get(stepKey);
		if (stepOptions == null) {
			stepOptions = new HashMap<>();
			options.put(stepKey, stepOptions);
		}
		@SuppressWarnings("unchecked")
		Map<@NonNull Key<T>, @Nullable T> stepOptions2 = (Map<@NonNull Key<T>, @Nullable T>)(Object)stepOptions;
		stepOptions2.put(optionKey, object);
	}
}
