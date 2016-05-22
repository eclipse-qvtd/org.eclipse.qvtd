/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
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
 * An InvocationFailedException is thrown when a Mapping invocation fails as a result of an attempt to
 * access a Property before its value has been assigned. The InvocationManager should catch the exception
 * and mark the invocation for a retry once the Property has been assigned.
 * 
 * @since 1.1
 */
@SuppressWarnings("serial")
public class InvocationFailedException extends InvalidValueException
{
	public final @NonNull SlotState slotState;
	
	public InvocationFailedException(@NonNull SlotState slotState) {
		super("not-ready");
		this.slotState = slotState;
	}

	@Override
	public String toString() {
		return slotState.toString();
	}
}