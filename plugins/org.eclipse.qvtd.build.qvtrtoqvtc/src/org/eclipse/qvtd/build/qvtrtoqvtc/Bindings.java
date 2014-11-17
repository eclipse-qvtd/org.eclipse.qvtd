package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.qvtd.build.qvtrtoqvtc.impl.BindingKey;

public class Bindings implements Map<Object, Object> {

	private Map<Object, Object> delegate;
	
	
	public Bindings() {
		this.delegate = new HashMap<Object, Object>();
	}

	public Bindings(Map<Object, Object> delegate) {
		super();
		this.delegate = delegate;
	}
	
	@Override
	public Object get(Object key) {
		return delegate.get(key);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(BindingKey<T> key) {
		return (T) delegate.get(key);
	}
	
	@Override
	public Object remove(Object key) {
		return delegate.remove(key);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T remove(BindingKey<T> key) {
		return (T) delegate.remove(key);
	}
	
	@Override
	public Object put(Object key, Object value) {
		throw new UnsupportedOperationException("Put should be used using correct generic type information.");
	}
	
	@SuppressWarnings("unchecked")
	public <T> T  put(BindingKey<T> key, T value) {
		return (T) delegate.put(key, value);
	}
	

	@Override
	public void putAll(Map<? extends Object, ? extends Object> arg0) {
		delegate.putAll(arg0);
		
	}

	// The rest can be delegated
	

	@Override
	public void clear() {
		delegate.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return delegate.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return delegate.containsValue(value);
	}

	@Override
	public Set<java.util.Map.Entry<Object, Object>> entrySet() {
		return delegate.entrySet();
	}

	
	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	@Override
	public Set<Object> keySet() {		
		return delegate.keySet();
	}	

	@Override
	public int size() {
		return delegate.size();
	}

	@Override
	public Collection<Object> values() {
		return delegate.values();
	}
	
	
	
}
