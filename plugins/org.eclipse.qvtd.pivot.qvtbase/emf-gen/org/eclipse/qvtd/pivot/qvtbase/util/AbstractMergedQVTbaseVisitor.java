/*******************************************************************************
 * <copyright>
 * 
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

/**
 * An AbstractMergedQVTbaseVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedQVTbaseVisitor<R, C>
	extends org.eclipse.ocl.pivot.util.AbstractMergedVisitor<R, C>
	implements QVTbaseVisitor<R>
{
	protected AbstractMergedQVTbaseVisitor(C context) {
		super(context);
	}

	@Override
	public R visitBaseModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull BaseModel object) {
		return visiting(object);
	}

	@Override
	public R visitDomain(org.eclipse.qvtd.pivot.qvtbase.@NonNull Domain object) {
		return visiting(object);
	}

	@Override
	public R visitFunction(org.eclipse.qvtd.pivot.qvtbase.@NonNull Function object) {
		return visiting(object);
	}

	@Override
	public R visitFunctionParameter(org.eclipse.qvtd.pivot.qvtbase.@NonNull FunctionParameter object) {
		return visiting(object);
	}

	@Override
	public R visitPattern(org.eclipse.qvtd.pivot.qvtbase.@NonNull Pattern object) {
		return visiting(object);
	}

	@Override
	public R visitPredicate(org.eclipse.qvtd.pivot.qvtbase.@NonNull Predicate object) {
		return visiting(object);
	}

	@Override
	public R visitRule(org.eclipse.qvtd.pivot.qvtbase.@NonNull Rule object) {
		return visiting(object);
	}

	@Override
	public R visitTransformation(org.eclipse.qvtd.pivot.qvtbase.@NonNull Transformation object) {
		return visiting(object);
	}

	@Override
	public R visitTypedModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel object) {
		return visiting(object);
	}
}
