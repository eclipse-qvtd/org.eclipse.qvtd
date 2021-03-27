/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.runtime.evaluation.AbstractModelsManager;
import org.eclipse.qvtd.runtime.model.QVTruntimeLibrary;

public class QVTbaseEnvironmentFactory extends PivotEnvironmentFactory
{
	public static interface EntryPointAnalysisInterface {}
	public static interface EntryPointsAnalysisInterface {}

	/**
	 * CreateStrategy provides the QVTc/QVTi/QVTr behavioral variation for a QVTbaseEnvironmentFactory.
	 * Derived QVTbaseEnvironmentFactory are obsolete since the behaviour variaes from initially QVTc/QVTr to QVTi.
	 */
	public static abstract class CreateStrategy
	{
		public @NonNull EntryPointsAnalysisInterface createEntryPointsAnalysis(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull Transformation transformation) {
			throw new UnsupportedOperationException(); // XXX
		}

		public @NonNull AbstractModelsManager createModelsManager(@NonNull EntryPointAnalysisInterface entryPointAnalysis) {
			throw new UnsupportedOperationException(); // XXX
		}

		public abstract @NonNull FlowAnalysis createFlowAnalysis(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull OCLExpression contextExpression);

		public abstract @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
				@NonNull QVTbaseEnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue);

		public abstract @NonNull String getDefaultStandardLibraryURI();
	}

	private @NonNull CreateStrategy createStrategy;

	public QVTbaseEnvironmentFactory(@NonNull ProjectManager projectManager,
			@Nullable ResourceSet externalResourceSet, @NonNull CreateStrategy createStrategy) {
		super(projectManager, externalResourceSet, null);
		this.createStrategy = createStrategy;
		String primaryDefaultStandardLibraryURI = QVTruntimeLibrary.STDLIB_URI;
		String secondaryDefaultStandardLibraryURI = createStrategy.getDefaultStandardLibraryURI();
		StandardLibraryInternal standardLibrary = getStandardLibrary();
		standardLibrary.setDefaultStandardLibraryURI(primaryDefaultStandardLibraryURI);
		if (!secondaryDefaultStandardLibraryURI.equals(primaryDefaultStandardLibraryURI)) {
			standardLibrary.setDefaultStandardLibraryURI(secondaryDefaultStandardLibraryURI);
		}
	}

	public @NonNull EntryPointsAnalysisInterface createEntryPointsAnalysis(@NonNull Transformation transformation) {
		return createStrategy.createEntryPointsAnalysis(this, transformation);
	}

	@Override
	public final @NonNull FlowAnalysis createFlowAnalysis(@NonNull OCLExpression contextExpression) {
		return createStrategy.createFlowAnalysis(this, contextExpression);
	}

	public @NonNull AbstractModelsManager createModelsManager(@NonNull EntryPointAnalysisInterface entryPointAnalysis) {
		return createStrategy.createModelsManager(entryPointAnalysis);
	}

	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@Nullable Type selfType, @Nullable Type selfTypeValue) {
		return createStrategy.createTemplateParameterSubstitutionVisitor(this, selfType, selfTypeValue);
	}

	public @NonNull CreateStrategy getCreateStrategy() {
		return createStrategy;
	}

	public boolean keepDebug() {
		return false;
	}

	public @NonNull CreateStrategy setCreateStrategy(@NonNull CreateStrategy createStrategy) {
		CreateStrategy savedStrategy = this.createStrategy;
		this.createStrategy = createStrategy;
		return savedStrategy;
	}
}
