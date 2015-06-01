/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.evaluator.AbstractVMEnvironmentFactory;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEnvironmentFactory;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationAnalysis;

public class QVTiVMEnvironmentFactory extends AbstractVMEnvironmentFactory implements IVMEnvironmentFactory
{
	public QVTiVMEnvironmentFactory(@NonNull QVTiEnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	public @NonNull IQVTiVMEvaluationEnvironment createVMEvaluationEnvironment(@NonNull Transformation transformation, @NonNull QVTiModelManager modelManager) {
		return new QVTiVMRootEvaluationEnvironment(this, transformation, modelManager, getNextEnvironmentId());
	}

	public @NonNull IQVTiVMEvaluationEnvironment createVMEvaluationEnvironment(@NonNull IQVTiVMEvaluationEnvironment parent, @NonNull NamedElement operation) {
		return new QVTiVMNestedEvaluationEnvironment(parent, operation, getNextEnvironmentId());
	}

	public @NonNull QVTiVMRootEvaluationVisitor createVMEvaluationVisitor(@NonNull IQVTiVMEvaluationEnvironment evalEnv) {
		return new QVTiVMRootEvaluationVisitor(evalEnv, ClassUtil.nonNullState(getShell()));
	}

	public @NonNull QVTiVMModelManager createVMModelManager(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
		return new QVTiVMModelManager(transformationAnalysis);
	}

	@Override
	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
	}
}
