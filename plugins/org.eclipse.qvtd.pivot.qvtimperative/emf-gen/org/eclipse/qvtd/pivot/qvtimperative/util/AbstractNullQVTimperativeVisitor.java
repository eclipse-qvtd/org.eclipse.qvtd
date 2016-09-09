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
 * An AbstractNullQVTimperativeVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.  
 */
 @Deprecated
public abstract class AbstractNullQVTimperativeVisitor<@Nullable R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractNullQVTbaseVisitor<R, C> implements QVTimperativeVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTimperativeVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitAddStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AddStatement object) {
		return null;
	}

	@Override
	public R visitAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Assignment object) {
		return null;
	}

	@Override
	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BottomPattern object) {
		return null;
	}

	@Override
	public R visitBottomStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BottomStatement object) {
		return null;
	}

	@Override
	public R visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object) {
		return null;
	}

	@Override
	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardPattern object) {
		return null;
	}

	@Override
	public R visitImperativeDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeDomain object) {
		return null;
	}

	@Override
	public R visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object) {
		return null;
	}

	@Override
	public R visitImperativePattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativePattern object) {
		return null;
	}

	@Override
	public R visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object) {
		return null;
	}

	@Override
	public R visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object) {
		return null;
	}

	@Override
	public R visitMappingCallBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCallBinding object) {
		return null;
	}

	@Override
	public R visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object) {
		return null;
	}

	@Override
	public R visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object) {
		return null;
	}

	@Override
	public R visitNewStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NewStatement object) {
		return null;
	}

	@Override
	public R visitSetStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SetStatement object) {
		return null;
	}

	@Override
	public R visitStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Statement object) {
		return null;
	}

	@Override
	public R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableAssignment object) {
		return null;
	}

	@Override
	public R visitVariablePredicate(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariablePredicate object) {
		return null;
	}
}
