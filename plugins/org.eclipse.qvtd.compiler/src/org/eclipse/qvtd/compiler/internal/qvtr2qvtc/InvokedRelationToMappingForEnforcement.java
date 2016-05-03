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
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/*public*/ class InvokedRelationToMappingForEnforcement extends AbstractQVTr2QVTcRelations
{	
	private class InvokedEnforceableRelationDomain2CoreMapping extends AbstractEnforceableRelationDomain2CoreMapping
	{
		protected class InvokedOtherRelationDomain2CoreDomain extends AbstractOtherRelationDomain2CoreDomain 
		{
			public InvokedOtherRelationDomain2CoreDomain(@NonNull RelationDomain rOtherDomain) {
				super(rOtherDomain);
			}
			
			// body of IROppositeDomainsToMappingForEnforcement
			@Override
			public void mapOtherDomainToDomainVariablesAndPatterns() throws CompilerChainException {
				List<@NonNull Variable> rOtherDomainVariables = getDomainVariables(rOtherDomain); //ClassUtil.nullFree(rOtherDomainPattern.getBindsTo());
				List<@NonNull TemplateExp> rOtherTemplateExpressions = getTemplateExpressions(rOtherDomain);
				List<@NonNull Variable> rOtherRootVariables = getRootVariables(rOtherDomain); 
				//
				Set<@NonNull Variable> rOtherGuardVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
				rOtherGuardVariables.retainAll(rWhenVariables);
				rOtherGuardVariables.addAll(rOtherRootVariables);
				//
				Set<@NonNull Variable> rOtherBottomVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
				rOtherBottomVariables.removeAll(rWhenVariables);
				rOtherBottomVariables.removeAll(rSharedVariables);
				rOtherBottomVariables.removeAll(rOtherRootVariables);
				//
				Set<@NonNull Variable> rMiddleBottomVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
				rMiddleBottomVariables.removeAll(rWhenVariables);
				rMiddleBottomVariables.retainAll(rSharedVariables);
				rMiddleBottomVariables.removeAll(rOtherRootVariables);
				//
				mapVariablesToVariables(rOtherGuardVariables, cOtherGuardPattern);
				mapVariablesToVariables(rOtherBottomVariables, cOtherBottomPattern);
				mapVariablesToVariables(rMiddleBottomVariables, cMiddleBottomPattern);
				for (@NonNull TemplateExp rOtherTemplateExpression : rOtherTemplateExpressions) {
					addTemplateExpressionToMiddleBottom(rOtherTemplateExpression);
				}
			}		
		}
		
		private @NonNull Relation rInvokingRelation;
		private @NonNull RelationCallExp rInvocation;

		public InvokedEnforceableRelationDomain2CoreMapping(@NonNull RelationCallExp rInvocation, @NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) {
			super(rEnforcedDomain, cMappingName);
			this.rInvocation = rInvocation;
			this.rInvokingRelation = qvtr2qvtc.getInvokingRelationForRelationCallExp(rInvocation);
		}

		@Override
		protected @NonNull AbstractOtherRelationDomain2CoreDomain createOtherDomain2CoreDomain( @NonNull RelationDomain rRelationDomain) {
			return new InvokedOtherRelationDomain2CoreDomain(rRelationDomain);
		}

		// RInvokerToMGuard
		private void mapInvokerToGuardPredicates() throws CompilerChainException {
			// where
			List<@NonNull Domain> dseq = new ArrayList<@NonNull Domain>(ClassUtil.nullFree(rRelation.getDomain()));
			List<@NonNull OCLExpression> rArguments = ClassUtil.nullFree(rInvocation.getArgument());
			for (@NonNull OCLExpression rArgument : rArguments) {
				VariableExp rArgumentVariableExp = (VariableExp)rArgument;
				@NonNull RelationDomain rArgumentDomain = (RelationDomain) dseq.get(rArguments.indexOf(rArgumentVariableExp));		// FIXME multi-roots
				// RInvokerToMGuardPredicate
				Type traceClass = qvtr2qvtc.getTraceClass(rInvokingRelation);
				Variable rArgumentVariable = (Variable) ClassUtil.nonNullState(rArgumentVariableExp.getReferredVariable());
				Variable rRootVariable = ClassUtil.nonNullState(rArgumentDomain.getRootVariable().get(0));
				Variable vd = whenVariable(cMiddleGuardPattern, traceClass.getName()+"_v", traceClass);
				Variable cRootVariable = getCoreVariable(rRootVariable);
				Property cProperty = getProperty(vd.getType(), rArgumentVariable);
				NavigationCallExp cTraceValue = createNavigationCallExp(createVariableExp(vd), cProperty);
				addConditionPredicate(cMiddleGuardPattern, cTraceValue, createVariableExp(cRootVariable));
			}
		}

		@Override
		protected void where() throws CompilerChainException {
			Set<@NonNull Variable> rEnforcedBottomDomainVariables = new HashSet<@NonNull Variable>(rEnforcedDomainVariables);
			rEnforcedBottomDomainVariables.removeAll(rWhenVariables);
			rEnforcedBottomDomainVariables.removeAll(rSharedVariables);
			rEnforcedBottomDomainVariables.removeAll(rEnforcedRootVariables);
			//
			Set<@NonNull Predicate> rPredicatesWithVariableBindings = selectPredicatesThatReferToVariables(rPredicates, rEnforcedBottomDomainVariables);
			//
			Set<@NonNull Predicate> rPredicatesWithoutVariableBindings = new HashSet<@NonNull Predicate>(rPredicates);
			rPredicatesWithoutVariableBindings.removeAll(rPredicatesWithVariableBindings);
			//
			Set<@NonNull Variable> rEnforcedDomainGuardVariables = new HashSet<@NonNull Variable>(rEnforcedDomainVariables);
			rEnforcedDomainGuardVariables.retainAll(rWhenVariables);
			rEnforcedDomainGuardVariables.addAll(rEnforcedRootVariables);
			// Relation Calls
			// T5
			mapPredicatesToPredicates(rPredicatesWithVariableBindings);
			mapVariablesToVariables(rEnforcedDomainGuardVariables, cEnforcedGuardPattern);
			//T4
			mapVariablesToVariables(rMiddleBottomDomainVariables, cMiddleBottomPattern);
			//T3
			
			// IROppositeDomainsToMappingForEnforcement
			for (@NonNull AbstractOtherRelationDomain2CoreDomain otherDomain2coreDomain : otherDomain2coreDomains) {
				otherDomain2coreDomain.mapOtherDomainToDomainVariablesAndPatterns();
			}		
			mapInvokerToGuardPredicates();
			mapDomainVariablesToMiddleVariableAssignments(rOtherDomainVariables);
			mapWhenPatternToGuardPatterns();
			mapEnforcedDomain(rPredicatesWithoutVariableBindings, rEnforcedBottomDomainVariables);
			mapRelationImplementationToEnforcementOperation();
		}
	}
	
	public InvokedRelationToMappingForEnforcement(@NonNull QVTrToQVTc qvtr2qvtc, @NonNull Relation rRelation) {
		super(qvtr2qvtc, rRelation);
		assert !rRelation.isIsTopLevel();
	}
	
	public void doInvokedRelationToMappingForEnforcement() throws CompilerChainException {
		// check() {
		@NonNull List<@NonNull InvokedEnforceableRelationDomain2CoreMapping> enforceableRelationDomain2coreMappings = new ArrayList<@NonNull InvokedEnforceableRelationDomain2CoreMapping>();
		for (@NonNull RelationCallExp rInvocation : qvtr2qvtc.getRelationCallExpsForRelation(rRelation)) {
			System.out.println("invocation" + rRelation + " from " + rInvocation);
			for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
				if (rDomain.isIsEnforceable()) {
					RelationDomain rEnforcedDomain = (RelationDomain)rDomain;
//					@NonNull DomainPattern rEnforcedDomainPattern = qvtr2qvtc.getDomainPattern(rEnforcedDomain);
//					TemplateExp rEnforcedTemplateExpression = rEnforcedDomainPattern.getTemplateExpression();
					String coreMappingName = getCoreMappingName(rInvocation, rEnforcedDomain);
//					if (rEnforcedTemplateExpression instanceof ObjectTemplateExp) {
						enforceableRelationDomain2coreMappings.add(new InvokedEnforceableRelationDomain2CoreMapping(rInvocation, rEnforcedDomain, coreMappingName));
//					}
//					else {
//						throw new CompilerChainException("Missing doInvokedRelationToMappingForEnforcement support for CollectionTemplateExp");
//						enforceableRelationDomain2coreMappings.add(new InvokedEnforceableRelationDomain2CoreMapping(rInvocation, rEnforcedDomain, coreMappingName));
//					}
				}
			}
		}
		// where()
		where(rRelation, enforceableRelationDomain2coreMappings);
	}
	
	private @NonNull String getCoreMappingName(@NonNull RelationCallExp rInvocation, @NonNull RelationDomain rEnforcedDomain) {
		@NonNull Relation rInvokingRelation = qvtr2qvtc.getInvokingRelationForRelationCallExp(rInvocation);
		@NonNull String rRelationName = ClassUtil.nonNullState(rRelation.getName());
		@NonNull String rRelationNameName = ClassUtil.nonNullState(rInvokingRelation.getName());
		return rRelationName + '_' + rRelationNameName + '_' + rEnforcedDomain.getName();
	}
}
