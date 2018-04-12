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
 * An AbstractWrappingQVTtraceVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingQVTtraceVisitor<R, C, @NonNull D extends QVTtraceVisitor<R>, P>
	extends AbstractQVTtraceVisitor<R, C>
	implements QVTtraceVisitor<R>
{
	protected final @NonNull D delegate;

	protected AbstractWrappingQVTtraceVisitor(@NonNull D delegate, C context) {
		super(context);
		this.delegate = delegate;
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Intercept an exception thrown by the delegated visit to perform some post-functionality that may use the visitable object,
	 * the result of preVisit and the thrown exception to determine the overall wrapped result.
	 *
	 * @return a rethrown RuntimeException or a RuntimeException-wrapped non-RuntimeException.
	 */
	protected R badVisit(org.eclipse.qvtd.runtime.qvttrace.util.@NonNull TraceVisitable visitable, @Nullable P prologue, @NonNull Throwable e) throws RuntimeException {
		if (e instanceof Exception) {
			throw (RuntimeException)e;
		}
		else {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Obtains the visitor that I wrap.
	 *
	 * @return my wrapped visitor
	 */
	protected @NonNull D getDelegate() {
		return delegate;
	}

	/**
	 * Intercept the result of the delegated visit to perform some post-functionality that may use the visitable object,
	 * the result of preVisit and the result of the delegated visit to determine the overall wrapped result.
	 *
	 * @return the epilogue result, which defaults to the delegated result.
	 */
	protected R postVisit(org.eclipse.qvtd.runtime.qvttrace.util.@NonNull TraceVisitable visitable, @Nullable P prologue, R result) {
		return result;
	}

	/**
	 * Compute and return some value before performing the delegated visit.
	 *
	 * @return the prologue result, which defauilts to null.
	 */
	protected @Nullable P preVisit(org.eclipse.qvtd.runtime.qvttrace.util.@NonNull TraceVisitable visitable) {
		return null;
	}

	@Override
	public R visiting(org.eclipse.qvtd.runtime.qvttrace.util.@NonNull TraceVisitable visitable) {
		throw new UnsupportedOperationException();		// Cannot happen since all methods delegate.
	}

	@Override
	public R visitDispatch(org.eclipse.qvtd.runtime.qvttrace.@NonNull Dispatch object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDispatch(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitExecution(org.eclipse.qvtd.runtime.qvttrace.@NonNull Execution object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitExecution(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTraceElement(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceElement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTraceElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTraceInstance(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceInstance object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTraceInstance(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTraceModel(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceModel object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTraceModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
