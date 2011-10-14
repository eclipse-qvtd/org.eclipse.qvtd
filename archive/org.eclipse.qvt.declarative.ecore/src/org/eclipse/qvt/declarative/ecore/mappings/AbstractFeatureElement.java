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
 * $Id: AbstractFeatureElement.java,v 1.3 2009/02/17 21:31:35 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import java.util.List;

import org.eclipse.emf.common.notify.NotifyingList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * An AbstractFeatureElement defines either adapting or ecore ends of an EStructuralFeature
 * mapping between an adapting and ecore model. Derived classes specialise for EAttribute
 * or EReference behaviour and for representation as a contained element or as an
 * XMI extension object. 
 *
 * @param <F> EAttribute or EReference
 */
public abstract class AbstractFeatureElement<F extends EStructuralFeature>
{
    public static class DiagnosticString implements Resource.Diagnostic
    {
    	protected final String message;
    	protected final String location;

    	public DiagnosticString(String message, String location) {
    		this.message = message;
    		this.location = location;
    	}

    	public int getColumn() {
    		return 0;
    	}

    	public int getLine() {
    		return 0;
    	}

    	public String getLocation() {
    		return location;
    	}

		public String getMessage() {
			return message;
		}
    }
	public final F eStructuralFeature;
	
	protected AbstractFeatureElement(F eStructuralFeature) {
		this.eStructuralFeature = eStructuralFeature;
	}

	public String formatName() {
		return MappingUtils.formatLocalName(eStructuralFeature.eContainer())
			+ "." + MappingUtils.formatLocalName(eStructuralFeature);
	}
	
	public abstract Object get(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject eObject, boolean resolveProxies);

	public Object getDefaultValue() {
		return getEcoreFeature().isMany() ? null : eStructuralFeature.getDefaultValue();
	}

	public EDataType getEDataType() {
		F ecoreFeature = getEStructuralFeature();
		if (ecoreFeature instanceof EAttribute)
			return ((EAttribute) ecoreFeature).getEAttributeType();
		else
			return null;
	}
	
	public F getEStructuralFeature() {
		return eStructuralFeature;
	}
	
	public abstract EStructuralFeature getEcoreFeature();		
	public abstract Object getExtension(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject adaptingContainerObject, AnyType extensionObject);

	public EStructuralFeature getExtensionFeature(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ".getExtensionFeature");
	}

	public abstract boolean isContainer();
	public abstract boolean isContainment();		
	public abstract void set(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject eObject, Object value);
	public abstract void setExtension(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, AnyType extensionObject, Object value);

	protected void setExtensionElement(FeatureMap featureMap, EObject eObject, EStructuralFeature structuralFeature, Object value) {
		//
		//	Contributions to a mixed content are pretty printed on the assumption that indenting is
		//	performed by XMLString that has a built-in 2 character indent.
		//
		if ((featureMap instanceof NotifyingList<?>) && (((NotifyingList<?>) featureMap).getFeatureID() == XMLTypePackage.ANY_TYPE__MIXED)) {
			StringBuffer s = new StringBuffer();
			s.append("\n    ");								// Indent for xmi:XMI and for root element
			for (EObject rootObject = eObject; rootObject.eContainer() != null; rootObject = rootObject.eContainer())
				s.append("  ");								// Indent for each parent element
			if (featureMap.size() == 0)
				featureMap.add(XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, s.toString());	// Last line for </xmi:Extension>
			s.append("  ");									// Indent for <xmi:Extension
			featureMap.add(featureMap.size()-1, XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT, s.toString());
			featureMap.add(featureMap.size()-1, structuralFeature, value);		
		}
		else
			featureMap.add(structuralFeature, value);
	}
	
	protected void setExtensionValue(FeatureMap featureMap, EObject eObject, EStructuralFeature structuralFeature, Object value) {
		if (getEcoreFeature().isMany())
			for (Object v : (List<?>)value)
				setExtensionElement(featureMap, eObject, structuralFeature, v);
		else
			setExtensionElement(featureMap, eObject, structuralFeature, value);
	}

	protected void setValue(EObject eObject, EStructuralFeature structuralFeature, Object valueOrValues) {
		assert !(eObject instanceof AnyType);
		if (getEcoreFeature().isMany()) {
			List<Object> list = MappingUtils.asClassUnchecked(eObject.eGet(structuralFeature), (List<Object>)null);
			if (valueOrValues != null)
				list.addAll((List<?>)valueOrValues);
		}
		else {
			EClass eClass1 = (EClass) structuralFeature.eContainer();
			EClass eClass2 = eObject.eClass();
			if (eClass1.isSuperTypeOf(eClass2))
				eObject.eSet(structuralFeature, valueOrValues);
			else {
				Object defaultValue = structuralFeature.getDefaultValue();
				if ((defaultValue != valueOrValues) && ((defaultValue == null) || !defaultValue.equals(valueOrValues))) {
					Resource toResource = eObject.eResource();
					String message = "Ignored " + MappingUtils.formatFeatureName(structuralFeature) + " for " + MappingUtils.formatLocalName(eClass2);
					String location = "??";		// FIXME
					toResource.getErrors().add(new DiagnosticString(message, location));
					// FIXME
					System.out.println(message);
				}
			}
		}
	}
	
	@Override public String toString() {
		return MappingUtils.formatFullName(eStructuralFeature);
	}
}