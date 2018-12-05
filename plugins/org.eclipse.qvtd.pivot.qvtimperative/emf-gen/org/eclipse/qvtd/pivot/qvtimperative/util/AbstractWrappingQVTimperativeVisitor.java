/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractWrappingQVTimperativeVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingQVTimperativeVisitor<R, C, @NonNull D extends QVTimperativeVisitor<R>, P>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractWrappingQVTbaseVisitor<R, C, D, P>
	implements QVTimperativeVisitor<R>
{
	protected AbstractWrappingQVTimperativeVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visitAddStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AddStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAddStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAppendParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AppendParameter object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAppendParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAppendParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AppendParameterBinding object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAppendParameterBinding(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBufferStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BufferStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBufferStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCheckStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CheckStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCheckStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitConnectionVariable(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDeclareStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull DeclareStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDeclareStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitGuardParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardParameter object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitGuardParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitGuardParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardParameterBinding object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitGuardParameterBinding(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitImperativeModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitImperativeTransformation(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeTransformation object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitImperativeTransformation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitImperativeTypedModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeTypedModel object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitImperativeTypedModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLoopParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull LoopParameterBinding object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLoopParameterBinding(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLoopVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull LoopVariable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLoopVariable(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMapping(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingCall(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingLoop(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMappingParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameter object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMappingParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameterBinding object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingParameterBinding(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNewStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NewStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNewStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitObservableStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ObservableStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitObservableStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSetStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SetStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSetStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSimpleParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SimpleParameter object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSimpleParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSimpleParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SimpleParameterBinding object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSimpleParameterBinding(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Statement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVariableStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVariableStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
