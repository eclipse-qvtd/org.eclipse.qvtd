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
		public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
				@NonNull QVTbaseEnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
			return new QVTimperativeTemplateParameterSubstitutionVisitor(environmentFactory, selfType, selfTypeValue);
		}
	}

	public static final @NonNull CreateStrategy CREATE_STRATEGY = new QVTiCreateStrategy();

	public QVTiEnvironmentFactory(@NonNull ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
		super(projectMap, externalResourceSet, CREATE_STRATEGY);
		getStandardLibrary().setDefaultStandardLibraryURI(QVTimperativeLibrary.STDLIB_URI);
	}

	public @NonNull EntryPointsAnalysis createEntryPointsAnalysis(@NonNull ImperativeTransformation transformation) {
		return new EntryPointsAnalysis(this, transformation);
	}

	//	@Override
	//	public @NonNull BasicOCLExecutor createExecutor( @NonNull ModelManager modelManager) {
	//		return new BasicOCLExecutor(this, modelManager);		// Inherited functionality used for validation
	//	}

	public @NonNull QVTiModelsManager createModelsManager(@NonNull EntryPointAnalysis entryPointAnalysis) {
		return new QVTiModelsManager(entryPointAnalysis);
	}

	@Override
	public @NonNull FlowAnalysis createFlowAnalysis(@NonNull OCLExpression contextExpression) {
		return new QVTimperativeFlowAnalysis(this, contextExpression);
	}

	public boolean keepDebug() {
		return false;
	}
}
