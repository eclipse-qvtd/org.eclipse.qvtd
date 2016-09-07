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

import java.lang.Boolean;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseAS2XMIidVisitor;

/**
 * An AbstractQVTimperativeAS2XMIidVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeAS2XMIidVisitor
	extends QVTbaseAS2XMIidVisitor
	implements QVTimperativeVisitor<Boolean>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}	

	@Override
	public @Nullable Boolean visitAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Assignment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BottomPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Boolean visitConnectionAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable Boolean visitConnectionStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionStatement object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Boolean visitCoreDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CoreDomain object) {
		return visitDomain(object);
	}

	@Override
	public @Nullable Boolean visitCorePattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CorePattern object) {
		return visitPattern(object);
	}

	@Override
	public @Nullable Boolean visitGuardPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Boolean visitImperativeBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

	@Override
	public @Nullable Boolean visitImperativeDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeDomain object) {
		return visitCoreDomain(object);
	}

	@Override
	public @Nullable Boolean visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable Boolean visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object) {
		return visitRule(object);
	}

	@Override
	public @Nullable Boolean visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitMappingCallBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCallBinding object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object) {
		return visitCallExp(object);
	}

	@Override
	public @Nullable Boolean visitMappingSequence(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingSequence object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable Boolean visitNavigationAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NavigationAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable Boolean visitOppositePropertyAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull OppositePropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @Nullable Boolean visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull PropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @Nullable Boolean visitRealizedVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull RealizedVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Boolean visitVariableAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable Boolean visitVariablePredicate(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariablePredicate object) {
		return visitPredicate(object);
	}
}
