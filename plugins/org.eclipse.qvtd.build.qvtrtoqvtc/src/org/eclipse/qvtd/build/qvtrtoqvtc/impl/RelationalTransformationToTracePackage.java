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
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
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
			}
			return rule;
		}
	}
	
	private static class SubRecord implements AbstractRule.SubRecord
	{
		public final @NonNull Relation r;
		public final @Nullable String rn;
		public org.eclipse.ocl.examples.pivot.Class c;
	
		public SubRecord(@NonNull Relation r, @Nullable String rn) {
			this.r = r;
			this.rn = rn;
		}
	}

	public static final @NonNull Rule.Factory FACTORY = new Factory(); 
	
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	public static final @NonNull RelationsBindings.Key<RelationalTransformation> RELATIONS_rt = RELATIONS_BINDINGS.createRoot((RelationalTransformation)null, "rt");
	
	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	public static final @NonNull CoreBindings.Key<org.eclipse.ocl.examples.pivot.Package> CORE_p = CORE_BINDINGS.create((org.eclipse.ocl.examples.pivot.Package)null, "p");
	
	// Primitives
	String rtn;

	private final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();

	public RelationalTransformationToTracePackage(@NonNull QvtrToQvtcTransformation transformation, @NonNull RelationalTransformation rt) {
		super(transformation);
		relationsBindings.put(RELATIONS_rt, rt);
	}

	@Override
	public void check() {
		RelationalTransformation rt = relationsBindings.get(RELATIONS_rt);
		rtn = rt.getName();
		org.eclipse.ocl.examples.pivot.Package p = coreBindings.get(CORE_p);
		assert (rt != null) && (p == null);
		for (org.eclipse.qvtd.pivot.qvtbase.Rule br : rt.getRule()) {
			if (br instanceof Relation) {
				Relation r = (Relation)br;
				subRecords.add(new SubRecord(r, r.getName()));
			}
		}
	}
	
	@Override
	public void enforce() {
		org.eclipse.ocl.examples.pivot.Package p = coreBindings.get(CORE_p);
		assert p == null;
		p = PivotFactory.eINSTANCE.createPackage();
		assert p != null;
		p.setName("T" + rtn);
		coreBindings.put(CORE_p, p);
		transformation.addOrphan(p);
		for (SubRecord subRecord : subRecords) {
			org.eclipse.ocl.examples.pivot.Class c = PivotFactory.eINSTANCE.createClass();
			c.setName("T" + subRecord.rn);
			p.getOwnedType().add(c);
			subRecord.c = c;
		}
	}

	public @NonNull RelationsBindings.KeySet getRelationsBindingsKeys() {
		return RELATIONS_BINDINGS;
	}
	
	public @NonNull CoreBindings.KeySet getCoreBindingsKeys() {
		return CORE_BINDINGS;
	}
	
	@Override
	public void where() {
		for (SubRecord subRecord : subRecords) {
			RelationToTraceClass innerRule = new RelationToTraceClass(transformation);
			RelationsBindings innerRelationsBindings = innerRule.getRelationsBindings();
			innerRelationsBindings.put(RelationToTraceClass.RELATIONS_r, subRecord.r);
			CoreBindings innerCoreBindings = innerRule.getCoreBindings();
			innerCoreBindings.put(RelationToTraceClass.CORE_rc, subRecord.c);
			transformation.executeNestedRule(innerRule);
		}
	}
}
