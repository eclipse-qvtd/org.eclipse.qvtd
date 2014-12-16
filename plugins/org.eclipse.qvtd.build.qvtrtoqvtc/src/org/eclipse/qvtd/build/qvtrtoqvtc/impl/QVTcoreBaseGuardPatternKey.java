package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.KeyBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractBindings.KeySet;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;

public class QVTcoreBaseGuardPatternKey implements RelationKey {
	
	private static final @NonNull KeyBindings.KeySet RELATION_KEY_BINDINGS = new KeyBindings.KeySet();
	public static final @NonNull KeyBindings.KeyKey<Area> AREA = RELATION_KEY_BINDINGS.create((Area)null, "area");
	
	
	private Map<KeyBindings, GuardPattern> guardPatterns = new HashMap<KeyBindings, GuardPattern>();
	
	
	public void add(GuardPattern guardPattern) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(AREA, guardPattern.getArea());
		guardPatterns.put(relationKeyBindings, guardPattern);
	}
	
	public GuardPattern get(Area area) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(AREA, area);
		return guardPatterns.get(relationKeyBindings);
	}
	
	@Override
	@NonNull
	public KeySet getKeyBindings() {
		return RELATION_KEY_BINDINGS;
	}

}
