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

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

public interface CompilerChain
{
	/**
	 * A CompilerChain.Key provides type safety for the per-step option values.
	 */
	public static class Key<T>
	{
		protected final @NonNull String name;

		public Key(@NonNull String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

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
	public static final @NonNull String QVTP_STEP = "QVTp";
	public static final @NonNull String QVTR_STEP = "QVTr";
	public static final @NonNull String QVTS_STEP = "QVTs";
	public static final @NonNull String QVTU_STEP = "QVTu";
	public static final @NonNull String TRACE_STEP = "Trace";

	public static final @NonNull Key<Boolean> CHECK_KEY = new Key<Boolean>("check");
	public static final @NonNull Key<Boolean> DEBUG_KEY = new Key<Boolean>("debug");
	//	public static final @NonNull Key<@NonNull QVTuConfiguration> QVTU_CONFIGURATION_KEY = new Key<@NonNull QVTuConfiguration>("qvtuConfiguration");
	public static final @NonNull Key<@NonNull Map<@NonNull String, @Nullable String>> GENMODEL_OPTIONS_KEY = new Key<@NonNull Map<@NonNull String, @Nullable String>>("genmodel-options");
	public static final @NonNull Key<@Nullable Collection<@NonNull ? extends GenPackage>> GENMODEL_USED_GENPACKAGES_KEY = new Key<@Nullable Collection<@NonNull ? extends GenPackage>>("genmodel-usedGenPackages");;
	public static final @NonNull Key<@NonNull Map<@NonNull String, @Nullable String>> TRACE_OPTIONS_KEY = new Key<@NonNull Map<@NonNull String, @Nullable String>>("trace-options");
	public static final @NonNull Key<@NonNull Map<Object, Object>> SAVE_OPTIONS_KEY = new Key<@NonNull Map<Object, Object>>("save");
	public static final @NonNull Key<@Nullable URI> URI_KEY = new Key<@Nullable URI>("uri");
	public static final @NonNull Key<Boolean> VALIDATE_KEY = new Key<Boolean>("validate");

	public static final @NonNull Key<@Nullable String> JAVA_EXTRA_PREFIX_KEY = new Key<@Nullable String>("javaExtraPrefix");
	public static final @NonNull Key<@Nullable Boolean> JAVA_INCREMENTAL_KEY = new Key<@Nullable Boolean>("javaIncremental");

	public static final @NonNull String GENMODEL_BASE_PREFIX = "genModelBasePrefix";
	public static final @NonNull String GENMODEL_COPYRIGHT_TEXT = "genModelCopyrightText";

	public static final @NonNull String TRACE_NS_URI = "traceNsURI";

	void addListener(@NonNull Listener listener);
	@NonNull Class<? extends Transformer> build(@NonNull String outputName, @NonNull String ... genModelFiles) throws Exception;
	@NonNull ImperativeTransformation compile(@NonNull String outputName) throws Exception;
	void compiled(@NonNull String stepKey, @NonNull Object object);
	@NonNull Resource createResource(@NonNull URI uri) throws IOException;
	void dispose();
	@NonNull QVTbaseEnvironmentFactory getEnvironmentFactory();
	<T> @Nullable T getOption(@NonNull String stepKey, @NonNull Key<T> optionKey);
	@NonNull URI getURI(@NonNull String stepKey, @NonNull Key<URI> uriKey);
	void removeListener(@NonNull Listener listener);
	void saveResource(@NonNull Resource asResource, @NonNull String stepKey) throws IOException;
	<T> void setOption(@NonNull String stepKey, @NonNull Key<T> optionKey, @Nullable T object);
}
