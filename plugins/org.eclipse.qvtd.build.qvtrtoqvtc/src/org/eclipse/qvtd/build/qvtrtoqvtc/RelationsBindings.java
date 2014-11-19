package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class RelationsBindings extends AbstractBindings
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
	
	private final @NonNull ConstrainedRule rule;
	private @Nullable PrimitivesBindings primitivesBindings = null;
	
	public RelationsBindings(@NonNull ConstrainedRule rule) {
		this.rule = rule;
	}
	
	protected void checkKey(@NonNull AbstractBindings.Key<?> key) {
		for (Key<?> relationsKey : rule.getRelationsBindingsKeys().getKeys()) {
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

	public @NonNull ConstrainedRule getRule() {
		return rule;
	}
	
	public @NonNull CoreBindings getCoreBindings() {
		return getPrimitivesBindings().getCoreBindings();
	}
	
	public @NonNull PrimitivesBindings getPrimitivesBindings() {
		PrimitivesBindings primitivesBindings2 = primitivesBindings;
		if (primitivesBindings2 == null) {
			primitivesBindings = primitivesBindings2 = new PrimitivesBindings(this);
		}
		return primitivesBindings2;
	}
	
	public @NonNull TraceRecord getTraceRecord() {
		return getPrimitivesBindings().getTraceRecord();
	}

	public boolean matches(@NonNull KeySet allKeys, @NonNull RelationsBindings traceBindings) {
		for (@SuppressWarnings("null")@NonNull Key<?> key : allKeys.getKeys()) {
			Object boundValue = get(key);
			if ((boundValue == null) && !containsKey(key)) {
				return false;
			}
			Object traceValue = traceBindings.get(key);
			if ((traceValue == null) && !traceBindings.containsKey(key)) {
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
}
