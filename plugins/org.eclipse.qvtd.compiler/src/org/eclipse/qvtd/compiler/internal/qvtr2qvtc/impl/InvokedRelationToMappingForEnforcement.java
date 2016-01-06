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
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTcRelations;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
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
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

public class InvokedRelationToMappingForEnforcement extends AbstractRule {

	private static class Factory extends AbstractRule.Factory
	{
		@Override
		public @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation, @NonNull EObject eo) {
			Rule rule = null;
			if (eo instanceof Relation) {	
				rule = new InvokedRelationToMappingForEnforcement(transformation, (Relation) eo);
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

		@NonNull private Relation ir;
		@NonNull private RelationDomain rd;
//		@NonNull private TypedModel dir;
		@NonNull private String tmn;
		@NonNull private List<org.eclipse.ocl.pivot.Package> up;
		@NonNull private String dn;
		@NonNull private List<Variable> domainVars;
		@NonNull private ObjectTemplateExp te;
		@NonNull private Variable tev;
		@NonNull private List<RelationDomain> rOppositeDomains;
		@NonNull private RelationCallExp ri;
		
		// Core
		private BottomPattern mb;
		private String irn;
		private Mapping m;
		private CoreDomain md;
		private TypedModel mdir;
		private GuardPattern dg;
		private BottomPattern db;
		private RealizedVariable tcv;
		private GuardPattern mg;
		

		public SubRecord(@NonNull RelationCallExp ri, @NonNull Relation ir,
				@NonNull String irn, @NonNull RelationDomain rd,
				@NonNull TypedModel dir, @NonNull String tmn,
				@NonNull String dn, @NonNull List<org.eclipse.ocl.pivot.Package> up, 
				@NonNull List<Variable> domainVars,
				@NonNull ObjectTemplateExp te, @NonNull Variable tev,
				@NonNull List<RelationDomain> rOppositeDomains) {
			
			this.ri = ri;
			this.ir = ir;
			this.irn = irn;
			this.rd = rd;
//			this.dir = dir;
			this.tmn = tmn;
			this.dn = dn;
			this.up = up;
			this.domainVars = domainVars;
			this.te = te;
			this.tev = tev;
			this.rOppositeDomains = rOppositeDomains;
		}
		
	}
	
	// Relations
	private static final RuleBindings.@NonNull KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	private static final RuleBindings.@NonNull RuleKey<Relation> RELATIONS_r = RULE_BINDINGS.createRoot((Relation)null, "r");

	public Transformation mt;
	
	public static final Rule.@NonNull Factory FACTORY = new Factory(); 
	
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();
	private String rn;
	
	protected InvokedRelationToMappingForEnforcement(
			@NonNull QvtrToQvtcTransformation transformation, Relation r) {
		
		super(transformation);
		ruleBindings.put(RELATIONS_r, r);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#check()
	 */
	@Override
	public void check() {
		Relation r = ruleBindings.get(RELATIONS_r);
		assert (r != null);
		rn = r.getName();
		if (!r.isIsTopLevel()) {
			List<RelationCallExp> ris = transformation.getRelationCallExpsForRelation(r);
			if (ris != null) {
				for (RelationCallExp ri : ris) {
					assert ri != null;
					Relation ir = transformation.getInvokingRelationForRelationCallExp(ri);
					assert ir != null;
					String irn = ir.getName();
					assert irn != null;
					for (Domain d : r.getDomain()) {
						RelationDomain rd = (RelationDomain) d;
						DomainPattern dp = rd.getPattern().get(0);
						assert dp != null;
						if (rd.isIsEnforceable() && dp.getTemplateExpression() instanceof ObjectTemplateExp) {
							//Mapping m = QVTcoreFactory.eINSTANCE.createMapping();
							String dn = rd.getName();
							assert dn != null;
							TypedModel dir = rd.getTypedModel();
							String tmn = dir.getName();
							assert tmn != null;
							List<org.eclipse.ocl.pivot.Package> up = dir.getUsedPackage();
							assert up != null;
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
							subRecords.add(new SubRecord(ri, ir, irn, rd, dir, tmn, dn, up, domainVars, te, tev, rOppositeDomains));
						}
					}
				}
			}
		}
	}
	
	
	

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#instantiateOutput()
	 */
	@Override
	public void instantiateOutput() {
		Relation r = ruleBindings.get(RELATIONS_r);
		assert (r != null) && (mt != null);
		for (SubRecord subRecord : subRecords) {
			final Transformation mt2 = mt;
			if (mt2 != null) {
				Mapping m = transformation.findMapping(rn+'_'+subRecord.irn+'_'+subRecord.dn, mt2);
				assert m != null;
				subRecord.m = m;
				GuardPattern mg = transformation.findGuardPattern(m);
				assert mg != null;
				subRecord.mg = mg;
				BottomPattern mb = transformation.findBottomPattern(m);
				assert mb != null;
				subRecord.mb = mb;
				CoreDomain md = transformation.findCoreDomain(subRecord.dn, m);
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
				GuardPattern dg = transformation.findGuardPattern(md);
				assert dg != null;
				subRecord.dg = dg;
				BottomPattern db = transformation.findBottomPattern(md);
				assert db != null;
				subRecord.db = db;
			}
		}
	}
	
	

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#setAttributes()
	 */
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
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#when()
	 */
	@Override
	public boolean when() {
		Relation r = ruleBindings.get(RELATIONS_r);
		assert r != null;
		RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
		assert rt != null;
		// This is the same code the factory has, and IMHO its better encapsulated by the factory.
		// The real issue is that the bindings needs a rule and to get a record (rule) we need a binding
		//Rule whenRule = RelationalTransformationToMappingTransformation.FACTORY.createRule(transformation, rt);
		RelationalTransformationToMappingTransformation whenRule = new RelationalTransformationToMappingTransformation(transformation, rt); 
		RuleBindings whenBindings = whenRule.getRuleBindings();
		RelationalTransformationToMappingTransformation whenRuleRecord = (RelationalTransformationToMappingTransformation) transformation.getRecord(whenBindings);
		if (whenRuleRecord != null && whenRuleRecord.hasExecuted()) {
			mt = (Transformation) whenRuleRecord.getCore();
			assert mt != null;
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#where()
	 */
	@Override
	public void where() {
		QVTr2QVTcRelations relations = new QVTr2QVTcRelations(transformation);
		Relation r = ruleBindings.get(RELATIONS_r);
		assert r != null;
		Set<Variable> allDomainVars = relations.getAllDomainVars(r);
		Set<Variable> whereVars = new HashSet<Variable>();
		Set<Variable> whenVars = new HashSet<Variable>();
		Set<Predicate> rpSet = new HashSet<Predicate>();
		if (r.getWhen() != null) {
			whenVars.addAll(r.getWhen().getBindsTo());
		}
		if (r.getWhere() != null) {
			rpSet.addAll(relations.rejectRelationCallPredicates(r.getWhere().getPredicate()));
			whereVars.addAll(r.getWhere().getBindsTo());
		}
		Set<Variable> sharedDomainVars = relations.getSharedDomainVars(r);
		Set<Variable> unsharedWhereVars = new HashSet<Variable>(whereVars);
		unsharedWhereVars.removeAll(whenVars);
		unsharedWhereVars.removeAll(allDomainVars);
		unsharedWhereVars.addAll(sharedDomainVars);
		Set<Variable> unsharedWhenVars = new HashSet<Variable>(whenVars);
		unsharedWhenVars.removeAll(allDomainVars);
		for (SubRecord subRecord : subRecords) {
			Set<Variable> oppositeDomainVars = new HashSet<Variable>();
			for (Domain d : subRecord.rOppositeDomains) {
				if (((RelationDomain)d).getPattern() != null) {
					oppositeDomainVars.addAll(((RelationDomain)d).getPattern().get(0).getBindsTo());
				}
			}
			Set<Variable> domainBottomUnSharedVars = new HashSet<Variable>(subRecord.domainVars);
			domainBottomUnSharedVars.removeAll(whenVars);
			domainBottomUnSharedVars.removeAll(sharedDomainVars);
			domainBottomUnSharedVars.remove(subRecord.tev);
			Set<Predicate> predicatesWithVarBindings = relations.filterOutPredicatesThatReferToVars(rpSet, domainBottomUnSharedVars);
			Set<Predicate> predicatesWithoutVarBindings = new HashSet<Predicate>(rpSet);
			predicatesWithoutVarBindings.removeAll(predicatesWithVarBindings);
			Set<Variable> domainTopVars = new HashSet<Variable>(subRecord.domainVars);
			domainTopVars.retainAll(whenVars);
			domainTopVars.add(subRecord.tev);
			Mapping m = subRecord.m;
			assert m!= null;
			GuardPattern mg = subRecord.mg;
			assert mg != null;
			BottomPattern mb = subRecord.mb;
			assert mb != null;
			GuardPattern dg = subRecord.dg;
			assert dg != null;
			BottomPattern db = subRecord.db;
			assert db != null;
			// Relation Calls
			// T6
			RealizedVariable tcv = relations.doRelationDomainToTraceClassVar(r, subRecord.rd, mb);
			assert tcv != null;
			subRecord.tcv = tcv;
			// T5
			relations.doRPredicateSetToMBPredicateSet(new ArrayList<Predicate>(predicatesWithVarBindings), mb);
			relations.doRVarSetToDGVarSet(new ArrayList<Variable>(domainTopVars), dg);
			//T4
			relations.doRVarSetToMBVarSet(new ArrayList<Variable>(unsharedWhereVars), mb);
			//T3
			relations.doIROppositeDomainsToMappingForEnforcement(r, subRecord.ir, subRecord.rd, m);
			relations.doRInvokerToMGuard(subRecord.ir, subRecord.ri, r, mg);
			relations.doROppositeDomainVarsToTraceClassProps(r, subRecord.rd, subRecord.te, oppositeDomainVars, mb);
			relations.doRWhenPatternToMGuardPattern(r, mg);
			relations.doRDomainToMDBottomForEnforcement(r, subRecord.rd, subRecord.te, predicatesWithoutVarBindings, domainBottomUnSharedVars, db);
			relations.doRRelImplToMBottomEnforcementOperation(r, subRecord.rd, mb);
		}
	}
	
}
