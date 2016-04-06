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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
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

/*public*/ abstract class AbstractQVTr2QVTcRelations extends QVTcoreHelper
{
	protected abstract class AbstractRelationDomain2CoreDomain 
	{
		// Relations
		protected final @NonNull RelationDomain rd;									// This source enforced domain
		protected final @NonNull Relation r;										// Parent relation of this domain
		protected final @NonNull RelationalTransformation rt;						// Parent transformation of parent relation of enforced domain
		protected final @NonNull List<@NonNull Variable> domainVars;				// All variables defined or referenced in this domain
		protected final @NonNull List<@NonNull RelationDomain> rOtherDomains;		// All other domains sharing the parent of this domain
		protected final @NonNull ObjectTemplateExp te;								// The template expression defining the enforced domain pattern
		protected final @NonNull Variable tev;										// The template expression  variable (the root variable of the enforced domain pattern)
		// Core
		protected final @NonNull Transformation mt;									// The transformation containing the result mapping
		protected final @NonNull Mapping m;											// The resultant mapping
		protected final @NonNull GuardPattern mg;									// The resultant mapping guard pattern
		protected final @NonNull BottomPattern mb;									// The resultant mapping bottom pattern	
		protected final @NonNull TypedModel mdir;									// The resultant enforced typed model
		protected final @NonNull CoreDomain md;										// The resultant enforced domain
		protected final @NonNull GuardPattern dg;									// The resultant enforced domain guard pattern
		protected final @NonNull BottomPattern db;									// The resultant enforced domain bottom pattern
		protected final @NonNull RealizedVariable tcv;								// The trace class variable (the middle variable identifying the middle object)
		
		public AbstractRelationDomain2CoreDomain(@NonNull RelationDomain rd, @NonNull String coreMappingName) {
			this.rd = rd;
			//
			this.r = (Relation) ClassUtil.nonNullState(rd.getRule());
			this.rt = (RelationalTransformation) ClassUtil.nonNullState(r.getTransformation());
			@NonNull DomainPattern dp = qvtr2qvtc.getDomainPattern(rd);
			this.domainVars = ClassUtil.nullFree(dp.getBindsTo());
			this.rOtherDomains = getOtherDomains(rd);
			this.te = (ObjectTemplateExp) ClassUtil.nonNullState(dp.getTemplateExpression());
			this.tev = ClassUtil.nonNullState(te.getBindsTo());
			@NonNull TypedModel dir = ClassUtil.nonNullState(rd.getTypedModel());
			@NonNull String rn = ClassUtil.nonNullState(r.getName());
			@NonNull String dn = ClassUtil.nonNullState(rd.getName());
			@NonNull Type tc = qvtr2qvtc.getTraceClass(r);
			//
			this.mt = qvtr2qvtc.getCoreTransformation(rt);
			this.mdir = getCoreTypedModel(mt, ClassUtil.nonNullState(dir.getName()), ClassUtil.nullFree(dir.getUsedPackage()));
			this.m = qvtr2qvtc.whenMapping(r, coreMappingName);
			this.mg = ClassUtil.nonNullState(m.getGuardPattern());
			this.mb = ClassUtil.nonNullState(m.getBottomPattern());
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
		protected void doRDomainPatternToMDBottomPattern(@NonNull ObjectTemplateExp te) throws CompilerChainException {
			Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
			Variable vte = ClassUtil.nonNullState(te.getBindsTo());
			for (@NonNull PropertyTemplateItem pt : ClassUtil.nullFree(te.getPart())) {
				Property pp = ClassUtil.nonNullState(pt.getReferredProperty());
				String pn = pp.getName();
				Variable mvte = doRVarToMVar(vte);
			    Property tp = getProperty(mvte.getType(), pn);
				VariableExp ve1 = createVariableExp(mvte);
				OCLExpression ptv = ClassUtil.nonNullState(pt.getValue());
				if (ptv instanceof VariableExp) {
					/**
					 * Each PropertyTemplateItem whose value is a simple VariableExp
					 * converts to a domain(unshared) / middle(shared) PropertyAssignment.
					 * 
					 * ve1:T{tp = ve2}   =>   ve1.tp := ve2;
					 */
					VariableExp e = (VariableExp)ptv;
					Variable vpte = ClassUtil.nonNullState((Variable) e.getReferredVariable());
					Variable mvpte = doRVarToMVar(vpte);
					VariableExp ve2 = createVariableExp(mvpte);
					PropertyAssignment a = createPropertyAssignment(ve1, tp, ve2);
					if (sharedDomainVars.contains(vpte)) {
						mb.getAssignment().add(a);
					}
					else {
						db.getAssignment().add(a);
					}
				}
				else if (ptv instanceof CollectionTemplateExp) {
					/**
					 * Each PropertyTemplateItem whose value is a CollectionTemplateExp
					 * converts to a VariableAssignment and Predicates.
					 * 
					 * ve1:T1{tp = ve2:Collection{a++b}}		=>   ve2 := ve1.tp;
					 */
					CollectionTemplateExp cte = (CollectionTemplateExp) ptv;
					Variable vcte = ClassUtil.nonNullState(cte.getBindsTo());
					Variable mvcte = doRVarToMVar(vcte);
					PropertyCallExp pce =  createPropertyCallExp(ve1, tp);
					VariableAssignment a = createVariableAssignment(mvcte, pce);
					mb.getAssignment().add(a);
					/**
					 * Each CollectionTemplateExp member that is not a variable
					 * converts to a VariableAssignment of a new variable the member expression.
					 * 
					 * ve1:T1{tp = ve2:Collection{a++b}}		=>   a := a;
					 */
					Map<@NonNull OCLExpression, @NonNull Variable> rMember2mVariable = new HashMap<@NonNull OCLExpression, @NonNull Variable>();
					List<@NonNull OCLExpression> rMembers = ClassUtil.nullFree(cte.getMember());
					for (@NonNull OCLExpression rMember : rMembers) {
						Variable mVariable;
						if (rMember instanceof ObjectTemplateExp) {
							doRDomainPatternToMDBottomPattern((ObjectTemplateExp)rMember);
							Variable rVariable = ClassUtil.nonNullState(((ObjectTemplateExp)rMember).getBindsTo());
							mVariable = doRVarToMVar(rVariable);
						}
						else if (rMember instanceof VariableExp) {
							Variable rVariable = ClassUtil.nonNullState((Variable)((VariableExp)rMember).getReferredVariable());
							mVariable = doRVarToMVar(rVariable);
						}
						else {
							OCLExpression mMember = doRExpToMExp(rMember);
							mVariable = createVariable(qvtr2qvtc.getSafeName(r, mMember, "member"), mMember);
						}
						rMember2mVariable.put(rMember, mVariable);
					}
//					CollectionTemplateExp cte = (CollectionTemplateExp) ptv;
//					Variable vcte = ClassUtil.nonNullState(cte.getBindsTo());
//					Variable mvcte = doRVarToMVar(vcte);
//					PropertyCallExp pce =  createPropertyCallExp(ve1, tp);
//					VariableAssignment a = createVariableAssignment(mvcte, pce);
//					mb.getAssignment().add(a);

					
					CollectionType collectionType = ClassUtil.nonNullState(cte.getReferredCollectionType());
					int size = rMembers.size();
					Variable rRest = cte.getRest();
					if (rRest == null) {
						/**
						 * The predicate for a CollectionTemplateExp without a rest variable is a total comparison.
						 * 
						 * ve1:T1{tp = ve2:Collection{a++b}}		=>   ve2 := ve1.tp; ve2 = Collection{a,b};
						 */
						List<@NonNull CollectionLiteralPart> mParts = new ArrayList<@NonNull CollectionLiteralPart>();
						for (@NonNull OCLExpression rMember : rMembers) {
							Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
							CollectionLiteralPart mItem = createCollectionItem(createVariableExp(mVariable));
							mParts.add(mItem);
						}
						CollectionLiteralExp cle = createCollectionLiteralExp(collectionType, mParts);
						VariableExp ve2 = createVariableExp(mvcte);
						OperationCallExp eTerm = createOperationCallExp(ve2, "=", cle);
						Predicate pd = createPredicate(eTerm);
						mb.getPredicate().add(pd);
					}
					else {
						Variable mRest = doRVarToMVar(rRest);
						if (collectionType.isOrdered()) {
							/**
							 * The assignment for an ordered CollectionTemplateExp rest variable is a sub-collection assignment.
							 * 
							 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   c := ve2->subCollection(3,ve2->size());
							 */
							VariableExp vRest = createVariableExp(rRest);
							String opName = collectionType.isUnique() ? "subOrderedSet" : "subSequence";
							IntegerLiteralExp eStart = createIntegerLiteralExp(size);
							OCLExpression eFinish = createOperationCallExp(createVariableExp(mvcte), "size");
							OCLExpression eTail = createOperationCallExp(createVariableExp(mvcte), opName, vRest, eStart, eFinish);
							VariableAssignment aRest = createVariableAssignment(mRest, eTail);
							mb.getAssignment().add(aRest);
							/**
							 * The predicates for each ordered CollectionTemplateExp member variable is an element comparison.
							 * 
							 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   a = ve2->at(1);
							 */
							for (int i = 0; i < size; i++) {
								IntegerLiteralExp eIndex = createIntegerLiteralExp(i+1);
								OCLExpression vElement = createOperationCallExp(createVariableExp(mvcte), "at", eIndex);
								OCLExpression rMember = rMembers.get(i);
								Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
								OperationCallExp eTerm = createOperationCallExp(createVariableExp(mVariable), "=", vElement);
								Predicate pd = createPredicate(eTerm);
								mb.getPredicate().add(pd);
							}
						}
						else { 
							/**
							 * The assignment for an unordered CollectionTemplateExp rest variable is a cumulative exclusion.
							 * 
							 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   c := ve2->excluding(a)->excluding(b);
							 */
							OCLExpression exclusions = createVariableExp(mvcte);
							for (@NonNull OCLExpression rMember : rMembers) {
								Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
								exclusions = createOperationCallExp(exclusions, "excluding", createVariableExp(mVariable));
							}
							VariableAssignment aRest = createVariableAssignment(mRest, exclusions);
							mb.getAssignment().add(aRest);
							/**
							 * The predicates for each unordered CollectionTemplateExp member variable is an excluded inclusion test.
							 * 
							 * ve1:T1{tp = ve2:Collection{a,b++c}}		=>   ve2->excluding(a)->includes(b);
							 */
							for (int i = 0; i < size; i++) {
								@NonNull OCLExpression eTerm = createVariableExp(mvcte);
								for (int j = 0; j < i; j++) {
									OCLExpression rMember = rMembers.get(j);
									Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
									eTerm = createOperationCallExp(eTerm, "excluding", createVariableExp(mVariable));
								}
								OCLExpression rMember = rMembers.get(i);
								Variable mVariable = ClassUtil.nonNullState(rMember2mVariable.get(rMember));
								eTerm = createOperationCallExp(eTerm, "includes", createVariableExp(mVariable));
								Predicate pd = createPredicate(eTerm);
								mb.getPredicate().add(pd);
							}
						}
					}
				}
				else if (ptv instanceof ObjectTemplateExp) {
					/**
					 * Each PropertyTemplateItem whose value is an ObjectTemplateExp
					 * converts to a PropertyAssignment.
					 * 
					 * ve1:T1{tp = ve2:T2{...}}   =>   ve1.tp := ve2;
					 */
					ObjectTemplateExp pte = (ObjectTemplateExp) ptv;
					Variable vpte = ClassUtil.nonNullState(pte.getBindsTo());
					Variable mvpte = doRVarToMVar(vpte);
					doRDomainPatternToMDBottomPattern(pte);
					VariableExp ve2 = createVariableExp(mvpte);
					PropertyAssignment a = createPropertyAssignment(ve1, tp, ve2);
					mb.getAssignment().add(a);
				}
				else {
					/**
					 * Each PropertyTemplateItem whose value is not a TemplateExp and not a VariableExp
					 * converts to a PropertyAssignment.
					 * 
					 * ve1:T{tp = me}   =>   ve1.tp := me;
					 */
					OCLExpression me = doRExpToMExp(ptv);
					PropertyAssignment a = createPropertyAssignment(ve1, tp, me);
					mb.getAssignment().add(a);
				}
			}
		}

		// 15
		/*
		 * Creates a Predicate, who's ConditionExpression is an
		 * OperationCallExp:
		 * 		trace.<v.name> = v;
		 * TODO Suggest better name: RDomainPatternVariableToTracePredicate?
		 */
		private void doRDomainToMBottomPredicateForEnforcement(@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings, @NonNull Set<@NonNull Variable> unboundDomainVars) throws CompilerChainException
		{
			// check
			Variable v = te.getBindsTo();
			assert v != null;
			// init
			// where
			@NonNull Variable mv = doRVarToMVar(v);
			Set<@NonNull Variable> remainingUnBoundDomainVars = new HashSet<@NonNull Variable>(unboundDomainVars);
			remainingUnBoundDomainVars.remove(v);
			Set<@NonNull Predicate> predicatesWithVarBindings = 
					filterOutPredicatesThatReferToVars(predicatesWithoutVarBindings, remainingUnBoundDomainVars);
			doRPredicateSetToMBPredicateSet(predicatesWithVarBindings, mb);
			// assign
			VariableExp pve = createVariableExp(tcv);
			Property pep = getProperty(tcv.getType(), v.getName());
			PropertyCallExp pe = createPropertyCallExp(pve, pep);
			VariableExp ave = createVariableExp(mv);
			OperationCallExp ee = createOperationCallExp(pe, "=", ave);
			Predicate pd = createPredicate(ee);
			mb.getPredicate().add(pd);
		}
		
		// 18
		/*
		 * Creates Assignments for each part of the ObjectTemplateExp
		 */
		private void doRDomainToMDBottomForEnforcementOfIdentityProp() throws CompilerChainException
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
//			RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
//			assert rt != null;
//			@NonNull Transformation mt = qvtr2qvtc.getCoreTransformation(rt);
			// TODO Finish when clear about if the call should be uncommented
			// ...
		}
		
		// 29
		protected void doRPredicateSetToMBPredicateSet(@NonNull Iterable<@NonNull Predicate> predSeq, @NonNull BottomPattern mb) {
			for (@NonNull Predicate rp : predSeq) {
				OCLExpression re = ClassUtil.nonNullState(rp.getConditionExpression());
				@NonNull OCLExpression me = doRExpToMExp(re);
				Predicate mp = createPredicate(me);
				mb.getPredicate().add(mp);
			}
/*			
			// check
			if(predSeq.isEmpty()) {
				return;
			}
			Predicate rp = predSeq.remove(0);
			OCLExpression re = rp.getConditionExpression();
			assert re != null;
			// init
			@NonNull Predicate mp = createPredicate();
			// when
			@NonNull OCLExpression me = doRExpToMExp(re);
			doRPredicateSetToMBPredicateSet(predSeq, mb);
			// assign
			mp.setConditionExpression(me);
			mb.getPredicate().add(mp); */
		}
		
		// 32
		private void doRSimplePatternToMPattern(@NonNull Pattern rp) {
			for (@NonNull Predicate pd : ClassUtil.nullFree(rp.getPredicate())) {
				OCLExpression ce = ClassUtil.nonNullState(pd.getConditionExpression());
				if (!(ce instanceof RelationCallExp)) {
					OCLExpression me = doRExpToMExp(ce);
					Predicate mpd = createPredicate(me);		// FIXME orphan
					throw new UnsupportedOperationException("FIXME orphan");
				}
			}
		}
		
		// 40
		private void doRWhenRelCallToMGuard(@NonNull Pattern rp) throws CompilerChainException {
			
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
		private void doRDomainPatternExprToMappingBottomVarAssignment(@NonNull Variable v, @NonNull Property pp, @NonNull OCLExpression e) throws CompilerChainException {
			Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
			if ((e instanceof VariableExp) && sharedDomainVars.contains(((VariableExp)e).getReferredVariable()) ) {
				String pn = pp.getName();
				Variable rev = ClassUtil.nonNullState((Variable) ((VariableExp)e).getReferredVariable());
				Variable mv = doRVarToMRealizedVar(v);
				Variable mev = doRVarToMVar(rev);
				VariableExp ve = createVariableExp(mv);
				Property tp = getProperty(mv.getType(), pn);
				VariableExp me = createVariableExp(mev);
				PropertyAssignment a = createPropertyAssignment(ve, tp, me);
				mb.getAssignment().add(a);
			}
		}

		// 7
		private void doRDomainPatternExprToMappingDomainAssignment(@NonNull Variable v, @NonNull Property pp, @NonNull OCLExpression e) throws CompilerChainException {
			if (!(e instanceof VariableExp) &&  !(e instanceof ObjectTemplateExp)) {
				String pn = pp.getName();
				Variable mv = doRVarToMVar(v);
				VariableExp ve = createVariableExp(mv);
				Property tp = getProperty(mv.getType(), pn); 
				OCLExpression me = doRExpToMExp(e);
				PropertyAssignment a = createPropertyAssignment(ve, tp, me);
				db.getAssignment().add(a);
			}
		}
			
		// 8
		private void doRDomainPatternExprToMappingDomainTemplateVarAssignment(@NonNull Variable v, @NonNull Property pp, @NonNull OCLExpression e) throws CompilerChainException {
			Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
			if (e instanceof ObjectTemplateExp) {
				Variable rev = ClassUtil.nonNullState(((ObjectTemplateExp)e).getBindsTo());
				if (!sharedDomainVars.contains(rev)) {
					String pn = pp.getName();
					Variable mv = doRVarToMRealizedVar(v);
					Variable mev = doRVarToMVar(rev);
					VariableExp ve = createVariableExp(mv);
					Property tp = getProperty(mv.getType(), pn);
					VariableExp me = createVariableExp(mev);
					PropertyAssignment a = createPropertyAssignment(ve, tp, me);
					db.getAssignment().add(a);
				}
			}
		}
			
		// 9
		private void doRDomainPatternExprToMappingDomainVarAssignment(@NonNull Variable v, @NonNull Property pp, @NonNull OCLExpression e) throws CompilerChainException {
			Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
			if ((e instanceof VariableExp) && !sharedDomainVars.contains(((VariableExp)e).getReferredVariable()) ) {
				String pn = pp.getName();
				Variable rev = ClassUtil.nonNullState((Variable) ((VariableExp) e).getReferredVariable());
				RealizedVariable mv = (RealizedVariable) doRVarToMRealizedVar(v);
				Variable mev = doRVarToMVar(rev);
				db.getRealizedVariable().add(mv);
				VariableExp ve = createVariableExp(mv);
				Property tp = getProperty(mv.getType(), pn);
				VariableExp me = createVariableExp(mev);
				PropertyAssignment a = createPropertyAssignment(ve, tp, me);
				db.getAssignment().add(a);
			}
		}
			
		// 16
		private void doRDomainToMComposedMappingGuard(@NonNull OCLExpression e, @NonNull Mapping cm) throws CompilerChainException {			
			// when
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
					List<org.eclipse.ocl.pivot.@NonNull Package> up = ClassUtil.nullFree(dir.getUsedPackage());
					if (rt != dir.getTransformation())
						return;
					// init
					GuardPattern mg = cm.getGuardPattern();
					CoreDomain cd = qvtr2qvtc.whenCoreDomain(cm, dn);
					GuardPattern cmdg = cd.getGuardPattern();
					// where
					BottomPattern mb = cm.getBottomPattern();
					assert mb != null;
					@NonNull Variable mv = doRVarToMVar(v);
					// assign
					VariableExp ve1 = createVariableExp(tcv);
					VariableExp ve2 = createVariableExp(mv);
					Property tp = getProperty(mv.getType(), mv.getName());
					PropertyCallExp pe = createPropertyCallExp(ve1, tp);
					OperationCallExp ee = createOperationCallExp(pe, "=", ve2);
					Predicate pd = createPredicate(ee);
					mg.getPredicate().add(pd);
					TypedModel mdir = getTypedModel(tmn, up);
					cd.setTypedModel(mdir);
					cmdg.getBindsTo().add(mv);
					cd.setGuardPattern(cmdg);
				}
			}
		}

		// 21
		private void doRDomainToMDBottomForEnforcementOfNonIdentityPropPrimitive() throws CompilerChainException
		{
			// when
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
					Mapping cm = qvtr2qvtc.whenMapping(r, m.getName()+"_forNonIdentityProp");
					BottomPattern bp = cm.getBottomPattern();
					cm.getGuardPattern();
					// where
					@NonNull Variable mv = doRVarToMVar(v);
					@NonNull OCLExpression me = doRExpToMExp(e);
					// where
					doRDomainToMComposedMappingGuard(e, cm);
					// assign
					VariableExp ve = createVariableExp(mv);
					Property tp = getProperty(mv.getType(), pn);
					PropertyAssignment a = createPropertyAssignment(ve, tp, me);
					bp.getAssignment().add(a);
					m.getLocal().add(cm);
				}
			}
		}
		
		// 23
		/*
		 * Creates the assignment of the middle model to the L/R models
		 */
		private void doRDomainVarToMDBottomAssignmnetForEnforcement() throws CompilerChainException
		{
			Variable v = ClassUtil.nonNullState(te.getBindsTo());
			Variable mv = doRVarToMVar(v);
			VariableExp ve1 = createVariableExp(tcv);
			Property tp = getProperty(tcv.getType(), v.getName());
			VariableExp ve2 = createVariableExp(mv);
			PropertyAssignment a = createPropertyAssignment(ve1, tp, ve2);
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
		
		// 17
		protected void doRDomainToMDBottomForEnforcement(@NonNull Set<@NonNull Predicate> predicatesWithoutVarBindings,  @NonNull Set<@NonNull Variable> unboundDomainVars) throws CompilerChainException
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
		
		// 28
		protected void doROppositeDomainVarsToTraceClassProps(@NonNull Set<@NonNull Variable> domainVars) throws CompilerChainException {			
			// check
			for (@NonNull Variable dv : domainVars) {
				TemplateExp dvte = qvtr2qvtc.getTemplateExpression(dv);
//				if (dvte instanceof ObjectTemplateExp) {
					// tp=dv:T{...} => tcv.tp := dv;
					Variable mdv = doRVarToMVar(dv);
					VariableExp ve1 = createVariableExp(tcv);
					Property tp = getProperty(tcv.getType(), dv.getName());
					VariableExp ve2 = createVariableExp(mdv);
					PropertyAssignment a = createPropertyAssignment(ve1, tp, ve2);
					mb.getAssignment().add(a);
//				}
/*				else if (dvte instanceof CollectionTemplateExp) {
					// tp=dv:T{...} => tcv.tp := dv;
					Variable mdv = doRVarToMVar(dv);
//					VariableExp ve1 = createVariableExp(tcv);
					VariableExp ve2 = createVariableExp(mdv);
					VariableAssignment a = createVariableAssignment(mdv, ve2);
					mb.getAssignment().add(a);
				} */
/*				else if (dvte instanceof CollectionTemplateExp) {
					CollectionTemplateExp collectionTemplateExp = (CollectionTemplateExp)dvte;
				} */
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
		protected void doRWhenPatternToMGuardPattern() throws CompilerChainException {			
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
				doRVarSetToDGVarSet(unsharedWhenVars, mg);
			}
		}

		protected @NonNull Set<@NonNull Variable> getOppositeDomainVars() {
			Set<@NonNull Variable> oppositeDomainVars = new HashSet<@NonNull Variable>();
			for (Domain d : ClassUtil.nullFree(rOtherDomains)) {
				for (DomainPattern pattern : ClassUtil.nullFree(((RelationDomain) d).getPattern())) {
					oppositeDomainVars.addAll(ClassUtil.nullFree(pattern.getBindsTo()));
				}
			}
			return oppositeDomainVars;
		}

		protected @NonNull TypedModel getTypedModel(@NonNull String tmn, @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> up) {
/*			for (@NonNull TypedModel tm : ClassUtil.nullFree(mt.getModelParameter())) {
				if (tmn.equals(tm.getName())) {
					if (tm.getUsedPackage().equals(up)) {
						return tm;
					}
				}
			}
			return null; */
			return getCoreTypedModel(mt, tmn, up);
		}

		protected void setAttributes() {
			mb.getRealizedVariable().add(tcv);
			//mb.getVariable().addAll(mbvars);
			md.setTypedModel(mdir);
			md.setIsEnforceable(true);
		}

		@Override
		public @NonNull String toString() {
			return r.getName() + "::" + rd.getName() + " => " + m.getName() + "::" + md.getName();
		}
		
		protected abstract void where(@NonNull Set<@NonNull Variable> whenVars, @NonNull Set<@NonNull Predicate> rpSet,
				@NonNull Set<@NonNull Variable> sharedDomainVars, @NonNull Set<@NonNull Variable> unsharedWhereVars) throws CompilerChainException;
	}

	protected @NonNull final QVTrToQVTc qvtr2qvtc;

	protected AbstractQVTr2QVTcRelations(@NonNull QVTrToQVTc qvtr2qvtc) {
		super(qvtr2qvtc.getEnvironmentFactory());
		this.qvtr2qvtc = qvtr2qvtc;
	}
	
	// 33
	protected void doRVarSetToDGVarSet(@NonNull Iterable<@NonNull Variable> rvSeq, @NonNull GuardPattern dg) {
		for (@NonNull Variable rv : rvSeq) {
			qvtr2qvtc.whenVariable(dg, rv);
		}
	}
	
	// 34	
	protected void doRVarSetToMBVarSet(@NonNull Iterable<@NonNull Variable> rvSeq, @NonNull BottomPattern mb) {
		for (@NonNull Variable rv : rvSeq) {
			qvtr2qvtc.whenVariable(mb, rv);
		}
	}
	
	protected @NonNull Variable doRVarToMVar(@NonNull Variable rv) {
		return qvtr2qvtc.getCoreVariable(rv);
	}
	
	// 36
	protected @NonNull RealizedVariable doRVarToMRealizedVar(@NonNull Variable rv, @NonNull BottomPattern pattern) {		
		RealizedVariable mv = qvtr2qvtc.whenRealizedVariable(pattern, rv);
		return mv;
	}
	
	private @NonNull /*Realized*/Variable doRVarToMRealizedVar(@NonNull Variable rv) {		
		@NonNull /*Realized*/Variable mv = /*(RealizedVariable)*/ qvtr2qvtc.getCoreVariable(rv);
		return mv;
	}
	
	// 39
	private void doRWhenRelCallArgToMGuardPredicate(@NonNull Relation r, @NonNull VariableExp ve,
			@NonNull RelationDomain d, @NonNull GuardPattern mg, @NonNull String vdId) throws CompilerChainException {
		Type tc = qvtr2qvtc.getTraceClass(r);
		String dvn = ClassUtil.nonNullState(d.getRootVariable().get(0).getName());
		Variable v = (Variable) ClassUtil.nonNullState(ve.getReferredVariable());
		Variable vd = qvtr2qvtc.whenVariable(mg, tc.getName()+vdId+"_v", tc);
		Variable mv = doRVarToMVar(v);
		VariableExp pve = createVariableExp(vd);
		VariableExp ave = createVariableExp(mv);
		Property pep = getProperty(vd.getType(), dvn);
		PropertyCallExp pe = createPropertyCallExp(pve, pep);
		OperationCallExp ee = createOperationCallExp(pe, "=", ave);
		Predicate mgp = createPredicate(ee);
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
	
	/**
	 * Return all variables defined in all domains.
	 */
	protected @NonNull Set<@NonNull Variable> getAllDomainVars(@NonNull Relation r) {
		Set<@NonNull Variable> allDomainVars = new HashSet<@NonNull Variable>();
		for (@NonNull Domain d : ClassUtil.nullFree(r.getDomain())) {
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

	protected @NonNull List<@NonNull RelationDomain> getOtherDomains(@NonNull RelationDomain rd) {
		List<@NonNull RelationDomain> rOtherDomains = new ArrayList<@NonNull RelationDomain>();
		for (@NonNull Domain d : ClassUtil.nullFree(rd.getRule().getDomain())) {
			if ((d instanceof RelationDomain) && (d != rd)) {
				rOtherDomains.add((RelationDomain)d);
			}
		}
		return rOtherDomains;
	}

	protected @NonNull Set<@NonNull Predicate> getPredicates(@NonNull Relation r) {
		Set<@NonNull Predicate> rpSet = new HashSet<@NonNull Predicate>();
		Pattern rWhere = r.getWhere();
		if (rWhere != null) {
			rpSet.addAll(rejectRelationCallPredicates(ClassUtil.nullFree(rWhere.getPredicate())));
		}
		return rpSet;
	}

	protected @NonNull Property getProperty(/*@NonNull*/ Type traceClass, /*@NonNull*/ String name) throws CompilerChainException {
		assert (traceClass != null) && (name != null);
		if (traceClass instanceof org.eclipse.ocl.pivot.Class) {
			for (@NonNull Property p : ClassUtil.nullFree(((org.eclipse.ocl.pivot.Class)traceClass).getOwnedProperties())) {
				if (name.equals(p.getName()))
					return p;
			}
		}
		throw new CompilerChainException("No " + traceClass + "::" + name + " in the trace class");
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
		unsharedWhereVars.addAll(sharedDomainVars);			// FIXME this stinks
		return unsharedWhereVars;
	}

	/**
	 * Return all variables used in the when clause.
	 */
	protected @NonNull Set<@NonNull Variable> getWhenVars(@NonNull Relation r) {
		Set<@NonNull Variable> whenVars = new HashSet<@NonNull Variable>();
		Pattern rWhen = r.getWhen();
		if (rWhen != null) {
			whenVars.addAll(ClassUtil.nullFree(rWhen.getBindsTo()));
		}
		return whenVars;
	}

	/**
	 * Return all variables used in the where clause.
	 */
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

	protected void where(@NonNull Relation r, @NonNull List<@NonNull ? extends AbstractRelationDomain2CoreDomain> relation2mappings) throws CompilerChainException {
		Set<@NonNull Variable> allDomainVars = getAllDomainVars(r);
		Set<@NonNull Variable> whenVars = getWhenVars(r);
		Set<@NonNull Variable> whereVars = getWhereVars(r);
		Set<@NonNull Predicate> rpSet = getPredicates(r);
		Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
		Set<@NonNull Variable> unsharedWhereVars = getUnsharedWhereVars(whereVars, whenVars, sharedDomainVars, allDomainVars);
//		Set<@NonNull Variable> unsharedWhenVars = getUnsharedWhenVars(whenVars, allDomainVars);
		for (@NonNull AbstractRelationDomain2CoreDomain relation2mapping : relation2mappings) {
			relation2mapping.where(whenVars, rpSet, sharedDomainVars, unsharedWhereVars);
		}
		// setAttributes() {
		for (@NonNull AbstractRelationDomain2CoreDomain relation2mapping : relation2mappings) {
			relation2mapping.setAttributes();
		}
	}
}
