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
 * from: org.eclipse.qvtd.xtext.qvtcore/model/QVTcoreCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtcorecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractDelegatingQVTcoreCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTcoreCSVisitor<R, C, @NonNull D extends QVTcoreCSVisitor<R>>
	extends org.eclipse.qvtd.xtext.qvtbasecs.util.AbstractDelegatingQVTbaseCSVisitor<R, C, D>
	implements QVTcoreCSVisitor<R>
{
	protected AbstractDelegatingQVTcoreCSVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAreaCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull AreaCS object) {
		return delegate.visitAreaCS(object);
	}

	@Override
	public R visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull BottomPatternCS object) {
		return delegate.visitBottomPatternCS(object);
	}

	@Override
	public R visitDirectionCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull DirectionCS object) {
		return delegate.visitDirectionCS(object);
	}

	@Override
	public R visitDomainCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull DomainCS object) {
		return delegate.visitDomainCS(object);
	}

	@Override
	public R visitEnforcementOperationCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull EnforcementOperationCS object) {
		return delegate.visitEnforcementOperationCS(object);
	}

	@Override
	public R visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull GuardPatternCS object) {
		return delegate.visitGuardPatternCS(object);
	}

	@Override
	public R visitMappingCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull MappingCS object) {
		return delegate.visitMappingCS(object);
	}

	@Override
	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull ParamDeclarationCS object) {
		return delegate.visitParamDeclarationCS(object);
	}

	@Override
	public R visitPatternCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull PatternCS object) {
		return delegate.visitPatternCS(object);
	}

	@Override
	public R visitPredicateCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull PredicateCS object) {
		return delegate.visitPredicateCS(object);
	}

	@Override
	public R visitPredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull PredicateOrAssignmentCS object) {
		return delegate.visitPredicateOrAssignmentCS(object);
	}

	@Override
	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull QueryCS object) {
		return delegate.visitQueryCS(object);
	}

	@Override
	public R visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull RealizeableVariableCS object) {
		return delegate.visitRealizeableVariableCS(object);
	}

	@Override
	public R visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull RealizedVariableCS object) {
		return delegate.visitRealizedVariableCS(object);
	}

	@Override
	public R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}

	@Override
	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull TransformationCS object) {
		return delegate.visitTransformationCS(object);
	}

	@Override
	public R visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull UnrealizedVariableCS object) {
		return delegate.visitUnrealizedVariableCS(object);
	}
}
