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
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

/*public*/ class InvokedRelationToMappingForEnforcement extends AbstractQVTr2QVTcRelations
{	
	protected class InvokedEnforceableRelationDomain2CoreMapping extends AbstractEnforceableRelationDomain2CoreMapping
	{
		protected class InvokedOtherRelationDomain2CoreDomain extends AbstractOtherRelationDomain2CoreDomain 
		{
			public InvokedOtherRelationDomain2CoreDomain(@NonNull RelationDomain rOtherDomain) {
				super(rOtherDomain);
			}
			
/*			// body of IROppositeDomainsToMappingForEnforcement
			@Override
			public void synthesize() throws CompilerChainException { // FIXME unify with TopLevel
//				Set<@NonNull Variable> rOtherDomainVariables = new HashSet<@NonNull Variable>();
//				gatherReferredVariables(rOtherDomainVariables, rOtherDomain); //ClassUtil.nullFree(rOtherDomainPattern.getBindsTo());
//				assert rOtherDomainVariables.equals(Sets.newHashSet(getDomainVariables(rOtherDomain)));
//				List<@NonNull Variable> rOtherRootVariables = getRootVariables(rOtherDomain); 
				//
//				Set<@NonNull Variable> rOtherGuardVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
//				rOtherGuardVariables.retainAll(rWhenVariables);
//				rOtherGuardVariables.addAll(rOtherRootVariables);
				//
//				Set<@NonNull Variable> rOtherBottomVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
//				rOtherBottomVariables.removeAll(rWhenVariables);
//				rOtherBottomVariables.removeAll(rSharedVariables);
//				rOtherBottomVariables.removeAll(rOtherRootVariables);
				//
//				Set<@NonNull Variable> rMiddleBottomVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
//				rMiddleBottomVariables.removeAll(rWhenVariables);
//				rMiddleBottomVariables.retainAll(rSharedVariables);
//				rMiddleBottomVariables.removeAll(rOtherRootVariables);
				//
//				mapVariables(rOtherGuardVariables, cOtherGuardPattern);
//				mapVariables(rOtherBottomVariables, cOtherBottomPattern);
//				mapVariables(rMiddleBottomVariables, cMiddleBottomPattern);
				//
				super.synthesize();
			} */	
		}
		
		private @NonNull Relation rInvokingRelation;
		private @NonNull RelationCallExp rInvocation;

		public InvokedEnforceableRelationDomain2CoreMapping(@NonNull RelationCallExp rInvocation, @NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) {
			super(rEnforcedDomain, cMappingName);
			this.rInvocation = rInvocation;
			this.rInvokingRelation = qvtr2qvtc.getInvokingRelation(rInvocation);
		}

		@Override
		protected @NonNull AbstractOtherRelationDomain2CoreDomain createOtherDomain2CoreDomain( @NonNull RelationDomain rRelationDomain) {
			return new InvokedOtherRelationDomain2CoreDomain(rRelationDomain);
		}

		@Override
		protected @NonNull Set<@NonNull Variable> getEnforcedBottomDomainVariables() { // FIXME unify with TopLevel
			Set<@NonNull Variable> rEnforcedBottomDomainVariables = new HashSet<@NonNull Variable>(rEnforcedReferredVariables);
			rEnforcedBottomDomainVariables.removeAll(rWhenVariable2rDomain.keySet());
			rEnforcedBottomDomainVariables.removeAll(rSharedVariables);
			rEnforcedBottomDomainVariables.removeAll(rEnforcedRootVariables);
			return rEnforcedBottomDomainVariables;
		}

//		@Override
//		protected @NonNull Set<@NonNull Variable> getEnforcedDomainGuardVariables(@NonNull Set<@NonNull Variable> rEnforcedBottomDomainVariables) { // FIXME unify with TopLevel
//			Set<@NonNull Variable> rEnforcedDomainGuardVariables = new HashSet<@NonNull Variable>(rEnforcedReferredVariables);
//			rEnforcedDomainGuardVariables.retainAll(rWhenVariables);
//			rEnforcedDomainGuardVariables.addAll(rEnforcedRootVariables);
//			return rEnforcedDomainGuardVariables;
//		}

		// RInvokerToMGuard
		@Override
		protected void mapInvocation() throws CompilerChainException {
			Type invokingTraceClass = qvtr2qvtc.getTraceClass(rInvokingRelation);
			Variable cInvocationVariable/*vd*/ = variablesAnalysis.addCoreGuardVariable("from_" + invokingTraceClass.getName(), invokingTraceClass);
			Type cInvocationType = cInvocationVariable.getType();
			assert cInvocationType == invokingTraceClass;			// FIXME
			List<@NonNull OCLExpression> rArguments = ClassUtil.nullFree(rInvocation.getArgument());
			List<@NonNull Variable> rParameters = qvtr2qvtc.getRootVariables(rRelation);
			int iSize = rArguments.size();
			assert iSize == rParameters.size();
			for (int i = 0; i < iSize; i++) {
				Variable rParameter = rParameters.get(i);
				OCLExpression rArgument = rArguments.get(i);
				VariableExp rArgumentVariableExp = (VariableExp)rArgument;
				// RInvokerToMGuardPredicate
				Variable rArgumentVariable = (Variable) ClassUtil.nonNullState(rArgumentVariableExp.getReferredVariable());
				Variable cParameter = variablesAnalysis.getCoreVariable(rParameter);
				Property cProperty = qvtr2qvtc.getProperty(cInvocationType, rArgumentVariable);
				NavigationCallExp cInvocationValue = createNavigationCallExp(createVariableExp(cInvocationVariable), cProperty);
				variablesAnalysis.addConditionPredicate(cMiddleGuardPattern, cInvocationValue, createVariableExp(cParameter));
			}
		}
	}
	
	public InvokedRelationToMappingForEnforcement(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull Relation rRelation) {
		super(qvtr2qvtc, rRelation);
		assert !rRelation.isIsTopLevel();
	}
	
	/**
	 * Each invocation of each enforced domain is synthesized as a separate mapping.
	 */
	@Override
	protected @NonNull List<@NonNull InvokedEnforceableRelationDomain2CoreMapping> analyze() throws CompilerChainException {
		List<@NonNull InvokedEnforceableRelationDomain2CoreMapping> enforceableRelationDomain2coreMappings = new ArrayList<@NonNull InvokedEnforceableRelationDomain2CoreMapping>();
		for (@NonNull RelationCallExp rInvocation : qvtr2qvtc.getRelationCallExpsForRelation(rRelation)) {
			QVTr2QVTc.SYNTHESIS.println("invocation of " + rRelation + " from " + rInvocation);
			@NonNull Relation rInvokingRelation = qvtr2qvtc.getInvokingRelation(rInvocation);
			@NonNull String rInvokingRelationName = ClassUtil.nonNullState(rInvokingRelation.getName());
			for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
				if (rDomain.isIsEnforceable()) {
					RelationDomain rEnforcedDomain = (RelationDomain)rDomain;
					String coreMappingName = rRelationName + '_' + rInvokingRelationName + '_' + rEnforcedDomain.getName();
					enforceableRelationDomain2coreMappings.add(new InvokedEnforceableRelationDomain2CoreMapping(rInvocation, rEnforcedDomain, coreMappingName));
				}
			}
		}
		return enforceableRelationDomain2coreMappings;
	}
}
