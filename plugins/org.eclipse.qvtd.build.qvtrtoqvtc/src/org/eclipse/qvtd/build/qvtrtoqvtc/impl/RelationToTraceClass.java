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
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.PrimitivesBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class RelationToTraceClass extends AbstractRule
{
	// Relations
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	public static final @NonNull RelationsBindings.Key<Relation> RELATIONS_r = RELATIONS_BINDINGS.create((Relation)null, "r");
	public static final @NonNull RelationsBindings.Key<RelationDomain> RELATIONS_rd = RELATIONS_BINDINGS.create((RelationDomain)null, "rd");
	public static final @NonNull RelationsBindings.Key<DomainPattern> RELATIONS_rdp = RELATIONS_BINDINGS.create((DomainPattern)null, "rdp");
	public static final @NonNull RelationsBindings.Key<ObjectTemplateExp> RELATIONS_t = RELATIONS_BINDINGS.create((ObjectTemplateExp)null, "t");
	public static final @NonNull RelationsBindings.Key<Variable> RELATIONS_tv = RELATIONS_BINDINGS.create((Variable)null, "tv");
	public static final @NonNull RelationsBindings.Key<Type> RELATIONS_c = RELATIONS_BINDINGS.create((Type)null, "c");

	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	public static final @NonNull CoreBindings.Key<EClass> CORE_rc = CORE_BINDINGS.create((EClass)null, "rc");
	public static final @NonNull CoreBindings.Key<EReference> CORE_a = CORE_BINDINGS.create((EReference)null, "a");
	// Primitives
	private static final @NonNull PrimitivesBindings.KeySet PRIMITIVES_BINDINGS = new PrimitivesBindings.KeySet();
	private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_rn = PRIMITIVES_BINDINGS.create((String)null, "rn");
	private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_vn = PRIMITIVES_BINDINGS.create((String)null, "vn");
	
	public RelationToTraceClass(@NonNull QvtrToQvtcTransformation transformation) {
		super(transformation);
	}
	
	public @NonNull CoreBindings.KeySet getCoreBindingsKeys() {
		return CORE_BINDINGS;
	}

	public @NonNull PrimitivesBindings.KeySet getPrimitivesBindingsKeys() {
		return PRIMITIVES_BINDINGS;
	}

	public @NonNull RelationsBindings.KeySet getRelationsBindingsKeys() {
		return RELATIONS_BINDINGS;
	}
	
	@Override
	public @NonNull List<RelationsBindings> findInputMatches(@NonNull Resource inputModel) {
		List<RelationsBindings> loopData = new ArrayList<RelationsBindings>();
		TreeIterator<EObject> it = inputModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof Relation) {
				Relation eo2 = (Relation) eo;
				for (Domain d : eo2.getDomain()) {
					RelationDomain rd = (RelationDomain) d;
					if (rd.getPattern().getTemplateExpression() instanceof ObjectTemplateExp) {
						RelationsBindings bindings = new RelationsBindings(this);
						bindings.put(RELATIONS_r, eo2);
						bindings.put(RELATIONS_rd, rd);
						bindings.put(RELATIONS_rdp, rd.getPattern());
						bindings.put(RELATIONS_t, (ObjectTemplateExp) rd.getPattern().getTemplateExpression());
						bindings.put(RELATIONS_tv, rd.getPattern().getTemplateExpression().getBindsTo());
						loopData.add(bindings);
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

	@Override
	public List<EObject> instantiateMiddleElements(Map<Class<? extends EObject>, List<EObject>> qvtcMiddleElements, @NonNull CoreBindings coreBindings) {
		
		List<EObject> results = new ArrayList<EObject>();
		EcoreFactory factory = EcoreFactory.eINSTANCE;
		EClass rc = null;
		EReference a = null;
		PrimitivesBindings primitivesBindings = coreBindings.getPrimitivesBindings();
		String rn = primitivesBindings.get(PRIMITIVES_rn);
		String vn = primitivesBindings.get(PRIMITIVES_vn);
		if (qvtcMiddleElements.containsKey(EClass.class)) {
			for (EObject e : qvtcMiddleElements.get(EClass.class)) {
				if (((EClass) e).getName().equals("T" + rn)) {
					rc = (EClass) e;
				}
			}
			if (rc != null) {
				if (qvtcMiddleElements.containsKey(EReferenceImpl.class)) {
					for (EObject e : qvtcMiddleElements.get(EReferenceImpl.class)) {
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
			results.add(rc);
			
		}
		if (a == null) {
			a = factory.createEReference();
			results.add(a);
		}
		coreBindings.put(CORE_rc, rc);
		coreBindings.put(CORE_a, a);
		return results;
	}

	@Override
	public void setAttributes(@NonNull CoreBindings coreBindings) {
		EClass rc = coreBindings.get(CORE_rc);
		EReference a = coreBindings.get(CORE_a);
		PrimitivesBindings primitivesBindings = coreBindings.getPrimitivesBindings();
		String rn = primitivesBindings.get(PRIMITIVES_rn);
		String vn = primitivesBindings.get(PRIMITIVES_vn);
		rc.setName('T' + rn);
		a.setName(vn);
		a.setEType((EClassifier) primitivesBindings.getRelationsBindings().get(RELATIONS_c));			// FIXME Bad cast
		rc.getEStructuralFeatures().add(a);
	}
	
	@Override
	public boolean when(@NonNull RelationsBindings relationsBindings) {
		Relation r = relationsBindings.get(RELATIONS_r);
		RelationDomain rd = relationsBindings.get(RELATIONS_rd);
		DomainPattern rdp = relationsBindings.get(RELATIONS_rdp);
		ObjectTemplateExp t = relationsBindings.get(RELATIONS_t);
		Variable tv = relationsBindings.get(RELATIONS_tv);
		Type c = relationsBindings.get(RELATIONS_c);
		if (r != null && rd != null && rdp != null && t != null && tv != null && c != null
				&& r.getDomain().contains(rd)
				&& rd.getPattern().equals(rdp)
				&& rdp.getTemplateExpression().equals(t)
				&& t.getBindsTo().equals(tv)
				&& tv.getType().equals(c)) {
			PrimitivesBindings primitivesBindings = relationsBindings.getPrimitivesBindings();
			primitivesBindings.put(PRIMITIVES_rn, r.getName());
			primitivesBindings.put(PRIMITIVES_vn, tv.getName());
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void where(@NonNull CoreBindings bindings) {
		ObjectTemplateExp t = bindings.getRelationsBindings().get(RELATIONS_t); 
		for (PropertyTemplateItem part : t.getPart()) {
			if (part.getValue() instanceof ObjectTemplateExp) {
				RelationsBindings innerRelationsBindings = new RelationsBindings(new SubTemplateToTraceClassProps(transformation));
				CoreBindings innerCoreBindings = innerRelationsBindings.getCoreBindings();
				// TODO add other bindings!
				ObjectTemplateExp objectTemplateExp = (ObjectTemplateExp)part.getValue();
				innerRelationsBindings.put(SubTemplateToTraceClassProps.RELATIONS_t, objectTemplateExp);
				innerRelationsBindings.put(SubTemplateToTraceClassProps.RELATIONS_tv, objectTemplateExp.getBindsTo());
				innerRelationsBindings.put(SubTemplateToTraceClassProps.RELATIONS_c, objectTemplateExp.getBindsTo().getType());
				innerCoreBindings.put(SubTemplateToTraceClassProps.CORE_rc, bindings.get(CORE_rc));
				transformation.executeNestedRule(innerCoreBindings);
			}
		}
	}

}
