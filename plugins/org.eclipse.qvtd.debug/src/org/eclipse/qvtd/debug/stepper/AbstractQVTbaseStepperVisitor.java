/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.debug.stepper;

import org.eclipse.ocl.examples.debug.stepper.OCLStepperVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepper;
import org.eclipse.qvtd.pivot.qvtbase.FunctionBody;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractQVTbaseStepperVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTbaseStepperVisitor
extends OCLStepperVisitor
implements QVTbaseVisitor<IStepper>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTbaseStepperVisitor(@NonNull Object context) {
		super(context);
	}

	@Override
	public @Nullable IStepper visitBaseModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull BaseModel object) {
		return visitModel(object);
	}

	@Override
	public @Nullable IStepper visitDomain(org.eclipse.qvtd.pivot.qvtbase.@NonNull Domain object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable IStepper visitFunction(org.eclipse.qvtd.pivot.qvtbase.@NonNull Function object) {
		return visitOperation(object);
	}

	@Override
	public @Nullable IStepper visitFunctionBody(@NonNull FunctionBody object) {
		return super.visitExpressionInOCL(object);
	}

	@Override
	public @Nullable IStepper visitFunctionParameter(org.eclipse.qvtd.pivot.qvtbase.@NonNull FunctionParameter object) {
		return visitParameter(object);
	}

	@Override
	public @Nullable IStepper visitPattern(org.eclipse.qvtd.pivot.qvtbase.@NonNull Pattern object) {
		return visitElement(object);
	}

	@Override
	public @Nullable IStepper visitPredicate(org.eclipse.qvtd.pivot.qvtbase.@NonNull Predicate object) {
		return visitElement(object);
	}

	@Override
	public @Nullable IStepper visitRule(org.eclipse.qvtd.pivot.qvtbase.@NonNull Rule object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable IStepper visitTransformation(org.eclipse.qvtd.pivot.qvtbase.@NonNull Transformation object) {
		return visitClass(object);
	}

	@Override
	public @Nullable IStepper visitTypedModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel object) {
		return visitNamedElement(object);
	}
}
