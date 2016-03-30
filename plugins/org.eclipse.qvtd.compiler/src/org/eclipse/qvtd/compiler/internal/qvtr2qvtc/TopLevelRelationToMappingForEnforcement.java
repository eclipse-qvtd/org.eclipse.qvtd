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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

import com.google.common.collect.Sets;

/*public*/ class TopLevelRelationToMappingForEnforcement extends AbstractQVTr2QVTcRelations
{
	private @NonNull String getCoreMappingName(@NonNull RelationDomain rd) {
		@NonNull Relation r = (@NonNull Relation) ClassUtil.nonNullState(rd.getRule());
		@NonNull String rn = ClassUtil.nonNullState(r.getName());
		@NonNull String dn = ClassUtil.nonNullState(rd.getName());
		return rn+'_'+dn;
	}

	private class RelationDomain2CoreDomain extends AbstractRelationDomain2CoreDomain
	{
		private @NonNull RealizedVariable mtev;			// The mapping template expression variable (the realized variable enforced by the domain pattern)
			
		public RelationDomain2CoreDomain(@NonNull RelationDomain rd) {
			super(rd, getCoreMappingName(rd));
			//
			this.mtev = doRVarToMRealizedVar(tev, db);
		}

		// 47
		public void doTROppositeDomainsToMappingForEnforcement() throws CompilerChainException {
			Set<@NonNull RelationDomain> rds = new HashSet<@NonNull RelationDomain>();
			for (@NonNull Domain d : ClassUtil.nullFree(r.getDomain())) {
				rds.add((RelationDomain) d);
			}
			rds.remove(rd); // guard
			assert rds.equals(Sets.newHashSet(rOtherDomains));
			for (@NonNull RelationDomain ord : rds) {		// FIXME rOppositeDomains already computed
				// check
				DomainPattern dp = qvtr2qvtc.getDomainPattern(ord);
				TemplateExp dpte = dp.getTemplateExpression();
				if (dpte instanceof ObjectTemplateExp) {
					String dn = ClassUtil.nonNullState(ord.getName());
					TypedModel dir = ClassUtil.nonNullState(ord.getTypedModel());
					String tmn = ClassUtil.nonNullState(dir.getName());
					List<org.eclipse.ocl.pivot.@NonNull Package> up = ClassUtil.nullFree(dir.getUsedPackage());
					boolean c = ord.isIsCheckable();
					List<@NonNull Variable> domainVars = ClassUtil.nullFree(dp.getBindsTo());
					ObjectTemplateExp te = (ObjectTemplateExp)dpte;
					Variable tev = ClassUtil.nonNullState(te.getBindsTo());
					// when
					// init
					CoreDomain cd = qvtr2qvtc.whenCoreDomain(m, dn);
					GuardPattern dg = ClassUtil.nonNullState(cd.getGuardPattern());
					BottomPattern db = ClassUtil.nonNullState(cd.getBottomPattern());
					BottomPattern mb = ClassUtil.nonNullState(m.getBottomPattern());
					assert mb == this.mb;
					// where
					Set<@NonNull Variable> whenVars = getWhenVars(r);
					Set<@NonNull Variable> domainTopVars = new HashSet<@NonNull Variable>(domainVars);
					domainTopVars.retainAll(whenVars);
					domainTopVars.add(tev);
					Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
					Set<@NonNull Variable> domainBottomUnSharedVars = new HashSet<@NonNull Variable>(domainVars);
					domainBottomUnSharedVars.removeAll(whenVars);
					domainBottomUnSharedVars.removeAll(sharedDomainVars);
					domainBottomUnSharedVars.remove(tev);
					Set<@NonNull Variable> domainBottomSharedVars = new HashSet<@NonNull Variable>(domainVars);
					domainBottomSharedVars.removeAll(whenVars);
					domainBottomSharedVars.retainAll(sharedDomainVars);
					domainBottomSharedVars.remove(tev);
					
					/*List<Variable> dgVars =*/ doRVarSetToDGVarSet(domainTopVars, dg);
					/*List<Variable> dbVars =*/ doRVarSetToMBVarSet(domainBottomUnSharedVars, db);
					doRVarSetToMBVarSet(domainBottomSharedVars, mb);
					doRDomainPatternToMDBottomPattern(te);
					// assign
					TypedModel mdir = getTypedModel(tmn, up);
					cd.setTypedModel(mdir);
					cd.setIsCheckable(c);
					cd.setIsEnforceable(false);
					cd.setGuardPattern(dg);
					assert m.getBottomPattern() == mb;
					m.setBottomPattern(mb);					// FIXME redundant
				}
			}
		}

		@Override
		protected void setAttributes() {
			super.setAttributes();
			db.getRealizedVariable().add(mtev);
		}

		@Override
		protected void where(@NonNull Set<@NonNull Variable> whenVars, @NonNull Set<@NonNull Predicate> rpSet,
				@NonNull Set<@NonNull Variable> sharedDomainVars, @NonNull Set<@NonNull Variable> unsharedWhereVars) throws CompilerChainException {
			Set<@NonNull Variable> oppositeDomainVars = getOppositeDomainVars();
			Set<@NonNull Variable> domainBottomUnSharedVars = new HashSet<@NonNull Variable>(domainVars);
			domainBottomUnSharedVars.removeAll(whenVars);
			domainBottomUnSharedVars.removeAll(sharedDomainVars);
			Set<@NonNull Predicate> predicatesWithVarBindings = filterOutPredicatesThatReferToVars(rpSet, domainBottomUnSharedVars);
			Set<@NonNull Predicate> predicatesWithoutVarBindings = new HashSet<@NonNull Predicate>(rpSet);
			predicatesWithoutVarBindings.removeAll(predicatesWithVarBindings);
			Set<@NonNull Variable> domainVarsSharedWithWhen = new HashSet<@NonNull Variable>(domainVars);
			domainVarsSharedWithWhen.retainAll(whenVars);
			if (!whenVars.contains(tev)) {						// This fixes Bug 486636
				domainVarsSharedWithWhen.remove(tev);
			}
			// Relation Calls
			//T5
			doRPredicateSetToMBPredicateSet(predicatesWithVarBindings, mb);
			doRVarSetToDGVarSet(domainVarsSharedWithWhen, dg);
			
			//T4
			/* List<@NonNull Variable> mbvars =*/ doRVarSetToMBVarSet(unsharedWhereVars, mb);
			//mbvars = mbvars;
			//T3
			doTROppositeDomainsToMappingForEnforcement();
			// Invoked here so the variables are instantiated
			doROppositeDomainVarsToTraceClassProps(oppositeDomainVars);
			doRWhenPatternToMGuardPattern();
			doRDomainToMDBottomForEnforcement(predicatesWithoutVarBindings, domainBottomUnSharedVars);
			doRRelImplToMBottomEnforcementOperation();
		}
	}

	public TopLevelRelationToMappingForEnforcement(@NonNull QVTrToQVTc qvtr2qvtc) {
		super(qvtr2qvtc);
	}

	public void doTopLevelRelationToMappingForEnforcement(@NonNull Relation r) throws CompilerChainException {
		assert r.isIsTopLevel();
		// check
		@NonNull List<@NonNull RelationDomain2CoreDomain> relation2mappings = new ArrayList<@NonNull RelationDomain2CoreDomain>();
		for (@NonNull Domain d : ClassUtil.nullFree(r.getDomain())) {
			if (d.isIsEnforceable()) {
				RelationDomain rd = (RelationDomain)d;
				for (@NonNull DomainPattern pattern : ClassUtil.nullFree(rd.getPattern())) {
					TemplateExp templateExpression = pattern.getTemplateExpression();
					if (templateExpression instanceof ObjectTemplateExp) {
						relation2mappings.add(new RelationDomain2CoreDomain(rd));
						break;
					}
				}
			}
		}
		// where() {
		where(r, relation2mappings);
	}
}
