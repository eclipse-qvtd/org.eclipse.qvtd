package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.DomainVarsSharedWithWhenToDgVars.DomainVarsSharedWithWhenToDgVarsRecord;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RWhenPatternToMGuardPattern.RWhenPatternToMGuardPatternRecord;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class TopLevelRelationForMappingForEnforcement extends AbstractRule
		implements ConstrainedRule {

	
	public class TopLevelRelationForMappingForEnforcementRecord
			extends AbstractTraceRecord implements TraceRecord {
		
		// Relations
		Relation r;
		RelationDomain rd;
		
		// Core
		Mapping m;
		CoreDomain md;
		/**
		 * @return the r
		 */
		public Relation getR() {
			return r;
		}
		/**
		 * @param r the r to set
		 */
		public void setR(Relation r) {
			this.r = r;
		}
		/**
		 * @return the rd
		 */
		public RelationDomain getRd() {
			return rd;
		}
		/**
		 * @param rd the rd to set
		 */
		public void setRd(RelationDomain rd) {
			this.rd = rd;
		}
		/**
		 * @return the m
		 */
		public Mapping getM() {
			return m;
		}
		/**
		 * @param m the m to set
		 */
		public void setM(Mapping m) {
			this.m = m;
		}
		/**
		 * @return the md
		 */
		public CoreDomain getMd() {
			return md;
		}
		/**
		 * @param md the md to set
		 */
		public void setMd(CoreDomain md) {
			this.md = md;
		}
		
	}
	
	TopLevelRelationForMappingForEnforcementRecord record;
	
	private Transformation mt;
	String rn, dn, tmn;
	
	private List<EObject> rOppositeDomains;
	private RealizedVariable tcv;

	private Variable mtev;

	private GuardPattern dg;

	private Set<Variable> domainVarsSharedWithWhen;

	private EList<Variable> domainVars;
	
	
	@Override
	public TraceRecord creareTraceRecord() {
		record = new TopLevelRelationForMappingForEnforcementRecord();
		return record;
	}
	
//	@Override
	public boolean when(QvtrToQvtcTransformation transformation, List<Object> inputElements) {
		RelationalTransformation rt;
		Relation r = null;
		RelationDomain rd = null;
		for (Object e : inputElements) {
			if (e instanceof Relation) {
				r = (Relation) e;
			} else if (e instanceof RelationDomain) {
				rd = (RelationDomain) e;
			} else if (e instanceof List) {
				rOppositeDomains = (List<EObject>) e;
			} else {
				// Exception?
				System.out.println("Wrong type for trace.");
			}
		}
		rt = (RelationalTransformation) r.getTransformation();
		RelationalTransformationToMappingTransformation rtTomtRule = new RelationalTransformationToMappingTransformation();
		List<Object> args = new ArrayList<Object>();
		args.add(rt);
/*		TraceRecord rtTomtRecord = transformation.executeRule(rtTomtRule, args);
		mt = ((RelationalTransformationToMappingTransformationRecord)rtTomtRecord).getMt();
		if (r != null && rd != null && r.getDomain().contains(rd)
				&& r.getTransformation().equals(rt)
				&& rd.getTypedModel().getTransformation().equals(rt)) {
			record.setR(r);
			record.setRd(rd);
			rn  = r.getName();
			dn = rd.getName();
			tmn = rd.getTypedModel().getName();
			domainVars = rd.getPattern().getBindsTo(); */
			return true;
//		} else {
//			return false;
//		}
	}
	
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> outputModelElements) {
		List<EObject> results = new ArrayList<EObject>();
		// There should't be any other mapping with the same name!
		Mapping m = QVTcoreFactory.eINSTANCE.createMapping();
		results.add(m);
		record.setM(m);
		m.setGuardPattern(QVTcoreBaseFactory.eINSTANCE.createGuardPattern());
		BottomPattern mb = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		tcv = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
		mb.getBindsTo().add(tcv);
		CoreDomain md = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
		results.add(md);
		record.setMd(md);
		if (outputModelElements.containsKey(TypedModel.class)) {
			for (EObject mdir : outputModelElements.get(TypedModel.class)) {
				if (((TypedModel)mdir).getName().equals(tmn)) {
					md.setTypedModel((TypedModel) mdir);
					break;
				}
			}
		} else {	
			// Exception?? The typed model should exist! Executing the transformation
			// rule once dosen't guarantee that all the typed models have been 
			// transformed?
		}
		dg = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
		md.setGuardPattern(dg);
		BottomPattern db = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		mtev = PivotFactory.eINSTANCE.createVariable();
		db.getBindsTo().add(mtev);
		results.add(mtev);
		return results;
	}
	
	
	public void setAttributes() {
		
		record.getM().setName(rn+'_'+dn);
		record.getM().setTransformation(mt);
		record.getMd().setName(dn);
		record.getMd().setIsEnforceable(true);
	}
	
	@Override
	public void where(QvtrToQvtcTransformation transformation) {
		
		// T3
		ConstrainedRule rule = new RWhenPatternToMGuardPattern();
		RWhenPatternToMGuardPatternRecord rwpTomgpRecord = (RWhenPatternToMGuardPatternRecord) rule.creareTraceRecord(null);
		
		
		
		// T4
		rule = new DomainVarsSharedWithWhenToDgVars();
		DomainVarsSharedWithWhenToDgVarsRecord dvswwTodvRecord = (DomainVarsSharedWithWhenToDgVarsRecord) rule.creareTraceRecord(null);
		dvswwTodvRecord.setDomainVarsSharedWithWhen(domainVarsSharedWithWhen);
		dvswwTodvRecord.setDg(dg);
		
	}
	
	
	public List<Bindings> findInputMatches(Resource inputModel) {
		List<List<Object>> loopData = new ArrayList<List<Object>>();
		EClass rEClass = QVTrelationFactory.eINSTANCE.createRelation().eClass();
		TreeIterator<EObject> it = inputModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo.eClass().equals(rEClass)) {
				for (Domain rd : ((Relation)eo).getDomain()) {
					List<Object> args = new ArrayList<Object>();
					args.add(eo);
					args.add(rd);
					List<EObject> rOppositeDomains = new ArrayList<EObject>(((Relation)eo).getDomain());
					rOppositeDomains.remove(rd);
					args.add(rOppositeDomains);
					loopData.add(args);
				}
			} 
			/*
			else if(eo.eClass().getEAllSuperTypes().contains(rtEClass)) {
			}
			*/
		}
		return null;//loopData;
	}

	@Override
	public TraceRecord creareTraceRecord(Bindings bindings) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
