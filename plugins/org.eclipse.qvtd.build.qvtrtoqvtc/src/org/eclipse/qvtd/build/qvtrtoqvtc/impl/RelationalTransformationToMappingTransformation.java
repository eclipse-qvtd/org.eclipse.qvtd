/*******************************************************************************
 * Copyright (c) 2014 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToMappingTransformation extends AbstractRule
{
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	public static final @NonNull RelationsBindings.Key<RelationalTransformation> RELATIONS_rt = RELATIONS_BINDINGS.createRoot((RelationalTransformation)null, "rt");
	private static final @NonNull RelationsBindings.Key<TypedModel> RELATIONS_rtm = RELATIONS_BINDINGS.create((TypedModel)null, "rtm");
	
	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	public static final @NonNull CoreBindings.Key<Transformation> CORE_MT = CORE_BINDINGS.create((Transformation)null, "mt");
	public static final @NonNull CoreBindings.Key<TypedModel> CORE_MTM = CORE_BINDINGS.create((TypedModel)null, "mtm");
	
	// Primitives
	String rtn;
	String tmn;
	
	//private static final @NonNull PrimitivesBindings.KeySet PRIMITIVES_BINDINGS = new PrimitivesBindings.KeySet();
	//private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_rtn = PRIMITIVES_BINDINGS.create((String)null, "rtn");
	//private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_tmn = PRIMITIVES_BINDINGS.create((String)null, "tmn");

	public static final @NonNull Factory FACTORY = new Factory(); 
	
	public static class Factory extends AbstractRule.Factory {

		public @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation, @NonNull EObject eo) {
			Rule rule = null;
			if (eo instanceof RelationalTransformation) {	
				rule = new RelationalTransformationToMappingTransformation(transformation, (RelationalTransformation) eo);
			}
			return rule;
		}
	}
	
	public RelationalTransformationToMappingTransformation(@NonNull QvtrToQvtcTransformation transformation, @NonNull RelationalTransformation rt) {
		super(transformation);
		for (TypedModel rtm : rt.getModelParameter()) {
			RelationsBindings relationsBindings = new RelationsBindings(this);
			relationsBindings.put(RELATIONS_rt, rt);
			relationsBindings.put(RELATIONS_rtm, rtm);
		}
	}

	
	public @NonNull RelationsBindings.KeySet getRelationsBindingsKeys() {
		return RELATIONS_BINDINGS;
	}
	
	public @NonNull CoreBindings.KeySet getCoreBindingsKeys() {
		return CORE_BINDINGS;
	}

	
	@Override
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> outputModelElements) {
		// Search the output model first!
		List<EObject> results = new ArrayList<EObject>();
		Transformation mt;
		TypedModel mtm;
		if (outputModelElements.containsKey(Transformation.class)) {
			// There should be only 1 transformation
			mt = (Transformation) outputModelElements.get(Transformation.class).get(0);
		} else {	
			mt = QVTbaseFactory.eINSTANCE.createTransformation();
			results.add(mt);
		}
		mtm = QVTbaseFactory.eINSTANCE.createTypedModel();
		results.add(mtm);
		coreBindings.put(CORE_MT, mt);
		coreBindings.put(CORE_MTM, mtm);
		return results;
	}


	@Override
	public void setAttributes() {
		TypedModel rtm = relationsBindings.get(RELATIONS_rtm);
		coreBindings.get(CORE_MT).setName(rtn);;
		coreBindings.get(CORE_MTM).setName(tmn);
		coreBindings.get(CORE_MT).getModelParameter().add(coreBindings.get(CORE_MTM));
		coreBindings.get(CORE_MTM).getUsedPackage().addAll(rtm.getUsedPackage());
	}

	@Override
	public boolean when(@NonNull TransformationTraceData traceData) {
		RelationalTransformation rt = relationsBindings.get(RELATIONS_rt);
		TypedModel rtm = relationsBindings.get(RELATIONS_rtm);
		if (rt != null && rtm != null && rt.getModelParameter().contains(rtm)) {
			rtn = rt.getName();
			tmn = rtm.getName();
			coreBindings = new CoreBindings(this);
			return true;
		} else {
			return false;
		}
	}
}
