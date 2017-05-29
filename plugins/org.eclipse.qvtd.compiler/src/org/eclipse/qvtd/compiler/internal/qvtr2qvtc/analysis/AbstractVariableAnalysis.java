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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractVariableAnalysis provides the abstract accumulation the usage of a core or relation variable.
 * Derived CoreVariableAnalysis/RelationVariableAnalysis/ThisVariableAnalysis provide real functionality.
 */
public abstract class AbstractVariableAnalysis implements VariableAnalysis
{
	protected final @NonNull VariablesAnalysis variablesAnalysis;
	//	protected final @NonNull String name;

	protected AbstractVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis) {
		this.variablesAnalysis = variablesAnalysis;
		//		this.name = variablesAnalysis.getUniqueVariableName(name, this);
	}
}