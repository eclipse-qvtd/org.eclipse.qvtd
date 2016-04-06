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
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

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
		private @Nullable RealizedVariable mtev;
			
		public RelationDomain2CoreDomain(@NonNull RelationDomain rd) {
			super(rd, getCoreMappingName(rd));
			//
			this.mtev = doRVarToMRealizedVar(tev, db);
		}

		// 47
		public void doTROppositeDomainsToMappingForEnforcement() throws CompilerChainException {
			Set<@NonNull RelationDomain> rds = new HashSet<@NonNull RelationDomain>();
			for (Domain d : ClassUtil.nullFree(r.getDomain())) {
				rds.add((RelationDomain) d);
			}
			rds.remove(rd); // guard
			for (RelationDomain ord : rds) {		// FIXME rOppositeDomains already computed
				// check
				DomainPattern dp = qvtr2qvtc.getDomainPattern(ord);
				if (dp.getTemplateExpression() instanceof ObjectTemplateExp) {
					String dn = ClassUtil.nonNullState(ord.getName());
					TypedModel dir = ClassUtil.nonNullState(ord.getTypedModel());
					String tmn = ClassUtil.nonNullState(dir.getName());
					RelationalTransformation rt = (RelationalTransformation) ClassUtil.nonNullState(dir.getTransformation());
					List<org.eclipse.ocl.pivot.Package> up = dir.getUsedPackage();
					boolean c = ord.isIsCheckable();
					List<@NonNull Variable> domainVars = ClassUtil.nullFree(dp.getBindsTo());
					ObjectTemplateExp te = (ObjectTemplateExp) ClassUtil.nonNullState(dp.getTemplateExpression());
					// when
					@NonNull Transformation mt = qvtr2qvtc.getCoreTransformation(rt);
					// init
					CoreDomain cd = qvtr2qvtc.whenCoreDomain(m, dn);
					GuardPattern dg = ClassUtil.nonNullState(cd.getGuardPattern());
					BottomPattern db = ClassUtil.nonNullState(cd.getBottomPattern());
					BottomPattern mb = ClassUtil.nonNullState(m.getBottomPattern());
					// where
					Set<@NonNull Variable> whenVars = new HashSet<@NonNull Variable>();
					if (r.getWhen() != null)
						whenVars.addAll(ClassUtil.nullFree(r.getWhen().getBindsTo()));
					Set<@NonNull Variable> domainTopVars = new HashSet<@NonNull Variable>(domainVars);
					domainTopVars.retainAll(whenVars);
					Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
					Set<@NonNull Variable> domainBottomUnSharedVars = new HashSet<@NonNull Variable>(domainVars);
					domainBottomUnSharedVars.removeAll(whenVars);
					domainBottomUnSharedVars.removeAll(sharedDomainVars);
					Set<@NonNull Variable> domainBottomSharedVars = new HashSet<@NonNull Variable>(domainVars);
					domainBottomSharedVars.removeAll(whenVars);
					domainBottomSharedVars.retainAll(sharedDomainVars);
					
					/*List<Variable> dgVars =*/ doRVarSetToDGVarSet(new ArrayList<@NonNull Variable>(domainTopVars), dg);
					/*List<Variable> dbVars =*/ doRVarSetToMBVarSet(new ArrayList<@NonNull Variable>(domainBottomUnSharedVars), db);
					doRVarSetToMBVarSet(new ArrayList<@NonNull Variable>(domainBottomSharedVars), mb);
					doRDomainPatternToMDBottomPattern(te);
					// assign
					TypedModel mdir = null;
					for (TypedModel tm : mt.getModelParameter()) {
						if (tmn.equals(tm.getName())) {
							if (tm.getUsedPackage().equals(up)) {
								mdir = tm;
								break;
							}
						}
					}
					cd.setTypedModel(mdir);
					cd.setIsCheckable(c);
					cd.setIsEnforceable(false);
					cd.setGuardPattern(dg);
					m.setBottomPattern(mb);
				}
			}
		}

		@Override
		protected void setAttributes() {
			super.setAttributes();
			if (mtev != null) {
				db.getRealizedVariable().add(mtev);
			}
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
			doRPredicateSetToMBPredicateSet(new ArrayList<@NonNull Predicate>(predicatesWithVarBindings), mb);		// FIXME new ArrayList redundant
			doRVarSetToDGVarSet(new ArrayList<@NonNull Variable>(domainVarsSharedWithWhen), dg);		// FIXME new ArrayList redundant
			
			//T4
			/* List<@NonNull Variable> mbvars =*/ doRVarSetToMBVarSet(new ArrayList<@NonNull Variable>(unsharedWhereVars), mb);		// FIXME new ArrayList redundant
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
		// check
		if (!r.isIsTopLevel()) {
			return;
		}
		@NonNull List<@NonNull RelationDomain2CoreDomain> relation2mappings = new ArrayList<@NonNull RelationDomain2CoreDomain>();
		for (Domain d : r.getDomain()) {
			if (d.isIsEnforceable()) {
				RelationDomain rd = (RelationDomain)d;
				for (DomainPattern pattern : rd.getPattern()) {
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
