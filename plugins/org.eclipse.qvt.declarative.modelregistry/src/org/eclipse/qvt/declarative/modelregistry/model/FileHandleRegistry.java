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
package org.eclipse.qvt.declarative.modelregistry.model;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.modelregistry.util.ClassUtils;

/**
 * A FileHandleRegistry forms part of the in memory oorg.eclipse.qvt.declarative.modelregistry
 * model read from and updated in the project .settings folder.
 * 
 * The ProjectRegistry contains a FileHandleRegistry for each file handle for which models are
 * registered. The FileHandleRegistry in turn contains an AccessorRegistry for each Accessor class
 * and the AccessorRegistry contains the model Registrations.
 */
public class FileHandleRegistry implements Comparable<FileHandleRegistry>
{
	private static class AccessorClassToAccessorRegistryMap {
		private HashMap<Class<? extends Accessor>, AccessorRegistry<? extends Accessor>> map = new HashMap<Class<? extends Accessor>, AccessorRegistry<? extends Accessor>>();
		@SuppressWarnings("unchecked")
		public <A extends Accessor> AccessorRegistry<A> get(Class<A> key) {
			return (AccessorRegistry<A>) map.get(key);
		}
		@SuppressWarnings("unchecked")
		public <A extends Accessor> AccessorRegistry<A> put(Class<A> key, AccessorRegistry<A> value) {
			return (AccessorRegistry<A>) map.put(key, value);
		}
		public Collection<Class<? extends Accessor>> keySet() {
			return map.keySet();
		}
		public Collection<AccessorRegistry<? extends Accessor>> values() {
			return map.values();
		}
	}
	private final ProjectRegistry parent;
	private final AbstractFileHandle fileHandle;
	private final AccessorClassToAccessorRegistryMap map = new AccessorClassToAccessorRegistryMap();
	
	public FileHandleRegistry(ProjectRegistry parent, AbstractFileHandle fileHandle) {
		this.parent = parent;
		this.fileHandle = fileHandle;
	}

	public <A extends Accessor> void add(A accessor, URI ecoreURI, ModelSerialization modelSerialisation) {
		AccessorRegistry<A> registry = getOrCreate(ClassUtils.getClass(accessor));
		registry.add(accessor, ecoreURI, modelSerialisation);		
	}

	public <A extends Accessor> Registration<A> add(Registration<A> registration) {
		Class<A> accessorClass = registration.getAccessorClass();
		AccessorRegistry<A> registry = getOrCreate(accessorClass);
		return registry.add(registration);
	}

	public int compareTo(FileHandleRegistry fileHandleRegistry) {
		String name1 = getFileHandle().getProjectRelativeName();
		if (name1 == null)
			return -1;
		String name2 = fileHandleRegistry.getFileHandle().getProjectRelativeName();
		if (name2 == null)
			return 1;
		IPath path1 = new Path(name1);
		IPath path2 = new Path(name2);
		int segmentCount1 = path1.segmentCount();
		int segmentCount2 = path2.segmentCount();
		int segmentCount = Math.min(segmentCount1, segmentCount2);
		for (int i = 0; i < segmentCount; i++) {
			int comparison = path1.segment(i).compareTo(path2.segment(i));
			if (comparison != 0)
				return comparison;
		}
		return segmentCount1 - segmentCount2;
	}

	public <A extends Accessor> AccessorRegistry<A> get(Class<A> accessorClass) {
		return map.get(accessorClass);
	}

	public <A extends Accessor> AccessorRegistry<A> getOrCreate(Class<A> accessorClass) {
		AccessorRegistry<A> accessorRegistry = map.get(accessorClass);
		if (accessorRegistry == null) {
			accessorRegistry = new AccessorRegistry<A>(this, accessorClass);
			map.put(accessorClass, accessorRegistry);
		}			
		return accessorRegistry;
	}
	
	public Collection<Class<? extends Accessor>> getAccessorKeys() { return map.keySet(); }

	/**
	 * Return the depth of the file handle with respect to the project handle. Returns 0 for the
	 * project, 1 for direct project members, etc.
	 * 
	 * @return the depth with respect to the project.
	 */
	public int getDepth() {
		int depth = 0;
		for (AbstractFileHandle ancestorHandle = fileHandle.getParentFileHandle(); ancestorHandle != null; ancestorHandle = ancestorHandle.getParentFileHandle())
			depth++;
		return depth;
	}

	public AbstractFileHandle getFileHandle() { return fileHandle; }
	public ProjectRegistry getProjectRegistry() { return parent; }

	public <A extends Accessor> Registration<A> getRegistration(A accessor) {
		AccessorRegistry<A> accessorRegistry = get(ClassUtils.getClass(accessor));
		return accessorRegistry != null ? accessorRegistry.get(accessor) : null;
	}
	
	public Collection<AccessorRegistry<?>> getRegistries() { return map.values(); }

	public URI getURI(Accessor accessor) {
		Registration<?> registration = getRegistration(accessor);
		return registration != null ? registration.getURI() : null;
	}

	public <A extends Accessor> Registration<A> remove(Registration<A> registration) {
		Class<A> accessorClass = registration.getAccessorClass();
		AccessorRegistry<A> registry = getOrCreate(accessorClass);
		return registry.remove(registration);
	}
	
	@Override public String toString() {
		return getFileHandle().getAbsoluteName();
	}
}
