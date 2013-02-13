/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * from: /org.eclipse.qvtd.xtext.qvtcore/model/QVTcoreCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.xtext.qvtcorecst.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTcoreCSVisitor<R> extends org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.AreaCS object);
	@Nullable R visitAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS object);
	@Nullable R visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS object);
	@Nullable R visitComposedMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.ComposedMappingCS object);
	@Nullable R visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS object);
	@Nullable R visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.DomainCS object);
	@Nullable R visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS object);
	@Nullable R visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS object);
	@Nullable R visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.MappingCS object);
	@Nullable R visitMappingCallBindingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.MappingCallBindingCS object);
	@Nullable R visitMappingCallCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.MappingCallCS object);
	@Nullable R visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS object);
	@Nullable R visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.PatternCS object);
	@Nullable R visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.QueryCS object);
	@Nullable R visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS object);
	@Nullable R visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS object);
	@Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS object);
	@Nullable R visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS object);
	@Nullable R visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS object);
}
