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
 * $Id: MappingMetaDataRegistryRegistry.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResourceFactory;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry.RegistryFactory;

/**
 * MappingMetaDataRegistryRegistry maintains a map of non-Ecore package to
 * IMappingMetaData that defines the Ecore adapters necessary to use an adapted Ecore
 * model as the non-Ecore model.
 */
public class MappingMetaDataRegistryRegistry implements IMappingMetaDataRegistry.Registry
{
	/**
	 * Registry of all known MappingMetaData
	 */
	private Map<EPackage, IMappingMetaData> registry = new HashMap<EPackage, IMappingMetaData>();
	private RegistryFactory factory = null;
	
	public IMappingMetaDataRegistry createMappingMetaDataRegistry(EPackage rootEPackage, AdaptingXMIResourceFactory resourceAdapterFactory) {
		return factory != null ? factory.createMappingMetaDataRegistry(rootEPackage, resourceAdapterFactory) : null; 
	}
	
	public IMappingMetaData getMappingMetaData(EPackage adaptingEPackage) {
		return registry.get(adaptingEPackage);
	}

	public RegistryFactory getMappingMetaDataRegistryFactory() {
		return factory;
	}
	
	public void putMappingMetaData(EPackage adaptingEPackage, IMappingMetaData mappingMetaData) {
		IMappingMetaData oldMappingMetaData = registry.put(adaptingEPackage, mappingMetaData);
		assert oldMappingMetaData == null : oldMappingMetaData + " displaced by " + mappingMetaData;
		mappingMetaData.getImports();		// Ensure imported packages get registered
	}
	
	public void reset() {
		registry.clear();
		factory = null;
	}
	
	public void setMappingMetaDataRegistry(RegistryFactory registryFactory) {
		factory = registryFactory;
	}
}
