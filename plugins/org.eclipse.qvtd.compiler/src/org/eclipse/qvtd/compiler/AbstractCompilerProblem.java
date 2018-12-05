/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.CompilerProblem;

public abstract class AbstractCompilerProblem implements CompilerProblem
{
	protected final @NonNull Severity severity;

	protected AbstractCompilerProblem(@NonNull Severity severity) {
		this.severity = severity;
	}

	@Override
	public @NonNull Severity getSeverity() {
		return severity;
	}
}
