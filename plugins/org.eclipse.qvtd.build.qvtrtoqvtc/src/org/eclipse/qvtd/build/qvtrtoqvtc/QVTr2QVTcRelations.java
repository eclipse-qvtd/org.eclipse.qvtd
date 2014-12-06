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
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
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
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
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
		} else if (e instanceof EnumLiteralExp) {
			
		} 
		else if (e instanceof ObjectTemplateExp) {
			ObjectTemplateExp te = (ObjectTemplateExp) e;
			vs.add(te.getBindsTo());
			for (PropertyTemplateItem p : te.getPart()) {
				vs.addAll(getVarsOfExp(p.getValue()));
			}
		} else if (e instanceof CollectionTemplateExp) {
			CollectionTemplateExp cte = (CollectionTemplateExp) e;
			if (cte.getRest() != null)
				vs.add(cte.getRest());
			for (OCLExpression m : cte.getMember())
				vs.addAll(getVarsOfExp(m));
		}
		else {
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
		// check
		Variable v = te.getBindsTo();
		Set<Variable> remainingUnBoundDomainVars = new HashSet<Variable>(unboundDomainVars);
		remainingUnBoundDomainVars.remove(v);
		Set<Predicate> predicatesWithVarBindings = filterOutPredicatesThatReferToVars(predicatesWithoutVarBindings, remainingUnBoundDomainVars);	
		Set<Predicate> remainingPredicatesWithoutVarBindings = new HashSet<Predicate>(predicatesWithoutVarBindings);
		remainingPredicatesWithoutVarBindings.removeAll(predicatesWithVarBindings);
		Area area = db.getArea();
		assert area instanceof CoreDomain : "Missing CoreDomain for RDomainToMDBottomForEnforcement";
		CoreDomain cd = (CoreDomain) area;
		Rule rule = cd.getRule();
		assert rule instanceof Mapping : "Missing Mapping for RDomainToMDBottomForEnforcement";
		Mapping m = (Mapping) rule;
		// init
		BottomPattern mb = transformation.findBottomPattern(m);
		
		//rtSeq = Sequence{r, te};
	    //rtdSeq = Sequence{r, te, rd};
	    //rdtVarsSeqRest = Sequence{rdtSet, remainingPredicatesWithoutVarBindings, remainingUnBoundDomainVars};
		
		// where
		doRDomainToMDBottomForEnforcementOfIdentityProp(r, te, db);
		//doRDomainToMDBottomForEnforcementOfNonIdentityPropObject(r, rd, te, remainingPredicatesWithoutVarBindings, remainingUnBoundDomainVars, m);		
		doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive(r, te, rd, m);
		
		// This call is wrong as the trace variable is realized, it can't be guarded.
		// This should only be done in a nested mapping or later mapping
		//doRDomainToMBottomPredicateForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);
		
		doRDomainVarToMDBottomAssignmnetForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);
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
			doUnsharedWhenVarsToMgVars(unsharedWhenVars, mg);
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
		pve.setReferredVariable(tcv);
		pve.setType(tcv.getType());
		pe.setSource(pve);
		Property pep = getProperty(v.getName(), tcv.getType());
		assert pep != null;
		pe.setReferredProperty(pep);
		pe.setType(pep.getType());
		ee.setSource(pe);
		ee.setReferredOperation(getEqualsOPeration());
		ee.setType(transformation.getMetaModelManager().getBooleanType());
		ave.setReferredVariable(mv);
		ave.setType(mv.getType());
		ee.getArgument().add(ave);
		pd.setConditionExpression(ee);
		mb.getPredicate().add(pd);
	}
	
	// 18
	/*
	 * Creates Assignments for each part of the ObjectTemplateExp
	 */
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
	private void doUnsharedWhenVarsToMgVars(@NonNull Set<Variable> unsharedWhenVars,
			@NonNull GuardPattern mg) {
		
		List<Variable> mgVars = doRVarSetToMVarSet(new ArrayList<Variable>(unsharedWhenVars));
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
			Variable rev = (Variable) ((VariableExp)e).getReferredVariable();
			assert rev != null;
			// init
			PropertyAssignment a = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			VariableExp ve = PivotFactory.eINSTANCE.createVariableExp();
			VariableExp me = PivotFactory.eINSTANCE.createVariableExp();
			// where
			RealizedVariable mv = doRVarToMRealizedVar(v);
			Variable mev = doRVarToMVar(rev);
			// assign
			ve.setReferredVariable(mv);
			ve.setType(mv.getType());
			a.setSlotExpression(ve);
			Property tp = getProperty(pn, mv.getType());
			a.setTargetProperty(tp);
			me.setReferredVariable(mev);
			me.setType(mev.getType());
			a.setValue(me);
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
			// where
			Variable mv = doRVarToMVar(v);
			OCLExpression me = doRExpToMExp(e);
			// assign
			a.setSlotExpression(ve);
			ve.setReferredVariable(mv);
			ve.setType(mv.getType());
			Property tp = getProperty(pn, mv.getType()); 
			a.setTargetProperty(tp);
			a.setValue(me);
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
				Property tp = getProperty(pn, mv.getType());
				a.setTargetProperty(tp);
				me.setReferredVariable(mev);
				me.setType(mev.getType());
				a.setValue(me);
				db.getRealizedVariable().add(mv);
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
		if ((e instanceof VariableExp) && !sharedDomainVars.contains(((VariableExp)e).getReferredVariable()) ) {
			String pn = pp.getName();
			Variable rev = (Variable) ((VariableExp) e).getReferredVariable();
			assert rev != null;
			// init
			PropertyAssignment a = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			VariableExp ve = PivotFactory.eINSTANCE.createVariableExp();
			VariableExp me = PivotFactory.eINSTANCE.createVariableExp();
			// where
			RealizedVariable mv = doRVarToMRealizedVar(v);
			Variable mev = doRVarToMVar(rev);
			// assign
			ve.setReferredVariable(mv);
			ve.setType(mv.getType());
			a.setSlotExpression(ve);
			Property tp = getProperty(pn, mv.getType());
			a.setTargetProperty(tp);
			me.setReferredVariable(mev);
			me.setType(mev.getType());
			a.setValue(me);
			
			db.getRealizedVariable().add(mv);
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
		// check
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
				PropertyAssignment a = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
				VariableExp ve = PivotFactory.eINSTANCE.createVariableExp();
				// where
				Variable mv = doRVarToMVar(v);
				OCLExpression me = doRExpToMExp(e);
				// where
				doRDomainToMComposedMappingGuard(r, te, rd, e, cm);
				// assign
				ve.setReferredVariable(mv);
				ve.setType(mv.getType());
				a.setSlotExpression(ve);
				Property tp = getProperty(pn, mv.getType());
				a.setTargetProperty(tp);
				a.setValue(me);
				
				bp.getAssignment().add(a);
			}
		}
	}
	
	// 23
	/*
	 * Creates the assignment of the middle model to the L/R models
	 */
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
		ve1.setReferredVariable(tcv);
		ve1.setType(tcv.getType());
		a.setSlotExpression(ve1);
		Property tp = getProperty(v.getName(), tcv.getType());
		assert tp != null;
		a.setTargetProperty(tp);
		ve2.setReferredVariable(mv);
		ve2.setType(mv.getType());
		a.setValue(ve2);
		
		mb.getRealizedVariable().add(tcv);
		mb.getAssignment().add(a);
	}
	
	// 29
	public void doRPredicateSetToMBPredicateSet(@NonNull ArrayList<Predicate> predSeq, @NonNull BottomPattern mb) {
		
		// check
		if(predSeq.isEmpty()) {
			return;
		}
		Predicate rp = predSeq.remove(0);
		OCLExpression re = rp.getConditionExpression();
		assert re != null;
		// init
		Predicate mp = QVTbaseFactory.eINSTANCE.createPredicate();
		// when
		OCLExpression me = doRExpToMExp(re);
		doRPredicateSetToMBPredicateSet(predSeq, mb);
		// assign
		mp.setConditionExpression(me);
		mb.getPredicate().add(mp);
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
	
	private Property getProperty(String name, Type owningType) {
		
		for (Property p : owningType.getOwnedAttribute()) {
			if (p.getName().equals(name))
				return p;
		}
		return null;
	}

	

}
