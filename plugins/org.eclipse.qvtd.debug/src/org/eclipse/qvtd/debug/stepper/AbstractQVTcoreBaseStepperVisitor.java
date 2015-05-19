/*******************************************************************************
 * Copyright (c) 2013 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.debug.stepper;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepper;
import org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor;

/**
 * An AbstractQVTcoreBaseStepperVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTcoreBaseStepperVisitor
	extends AbstractQVTbaseStepperVisitor
	implements QVTcoreBaseVisitor<IStepper>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTcoreBaseStepperVisitor(@NonNull Object context) {
		super(context);
	}	

	public @Nullable IStepper visitAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.Assignment object) {
		return visitElement(object);
	}

	public @Nullable IStepper visitBottomPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern object) {
		return visitCorePattern(object);
	}

	public @Nullable IStepper visitCoreDomain(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain object) {
		return visitDomain(object);
	}

	public @Nullable IStepper visitCorePattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CorePattern object) {
		return visitPattern(object);
	}

	public @Nullable IStepper visitEnforcementOperation(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation object) {
		return visitElement(object);
	}

	public @Nullable IStepper visitGuardPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern object) {
		return visitCorePattern(object);
	}

	public @Nullable IStepper visitPropertyAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment object) {
		return visitAssignment(object);
	}

	public @Nullable IStepper visitRealizedVariable(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable object) {
		return visitVariable(object);
	}

	public @Nullable IStepper visitVariableAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment object) {
		return visitAssignment(object);
	}
}
