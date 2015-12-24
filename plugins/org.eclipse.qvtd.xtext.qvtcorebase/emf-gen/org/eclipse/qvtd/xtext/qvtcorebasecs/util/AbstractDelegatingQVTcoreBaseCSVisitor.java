/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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

/**
 * An AbstractDelegatingQVTcoreBaseCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTcoreBaseCSVisitor<R, C, D extends QVTcoreBaseCSVisitor<R>>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements QVTcoreBaseCSVisitor<R>
{
	protected AbstractDelegatingQVTcoreBaseCSVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAbstractMappingCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull AbstractMappingCS object) {
		return delegate.visitAbstractMappingCS(object);
	}

	@Override
	public R visitAreaCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull AreaCS object) {
		return delegate.visitAreaCS(object);
	}

	@Override
	public R visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull BottomPatternCS object) {
		return delegate.visitBottomPatternCS(object);
	}

	@Override
	public R visitDirectionCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull DirectionCS object) {
		return delegate.visitDirectionCS(object);
	}

	@Override
	public R visitDomainCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull DomainCS object) {
		return delegate.visitDomainCS(object);
	}

	@Override
	public R visitEnforcementOperationCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull EnforcementOperationCS object) {
		return delegate.visitEnforcementOperationCS(object);
	}

	@Override
	public R visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull GuardPatternCS object) {
		return delegate.visitGuardPatternCS(object);
	}

	@Override
	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull ParamDeclarationCS object) {
		return delegate.visitParamDeclarationCS(object);
	}

	@Override
	public R visitPatternCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull PatternCS object) {
		return delegate.visitPatternCS(object);
	}

	@Override
	public R visitPredicateCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull PredicateCS object) {
		return delegate.visitPredicateCS(object);
	}

	@Override
	public R visitPredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull PredicateOrAssignmentCS object) {
		return delegate.visitPredicateOrAssignmentCS(object);
	}

	@Override
	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull QueryCS object) {
		return delegate.visitQueryCS(object);
	}

	@Override
	public R visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull RealizeableVariableCS object) {
		return delegate.visitRealizeableVariableCS(object);
	}

	@Override
	public R visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull RealizedVariableCS object) {
		return delegate.visitRealizedVariableCS(object);
	}

	@Override
	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull TransformationCS object) {
		return delegate.visitTransformationCS(object);
	}

	@Override
	public R visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull UnrealizedVariableCS object) {
		return delegate.visitUnrealizedVariableCS(object);
	}
}
