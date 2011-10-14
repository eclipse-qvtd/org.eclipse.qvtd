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
 * $Id: MappingMetaDataRegistry.java,v 1.3 2009/02/17 21:31:35 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEList;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEPackage;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingInternalEList;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResource;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResourceFactory;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaData.ImportComparator;

/**
 * MappingMetaDataRegistry maintains the set of package to MappingMetaData maps for use
 * in an Ecore to Adapting or Adapting to Ecore mapping.
 */
public class MappingMetaDataRegistry extends BasicExtendedMetaData implements IMappingMetaDataRegistry.Install
{
	/**
	 * Interface for test object that may be installed to oversee a consistency validation
	 * between an Ecore model and an Adapting model.
	 */
	public interface ConsistencyValidator
	{
		public void inconsistent(ENamedElement ecoreObject, ENamedElement adaptingObject, EStructuralFeature inconsistentFeature, Object ecoreValue, Object adaptingValue);
	}
	
	public static ConsistencyValidator consistencyValidator = null;

	protected final EPackage rootAdaptingEPackage;
	protected final AdaptingXMIResourceFactory resourceAdapterFactory;
	private Map<IMappingMetaData, IMappingMetaData.Factory> mappingMetaDatas = new HashMap<IMappingMetaData, IMappingMetaData.Factory>();
	private List<IMappingMetaData> uninitializedMappingMetaDatas = new ArrayList<IMappingMetaData>();
	protected final Set<EPackage> ecorePackages = new HashSet<EPackage>();
	protected final Map<String, EPackage> adaptingPackages = new HashMap<String, EPackage>();
	protected final Map<EClass, EClassMap> adaptingEClassMaps = new HashMap<EClass, EClassMap>();	// Adapting EClass to EClassMap
	protected final Map<String, EDataType> adaptingEDataTypeMaps = new HashMap<String, EDataType>();	// Adapting EDataType URI to Ecore EDataType
	protected final Map<EClass, EClassMap> ecoreEClassMaps = new HashMap<EClass, EClassMap>();	// Ecore EClass to EClassMap
	protected final Map<String, EDataType> ecoreEDataTypeMaps = new HashMap<String, EDataType>();	// Ecore EDataType URI to Adapting EDataType
	protected final EStructuralFeature xmiExtensionFeature;
	protected final EStructuralFeature extenderFeature;

	protected final Map<EStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature>> ecoreEStructuralFeatureMaps
		= new HashMap<EStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature>>();
	protected final Map<EStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature>> adaptingEStructuralFeatureMaps
		= new HashMap<EStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature>>();
	
	public MappingMetaDataRegistry(EPackage rootAdaptingEPackage, AdaptingXMIResourceFactory resourceAdapterFactory) {
		assert rootAdaptingEPackage != EcorePackage.eINSTANCE;
		this.rootAdaptingEPackage = rootAdaptingEPackage;
		this.resourceAdapterFactory = resourceAdapterFactory != null ? resourceAdapterFactory : new AdaptingXMIResourceFactory(this);
		this.xmiExtensionFeature = demandFeature(ExtendedMetaData.XMI_URI, "Extension", true);
		this.extenderFeature = demandFeature(null, "extender", false);		
//		DebugCounters.increment("MappingMetaDataRegistry()");
	}

	public void addMappingMetaData(IMappingMetaData.Factory mappingMetaDataFactory) {
		IMappingMetaData mappingMetaData = mappingMetaDataFactory.getMappingMetaData();
		if (mappingMetaDatas.containsKey(mappingMetaData))
			return;
//		DebugCounters.increment("MappingMetaDataRegistry.mappingMetaDatas.put()");
		mappingMetaDatas.put(mappingMetaData, mappingMetaDataFactory);
		if (uninitializedMappingMetaDatas.contains(mappingMetaData))
			return;
		boolean wasInitialized = !mappingMetaDatas.isEmpty() && uninitializedMappingMetaDatas.isEmpty();
		uninitializedMappingMetaDatas.add(mappingMetaData);
		for (IMappingMetaData importedMappingMetaData : mappingMetaData.getImports()) {
			if (!mappingMetaDatas.containsKey(importedMappingMetaData))
				uninitializedMappingMetaDatas.add(importedMappingMetaData);
		}
		if (wasInitialized)
			initialize();
	}
	
	public void configure(ResourceSet resourceSet) {
		for (IMappingMetaData mappingMetaData : mappingMetaDatas.keySet())
			mappingMetaData.configure(resourceSet, this);		// FIXME WIP use predictable (import) order
	}
	
	public AdaptingEObject createAdapter(EObject ecoreObject) {
		EClass ecoreEClass = ecoreObject.eClass();
		EClassMap eClassMap = getEcoreEClassMap(ecoreEClass);
		if (eClassMap == null)
			throw new MappingConfigurationException("No adapting class adapter configured", ecoreEClass, null);
		return eClassMap.createAdapter(this, ecoreObject);
	}
	
	protected AdaptingXMIResource createAdapter(Resource resource, URI uri) {
		AdaptingXMIResource adapter = new AdaptingXMIResource(resource, uri, this);
		if ((uri != null) && !uri.equals(resource.getURI())) {
			ResourceSet resourceSet = resource.getResourceSet();
			if (resourceSet != null)
				resourceSet.getResources().add(adapter);
		}
		return adapter;
	}
	
	public EStructuralFeature createDemandEcoreFeature(EStructuralFeature ecoreFeature) {
		boolean isReference = ecoreFeature instanceof EReference;
		boolean isElement = isReference ? ((EReference) ecoreFeature).isContainment() : false;		
		return demandFeature(null, ecoreFeature.getName(), isElement, isReference);
	}
	
	public EAttribute createDemandExtensionAttributeAsAttributeFeature(EAttribute ecoreFeature) {
		return (EAttribute) demandFeature(null, ecoreFeature.getName(), false, false);
	}
	
	public EReference createDemandExtensionAttributeAsReferenceFeature(EAttribute ecoreFeature) {
		return (EReference) demandFeature(null, ecoreFeature.getName(), true, true);
	}
	
	public EReference createDemandExtensionReferenceFeature(EReference ecoreFeature, boolean isElement) {
		return (EReference) demandFeature(null, ecoreFeature.getName(), isElement, true);
	}

	@Override public EPackage demandPackage(String namespace) {
		EPackage ePackage = adaptingPackages.get(namespace);
		if (ePackage == null)
			ePackage = super.demandPackage(namespace);
		return ePackage;
	}

	protected <K,T> void diagnosedPut(Map<K, T> map, K key, T newValue) {
		T oldValue = map.put(key, newValue);
		if (oldValue != newValue)		// FIXME avoid the duplication
			assert oldValue == null : oldValue + " displaced by " + newValue;
	}

	/**
	 * Convert an EDataType used in an adapting model to that used in an Ecore model.
	 * @param ecoreValue
	 * @return
	 */
	public EDataType exportEDataType(EDataType ecoreEDataType) {
		URI uri = EcoreUtil.getURI(ecoreEDataType);
		EDataType adaptingEDataType = ecoreEDataTypeMaps.get(uri.toString());
		return adaptingEDataType != null ? adaptingEDataType : ecoreEDataType;
	}
	
	public EObject getAdapter(EObject ecoreObject) {
		if (ecoreObject == null)
			return null;
		initialize();
		List<Adapter> eAdapters = ecoreObject.eAdapters();
		for (Adapter eAdapter : eAdapters) {
			if ((eAdapter instanceof AdaptingEObject) && (((AdaptingEObject) eAdapter).getMappingMetaDataRegistry() == this))
				return MappingUtils.asClassUnchecked(eAdapter, (EObject)null);
		}
		AdaptingEObject eAdapter = createAdapter(ecoreObject);
		if (eAdapter != null)
			eAdapters.add(eAdapter);
		return eAdapter;
	}
	
	public AdaptingXMIResource getAdapter(Resource resource, URI uri) {
		if (resource == null)
			return null;
		initialize();
		List<Adapter> eAdapters = resource.eAdapters();
		for (Adapter eAdapter : eAdapters) {
			if ((eAdapter instanceof AdaptingXMIResource) && (((AdaptingXMIResource) eAdapter).getMappingMetaDataRegistry() == this))
				return (AdaptingXMIResource) eAdapter;
		}
		AdaptingXMIResource eAdapter = createAdapter(resource, uri);
		eAdapters.add(eAdapter);
		return eAdapter;
	}

	public <E extends EObject, A extends EObject> EList<A> getAdapters(EList<E> ecoreObjects) {
		if (ecoreObjects instanceof InternalEList<?>)
			return new AdaptingInternalEList<E, A>(this, (InternalEList<E>)ecoreObjects);
		else
			return new AdaptingEList<E, A, EList<E>>(this, ecoreObjects);
	}

	public EClassMap getAdaptingEClassMap(EClass adaptingEClass) {
		return adaptingEClassMaps.get(adaptingEClass);
	}

	public EStructuralFeatureMap<? extends EStructuralFeature> getAdaptingEStructuralFeatureMap(EStructuralFeature adaptingFeature) {
		return adaptingEStructuralFeatureMaps.get(adaptingFeature);
	}

	public EClassMap getEcoreEClassMap(EClass ecoreEClass) {
		return ecoreEClassMaps.get(ecoreEClass);
	}

	public EStructuralFeatureMap<? extends EStructuralFeature> getEcoreEStructuralFeatureMap(EStructuralFeature ecoreFeature) {
		return ecoreEStructuralFeatureMaps.get(ecoreFeature);
	}

	public MappingMetaData getMappingMetaData(EClass adaptingEClass) {
		EClassMap classMap = getAdaptingEClassMap(adaptingEClass);
		return classMap != null ? classMap.getMappingMetaData() : null;
	}

	public IMappingMetaData.Factory getMappingMetaDataFactory(IMappingMetaData mappingMetaData) {
		IMappingMetaData.Factory mappingMetaDataFactory = mappingMetaDatas.get(mappingMetaData);
		if (mappingMetaDataFactory == null)
			mappingMetaDataFactory = mappingMetaData.createFactory(this);
		return mappingMetaDataFactory;
	}

	public String getName() {
		return getRootAdaptingEPackage().getName();
	}

	@Override public EPackage getPackage(String namespace) {
		EPackage ePackage = super.getPackage(namespace);
		if (ePackage == null)
			return null;
		IMappingMetaData mappingMetaData = REGISTRY.getMappingMetaData(ePackage);
		if (mappingMetaData == null)
			return ePackage;
		IMappingMetaData.Factory factory = mappingMetaData.getFactory(this);
		factory.getMappingMetaDataRegistry().initialize();
		return new AdaptingEPackage(factory, ePackage);
	}

	public AdaptingXMIResourceFactory getResourceFactory() {
		return resourceAdapterFactory;
	}

	public EPackage getRootAdaptingEPackage() {
		return rootAdaptingEPackage;
	}
	
	/**
	 * Return a non-null list of AnyType objects that serve as Ecore extensions of object.
	 * (If object is an AnyType, then it is returned as its own extension).
	 * 
	 * @param object
	 * @return
	 */
	public List<AnyType> getXMIExtensions(EObject object) {
		boolean createIfAbsent = true;
		List<AnyType> ecoreExtensions = getXMIExtensionsOrNull(object);
		if (createIfAbsent && (ecoreExtensions == null)) {
			XMLResource resource = (XMLResource) object.eResource();
			Map<EObject, AnyType> eObjectToExtensionMap = resource.getEObjectToExtensionMap();
			AnyType xmiExtensions = eObjectToExtensionMap.get(object);
			if (xmiExtensions == null) {
				xmiExtensions = XMLTypeFactory.eINSTANCE.createAnyType();
				eObjectToExtensionMap.put(object, xmiExtensions);
			}
			AnyType xmiExtension = XMLTypeFactory.eINSTANCE.createAnyType();
			xmiExtension.getAnyAttribute().add(extenderFeature, EcorePackage.eNS_URI);
			ecoreExtensions = new ArrayList<AnyType>();
			ecoreExtensions.add(xmiExtension);
			xmiExtensions.getMixed().add(xmiExtensionFeature, xmiExtension);
		}
		return ecoreExtensions;
	}
	
	/**
	 * Return a possibly null list of AnyType objects that serve as Ecore extensions of object.
	 * (If object is an AnyType, then it is returned as its own extension).
	 * 
	 * @param object
	 * @return
	 */
	public List<AnyType> getXMIExtensionsOrNull(EObject object) {
		assert !(object instanceof AnyType);			// Caller should optimise
		XMLResource resource = (XMLResource) object.eResource();
		Map<EObject, AnyType> eObjectToExtensionMap = resource != null ? resource.getEObjectToExtensionMap() : null;
		AnyType xmiExtensions = eObjectToExtensionMap != null ? eObjectToExtensionMap.get(object) : null;
		if (xmiExtensions == null)
			return null;
		List<AnyType> ecoreXMIExtensions = null;
		for (FeatureMap.Entry xmiExtensionEntry : xmiExtensions.getMixed()) {
			if (xmiExtensionEntry.getEStructuralFeature() == xmiExtensionFeature) {
				Object xmiExtensionObject = xmiExtensionEntry.getValue();
				if (xmiExtensionObject instanceof AnyType) {
					AnyType xmiExtension = (AnyType) xmiExtensionObject;
					Object extender = xmiExtension.getAnyAttribute().get(extenderFeature, false);
					if (EcorePackage.eINSTANCE.getNsURI().equals(extender)) {
						if (ecoreXMIExtensions == null)
							ecoreXMIExtensions = new ArrayList<AnyType>();
						ecoreXMIExtensions.add(xmiExtension);
					}
				}
			}
		}
		return ecoreXMIExtensions;
	}

	public List<Object> getXMIExtensionValuesOrNull(EObject object, EStructuralFeature eStructuralFeature) {
		String featureName = eStructuralFeature.getName();
		List<AnyType> ecoreExtensions = null;
		int iMax;
		AnyType ecoreExtension;
		if (!(object instanceof AnyType)) {
			ecoreExtensions = getXMIExtensionsOrNull(object);
			if (ecoreExtensions == null)
				return null;
			iMax = ecoreExtensions.size();
			if (iMax <= 0)
				return null;
			ecoreExtension = ecoreExtensions.get(0);
		}
		else {
			iMax = 1;
			ecoreExtension = (AnyType) object;
		}
		List<Object> result = null;
		for (int i = 0; true; ) {
			// mixed/anyAttribute seems to just depend on accidental text
			for (FeatureMap.Entry xmiExtensionChildEntry : ecoreExtension.getMixed()) {
				if (xmiExtensionChildEntry.getEStructuralFeature().getName().equals(featureName)) {
					if (result == null)
						result = new ArrayList<Object>();
					result.add(xmiExtensionChildEntry.getValue());
				}
			}
			for (FeatureMap.Entry xmiExtensionChildEntry : ecoreExtension.getAnyAttribute()) {
				if (xmiExtensionChildEntry.getEStructuralFeature().getName().equals(featureName)) {
					if (result == null)
						result = new ArrayList<Object>();
					result.add(xmiExtensionChildEntry.getValue());
				}
			}
			if (ecoreExtensions == null)
				break;
			if (++i >= iMax)
				break;
			ecoreExtension = ecoreExtensions.get(i);
		}
		return result;
	}

	/**
	 * Convert an EDataType used in an adapting model to that used in an Ecore model.
	 * @param ecoreValue
	 * @return
	 */
	public EDataType importEDataType(EDataType adaptingEDataType) {
		URI uri = EcoreUtil.getURI(adaptingEDataType);
		EDataType ecoreEDataType = adaptingEDataTypeMaps.get(uri.toString());
		return ecoreEDataType != null ? ecoreEDataType : adaptingEDataType;
	}
	
	public void initialize() {
		if (!uninitializedMappingMetaDatas.isEmpty()) {
//			DebugCounters.increment("MappingMetaDataRegistry.initialize()");
			Collections.sort(uninitializedMappingMetaDatas, ImportComparator.INSTANCE);
			for (IMappingMetaData mappingMetaData : uninitializedMappingMetaDatas) {
				mappingMetaData.getFactory(this);
				mappingMetaData.initialize(this);
			}
			uninitializedMappingMetaDatas.clear();
			for (EClassMap eClassMap : ecoreEClassMaps.values())
				eClassMap.compile(this);
		}
	}

	public EClassMap install(EClassMap eClassMap) {
		EClass ecoreEClass = eClassMap.getEcoreEClass();
		if (ecoreEClass != null)
			putEcoreEClassMap(ecoreEClass, eClassMap);
		EClass adaptingEClass = eClassMap.getAdaptingEClass();
		if (adaptingEClass != null)
			putAdaptingEClassMap(adaptingEClass, eClassMap);
		return eClassMap;
	}

	public void install(EStructuralFeatureMap<? extends EStructuralFeature> eStructuralFeatureMap) {
		eStructuralFeatureMap.install();	
	}
	
	public void installAdaptingClassMapFeatures(EClass ecoreClass, EClass adaptingClass) {
		for (EStructuralFeature adaptingFeature :  adaptingClass.getEAllStructuralFeatures()) {
			if (adaptingFeature.isDerived() || adaptingFeature.isTransient() || adaptingFeature.isVolatile())
				continue;
			if ((adaptingFeature instanceof EReference) && ((EReference) adaptingFeature).isContainer())
				continue;
			EStructuralFeatureMap<? extends EStructuralFeature> adaptingFeatureMap = getAdaptingEStructuralFeatureMap(adaptingFeature);
			if (adaptingFeatureMap != null)
				continue;
			EStructuralFeature ecoreFeature = ecoreClass.getEStructuralFeature(adaptingFeature.getName());
			if (ecoreFeature == null) {
				if (consistencyValidator != null)
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, null, ecoreClass, adaptingClass);
			}
			else if (ecoreFeature instanceof EAttribute)
				installFeatureToFeatureMap((EAttribute) ecoreFeature, (EAttribute) adaptingFeature);				
			else
				installFeatureToFeatureMap((EReference) ecoreFeature, (EReference) adaptingFeature);				
		}
	}
	
	/**
	 * Install the regular same-named mappings between adaptingClass and ecoreClass.
	 * @throws MappingConfigurationException 
	 */
	public void installClassPair(MappingMetaData mappingMetaData, EClass ecoreClass, EClass adaptingClass) {
		install(new EClassMap.Direct(mappingMetaData, ecoreClass, adaptingClass));				
		installAdaptingClassMapFeatures(ecoreClass, adaptingClass);
		installEcoreClassMapFeatures(ecoreClass, adaptingClass);
	}

	public void installClassToExtensionMap(EClassMap.Extension eClassMap) {
		EClass ecoreEClass = eClassMap.getEcoreEClass();
		if (ecoreEClass != null)
			putEcoreEClassMap(ecoreEClass, eClassMap);
	}

	public void installDetailToFeatureMap(String detailsKey, EAttribute adaptingFeature) {
		EcoreDetailElement ecoreDetailElement = EcoreDetailElement.create(detailsKey);
		EcoreFeatureElement<EAttribute> adaptingFeatureElement = EcoreFeatureElement.create(adaptingFeature);
		install(new EAttributeMap(this, ecoreDetailElement, adaptingFeatureElement));
	}
	
	public void installEcoreClassMapFeatures(EClass ecoreClass, EClass adaptingClass) {
		for (EStructuralFeature ecoreFeature :  ecoreClass.getEAllStructuralFeatures()) {
			if (ecoreFeature.isDerived() || ecoreFeature.isTransient() || ecoreFeature.isVolatile())
				continue;
			if ((ecoreFeature instanceof EReference) && ((EReference) ecoreFeature).isContainer())
				continue;
			EStructuralFeatureMap<? extends EStructuralFeature> ecoreFeatureMap = getEcoreEStructuralFeatureMap(ecoreFeature);
			if (ecoreFeatureMap != null)
				continue;
			EStructuralFeature adaptingFeature = adaptingClass.getEStructuralFeature(ecoreFeature.getName());
			if (adaptingFeature == null) {
				if (consistencyValidator != null)
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, null, ecoreClass, adaptingClass);
			}
			else if (ecoreFeature instanceof EAttribute)
				installFeatureToFeatureMap((EAttribute) ecoreFeature, (EAttribute) adaptingFeature);				
			else
				installFeatureToFeatureMap((EReference) ecoreFeature, (EReference) adaptingFeature);				
		}
	}

	public void installFeatureToExtensionAttributeMap(EAttribute ecoreFeature) {
		EcoreFeatureElement<EAttribute> ecoreFeatureElement = EcoreFeatureElement.create(ecoreFeature);
		EAttribute extensionFeature = createDemandExtensionAttributeAsAttributeFeature(ecoreFeature);
		ExtensionFeatureElement<EAttribute, EAttribute> adaptingFeatureElement = ExtensionFeatureElement.create(ecoreFeature, extensionFeature);
	    install(new EAttributeMap(this, ecoreFeatureElement, adaptingFeatureElement));
	}

	public void installFeatureToExtensionAttributeOrElementMap(EReference ecoreFeature) {
		assert !ecoreFeature.isContainment();
		EcoreFeatureElement<EReference> ecoreFeatureElement = EcoreFeatureElement.create(ecoreFeature);
		EReference extensionElementFeature = createDemandExtensionReferenceFeature(ecoreFeature, true);
		EReference extensionAttributeFeature = createDemandExtensionReferenceFeature(ecoreFeature, false);
		if (ecoreFeature.isMany())
			extensionAttributeFeature.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
		ExtensionFeatureElement<EReference, EReference> adaptingFeatureElement = ExtensionFeatureElement.create(ecoreFeature, extensionAttributeFeature, extensionElementFeature);
	    install(new EReferenceMap(this, ecoreFeatureElement, adaptingFeatureElement));
	}

	public void installFeatureToExtensionElementMap(EAttribute ecoreFeature) {
		EcoreFeatureElement<EAttribute> ecoreFeatureElement = EcoreFeatureElement.create(ecoreFeature);
		EReference extensionFeature = createDemandExtensionAttributeAsReferenceFeature(ecoreFeature);
		ExtensionFeatureElement<EReference, EAttribute> adaptingFeatureElement = ExtensionFeatureElement.create(ecoreFeature, extensionFeature);
	    install(new EAttributeMap(this, ecoreFeatureElement, adaptingFeatureElement));
	}

	public void installFeatureToExtensionElementMap(EReference ecoreFeature) {
		assert ecoreFeature.isContainment();
		EcoreFeatureElement<EReference> ecoreFeatureElement = EcoreFeatureElement.create(ecoreFeature);
		EReference extensionFeature = createDemandExtensionReferenceFeature(ecoreFeature, true);
		ExtensionFeatureElement<EReference, EReference> adaptingFeatureElement = ExtensionFeatureElement.create(ecoreFeature, extensionFeature);
	    install(new EReferenceMap(this, ecoreFeatureElement, adaptingFeatureElement));
	}

	public void installFeatureToFeatureMap(EAttribute ecoreFeature, EAttribute adaptingFeature) {
		EStructuralFeatureMap<? extends EStructuralFeature> ecoreFeatureMap = getEcoreEStructuralFeatureMap(ecoreFeature);
		EStructuralFeatureMap<? extends EStructuralFeature> adaptingFeatureMap = getAdaptingEStructuralFeatureMap(adaptingFeature);
		if ((ecoreFeatureMap != null) || (adaptingFeatureMap != null)) {
			if (ecoreFeatureMap == adaptingFeatureMap)
				return;
			if (consistencyValidator != null)
				consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, null, ecoreFeatureMap, adaptingFeatureMap);
//			throw new MappingConfigurationConflictException("Conflicting feature map", ecoreFeature, adaptingFeature, ecoreFeatureMap, adaptingFeatureMap);
		}
		else {
			EcoreFeatureElement<EAttribute> ecoreFeatureElement = EcoreFeatureElement.create(ecoreFeature);
			EcoreFeatureElement<EAttribute> adaptingFeatureElement = EcoreFeatureElement.create(adaptingFeature);
			install(new EAttributeMap(this, ecoreFeatureElement, adaptingFeatureElement));
		}
	}

	public void installFeatureToFeatureMap(EReference ecoreFeature, EReference adaptingFeature) {
		EStructuralFeatureMap<? extends EStructuralFeature> ecoreFeatureMap = getEcoreEStructuralFeatureMap(ecoreFeature);
		EStructuralFeatureMap<? extends EStructuralFeature> adaptingFeatureMap = getAdaptingEStructuralFeatureMap(adaptingFeature);
		if ((consistencyValidator != null) && ((ecoreFeature != null) || (adaptingFeature != null))) {
			if ((ecoreFeature != null) != (adaptingFeature != null))
				consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, null, ecoreFeature, adaptingFeature);			
			else if ((ecoreFeature != null) && (adaptingFeature != null)) {			// Redundant tests keeps compiler warnings happy
				if (ecoreFeature.getLowerBound() != adaptingFeature.getLowerBound())
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, EcorePackage.Literals.ETYPED_ELEMENT__LOWER_BOUND, Integer.valueOf(ecoreFeature.getLowerBound()), Integer.valueOf(adaptingFeature.getLowerBound()));			
				if ((ecoreFeature.isOrdered() != adaptingFeature.isOrdered()) && ecoreFeature.isMany())
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, EcorePackage.Literals.ETYPED_ELEMENT__ORDERED, Boolean.valueOf(ecoreFeature.isOrdered()), Boolean.valueOf(adaptingFeature.isOrdered()));			
				if (ecoreFeature.isUnique() != adaptingFeature.isUnique())
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, EcorePackage.Literals.ETYPED_ELEMENT__UNIQUE, Boolean.valueOf(ecoreFeature.isUnique()), Boolean.valueOf(adaptingFeature.isUnique()));			
				if (ecoreFeature.getUpperBound() != adaptingFeature.getUpperBound())
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, EcorePackage.Literals.ETYPED_ELEMENT__UPPER_BOUND, Integer.valueOf(ecoreFeature.getUpperBound()), Integer.valueOf(adaptingFeature.getUpperBound()));			
				if (ecoreFeature.isChangeable() != adaptingFeature.isChangeable())
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__CHANGEABLE, Boolean.valueOf(ecoreFeature.isChangeable()), Boolean.valueOf(adaptingFeature.isChangeable()));			
				if (ecoreFeature.isDerived() != adaptingFeature.isDerived())
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__DERIVED, Boolean.valueOf(ecoreFeature.isDerived()), Boolean.valueOf(adaptingFeature.isDerived()));			
				if (ecoreFeature.isTransient() != adaptingFeature.isTransient())
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT, Boolean.valueOf(ecoreFeature.isTransient()), Boolean.valueOf(adaptingFeature.isTransient()));			
				if (ecoreFeature.isUnsettable() != adaptingFeature.isUnsettable())
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE, Boolean.valueOf(ecoreFeature.isUnsettable()), Boolean.valueOf(adaptingFeature.isUnsettable()));			
				if (ecoreFeature.isVolatile() != adaptingFeature.isVolatile())
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__VOLATILE, Boolean.valueOf(ecoreFeature.isVolatile()), Boolean.valueOf(adaptingFeature.isVolatile()));			
				if (ecoreFeature.isContainment() != adaptingFeature.isContainment())
					consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, EcorePackage.Literals.EREFERENCE__CONTAINMENT, Boolean.valueOf(ecoreFeature.isContainment()), Boolean.valueOf(adaptingFeature.isContainment()));			
//				if (ecoreFeature.isID() != adaptingFeature.isID())
//					consistencyValidator.inconsistent(EcorePackage.Literals.EATTRIBUTE__ID, ecoreFeature, adaptingFeature);			
			}
		}
		if ((ecoreFeatureMap != null) || (adaptingFeatureMap != null)) {
			if (ecoreFeatureMap == adaptingFeatureMap)
				return;
			if (consistencyValidator != null)
				consistencyValidator.inconsistent(ecoreFeature, adaptingFeature, null, ecoreFeatureMap, adaptingFeatureMap);
		}
		else {
			EcoreFeatureElement<EReference> ecoreFeatureElement = EcoreFeatureElement.create(ecoreFeature);
			EcoreFeatureElement<EReference> adaptingFeatureElement = EcoreFeatureElement.create(adaptingFeature);
			install(new EReferenceMap(this, ecoreFeatureElement, adaptingFeatureElement));
		}
	}

	/**
	 * Install the regular same-named mappings between adaptingPackage and ecorePackage.
	 * @throws MappingConfigurationException 
	 */
	public void installPackagePair(MappingMetaData mappingMetaData, EPackage ecorePackage, EPackage adaptingPackage) {
		for (EClassifier adaptingClassifier :  adaptingPackage.getEClassifiers()) {
			if (!(adaptingClassifier instanceof EClass))
				continue;
			if (((EClass) adaptingClassifier).isAbstract())
				continue;
			if (getAdaptingEClassMap((EClass) adaptingClassifier) != null)
				continue;
			EClassifier ecoreClassifier = ecorePackage.getEClassifier(adaptingClassifier.getName());
			if (ecoreClassifier == null) {
				if (consistencyValidator != null)
					consistencyValidator.inconsistent(ecoreClassifier, adaptingClassifier, null, ecorePackage, adaptingPackage);
			}
			else if (adaptingClassifier instanceof EClass)
				installClassPair(mappingMetaData, (EClass) ecoreClassifier, (EClass) adaptingClassifier);
		}
		for (EClassifier ecoreClassifier :  ecorePackage.getEClassifiers()) {
			if (!(ecoreClassifier instanceof EClass))
					continue;
			if (((EClass) ecoreClassifier).isAbstract())
				continue;
			if (getEcoreEClassMap((EClass) ecoreClassifier) != null)
				continue;
			EClassifier adaptingClassifier = adaptingPackage.getEClassifier(ecoreClassifier.getName());
			if (adaptingClassifier == null) {
				if (consistencyValidator != null)
					consistencyValidator.inconsistent(ecoreClassifier, adaptingClassifier, null, ecorePackage, adaptingPackage);
			}
		}		
	}

	public void postLoad(EObject ecoreObject) {
		EClass ecoreClass = ecoreObject.eClass();
		EClassMap eClassMap = getEcoreEClassMap(ecoreClass);
		if (eClassMap != null)
			eClassMap.postLoad(this, ecoreObject);
	}

	public void postSave(EObject ecoreObject) {
		EClass ecoreClass = ecoreObject.eClass();
		EClassMap eClassMap = getEcoreEClassMap(ecoreClass);
		if (eClassMap != null)
			eClassMap.postSave(this, ecoreObject);
	}

	public void preLoad(EObject ecoreObject) {
		EClass ecoreClass = ecoreObject.eClass();
		EClassMap eClassMap = getEcoreEClassMap(ecoreClass);
		if (eClassMap != null)
			eClassMap.preLoad(this, ecoreObject);
	}

	public void preSave(EObject ecoreObject) {
		EClass ecoreClass = ecoreObject.eClass();
		EClassMap eClassMap = getEcoreEClassMap(ecoreClass);
		if (eClassMap != null)
			eClassMap.preSave(this, ecoreObject);
	}

	public void putAdaptingEClassMap(EClass adaptingEClass, EClassMap classMap) {
		assert adaptingEClass != null : "null adaptingEClass in putAdaptingClassMap";
		assert classMap != null : "null classMap in putAdaptingClassMap";
		diagnosedPut(adaptingEClassMaps, adaptingEClass, classMap);
		EPackage adaptingPackage = adaptingEClass.getEPackage();
		String adaptingURI = adaptingPackage.getNsURI();
		putAdaptingPackage(adaptingURI, adaptingPackage);
	}

	public void putAdaptingFeatureMap(EStructuralFeature adaptingEStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature> structuralFeatureMap) {
		diagnosedPut(adaptingEStructuralFeatureMaps, adaptingEStructuralFeature, structuralFeatureMap);
	}

	protected void putAdaptingPackage(String adaptingURI, EPackage adaptingPackage) {
		if (!adaptingPackages.containsKey(adaptingURI))
			adaptingPackages.put(adaptingURI, adaptingPackage);
	}

	public void putEDataTypeMap(EDataType ecoreEDataType, EDataType adaptingEDataType) {
		URI adaptingURI = EcoreUtil.getURI(adaptingEDataType);
		URI ecoreURI = EcoreUtil.getURI(ecoreEDataType);
		diagnosedPut(adaptingEDataTypeMaps, adaptingURI.toString(), ecoreEDataType);
		diagnosedPut(ecoreEDataTypeMaps, ecoreURI.toString(), adaptingEDataType);
	}

	public void putEcoreEClassMap(EClass ecoreEClass, EClassMap classMap) {
		assert ecoreEClass != null : "null ecoreEClass in putEcoreClassMap";
		assert classMap != null : "null classMap in putEcoreClassMap";
		diagnosedPut(ecoreEClassMaps, ecoreEClass, classMap);
		EPackage ecorePackage = ecoreEClass.getEPackage();
		if (!ecorePackages.contains(ecorePackage))
			ecorePackages.add(ecorePackage);
	}

	public void putEcoreFeatureMap(EStructuralFeature ecoreEStructuralFeature, EStructuralFeatureMap<? extends EStructuralFeature> structuralFeatureMap) {
		diagnosedPut(ecoreEStructuralFeatureMaps, ecoreEStructuralFeature, structuralFeatureMap);
	}

	public EClassMap removeAdaptingEClassMap(EClass adaptingEClass) {
		EClassMap removedClassMap = adaptingEClassMaps.remove(adaptingEClass);
		assert removedClassMap != null : "No class map to remove for " + adaptingEClass;
		return removedClassMap;
	}

	public EClassMap removeEcoreEClassMap(EClass ecoreEClass) {
		EClassMap removedClassMap = ecoreEClassMaps.remove(ecoreEClass);
		assert removedClassMap != null : "No class map to remove for " + ecoreEClass;
		return removedClassMap;
	}
	
	@Override
	public String toString() {
		return getName() + " <-> Ecore";
	}

	/**
	 * Return null if all ecorePackages have an accurate set of class and feature map declarations.
	 * Return badly configured object with explanations to writer if not valid.
	 */
	public EObject validate(PrintWriter writer) {
		EObject badObject = null;
		for (EPackage ecorePackage : ecorePackages) {
			for (EClassifier ecoreClassifier : ecorePackage.getEClassifiers()) {
				if (ecoreClassifier instanceof EClass) {
					EClassMap classMap = ecoreEClassMaps.get(ecoreClassifier);
					if (classMap == null) {
						if (!((EClass)ecoreClassifier).isAbstract()) {
							if (writer != null)
								writer.println("Missing class: " + MappingUtils.formatFullName(ecoreClassifier));
							badObject = ecoreClassifier;
						}
					}
					else {
						EStructuralFeature badFeature = classMap.validate(this, writer);
						if (badFeature != null)
							badObject = badFeature;
					}
				}
			}
		}
		return badObject;
	}
}
