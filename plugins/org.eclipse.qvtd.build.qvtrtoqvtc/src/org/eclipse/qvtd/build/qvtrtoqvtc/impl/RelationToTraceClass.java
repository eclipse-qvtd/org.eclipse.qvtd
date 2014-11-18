package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
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
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class RelationToTraceClass extends AbstractRule {
	
	// Relations
	public static final BindingKey<Relation> r = new BindingKey<Relation>("r");
	public static final BindingKey<RelationDomain> rd = new BindingKey<RelationDomain>("rd");
	public static final BindingKey<DomainPattern> rdp = new BindingKey<DomainPattern>("rdp");
	public static final BindingKey<ObjectTemplateExp> t = new BindingKey<ObjectTemplateExp>("t");
	public static final BindingKey<Variable> tv = new BindingKey<Variable>("tv");
	public static final BindingKey<Type> c = new BindingKey<Type>("c");
	
	// Core
	public static final BindingKey<EClass> rc = new BindingKey<EClass>("rc");
	public static final BindingKey<EReference> a = new BindingKey<EReference>("a");
	
	private String rn, vn;
	
	@Override
	public boolean when(QvtrToQvtcTransformation transformation,  Resource qvtrModel) {
		Relation r = record.getBindings().get(RelationToTraceClass.r);
		RelationDomain rd = record.getBindings().get(RelationToTraceClass.rd);
		DomainPattern rdp = record.getBindings().get(RelationToTraceClass.rdp);
		ObjectTemplateExp t = record.getBindings().get(RelationToTraceClass.t);
		Variable tv = record.getBindings().get(RelationToTraceClass.tv);
		Type c = record.getBindings().get(RelationToTraceClass.c);
		if (r != null && rd != null && rdp != null && t != null && tv != null && c != null
				&& r.getDomain().contains(rd)
				&& rd.getPattern().equals(rdp)
				&& rdp.getTemplateExpression().equals(t)
				&& t.getBindsTo().equals(tv)
				&& tv.getType().equals(c)) {
			rn = r.getName();
			vn = tv.getName();
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
			record.getBindings().put(RelationToTraceClass.rc, rc);
			results.add(rc);
			a = factory.createEReference();
			record.getBindings().put(RelationToTraceClass.a, a);
			results.add(a);
		}
		return results;
	}

	@Override
	public void setAttributes() {
		
		record.getBindings().get(rc).setName('T' + rn);
		record.getBindings().get(a).setName(vn);
		record.getBindings().get(a).setEType((EClassifier) record.getBindings().get(c));
		record.getBindings().get(rc).getEStructuralFeatures().add(record.getBindings().get(a));
	}
	
	@Override
	public void where(QvtrToQvtcTransformation transformation) {
		SubTemplateToTraceClassProps rule = new SubTemplateToTraceClassProps();
		ObjectTemplateExp t = record.getBindings().get(RelationToTraceClass.t); 
		for (PropertyTemplateItem part : t.getPart()) {
			if (part.getValue() instanceof ObjectTemplateExp) {
				Bindings bindings = new Bindings();
				bindings.put(SubTemplateToTraceClassProps.t, t);
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

	@Override
	public List<Bindings> findInputMatches(Resource inputModel) {
		List<Bindings> matches = new ArrayList<Bindings>();
		TreeIterator<EObject> it = inputModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof Relation) {
				for (Domain d : ((Relation)eo).getDomain()) {
					RelationDomain rd = (RelationDomain) d;
					if (rd.getPattern().getTemplateExpression() instanceof ObjectTemplateExp) {
						Bindings bindings = new Bindings();
						bindings.put(RelationToTraceClass.r, (Relation) eo);
						bindings.put(RelationToTraceClass.rd, rd);
						bindings.put(RelationToTraceClass.rdp, rd.getPattern());
						bindings.put(RelationToTraceClass.t, (ObjectTemplateExp) rd.getPattern().getTemplateExpression());
						bindings.put(RelationToTraceClass.tv, rd.getPattern().getTemplateExpression().getBindsTo());
						matches.add(bindings);
					}
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
