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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullQVTbaseVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.
 */
 @Deprecated
public abstract class AbstractNullQVTbaseVisitor<@Nullable R, C>
	extends org.eclipse.ocl.pivot.util.AbstractNullVisitor<R, C> implements QVTbaseVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractNullQVTbaseVisitor(C context) {
		super(context);
	}

	@Override
	public R visitBaseModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull BaseModel object) {
		return null;
	}

	@Override
	public R visitCompoundTargetElement(org.eclipse.qvtd.pivot.qvtbase.@NonNull CompoundTargetElement object) {
		return null;
	}

	@Override
	public R visitDomain(org.eclipse.qvtd.pivot.qvtbase.@NonNull Domain object) {
		return null;
	}

	@Override
	public R visitFunction(org.eclipse.qvtd.pivot.qvtbase.@NonNull Function object) {
		return null;
	}

	@Override
	public R visitFunctionBody(org.eclipse.qvtd.pivot.qvtbase.@NonNull FunctionBody object) {
		return null;
	}

	@Override
	public R visitFunctionParameter(org.eclipse.qvtd.pivot.qvtbase.@NonNull FunctionParameter object) {
		return null;
	}

	@Override
	public R visitPattern(org.eclipse.qvtd.pivot.qvtbase.@NonNull Pattern object) {
		return null;
	}

	@Override
	public R visitPredicate(org.eclipse.qvtd.pivot.qvtbase.@NonNull Predicate object) {
		return null;
	}

	@Override
	public R visitRule(org.eclipse.qvtd.pivot.qvtbase.@NonNull Rule object) {
		return null;
	}

	@Override
	public R visitSimpleTargetElement(org.eclipse.qvtd.pivot.qvtbase.@NonNull SimpleTargetElement object) {
		return null;
	}

	@Override
	public R visitTarget(org.eclipse.qvtd.pivot.qvtbase.@NonNull Target object) {
		return null;
	}

	@Override
	public R visitTargetElement(org.eclipse.qvtd.pivot.qvtbase.@NonNull TargetElement object) {
		return null;
	}

	@Override
	public R visitTransformation(org.eclipse.qvtd.pivot.qvtbase.@NonNull Transformation object) {
		return null;
	}

	@Override
	public R visitTypedModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel object) {
		return null;
	}
}
