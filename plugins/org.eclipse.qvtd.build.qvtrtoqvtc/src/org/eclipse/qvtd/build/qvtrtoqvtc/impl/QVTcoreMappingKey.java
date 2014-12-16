package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.KeyBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractBindings.KeySet;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

public class QVTcoreMappingKey implements RelationKey {
	
	private static final @NonNull KeyBindings.KeySet RELATION_KEY_BINDINGS = new KeyBindings.KeySet();
	public static final @NonNull KeyBindings.KeyKey<String> NAME = RELATION_KEY_BINDINGS.create((String)null, "name");
	public static final @NonNull KeyBindings.KeyKey<Transformation> TRANSFORMATION = RELATION_KEY_BINDINGS.create((Transformation)null, "transformation");
	
	private Map<KeyBindings, Mapping> mappings = new HashMap<KeyBindings, Mapping>();
	
	
	public void add(Mapping mapping) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(NAME, mapping.getName());
		relationKeyBindings.put(TRANSFORMATION, mapping.getTransformation());
		mappings.put(relationKeyBindings, mapping);
	}
	
	public Mapping get(String mn, Transformation mt) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(NAME, mn);
		relationKeyBindings.put(TRANSFORMATION, mt);
		return mappings.get(relationKeyBindings);
	}
	
	@Override
	@NonNull
	public KeySet getKeyBindings() {
		return RELATION_KEY_BINDINGS;
	}
	

}
