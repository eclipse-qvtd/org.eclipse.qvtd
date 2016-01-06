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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.AbstractBindings.KeySet;

public class PivotPropertyKey implements RelationKey {
	
	private static final KeyBindings.@NonNull KeySet RELATION_KEY_BINDINGS = new KeyBindings.KeySet();
	public static final KeyBindings.@NonNull KeyKey<String> NAME = RELATION_KEY_BINDINGS.create((String)null, "name");
	public static final KeyBindings.@NonNull KeyKey<Type> OWNING_TYPE = RELATION_KEY_BINDINGS.create((Type)null, "owningType");
	
	private Map<KeyBindings, Property> properties = new HashMap<KeyBindings, Property>();
	
	public void add(Property property) {
		KeyBindings relationKeyBindings = new KeyBindings(this);
		relationKeyBindings.put(NAME, property.getName());
		relationKeyBindings.put(OWNING_TYPE, property.getOwningClass());
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
