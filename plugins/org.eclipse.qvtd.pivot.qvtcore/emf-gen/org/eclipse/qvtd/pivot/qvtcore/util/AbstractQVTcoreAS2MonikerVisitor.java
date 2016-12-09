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

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseAS2MonikerVisitor;

/**
 * An AbstractQVTcoreAS2MonikerVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTcoreAS2MonikerVisitor
	extends QVTbaseAS2MonikerVisitor
	implements QVTcoreVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTcoreAS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
	}

	@Override
	public @Nullable Object visitAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull Assignment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitBottomPattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull BottomPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Object visitBottomVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull BottomVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Object visitCoreDomain(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreDomain object) {
		return visitDomain(object);
	}

	@Override
	public @Nullable Object visitCoreModel(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable Object visitCorePattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull CorePattern object) {
		return visitPattern(object);
	}

	@Override
	public @Nullable Object visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcore.@NonNull EnforcementOperation object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitGuardPattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull GuardPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Object visitGuardVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull GuardVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Object visitMapping(org.eclipse.qvtd.pivot.qvtcore.@NonNull Mapping object) {
		return visitRule(object);
	}

	@Override
	public @Nullable Object visitNavigationAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull NavigationAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable Object visitOppositePropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull OppositePropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @Nullable Object visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull PropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @Nullable Object visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull RealizedVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Object visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull VariableAssignment object) {
		return visitAssignment(object);
	}
}
