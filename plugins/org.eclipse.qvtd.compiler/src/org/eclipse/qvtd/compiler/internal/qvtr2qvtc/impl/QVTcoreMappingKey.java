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
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

public class QVTcoreMappingKey implements RelationKey {
	
	private static final KeyBindings.@NonNull KeySet RELATION_KEY_BINDINGS = new KeyBindings.KeySet();
	public static final KeyBindings.@NonNull KeyKey<String> NAME = RELATION_KEY_BINDINGS.create((String)null, "name");
	public static final KeyBindings.@NonNull KeyKey<Transformation> TRANSFORMATION = RELATION_KEY_BINDINGS.create((Transformation)null, "transformation");
	
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
