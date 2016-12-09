/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtcore.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullQVTcoreVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.
 */
 @Deprecated
public abstract class AbstractNullQVTcoreVisitor<@Nullable R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractNullQVTbaseVisitor<R, C> implements QVTcoreVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractNullQVTcoreVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull Assignment object) {
		return null;
	}

	@Override
	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull BottomPattern object) {
		return null;
	}

	@Override
	public R visitBottomVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull BottomVariable object) {
		return null;
	}

	@Override
	public R visitCoreDomain(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreDomain object) {
		return null;
	}

	@Override
	public R visitCoreModel(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreModel object) {
		return null;
	}

	@Override
	public R visitCorePattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull CorePattern object) {
		return null;
	}

	@Override
	public R visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcore.@NonNull EnforcementOperation object) {
		return null;
	}

	@Override
	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull GuardPattern object) {
		return null;
	}

	@Override
	public R visitGuardVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull GuardVariable object) {
		return null;
	}

	@Override
	public R visitMapping(org.eclipse.qvtd.pivot.qvtcore.@NonNull Mapping object) {
		return null;
	}

	@Override
	public R visitNavigationAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull NavigationAssignment object) {
		return null;
	}

	@Override
	public R visitOppositePropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull OppositePropertyAssignment object) {
		return null;
	}

	@Override
	public R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull PropertyAssignment object) {
		return null;
	}

	@Override
	public R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull RealizedVariable object) {
		return null;
	}

	@Override
	public R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull VariableAssignment object) {
		return null;
	}
}
