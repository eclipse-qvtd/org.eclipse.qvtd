/**
 * <copyright>
 * 
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.debug.stepper;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.stepper.AbstractStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.IRootVMEvaluationVisitor;
import org.eclipse.ocl.examples.pivot.Element;

public class NonStepper extends AbstractStepper
{
	public static @NonNull NonStepper INSTANCE = new NonStepper();
	
	@Override
	public @Nullable Element isPostStoppable(@NonNull IRootVMEvaluationVisitor<?> rootVMEvaluationVisitor, @NonNull Element childElement, @Nullable Element parentElement) {
		return null;
	}

	@Override
	public boolean isPreStoppable(@NonNull IRootVMEvaluationVisitor<?> rootVMEvaluationVisitor, @NonNull Element element) {
		return false;
	}
}
