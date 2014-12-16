package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.KeyBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractBindings.KeySet;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationKey;
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
