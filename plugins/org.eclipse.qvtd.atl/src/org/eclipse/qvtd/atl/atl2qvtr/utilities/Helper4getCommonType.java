/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.atl.atl2qvtr.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractTernaryOperation;

public class Helper4getCommonType extends AbstractTernaryOperation
{
	public static final @NonNull Helper4getCommonType INSTANCE = new Helper4getCommonType();

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object selfValue, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		org.eclipse.ocl.pivot.Class asType1 = (org.eclipse.ocl.pivot.Class)sourceValue;
		org.eclipse.ocl.pivot.Class asType2 = (org.eclipse.ocl.pivot.Class)argumentValue;
		assert (asType1 != null);
		assert (asType2 != null);
		org.eclipse.ocl.pivot.Class asCommonType = (org.eclipse.ocl.pivot.Class)asType1.getCommonType(executor.getIdResolver(), asType2);
		return asCommonType;
	}
}
