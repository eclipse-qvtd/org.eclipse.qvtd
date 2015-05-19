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
 */
public interface QVTcoreBaseCSVisitor<R> extends org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitAbstractMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractMappingCS object);
	@Nullable R visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.AreaCS object);
	@Nullable R visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS object);
	@Nullable R visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS object);
	@Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS object);
	@Nullable R visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS object);
	@Nullable R visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS object);
	@Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.ParamDeclarationCS object);
	@Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.PatternCS object);
	@Nullable R visitPredicateCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateCS object);
	@Nullable R visitPredicateOrAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS object);
	@Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS object);
	@Nullable R visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.RealizeableVariableCS object);
	@Nullable R visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.RealizedVariableCS object);
	@Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS object);
	@Nullable R visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS object);
}
