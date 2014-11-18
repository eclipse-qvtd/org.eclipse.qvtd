package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

public class Bindings
{
	public static class Key<T>
	{
		private final @NonNull String key;
		
		public Key(@NonNull String key) {
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

	private final @NonNull Map<Key<?>, Object> delegate = new HashMap<Key<?>, Object>();
	
	public Bindings() {}
	
	@SuppressWarnings("unchecked")
	public <T> T get(@NonNull Key<T> key) {
		return (T) delegate.get(key);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T put(@NonNull Key<T> key, T value) {
		return (T) delegate.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T remove(@NonNull Key<T> key) {
		return (T) delegate.remove(key);
	}

	public void clear() {
		delegate.clear();
	}

	public boolean containsKey(@NonNull Key<?> key) {
		return delegate.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return delegate.containsValue(value);
	}

	@SuppressWarnings("null")
	public @NonNull Set<Map.Entry<Key<?>, Object>> entrySet() {
		return delegate.entrySet();
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

	@SuppressWarnings("null")
	public @NonNull Collection<Object> values() {
		return delegate.values();
	}
}
