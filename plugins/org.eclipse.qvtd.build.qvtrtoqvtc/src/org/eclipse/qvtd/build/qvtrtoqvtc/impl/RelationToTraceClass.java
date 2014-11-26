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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

public class RelationToTraceClass extends AbstractRule
{
	/*
	private static class Factory extends AbstractRule.Factory
	{
		@Override
		public @Nullable Rule createRule(
				@NonNull QvtrToQvtcTransformation transformation,
				@NonNull EObject eo) {
			Rule rule = null;
			if (eo instanceof Relation) {	
				rule = new RelationToTraceClass(transformation, (Relation) eo);
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
	*/
	private class SubRecord 
	{
		// Relations
		@NonNull private ObjectTemplateExp t;
		@NonNull private String vn;
		@NonNull private Type c;
		
		// Core
		@Nullable private Property a;
		
		public SubRecord(@NonNull ObjectTemplateExp t, @NonNull String vn, @NonNull Type c) {
			this.t = t;
			this.vn = vn;
			this.c = c;
		}
	}
	
	//public static final @NonNull Rule.Factory FACTORY = new Factory();
	
	// Relations
	private static final @NonNull RuleBindings.KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	public static final @NonNull RuleBindings.RuleKey<Relation> RELATIONS_r = RULE_BINDINGS.createRoot((Relation)null, "r");

	// Core
	private org.eclipse.ocl.examples.pivot.Class rc;
	
	private String rn;
	private org.eclipse.ocl.examples.pivot.Package p;
	
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();
	
	public RelationToTraceClass(@NonNull QvtrToQvtcTransformation transformation, @NonNull Relation r) {
		super(transformation);
		ruleBindings.put(RELATIONS_r, r);
	}

	public void check() {
		Relation r = ruleBindings.get(RELATIONS_r);
		assert r != null;
		rn = r.getName();
		for (Domain d : r.getDomain()) {
			RelationDomain rd = (RelationDomain) d;
			DomainPattern rdp = rd.getPattern();
			OCLExpression templateExpression = rdp.getTemplateExpression();
			if (templateExpression instanceof ObjectTemplateExp) {
				ObjectTemplateExp t = (ObjectTemplateExp) templateExpression;
				Variable tv = t.getBindsTo();
				if (tv != null) {
					Type c = tv.getType();
					if (c != null) {
						String vn = tv.getName();
						assert vn != null;
						subRecords.add(new SubRecord(t, vn, c));
					}
				}
			}
		}
	}

	public @Nullable org.eclipse.ocl.examples.pivot.Class getCore() {
		return rc;
	}

	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}
	
	@Override
	public void instantiateOutput() {
		rc = PivotFactory.eINSTANCE.createClass();
		assert rc != null;
		transformation.addOrphan(rc);
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
		assert rc != null;
		rc.setName("T"+rn);
		rc.setPackage(p);
		for (SubRecord subRecord : subRecords) {
			Property a = subRecord.a;
			assert a != null;
			a.setName(subRecord.vn);
			a.setType(subRecord.c);
			rc.getOwnedAttribute().add(a);
		}
	}
	
	public void setCore(@NonNull org.eclipse.ocl.examples.pivot.Class rc) {
		this.rc = rc;
	}

	/*
	@Override
	public boolean when() {
		Relation r = ruleBindings.get(RELATIONS_r);
		assert r != null;
		RelationalTransformation rt = (RelationalTransformation) r.getTransformation();
		assert rt != null;
		// This is the same code the factory has, and IMHO its better encapsulated by the factory. The real issue is that the bindings need a rule
		RuleBindings whenBindings = new RuleBindings(new RelationalTransformationToTracePackage(transformation, rt));
		RelationalTransformationToTracePackage whenRule = (RelationalTransformationToTracePackage) transformation.getRecord(whenBindings);
		//Rule whenRule = RelationalTransformationToTracePackage.FACTORY.createRule(transformation, rt);
		if (whenRule != null && whenRule.hasExecuted()) {
			p = (Package) whenRule.getCore();
			assert p != null;
			return true;
		}
		return false;
	}
	*/

	@Override
	public void where() {
		for (SubRecord subRecord : subRecords) {
			Rule innerRule = new SubTemplateToTraceClassProps(transformation, subRecord.t, rc);
			if (innerRule != null) {
				assert !innerRule.hasExecuted();
				transformation.executeNestedRule(innerRule);
			}
		}
	}
	
	
}
