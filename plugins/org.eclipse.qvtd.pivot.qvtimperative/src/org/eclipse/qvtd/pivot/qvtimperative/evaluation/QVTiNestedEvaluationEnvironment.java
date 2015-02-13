/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class QVTiNestedEvaluationEnvironment extends QVTiEvaluationEnvironment
{
	protected final @NonNull QVTiRootEvaluationEnvironment rootEvaluationEnvironment;
	
	public QVTiNestedEvaluationEnvironment(@NonNull IQVTiEvaluationEnvironment evaluationEnvironment, @NonNull NamedElement executableObject) {
		super(evaluationEnvironment, executableObject);
		rootEvaluationEnvironment = evaluationEnvironment.getRootEvaluationEnvironment();
	}

	@Override
	public @NonNull Transformation getTransformation() {
		return rootEvaluationEnvironment.getTransformation();
	}

	@Override
	public @NonNull QVTiRootEvaluationEnvironment getRootEvaluationEnvironment() {
		return rootEvaluationEnvironment;
	}
}
