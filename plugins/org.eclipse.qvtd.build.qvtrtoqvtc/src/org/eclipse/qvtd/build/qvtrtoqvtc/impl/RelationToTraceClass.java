package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.SubTemplateToTraceClassProps.SubTemplateToTraceClassPropsRecord;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class RelationToTraceClass extends AbstractRule implements
		ConstrainedRule {
	
	public class RelationToTraceClassRecord
		extends AbstractTraceRecord implements TraceRecord {
		
		// Relations
		private Relation r;
		private RelationDomain rd;
		
		// Core
		private EClass rc;
		private EReference a;
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
		 * @return the rc
		 */
		public EClass getRc() {
			return rc;
		}
		/**
		 * @param rc the rc to set
		 */
		public void setRc(EClass rc) {
			this.rc = rc;
		}
		/**
		 * @return the a
		 */
		public EReference getA() {
			return a;
		}
		/**
		 * @param a the a to set
		 */
		public void setA(EReference a) {
			this.a = a;
		}
		@Override
		public boolean matches(ConstrainedRule rule, List<Object> inputElements) {
			return rule instanceof RelationToTraceClass
					&& inputElements.contains(r)
					&& inputElements.contains(rd);
		}
						
	}
	
	private RelationToTraceClassRecord record;
	
	// The relation name
	private String rn, vn;
	

	@Override
	public TraceRecord creareTrace() {
		
		record = new RelationToTraceClassRecord(); 
		return record;
	}
	
	public boolean when(QvtrToQvtcTransformation transformation, List<Object> inputElements) {
		Relation r = null;
		RelationDomain rd = null;
		for (Object e : inputElements) {
			if (e instanceof Relation) {
				r = (Relation) e;
			} else if (e instanceof RelationDomain) {
				rd = (RelationDomain) e;
			}
		}
		if (r != null && rd != null
				&& r.getDomain().contains(rd)
				&& rd.getPattern().getTemplateExpression() instanceof ObjectTemplateExp) {
			record.setR(r);
			record.setRd(rd);
			rn = r.getName();
			return true;
		} else {
			return false;
		}
		
		
	}

	@Override
	public List<EObject> instantiateMiddleElements(Map<Class<? extends EObject>, List<EObject>> qvtcMiddleElements) {
		
		List<EObject> results = new ArrayList<EObject>();
		EcoreFactory factory = EcoreFactory.eINSTANCE;
		EClass rc = null;
		EReference a = null;
		if (qvtcMiddleElements.containsKey(EClass.class)) {
			for (EObject e : qvtcMiddleElements.get(EClass.class)) {
				if (((EClass) e).getName().equals("T" + rn)) {
					rc = (EClass) e;
				}
			}
			if (rc != null) {
				if (qvtcMiddleElements.containsKey(EReference.class)) {
					for (EObject e : qvtcMiddleElements.get(EReference.class)) {
						if (((EReference) e).getClass().equals(rc)
								&& ((EReference) e).getName().equals(vn)) {
							a = (EReference) e;
						}
					}
				}
			}
		}
		if (rc == null) {	
			rc = factory.createEClass();
			record.setRc(rc);
			results.add(rc);
			a = factory.createEReference();
			record.setA(a);
			results.add(a);
		}
		return results;
	}

	@Override
	public void setAttributes() {
		
		record.getRc().setName('T' + rn);
		record.getA().setName(vn);
		record.getA().setEType(record.getRd().getPattern().getTemplateExpression().getBindsTo().getType().eClass());
	}
	
	
	@Override
	public void where(QvtrToQvtcTransformation transformation) {
		SubTemplateToTraceClassProps rule = new SubTemplateToTraceClassProps();
		ObjectTemplateExp t = (ObjectTemplateExp) record.getRd().getPattern().getTemplateExpression(); 
		for (PropertyTemplateItem part : t.getPart()) {
			if (part.getValue() instanceof ObjectTemplateExp) {
				SubTemplateToTraceClassPropsRecord stTotcpRecord = (SubTemplateToTraceClassPropsRecord) rule.creareTrace();
				stTotcpRecord.setRc(record.getRc());;
				stTotcpRecord.setT((ObjectTemplateExp) part.getValue());
				stTotcpRecord.setTv(((ObjectTemplateExp)part.getValue()).getBindsTo());
				transformation.executeRule(rule, stTotcpRecord);
			}
		}
	}

	@Override
	public List<List<Object>> getLoopData(Resource inputModel) {
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
					loopData.add(args);
				}
			} 
			/*
			else if(eo.eClass().getEAllSuperTypes().contains(rtEClass)) {
			}
			*/
		}
		return loopData;
	}

}
