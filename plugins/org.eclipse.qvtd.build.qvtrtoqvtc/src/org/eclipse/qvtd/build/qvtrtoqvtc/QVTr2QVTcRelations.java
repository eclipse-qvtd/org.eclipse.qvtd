package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
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
	
	private final QvtrToQvtcTransformation transformation;
	

	public QVTr2QVTcRelations(QvtrToQvtcTransformation transformation) {
		this.transformation = transformation;
	}
	
	/* =============  Queries ============= */
	
	public Set<Variable> getSharedDomainVars(Relation r) {
		
		Set<Variable> vars = new HashSet<Variable>();
		for (Domain d : r.getDomain()) {
			if (((RelationDomain) d).getPattern() != null) {
				if (vars.isEmpty()) {
					vars.addAll(((RelationDomain) d).getPattern().getBindsTo());
				} else {
					vars.retainAll(((RelationDomain) d).getPattern().getBindsTo());
				}
			}
		}
		return vars;
	}
	
	public @NonNull Set<Predicate> filterOutPredicatesThatReferToVars(@NonNull Set<Predicate> rpSet,
			@NonNull Set<Variable> ownrdVars) {
		// TODO Auto-generated method stub
		return rpSet;		// FIXME
	}
	
	
	public void doRDomainVarToMDBottomAssignmnetForEnforcement(@NonNull Relation r, @NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, @NonNull Set<Variable> unboundDomainVars, @NonNull BottomPattern mb)
	{
	}
	
	
	public void doRDomainToMBottomPredicateForEnforcement(@NonNull Relation r, @NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, @NonNull Set<Variable> unboundDomainVars, @NonNull BottomPattern mb)
	{
	}
	
	/* =============  T3 ============= */
	
	// 15
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
	
	// 27
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
		//RDomainToMDBottomForEnforcementOfIdentityPropObject(rdtSeq, mb);
		doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive(r, te, rd, m);
		doRDomainToMDBottomForEnforcementOfNonIdentityPropObject(r, rd, te, remainingPredicatesWithoutVarBindings, remainingUnBoundDomainVars, m);
		doRDomainToMBottomPredicateForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);
	}
	
	/* =============  T4 ============= */
	
	// 6
	private void doUnsharedWhenVarsToMgVars(@NonNull ArrayList<Variable> unsharedWhenVars,
			@NonNull GuardPattern mg) {
		
		List<Variable> mgVars = doRVarSetToMVarSet(unsharedWhenVars);
		mg.getBindsTo().addAll(mgVars);
	}

	// 7
	public void doDomainVarsSharedWithWhenToDgVars (@NonNull Set<Variable> domainVarsSharedWithWhen, @NonNull GuardPattern dg) {
		
		List<Variable> dbVars = doRVarSetToMVarSet(new ArrayList<Variable>(domainVarsSharedWithWhen));
		dg.getBindsTo().addAll(dbVars);

	}
	
	// 21
	private void doRSimplePatternToMPattern(Pattern rp, Pattern mp) {
		for (Predicate pd : rp.getPredicate()) {
			// check
			if (!(pd.getConditionExpression() instanceof RelationCallExp)) {
				Predicate mpd = QVTbaseFactory.eINSTANCE.createPredicate();
				OCLExpression me = doRExpToMExp(pd.getConditionExpression());
				mpd.setConditionExpression(me);
			}
		}
	}
	
	// 22
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
					doRWhenRelCallArgToMGuardPredicate(r, a, (RelationDomain) dseq.get(e.getArgument().indexOf(a)), mp);
				}
			}
		}
	}
	
	// 28
	public void doRDomainToMDBottomForEnforcementOfNonIdentityPropObject(@NonNull Relation r, @NonNull RelationDomain rd, @NonNull ObjectTemplateExp te,
			@NonNull Set<Predicate> predicatesWithoutVarBindings, @NonNull Set<Variable> unboundDomainVars, @NonNull Mapping m)
	{
		// check
		// FIXME not c.key.part->includes(pp)
		// when
		RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
		RuleBindings whenBindings = new RuleBindings(new RelationalTransformationToMappingTransformation(transformation, rt));
		RelationalTransformationToMappingTransformation whenRule = (RelationalTransformationToMappingTransformation) transformation.getRecord(whenBindings);
		Transformation mt = null;
		if (whenRule != null && whenRule.hasExecuted()) {
			mt = whenRule.getCore();
		}
		// TODO Finish when clear about if the call should be uncommented
		// ...
	}
	
	// 31
	public void doRDomainToMDBottomForEnforcementOfIdentityProp(@NonNull Relation r, @NonNull ObjectTemplateExp te, @NonNull BottomPattern db)
	{
		Variable v = te.getBindsTo();
		Type c = v.getType();
		//
		//	Enforce-Check
		//
		Area area = db.getArea();
		assert area instanceof CoreDomain : "Missing CoreDomain for RDomainToMDBottomForEnforcement";
		CoreDomain cd = (CoreDomain) area;
		Rule rule = cd.getRule();
		assert rule instanceof Mapping : "Missing Mapping for RDomainToMDBottomForEnforcement";
		Mapping m = (Mapping) rule;
		BottomPattern mb = transformation.findBottomPattern(m);
		assert mb != null;
		for (PropertyTemplateItem pt : te.getPart()) {
			Property pp = pt.getReferredProperty();
			// FIXME c.key.part->includes(pp)
			OCLExpression e = pt.getValue();
			doRDomainPatternExprToMappingDomainAssignment(v, pp, e, db);
			doRDomainPatternExprToMappingDomainVarAssignment(r, v, pp, e, db);
			doRDomainPatternExprToMappingDomainTemplateVarAssignment(r, v, pp, e, db);
		    doRDomainPatternExprToMappingBottomVarAssignment(r, v, pp, e, mb);
		}
	}
	
	// 37
	public void doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive(@NonNull Relation r, @NonNull ObjectTemplateExp te, @NonNull RelationDomain rd,
			@NonNull Mapping m)
	{
		// check
		// FIXME (not c.key.part->includes(pp))
		for (PropertyTemplateItem pt : te.getPart()) {
			OCLExpression e = pt.getValue();
			if (!(e instanceof TemplateExp)) {
				RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
				RuleBindings whenBindings = new RuleBindings(new RelationalTransformationToMappingTransformation(transformation, rt));
				RelationalTransformationToMappingTransformation whenRule = (RelationalTransformationToMappingTransformation) transformation.getRecord(whenBindings);
				Transformation mt = null;
				if (whenRule != null && whenRule.hasExecuted()) {
					mt = whenRule.getCore();
				}
				assert mt != null;
				String pn = pt.getReferredProperty().getName();
				Variable v = te.getBindsTo();
				Type c = v.getType();
				// init
				Mapping cm = transformation.findMapping(m.getName()+"_forNonIdentityProp", mt);
				BottomPattern bp = transformation.findBottomPattern(cm);
				Variable mv = doRVarToMVar(v);
				OCLExpression me = doRExpToMExp(e);
				PropertyAssignment a = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
				VariableExp ve = PivotFactory.eINSTANCE.createVariableExp();
				// assign
				ve.setReferredVariable(mv);
				a.setSlotExpression(ve);
				for (Property tp : mv.getType().getOwnedAttribute()) {
					if (tp.getName() == pn) {
						a.setTargetProperty(tp);
						break;
					}
				}
				a.setValue(me);
				bp.getAssignment().add(a);
				// where
				doRDomainToMComposedMappingGuard(r, te, rd, e, cm);
			}
		}
		
		
	}
	
	
	/* =============  T5 ============= */
	
	private void doRDomainToMComposedMappingGuard(Relation r,
			ObjectTemplateExp te, RelationDomain rd, OCLExpression e, Mapping cm) {
		// TODO Auto-generated method stub
		
	}

	// 16
	public @NonNull List<Variable> doRVarSetToMVarSet(@NonNull ArrayList<Variable> rvSeq) {
		
		List<Variable> mvSet = new ArrayList<Variable>();
		if (!rvSeq.isEmpty()) {
			Variable rv = rvSeq.remove(0);
			Variable mv = doRVarToMVar(rv);
			mvSet.add(mv);
			mvSet.addAll(doRVarSetToMVarSet(rvSeq));
		}
		return mvSet;
	}
	
	// 23
	private void doRWhenRelCallArgToMGuardPredicate(@NonNull Relation r, @NonNull VariableExp ve,
			@NonNull RelationDomain d, @NonNull GuardPattern mp) {
		// When
		RuleBindings whenBindings = new RuleBindings(new RelationToTraceClass(transformation, r));
		RelationToTraceClass whenRule = (RelationToTraceClass) transformation.getRecord(whenBindings);
		//Rule whenRule = RelationToTraceClass.FACTORY.createRule(transformation, r);
		Type tc = null;
		if (whenRule != null && whenRule.hasExecuted()) {
			tc = (Type) whenRule.getCore();
		}
		assert tc != null;
		// check
		Variable vd = transformation.findVariable(tc.getName()+"_v", tc);
		String dvn = d.getRootVariable().getName();
		Variable v = (Variable) ve.getReferredVariable();
		// init
		Predicate mpd = QVTbaseFactory.eINSTANCE.createPredicate();
		OperationCallExp ee = PivotFactory.eINSTANCE.createOperationCallExp();
		PropertyCallExp pe = PivotFactory.eINSTANCE.createPropertyCallExp();
		VariableExp pve = PivotFactory.eINSTANCE.createVariableExp();
		VariableExp ave = PivotFactory.eINSTANCE.createVariableExp();
		// where
		Variable mv = doRVarToMVar(v);
		// assign
		mpd.setConditionExpression(ee);
		ee.setSource(pe);
		pe.setSource(pve);
		for (DomainProperty pep : tc.getLocalProperties()) {
			if ((pep.getName() == dvn) && (pep.getType() == vd.getType())) {
				pe.setReferredProperty((Property) pep);
			}
		}
		// ee.setReferredOperation(value); FIXME
		ave.setReferredVariable(mv);
		ee.getArgument().add(ave);
		pve.setReferredVariable(vd);
		mp.getBindsTo().add(vd);
		
	}

	// 30
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
	
	// 33
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
			a.setSlotExpression(ve);
			for (Property tp : mv.getType().getOwnedAttribute()) {
				if (tp.getName() == pn) {
					a.setTargetProperty(tp);
					break;
				}
			}
			a.setValue(me);
			db.getAssignment().add(a);
		}
		
	}

	// 34
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
			a.setSlotExpression(ve);
			for (Property tp : mv.getType().getOwnedAttribute()) {
				if (tp.getName() == pn) {
					a.setTargetProperty(tp);
					break;
				}
			}
			me.setReferredVariable(mev);
			a.setValue(me);
			db.getAssignment().add(a);
		}
		
	}


	// 35
	private void doRDomainPatternExprToMappingDomainTemplateVarAssignment(
			@NonNull Relation r, @NonNull Variable v,
			@NonNull Property pp, @NonNull OCLExpression e,
			@NonNull BottomPattern db) {
		
		// when 
		Set<Variable> sharedDomainVars = getSharedDomainVars(r);
		// check
		if (e instanceof ObjectTemplateExp) {
			Variable rev = ((ObjectTemplateExp)e).getBindsTo();
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
				a.setSlotExpression(ve);
				for (Property tp : mv.getType().getOwnedAttribute()) {
					if (tp.getName() == pn) {
						a.setTargetProperty(tp);
						break;
					}
				}
				me.setReferredVariable(mev);
				a.setValue(me);
				db.getAssignment().add(a);
			}
			
		}
		
		
	}

	// 36
	private void doRDomainPatternExprToMappingBottomVarAssignment(Relation r,
			Variable v, Property pp, OCLExpression e, BottomPattern mb) {

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
			a.setSlotExpression(ve);
			for (Property tp : mv.getType().getOwnedAttribute()) {
				if (tp.getName() == pn) {
					a.setTargetProperty(tp);
					break;
				}
			}
			me.setReferredVariable(mev);
			a.setValue(me);
			mb.getAssignment().add(a);
		}
		
	}


	
	/* =============  T6 ============= */ 
	
	// 19
	public @NonNull Variable doRVarToMVar(@NonNull Variable rv) {

		Variable mv = transformation.findVariable(rv.getName(), rv.getType());
		return mv;
	}
		
	
	//20
	public @NonNull RealizedVariable doRVarToMRealizedVar(@NonNull Variable rv) {
		RealizedVariable mv = transformation.findRealizedVariable(rv.getName(), rv.getType());
		return mv;
	}
		
	// 49
	public @NonNull RealizedVariable doRelationDomainToTraceClassVar(@NonNull Relation r, @NonNull RelationDomain d, @NonNull Type tc) {
		String rn = r.getName();
		assert rn != null;
		String dn = d.getName();
		assert dn != null;
		RealizedVariable mv = transformation.findRealizedVariable(rn+"_"+dn+"_v", tc);
		return mv;
	}
	
	/*
	 * The issue with this method is that all variables should have been
	 * transformed so all variable references can be correctly pointed.
	 * However, if we call it after all variable modifying relations it
	 * should work.
	 */
	// 50
	public OCLExpression doRExpToMExp(@NonNull OCLExpression re) {
		
		return null;
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

	

}
