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
 * from: org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtcorebase.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractMergedQVTcoreBaseVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedQVTcoreBaseVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractMergedQVTbaseVisitor<R, C>
	implements QVTcoreBaseVisitor<R>
{
	protected AbstractMergedQVTcoreBaseVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull Assignment object) {
		return visiting(object);
	}

	@Override
	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull BottomPattern object) {
		return visiting(object);
	}

	@Override
	public R visitCoreDomain(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull CoreDomain object) {
		return visiting(object);
	}

	@Override
	public R visitCorePattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull CorePattern object) {
		return visiting(object);
	}

	@Override
	public R visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull EnforcementOperation object) {
		return visiting(object);
	}

	@Override
	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull GuardPattern object) {
		return visiting(object);
	}

	@Override
	public R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull PropertyAssignment object) {
		return visiting(object);
	}

	@Override
	public R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull RealizedVariable object) {
		return visiting(object);
	}

	@Override
	public R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull VariableAssignment object) {
		return visiting(object);
	}
}
