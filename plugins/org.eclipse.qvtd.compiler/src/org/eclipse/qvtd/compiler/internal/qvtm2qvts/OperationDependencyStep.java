/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;

/**
 * OperationDependencyStep describes one step in the set of alternative usages of an analyzed operation input/output value.
 */
public interface OperationDependencyStep extends Nameable
{
	public interface ClassStep extends OperationDependencyStep
	{
		boolean isParameter();
	}

	public interface PropertyStep extends OperationDependencyStep
	{
		@NonNull CallExp getCallExp();
		@NonNull Property getProperty();
	}

	@NonNull Element getElement();
	org.eclipse.ocl.pivot.@NonNull Class getElementalType();
	@NonNull Element getPathElement();
	@NonNull DomainUsage getUsage();
}