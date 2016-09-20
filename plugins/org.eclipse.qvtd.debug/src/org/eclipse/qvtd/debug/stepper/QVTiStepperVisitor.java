/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
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
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepper;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;

public class QVTiStepperVisitor extends AbstractQVTimperativeStepperVisitor
{
	public static @NonNull QVTiStepperVisitor INSTANCE = new QVTiStepperVisitor(QVTiStepperVisitor.class);

	protected QVTiStepperVisitor(@NonNull Object context) {
		super(context);
	}

	@Override
	public @Nullable IStepper visitAddStatement(@NonNull AddStatement object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitAppendParameter(@NonNull AppendParameter object) {
		return NonStepper.INSTANCE;
	}

	@Override
	public IStepper visitAppendParameterBinding(@NonNull AppendParameterBinding object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitBufferStatement(@NonNull BufferStatement object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitCheckStatement(@NonNull CheckStatement object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitConnectionVariable(@NonNull ConnectionVariable object) {
		return visiting(object);
	}

	@Override
	public @Nullable IStepper visitDeclareStatement(@NonNull DeclareStatement asVariable) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitDomain(@NonNull Domain object) {
		return visiting(object);
	}

	@Override
	public @Nullable IStepper visitGuardParameter(@NonNull GuardParameter asVariable) {
		return NonStepper.INSTANCE;
	}

	@Override
	public IStepper visitGuardParameterBinding(@NonNull GuardParameterBinding object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitImperativeTypedModel(@NonNull ImperativeTypedModel object) {
		return NonStepper.INSTANCE;
	}

	@Override
	public IStepper visitLoopParameterBinding(@NonNull LoopParameterBinding object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitLoopVariable(@NonNull LoopVariable asVariable) {
		return NonStepper.INSTANCE;
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
	public @Nullable IStepper visitMappingLoop(@NonNull MappingLoop object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitMappingParameter(@NonNull MappingParameter object) {
		return visiting(object);
	}

	@Override
	public @Nullable IStepper visitMappingParameterBinding(@NonNull MappingParameterBinding object) {
		return visiting(object);
	}

	@Override
	public @Nullable IStepper visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);
	}

	@Override
	public @Nullable IStepper visitNewStatement(@NonNull NewStatement object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitObservableStatement(@NonNull ObservableStatement object) {
		return visiting(object);
	}

	@Override
	public @Nullable IStepper visitPredicate(@NonNull Predicate object) {
		return NonStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitSetStatement(@NonNull SetStatement object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitSimpleParameter(@NonNull SimpleParameter asVariable) {
		return NonStepper.INSTANCE;
	}

	@Override
	public IStepper visitSimpleParameterBinding(@NonNull SimpleParameterBinding object) {
		return PreStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitStatement(@NonNull Statement object) {
		return visiting(object);
	}

	@Override
	public @Nullable IStepper visitTransformation(@NonNull Transformation object) {
		return PrePostStepper.INSTANCE;
	}
}
