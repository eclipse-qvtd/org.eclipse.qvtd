/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.evaluation.PivotEvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.resource.StandaloneProjectMap;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class QVTiEnvironmentFactory extends PivotEnvironmentFactory {

	public QVTiEnvironmentFactory(@Nullable StandaloneProjectMap projectMap, @Nullable ModelManager modelManager) {
		super(projectMap, modelManager);
	}

	@Override
	public @NonNull PivotEvaluationEnvironment createEvaluationEnvironment() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull IQVTiEvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent) {
		return new QVTiNestedEvaluationEnvironment((IQVTiEvaluationEnvironment) parent);
	}

	public @NonNull IQVTiEvaluationEnvironment createEvaluationEnvironment(@NonNull QVTiModelManager modelManager, @NonNull Transformation transformation) {
		return new QVTiRootEvaluationEnvironment(this, modelManager, transformation);
	}

	public @NonNull IQVTiEvaluationEnvironment createEvaluationEnvironment(@NonNull IQVTiEvaluationEnvironment parent, @NonNull NamedElement operation) {
		return new QVTiNestedEvaluationEnvironment(parent);
	}

	public @NonNull QVTiEvaluationVisitor createEvaluationVisitor(@NonNull IQVTiEvaluationEnvironment evalEnv) {
		QVTiEvaluationVisitor visitor = new QVTiEvaluationVisitorImpl(evalEnv);
        if (isEvaluationTracingEnabled()) {
            // decorate the evaluation visitor with tracing support
        	visitor = new QVTiTracingEvaluationVisitor(visitor);
        	((QVTiTracingEvaluationVisitor)visitor).setVerboseLevel(QVTiTracingEvaluationVisitor.VERBOSE_LEVEL_HIGH);
        }
		return visitor;
	}

	public @NonNull QVTiModelManager createModelManager(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
		return new QVTiModelManager(transformationAnalysis);
	}

	public @NonNull QVTiTransformationAnalysis createTransformationAnalysis() {
		return new QVTiTransformationAnalysis(getMetamodelManager());
	}

	public boolean keepDebug() {
		return false;
	}
}
