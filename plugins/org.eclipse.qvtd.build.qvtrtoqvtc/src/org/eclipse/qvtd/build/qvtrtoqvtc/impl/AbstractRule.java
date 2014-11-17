package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;

public abstract class AbstractRule implements ConstrainedRule {
	
	public boolean matchBindings(TraceRecord tr, Bindings bindings) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Bindings> findInputMatches(Resource inputModel) {
		return new ArrayList<Bindings>();
	}
	
	public boolean when(QvtrToQvtcTransformation transformation) {
		return true;
	}
	
	public void where(QvtrToQvtcTransformation transformation) { }
	
	
	public void setAttributes() { }
	
	
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> outputModelElements) {
		return new ArrayList<EObject>();
	}
	
	public List<EObject> instantiateMiddleElements(Map<Class<? extends EObject>, List<EObject>> qvtcMiddleElements) {
		return new ArrayList<EObject>();
	}

}
