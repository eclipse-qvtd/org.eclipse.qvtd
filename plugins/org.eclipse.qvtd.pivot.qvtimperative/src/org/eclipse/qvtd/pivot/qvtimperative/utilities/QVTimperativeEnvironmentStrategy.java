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
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelsManager;
import org.eclipse.qvtd.pivot.qvtimperative.model.QVTimperativeLibrary;

public class QVTimperativeEnvironmentStrategy extends EnvironmentStrategy
{
	public static final @NonNull EnvironmentStrategy INSTANCE = new QVTimperativeEnvironmentStrategy();

	@Override
	public @NonNull EntryPointsAnalysis createEntryPointsAnalysis(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation transformation) {
		return new EntryPointsAnalysis(environmentFactory, transformation);
	}

	@Override
	public @NonNull FlowAnalysis createFlowAnalysis(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull OCLExpression contextExpression) {
		return new QVTimperativeFlowAnalysis(environmentFactory, contextExpression);
	}

	@Override
	public @NonNull QVTiModelsManager createModelsManager(@NonNull EntryPointAnalysis entryPointAnalysis) {
		return new QVTiModelsManager(entryPointAnalysis);
	}

	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@NonNull QVTimperativeEnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		return new QVTimperativeTemplateParameterSubstitutionVisitor(environmentFactory, selfType, selfTypeValue);
	}

	@Override
	public @NonNull String getDefaultStandardLibraryURI() {
		return QVTimperativeLibrary.STDLIB_URI;
	}
}