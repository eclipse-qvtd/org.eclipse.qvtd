/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.model.QVTbaseLibrary;

public class QVTbaseEnvironmentFactory extends AbstractEnvironmentFactory
{
	public static abstract class CreateStrategy
	{
		public abstract @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
				@NonNull QVTbaseEnvironmentFactory environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue);
	}

	private @Nullable CreateStrategy createStrategy = null;

	public QVTbaseEnvironmentFactory(@NonNull ProjectManager projectManager,
			@Nullable ResourceSet externalResourceSet, @Nullable CreateStrategy createStrategy) {
		super(projectManager, externalResourceSet);
		this.createStrategy = createStrategy;
		getStandardLibrary().setDefaultStandardLibraryURI(QVTbaseLibrary.STDLIB_URI);
	}

	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@Nullable Type selfType, @Nullable Type selfTypeValue) {
		if (createStrategy != null) {
			return createStrategy.createTemplateParameterSubstitutionVisitor(this, selfType, selfTypeValue);
		}
		else {
			return super.createTemplateParameterSubstitutionVisitor(selfType, selfTypeValue);
		}
	}

	public @Nullable CreateStrategy getCreateStrategy() {
		return createStrategy;
	}

	public @Nullable CreateStrategy setCreateStrategy(@Nullable CreateStrategy createStrategy) {
		CreateStrategy savedStrategy = this.createStrategy;
		this.createStrategy = createStrategy;
		return savedStrategy;
	}
}
