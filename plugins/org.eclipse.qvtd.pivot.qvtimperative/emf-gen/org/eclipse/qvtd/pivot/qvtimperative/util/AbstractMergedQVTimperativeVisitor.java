/*******************************************************************************
 * <copyright>
 * 
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
 * An AbstractMergedQVTimperativeVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedQVTimperativeVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractMergedQVTbaseVisitor<R, C>
	implements QVTimperativeVisitor<R>
{
	protected AbstractMergedQVTimperativeVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Assignment object) {
		return visiting(object);
	}

	@Override
	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BottomPattern object) {
		return visiting(object);
	}

	@Override
	public R visitConnectionAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionAssignment object) {
		return visiting(object);
	}

	@Override
	public R visitConnectionStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionStatement object) {
		return visiting(object);
	}

	@Override
	public R visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object) {
		return visiting(object);
	}

	@Override
	public R visitCoreDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CoreDomain object) {
		return visiting(object);
	}

	@Override
	public R visitCorePattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CorePattern object) {
		return visiting(object);
	}

	@Override
	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardPattern object) {
		return visiting(object);
	}

	@Override
	public R visitImperativeBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeBottomPattern object) {
		return visiting(object);
	}

	@Override
	public R visitImperativeDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeDomain object) {
		return visiting(object);
	}

	@Override
	public R visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object) {
		return visiting(object);
	}

	@Override
	public R visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object) {
		return visiting(object);
	}

	@Override
	public R visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object) {
		return visiting(object);
	}

	@Override
	public R visitMappingCallBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCallBinding object) {
		return visiting(object);
	}

	@Override
	public R visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object) {
		return visiting(object);
	}

	@Override
	public R visitMappingSequence(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingSequence object) {
		return visiting(object);
	}

	@Override
	public R visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object) {
		return visiting(object);
	}

	@Override
	public R visitNavigationAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NavigationAssignment object) {
		return visiting(object);
	}

	@Override
	public R visitOppositePropertyAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull OppositePropertyAssignment object) {
		return visiting(object);
	}

	@Override
	public R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull PropertyAssignment object) {
		return visiting(object);
	}

	@Override
	public R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull RealizedVariable object) {
		return visiting(object);
	}

	@Override
	public R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableAssignment object) {
		return visiting(object);
	}

	@Override
	public R visitVariablePredicate(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariablePredicate object) {
		return visiting(object);
	}
}
