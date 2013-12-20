/*******************************************************************************
 * Copyright (c) 2013 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.PivotEvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class QVTiEnvironmentFactory extends PivotEnvironmentFactory {

	public QVTiEnvironmentFactory(@Nullable EPackage.Registry reg, @NonNull MetaModelManager metaModelManager) {
		super(reg, metaModelManager);
	}

	@Override
	public @NonNull PivotEvaluationEnvironment createEvaluationEnvironment() {
		throw new UnsupportedOperationException();
	}

	public @NonNull IQVTiEvaluationEnvironment createEvaluationEnvironment(@NonNull Transformation transformation) {
		return new QVTiRootEvaluationEnvironment(getMetaModelManager(), transformation);
	}

	@Override
	public @NonNull IQVTiEvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent) {
		return new QVTiNestedEvaluationEnvironment((QVTiEvaluationEnvironment) parent);
	}

	public @NonNull QVTiEvaluationVisitor createEvaluationVisitor(@NonNull Environment env, @NonNull IQVTiEvaluationEnvironment evalEnv, @NonNull QVTiModelManager modelManager) {
		QVTiEvaluationVisitor visitor = new QVTiEvaluationVisitorImpl(env, evalEnv, modelManager);
		return visitor;
	}

	public @NonNull QVTiModelManager createModelManager(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
		return new QVTiModelManager(transformationAnalysis);
	}

	public @NonNull QVTiTransformationAnalysis createTransformationAnalysis() {
		return new QVTiTransformationAnalysis(metaModelManager);
	}

	public boolean keepDebug() {
		return false;
	}
}
