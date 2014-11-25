package org.eclipse.qvtd.build.qvtrtoqvtc;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractBindings;

public class KeyBindings extends AbstractBindings {
	
	
	public static class KeyKey<T> extends AbstractBindings.Key<T>
	{
		private KeyKey(@NonNull String key) {
			super(key);
		}
	}

	public static class KeySet extends AbstractBindings.KeySet
	{
		
		public @NonNull <T> KeyKey<T> create(@Nullable T keyClass, @NonNull String key) {
			KeyKey<T> theKey = new KeyKey<T>(key);
			keys.add(theKey);
			return theKey;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == this)
				return true;
			if (!(o instanceof KeySet))
				return false;
			KeySet oks = (KeySet) o;
			return this.keys.equals(oks.keys);
		}
		
		@Override
		public int hashCode() {
			return keys.hashCode();
		}
		
	}
	
	protected @NonNull final RelationKey relationKey;
	
	public KeyBindings(@NonNull RelationKey relationKey) {
		this.relationKey = relationKey;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(@NonNull KeyKey<T> key) {
		return (T) delegate.get(key);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T put(@NonNull KeyKey<T> key, T value) {
		return (T) delegate.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T remove(@NonNull KeyKey<T> key) {
		return (T) delegate.remove(key);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof KeyBindings))
			return false;
		KeyBindings rb = (KeyBindings) o;
		//if (rule.getClass() != rb.getRule().getClass())
		//	return false;
		for (Key<?> key : relationKey.getKeyBindings().getKeys()) {
			assert key != null;
			Object thisValue = get((KeyKey<?>) key);
			Object thatValue = rb.get((KeyKey<?>) key);
			if (thisValue != thatValue)
				return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int code = 0;
		code += this.getClass().hashCode();
		for (Key<?> key : relationKey.getKeyBindings().getKeys()) {
			assert key != null;
			code += get((KeyKey<?>) key).hashCode();
		}
		return code;
	}
	
}
