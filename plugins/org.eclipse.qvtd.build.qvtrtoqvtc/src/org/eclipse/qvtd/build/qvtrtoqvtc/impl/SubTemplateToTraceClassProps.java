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
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class SubTemplateToTraceClassProps extends AbstractRule
{	
	
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
	public static final @NonNull RuleBindings.RuleKey<ObjectTemplateExp> RELATIONS_tp = RULE_BINDINGS.create((ObjectTemplateExp)null, "tp");
	
	// Core
	@NonNull org.eclipse.ocl.examples.pivot.Class rc;
	
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();

	public SubTemplateToTraceClassProps(@NonNull QvtrToQvtcTransformation transformation,
			@NonNull ObjectTemplateExp t,
			@NonNull org.eclipse.ocl.examples.pivot.Class rc) {
		super(transformation);
		ruleBindings.put(RELATIONS_t, t);
		this.rc = rc;
	}

	public void check() {
		ObjectTemplateExp t = ruleBindings.get(RELATIONS_t);
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

	public @NonNull RuleBindings.KeySet getRuleBindingsKeys() {
		return RULE_BINDINGS;
	}
	
	
	@Override
	public void instantiateOutput() {
		for (SubRecord subRecord : subRecords) {
			Property a = transformation.findProperty(subRecord.vn, rc);
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
		for (SubRecord subRecord : subRecords) {
			Property a = subRecord.a;
			assert a != null;
			//a.setName(subRecord.vn);
			a.setType(subRecord.c);
			//rc.getOwnedAttribute().add(a);
		}
		
	}

	@Override
	public void where() {
		for (SubRecord subRecord : subRecords) {
			Rule innerRule = new SubTemplateToTraceClassProps(transformation, subRecord.tp, rc);
			if (innerRule != null) {
				assert !innerRule.hasExecuted();
				transformation.executeNestedRule(innerRule);
			}
			
		}
	}

}
