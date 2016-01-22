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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.Rule;

public class RuleBindings
{
	protected @NonNull final Rule rule;
	private Integer hashCode;
	
	public RuleBindings(@NonNull Rule rule) {
		this.rule = rule;
	}

	public @NonNull Rule getRule() {
		return rule;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof RuleBindings))
			return false;
		RuleBindings rb = (RuleBindings) o;
		if (rule.getClass() != rb.getRule().getClass())
			return false;
		/*
		for (Key<?> key : rule.getRuleBindingsKeys().getRootKeys()) {
			assert key != null;
			Object thisValue = get((Key<?>) key);
			Object thatValue = rb.get((RuleKey<?>) key);
			if (thisValue != thatValue)
				return false;
		}
		return true;
		*/
		return false;
	}
	
	@Override
	public int hashCode() {
	    if (hashCode == null) {
	        hashCode = getClass().hashCode();
	    }
	    return hashCode.intValue();
	}
}
