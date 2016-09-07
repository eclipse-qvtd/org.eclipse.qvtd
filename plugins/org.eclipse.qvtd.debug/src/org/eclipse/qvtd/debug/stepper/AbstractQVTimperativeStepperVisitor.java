/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
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
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * An AbstractQVTimperativeStepperVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeStepperVisitor
extends AbstractQVTbaseStepperVisitor
implements QVTimperativeVisitor<IStepper>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeStepperVisitor(@NonNull Object context) {
		super(context);
	}

	@Override
	public @Nullable IStepper visitAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Assignment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable IStepper visitBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BottomPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable IStepper visitCoreDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CoreDomain object) {
		return visitDomain(object);
	}

	@Override
	public @Nullable IStepper visitCorePattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CorePattern object) {
		return visitPattern(object);
	}

	@Override
	public @Nullable IStepper visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtimperative.@NonNull EnforcementOperation object) {
		return visitElement(object);
	}

	@Override
	public @Nullable IStepper visitGuardPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable IStepper visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable IStepper visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object) {
		return visitRule(object);
	}

	@Override
	public @Nullable IStepper visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable IStepper visitMappingCallBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCallBinding object) {
		return visitElement(object);
	}

	@Override
	public @Nullable IStepper visitNavigationAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NavigationAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable IStepper visitOppositePropertyAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull OppositePropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @Nullable IStepper visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull PropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @Nullable IStepper visitRealizedVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull RealizedVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable IStepper visitVariableAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable IStepper visitVariablePredicate(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariablePredicate object) {
		return visitPredicate(object);
	}
}
