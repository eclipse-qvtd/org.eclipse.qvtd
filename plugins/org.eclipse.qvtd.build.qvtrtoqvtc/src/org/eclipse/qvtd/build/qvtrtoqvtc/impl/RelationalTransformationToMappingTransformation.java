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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.build.qvtrtoqvtc.RuleBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToMappingTransformation extends AbstractRule
{
	private static class Factory extends AbstractRule.Factory
	{
		public @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation, @NonNull EObject eo,
				@NonNull TransformationTraceData traceData) {
			Rule rule = null;
			if (eo instanceof RelationalTransformation) {
				rule = new RelationalTransformationToMappingTransformation(transformation, (RelationalTransformation) eo);
				Rule tracedRule = traceData.getRecord(rule.getRuleBindings());
				if (tracedRule != null)
					rule = tracedRule;
			}
			return rule;
		}
	}
	
	private class SubRecord extends AbstractRule.AbstractSubRecord
	{
		
		public SubRecord(@NonNull Rule rule, @NonNull TypedModel rtm, @Nullable String tmn, @NonNull List<org.eclipse.ocl.examples.pivot.Package> up) {
			super(rule);
			
			ruleBindings.put(RELATIONS_rtm, rtm);
			ruleBindings.put(SHARED_tmn, tmn);
			ruleBindings.put(SHARED_up, up);
		}
	}

	public static final @NonNull Rule.Factory FACTORY = new Factory(); 
	
	// Relations
	private static final @NonNull RuleBindings.KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	public static final @NonNull RuleBindings.Key<RelationalTransformation> RELATIONS_rt = RULE_BINDINGS.createRoot((RelationalTransformation)null, "rt");
	private static final @NonNull RuleBindings.Key<TypedModel> RELATIONS_rtm = RULE_BINDINGS.create((TypedModel)null, "rtm");
	
	// Core
	public static final @NonNull RuleBindings.Key<Transformation> CORE_mt = RULE_BINDINGS.create((Transformation)null, "mt");
	public static final @NonNull RuleBindings.Key<TypedModel> CORE_mtm = RULE_BINDINGS.create((TypedModel)null, "mtm");
	
	// Shared
	public static final @NonNull RuleBindings.Key<String> SHARED_tmn = RULE_BINDINGS.create((String)null, "tmn");
	public static final @NonNull RuleBindings.Key<List<org.eclipse.ocl.examples.pivot.Package>> SHARED_up = RULE_BINDINGS.create((List<org.eclipse.ocl.examples.pivot.Package>)null, "up");
	
	// Primitives
	String rtn;
	
	public RelationalTransformationToMappingTransformation(@NonNull QvtrToQvtcTransformation transformation, @NonNull RelationalTransformation rt) {
		super(transformation);
		ruleBindings.put(RELATIONS_rt, rt);
	}

	@Override
	public void check() {
		RelationalTransformation rt = ruleBindings.get(RELATIONS_rt);
		rtn = rt.getName();
		Transformation mt = ruleBindings.get(CORE_mt);
		assert (rt != null) && (mt == null);
		for (TypedModel rtm : rt.getModelParameter()) {
			@SuppressWarnings("null")@NonNull List<Package> usedPackage = rtm.getUsedPackage();
			subRecords.add(new SubRecord(this, rtm, rtm.getName(), usedPackage));
		}
	}
	
	@Override
	@NonNull
	public Object getCoreResult() {
		Transformation mt = ruleBindings.get(CORE_mt);
		assert mt != null;
		return mt;
	}

	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}

	@Override
	public void instantiateOutput() {
		Transformation mt = ruleBindings.get(CORE_mt);
		assert mt == null;
		mt = QVTbaseFactory.eINSTANCE.createTransformation();
		assert mt != null;
		ruleBindings.put(CORE_mt, mt);
		transformation.addOrphan(mt);
		for (org.eclipse.qvtd.build.qvtrtoqvtc.Rule.SubRecord subRecord : subRecords) {
			TypedModel mtm =  QVTbaseFactory.eINSTANCE.createTypedModel();
			subRecord.getRuleBindings().put(CORE_mtm, mtm);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#setAttributes()
	 */
	@Override
	public void setAttributes() {
		Transformation mt = ruleBindings.get(CORE_mt);
		assert mt != null;
		for (org.eclipse.qvtd.build.qvtrtoqvtc.Rule.SubRecord subRecord : subRecords) {
			TypedModel mtm = subRecord.getRuleBindings().get(CORE_mtm);
			assert mtm != null;
			mtm.setName(subRecord.getRuleBindings().get(SHARED_tmn));
			mtm.getUsedPackage().addAll(subRecord.getRuleBindings().get(SHARED_up));
			mt.getModelParameter().add(mtm);
		}
	}
	
}
