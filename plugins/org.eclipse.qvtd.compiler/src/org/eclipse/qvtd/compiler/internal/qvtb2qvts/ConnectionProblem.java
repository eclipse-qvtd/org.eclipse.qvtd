/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.AbstractCompilerProblem;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;

public class ConnectionProblem extends AbstractCompilerProblem
{
	protected final @NonNull Connection connection;
	protected final @NonNull String boundMessage;

	public ConnectionProblem(@NonNull Severity severity, @NonNull Connection connection, @NonNull String boundMessage) {
		super(severity);
		this.connection = connection;
		this.boundMessage = boundMessage;
	}

	@Override
	public @NonNull String toString() {
		return "Connection " + severity + " for " + connection.toString() + "\n\t" + boundMessage;
	}
}
