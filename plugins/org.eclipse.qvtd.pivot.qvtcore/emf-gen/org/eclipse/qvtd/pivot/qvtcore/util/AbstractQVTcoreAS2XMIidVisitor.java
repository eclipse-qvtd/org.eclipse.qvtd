/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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

import java.lang.Boolean;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseAS2XMIidVisitor;

/**
 * An AbstractQVTcoreAS2XMIidVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
@SuppressWarnings("deprecation")
public abstract class AbstractQVTcoreAS2XMIidVisitor
extends QVTbaseAS2XMIidVisitor
implements QVTcoreVisitor<Boolean>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTcoreAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}

	@Override
	public @Nullable Boolean visitAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull Assignment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitBottomPattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull BottomPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Boolean visitBottomVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull BottomVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Boolean visitCoreDomain(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreDomain object) {
		return visitDomain(object);
	}

	@Override
	public @Nullable Boolean visitCoreModel(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable Boolean visitCorePattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull CorePattern object) {
		return visitPattern(object);
	}

	@Override
	public @Nullable Boolean visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcore.@NonNull EnforcementOperation object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitGuardPattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull GuardPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Boolean visitGuardVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull GuardVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Boolean visitMapping(org.eclipse.qvtd.pivot.qvtcore.@NonNull Mapping object) {
		return visitRule(object);
	}

	@Override
	public @Nullable Boolean visitNavigationAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull NavigationAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable Boolean visitOppositePropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull OppositePropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @Nullable Boolean visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull PropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @Nullable Boolean visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull RealizedVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Boolean visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull VariableAssignment object) {
		return visitAssignment(object);
	}
}
