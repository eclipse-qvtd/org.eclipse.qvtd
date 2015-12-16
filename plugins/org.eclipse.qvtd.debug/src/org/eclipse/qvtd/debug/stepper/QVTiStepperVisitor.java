/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.stepper;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.stepper.NonStepper;
import org.eclipse.ocl.examples.debug.stepper.OCLStepperVisitor;
import org.eclipse.ocl.examples.debug.stepper.PostStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepper;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;

public class QVTiStepperVisitor extends AbstractQVTimperativeStepperVisitor
{
	public static @NonNull OCLStepperVisitor INSTANCE = new QVTiStepperVisitor(QVTiStepperVisitor.class);

	protected QVTiStepperVisitor(@NonNull Object context) {
		super(context);
	}

	@Override
	public @Nullable IStepper visitAssignment(@NonNull Assignment object) {
		return PostStepper.INSTANCE;
	}

	public @Nullable IStepper visitConnectionAssignment(@NonNull ConnectionAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable IStepper visitBottomPattern(@NonNull BottomPattern object) {
		return NonStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitDomain(@NonNull Domain object) {
		return NonStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitGuardPattern(@NonNull GuardPattern object) {
		return NonStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitImperativeBottomPattern(@NonNull ImperativeBottomPattern object) {
		return NonStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitImperativeDomain(@NonNull ImperativeDomain object) {
		return visitCoreDomain(object);
	}

	@Override
	public @Nullable IStepper visitMapping(@NonNull Mapping object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitMappingCall(@NonNull MappingCall object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitMappingCallBinding(@NonNull MappingCallBinding object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitMappingLoop(@NonNull MappingLoop object) {
		return PreStepper.INSTANCE;
	}

	public @Nullable IStepper visitMappingSequence(@NonNull MappingSequence object) {
		return NonStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitMappingStatement(@NonNull MappingStatement object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitPredicate(@NonNull Predicate object) {
		return NonStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitRealizedVariable(@NonNull RealizedVariable object) {
		return NonStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitTransformation(@NonNull Transformation object) {
		return PrePostStepper.INSTANCE;
	}
}
