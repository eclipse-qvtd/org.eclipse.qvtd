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
 * $Id: EStructuralFeatureMap.java,v 1.4 2009/02/17 21:31:35 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * EStructuralFeatureMap handles the conversion between an attribute/reference of an Ecore-based
 * meta-model and a feature of a similar adapting meta-model.
 * 
 * Access to the Ecore attribute/reference is handled by an EcoreFeatureElement.
 * Access to the non-Ecore attribute/reference is handled by the more general AbstractFeatureElement,
 * which may be an EcoreFeatureElement for a modeled element or an ExtensionFeatureElement for
 * an unmodeled element to be persisted as an xmi:Extension.
 * 
 * Derivations of this class or the FeatureElement classes support alternate behaviours.
 * 
 * Conversions may occur in three phases for the two directions: getEcoreValue->exportValue->setAdaptingValue,
 * or getAdaptingValue->importValue->setEcoreValue.
 * 
 * The getEcoreValue/setEcoreValue may tidy up the Ecore access so that only one of instanceClass/TypeName,
 * type/genericType etc are published.
 * 
 * The exportValue/importValue perform the conversion between adapting and Ecore model values.
 * 
 * The getAdaptingValue/setAdaptingValue perform the xmi:extension access for preSave/postLoad.
 * 
 * See EMOFMappingMetaData for a variety of irregular mappings.
 */
public abstract class EStructuralFeatureMap<FE extends EStructuralFeature>
{
	protected final IMappingMetaDataRegistry.Install mappingMetaDataRegistry;
	protected final AbstractFeatureElement<FE> ecoreFeatureElement;
	protected final AbstractFeatureElement<? extends EStructuralFeature> adaptingFeatureElement;
	
	protected EStructuralFeatureMap(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, AbstractFeatureElement<FE> ecoreEStructuralFeature, AbstractFeatureElement<? extends EStructuralFeature> adaptingEStructuralFeature) {
		this.mappingMetaDataRegistry = mappingMetaDataRegistry;
		this.ecoreFeatureElement = ecoreEStructuralFeature;
		this.adaptingFeatureElement = adaptingEStructuralFeature;
		if ((ecoreEStructuralFeature != null) && (adaptingEStructuralFeature != null)) {
//			assert ecoreEStructuralFeature.isContainment() == otherEStructuralFeature.isContainment();
//			assert ecoreEStructuralFeature.isMany() == otherEStructuralFeature.isMany() : "same isMany";
		}
		if (ecoreEStructuralFeature != null)
			assert !ecoreEStructuralFeature.isContainer() : "should not create isContainer EStructuralFeatureMap for " + MappingUtils.formatFeatureName(ecoreEStructuralFeature);
		if (adaptingEStructuralFeature != null)
			assert !adaptingEStructuralFeature.isContainer() : "should not create isContainer EStructuralFeatureMap for " + MappingUtils.formatFeatureName(adaptingEStructuralFeature);
	}

	public void exportFeature(EObject ecoreObject, EObject adaptingObject) {
		if ((ecoreFeatureElement == null) || (adaptingFeatureElement == null))
			return;
		Object ecoreValue = getEcoreValue(ecoreObject, false);
		Object adaptingValue = exportValueOrValues(adaptingObject, ecoreValue);
		if (adaptingValue != null)
			setAdaptingValue(adaptingObject, adaptingValue);
	}

	protected abstract Object exportValue(EObject adaptingObject, Object ecoreValue);

	/**
	 * Convert the ecoreValue to an adaptingValue
	 * 
	 * @param ecoreValue
	 * @return
	 */
	public Object exportValueOrValues(EObject adaptingObject, Object ecoreValue) {
		if (ecoreValue instanceof List<?>)
			return exportValues(adaptingObject, (List<?>)ecoreValue);
		else
			return exportValue(adaptingObject, ecoreValue);		
	}

	protected abstract List<?> exportValues(EObject adaptingObject, List<?> ecoreValues);

	public EStructuralFeature getAdaptingFeature() {
		return adaptingFeatureElement != null ? adaptingFeatureElement.getEStructuralFeature() : null;
	}

	public AbstractFeatureElement<? extends EStructuralFeature> getAdaptingFeatureElement() {
		return adaptingFeatureElement;
	}
	
	public Object getAdaptingValue(EObject adaptingContainerObject, EObject adaptingObject) {
		if (adaptingFeatureElement == null)
			return null;
		else if (adaptingObject instanceof AnyType)
			return adaptingFeatureElement.getExtension(mappingMetaDataRegistry, adaptingContainerObject, (AnyType) adaptingObject);
		else
			return adaptingFeatureElement.get(mappingMetaDataRegistry, adaptingObject, false);
	}

	public AbstractFeatureElement<FE> getEcoreFeatureElement() {
		return ecoreFeatureElement;
	}

	public FE getEcoreStructuralFeature() {
		return ecoreFeatureElement != null ? ecoreFeatureElement.getEStructuralFeature() : null;
	}
	
	/**
	 * Return the feature value from the Ecore model.
	 * 
	 * @param eObject
	 * @return
	 */
	public Object getEcoreValue(EObject ecoreObject, boolean resolveProxies) {
		return ecoreFeatureElement != null ? ecoreFeatureElement.get(mappingMetaDataRegistry, ecoreObject, resolveProxies) : null;
	}

	public void importFeature(EObject adaptingContainerObject, EObject adaptingObject, EObject ecoreObject) {
		if ((ecoreFeatureElement == null) || (adaptingFeatureElement == null))
			return;
		Object adaptingValue = getAdaptingValue(adaptingContainerObject, adaptingObject);
		Object ecoreValue = importValueOrValues(adaptingContainerObject.eResource(), adaptingObject, adaptingValue);
		if (ecoreValue != null)
			setEcoreValue(ecoreObject, ecoreValue);
	}
	
	protected abstract Object importValue(Resource adaptingResource, EObject adaptingObject, Object adaptingValue);

	/**
	 * Convert the adaptingValue to an ecoreValue
	 * @param adaptingObject
	 * @param adaptingValue
	 * 
	 * @return
	 */
	public Object importValueOrValues(Resource adaptingResource, EObject adaptingObject, Object adaptingValue) {
		if (adaptingValue instanceof FeatureMap) {
			FeatureMap featureMap = (FeatureMap) adaptingValue;
			if (featureMap.size() != 1)
				return importValues(adaptingResource, adaptingObject, featureMap);
			else
				return importValue(adaptingResource, adaptingObject, featureMap.get(0));		
		}
		else {
			if (adaptingValue instanceof List<?>)
				return importValues(adaptingResource, adaptingObject, (List<?>)adaptingValue);
			else
				return importValue(adaptingResource, adaptingObject, adaptingValue);		
		}
	}

	protected List<Object> importValues(Resource adaptingResource, EObject adaptingObject, List<?> adaptingValues) {
		List<Object> ecoreValues = new ArrayList<Object>();
		for (Object adaptingValue : adaptingValues) {
			Object ecoreValue = importValue(adaptingResource, adaptingObject, adaptingValue);
			if (ecoreValue != null)
				ecoreValues.add(ecoreValue);
		}
		return ecoreValues;
	}

	public void install() {
		if (ecoreFeatureElement != null)
			installEcoreFeatureElement(ecoreFeatureElement);
		if (adaptingFeatureElement != null)
			installAdaptingFeatureElement(adaptingFeatureElement);
	}

	protected void installAdaptingFeatureElement(AbstractFeatureElement<? extends EStructuralFeature> adaptingFeatureElement) {
		if (!(adaptingFeatureElement instanceof ExtensionFeatureElement<?,?>)) {
			EStructuralFeature adaptingEStructuralFeature = adaptingFeatureElement.getEStructuralFeature();
			if (adaptingEStructuralFeature != null) {
				mappingMetaDataRegistry.putAdaptingFeatureMap(adaptingEStructuralFeature, this);
			}
		}
	}

	protected void installEcoreFeatureElement(AbstractFeatureElement<FE> ecoreFeatureElement) {
		FE ecoreEStructuralFeature = ecoreFeatureElement.getEStructuralFeature();
		if (ecoreEStructuralFeature != null)
			mappingMetaDataRegistry.putEcoreFeatureMap(ecoreEStructuralFeature, this);
	}

	public boolean isSetEcore(EObject ecoreObject) {
		if (ecoreFeatureElement == null)
			return false;
		FE ecoreEFeature = ecoreFeatureElement.getEStructuralFeature();
		EClass ecoreObjectEClass = ecoreObject.eClass();
		EClass ecoreEFeatureEClass = ecoreEFeature.getEContainingClass();
		if (!ecoreEFeatureEClass.isSuperTypeOf(ecoreObjectEClass))		// Not all EReference features apply to EAttribute and vice-versa
			return false;
		return ecoreObject.eIsSet(ecoreEFeature);
	}

	public void setAdaptingValue(EObject adaptingObject, Object adaptingValue) {
		if (adaptingObject instanceof AnyType)
			adaptingFeatureElement.setExtension(mappingMetaDataRegistry, (AnyType) adaptingObject, adaptingValue);
		else if (adaptingFeatureElement instanceof ExtensionFeatureElement<?,?>)
			adaptingFeatureElement.set(mappingMetaDataRegistry, adaptingObject, adaptingValue);
		else
			assert false : "Bad setAdaptingValue";
	}

	public void setEcoreValue(EObject ecoreObject, Object ecoreValue) {
		assert !(ecoreObject instanceof AnyType);
		ecoreFeatureElement.set(mappingMetaDataRegistry, ecoreObject, ecoreValue);
	}
	
	@Override public String toString() {
		return String.valueOf(ecoreFeatureElement) + " <==> " + String.valueOf(adaptingFeatureElement);
	}

	public void unsetEcore(EObject ecoreObject) {
		ecoreObject.eUnset(ecoreFeatureElement.getEStructuralFeature());
	}
}