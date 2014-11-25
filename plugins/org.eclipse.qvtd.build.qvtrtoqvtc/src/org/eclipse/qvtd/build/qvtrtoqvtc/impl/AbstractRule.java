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

public abstract class AbstractRule implements Rule
{
	protected static abstract class Factory implements Rule.Factory
	{
		public abstract @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation,
				@NonNull EObject eo);
		
		public abstract @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation,
				@NonNull List<EObject> eos);
		
		public @NonNull List<Rule> getRules(@NonNull QvtrToQvtcTransformation transformation, @NonNull Resource inputModel) {
			List<Rule> rules = new ArrayList<Rule>();
			TreeIterator<EObject> it = inputModel.getAllContents();
			while(it.hasNext()) {
				EObject eo = it.next();
				if (eo != null) {
					Rule rule = createRule(transformation, eo);
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
	public boolean when() {
		return true;
	}

	@Override
	public void where() {}
}
