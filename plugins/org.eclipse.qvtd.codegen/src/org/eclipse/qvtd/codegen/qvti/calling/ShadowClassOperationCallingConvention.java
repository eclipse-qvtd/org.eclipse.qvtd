/*******************************************************************************
 * Copyright (c) 2022 Willink Transformation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.calling;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Operation;

/**
 *  ShadowClassOperationCallingConvention defines the support for the call of an operation returning an implemented DataType.
 */
public class ShadowClassOperationCallingConvention extends ShadowFunctionOperationCallingConvention		// FIXME Promote to OCL
{
	private static final @NonNull ShadowClassOperationCallingConvention INSTANCE = new ShadowClassOperationCallingConvention();

	public static @NonNull ShadowClassOperationCallingConvention getInstance(@NonNull Operation asOperation, boolean maybeVirtual) {
		INSTANCE.logInstance(asOperation, maybeVirtual);
		return INSTANCE;
	}
}
