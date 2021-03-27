/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.runtime.model.QVTruntimeLibrary;

public class QVTrEnvironmentFactory extends QVTbaseEnvironmentFactory
{
	private static class QVTrCreateStrategy extends CreateStrategy
	{
		@Override
		public @NonNull FlowAnalysis createFlowAnalysis(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull OCLExpression contextExpression) {
			return new QVTrelationFlowAnalysis(environmentFactory, contextExpression);
		}

		@Override
		public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
				@NonNull QVTbaseEnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
			return new QVTrelationTemplateParameterSubstitutionVisitor(environmentFactory, selfType, selfTypeValue);
		}

		@Override
		public @NonNull String getDefaultStandardLibraryURI() {
			return QVTruntimeLibrary.STDLIB_URI;
		}
	}

	public static final @NonNull CreateStrategy CREATE_STRATEGY = new QVTrCreateStrategy();

	@Deprecated /* @deprecated Use QVTbaseEnvironmentFactory */
	public QVTrEnvironmentFactory(@NonNull ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
		super(projectMap, externalResourceSet, CREATE_STRATEGY);
	}
}
