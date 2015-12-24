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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullQVTcoreBaseVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.  
 */
 @Deprecated
public abstract class AbstractNullQVTcoreBaseVisitor<@Nullable R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractNullQVTbaseVisitor<R, C> implements QVTcoreBaseVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTcoreBaseVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull Assignment object) {
		return null;
	}

	@Override
	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull BottomPattern object) {
		return null;
	}

	@Override
	public R visitCoreDomain(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull CoreDomain object) {
		return null;
	}

	@Override
	public R visitCorePattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull CorePattern object) {
		return null;
	}

	@Override
	public R visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull EnforcementOperation object) {
		return null;
	}

	@Override
	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull GuardPattern object) {
		return null;
	}

	@Override
	public R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull PropertyAssignment object) {
		return null;
	}

	@Override
	public R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull RealizedVariable object) {
		return null;
	}

	@Override
	public R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull VariableAssignment object) {
		return null;
	}
}
