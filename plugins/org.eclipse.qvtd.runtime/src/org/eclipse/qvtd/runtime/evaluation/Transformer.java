/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.evaluation.EvaluationCache;
import org.eclipse.qvtd.runtime.qvttrace.TransformationExecution;

/**
 * A Transformer provides the core support to execute an auto-generated transformation
 * between models.
 *
 * @noimplement clients should derive from AbstractTransformer
 */
public interface Transformer extends ExecutionVisitable
{
	/**
	 * Clients may reference this explicitly to force a compile-time failure for a mismatch.
	 *
	 * @noreference this is solely for development usage.
	 *
	 * 1.1.0-1 API version introduced, ObjectManager etc interfaces separated out, AbstractObjectManager etc enforced.
	 * 1.1.0-2 Preliminary incremental support.
	 */
	public static int RUN_TIME_EVALUATOR_API_VERSION_1_1_0_2 = 1*1000 + 1 * 100 + 0*10 + 2;

	/**
	 * The run-time API version.
	 *
	 * @noreference this is solely for development usage.
	 */
	public static int RUN_TIME_EVALUATOR_API_VERSION = RUN_TIME_EVALUATOR_API_VERSION_1_1_0_2;

	void analyzeInputResources();
	@NonNull EvaluationCache getEvaluationCache();
	@NonNull TransformationExecutor getExecutor();
	@NonNull InvocationManager getInvocationManager();
	@NonNull ModelsManager getModelsManager();
	@NonNull ObjectManager getObjectManager();
	@Nullable TransformationExecution getTransformationExecution();
	int getTypedModelIndex(@NonNull String targetModelName);
	@NonNull TypedModelInstance getTypedModelInstance(@NonNull String modelName);
	boolean run() throws Exception;
	boolean run(@NonNull String targetName) throws Exception;
}
