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
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class RelationToTraceClass extends AbstractRule
{
	private static class SubRecord implements AbstractRule.SubRecord
	{
//		public final @NonNull RelationDomain rd;
//		public final @NonNull DomainPattern rdp;
		public final @NonNull ObjectTemplateExp t;
//		public final @NonNull Variable tv;
		public final @Nullable String vn;
//		public final @NonNull Type c;
		
		public SubRecord(@NonNull RelationDomain rd, @NonNull DomainPattern rdp, @NonNull ObjectTemplateExp t, @NonNull Variable tv, @Nullable String vn, @NonNull Type c) {
//			this.rd = rd;
//			this.rdp = rdp;
			this.t = t;
//			this.tv = tv;
			this.vn = vn;
//			this.c = c;
		}
	}
	
	// Relations
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	public static final @NonNull RelationsBindings.Key<Relation> RELATIONS_r = RELATIONS_BINDINGS.create((Relation)null, "r");
//	public static final @NonNull RelationsBindings.Key<RelationDomain> RELATIONS_rd = RELATIONS_BINDINGS.create((RelationDomain)null, "rd");
//	public static final @NonNull RelationsBindings.Key<DomainPattern> RELATIONS_rdp = RELATIONS_BINDINGS.create((DomainPattern)null, "rdp");
//	public static final @NonNull RelationsBindings.Key<ObjectTemplateExp> RELATIONS_t = RELATIONS_BINDINGS.create((ObjectTemplateExp)null, "t");
//	public static final @NonNull RelationsBindings.Key<Variable> RELATIONS_tv = RELATIONS_BINDINGS.create((Variable)null, "tv");
//	public static final @NonNull RelationsBindings.Key<Type> RELATIONS_c = RELATIONS_BINDINGS.create((Type)null, "c");

	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	public static final @NonNull CoreBindings.Key<org.eclipse.ocl.examples.pivot.Class> CORE_rc = CORE_BINDINGS.create((org.eclipse.ocl.examples.pivot.Class)null, "rc");
//	public static final @NonNull CoreBindings.Key<Property> CORE_a = CORE_BINDINGS.create((Property)null, "a");
	
	private final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();
	
	public RelationToTraceClass(@NonNull QvtrToQvtcTransformation transformation) {
		super(transformation);
	}

	public void check() {
		Relation r = relationsBindings.get(RELATIONS_r);
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
					subRecords.add(new SubRecord(rd, rdp, t, tv, tv.getName(), c));
				}
			}
		}
	}

	@Override
	public void enforce() {
		org.eclipse.ocl.examples.pivot.Class rc = coreBindings.get(CORE_rc);
		assert (rc != null);
		rc = PivotFactory.eINSTANCE.createClass();
		for (SubRecord subRecord : subRecords) {
			Property a = PivotFactory.eINSTANCE.createProperty();
			a.setName(subRecord.vn);
			rc.getOwnedAttribute().add(a);
		}
	}

	public @NonNull CoreBindings.KeySet getCoreBindingsKeys() {
		return CORE_BINDINGS;
	}

	public @NonNull RelationsBindings.KeySet getRelationsBindingsKeys() {
		return RELATIONS_BINDINGS;
	}

	public @NonNull List<SubRecord> getSubRecords() {
		return subRecords;
	}
	
	@Override
	public void where() {
		org.eclipse.ocl.examples.pivot.Class rc = coreBindings.get(CORE_rc);
		for (SubRecord subRecord : subRecords) {
			SubTemplateToTraceClassProps innerRule = new SubTemplateToTraceClassProps(transformation);
			RelationsBindings innerRelationsBindings = innerRule.getRelationsBindings();
			innerRelationsBindings.put(SubTemplateToTraceClassProps.RELATIONS_t, subRecord.t);
			CoreBindings innerCoreBindings = innerRule.getCoreBindings();
			innerCoreBindings.put(SubTemplateToTraceClassProps.CORE_rc, rc);
			transformation.executeNestedRule(innerRule);
		}
	}
}
