/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.xtext.qvtcorebase/model/QVTcoreBaseCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtcorebasecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSLeft2RightVisitor;

/**
 * An AbstractQVTcoreBaseCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTcoreBaseCSLeft2RightVisitor
	extends EssentialOCLCSLeft2RightVisitor
	implements QVTcoreBaseCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTcoreBaseCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Element visitAbstractMappingCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull AbstractMappingCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitAreaCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull AreaCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull BottomPatternCS csElement) {
		return visitPatternCS(csElement);
	}

	@Override
	public @Nullable Element visitDirectionCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull DirectionCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitDomainCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull DomainCS csElement) {
		return visitAreaCS(csElement);
	}

	@Override
	public @Nullable Element visitEnforcementOperationCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull EnforcementOperationCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull GuardPatternCS csElement) {
		return visitPatternCS(csElement);
	}

	@Override
	public @Nullable Element visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull ParamDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPatternCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull PatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPredicateCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull PredicateCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitPredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull PredicateOrAssignmentCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitQueryCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull QueryCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull RealizeableVariableCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull RealizedVariableCS csElement) {
		return visitRealizeableVariableCS(csElement);
	}

	@Override
	public @Nullable Element visitTransformationCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull TransformationCS csElement) {
		return visitClassCS(csElement);
	}

	@Override
	public @Nullable Element visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull UnrealizedVariableCS csElement) {
		return visitRealizeableVariableCS(csElement);
	}
}
