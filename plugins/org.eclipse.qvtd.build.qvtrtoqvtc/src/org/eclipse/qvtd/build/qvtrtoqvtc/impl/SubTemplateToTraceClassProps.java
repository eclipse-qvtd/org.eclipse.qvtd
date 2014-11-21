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
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class SubTemplateToTraceClassProps extends AbstractRule
{	
	private static class SubRecord implements AbstractRule.SubRecord
	{
//		public final @NonNull PropertyTemplateItem pt;
//		public final @NonNull DomainPattern rdp;
//		public final @NonNull ObjectTemplateExp tp;
//		public final @NonNull Variable tv;
		public final @Nullable String vn;
		public final @NonNull Type c;
		
		public SubRecord(@NonNull PropertyTemplateItem pt, @NonNull ObjectTemplateExp tp, @NonNull Variable tv, @Nullable String vn, @NonNull Type c) {
//			this.pt = pt;
//			this.tp = tp;
//			this.tv = tv;
			this.vn = vn;
			this.c = c;
		}
	}

	// Relations
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	public static final @NonNull RelationsBindings.Key<ObjectTemplateExp> RELATIONS_t = RELATIONS_BINDINGS.create((ObjectTemplateExp)null, "t");
//	public static final @NonNull RelationsBindings.Key<PropertyTemplateItem> RELATIONS_pt = RELATIONS_BINDINGS.create((PropertyTemplateItem)null, "pt");
//	public static final @NonNull RelationsBindings.Key<ObjectTemplateExp> RELATIONS_tp = RELATIONS_BINDINGS.create((ObjectTemplateExp)null, "tp");
//	public static final @NonNull RelationsBindings.Key<Variable> RELATIONS_tv = RELATIONS_BINDINGS.create((Variable)null, "tv");
//	public static final @NonNull RelationsBindings.Key<Type> RELATIONS_c = RELATIONS_BINDINGS.create((Type)null, "c");
	
	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	public static final @NonNull CoreBindings.Key<org.eclipse.ocl.examples.pivot.Class> CORE_rc = CORE_BINDINGS.create((org.eclipse.ocl.examples.pivot.Class)null, "rc");
	public static final @NonNull CoreBindings.Key<Property> CORE_a = CORE_BINDINGS.create((Property)null, "a");

	private final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();

	public SubTemplateToTraceClassProps(@NonNull QvtrToQvtcTransformation transformation) {
		super(transformation);
	}

	public void check() {
		ObjectTemplateExp t = relationsBindings.get(RELATIONS_t);
		org.eclipse.ocl.examples.pivot.Class rc = coreBindings.get(CORE_rc);
		assert (t != null) && (rc != null);
		for (PropertyTemplateItem pt : t.getPart()) {
			OCLExpression value = pt.getValue();
			if (value instanceof ObjectTemplateExp) {
				ObjectTemplateExp tp = (ObjectTemplateExp) value;
				Variable tv = t.getBindsTo();
				Type c = t.getType();
				if ((tv != null) && (c != null)) {
					subRecords.add(new SubRecord(pt, tp, tv, tv.getName(), c));
				}
			}
		}
	}

	@Override
	public void enforce() {
		org.eclipse.ocl.examples.pivot.Class rc = coreBindings.get(CORE_rc);
		assert rc != null;
		for (SubRecord subRecord : subRecords) {
			Property a = PivotFactory.eINSTANCE.createProperty();
			a.setName(subRecord.vn);
			a.setType(subRecord.c);
			rc.getOwnedAttribute().add(a);
		}
	}
	
	public @NonNull CoreBindings.KeySet getCoreBindingsKeys() {
		return CORE_BINDINGS;
	}

	public @NonNull RelationsBindings.KeySet getRelationsBindingsKeys() {
		return RELATIONS_BINDINGS;
	}
	
	@Override
	public void where() {
		org.eclipse.ocl.examples.pivot.Class rc = coreBindings.get(CORE_rc);
		ObjectTemplateExp t = relationsBindings.get(RELATIONS_t);
		for (PropertyTemplateItem part : t.getPart()) {
			OCLExpression value = part.getValue();
			if (value instanceof ObjectTemplateExp) {
				ObjectTemplateExp objectTemplateExp = (ObjectTemplateExp)value;
				SubTemplateToTraceClassProps innerRule = new SubTemplateToTraceClassProps(transformation);
				RelationsBindings innerRelationsBindings = innerRule.getRelationsBindings();
				innerRelationsBindings.put(SubTemplateToTraceClassProps.RELATIONS_t, objectTemplateExp);
				CoreBindings innerCoreBindings = innerRule.getCoreBindings();
				innerCoreBindings.put(SubTemplateToTraceClassProps.CORE_rc, rc);
				transformation.executeNestedRule(innerRule);
			}
		}
	}

}
