package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractBindings.KeySet;

public class PivotPropertyKey implements RelationKey {
	
	private static final @NonNull KeyBindings.KeySet RELATION_KEY_BINDINGS = new KeyBindings.KeySet();
	public static final @NonNull KeyBindings.KeyKey<String> NAME = RELATION_KEY_BINDINGS.create((String)null, "name");
	public static final @NonNull KeyBindings.KeyKey<Type> OWNING_TYPE = RELATION_KEY_BINDINGS.create((Type)null, "owningType");
	
	private Map<KeyBindings, Property> properties = new HashMap<KeyBindings, Property>();
	
	public void add(Property property) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(NAME, property.getName());
		relationKeyBindings.put(OWNING_TYPE, property.getOwningType());
		properties.put(relationKeyBindings, property);
	}
	
	public Property get(String name, Type owningType) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(NAME, name);
		relationKeyBindings.put(OWNING_TYPE, owningType);
		return properties.get(relationKeyBindings);
	}
	
	@Override
	@NonNull
	public KeySet getKeyBindings() {
		// TODO Auto-generated method stub
		return RELATION_KEY_BINDINGS;
	}

}
