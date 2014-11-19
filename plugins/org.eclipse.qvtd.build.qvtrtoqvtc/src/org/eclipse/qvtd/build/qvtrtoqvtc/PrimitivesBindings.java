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

public class PrimitivesBindings extends AbstractBindings
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
		
		public @NonNull <T> Key<T> create(@Nullable T keyClass, @NonNull String key) {
			Key<T> theKey = new Key<T>(key);
			keys.add(theKey);
			return theKey;
		}

		public @NonNull List<Key<?>> getKeys() {
			return keys;
		}

		@Override
		public String toString() {
			return keys.toString();
		}
	}

	private final @NonNull RelationsBindings relationsBindings;
	private @Nullable CoreBindings coreBindings = null;
	
	public PrimitivesBindings(@NonNull RelationsBindings relationsBindings) {
		this.relationsBindings = relationsBindings;
	}
	
	protected void checkKey(@NonNull AbstractBindings.Key<?> key) {
		ConstrainedRule rule = relationsBindings.getRule();
		for (Key<?> relationsKey : rule.getPrimitivesBindingsKeys().getKeys()) {
			if (relationsKey == key) {
				return;
			}
		}
		throw new IllegalArgumentException("Incompatible core key " + key + " for " + rule);
	}

	public boolean containsKey(@NonNull Key<?> key) {
		return delegate.containsKey(key);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(@NonNull Key<T> key) {
		return (T) delegate.get(key);
	}
	
	public @NonNull CoreBindings getCoreBindings() {
		CoreBindings coreBindings2 = coreBindings;
		if (coreBindings2 == null) {
			coreBindings = coreBindings2 = new CoreBindings(this);
		}
		return coreBindings2;
	}

	public @NonNull RelationsBindings getRelationsBindings() {
		return relationsBindings;
	}
	
	public @NonNull TraceRecord getTraceRecord() {
		return getCoreBindings().getTraceRecord();
	}

	public @NonNull ConstrainedRule getRule() {
		return relationsBindings.getRule();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T put(@NonNull Key<T> key, T value) {
		return (T) delegate.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T remove(@NonNull Key<T> key) {
		return (T) delegate.remove(key);
	}
}
