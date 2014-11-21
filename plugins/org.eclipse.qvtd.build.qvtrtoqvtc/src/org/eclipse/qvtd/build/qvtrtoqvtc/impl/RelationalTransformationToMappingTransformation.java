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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToMappingTransformation extends AbstractRule
{
	private static class Factory extends AbstractRule.Factory
	{
		public @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation, @NonNull EObject eo) {
			Rule rule = null;
			if (eo instanceof RelationalTransformation) {	
				rule = new RelationalTransformationToMappingTransformation(transformation, (RelationalTransformation) eo);
			}
			return rule;
		}
	}
	
	private static class SubRecord implements AbstractRule.SubRecord
	{
//		public final @NonNull TypedModel rtm;
		public final @Nullable String tmn;
		public final @NonNull List<org.eclipse.ocl.examples.pivot.Package> up;
	
		public SubRecord(@NonNull TypedModel rtm, @Nullable String tmn, @NonNull List<org.eclipse.ocl.examples.pivot.Package> up) {
//			this.rtm = rtm;
			this.tmn = tmn;
			this.up = up;
		}
	}

	public static final @NonNull Rule.Factory FACTORY = new Factory(); 
	
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	public static final @NonNull RelationsBindings.Key<RelationalTransformation> RELATIONS_rt = RELATIONS_BINDINGS.createRoot((RelationalTransformation)null, "rt");
//	private static final @NonNull RelationsBindings.Key<TypedModel> RELATIONS_rtm = RELATIONS_BINDINGS.create((TypedModel)null, "rtm");
	
	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	public static final @NonNull CoreBindings.Key<Transformation> CORE_mt = CORE_BINDINGS.create((Transformation)null, "mt");
//	public static final @NonNull CoreBindings.Key<TypedModel> CORE_MTM = CORE_BINDINGS.create((TypedModel)null, "mtm");
	
	// Primitives
	String rtn;

	private final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();

	public RelationalTransformationToMappingTransformation(@NonNull QvtrToQvtcTransformation transformation, @NonNull RelationalTransformation rt) {
		super(transformation);
		relationsBindings.put(RELATIONS_rt, rt);
	}

	@Override
	public void check() {
		RelationalTransformation rt = relationsBindings.get(RELATIONS_rt);
		rtn = rt.getName();
		Transformation mt = coreBindings.get(CORE_mt);
		assert (rt != null) && (mt == null);
		for (TypedModel rtm : rt.getModelParameter()) {
			@SuppressWarnings("null")@NonNull List<Package> usedPackage = rtm.getUsedPackage();
			subRecords.add(new SubRecord(rtm, rtm.getName(), usedPackage));
		}
	}
	
	@Override
	public void enforce() {
		Transformation mt = coreBindings.get(CORE_mt);
		assert mt == null;
		mt = QVTbaseFactory.eINSTANCE.createTransformation();
		assert mt != null;
		coreBindings.put(CORE_mt, mt);
		transformation.addOrphan(mt);
		for (SubRecord subRecord : subRecords) {
			TypedModel mtm = QVTbaseFactory.eINSTANCE.createTypedModel();
			mtm.setName(subRecord.tmn);
			mtm.getUsedPackage().addAll(subRecord.up);
			mt.getModelParameter().add(mtm);
		}
	}

	public @NonNull RelationsBindings.KeySet getRelationsBindingsKeys() {
		return RELATIONS_BINDINGS;
	}
	
	public @NonNull CoreBindings.KeySet getCoreBindingsKeys() {
		return CORE_BINDINGS;
	}
}
