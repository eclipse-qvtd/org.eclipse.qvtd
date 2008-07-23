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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractProjectHandle;

public class FileHandle extends PlatformObject implements AbstractFileHandle
{	
	public static String createCanonicalFileName(File file) throws IOException {
		if (file == null)
			return null;
		return file.getCanonicalPath();
	}
	
	protected final ProjectHandle projectHandle;
	protected final File file;
	
	protected FileHandle(File projectFile) throws IOException {
		this.projectHandle = (ProjectHandle) this;
		this.file = projectFile != null ? new File(createCanonicalFileName(projectFile)) : null;
	}

	public FileHandle(ProjectHandle projectHandle, File file) throws IOException {
		this.projectHandle = projectHandle;
		this.file = file != null ? new File(createCanonicalFileName(file)) : null;
	}

	public boolean exists() {
		return file.exists();
	}
	
	public String getAbsoluteName() {
		return file.getAbsolutePath();
	}

	public InputStream getContents() throws FileNotFoundException {
		return new FileInputStream(file);
	}
	
	public File getFile() {
		return file;
	}

	public String getName() {
		return file.getName();
	}
	
	public FileHandle getParentFileHandle() {
		String parent = file.getParent();
		File file = parent != null ? new File(parent) : null;
		try {
			return file != null ? projectHandle.getFileHandle(file) : null;
		} catch (IOException e) {
			return null;
		}
	}
	
	public AbstractProjectHandle getProjectHandle() {
		return projectHandle;
	}
	
	public String getProjectRelativeName() {
		return getProjectRelativePath().toString();
	}
	
	public IPath getProjectRelativePath() {
		IPath filePath = new Path(getAbsoluteName());
		IPath projectPath = new Path(getProjectHandle().getAbsoluteName());
		int matchingSegements = filePath.matchingFirstSegments(projectPath);
		return filePath.removeFirstSegments(matchingSegements).setDevice(null);
	}

	public URI getURI() {
		return URI.createFileURI(getFile().toString());
	}

	public File isFile() { return file.isFile() ? file : null; }
	public File isFolder() { return file.isDirectory() ? file : null; }
	public File isProject() { return projectHandle == this ? file : null; }
	
	@Override public String toString() { return getAbsoluteName(); }
}
