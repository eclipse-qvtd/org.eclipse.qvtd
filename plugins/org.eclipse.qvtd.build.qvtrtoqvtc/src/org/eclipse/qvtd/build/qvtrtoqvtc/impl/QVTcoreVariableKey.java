package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.KeyBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.KeyBindings.KeySet;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationKey;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;

public class QVTcoreVariableKey implements RelationKey {
	
	private static final @NonNull KeyBindings.KeySet RELATION_KEY_BINDINGS = new KeyBindings.KeySet();
	public static final @NonNull KeyBindings.KeyKey<String> NAME = RELATION_KEY_BINDINGS.create((String)null, "name");
	public static final @NonNull KeyBindings.KeyKey<Type> TYPE = RELATION_KEY_BINDINGS.create((Type)null, "type");
	public static final @NonNull KeyBindings.KeyKey<CorePattern> CORE_PATTERN = RELATION_KEY_BINDINGS.create((CorePattern)null, "corePattern");

	private Map<KeyBindings, Variable> variables = new HashMap<KeyBindings, Variable>();
	
	public void add(Variable variable, CorePattern pattern) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(NAME, variable.getName());
		relationKeyBindings.put(TYPE, variable.getType());
		relationKeyBindings.put(CORE_PATTERN, pattern);
		variables.put(relationKeyBindings, variable);
	}
	
	public Variable get(String name, Type type, CorePattern pattern) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(NAME, name);
		relationKeyBindings.put(TYPE, type);
		relationKeyBindings.put(CORE_PATTERN, pattern);
		return variables.get(relationKeyBindings);
	}
	
	@Override
	@NonNull
	public KeySet getKeyBindings() {
		return RELATION_KEY_BINDINGS;
	}

}
