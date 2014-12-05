/*******************************************************************************
 * Copyright (c) 2014 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.OCLExpCopy;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationToTraceClass;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationalTransformationToMappingTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RuleBindings;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class QVTr2QVTcRelations {
	
	@NonNull private final QvtrToQvtcTransformation transformation;
	

	public QVTr2QVTcRelations(@NonNull QvtrToQvtcTransformation transformation) {
		this.transformation = transformation;
	}
	
	/* =============  Queries ============= */
	// TODO bug 453863
	public Set<Variable> getSharedDomainVars(Relation r) {
		
		Set<Variable> vars = new HashSet<Variable>();
		for (Domain d : r.getDomain()) {
			if (((RelationDomain) d).getPattern() != null) {
				if (vars.isEmpty()) {
					vars.addAll(((RelationDomain) d).getPattern().getBindsTo());
				} else {
					List<Variable> bt = ((RelationDomain) d).getPattern().getBindsTo(); 
					vars.retainAll(bt);
				}
			}
		}
		return vars;
	}
	
	/*
	 * Get variables occurring in an OCL expression
	 */
	// FIXME this function is not complete! It needs to be completed for other 
	// type of expressions
	public Set<Variable> getVarsOfExp(OCLExpression e) {
		
		Set<Variable> vs = new HashSet<Variable>();
		if (e instanceof VariableExp) {
			vs.add((Variable) ((VariableExp) e).getReferredVariable());
		} else if (e instanceof OperationCallExp) {
			OperationCallExp oc = (OperationCallExp) e;
			vs.addAll(getVarsOfExp(oc.getSource()));
			for (OCLExpression a : oc.getArgument()) {
				vs.addAll(getVarsOfExp(a));
			}
		} else if (e instanceof PropertyCallExp) {
			vs.addAll(getVarsOfExp( ((PropertyCallExp) e).getSource()));
		} else if (e instanceof RelationCallExp) {
			RelationCallExp rc = (RelationCallExp) e;
			for (OCLExpression a : rc.getArgument()) {
				vs.addAll(getVarsOfExp(a));
			}
		} else {
			assert false : "getVarsOfExp() missing case for " + e.eClass().getName();
		}
		return vs;
	}
	
	public @NonNull Set<Predicate> filterOutPredicatesThatReferToVars(@NonNull Set<Predicate> rpSet,
			@NonNull Set<Variable> ownrdVars) {
		
		Set<Predicate> fpSet = new HashSet<Predicate>();
		for (Predicate p : rpSet) {
			Set<Variable> vs = getVarsOfExp(p.getConditionExpression());
			vs.retainAll(ownrdVars);
			if (vs.isEmpty()) {
				fpSet.add(p);
			}
		}
		return fpSet;
	}
	
	/* =============  T3 ============= */
	
	// 17
	public void doRDomainToMDBottomForEnforcement(@NonNull Relation r, @NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, @NonNull Set<Variable> unboundDomainVars, @NonNull BottomPattern db)
	{
		// NOT-USED   tcv, mv: essentialocl::Variable;
		//
		//	Check
		//
		Variable v = te.getBindsTo();
		//
		//	Post-Check
		//
		Set<Variable> remainingUnBoundDomainVars = new HashSet<Variable>(unboundDomainVars);
		remainingUnBoundDomainVars.remove(v);
		//
		Set<Predicate> predicatesWithVarBindings = filterOutPredicatesThatReferToVars(predicatesWithoutVarBindings, remainingUnBoundDomainVars);	
		Set<Predicate> remainingPredicatesWithoutVarBindings = new HashSet<Predicate>(predicatesWithoutVarBindings);
		remainingPredicatesWithoutVarBindings.removeAll(predicatesWithVarBindings);
		//
		//	Enforce-Check
		//
		Area area = db.getArea();
		assert area instanceof CoreDomain : "Missing CoreDomain for RDomainToMDBottomForEnforcement";
		CoreDomain cd = (CoreDomain) area;
		Rule rule = cd.getRule();
		assert rule instanceof Mapping : "Missing Mapping for RDomainToMDBottomForEnforcement";
		Mapping m = (Mapping) rule;
		//
		//	Enforce-Create
		//
		//BottomPattern mb = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		BottomPattern mb = transformation.findBottomPattern(m);
		//
		//	then-where
		//
		doRDomainToMDBottomForEnforcementOfIdentityProp(r, te, db);
		
		doRDomainVarToMDBottomAssignmnetForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);
		doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive(r, te, rd, m);
		//doRDomainToMDBottomForEnforcementOfNonIdentityPropObject(r, rd, te, remainingPredicatesWithoutVarBindings, remainingUnBoundDomainVars, m);
		doRDomainToMBottomPredicateForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);
	}
		
	// 38
	public void doRWhenPatternToMGuardPattern(@NonNull Relation r, @NonNull GuardPattern mg) {
		
		// check
		Pattern whenp = r.getWhen();
		if (whenp != null) {
			Set<Variable> whenVars = new HashSet<Variable>(whenp.getBindsTo());
			// where
			Set<Variable> allDomainVars = getAllDomainVars(r);
			Set<Variable> unsharedWhenVars = new HashSet<Variable>(whenVars);
			unsharedWhenVars.removeAll(allDomainVars);
			doRWhenRelCallToMGuard(whenp, mg);
			doRSimplePatternToMPattern(whenp, mg);
			doUnsharedWhenVarsToMgVars(new ArrayList<Variable>(unsharedWhenVars), mg);
		}
	}
	
	/* =============  T4 ============= */
	
	// 2
	public void doDomainVarsSharedWithWhenToDgVars (@NonNull Set<Variable> domainVarsSharedWithWhen, @NonNull GuardPattern dg) {
		
		List<Variable> dbVars = doRVarSetToMVarSet(new ArrayList<Variable>(domainVarsSharedWithWhen));
		dg.getBindsTo().addAll(dbVars);

	}
	
	// 15
	public void doRDomainToMBottomPredicateForEnforcement(@NonNull Relation r, @NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, @NonNull Set<Variable> unboundDomainVars,
			@NonNull BottomPattern mb)
	{
		// check
		Variable v = te.getBindsTo();
		assert v != null;
		// init
		Predicate pd = QVTbaseFactory.eINSTANCE.createPredicate();
		OperationCallExp ee = PivotFactory.eINSTANCE.createOperationCallExp();
		PropertyCallExp pe = PivotFactory.eINSTANCE.createPropertyCallExp();
		VariableExp pve = PivotFactory.eINSTANCE.createVariableExp();
		VariableExp ave = PivotFactory.eINSTANCE.createVariableExp();
		// where
		RealizedVariable tcv = doRelationDomainToTraceClassVar(r, rd);
		Variable mv = doRVarToMVar(v);
		Set<Variable> remainingUnBoundDomainVars = new HashSet<Variable>(unboundDomainVars);
		remainingUnBoundDomainVars.remove(v);
		Set<Predicate> predicatesWithVarBindings = filterOutPredicatesThatReferToVars(predicatesWithoutVarBindings, remainingUnBoundDomainVars);
		
		doRPredicateSetToMBPredicateSet(new ArrayList<Predicate>(predicatesWithVarBindings), mb);
		// assign
		pd.setConditionExpression(ee);
		ee.setSource(pe);
		pe.setSource(pve);
		pve.setReferredVariable(tcv);
		pve.setType(tcv.getType());
		Property pep = transformation.findProperty(v.getName(), tcv.getType());
		assert pep != null;
		pe.setReferredProperty(pep);
		pe.setType(pep.getType());
		ee.setReferredOperation(getEqualsOPeration());
		ee.setType(transformation.getMetaModelManager().getBooleanType());
		ee.getArgument().add(ave);
		ave.setReferredVariable(mv);
		ave.setType(mv.getType());
		
		mb.getBindsTo().add(tcv);
		mb.getRealizedVariable().add(tcv);
		mb.getBindsTo().add(mv);
		mb.getPredicate().add(pd);
	}
	
	// 18
	public void doRDomainToMDBottomForEnforcementOfIdentityProp(@NonNull Relation r, @NonNull ObjectTemplateExp te, @NonNull BottomPattern db)
	{
		// check
		final Variable v = te.getBindsTo();
		assert v != null;
		Area area = db.getArea();
		assert area instanceof CoreDomain : "Missing CoreDomain for RDomainToMDBottomForEnforcement";
		CoreDomain cd = (CoreDomain) area;
		Rule rule = cd.getRule();
		assert rule instanceof Mapping : "Missing Mapping for RDomainToMDBottomForEnforcement";
		Mapping m = (Mapping) rule;
		BottomPattern mb = transformation.findBottomPattern(m);
		assert mb != null;
		for (PropertyTemplateItem pt : te.getPart()) {
			final Property pp = pt.getReferredProperty();
			// check relations
			if (transformation.getKeyforClass().getPart().contains(pp)) {
				final OCLExpression e = pt.getValue();
				assert (pp != null) && (e != null);
				doRDomainPatternExprToMappingDomainAssignment(v, pp, e, db);
				doRDomainPatternExprToMappingDomainVarAssignment(r, v, pp, e, db);
				doRDomainPatternExprToMappingDomainTemplateVarAssignment(r, v, pp, e, db);
			    doRDomainPatternExprToMappingBottomVarAssignment(r, v, pp, e, mb);
			}
			
		}
	}
	
	// 20
	public void doRDomainToMDBottomForEnforcementOfNonIdentityPropObject(@NonNull Relation r, @NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, @NonNull Set<Variable> unboundDomainVars, @NonNull Mapping m)
	{
		// check
		// FIXME not c.key.part->includes(pp)
		// when
		RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
		assert rt != null;
		RelationalTransformationToMappingTransformation whenRule = new RelationalTransformationToMappingTransformation(transformation, rt);
		RuleBindings whenBindings = whenRule.getRuleBindings();
		whenRule = (RelationalTransformationToMappingTransformation) transformation.getRecord(whenBindings);
		Transformation mt = null;
		if (whenRule != null && whenRule.hasExecuted()) {
			mt = whenRule.getCore();
		}
		assert mt != null;
		// TODO Finish when clear about if the call should be uncommented
		// ...
	}
	
	// 32
	private void doRSimplePatternToMPattern(Pattern rp, Pattern mp) {
		for (Predicate pd : rp.getPredicate()) {
			// check
			OCLExpression ce = pd.getConditionExpression();
			assert ce != null;
			if (!(ce instanceof RelationCallExp)) {
				Predicate mpd = QVTbaseFactory.eINSTANCE.createPredicate();
				OCLExpression me = doRExpToMExp(ce);
				mpd.setConditionExpression(me);
			}
		}
	}
	
	// 40
	public void doRWhenRelCallToMGuard(@NonNull Pattern rp, @NonNull GuardPattern mp) {
		
		for (Predicate p : rp.getPredicate()) {
			// check
			if (p.getConditionExpression() instanceof RelationCallExp) {
				RelationCallExp e = (RelationCallExp) p.getConditionExpression();
				Relation r = e.getReferredRelation();
				List<Domain> dseq = new ArrayList<Domain>(r.getDomain());
				// where
				for (OCLExpression arg : e.getArgument()) {
					VariableExp a = (VariableExp) arg;
					RelationDomain rd = (RelationDomain) dseq.get(e.getArgument().indexOf(a));
					assert (a != null) && (rd != null);
					doRWhenRelCallArgToMGuardPredicate(r, a, rd, mp);
				}
			}
		}
	}
		
	// 50
	private void doUnsharedWhenVarsToMgVars(@NonNull ArrayList<Variable> unsharedWhenVars,
			@NonNull GuardPattern mg) {
		
		List<Variable> mgVars = doRVarSetToMVarSet(unsharedWhenVars);
		mg.getBindsTo().addAll(mgVars);
	}
	
	
	/* =============  T5 ============= */
	
	// 6
	private void doRDomainPatternExprToMappingBottomVarAssignment(@NonNull Relation r,
			@NonNull Variable v, @NonNull Property pp, 
			@NonNull OCLExpression e, @NonNull BottomPattern mb) {

		// when
		Set<Variable> sharedDomainVars = getSharedDomainVars(r);
		// check
		if ((e instanceof VariableExp) && sharedDomainVars.contains(((VariableExp)e).getReferredVariable()) ) {
			String pn = pp.getName();
			// init
			PropertyAssignment a = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			VariableExp ve = PivotFactory.eINSTANCE.createVariableExp();
			VariableExp me = PivotFactory.eINSTANCE.createVariableExp();
			RealizedVariable mv = doRVarToMRealizedVar(v);
			Variable mev = doRVarToMVar(v);
			// assign
			ve.setReferredVariable(mv);
			ve.setType(mv.getType());
			a.setSlotExpression(ve);
			for (Property tp : mv.getType().getOwnedAttribute()) {
				if (tp.getName() == pn) {
					a.setTargetProperty(tp);
					break;
				}
			}
			me.setReferredVariable(mev);
			me.setType(mev.getType());
			a.setValue(me);
			
			mb.getBindsTo().add(mv);
			mb.getRealizedVariable().add(mv);
			mb.getBindsTo().add(mev);
			mb.getAssignment().add(a);
		}
		
	}
	
	// 7
	private void doRDomainPatternExprToMappingDomainAssignment(@NonNull Variable v,
			@NonNull Property pp, @NonNull OCLExpression e,
			@NonNull BottomPattern db) {
		
		// check
		if (!(e instanceof VariableExp) &&  !(e instanceof ObjectTemplateExp)) {
			String pn = pp.getName();
			// init
			PropertyAssignment a = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			VariableExp ve = PivotFactory.eINSTANCE.createVariableExp();
			Variable mv = doRVarToMVar(v);
			OCLExpression me = doRExpToMExp(e);
			// assign
			ve.setReferredVariable(mv);
			ve.setType(mv.getType());
			a.setSlotExpression(ve);
			for (Property tp : mv.getType().getOwnedAttribute()) {
				if (tp.getName() == pn) {
					a.setTargetProperty(tp);
					break;
				}
			}
			a.setValue(me);
			
			db.getBindsTo().add(mv);
			db.getAssignment().add(a);
		}
		
	}
		
	// 8
	private void doRDomainPatternExprToMappingDomainTemplateVarAssignment(
			@NonNull Relation r, @NonNull Variable v,
			@NonNull Property pp, @NonNull OCLExpression e,
			@NonNull BottomPattern db) {
		
		// when 
		Set<Variable> sharedDomainVars = getSharedDomainVars(r);
		// check
		if (e instanceof ObjectTemplateExp) {
			final Variable rev = ((ObjectTemplateExp)e).getBindsTo();
			assert rev != null;
			if (!sharedDomainVars.contains(rev)) {
				String pn = pp.getName();
				// init
				PropertyAssignment a = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
				VariableExp ve = PivotFactory.eINSTANCE.createVariableExp();
				VariableExp me = PivotFactory.eINSTANCE.createVariableExp();
				RealizedVariable mv = doRVarToMRealizedVar(v);
				Variable mev = doRVarToMVar(rev);
				// assign
				ve.setReferredVariable(mv);
				ve.setType(mv.getType());
				a.setSlotExpression(ve);
				for (Property tp : mv.getType().getOwnedAttribute()) {
					if (tp.getName() == pn) {
						a.setTargetProperty(tp);
						break;
					}
				}
				me.setReferredVariable(mev);
				me.setType(mev.getType());
				a.setValue(me);
				
				db.getBindsTo().add(mv);
				db.getRealizedVariable().add(mv);
				db.getBindsTo().add(mv);
				db.getAssignment().add(a);
			}
		}
	}
		
	// 9
	private void doRDomainPatternExprToMappingDomainVarAssignment(@NonNull Relation r,
			@NonNull Variable v, @NonNull Property pp,
			@NonNull OCLExpression e, @NonNull BottomPattern db) {
		
		// when
		Set<Variable> sharedDomainVars = getSharedDomainVars(r);
		// check
		if ((e instanceof VariableExp) && sharedDomainVars.contains(((VariableExp)e).getReferredVariable()) ) {
			String pn = pp.getName();
			// init
			PropertyAssignment a = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			VariableExp ve = PivotFactory.eINSTANCE.createVariableExp();
			VariableExp me = PivotFactory.eINSTANCE.createVariableExp();
			RealizedVariable mv = doRVarToMRealizedVar(v);
			Variable mev = doRVarToMVar(v);
			// assign
			ve.setReferredVariable(mv);
			ve.setType(mv.getType());
			a.setSlotExpression(ve);
			for (Property tp : mv.getType().getOwnedAttribute()) {
				if (tp.getName() == pn) {
					a.setTargetProperty(tp);
					break;
				}
			}
			me.setReferredVariable(mev);
			me.setType(mev.getType());
			a.setValue(me);
			
			db.getBindsTo().add(mv);
			db.getRealizedVariable().add(mv);
			db.getBindsTo().add(mev);
			db.getAssignment().add(a);
		}
	}
		
	// 16
	private void doRDomainToMComposedMappingGuard(Relation r,
			ObjectTemplateExp te, RelationDomain rd, OCLExpression e, Mapping cm) {
		// TODO Auto-generated method stub
		
	}

	
	// 21
	public void doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive(@NonNull Relation r, @NonNull ObjectTemplateExp te, @NonNull RelationDomain rd,
			@NonNull Mapping m)
	{
		// check
		RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
		assert rt != null;
		RelationalTransformationToMappingTransformation whenRule = new RelationalTransformationToMappingTransformation(transformation, rt);
		RuleBindings whenBindings = whenRule.getRuleBindings();
		whenRule = (RelationalTransformationToMappingTransformation) transformation.getRecord(whenBindings);
		Transformation mt = null;
		if (whenRule != null && whenRule.hasExecuted()) {
			mt = whenRule.getCore();
		}
		assert mt != null;
		for (PropertyTemplateItem pt : te.getPart()) {
			final OCLExpression e = pt.getValue();
			Property pp = pt.getReferredProperty();
			assert e != null;
			if (!(transformation.getKeyforClass().getPart().contains(pp)) && !(e instanceof TemplateExp)) {
				String pn = pp.getName();
				Variable v = te.getBindsTo();
				assert v != null;
				// init
				Mapping cm = transformation.findMapping(m.getName()+"_forNonIdentityProp", mt);
				BottomPattern bp = transformation.findBottomPattern(cm);
				Variable mv = doRVarToMVar(v);
				OCLExpression me = doRExpToMExp(e);
				PropertyAssignment a = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
				VariableExp ve = PivotFactory.eINSTANCE.createVariableExp();
				// assign
				ve.setReferredVariable(mv);
				ve.setType(mv.getType());
				a.setSlotExpression(ve);
				for (Property tp : mv.getType().getOwnedAttribute()) {
					if (tp.getName() == pn) {
						a.setTargetProperty(tp);
						break;
					}
				}
				a.setValue(me);
				
				bp.getBindsTo().add(mv);
				bp.getAssignment().add(a);
				// where
				doRDomainToMComposedMappingGuard(r, te, rd, e, cm);
				// TODO finish?
			}
		}
	}
	
	// 23
	public void doRDomainVarToMDBottomAssignmnetForEnforcement(@NonNull Relation r, @NonNull RelationDomain rd,
			@NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings,
			@NonNull Set<Variable> unboundDomainVars, @NonNull BottomPattern mb)
	{
		// check
		Variable v = te.getBindsTo();
		assert v != null;
		// init
		PropertyAssignment a = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
		VariableExp ve1 = PivotFactory.eINSTANCE.createVariableExp();
		VariableExp ve2 = PivotFactory.eINSTANCE.createVariableExp();
		// where
		RealizedVariable tcv = doRelationDomainToTraceClassVar(r, rd);
		Variable mv = doRVarToMVar(v);
		// assign
		a.setSlotExpression(ve1);
		ve1.setReferredVariable(tcv);
		ve1.setType(tcv.getType());
		Property tp = transformation.findProperty(v.getName(), tcv.getType());
		assert tp != null;
		a.setTargetProperty(tp);
		a.setValue(ve2);
		ve2.setReferredVariable(mv);
		ve2.setType(mv.getType());
		
		mb.getBindsTo().add(tcv);
		mb.getRealizedVariable().add(tcv);
		mb.getBindsTo().add(mv);
		mb.getAssignment().add(a);
	}
	
	// 29
	public void doRPredicateSetToMBPredicateSet(@NonNull ArrayList<Predicate> predSeq, @NonNull BottomPattern mb) {
		
		if(predSeq.isEmpty()) {
			return;
		}
		Predicate rp = predSeq.remove(0);
		OCLExpression re = rp.getConditionExpression();
		if (re != null) {
			OCLExpression me = doRExpToMExp(re);
			Predicate mp = QVTbaseFactory.eINSTANCE.createPredicate();
			mp.setConditionExpression(me);
			mb.getPredicate().add(mp);
		}
		doRPredicateSetToMBPredicateSet(predSeq, mb);
	}
	
	// 35
	public @NonNull List<Variable> doRVarSetToMVarSet(@NonNull ArrayList<Variable> rvSeq) {
		
		List<Variable> mvSet = new ArrayList<Variable>();
		if (!rvSeq.isEmpty()) {
			final Variable rv = rvSeq.remove(0);
			assert rv != null;
			Variable mv = doRVarToMVar(rv);
			mvSet.add(mv);
			mvSet.addAll(doRVarSetToMVarSet(rvSeq));
		}
		return mvSet;
	}
	
	// 39
	private void doRWhenRelCallArgToMGuardPredicate(@NonNull Relation r, @NonNull VariableExp ve,
			@NonNull RelationDomain d, @NonNull GuardPattern mg) {
		// When
		RelationToTraceClass whenRule = new RelationToTraceClass(transformation, r);
		RuleBindings whenBindings = whenRule.getRuleBindings();
		whenRule = (RelationToTraceClass) transformation.getRecord(whenBindings);
		Type tc = null;
		if (whenRule != null && whenRule.hasExecuted()) {
			tc = (Type) whenRule.getCore();
		}
		assert tc != null;
		// check
		String dvn = d.getRootVariable().getName();
		Variable v = (Variable) ve.getReferredVariable();
		// init
		Variable vd = transformation.findVariable(tc.getName()+"_v", tc);
		Predicate mpd = QVTbaseFactory.eINSTANCE.createPredicate();
		OperationCallExp ee = PivotFactory.eINSTANCE.createOperationCallExp();
		PropertyCallExp pe = PivotFactory.eINSTANCE.createPropertyCallExp();
		VariableExp pve = PivotFactory.eINSTANCE.createVariableExp();
		VariableExp ave = PivotFactory.eINSTANCE.createVariableExp();
		// where
		assert v != null;
		Variable mv = doRVarToMVar(v);
		// assign
		mpd.setConditionExpression(ee);
		ee.setSource(pe);
		pe.setSource(pve);
		pve.setReferredVariable(vd);
		pve.setType(vd.getType());
		for (DomainProperty pep : tc.getLocalProperties()) {
			if ((pep.getName() == dvn) && (pep.getType() == vd.getType())) {
				pe.setReferredProperty((Property) pep);
				pe.setType(((Property) pep).getType());
			}
		}
		ee.setReferredOperation(getEqualsOPeration());
		ee.setType(transformation.getMetaModelManager().getBooleanType());
		ave.setReferredVariable(mv);
		ave.setType(mv.getType());
		ee.getArgument().add(ave);
		
		mg.getBindsTo().add(vd);
		mg.getBindsTo().add(mv);
		mg.getPredicate().add(mpd);
		
	}

	
	/* =============  T6 ============= */
	
	/*
	 * The issue with this method is that all variables should have been
	 * transformed so all variable references can be correctly pointed.
	 * However, if we call it after all variable modifying relations it
	 * should work.
	 */
	// 25
	public OCLExpression doRExpToMExp(@NonNull OCLExpression re) {
		OCLExpCopy oCLExpCopy = new OCLExpCopy(transformation);
		
		return (OCLExpression) oCLExpCopy.caseOCLExpression(re);
	}
	
	// 36
	public @NonNull RealizedVariable doRVarToMRealizedVar(@NonNull Variable rv) {
		
		RealizedVariable mv = transformation.findRealizedVariable(rv.getName(), rv.getType());
		transformation.putVariableTrace(rv, mv);
		return mv;
	}
		
	// 37
	public @NonNull Variable doRVarToMVar(@NonNull Variable rv) {

		Variable mv = transformation.findVariable(rv.getName(), rv.getType());
		transformation.putVariableTrace(rv, mv);
		return mv;
	}
	
	// 42
	public @NonNull RealizedVariable doRelationDomainToTraceClassVar(@NonNull Relation r,
			@NonNull RelationDomain d) {

		// check
		String rn = r.getName();
		assert rn != null;
		String dn = d.getName();
		assert dn != null;
		// when
		RelationToTraceClass whenRule = new RelationToTraceClass(transformation, r);
		RuleBindings whenBindings = whenRule.getRuleBindings();
		whenRule = (RelationToTraceClass) transformation.getRecord(whenBindings);
		Type tc = null;
		if (whenRule != null && whenRule.hasExecuted()) {
			tc = (Type) whenRule.getCore();
		}
		assert tc != null;
		RealizedVariable mv = transformation.findRealizedVariable(rn+"_"+dn+"_v", tc);
		return mv;
	}
	
	

	/* =============  Helpers ============= */

	public Set<Predicate> rejectRelationCallPredicates(
			@NonNull List<Predicate> predicates) {

		Set<Predicate> rpSet = new HashSet<Predicate>(predicates);
		Iterator<Predicate> it = rpSet.iterator();
		while (it.hasNext()) {
			Predicate p = it.next();
			if (p.getConditionExpression() instanceof RelationCallExp) {
				it.remove();
			}
		}
		return rpSet;
	}
	
	public Set<Variable> getAllDomainVars(@NonNull Relation r) {
		Set<Variable> allDomainVars = new HashSet<Variable>();
		for (Domain d : r.getDomain()) {
			if (((RelationDomain) d).getPattern() != null)
				allDomainVars.addAll(((RelationDomain) d).getPattern().getBindsTo());
		}
		return allDomainVars;
	}
	
	private Operation getEqualsOPeration() {
		Operation referredOperation = null;
		for (Operation o : transformation.getMetaModelManager().getOclAnyType().getOwnedOperation()) {
			if (o.getName().equals("=")) {
				referredOperation = o;
				break;
			}
		}
		return referredOperation;
	}

	

}
