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
import org.eclipse.jdt.annotation.Nullable;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface QVTtraceVisitor<R>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class,
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	R visiting(org.eclipse.qvtd.runtime.qvttrace.util.@NonNull TraceVisitable visitable);

	R visitDispatch(org.eclipse.qvtd.runtime.qvttrace.@NonNull Dispatch object);
	R visitExecution(org.eclipse.qvtd.runtime.qvttrace.@NonNull Execution object);
	R visitTraceElement(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceElement object);
	R visitTraceInstance(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceInstance object);
	R visitTraceModel(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceModel object);
}
