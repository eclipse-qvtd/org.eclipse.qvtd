package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.KeyBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractBindings.KeySet;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;

public class QVTcoreBaseBottomPatternKey implements RelationKey {
	
	private static final @NonNull KeyBindings.KeySet RELATION_KEY_BINDINGS = new KeyBindings.KeySet();
	public static final @NonNull KeyBindings.KeyKey<Area> AREA = RELATION_KEY_BINDINGS.create((Area)null, "area");
	
	private Map<KeyBindings, BottomPattern> bottomPatterns = new HashMap<KeyBindings, BottomPattern>();
	
		
	public void add(BottomPattern bottomPattern) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(AREA, bottomPattern.getArea());
		bottomPatterns.put(relationKeyBindings, bottomPattern);
	}
	
	public BottomPattern get(Area area) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(AREA, area);
		return bottomPatterns.get(relationKeyBindings);
	}
	
	@Override
	@NonNull
	public KeySet getKeyBindings() {
		return RELATION_KEY_BINDINGS;
	}

}
