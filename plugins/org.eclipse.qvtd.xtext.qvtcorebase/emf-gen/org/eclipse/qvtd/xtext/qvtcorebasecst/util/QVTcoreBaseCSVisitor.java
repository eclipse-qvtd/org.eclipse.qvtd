/**
 * <copyright>
 * 
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
 * from: model/QVTcoreBaseCST.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.xtext.qvtcorebasecst.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTcoreBaseCSVisitor<R> extends org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitAbstractMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AbstractMappingCS object);
	@Nullable R visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AreaCS object);
	@Nullable R visitAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AssignmentCS object);
	@Nullable R visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.BottomPatternCS object);
	@Nullable R visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.DirectionCS object);
	@Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.DomainCS object);
	@Nullable R visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.EnforcementOperationCS object);
	@Nullable R visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.GuardPatternCS object);
	@Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.ParamDeclarationCS object);
	@Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.PatternCS object);
	@Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.QueryCS object);
	@Nullable R visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.RealizeableVariableCS object);
	@Nullable R visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.RealizedVariableCS object);
	@Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.TransformationCS object);
	@Nullable R visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.UnrealizedVariableCS object);
}
