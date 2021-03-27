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
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.model.QVTimperativeLibrary;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeFlowAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeTemplateParameterSubstitutionVisitor;

public class QVTiEnvironmentFactory extends QVTbaseEnvironmentFactory
{
	private static class QVTiCreateStrategy extends CreateStrategy
	{
		@Override
		public @NonNull EntryPointsAnalysisInterface createEntryPointsAnalysis(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull Transformation transformation) {
			return new EntryPointsAnalysis(environmentFactory, (ImperativeTransformation)transformation);
		}

		@Override
		public @NonNull FlowAnalysis createFlowAnalysis(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull OCLExpression contextExpression) {
			return new QVTimperativeFlowAnalysis(environmentFactory, contextExpression);
		}

		@Override
		public @NonNull QVTiModelsManager createModelsManager(@NonNull EntryPointAnalysisInterface entryPointAnalysis) {
			return new QVTiModelsManager((EntryPointAnalysis)entryPointAnalysis);
		}

		@Override
		public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
				@NonNull QVTbaseEnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
			return new QVTimperativeTemplateParameterSubstitutionVisitor(environmentFactory, selfType, selfTypeValue);
		}

		@Override
		public @NonNull String getDefaultStandardLibraryURI() {
			return QVTimperativeLibrary.STDLIB_URI;
		}
	}

	public static final @NonNull CreateStrategy CREATE_STRATEGY = new QVTiCreateStrategy();

	@Deprecated /* @deprecated Use QVTbaseEnvironmentFactory */
	public QVTiEnvironmentFactory(@NonNull ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
		super(projectMap, externalResourceSet, CREATE_STRATEGY);
	}
}
