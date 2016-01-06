/*******************************************************************************
 * Copyright (c) 2014, 2015 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.Rule;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToMappingTransformation extends AbstractRule
{
	private static class Factory extends AbstractRule.Factory
	{
		@Override
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
	//	@NonNull public TypedModel rtm;
		@NonNull public String tmn;
		@NonNull public List<org.eclipse.ocl.pivot.Package> up;
		
		// Core
		@Nullable public TypedModel mtm;
		
		public SubRecord(@NonNull TypedModel rtm, @NonNull String tmn, @NonNull List<org.eclipse.ocl.pivot.Package> up) {
	//		this.rtm = rtm;
			this.tmn = tmn;
			this.up = up;
		}

		
	}

	public static final Rule.@NonNull Factory FACTORY = new Factory(); 
	
	// Relations
	private static final RuleBindings.@NonNull KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	public static final RuleBindings.@NonNull RuleKey<@NonNull RelationalTransformation> RELATIONS_rt = RULE_BINDINGS.createRoot((RelationalTransformation)null, "rt");
//	private static final RuleBindings.@NonNull RuleKey<TypedModel> RELATIONS_rtm = RULE_BINDINGS.create((TypedModel)null, "rtm");
	
	// Core
	Transformation mt = null;
	org.eclipse.ocl.pivot.Package p = null;
	TypedModel mmtm = null;
	//public static final RuleBindings.@NonNull RuleKey<Transformation> CORE_mt = RULE_BINDINGS.create((Transformation)null, "mt");
//	public static final RuleBindings.@NonNull RuleKey<TypedModel> CORE_mtm = RULE_BINDINGS.create((TypedModel)null, "mtm");
	
	// Shared
//	public static final RuleBindings.@NonNull RuleKey<String> SHARED_tmn = RULE_BINDINGS.create((String)null, "tmn");
//	public static final RuleBindings.@NonNull RuleKey<List<org.eclipse.ocl.examples.pivot.Package>> SHARED_up = RULE_BINDINGS.create((List<org.eclipse.ocl.examples.pivot.Package>)null, "up");
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
		p = transformation.getTransformationToPackageTrace(rt);
		assert p != null;
		for (TypedModel rtm : rt.getModelParameter()) {
			@NonNull List<org.eclipse.ocl.pivot.Package> usedPackage = rtm.getUsedPackage();
			String tmn = rtm.getName();
			assert tmn != null;
			subRecords.add(new SubRecord(rtm, tmn, usedPackage));
		}
	}
	
	public @Nullable Transformation getCore() {
		return mt;
	}

	@Override
	public RuleBindings.@NonNull KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}

	@Override
	public void instantiateOutput() {
		mt = QVTbaseFactory.eINSTANCE.createTransformation();
		assert mt != null;
		transformation.addOrphan(mt);
		// One TypeModel for the middle model
		mmtm =  QVTbaseFactory.eINSTANCE.createTypedModel();
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
		mt.setName(rtn);
		assert p != null;
		assert mmtm != null;
		mmtm.setName("");
		mmtm.getUsedPackage().add(p);
		mt.getModelParameter().add(mmtm);
		for (SubRecord subRecord : subRecords) {
			TypedModel mtm = subRecord.mtm;
			assert mtm != null;
			mtm.setName(subRecord.tmn);
			mtm.getUsedPackage().addAll(subRecord.up);
			mt.getModelParameter().add(mtm);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#when()
	 */
	@Override
	public boolean when() {
		RelationalTransformation rt = ruleBindings.get(RELATIONS_rt);
		assert rt != null;
		RelationalTransformationToTracePackage whenRule = new RelationalTransformationToTracePackage(transformation, rt); 
		RuleBindings whenBindings = whenRule.getRuleBindings();
		RelationalTransformationToTracePackage whenRuleRecord = (RelationalTransformationToTracePackage) transformation.getRecord(whenBindings);
		if (whenRuleRecord != null && whenRuleRecord.hasExecuted()) {
			p = whenRuleRecord.getCore();
			assert p != null;
			return true;
		}
		return false;
	}
	
	
	
}
