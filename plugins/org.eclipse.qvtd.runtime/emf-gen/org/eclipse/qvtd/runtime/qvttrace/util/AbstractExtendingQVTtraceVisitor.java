/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.runtime/model/QVTtrace.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.runtime.qvttrace.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingQVTtraceVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTtraceVisitor<R, C>
	extends AbstractQVTtraceVisitor<R, C>
	implements QVTtraceVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTtraceVisitor(C context) {
		super(context);
	}

	@Override
	public R visitDispatch(org.eclipse.qvtd.runtime.qvttrace.@NonNull Dispatch object) {
		return visitTraceInstance(object);
	}

	@Override
	public R visitExecution(org.eclipse.qvtd.runtime.qvttrace.@NonNull Execution object) {
		return visitTraceInstance(object);
	}

	@Override
	public R visitTraceElement(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceElement object) {
		return visiting(object);
	}

	@Override
	public R visitTraceInstance(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceInstance object) {
		return visitTraceElement(object);
	}

	@Override
	public R visitTraceModel(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceModel object) {
		return visitTraceElement(object);
	}
}
