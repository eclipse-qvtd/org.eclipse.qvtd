/*******************************************************************************
 * Copyright (c) 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests.helpers;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;

public class ExternalFunctionSum extends AbstractBinaryOperation
{
	public static final @NonNull ExternalFunctionSum INSTANCE = new ExternalFunctionSum();

	@SuppressWarnings("null")
	@Override
	public @NonNull Integer evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object firstValue, @Nullable Object secondValue) {
		Integer int1 = (@NonNull Integer)firstValue;
		Integer int2 = (@NonNull Integer)secondValue;
		return Integer.valueOf(int1 + int2);
	}
}
