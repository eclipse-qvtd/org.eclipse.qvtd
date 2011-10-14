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
 * $Id: EAttributeMap.java,v 1.4 2009/02/17 21:31:35 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * An EAttributeMap defines the mapping between an EAttribute of an adapting model and a corresponding
 * EAttribute of an Ecore model. It forms the feature node in the MappingMetaData, EClassMap,
 * EStructuralFeatureMap, AbstractFeatureElement hierarchy providing the meta data for the 
 * adapting to/from ecore mapping.
 */
public class EAttributeMap extends EStructuralFeatureMap<EAttribute>
{
	public EAttributeMap(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, AbstractFeatureElement<EAttribute> ecoreEStructuralFeature, AbstractFeatureElement<? extends EStructuralFeature> adaptingEStructuralFeature) {
		super(mappingMetaDataRegistry, ecoreEStructuralFeature, adaptingEStructuralFeature);
	}
	
	@Override protected Object exportValue(EObject adaptingObject, Object ecoreValue) {
		EAttribute ecoreFeature = ecoreFeatureElement.getEStructuralFeature();
		EDataType ecoreDataType = ecoreFeature.getEAttributeType();
		EFactory ecoreFactory = ecoreDataType.getEPackage().getEFactoryInstance();
		String stringValue = ecoreFactory.convertToString(ecoreDataType, ecoreValue);
		EStructuralFeature adaptingFeature = adaptingFeatureElement.getEStructuralFeature();
		if (adaptingFeature instanceof EAttribute) {
			EAttribute adaptingAttribute = (EAttribute) adaptingFeature;
			EDataType adaptingDataType = adaptingAttribute.getEAttributeType();
			EFactory adaptingFactory = adaptingDataType.getEPackage().getEFactoryInstance();
			return adaptingFactory.createFromString(adaptingDataType, stringValue);
		}
		else												// Never happens
			return stringValue;
	}

	@Override protected List<?> exportValues(EObject adaptingObject, List<?> ecoreValues) {
		List<Object> adaptingValues;
		if (ecoreValues instanceof InternalEList<?>) {
			EStructuralFeature adaptingFeature = adaptingFeatureElement.getEStructuralFeature();
			if (adaptingFeature  instanceof EAttribute) {
				EDataType adaptingDataType = ((EAttribute) adaptingFeature).getEAttributeType();
				adaptingValues = new BasicInternalEList<Object>(adaptingDataType.getInstanceClass());
			}
			else											// Never happens
				adaptingValues = new BasicInternalEList<Object>(String.class);
		}
		else
			adaptingValues = new BasicEList<Object>();
		for (Object ecoreValue : ecoreValues.toArray()) {	 // Ensure iteration does not resolve (190644)
			Object adaptingValue = exportValue(adaptingObject, ecoreValue);
			if (adaptingValue != null)
				adaptingValues.add(adaptingValue);
		}
		return adaptingValues;
	}
	
	@Override
	protected Object importValue(Resource adaptingResource, EObject adaptingObject, Object adaptingValue) {
		assert !(adaptingValue instanceof AnyType);
		if (adaptingValue == null)
			return null;
		EStructuralFeature adaptingFeature;
		if (adaptingValue instanceof FeatureMap.Entry) {
			FeatureMap.Entry entry = (FeatureMap.Entry) adaptingValue;
			adaptingFeature = entry.getEStructuralFeature();
			adaptingValue = entry.getValue();
		}
		else {
			adaptingFeature = adaptingFeatureElement.getEStructuralFeature();
		}
		String stringValue;
		if (adaptingFeature instanceof EAttribute) {
			EDataType adaptingDataType = ((EAttribute) adaptingFeature).getEAttributeType();
			EFactory adaptingFactory = adaptingDataType.getEPackage().getEFactoryInstance();
			stringValue = adaptingFactory.convertToString(adaptingDataType, adaptingValue);
		}
		else												// Never happens
			stringValue = adaptingValue.toString();
		EDataType ecoreDataType = ecoreFeatureElement.getEDataType();
		EFactory ecoreFactory = ecoreDataType.getEPackage().getEFactoryInstance();
		return ecoreFactory.createFromString(ecoreDataType, stringValue);
	}
}