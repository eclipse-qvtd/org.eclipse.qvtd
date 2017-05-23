/*******************************************************************************
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * An InvalidEvaluationException is thrown when an OCL evaluation fails due to a serious error
 * such as NullPointerException or ClassCastException etc. Program flow errors such as
 * divide-by-zero or OrderedCollection index out of bounds are not InvalidEvaluationException.
 *
 * FIXME promote to OCL
 */
@SuppressWarnings("serial")
public class InvalidEvaluationException extends InvalidValueException
{
	public InvalidEvaluationException(@NonNull Exception exception) {		// FIXME Throwable
		super(exception);
	}

	public InvalidEvaluationException(@NonNull Exception exception, @NonNull String messageTemplate, Object... bindings) {
		super(exception, messageTemplate, bindings);
	}

	public InvalidEvaluationException(@NonNull String messageTemplate, Object... bindings) {
		super(messageTemplate, bindings);
	}
}