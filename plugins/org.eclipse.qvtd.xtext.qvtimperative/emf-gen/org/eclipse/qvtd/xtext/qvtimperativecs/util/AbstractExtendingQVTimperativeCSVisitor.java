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
 * An AbstractExtendingQVTimperativeCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTimperativeCSVisitor<R, C>
	extends org.eclipse.qvtd.xtext.qvtbasecs.util.AbstractExtendingQVTbaseCSVisitor<R, C>
	implements QVTimperativeCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTimperativeCSVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitAreaCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AreaCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull BottomPatternCS object) {
		return visitPatternCS(object);
	}

	@Override
	public R visitConnectionStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ConnectionStatementCS object) {
		return visitMappingStatementCS(object);
	}

	@Override
	public R visitDirectionCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DirectionCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitDomainCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DomainCS object) {
		return visitAreaCS(object);
	}

	@Override
	public R visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardPatternCS object) {
		return visitPatternCS(object);
	}

	@Override
	public R visitImperativeDomainCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativeDomainCS object) {
		return visitDomainCS(object);
	}

	@Override
	public R visitImperativePredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativePredicateOrAssignmentCS object) {
		return visitPredicateOrAssignmentCS(object);
	}

	@Override
	public R visitImperativeRealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativeRealizedVariableCS object) {
		return visitRealizedVariableCS(object);
	}

	@Override
	public R visitMappingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitMappingCallBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallBindingCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitMappingCallCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallCS object) {
		return visitMappingStatementCS(object);
	}

	@Override
	public R visitMappingLoopCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingLoopCS object) {
		return visitMappingStatementCS(object);
	}

	@Override
	public R visitMappingSequenceCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingSequenceCS object) {
		return visitMappingStatementCS(object);
	}

	@Override
	public R visitMappingStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingStatementCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PatternCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitPredicateCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PredicateCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitPredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PredicateOrAssignmentCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull QueryCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull RealizeableVariableCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull RealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}

	@Override
	public R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TopLevelCS object) {
		return visitRootPackageCS(object);
	}

	@Override
	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TransformationCS object) {
		return visitAbstractTransformationCS(object);
	}

	@Override
	public R visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull UnrealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}
}
