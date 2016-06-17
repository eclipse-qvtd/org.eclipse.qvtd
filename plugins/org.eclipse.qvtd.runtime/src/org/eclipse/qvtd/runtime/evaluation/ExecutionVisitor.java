/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
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

/**
 * @since 1.1
 */
public interface ExecutionVisitor<R>
{
	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
//	R visiting(@NonNull ExecutionVisitable visitable);

	R visitValueOccurrence(@NonNull Computation object);
	R visitInvocation(@NonNull Invocation object);
	R visitInvocationManager(@NonNull InvocationManager object);
	R visitObjectManager(@NonNull ObjectManager object);
	R visitSlotState(@NonNull SlotState object);
	R visitTransformer(@NonNull Transformer object);
}
