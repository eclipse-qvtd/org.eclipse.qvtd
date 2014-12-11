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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Package;
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
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class QVTr2QVTcRelations {
	
	private @NonNull final QvtrToQvtcTransformation transformation;
	

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
	
	private boolean isVarBoundToSomeOtherTemplate(ObjectTemplateExp rootTe,
			ObjectTemplateExp skipTe, Variable v) {
		
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
	
	/* =============  T3 ============= */
	
	// 17
	public void doRDomainToMDBottomForEnforcement(@NonNull Relation r, 
			@NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, 
			@NonNull Set<Variable> unboundDomainVars, @NonNull BottomPattern db)
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
		BottomPattern mb = m.getBottomPattern();
		assert mb != null;
		// where
		doRDomainToMDBottomForEnforcementOfIdentityProp(r, te, db);
		doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive(r, te, rd, m);
		
		// This call is wrong as the trace variable is realized, it can't be guarded.
		// This should only be done in a nested mapping or later mapping
		//doRDomainToMBottomPredicateForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);		
		doRDomainVarToMDBottomAssignmnetForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);
	}

	// 31
	public void doRRelImplToMBottomEnforcementOperation(Relation r,
			RelationDomain rd, BottomPattern mb) {
		
		// TODO Only code this if we have rules with operational implementations.
		// Which RelToCore does not have
		
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
			//doUnsharedWhenVarsToMgVars(unsharedWhenVars, mg);
			doRVarSetToDGVarSet(new ArrayList<Variable>(unsharedWhenVars), mg);
		}
	}
	
	/* =============  T4 ============= */
	
	// 2
	/*public void doDomainVarsSharedWithWhenToDgVars(@NonNull Set<Variable> domainVarsSharedWithWhen, @NonNull GuardPattern dg) {
		
		List<Variable> dbVars = doRVarSetToMVarSet(new ArrayList<Variable>(domainVarsSharedWithWhen));
		dg.getBindsTo().addAll(dbVars);
	}*/
	
	// 10
	private void doRDomainPatternToMDBottomPattern(@NonNull Relation r,
			@NonNull ObjectTemplateExp te, @NonNull BottomPattern db) {
		
		CoreDomain cd = (CoreDomain) db.getArea();
		assert cd != null;
		Mapping m = (Mapping) cd.getRule();
		assert m != null;
		BottomPattern mb = m.getBottomPattern();
		assert mb != null;
		doRDomainPatternToMDBottomPatternComposite(r, te, db);
		doRDomainPatternToMDBottomPatternSimpleNonVarExpr(te, db);
	    doRDomainPatternToMDBottomPatternSimpleUnSharedVarExpr(r, te, db);
	    doRDomainPatternToMDBottomPatternSimpleSharedVarExpr(r, te, mb);
		
	}

	// 15
	/*
	 * Creates a Predicate, who's ConditionExpression is an
	 * OperationCallExp:
	 * 		trace.<v.name> = v;
	 * TODO Suggest better name: RDomainPatternVariableToTracePredicate?
	 */
	public void doRDomainToMBottomPredicateForEnforcement(@NonNull Relation r, 
			@NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, 
			@NonNull Set<Variable> unboundDomainVars,
			@NonNull BottomPattern mb)
	{
		// check
		Variable v = te.getBindsTo();
		assert v != null;
		// init
		Predicate pd = transformation.createPredicate();
		OperationCallExp ee = transformation.createOperationCallExp();
		PropertyCallExp pe = transformation.createPropertyCallExp();
		VariableExp pve = transformation.createVariableExp();
		VariableExp ave = transformation.createVariableExp();
		// where
		RealizedVariable tcv = doRelationDomainToTraceClassVar(r, rd, mb);
		Variable mv = doRVarToMVar(v);
		Set<Variable> remainingUnBoundDomainVars = new HashSet<Variable>(unboundDomainVars);
		remainingUnBoundDomainVars.remove(v);
		Set<Predicate> predicatesWithVarBindings = 
				filterOutPredicatesThatReferToVars(predicatesWithoutVarBindings, remainingUnBoundDomainVars);
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
			Key key = transformation.getKeyforType(c);
			assert key != null;
			if (key.getPart().contains(pp)) {
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
				Predicate mpd = transformation.createPredicate();
				OCLExpression me = doRExpToMExp(ce);
				assert me != null;
				mpd.setConditionExpression(me);
			}
		}
	}
	
	// 34	
	public void doRVarSetToMBVarSet(@NonNull ArrayList<Variable> rvSeq,
			@NonNull BottomPattern mb) {
		
		if (!rvSeq.isEmpty()) {
			// check
			Variable rv = rvSeq.remove(0);
			assert rv != null;
			// when
			Variable mv = doRVarToMVar(rv, mb);
			assert mv != null;
			doRVarSetToMBVarSet(rvSeq, mb);
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
	
	// 47
	public void doTROppositeDomainsToMappingForEnforcement(@NonNull Relation r,
			@NonNull RelationDomain rd, @NonNull Mapping m) {
		
		Set<RelationDomain> rds = new HashSet<RelationDomain>();
		for (Domain d : r.getDomain()) {
			rds.add((RelationDomain) d);
		}
		rds.remove(rd); // guard
		for (RelationDomain ord : rds) {
			// check
			DomainPattern dp = ord.getPattern();
			if (dp.getTemplateExpression() instanceof ObjectTemplateExp) {
				String dn = ord.getName();
				assert dn != null;
				TypedModel dir = ord.getTypedModel();
				String tmn = dir.getName();
				assert tmn != null;
				RelationalTransformation rt = (RelationalTransformation) dir.getTransformation();
				assert rt != null;
				List<Package> up = dir.getUsedPackage();
				boolean c = ord.isIsCheckable();
				List<Variable> domainVars = dp.getBindsTo();
				ObjectTemplateExp te = (ObjectTemplateExp) dp.getTemplateExpression();
				assert te != null;
				// init
				CoreDomain cd = transformation.findCoreDomain(dn, m);
				GuardPattern dg = transformation.findGuardPattern(cd);
				BottomPattern db = transformation.findBottomPattern(cd);
				BottomPattern mb = transformation.findBottomPattern(m);
				// where
				Set<Variable> whenVars = new HashSet<Variable>();
				if (r.getWhen() != null)
					whenVars.addAll(r.getWhen().getBindsTo());
				Set<Variable> domainTopVars = new HashSet<Variable>(domainVars);
				domainTopVars.retainAll(whenVars);
				Set<Variable> sharedDomainVars = getSharedDomainVars(r);
				Set<Variable> domainBottomUnSharedVars = new HashSet<Variable>(domainVars);
				domainBottomUnSharedVars.removeAll(whenVars);
				domainBottomUnSharedVars.removeAll(sharedDomainVars);
				Set<Variable> domainBottomSharedVars = new HashSet<Variable>(domainVars);
				domainBottomSharedVars.removeAll(whenVars);
				domainBottomSharedVars.retainAll(sharedDomainVars);
				RelationalTransformationToMappingTransformation whenRule = 
						new RelationalTransformationToMappingTransformation(transformation, rt); 
				RuleBindings whenBindings = whenRule.getRuleBindings();
				RelationalTransformationToMappingTransformation whenRuleRecord = (RelationalTransformationToMappingTransformation) transformation.getRecord(whenBindings);
				Transformation mt = null;
				if (whenRuleRecord != null && whenRuleRecord.hasExecuted()) {
					mt = (Transformation) whenRuleRecord.getCore();
				}
				assert mt != null;
				/*List<Variable> dgVars =*/ doRVarSetToDGVarSet(new ArrayList<Variable>(domainTopVars), dg);
				/*List<Variable> dbVars =*/ doRVarSetToMBVarSet(new ArrayList<Variable>(domainBottomUnSharedVars), db);
				doRVarSetToMBVarSet(new ArrayList<Variable>(domainBottomSharedVars), mb);
				doRDomainPatternToMDBottomPattern(r, te, db);
				// assign
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
				cd.setIsCheckable(c);
				cd.setIsEnforceable(false);
				cd.setGuardPattern(dg);
				m.setBottomPattern(mb);
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
			PropertyAssignment a = transformation.createPropertyAssignment();
			VariableExp ve = transformation.createVariableExp();
			VariableExp me = transformation.createVariableExp();
			// where
			RealizedVariable mv = doRVarToMRealizedVar(v);
			Variable mev = doRVarToMVar(rev);
			// assign
			ve.setReferredVariable(mv);
			ve.setType(mv.getType());
			a.setSlotExpression(ve);
			Property tp = getProperty(pn, mv.getType());
			assert tp != null;
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
			PropertyAssignment a = transformation.createPropertyAssignment();
			VariableExp ve = transformation.createVariableExp();
			// where
			Variable mv = doRVarToMVar(v);
			assert mv != null;
			OCLExpression me = doRExpToMExp(e);
			assert me != null;
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
				PropertyAssignment a = transformation.createPropertyAssignment();
				VariableExp ve = transformation.createVariableExp();
				VariableExp me = transformation.createVariableExp();
				RealizedVariable mv = doRVarToMRealizedVar(v);
				Variable mev = doRVarToMVar(rev);
				// assign
				ve.setReferredVariable(mv);
				ve.setType(mv.getType());
				a.setSlotExpression(ve);
				Property tp = getProperty(pn, mv.getType());
				assert tp != null;
				a.setTargetProperty(tp);
				me.setReferredVariable(mev);
				me.setType(mev.getType());
				a.setValue(me);
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
			PropertyAssignment a = transformation.createPropertyAssignment();
			VariableExp ve = transformation.createVariableExp();
			VariableExp me = transformation.createVariableExp();
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
	
	// 11
	/*
	 * Recursively create an assignment for each ObjectTemplateExp
	 */
	private void doRDomainPatternToMDBottomPatternComposite(@NonNull Relation r,
			@NonNull ObjectTemplateExp te, @NonNull BottomPattern db) {
		
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
				PropertyAssignment a = transformation.createPropertyAssignment();
				VariableExp ve1 = transformation.createVariableExp();
				VariableExp ve2 = transformation.createVariableExp();
				// where
				Variable mvte = doRVarToMVar(vte);
				Variable mvpte = doRVarToMVar(vpte);
				doRDomainPatternToMDBottomPattern(r, pte, db);
				// assign
				Property tp = getProperty(pn, mvte.getType());
				assert tp != null;
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
	private void doRDomainPatternToMDBottomPatternSimpleNonVarExpr(@NonNull ObjectTemplateExp te,
			@NonNull BottomPattern db) {
		
		
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
				PropertyAssignment a = transformation.createPropertyAssignment();
				VariableExp ve = transformation.createVariableExp();
				// where
				Variable mvte = doRVarToMVar(vte);
				assert mvte != null;
				OCLExpression me = doRExpToMExp(e);
				assert me != null;
				// assign
				ve.setReferredVariable(mvte);
				ve.setType(mvte.getType());
				Property tp = getProperty(pn, mvte.getType());
				assert tp != null;
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
	private void doRDomainPatternToMDBottomPatternSimpleSharedVarExpr(
			@NonNull Relation r, @NonNull ObjectTemplateExp te, 
			@NonNull BottomPattern mb) {
		
		// when
		Set<Variable> sharedDomainVars = getSharedDomainVars(r);
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
					PropertyAssignment a = transformation.createPropertyAssignment();
					VariableExp ve1 = transformation.createVariableExp();
					VariableExp ve2 = transformation.createVariableExp();
					// where
					Variable mvte = doRVarToMVar(vte);
					Variable mvpte = doRVarToMVar(vpte);
					// assign
				    ve1.setReferredVariable(mvte);
				    ve2.setReferredVariable(mvpte);
					Property tp = getProperty(pn, mvte.getType());
					assert tp != null;
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
	
	private void doRDomainPatternToMDBottomPatternSimpleUnSharedVarExpr(
			@NonNull Relation r, @NonNull ObjectTemplateExp te, 
			@NonNull BottomPattern db) {
		// when
		Set<Variable> sharedDomainVars = getSharedDomainVars(r);
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
					PropertyAssignment a = transformation.createPropertyAssignment();
					VariableExp ve1 = transformation.createVariableExp();
					VariableExp ve2 = transformation.createVariableExp();
					// where
					Variable mvte = doRVarToMVar(vte);
					Variable mvpte = doRVarToMVar(vpte);
					// assign
				    ve1.setReferredVariable(mvte);
				    ve2.setReferredVariable(mvpte);
					Property tp = getProperty(pn, mvte.getType());
					assert tp != null;
					a.setSlotExpression(ve1);
					a.setTargetProperty(tp);
					a.setValue(ve2);
					db.getAssignment().add(a);
				}
			}
		}
		
	}
		
	// 16
	private void doRDomainToMComposedMappingGuard(@NonNull Relation r,
			@NonNull ObjectTemplateExp te, @NonNull RelationDomain rd,
			@NonNull OCLExpression e, @NonNull Mapping cm) {
		
		// when
		RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
		assert rt != null;
		Transformation mt = null;
		RelationalTransformationToMappingTransformation whenRule = new RelationalTransformationToMappingTransformation(transformation, rt); 
		RuleBindings whenBindings = whenRule.getRuleBindings();
		RelationalTransformationToMappingTransformation whenRuleRecord = (RelationalTransformationToMappingTransformation) transformation.getRecord(whenBindings);
		if (whenRuleRecord != null && whenRuleRecord.hasExecuted()) {
			mt = (Transformation) whenRuleRecord.getCore();
			
		}
		assert mt != null;
		// guard
		DomainPattern rdp = rd.getPattern();
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
				List<Package> up = dir.getUsedPackage();
				if (rt != dir.getTransformation())
					return;
				// init
				GuardPattern mg = transformation.findGuardPattern(cm);
				Predicate pd = transformation.createPredicate();
				OperationCallExp ee = transformation.createOperationCallExp();
				PropertyCallExp pe = transformation.createPropertyCallExp();
				VariableExp ve1 = transformation.createVariableExp();
				VariableExp ve2 = transformation.createVariableExp();
				CoreDomain cd = transformation.findCoreDomain(dn, cm);
				GuardPattern cmdg = transformation.findGuardPattern(cd);
				// where
				BottomPattern mb = cm.getBottomPattern();
				assert mb != null;
				RealizedVariable tcv = doRelationDomainToTraceClassVar(r, rd, mb);
				assert tcv != null;
				Variable mv = doRVarToMVar(v);
				assert mv != null;
				// assign
				ve1.setReferredVariable(tcv);
				ve1.setType(tcv.getType());
				Property tp = getProperty(mv.getName(), mv.getType());
				pe.setSource(ve1);
				pe.setReferredProperty(tp);
				pe.setType(tp.getType());
				ee.setSource(pe);
				ee.setReferredOperation(getEqualsOPeration());
				ee.setType(transformation.getMetaModelManager().getBooleanType());
				ve2.setReferredVariable(mv);
				ve2.setType(mv.getType());
				ee.getArgument().add(ve2);
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
	public void doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive(@NonNull Relation r, 
			@NonNull ObjectTemplateExp te, @NonNull RelationDomain rd,
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
			Variable v = te.getBindsTo();
			assert v != null;
			Type c = v.getType();
			assert c != null;
			Key key = transformation.getKeyforType(c);
			assert key != null;
			if (!(key.getPart().contains(pp)) && !(e instanceof TemplateExp)) {
				String pn = pp.getName();
				// init
				Mapping cm = transformation.findMapping(m.getName()+"_forNonIdentityProp", mt);
				BottomPattern bp = transformation.findBottomPattern(cm);
				transformation.findGuardPattern(cm);
				PropertyAssignment a = transformation.createPropertyAssignment();
				VariableExp ve = transformation.createVariableExp();
				// where
				Variable mv = doRVarToMVar(v);
				OCLExpression me = doRExpToMExp(e);
				assert me != null;
				// where
				doRDomainToMComposedMappingGuard(r, te, rd, e, cm);
				// assign
				ve.setReferredVariable(mv);
				ve.setType(mv.getType());
				a.setSlotExpression(ve);
				Property tp = getProperty(pn, mv.getType());
				assert tp != null;
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
	public void doRDomainVarToMDBottomAssignmnetForEnforcement(@NonNull Relation r, @NonNull RelationDomain rd,
			@NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings,
			@NonNull Set<Variable> unboundDomainVars, @NonNull BottomPattern mb)
	{
		// check
		Variable v = te.getBindsTo();
		assert v != null;
		// init
		PropertyAssignment a = transformation.createPropertyAssignment();
		VariableExp ve1 = transformation.createVariableExp();
		VariableExp ve2 = transformation.createVariableExp();
		// where
		RealizedVariable tcv = doRelationDomainToTraceClassVar(r, rd, mb);
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
		
		mb.getAssignment().add(a);
	}
	
	// 28
	public void doROppositeDomainVarsToTraceClassProps(@NonNull Relation r,
			@NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Variable> domainVars,
			@NonNull BottomPattern mb) {
		
		// check
		for(Variable dv : domainVars) {
			if (transformation.getTemplateExpression(dv) != null) {
				// init
				PropertyAssignment a = transformation.createPropertyAssignment();
				VariableExp ve1 = transformation.createVariableExp();
				VariableExp ve2 = transformation.createVariableExp();
				// where
				RealizedVariable tcv = doRelationDomainToTraceClassVar(r, rd, mb);
				assert dv != null;
				Variable mdv = doRVarToMVar(dv);
				// assign
				ve1.setReferredVariable(tcv);
				ve1.setType(tcv.getType());
				a.setSlotExpression(ve1);
				Property tp = getProperty(dv.getName(), tcv.getType());
				assert tp != null;
				a.setTargetProperty(tp);
				ve2.setReferredVariable(mdv);
				ve2.setType(mdv.getType());
				a.setValue(ve2);
				mb.getAssignment().add(a);
			}
		}
		
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
		Predicate mp = transformation.createPredicate();
		// when
		OCLExpression me = doRExpToMExp(re);
		assert me != null;
		doRPredicateSetToMBPredicateSet(predSeq, mb);
		// assign
		mp.setConditionExpression(me);
		mb.getPredicate().add(mp);
	}
	
	// 33
	public void doRVarSetToDGVarSet(@NonNull ArrayList<Variable> rvSeq,
			@NonNull GuardPattern dg) {
		
		if (!rvSeq.isEmpty()) {
			// check
			Variable rv = rvSeq.remove(0);
			assert rv != null;
			// when
			Variable mv = doRVarToMVar(rv, dg);
			assert mv != null;
			doRVarSetToDGVarSet(rvSeq, dg);
		}
		
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
		Variable vd = transformation.findVariable(tc.getName()+"_v", tc, mg);
		Predicate mgp = transformation.createPredicate();
		OperationCallExp ee = transformation.createOperationCallExp();
		PropertyCallExp pe = transformation.createPropertyCallExp();
		VariableExp pve = transformation.createVariableExp();
		VariableExp ave = transformation.createVariableExp();
		// where
		assert v != null;
		Variable mv = doRVarToMVar(v);
		// assign
		mgp.setConditionExpression(ee);
		ee.setSource(pe);
		pe.setSource(pve);
		pve.setReferredVariable(vd);
		pve.setType(vd.getType());
		Property pep = getProperty(dvn, vd.getType());
		assert pep != null;
		pe.setReferredProperty(pep);
		pe.setType(pep.getType());
		ee.setReferredOperation(getEqualsOPeration());
		ee.setType(transformation.getMetaModelManager().getBooleanType());
		ave.setReferredVariable(mv);
		ave.setType(mv.getType());
		ee.getArgument().add(ave);
		
		mg.getPredicate().add(mgp);
		
	}

	
	/* =============  T6 ============= */
	
	/*
	 * The issue with this method is that all variables should have been
	 * transformed so all variable references can be correctly pointed.
	 * However, if we call it after all variable modifying relations it
	 * should work.
	 */
	// 25
	public @Nullable OCLExpression doRExpToMExp(@NonNull OCLExpression re) {
		OCLExpCopy oCLExpCopy = new OCLExpCopy(transformation);
		
		return (OCLExpression) oCLExpCopy.doSwitch(re);
	}
	
	// 36
	public @NonNull RealizedVariable doRVarToMRealizedVar(@NonNull Variable rv, 
			@NonNull CorePattern pattern) {
		
		String n = rv.getName();
		Type t = rv.getType();
		assert (n != null) && (t != null);
		RealizedVariable mv = transformation.findRealizedVariable(n, t, pattern);
		assert mv != null;
		transformation.putVariableTrace(rv, mv);
		return mv;
	}
	
	public @NonNull RealizedVariable doRVarToMRealizedVar(@NonNull Variable rv) {
		
		RealizedVariable mv = (RealizedVariable) transformation.getVariableTrace(rv);
		assert mv != null;
		return mv;
	}
		
	// 37
	public @NonNull Variable doRVarToMVar(@NonNull Variable rv, 
			@NonNull CorePattern pattern) {

		String n = rv.getName();
		Type t = rv.getType();
		assert (n != null) && (t != null);
		Variable mv = transformation.findVariable(n, t, pattern);
		assert mv != null;
		transformation.putVariableTrace(rv, mv);
		return mv;
	}
	
	public @NonNull Variable doRVarToMVar(@NonNull Variable rv) {

		Variable mv = transformation.getVariableTrace(rv);
		assert mv != null;
		return mv;
	}
	
	// 42
	public @NonNull RealizedVariable doRelationDomainToTraceClassVar(@NonNull Relation r,
			@NonNull RelationDomain d, @NonNull CorePattern p) {

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
		RealizedVariable mv = transformation.findRealizedVariable(rn+"_"+dn+"_v", tc, p);
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
