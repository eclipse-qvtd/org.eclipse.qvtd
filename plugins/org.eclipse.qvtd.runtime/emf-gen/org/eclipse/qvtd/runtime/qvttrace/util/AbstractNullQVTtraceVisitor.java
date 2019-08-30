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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullQVTtraceVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.
 */
 @Deprecated
public abstract class AbstractNullQVTtraceVisitor<@Nullable R, C>
	extends AbstractQVTtraceVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractNullQVTtraceVisitor(C context) {
		super(context);
	}

	@Override
	public R visitDispatch(org.eclipse.qvtd.runtime.qvttrace.@NonNull Dispatch object) {
		return null;
	}

	@Override
	public R visitExecution(org.eclipse.qvtd.runtime.qvttrace.@NonNull Execution object) {
		return null;
	}

	@Override
	public R visitTraceElement(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceElement object) {
		return null;
	}

	@Override
	public R visitTraceInstance(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceInstance object) {
		return null;
	}

	@Override
	public R visitTraceModel(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceModel object) {
		return null;
	}

	@Override
	public R visitTransformationExecution(org.eclipse.qvtd.runtime.qvttrace.@NonNull TransformationExecution object) {
		return null;
	}
}
