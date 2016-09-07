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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.qvtd.xtext.qvtbase.cs2as.QVTbaseCSLeft2RightVisitor;

/**
 * An AbstractQVTimperativeCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeCSLeft2RightVisitor
	extends QVTbaseCSLeft2RightVisitor
	implements QVTimperativeCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Element visitAreaCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AreaCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull BottomPatternCS csElement) {
		return visitPatternCS(csElement);
	}

	@Override
	public @Nullable Element visitConnectionStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ConnectionStatementCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Element visitDirectionCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DirectionCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitDomainCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DomainCS csElement) {
		return visitAreaCS(csElement);
	}

	@Override
	public @Nullable Element visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardPatternCS csElement) {
		return visitPatternCS(csElement);
	}

	@Override
	public @Nullable Element visitImperativeDomainCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativeDomainCS csElement) {
		return visitDomainCS(csElement);
	}

	@Override
	public @Nullable Element visitImperativePredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativePredicateOrAssignmentCS csElement) {
		return visitPredicateOrAssignmentCS(csElement);
	}

	@Override
	public @Nullable Element visitImperativeRealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativeRealizedVariableCS csElement) {
		return visitRealizedVariableCS(csElement);
	}

	@Override
	public @Nullable Element visitMappingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitMappingCallBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallBindingCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitMappingCallCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Element visitMappingLoopCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingLoopCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Element visitMappingSequenceCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingSequenceCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Element visitMappingStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingStatementCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ParamDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPredicateCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PredicateCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitPredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PredicateOrAssignmentCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitQueryCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull QueryCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull RealizeableVariableCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull RealizedVariableCS csElement) {
		return visitRealizeableVariableCS(csElement);
	}

	@Override
	public @Nullable Element visitTopLevelCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}

	@Override
	public @Nullable Element visitTransformationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TransformationCS csElement) {
		return visitAbstractTransformationCS(csElement);
	}

	@Override
	public @Nullable Element visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull UnrealizedVariableCS csElement) {
		return visitRealizeableVariableCS(csElement);
	}
}
