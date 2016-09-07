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
 * from: org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtimperativecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractDelegatingQVTimperativeCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTimperativeCSVisitor<R, C, @NonNull D extends QVTimperativeCSVisitor<R>>
	extends org.eclipse.qvtd.xtext.qvtbasecs.util.AbstractDelegatingQVTbaseCSVisitor<R, C, D>
	implements QVTimperativeCSVisitor<R>
{
	protected AbstractDelegatingQVTimperativeCSVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAreaCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AreaCS object) {
		return delegate.visitAreaCS(object);
	}

	@Override
	public R visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull BottomPatternCS object) {
		return delegate.visitBottomPatternCS(object);
	}

	@Override
	public R visitConnectionStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ConnectionStatementCS object) {
		return delegate.visitConnectionStatementCS(object);
	}

	@Override
	public R visitDirectionCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DirectionCS object) {
		return delegate.visitDirectionCS(object);
	}

	@Override
	public R visitDomainCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DomainCS object) {
		return delegate.visitDomainCS(object);
	}

	@Override
	public R visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardPatternCS object) {
		return delegate.visitGuardPatternCS(object);
	}

	@Override
	public R visitImperativeDomainCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativeDomainCS object) {
		return delegate.visitImperativeDomainCS(object);
	}

	@Override
	public R visitImperativePredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativePredicateOrAssignmentCS object) {
		return delegate.visitImperativePredicateOrAssignmentCS(object);
	}

	@Override
	public R visitImperativeRealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativeRealizedVariableCS object) {
		return delegate.visitImperativeRealizedVariableCS(object);
	}

	@Override
	public R visitMappingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCS object) {
		return delegate.visitMappingCS(object);
	}

	@Override
	public R visitMappingCallBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallBindingCS object) {
		return delegate.visitMappingCallBindingCS(object);
	}

	@Override
	public R visitMappingCallCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallCS object) {
		return delegate.visitMappingCallCS(object);
	}

	@Override
	public R visitMappingLoopCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingLoopCS object) {
		return delegate.visitMappingLoopCS(object);
	}

	@Override
	public R visitMappingSequenceCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingSequenceCS object) {
		return delegate.visitMappingSequenceCS(object);
	}

	@Override
	public R visitMappingStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingStatementCS object) {
		return delegate.visitMappingStatementCS(object);
	}

	@Override
	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ParamDeclarationCS object) {
		return delegate.visitParamDeclarationCS(object);
	}

	@Override
	public R visitPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PatternCS object) {
		return delegate.visitPatternCS(object);
	}

	@Override
	public R visitPredicateCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PredicateCS object) {
		return delegate.visitPredicateCS(object);
	}

	@Override
	public R visitPredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PredicateOrAssignmentCS object) {
		return delegate.visitPredicateOrAssignmentCS(object);
	}

	@Override
	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull QueryCS object) {
		return delegate.visitQueryCS(object);
	}

	@Override
	public R visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull RealizeableVariableCS object) {
		return delegate.visitRealizeableVariableCS(object);
	}

	@Override
	public R visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull RealizedVariableCS object) {
		return delegate.visitRealizedVariableCS(object);
	}

	@Override
	public R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}

	@Override
	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TransformationCS object) {
		return delegate.visitTransformationCS(object);
	}

	@Override
	public R visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull UnrealizedVariableCS object) {
		return delegate.visitUnrealizedVariableCS(object);
	}
}
