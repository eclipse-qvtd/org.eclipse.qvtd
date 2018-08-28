/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
 * An AbstractMergedQVTtraceVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedQVTtraceVisitor<R, C>
	extends AbstractQVTtraceVisitor<R, C>
	implements QVTtraceVisitor<R>
{
	protected AbstractMergedQVTtraceVisitor(C context) {
		super(context);
	}

	@Override
	public R visitDispatch(org.eclipse.qvtd.runtime.qvttrace.@NonNull Dispatch object) {
		return visiting(object);
	}

	@Override
	public R visitExecution(org.eclipse.qvtd.runtime.qvttrace.@NonNull Execution object) {
		return visiting(object);
	}

	@Override
	public R visitTraceElement(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceElement object) {
		return visiting(object);
	}

	@Override
	public R visitTraceInstance(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceInstance object) {
		return visiting(object);
	}

	@Override
	public R visitTraceModel(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceModel object) {
		return visiting(object);
	}
}
