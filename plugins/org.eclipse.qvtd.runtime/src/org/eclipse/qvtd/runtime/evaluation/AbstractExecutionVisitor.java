/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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

public /*abstract*/ class AbstractExecutionVisitor<R> implements ExecutionVisitor<R>
{
	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	public R visiting(@NonNull ExecutionVisitable visitable) {
		throw new UnsupportedOperationException("No " + getClass().getSimpleName() + " support for a " + visitable.getClass().getSimpleName());
	}

	@Override
	public R visitComputation(@NonNull Computation object) {
		return visiting(object);
	}

	@Override
	public R visitConnection(@NonNull Connection object) {
		return visiting(object);
	}

	@Override
	public R visitInterval(@NonNull Interval object) {
		return visiting(object);
	}

	@Override
	public R visitInvocation(@NonNull Invocation object) {
		return visiting(object);
	}

	@Override
	public R visitInvocationConstructor(@NonNull InvocationConstructor object) {
		return visiting(object);
	}

	@Override
	public R visitInvocationManager(@NonNull InvocationManager object) {
		return visiting(object);
	}

	@Override
	public R visitObjectManager(@NonNull ObjectManager object) {
		return visiting(object);
	}

	@Override
	public R visitSlotState(@NonNull SlotState object) {
		return visiting(object);
	}

	@Override
	public R visitTransformer(@NonNull Transformer object) {
		return visiting(object);
	}
}
