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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.build.qvtrtoqvtc.RuleBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;

public abstract class AbstractRule implements Rule
{
	protected static abstract class Factory implements Rule.Factory
	{
		public abstract @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation,  @NonNull EObject eo,
				@NonNull TransformationTraceData traceData);
		
		public @NonNull List<Rule> getRules(@NonNull QvtrToQvtcTransformation transformation, @NonNull Resource inputModel,
				@NonNull TransformationTraceData traceData) {
			List<Rule> rules = new ArrayList<Rule>();
			TreeIterator<EObject> it = inputModel.getAllContents();
			while(it.hasNext()) {
				EObject eo = it.next();
				if (eo != null) {
					Rule rule = createRule(transformation, eo, traceData);
					if (rule != null) {
						rules.add(rule);
					}
				}
			}
			return rules;
		}
	}
	
	
	public abstract class AbstractSubRecord implements AbstractRule.SubRecord
	{
		protected final @NonNull RuleBindings ruleBindings;
		
		
		protected AbstractSubRecord(@NonNull Rule rule) {
			
			ruleBindings = new RuleBindings(rule);
		}
		
		@Override
		public @NonNull RuleBindings getRuleBindings() {
			return ruleBindings;
		}

		@Override
		@NonNull
		public RuleBindings.KeySet getRuleBindingsKeys() {
			return (RuleBindings.KeySet) ruleBindings.keySet();
		}
	}
	
	protected final @NonNull QvtrToQvtcTransformation transformation;
	protected final @NonNull RuleBindings ruleBindings = new RuleBindings(this);
	protected final @NonNull List<SubRecord> subRecords = new ArrayList<SubRecord>();
	
	private boolean executed = false;

	protected AbstractRule(@NonNull QvtrToQvtcTransformation transformation) {
		this.transformation = transformation;
	}

	public void check() {
		throw new UnsupportedOperationException();
	}

	public void instantiateOutput() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public RuleBindings getRuleBindings() {
		return ruleBindings;
	}

	@Override
	@NonNull
	public RuleBindings.KeySet getRuleBindingsKeys() {
		return (RuleBindings.KeySet) ruleBindings.keySet();
	}

	@NonNull
	public List<? extends SubRecord> getSubRecords() {
		return subRecords;
	}

	@Override
	public boolean hasExecuted() {
		return executed;
	}

	@Override
	public void setAttributes() {}


	@Override
	public void setExecuted(boolean executed) {
		this.executed = executed;
	}

	@Override
	public boolean when(@NonNull TransformationTraceData traceData) {
		return true;
	}

	@Override
	public void where(@NonNull TransformationTraceData traceData) {}
}
