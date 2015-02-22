/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
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
 * from: org.eclipse.qvtd.xtext.qvtcorebase/model/QVTcoreBaseCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtcorebasecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTcoreBaseCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTcoreBaseCSVisitor<R, C, D extends QVTcoreBaseCSVisitor<R>>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements QVTcoreBaseCSVisitor<R>
{
	protected AbstractDelegatingQVTcoreBaseCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.xtext.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitAbstractMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractMappingCS object) {
		return delegate.visitAbstractMappingCS(object);
	}

	@Override
	public @Nullable R visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.AreaCS object) {
		return delegate.visitAreaCS(object);
	}

	@Override
	public @Nullable R visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS object) {
		return delegate.visitBottomPatternCS(object);
	}

	@Override
	public @Nullable R visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS object) {
		return delegate.visitDirectionCS(object);
	}

	@Override
	public @Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS object) {
		return delegate.visitDomainCS(object);
	}

	@Override
	public @Nullable R visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS object) {
		return delegate.visitEnforcementOperationCS(object);
	}

	@Override
	public @Nullable R visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS object) {
		return delegate.visitGuardPatternCS(object);
	}

	@Override
	public @Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.ParamDeclarationCS object) {
		return delegate.visitParamDeclarationCS(object);
	}

	@Override
	public @Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.PatternCS object) {
		return delegate.visitPatternCS(object);
	}

	@Override
	public @Nullable R visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateCS object) {
		return delegate.visitPredicateCS(object);
	}

	@Override
	public @Nullable R visitPredicateOrAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS object) {
		return delegate.visitPredicateOrAssignmentCS(object);
	}

	@Override
	public @Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS object) {
		return delegate.visitQueryCS(object);
	}

	@Override
	public @Nullable R visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.RealizeableVariableCS object) {
		return delegate.visitRealizeableVariableCS(object);
	}

	@Override
	public @Nullable R visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.RealizedVariableCS object) {
		return delegate.visitRealizedVariableCS(object);
	}

	@Override
	public @Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS object) {
		return delegate.visitTransformationCS(object);
	}

	@Override
	public @Nullable R visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS object) {
		return delegate.visitUnrealizedVariableCS(object);
	}
}
