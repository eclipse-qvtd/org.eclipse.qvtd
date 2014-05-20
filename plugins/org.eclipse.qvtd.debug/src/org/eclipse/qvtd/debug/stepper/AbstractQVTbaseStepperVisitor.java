/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.debug.stepper;

import org.eclipse.ocl.examples.debug.stepper.OCLStepperVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepper;
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

	public @Nullable IStepper visitBaseModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.BaseModel object) {
		return visitRoot(object);
	}

	public @Nullable IStepper visitDomain(@NonNull org.eclipse.qvtd.pivot.qvtbase.Domain object) {
		return visitNamedElement(object);
	}

	public @Nullable IStepper visitFunction(@NonNull org.eclipse.qvtd.pivot.qvtbase.Function object) {
		return visitOperation(object);
	}

	public @Nullable IStepper visitFunctionParameter(@NonNull org.eclipse.qvtd.pivot.qvtbase.FunctionParameter object) {
		return visitParameter(object);
	}

	public @Nullable IStepper visitPattern(@NonNull org.eclipse.qvtd.pivot.qvtbase.Pattern object) {
		return visitElement(object);
	}

	public @Nullable IStepper visitPredicate(@NonNull org.eclipse.qvtd.pivot.qvtbase.Predicate object) {
		return visitElement(object);
	}

	public @Nullable IStepper visitRule(@NonNull org.eclipse.qvtd.pivot.qvtbase.Rule object) {
		return visitNamedElement(object);
	}

	public @Nullable IStepper visitTransformation(@NonNull org.eclipse.qvtd.pivot.qvtbase.Transformation object) {
		return visitClass(object);
	}

	public @Nullable IStepper visitTypedModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.TypedModel object) {
		return visitNamedElement(object);
	}

	public @Nullable IStepper visitUnit(@NonNull org.eclipse.qvtd.pivot.qvtbase.Unit object) {
		return visitNamedElement(object);
	}
}
