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

import java.io.IOException;

import org.eclipse.emf.common.util.URI;

/**
 * The AbstractProjectHandle denotes a special location with respect to which all other file handles
 * belonging to a project are resolved. There is no fundamental need for this location
 * to exist or to be a parent of the other resources, although in normal practice the
 * project handle will denote the hierarchical root of the project.
 *
 * Derived ProjectHandle and EclipseProjectHandle specialise the behaviour using
 * a java.io.File to define the location of a project for standalone usage, or a
 * org.eclipse.core.resources.IProject for use with an active Eclipse Workspace.
 */
public interface AbstractProjectHandle extends AbstractFileHandle
{
	public static final String DEFAULT_MODEL_REGISTRY_NAME = "org.eclipse.qvt.declarative.modelregistry"; //$NON-NLS-1$
	public static final String DEFAULT_MODEL_REGISTRY_PATH = ".settings/" + DEFAULT_MODEL_REGISTRY_NAME; //$NON-NLS-1$
	/**
	 * Return the FileHandle for the model located at name relative to the project,
	 * if the name does not start with a /, or with respect to the root if it does.
	 * 
	 * @param name
	 * @return the Handle
	 * @throws IOException 
	 */
	public AbstractFileHandle getFileHandle(String name) throws IOException;
	
	/**
	 * Get the URI of the registry model.
	 * 
	 * @return the registry URI
	 */
	public URI getRegistryURI();
	
	/**
	 * Get the name of the registry model with respect to the project.
	 * The default value is DEFAULT_MODEL_REGISTRY_NAME.
	 * 
	 * @return registry name
	 */
	public String getRegistryName();
//	public String getRoot();

	/**
	 * Respond to a notification that the registry has changed.
	 */
	public void refreshRegistry();
	
	/**
	 * Define the name of the registry model with respect to the project.
	 * 
	 * @param name registry name
	 */
	public void setRegistryName(String name);
//	public void setRoot(String name);
}
