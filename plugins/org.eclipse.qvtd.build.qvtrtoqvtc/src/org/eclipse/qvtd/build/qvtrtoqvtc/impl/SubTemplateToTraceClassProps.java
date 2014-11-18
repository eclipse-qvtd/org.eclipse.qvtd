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
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.PrimitivesBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class SubTemplateToTraceClassProps extends AbstractRule
{
	// Relations
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	public static final @NonNull RelationsBindings.Key<ObjectTemplateExp> RELATIONS_t = RELATIONS_BINDINGS.create((ObjectTemplateExp)null, "t");
	public static final @NonNull RelationsBindings.Key<PropertyTemplateItem> RELATIONS_pt = RELATIONS_BINDINGS.create((PropertyTemplateItem)null, "pt");
	public static final @NonNull RelationsBindings.Key<ObjectTemplateExp> RELATIONS_tp = RELATIONS_BINDINGS.create((ObjectTemplateExp)null, "tp");
	public static final @NonNull RelationsBindings.Key<Variable> RELATIONS_tv = RELATIONS_BINDINGS.create((Variable)null, "tv");
	public static final @NonNull RelationsBindings.Key<Type> RELATIONS_c = RELATIONS_BINDINGS.create((Type)null, "c");
	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	public static final @NonNull CoreBindings.Key<EClass> CORE_rc = CORE_BINDINGS.create((EClass)null, "rc");
	public static final @NonNull CoreBindings.Key<EReference> CORE_a = CORE_BINDINGS.create((EReference)null, "a");
	// Primitives
	private static final @NonNull PrimitivesBindings.KeySet PRIMITIVES_BINDINGS = new PrimitivesBindings.KeySet();
	private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_vn = PRIMITIVES_BINDINGS.create((String)null, "vn");

	public SubTemplateToTraceClassProps(@NonNull QvtrToQvtcTransformation transformation) {
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
	
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> qvtcModelElements, @NonNull CoreBindings coreBindings) {
		List<EObject> result = new ArrayList<EObject>(); 
		EReference a = EcoreFactory.eINSTANCE.createEReference();
		coreBindings.put(CORE_a, a);
		result.add(a);
		return result;
	}
	
	public void setAttributes(@NonNull CoreBindings coreBindings) {
		PrimitivesBindings primitivesBindings = coreBindings.getPrimitivesBindings();
		EReference a = coreBindings.get(CORE_a);
		EClass rc = coreBindings.get(CORE_rc);
		String vn = primitivesBindings.get(PRIMITIVES_vn);
		a.setName(vn);
		a.setEType((EClassifier) coreBindings.getRelationsBindings().get(RELATIONS_c));		// FIXME Bad cast
		rc.getEStructuralFeatures().add(a);
	}
	
	@Override
	public boolean when(@NonNull RelationsBindings relationsBindings) {
		PrimitivesBindings primitivesBindings = relationsBindings.getPrimitivesBindings();
		Variable tv = relationsBindings.get(RELATIONS_tv);
		primitivesBindings.put(PRIMITIVES_vn, tv.getName());
		return true;
	}
	
	@Override
	public void where(@NonNull CoreBindings coreBindings) {
		EClass rc = coreBindings.get(CORE_rc);
		ObjectTemplateExp t = coreBindings.getRelationsBindings().get(RELATIONS_t);
		for (PropertyTemplateItem part : t.getPart()) {
			OCLExpression value = part.getValue();
			if (value instanceof ObjectTemplateExp) {
				ObjectTemplateExp objectTemplateExp = (ObjectTemplateExp)value;
				RelationsBindings innerRelationsBindings = new RelationsBindings(new SubTemplateToTraceClassProps(transformation));
				CoreBindings innerCoreBindings = innerRelationsBindings.getCoreBindings();
				// TODO add other bindings!
				innerRelationsBindings.put(SubTemplateToTraceClassProps.RELATIONS_t, objectTemplateExp);
				innerRelationsBindings.put(SubTemplateToTraceClassProps.RELATIONS_tv, objectTemplateExp.getBindsTo());
				innerRelationsBindings.put(SubTemplateToTraceClassProps.RELATIONS_c, objectTemplateExp.getBindsTo().getType());
				innerCoreBindings.put(SubTemplateToTraceClassProps.CORE_rc, rc);
				transformation.executeNestedRule(innerCoreBindings);
			}
		}
	}

}
