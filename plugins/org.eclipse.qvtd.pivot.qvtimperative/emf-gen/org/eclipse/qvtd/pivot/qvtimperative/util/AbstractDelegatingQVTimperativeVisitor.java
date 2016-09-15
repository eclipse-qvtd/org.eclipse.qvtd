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
	public R visitCheckStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CheckStatement object) {
		return delegate.visitCheckStatement(object);
	}

	@Override
	public R visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object) {
		return delegate.visitConnectionVariable(object);
	}

	@Override
	public R visitGuardVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardVariable object) {
		return delegate.visitGuardVariable(object);
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
	public R visitImperativeTypedModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeTypedModel object) {
		return delegate.visitImperativeTypedModel(object);
	}

	@Override
	public R visitInConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull InConnectionVariable object) {
		return delegate.visitInConnectionVariable(object);
	}

	@Override
	public R visitLoopVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull LoopVariable object) {
		return delegate.visitLoopVariable(object);
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
	public R visitNewStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NewStatement object) {
		return delegate.visitNewStatement(object);
	}

	@Override
	public R visitOutConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull OutConnectionVariable object) {
		return delegate.visitOutConnectionVariable(object);
	}

	@Override
	public R visitPredicateVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull PredicateVariable object) {
		return delegate.visitPredicateVariable(object);
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
	public R visitVariableStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableStatement object) {
		return delegate.visitVariableStatement(object);
	}
}
