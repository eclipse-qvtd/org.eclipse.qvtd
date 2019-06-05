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

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractTernaryOperation;

public class Helper4getOperation extends AbstractTernaryOperation
{
	public static final @NonNull Helper4getOperation INSTANCE = new Helper4getOperation();

	@Override
	public @NonNull Operation evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object selfValue, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		org.eclipse.ocl.pivot.Class asType = (org.eclipse.ocl.pivot.Class)sourceValue;
		Operation asOperation = null;
		assert (asType != null);// {
		String operationName = (String) argumentValue;
		assert operationName != null;
		CompleteClass completeClass = executor.getEnvironmentFactory().getCompleteModel().getCompleteClass(asType);
		Iterator<@NonNull Operation> asOperations = completeClass.getOperations(null, operationName).iterator();
		asOperation = asOperations.hasNext() ? asOperations.next() : null;
		//		}
		if (asOperation == null) {
			asOperation = executor.getStandardLibrary().getOclInvalidOperation();
		}
		return asOperation;
	}
}
