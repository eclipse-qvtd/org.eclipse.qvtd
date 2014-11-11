package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToMappingTransformation
		extends AbstractRule
		implements ConstrainedRule {
	
	public class RelationalTransformationToMappingTransformationRecord
		extends AbstractTraceRecord implements TraceRecord {
		
		// Relations
		private RelationalTransformation rt;
		private TypedModel rtm;
		
		// Core
		private Transformation mt;
		private TypedModel mtm;
		/**
		 * @return the rt
		 */
		public RelationalTransformation getRt() {
			return rt;
		}
		/**
		 * @param rt the rt to set
		 */
		public void setRt(RelationalTransformation rt) {
			this.rt = rt;
		}
		/**
		 * @return the rtm
		 */
		public TypedModel getRtm() {
			return rtm;
		}
		/**
		 * @param rtm the rtm to set
		 */
		public void setRtm(TypedModel rtm) {
			this.rtm = rtm;
		}
		/**
		 * @return the coreTransformation
		 */
		public Transformation getMt() {
			return mt;
		}
		/**
		 * @param coreTransformation the coreTransformation to set
		 */
		public void setMt(Transformation coreTransformation) {
			this.mt = coreTransformation;
		}
		/**
		 * @return the mtm
		 */
		public TypedModel getMtm() {
			return mtm;
		}
		/**
		 * @param mtm the mtm to set
		 */
		public void setMtm(TypedModel mtm) {
			this.mtm = mtm;
		}
		
		@Override
		public boolean matches(ConstrainedRule rule, List<Object> inputElements) {
			return rule instanceof RelationalTransformationToMappingTransformation
					&& inputElements.contains(rt)
					&& inputElements.contains(rtm);
		}
		
		
	}
	
	private String rtn, tmn;
	
	private RelationalTransformationToMappingTransformationRecord record;
	
	@Override
	public TraceRecord creareTrace() {
		record = new RelationalTransformationToMappingTransformationRecord();
		return record;
	}
	
	public boolean when(QvtrToQvtcTransformation transformation, List<Object> inputElements) {
		RelationalTransformation rt = null;
		TypedModel rtm = null;
		for (Object e : inputElements) {
			if (e instanceof RelationalTransformation) {
				rt = (RelationalTransformation) e;
			} else if (e instanceof TypedModel) {
				rtm = (TypedModel) e;
			} else {
				// Exception?
				System.out.println("Wrong type for trace.");
			}
		}
		if (rt != null && rtm != null
				&& rt.getModelParameter().contains(rtm)) {
			record.setRtm(rtm);
			tmn = rtm.getName();
			record.setRt(rt);
			rtn = rt.getName();
			return true;
		} else {
			return false;
		}
	}


	@Override
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> outputModelElements) {
		// Search the output model first!
		List<EObject> results = new ArrayList<EObject>();
		Transformation mt;
		if (outputModelElements.containsKey(Transformation.class)) {
			mt = (Transformation) outputModelElements.get(Transformation.class).get(0);
		} else {	
			mt = QVTbaseFactory.eINSTANCE.createTransformation();
			results.add(mt);
		}
		record.setMt(mt);
		TypedModel mtm = null;
		mtm = QVTbaseFactory.eINSTANCE.createTypedModel();
		results.add(mtm);
		record.setMtm(mtm);
		return results;
	}

	@Override
	public void setAttributes() {
		record.getMt().setName(rtn);
		record.getMtm().setName(tmn);
		record.getMt().getModelParameter().add(record.getMtm());
		record.getMtm().getUsedPackage().addAll(record.getRtm().getUsedPackage());
	}
	
	@Override
	public void where(QvtrToQvtcTransformation transformation) {
		//ConstrainedRule rule = new TypedModelToTypedModel();
		//List<EObject> args = new ArrayList<EObject>(record.getRelationalTransformation().getModelParameter());
		//rule.setInputElements(args);
		//transformation.executeRule(rule);
	}
	
	public List<List<Object>> getLoopData(Resource inputModel) {
		List<List<Object>> loopData = new ArrayList<List<Object>>();
		EClass rtEClass = QVTrelationFactory.eINSTANCE.createRelationalTransformation().eClass();
		TreeIterator<EObject> it = inputModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo.eClass().equals(rtEClass)) {
				for (TypedModel rtm : ((RelationalTransformation)eo).getModelParameter()) {
					List<Object> args = new ArrayList<Object>();
					args.add(eo);
					args.add(rtm);
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
