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
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
public class RelationToTraceClass extends AbstractRule {
	
	// Relations
	public final BindingKey<Relation> r = new BindingKey<Relation>("r");
	public final BindingKey<RelationDomain> rd = new BindingKey<RelationDomain>("rd");
	public final BindingKey<DomainPattern> rdp = new BindingKey<DomainPattern>("rdp");
	public final BindingKey<ObjectTemplateExp> t = new BindingKey<ObjectTemplateExp>("t");
	public final BindingKey<Variable> tv = new BindingKey<Variable>("tv");
	public final BindingKey<Type> c = new BindingKey<Type>("c");
	
	// Core
	public final BindingKey<EClass> rc = new BindingKey<EClass>("rc");
	public final BindingKey<EReference> a = new BindingKey<EReference>("a");
	
	@Override
	public boolean matchBindings(TraceRecord tr, Bindings bindings) {
		
		boolean match = true;
		if (bindings.get(c) != null && tr.getBindings().get(c) != null) {
			match &= (bindings.get(c).equals(tr.getBindings().get(c)));
		} else {
			match = false;
		}
		if (bindings.get(tv) != null && tr.getBindings().get(tv) != null) {
			match &= (bindings.get(tv).equals(tr.getBindings().get(tv)));
		} else {
			match = false;
		}
		if (bindings.get(t) != null && tr.getBindings().get(t) != null) {
			match &= (bindings.get(t).equals(tr.getBindings().get(t)));
		} else {
			match = false;
		}
		if (bindings.get(rdp) != null && tr.getBindings().get(rdp) != null) {
			match &= (bindings.get(rdp).equals(tr.getBindings().get(rdp)));
		} else {
			match = false;
		}
		if (bindings.get(rd) != null && tr.getBindings().get(rd) != null) {
			match &= (bindings.get(rd).equals(tr.getBindings().get(rd)));
		} else {
			match = false;
		}
		if (bindings.get(r) != null && tr.getBindings().get(r) != null) {
			match &= (bindings.get(r).equals(tr.getBindings().get(r)));
		} else {
			match = false;
		}
		return match;
	}
	
	private TraceRecord record;
	private String rn, vn;
	

	@Override
	public TraceRecord creareTraceRecord(Bindings bindings) {
		
		record = new AbstractTraceRecord(bindings); 
		return record;
	}
	
	@Override
	public boolean when(QvtrToQvtcTransformation transformation) {
		Relation r = record.getBindings().get(this.r);
		RelationDomain rd = record.getBindings().get(this.rd);
		DomainPattern rdp = record.getBindings().get(this.rdp);
		ObjectTemplateExp t = record.getBindings().get(this.t);
		Variable tv = record.getBindings().get(this.tv);
		Type c = record.getBindings().get(this.c);
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
			record.getBindings().put(this.rc, rc);
			results.add(rc);
			a = factory.createEReference();
			record.getBindings().put(this.a, a);
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
		ObjectTemplateExp t = record.getBindings().get(this.t); 
		for (PropertyTemplateItem part : t.getPart()) {
			if (part.getValue() instanceof ObjectTemplateExp) {
				Bindings r = new Bindings();
				// TODO add other bindings!
				r.put(SubTemplateToTraceClassProps.t, part.getValue());
				r.put(SubTemplateToTraceClassProps.tv, ((ObjectTemplateExp)part.getValue()).getBindsTo());
				r.put(SubTemplateToTraceClassProps.c, ((ObjectTemplateExp)part.getValue()).getBindsTo().getType());
				r.put(SubTemplateToTraceClassProps.rc, record.getBindings().get(rc));
				
				TraceRecord stTotcpRecord = rule.creareTraceRecord(r);
				transformation.executeRule(rule, stTotcpRecord);
			}
		}
	}

	@Override
	public List<Bindings> findInputMatches(Resource inputModel) {
		List<Bindings> loopData = new ArrayList<Bindings>();
		TreeIterator<EObject> it = inputModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof Relation) {
				for (Domain d : ((Relation)eo).getDomain()) {
					RelationDomain rd = (RelationDomain) d;
					if (rd.getPattern().getTemplateExpression() instanceof ObjectTemplateExp) {
						Bindings r = new Bindings();
						r.put(this.r, (Relation) eo);
						r.put(this.rd, rd);
						r.put(this.rdp, rd.getPattern());
						r.put(this.t, (ObjectTemplateExp) rd.getPattern().getTemplateExpression());
						r.put(this.tv, rd.getPattern().getTemplateExpression().getBindsTo());
						loopData.add(r);
					}
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
