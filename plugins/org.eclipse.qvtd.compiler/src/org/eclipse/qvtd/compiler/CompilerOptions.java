/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * The CompilerOptions control the execution of the CompilerChain using a distinct typed-key to value for each compilation step.
 * A fall-back set of options are provided by using the DEFAULT_STEP.
 */
public interface CompilerOptions
{
	/**
	 * A CompilerOptions.Key provides type safety for the per-step option values.
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
	 * StepOptions provides the type safe option values for a compilation step.
	 */
	public static class StepOptions
	{
		protected final @NonNull String stepKey;
		private final @NonNull Map<@NonNull Key<Object>, @Nullable Object> options = new HashMap<>();

		public StepOptions(@NonNull String stepKey) {
			this.stepKey = stepKey;
		}

		public <T> @Nullable T basicGet(@NonNull Key<T> optionsKey) {
			@SuppressWarnings("unchecked")
			T value = (T) options.get(optionsKey);
			return value;
		}

		public <T> boolean containsKey(@NonNull Key<T> optionsKey) {
			return options.containsKey(optionsKey);
		}

		public <T> @NonNull T get(@NonNull Key<T> optionsKey) {
			@SuppressWarnings("unchecked")
			T value = (T) ClassUtil.nonNullState(options.get(optionsKey));
			return value;
		}

		public <T> void put(@NonNull Key<T> optionsKey, @Nullable T optionValue) {
			@SuppressWarnings("unchecked")
			Key<Object> castKey = (Key<Object>) optionsKey;
			options.put(castKey, optionValue);
		}

		@Override
		public String toString() {
			return stepKey + options.toString();
		}
	}

	/**
	 * Return the optionsKey sub-option of the stepKey option of the overall options.
	 * If no stepKey options are available the sub-option of the DEFAULT_KEY is returned.
	 */
	<T> @Nullable T basicGetOption(@NonNull String stepKey, @NonNull Key<T> optionKey);

	/**
	 * Return the options applicable to a particular compilation step. Fallbcak values are not provided. May be null.
	 */
	@Nullable StepOptions basicGetOptions(@NonNull String stepKey);

	/**
	 * Return the optionsKey sub-option of the stepKey option of the overall options.
	 * Throws an IllegalStateException if stepKey options are available or no optionKey is contained.
	 */
	<T> @NonNull T getOption(@NonNull String stepKey, @NonNull Key<T> optionKey);


	//	void setClassStepOptions(@NonNull String projectName, @NonNull URI classURI) throws IOException;

	//	void setDebugGraphs(boolean dotGraphs, boolean yedGraphs);

	//	void setGenerateOptions(@NonNull String projectName, @NonNull URI txURI,
	//			@NonNull Map<String, String> intermediatesMap) throws IOException;

	//	void setGenerateGenModelOptions(@NonNull URI genModelURI, @NonNull String basePrefix, @Nullable String copyright,
	//			@Nullable Collection<@NonNull GenPackage> usedGenPackages);

	/**
	 * Set the optionsKey sub-option of the stepKey option of the overall options to optionValue.
	 * If no stepKey options are available the sub-option of the DEFAULT_KEY is returned.
	 */
	<T> void setOption(@NonNull String stepKey, @NonNull Key<T> optionsKey, @Nullable T optionValue);

	//	void setURIs(@NonNull String @NonNull [] keys, @NonNull Map<String, String> key2value);
}
