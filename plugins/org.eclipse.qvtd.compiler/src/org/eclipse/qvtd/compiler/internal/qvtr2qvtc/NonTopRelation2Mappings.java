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
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

import com.google.common.collect.Iterables;

/**
 * NonTopRelation2Mappings refines BasicRelation2Mappings to support conversion of a non-top, necessarily invoked relation.
 */
/*public*/ class NonTopRelation2Mappings extends BasicRelation2Mappings
{
	/**
	 * NonTopEnforceableRelationDomain2CoreMapping refines AbstractEnforceableRelationDomain2CoreMapping to support conversion of an invoked enforced domain.
	 */
	protected abstract class NonTopEnforceableRelationDomain2CoreMapping extends AbstractEnforceableRelationDomain2CoreMapping
	{
		/**
		 * NonTopOtherRelationDomain2CoreDomain refines AbstractOtherRelationDomain2CoreDomain to support conversion of an invoked not-enforced domain.
		 */
		protected class NonTopOtherRelationDomain2CoreDomain extends AbstractOtherRelationDomain2CoreDomain
		{
			public NonTopOtherRelationDomain2CoreDomain(@NonNull RelationDomain rOtherDomain) {
				super(rOtherDomain);
			}
		}

		public NonTopEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rEnforcedDomain, cMappingName);
		}

		@Override
		protected @NonNull OtherRelationDomain2CoreDomain createOtherDomain2CoreDomain( @NonNull RelationDomain rRelationDomain) {
			return new NonTopOtherRelationDomain2CoreDomain(rRelationDomain);
		}

		@Override
		protected @NonNull Set<@NonNull Variable> getEnforcedBottomDomainVariables() { // FIXME unify with TopLevel
			Set<@NonNull Variable> rEnforcedBottomDomainVariables = new HashSet<@NonNull Variable>(rEnforcedReferredVariables);
			rEnforcedBottomDomainVariables.removeAll(rWhenVariable2rTypedModel.keySet());
			rEnforcedBottomDomainVariables.removeAll(rSharedVariables);
			rEnforcedBottomDomainVariables.removeAll(rEnforcedRootVariables);
			return rEnforcedBottomDomainVariables;
		}

		@Override
		protected void synthesize() throws CompilerChainException {
			Relation rRootRelation = rRelation;
			for (Relation rOverriddenRelation = rRelation; (rOverriddenRelation = QVTrelationUtil.basicGetOverridden(rOverriddenRelation)) != null; ) {
				rRootRelation = rOverriddenRelation;
			}
			org.eclipse.ocl.pivot.Class signatureClass = relationalTransformation2tracePackage.getSignatureClass(rRootRelation);
			Variable cCalledVariable/*vd*/ = variablesAnalysis.addCoreGuardVariable(QVTrNameGenerator.INVOCATION_GUARD_NAME, signatureClass);
			List<@NonNull Variable> rootVariables = QVTrelationUtil.getRootVariables(rRootRelation);
			List<@NonNull Variable> overridingVariables = QVTrelationUtil.getRootVariables(rRelation);
			int iMax = rootVariables.size();
			assert iMax == overridingVariables.size();
			for (int i = 0; i < rootVariables.size(); i++) {
				@NonNull Variable rRootDeclaration = rootVariables.get(i);
				@NonNull Variable rOverridingDeclaration = overridingVariables.get(i);
				Property signatureProperty = relationalTransformation2tracePackage.getSignatureProperty(rRootRelation, rRootDeclaration);
				Variable cArgumentVariable = variablesAnalysis.getCoreVariable(rOverridingDeclaration);
				VariableExp cArgumentExpression = createVariableExp(cArgumentVariable);
				if (cArgumentVariable instanceof RealizedVariable) {
					variablesAnalysis.getCoreVariableAnalysis(cCalledVariable).addNavigationAssignment(signatureProperty, cArgumentExpression, false);
				}
				else {
					NavigationCallExp cNavigationExp = createNavigationCallExp(createVariableExp(cCalledVariable), signatureProperty);
					variablesAnalysis.addConditionPredicate(cMiddleGuardPattern, cArgumentExpression, cNavigationExp);
				}
			}
			super.synthesize();
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

	public NonTopRelation2Mappings(@NonNull RelationalTransformation2CoreTransformation relationalTransformation2coreTransformation, @NonNull RelationAnalysis relationAnalysis) {
		super(relationalTransformation2coreTransformation, relationAnalysis);
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
			RelationAnalysis rOverrideAnalysis = transformationAnalysis.getRelationAnalysis(rOverride);
			Iterable<@NonNull RelationCallExp> incomingWhenInvocations = rOverrideAnalysis.getIncomingWhenInvocations();
			if ((incomingWhenInvocations != null) && !Iterables.isEmpty(incomingWhenInvocations)) {
				hasWhenInvocation = true;
			}
			Iterable<@NonNull RelationCallExp> incomingWhereInvocations = rOverrideAnalysis.getIncomingWhereInvocations();
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
				RelationAnalysis rOverriddenRelationAnalysis = transformationAnalysis.getRelationAnalysis(rOverriddenRelation);
				TypedModel rEnforcedTypedModel = enforceableRelationDomain2coreMapping.rEnforcedTypedModel;
				Mapping coreOverridingMapping = enforceableRelationDomain2coreMapping.getCoreMapping();
				Relation2Mappings overriddenRelation2Mappings = relationalTransformation2coreTransformation.getRelation2Mappings(rOverriddenRelationAnalysis);
				EnforceableRelationDomain2CoreMapping overriddenRelationDomain2CoreMapping = overriddenRelation2Mappings.getWhenRelationDomain2CoreMapping(rEnforcedTypedModel);
				Mapping coreOverriddenMapping = overriddenRelationDomain2CoreMapping.getCoreMapping();
				coreOverridingMapping.setOverridden(coreOverriddenMapping);
			}
		}
		for (@NonNull AbstractEnforceableRelationDomain2CoreMapping enforceableRelationDomain2coreMapping : whereTypedModel2relationDomain2coreMapping.values()) {
			enforceableRelationDomain2coreMapping.synthesize();
			enforceableRelationDomain2coreMapping.variablesAnalysis.check();
			Relation rOverriddenRelation = QVTrelationUtil.basicGetOverridden(rRelation);
			if (rOverriddenRelation != null) {
				RelationAnalysis rOverriddenRelationAnalysis = transformationAnalysis.getRelationAnalysis(rOverriddenRelation);
				TypedModel rEnforcedTypedModel = enforceableRelationDomain2coreMapping.rEnforcedTypedModel;
				Mapping coreOverridingMapping = enforceableRelationDomain2coreMapping.getCoreMapping();
				Relation2Mappings overriddenRelation2Mappings = relationalTransformation2coreTransformation.getRelation2Mappings(rOverriddenRelationAnalysis);
				EnforceableRelationDomain2CoreMapping overriddenRelationDomain2CoreMapping = overriddenRelation2Mappings.getWhereRelationDomain2CoreMapping(rEnforcedTypedModel);
				Mapping coreOverriddenMapping = overriddenRelationDomain2CoreMapping.getCoreMapping();
				coreOverridingMapping.setOverridden(coreOverriddenMapping);
			}
		}
	}

	protected final class WhenedEnforceableRelationDomain2CoreMapping extends NonTopEnforceableRelationDomain2CoreMapping
	{
		protected WhenedEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rEnforcedDomain, cMappingName);
		}

		@Override
		protected @NonNull VariablesAnalysis createVariablesAnalysis(@NonNull RelationDomain rEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
			return new VariablesAnalysis.WhenedVariablesAnalysis(relationAnalysis, rEnforcedDomain, cEnforcedDomain, traceClass);
		}

		@Override
		protected @NonNull EnforceableRelationDomain2CoreMapping mapOverrides(@NonNull Relation2Mappings relation2Mappings) {
			return relation2Mappings.getWhenRelationDomain2CoreMapping(rEnforcedTypedModel);
		}
	}

	protected final class WheredEnforceableRelationDomain2CoreMapping extends NonTopEnforceableRelationDomain2CoreMapping
	{
		protected WheredEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rEnforcedDomain, cMappingName);
		}

		@Override
		protected @NonNull VariablesAnalysis createVariablesAnalysis(@NonNull RelationDomain rEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
			return new VariablesAnalysis.WheredVariablesAnalysis(relationAnalysis, rEnforcedDomain, cEnforcedDomain, traceClass);
		}

		@Override
		protected @NonNull EnforceableRelationDomain2CoreMapping mapOverrides(@NonNull Relation2Mappings relation2Mappings) {
			return relation2Mappings.getWhereRelationDomain2CoreMapping(rEnforcedTypedModel);
		}
	}
}
