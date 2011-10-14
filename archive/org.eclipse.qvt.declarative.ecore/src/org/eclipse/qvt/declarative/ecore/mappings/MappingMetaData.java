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
 * $Id: MappingMetaData.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.qvt.declarative.ecore.Activator;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEFactory;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResourceFactory;

/**
 * MappingMetaData defines the mapping rules between an Ecore-based model and some similar 
 * adapting model such as an EMOF-based model.
 * 
 * See EMOFMappingMetaData for a complex mapping, EssentialOCLMetaData for a much simpler
 * almost regular mapping and QVTTemplateMappingMetaData for a trivial mapping.
 */
public abstract class MappingMetaData implements IMappingMetaData.Install
{
	public static class ImportComparator implements Comparator<IMappingMetaData>
	{
		public static final ImportComparator INSTANCE = new ImportComparator();

		public int compare(IMappingMetaData o1, IMappingMetaData o2) {
			List<IMappingMetaData> s1 = o1.getImports();
			List<IMappingMetaData> s2 = o2.getImports();
			if (s2.containsAll(s1))
				return -1;
			if (s1.containsAll(s2))
				return 1;
			return 0;
		}
	}

	public abstract static class Factory extends AdaptingEFactory implements IMappingMetaData.Factory
	{
		protected final IMappingMetaDataRegistry.Install mappingMetaDataRegistry;
		protected final IMappingMetaData mappingMetaData;

		protected Factory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, IMappingMetaData mappingMetaData) {
			super(mappingMetaData.getAdaptingEPackage());
			this.mappingMetaDataRegistry = mappingMetaDataRegistry;
			this.mappingMetaData = mappingMetaData;
			mappingMetaDataRegistry.addMappingMetaData(this);
//			DebugCounters.increment("MappingMetaData.Factory()");
		}

		public EObject create(EClass adaptingClass) {
			throw new IllegalArgumentException("Creation of class '" + adaptingClass.getName() + "' objects is not supported");
		}

		protected EObject getAdapter(EObject ecoreObject) {
			return mappingMetaDataRegistry.getAdapter(ecoreObject);
		}

		public EStructuralFeatureMap<? extends EStructuralFeature> getFeatureMap(EClass ecoreEClass, EStructuralFeature ecoreFeature) {
			return mappingMetaDataRegistry.getEcoreEStructuralFeatureMap(ecoreFeature);
		}

		public IMappingMetaData getMappingMetaData() {
			return mappingMetaData;
		}

		public IMappingMetaDataRegistry getMappingMetaDataRegistry() {
			return mappingMetaDataRegistry;
		}
		
		@Override
		public String toString() {
			return "Factory(" + mappingMetaData + ")";
		}
	}
	
	public static class RegistryFactory implements IMappingMetaDataRegistry.RegistryFactory
	{
		public IMappingMetaDataRegistry createMappingMetaDataRegistry(EPackage rootEPackage, AdaptingXMIResourceFactory resourceAdapterFactory) {			
			return new MappingMetaDataRegistry(rootEPackage, resourceAdapterFactory);
		}	
	}

	protected final EPackage adaptingEPackage;
	protected final EPackage ecoreEPackage;
	protected final String[] uriAliases;
	protected List<IMappingMetaData> imports = null;		// imports[i] not imported by any imports[j] where j < i, including this
	protected List<IMappingMetaData> merges = null;
		
	protected MappingMetaData(EPackage adaptingEPackage, EPackage ecoreEPackage, String[] uriAliases) {
		this.adaptingEPackage = adaptingEPackage;
		this.ecoreEPackage = ecoreEPackage;
		this.uriAliases = uriAliases;
		if (IMappingMetaDataRegistry.REGISTRY.getMappingMetaDataRegistryFactory() == null)
			IMappingMetaDataRegistry.REGISTRY.setMappingMetaDataRegistry(new RegistryFactory());
		IMappingMetaDataRegistry.REGISTRY.putMappingMetaData(adaptingEPackage, this);
		if (uriAliases != null)
			for (String uriAlias : uriAliases)
				EPackage.Registry.INSTANCE.put(uriAlias, adaptingEPackage);
//		DebugCounters.increment("MappingMetaData()");
	}
	
	protected List<IMappingMetaData> computeImports(Stack<IMappingMetaData> forMappingMetadatas) {
		return new ArrayList<IMappingMetaData>();
	}

	protected List<IMappingMetaData> computeImports(Stack<IMappingMetaData> forMappingMetaDatas, List<IMappingMetaData> imports, IMappingMetaData.Install... importedMetaDatas) {
		List<IMappingMetaData.Install> newImports = null;
		for (IMappingMetaData.Install importedMetaData : importedMetaDatas) {
			if (!imports.contains(importedMetaData)) {
				if (newImports == null)
					newImports = new ArrayList<IMappingMetaData.Install>();
				newImports.add(importedMetaData);
			}
		}
		if (newImports != null) {		
			Set<IMappingMetaData> allImports = new HashSet<IMappingMetaData>();
			for (IMappingMetaData.Install newImport : newImports)
				allImports.addAll(newImport.getImports(forMappingMetaDatas));
			List<IMappingMetaData> sortedImports = new ArrayList<IMappingMetaData>(allImports);
			Collections.sort(sortedImports, ImportComparator.INSTANCE);
			return sortedImports;
		}
		else
			return imports;
	}
	
	protected List<IMappingMetaData> computeMerges() {
		return new ArrayList<IMappingMetaData>();
	}

	public void configure(ResourceSet resourceSet, IMappingMetaDataRegistry mappingMetaDataRegistry) {
		Map<String, Object> contentTypeToFactoryMap = resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap();
		EList<ContentHandler> contentHandlers = resourceSet.getURIConverter().getContentHandlers();
		String adaptingContentTypeIdentifier = getAdaptingContentTypeIdentifier();
		String ecoreContentTypeIdentifier = getEcoreContentTypeIdentifier();
		if (ecoreContentTypeIdentifier != null) {
			Resource.Factory ecoreResourceFactory = getEcoreResourceFactory();
			contentTypeToFactoryMap.put(ecoreContentTypeIdentifier, ecoreResourceFactory);
			contentHandlers.add(new RootXMLContentHandlerImpl(ecoreContentTypeIdentifier, null, RootXMLContentHandlerImpl.XMI_KIND, ecoreEPackage.getNsURI(), null));
		}
		if (adaptingContentTypeIdentifier != null) {
			Resource.Factory adaptingResourceFactory = getAdaptingResourceFactory(mappingMetaDataRegistry);
			contentTypeToFactoryMap.put(adaptingContentTypeIdentifier, adaptingResourceFactory);
			contentHandlers.add(new RootXMLContentHandlerImpl(adaptingContentTypeIdentifier, null,
					RootXMLContentHandlerImpl.XMI_KIND, adaptingEPackage.getNsURI(), null));
			if (uriAliases != null)
				for (String uriAlias : uriAliases)
					contentHandlers.add(new RootXMLContentHandlerImpl(adaptingContentTypeIdentifier, null, RootXMLContentHandlerImpl.XMI_KIND, uriAlias, null));
		}
	}

	public abstract String getAdaptingContentTypeIdentifier();
	
	public EPackage getAdaptingEPackage() {
		return adaptingEPackage;
	}

	public EStructuralFeatureMap<? extends EStructuralFeature> getAdaptingFeatureMap(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EClass adaptingEClass, EStructuralFeature adaptingFeature) {
		return mappingMetaDataRegistry.getAdaptingEStructuralFeatureMap(adaptingFeature);
	}
	
	public abstract Resource.Factory getAdaptingResourceFactory(IMappingMetaDataRegistry mappingMetaDataRegistry);

	public abstract String getEcoreContentTypeIdentifier();
	
	public EPackage getEcoreEPackage() {
		return ecoreEPackage;
	}
	
	public Resource.Factory getEcoreResourceFactory() { // FIX WIP change to abstract
		return new XMIResourceFactoryImpl();
	}

	public EStructuralFeatureMap<? extends EStructuralFeature> getEcoreFeatureMap(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EClass ecoreEClass, EStructuralFeature ecoreFeature) {
		return mappingMetaDataRegistry.getEcoreEStructuralFeatureMap(ecoreFeature);
	}
	
	/**
	 * Return the mappingMetaDataRegistry-specific factory for this mapping meta-data.
	 */
	public IMappingMetaData.Factory getFactory(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		return mappingMetaDataRegistry.getMappingMetaDataFactory(this);
	}
	
	public List<IMappingMetaData> getImports() {
		if (imports != null)
			return imports;
		else
			return getImports(new Stack<IMappingMetaData>());
	}
	
	public List<IMappingMetaData> getImports(Stack<IMappingMetaData> forMappingMetaDatas) {
		if (imports == null) {
			if (forMappingMetaDatas.contains(this))
				Activator.logError("Cyclic mapping import for " + this, null);
			else {
				forMappingMetaDatas.push(this);
				List<IMappingMetaData> computedImports = computeImports(forMappingMetaDatas);
				computedImports.add(this);
				imports = Collections.unmodifiableList(computedImports);
				forMappingMetaDatas.pop();
			}
		}
		return imports;
	}
	
	public List<IMappingMetaData> getMerges() {
		if (merges == null)
			merges = Collections.unmodifiableList(computeMerges());
		return merges;
	}
	
	@Override
	public String toString() {
		return "Mapping(" + adaptingEPackage.getName() + ")";
	}
}
