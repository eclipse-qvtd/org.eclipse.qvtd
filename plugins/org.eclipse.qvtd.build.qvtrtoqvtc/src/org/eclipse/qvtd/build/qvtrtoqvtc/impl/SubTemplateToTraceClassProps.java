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
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.build.qvtrtoqvtc.RuleBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class SubTemplateToTraceClassProps extends AbstractRule
{	
	
	private static class Factory extends AbstractRule.Factory
	{
		public @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation, @NonNull EObject eo,
				@NonNull TransformationTraceData traceData) {
			Rule rule = null;
			if (eo instanceof ObjectTemplateExp) {	
				rule = new SubTemplateToTraceClassProps(transformation, (ObjectTemplateExp) eo);
				Rule tracedRule = traceData.getRecord(rule.getRuleBindings());
				if (tracedRule != null)
					rule = tracedRule;
			}
			return rule;
		}
	}
	
	
	private class SubRecord extends AbstractRule.AbstractSubRecord
	{
		
		public SubRecord(@NonNull Rule rule, @NonNull PropertyTemplateItem pt, @NonNull ObjectTemplateExp tp, @NonNull Variable tv, @Nullable String vn, @NonNull Type c) {
			super(rule);
			ruleBindings.put(RELATIONS_tp, tp);
			ruleBindings.put(SHARED_vn, vn);
			ruleBindings.put(SHARED_c, c);
		}
	}

	// Relations
	private static final @NonNull RuleBindings.KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	public static final @NonNull RuleBindings.Key<ObjectTemplateExp> RELATIONS_t = RULE_BINDINGS.createRoot((ObjectTemplateExp)null, "t");
//	public static final @NonNull RelationsBindings.Key<PropertyTemplateItem> RELATIONS_pt = RELATIONS_BINDINGS.create((PropertyTemplateItem)null, "pt");
	public static final @NonNull RuleBindings.Key<ObjectTemplateExp> RELATIONS_tp = RULE_BINDINGS.create((ObjectTemplateExp)null, "tp");
//	public static final @NonNull RelationsBindings.Key<Variable> RELATIONS_tv = RELATIONS_BINDINGS.create((Variable)null, "tv");
//	public static final @NonNull RelationsBindings.Key<Type> RELATIONS_c = RELATIONS_BINDINGS.create((Type)null, "c");
	
	// Core
	public static final @NonNull RuleBindings.Key<org.eclipse.ocl.examples.pivot.Class> CORE_rc = RULE_BINDINGS.create((org.eclipse.ocl.examples.pivot.Class)null, "rc");
	public static final @NonNull RuleBindings.Key<Property> CORE_a = RULE_BINDINGS.create((Property)null, "a");
	
	// Shared
	public static final @NonNull RuleBindings.Key<String> SHARED_vn = RULE_BINDINGS.create((String)null, "vn");
	public static final @NonNull RuleBindings.Key<Type> SHARED_c = RULE_BINDINGS.create((Type)null, "c");	
	
	
	public static final @NonNull Rule.Factory FACTORY = new Factory(); 

	public SubTemplateToTraceClassProps(@NonNull QvtrToQvtcTransformation transformation, @NonNull ObjectTemplateExp t) {
		super(transformation);
		ruleBindings.put(RELATIONS_t, t);
	}

	public void check() {
		ObjectTemplateExp t = ruleBindings.get(RELATIONS_t);
		assert t != null;
		org.eclipse.ocl.examples.pivot.Class rc = ruleBindings.get(CORE_rc);
		assert (t != null) && (rc != null);
		for (PropertyTemplateItem pt : t.getPart()) {
			OCLExpression value = pt.getValue();
			if (value instanceof ObjectTemplateExp) {
				ObjectTemplateExp tp = (ObjectTemplateExp) value;
				Variable tv = t.getBindsTo();
				Type c = t.getType();
				if ((tv != null) && (c != null)) {
					subRecords.add(new SubRecord(this, pt, tp, tv, tv.getName(), c));
				}
			}
		}
	}

	@Override
	@NonNull
	public Object getCoreResult() {
		throw new UnsupportedOperationException("This rule is 1 -> *, can't get single core result");
	}

	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}
	
	
	
	@Override
	public void instantiateOutput() {
		for (org.eclipse.qvtd.build.qvtrtoqvtc.Rule.SubRecord subRecord : subRecords) {
			Property a = PivotFactory.eINSTANCE.createProperty();
			assert a != null;
			transformation.addOrphan(a);
			subRecord.getRuleBindings().put(CORE_a, a);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#setAttributes()
	 */
	@Override
	public void setAttributes() {
		org.eclipse.ocl.examples.pivot.Class rc = ruleBindings.get(CORE_rc);
		assert rc != null;
		for (org.eclipse.qvtd.build.qvtrtoqvtc.Rule.SubRecord subRecord : subRecords) {
			Property a = subRecord.getRuleBindings().get(CORE_a);
			assert a != null;
			a.setName(subRecord.getRuleBindings().get(SHARED_vn));
			a.setType(subRecord.getRuleBindings().get(SHARED_c));
			rc.getOwnedAttribute().add(a);
		}
		
	}

	@Override
	public void where(@NonNull TransformationTraceData traceData) {
		org.eclipse.ocl.examples.pivot.Class rc = ruleBindings.get(CORE_rc);
		for (org.eclipse.qvtd.build.qvtrtoqvtc.Rule.SubRecord subRecord : subRecords) {
			Rule innerRule = SubTemplateToTraceClassProps.FACTORY.createRule(transformation, subRecord.getRuleBindings().get(RELATIONS_tp), traceData);
			if (innerRule != null) {
				assert !innerRule.hasExecuted();
				RuleBindings innerRuleBindings = innerRule.getRuleBindings();
				innerRuleBindings.put(SubTemplateToTraceClassProps.CORE_rc, rc);
				transformation.executeNestedRule(innerRule);
			}
			
		}
	}

}
