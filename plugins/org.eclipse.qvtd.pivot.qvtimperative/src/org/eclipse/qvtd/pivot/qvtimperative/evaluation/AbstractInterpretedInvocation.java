/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;

public abstract class AbstractInterpretedInvocation extends AbstractInvocation
{
	protected final @NonNull Object @NonNull [] values;

	public AbstractInterpretedInvocation(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] theseValues) {
		super(constructor);
		int iMax = theseValues.length;
		this.values = new @NonNull Object[iMax];
		for (int i = 0; i < iMax; i++) {
			this.values[i] = theseValues[i];
		}
	}

	@Override
	public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
		int iMax = thoseValues.length;
		if (iMax != values.length) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			if (!idResolver.oclEquals(values[i], thoseValues[i])) {
				return false;
			}
		}
		return true;
	}
}