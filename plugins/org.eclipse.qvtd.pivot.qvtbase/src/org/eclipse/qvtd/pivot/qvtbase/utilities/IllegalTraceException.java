/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

/**
 * An IllegalTraceException is thrown if the attempt to load artefacts from QVTtrace.ecore
 * fails. This should only happen during development.
 */
@SuppressWarnings("serial")
public class IllegalTraceException extends IllegalStateException
{
	public IllegalTraceException(String string) {
		super(string);
	}

	public IllegalTraceException(String string, Throwable e) {
		super(string, e);
	}
}