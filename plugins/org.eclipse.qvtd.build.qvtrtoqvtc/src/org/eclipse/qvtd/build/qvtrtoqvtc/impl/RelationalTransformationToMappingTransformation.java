package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToMappingTransformation
		extends AbstractRule {
	
	// Relations
	public final BindingKey<RelationalTransformation> rt = new BindingKey<RelationalTransformation>("rt");
	public final BindingKey<TypedModel> rtm = new BindingKey<TypedModel>("rtm");
	
	// Core
	public final BindingKey<Transformation> mt = new BindingKey<Transformation>("mt");
	public final BindingKey<TypedModel> mtm = new BindingKey<TypedModel>("mtm");
	
	
	private TraceRecord record;
	public String rtn;
	public String tmn;
	
	public boolean matchBindings(TraceRecord tr, Bindings bindings) {
		
		boolean match = true;
		if (bindings.get(rt) != null && tr.getBindings().get(rt) != null) {
			match &= (bindings.get(rt).equals(tr.getBindings().get(rt)));
		} else {
			match = false;
		}
		if (bindings.get(rtm) != null && tr.getBindings().get(rtm) != null) {
			match &= (bindings.get(rtm).equals(tr.getBindings().get(rtm)));
		} else {
			match = false;
		}
		return match;
	}
	
	@Override
	public TraceRecord creareTraceRecord(Bindings bindings) {
		record = new AbstractTraceRecord(bindings);
		return record;
	}
	
	public boolean when(QvtrToQvtcTransformation transformation) {
		RelationalTransformation rt = record.getBindings().get(this.rt);
		TypedModel rtm = record.getBindings().get(this.rtm);
		if (rt != null && rtm != null
				&& rt.getModelParameter().contains(rtm)) {
			rtn = rt.getName();
			tmn = rtm.getName();
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
		record.getBindings().put(this.mt, mt);
		TypedModel mtm = QVTbaseFactory.eINSTANCE.createTypedModel();
		results.add(mtm);
		record.getBindings().put(this.mtm, mtm);
		return results;
	}

	@Override
	public void setAttributes() {
		record.getBindings().get(this.mt).setName(rtn);;
		record.getBindings().get(this.mtm).setName(tmn);
		record.getBindings().get(this.mt).getModelParameter().add(record.getBindings().get(this.mtm));
		record.getBindings().get(this.mtm).getUsedPackage().addAll(record.getBindings().get(this.rtm).getUsedPackage());
	}
	
	public List<Bindings> findInputMatches(Resource inputModel) {
		List<Bindings> loopData = new ArrayList<Bindings>();
		TreeIterator<EObject> it = inputModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof RelationalTransformation) {
				for (TypedModel rtm : ((RelationalTransformation)eo).getModelParameter()) {
					Bindings r = new Bindings();
					r.put(this.rt, (RelationalTransformation)eo);
					r.put(this.rtm, rtm);
					loopData.add(r);
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
