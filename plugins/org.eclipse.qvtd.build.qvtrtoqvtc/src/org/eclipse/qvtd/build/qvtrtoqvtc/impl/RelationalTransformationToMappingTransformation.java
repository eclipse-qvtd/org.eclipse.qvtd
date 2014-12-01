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
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
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
				Rule tracedRule = transformation.getRecord(rule.getRuleBindings());
				if (tracedRule != null)
					rule = tracedRule;
			}
			return rule;
		}

		@Override
		public @Nullable Rule createRule(
				@NonNull QvtrToQvtcTransformation transformation,
				@NonNull List<EObject> eos) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	private class SubRecord 
	{
		
		// Relations
		@NonNull public TypedModel rtm;
		@NonNull public String tmn;
		@NonNull public List<Package> up;
		
		// Core
		@Nullable public TypedModel mtm;
		
		public SubRecord(@NonNull TypedModel rtm, @NonNull String tmn, @NonNull List<Package> up) {
			this.rtm = rtm;
			this.tmn = tmn;
			this.up = up;
		}

		
	}

	public static final @NonNull Rule.Factory FACTORY = new Factory(); 
	
	// Relations
	private static final @NonNull RuleBindings.KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	public static final @NonNull RuleBindings.RuleKey<RelationalTransformation> RELATIONS_rt = RULE_BINDINGS.createRoot((RelationalTransformation)null, "rt");
//	private static final @NonNull RuleBindings.RuleKey<TypedModel> RELATIONS_rtm = RULE_BINDINGS.create((TypedModel)null, "rtm");
	
	// Core
	Transformation mt = null;
	//public static final @NonNull RuleBindings.RuleKey<Transformation> CORE_mt = RULE_BINDINGS.create((Transformation)null, "mt");
//	public static final @NonNull RuleBindings.RuleKey<TypedModel> CORE_mtm = RULE_BINDINGS.create((TypedModel)null, "mtm");
	
	// Shared
//	public static final @NonNull RuleBindings.RuleKey<String> SHARED_tmn = RULE_BINDINGS.create((String)null, "tmn");
//	public static final @NonNull RuleBindings.RuleKey<List<org.eclipse.ocl.examples.pivot.Package>> SHARED_up = RULE_BINDINGS.create((List<org.eclipse.ocl.examples.pivot.Package>)null, "up");
	String rtn;
	 
	
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();
	
	public RelationalTransformationToMappingTransformation(@NonNull QvtrToQvtcTransformation transformation, @NonNull RelationalTransformation rt) {
		super(transformation);
		ruleBindings.put(RELATIONS_rt, rt);
	}

	@Override
	public void check() {
		RelationalTransformation rt = ruleBindings.get(RELATIONS_rt);
		rtn = rt.getName();
		assert (rt != null) && (mt == null);
		for (TypedModel rtm : rt.getModelParameter()) {
			@SuppressWarnings("null")@NonNull List<Package> usedPackage = rtm.getUsedPackage();
			String tmn = rtm.getName();
			assert tmn != null;
			subRecords.add(new SubRecord(rtm, tmn, usedPackage));
		}
	}
	
	public @Nullable Transformation getCore() {
		return mt;
	}

	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}

	@Override
	public void instantiateOutput() {
		mt = QVTbaseFactory.eINSTANCE.createTransformation();
		assert mt != null;
		transformation.addOrphan(mt);
		for (SubRecord subRecord : subRecords) {
			TypedModel mtm =  QVTbaseFactory.eINSTANCE.createTypedModel();
			subRecord.mtm = mtm;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#setAttributes()
	 */
	@Override
	public void setAttributes() {
		assert mt != null;
		for (SubRecord subRecord : subRecords) {
			TypedModel mtm = subRecord.mtm;
			assert mtm != null;
			mtm.setName(subRecord.tmn);
			mtm.getUsedPackage().addAll(subRecord.up);
			mt.getModelParameter().add(mtm);
		}
	}
	
}
