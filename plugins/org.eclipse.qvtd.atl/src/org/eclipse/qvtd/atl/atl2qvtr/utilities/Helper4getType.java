/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
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
import org.eclipse.m2m.atl.common.OCL.OclType;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;

public class Helper4getType extends AbstractBinaryOperation
{
	public static final @NonNull Helper4getType INSTANCE = new Helper4getType();

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object selfValue, @Nullable Object sourceValue) {
		OclType atlType = (OclType)sourceValue;
		if (atlType != null) {
			return HelperUtils.getType(executor, atlType);
		}
		else {
			return executor.getStandardLibrary().getOclInvalidType();
		}
	}
}
