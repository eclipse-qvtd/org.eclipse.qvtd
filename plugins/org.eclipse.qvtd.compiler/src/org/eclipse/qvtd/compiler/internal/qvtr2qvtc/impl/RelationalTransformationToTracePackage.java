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
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTcRelations;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.Rule;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToTracePackage extends AbstractRule
{
	private static class Factory extends AbstractRule.Factory
	{
		@Override
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
		public org.eclipse.ocl.pivot.Class rc;
		
		public SubRecord(@NonNull Relation r) {
			this.r = r;
		}
		
	}
	

	public static final Rule.@NonNull Factory FACTORY = new Factory(); 
	
	private static final RuleBindings.@NonNull KeySet RULE_BINDINGS = new RuleBindings.KeySet();
	public static final RuleBindings.@NonNull RuleKey<RelationalTransformation> RELATIONS_rt = RULE_BINDINGS.createRoot((RelationalTransformation)null, "rt");
	
	// Core
	private org.eclipse.ocl.pivot.Package p;
	
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
	
	public org.eclipse.ocl.pivot.@Nullable Package getCore() {
		return p;
	}

	@Override
	public RuleBindings.@NonNull KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}

	@Override
	public void instantiateOutput() {
		p = PivotFactory.eINSTANCE.createPackage();
		assert p != null;
		transformation.addOrphan(p);
		transformation.putTransformationToPackageTrace(ruleBindings.get(RELATIONS_rt), p);
		for (SubRecord subRecord : subRecords) {
			org.eclipse.ocl.pivot.Class rc = PivotFactory.eINSTANCE.createClass();
			assert rc != null;
			p.getOwnedClasses().add(rc);
			subRecord.rc = rc;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractRule#setAttributes()
	 */
	@Override
	public void setAttributes() {
		
		p.setName("P" + rtn);
		p.setURI(p.getName());
	}
	
	@Override
	public void where() {
		QVTr2QVTcRelations relations = new QVTr2QVTcRelations(transformation);
		for (SubRecord subRecord : subRecords) {
			final org.eclipse.ocl.pivot.Class rc2 = subRecord.rc;
			assert (rc2 != null);
			relations.doRelationToTraceClass(subRecord.r, rc2);
		}
	}
}
