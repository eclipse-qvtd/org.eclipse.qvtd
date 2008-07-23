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
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.qvt.declarative.modelregistry.ModelRegistryPackage;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelSerializationRegistry.FactorySerializationDelegate;
import org.eclipse.qvt.declarative.modelregistry.model.Accessor;
import org.eclipse.qvt.declarative.modelregistry.model.ModelNameAccessor;
import org.eclipse.qvt.declarative.modelregistry.model.ModelSerialization;
import org.eclipse.qvt.declarative.modelregistry.model.ProjectRegistry;
import org.eclipse.qvt.declarative.modelregistry.model.Registration;
import org.eclipse.qvt.declarative.modelregistry.model.URIAccessor;

public class AbstractModelResolver implements ModelResolver
{
	private final AbstractFileHandle handle;
	private ResourceSet resourceSet = null;
	private ProjectRegistry projectRegistry = null;
	
	public AbstractModelResolver(AbstractFileHandle handle) {
		this.handle = handle;
		this.resourceSet = null;
	}

	/**
	 * Create the ResourceSet when one is required but undefined.
	 * 
	 * The default implementation returns an EcoreFamilyResourceSetImpl so that the
	 * namespace of the root XML element is used to determine the appropriate loader.
	 * 
	 * @return the ResourceSet
	 */
	protected ResourceSet createResourceSet() {
		return new ResourceSetImpl();
	}

	/**
	 * Return a list of packages to be registered for potential resolution against their URIs.
	 * 
	 * When running under Eclipse, this method may return null to limit URI resolution
	 * to the standard plug-in registrations.
	 * 
	 * When running standalone, this method is invoked by the first attempt to geyt a resource set.
	 * It must define all URIs that are used.
	 * 
	 * The default implementation provides the URI of the Model Registry.
	 * 
	 * @return pacakges to be registered.
	 */
	protected EPackage[] getPackagesToRegister() {
		return new EPackage[] { ModelRegistryPackage.eINSTANCE };
	}

	public ProjectRegistry getProjectRegistry() {
		if (projectRegistry == null) {
			AbstractProjectHandle projectHandle = handle.getProjectHandle();
			projectRegistry = new ProjectRegistry(projectHandle, getResourceSet());
			projectRegistry.loadModel();
		}
		return projectRegistry;
	}

	public <A extends Accessor> Registration<A> getRegistration(A accessor) {
		return getProjectRegistry().getRegistration(handle, accessor);
	}

	public Registration<ModelNameAccessor> getRegistration(String modelName) {
		ModelNameAccessor accessor = new ModelNameAccessor(modelName);
		return getRegistration(accessor);
	}
	
	public Registration<URIAccessor> getRegistration(java.net.URI uri) {
		URIAccessor accessor = new URIAccessor(uri);
		return getRegistration(accessor);
	}

	public <A extends Accessor> Collection<Registration<A>> getRegistrations(Class<A> accessorClass) {
		return getProjectRegistry().getRegistrations(handle, accessorClass);
	}

	public Resource getResource(URI uri, boolean loadOnDemand) throws Exception {
		try {
			return resourceSet.getResource(uri, loadOnDemand);
		} catch (WrappedException e) {			// FIXME do we really want to unwrap FileNotFoundException?
			throw e.exception();
		}
	}

	public Resource getResource(Registration<ModelNameAccessor> registration) throws IOException {
		if (registration == null)
			return null;
		URI rawURI = registration.getURI();
		URI resolvedURI = getProjectRegistry().resolveURI(rawURI);
		ModelSerialization serialization = registration.getSerialization();
		ModelSerializationRegistry serializationRegistry = ModelRegistryEnvironment.getInstance().getModelSerializationRegistry();
		FactorySerializationDelegate serializationDelegate = serializationRegistry.getSerialization(serialization.getName());
		if (serializationDelegate == null)
			return null;
		Factory serializationFactory = serializationDelegate.load();
		if (serializationFactory == null)
			return null;
		Resource resource = getResourceSet().getResource(resolvedURI, false);
		if (resource == null)
			resource = serializationFactory.createResource(resolvedURI);
		if (resource == null)
			return null;
		getResourceSet().getResources().add(resource);
		resource.load(null);
		return resource;
	}
	
	public ResourceSet getResourceSet() {
		if (resourceSet == null)
			setResourceSet(initialiseResourceSet(createResourceSet()));
		return resourceSet;
	}
	
	public URI getURI(Accessor accessor) {
		return getProjectRegistry().getResolvedURI(handle, accessor);
	}

	public URI getURI(String modelName) {
		Accessor accessor = new ModelNameAccessor(modelName);
		return getURI(accessor);
	}
	
	public URI getURI(java.net.URI uri) {
		Accessor accessor = new URIAccessor(uri);
		return getURI(accessor);
	}

	/**
	 * Initialise the resourceFactoryRegistry of the resourceSet.
	 * 
	 * The default implementation installs the XMIResourceFactory for all extensions.
	 * 
	 * @param resourceFactoryRegistry to be initialised.
	 */
	protected void initialiseResourceFactoryRegistry(Registry resourceFactoryRegistry) {
		resourceFactoryRegistry.getExtensionToFactoryMap().put(Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	}
	
	/**
	 * Initialise the resourceSet. This method may be invoked directly to initialise
	 * an externally provided ResourceSet before installation via setResourceSet().
	 * It is invoked indirectly as createResourceSet() is invoked from getResourceSet().
	 * The default initialisation loads all packages returned by getPackagesToRegister()
	 * and then invokes initialiseResourceFactoryRegistry().
	 * 
	 * @param resourceSet
	 * @return
	 */
	protected ResourceSet initialiseResourceSet(ResourceSet resourceSet) {
		if (resourceSet == null)
			return null;
		EPackage[] ePackages = getPackagesToRegister();
		if (ePackages != null) {
			EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
			for (EPackage ePackage : ePackages)
				packageRegistry.put(ePackage.getNsURI(), ePackage);
		}
    	Registry resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
    	initialiseResourceFactoryRegistry(resourceFactoryRegistry);
		return resourceSet;
	}

	/**
	 * Define the 
	 * @param resourceSet
	 */
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
	@Override public String toString() {
		return handle.getProjectRelativeName();
	}
}
