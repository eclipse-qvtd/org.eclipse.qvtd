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
 * from: org.eclipse.qvtd.xtext.qvtcore/model/QVTcoreCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtcorecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface QVTcoreCSVisitor<R> extends org.eclipse.qvtd.xtext.qvtbasecs.util.QVTbaseCSVisitor<R>
{
	R visitAreaCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull AreaCS object);
	R visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull BottomPatternCS object);
	R visitDirectionCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull DirectionCS object);
	R visitDomainCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull DomainCS object);
	R visitEnforcementOperationCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull EnforcementOperationCS object);
	R visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull GuardPatternCS object);
	R visitMappingCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull MappingCS object);
	R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull ParamDeclarationCS object);
	R visitPatternCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull PatternCS object);
	R visitPredicateCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull PredicateCS object);
	R visitPredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull PredicateOrAssignmentCS object);
	R visitQueryCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull QueryCS object);
	R visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull RealizeableVariableCS object);
	R visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull RealizedVariableCS object);
	R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull TopLevelCS object);
	R visitTransformationCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull TransformationCS object);
	R visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecs.@NonNull UnrealizedVariableCS object);
}
