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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Environment;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.PivotEvaluationEnvironment;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class QVTiEnvironmentFactory extends PivotEnvironmentFactory {

	public QVTiEnvironmentFactory(@Nullable EPackage.Registry reg, @NonNull MetaModelManager metaModelManager) {
		super(reg, metaModelManager);
	}

	@Override
	public @NonNull QVTiEnvironment createEnvironment() {
		return new QVTiEnvironment(this, null);
	}

	@Override
	public @NonNull QVTiEnvironment createEnvironment(@NonNull Environment parent) {
		if (!(parent instanceof QVTiEnvironment)) {
			throw new IllegalArgumentException("Parent environment must be a QVTi environment: " + parent); //$NON-NLS-1$
		}
		return new QVTiEnvironment((QVTiEnvironment) parent);
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

	public @NonNull QVTiEvaluationVisitor createEvaluationVisitor(@NonNull QVTiEnvironment env, @NonNull IQVTiEvaluationEnvironment evalEnv) {
		QVTiEvaluationVisitor visitor = new QVTiEvaluationVisitorImpl(env, evalEnv);
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
		return new QVTiTransformationAnalysis(metaModelManager);
	}

	public boolean keepDebug() {
		return false;
	}
}
