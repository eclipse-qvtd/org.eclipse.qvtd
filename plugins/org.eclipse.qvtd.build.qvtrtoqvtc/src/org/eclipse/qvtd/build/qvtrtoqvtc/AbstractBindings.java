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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

/**
 * AbstractBindings defines the interface for a typesafe heterogeneous Map<Key<T>,T> in which each entry may have a distinct T.
 * <p>
 * Derived classes provide further typesafety for keys of the distinct relations (input), core (output) and primitives (temporary) domains.
 */
public abstract class AbstractBindings
{
	public static abstract class Key<T>
	{
		private final @NonNull String key;
		
		protected Key(@NonNull String key) {
			this.key = key;
		}
	
		public @NonNull String getKey() {
			return key;
		}
	
		/*
		 * The default per-object hashCode is suitable since Key<X>("x") is a different key to Key<Y)("x").
		 * In the absence of run-time class information inadvertent declaration of a duplicate will create
		 * two distinct keys.
		 */
		// public int hashCode() { return super.hashCode(); }
	
		/*
		 * The default per-object equals is suitable since Key<X>("x") is a different key to Key<Y)("x").
		 */
		// public boolean equals(Object obj) {
		
		@Override
	    public @NonNull String toString() {
	        return key;
	    }
	}

	protected final @NonNull Map<Key<?>, Object> delegate = new HashMap<Key<?>, Object>();
//	private Integer hashCode = null;				// Non-nuyll once Bindings becomes readOnly.
	
	protected @NonNull final Rule rule;
	
	protected AbstractBindings(@NonNull Rule rule) {
		this.rule = rule;
	}
	
	public void clear() {
		delegate.clear();
	}

	public boolean containsValue(Object value) {
		return delegate.containsValue(value);
	}

	@SuppressWarnings("null")
	public @NonNull Set<Map.Entry<Key<?>, Object>> entrySet() {
		return delegate.entrySet();
	}
	

	public @NonNull Rule getRule() {
		return rule;
	}


	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	@SuppressWarnings("null")
	public @NonNull Set<Key<?>> keySet() {		
		return delegate.keySet();
	}	

	public int size() {
		return delegate.size();
	}

	@Override
	public String toString() {
		return delegate.toString();
	}

	@SuppressWarnings("null")
	public @NonNull Collection<Object> values() {
		return delegate.values();
	}
}
