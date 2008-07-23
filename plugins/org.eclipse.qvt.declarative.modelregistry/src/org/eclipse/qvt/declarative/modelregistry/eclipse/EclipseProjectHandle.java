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
package org.eclipse.qvt.declarative.modelregistry.eclipse;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractProjectHandle;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelRegistryEnvironment;

public class EclipseProjectHandle extends EclipseFileHandle implements AbstractProjectHandle
{
	private Map<IResource,EclipseFileHandle> handles = new HashMap<IResource,EclipseFileHandle>();
	private String registryName = DEFAULT_MODEL_REGISTRY_PATH;
//	private String rootPath = null;
	
	public EclipseProjectHandle(IProject project) {
		super(project);
		handles.put(project, this);
	}

	public EclipseFileHandle getFileHandle(String name) {
		IPath path = new Path(name);
		IContainer referenceResource = getProjectResource();
		if (path.isAbsolute()) {
			path = path.makeRelative();
			referenceResource = referenceResource.getParent();
		}
		IResource memberResource = referenceResource.findMember(path);
		if (memberResource != null)
			return getFileHandle(memberResource);
		IFile fileResource = referenceResource.getFile(path);
		if (fileResource != null)
			return getFileHandle(fileResource);
		return null;
//		return getHandle(memberResource);
//		if (memberResource == null)
//			return null;			// FIXME ?? put in a proxy to avoid deletion ??
//		return getHandle(memberResource);
	}

	public EclipseFileHandle getFileHandle(IResource resource) {
		if (resource == null)
			return null;
		EclipseFileHandle handle = handles.get(resource);
		if (handle == null) {
			// Using resource.getAdapter just introduces a needless Eclipse platform
			//  coupling without ensuring unique handles.
			handle = new EclipseFileHandle(this, resource);
			handles.put(resource, handle);
		}
		return handle;
	}
	
	public IProject getProjectResource() {
		return (IProject) getResource();
	}

	public IFile getRegistryResource() {
		return getProjectResource().getFile(new Path(getRegistryName()));
	}
	
	public URI getRegistryURI() {
		URI registryURI = URI.createURI(registryName);
		URI projectURI = getURI();
		URI resolvedURI = registryURI.resolve(projectURI);
		return resolvedURI;
	}

	public String getRegistryName() {
		return registryName;
	}

//	public String getRoot() {
//		return rootPath;
//	}

	@Override public URI getURI() {
		return URI.createURI(resource.getLocationURI().toString() + "/");
	}
	
	public void refreshRegistry() {
		IFile registryResource = getRegistryResource();
		try {
			registryResource.refreshLocal(0, null);
		} catch (CoreException e) {
			ModelRegistryEnvironment.logError("Failed to refresh registry", e);
		}
	}

	public void setRegistryName(String name) {
		registryName = name;
	}

//	public void setRoot(String rootPath) {
//		this.rootPath = rootPath;		
//	}
}
