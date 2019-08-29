/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface ModelsManager
{
	@NonNull Map<@NonNull Object, @NonNull Object>[] getObject2oppositeObject();
	int getOppositePropertyIndex(@NonNull EReference eReference);
	@NonNull TypedModelInstance getTypedModelInstance(@NonNull String modelName);
	@NonNull Iterable<? extends @NonNull TypedModelInstance> getTypedModelInstances();
	@NonNull EReference @NonNull [] getPropertyIndex2eReference();
	void removeResources();
	void saveModels(@Nullable Map<?, ?> saveOptions) throws IOException;
}
