/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.common;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * A SimpleConfigurations comprises a single TypedModelsConfiguration for which an output TypedModel
 * is specifued by name and all other TYpedModels are inputs.
 *
 * This is appropriate for the common use case of a unidirectional transformation or for
 * a unidirectional compilation of a multidirectional transfprmation.
 */
public class SimpleConfigurations extends TypedModelsConfigurations
{

	public SimpleConfigurations(@NonNull String enforcedTypedModelName) {
		add(new TypedModelsConfiguration(enforcedTypedModelName));
	}

	@Override
	public @Nullable String reconcile(@NonNull Transformation transformation) {
		return super.reconcile(transformation);
	}
}
