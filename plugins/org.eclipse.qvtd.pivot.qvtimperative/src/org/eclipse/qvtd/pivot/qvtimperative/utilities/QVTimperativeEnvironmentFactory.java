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
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.runtime.evaluation.AbstractModelsManager;
import org.eclipse.qvtd.runtime.model.QVTruntimeLibrary;

public class QVTimperativeEnvironmentFactory extends PivotEnvironmentFactory
{
	/**
	 * Strategy provides the QVTc/QVTi/QVTr behavioral variation for a QVTimperativeEnvironmentFactory.
	 * Derived QVTimperativeEnvironmentFactory are obsolete since the behaviour variaes from initially QVTc/QVTr to QVTi.
	 */
	public static abstract class Strategy
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

	private @NonNull Strategy createStrategy;

	protected QVTimperativeEnvironmentFactory(@NonNull ProjectManager projectManager,
			@Nullable ResourceSet externalResourceSet, @NonNull Strategy createStrategy) {
		super(projectManager, externalResourceSet, null);
		this.createStrategy = createStrategy;
		String primaryStandardLibraryURI = QVTruntimeLibrary.STDLIB_URI;
		String secondaryStandardLibraryURI = createStrategy.getDefaultStandardLibraryURI();
		StandardLibraryInternal standardLibrary = getStandardLibrary();
		standardLibrary.setDefaultStandardLibraryURI(primaryStandardLibraryURI);
		if (!secondaryStandardLibraryURI.equals(primaryStandardLibraryURI)) {
			standardLibrary.setDefaultStandardLibraryURI(secondaryStandardLibraryURI);
		}
	}

	public @NonNull EntryPointsAnalysis createEntryPointsAnalysis(@NonNull ImperativeTransformation transformation) {
		return createStrategy.createEntryPointsAnalysis(this, transformation);
	}

	@Override
	public final @NonNull FlowAnalysis createFlowAnalysis(@NonNull OCLExpression contextExpression) {
		return createStrategy.createFlowAnalysis(this, contextExpression);
	}

	public @NonNull AbstractModelsManager createModelsManager(@NonNull EntryPointAnalysis entryPointAnalysis) {
		return createStrategy.createModelsManager(entryPointAnalysis);
	}

	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@Nullable Type selfType, @Nullable Type selfTypeValue) {
		return createStrategy.createTemplateParameterSubstitutionVisitor(this, selfType, selfTypeValue);
	}

	public @NonNull Strategy getCreateStrategy() {
		return createStrategy;
	}

	public boolean keepDebug() {
		return false;
	}

	public @NonNull Strategy setCreateStrategy(@NonNull Strategy createStrategy) {
		Strategy savedStrategy = this.createStrategy;
		this.createStrategy = createStrategy;
		return savedStrategy;
	}
}
