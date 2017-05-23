/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.model.QVTimperativeLibrary;
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

	//	@Override
	//	public @NonNull BasicOCLExecutor createExecutor( @NonNull ModelManager modelManager) {
	//		return new BasicOCLExecutor(this, modelManager);		// Inherited functionality used for validation
	//	}

	public @NonNull QVTiModelsManager createModelsManager(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
		return new QVTiModelsManager(transformationAnalysis);
	}

	public @NonNull QVTiTransformationAnalysis createTransformationAnalysis(@NonNull ImperativeTransformation transformation) {
		return new QVTiTransformationAnalysis(this, transformation);
	}

	public boolean keepDebug() {
		return false;
	}
}
