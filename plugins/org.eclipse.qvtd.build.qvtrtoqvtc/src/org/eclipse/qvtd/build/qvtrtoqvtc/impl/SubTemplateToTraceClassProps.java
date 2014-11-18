package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class SubTemplateToTraceClassProps extends AbstractRule {
	
	
	// Relations
	public static final @NonNull Bindings.Key<ObjectTemplateExp> t = new Bindings.Key<ObjectTemplateExp>("t");
	public static final @NonNull Bindings.Key<PropertyTemplateItem> pt = new Bindings.Key<PropertyTemplateItem>("pt");
	public static final @NonNull Bindings.Key<ObjectTemplateExp> tp = new Bindings.Key<ObjectTemplateExp>("pt");
	public static final @NonNull Bindings.Key<Variable> tv = new Bindings.Key<Variable>("tv");
	public static final @NonNull Bindings.Key<Type> c = new Bindings.Key<Type>("c");
		
	// Core
	public static final @NonNull Bindings.Key<EClass> rc = new Bindings.Key<EClass>("rc");
	public static final @NonNull Bindings.Key<EReference> a = new Bindings.Key<EReference>("a");
	
	private TraceRecord  record;
	private String vn;

	@Override
	public TraceRecord creareTraceRecord(Bindings bindings) {
		record = new AbstractTraceRecord(bindings);
		return record;
	}
	
	@Override
	public boolean when(QvtrToQvtcTransformation transformation) {
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
				Bindings r = new Bindings();
				// TODO add other bindings!
				ObjectTemplateExp objectTemplateExp = (ObjectTemplateExp)part.getValue();
				r.put(SubTemplateToTraceClassProps.t, objectTemplateExp);
				r.put(SubTemplateToTraceClassProps.tv, objectTemplateExp.getBindsTo());
				r.put(SubTemplateToTraceClassProps.c, objectTemplateExp.getBindsTo().getType());
				r.put(SubTemplateToTraceClassProps.rc, record.getBindings().get(rc));
				
				TraceRecord stTotcpRecord = rule.creareTraceRecord(r);
				transformation.executeRule(rule, stTotcpRecord);
			}
		}
		
	}

}
