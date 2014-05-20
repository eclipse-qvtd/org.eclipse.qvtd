/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
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
package	org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTcoreBaseCSVisitor<R> extends org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitAbstractMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS object);
	@Nullable R visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AreaCS object);
	@Nullable R visitAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS object);
	@Nullable R visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS object);
	@Nullable R visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS object);
	@Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS object);
	@Nullable R visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.EnforcementOperationCS object);
	@Nullable R visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.GuardPatternCS object);
	@Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.ParamDeclarationCS object);
	@Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.PatternCS object);
	@Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS object);
	@Nullable R visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizeableVariableCS object);
	@Nullable R visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizedVariableCS object);
	@Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS object);
	@Nullable R visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.UnrealizedVariableCS object);
}
