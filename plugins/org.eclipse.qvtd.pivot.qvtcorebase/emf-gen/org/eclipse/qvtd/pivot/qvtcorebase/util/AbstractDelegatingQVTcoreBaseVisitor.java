/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
 * An AbstractDelegatingQVTcoreBaseVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTcoreBaseVisitor<R, C, D extends QVTcoreBaseVisitor<R>>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractDelegatingQVTbaseVisitor<R, C, D>
	implements QVTcoreBaseVisitor<R>
{
	protected AbstractDelegatingQVTcoreBaseVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull Assignment object) {
		return delegate.visitAssignment(object);
	}

	@Override
	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull BottomPattern object) {
		return delegate.visitBottomPattern(object);
	}

	@Override
	public R visitCoreDomain(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull CoreDomain object) {
		return delegate.visitCoreDomain(object);
	}

	@Override
	public R visitCorePattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull CorePattern object) {
		return delegate.visitCorePattern(object);
	}

	@Override
	public R visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull EnforcementOperation object) {
		return delegate.visitEnforcementOperation(object);
	}

	@Override
	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull GuardPattern object) {
		return delegate.visitGuardPattern(object);
	}

	@Override
	public R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull PropertyAssignment object) {
		return delegate.visitPropertyAssignment(object);
	}

	@Override
	public R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull RealizedVariable object) {
		return delegate.visitRealizedVariable(object);
	}

	@Override
	public R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull VariableAssignment object) {
		return delegate.visitVariableAssignment(object);
	}
}
