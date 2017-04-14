/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

import com.google.common.collect.Iterables;

/**
 * InvokedRelationToMappingForEnforcement refines AbstractQVTr2QVTcRelations to support conversion of an invoked relation.
 */
/*public*/ class InvokedRelationToMappingForEnforcement extends AbstractQVTr2QVTcRelations
{
	/**
	 * InvokedEnforceableRelationDomain2CoreMapping refines AbstractEnforceableRelationDomain2CoreMapping to support conversion of an invoked enforced domain.
	 */
	protected abstract class InvokedEnforceableRelationDomain2CoreMapping extends AbstractEnforceableRelationDomain2CoreMapping
	{
		/**
		 * InvokedOtherRelationDomain2CoreDomain refines AbstractOtherRelationDomain2CoreDomain to support conversion of an invoked not-enforced domain.
		 */
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

		private @NonNull Iterable<@NonNull OCLExpression> rArguments;
		private @NonNull Relation rInvokingRelation;

		public InvokedEnforceableRelationDomain2CoreMapping(@NonNull Iterable<@NonNull OCLExpression> rArguments, @NonNull Relation rInvokingRelation, @NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rEnforcedDomain, cMappingName);
			this.rArguments = rArguments;
			this.rInvokingRelation = rInvokingRelation;
		}

		@Override
		protected @NonNull AbstractOtherRelationDomain2CoreDomain createOtherDomain2CoreDomain( @NonNull RelationDomain rRelationDomain) {
			return new InvokedOtherRelationDomain2CoreDomain(rRelationDomain);
		}

		@Override
		protected @NonNull Set<@NonNull Variable> getEnforcedBottomDomainVariables() { // FIXME unify with TopLevel
			Set<@NonNull Variable> rEnforcedBottomDomainVariables = new HashSet<@NonNull Variable>(rEnforcedReferredVariables);
			rEnforcedBottomDomainVariables.removeAll(rWhenVariable2rTypedModel.keySet());
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
			Type invokingTraceClass = qvtr2qvtc.getTraceClass(rInvokingRelation);		// ?? invocation
			Variable cInvocationVariable/*vd*/ = variablesAnalysis.addCoreGuardVariable("from_" + invokingTraceClass.getName(), invokingTraceClass);
			Type cInvocationType = cInvocationVariable.getType();
			assert cInvocationType == invokingTraceClass;			// FIXME
			List<@NonNull Variable> rParameters = qvtr2qvtc.getRootVariables(rRelation);
			int iSize = Iterables.size(rArguments);
			assert iSize == rParameters.size();
			int i = 0;
			for (OCLExpression rArgument : rArguments) {
				if (i >= iSize) {
					break;
				}
				Variable rParameter = rParameters.get(i);
				VariableExp rArgumentVariableExp = (VariableExp)rArgument;
				// RInvokerToMGuardPredicate
				Variable rArgumentVariable = QVTrelationUtil.getReferredVariable(rArgumentVariableExp);
				Variable cParameter = variablesAnalysis.getCoreVariable(rParameter);
				Property cProperty = qvtr2qvtc.getProperty(cInvocationType, rArgumentVariable);
				NavigationCallExp cInvocationValue = createNavigationCallExp(createVariableExp(cInvocationVariable), cProperty);
				variablesAnalysis.addConditionPredicate(cMiddleGuardPattern, cInvocationValue, createVariableExp(cParameter));
				i++;
			}
		}
	}

	protected final @Nullable Iterable<@NonNull RelationCallExp> whenInvocations;
	protected final @Nullable Iterable<@NonNull RelationCallExp> whereInvocations;

	public InvokedRelationToMappingForEnforcement(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull Relation rRelation,
			@Nullable Iterable<@NonNull RelationCallExp> whenInvocations, @Nullable Iterable<@NonNull RelationCallExp> whereInvocations) {
		super(qvtr2qvtc, rRelation);
		assert !rRelation.isIsTopLevel();
		this.whenInvocations = whenInvocations;
		this.whereInvocations = whereInvocations;
	}

	/**
	 * Each invocation of each enforced domain is synthesized as a separate mapping.
	 */
	@Override
	protected @NonNull List<@NonNull InvokedEnforceableRelationDomain2CoreMapping> analyze() throws CompilerChainException {
		List<@NonNull InvokedEnforceableRelationDomain2CoreMapping> enforceableRelationDomain2coreMappings = new ArrayList<@NonNull InvokedEnforceableRelationDomain2CoreMapping>();
		Iterable<@NonNull RelationCallExp> whenInvocations = qvtr2qvtc.getWhenInvocationsOf(rRelation);
		if (whenInvocations != null) {
			for (@NonNull RelationCallExp rInvocation : whenInvocations) {
				QVTr2QVTc.SYNTHESIS.println("invocation of when " + rRelation + " from " + rInvocation);
				@NonNull Relation rInvokingRelation = qvtr2qvtc.getInvokingRelation(rInvocation);
				Iterable<@NonNull OCLExpression> rArguments = QVTrelationUtil.getOwnedArguments(rInvocation);
				@NonNull Relation rInvokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
				@NonNull String rInvokingRelationName = QVTrelationUtil.getName(rInvokingRelation);
				for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
					if (rDomain.isIsEnforceable()) {
						String coreMappingName = rRelationName + '_' + rInvokingRelationName + '_' + rDomain.getName();
						enforceableRelationDomain2coreMappings.add(new WhenedEnforceableRelationDomain2CoreMapping(rArguments, rInvokingRelation, rDomain, coreMappingName));
						for (@NonNull Relation rOverridingInvokedRelation : qvtr2qvtc.getOverridingRelations(rInvokedRelation)) {
							coreMappingName = QVTrelationUtil.getName(rOverridingInvokedRelation) + '_' + rInvokingRelationName + '_' + rDomain.getName();
							enforceableRelationDomain2coreMappings.add(new WhenedEnforceableRelationDomain2CoreMapping(rArguments, rInvokingRelation, rDomain, coreMappingName));
						}
					}
				}
			}
		}
		Iterable<@NonNull RelationCallExp> whereInvocations = qvtr2qvtc.getWhereInvocationsOf(rRelation);
		if (whereInvocations != null) {
			for (@NonNull RelationCallExp rInvocation : whereInvocations) {
				QVTr2QVTc.SYNTHESIS.println("invocation of where " + rRelation + " from " + rInvocation);
				@NonNull Relation rInvokingRelation = qvtr2qvtc.getInvokingRelation(rInvocation);
				Iterable<@NonNull OCLExpression> rArguments = QVTrelationUtil.getOwnedArguments(rInvocation);
				@NonNull Relation rInvokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
				@NonNull String rInvokingRelationName = QVTrelationUtil.getName(rInvokingRelation);
				for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
					if (rDomain.isIsEnforceable()) {
						String coreMappingName = rRelationName + '_' + rInvokingRelationName + '_' + rDomain.getName();
						enforceableRelationDomain2coreMappings.add(new WheredEnforceableRelationDomain2CoreMapping(rArguments, rInvokingRelation, rDomain, coreMappingName));
						for (@NonNull Relation rOverridingInvokedRelation : qvtr2qvtc.getOverridingRelations(rInvokedRelation)) {
							coreMappingName = QVTrelationUtil.getName(rOverridingInvokedRelation) + '_' + rInvokingRelationName + '_' + rDomain.getName();
							enforceableRelationDomain2coreMappings.add(new WheredEnforceableRelationDomain2CoreMapping(rArguments, rInvokingRelation, rDomain, coreMappingName));
						}
					}
				}
			}
		}
		return enforceableRelationDomain2coreMappings;
	}

	@Override
	protected @Nullable Iterable<@NonNull RelationCallExp> getWhenInvocations() {
		return whenInvocations;
	}

	@Override
	protected @Nullable Iterable<@NonNull RelationCallExp> getWhereInvocations() {
		return whereInvocations;
	}

	protected final class WhenedEnforceableRelationDomain2CoreMapping extends InvokedEnforceableRelationDomain2CoreMapping
	{
		protected WhenedEnforceableRelationDomain2CoreMapping(@NonNull Iterable<@NonNull OCLExpression> rArguments, @NonNull Relation rInvokingRelation,
				@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rArguments, rInvokingRelation, rEnforcedDomain, cMappingName);
		}

		@Override
		protected @NonNull VariablesAnalysis createVariablesAnalysis(@NonNull RelationDomain rEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
			return new VariablesAnalysis.WhenedVariablesAnalysis(qvtr2qvtc, rEnforcedDomain, cEnforcedDomain, traceClass);
		}
	}

	protected final class WheredEnforceableRelationDomain2CoreMapping extends InvokedEnforceableRelationDomain2CoreMapping
	{
		protected WheredEnforceableRelationDomain2CoreMapping(@NonNull Iterable<@NonNull OCLExpression> rArguments, @NonNull Relation rInvokingRelation,
				@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rArguments, rInvokingRelation, rEnforcedDomain, cMappingName);
		}

		@Override
		protected @NonNull VariablesAnalysis createVariablesAnalysis(@NonNull RelationDomain rEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
			return new VariablesAnalysis.WheredVariablesAnalysis(qvtr2qvtc, rEnforcedDomain, cEnforcedDomain, traceClass);
		}
	}
}
