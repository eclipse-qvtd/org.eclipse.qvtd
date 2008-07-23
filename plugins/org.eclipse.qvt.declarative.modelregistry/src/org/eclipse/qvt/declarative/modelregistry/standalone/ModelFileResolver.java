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

import org.eclipse.qvt.declarative.modelregistry.environment.AbstractModelResolver;

/**
 * ModelFileResolver supports use of the ModelRegistry in a standalone application using just
 * java.io.File as the handle on the physical model storage medium.
 */
public class ModelFileResolver extends AbstractModelResolver
{
	public static ProjectHandle createProjectHandle(File file) throws IOException {
		return new ProjectHandle(file, null);
	}
	
	public static ProjectHandle createProjectHandle(File file, String registryPath) throws IOException {
		return new ProjectHandle(file, registryPath);
	}
	
	public static FileHandle createFileHandle(ProjectHandle projectHandle, File file) throws IOException {
		return projectHandle.getFileHandle(file);
	}
	
	public ModelFileResolver(ProjectHandle projectHandle, File file) throws IOException {
		super(createFileHandle(projectHandle, file));
	}
	
	public ModelFileResolver(ProjectHandle projectHandle, String file) throws IOException {
		super(createFileHandle(projectHandle, new File(file)));
	}
}
