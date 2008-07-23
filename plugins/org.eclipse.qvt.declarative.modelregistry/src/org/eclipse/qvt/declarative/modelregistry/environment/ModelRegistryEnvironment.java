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

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.qvt.declarative.modelregistry.standalone.StandaloneModelRegistryEnvironment;

/**
 * The ModelRegistryEnvironment defines the singleton facilities of the Model Registry and
 * their initialisation.
 * 
 * Derived StandaloneModelRegistryEnvironment and EclipseModelRegistryEnvironment
 * define environments that are initialised programmatically or by plug-in extensions. 
 */
public abstract class ModelRegistryEnvironment
{
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.qvt.declarative.modelregistry";

	// The shared instance
	private static ModelRegistryEnvironment INSTANCE = null;
	
	public static ModelRegistryEnvironment getInstance() {
		if (INSTANCE == null)
			INSTANCE = new StandaloneModelRegistryEnvironment();
		return INSTANCE;
	}
	
	public static void logError(String string, Throwable e) {
		getInstance().logTheError(string, e);
	}

	private AccessorKindRegistry accessorKindRegistry = null;
	private ModelContentRegistry modelContentRegistry = null;
	private ModelSerializationRegistry modelSerializationRegistry = null;
	
	protected ModelRegistryEnvironment() {
		INSTANCE = this;
	}
	
	protected AccessorKindRegistry createAccessorKindRegistry() {
		return new AccessorKindRegistry();
	}
	
	protected ModelContentRegistry createModelContentRegistry() {
		return new ModelContentRegistry();
	}
	
	protected ModelSerializationRegistry createModelSerializationRegistry() {
		return new ModelSerializationRegistry();
	}
	
	public AccessorKindRegistry getAccessorKindRegistry() {
		if (accessorKindRegistry == null) {
			accessorKindRegistry = createAccessorKindRegistry();
			initializeAccessorKindRegistry(accessorKindRegistry);
		}
		return accessorKindRegistry;
	}
	
	/**
	 * Return a File to access the URI, or null if the URI cannot be
	 * resolved to a file protocol.
	 * 
	 * @return the File
	 * @throws URISyntaxException if the URI syntax is bad
	 * @throws IOException if URL resolution fails
	 */
	public File getFile(URI uri) throws URISyntaxException, IOException {
		String fileString = uri.toString();
		URL url = new URL(fileString);
		if (!"file".equals(url.getProtocol()))
			return null;
		return new File(url.toString().substring(5));
	}	
	
	public ModelContentRegistry getModelContentRegistry() {
		if (modelContentRegistry == null) {
			modelContentRegistry = createModelContentRegistry();
			initializeModelContentRegistry(modelContentRegistry);
		}
		return modelContentRegistry;
	}
	
	public ModelSerializationRegistry getModelSerializationRegistry() {
		if (modelSerializationRegistry == null) {
			modelSerializationRegistry = createModelSerializationRegistry();
			initializeModelSerializationRegistry(modelSerializationRegistry);
		}
		return modelSerializationRegistry;
	}
	
	/**
	 * Install any required content in the AccessorKindRegistry.
	 */
	protected abstract void initializeAccessorKindRegistry(AccessorKindRegistry accessorKindRegistry);
	
	/**
	 * Install any required content in the ModelContentRegistry.
	 */
	protected abstract void initializeModelContentRegistry(ModelContentRegistry modelContentRegistry);
	
	/**
	 * Install any required content in the ModelSerializationRegistry.
	 */
	protected abstract void initializeModelSerializationRegistry(ModelSerializationRegistry modelSerializationRegistry);	

	public abstract void logTheError(String string, Throwable e);
}
