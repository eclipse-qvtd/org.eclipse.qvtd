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
 * $Id: EcoreDetailElement.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * An EcoreDetailElement defines the ecore ends of an EStructuralFeature
 * mapping between an adapting and ecore model, for use when the Ecore representation is
 * an annotation detail value. 
 *
 * @param <F> EAttribute or EReference
 */
public abstract class EcoreDetailElement extends AbstractFeatureElement<EAttribute>
{
	public static EcoreDetailElement create(String detailsKey) {
		return new EAttributeElement(detailsKey);
	}

	public static class EAttributeElement extends EcoreDetailElement {
		
		public EAttributeElement(String detailKey) {
			super(detailKey);
		}

		@Override public boolean isContainer() {
			return false;
		}

		@Override public boolean isContainment() {
			return false;
		}
	}
	
	protected final String detailsKey;

	protected EcoreDetailElement(String detailsKey) {
		super(null);			// FIXME Super NPEs
		this.detailsKey = detailsKey;
	}
	
	@Override
	public Object get(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject eObject, boolean resolveProxies) {
		assert eObject instanceof EAnnotation;
		return ((EAnnotation)eObject).getDetails().get(detailsKey);
	}

	@Override
	public EDataType getEDataType() {
		return EcorePackage.Literals.ESTRING;
	}
	
	@Override public EStructuralFeature getEcoreFeature() {
		return eStructuralFeature;
	}
	
	@Override
	public Object getExtension(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject adaptingContainerObject, AnyType extensionObject) {
		return extensionObject.getAnyAttribute().get(getExtensionFeature(mappingMetaDataRegistry), false);
	}

	@Override
	public void set(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject eObject, Object value) {
		assert eObject instanceof EAnnotation;
		assert value instanceof String;
		((EAnnotation)eObject).getDetails().put(detailsKey, (String) value);
	}
	
	@Override
	public void setExtension(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, AnyType extensionObject, Object value) {
		setExtensionValue(extensionObject.getAnyAttribute(), extensionObject, getExtensionFeature(mappingMetaDataRegistry), value); // FIXME getMixed() sometimes ?
	}
	
	@Override
	public String toString() {
		return "@" + detailsKey;
	}
}