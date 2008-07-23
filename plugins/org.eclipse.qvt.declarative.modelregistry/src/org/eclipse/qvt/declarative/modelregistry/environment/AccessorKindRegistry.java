/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.modelregistry.environment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.qvt.declarative.modelregistry.model.Accessor;
import org.eclipse.qvt.declarative.modelregistry.model.ModelNameAccessor;
import org.eclipse.qvt.declarative.modelregistry.util.ClassUtils;

/**
 * The map of accessor kinds to accessor prototypes.
 */
public class AccessorKindRegistry
{
	private static class AccessorClassToAccessorMap {
		private HashMap<Class<? extends Accessor>, Accessor> map = new HashMap<Class<? extends Accessor>, Accessor>();
		@SuppressWarnings("unchecked")
		public <A extends Accessor> A get(Class<A> key) {
			return (A) map.get(key);
		}
		@SuppressWarnings("unchecked")
		public <A extends Accessor> A put(Class<A> key, A value) {
			return (A) map.put(key, value);
		}
	}
	private final Map<String, Class<? extends Accessor>> kindToClassMap = new HashMap<String, Class<? extends Accessor>>();
	private final AccessorClassToAccessorMap classToPrototypeMap = new AccessorClassToAccessorMap();

	public Accessor createAccessor(String accessorKind, String accessorName) {
		Class<? extends Accessor> accessorClass =  kindToClassMap.get(accessorKind != null ? accessorKind : ModelNameAccessor.KIND);
		if (accessorClass == null)
			return null;
		return createAccessor(accessorClass, accessorName);
	}

	public <A extends Accessor> A createAccessor(Class<A> accessorClass, String accessorName) {
		A accessorPrototype = classToPrototypeMap.get(accessorClass);
		try {
			return ClassUtils.asClassChecked(accessorPrototype.newInstance(accessorName), accessorClass);
		} catch (Exception e) {
			ModelRegistryEnvironment.logError("Unable to construct '" + accessorPrototype.getClass().getName() + "' instance", e);
			return null;
		}
	}

	public Class<? extends Accessor> getAccessorClass(String accessorKind) {
		return kindToClassMap.get(accessorKind);
	}

	public Collection<String> getKinds() {
		return kindToClassMap.keySet();
	}

	public <A extends Accessor> void addAccessor(A accessorPrototype) {
		Class<A> accessorClass = ClassUtils.getClass(accessorPrototype);
 		kindToClassMap.put(accessorPrototype.getKind(), accessorClass);
		classToPrototypeMap.put(accessorClass, accessorPrototype);
	}
	 
	public <A extends Accessor> String toAccessorString(Class<A> accessorClass) {
		Accessor prototype = classToPrototypeMap.get(accessorClass);
		return prototype.getKind() + ":" + prototype.getName();
	}
}
