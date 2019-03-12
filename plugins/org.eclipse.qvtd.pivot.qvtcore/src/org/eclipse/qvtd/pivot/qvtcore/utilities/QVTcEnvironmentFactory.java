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
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtbase.model.QVTbaseLibrary;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;

public class QVTcEnvironmentFactory extends QVTbaseEnvironmentFactory
{
	private static class QVTcCreateStrategy extends CreateStrategy
	{
		@Override
		public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
				@NonNull QVTbaseEnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
			return new QVTcoreTemplateParameterSubstitutionVisitor(environmentFactory, selfType, selfTypeValue);
		}
	}

	public static final @NonNull CreateStrategy CREATE_STRATEGY = new QVTcCreateStrategy();

	public QVTcEnvironmentFactory(@NonNull ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
		super(projectMap, externalResourceSet, CREATE_STRATEGY);
		getStandardLibrary().setDefaultStandardLibraryURI(QVTbaseLibrary.STDLIB_URI);
	}

	@Override
	public @NonNull FlowAnalysis createFlowAnalysis(@NonNull OCLExpression contextExpression) {
		return new QVTcoreFlowAnalysis(this, contextExpression);
	}

	public boolean keepDebug() {
		return false;
	}
}
