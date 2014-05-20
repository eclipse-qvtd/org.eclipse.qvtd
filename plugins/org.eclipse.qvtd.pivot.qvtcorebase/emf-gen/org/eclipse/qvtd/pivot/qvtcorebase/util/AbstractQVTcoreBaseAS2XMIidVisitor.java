/*******************************************************************************
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

import java.lang.Boolean;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseAS2XMIidVisitor;

/**
 * An AbstractQVTcoreBaseAS2XMIidVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTcoreBaseAS2XMIidVisitor
	extends QVTbaseAS2XMIidVisitor
	implements QVTcoreBaseVisitor<Boolean>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTcoreBaseAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}	

	public @Nullable Boolean visitAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.Assignment object) {
		return visitElement(object);
	}

	public @Nullable Boolean visitBottomPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern object) {
		return visitCorePattern(object);
	}

	public @Nullable Boolean visitCoreDomain(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain object) {
		return visitDomain(object);
	}

	public @Nullable Boolean visitCorePattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CorePattern object) {
		return visitPattern(object);
	}

	public @Nullable Boolean visitEnforcementOperation(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation object) {
		return visitElement(object);
	}

	public @Nullable Boolean visitGuardPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern object) {
		return visitCorePattern(object);
	}

	public @Nullable Boolean visitPropertyAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment object) {
		return visitAssignment(object);
	}

	public @Nullable Boolean visitRealizedVariable(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable object) {
		return visitVariable(object);
	}

	public @Nullable Boolean visitVariableAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment object) {
		return visitAssignment(object);
	}
}
