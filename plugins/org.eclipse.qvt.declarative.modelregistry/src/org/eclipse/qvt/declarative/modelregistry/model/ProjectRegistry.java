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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.qvt.declarative.modelregistry.ModelRegistration;
import org.eclipse.qvt.declarative.modelregistry.ModelRegistry;
import org.eclipse.qvt.declarative.modelregistry.ModelRegistryFactory;
import org.eclipse.qvt.declarative.modelregistry.ModelRegistryPackage;
import org.eclipse.qvt.declarative.modelregistry.ModelRegistrySettings;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractProjectHandle;
import org.eclipse.qvt.declarative.modelregistry.environment.AccessorKindRegistry;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelRegistryEnvironment;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelSerializationRegistry;

/**
 * A ProjectRegistry instance forms the root of a model registry. It provides the in-memory
 * form of the org.eclipse.qvt.declarative.modelregistry model read from and updated in the
 * project .settings folder.
 * 
 * The ProjectRegistry contains a FileHandleRegistry for each file handle for which models are
 * registered. The FileHandleRegistry in turn contains an AccessorRegistry for each Accessor class
 * and the AccessorRegistry contains the model Registrations.
 */
public class ProjectRegistry
{
	public static final String DEFAULT_SERIALISATION_NAME = "XML";

	private final AbstractProjectHandle projectHandle;
	private final Map<AbstractFileHandle, FileHandleRegistry> map = new HashMap<AbstractFileHandle, FileHandleRegistry>();
	private final ResourceSet resourceSet;
	private Resource model = null;
	private Map<String, String> unregisteredKinds = null;
	
	public ProjectRegistry(AbstractProjectHandle projectHandle, ResourceSet resourceSet) {
		this.projectHandle = projectHandle;
		this.resourceSet = resourceSet;
	}

	public FileHandleRegistry add(AbstractFileHandle fileHandle) {
		FileHandleRegistry fileHandleRegistry = new FileHandleRegistry(this, fileHandle);
		map.put(fileHandle, fileHandleRegistry);
		return fileHandleRegistry;
	}
	
	public <A extends Accessor> Registration<A> add(Registration<A> registration) {
		AbstractFileHandle fileHandle = registration.getFileHandle();
		FileHandleRegistry fileHandleRegistry = getOrCreate(fileHandle);
		return fileHandleRegistry.add(registration);
	}

	private ModelRegistrySettings exportToModel() {
		ModelRegistrySettings modelRegistrySettings = ModelRegistryFactory.eINSTANCE.createModelRegistrySettings();
		List<FileHandleRegistry> fileHandleRegistries = new ArrayList<FileHandleRegistry>(map.values());
		Collections.sort(fileHandleRegistries);
		for (FileHandleRegistry fileHandleRegistry : fileHandleRegistries) {
			AbstractFileHandle fileHandle = fileHandleRegistry.getFileHandle();
			ModelRegistry modelRegistry = ModelRegistryFactory.eINSTANCE.createModelRegistry();
			modelRegistry.setName(fileHandle.getProjectRelativeName());
			modelRegistrySettings.getResource().add(modelRegistry);
			List<AccessorRegistry<?>> accessorRegistries = new ArrayList<AccessorRegistry<?>>(fileHandleRegistry.getRegistries());
			Collections.sort(accessorRegistries);
			for (AccessorRegistry<?> accessorRegistry : accessorRegistries) {
				List<Registration<?>> registrations = new ArrayList<Registration<?>>(accessorRegistry.getRegistrations());
				Collections.sort(registrations);
				for (Registration<?> registration : registrations) {
					Accessor accessor = registration.getAccessor();
					ModelRegistration modelRegistration = ModelRegistryFactory.eINSTANCE.createModelRegistration();
					modelRegistration.setAccessor(accessor.getName());
					modelRegistration.setKind(accessor.getKind());
					if (!DEFAULT_SERIALISATION_NAME.equals(registration.getSerializationName()))
						modelRegistration.setSerialization(registration.getSerializationName());
					modelRegistration.setUri(registration.getURIString());
					modelRegistry.getEntry().add(modelRegistration);
				} 
			}
		}
		return modelRegistrySettings;
	}

	public FileHandleRegistry get(AbstractFileHandle fileHandle) {
		return map.get(fileHandle);
	}

	public FileHandleRegistry getOrCreate(AbstractFileHandle fileHandle) {
		FileHandleRegistry fileHandleRegistry = map.get(fileHandle);
		if (fileHandleRegistry == null) {
			fileHandleRegistry = new FileHandleRegistry(this, fileHandle);
			map.put(fileHandle, fileHandleRegistry);
		}
		return fileHandleRegistry;
	}
	
	public AbstractProjectHandle getProject() { return projectHandle; }
	
	/**
	 * Return the registration applicable to accessor in the context of fileHandle
	 * @param <A> kind of accessor
	 * @param fileHandle defining look-up context
	 * @param accessor name of accessor
	 * @return the registration
	 */
	public <A extends Accessor> Registration<A> getRegistration(AbstractFileHandle fileHandle, A accessor) {
		for (AbstractFileHandle ancestorHandle = fileHandle; ancestorHandle != null; ancestorHandle = ancestorHandle.getParentFileHandle()) {
			FileHandleRegistry fileHandleRegistry = get(ancestorHandle);
			if (fileHandleRegistry != null) {
				Registration<A> registration = fileHandleRegistry.getRegistration(accessor);
				if (registration != null)
					return registration;
			}
		}
		return null;
	}
	
	/**
	 * Return all registrations applicable to accessorClass in the context of fileHandle, typically
	 * to treat all such registrations as a look-up path.
	 * @param Class<A> kind of accessor
	 * @param fileHandle defining look-up context
	 * @param accessor name of accessor
	 * @return the registrations
	 */
	public <A extends Accessor> Collection<Registration<A>> getRegistrations(AbstractFileHandle fileHandle, Class<A> accessorClass) {
		AccessorRegistry<A> flatAccessorRegistry = new AccessorRegistry<A>(get(fileHandle), accessorClass);
		for (AbstractFileHandle ancestorHandle = fileHandle; ancestorHandle != null; ancestorHandle = ancestorHandle.getParentFileHandle()) {
			FileHandleRegistry fileHandleRegistry = get(ancestorHandle);
			if (fileHandleRegistry != null) {
				AccessorRegistry<A> accessorRegistry = fileHandleRegistry.get(accessorClass);
				if (accessorRegistry != null) {
					for (Registration<A> registration : accessorRegistry.getRegistrations()) {
						if (flatAccessorRegistry.get(registration.getAccessor()) == null)
							flatAccessorRegistry.add(registration);
					}
				}
			}
		}
		return flatAccessorRegistry.getRegistrations();
	}
	
	/**
	 * Return the URI that resolves accessor within the context of fileHandle
	 * after resolution against the URI of the project.
	 * 
	 * @param fileHandle defining look-up context
	 * @param accessor name and kind of accessor
	 * @return the resolved URI
	 */
	public URI getResolvedURI(AbstractFileHandle fileHandle, Accessor accessor) {
		return resolveURI(getURI(fileHandle, accessor));
	}
		
	public ResourceSet getResourceSet() { return resourceSet; }

	/**
	 * Return the URI that resolves accessor within the context of fileHandle.
	 * @param fileHandle defining look-up context
	 * @param accessor name and kind of accessor
	 * @return the URI
	 */
	public URI getURI(AbstractFileHandle fileHandle, Accessor accessor) {
		Registration<?> registration = getRegistration(fileHandle, accessor);
		return registration != null ? registration.getURI() : null;
	}
	
	private void importFromModel(Resource model, URI registryURI) {
		map.clear();
		AccessorKindRegistry accessorKindRegistry = ModelRegistryEnvironment.getInstance().getAccessorKindRegistry();
		ModelSerializationRegistry modelSerializationRegistry = ModelRegistryEnvironment.getInstance().getModelSerializationRegistry();
		for (EObject content : model.getContents()) {
			ModelRegistrySettings settings = (ModelRegistrySettings) content;
			for (ModelRegistry modelRegistry : settings.getResource()) {
				String name = modelRegistry.getName();
				AbstractFileHandle fileHandle = null;
				try {
					fileHandle = projectHandle.getFileHandle(name);
				} catch (IOException e) {
					ModelRegistryEnvironment.logError("Illegal model registry file handle name", e);
				}
				if (fileHandle != null) {
					FileHandleRegistry fileHandleRegistry = add(fileHandle);
					for (ModelRegistration modelRegistration : modelRegistry.getEntry()) {
						String kind = modelRegistration.getKind();
						Accessor accessor = accessorKindRegistry.createAccessor(kind, modelRegistration.getAccessor());
						if (accessor == null) {
							if (unregisteredKinds == null)
								unregisteredKinds = new HashMap<String,String>();
							if (!unregisteredKinds.containsKey(kind)) {
								unregisteredKinds.put(kind, kind);
								ModelRegistryEnvironment.logError("Unregistered accessor kind '" + kind + "' used in '" + registryURI + "'", null);
							}
							accessor = new UnregisteredAccessor(kind, modelRegistration.getAccessor());
						}
						URI ecoreURI = URI.createURI(modelRegistration.getUri());
						String serializationName = modelRegistration.getSerialization();
						if (serializationName == null)
							serializationName = DEFAULT_SERIALISATION_NAME;
						ModelSerialization modelSerialisation = modelSerializationRegistry.getSerializationOrCreate(serializationName);
						fileHandleRegistry.add(accessor, ecoreURI, modelSerialisation);
					}
				}
			}
		}
	}
	
	public boolean loadModel() {
		URI registryURI = projectHandle.getRegistryURI();
		try {
			try {
				if (model == null) {									// FIXME Persist ResourceSet between lookups
					ResourceSet resourceSet = new ResourceSetImpl();	// Private resource set to avoid clutter
					resourceSet.getPackageRegistry().put(ModelRegistryPackage.eINSTANCE.getNsURI(), ModelRegistryPackage.eINSTANCE);
					resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
					model = resourceSet.getResource(registryURI, true);
				}
				importFromModel(model, registryURI);
				return true;
			} catch (WrappedException e) {
				throw e.exception();
			}
		} catch (FileNotFoundException e) {
			return true;			// Need to create model registry from scratch
		} catch (Exception e) {
			ModelRegistryEnvironment.logError("Failed to get model registry from '" + registryURI + "'", e);
		}
		return false;
	}

	public <A extends Accessor> Registration<A> remove(Registration<A> registration) {
		AbstractFileHandle fileHandle = registration.getFileHandle();
		FileHandleRegistry fileHandleRegistry = map.get(fileHandle);
		return fileHandleRegistry.remove(registration);
	}
	
	/**
	 * Return the URI after resolution against the project file handle URI.
	 * @param uri uri to resolve
	 * @return the resolved URI
	 */
	public URI resolveURI(URI uri) {
		if (uri == null)
			return uri;
		return uri.resolve(projectHandle.getURI());
	}
	
	public boolean saveModel() {
		URI registryURI = projectHandle.getRegistryURI();
		ModelRegistrySettings settings = exportToModel();
		model = resourceSet.createResource(registryURI);
		model.getContents().add(settings);
		try {
			model.save(null);			// FIXME rename original as a backup till successful
			projectHandle.refreshRegistry();
		} catch (IOException e) {
			ModelRegistryEnvironment.logError("Failed to create model registry at '" + registryURI + "'", e);
			return false;
		}
		return true;
	}
		
	@Override public String toString() {
		return getProject().toString();
	}
}
