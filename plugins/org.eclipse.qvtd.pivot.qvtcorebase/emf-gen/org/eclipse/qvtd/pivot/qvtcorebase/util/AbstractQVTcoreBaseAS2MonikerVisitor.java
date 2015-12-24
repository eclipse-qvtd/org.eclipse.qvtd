/*******************************************************************************
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

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseAS2MonikerVisitor;

/**
 * An AbstractQVTcoreBaseAS2MonikerVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTcoreBaseAS2MonikerVisitor
	extends QVTbaseAS2MonikerVisitor
	implements QVTcoreBaseVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTcoreBaseAS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
	}	

	@Override
	public @Nullable Object visitAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull Assignment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitBottomPattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull BottomPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Object visitCoreDomain(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull CoreDomain object) {
		return visitDomain(object);
	}

	@Override
	public @Nullable Object visitCorePattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull CorePattern object) {
		return visitPattern(object);
	}

	@Override
	public @Nullable Object visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull EnforcementOperation object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitGuardPattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull GuardPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Object visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull PropertyAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable Object visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull RealizedVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Object visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull VariableAssignment object) {
		return visitAssignment(object);
	}
}
