/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial API and implementation as MtcUtil
 *     E.D.Willink - initial API and re-implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtc2qvtu;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * QVTuConfiguration captures the configuration to be imposed by a QVTc2QVTu transformation
 * and provides configuration related utilities.
 */
public class QVTuConfiguration
{
	public enum Mode {
		CHECK,
		ENFORCE
	}

	private final @NonNull Mode mode;
	private final @NonNull List<@NonNull TypedModel> inputTypedModels;
	private final @NonNull List<@NonNull TypedModel> intermediateTypedModels;
	private final @NonNull List<@NonNull TypedModel> outputTypedModels;

	public QVTuConfiguration(@NonNull Mode mode, @NonNull List<@NonNull TypedModel> inputTypedModels,
			@NonNull List<@NonNull TypedModel> intermediateTypedModels, @NonNull List<@NonNull TypedModel> outputTypedModels) {
		this.mode = mode;
		this.inputTypedModels = inputTypedModels;
		this.intermediateTypedModels = intermediateTypedModels;
		this.outputTypedModels = outputTypedModels;
	}

	/**
	 * Checks if is check mode.
	 */
	public boolean isCheckMode() {
		return mode == Mode.CHECK;
	}

	public boolean isEnforceMode() {
		return mode == Mode.ENFORCE;
	}

	public boolean isInput(@NonNull TypedModel typedModel) {
		return inputTypedModels.contains(typedModel);
	}

	public boolean isIntermediate(@NonNull TypedModel typedModel) {
		return intermediateTypedModels.contains(typedModel);
	}

	public boolean isOutput(@NonNull TypedModel typedModel) {
		return outputTypedModels.contains(typedModel);
	}
}
