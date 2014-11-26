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
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class SubTemplateToTraceClassProps extends AbstractRule
{	
	
	private static class Factory extends AbstractRule.Factory
	{
		public @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation,
				@NonNull EObject eo) {
			Rule rule = null;
			if (eo instanceof ObjectTemplateExp) {	
				rule = new SubTemplateToTraceClassProps(transformation, (ObjectTemplateExp) eo);
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
		@NonNull private ObjectTemplateExp tp;
		@NonNull private String vn;
		@NonNull private Type c;
		
		// Core
		@Nullable private Property a;
		
		
		public SubRecord( @NonNull ObjectTemplateExp tp, @NonNull String vn, @NonNull Type c) {
			
			this.tp = tp;
			this.vn = vn;
			this.c = c;
		}
		
	}

	// Relations
	private static final @NonNull RuleBindings.KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	public static final @NonNull RuleBindings.RuleKey<ObjectTemplateExp> RELATIONS_t = RULE_BINDINGS.createRoot((ObjectTemplateExp)null, "t");
//	public static final @NonNull RelationsBindings.Key<PropertyTemplateItem> RELATIONS_pt = RELATIONS_BINDINGS.create((PropertyTemplateItem)null, "pt");
	public static final @NonNull RuleBindings.RuleKey<ObjectTemplateExp> RELATIONS_tp = RULE_BINDINGS.create((ObjectTemplateExp)null, "tp");
//	public static final @NonNull RelationsBindings.Key<Variable> RELATIONS_tv = RELATIONS_BINDINGS.create((Variable)null, "tv");
//	public static final @NonNull RelationsBindings.Key<Type> RELATIONS_c = RELATIONS_BINDINGS.create((Type)null, "c");
	
	// Core
	public static final @NonNull RuleBindings.RuleKey<org.eclipse.ocl.examples.pivot.Class> CORE_rc = RULE_BINDINGS.create((org.eclipse.ocl.examples.pivot.Class)null, "rc");
	public static final @NonNull RuleBindings.RuleKey<Property> CORE_a = RULE_BINDINGS.create((Property)null, "a");
	
	// Shared
	public static final @NonNull RuleBindings.RuleKey<String> SHARED_vn = RULE_BINDINGS.create((String)null, "vn");
	public static final @NonNull RuleBindings.RuleKey<Type> SHARED_c = RULE_BINDINGS.create((Type)null, "c");	
	
	
	public static final @NonNull Rule.Factory FACTORY = new Factory(); 
	
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();

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
				Variable tv = tp.getBindsTo();
				if (tv != null) {
					Type c = tv.getType();
					if (c != null) {
						String vn = tv.getName();
						assert vn != null;
						subRecords.add(new SubRecord(tp, vn, c));
					}
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
		for (SubRecord subRecord : subRecords) {
			Property a = PivotFactory.eINSTANCE.createProperty();
			assert a != null;
			transformation.addOrphan(a);
			subRecord.a = a;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#setAttributes()
	 */
	@Override
	public void setAttributes() {
		org.eclipse.ocl.examples.pivot.Class rc = ruleBindings.get(CORE_rc);
		assert rc != null;
		for (SubRecord subRecord : subRecords) {
			Property a = subRecord.a;
			assert a != null;
			a.setName(subRecord.vn);
			a.setType(subRecord.c);
			rc.getOwnedAttribute().add(a);
		}
		
	}

	@Override
	public void where() {
		org.eclipse.ocl.examples.pivot.Class rc = ruleBindings.get(CORE_rc);
		for (SubRecord subRecord : subRecords) {
			Rule innerRule = SubTemplateToTraceClassProps.FACTORY.createRule(transformation, subRecord.tp);
			if (innerRule != null) {
				assert !innerRule.hasExecuted();
				RuleBindings innerRuleBindings = innerRule.getRuleBindings();
				innerRuleBindings.put(SubTemplateToTraceClassProps.CORE_rc, rc);
				transformation.executeNestedRule(innerRule);
			}
			
		}
	}

}
