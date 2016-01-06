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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.Rule;

public class RuleBindings extends AbstractBindings
{
	public static class RuleKey<T> extends AbstractBindings.Key<T>
	{
		private RuleKey(@NonNull String key) {
			super(key);
		}
	}

	public static class KeySet extends AbstractBindings.KeySet
	{
		protected final @NonNull List<Key<?>> rootKeys = new ArrayList<Key<?>>();
		
		public @NonNull <T> RuleKey<T> create(@Nullable T keyClass, @NonNull String key) {
			RuleKey<T> theKey = new RuleKey<T>(key);
			keys.add(theKey);
			return theKey;
		}
		
		public @NonNull <T> RuleKey<T> createRoot(@Nullable T keyClass, @NonNull String key) {
			RuleKey<T> rootKey = create(keyClass, key);
			rootKeys.add(rootKey);
			return (RuleKey<T>) rootKey;
		}
		
		public @NonNull List<Key<?>> getRootKeys() {
			return rootKeys;
		}
	}
	
	protected @NonNull final Rule rule;
	private Integer hashCode;
	
	public RuleBindings(@NonNull Rule rule) {
		this.rule = rule;
	}
	
	protected void checkKey(AbstractBindings.@NonNull Key<?> key) {
		for (Key<?> relationsKey : rule.getRuleBindingsKeys().getKeys()) {
			if (relationsKey == key) {
				return;
			}
		}
		throw new IllegalArgumentException("Incompatible relations key " + key + " for " + rule);
	}

	public boolean containsKey(@NonNull RuleKey<?> key) {
		return delegate.containsKey(key);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(@NonNull RuleKey<T> key) {
		return (T) delegate.get(key);
	}

	public @NonNull Rule getRule() {
		return rule;
	}
	
	public boolean matches(@NonNull RuleKey<?> rootKey, @NonNull RuleBindings traceBindings) {
		
		Object boundValue = get(rootKey);
		if ((boundValue == null) && !containsKey(rootKey)) {
			return false;
		}
		Object traceValue = traceBindings.get(rootKey);
		if ((traceValue == null) && !traceBindings.containsKey(rootKey)) {
			return false;
		}
		if (traceValue == null) {
			if (boundValue != null) {
				return false;
			}
		}
		else if (!(traceValue.equals(boundValue))) {
			return false;
		}
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T put(@NonNull RuleKey<T> key, T value) {
		return (T) delegate.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T remove(@NonNull RuleKey<T> key) {
		return (T) delegate.remove(key);
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
			Object thisValue = get((RuleKey<?>) key);
			Object thatValue = rb.get((RuleKey<?>) key);
			if (thisValue != thatValue)
				return false;
		}
		return true;
		*/
		return delegate.equals(rb.delegate);
	}
	
	@Override
	public int hashCode() {
	    if (hashCode == null) {
	        hashCode = getClass().hashCode() + delegate.hashCode();
	    }
	    return hashCode.intValue();
	}
	/*
	@Override
	public int hashCode() {
		int code = 0;
		code += this.getClass().hashCode();
		for (Key<?> key : rule.getRuleBindingsKeys().getRootKeys()) {
			assert key != null;
			code += get((RuleKey<?>) key).hashCode();
		}
		return code;
	}
	*/
	
}
