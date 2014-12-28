/*******************************************************************************
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
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

import java.lang.Object;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseASSaverNormalizeVisitor;

/**
 * An AbstractQVTcoreBaseASSaverNormalizeVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTcoreBaseASSaverNormalizeVisitor
	extends QVTbaseASSaverNormalizeVisitor
	implements QVTcoreBaseVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTcoreBaseASSaverNormalizeVisitor(@NonNull ASSaver context) {
		super(context);
	}	

	@Override
	public @Nullable Object visitAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.Assignment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitBottomPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Object visitCoreDomain(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain object) {
		return visitDomain(object);
	}

	@Override
	public @Nullable Object visitCorePattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CorePattern object) {
		return visitPattern(object);
	}

	@Override
	public @Nullable Object visitEnforcementOperation(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitGuardPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Object visitPropertyAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable Object visitRealizedVariable(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Object visitVariableAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment object) {
		return visitAssignment(object);
	}
}
