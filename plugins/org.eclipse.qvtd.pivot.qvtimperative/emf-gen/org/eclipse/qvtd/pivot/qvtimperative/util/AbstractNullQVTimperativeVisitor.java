/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvtd.pivot.qvtimperative.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullQVTimperativeVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullQVTimperativeVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractNullQVTcoreBaseVisitor<R, C> implements QVTimperativeVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTimperativeVisitor(@NonNull C context) {
		super(context);
	}	

	public @Nullable R visitImperativeModel(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel object) {
		return null;
	}

	public @Nullable R visitMapping(@NonNull org.eclipse.qvtd.pivot.qvtimperative.Mapping object) {
		return null;
	}

	public @Nullable R visitMappingCall(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCall object) {
		return null;
	}

	public @Nullable R visitMappingCallBinding(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding object) {
		return null;
	}

	public @Nullable R visitMiddlePropertyAssignment(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment object) {
		return null;
	}

	public @Nullable R visitMiddlePropertyCallExp(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp object) {
		return null;
	}

	public @Nullable R visitVariablePredicate(@NonNull org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate object) {
		return null;
	}
}
