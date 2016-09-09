/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractDelegatingQVTimperativeVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTimperativeVisitor<R, C, @NonNull D extends QVTimperativeVisitor<R>>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractDelegatingQVTbaseVisitor<R, C, D>
	implements QVTimperativeVisitor<R>
{
	protected AbstractDelegatingQVTimperativeVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAddStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AddStatement object) {
		return delegate.visitAddStatement(object);
	}

	@Override
	public R visitAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Assignment object) {
		return delegate.visitAssignment(object);
	}

	@Override
	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BottomPattern object) {
		return delegate.visitBottomPattern(object);
	}

	@Override
	public R visitBottomStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BottomStatement object) {
		return delegate.visitBottomStatement(object);
	}

	@Override
	public R visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object) {
		return delegate.visitConnectionVariable(object);
	}

	@Override
	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardPattern object) {
		return delegate.visitGuardPattern(object);
	}

	@Override
	public R visitImperativeDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeDomain object) {
		return delegate.visitImperativeDomain(object);
	}

	@Override
	public R visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object) {
		return delegate.visitImperativeModel(object);
	}

	@Override
	public R visitImperativePattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativePattern object) {
		return delegate.visitImperativePattern(object);
	}

	@Override
	public R visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object) {
		return delegate.visitMapping(object);
	}

	@Override
	public R visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object) {
		return delegate.visitMappingCall(object);
	}

	@Override
	public R visitMappingCallBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCallBinding object) {
		return delegate.visitMappingCallBinding(object);
	}

	@Override
	public R visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object) {
		return delegate.visitMappingLoop(object);
	}

	@Override
	public R visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object) {
		return delegate.visitMappingStatement(object);
	}

	@Override
	public R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull RealizedVariable object) {
		return delegate.visitRealizedVariable(object);
	}

	@Override
	public R visitSetStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SetStatement object) {
		return delegate.visitSetStatement(object);
	}

	@Override
	public R visitStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Statement object) {
		return delegate.visitStatement(object);
	}

	@Override
	public R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableAssignment object) {
		return delegate.visitVariableAssignment(object);
	}

	@Override
	public R visitVariablePredicate(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariablePredicate object) {
		return delegate.visitVariablePredicate(object);
	}
}
