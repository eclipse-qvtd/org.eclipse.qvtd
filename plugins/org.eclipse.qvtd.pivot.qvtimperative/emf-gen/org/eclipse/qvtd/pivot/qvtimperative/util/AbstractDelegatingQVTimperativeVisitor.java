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
	public R visitAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Assignment object) {
		return delegate.visitAssignment(object);
	}

	@Override
	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BottomPattern object) {
		return delegate.visitBottomPattern(object);
	}

	@Override
	public R visitConnectionAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionAssignment object) {
		return delegate.visitConnectionAssignment(object);
	}

	@Override
	public R visitConnectionStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionStatement object) {
		return delegate.visitConnectionStatement(object);
	}

	@Override
	public R visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object) {
		return delegate.visitConnectionVariable(object);
	}

	@Override
	public R visitCoreDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CoreDomain object) {
		return delegate.visitCoreDomain(object);
	}

	@Override
	public R visitCorePattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CorePattern object) {
		return delegate.visitCorePattern(object);
	}

	@Override
	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardPattern object) {
		return delegate.visitGuardPattern(object);
	}

	@Override
	public R visitImperativeBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeBottomPattern object) {
		return delegate.visitImperativeBottomPattern(object);
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
	public R visitMappingSequence(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingSequence object) {
		return delegate.visitMappingSequence(object);
	}

	@Override
	public R visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object) {
		return delegate.visitMappingStatement(object);
	}

	@Override
	public R visitNavigationAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NavigationAssignment object) {
		return delegate.visitNavigationAssignment(object);
	}

	@Override
	public R visitOppositePropertyAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull OppositePropertyAssignment object) {
		return delegate.visitOppositePropertyAssignment(object);
	}

	@Override
	public R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull PropertyAssignment object) {
		return delegate.visitPropertyAssignment(object);
	}

	@Override
	public R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull RealizedVariable object) {
		return delegate.visitRealizedVariable(object);
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
