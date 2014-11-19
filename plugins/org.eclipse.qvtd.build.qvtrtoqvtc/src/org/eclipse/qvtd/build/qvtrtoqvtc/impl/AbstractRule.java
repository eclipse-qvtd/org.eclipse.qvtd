package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.PrimitivesBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;

public abstract class AbstractRule implements ConstrainedRule
{
	private static final @NonNull PrimitivesBindings.KeySet EMPTY_PRIMITIVES_BINDINGS = new PrimitivesBindings.KeySet();
	protected final @NonNull QvtrToQvtcTransformation transformation;

	protected AbstractRule(@NonNull QvtrToQvtcTransformation transformation) {
		this.transformation = transformation;
	}
	
	public @NonNull List<RelationsBindings> findInputMatches(@NonNull Resource inputModel) {
		return new ArrayList<RelationsBindings>();
	}

	public @NonNull PrimitivesBindings.KeySet getPrimitivesBindingsKeys() {
		return EMPTY_PRIMITIVES_BINDINGS;
	}
	
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> outputModelElements, @NonNull CoreBindings coreBindings) {
		return new ArrayList<EObject>();
	}
	
	public List<EObject> instantiateMiddleElements(Map<Class<? extends EObject>, List<EObject>> qvtcMiddleElements, @NonNull CoreBindings coreBindings) {
		return new ArrayList<EObject>();
	}
	
	public boolean matchBindings(@NonNull TraceRecord tr, @NonNull RelationsBindings relationsBindings) {
		RelationsBindings traceBindings = tr.getRelationsBindings();
		return relationsBindings.matches(getRelationsBindingsKeys(), traceBindings);
	}
	
	public void setAttributes(@NonNull CoreBindings coreBindings) { }
	
	public boolean when(@NonNull RelationsBindings relationsBindings) {
		return true;
	}
	
	public void where(@NonNull CoreBindings coreBindings) { }
}
