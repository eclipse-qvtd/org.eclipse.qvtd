/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.model.QVTimperativeLibrary;

public class QVTiEnvironmentFactory extends QVTbaseEnvironmentFactory
{
	public QVTiEnvironmentFactory(@NonNull ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
		super(projectMap, externalResourceSet);
		getStandardLibrary().setDefaultStandardLibraryURI(QVTimperativeLibrary.STDLIB_URI);
	}

	@Override
	public @NonNull QVTiExecutor createExecutor( @NonNull ModelManager modelManager) {
		return new BasicQVTiExecutor(this, modelManager);
	}

	public @NonNull QVTiModelManager createModelManager(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
		return new QVTiModelManager(transformationAnalysis);
	}

	public @NonNull QVTiTransformationAnalysis createTransformationAnalysis() {
		return new QVTiTransformationAnalysis(this);
	}

	public boolean keepDebug() {
		return false;
	}
}
