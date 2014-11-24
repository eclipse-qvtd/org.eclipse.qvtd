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

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.build.qvtrtoqvtc.RuleBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class RelationToTraceClass extends AbstractRule
{
	
	private static class Factory extends AbstractRule.Factory
	{

		@Override
		public @Nullable Rule createRule(
				@NonNull QvtrToQvtcTransformation transformation,
				@NonNull EObject eo, @NonNull TransformationTraceData traceData) {
			Rule rule = null;
			if (eo instanceof Relation) {	
				rule = new RelationToTraceClass(transformation, (Relation) eo);
				Rule tracedRule = traceData.getRecord(rule.getRuleBindings());
				if (tracedRule != null)
					rule = tracedRule;
			}
			return rule;
		}
		
	}
	
	private class SubRecord extends AbstractRule.AbstractSubRecord
	{

		protected SubRecord(@NonNull Rule rule, @NonNull RelationDomain rd, @NonNull DomainPattern rdp, @NonNull ObjectTemplateExp t, @NonNull Variable tv, @Nullable String vn, @NonNull Type c) {
			super(rule);
			ruleBindings.put(RELATIONS_t, t);
			ruleBindings.put(SHARED_vn, vn);
			ruleBindings.put(SHARED_c, c);
		}

	}
	
	// Relations
	private static final @NonNull RuleBindings.KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	public static final @NonNull RuleBindings.Key<Relation> RELATIONS_r = RULE_BINDINGS.createRoot((Relation)null, "r");
//	public static final @NonNull RelationsBindings.Key<RelationDomain> RELATIONS_rd = RELATIONS_BINDINGS.create((RelationDomain)null, "rd");
//	public static final @NonNull RelationsBindings.Key<DomainPattern> RELATIONS_rdp = RELATIONS_BINDINGS.create((DomainPattern)null, "rdp");
	public static final @NonNull RuleBindings.Key<ObjectTemplateExp> RELATIONS_t = RULE_BINDINGS.create((ObjectTemplateExp)null, "t");
//	public static final @NonNull RelationsBindings.Key<Variable> RELATIONS_tv = RELATIONS_BINDINGS.create((Variable)null, "tv");


	// Core
	public static final @NonNull RuleBindings.Key<org.eclipse.ocl.examples.pivot.Class> CORE_rc = RULE_BINDINGS.create((org.eclipse.ocl.examples.pivot.Class)null, "rc");
	public static final @NonNull RuleBindings.Key<Property> CORE_a = RULE_BINDINGS.create((Property)null, "a");
	
	// Shared
	public static final @NonNull RuleBindings.Key<String> SHARED_vn = RULE_BINDINGS.create((String)null, "vn");
	public static final @NonNull RuleBindings.Key<Type> SHARED_c = RULE_BINDINGS.create((Type)null, "c");
	
	public static final @NonNull Rule.Factory FACTORY = new Factory(); 
	
	private org.eclipse.ocl.examples.pivot.Package p;
	
	
	public RelationToTraceClass(@NonNull QvtrToQvtcTransformation transformation, @NonNull Relation r) {
		super(transformation);
		ruleBindings.put(RELATIONS_r, r);
	}

	public void check() {
		Relation r = ruleBindings.get(RELATIONS_r);
		assert r != null;
		for (Domain d : r.getDomain()) {
			RelationDomain rd = (RelationDomain) d;
			DomainPattern rdp = rd.getPattern();
			TemplateExp templateExpression = rdp.getTemplateExpression();
			if (templateExpression instanceof ObjectTemplateExp) {
				ObjectTemplateExp t = (ObjectTemplateExp) templateExpression;
				Variable tv = t.getBindsTo();
				Type c = t.getType();
				if ((tv != null) && (c != null)) {
					subRecords.add(new SubRecord(this, rd, rdp, t, tv, tv.getName(), c));
				}
			}
		}
	}

	@Override
	@NonNull
	public Object getCoreResult() {
		org.eclipse.ocl.examples.pivot.Class rc = ruleBindings.get(CORE_rc);
		assert rc != null;
		return rc;
	}

	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}
	
	@Override
	public void instantiateOutput() {
		org.eclipse.ocl.examples.pivot.Class rc = ruleBindings.get(CORE_rc);
		assert rc == null;
		rc = PivotFactory.eINSTANCE.createClass();
		assert rc != null;
		ruleBindings.put(CORE_rc, rc);
		transformation.addOrphan(rc);
		for (org.eclipse.qvtd.build.qvtrtoqvtc.Rule.SubRecord subRecord : subRecords) {
			Property a = PivotFactory.eINSTANCE.createProperty();
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
		rc.setPackage(p);
		for (org.eclipse.qvtd.build.qvtrtoqvtc.Rule.SubRecord subRecord : subRecords) {
			Property a = subRecord.getRuleBindings().get(CORE_a);
			assert a != null;
			a.setName(subRecord.getRuleBindings().get(SHARED_vn));
			a.setType(subRecord.getRuleBindings().get(SHARED_c));
			rc.getOwnedAttribute().add(a);
		}
	}

	
	@Override
	public boolean when(@NonNull TransformationTraceData traceData) {
		Relation r = ruleBindings.get(RELATIONS_r);
		assert r != null;
		Rule whenRule = RelationalTransformationToTracePackage.FACTORY.createRule(transformation, r.getTransformation(), traceData);
		if (whenRule != null && whenRule.hasExecuted()) {
			p = (Package) whenRule.getCoreResult();
			assert p != null;
			return true;
		}
		return false;
	}

	@Override
	public void where(@NonNull TransformationTraceData traceData) {
		org.eclipse.ocl.examples.pivot.Class rc = ruleBindings.get(CORE_rc);
		for (org.eclipse.qvtd.build.qvtrtoqvtc.Rule.SubRecord subRecord : subRecords) {
			Rule innerRule = SubTemplateToTraceClassProps.FACTORY.createRule(transformation, subRecord.getRuleBindings().get(RELATIONS_t), traceData);
			if (innerRule != null) {
				assert !innerRule.hasExecuted();
				RuleBindings innerRuleBindings = innerRule.getRuleBindings();
				innerRuleBindings.put(SubTemplateToTraceClassProps.CORE_rc, rc);
				transformation.executeNestedRule(innerRule);
			}
			
		}
	}
	
	
}
