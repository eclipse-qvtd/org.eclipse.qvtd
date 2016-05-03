/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/*public*/ class TopLevelRelationToMappingForEnforcement extends AbstractQVTr2QVTcRelations
{
	private class TopEnforceableRelationDomain2CoreMapping extends AbstractEnforceableRelationDomain2CoreMapping
	{
		protected class TopOtherRelationDomain2CoreDomain extends AbstractOtherRelationDomain2CoreDomain 
		{
			public TopOtherRelationDomain2CoreDomain(@NonNull RelationDomain rOtherDomain) {
				super(rOtherDomain);
			}

			// body of TROppositeDomainsToMappingForEnforcement
			@Override
			public void mapOtherDomainToDomainVariablesAndPatterns() throws CompilerChainException {
//				cOtherDomain.setGuardPattern(cOtherGuardPattern);		// FIXME redundant
				for (@NonNull DomainPattern rOtherDomainPattern : ClassUtil.nullFree(rOtherDomain.getPattern())) {
					List<@NonNull Variable> rOtherDomainVariables = ClassUtil.nullFree(rOtherDomainPattern.getBindsTo());
					TemplateExp rOtherTemplateExpression = rOtherDomainPattern.getTemplateExpression();
					Variable rOtherRootVariable = ClassUtil.nonNullState(rOtherTemplateExpression.getBindsTo());
//					if (rOtherTemplateExpression instanceof ObjectTemplateExp) {
//						ObjectTemplateExp rOtherObjectTemplateExpression = (ObjectTemplateExp)rOtherTemplateExpression;
						Set<@NonNull Variable> rOtherGuardDomainVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
						rOtherGuardDomainVariables.retainAll(rWhenVariables);
						rOtherGuardDomainVariables.add(rOtherRootVariable);
						rOtherGuardDomainVariables.removeAll(rSharedVariables);
//						rOtherGuardDomainVariables.removeAll(rNonUniquePatternVariables);
						//
						Set<@NonNull Variable> rOtherBottomDomainVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
						rOtherBottomDomainVariables.removeAll(rWhenVariables);
						rOtherBottomDomainVariables.removeAll(rSharedVariables);
//						rOtherBottomDomainVariables.removeAll(rNonUniquePatternVariables);
						rOtherBottomDomainVariables.remove(rOtherRootVariable);
						//
						Set<@NonNull Variable> rMiddleBottomDomainVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
						rMiddleBottomDomainVariables.removeAll(rWhenVariables);
						rMiddleBottomDomainVariables.retainAll(rSharedVariables);
//						rMiddleBottomDomainVariables.removeAll(rNonUniquePatternVariables);
						rMiddleBottomDomainVariables.remove(rOtherRootVariable);
						//
						mapVariablesToVariables(rOtherGuardDomainVariables, cOtherGuardPattern);
						mapVariablesToVariables(rOtherBottomDomainVariables, cOtherBottomPattern);
						mapVariablesToVariables(rMiddleBottomDomainVariables, cMiddleBottomPattern);
						addTemplateExpressionToMiddleBottom(rOtherTemplateExpression);
//					}
//					else {
//						throw new CompilerChainException("Missing doTROppositeDomainsToMappingForEnforcement support for CollectionTemplateExp");
//					}
				}
			}
		}
		
		private @NonNull List<@NonNull RealizedVariable> cEnforcedRootVariables;	// The mapping template expression variables (the realized variable enforced by the domain pattern)
															// except when arguments
			
		public TopEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) {
			super(rEnforcedDomain, cMappingName);
			this.cEnforcedRootVariables = new ArrayList<@NonNull RealizedVariable>(rEnforcedRootVariables.size());
			for (@NonNull Variable rEnforcedRootVariable : rEnforcedRootVariables) {
				if (!rWhenVariables.contains(rEnforcedRootVariable)) {
					this.cEnforcedRootVariables.add(mapRealizedVariable(rEnforcedRootVariable));
				}
			}
		}

		@Override
		protected @NonNull AbstractOtherRelationDomain2CoreDomain createOtherDomain2CoreDomain( @NonNull RelationDomain rRelationDomain) {
			return new TopOtherRelationDomain2CoreDomain(rRelationDomain);
		}

		@Override
		protected void setAttributes() {
			super.setAttributes();
			cEnforcedBottomPattern.getRealizedVariable().addAll(cEnforcedRootVariables);
		}

		@Override
		protected void where() throws CompilerChainException {
			Set<@NonNull Variable> rEnforcedBottomDomainVariables = new HashSet<@NonNull Variable>(rEnforcedDomainVariables);
			rEnforcedBottomDomainVariables.removeAll(rWhenVariables);
			rEnforcedBottomDomainVariables.removeAll(rSharedVariables);
//			rEnforcedBottomDomainVariables.removeAll(rNonUniquePatternVariables);
			//
			Set<@NonNull Predicate> rPredicatesWithVariableBindings = selectPredicatesThatReferToVariables(rPredicates, rEnforcedBottomDomainVariables);
			Set<@NonNull Predicate> rPredicatesWithoutVariableBindings = new HashSet<@NonNull Predicate>(rPredicates);
			rPredicatesWithoutVariableBindings.removeAll(rPredicatesWithVariableBindings);
			//
			Set<@NonNull Variable> rEnforcedDomainGuardVariables = new HashSet<@NonNull Variable>(rEnforcedDomainVariables);
			rEnforcedDomainGuardVariables.retainAll(rWhenVariables);
			rEnforcedBottomDomainVariables.removeAll(rSharedVariables);
//			rEnforcedBottomDomainVariables.removeAll(rNonUniquePatternVariables);
			//
			List<@NonNull Variable> nonWhenRootVariables2 = rEnforcedRootVariables;
			nonWhenRootVariables2.removeAll(rWhenVariables);
			rEnforcedDomainGuardVariables.remove(nonWhenRootVariables2);						// This fixes Bug 486636
			// Relation Calls
			mapPredicatesToPredicates(rPredicatesWithVariableBindings);
			mapVariablesToVariables(rEnforcedDomainGuardVariables, cEnforcedGuardPattern);		
			mapVariablesToVariables(rMiddleBottomDomainVariables, cMiddleBottomPattern);
			for (@NonNull AbstractOtherRelationDomain2CoreDomain otherDomain2coreDomain : otherDomain2coreDomains) {
				otherDomain2coreDomain.mapOtherDomainToDomainVariablesAndPatterns();
			}		
			// Invoked here so the variables are instantiated
			mapDomainVariablesToMiddleVariableAssignments(rOtherDomainVariables);
			mapWhenPatternToGuardPatterns();
			mapEnforcedDomain(rPredicatesWithoutVariableBindings, rEnforcedBottomDomainVariables);
			mapRelationImplementationToEnforcementOperation();
		}
	}
	
	public TopLevelRelationToMappingForEnforcement(@NonNull QVTrToQVTc qvtr2qvtc, @NonNull Relation rRelation) {
		super(qvtr2qvtc, rRelation);
		assert rRelation.isIsTopLevel();
	}

	public void doTopLevelRelationToMappingForEnforcement() throws CompilerChainException {
		// check
		@NonNull List<@NonNull TopEnforceableRelationDomain2CoreMapping> enforceableRelationDomain2coreMappings = new ArrayList<@NonNull TopEnforceableRelationDomain2CoreMapping>();
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			if (rDomain.isIsEnforceable()) {
				RelationDomain rEnforcedDomain = (RelationDomain)rDomain;
				for (@NonNull DomainPattern rEnforcedPattern : ClassUtil.nullFree(rEnforcedDomain.getPattern())) {
					TemplateExp rEnforcedTemplateExpression = rEnforcedPattern.getTemplateExpression();
					if (rEnforcedTemplateExpression instanceof ObjectTemplateExp) {
						enforceableRelationDomain2coreMappings.add(new TopEnforceableRelationDomain2CoreMapping(rEnforcedDomain, getCoreMappingName(rEnforcedDomain)));
						break;
					}
					else {
						throw new CompilerChainException("Missing doTopLevelRelationToMappingForEnforcement support for CollectionTemplateExp");
					}
				}
			}
		}
		// where() {
		where(rRelation, enforceableRelationDomain2coreMappings);
	}
	
	private @NonNull String getCoreMappingName(@NonNull RelationDomain rEnforcedDomain) {
		@NonNull String rRelationName = ClassUtil.nonNullState(rRelation.getName());
		@NonNull String rEnforcedDomainName = ClassUtil.nonNullState(rEnforcedDomain.getName());
		return rRelationName + '_' + rEnforcedDomainName;
	}

}
