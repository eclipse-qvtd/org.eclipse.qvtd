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

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseAS2MonikerVisitor;

/**
 * An AbstractQVTimperativeAS2MonikerVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeAS2MonikerVisitor
	extends QVTbaseAS2MonikerVisitor
	implements QVTimperativeVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeAS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
	}	

	@Override
	public @Nullable Object visitAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Assignment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BottomPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Object visitConnectionAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable Object visitConnectionStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionStatement object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Object visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Object visitCoreDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CoreDomain object) {
		return visitDomain(object);
	}

	@Override
	public @Nullable Object visitCorePattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CorePattern object) {
		return visitPattern(object);
	}

	@Override
	public @Nullable Object visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtimperative.@NonNull EnforcementOperation object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitGuardPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardPattern object) {
		return visitCorePattern(object);
	}

	@Override
	public @Nullable Object visitImperativeBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

	@Override
	public @Nullable Object visitImperativeDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeDomain object) {
		return visitCoreDomain(object);
	}

	@Override
	public @Nullable Object visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable Object visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object) {
		return visitRule(object);
	}

	@Override
	public @Nullable Object visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Object visitMappingCallBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCallBinding object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object) {
		return visitCallExp(object);
	}

	@Override
	public @Nullable Object visitMappingSequence(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingSequence object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Object visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable Object visitNavigationAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NavigationAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable Object visitOppositePropertyAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull OppositePropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @Nullable Object visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull PropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @Nullable Object visitRealizedVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull RealizedVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Object visitVariableAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable Object visitVariablePredicate(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariablePredicate object) {
		return visitPredicate(object);
	}
}
