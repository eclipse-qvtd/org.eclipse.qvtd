/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.runtime.evaluation.AbstractModelsManager;

/**
 * EnvironmentStrategy provides the QVTc/QVTi/QVTr behavioral variation for a QVTimperativeEnvironmentFactory.
 * Derived QVTimperativeEnvironmentFactory are obsolete since the behaviour variaes from initially QVTc/QVTr to QVTi.
 */
public abstract class EnvironmentStrategy
{
	public @NonNull EntryPointsAnalysis createEntryPointsAnalysis(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation transformation) {
		throw new UnsupportedOperationException(); // XXX
	}

	public @NonNull AbstractModelsManager createModelsManager(@NonNull EntryPointAnalysis entryPointAnalysis) {
		throw new UnsupportedOperationException(); // XXX
	}

	public abstract @NonNull FlowAnalysis createFlowAnalysis(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull OCLExpression contextExpression);

	public abstract @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@NonNull QVTimperativeEnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue);

	public abstract @NonNull String getDefaultStandardLibraryURI();
}