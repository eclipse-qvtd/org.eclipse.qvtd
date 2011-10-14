/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ResourceSetMappingMetaDataRegistryAdapter.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.adapters;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;

/**
 * A ResourceSetMappingMetaDataRegistryAdapter extends a ResourceSet to maintain
 * the map of root mapped EPackage to MappingMetaDataRegistry used to identify
 * the MappingMetaDataRegistry that accumulates registrations of the MappingMetaData
 * between Ecore-based and non-Ecore-based models. This facilitates the
 * realisation of the non-Ecore-based model as a set of adapters on an equivalent
 * Ecore-based model.
 */
public class ResourceSetMappingMetaDataRegistryAdapter extends AdapterImpl
{
	/**
	 * Return the adapter for resourceSet, creating it if necessary.
	 */
	public static ResourceSetMappingMetaDataRegistryAdapter getAdapter(ResourceSet resourceSet) {
		EList<Adapter> adapters = resourceSet.eAdapters();
		ResourceSetMappingMetaDataRegistryAdapter adapter = (ResourceSetMappingMetaDataRegistryAdapter) EcoreUtil.getAdapter(adapters, ResourceSetMappingMetaDataRegistryAdapter.class);
		if (adapter == null) {
			adapter = new ResourceSetMappingMetaDataRegistryAdapter();
			adapters.add(adapter);
		}
		return adapter;
	}
	
	/**
	 * Return the MappingMetaDataRegistry that resourceSet uses for mappingMetaData.
	 */
	public static IMappingMetaDataRegistry getMappingMetaDataRegistry(ResourceSet resourceSet, IMappingMetaData mappingMetaData) {
		ResourceSetMappingMetaDataRegistryAdapter adapter = getAdapter(resourceSet);
		return adapter.getMappingMetaDataRegistry(mappingMetaData);
	}
	
	private Map<EPackage, IMappingMetaDataRegistry> mappingRegistries = null;

	public IMappingMetaDataRegistry getMappingMetaDataRegistry(IMappingMetaData mappingMetaData) {
		EPackage rootEPackage = mappingMetaData.getRootEPackage();
		if (mappingRegistries == null)
			mappingRegistries = new HashMap<EPackage, IMappingMetaDataRegistry>();
		IMappingMetaDataRegistry mappingMetaDataRegistry = mappingRegistries.get(rootEPackage);
		if (mappingMetaDataRegistry == null) {
			mappingMetaDataRegistry = IMappingMetaDataRegistry.REGISTRY.createMappingMetaDataRegistry(rootEPackage, null);
			mappingRegistries.put(rootEPackage, mappingMetaDataRegistry);
		}
		mappingMetaDataRegistry.getMappingMetaDataFactory(mappingMetaData);
		return mappingMetaDataRegistry;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ResourceSetMappingMetaDataRegistryAdapter.class;
	}
}
