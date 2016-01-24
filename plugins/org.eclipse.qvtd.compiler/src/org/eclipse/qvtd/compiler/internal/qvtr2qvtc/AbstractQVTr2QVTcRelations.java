/*******************************************************************************
 * Copyright (c) 2014, 2015 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/*public*/ abstract class AbstractQVTr2QVTcRelations
{
	protected abstract class AbstractRelationDomain2CoreDomain 
	{
		// Relations
		protected final @NonNull RelationDomain rd;
		protected final @NonNull Relation r;
		protected final @NonNull List<@NonNull Variable> domainVars;
		protected final @NonNull List<@NonNull RelationDomain> rOppositeDomains;
		protected final @NonNull ObjectTemplateExp te;
		protected final @NonNull Variable tev;
		// Core
		protected final @NonNull Mapping m;
		protected final @NonNull GuardPattern mg;
		protected final @NonNull BottomPattern mb;
		protected final @NonNull TypedModel mdir;
		protected final @NonNull CoreDomain md;
		protected final @NonNull GuardPattern dg;
		protected final @NonNull BottomPattern db;
		protected final @NonNull RealizedVariable tcv;
			
		public AbstractRelationDomain2CoreDomain(@NonNull RelationDomain rd, @NonNull String coreMappingName) {
			this.rd = rd;
			//
			this.r = (@NonNull Relation) ClassUtil.nonNullState(rd.getRule());
			@NonNull DomainPattern dp = qvtr2qvtc.getDomainPattern(rd);
			this.domainVars = ClassUtil.nullFree(dp.getBindsTo());
			this.rOppositeDomains = getOppositeDomains(rd);
			this.te = (ObjectTemplateExp) ClassUtil.nonNullState(dp.getTemplateExpression());
			this.tev = ClassUtil.nonNullState(te.getBindsTo());
			@NonNull RelationalTransformation rt = (RelationalTransformation) ClassUtil.nonNullState(r.getTransformation());
			@NonNull Transformation mt = qvtr2qvtc.getCoreTransformation(rt);
			@NonNull TypedModel dir = ClassUtil.nonNullState(rd.getTypedModel());
			@NonNull String rn = ClassUtil.nonNullState(r.getName());
			@NonNull String dn = ClassUtil.nonNullState(rd.getName());
			@NonNull TypedModel coreTypedModel = getCoreTypedModel(mt, ClassUtil.nonNullState(dir.getName()), ClassUtil.nullFree(dir.getUsedPackage()));
			@NonNull Type tc = qvtr2qvtc.getTraceClass(r);
			//
			this.m = qvtr2qvtc.whenMapping(mt, coreMappingName);
			this.mg = ClassUtil.nonNullState(m.getGuardPattern());
			this.mb = ClassUtil.nonNullState(m.getBottomPattern());
			this.mdir = coreTypedModel;
			this.md = qvtr2qvtc.whenCoreDomain(m, dn);
			this.dg = ClassUtil.nonNullState(md.getGuardPattern());
			this.db = ClassUtil.nonNullState(md.getBottomPattern());
			this.tcv = qvtr2qvtc.whenRealizedVariable(mb, rn+"_"+dn+"_v", tc);	// 42
		}
		
		/* =============  T3 ============= */
		
		/* =============  T4 ============= */
		
		// 2
		/*public void doDomainVarsSharedWithWhenToDgVars(@NonNull Set<Variable> domainVarsSharedWithWhen, @NonNull GuardPattern dg) {
			
			List<Variable> dbVars = doRVarSetToMVarSet(new ArrayList<Variable>(domainVarsSharedWithWhen));
			dg.getBindsTo().addAll(dbVars);
		}*/
		
		// 10
		protected void doRDomainPatternToMDBottomPattern(@NonNull ObjectTemplateExp pte) {
			
			CoreDomain cd = (CoreDomain) db.getArea();
			assert cd != null;
			Mapping m = (Mapping) cd.getRule();
			assert m != null;
			BottomPattern mb = m.getBottomPattern();
			assert mb != null;
			doRDomainPatternToMDBottomPatternComposite(pte);
			doRDomainPatternToMDBottomPatternSimpleNonVarExpr(pte);
		    doRDomainPatternToMDBottomPatternSimpleUnSharedVarExpr(pte);
		    doRDomainPatternToMDBottomPatternSimpleSharedVarExpr(pte);
			
		}

		// 15
		/*
		 * Creates a Predicate, who's ConditionExpression is an
		 * OperationCallExp:
		 * 		trace.<v.name> = v;
		 * TODO Suggest better name: RDomainPatternVariableToTracePredicate?
		 */
		private void doRDomainToMBottomPredicateForEnforcement(@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings, @NonNull Set<@NonNull Variable> unboundDomainVars)
		{
			// check
			Variable v = te.getBindsTo();
			assert v != null;
			// init
			Predicate pd = qvtr2qvtc.createPredicate();
			OperationCallExp ee = qvtr2qvtc.createOperationCallExp();
			PropertyCallExp pe = qvtr2qvtc.createPropertyCallExp();
			VariableExp pve = qvtr2qvtc.createVariableExp();
			VariableExp ave = qvtr2qvtc.createVariableExp();
			// where
			@NonNull Variable mv = doRVarToMVar(v);
			Set<@NonNull Variable> remainingUnBoundDomainVars = new HashSet<@NonNull Variable>(unboundDomainVars);
			remainingUnBoundDomainVars.remove(v);
			Set<@NonNull Predicate> predicatesWithVarBindings = 
					filterOutPredicatesThatReferToVars(predicatesWithoutVarBindings, remainingUnBoundDomainVars);
			doRPredicateSetToMBPredicateSet(new ArrayList<@NonNull Predicate>(predicatesWithVarBindings), mb);
			// assign
			pve.setReferredVariable(tcv);
			pve.setType(tcv.getType());
			pe.setOwnedSource(pve);
			@NonNull Property pep = getProperty(tcv.getType(), v.getName());
			pe.setReferredProperty(pep);
			pe.setType(pep.getType());
			ee.setOwnedSource(pe);
			ee.setReferredOperation(getEqualsOperation());
			ee.setType(qvtr2qvtc.getStandardLibrary().getBooleanType());
			ave.setReferredVariable(mv);
			ave.setType(mv.getType());
			ee.getOwnedArguments().add(ave);
			pd.setConditionExpression(ee);
			mb.getPredicate().add(pd);
		}
		
		// 18
		/*
		 * Creates Assignments for each part of the ObjectTemplateExp
		 */
		private void doRDomainToMDBottomForEnforcementOfIdentityProp()
		{
			// check
			Variable v = te.getBindsTo();
			assert v != null;
			Type c = v.getType();
			assert c != null;
			Area area = db.getArea();
			assert area instanceof CoreDomain : "Missing CoreDomain for RDomainToMDBottomForEnforcement";
			CoreDomain cd = (CoreDomain) area;
			Rule rule = cd.getRule();
			assert rule instanceof Mapping : "Missing Mapping for RDomainToMDBottomForEnforcement";
			Mapping m = (Mapping) rule;
			BottomPattern mb = m.getBottomPattern();
			assert mb != null;
			for (PropertyTemplateItem pt : te.getPart()) {
				final Property pp = pt.getReferredProperty();
				// check relations
				Key key = qvtr2qvtc.getKeyforType(c);
				assert key != null;		// FIXME why non-null
				if (key.getPart().contains(pp)) {
					final OCLExpression e = pt.getValue();
					assert (pp != null) && (e != null);
					doRDomainPatternExprToMappingDomainAssignment(v, pp, e);
					doRDomainPatternExprToMappingDomainVarAssignment(v, pp, e);
					doRDomainPatternExprToMappingDomainTemplateVarAssignment(v, pp, e);
				    doRDomainPatternExprToMappingBottomVarAssignment(v, pp, e);
				}
			}
		}
		
		// 20
		private void doRDomainToMDBottomForEnforcementOfNonIdentityPropObject(@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings, @NonNull Set<@NonNull Variable> unboundDomainVars)
		{
			// check
			// FIXME not c.key.part->includes(pp)
			// when
			RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
			assert rt != null;
			@NonNull Transformation mt = qvtr2qvtc.getCoreTransformation(rt);
			// TODO Finish when clear about if the call should be uncommented
			// ...
		}
		
		// 29
		protected void doRPredicateSetToMBPredicateSet(@NonNull ArrayList<@NonNull Predicate> predSeq, @NonNull BottomPattern mb) {
			
			// check
			if(predSeq.isEmpty()) {
				return;
			}
			Predicate rp = predSeq.remove(0);
			OCLExpression re = rp.getConditionExpression();
			assert re != null;
			// init
			@NonNull Predicate mp = qvtr2qvtc.createPredicate();
			// when
			@NonNull OCLExpression me = doRExpToMExp(re);
			doRPredicateSetToMBPredicateSet(predSeq, mb);
			// assign
			mp.setConditionExpression(me);
			mb.getPredicate().add(mp);
		}
		
		// 32
		private void doRSimplePatternToMPattern(@NonNull Pattern rp) {
			for (@NonNull Predicate pd : ClassUtil.nullFree(rp.getPredicate())) {
				// check
				OCLExpression ce = pd.getConditionExpression();
				assert ce != null;
				if (!(ce instanceof RelationCallExp)) {
					@NonNull Predicate mpd = qvtr2qvtc.createPredicate();
					@NonNull OCLExpression me = doRExpToMExp(ce);
					mpd.setConditionExpression(me);
				}
			}
		}
		
		// 34	
		protected void doRVarSetToMBVarSet(@NonNull ArrayList<@NonNull Variable> rvSeq, @NonNull BottomPattern mb) {
			for (@NonNull Variable rv : rvSeq) {
				qvtr2qvtc.whenVariable(mb, rv);
			}
		}
		
		// 40
		private void doRWhenRelCallToMGuard(@NonNull Pattern rp) {
			
			for (Predicate p : rp.getPredicate()) {
				// check
				if (p.getConditionExpression() instanceof RelationCallExp) {
					RelationCallExp e = (RelationCallExp) p.getConditionExpression();
					Relation r = e.getReferredRelation();
					List<Domain> dseq = new ArrayList<Domain>(r.getDomain());
					// where
					StringBuilder s = new StringBuilder();
					for (OCLExpression arg : e.getArgument()) {
						VariableExp a = (VariableExp) arg;
						s.append("_");
						s.append(a.getReferredVariable().getName());
					}
					String vdId = s.toString();
				    for (OCLExpression arg : e.getArgument()) {
						VariableExp a = (VariableExp) arg;
						RelationDomain rd = (RelationDomain) dseq.get(e.getArgument().indexOf(a));
						assert (a != null) && (rd != null) && (vdId != null);
						doRWhenRelCallArgToMGuardPredicate(r, a, rd, mg, vdId);
					}
				}
			}
		}

		// 50
		/*
		private void doUnsharedWhenVarsToMgVars(@NonNull Set<Variable> unsharedWhenVars,
				@NonNull GuardPattern mg) {
			
			List<Variable> mgVars = doRVarSetToMVarSet(new ArrayList<Variable>(unsharedWhenVars));
			mg.getBindsTo().addAll(mgVars);
		}
		*/
		
		
		/* =============  T5 ============= */
		
		// 6
		private void doRDomainPatternExprToMappingBottomVarAssignment(@NonNull Variable v, @NonNull Property pp, @NonNull OCLExpression e) {

			// when
			Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
			// check
			if ((e instanceof VariableExp) && sharedDomainVars.contains(((VariableExp)e).getReferredVariable()) ) {
				String pn = pp.getName();
				Variable rev = (Variable) ((VariableExp)e).getReferredVariable();
				assert rev != null;
				// init
				PropertyAssignment a = qvtr2qvtc.createPropertyAssignment();
				VariableExp ve = qvtr2qvtc.createVariableExp();
				VariableExp me = qvtr2qvtc.createVariableExp();
				// where
				@NonNull RealizedVariable mv = doRVarToMRealizedVar(v);
				@NonNull Variable mev = doRVarToMVar(rev);
				// assign
				ve.setReferredVariable(mv);
				ve.setType(mv.getType());
				a.setSlotExpression(ve);
				@NonNull Property tp = getProperty(mv.getType(), pn);
				a.setTargetProperty(tp);
				me.setReferredVariable(mev);
				me.setType(mev.getType());
				a.setValue(me);
				mb.getAssignment().add(a);
			}
		}

		
		// 7
		private void doRDomainPatternExprToMappingDomainAssignment(@NonNull Variable v, @NonNull Property pp, @NonNull OCLExpression e) {
			
			// check
			if (!(e instanceof VariableExp) &&  !(e instanceof ObjectTemplateExp)) {
				String pn = pp.getName();
				// init
				PropertyAssignment a = qvtr2qvtc.createPropertyAssignment();
				VariableExp ve = qvtr2qvtc.createVariableExp();
				// where
				@NonNull Variable mv = doRVarToMVar(v);
				@NonNull OCLExpression me = doRExpToMExp(e);
				// assign
				a.setSlotExpression(ve);
				ve.setReferredVariable(mv);
				ve.setType(mv.getType());
				@NonNull Property tp = getProperty(mv.getType(), pn); 
				a.setTargetProperty(tp);
				a.setValue(me);
				db.getAssignment().add(a);
			}
			
		}
			
		// 8
		private void doRDomainPatternExprToMappingDomainTemplateVarAssignment(@NonNull Variable v, @NonNull Property pp, @NonNull OCLExpression e) {
			// when 
			Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
			// check
			if (e instanceof ObjectTemplateExp) {
				final Variable rev = ((ObjectTemplateExp)e).getBindsTo();
				assert rev != null;
				if (!sharedDomainVars.contains(rev)) {
					String pn = pp.getName();
					// init
					PropertyAssignment a = qvtr2qvtc.createPropertyAssignment();
					VariableExp ve = qvtr2qvtc.createVariableExp();
					VariableExp me = qvtr2qvtc.createVariableExp();
					RealizedVariable mv = doRVarToMRealizedVar(v);
					@NonNull Variable mev = doRVarToMVar(rev);
					// assign
					ve.setReferredVariable(mv);
					ve.setType(mv.getType());
					a.setSlotExpression(ve);
					@NonNull Property tp = getProperty(mv.getType(), pn);
					a.setTargetProperty(tp);
					me.setReferredVariable(mev);
					me.setType(mev.getType());
					a.setValue(me);
					db.getAssignment().add(a);
				}
			}
		}
			
		// 9
		private void doRDomainPatternExprToMappingDomainVarAssignment(@NonNull Variable v, @NonNull Property pp, @NonNull OCLExpression e) {
			// when
			Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
			// check
			if ((e instanceof VariableExp) && !sharedDomainVars.contains(((VariableExp)e).getReferredVariable()) ) {
				String pn = pp.getName();
				Variable rev = (Variable) ((VariableExp) e).getReferredVariable();
				assert rev != null;
				// init
				PropertyAssignment a = qvtr2qvtc.createPropertyAssignment();
				VariableExp ve = qvtr2qvtc.createVariableExp();
				VariableExp me = qvtr2qvtc.createVariableExp();
				// where
				@NonNull RealizedVariable mv = doRVarToMRealizedVar(v);
				@NonNull Variable mev = doRVarToMVar(rev);
				// assign
				ve.setReferredVariable(mv);
				ve.setType(mv.getType());
				a.setSlotExpression(ve);
				@NonNull Property tp = getProperty(mv.getType(), pn);
				a.setTargetProperty(tp);
				me.setReferredVariable(mev);
				me.setType(mev.getType());
				a.setValue(me);
				
				db.getRealizedVariable().add(mv);
				db.getAssignment().add(a);
			}
		}
		
		// 11
		/*
		 * Recursively create an assignment for each ObjectTemplateExp
		 */
		private void doRDomainPatternToMDBottomPatternComposite(@NonNull ObjectTemplateExp te) {
			
			// check
			for (PropertyTemplateItem pt : te.getPart()) {
				if (pt.getValue() instanceof ObjectTemplateExp) {
					Variable vte = te.getBindsTo();
					assert vte != null;
					Property pp = pt.getReferredProperty();
					assert pp != null;
					String pn = pp.getName();
					ObjectTemplateExp pte = (ObjectTemplateExp) pt.getValue();
					Variable vpte = pte.getBindsTo();
					assert vpte != null;
					// init
					PropertyAssignment a = qvtr2qvtc.createPropertyAssignment();
					VariableExp ve1 = qvtr2qvtc.createVariableExp();
					VariableExp ve2 = qvtr2qvtc.createVariableExp();
					// where
					@NonNull Variable mvte = doRVarToMVar(vte);
					@NonNull Variable mvpte = doRVarToMVar(vpte);
					doRDomainPatternToMDBottomPattern(pte);
					// assign
					@NonNull Property tp = getProperty(mvte.getType(), pn);
					ve1.setReferredVariable(mvte);
					ve1.setType(mvte.getType());
					a.setSlotExpression(ve1);
					a.setTargetProperty(tp);
					ve2.setReferredVariable(mvpte);
					ve2.setType(mvpte.getType());
					a.setValue(ve2);
					db.getAssignment().add(a);
				}
			}
		}
		
		// 12
		private void doRDomainPatternToMDBottomPatternSimpleNonVarExpr(@NonNull ObjectTemplateExp te) {
			// check
			Variable vte = te.getBindsTo();
			assert vte != null;
			for (PropertyTemplateItem pt : te.getPart()) {
				OCLExpression e = pt.getValue();
				assert e != null;
				// guard
				if (!(e instanceof TemplateExp) && !(e instanceof VariableExp)) {
					Property pp = pt.getReferredProperty();
					assert pp != null;
					String pn = pp.getName();
					// init
					PropertyAssignment a = qvtr2qvtc.createPropertyAssignment();
					VariableExp ve = qvtr2qvtc.createVariableExp();
					// where
					@NonNull Variable mvte = doRVarToMVar(vte);
					@NonNull OCLExpression me = doRExpToMExp(e);
					// assign
					ve.setReferredVariable(mvte);
					ve.setType(mvte.getType());
					@NonNull Property tp = getProperty(mvte.getType(), pn);
					a.setTargetProperty(tp);
					a.setSlotExpression(ve);
					a.setValue(me);
					db.getAssignment().add(a);
				}
			}
		}
		
		
		// 13
		/*
		 * Create a PropertyAssignment for each property assignment of the te
		 * that does not reference a shared domain var
		 */
		private void doRDomainPatternToMDBottomPatternSimpleSharedVarExpr(@NonNull ObjectTemplateExp te) {
			// when
			Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
			// check
			Variable vte = te.getBindsTo();
			assert vte != null;
			for (PropertyTemplateItem pt : te.getPart()) {
				if (pt.getValue() instanceof VariableExp) {
					VariableExp e = (VariableExp) pt.getValue();
					Variable vpte = (Variable) e.getReferredVariable();
					assert vpte != null;
					// guard
					if (sharedDomainVars.contains(vpte)) {
						String pn = pt.getReferredProperty().getName(); 
						// init
						PropertyAssignment a = qvtr2qvtc.createPropertyAssignment();
						VariableExp ve1 = qvtr2qvtc.createVariableExp();
						VariableExp ve2 = qvtr2qvtc.createVariableExp();
						// where
						@NonNull Variable mvte = doRVarToMVar(vte);
						@NonNull Variable mvpte = doRVarToMVar(vpte);
						// assign
					    ve1.setReferredVariable(mvte);
					    ve2.setReferredVariable(mvpte);
					    @NonNull Property tp = getProperty(mvte.getType(), pn);
						a.setSlotExpression(ve1);
						a.setTargetProperty(tp);
						a.setValue(ve2);
						mb.getAssignment().add(a);
					}
				}
			}
		}
			
		// 14 Opposite guard as 13
		/*
		 * Create a PropertyAssignment for each property assignment of the te
		 * that does reference a shared domain var
		 */
		
		private void doRDomainPatternToMDBottomPatternSimpleUnSharedVarExpr(@NonNull ObjectTemplateExp te) {
			// when
			Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
			// check
			Variable vte = te.getBindsTo();
			assert vte != null;
			for (PropertyTemplateItem pt : te.getPart()) {
				if (pt.getValue() instanceof VariableExp) {
					VariableExp e = (VariableExp) pt.getValue();
					Variable vpte = (Variable) e.getReferredVariable();
					assert vpte != null;
					// guard
					if (!sharedDomainVars.contains(vpte)) {
						String pn = pt.getReferredProperty().getName(); 
						// init
						PropertyAssignment a = qvtr2qvtc.createPropertyAssignment();
						VariableExp ve1 = qvtr2qvtc.createVariableExp();
						VariableExp ve2 = qvtr2qvtc.createVariableExp();
						// where
						@NonNull Variable mvte = doRVarToMVar(vte);
						@NonNull Variable mvpte = doRVarToMVar(vpte);
						// assign
					    ve1.setReferredVariable(mvte);
					    ve2.setReferredVariable(mvpte);
					    @NonNull Property tp = getProperty(mvte.getType(), pn);
						a.setSlotExpression(ve1);
						a.setTargetProperty(tp);
						a.setValue(ve2);
						db.getAssignment().add(a);
					}
				}
			}
			
		}
			
		// 16
		private void doRDomainToMComposedMappingGuard(@NonNull OCLExpression e, @NonNull Mapping cm) {
			
			// when
			RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
			assert rt != null;
			@NonNull Transformation mt = qvtr2qvtc.getCoreTransformation(rt);
			// guard
			DomainPattern rdp = qvtr2qvtc.getDomainPattern(rd);
			TemplateExp rdt = rdp.getTemplateExpression();
			if ((e instanceof VariableExp) && (rdt instanceof ObjectTemplateExp)) {
				// check
				Variable v = (Variable) ((VariableExp) e).getReferredVariable();
				assert v != null;
				if (isVarBoundToSomeOtherTemplate((ObjectTemplateExp) rdt, te, v)) {
					String dn, tmn;
					dn = rd.getName();
					assert dn != null;
					TypedModel dir = rd.getTypedModel();
					tmn = dir.getName();
					assert tmn != null;
					List<org.eclipse.ocl.pivot.Package> up = dir.getUsedPackage();
					if (rt != dir.getTransformation())
						return;
					// init
					GuardPattern mg = cm.getGuardPattern();
					Predicate pd = qvtr2qvtc.createPredicate();
					OperationCallExp ee = qvtr2qvtc.createOperationCallExp();
					PropertyCallExp pe = qvtr2qvtc.createPropertyCallExp();
					VariableExp ve1 = qvtr2qvtc.createVariableExp();
					VariableExp ve2 = qvtr2qvtc.createVariableExp();
					CoreDomain cd = qvtr2qvtc.whenCoreDomain(cm, dn);
					GuardPattern cmdg = cd.getGuardPattern();
					// where
					BottomPattern mb = cm.getBottomPattern();
					assert mb != null;
					@NonNull Variable mv = doRVarToMVar(v);
					// assign
					ve1.setReferredVariable(tcv);
					ve1.setType(tcv.getType());
					@NonNull Property tp = getProperty(mv.getType(), mv.getName());
					pe.setOwnedSource(ve1);
					pe.setReferredProperty(tp);
					pe.setType(tp.getType());
					ee.setOwnedSource(pe);
					ee.setReferredOperation(getEqualsOperation());
					ee.setType(qvtr2qvtc.getStandardLibrary().getBooleanType());
					ve2.setReferredVariable(mv);
					ve2.setType(mv.getType());
					ee.getOwnedArguments().add(ve2);
					pd.setConditionExpression(ee);
					mg.getPredicate().add(pd);
					TypedModel mdir = null;
					for (TypedModel tm : mt.getModelParameter()) {
						if (tm.getName().equals(tmn)) {
							if (tm.getUsedPackage().equals(up)) {
								mdir = tm;
								break;
							}
						}
					}
					cd.setTypedModel(mdir);
					cmdg.getBindsTo().add(mv);
					cd.setGuardPattern(cmdg);
				}
			}
		}

		// 21
		private void doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive()
		{
			// when
			RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
			assert rt != null;
			@NonNull Transformation mt = qvtr2qvtc.getCoreTransformation(rt);
			// check
			for (@NonNull PropertyTemplateItem pt : ClassUtil.nullFree(te.getPart())) {
				OCLExpression e = ClassUtil.nonNullState(pt.getValue());
				Property pp = ClassUtil.nonNullState(pt.getReferredProperty());
				Variable v = ClassUtil.nonNullState(te.getBindsTo());
				Type c = ClassUtil.nonNullState(v.getType());
				Key key = qvtr2qvtc.getKeyforType(c);
				assert key != null; // FIXME why non-null
				if (!(key.getPart().contains(pp)) && !(e instanceof TemplateExp)) {
					String pn = pp.getName();
					// init
					Mapping cm = qvtr2qvtc.whenMapping(mt, m.getName()+"_forNonIdentityProp");
					BottomPattern bp = cm.getBottomPattern();
					cm.getGuardPattern();
					PropertyAssignment a = qvtr2qvtc.createPropertyAssignment();
					VariableExp ve = qvtr2qvtc.createVariableExp();
					// where
					@NonNull Variable mv = doRVarToMVar(v);
					@NonNull OCLExpression me = doRExpToMExp(e);
					// where
					doRDomainToMComposedMappingGuard(e, cm);
					// assign
					ve.setReferredVariable(mv);
					ve.setType(mv.getType());
					a.setSlotExpression(ve);
					@NonNull Property tp = getProperty(mv.getType(), pn);
					a.setTargetProperty(tp);
					a.setValue(me);
					bp.getAssignment().add(a);
					m.getLocal().add(cm);
				}
			}
		}
		
		// 23
		/*
		 * Creates the assignment of the middle model to the L/R models
		 */
		private void doRDomainVarToMDBottomAssignmnetForEnforcement()
		{
			// check
			Variable v = ClassUtil.nonNullState(te.getBindsTo());
			// init
			PropertyAssignment a = qvtr2qvtc.createPropertyAssignment();
			VariableExp ve1 = qvtr2qvtc.createVariableExp();
			VariableExp ve2 = qvtr2qvtc.createVariableExp();
			// where
			@NonNull Variable mv = doRVarToMVar(v);
			// assign
			ve1.setReferredVariable(tcv);
			ve1.setType(tcv.getType());
			a.setSlotExpression(ve1);
			@NonNull Property tp = getProperty(tcv.getType(), v.getName());
			a.setTargetProperty(tp);
			ve2.setReferredVariable(mv);
			ve2.setType(mv.getType());
			a.setValue(ve2);
			
			mb.getAssignment().add(a);
		}
		
		// 35
		/*public @NonNull List<Variable> doRVarSetToMVarSet(@NonNull ArrayList<Variable> rvSeq) {
			
			List<Variable> mvSet = new ArrayList<Variable>();
			if (!rvSeq.isEmpty()) {
				final Variable rv = rvSeq.remove(0);
				assert rv != null;
				Variable mv = doRVarToMVar(rv);
				mvSet.add(mv);
				mvSet.addAll(doRVarSetToMVarSet(rvSeq));
			}
			return mvSet;
		}*/

		
		/* =============  T6 ============= */
		
		/*
		 * The issue with this method is that all variables should have been
		 * transformed so all variable references can be correctly pointed.
		 * However, if we call it after all variable modifying relations it
		 * should work.
		 */
		// 25
		private @NonNull OCLExpression doRExpToMExp(@NonNull OCLExpression re) {
//			OCLExpCopy oCLExpCopy = new OCLExpCopy(qvtr2qvtc);
			
//			return (OCLExpression) ClassUtil.nonNullState(oCLExpCopy.doSwitch(re));
			return qvtr2qvtc.copy(re, null);
		}
		
		// 36
		protected @NonNull RealizedVariable doRVarToMRealizedVar(@NonNull Variable rv, @NonNull BottomPattern pattern) {		
			RealizedVariable mv = qvtr2qvtc.whenRealizedVariable(pattern, rv);
			return mv;
		}
		
		private @NonNull RealizedVariable doRVarToMRealizedVar(@NonNull Variable rv) {		
			@NonNull RealizedVariable mv = (RealizedVariable) qvtr2qvtc.getCoreVariable(rv);
			return mv;
		}
		
		// 17
		protected void doRDomainToMDBottomForEnforcement(@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings,  @NonNull Set<@NonNull Variable> unboundDomainVars)
		{
			// check
			Variable v = te.getBindsTo();
			Set<@NonNull Variable> remainingUnBoundDomainVars = new HashSet<@NonNull Variable>(unboundDomainVars);
			remainingUnBoundDomainVars.remove(v);
			Set<@NonNull Predicate> predicatesWithVarBindings = filterOutPredicatesThatReferToVars(predicatesWithoutVarBindings, remainingUnBoundDomainVars);	
			Set<@NonNull Predicate> remainingPredicatesWithoutVarBindings = new HashSet<@NonNull Predicate>(predicatesWithoutVarBindings);
			remainingPredicatesWithoutVarBindings.removeAll(predicatesWithVarBindings);
			Area area = db.getArea();
			assert area instanceof CoreDomain : "Missing CoreDomain for RDomainToMDBottomForEnforcement";
			CoreDomain cd = (CoreDomain) area;
			Rule rule = cd.getRule();
			assert rule instanceof Mapping : "Missing Mapping for RDomainToMDBottomForEnforcement";
			Mapping m = (Mapping) rule;
			// init
			BottomPattern mb = m.getBottomPattern();
			assert mb != null;
			// where
			doRDomainToMDBottomForEnforcementOfIdentityProp();
			doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive();
			
			// This call is wrong as the trace variable is realized, it can't be guarded.
			// This should only be done in a nested mapping or later mapping
			//doRDomainToMBottomPredicateForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);		
			doRDomainVarToMDBottomAssignmnetForEnforcement();
		}
		
		
		// 28
		protected void doROppositeDomainVarsToTraceClassProps(@NonNull Set<@NonNull Variable> domainVars) {			
			// check
			for (@NonNull Variable dv : domainVars) {
				if (qvtr2qvtc.getTemplateExpression(dv) != null) {
					// init
					PropertyAssignment a = qvtr2qvtc.createPropertyAssignment();
					VariableExp ve1 = qvtr2qvtc.createVariableExp();
					VariableExp ve2 = qvtr2qvtc.createVariableExp();
					// where
					@NonNull Variable mdv = doRVarToMVar(dv);
					// assign
					ve1.setReferredVariable(tcv);
					ve1.setType(tcv.getType());
					a.setSlotExpression(ve1);
					@NonNull Property tp = getProperty(tcv.getType(), dv.getName());
					a.setTargetProperty(tp);
					ve2.setReferredVariable(mdv);
					ve2.setType(mdv.getType());
					a.setValue(ve2);
					mb.getAssignment().add(a);
				}
			}
			
		}	

		// 31
		/**
		 * Transform a rule implemented by a black box into an enforcement operation
		 *
		 * @param r the r
		 * @param rd the rd
		 * @param mb the mb
		 */
		protected void doRRelImplToMBottomEnforcementOperation() {
			
			// TODO Code this when testing transformations with operational implementations.
			
		}
		
		// 38
		protected void doRWhenPatternToMGuardPattern() {			
			// check
			Pattern whenp = r.getWhen();
			if (whenp != null) {
				Set<@NonNull Variable> whenVars = new HashSet<@NonNull Variable>(ClassUtil.nullFree(whenp.getBindsTo()));
				// where
				Set<@NonNull Variable> allDomainVars = getAllDomainVars(r);
				Set<@NonNull Variable> unsharedWhenVars = new HashSet<@NonNull Variable>(whenVars);
				unsharedWhenVars.removeAll(allDomainVars);
				doRWhenRelCallToMGuard(whenp);
				doRSimplePatternToMPattern(whenp);
				//doUnsharedWhenVarsToMgVars(unsharedWhenVars, mg);
				doRVarSetToDGVarSet(new ArrayList<@NonNull Variable>(unsharedWhenVars), mg);
			}
		}

		protected @NonNull Set<@NonNull Variable> getOppositeDomainVars() {
			Set<@NonNull Variable> oppositeDomainVars = new HashSet<@NonNull Variable>();
			for (Domain d : ClassUtil.nullFree(rOppositeDomains)) {
				for (DomainPattern pattern : ClassUtil.nullFree(((RelationDomain) d).getPattern())) {
					oppositeDomainVars.addAll(ClassUtil.nullFree(pattern.getBindsTo()));
				}
			}
			return oppositeDomainVars;
		}

		protected void setAttributes() {
			mb.getRealizedVariable().add(tcv);
			//mb.getVariable().addAll(mbvars);
			md.setTypedModel(mdir);
			md.setIsEnforceable(true);
		}
		
		protected abstract void where(@NonNull Set<@NonNull Variable> whenVars, @NonNull Set<@NonNull Predicate> rpSet,
				@NonNull Set<@NonNull Variable> sharedDomainVars, @NonNull Set<@NonNull Variable> unsharedWhereVars);
	}

	protected @NonNull final QVTrToQVTc qvtr2qvtc;

	protected AbstractQVTr2QVTcRelations(@NonNull QVTrToQVTc qvtr2qvtc) {
		this.qvtr2qvtc = qvtr2qvtc;
	}
	
	// 33
	protected void doRVarSetToDGVarSet(@NonNull ArrayList<@NonNull Variable> rvSeq, @NonNull GuardPattern dg) {
		for (@NonNull Variable rv : rvSeq) {
			qvtr2qvtc.whenVariable(dg, rv);
		}
	}
	
	protected @NonNull Variable doRVarToMVar(@NonNull Variable rv) {
		return qvtr2qvtc.getCoreVariable(rv);
	}
	
	// 39
	private void doRWhenRelCallArgToMGuardPredicate(@NonNull Relation r, @NonNull VariableExp ve,
			@NonNull RelationDomain d, @NonNull GuardPattern mg, @NonNull String vdId) {
		// when
		@NonNull Type tc = qvtr2qvtc.getTraceClass(r);
		// check
		String dvn = ClassUtil.nonNullState(d.getRootVariable().get(0).getName());
		Variable v = (Variable) ClassUtil.nonNullState(ve.getReferredVariable());
		// init
		Variable vd = qvtr2qvtc.whenVariable(mg, tc.getName()+vdId+"_v", tc);
		Predicate mgp = qvtr2qvtc.createPredicate();
		OperationCallExp ee = qvtr2qvtc.createOperationCallExp();
		PropertyCallExp pe = qvtr2qvtc.createPropertyCallExp();
		VariableExp pve = qvtr2qvtc.createVariableExp();
		VariableExp ave = qvtr2qvtc.createVariableExp();
		// where
		@NonNull Variable mv = doRVarToMVar(v);
		// assign
		mgp.setConditionExpression(ee);
		ee.setOwnedSource(pe);
		pe.setOwnedSource(pve);
		pve.setReferredVariable(vd);
		pve.setType(vd.getType());
		@NonNull Property pep = getProperty(vd.getType(), dvn);
		pe.setReferredProperty(pep);
		pe.setType(pep.getType());
		ee.setReferredOperation(getEqualsOperation());
		ee.setType(qvtr2qvtc.getStandardLibrary().getBooleanType());
		ave.setReferredVariable(mv);
		ave.setType(mv.getType());
		ee.getOwnedArguments().add(ave);
		
		mg.getPredicate().add(mgp);
		
	}
	
	/* =============  Helpers ============= */
	protected @NonNull Set<@NonNull Predicate> filterOutPredicatesThatReferToVars(@NonNull Set<@NonNull Predicate> rpSet,
			@NonNull Set<@NonNull Variable> ownrdVars) {
		
		Set<@NonNull Predicate> fpSet = new HashSet<@NonNull Predicate>();
		for (Predicate p : rpSet) {
			OCLExpression conditionExpression = p.getConditionExpression();
			assert conditionExpression != null;
			Set<@NonNull Variable> vs = qvtr2qvtc.getVarsOfExp(conditionExpression);
			vs.retainAll(ownrdVars);
			if (vs.isEmpty()) {
				fpSet.add(p);
			}
		}
		return fpSet;
	}
	
	protected @NonNull Set<@NonNull Variable> getAllDomainVars(@NonNull Relation r) {
		Set<@NonNull Variable> allDomainVars = new HashSet<@NonNull Variable>();
		for (Domain d : ClassUtil.nullFree(r.getDomain())) {
			DomainPattern domainPattern = qvtr2qvtc.getDomainPattern(d);
			allDomainVars.addAll(ClassUtil.nullFree(domainPattern.getBindsTo()));
		}
		return allDomainVars;
	}

	protected @NonNull TypedModel getCoreTypedModel(@NonNull Transformation mt, @NonNull String name, @NonNull List<@NonNull Package> usedPackages) {
		for (TypedModel tm : mt.getModelParameter()) {
			if (name.equals(tm.getName())) {
				assert tm.getUsedPackage().equals(usedPackages);
				return tm;
			}
		}
		return ClassUtil.nonNullState(null);
	}
	
	protected @NonNull Operation getEqualsOperation() {
		for (Operation o : qvtr2qvtc.getStandardLibrary().getOclAnyType().getOwnedOperations()) {
			if (o.getName().equals("=")) {
				return o;
			}
		}
		throw new IllegalStateException("No = operation");
	}

	protected @NonNull List<@NonNull RelationDomain> getOppositeDomains(@NonNull RelationDomain rd) {
		List<@NonNull RelationDomain> rOppositeDomains = new ArrayList<@NonNull RelationDomain>();
		for (Domain d : rd.getRule().getDomain()) {
			if (d instanceof RelationDomain) {
				rOppositeDomains.add((RelationDomain)d);
			}
		}
		rOppositeDomains.remove(rd);
		return rOppositeDomains;
	}

	protected @NonNull Set<@NonNull Predicate> getPredicates(@NonNull Relation r) {
		Set<@NonNull Predicate> rpSet = new HashSet<@NonNull Predicate>();
		Pattern rWhere = r.getWhere();
		if (rWhere != null) {
			rpSet.addAll(rejectRelationCallPredicates(ClassUtil.nullFree(rWhere.getPredicate())));
		}
		return rpSet;
	}

	protected @NonNull Property getProperty(/*@NonNull*/ Type traceClass, /*@NonNull*/ String name) {
		assert (traceClass != null) && (name != null);
		if (traceClass instanceof org.eclipse.ocl.pivot.Class) {
			for (Property p : ((org.eclipse.ocl.pivot.Class)traceClass).getOwnedProperties()) {
				if (name.equals(p.getName()))
					return p;
			}
		}
		return ClassUtil.nonNullState(null);
	}

	protected @NonNull Set<@NonNull Variable> getUnsharedWhenVars(@NonNull Set<@NonNull Variable> whenVars, @NonNull Set<@NonNull Variable> allDomainVars) {
		Set<@NonNull Variable> unsharedWhereVars = new HashSet<@NonNull Variable>(whenVars);
		unsharedWhereVars.removeAll(allDomainVars);
		return unsharedWhereVars;
	}

	protected @NonNull Set<@NonNull Variable> getUnsharedWhereVars(@NonNull Set<@NonNull Variable> whereVars,
			@NonNull Set<@NonNull Variable> whenVars, @NonNull Set<@NonNull Variable> sharedDomainVars, @NonNull Set<@NonNull Variable> allDomainVars) {
		Set<@NonNull Variable> unsharedWhereVars = new HashSet<@NonNull Variable>(whereVars);
		unsharedWhereVars.removeAll(whenVars);
		unsharedWhereVars.removeAll(allDomainVars);
		unsharedWhereVars.addAll(sharedDomainVars);
		return unsharedWhereVars;
	}

	protected @NonNull Set<@NonNull Variable> getWhenVars(@NonNull Relation r) {
		Set<@NonNull Variable> whenVars = new HashSet<@NonNull Variable>();
		Pattern rWhen = r.getWhen();
		if (rWhen != null) {
			whenVars.addAll(ClassUtil.nullFree(rWhen.getBindsTo()));
		}
		return whenVars;
	}

	protected @NonNull Set<@NonNull Variable> getWhereVars(@NonNull Relation r) {
		Set<@NonNull Variable> whereVars = new HashSet<@NonNull Variable>();
		Pattern rWhere = r.getWhere();
		if (rWhere != null) {
			whereVars.addAll(ClassUtil.nullFree(rWhere.getBindsTo()));
		}
		return whereVars;
	}
	
	private boolean isVarBoundToSomeOtherTemplate(ObjectTemplateExp rootTe, ObjectTemplateExp skipTe, Variable v) {	
		if (rootTe == skipTe) {
			return false;
		}
		if (rootTe.getBindsTo().equals(v)) {
			return true;
		} else {
			boolean exists = false;
			for (PropertyTemplateItem p : rootTe.getPart()) {
				if (p.getValue() instanceof ObjectTemplateExp) {
					exists |= isVarBoundToSomeOtherTemplate((ObjectTemplateExp) p.getValue(), skipTe, v);
				}
			}
			return exists;
		}	
	}
	
	protected @NonNull Set<@NonNull Predicate> rejectRelationCallPredicates(
			@NonNull List<@NonNull Predicate> predicates) {

		Set<@NonNull Predicate> rpSet = new HashSet<@NonNull Predicate>(predicates);
		Iterator<@NonNull Predicate> it = rpSet.iterator();
		while (it.hasNext()) {
			Predicate p = it.next();
			if (p.getConditionExpression() instanceof RelationCallExp) {
				it.remove();
			}
		}
		return rpSet;
	}

	protected void where(@NonNull Relation r, @NonNull List<@NonNull ? extends AbstractRelationDomain2CoreDomain> relation2mappings) {
		Set<@NonNull Variable> allDomainVars = getAllDomainVars(r);
		Set<@NonNull Variable> whenVars = getWhenVars(r);
		Set<@NonNull Variable> whereVars = getWhereVars(r);
		Set<@NonNull Predicate> rpSet = getPredicates(r);
		Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
		Set<@NonNull Variable> unsharedWhereVars = getUnsharedWhereVars(whereVars, whenVars, sharedDomainVars, allDomainVars);
//		Set<@NonNull Variable> unsharedWhenVars = getUnsharedWhenVars(whenVars, allDomainVars);
		for (AbstractRelationDomain2CoreDomain relation2mapping : relation2mappings) {
			relation2mapping.where(whenVars, rpSet, sharedDomainVars, unsharedWhereVars);
		}
		// setAttributes() {
		for (AbstractRelationDomain2CoreDomain relation2mapping : relation2mappings) {
			relation2mapping.setAttributes();
		}
	}
}
