/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.StringUtil;

public class CompilerChainException extends IOException implements CompilerProblem
{
	private static final long serialVersionUID = 1L;

	public CompilerChainException(@NonNull Throwable cause, @NonNull String messageTemplate, Object... bindings) {
		super(StringUtil.bind(messageTemplate, bindings), cause);
	}

	public CompilerChainException(@NonNull String messageTemplate, Object... bindings) {
		super(StringUtil.bind(messageTemplate, bindings));
	}

	public CompilerChainException(@NonNull Throwable cause) {
		super(cause);
	}

	@Override
	public @NonNull Severity getSeverity() {
		return Severity.ERROR;
	}
}
