/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.pivot/model/Pivot.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.runtime.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * @since 1.1
 */
public interface ExecutionVisitor<R>
{
	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
//	@Nullable R visiting(@NonNull ExecutionVisitable visitable);

	@Nullable R visitInvocation(@NonNull Invocation object);
	@Nullable R visitInvocationManager(@NonNull InvocationManager object);
	@Nullable R visitObjectManager(@NonNull ObjectManager object);
	@Nullable R visitSlotState(@NonNull SlotState object);
	@Nullable R visitTransformer(@NonNull Transformer object);
}