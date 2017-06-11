/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.VariableAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;

/**
 * A VariableAnalysis accumulates the usage of a core or relation variable and eventually synthesizes an appropriate core variable.
 *
 * @noimplement Clients should extend AbstractVariableAnalysis.
 */
public interface Variable2Variable extends VariableAnalysis
{
	/**
	 * Add the NavigationAssignment "cVariable.cProperty := cExpression" to the cBottomPattern inverting the usage
	 * of a Collection element assignment to "cExpression.cOppositeProperty := cVariable".
	 * @throws CompilerChainException
	 */
	void addNavigationAssignment(@NonNull Property targetProperty, @NonNull OCLExpression cExpression, @Nullable Boolean isPartial) throws CompilerChainException;

	/**
	 * Perform diagnostic checks at the end of the analysis.
	 */
	void check();

	/**
	 * The Core pattern in which the core variable is declared. Returns null for the 'this' variable.
	 */
	@Nullable CorePattern getCorePattern();

	/**
	 * The core variable for this analysis.
	 */
	@NonNull Variable getCoreVariable();
}