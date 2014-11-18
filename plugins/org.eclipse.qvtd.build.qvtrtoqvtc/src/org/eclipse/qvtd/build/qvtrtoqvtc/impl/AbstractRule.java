package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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
	
	protected TraceRecord record;
	
	// Does a partial matching, i.e. it only verifies that the trace record
	// has the same values for the keys that the binding has (usually only
	// the input model)
	public boolean matchBindings(TraceRecord tr, Bindings bindings) {
			
		boolean match = true;
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field f : fields) {
			Class<?> t = f.getType();
		    if (Modifier.isStatic(f.getModifiers()) && (t == BindingKey.class)) {
		    	try {
		    		Object key = f.get(this);
					if (bindings.get(key) != null) {
						match &= (bindings.get(key).equals(tr.getBindings().get(key)));
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } 
		}
		return match;
	}
	
	public List<Bindings> findInputMatches(Resource inputModel) {
		return new ArrayList<Bindings>();
	}
	

	public TraceRecord creareTraceRecord(Bindings bindings) {
		record = new AbstractTraceRecord(bindings); 
		return record;
	}
	
	public boolean when(QvtrToQvtcTransformation transformation, Resource qvtrModel) {
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
