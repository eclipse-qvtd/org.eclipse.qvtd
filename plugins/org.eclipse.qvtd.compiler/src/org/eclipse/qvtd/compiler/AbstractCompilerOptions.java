/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * The AbstractCompilerOptions provides the configuration of the CompilerChain.
 *
 * Pragmatically AbstractCompilerOptions supports re-use between launch configuration, test, and user
 * initialization of the compiler chain, with derived CompilerOptions classes giving standard behaviour
 * for each language.
 */
public abstract class AbstractCompilerOptions implements CompilerOptions
{
	private final @NonNull Map<@NonNull String, @Nullable StepOptions> options = new HashMap<>();

	@Override
	public <T> @Nullable T basicGetOption(@NonNull String stepKey, @NonNull Key<T> optionKey) {
		StepOptions stepOptions = options.get(stepKey);
		if ((stepOptions == null) && !options.containsKey(stepKey)) {
			stepOptions = options.get(CompilerChain.DEFAULT_STEP);
		}
		@Nullable Object optionValue = null;
		if (stepOptions != null) {
			optionValue = stepOptions.basicGet(optionKey);
			if ((optionValue == null) && !stepOptions.containsKey(optionKey)) {
				StepOptions defaultOptions = options.get(CompilerChain.DEFAULT_STEP);
				if (defaultOptions != null){
					optionValue =  defaultOptions.basicGet(optionKey);
				}
			}
		}
		@SuppressWarnings("unchecked") T castValue = (T) optionValue;
		return castValue;
	}

	@Override
	public @Nullable StepOptions basicGetOptions(@NonNull String stepKey) {
		return options.get(stepKey);
	}

	@Override
	public <T> @NonNull T getOption(@NonNull String stepKey, @NonNull Key<T> optionKey) {
		StepOptions stepOptions = ClassUtil.nonNullState(options.get(stepKey));
		return stepOptions.get(optionKey);
	}

	@Override
	public <T> void setOption(@NonNull String stepKey, @NonNull Key<T> optionsKey, @Nullable T optionValue) {
		StepOptions stepOptions = options.get(stepKey);
		if (stepOptions == null) {
			stepOptions = new StepOptions(stepKey);
			options.put(stepKey, stepOptions);
		}
		stepOptions.put(optionsKey, optionValue);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		List<@NonNull String> keys = new ArrayList<>(options.keySet());
		Collections.sort(keys);
		for (@NonNull String key : keys) {
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(key + " = " + options.get(key));
		}
		return s.toString();
	}
}
