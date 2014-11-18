package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToMappingTransformation
		extends AbstractRule {
	
	// Relations
	public static final BindingKey<RelationalTransformation> rt = new BindingKey<RelationalTransformation>("rt");
	public static final BindingKey<TypedModel> rtm = new BindingKey<TypedModel>("rtm");
	
	// Core
	public static final BindingKey<Transformation> mt = new BindingKey<Transformation>("mt");
	public static final BindingKey<TypedModel> mtm = new BindingKey<TypedModel>("mtm");
	
	public String rtn;
	public String tmn;
	
	@Override
	public boolean when(QvtrToQvtcTransformation transformation, Resource qvtrModel) {
		RelationalTransformation rt = record.getBindings().get(RelationalTransformationToMappingTransformation.rt);
		TypedModel rtm = record.getBindings().get(RelationalTransformationToMappingTransformation.rtm);
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
		record.getBindings().put(RelationalTransformationToMappingTransformation.mt, mt);
		TypedModel mtm = QVTbaseFactory.eINSTANCE.createTypedModel();
		results.add(mtm);
		mt.getModelParameter().add(mtm);
		record.getBindings().put(RelationalTransformationToMappingTransformation.mtm, mtm);
		return results;
	}

	@Override
	public void setAttributes() {
		record.getBindings().get(RelationalTransformationToMappingTransformation.mt).setName(rtn);;
		record.getBindings().get(RelationalTransformationToMappingTransformation.mtm).setName(tmn);
		record.getBindings().get(RelationalTransformationToMappingTransformation.mt).getModelParameter().add(record.getBindings().get(RelationalTransformationToMappingTransformation.mtm));
		record.getBindings().get(RelationalTransformationToMappingTransformation.mtm).getUsedPackage().addAll(record.getBindings().get(RelationalTransformationToMappingTransformation.rtm).getUsedPackage());
	}
	
	public List<Bindings> findInputMatches(Resource inputModel) {
		List<Bindings> matches = new ArrayList<Bindings>();
		TreeIterator<EObject> it = inputModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof RelationalTransformation) {
				for (TypedModel rtm : ((RelationalTransformation)eo).getModelParameter()) {
					Bindings bindingsr = new Bindings();
					bindingsr.put(RelationalTransformationToMappingTransformation.rt, (RelationalTransformation)eo);
					bindingsr.put(RelationalTransformationToMappingTransformation.rtm, rtm);
					matches.add(bindingsr);
				}
				
			} 
			/*
			else if(eo.eClass().getEAllSuperTypes().contains(rtEClass)) {
			}
			*/
		}
		return matches;
	}
	
	

}
