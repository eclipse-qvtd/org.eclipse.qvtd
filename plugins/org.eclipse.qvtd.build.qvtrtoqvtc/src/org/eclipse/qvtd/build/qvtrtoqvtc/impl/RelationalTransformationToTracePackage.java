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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.build.qvtrtoqvtc.RuleBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToTracePackage extends AbstractRule
{
	private static class Factory extends AbstractRule.Factory
	{
		public @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation, @NonNull EObject eo,
				@NonNull TransformationTraceData traceData) {
			Rule rule = null;
			if (eo instanceof RelationalTransformation) {	
				rule = new RelationalTransformationToTracePackage(transformation, (RelationalTransformation) eo);
				Rule tracedRule = traceData.getRecord(rule.getRuleBindings());
				if (tracedRule != null)
					rule = tracedRule;
			}
			return rule;
		}
	}
	

	public static final @NonNull Rule.Factory FACTORY = new Factory(); 
	
	private static final @NonNull RuleBindings.KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	public static final @NonNull RuleBindings.Key<RelationalTransformation> RELATIONS_rt = RULE_BINDINGS.createRoot((RelationalTransformation)null, "rt");
	
	// Core
	public static final @NonNull RuleBindings.Key<org.eclipse.ocl.examples.pivot.Package> CORE_p = RULE_BINDINGS.create((org.eclipse.ocl.examples.pivot.Package)null, "p");
	
	// Primitives
	String rtn;

	public RelationalTransformationToTracePackage(@NonNull QvtrToQvtcTransformation transformation, @NonNull RelationalTransformation rt) {
		super(transformation);
		ruleBindings.put(RELATIONS_rt, rt);
	}

	@Override
	public void check() {
		RelationalTransformation rt = ruleBindings.get(RELATIONS_rt);
		rtn = rt.getName();
		org.eclipse.ocl.examples.pivot.Package p = ruleBindings.get(CORE_p);
		assert (rt != null) && (p == null);
	}
	
	@Override
	@NonNull
	public Object getCoreResult() {
		org.eclipse.ocl.examples.pivot.Package p = ruleBindings.get(CORE_p);
		assert p != null;
		return p;
	}

	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}

	@Override
	public void instantiateOutput() {
		org.eclipse.ocl.examples.pivot.Package p = ruleBindings.get(CORE_p);
		assert p == null;
		p = PivotFactory.eINSTANCE.createPackage();
		assert p != null;
		ruleBindings.put(CORE_p, p);
		transformation.addOrphan(p);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#setAttributes()
	 */
	@Override
	public void setAttributes() {
		
		org.eclipse.ocl.examples.pivot.Package p = ruleBindings.get(CORE_p);
		assert p != null;
		p.setName("T" + rtn);
	}
	
	
	
	/*
	@Override
	public void where() {
		for (SubRecord subRecord : subRecords) {
			RelationToTraceClass innerRule = new RelationToTraceClass(transformation);
			RuleBindings innerRelationsBindings = innerRule.getRuleBindings();
			innerRelationsBindings.put(RelationToTraceClass.RELATIONS_r, subRecord.r);
			CoreBindings innerCoreBindings = innerRule.getCoreBindings();
			innerCoreBindings.put(RelationToTraceClass.CORE_rc, subRecord.c);
			transformation.executeNestedRule(innerRule);
		}
	}
	*/
}
