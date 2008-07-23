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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.qvt.declarative.modelregistry.model.Accessor;
import org.eclipse.qvt.declarative.modelregistry.model.ProjectRegistry;

public interface ModelResolver
{
	/**
	 * Return the project registry, creating and loading it if not already loaded.
	 * 
	 * @return the project registry
	 */
	public ProjectRegistry getProjectRegistry();
	
	public Resource getResource(URI uri, boolean loadOnDemand) throws Exception;
	
	public ResourceSet getResourceSet();
	
	/**
	 * Return the (Ecore) URI suitable for getting the (Ecore) resource defined by the
	 * accessor in the context of a file defined by its handle.
	 * @param accessor the name and type of resource to be located.
	 * @return the Ecore URI
	 */
	public URI getURI(Accessor accessor);

	/**
	 * Return the (Ecore) URI suitable for getting the (Ecore) resource defined by the
	 * modelName in the context of a file defined by its handle.
	 * 
	 * This is just a convenience form of getURI(resource, new ModelNameAccessor(modelName)).
	 * 
	 * @param modelName the name of the model to be located.
	 * @return the Ecore URI
	 */
	public abstract URI getURI(String modelName);

	/**
	 * Return the (Ecore) URI suitable for getting the (Ecore) resource defined by the
	 * (java.net.URI) uri in the context of a file defined by its handle.
	 * 
	 * This is just a convenience form of getURI(resource, new URIAccessor(uri)).
	 * 
	 * @param uri the URI name of the model to be located.
	 * @return the Ecore URI
	 */
	public abstract URI getURI(java.net.URI uri);

}