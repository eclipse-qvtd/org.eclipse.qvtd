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
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public interface IQVTiEvaluationEnvironment extends EvaluationEnvironment
{
	@Override
	@NonNull QVTiModelManager getModelManager();
	@NonNull QVTiRootEvaluationEnvironment getRootEvaluationEnvironment();
	@NonNull Transformation getTransformation();
}
