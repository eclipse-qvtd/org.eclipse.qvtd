/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;

public interface QVTiEvaluationEnvironment extends EvaluationEnvironment.EvaluationEnvironmentExtension
{
	@Override
	@NonNull QVTiExecutor getExecutor();
	@NonNull QVTiRootEvaluationEnvironment getRootEvaluationEnvironment();
	@NonNull Transformation getTransformation();
	@Nullable DomainUsage getUsageFor(@NonNull Element element);
}
