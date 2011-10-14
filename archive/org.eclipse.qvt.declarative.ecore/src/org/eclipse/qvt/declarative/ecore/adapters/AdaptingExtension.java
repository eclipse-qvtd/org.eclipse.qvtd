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
 * $Id: AdaptingExtension.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.adapters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.qvt.declarative.ecore.mappings.EClassMap;
import org.eclipse.qvt.declarative.ecore.mappings.EStructuralFeatureMap;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;
/**
 * An AdaptingExtension behaves as an EObject for an element of an adapting model adapting
 * an ecore model in the same way as AdaptingEObject but maintains the adapted ecore
 * state as AnyType feature maps, so that they are correctly serialised when saved as XMI.
 * 
 * The adapted state is typically only transiently valid between the presSave and postSave
 * serialisation phases.  
 */
public class AdaptingExtension extends AdaptingEObject implements AnyType
{
	protected FeatureMap mixed = null;
	protected FeatureMap anyAttribute = null;

	public AdaptingExtension(MappingMetaDataRegistry mappingMetaDataRegistry, EClassMap eClassMap, EObject target) {
		super(mappingMetaDataRegistry, eClassMap, target);
	}

	@Override public Object eGet(EStructuralFeature feature) {
		if (XMLTypePackage.eINSTANCE.getAnyType().isSuperTypeOf(feature.getEContainingClass())) {
		    switch (feature.getFeatureID())
		    {
		      case XMLTypePackage.ANY_TYPE__MIXED:
		        return getMixed();
		      case XMLTypePackage.ANY_TYPE__ANY:
		        return getAny();
		      case XMLTypePackage.ANY_TYPE__ANY_ATTRIBUTE:
		        return getAnyAttribute();
		      default:
			    return null;
		    }
		}
		else
			return super.eGet(feature);
	}

	@Override public Object eGet(EStructuralFeature feature, boolean resolve) {
		if (XMLTypePackage.eINSTANCE.getAnyType().isSuperTypeOf(feature.getEContainingClass())) {
		    switch (feature.getFeatureID())
		    {
		      case XMLTypePackage.ANY_TYPE__MIXED:
		        return getMixed();
		      case XMLTypePackage.ANY_TYPE__ANY:
		        return getAny();
		      case XMLTypePackage.ANY_TYPE__ANY_ATTRIBUTE:
		        return getAnyAttribute();
		      default:
			    return null;
		    }
		}
		else
			return super.eGet(feature, resolve);
	}

	@Override public boolean eIsSet(EStructuralFeature feature) {
		if (XMLTypePackage.eINSTANCE.getAnyType().isSuperTypeOf(feature.getEContainingClass())) {
		    switch (feature.getFeatureID())
		    {
		      case XMLTypePackage.ANY_TYPE__MIXED:
		        return mixed != null && !mixed.isEmpty();
		      case XMLTypePackage.ANY_TYPE__ANY:
		        return !getAny().isEmpty();
		      case XMLTypePackage.ANY_TYPE__ANY_ATTRIBUTE:
		        return anyAttribute != null && !anyAttribute.isEmpty();
		      default:
		    	return false;
		    }
		}
		else
			return super.eIsSet(feature);
	}

	public FeatureMap getAny() {
	    return (FeatureMap)getMixed().<FeatureMap.Entry>list(XMLTypePackage.Literals.ANY_TYPE__ANY);
	}

	public FeatureMap getAnyAttribute() {
	    if (anyAttribute == null)
	    	anyAttribute = new BasicFeatureMap(this, XMLTypePackage.ANY_TYPE__ANY_ATTRIBUTE);
	    return anyAttribute;
	}

	public FeatureMap getMixed() {
	    if (mixed == null)
	    	mixed = new BasicFeatureMap(this, XMLTypePackage.ANY_TYPE__MIXED);
	    return mixed;
	}

	@Override
	public boolean isXmiExtension() {
		return true;
	}

	@Override public void postLoad() {
		for (EStructuralFeatureMap<?> featureMap : getClassMap().getAdaptingFeatureMaps(target))
			featureMap.importFeature(this, this, target);
	}

	@Override public void preSave() {
		for (EStructuralFeatureMap<?> featureMap : getClassMap().getAdaptingFeatureMaps(target))
			featureMap.exportFeature(target, this);
	}
}
