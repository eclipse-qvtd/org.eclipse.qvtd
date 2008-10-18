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
 * $Id: EReferenceMap.java,v 1.3 2008/10/18 18:46:43 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * An EReferenceMap defines the mapping between an EReference of an adapting model and a corresponding
 * EAttribute of an Ecore model. It forms the feature node in the MappingMetaData, EClassMap,
 * EStructuralFeatureMap, AbstractFeatureElement hierarchy providing the meta data for the 
 * adapting to/from ecore mapping.
 */
public class EReferenceMap extends EStructuralFeatureMap<EReference>
{
	public EReferenceMap(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EcoreFeatureElement<EReference> ecoreEStructuralFeature, AbstractFeatureElement<EReference> adaptingEStructuralFeature) {
		super(mappingMetaDataRegistry, ecoreEStructuralFeature, adaptingEStructuralFeature);
	}
	
	@Override protected Object exportValue(EObject adaptingObject, Object ecoreValue) {
		return mappingMetaDataRegistry.getAdapter((EObject) ecoreValue);
	}

	@SuppressWarnings("unchecked")
	@Override protected List<?> exportValues(EObject adaptingObject, List<?> ecoreValues) {
		return mappingMetaDataRegistry.getAdapters((EList<EObject>)ecoreValues);
	}
	
	@Override
	protected Object importValue(Resource adaptingResource, EObject adaptingObject, Object adaptingValue) {
		if (adaptingValue == null)
			return null;
		else if (adaptingValue instanceof AnyType) {
			if (((AnyType)adaptingValue).eIsProxy()) {	// Resolution necessary to create correct proxy, so no need for proxy at all
				ResourceSet resourceSet = adaptingResource.getResourceSet();
				URI proxyURI = ((InternalEObject)adaptingValue).eProxyURI();
				return resourceSet.getEObject(proxyURI, true);
			}
			EReference ecoreFeature = getEcoreStructuralFeature();
			EClass ecoreClass = ecoreFeature.getEReferenceType();
			EClassMap eClassMap = mappingMetaDataRegistry.getEcoreEClassMap(ecoreClass);
			EObject ecoreValue = ecoreClass.getEPackage().getEFactoryInstance().create(ecoreClass);
			for (EStructuralFeatureMap<? extends EStructuralFeature> featureMap : eClassMap.getEcoreFeatureMaps())
				featureMap.importFeature(adaptingObject, (AnyType)adaptingValue, ecoreValue);		
			return ecoreValue;
		}
		else
			return ((Adapter)adaptingValue).getTarget();
	}
}