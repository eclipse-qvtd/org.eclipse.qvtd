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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTcRelations;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

public class TopLevelRelationToMappingForEnforcement extends AbstractRule
{
	
	private static class Factory extends AbstractRule.Factory
	{
		@Override
		public @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation, @NonNull EObject eo) {
			Rule rule = null;
			if (eo instanceof Relation) {	
				rule = new TopLevelRelationToMappingForEnforcement(transformation, (Relation) eo);
				Rule tracedRule = transformation.getRecord(rule.getRuleBindings());
				if (tracedRule != null)
					rule = tracedRule;
			}
			return rule;
		}

		@Override
		public @Nullable Rule createRule(
				@NonNull QvtrToQvtcTransformation transformation,
				@NonNull List<EObject> eos) {
			return null;
		}
	}
	
	private class SubRecord 
	{
		// Relations
		private @NonNull RelationDomain rd;
//		private @NonNull TypedModel dir;
		private @NonNull String tmn;
		private @NonNull String dn;
		private @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> up;
		private @NonNull ObjectTemplateExp te;
		private @NonNull Variable tev;
		private @NonNull List<@NonNull RelationDomain> rOppositeDomains;
		private @NonNull List<@NonNull Variable> domainVars;
		
		// Core
		private @Nullable Mapping m;
		private @Nullable GuardPattern mg;
		private @Nullable BottomPattern mb;
		private @Nullable RealizedVariable tcv;
		private @Nullable CoreDomain md;
		private @Nullable TypedModel mdir;
		private @Nullable GuardPattern dg;
		private @Nullable BottomPattern db;
		private @Nullable RealizedVariable mtev;
//		public @Nullable List<@NonNull Variable> mbvars;
		
		
		public SubRecord(@NonNull RelationDomain rd, @NonNull TypedModel dir,
				@NonNull String tmn, @NonNull String dn,
				@NonNull List<org.eclipse.ocl.pivot.@NonNull Package> up,@NonNull List<@NonNull Variable> domainVars,
				@NonNull ObjectTemplateExp te, @NonNull Variable tev,
				@NonNull List<@NonNull RelationDomain> rOppositeDomains) {
			this.rd = rd;
//			this.dir = dir;
			this.tmn = tmn;
			this.dn = dn;
			this.up = up;
			this.te = te;
			this.tev = tev;
			this.domainVars = domainVars;
			this.rOppositeDomains = rOppositeDomains;
		}
		
	}

	private final @NonNull Relation r;

	private String rn;

	public Transformation mt;
	
	public static final Rule.@NonNull Factory FACTORY = new Factory(); 
	
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();

	public TopLevelRelationToMappingForEnforcement(@NonNull QvtrToQvtcTransformation transformation,
			@NonNull Relation r) {
		super(transformation);
		this.r = r;
	}

	// One Mapping per domain
	@Override
	public void check() {
		rn = r.getName();
		if (r.isIsTopLevel()) {
			for (Domain d : r.getDomain()) {
				RelationDomain rd = (RelationDomain) d;
				if (rd.isIsEnforceable() && QVTr2QVTcRelations.getDomainPattern(rd).getTemplateExpression() instanceof ObjectTemplateExp) {
					//Mapping m = QVTcoreFactory.eINSTANCE.createMapping();
					String dn = rd.getName();
					assert dn != null;
					TypedModel dir = rd.getTypedModel();
					String tmn = dir.getName();
					assert tmn != null;
					List<org.eclipse.ocl.pivot.Package> up = dir.getUsedPackage();
					assert up != null;
					DomainPattern dp = QVTr2QVTcRelations.getDomainPattern(rd);
					List<Variable> domainVars = dp.getBindsTo();
					ObjectTemplateExp te = (ObjectTemplateExp) dp.getTemplateExpression();
					Variable tev = te.getBindsTo();
					assert tev != null;
					List<RelationDomain> rOppositeDomains = new ArrayList<RelationDomain>();
					Iterator<Domain> it = r.getDomain().iterator();
					while (it.hasNext()) {
						rOppositeDomains.add((RelationDomain) it.next());
					}
					rOppositeDomains.remove(rd);
					subRecords.add(new SubRecord(rd, dir, tmn, dn, up, domainVars, te, tev, rOppositeDomains));
				}
			}
		}
	}
	
	@Override
	public void instantiateOutput() {
		for (SubRecord subRecord : subRecords) {
			final Transformation mt2 = mt;
			if (mt2 != null) {
				Mapping m = transformation.whenMapping(mt2, rn+'_'+subRecord.dn);
				assert m != null;
				subRecord.m = m;
				GuardPattern mg = transformation.whenGuardPattern(m);
				assert mg != null;
				subRecord.mg = mg;
				BottomPattern mb = transformation.whenBottomPattern(m);
				assert mb != null;
				subRecord.mb = mb;
				CoreDomain md = transformation.whenCoreDomain(m, subRecord.dn);
				assert md != null;
				subRecord.md = md;
				TypedModel mdir = null;
				for (TypedModel tm : mt2.getModelParameter()) {
					if (tm.getName() == subRecord.tmn) {
						if (tm.getUsedPackage().equals(subRecord.up)) {
							mdir = tm;
							break;
						}
					}
				}
				assert mdir != null;
				subRecord.mdir = mdir;
				GuardPattern dg = transformation.whenGuardPattern(md);
				assert dg != null;
				subRecord.dg = dg;
				BottomPattern db = transformation.whenBottomPattern(md);
				assert db != null;
				subRecord.db = db;
			} else {
				// TODO handle null value
			}
		}
	}

	
	@Override
	public void setAttributes() {
		for (SubRecord subRecord : subRecords) {
			BottomPattern mb = subRecord.mb;
			RealizedVariable tcv = subRecord.tcv;
			assert (mb != null) && (tcv != null);
			mb.getRealizedVariable().add(tcv);
			//mb.getVariable().addAll(mbvars);
			CoreDomain md = subRecord.md;
			assert (md != null);
			md.setTypedModel(subRecord.mdir);
			md.setIsEnforceable(true);
			BottomPattern db = subRecord.db;
			RealizedVariable mtev = subRecord.mtev;
			assert (db != null) && (mtev != null);
			db.getRealizedVariable().add(mtev);
		}
	}	
	
	@Override
	public boolean when() {
		RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
		assert rt != null;
		// This is the same code the factory has, and IMHO its better encapsulated by the factory.
		// The real issue is that the bindings needs a rule and to get a record (rule) we need a binding
		//Rule whenRule = RelationalTransformationToMappingTransformation.FACTORY.createRule(transformation, rt);
		RelationalTransformationToMappingTransformation whenRule = new RelationalTransformationToMappingTransformation(transformation, rt); 
		RuleBindings whenBindings = whenRule.getRuleBindings();
		RelationalTransformationToMappingTransformation whenRuleRecord = (RelationalTransformationToMappingTransformation) transformation.getRecord(whenBindings);
		if (whenRuleRecord != null && whenRuleRecord.hasExecuted()) {
			mt = whenRuleRecord.getCore();
			assert mt != null;
			return true;
		}
		return false;
	}

	@Override
	public void where() {
		QVTr2QVTcRelations relations = new QVTr2QVTcRelations(transformation);
		Set<@NonNull Predicate> rpSet = new HashSet<@NonNull Predicate>();
		Set<@NonNull Variable> whereVars = new HashSet<@NonNull Variable>();
		Set<@NonNull Variable> whenVars = new HashSet<@NonNull Variable>();
		if (r.getWhen() != null) {
			whenVars.addAll(ClassUtil.nullFree(r.getWhen().getBindsTo()));
		}
		Pattern rWhere = r.getWhere();
		if (rWhere != null) {
			rpSet.addAll(relations.rejectRelationCallPredicates(ClassUtil.nullFree(rWhere.getPredicate())));
			whereVars.addAll(ClassUtil.nullFree(rWhere.getBindsTo()));
		}
		Set<@NonNull Variable> sharedDomainVars = relations.getSharedDomainVars(r);
		Set<@NonNull Variable> allDomainVars = relations.getAllDomainVars(r);
		Set<@NonNull Variable> unsharedWhereVars = new HashSet<@NonNull Variable>(whereVars);
		unsharedWhereVars.removeAll(whenVars);
		unsharedWhereVars.removeAll(allDomainVars);
		unsharedWhereVars.addAll(sharedDomainVars);
		Set<@NonNull Variable> unsharedWhenVars = new HashSet<@NonNull Variable>(whenVars);
		unsharedWhenVars.removeAll(allDomainVars);
		for (SubRecord subRecord : subRecords) {
			Set<Variable> oppositeDomainVars = new HashSet<Variable>();
			for (Domain d : subRecord.rOppositeDomains) {
				oppositeDomainVars.addAll(QVTr2QVTcRelations.getDomainPattern(d).getBindsTo());
			}
			Set<@NonNull Variable> domainBottomUnSharedVars = new HashSet<@NonNull Variable>(subRecord.domainVars);
			domainBottomUnSharedVars.removeAll(whenVars);
			domainBottomUnSharedVars.removeAll(sharedDomainVars);
			Set<@NonNull Predicate> predicatesWithVarBindings = relations.filterOutPredicatesThatReferToVars(rpSet, domainBottomUnSharedVars);
			Set<@NonNull Predicate> predicatesWithoutVarBindings = new HashSet<@NonNull Predicate>(rpSet);
			predicatesWithoutVarBindings.removeAll(predicatesWithVarBindings);
			Set<@NonNull Variable> domainVarsSharedWithWhen = new HashSet<@NonNull Variable>(subRecord.domainVars);
			domainVarsSharedWithWhen.retainAll(whenVars);
			domainVarsSharedWithWhen.remove(subRecord.tev);
			BottomPattern mb = subRecord.mb;
			assert mb != null;
			BottomPattern db = subRecord.db;
			assert db != null;
			GuardPattern dg = subRecord.dg;
			assert dg != null;
			Mapping m = subRecord.m;
			assert m!= null;
			GuardPattern mg = subRecord.mg;
			assert mg != null;
			
			// Relation Calls
			// T6
			RealizedVariable mtev = relations.doRVarToMRealizedVar(subRecord.tev, db);
			assert mtev != null;
			subRecord.mtev = mtev;
			RealizedVariable tcv = relations.doRelationDomainToTraceClassVar(r, subRecord.rd, mb);
			assert tcv != null;
			subRecord.tcv = tcv;
			//T5
			relations.doRPredicateSetToMBPredicateSet(new ArrayList<Predicate>(predicatesWithVarBindings), mb);
			relations.doRVarSetToDGVarSet(new ArrayList<Variable>(domainVarsSharedWithWhen), dg);
			
			//T4
			/* List<Variable> mbvars =*/ relations.doRVarSetToMBVarSet(new ArrayList<Variable>(unsharedWhereVars), mb);
			//subRecord.mbvars = mbvars;
			//T3
			relations.doTROppositeDomainsToMappingForEnforcement(r, subRecord.rd, m);
			// Invoked here so the variables are instantiated
			relations.doROppositeDomainVarsToTraceClassProps(r, subRecord.rd, subRecord.te, oppositeDomainVars, mb);
			relations.doRWhenPatternToMGuardPattern(r, mg);
			relations.doRDomainToMDBottomForEnforcement(r, subRecord.rd, subRecord.te, predicatesWithoutVarBindings, domainBottomUnSharedVars, db);
			relations.doRRelImplToMBottomEnforcementOperation(r, subRecord.rd, mb);
			
		}
	}
	
}
