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
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class QVTiEnvironmentFactory extends AbstractEnvironmentFactory {

	public QVTiEnvironmentFactory(@Nullable ProjectManager projectMap) {
		super(projectMap);
	}

	@Override
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent, @NonNull NamedElement executableObject) {
		if (parent instanceof IQVTiEvaluationEnvironment) {
			return new QVTiNestedEvaluationEnvironment((IQVTiEvaluationEnvironment) parent, executableObject);
		}
		else{
			return super.createEvaluationEnvironment(parent, executableObject);
		}
	}

	@Override
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull NamedElement executableObject, @NonNull ModelManager modelManager) {
		if (executableObject instanceof Transformation) {
			return new QVTiRootEvaluationEnvironment(this, (Transformation) executableObject, (QVTiModelManager) modelManager);
		}
		else {
			return super.createEvaluationEnvironment(executableObject, modelManager);
		}
	}

	@Override
	public @NonNull EvaluationVisitor createEvaluationVisitor(@NonNull EvaluationEnvironment evalEnv) {
		if (evalEnv instanceof IQVTiEvaluationEnvironment) {
			IQVTiEvaluationVisitor visitor = new QVTiEvaluationVisitor((IQVTiEvaluationEnvironment)evalEnv);
	        if (isEvaluationTracingEnabled()) {
	            // decorate the evaluation visitor with tracing support
	        	visitor = new QVTiTracingEvaluationVisitor(visitor);
	        	((QVTiTracingEvaluationVisitor)visitor).setVerboseLevel(QVTiTracingEvaluationVisitor.VERBOSE_LEVEL_HIGH);
	        }
			return visitor;
		}
		else {
			return super.createEvaluationVisitor(evalEnv);
		}
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
