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
package org.eclipse.qvt.declarative.modelregistry.standalone;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractProjectHandle;

public class ProjectHandle extends FileHandle implements AbstractProjectHandle
{
	private Map<String,FileHandle> handles = new HashMap<String,FileHandle>();
	private String registryName = DEFAULT_MODEL_REGISTRY_PATH;
	private String rootPath = null;
	
	public ProjectHandle(String projectFile, String registryPath) throws IOException {
		this(new File(projectFile), registryPath);
		handles.put(getFile().toString(), this);
	}
	
	public ProjectHandle(File projectFile, String registryPath) throws IOException {
		super(projectFile);
		setRegistryName(registryPath); 
		handles.put(getFile().toString(), this);
	}

	public FileHandle getFileHandle(String name) throws IOException {
		File referenceFile = getFile();
		if (name.startsWith("/")) {
			name = name.substring(1);
			if (rootPath == null)
				referenceFile = new File(referenceFile.getParent());
			else
				referenceFile = new File(rootPath);
		}
		File memberFile = new File(referenceFile, name);
		return getFileHandle(memberFile);
	}

	public FileHandle getFileHandle(File file) throws IOException {
		if (file == null)
			return null;
		String canonicalFileName = createCanonicalFileName(file);
		FileHandle handle = handles.get(canonicalFileName);
		if (handle == null) {
			handle = new FileHandle(this, file);
			handles.put(handle.getFile().toString(), handle);
		}
		return handle;
	}
	
	@Override public FileHandle getParentFileHandle() {
		return null;
	}

	public File getRegistryFile() {
		return new File(file, getRegistryName());
	}

	public String getRegistryName() {
		return registryName;
	}
	
	public URI getRegistryURI() {
		URI registryURI = URI.createURI(registryName);
		URI projectURI = getURI();
		URI resolvedURI = registryURI.resolve(projectURI);
		return resolvedURI;
	}

	public String getRoot() {
		return rootPath;
	}

	@Override public URI getURI() {
		return URI.createFileURI(getFile().toString() + "/");
	}
	
	public void refreshRegistry() {}

	public void setRegistryName(String name) {
		registryName = name != null ? name : DEFAULT_MODEL_REGISTRY_PATH;
	}

	public void setRoot(String rootPath) {
		this.rootPath = rootPath;		
	}
}
