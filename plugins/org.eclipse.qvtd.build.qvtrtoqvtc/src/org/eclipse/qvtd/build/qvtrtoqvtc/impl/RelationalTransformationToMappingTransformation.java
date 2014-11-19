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
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.PrimitivesBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToMappingTransformation extends AbstractRule
{
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	public static final @NonNull RelationsBindings.Key<RelationalTransformation> RELATIONS_rt = RELATIONS_BINDINGS.create((RelationalTransformation)null, "rt");
	public static final @NonNull RelationsBindings.Key<TypedModel> RELATIONS_rtm = RELATIONS_BINDINGS.create((TypedModel)null, "rtm");
	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	public static final @NonNull CoreBindings.Key<Transformation> CORE_MT = CORE_BINDINGS.create((Transformation)null, "mt");
	public static final @NonNull CoreBindings.Key<TypedModel> CORE_MTM = CORE_BINDINGS.create((TypedModel)null, "mtm");
	// Primitives
	private static final @NonNull PrimitivesBindings.KeySet PRIMITIVES_BINDINGS = new PrimitivesBindings.KeySet();
	private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_rtn = PRIMITIVES_BINDINGS.create((String)null, "rtn");
	private static final @NonNull PrimitivesBindings.Key<String> PRIMITIVES_tmn = PRIMITIVES_BINDINGS.create((String)null, "tmn");


	public RelationalTransformationToMappingTransformation(@NonNull QvtrToQvtcTransformation transformation) {
		super(transformation);
	}
	
	public @NonNull List<RelationsBindings> findInputMatches(@NonNull Resource inputModel) {
		List<RelationsBindings> matches = new ArrayList<RelationsBindings>();
		TreeIterator<EObject> it = inputModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof RelationalTransformation) {
				RelationalTransformation relationalTransformation = (RelationalTransformation)eo;
				for (TypedModel rtm : relationalTransformation.getModelParameter()) {
					RelationsBindings relationsBindings = new RelationsBindings(this);
					relationsBindings.put(RELATIONS_rt, relationalTransformation);
					relationsBindings.put(RELATIONS_rtm, rtm);
					matches.add(relationsBindings);
				}
				
			} 
			/*
			else if(eo.eClass().getEAllSuperTypes().contains(rtEClass)) {
			}
			*/
		}
		return matches;
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
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> outputModelElements, @NonNull CoreBindings bindings) {
		// Search the output model first!
		List<EObject> results = new ArrayList<EObject>();
		Transformation mt;
		if (outputModelElements.containsKey(Transformation.class)) {
			// There should be only 1 transformation
			mt = (Transformation) outputModelElements.get(Transformation.class).get(0);
		} else {	
			mt = QVTbaseFactory.eINSTANCE.createTransformation();
			results.add(mt);
		}
		bindings.put(CORE_MT, mt);
		TypedModel mtm = QVTbaseFactory.eINSTANCE.createTypedModel();
		results.add(mtm);
		bindings.put(CORE_MTM, mtm);
		return results;
	}

	@Override
	public void setAttributes(@NonNull CoreBindings coreBindings) {
		PrimitivesBindings primitivesBindings = coreBindings.getPrimitivesBindings();
		TypedModel rtm = primitivesBindings.getRelationsBindings().get(RELATIONS_rtm);
		Transformation mt = coreBindings.get(CORE_MT);
		TypedModel mtm = coreBindings.get(CORE_MTM);
		String rtn = primitivesBindings.get(PRIMITIVES_rtn);
		String tmn = primitivesBindings.get(PRIMITIVES_tmn);
		mt.setName(rtn);;
		mtm.setName(tmn);
		mt.getModelParameter().add(mtm);
		mtm.getUsedPackage().addAll(rtm.getUsedPackage());
	}
	
	@Override
	public boolean when(@NonNull RelationsBindings relationsBindings) {
		RelationalTransformation rt = relationsBindings.get(RELATIONS_rt);
		TypedModel rtm = relationsBindings.get(RELATIONS_rtm);
		if (rt != null && rtm != null && rt.getModelParameter().contains(rtm)) {
			PrimitivesBindings primitivesBindings = relationsBindings.getPrimitivesBindings();
			primitivesBindings.put(PRIMITIVES_rtn, rt.getName());
			primitivesBindings.put(PRIMITIVES_tmn, rtm.getName());
			return true;
		} else {
			return false;
		}
	}
}
