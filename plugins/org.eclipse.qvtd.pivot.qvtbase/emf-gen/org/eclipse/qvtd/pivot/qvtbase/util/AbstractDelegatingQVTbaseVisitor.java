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
 * from: org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtbase.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTbaseVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTbaseVisitor<R, C, D extends QVTbaseVisitor<R>>
	extends org.eclipse.ocl.pivot.util.AbstractDelegatingVisitor<R, C, D>
	implements QVTbaseVisitor<R>
{
	protected AbstractDelegatingQVTbaseVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitBaseModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.BaseModel object) {
		return delegate.visitBaseModel(object);
	}

	@Override
	public @Nullable R visitDomain(@NonNull org.eclipse.qvtd.pivot.qvtbase.Domain object) {
		return delegate.visitDomain(object);
	}

	@Override
	public @Nullable R visitFunction(@NonNull org.eclipse.qvtd.pivot.qvtbase.Function object) {
		return delegate.visitFunction(object);
	}

	@Override
	public @Nullable R visitFunctionParameter(@NonNull org.eclipse.qvtd.pivot.qvtbase.FunctionParameter object) {
		return delegate.visitFunctionParameter(object);
	}

	@Override
	public @Nullable R visitPattern(@NonNull org.eclipse.qvtd.pivot.qvtbase.Pattern object) {
		return delegate.visitPattern(object);
	}

	@Override
	public @Nullable R visitPredicate(@NonNull org.eclipse.qvtd.pivot.qvtbase.Predicate object) {
		return delegate.visitPredicate(object);
	}

	@Override
	public @Nullable R visitRule(@NonNull org.eclipse.qvtd.pivot.qvtbase.Rule object) {
		return delegate.visitRule(object);
	}

	@Override
	public @Nullable R visitTransformation(@NonNull org.eclipse.qvtd.pivot.qvtbase.Transformation object) {
		return delegate.visitTransformation(object);
	}

	@Override
	public @Nullable R visitTypedModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.TypedModel object) {
		return delegate.visitTypedModel(object);
	}
}
