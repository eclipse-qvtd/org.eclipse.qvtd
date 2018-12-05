/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class QVTiNestedEvaluationEnvironment extends BasicEvaluationEnvironment implements QVTiEvaluationEnvironment
{
	protected final @NonNull QVTiRootEvaluationEnvironment rootEvaluationEnvironment;

	public QVTiNestedEvaluationEnvironment(@NonNull QVTiEvaluationEnvironment evaluationEnvironment, @NonNull NamedElement executableObject, @Nullable Object caller) {
		super(evaluationEnvironment, executableObject, caller);
		rootEvaluationEnvironment = evaluationEnvironment.getRootEvaluationEnvironment();
	}

	@Override
	public @NonNull QVTiExecutor getExecutor() {
		return (QVTiExecutor) super.getExecutor();
	}

	@Override
	public @NonNull QVTiEvaluationEnvironment getParentEvaluationEnvironment() {
		EvaluationEnvironment parent = getParent();
		assert parent != null;
		return (QVTiEvaluationEnvironment)parent;
	}

	@Override
	public @NonNull QVTiRootEvaluationEnvironment getRootEvaluationEnvironment() {
		return rootEvaluationEnvironment;
	}

	@Override
	public @NonNull Transformation getTransformation() {
		return rootEvaluationEnvironment.getTransformation();
	}
}
