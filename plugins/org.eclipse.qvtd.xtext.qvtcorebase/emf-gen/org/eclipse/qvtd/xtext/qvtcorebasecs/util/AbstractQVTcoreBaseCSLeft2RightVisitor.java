/*******************************************************************************
 * Copyright (c) 2010 E.D.Willink and others.
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
	public @Nullable Element visitAbstractMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractMappingCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.AreaCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.AssignmentCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS csElement) {
		return visitPatternCS(csElement);
	}

	@Override
	public @Nullable Element visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS csElement) {
		return visitAreaCS(csElement);
	}

	@Override
	public @Nullable Element visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS csElement) {
		return visitPatternCS(csElement);
	}

	@Override
	public @Nullable Element visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.ParamDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.PatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.RealizeableVariableCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.RealizedVariableCS csElement) {
		return visitRealizeableVariableCS(csElement);
	}

	@Override
	public @Nullable Element visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS csElement) {
		return visitClassCS(csElement);
	}

	@Override
	public @Nullable Element visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS csElement) {
		return visitRealizeableVariableCS(csElement);
	}
}
