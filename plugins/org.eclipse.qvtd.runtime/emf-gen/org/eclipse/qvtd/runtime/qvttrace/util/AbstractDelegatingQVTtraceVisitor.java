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
 * An AbstractDelegatingQVTtraceVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTtraceVisitor<R, C, @NonNull D extends QVTtraceVisitor<R>>
	extends AbstractQVTtraceVisitor<R, C>
	implements QVTtraceVisitor<R>
{
	protected final @NonNull D delegate;

	protected AbstractDelegatingQVTtraceVisitor(@NonNull D delegate, C context) {
		super(context);
	//	assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$
		this.delegate = delegate;
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	//	public @NonNull DecorableQVTtraceVisitor<R> createNestedVisitor() {
	//		return delegate.createNestedVisitor();
	//	}

	/**
	 * Obtains the visitor that I decorate.
	 *
	 * @return my decorated visitor
	 */
	protected final @NonNull D getDelegate() {
		return delegate;
	}

	@Override
	public R visiting(org.eclipse.qvtd.runtime.qvttrace.util.@NonNull TraceVisitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitDispatch(org.eclipse.qvtd.runtime.qvttrace.@NonNull Dispatch object) {
		return delegate.visitDispatch(object);
	}

	@Override
	public R visitExecution(org.eclipse.qvtd.runtime.qvttrace.@NonNull Execution object) {
		return delegate.visitExecution(object);
	}

	@Override
	public R visitTraceElement(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceElement object) {
		return delegate.visitTraceElement(object);
	}

	@Override
	public R visitTraceInstance(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceInstance object) {
		return delegate.visitTraceInstance(object);
	}

	@Override
	public R visitTraceModel(org.eclipse.qvtd.runtime.qvttrace.@NonNull TraceModel object) {
		return delegate.visitTraceModel(object);
	}
}