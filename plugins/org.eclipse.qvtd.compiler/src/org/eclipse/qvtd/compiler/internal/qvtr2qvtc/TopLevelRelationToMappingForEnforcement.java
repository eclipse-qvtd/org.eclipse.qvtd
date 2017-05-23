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
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * TopLevelRelationToMappingForEnforcement refines AbstractQVTr2QVTcRelations to support conversion of a top level relation.
 */
/*public*/ class TopLevelRelationToMappingForEnforcement extends AbstractQVTr2QVTcRelations
{
	/**
	 * TopEnforceableRelationDomain2CoreMapping refines AbstractEnforceableRelationDomain2CoreMapping to support conversion of a top level enforced domain.
	 */
	protected class TopEnforceableRelationDomain2CoreMapping extends AbstractEnforceableRelationDomain2CoreMapping
	{
		/**
		 * TopOtherRelationDomain2CoreDomain refines AbstractOtherRelationDomain2CoreDomain to support conversion of a top level not-enforced domain.
		 */
		protected class TopOtherRelationDomain2CoreDomain extends AbstractOtherRelationDomain2CoreDomain
		{
			public TopOtherRelationDomain2CoreDomain(@NonNull RelationDomain rOtherDomain) {
				super(rOtherDomain);
			}

			/*			// body of TROppositeDomainsToMappingForEnforcement
			@Override
			public void synthesize() throws CompilerChainException { // FIXME unify with Invoked
//				for (@NonNull DomainPattern rOtherDomainPattern : ClassUtil.nullFree(rOtherDomain.getPattern())) {
//					List<@NonNull Variable> rOtherDomainVariables = ClassUtil.nullFree(rOtherDomainPattern.getBindsTo());
//					TemplateExp rOtherTemplateExpression = rOtherDomainPattern.getTemplateExpression();
//					Variable rOtherRootVariable = ClassUtil.nonNullState(rOtherTemplateExpression.getBindsTo());
//					Set<@NonNull Variable> rOtherGuardDomainVariables = new HashSet<>(rOtherDomainVariables);
//					rOtherGuardDomainVariables.retainAll(rWhenVariables);
//					rOtherGuardDomainVariables.add(rOtherRootVariable);
//					rOtherGuardDomainVariables.removeAll(rSharedVariables);
					//
//					Set<@NonNull Variable> rOtherBottomDomainVariables = new HashSet<>(rOtherDomainVariables);
//					rOtherBottomDomainVariables.removeAll(rWhenVariables);
//					rOtherBottomDomainVariables.removeAll(rSharedVariables);
//					rOtherBottomDomainVariables.remove(rOtherRootVariable);
					//
//					Set<@NonNull Variable> rMiddleBottomDomainVariables = new HashSet<>(rOtherDomainVariables);
//					rMiddleBottomDomainVariables.removeAll(rWhenVariables);
//					rMiddleBottomDomainVariables.retainAll(rSharedVariables);
//					rMiddleBottomDomainVariables.remove(rOtherRootVariable);
					//
//					mapVariables(rOtherGuardDomainVariables, cOtherGuardPattern);
//					mapVariables(rOtherBottomDomainVariables, cOtherBottomPattern);
//					mapVariables(rMiddleBottomDomainVariables, cMiddleBottomPattern);
//				}
				//
				super.synthesize();
			} */
		}

		/**
		 * The mapping template expression variables (the realized variables enforced by the domain pattern)
		 *  excludes when arguments
		 */
		//		private @NonNull List<@NonNull RealizedVariable> cEnforcedRootVariables;

		public TopEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rEnforcedDomain, cMappingName);
			//			this.cEnforcedRootVariables = new ArrayList<>(rEnforcedRootVariables.size());
			/*			for (@NonNull Variable rEnforcedRootVariable : rEnforcedRootVariables) {
				if (!rWhenVariables.contains(rEnforcedRootVariable)) {
					Variable realizedVariable = mapRealizedVariable(rEnforcedRootVariable);
					if (realizedVariable instanceof RealizedVariable) {		// FIXME not a RealizedVariable if keyed
						this.cEnforcedRootVariables.add((RealizedVariable)realizedVariable);
					}
				}
			} */
		}

		@Override
		protected @NonNull AbstractOtherRelationDomain2CoreDomain createOtherDomain2CoreDomain( @NonNull RelationDomain rRelationDomain) {
			return new TopOtherRelationDomain2CoreDomain(rRelationDomain);
		}

		@Override
		protected @NonNull VariablesAnalysis createVariablesAnalysis(@NonNull RelationDomain rEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
			return new VariablesAnalysis(qvtr2qvtc, rEnforcedDomain, cEnforcedDomain, traceClass);
		}

		@Override
		protected @NonNull Set<@NonNull Variable> getEnforcedBottomDomainVariables() { // FIXME unify with Invoked
			Set<@NonNull Variable> rEnforcedBottomDomainVariables = new HashSet<>(rEnforcedReferredVariables);
			rEnforcedBottomDomainVariables.removeAll(rWhenVariable2rTypedModel.keySet());
			rEnforcedBottomDomainVariables.removeAll(rSharedVariables);
			return rEnforcedBottomDomainVariables;
		}

		/*		@Override
		protected @NonNull Set<@NonNull Variable> getEnforcedDomainGuardVariables(@NonNull Set<@NonNull Variable> rEnforcedBottomDomainVariables) { // FIXME unify with Invoked
			Set<@NonNull Variable> rEnforcedDomainGuardVariables = new HashSet<>(rEnforcedReferredVariables);
			rEnforcedDomainGuardVariables.retainAll(rWhenVariables);
			rEnforcedBottomDomainVariables.removeAll(rSharedVariables);
			//
			List<@NonNull Variable> nonWhenRootVariables2 = rEnforcedRootVariables;
			nonWhenRootVariables2.removeAll(rWhenVariables);
			rEnforcedDomainGuardVariables.remove(nonWhenRootVariables2);						// This fixes Bug 486636
			return rEnforcedDomainGuardVariables;
		} */

		public @NonNull AbstractEnforceableRelationDomain2CoreMapping getTopRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
			return ClassUtil.nonNullState(topTypedModel2relationDomain2coreMapping.get(rEnforcedTypedModel));
		}

		@Override
		protected @NonNull AbstractEnforceableRelationDomain2CoreMapping mapOverrides(@NonNull AbstractQVTr2QVTcRelations relation2Mappings) {
			return relation2Mappings.getTopRelationDomain2CoreMapping(rEnforcedTypedModel);
		}

		@Override
		protected void synthesize() throws CompilerChainException {
			super.synthesize();
			//			cEnforcedBottomPattern.getRealizedVariable().addAll(cEnforcedRootVariables);	// FIXME redundant ??
		}
	}

	/**
	 * The per-typed model top relation conversions.
	 */
	protected @NonNull Map<@NonNull TypedModel, @NonNull AbstractEnforceableRelationDomain2CoreMapping> topTypedModel2relationDomain2coreMapping = new HashMap<>();

	public TopLevelRelationToMappingForEnforcement(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull Relation rRelation) {
		super(qvtr2qvtc, rRelation);
		assert rRelation.isIsTopLevel();
	}

	private void addTopRelationDomain2coreMapping(@NonNull AbstractEnforceableRelationDomain2CoreMapping relationDomain2coreMapping) {
		RelationDomain rDomain = relationDomain2coreMapping.rEnforcedDomain;
		TypedModel rTypedModel = QVTrelationUtil.getTypedModel(rDomain);
		AbstractEnforceableRelationDomain2CoreMapping old = topTypedModel2relationDomain2coreMapping.put(rTypedModel, relationDomain2coreMapping);
		assert old == null;
	}

	/**
	 * Return the list of conversions, one for each possible enforced domain.
	 */
	@Override
	public void analyze() throws CompilerChainException {
		for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
			if (rDomain.isIsEnforceable()) {
				String coreMappingName = qvtr2qvtc.getNameGenerator().createMappingName(rDomain);
				addTopRelationDomain2coreMapping(new TopEnforceableRelationDomain2CoreMapping(rDomain, coreMappingName));
			}
		}
	}

	@Override
	public void synthesize() throws CompilerChainException {
		for (@NonNull AbstractEnforceableRelationDomain2CoreMapping enforceableRelationDomain2coreMapping : topTypedModel2relationDomain2coreMapping.values()) {
			enforceableRelationDomain2coreMapping.synthesize();
			enforceableRelationDomain2coreMapping.variablesAnalysis.check();
			Relation rOverriddenRelation = QVTrelationUtil.basicGetOverridden(rRelation);
			if (rOverriddenRelation != null) {
				TypedModel rEnforcedTypedModel = enforceableRelationDomain2coreMapping.rEnforcedTypedModel;
				Mapping coreOverridingMapping = enforceableRelationDomain2coreMapping.getCoreMapping();
				AbstractQVTr2QVTcRelations overriddenRelation2Mappings = qvtr2qvtc.getRelation2Mappings(rOverriddenRelation);
				AbstractEnforceableRelationDomain2CoreMapping overriddenRelationDomain2CoreMapping = overriddenRelation2Mappings.getTopRelationDomain2CoreMapping(rEnforcedTypedModel);
				Mapping coreOverriddenMapping = overriddenRelationDomain2CoreMapping.getCoreMapping();
				coreOverridingMapping.setOverridden(coreOverriddenMapping);
			}
		}
	}
}
