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
 * from: org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtimperativecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface QVTimperativeCSVisitor<R> extends org.eclipse.qvtd.xtext.qvtbasecs.util.QVTbaseCSVisitor<R>
{
	R visitAreaCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AreaCS object);
	R visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull BottomPatternCS object);
	R visitConnectionStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ConnectionStatementCS object);
	R visitDirectionCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DirectionCS object);
	R visitDomainCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DomainCS object);
	R visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardPatternCS object);
	R visitImperativeDomainCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativeDomainCS object);
	R visitImperativePredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativePredicateOrAssignmentCS object);
	R visitImperativeRealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ImperativeRealizedVariableCS object);
	R visitMappingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCS object);
	R visitMappingCallBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallBindingCS object);
	R visitMappingCallCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallCS object);
	R visitMappingLoopCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingLoopCS object);
	R visitMappingSequenceCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingSequenceCS object);
	R visitMappingStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingStatementCS object);
	R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ParamDeclarationCS object);
	R visitPatternCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PatternCS object);
	R visitPredicateCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PredicateCS object);
	R visitPredicateOrAssignmentCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull PredicateOrAssignmentCS object);
	R visitQueryCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull QueryCS object);
	R visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull RealizeableVariableCS object);
	R visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull RealizedVariableCS object);
	R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TopLevelCS object);
	R visitTransformationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TransformationCS object);
	R visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull UnrealizedVariableCS object);
}
