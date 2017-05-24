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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * Relation2AbstractMappings refines AbstractRelation2Mappings to support conversion of an abstract relation.
 */
/*public*/ class Relation2AbstractMappings extends AbstractRelation2Mappings
{
	protected class RelationDomain2AbstractCoreMapping implements EnforceableRelationDomain2CoreMapping
	{			// FIXME share some minimal functionality
		protected class OtherRelationDomain2AbstractCoreDomain implements OtherRelationDomain2CoreDomain
		{
			public OtherRelationDomain2AbstractCoreDomain(@NonNull RelationDomain rOtherDomain) {
				TypedModel rOtherTypedModel = QVTrelationUtil.getTypedModel(rOtherDomain);
				List<@NonNull Variable> rOtherRootVariables = QVTrelationUtil.getRootVariables(rOtherDomain);
				//
				TypedModel cOtherTypedModel = getCoreTypedModel(rOtherTypedModel);
				CoreDomain cOtherDomain = createCoreDomain(cOtherTypedModel, false);
				cOtherDomain.setIsCheckable(rOtherDomain.isIsCheckable());
				cOtherDomain.setIsEnforceable(false);
				for (@NonNull Variable rVariable : rOtherRootVariables) {
					VariableAnalysis variableAnalysis = variablesAnalysis.getVariableAnalysis(rVariable);
					variableAnalysis.setIsRoot();
					variableAnalysis.setOtherBound(cOtherDomain);
				}
			}

			@Override
			public void synthesize() throws CompilerChainException {}
		}

		// Relations
		/**
		 *  rd: The relation domain to be enforced
		 */
		protected final @NonNull RelationDomain rEnforcedDomain;
		/**
		 *  The TypedModel of the enforced domain: rEnforcedDomain.getTypedModel()
		 */
		protected final @NonNull TypedModel rEnforcedTypedModel;

		// Core
		/**
		 *  m: The resultant mapping
		 */
		protected final @NonNull Mapping cMapping;
		/**
		 *  mg: The resultant mapping guard pattern: cMapping.getOwnedGuardPattern()
		 */
		protected final @NonNull GuardPattern cMiddleGuardPattern;
		/**
		 *  mb : The resultant mapping bottom pattern: cMapping.getOwnedBottomPattern()
		 */
		protected final @NonNull BottomPattern cMiddleBottomPattern;
		/**
		 *  mdir: The resultant enforced typed model
		 */
		protected final @NonNull TypedModel cEnforcedTypedModel;
		/**
		 *  md: The resultant enforced domain
		 */
		protected final @NonNull CoreDomain cEnforcedDomain;

		/**
		 * The conversion for each other domains sharing the parent of this domain
		 */
		protected final @NonNull List<@NonNull OtherRelationDomain2CoreDomain> otherDomain2coreDomains;
		/**
		 *  The analysis of each viariable in the relation.
		 */
		protected final @NonNull VariablesAnalysis variablesAnalysis;

		public RelationDomain2AbstractCoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			//			super(rEnforcedDomain, cMappingName);
			this.rEnforcedDomain = rEnforcedDomain;
			this.rEnforcedTypedModel = QVTrelationUtil.getTypedModel(rEnforcedDomain);
			//
			this.cEnforcedTypedModel = getCoreTypedModel(rEnforcedTypedModel);
			this.cMapping = qvtr2qvtc.createMapping(rRelation, cMappingName);
			this.cMiddleGuardPattern = ClassUtil.nonNullState(cMapping.getGuardPattern());
			this.cMiddleBottomPattern = ClassUtil.nonNullState(cMapping.getBottomPattern());
			this.cEnforcedDomain = createCoreDomain(cEnforcedTypedModel, true);
			//			this.cEnforcedGuardPattern = ClassUtil.nonNullState(cEnforcedDomain.getGuardPattern());
			//			this.cEnforcedBottomPattern = ClassUtil.nonNullState(cEnforcedDomain.getBottomPattern());
			//
			this.variablesAnalysis = new VariablesAnalysis(qvtr2qvtc, rEnforcedDomain, cEnforcedDomain, null);
			//
			this.otherDomain2coreDomains = new ArrayList<>();
			for (@NonNull Domain rDomain : ClassUtil.nullFree(rEnforcedDomain.getRule().getDomain())) {
				if ((rDomain != rEnforcedDomain) && (rDomain instanceof RelationDomain)) {
					RelationDomain rRelationDomain = (RelationDomain)rDomain;
					otherDomain2coreDomains.add(new OtherRelationDomain2AbstractCoreDomain(rRelationDomain));
				}
			}
		}

		private @NonNull CoreDomain createCoreDomain(@NonNull TypedModel cTypedModel, boolean isEnforced) {
			CoreDomain coreDomain = qvtr2qvtc.createCoreDomain(cTypedModel);
			coreDomain.setIsCheckable(false);
			coreDomain.setIsEnforceable(isEnforced);
			coreDomain.setRule(cMapping);
			return coreDomain;
		}

		@Override
		public @NonNull Mapping getCoreMapping() {
			return cMapping;
		}

		protected @NonNull TypedModel getCoreTypedModel(@NonNull TypedModel rTypedModel) {
			String name = PivotUtil.getName(rTypedModel);
			Iterable<org.eclipse.ocl.pivot.@NonNull Package> usedPackages = QVTrelationUtil.getUsedPackages(rTypedModel);
			for (@NonNull TypedModel cTypedModel : QVTcoreUtil.getModelParameters(cTransformation)) {
				if (name.equals(cTypedModel.getName())) {
					assert cTypedModel.getUsedPackage().equals(usedPackages);
					return cTypedModel;
				}
			}
			return ClassUtil.nonNullState(null);
		}

		protected void synthesize() throws CompilerChainException {
			for (@NonNull VariableAnalysis variableAnalysis : variablesAnalysis.getAnalyses()) {
				variableAnalysis.getCoreVariable();
			}
		}
	}

	/**
	 * The per-typed model top relation conversions.
	 */
	protected @NonNull Map<@NonNull TypedModel, @NonNull RelationDomain2AbstractCoreMapping> typedModel2relationDomain2coreMapping = new HashMap<>();

	public Relation2AbstractMappings(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull Relation rRelation) {
		super(qvtr2qvtc, rRelation);
		assert rRelation.isIsAbstract();
	}

	private void addRelationDomain2coreMapping(@NonNull RelationDomain2AbstractCoreMapping relationDomain2coreMapping) {
		RelationDomain rDomain = relationDomain2coreMapping.rEnforcedDomain;
		TypedModel rTypedModel = QVTrelationUtil.getTypedModel(rDomain);
		EnforceableRelationDomain2CoreMapping old = typedModel2relationDomain2coreMapping.put(rTypedModel, relationDomain2coreMapping);
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
				addRelationDomain2coreMapping(new RelationDomain2AbstractCoreMapping(rDomain, coreMappingName));
			}
		}
	}

	@Override
	public @NonNull EnforceableRelationDomain2CoreMapping getWhenRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
		return ClassUtil.nonNullState(typedModel2relationDomain2coreMapping.get(rEnforcedTypedModel));
	}

	@Override
	public @NonNull EnforceableRelationDomain2CoreMapping getWhereRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
		return ClassUtil.nonNullState(typedModel2relationDomain2coreMapping.get(rEnforcedTypedModel));
	}

	@Override
	public void synthesize() throws CompilerChainException {
		for (@NonNull RelationDomain2AbstractCoreMapping enforceableRelationDomain2coreMapping : typedModel2relationDomain2coreMapping.values()) {
			enforceableRelationDomain2coreMapping.synthesize();
			enforceableRelationDomain2coreMapping.variablesAnalysis.check();
		}
	}
}
