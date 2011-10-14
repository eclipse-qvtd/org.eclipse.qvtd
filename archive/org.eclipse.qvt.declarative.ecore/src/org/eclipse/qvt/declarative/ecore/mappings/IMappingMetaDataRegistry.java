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
 * $Id: IMappingMetaDataRegistry.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.io.PrintWriter;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResource;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResourceFactory;

/**
 * IMappingMetaDataRegistry defines the composite behaviour of a set non-Ecore package
 * to an equivalent Ecore-based package IMappingMetaData. An IMappingMetaDataRegistry
 * by adapting content type identifiers to provide appropriate Resource.Factory
 * for creation of model elements during a resource load. The relevant adapting factory
 * is provided by an IMappingMetaData.Factory that is created on demand from the
 * IMappingMetaDataRegistry.REGISTRY which maintains a map of the stateless IMappingMetaData
 * for each non-Ecore package. Prior to usage the set of IMappingMetaData.Factory is
 * initialized to compile an overall non-Ecore class to Ecore class map. This compilation
 * uses the stronger IMappingMetaDataRegistry.Install interface.
 */
public interface IMappingMetaDataRegistry
{
	public void addMappingMetaData(IMappingMetaData.Factory factory);
	
	/**
	 * Install the required contentType declarations to support access of mapped
	 * models by normal resourceSet creation procedures.
	 */
	public void configure(ResourceSet resourceSet);

	public EStructuralFeature createDemandEcoreFeature(EStructuralFeature ecoreFeature);
	public EObject getAdapter(EObject ecoreObject);
	
	/**
	 * Create an adapter for the resource defining the adapter URI, if created, as uri.
	 * If uri is null, the adapter gets a null URI, and is not not registered with the resource set.
	 * @param resource
	 * @param uri
	 * @return
	 * @throws MappingConfigurationException
	 */
	public AdaptingXMIResource getAdapter(Resource resource, URI uri);

	public <E extends EObject, A extends EObject> EList<A> getAdapters(EList<E> ecoreObjects);
	
	public MappingMetaData getMappingMetaData(EClass adaptingEClass);

	public IMappingMetaData.Factory getMappingMetaDataFactory(IMappingMetaData mappingMetaData);

	public AdaptingXMIResourceFactory getResourceFactory();

	public EClassifier getType(EPackage ePackage, String typeName);

	public void initialize();

	public void postLoad(EObject ecoreObject);
	public void postSave(EObject ecoreObject);
	public void preLoad(EObject ecoreObject);
	public void preSave(EObject ecoreObject);

	public EObject validate(PrintWriter writer);
	
	public interface Install extends IMappingMetaDataRegistry
	{
		public EStructuralFeature createDemandEcoreFeature(EStructuralFeature ecoreFeature);
		public EAttribute createDemandExtensionAttributeAsAttributeFeature(EAttribute ecoreFeature);
		public EReference createDemandExtensionAttributeAsReferenceFeature(EAttribute ecoreFeature);
		public EReference createDemandExtensionReferenceFeature(EReference ecoreFeature, boolean isElement);
		public EDataType exportEDataType(EDataType ecoreEDataType);
		public EClassMap getAdaptingEClassMap(EClass adaptingEClass);
		public EStructuralFeatureMap<? extends EStructuralFeature> getAdaptingEStructuralFeatureMap(EStructuralFeature adaptingFeature);
		public EClassMap getEcoreEClassMap(EClass ecoreEClass);
		public EStructuralFeatureMap<? extends EStructuralFeature> getEcoreEStructuralFeatureMap(EStructuralFeature ecoreFeature);
		public List<AnyType> getXMIExtensions(EObject object);
		public List<Object> getXMIExtensionValuesOrNull(EObject object, EStructuralFeature eStructuralFeature);
		public EDataType importEDataType(EDataType adaptingEDataType);
		public EClassMap install(EClassMap eClassMap);
		public void install(EStructuralFeatureMap<? extends EStructuralFeature> eStructuralFeatureMap);
		public void installAdaptingClassMapFeatures(EClass ecoreClass, EClass adaptingClass);
		public void installClassPair(MappingMetaData mappingMetaData, EClass ecoreClass, EClass adaptingClass);
		public void installClassToExtensionMap(EClassMap.Extension eClassMap);
		public void installDetailToFeatureMap(String detailKey, EAttribute adaptingFeature);
		public void installEcoreClassMapFeatures(EClass ecoreClass, EClass adaptingClass);
		public void installFeatureToExtensionAttributeMap(EAttribute ecoreFeature);
		public void installFeatureToExtensionAttributeOrElementMap(EReference ecoreFeature);
		public void installFeatureToExtensionElementMap(EAttribute ecoreFeature);
		public void installFeatureToExtensionElementMap(EReference ecoreFeature);
		public void installFeatureToFeatureMap(EAttribute ecoreFeature, EAttribute adaptingFeature);
		public void installFeatureToFeatureMap(EReference ecoreFeature, EReference adaptingFeature);
		public void installPackagePair(MappingMetaData mappingMetaData, EPackage ecorePackage, EPackage adaptingPackage);
		public void putAdaptingEClassMap(EClass adaptingEClass, EClassMap classMap);
		public void putAdaptingFeatureMap(EStructuralFeature adaptingEStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature> structuralFeatureMap);
		public void putEDataTypeMap(EDataType ecoreEDataType, EDataType adaptingEDataType);
		public void putEcoreEClassMap(EClass ecoreEClass, EClassMap classMap);
		public void putEcoreFeatureMap(EStructuralFeature ecoreEStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature> structuralFeatureMap);
		public EClassMap removeAdaptingEClassMap(EClass adaptingEClass);
		public EClassMap removeEcoreEClassMap(EClass ecoreEClass);
	}
	
	/**
	 * Registry of all known MappingMetaData
	 */
	public interface Registry
	{
		public IMappingMetaDataRegistry createMappingMetaDataRegistry(EPackage rootEPackage, AdaptingXMIResourceFactory resourceAdapterFactory);
		public IMappingMetaData getMappingMetaData(EPackage adaptingEPackage);
		public RegistryFactory getMappingMetaDataRegistryFactory();
		public void putMappingMetaData(EPackage adaptingEPackage, IMappingMetaData mappingMetaData);
		public void reset();
		public void setMappingMetaDataRegistry(RegistryFactory registryFactory);
	}
	
	public interface RegistryFactory
	{
		public IMappingMetaDataRegistry createMappingMetaDataRegistry(EPackage rootEPackage, AdaptingXMIResourceFactory resourceAdapterFactory);
	}

	public Registry REGISTRY = new MappingMetaDataRegistryRegistry();
}
