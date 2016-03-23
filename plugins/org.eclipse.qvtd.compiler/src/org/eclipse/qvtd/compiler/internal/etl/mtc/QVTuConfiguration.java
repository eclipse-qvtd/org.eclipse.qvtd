/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial API and implementation as MtcUtil
 *     E.D.Willink - initial API and re-implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl.mtc;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

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
	private final @NonNull List<@NonNull String> inputs;		// FIXME Names rather than TypedModel until c/u TypedModel ambiguity eliminated
	private final @NonNull List<@NonNull String> outputs;
	
	public QVTuConfiguration(@NonNull Mode mode, @NonNull List<@NonNull String> inputs, @NonNull List<@NonNull String> outputs) {
		this.mode = mode;
		this.inputs = inputs;
		this.outputs = outputs;
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

	public boolean isInput(String name) {
		return inputs.contains(name);
	}

	public boolean isOutput(String name) {
		return outputs.contains(name);
	}
}
