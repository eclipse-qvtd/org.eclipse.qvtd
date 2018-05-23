/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.atl.atl2qvtr.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;

public class Helper4getProperty extends AbstractBinaryOperation
{
	public static final @NonNull Helper4getProperty INSTANCE = new Helper4getProperty();

	@Override
	public @NonNull Property evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		org.eclipse.ocl.pivot.Class asType = (org.eclipse.ocl.pivot.Class)sourceValue;
		Property asProperty = null;
		assert (asType != null);
		String propertyName = (String) argumentValue;
		assert propertyName != null;
		CompleteClass completeClass = executor.getEnvironmentFactory().getCompleteModel().getCompleteClass(asType);
		asProperty = completeClass.getProperty(propertyName);
		//		}
		if (asProperty == null) {
			asProperty = executor.getStandardLibrary().getOclInvalidProperty();
		}
		return asProperty;
	}
}
