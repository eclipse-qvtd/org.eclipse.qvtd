/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

public interface CompilerChain
{
	/**
	 * A CompilerChain.Listener is notified of the completion of each compiler step with a step-specific result object.
	 */
	public static interface Listener
	{
		void compiled(@NonNull String step, @Nullable Object object);
	}

	public static final @NonNull String CLASS_STEP = "Class";
	public static final @NonNull String DEFAULT_STEP = "default";
	public static final @NonNull String GENMODEL_STEP = "GenModel";
	public static final @NonNull String JAVA_STEP = "Java";
	public static final @NonNull String QVTC_STEP = "QVTc";
	public static final @NonNull String QVTI_STEP = "QVTi";
	public static final @NonNull String QVTM_STEP = "QVTm";
	public static final @NonNull String QVTR_STEP = "QVTr";
	public static final @NonNull String QVTS_STEP = "QVTs";
	public static final @NonNull String QVTU_STEP = "QVTu";
	public static final @NonNull String TRACE_STEP = "Trace";
	public static final @NonNull String UMLX_STEP = "UMLX";

	public static final CompilerOptions.@NonNull Key<Boolean> CHECK_KEY = new CompilerOptions.Key<>("check");
	public static final CompilerOptions.@NonNull Key<Boolean> DEBUG_KEY = new CompilerOptions.Key<>("debug");
	//	public static final CompilerOptions.@NonNull Key<@NonNull QVTuConfiguration> QVTU_CONFIGURATION_KEY = new CompilerOptions.Key<>("qvtuConfiguration");
	public static final CompilerOptions.@NonNull Key<@NonNull String> GENMODEL_MODEL_DIRECTORY_KEY = new CompilerOptions.Key<>("genmodel-model-directory");
	public static final CompilerOptions.@NonNull Key<@NonNull Map<@NonNull String, @Nullable String>> GENMODEL_OPTIONS_KEY = new CompilerOptions.Key<>("genmodel-options");
	public static final CompilerOptions.@NonNull Key<@Nullable Collection<@NonNull ? extends GenPackage>> GENMODEL_USED_GENPACKAGES_KEY = new CompilerOptions.Key<>("genmodel-usedGenPackages");;
	public static final CompilerOptions.@NonNull Key<@NonNull Boolean> KEEP_OLD_JAVA_FILES_KEY = new CompilerOptions.Key<>("keep-old-java-files");
	public static final CompilerOptions.@NonNull Key<@NonNull Map<@NonNull String, @Nullable String>> TRACE_OPTIONS_KEY = new CompilerOptions.Key<>("trace-options");
	public static final CompilerOptions.@NonNull Key<@NonNull Map<Object, Object>> SAVE_OPTIONS_KEY = new CompilerOptions.Key<>("save");
	public static final CompilerOptions.@NonNull Key<@NonNull Map<CompilerOptions.@NonNull Key<? extends Object>, @Nullable Object>> SCHEDULER_OPTIONS_KEY = new CompilerOptions.Key<>("scheduler-options");
	public static final CompilerOptions.@NonNull Key<@Nullable URI> URI_KEY = new CompilerOptions.Key<>("uri");
	public static final CompilerOptions.@NonNull Key<Boolean> VALIDATE_KEY = new CompilerOptions.Key<>("validate");

	public static final CompilerOptions.@NonNull Key<@NonNull JavaClasspath> CLASSPATH_KEY = new CompilerOptions.Key<>("classpath");

	public static final CompilerOptions.@NonNull Key<@Nullable String> JAVA_EXTRA_PREFIX_KEY = new CompilerOptions.Key<>("javaExtraPrefix");
	public static final CompilerOptions.@NonNull Key<@Nullable Boolean> JAVA_GENERATED_DEBUG_KEY = new CompilerOptions.Key<>("javaGeneratedDebug");
	public static final CompilerOptions.@NonNull Key<@Nullable Boolean> JAVA_INCREMENTAL_KEY = new CompilerOptions.Key<>("javaIncremental");

	public static final @NonNull String GENMODEL_BASE_PREFIX = "genModelBasePrefix";
	public static final @NonNull String GENMODEL_COPYRIGHT_TEXT = "genModelCopyrightText";

	public static final @NonNull String TRACE_NS_URI = "traceNsURI";

	public static final CompilerOptions.@NonNull Key<Boolean> SCHEDULER_NO_EARLY_MERGE = new CompilerOptions.Key<>("schedulerNoEarlyMerge");
	public static final CompilerOptions.@NonNull Key<Boolean> SCHEDULER_NO_LATE_CONSUMER_MERGE = new CompilerOptions.Key<>("schedulerNoLateConsumerMerge");
	public static final CompilerOptions.@NonNull Key<Boolean> SCHEDULER_DOT_GRAPHS = new CompilerOptions.Key<>("schedulerDotGraphs");
	public static final CompilerOptions.@NonNull Key<Boolean> SCHEDULER_YED_GRAPHS = new CompilerOptions.Key<>("schedulerYedGraphs");

	void addListener(@NonNull Listener listener);
	<T> @Nullable T basicGetOption(@NonNull String stepKey, CompilerOptions.@NonNull Key<T> optionKey);
	CompilerOptions.@Nullable StepOptions basicGetOptions(@NonNull String stepKey);
	@Nullable URI basicGetURI(@NonNull String stepKey, CompilerOptions.@NonNull Key<URI> uriKey);
	@NonNull Class<? extends Transformer> build(@NonNull String outputName, @NonNull String ... genModelFiles) throws Exception;
	//	@NonNull Class<? extends Transformer> build(@NonNull Iterable<@NonNull QVTuConfiguration> qvtuConfigurations, @NonNull String ... genModelFiles) throws Exception;
	@NonNull ImperativeTransformation compile(@NonNull String outputName) throws IOException;
	@NonNull ImperativeTransformation compile(@NonNull Iterable<@NonNull TypedModelsConfiguration> typedModelsConfigurations) throws IOException;
	void compiled(@NonNull String stepKey, @NonNull Object object);
	//	@NonNull QVTuConfiguration createQVTuConfiguration(@NonNull Resource resource, QVTuConfiguration.Mode mode, @NonNull Iterable<@NonNull String> enforcedOutputNames) throws IOException;
	@NonNull Resource createResource(@NonNull URI uri, @NonNull String contentType) throws IOException;
	void dispose();
	@NonNull QVTbaseEnvironmentFactory getEnvironmentFactory();
	//	@Nullable File getTraceClassesFolder();
	@NonNull URI getURI(@NonNull String stepKey, CompilerOptions.@NonNull Key<URI> uriKey);
	void removeListener(@NonNull Listener listener);
	void saveResource(@NonNull Resource asResource, @NonNull String stepKey) throws IOException;
}
