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
 * from: org.eclipse.qvtd.xtext.qvtcorebase/model/QVTcoreBaseCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtcorebasecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface QVTcoreBaseCSVisitor<R> extends org.eclipse.qvtd.xtext.qvtbasecs.util.QVTbaseCSVisitor<R>
{
	R visitAbstractMappingCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull AbstractMappingCS object);
	R visitAbstractTopLevelCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull AbstractTopLevelCS object);
	R visitAreaCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull AreaCS object);
	R visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull BottomPatternCS object);
	R visitDirectionCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull DirectionCS object);
	R visitDomainCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull DomainCS object);
	R visitEnforcementOperationCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull EnforcementOperationCS object);
	R visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull GuardPatternCS object);
	R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull ParamDeclarationCS object);
	R visitPatternCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull PatternCS object);
	R visitPredicateCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull PredicateCS object);
	R visitPredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull PredicateOrAssignmentCS object);
	R visitQueryCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull QueryCS object);
	R visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull RealizeableVariableCS object);
	R visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull RealizedVariableCS object);
	R visitTransformationCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull TransformationCS object);
	R visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorebasecs.@NonNull UnrealizedVariableCS object);
}
