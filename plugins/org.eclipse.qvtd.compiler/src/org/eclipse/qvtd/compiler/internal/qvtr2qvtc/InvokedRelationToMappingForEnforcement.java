/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
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

		public InvokedEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rEnforcedDomain, cMappingName);
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

		private @NonNull VariableDeclaration getOverriddenParameter(@NonNull Relation rOverride, @NonNull Variable rParameter) {
			if (rOverride == rRelation) {
				return rParameter;
			}
			RelationDomain rootVariableDomain = QVTrelationUtil.getRootVariableDomain(rParameter);
			List<@NonNull Variable> rootVariables = QVTrelationUtil.getRootVariables(rootVariableDomain);
			int index = rootVariables.indexOf(rParameter);
			assert index >= 0;
			TypedModel rTypedModel = QVTrelationUtil.getTypedModel(rootVariableDomain);
			RelationDomain overriddenRootVariableDomain = QVTrelationUtil.getRelationDomain(rOverride, rTypedModel);
			List<@NonNull Variable> overriddenRootVariables = QVTrelationUtil.getRootVariables(overriddenRootVariableDomain);
			assert index <= overriddenRootVariables.size();
			return overriddenRootVariables.get(index);
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
		protected void mapIncomingInvocation() throws CompilerChainException {
			Type invokingSignatureClass = null;		// ?? invocation
			Relation rOverride = rRelation;
			for (; rOverride != null; rOverride = QVTrelationUtil.basicGetOverridden(rOverride)) {
				invokingSignatureClass = qvtr2qvtc.basicGetSignatureClass(rOverride);
				if (invokingSignatureClass != null) {
					//				qvtr2qvtc.get
					break;
				}
			}
			assert rOverride != null;
			if (invokingSignatureClass == null) {
				invokingSignatureClass = qvtr2qvtc.getSignatureClass(rRelation);		// ?? invocation
			}
			Variable cInvocationVariable/*vd*/ = variablesAnalysis.addCoreGuardVariable("from_" + invokingSignatureClass.getName(), invokingSignatureClass);
			org.eclipse.ocl.pivot.Class cInvocationType = QVTrelationUtil.getClass(cInvocationVariable);
			assert cInvocationType == invokingSignatureClass;			// FIXME
			//			List<@NonNull OCLExpression> rArguments = QVTrelationUtil.Internal.getOwnedArgumentsList(rInvocation);
			List<@NonNull Variable> rParameters = qvtr2qvtc.getRootVariables(rRelation);
			//			int iSize = rArguments.size();
			int iSize = rParameters.size();
			//			assert iSize == rParameters.size();
			for (int i = 0; i < iSize; i++) {
				Variable rParameter = rParameters.get(i);
				//				OCLExpression rArgument = rArguments.get(i);
				//				VariableExp rArgumentVariableExp = (VariableExp)rArgument;
				// RInvokerToMGuardPredicate
				//				Variable rArgumentVariable = QVTrelationUtil.getReferredVariable(rArgumentVariableExp);
				Variable cParameter = variablesAnalysis.getCoreVariable(rParameter);
				Property cProperty = qvtr2qvtc.getSignatureProperty(cInvocationType, getOverriddenParameter(rOverride, rParameter));
				NavigationCallExp cInvocationValue = createNavigationCallExp(createVariableExp(cInvocationVariable), cProperty);
				variablesAnalysis.addConditionPredicate(cMiddleGuardPattern, cInvocationValue, createVariableExp(cParameter));
			}
		}
	}

	/**
	 * The per-typed model when invocation conversions.
	 */
	private @NonNull Map<@NonNull TypedModel, @NonNull AbstractEnforceableRelationDomain2CoreMapping> whenTypedModel2relationDomain2coreMapping = new HashMap<>();

	/**
	 * The per-typed model where invocation conversions.
	 */
	private @NonNull Map<@NonNull TypedModel, @NonNull AbstractEnforceableRelationDomain2CoreMapping> whereTypedModel2relationDomain2coreMapping = new HashMap<>();

	public InvokedRelationToMappingForEnforcement(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull Relation rRelation) {
		super(qvtr2qvtc, rRelation);
		assert !rRelation.isIsTopLevel();
	}

	private void addWhenRelationDomain2coreMapping(@NonNull AbstractEnforceableRelationDomain2CoreMapping relationDomain2coreMapping) {
		RelationDomain rDomain = relationDomain2coreMapping.rEnforcedDomain;
		TypedModel rTypedModel = QVTrelationUtil.getTypedModel(rDomain);
		AbstractEnforceableRelationDomain2CoreMapping old = whenTypedModel2relationDomain2coreMapping.put(rTypedModel, relationDomain2coreMapping);
		assert old == null;
	}

	private void addWhereRelationDomain2coreMapping(@NonNull AbstractEnforceableRelationDomain2CoreMapping relationDomain2coreMapping) {
		RelationDomain rDomain = relationDomain2coreMapping.rEnforcedDomain;
		TypedModel rTypedModel = QVTrelationUtil.getTypedModel(rDomain);
		AbstractEnforceableRelationDomain2CoreMapping old = whereTypedModel2relationDomain2coreMapping.put(rTypedModel, relationDomain2coreMapping);
		assert old == null;
	}

	/**
	 * Each invocation of each enforced domain is synthesized as a separate mapping.
	 */
	@Override
	public void analyze() throws CompilerChainException {
		boolean hasWhenInvocation = false;
		boolean hasWhereInvocation = false;
		for (@NonNull Relation rOverride : rAllOverrides) {
			Iterable<@NonNull RelationCallExp> incomingWhenInvocations = qvtr2qvtc.getIncomingWhenInvocationsOf(rOverride);
			if ((incomingWhenInvocations != null) && !Iterables.isEmpty(incomingWhenInvocations)) {
				hasWhenInvocation = true;
			}
			Iterable<@NonNull RelationCallExp> incomingWhereInvocations = qvtr2qvtc.getIncomingWhereInvocationsOf(rOverride);
			if ((incomingWhereInvocations != null) && !Iterables.isEmpty(incomingWhereInvocations)) {
				hasWhereInvocation = true;
			}
		}
		if (hasWhenInvocation) {
			QVTr2QVTc.SYNTHESIS.println("invocation of when " + rRelation);
			for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
				if (rDomain.isIsEnforceable()) {
					String coreMappingName = qvtr2qvtc.getNameGenerator().createWhenMappingClassName(rDomain);
					addWhenRelationDomain2coreMapping(new WhenedEnforceableRelationDomain2CoreMapping(rDomain, coreMappingName));
				}
			}
		}
		if (hasWhereInvocation) {
			QVTr2QVTc.SYNTHESIS.println("invocation of where " + rRelation);
			for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
				if (rDomain.isIsEnforceable()) {
					String coreMappingName = qvtr2qvtc.getNameGenerator().createWhereMappingClassName(rDomain);
					addWhereRelationDomain2coreMapping(new WheredEnforceableRelationDomain2CoreMapping(rDomain, coreMappingName));
				}
			}
		}
	}

	@Override
	public @NonNull AbstractEnforceableRelationDomain2CoreMapping getWhenRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
		return ClassUtil.nonNullState(whenTypedModel2relationDomain2coreMapping.get(rEnforcedTypedModel));
	}

	@Override
	public @NonNull AbstractEnforceableRelationDomain2CoreMapping getWhereRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
		return ClassUtil.nonNullState(whereTypedModel2relationDomain2coreMapping.get(rEnforcedTypedModel));
	}

	@Override
	public void synthesize() throws CompilerChainException {
		for (@NonNull AbstractEnforceableRelationDomain2CoreMapping enforceableRelationDomain2coreMapping : whenTypedModel2relationDomain2coreMapping.values()) {
			enforceableRelationDomain2coreMapping.synthesize();
			enforceableRelationDomain2coreMapping.variablesAnalysis.check();
			Relation rOverriddenRelation = QVTrelationUtil.basicGetOverridden(rRelation);
			if (rOverriddenRelation != null) {
				TypedModel rEnforcedTypedModel = enforceableRelationDomain2coreMapping.rEnforcedTypedModel;
				Mapping coreOverridingMapping = enforceableRelationDomain2coreMapping.getCoreMapping();
				AbstractQVTr2QVTcRelations overriddenRelation2Mappings = qvtr2qvtc.getRelation2Mappings(rOverriddenRelation);
				AbstractEnforceableRelationDomain2CoreMapping overriddenRelationDomain2CoreMapping = overriddenRelation2Mappings.getWhenRelationDomain2CoreMapping(rEnforcedTypedModel);
				Mapping coreOverriddenMapping = overriddenRelationDomain2CoreMapping.getCoreMapping();
				coreOverridingMapping.setOverridden(coreOverriddenMapping);
			}
		}
		for (@NonNull AbstractEnforceableRelationDomain2CoreMapping enforceableRelationDomain2coreMapping : whereTypedModel2relationDomain2coreMapping.values()) {
			enforceableRelationDomain2coreMapping.synthesize();
			enforceableRelationDomain2coreMapping.variablesAnalysis.check();
			Relation rOverriddenRelation = QVTrelationUtil.basicGetOverridden(rRelation);
			if (rOverriddenRelation != null) {
				TypedModel rEnforcedTypedModel = enforceableRelationDomain2coreMapping.rEnforcedTypedModel;
				Mapping coreOverridingMapping = enforceableRelationDomain2coreMapping.getCoreMapping();
				AbstractQVTr2QVTcRelations overriddenRelation2Mappings = qvtr2qvtc.getRelation2Mappings(rOverriddenRelation);
				AbstractEnforceableRelationDomain2CoreMapping overriddenRelationDomain2CoreMapping = overriddenRelation2Mappings.getWhereRelationDomain2CoreMapping(rEnforcedTypedModel);
				Mapping coreOverriddenMapping = overriddenRelationDomain2CoreMapping.getCoreMapping();
				coreOverridingMapping.setOverridden(coreOverriddenMapping);
			}
		}
	}

	protected final class WhenedEnforceableRelationDomain2CoreMapping extends InvokedEnforceableRelationDomain2CoreMapping
	{
		protected WhenedEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rEnforcedDomain, cMappingName);
		}

		@Override
		protected @NonNull VariablesAnalysis createVariablesAnalysis(@NonNull RelationDomain rEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
			return new VariablesAnalysis.WhenedVariablesAnalysis(qvtr2qvtc, rEnforcedDomain, cEnforcedDomain, traceClass);
		}

		@Override
		protected @NonNull AbstractEnforceableRelationDomain2CoreMapping mapOverrides(@NonNull AbstractQVTr2QVTcRelations relation2Mappings) {
			return relation2Mappings.getWhenRelationDomain2CoreMapping(rEnforcedTypedModel);
		}
	}

	protected final class WheredEnforceableRelationDomain2CoreMapping extends InvokedEnforceableRelationDomain2CoreMapping
	{
		protected WheredEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rEnforcedDomain, cMappingName);
		}

		@Override
		protected @NonNull VariablesAnalysis createVariablesAnalysis(@NonNull RelationDomain rEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
			return new VariablesAnalysis.WheredVariablesAnalysis(qvtr2qvtc, rEnforcedDomain, cEnforcedDomain, traceClass);
		}

		@Override
		protected @NonNull AbstractEnforceableRelationDomain2CoreMapping mapOverrides(@NonNull AbstractQVTr2QVTcRelations relation2Mappings) {
			return relation2Mappings.getWhereRelationDomain2CoreMapping(rEnforcedTypedModel);
		}
	}
}
