package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class SubTemplateToTraceClassProps extends AbstractRule implements
		ConstrainedRule {
	
	public class SubTemplateToTraceClassPropsRecord
			extends AbstractTraceRecord implements TraceRecord {
		
		// Relations
		private ObjectTemplateExp t;
		private Variable tv;
		
		// Core
		private EClass rc;
		private EReference a;
		/**
		 * @return the t
		 */
		public ObjectTemplateExp getT() {
			return t;
		}
		/**
		 * @param t the t to set
		 */
		public void setT(ObjectTemplateExp t) {
			this.t = t;
		}
		/**
		 * @return the tv
		 */
		public Variable getTv() {
			return tv;
		}
		/**
		 * @param tv the tv to set
		 */
		public void setTv(Variable tv) {
			this.tv = tv;
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
		
		
	}
	
	SubTemplateToTraceClassPropsRecord record;
	
	String vn;

	@Override
	public TraceRecord creareTrace() {
		record = new SubTemplateToTraceClassPropsRecord();
		return record;
	}
	
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> qvtcModelElements) {
		
		List<EObject> result = new ArrayList<EObject>(); 
		EReference a = EcoreFactory.eINSTANCE.createEReference();
		record.setA(a);
		result.add(a);
		return result;
	}
	
	public void setAttributes() {
		record.getA().setName(record.getTv().getName());
		record.getA().setEType(record.getTv().getType().eClass());
		record.getRc().getEStructuralFeatures().add(record.getA());
	}
	
	@Override
	public void where(QvtrToQvtcTransformation transformation) {
		SubTemplateToTraceClassProps rule = new SubTemplateToTraceClassProps();
		for (PropertyTemplateItem part : record.getT().getPart()) {
			if (part.getValue() instanceof ObjectTemplateExp) {
				SubTemplateToTraceClassPropsRecord stTotcpRecord = (SubTemplateToTraceClassPropsRecord) rule.creareTrace();
				stTotcpRecord.setRc(record.getRc());
				stTotcpRecord.setT((ObjectTemplateExp) part.getValue());
				stTotcpRecord.setTv(((ObjectTemplateExp)part.getValue()).getBindsTo());
				transformation.executeRule(rule, stTotcpRecord);
			}
		}
		
	}
	
	

}
