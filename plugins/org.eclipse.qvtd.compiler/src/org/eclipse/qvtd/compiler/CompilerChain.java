/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

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
	public static final @NonNull String JAVA_STEP = "Java";
	public static final @NonNull String QVTC_STEP = "QVTc";
	public static final @NonNull String QVTG_STEP = "QVTg";
	public static final @NonNull String QVTI_STEP = "QVTi";
	public static final @NonNull String QVTM_STEP = "QVTm";
	public static final @NonNull String QVTP_STEP = "QVTp";
	public static final @NonNull String QVTR_STEP = "QVTr";
	public static final @NonNull String QVTS_STEP = "QVTs";
	public static final @NonNull String QVTU_STEP = "QVTu";
	public static final @NonNull String TRACE_STEP = "Trace";
	
	public static final @NonNull Key<Boolean> CHECK_KEY = new Key<Boolean>("check");
	public static final @NonNull Key<@NonNull Map<?,?>> SAVE_OPTIONS_KEY = new Key<@NonNull Map<?,?>>("save");
	public static final @NonNull Key<URI> URI_KEY = new Key<URI>("uri");
	public static final @NonNull Key<Boolean> VALIDATE_KEY = new Key<Boolean>("validate");

	void addListener(@NonNull Listener listener);
	@NonNull Class<? extends Transformer> build(@NonNull String outputName, @NonNull String ... genModelFiles) throws Exception;
	@NonNull Transformation compile(@NonNull String outputName) throws Exception;
	void dispose();
	void removeListener(@NonNull Listener listener);
	<@NonNull T> void setOption(@NonNull String stepKey, @NonNull Key<T> optionKey, @Nullable T object);
}
