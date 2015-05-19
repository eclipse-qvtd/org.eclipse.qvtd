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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingQVTcoreBaseCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTcoreBaseCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements QVTcoreBaseCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTcoreBaseCSVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitAbstractMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractMappingCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.AreaCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS object) {
		return visitPatternCS(object);
	}

	@Override
	public @Nullable R visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS object) {
		return visitAreaCS(object);
	}

	@Override
	public @Nullable R visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS object) {
		return visitPatternCS(object);
	}

	@Override
	public @Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public @Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.PatternCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitPredicateOrAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public @Nullable R visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.RealizeableVariableCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public @Nullable R visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.RealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}

	@Override
	public @Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS object) {
		return visitClassCS(object);
	}

	@Override
	public @Nullable R visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}
}
