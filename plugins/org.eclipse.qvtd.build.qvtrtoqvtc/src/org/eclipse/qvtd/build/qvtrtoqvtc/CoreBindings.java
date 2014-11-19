package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractTraceRecord;

public class CoreBindings extends AbstractBindings
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

	private final @NonNull PrimitivesBindings primitivesBindings;
	private @Nullable TraceRecord traceRecord = null;
	
	public CoreBindings(@NonNull PrimitivesBindings primitivesBindings) {
		this.primitivesBindings = primitivesBindings;
	}
	
	protected void checkKey(@NonNull AbstractBindings.Key<?> key) {
		ConstrainedRule rule = primitivesBindings.getRule();
		for (Key<?> relationsKey : rule.getCoreBindingsKeys().getKeys()) {
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

	public @NonNull PrimitivesBindings getPrimitivesBindings() {
		return primitivesBindings;
	}

	public @NonNull RelationsBindings getRelationsBindings() {
		return primitivesBindings.getRelationsBindings();
	}

	public @NonNull ConstrainedRule getRule() {
		return primitivesBindings.getRule();
	}
	
	public @NonNull TraceRecord getTraceRecord() {
		TraceRecord traceRecord2 = traceRecord ;
		if (traceRecord2 == null) {
			traceRecord = traceRecord2 = new AbstractTraceRecord(this);
		}
		return traceRecord2;
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
