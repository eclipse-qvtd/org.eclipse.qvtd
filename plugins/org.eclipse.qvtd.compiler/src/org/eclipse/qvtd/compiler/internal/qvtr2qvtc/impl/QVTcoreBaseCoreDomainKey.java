package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.KeyBindings;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.RelationKey;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.AbstractBindings.KeySet;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;

public class QVTcoreBaseCoreDomainKey implements RelationKey {
	
	
	private static final @NonNull KeyBindings.KeySet RELATION_KEY_BINDINGS = new KeyBindings.KeySet();
	public static final @NonNull KeyBindings.KeyKey<String> NAME = RELATION_KEY_BINDINGS.create((String)null, "name");
	public static final @NonNull KeyBindings.KeyKey<org.eclipse.qvtd.pivot.qvtbase.Rule> RULE = RELATION_KEY_BINDINGS.create((org.eclipse.qvtd.pivot.qvtbase.Rule)null, "rule");
	
	private Map<KeyBindings, CoreDomain> coreDomains = new HashMap<KeyBindings, CoreDomain>();
	
	public void add(CoreDomain coreDomain) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(NAME, coreDomain.getName());
		relationKeyBindings.put(RULE, coreDomain.getRule());
		coreDomains.put(relationKeyBindings, coreDomain);
	}
	
	public CoreDomain get(String name, org.eclipse.qvtd.pivot.qvtbase.Rule rule) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(NAME, name);
		relationKeyBindings.put(RULE, rule);
		return coreDomains.get(relationKeyBindings);
	}
	
	@Override
	@NonNull
	public KeySet getKeyBindings() {
		return RELATION_KEY_BINDINGS;
	}
	
}
