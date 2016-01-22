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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.OCLExpCopy;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.RelationalTransformationToMappingTransformation;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.RuleBindings;
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

public class QVTr2QVTcRelations
{
	public static @NonNull DomainPattern getDomainPattern(@NonNull Domain d) {
		List<@NonNull DomainPattern> pattern = ClassUtil.nullFree(((RelationDomain) d).getPattern());
		assert pattern.size() == 1;
		DomainPattern domainPattern = pattern.get(0);
		assert domainPattern != null;
		return domainPattern;
	}
	
	private @NonNull final QvtrToQvtcTransformation transformation;
	
//	private @NonNull final String OPPOSITE_UPPER_SOURCE = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper";
//	private @NonNull final String OPPOSITE_ROLE_NAME_SOURCE = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";
//	private @NonNull final String EMF_ANNOTATION_DETAIL_KEY = "body";
//	private @NonNull final String OPPOSITE_UPPER_VALUE = "1";
//	private @NonNull final String OPPOSITE_ROLE_NAME_VALUE = "middle";
	
	

	public QVTr2QVTcRelations(@NonNull QvtrToQvtcTransformation transformation) {
		this.transformation = transformation;
	}
	
	/*
	 * Add oppositeUpper and oppositeRoleName annotations
	 *
	private void zzaddMiddleSynthesisAnnotations(Property p) {
		Annotation oppositeUpper = PivotFactory.eINSTANCE.createAnnotation();
		oppositeUpper.setName(OPPOSITE_UPPER_SOURCE);
		Detail oppositeUpperDetail = PivotFactory.eINSTANCE.createDetail();
		oppositeUpperDetail.setName(EMF_ANNOTATION_DETAIL_KEY);
		oppositeUpperDetail.getValues().add("OPPOSITE_UPPER_VALUE");
		oppositeUpper.getOwnedDetails().add(oppositeUpperDetail);
		p.getOwnedAnnotations().add(oppositeUpper);
		Annotation oppositeRoleName = PivotFactory.eINSTANCE.createAnnotation();
		oppositeRoleName.setName(OPPOSITE_ROLE_NAME_SOURCE);
		Detail oppositeRoleNameDetail = PivotFactory.eINSTANCE.createDetail();
		oppositeRoleNameDetail.setName(EMF_ANNOTATION_DETAIL_KEY);
		oppositeRoleNameDetail.getValues().add("OPPOSITE_ROLE_NAME_VALUE");
		oppositeRoleName.getOwnedDetails().add(oppositeRoleNameDetail);
		p.getOwnedAnnotations().add(oppositeRoleName);
	} */
	
	/* =============  Queries ============= */
	// TODO bug 453863
	public @NonNull Set<@NonNull Variable> getSharedDomainVars(Relation r) {
		
		Set<@NonNull Variable> vars = new HashSet<@NonNull Variable>();
		for (Domain d : ClassUtil.nullFree(r.getDomain())) {
			List<@NonNull Variable> bt = ClassUtil.nullFree(QVTr2QVTcRelations.getDomainPattern(d).getBindsTo()); 
			if (vars.isEmpty()) {
				vars.addAll(bt);
			} else {
				vars.retainAll(bt);
			}
		}
		return vars;
	}
	
	/*
	 * Get variables occurring in an OCL expression
	 */
	// FIXME this function is not complete! It needs to be completed for other 
	// type of expressions
	public @NonNull Set<@NonNull Variable> getVarsOfExp(@NonNull OCLExpression e) {
		
		Set<@NonNull Variable> vs = new HashSet<@NonNull Variable>();
		if (e instanceof VariableExp) {
			Variable referredVariable = (Variable) ((VariableExp) e).getReferredVariable();
			assert referredVariable != null;
			vs.add(referredVariable);
		} else if (e instanceof OperationCallExp) {
			OperationCallExp oc = (OperationCallExp) e;
			OCLExpression ownedSource = oc.getOwnedSource();
			assert ownedSource != null;
			vs.addAll(getVarsOfExp(ownedSource));
			for (OCLExpression a : ClassUtil.nullFree(oc.getOwnedArguments())) {
				vs.addAll(getVarsOfExp(a));
			}
		} else if (e instanceof PropertyCallExp) {
			OCLExpression ownedSource = ((PropertyCallExp) e).getOwnedSource();
			assert ownedSource != null;
			vs.addAll(getVarsOfExp( ownedSource));
		} else if (e instanceof RelationCallExp) {
			RelationCallExp rc = (RelationCallExp) e;
			for (OCLExpression a : ClassUtil.nullFree(rc.getArgument())) {
				vs.addAll(getVarsOfExp(a));
			}
		} else if (e instanceof EnumLiteralExp) {
			
		} 
		else if (e instanceof ObjectTemplateExp) {
			ObjectTemplateExp te = (ObjectTemplateExp) e;
			Variable bindsTo = te.getBindsTo();
			assert bindsTo != null;
			vs.add(bindsTo);
			for (PropertyTemplateItem p : te.getPart()) {
				OCLExpression value = p.getValue();
				assert value != null;
				vs.addAll(getVarsOfExp(value));
			}
		} else if (e instanceof CollectionTemplateExp) {
			CollectionTemplateExp cte = (CollectionTemplateExp) e;
			for (OCLExpression m : ClassUtil.nullFree(cte.getMember()))
				vs.addAll(getVarsOfExp(m));
		}
		else {
			assert false : "getVarsOfExp() missing case for " + e.eClass().getName();
		}
		return vs;
	}
	
	public @NonNull Set<@NonNull Predicate> filterOutPredicatesThatReferToVars(@NonNull Set<@NonNull Predicate> rpSet,
			@NonNull Set<@NonNull Variable> ownrdVars) {
		
		Set<@NonNull Predicate> fpSet = new HashSet<@NonNull Predicate>();
		for (Predicate p : rpSet) {
			OCLExpression conditionExpression = p.getConditionExpression();
			assert conditionExpression != null;
			Set<@NonNull Variable> vs = getVarsOfExp(conditionExpression);
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
			@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings, 
			@NonNull Set<@NonNull Variable> unboundDomainVars, @NonNull BottomPattern db)
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
		doRDomainToMDBottomForEnforcementOfIdentityProp(r, te, db);
		doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive(r, te, rd, m);
		
		// This call is wrong as the trace variable is realized, it can't be guarded.
		// This should only be done in a nested mapping or later mapping
		//doRDomainToMBottomPredicateForEnforcement(r, rd, te, predicatesWithoutVarBindings, unboundDomainVars, mb);		
		doRDomainVarToMDBottomAssignmnetForEnforcement(r, rd, te, mb);
	}

	// 31
	/**
	 * Transform a rule implemented by a black box into an enforcement operation
	 *
	 * @param r the r
	 * @param rd the rd
	 * @param mb the mb
	 */
	public void doRRelImplToMBottomEnforcementOperation(Relation r,
			RelationDomain rd, BottomPattern mb) {
		
		// TODO Code this when testing transformations with operational implementations.
		
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
			@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings, 
			@NonNull Set<@NonNull Variable> unboundDomainVars,
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
		Set<@NonNull Variable> remainingUnBoundDomainVars = new HashSet<@NonNull Variable>(unboundDomainVars);
		remainingUnBoundDomainVars.remove(v);
		Set<@NonNull Predicate> predicatesWithVarBindings = 
				filterOutPredicatesThatReferToVars(predicatesWithoutVarBindings, remainingUnBoundDomainVars);
		doRPredicateSetToMBPredicateSet(new ArrayList<Predicate>(predicatesWithVarBindings), mb);
		// assign
		pve.setReferredVariable(tcv);
		pve.setType(tcv.getType());
		pe.setOwnedSource(pve);
		Property pep = getProperty(v.getName(), tcv.getType());
		assert pep != null;
		pe.setReferredProperty(pep);
		pe.setType(pep.getType());
		ee.setOwnedSource(pe);
		ee.setReferredOperation(getEqualsOPeration());
		ee.setType(transformation.getStandardLibrary().getBooleanType());
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
			assert key != null;		// FIXME why non-null
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
					doRWhenRelCallArgToMGuardPredicate(r, a, rd, mp, vdId);
				}
			}
		}
	}
	
	public void doRelationToTraceClass(@NonNull Relation r, org.eclipse.ocl.pivot.@NonNull Class rc) {	
		transformation.putRelationTrace(r, rc);
		// check
		String rn = r.getName();
		assert rn != null;
		rc.setName("T"+rn);
		Set<Variable> sharedDomainVars = getSharedDomainVars(r);
		doRVarSetToTraceClassProps(new ArrayList<Variable>(sharedDomainVars), rc);
		for (Domain d : ClassUtil.nullFree(r.getDomain())) {
			DomainPattern rdp = getDomainPattern(d);
			TemplateExp t = rdp.getTemplateExpression();
			assert t != null;
			doSubObjectTemplateToTraceClassProps(t, rc);
		    doSubCollectionTemplateToTraceClassProps(t, rc);
		}
	}
	
	private void doRVarSetToTraceClassProps(@NonNull ArrayList<Variable> rvSeq, @NonNull Class rc) {
		
		if (!rvSeq.isEmpty()) {
			// check
			Variable rv = rvSeq.remove(0);
			assert rv != null;
			// when
			RVarToTraceClassProp(rv, rc);
			doRVarSetToTraceClassProps(rvSeq, rc);
		}
	}
	
	private void RVarToTraceClassProp(@NonNull Variable rv, @NonNull Class rc) {
		
		Type c = rv.getType();
		assert c != null;
		String vn = rv.getName();
		assert vn != null;
		// init
		/*Property a =*/ transformation.whenTraceProperty(rc, vn, c);
//		addMiddleSynthesisAnnotations(a);
//		assert a != null;
	    // assign
//	    a.setType(c);
	}

	private void doSubObjectTemplateToTraceClassProps(@NonNull TemplateExp t, org.eclipse.ocl.pivot.@NonNull Class rc) {	
		// check
		if (t instanceof ObjectTemplateExp) {
			doObjectTemplateToTraceClassProps((ObjectTemplateExp) t, rc);
		}
		
	}
	
	private void doObjectTemplateToTraceClassProps(@NonNull ObjectTemplateExp t, org.eclipse.ocl.pivot.@NonNull Class rc) {	
		// check
		Variable tv = t.getBindsTo();
		assert tv != null;
		Type c = tv.getType();
		assert c != null;
		String vn = tv.getName();
		assert vn != null;
		// init
		Property a = transformation.whenTraceProperty(rc, vn, c);
		assert a != null;
//		addMiddleSynthesisAnnotations(a); 
		// where
		for (PropertyTemplateItem pt : t.getPart()) {
			OCLExpression value = pt.getValue();
			assert value != null;
			if (value instanceof TemplateExp) {
				TemplateExp tp = (TemplateExp) value;
				doSubObjectTemplateToTraceClassProps(tp, rc);
			    doSubCollectionTemplateToTraceClassProps(tp, rc);
			}
		}
	    // assign
//	    a.setType(c);
	}

	private void doSubCollectionTemplateToTraceClassProps(@NonNull TemplateExp t, org.eclipse.ocl.pivot.@NonNull Class rc) {
		// check
		if (t instanceof CollectionTemplateExp) {
			doCollectionTemplateToTraceClassProps((CollectionTemplateExp) t, rc);
		}
	}


	private void doCollectionTemplateToTraceClassProps(@NonNull CollectionTemplateExp t, org.eclipse.ocl.pivot.@NonNull Class rc) {	
		// check
		for (OCLExpression m : t.getMember()) {
			if (m instanceof TemplateExp) {
				TemplateExp tp = (TemplateExp) m; 
				// Dont add trace attributes for collections, just for the members
				doSubObjectTemplateToTraceClassProps(tp, rc);
			    doSubCollectionTemplateToTraceClassProps(tp, rc);
			}
		}
	}

	// 47
	public void doTROppositeDomainsToMappingForEnforcement(@NonNull Relation r,
			@NonNull RelationDomain rd, @NonNull Mapping m) {
		
		Set<@NonNull RelationDomain> rds = new HashSet<@NonNull RelationDomain>();
		for (Domain d : ClassUtil.nullFree(r.getDomain())) {
			rds.add((RelationDomain) d);
		}
		rds.remove(rd); // guard
		for (RelationDomain ord : rds) {
			// check
			DomainPattern dp = getDomainPattern(ord);
			if (dp.getTemplateExpression() instanceof ObjectTemplateExp) {
				String dn = ord.getName();
				assert dn != null;
				TypedModel dir = ord.getTypedModel();
				String tmn = dir.getName();
				assert tmn != null;
				RelationalTransformation rt = (RelationalTransformation) dir.getTransformation();
				assert rt != null;
				List<org.eclipse.ocl.pivot.Package> up = dir.getUsedPackage();
				boolean c = ord.isIsCheckable();
				List<Variable> domainVars = dp.getBindsTo();
				ObjectTemplateExp te = (ObjectTemplateExp) dp.getTemplateExpression();
				assert te != null;
				// when
				RelationalTransformationToMappingTransformation whenRule = 
						new RelationalTransformationToMappingTransformation(transformation, rt); 
				RuleBindings whenBindings = whenRule.getRuleBindings();
				RelationalTransformationToMappingTransformation whenRuleRecord = (RelationalTransformationToMappingTransformation) transformation.getRecord(whenBindings);
				Transformation mt = null;
				if (whenRuleRecord != null && whenRuleRecord.hasExecuted()) {
					mt = whenRuleRecord.getCore();
				}
				assert mt != null;
				// init
				CoreDomain cd = transformation.whenCoreDomain(m, dn);
				GuardPattern dg = transformation.whenGuardPattern(cd);
				BottomPattern db = transformation.whenBottomPattern(cd);
				BottomPattern mb = transformation.whenBottomPattern(m);
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
			mt = whenRuleRecord.getCore();
			
		}
		assert mt != null;
		// guard
		DomainPattern rdp = getDomainPattern(rd);
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
				GuardPattern mg = transformation.whenGuardPattern(cm);
				Predicate pd = transformation.createPredicate();
				OperationCallExp ee = transformation.createOperationCallExp();
				PropertyCallExp pe = transformation.createPropertyCallExp();
				VariableExp ve1 = transformation.createVariableExp();
				VariableExp ve2 = transformation.createVariableExp();
				CoreDomain cd = transformation.whenCoreDomain(cm, dn);
				GuardPattern cmdg = transformation.whenGuardPattern(cd);
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
				pe.setOwnedSource(ve1);
				pe.setReferredProperty(tp);
				pe.setType(tp.getType());
				ee.setOwnedSource(pe);
				ee.setReferredOperation(getEqualsOPeration());
				ee.setType(transformation.getStandardLibrary().getBooleanType());
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
			assert key != null; // FIXME why non-null
			if (!(key.getPart().contains(pp)) && !(e instanceof TemplateExp)) {
				String pn = pp.getName();
				// init
				Mapping cm = transformation.whenMapping(mt, m.getName()+"_forNonIdentityProp");
				BottomPattern bp = transformation.whenBottomPattern(cm);
				transformation.whenGuardPattern(cm);
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
			@NonNull ObjectTemplateExp te, @NonNull BottomPattern mb)
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
			@NonNull Set<@NonNull Variable> domainVars,
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
				if (tp == null) {
					tp = getProperty(dv.getName(), tcv.getType());
				}
				assert tp != null : "Property " + dv.getName() + ". not found in trace class " + tcv.getType().getName();
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
			@NonNull RelationDomain d, @NonNull GuardPattern mg, @NonNull String vdId) {
		// when
		Type tc = transformation.getRelationTrace(r);
		assert tc != null;
		// check
		String dvn = d.getRootVariable().get(0).getName();
		assert dvn != null;
		Variable v = (Variable) ve.getReferredVariable();
		assert v != null;
		// init
		Variable vd = transformation.whenVariable(mg, tc.getName()+vdId+"_v", tc);
		Predicate mgp = transformation.createPredicate();
		OperationCallExp ee = transformation.createOperationCallExp();
		PropertyCallExp pe = transformation.createPropertyCallExp();
		VariableExp pve = transformation.createVariableExp();
		VariableExp ave = transformation.createVariableExp();
		// where
		Variable mv = doRVarToMVar(v);
		// assign
		mgp.setConditionExpression(ee);
		ee.setOwnedSource(pe);
		pe.setOwnedSource(pve);
		pve.setReferredVariable(vd);
		pve.setType(vd.getType());
		Property pep = getProperty(dvn, vd.getType());
		assert pep != null;
		pe.setReferredProperty(pep);
		pe.setType(pep.getType());
		ee.setReferredOperation(getEqualsOPeration());
		ee.setType(transformation.getStandardLibrary().getBooleanType());
		ave.setReferredVariable(mv);
		ave.setType(mv.getType());
		ee.getOwnedArguments().add(ave);
		
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
		
		RealizedVariable mv = transformation.whenRealizedVariable(pattern, rv);
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

		Variable mv = transformation.whenVariable(pattern, rv);
		return mv;
	}
	
	public @NonNull Variable doRVarToMVar(@NonNull Variable rv) {

		Variable mv = transformation.getVariableTrace(rv);
		assert mv != null : "No variable trace found for " + rv.getName() + ". Probable cause is a missing where/when statement to bind the variable.";
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
		Type tc = transformation.getRelationTrace(r);
		assert tc != null;
		RealizedVariable mv = transformation.whenRealizedVariable(p, rn+"_"+dn+"_v", tc);
		return mv;
	}
	
	public void doIROppositeDomainsToMappingForEnforcement(@NonNull Relation r,
			@NonNull Relation ir, @NonNull RelationDomain rd, 
			@NonNull Mapping m) {
		
		Set<@NonNull RelationDomain> rds = new HashSet<@NonNull RelationDomain>();
		for (Domain d : ClassUtil.nullFree(r.getDomain())) {
			rds.add((RelationDomain) d);
		}
		rds.remove(rd); // guard
		for (RelationDomain ord : rds) {
			// check
			DomainPattern dp = getDomainPattern(ord);
			if (dp.getTemplateExpression() instanceof ObjectTemplateExp) {
				String dn = ord.getName();
				assert dn != null;
				TypedModel dir = ord.getTypedModel();
				String tmn = dir.getName();
				assert tmn != null;
				RelationalTransformation rt = (RelationalTransformation) dir.getTransformation();
				assert rt != null;
				List<org.eclipse.ocl.pivot.Package> up = dir.getUsedPackage();
				boolean c = ord.isIsCheckable();
				List<Variable> domainVars = dp.getBindsTo();
				ObjectTemplateExp te = (ObjectTemplateExp) dp.getTemplateExpression();
				assert te != null;
				Variable tev = te.getBindsTo();
				// when
				RelationalTransformationToMappingTransformation whenRule = 
						new RelationalTransformationToMappingTransformation(transformation, rt); 
				RuleBindings whenBindings = whenRule.getRuleBindings();
				RelationalTransformationToMappingTransformation whenRuleRecord = (RelationalTransformationToMappingTransformation) transformation.getRecord(whenBindings);
				Transformation mt = null;
				if (whenRuleRecord != null && whenRuleRecord.hasExecuted()) {
					mt = whenRuleRecord.getCore();
				}
				assert mt != null;
				// init
				CoreDomain cd = transformation.whenCoreDomain(m, dn);
				GuardPattern dg = transformation.whenGuardPattern(cd);
				BottomPattern db = transformation.whenBottomPattern(cd);
				BottomPattern mb = transformation.whenBottomPattern(m);
				// where
				Set<Variable> whenVars = new HashSet<Variable>();
				if (r.getWhen() != null)
					whenVars.addAll(r.getWhen().getBindsTo());
				Set<Variable> domainTopVars = new HashSet<Variable>(domainVars);
				domainTopVars.retainAll(whenVars);
				domainTopVars.add(tev);
				Set<Variable> sharedDomainVars = getSharedDomainVars(r);
				Set<Variable> domainBottomUnSharedVars = new HashSet<Variable>(domainVars);
				domainBottomUnSharedVars.removeAll(whenVars);
				domainBottomUnSharedVars.removeAll(sharedDomainVars);
				domainBottomUnSharedVars.remove(tev);
				Set<Variable> domainBottomSharedVars = new HashSet<Variable>(domainVars);
				domainBottomSharedVars.removeAll(whenVars);
				domainBottomSharedVars.retainAll(sharedDomainVars);
				domainBottomSharedVars.remove(tev);
				
				doRVarSetToDGVarSet(new ArrayList<Variable>(domainTopVars), dg);
				doRVarSetToMBVarSet(new ArrayList<Variable>(domainBottomUnSharedVars), db);
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

	// ?
	public void doRInvokerToMGuard(@NonNull Relation ir,
			@NonNull RelationCallExp ri, @NonNull Relation r,
			@NonNull GuardPattern mg) {
		
		// where
		List<Domain> dseq = new ArrayList<Domain>(r.getDomain());
		for (OCLExpression arg : ri.getArgument()) {
			VariableExp a = (VariableExp) arg;
			RelationDomain rd = (RelationDomain) dseq.get(ri.getArgument().indexOf(a));
			assert (a != null) && (rd != null);
			doRInvokerToMGuardPredicate(ir, a, rd, mg);
		}
	}

	private void doRInvokerToMGuardPredicate(@NonNull Relation ir, 
			@NonNull VariableExp ve, @NonNull RelationDomain rd,
			@NonNull GuardPattern mg) {
		
		// when
		Type tc = transformation.getRelationTrace(ir);
		assert tc != null;
		// check
		Variable v = (Variable) ve.getReferredVariable();
		assert v != null;
		String vn = v.getName();
		assert vn != null;
		Variable dv = rd.getRootVariable().get(0);
		assert dv != null;
		// init
		Variable vd = transformation.whenVariable(mg, tc.getName()+"_v", tc);
		Predicate pd = transformation.createPredicate();
		OperationCallExp ee = transformation.createOperationCallExp();
		PropertyCallExp pe = transformation.createPropertyCallExp();
		VariableExp mve = transformation.createVariableExp();
		VariableExp ave = transformation.createVariableExp();
		// where
		Variable mdv = doRVarToMVar(dv);
		// assign
		pd.setConditionExpression(ee);
		ee.setOwnedSource(pe);
		pe.setOwnedSource(mve);
		mve.setReferredVariable(vd);
		mve.setType(vd.getType());
		Property pep = getProperty(vn, vd.getType());
		assert pep != null;
		pe.setReferredProperty(pep);
		pe.setType(pep.getType());
		ee.setReferredOperation(getEqualsOPeration());
		ee.setType(transformation.getStandardLibrary().getBooleanType());
		ave.setReferredVariable(mdv);
		ave.setType(mdv.getType());
		ee.getOwnedArguments().add(ave);
		
		mg.getPredicate().add(pd);
	}
	
	/* =============  Helpers ============= */

	public @NonNull Set<@NonNull Predicate> rejectRelationCallPredicates(
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
	
	public @NonNull Set<@NonNull Variable> getAllDomainVars(@NonNull Relation r) {
		Set<@NonNull Variable> allDomainVars = new HashSet<@NonNull Variable>();
		for (Domain d : ClassUtil.nullFree(r.getDomain())) {
			DomainPattern domainPattern = getDomainPattern(d);
			allDomainVars.addAll(ClassUtil.nullFree(domainPattern.getBindsTo()));
		}
		return allDomainVars;
	}
	
	private @NonNull Operation getEqualsOPeration() {
		for (Operation o : transformation.getStandardLibrary().getOclAnyType().getOwnedOperations()) {
			if (o.getName().equals("=")) {
				return o;
			}
		}
		throw new IllegalStateException("No = operation");
	}
	
	private Property getProperty(String name, Type owningType) {
		
		if (owningType instanceof org.eclipse.ocl.pivot.Class) {
			for (Property p : ((org.eclipse.ocl.pivot.Class)owningType).getOwnedProperties()) {
				if (p.getName().equals(name))
					return p;
			}
		}
		return null;
	}
}
