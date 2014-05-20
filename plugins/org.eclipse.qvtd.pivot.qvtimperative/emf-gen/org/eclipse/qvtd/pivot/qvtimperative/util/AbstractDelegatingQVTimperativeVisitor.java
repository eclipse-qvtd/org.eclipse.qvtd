/*******************************************************************************
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
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTimperativeVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTimperativeVisitor<R, C, D extends QVTimperativeVisitor<R>>
	extends org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractDelegatingQVTcoreBaseVisitor<R, C, D>
	implements QVTimperativeVisitor<R>
{
	protected AbstractDelegatingQVTimperativeVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitImperativeModel(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel object) {
		return delegate.visitImperativeModel(object);
	}

	public @Nullable R visitMapping(@NonNull org.eclipse.qvtd.pivot.qvtimperative.Mapping object) {
		return delegate.visitMapping(object);
	}

	public @Nullable R visitMappingCall(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCall object) {
		return delegate.visitMappingCall(object);
	}

	public @Nullable R visitMappingCallBinding(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding object) {
		return delegate.visitMappingCallBinding(object);
	}

	public @Nullable R visitMiddlePropertyAssignment(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment object) {
		return delegate.visitMiddlePropertyAssignment(object);
	}

	public @Nullable R visitMiddlePropertyCallExp(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp object) {
		return delegate.visitMiddlePropertyCallExp(object);
	}

	public @Nullable R visitVariablePredicate(@NonNull org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate object) {
		return delegate.visitVariablePredicate(object);
	}
}
