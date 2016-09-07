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
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

/*public*/ class TopLevelRelationToMappingForEnforcement extends AbstractQVTr2QVTcRelations
{
	protected class TopEnforceableRelationDomain2CoreMapping extends AbstractEnforceableRelationDomain2CoreMapping
	{
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
//					Set<@NonNull Variable> rOtherGuardDomainVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
//					rOtherGuardDomainVariables.retainAll(rWhenVariables);
//					rOtherGuardDomainVariables.add(rOtherRootVariable);
//					rOtherGuardDomainVariables.removeAll(rSharedVariables);
					//
//					Set<@NonNull Variable> rOtherBottomDomainVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
//					rOtherBottomDomainVariables.removeAll(rWhenVariables);
//					rOtherBottomDomainVariables.removeAll(rSharedVariables);
//					rOtherBottomDomainVariables.remove(rOtherRootVariable);
					//
//					Set<@NonNull Variable> rMiddleBottomDomainVariables = new HashSet<@NonNull Variable>(rOtherDomainVariables);
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

		private @NonNull List<@NonNull RealizedVariable> cEnforcedRootVariables;	// The mapping template expression variables (the realized variable enforced by the domain pattern)
		// except when arguments

		public TopEnforceableRelationDomain2CoreMapping(@NonNull RelationDomain rEnforcedDomain, @NonNull String cMappingName) throws CompilerChainException {
			super(rEnforcedDomain, cMappingName);
			this.cEnforcedRootVariables = new ArrayList<@NonNull RealizedVariable>(rEnforcedRootVariables.size());
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
		protected @NonNull Set<@NonNull Variable> getEnforcedBottomDomainVariables() { // FIXME unify with Invoked
			Set<@NonNull Variable> rEnforcedBottomDomainVariables = new HashSet<@NonNull Variable>(rEnforcedReferredVariables);
			rEnforcedBottomDomainVariables.removeAll(rWhenVariable2rDomain.keySet());
			rEnforcedBottomDomainVariables.removeAll(rSharedVariables);
			return rEnforcedBottomDomainVariables;
		}

		/*		@Override
		protected @NonNull Set<@NonNull Variable> getEnforcedDomainGuardVariables(@NonNull Set<@NonNull Variable> rEnforcedBottomDomainVariables) { // FIXME unify with Invoked
			Set<@NonNull Variable> rEnforcedDomainGuardVariables = new HashSet<@NonNull Variable>(rEnforcedReferredVariables);
			rEnforcedDomainGuardVariables.retainAll(rWhenVariables);
			rEnforcedBottomDomainVariables.removeAll(rSharedVariables);
			//
			List<@NonNull Variable> nonWhenRootVariables2 = rEnforcedRootVariables;
			nonWhenRootVariables2.removeAll(rWhenVariables);
			rEnforcedDomainGuardVariables.remove(nonWhenRootVariables2);						// This fixes Bug 486636
			return rEnforcedDomainGuardVariables;
		} */

		@Override
		protected void synthesize() throws CompilerChainException {
			super.synthesize();
			cEnforcedBottomPattern.getRealizedVariable().addAll(cEnforcedRootVariables);	// FIXME redundant ??
		}
	}

	public TopLevelRelationToMappingForEnforcement(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull Relation rRelation) {
		super(qvtr2qvtc, rRelation);
		assert rRelation.isIsTopLevel();
	}

	/**
	 * Each enforced domain is synthesized as a separate mapping.
	 */
	@Override
	protected @NonNull List<@NonNull TopEnforceableRelationDomain2CoreMapping> analyze() throws CompilerChainException {
		List<@NonNull TopEnforceableRelationDomain2CoreMapping> enforceableRelationDomain2coreMappings = new ArrayList<@NonNull TopEnforceableRelationDomain2CoreMapping>();
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			if (rDomain.isIsEnforceable()) {
				RelationDomain rEnforcedDomain = (RelationDomain)rDomain;
				String rEnforcedDomainName = ClassUtil.nonNullState(rEnforcedDomain.getName());
				String coreMappingName = rRelationName + '_' + rEnforcedDomainName;
				enforceableRelationDomain2coreMappings.add(new TopEnforceableRelationDomain2CoreMapping(rEnforcedDomain, coreMappingName));
			}
		}
		return enforceableRelationDomain2coreMappings;
	}
}
