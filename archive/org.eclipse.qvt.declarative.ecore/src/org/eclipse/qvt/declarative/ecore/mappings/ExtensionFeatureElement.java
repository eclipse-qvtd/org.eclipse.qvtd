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
 * $Id: ExtensionFeatureElement.java,v 1.3 2009/02/17 21:31:35 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * An EcoreFeatureElement defines either adapting or ecore ends of an EStructuralFeature
 * mapping between an adapting and ecore model, for use when the representation is
 * as an XMI extension object. 
 *
 * @param <F> EAttribute or EReference
 */
public abstract class ExtensionFeatureElement<FA extends EStructuralFeature, FE extends EStructuralFeature> extends AbstractFeatureElement<FA>
{		
	public static ExtensionFeatureElement<EAttribute, EAttribute> create(EAttribute ecoreFeature, EAttribute extensionFeature) {
		if (extensionFeature == null)
			return null;
		else
			return new ExtensionAttributeAsAttributeElement(extensionFeature, ecoreFeature);
	}

	public static ExtensionFeatureElement<EReference, EAttribute> create(EAttribute ecoreFeature, EReference extensionFeature) {
		if (extensionFeature == null)
			return null;
		else
			return new ExtensionAttributeAsReferenceElement(extensionFeature, ecoreFeature);
	}

	public static ExtensionFeatureElement<EReference, EReference> create(EReference ecoreFeature, EReference extensionFeature) {
		if (extensionFeature == null)
			return null;
		else
			return new ExtensionReferenceElement(extensionFeature, ecoreFeature);
	}

	public static ExtensionFeatureElement<EReference, EReference> create(EReference ecoreFeature, EReference extensionAttributeFeature, EReference extensionElementFeature) {
		if (extensionElementFeature == null)
			return null;
		else
			return new ExtensionReferenceAttributeOrElement(extensionAttributeFeature, extensionElementFeature, ecoreFeature);
	}
	
	public abstract static class ExtensionAttributeElement<FA extends EStructuralFeature> extends ExtensionFeatureElement<FA, EAttribute>
	{		
		protected ExtensionAttributeElement(FA extensionFeature, EAttribute ecoreFeature) {
			super(extensionFeature, ecoreFeature);
		}

		@Override public boolean isContainer() {
			return false;
		}

		@Override public boolean isContainment() {
			return false;
		}
	}
	
	/**
	 * Attributes of extensions can be represented as attributes.
	 */
	public static class ExtensionAttributeAsAttributeElement extends ExtensionAttributeElement<EAttribute>
	{		
		public ExtensionAttributeAsAttributeElement(EAttribute extensionFeature, EAttribute ecoreFeature) {
			super(extensionFeature, ecoreFeature);
		}

		@Override protected FeatureMap getExtensionFeatureMap(AnyType extensionObject) {
			return extensionObject.getAnyAttribute();
		}
	}
	
	/**
	 * xmi:Extension does not support an attribute wildcard, so extension attributes
	 * must be represented as elements which is formed from a reference to an AnyType.
	 */
	public static class ExtensionAttributeAsReferenceElement extends ExtensionAttributeElement<EReference>
	{		
		public ExtensionAttributeAsReferenceElement(EReference extensionFeature, EAttribute ecoreFeature) {
			super(extensionFeature, ecoreFeature);
		}

		@Override
		public Object get(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject eObject, boolean resolveProxies) {
			Object value = super.get(mappingMetaDataRegistry, eObject, resolveProxies);
			if (value instanceof AnyType) {
				FeatureMap mixed = ((AnyType)value).getMixed();
				return mixed.size() > 0 ? mixed : "";				// Empty mixed is <xxx></xxx> not null.
			}
			else
				return value;				// Almost certainly null
		}

		@Override protected FeatureMap getExtensionFeatureMap(AnyType extensionObject) {
			return extensionObject.getMixed();
		}

		@Override protected void setExtensionElement(FeatureMap featureMap, EObject eObject, EStructuralFeature structuralFeature, Object value) {
			AnyType innerValue = XMLTypeFactory.eINSTANCE.createAnyType();
			FeatureMap innerFeatureMap = innerValue.getMixed();
			innerFeatureMap.add(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, value.toString());
			super.setExtensionElement(featureMap, eObject, structuralFeature, innerValue);
		}
	}

	/**
	 * Extension containment references are realised as elements.
	 */
	public static class ExtensionReferenceElement extends ExtensionFeatureElement<EReference, EReference>
	{		
		public ExtensionReferenceElement(EReference extensionFeature, EReference ecoreFeature) {
			super(extensionFeature, ecoreFeature);
//			assert !ecoreFeature.isContainer() : "Container features can only be serialised as elements";
			assert ecoreFeature.isContainment() : "Containment features can only be serialised as elements";
		}

		@Override protected FeatureMap getExtensionFeatureMap(AnyType extensionObject) {
			return extensionObject.getMixed();
		}

		@Override public boolean isContainer() {
			return false;
		}

		@Override public boolean isContainment() {
			return true;
		}
	}	

	/**
	 * Extension non-containment references are realised as attributes, but may be read as
	 * attributes or elements.
	 */
	public static class ExtensionReferenceAttributeOrElement extends ExtensionFeatureElement<EReference, EReference>
	{		
		private EReference extensionElementFeature;
		
		public ExtensionReferenceAttributeOrElement(EReference extensionAttributeFeature, EReference extensionElementFeature, EReference ecoreFeature) {
			super(extensionAttributeFeature, ecoreFeature);
			assert !ecoreFeature.isContainer() : "Container features can only be serialised as elements";
			assert !ecoreFeature.isContainment() : "Containment features can only be serialised as elements";
			this.extensionElementFeature = extensionElementFeature;
		}

		@Override
		public Object getExtension(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject adaptingContainerObject, AnyType extensionObject) {
			Object mixedValueOrValues = extensionObject.getMixed().get(extensionElementFeature, false);
			Object attributeValueOrValues = extensionObject.getAnyAttribute().get(eStructuralFeature, false);
			if (getEcoreFeature().isMany()) {
				List<Object> values = new ArrayList<Object>();
				if (attributeValueOrValues instanceof List<?>)
					values.addAll((List<?>) attributeValueOrValues);
				else if (attributeValueOrValues != null)
					values.add(attributeValueOrValues);
				if (mixedValueOrValues instanceof List<?>) {
					for (Object mixedValue : (List<?>) mixedValueOrValues) {
						if ((mixedValue instanceof EObject) && ((EObject)mixedValue).eIsProxy())
							mixedValue = mappingMetaDataRegistry.getAdapter(EcoreUtil.resolve((EObject)mixedValue, adaptingContainerObject));
						values.add(mixedValue);
					}
				}
				else if (mixedValueOrValues != null) {
					if ((mixedValueOrValues instanceof EObject) && ((EObject)mixedValueOrValues).eIsProxy())
						mixedValueOrValues = mappingMetaDataRegistry.getAdapter(EcoreUtil.resolve((EObject)mixedValueOrValues, adaptingContainerObject));
					values.add(mixedValueOrValues);
				}
				return values;
			}
			else {
				Object attributeValue = null;
				Object elementValue = null;
				if (attributeValueOrValues instanceof List<?>) {
					if (!((List<?>)attributeValueOrValues).isEmpty()) {
						if (((List<?>)attributeValueOrValues).size() > 1)
							System.out.println("Oversize attribute list for " + this);
						attributeValue = ((List<?>)attributeValueOrValues).get(0);
					}
				}
				else if (attributeValueOrValues != null)
					attributeValue = attributeValueOrValues;
				if (mixedValueOrValues instanceof List<?>) {
					if (!((List<?>)mixedValueOrValues).isEmpty()) {
						if (((List<?>)mixedValueOrValues).size() > 1)
							System.out.println("Oversize element list for " + this);
						elementValue = ((List<?>)mixedValueOrValues).get(0);
					}
				}
				else if (mixedValueOrValues != null)
					elementValue = mixedValueOrValues;
				if (attributeValue == null)
					return elementValue;
				if (elementValue != null)
					System.out.println("Attribute and element for " + this);
				return attributeValue;
			}
		}

		@Override protected FeatureMap getExtensionFeatureMap(AnyType extensionObject) {
			return extensionObject.getAnyAttribute();
		}

		@Override public boolean isContainer() {
			return false;
		}

		@Override public boolean isContainment() {
			return false;
		}
	}	
	
	protected final FE ecoreFeature;

	protected ExtensionFeatureElement(FA extensionFeature, FE ecoreFeature) {
		super(extensionFeature);
		this.ecoreFeature = ecoreFeature;
	}

	@Override
	public Object get(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject eObject, boolean resolveProxies) {
		assert !(eObject instanceof AnyType);
		Object valueOrValues = mappingMetaDataRegistry.getXMIExtensionValuesOrNull(eObject, eStructuralFeature);
		return resolveValueMultiplicity(valueOrValues);
	}
	
	@Override public Object getDefaultValue() {
		return ecoreFeature.isMany() ? null : ecoreFeature.getDefaultValue();
	}
	
	@Override public FE getEcoreFeature() {
		return ecoreFeature;
	}

	@Override
	public Object getExtension(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject adaptingContainerObject, AnyType extensionObject) {
		FeatureMap featureMap = getExtensionFeatureMap(extensionObject);
		Object valueOrValues = featureMap.get(eStructuralFeature, false);
		return resolveValueMultiplicity(valueOrValues);
	}

	protected abstract FeatureMap getExtensionFeatureMap(AnyType extensionObject);

	protected Object resolveValueMultiplicity(Object valueOrValues) {
		if (getEcoreFeature().isMany()) {
			assert (valueOrValues == null) || (valueOrValues instanceof List<?>);
		}
		else {
			if (valueOrValues instanceof List<?>) {
				assert ((List<?>)valueOrValues).size() <= 1;
				if (((List<?>)valueOrValues).size() > 1)
					System.out.println("Oversize list for " + this);
				valueOrValues = ((List<?>)valueOrValues).size() > 0 ? ((List<?>)valueOrValues).get(0) : null;
			}
			if (valueOrValues == null)
				valueOrValues = eStructuralFeature.getDefaultValue();
		}
		return valueOrValues;
	}

	@Override
	public void set(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject eObject, Object value) {
		assert !(eObject instanceof AnyType);
		Object defaultValue = getDefaultValue();
		Object testValue = (value instanceof List<?>) && ((List<?>)value).isEmpty() ? null : value != null ? value.toString() : null;
		boolean isDefault = (testValue == defaultValue) || ((testValue != null) && (defaultValue != null) && testValue.equals(defaultValue.toString()));
		if (!isDefault) {
			AnyType ecoreExtension = mappingMetaDataRegistry.getXMIExtensions(eObject).get(0);
			FeatureMap featureMap = getExtensionFeatureMap(ecoreExtension);
			setExtensionValue(featureMap, eObject, eStructuralFeature, value);
		}
	}

	@Override
	public void setExtension(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, AnyType extensionObject, Object value) {
		FeatureMap featureMap = getExtensionFeatureMap(extensionObject);
		setExtensionValue(featureMap, extensionObject, eStructuralFeature, value);
	}
}