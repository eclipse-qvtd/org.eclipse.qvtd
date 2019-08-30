/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor.ExecutorExtension;

/**
 * A TransformationExecutor supervises the execution of an auto-generated transformation.
 *
 * @noimplement
 */
public interface TransformationExecutor extends ExecutorExtension
{
	@Nullable Resource addInputURI(@NonNull String modelName, @NonNull URI modelURI);
	@NonNull Resource addOutputURI(@NonNull String modelName, @NonNull URI modelURI);
	@Override
	void dispose();
	Boolean execute(@Nullable Integer targetTypedModelIndex) throws Exception;
	@NonNull ModelsManager getModelsManager();
	@Nullable EObject getTransformationExecution();
	@NonNull Transformer getTransformer();
	int getTypedModelIndex(@NonNull String targetModelName);
	@NonNull TypedModelInstance getTypedModelInstance(@NonNull String modelName);
	void saveModels(@Nullable Map<?, ?> saveOptions) throws IOException;
	void setContextualProperty(@NonNull String propertyName, Object value);
	void setSuppressFailureDiagnosis(boolean suppressFailureDiagnosis);
}
