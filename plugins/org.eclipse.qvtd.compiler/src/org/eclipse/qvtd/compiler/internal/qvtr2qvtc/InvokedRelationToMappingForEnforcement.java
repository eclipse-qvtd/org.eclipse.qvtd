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
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/*public*/ class InvokedRelationToMappingForEnforcement extends AbstractQVTr2QVTcRelations
{	
	private @NonNull String getCoreMappingName(@NonNull RelationCallExp ri, @NonNull RelationDomain rd) {
		@NonNull Relation ir = qvtr2qvtc.getInvokingRelationForRelationCallExp(ri);
		@NonNull Relation r = (@NonNull Relation) ClassUtil.nonNullState(rd.getRule());
		@NonNull String rn = ClassUtil.nonNullState(r.getName());
		@NonNull String irn = ClassUtil.nonNullState(ir.getName());
		@NonNull String dn = ClassUtil.nonNullState(rd.getName());
		return rn+'_'+irn+'_'+dn;
	}

	private class RelationDomain2CoreDomain extends AbstractRelationDomain2CoreDomain
	{
		private @NonNull Relation ir;
		private @NonNull RelationCallExp ri;

		public RelationDomain2CoreDomain(@NonNull RelationCallExp ri, @NonNull RelationDomain rd) {
			super(rd, getCoreMappingName(ri, rd));
			this.ri = ri;
			this.ir = qvtr2qvtc.getInvokingRelationForRelationCallExp(ri);
		}
		
		private void doIROppositeDomainsToMappingForEnforcement() {
			Set<@NonNull RelationDomain> rds = new HashSet<@NonNull RelationDomain>();
			for (Domain d : ClassUtil.nullFree(r.getDomain())) {
				rds.add((RelationDomain) d);
			}
			rds.remove(rd); // guard
			for (RelationDomain ord : rds) {
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
					Variable tev = ClassUtil.nonNullState(te.getBindsTo());
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
					domainTopVars.add(tev);
					Set<@NonNull Variable> sharedDomainVars = qvtr2qvtc.getSharedDomainVars(r);
					Set<@NonNull Variable> domainBottomUnSharedVars = new HashSet<@NonNull Variable>(domainVars);
					domainBottomUnSharedVars.removeAll(whenVars);
					domainBottomUnSharedVars.removeAll(sharedDomainVars);
					domainBottomUnSharedVars.remove(tev);
					Set<@NonNull Variable> domainBottomSharedVars = new HashSet<@NonNull Variable>(domainVars);
					domainBottomSharedVars.removeAll(whenVars);
					domainBottomSharedVars.retainAll(sharedDomainVars);
					domainBottomSharedVars.remove(tev);
					
					doRVarSetToDGVarSet(new ArrayList<@NonNull Variable>(domainTopVars), dg);
					doRVarSetToMBVarSet(new ArrayList<@NonNull Variable>(domainBottomUnSharedVars), db);
					doRVarSetToMBVarSet(new ArrayList<@NonNull Variable>(domainBottomSharedVars), mb);
					doRDomainPatternToMDBottomPattern(te);
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
		private void doRInvokerToMGuard() {
			// where
			List<@NonNull Domain> dseq = new ArrayList<@NonNull Domain>(ClassUtil.nullFree(r.getDomain()));
			List<@NonNull OCLExpression> arguments = ClassUtil.nullFree(ri.getArgument());
			for (@NonNull OCLExpression arg : arguments) {
				VariableExp a = (VariableExp) arg;
				@NonNull RelationDomain rd = (RelationDomain) dseq.get(arguments.indexOf(a));
				doRInvokerToMGuardPredicate(a);
			}
		}

		private void doRInvokerToMGuardPredicate(@NonNull VariableExp ve) {
			// when
			@NonNull Type tc = qvtr2qvtc.getTraceClass(ir);
			// check
			Variable v = (Variable) ClassUtil.nonNullState(ve.getReferredVariable());
			String vn = ClassUtil.nonNullState(v.getName());
			Variable dv = ClassUtil.nonNullState(rd.getRootVariable().get(0));
			// init
			Variable vd = qvtr2qvtc.whenVariable(mg, tc.getName()+"_v", tc);
			Predicate pd = qvtr2qvtc.createPredicate();
			OperationCallExp ee = qvtr2qvtc.createOperationCallExp();
			PropertyCallExp pe = qvtr2qvtc.createPropertyCallExp();
			VariableExp mve = qvtr2qvtc.createVariableExp();
			VariableExp ave = qvtr2qvtc.createVariableExp();
			// where
			Variable mdv = doRVarToMVar(dv);
			// assign
			pd.setConditionExpression(ee);
			ee.setOwnedSource(pe);
			pe.setOwnedSource(mve);
			mve.setReferredVariable(vd);
			mve.setType(vd.getType());
			@NonNull Property pep = getProperty(vd.getType(), vn);
			pe.setReferredProperty(pep);
			pe.setType(pep.getType());
			ee.setReferredOperation(getEqualsOperation());
			ee.setType(qvtr2qvtc.getStandardLibrary().getBooleanType());
			ave.setReferredVariable(mdv);
			ave.setType(mdv.getType());
			ee.getOwnedArguments().add(ave);
			
			mg.getPredicate().add(pd);
		}

		@Override
		protected void where(@NonNull Set<@NonNull Variable> whenVars, @NonNull Set<@NonNull Predicate> rpSet,
				@NonNull Set<@NonNull Variable> sharedDomainVars, @NonNull Set<@NonNull Variable> unsharedWhereVars) {
			Set<@NonNull Variable> oppositeDomainVars = getOppositeDomainVars();
			Set<@NonNull Variable> domainBottomUnSharedVars = new HashSet<@NonNull Variable>(domainVars);
			domainBottomUnSharedVars.removeAll(whenVars);
			domainBottomUnSharedVars.removeAll(sharedDomainVars);
			domainBottomUnSharedVars.remove(tev);
			Set<@NonNull Predicate> predicatesWithVarBindings = filterOutPredicatesThatReferToVars(rpSet, domainBottomUnSharedVars);
			Set<@NonNull Predicate> predicatesWithoutVarBindings = new HashSet<@NonNull Predicate>(rpSet);
			predicatesWithoutVarBindings.removeAll(predicatesWithVarBindings);
			Set<@NonNull Variable> domainTopVars = new HashSet<@NonNull Variable>(domainVars);
			domainTopVars.retainAll(whenVars);
			domainTopVars.add(tev);
			// Relation Calls
			// T5
			doRPredicateSetToMBPredicateSet(new ArrayList<@NonNull Predicate>(predicatesWithVarBindings), mb);
			doRVarSetToDGVarSet(new ArrayList<@NonNull Variable>(domainTopVars), dg);
			//T4
			doRVarSetToMBVarSet(new ArrayList<@NonNull Variable>(unsharedWhereVars), mb);
			//T3
			doIROppositeDomainsToMappingForEnforcement();
			doRInvokerToMGuard();
			doROppositeDomainVarsToTraceClassProps(oppositeDomainVars);
			doRWhenPatternToMGuardPattern();
			doRDomainToMDBottomForEnforcement(predicatesWithoutVarBindings, domainBottomUnSharedVars);
			doRRelImplToMBottomEnforcementOperation();
		}
	}
	
	public InvokedRelationToMappingForEnforcement(@NonNull QVTrToQVTc qvtr2qvtc) {
		super(qvtr2qvtc);
	}
	
	public void doInvokedRelationToMappingForEnforcement(@NonNull Relation r) {
		// check() {
		if (r.isIsTopLevel()) {
			return;
		}
		@NonNull List<@NonNull RelationDomain2CoreDomain> relation2mappings = new ArrayList<@NonNull RelationDomain2CoreDomain>();
		for (@NonNull RelationCallExp ri : qvtr2qvtc.getRelationCallExpsForRelation(r)) {
			for (@NonNull Domain d : ClassUtil.nullFree(r.getDomain())) {
				if (d.isIsEnforceable()) {
					RelationDomain rd = (RelationDomain)d;
					@NonNull DomainPattern dp = qvtr2qvtc.getDomainPattern(rd);
					TemplateExp templateExpression = dp.getTemplateExpression();
					if (templateExpression instanceof ObjectTemplateExp) {
						relation2mappings.add(new RelationDomain2CoreDomain(ri, rd));
					}
				}
			}
		}
		// where()
		where(r, relation2mappings);
	}
}
