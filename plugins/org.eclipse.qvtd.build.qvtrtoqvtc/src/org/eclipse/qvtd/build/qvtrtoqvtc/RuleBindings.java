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
package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class RuleBindings extends AbstractBindings
{
	public static class Key<T> extends AbstractBindings.Key<T>
	{
		private Key(@NonNull String key) {
			super(key);
		}
	}

	public static class KeySet
	{
		protected final @NonNull List<Key<?>> keys = new ArrayList<Key<?>>();
		protected final @NonNull List<Key<?>> rootKeys = new ArrayList<Key<?>>();
		
		public @NonNull <T> Key<T> create(@Nullable T keyClass, @NonNull String key) {
			Key<T> theKey = new Key<T>(key);
			keys.add(theKey);
			return theKey;
		}
		
		public @NonNull <T> Key<T> createRoot(@Nullable T keyClass, @NonNull String key) {
			Key<T> rootKey = create(keyClass, key);
			rootKeys.add(rootKey);
			return (Key<T>) rootKey;
		}

		public @NonNull List<Key<?>> getKeys() {
			return keys;
		}
		
		public @NonNull List<Key<?>> getRootKeys() {
			return rootKeys;
		}
		

		@Override
		public String toString() {
			return keys.toString();
		}
	}
	
	public RuleBindings(@NonNull Rule rule) {
		super(rule);
	}
	
	protected void checkKey(@NonNull AbstractBindings.Key<?> key) {
		for (Key<?> relationsKey : rule.getRuleBindingsKeys().getKeys()) {
			if (relationsKey == key) {
				return;
			}
		}
		throw new IllegalArgumentException("Incompatible relations key " + key + " for " + rule);
	}

	public boolean containsKey(@NonNull Key<?> key) {
		return delegate.containsKey(key);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(@NonNull Key<T> key) {
		return (T) delegate.get(key);
	}

	@Override
	@NonNull
	public Rule getRule() {
		return rule;
	}
	
	public boolean matches(@NonNull Key<?> rootKey, @NonNull RuleBindings traceBindings) {
		
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
	public <T> T put(@NonNull Key<T> key, T value) {
		return (T) delegate.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T remove(@NonNull Key<T> key) {
		return (T) delegate.remove(key);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
		{
			return false;
		}

		if (this.getClass() != o.getClass())
		{
			return false;
		}
		RuleBindings rb = (RuleBindings) o;
		if (rule.getClass() != rb.getRule().getClass())
			return false;
		for (Key<?> key : rule.getRuleBindingsKeys().getRootKeys()) {
			assert key != null;
			Object thisValue = get(key);
			Object thatValue = rb.get(key);
			if (thisValue != thatValue)
				return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int code = 0;
		code += this.getClass().hashCode();
		for (Key<?> key : rule.getRuleBindingsKeys().getRootKeys()) {
			assert key != null;
			code += get(key).hashCode();
		}
		return code;
	}
	
	
	
	
}
