/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * A NotReadyValueException is thrown when transformation execution attempt to use a property value
 * before the property value is assigned. The exception is caught so that a retry occurs once the
 * required value has been assigned.
 */
public class NotReadyValueException extends InvalidValueException
{
	private static final long serialVersionUID = 1L;

	public NotReadyValueException(String messageTemplate, Object... bindings) {
		super(messageTemplate, bindings);
	}
}
