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
	public R visitAppendParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AppendParameter object) {
		return delegate.visitAppendParameter(object);
	}

	@Override
	public R visitAppendParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AppendParameterBinding object) {
		return delegate.visitAppendParameterBinding(object);
	}

	@Override
	public R visitBufferStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BufferStatement object) {
		return delegate.visitBufferStatement(object);
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
	public R visitDeclareStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull DeclareStatement object) {
		return delegate.visitDeclareStatement(object);
	}

	@Override
	public R visitGuardParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardParameter object) {
		return delegate.visitGuardParameter(object);
	}

	@Override
	public R visitGuardParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardParameterBinding object) {
		return delegate.visitGuardParameterBinding(object);
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
	public R visitLoopParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull LoopParameterBinding object) {
		return delegate.visitLoopParameterBinding(object);
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
	public R visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object) {
		return delegate.visitMappingLoop(object);
	}

	@Override
	public R visitMappingParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameter object) {
		return delegate.visitMappingParameter(object);
	}

	@Override
	public R visitMappingParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameterBinding object) {
		return delegate.visitMappingParameterBinding(object);
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
	public R visitObservableStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ObservableStatement object) {
		return delegate.visitObservableStatement(object);
	}

	@Override
	public R visitSetStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SetStatement object) {
		return delegate.visitSetStatement(object);
	}

	@Override
	public R visitSimpleParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SimpleParameter object) {
		return delegate.visitSimpleParameter(object);
	}

	@Override
	public R visitSimpleParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SimpleParameterBinding object) {
		return delegate.visitSimpleParameterBinding(object);
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
