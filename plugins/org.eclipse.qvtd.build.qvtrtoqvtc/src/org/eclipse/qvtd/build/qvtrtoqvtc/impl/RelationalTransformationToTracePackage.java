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
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.qvtd.build.qvtrtoqvtc.QVTr2QVTcRelations;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToTracePackage extends AbstractRule
{
	private static class Factory extends AbstractRule.Factory
	{
		public @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation, @NonNull EObject eo) {
			Rule rule = null;
			if (eo instanceof RelationalTransformation) {	
				rule = new RelationalTransformationToTracePackage(transformation, (RelationalTransformation) eo);
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
			return null;
		}
	}
	
	private class SubRecord {
		
		// Relations
		@NonNull private Relation r;
		public Class rc;
		
		public SubRecord(@NonNull Relation r) {
			this.r = r;
		}
		
	}
	

	public static final @NonNull Rule.Factory FACTORY = new Factory(); 
	
	private static final @NonNull RuleBindings.KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	public static final @NonNull RuleBindings.RuleKey<RelationalTransformation> RELATIONS_rt = RULE_BINDINGS.createRoot((RelationalTransformation)null, "rt");
	
	// Core
	private org.eclipse.ocl.examples.pivot.Package p;
	
	// Primitives
	private String rtn;
	
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();

	public RelationalTransformationToTracePackage(@NonNull QvtrToQvtcTransformation transformation, @NonNull RelationalTransformation rt) {
		super(transformation);
		ruleBindings.put(RELATIONS_rt, rt);
	}

	@Override
	public void check() {
		RelationalTransformation rt = ruleBindings.get(RELATIONS_rt);
		assert rt != null;
		rtn = rt.getName();
		for (org.eclipse.qvtd.pivot.qvtbase.Rule r : rt.getRule()) {
			assert r!= null;
			subRecords.add(new SubRecord((Relation) r));
		}
	}
	
	public @Nullable org.eclipse.ocl.examples.pivot.Package getCore() {
		return p;
	}

	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}

	@Override
	public void instantiateOutput() {
		p = PivotFactory.eINSTANCE.createPackage();
		assert p != null;
		transformation.addOrphan(p);
		for (SubRecord subRecord : subRecords) {
			org.eclipse.ocl.examples.pivot.Class rc = PivotFactory.eINSTANCE.createClass();
			assert rc != null;
			p.getOwnedType().add(rc);
			subRecord.rc = rc;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#setAttributes()
	 */
	@Override
	public void setAttributes() {
		
		p.setName("P" + rtn);
	}
	
	@Override
	public void where() {
		QVTr2QVTcRelations relations = new QVTr2QVTcRelations(transformation);
		for (SubRecord subRecord : subRecords) {
			final Class rc2 = subRecord.rc;
			assert (rc2 != null);
			relations.doRelationToTraceClass(subRecord.r, rc2);
		}
	}
}
