/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.KeyBindings;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.RelationKey;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.AbstractBindings.KeySet;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;

public class QVTcoreBaseBottomPatternKey implements RelationKey {
	
	private static final KeyBindings.@NonNull KeySet RELATION_KEY_BINDINGS = new KeyBindings.KeySet();
	public static final KeyBindings.@NonNull KeyKey<Area> AREA = RELATION_KEY_BINDINGS.create((Area)null, "area");
	
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
