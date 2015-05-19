/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.runtime;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.values.InvalidValueException;

public class CS2ASException extends InvalidValueException
{
	private static final long serialVersionUID = 1L;

	protected final @NonNull EObject csObject;

	public CS2ASException(@NonNull EObject csObject, @NonNull String message) {
		super(message);
		this.csObject = csObject;
	}

	public @NonNull EObject getCSObject() {
		return csObject;
	}
}
