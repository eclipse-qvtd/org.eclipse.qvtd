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
 * $Id: EcoreFeatureElement.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * An EcoreFeatureElement defines either adapting or ecore ends of an EStructuralFeature
 * mapping between an adapting and ecore model, for use when the representation is
 * as a contained element. 
 *
 * @param <F> EAttribute or EReference
 */
public abstract class EcoreFeatureElement<F extends EStructuralFeature> extends AbstractFeatureElement<F>
{
	public static EcoreFeatureElement<EAttribute> create(EAttribute eStructuralFeature) {
		if (eStructuralFeature == null)
			return null;
		else
			return new EAttributeElement(eStructuralFeature);
	}

	public static EcoreFeatureElement<EReference> create(EReference eStructuralFeature) {
		if (eStructuralFeature == null)
			return null;
		else
			return new EReferenceElement(eStructuralFeature);
	}

	public static class EAttributeElement extends EcoreFeatureElement<EAttribute> {
		
		public EAttributeElement(EAttribute eAttribute) {
			super(eAttribute);
		}

		@Override public boolean isContainer() {
			return false;
		}

		@Override public boolean isContainment() {
			return false;
		}
	}

	public static class EReferenceElement extends EcoreFeatureElement<EReference> {
		
		public EReferenceElement(EReference eReference) {
			super(eReference);
		}

		@Override public boolean isContainer() {
			return eStructuralFeature.isContainer();
		}

		@Override public boolean isContainment() {
			return eStructuralFeature.isContainment();
		}
	}
	
	protected EStructuralFeature demandFeature = null;  // Feature when a child of an extension: e.g. name in <eTypeParameters name=...>

	protected EcoreFeatureElement(F eStructuralFeature) {
		super(eStructuralFeature);
	}
	
	@Override
	public Object get(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject eObject, boolean resolveProxies) {
		assert !(eObject instanceof AnyType);
		EClass eObjectClass = eObject.eClass();
		EClass eFeatureClass = eStructuralFeature.getEContainingClass();
		if (!eFeatureClass.isSuperTypeOf(eObjectClass))
			throw new MappingConfigurationException("Cannot get ", eObjectClass, eStructuralFeature);
		return eObject.eGet(eStructuralFeature, resolveProxies);
	}
	
	@Override public F getEcoreFeature() {
		return eStructuralFeature;
	}
	
	@Override
	public Object getExtension(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject adaptingContainerObject, AnyType extensionObject) {
		return extensionObject.getAnyAttribute().get(getExtensionFeature(mappingMetaDataRegistry), false);
	}

	@Override
	public EStructuralFeature getExtensionFeature(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		if (demandFeature == null)
			demandFeature = mappingMetaDataRegistry.createDemandEcoreFeature(eStructuralFeature);
		return demandFeature;
	}

	@Override
	public void set(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject eObject, Object value) {
		setValue(eObject, eStructuralFeature, value);
	}
	
	@Override
	public void setExtension(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, AnyType extensionObject, Object value) {
		setExtensionValue(extensionObject.getAnyAttribute(), extensionObject, getExtensionFeature(mappingMetaDataRegistry), value); // FIXME getMixed() sometimes ?
	}
}