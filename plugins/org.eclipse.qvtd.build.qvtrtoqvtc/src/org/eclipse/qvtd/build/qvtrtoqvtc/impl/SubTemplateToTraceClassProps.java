package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class SubTemplateToTraceClassProps extends AbstractRule {
	
	
	// Relations
	public static final BindingKey<ObjectTemplateExp> t = new BindingKey<ObjectTemplateExp>("t");
	public static final BindingKey<PropertyTemplateItem> pt = new BindingKey<PropertyTemplateItem>("pt");
	public static final BindingKey<ObjectTemplateExp> tp = new BindingKey<ObjectTemplateExp>("pt");
	public static final BindingKey<Variable> tv = new BindingKey<Variable>("tv");
	public static final BindingKey<Type> c = new BindingKey<Type>("c");
		
	// Core
	public static final BindingKey<EClass> rc = new BindingKey<EClass>("rc");
	public static final BindingKey<EReference> a = new BindingKey<EReference>("a");
	
	private String vn;
	
	@Override
	public boolean when(QvtrToQvtcTransformation transformation,  Resource qvtrModel) {
		vn = record.getBindings().get(tv).getName();
		return true;
	}
	
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> qvtcModelElements) {
		
		List<EObject> result = new ArrayList<EObject>(); 
		EReference a = EcoreFactory.eINSTANCE.createEReference();
		record.getBindings().put(SubTemplateToTraceClassProps.a, a);
		result.add(a);
		return result;
	}
	
	public void setAttributes() {
		record.getBindings().get(a).setName(vn);
		record.getBindings().get(a).setEType((EClassifier) record.getBindings().get(c));
		record.getBindings().get(rc).getEStructuralFeatures().add(record.getBindings().get(a));
	}
	
	@Override
	public void where(QvtrToQvtcTransformation transformation) {
		SubTemplateToTraceClassProps rule = new SubTemplateToTraceClassProps();
		for (PropertyTemplateItem part : record.getBindings().get(SubTemplateToTraceClassProps.t).getPart()) {
			if (part.getValue() instanceof ObjectTemplateExp) {
				Bindings bindings = new Bindings();
				bindings.put(SubTemplateToTraceClassProps.t, record.getBindings().get(SubTemplateToTraceClassProps.t));
				bindings.put(SubTemplateToTraceClassProps.pt, part);
				bindings.put(SubTemplateToTraceClassProps.tp, (ObjectTemplateExp)part.getValue());
				bindings.put(SubTemplateToTraceClassProps.tv, ((ObjectTemplateExp)part.getValue()).getBindsTo());
				bindings.put(SubTemplateToTraceClassProps.c, ((ObjectTemplateExp)part.getValue()).getBindsTo().getType());
				bindings.put(SubTemplateToTraceClassProps.rc, record.getBindings().get(rc));
				TraceRecord stTotcpRecord = rule.creareTraceRecord(bindings);
				transformation.executeRule(rule, stTotcpRecord);
			}
		}
		
	}

}
