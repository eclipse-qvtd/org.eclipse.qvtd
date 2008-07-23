/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.emof.EMOF.util;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;
import org.eclipse.qvt.declarative.ecore.mappings.EAttributeOrEReference;
import org.eclipse.qvt.declarative.ecore.mappings.EClassMap;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;

/**
 * An AbstractEMOFPropertyAdapter provides the adapting EMOF Property model element that 
 * adapts an Ecore model EStructuralFeature element maintaining the Ecore element as an
 * EAttributeOrEReference until such time as it can be determined whether an
 * EAttribute or EReference is appropriate.
 * <p>
 * Derived classes must im
 */
public abstract class AbstractEMOFPropertyAdapter extends AdaptingEObject
{
	private EAttributeOrEReference originalTarget = null;
	
	protected AbstractEMOFPropertyAdapter(MappingMetaDataRegistry mappingMetaDataRegistry, EClassMap eClassMap, EAttributeOrEReference target) {
		super(mappingMetaDataRegistry, eClassMap, target);
	}

	/**
	 * Setting any feature that is distinctively EReference or EAttribute is intercepted
	 * to resolve the Ecore element.
	 */
	@Override public void eSet(EStructuralFeature feature, Object newValue) {
		resolveOnSet(feature, newValue);
		super.eSet(feature, newValue);
	}

	@Override public void postLoad() {
		super.postLoad();
		if (target instanceof EAttributeOrEReference)
			resolveTargetAsReference(((EAttributeOrEReference)target).getEType() instanceof EClass);		// Last ditch resolution against eGenericType extension
		else if (originalTarget != null) {
			//
			// resolveTargetAsReference may be invoked during an XMI load before the resource is
			// locatable from this adapter. This doesn't prevent SAXXMIHandler.handleObjectAttribs
			// invoking setID to install the originalTarget against the ID. Therefore an ID
			// registration for the originalTarget is replaced by an ID registration for the
			// resolved target.
			//
			Resource resource = target.eResource();
			if (resource instanceof XMLResource) {
				String id1 = ((XMLResource) resource).getID(originalTarget);
				String id2 = ((XMLResource) resource).getID(target);
				if ((id1 != null) && (id2 == null)) {
					((XMLResource) resource).setID(originalTarget, null);
					((XMLResource) resource).setID(target, id1);
				}
			}
			originalTarget = null;
		}
	}
	
	/**
	 * Invoke resolveTargetAsReference if the feature (and value) disambiguate
	 * EReference/EAttribute.
	 */
	public abstract void resolveOnSet(EStructuralFeature feature, Object newValue);

	public void resolveProxy(EObject adaptingObject) {
		EObject object = EcoreUtil.resolve(this, adaptingObject);
		if (!object.eIsProxy())
			resolveTargetAsReference(object instanceof EReference);
		else
			/* FIXME error*/;
	}

	/**
	 * Replace the current Ecore target by an EReference of EAttribute.
	 * 
	 * @param asReference true for an EReference
	 */
	protected void resolveTargetAsReference(boolean asReference) {
		if (target instanceof EAttributeOrEReference) {
			EAttributeOrEReference target = (EAttributeOrEReference)this.target;
			EStructuralFeature newTarget = asReference ? EcoreFactory.eINSTANCE.createEReference() : EcoreFactory.eINSTANCE.createEAttribute();
			// ID
			Resource resource = target.eResource();
			if (resource == null)
				originalTarget = target;		// Signal need for resolution by postLoad
			else if (resource instanceof XMLResource) {
				String id = ((XMLResource) resource).getID(target);
				((XMLResource) resource).setID(target, null);
				((XMLResource) resource).setID(newTarget, id);
			}
			// simple features
			newTarget.setChangeable(target.isChangeable());
			newTarget.setDefaultValueLiteral(target.getDefaultValueLiteral());
			newTarget.setDerived(target.isDerived());
			newTarget.setEGenericType(target.getEGenericType());
			newTarget.setLowerBound(target.getLowerBound());
			newTarget.setName(target.getName());
			newTarget.setOrdered(target.isOrdered());
			((InternalEObject)newTarget).eSetProxyURI(((InternalEObject)target).eProxyURI());
			newTarget.setTransient(target.isTransient());
			newTarget.setUnique(target.isUnique());
			newTarget.setUnsettable(target.isUnsettable());
			newTarget.setUpperBound(target.getUpperBound());
			newTarget.setVolatile(target.isVolatile());
			// container
			EClass eClass = target.getEContainingClass();
			if (eClass != null) {
				List<EStructuralFeature> eStructuralFeatures = eClass.getEStructuralFeatures();
				int index = eStructuralFeatures.indexOf(target);
				eStructuralFeatures.set(index, newTarget);
			}
			// annotations
			newTarget.getEAnnotations().addAll(target.getEAnnotations());
			// adapters
			newTarget.eAdapters().addAll(target.eAdapters());
			for (Adapter eAdapter : target.eAdapters())
				eAdapter.setTarget(newTarget);
		}
		if (asReference)
			assert target instanceof EReference;
		else
			assert target instanceof EAttribute;
	}
}
