/*******************************************************************************
 * Copyright (c) 2010, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.qvtd.xtext.qvtbase.cs2as.QVTbaseCSPostOrderVisitor;

/**
 * An AbstractQVTimperativeCSPostOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeCSPostOrderVisitor
	extends QVTbaseCSPostOrderVisitor
	implements QVTimperativeCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Continuation<?> visitAreaCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AreaCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull BottomPatternCS csElement) {
		return visitPatternCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitConnectionStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ConnectionStatementCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitDirectionCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DirectionCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitDomainCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DomainCS csElement) {
		return visitAreaCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardPatternCS csElement) {
		return visitPatternCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitImperativeDomainCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativeDomainCS csElement) {
		return visitDomainCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitImperativePredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativePredicateOrAssignmentCS csElement) {
		return visitPredicateOrAssignmentCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitImperativeRealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativeRealizedVariableCS csElement) {
		return visitRealizedVariableCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingCallBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallBindingCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingCallCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingLoopCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingLoopCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingSequenceCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingSequenceCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingStatementCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ParamDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPredicateCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PredicateCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PredicateOrAssignmentCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitQueryCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull QueryCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull RealizeableVariableCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull RealizedVariableCS csElement) {
		return visitRealizeableVariableCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTopLevelCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTransformationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TransformationCS csElement) {
		return visitAbstractTransformationCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull UnrealizedVariableCS csElement) {
		return visitRealizeableVariableCS(csElement);
	}
}
