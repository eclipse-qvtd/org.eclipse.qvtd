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
	public R visitGuardVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardVariable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitGuardVariable(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitImperativeDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeDomain object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitImperativeDomain(object);
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
	public R visitInConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull InConnectionVariable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitInConnectionVariable(object);
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
	public R visitMappingCallBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCallBinding object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingCallBinding(object);
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
	public R visitOutConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull OutConnectionVariable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOutConnectionVariable(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPredicateVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull PredicateVariable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPredicateVariable(object);
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
