/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
 * An AbstractWrappingQVTbaseVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingQVTbaseVisitor<R, C, D extends QVTbaseVisitor<R>, P>
	extends org.eclipse.ocl.pivot.util.AbstractWrappingVisitor<R, C, D, P>
	implements QVTbaseVisitor<R>
{
	protected AbstractWrappingQVTbaseVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visitBaseModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull BaseModel object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBaseModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDomain(org.eclipse.qvtd.pivot.qvtbase.@NonNull Domain object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDomain(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFunction(org.eclipse.qvtd.pivot.qvtbase.@NonNull Function object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFunction(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFunctionParameter(org.eclipse.qvtd.pivot.qvtbase.@NonNull FunctionParameter object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFunctionParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPattern(org.eclipse.qvtd.pivot.qvtbase.@NonNull Pattern object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPattern(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPredicate(org.eclipse.qvtd.pivot.qvtbase.@NonNull Predicate object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPredicate(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRule(org.eclipse.qvtd.pivot.qvtbase.@NonNull Rule object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRule(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTransformation(org.eclipse.qvtd.pivot.qvtbase.@NonNull Transformation object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTransformation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTypedModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTypedModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
