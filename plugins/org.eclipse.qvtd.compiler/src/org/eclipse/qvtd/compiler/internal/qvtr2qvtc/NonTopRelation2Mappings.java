/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.Relation2InvocationInterface;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.Relation2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.Relation2TraceClass;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
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

		/*		@Override
		protected void synthesize() throws CompilerChainException {
			org.eclipse.ocl.pivot.Class traceClass = relationalTransformation2tracePackage.getTraceClass(rRelation);
			//			Element2TraceProperty relation2TraceProperty = null;//relationalTransformation2tracePackage.getRelation2TraceProperty(rRelation);
			VariableDeclaration cCalledVariable/*vd* / = variablesAnalysis.getMiddleVariable();
			//			variablesAnalysis.addTraceNavigationAssignment(relation2TraceProperty.getTraceProperty(), cCalledVariable);
			List<@NonNull Variable> rootVariables = QVTrelationUtil.getRootVariables(rRelation);
			List<@NonNull Variable> overridingVariables = QVTrelationUtil.getRootVariables(rRelation);
			int iMax = rootVariables.size();
			assert iMax == overridingVariables.size();
			for (int i = 0; i < rootVariables.size(); i++) {
				@NonNull Variable rRootDeclaration = rootVariables.get(i);
				@NonNull Variable rOverridingDeclaration = overridingVariables.get(i);
				Property signatureProperty = relationalTransformation2tracePackage.getRelation2TraceClass(rRelation).getTraceProperty(rRootDeclaration);
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
		} */
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
		for (@NonNull Relation rOverriden : rAllOverriddens) {
			RelationAnalysis rOverrideAnalysis = transformationAnalysis.getRelationAnalysis(rOverriden);
			Iterable<@NonNull RelationCallExp> incomingWhenInvocations = rOverrideAnalysis.getIncomingWhenInvocations();
			if ((incomingWhenInvocations != null) && !Iterables.isEmpty(incomingWhenInvocations)) {
				hasWhenInvocation = true;
			}
			Iterable<@NonNull RelationCallExp> incomingWhereInvocations = rOverrideAnalysis.getIncomingWhereInvocations();
			if ((incomingWhereInvocations != null) && !Iterables.isEmpty(incomingWhereInvocations)) {
				hasWhereInvocation = true;
			}
		}
		if (hasWhereInvocation) {
			QVTr2QVTc.SYNTHESIS.println("invocation of where " + rRelation);
			for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
				if (rDomain.isIsEnforceable()) {
					String coreMappingName = qvtr2qvtc.getNameGenerator().createWhereMappingClassName(rDomain, null);
					addWhereRelationDomain2coreMapping(new WheredEnforceableRelationDomain2CoreMapping(rDomain, coreMappingName));
				}
			}
		}
		else if (hasWhenInvocation) {
			QVTr2QVTc.SYNTHESIS.println("invocation of when " + rRelation);
			for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
				if (rDomain.isIsEnforceable()) {
					String coreMappingName = qvtr2qvtc.getNameGenerator().createWhenMappingClassName(rDomain, null);
					addWhenRelationDomain2coreMapping(new WhenedEnforceableRelationDomain2CoreMapping(rDomain, coreMappingName));
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
			/*			Relation rOverriddenRelation = QVTrelationUtil.basicGetOverridden(rRelation);
			if (rOverriddenRelation != null) {
				RelationAnalysis rOverriddenRelationAnalysis = transformationAnalysis.getRelationAnalysis(rOverriddenRelation);
				TypedModel rEnforcedTypedModel = enforceableRelationDomain2coreMapping.rEnforcedTypedModel;
				Mapping coreOverridingMapping = enforceableRelationDomain2coreMapping.getCoreMapping();
				Relation2Mappings overriddenRelation2Mappings = relationalTransformation2coreTransformation.getRelation2Mappings(rOverriddenRelationAnalysis);
				EnforceableRelationDomain2CoreMapping overriddenRelationDomain2CoreMapping = overriddenRelation2Mappings.getWhenRelationDomain2CoreMapping(rEnforcedTypedModel);
				Mapping coreOverriddenMapping = overriddenRelationDomain2CoreMapping.getCoreMapping();
				coreOverridingMapping.setOverridden(coreOverriddenMapping);
			} */
		}
		for (@NonNull AbstractEnforceableRelationDomain2CoreMapping enforceableRelationDomain2coreMapping : whereTypedModel2relationDomain2coreMapping.values()) {
			enforceableRelationDomain2coreMapping.synthesize();
			enforceableRelationDomain2coreMapping.variablesAnalysis.check();
			/*			Relation rOverriddenRelation = QVTrelationUtil.basicGetOverridden(rRelation);
			if (rOverriddenRelation != null) {
				RelationAnalysis rOverriddenRelationAnalysis = transformationAnalysis.getRelationAnalysis(rOverriddenRelation);
				TypedModel rEnforcedTypedModel = enforceableRelationDomain2coreMapping.rEnforcedTypedModel;
				Mapping coreOverridingMapping = enforceableRelationDomain2coreMapping.getCoreMapping();
				Relation2Mappings overriddenRelation2Mappings = relationalTransformation2coreTransformation.getRelation2Mappings(rOverriddenRelationAnalysis);
				EnforceableRelationDomain2CoreMapping overriddenRelationDomain2CoreMapping = overriddenRelation2Mappings.getWhereRelationDomain2CoreMapping(rEnforcedTypedModel);
				Mapping coreOverriddenMapping = overriddenRelationDomain2CoreMapping.getCoreMapping();
				coreOverridingMapping.setOverridden(coreOverriddenMapping);
			} */
		}
	}

	protected final class WhenedEnforceableRelationDomain2CoreMapping extends NonTopEnforceableRelationDomain2CoreMapping	// FIXME flatten
	{
		protected WhenedEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rEnforcedDomain, cMappingName);
		}

		@Override
		protected @NonNull Variables2Variables createVariablesAnalysis(@NonNull RelationDomain rEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
			return new Variables2Variables(relationAnalysis, rEnforcedDomain, cEnforcedDomain, traceClass, true, false);
		}

		//		@Override
		//		protected @NonNull EnforceableRelationDomain2CoreMapping mapOverrides(@NonNull Relation2Mappings relation2Mappings) {
		//			return relation2Mappings.getWhenRelationDomain2CoreMapping(rEnforcedTypedModel);
		//		}
	}

	protected final class WheredEnforceableRelationDomain2CoreMapping extends NonTopEnforceableRelationDomain2CoreMapping	// FIXME flatten
	{
		protected WheredEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rEnforcedDomain, cMappingName);
			if ((rRelation.getOverridden() != null) || (rRelation.getOverrides().size() > 0)) {
				Relation rBaseRelation = QVTrelationUtil.getBaseRelation(rRelation);
				//				cMiddleVariable.get
				Variable2Variable coreVariableAnalysis = variablesAnalysis.getCoreVariableAnalysis(cMiddleVariable);
				coreVariableAnalysis.toString();
				Relation2TraceClass relation2traceClass = relationalTransformation2tracePackage.getRelation2TraceClass(rBaseRelation);
				Relation2MiddleType relation2InvocationInterface = relation2traceClass.getRelation2InvocationInterface();
				if (relation2InvocationInterface != relation2traceClass) {
					Variable cInvocationVariable = variablesAnalysis.addCoreGuardVariable("invocation", relation2InvocationInterface.getMiddleClass());
					Variable2Variable cInvocationVariableAnalysis = variablesAnalysis.getCoreVariableAnalysis(cInvocationVariable);
					//					variablesAnalysis.addTraceNavigationAssignment(rVariable, isOptional);

					for (@NonNull Variable rRootVariable : QVTrelationUtil.getRootVariables(rRelation)) {
						Variable rOverriddenRootVariable = QVTrelationUtil.getOverriddenVariable(rBaseRelation, rRootVariable);
						Variable cRootVariable = variablesAnalysis.getCoreVariable(rRootVariable);
						Property cProperty = relation2InvocationInterface.getTraceProperty(rOverriddenRootVariable);
						NavigationCallExp cNavigationExp = createNavigationCallExp(createVariableExp(cInvocationVariable), cProperty);
						variablesAnalysis.addConditionPredicate(cMiddleGuardPattern, createVariableExp(cRootVariable), cNavigationExp);
					}


					Property cResultProperty = ((Relation2InvocationInterface)relation2InvocationInterface).getResultProperty();
					cInvocationVariableAnalysis.addNavigationAssignment(cResultProperty, createVariableExp(cMiddleVariable), false);
				}
			}
		}

		@Override
		protected @NonNull Variables2Variables createVariablesAnalysis(@NonNull RelationDomain rEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
			return new Variables2Variables(relationAnalysis, rEnforcedDomain, cEnforcedDomain, traceClass, false, true);
		}

		//		@Override
		//		protected @NonNull EnforceableRelationDomain2CoreMapping mapOverrides(@NonNull Relation2Mappings relation2Mappings) {
		//			return relation2Mappings.getWhereRelationDomain2CoreMapping(rEnforcedTypedModel);
		//		}
	}
}
