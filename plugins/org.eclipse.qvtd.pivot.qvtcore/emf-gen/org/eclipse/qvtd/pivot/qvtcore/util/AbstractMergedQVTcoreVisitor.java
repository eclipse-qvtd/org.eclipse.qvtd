/*******************************************************************************
 * <copyright>
 *
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
 * from: org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtcore.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractMergedQVTcoreVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedQVTcoreVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractMergedQVTbaseVisitor<R, C>
	implements QVTcoreVisitor<R>
{
	protected AbstractMergedQVTcoreVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull Assignment object) {
		return visiting(object);
	}

	@Override
	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull BottomPattern object) {
		return visiting(object);
	}

	@Override
	public R visitBottomVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull BottomVariable object) {
		return visiting(object);
	}

	@Override
	public R visitCoreDomain(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreDomain object) {
		return visiting(object);
	}

	@Override
	public R visitCoreModel(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreModel object) {
		return visiting(object);
	}

	@Override
	public R visitCorePattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull CorePattern object) {
		return visiting(object);
	}

	@Override
	public R visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcore.@NonNull EnforcementOperation object) {
		return visiting(object);
	}

	@Override
	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull GuardPattern object) {
		return visiting(object);
	}

	@Override
	public R visitGuardVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull GuardVariable object) {
		return visiting(object);
	}

	@Override
	public R visitMapping(org.eclipse.qvtd.pivot.qvtcore.@NonNull Mapping object) {
		return visiting(object);
	}

	@Override
	public R visitNavigationAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull NavigationAssignment object) {
		return visiting(object);
	}

	@Override
	public R visitOppositePropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull OppositePropertyAssignment object) {
		return visiting(object);
	}

	@Override
	public R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull PropertyAssignment object) {
		return visiting(object);
	}

	@Override
	public R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull RealizedVariable object) {
		return visiting(object);
	}

	@Override
	public R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull VariableAssignment object) {
		return visiting(object);
	}
}
