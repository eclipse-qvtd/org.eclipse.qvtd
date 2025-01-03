/*******************************************************************************
 * Copyright (c) 2013, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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

/**
 * An AbstractDelegatingQVTbaseVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTbaseVisitor<R, C, @NonNull D extends QVTbaseVisitor<R>>
	extends org.eclipse.ocl.pivot.util.AbstractDelegatingVisitor<R, C, D>
	implements QVTbaseVisitor<R>
{
	protected AbstractDelegatingQVTbaseVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitBaseModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull BaseModel object) {
		return delegate.visitBaseModel(object);
	}

	@Override
	public R visitCompoundTargetElement(org.eclipse.qvtd.pivot.qvtbase.@NonNull CompoundTargetElement object) {
		return delegate.visitCompoundTargetElement(object);
	}

	@Override
	public R visitDomain(org.eclipse.qvtd.pivot.qvtbase.@NonNull Domain object) {
		return delegate.visitDomain(object);
	}

	@Override
	public R visitFunction(org.eclipse.qvtd.pivot.qvtbase.@NonNull Function object) {
		return delegate.visitFunction(object);
	}

	@Override
	public R visitFunctionBody(org.eclipse.qvtd.pivot.qvtbase.@NonNull FunctionBody object) {
		return delegate.visitFunctionBody(object);
	}

	@Override
	public R visitFunctionParameter(org.eclipse.qvtd.pivot.qvtbase.@NonNull FunctionParameter object) {
		return delegate.visitFunctionParameter(object);
	}

	@Override
	public R visitPattern(org.eclipse.qvtd.pivot.qvtbase.@NonNull Pattern object) {
		return delegate.visitPattern(object);
	}

	@Override
	public R visitPredicate(org.eclipse.qvtd.pivot.qvtbase.@NonNull Predicate object) {
		return delegate.visitPredicate(object);
	}

	@Override
	public R visitRule(org.eclipse.qvtd.pivot.qvtbase.@NonNull Rule object) {
		return delegate.visitRule(object);
	}

	@Override
	public R visitSimpleTargetElement(org.eclipse.qvtd.pivot.qvtbase.@NonNull SimpleTargetElement object) {
		return delegate.visitSimpleTargetElement(object);
	}

	@Override
	public R visitTarget(org.eclipse.qvtd.pivot.qvtbase.@NonNull Target object) {
		return delegate.visitTarget(object);
	}

	@Override
	public R visitTargetElement(org.eclipse.qvtd.pivot.qvtbase.@NonNull TargetElement object) {
		return delegate.visitTargetElement(object);
	}

	@Override
	public R visitTransformation(org.eclipse.qvtd.pivot.qvtbase.@NonNull Transformation object) {
		return delegate.visitTransformation(object);
	}

	@Override
	public R visitTypedModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel object) {
		return delegate.visitTypedModel(object);
	}
}
