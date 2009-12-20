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
 * $Id: AdaptingEObject.java,v 1.6 2009/12/20 08:41:23 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.adapters;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvt.declarative.ecore.mappings.AbstractFeatureElement;
import org.eclipse.qvt.declarative.ecore.mappings.EClassMap;
import org.eclipse.qvt.declarative.ecore.mappings.EStructuralFeatureMap;
import org.eclipse.qvt.declarative.ecore.mappings.ExtensionFeatureElement;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingUtils;

/**
 * An AdaptingEObject behaves as an EObject for an element of an adapting model adapting
 * an ecore model. The standard reflective interface is provided by eSet and eGet, such
 * that values are obtained from and adapted from the ecore model. The adapting adapting
 * model is stateless.
 * 
 * Adapted objects are normally created as a consequence of loading, saving or creating a
 * AdaptingXMIResource that defines the adapted model as an adapting resource.
 */
public class AdaptingEObject implements Adapter, Notifier, InternalEObject
{
	protected final MappingMetaDataRegistry mappingMetaDataRegistry;
	private EClassMap classMap;
	protected EObject target;
	
	public AdaptingEObject(MappingMetaDataRegistry mappingMetaDataRegistry, EClassMap classMap, EObject target) {
		this.mappingMetaDataRegistry = mappingMetaDataRegistry;
		this.classMap = classMap;
		this.target = target;
		assert classMap.getEcoreEClass().isInstance(target);
	}

	public EList<Adapter> eAdapters() {
		return target.eAdapters();
	}
	
	public TreeIterator<EObject> eAllContents() {
		throw new UnsupportedOperationException(getClass().getName() + ".eAllContents");
	}
	
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
	    return derivedFeatureID;
	}

	public NotificationChain eBasicRemoveFromContainer(NotificationChain notifications) {
		throw new UnsupportedOperationException(getClass().getName() + ".eBasicRemoveFromContainer");
	}

	public NotificationChain eBasicSetContainer(InternalEObject newContainer,
			int newContainerFeatureID, NotificationChain notifications) {
		throw new UnsupportedOperationException(getClass().getName() + ".eBasicSetContainer");
	}

	public EClass eClass() {
		return getClassMap().getAdaptingEClass(target);
	}

	public EObject eContainer() {
		return eInternalContainer();
	}

	public EStructuralFeature eContainingFeature() {
		EStructuralFeature ecoreContainingFeature = target.eContainingFeature();
		EObject ecoreContainer = target.eContainer();
		EClass ecoreContainmentClass = ecoreContainer.eClass();
		EClassMap containerClassMap = mappingMetaDataRegistry.getEcoreEClassMap(ecoreContainmentClass);
		EStructuralFeatureMap<? extends EStructuralFeature> containmentFeatureMap = containerClassMap.getEcoreFeatureMap(ecoreContainingFeature);
		return containmentFeatureMap.getAdaptingFeature();
	}

	public int eContainerFeatureID() {
		throw new UnsupportedOperationException(getClass().getName() + ".eContainerFeatureID");
	}

	public EReference eContainmentFeature() {
		EReference ecoreContainmentFeature = target.eContainmentFeature();
		EObject ecoreContainer = target.eContainer();
		EClass ecoreContainmentClass = ecoreContainer.eClass();
		EClassMap containerClassMap = mappingMetaDataRegistry.getEcoreEClassMap(ecoreContainmentClass);
		EStructuralFeatureMap<? extends EStructuralFeature> containmentFeatureMap = containerClassMap.getEcoreFeatureMap(ecoreContainmentFeature);
		EReference adaptingFeature = (EReference) containmentFeatureMap.getAdaptingFeature();
		if (adaptingFeature == null)
			adaptingFeature = (EReference) containmentFeatureMap.getEcoreFeatureElement().getExtensionFeature(mappingMetaDataRegistry);
		return adaptingFeature;
	}

	public EList<EObject> eContents() {
		return mappingMetaDataRegistry.getAdapters(target.eContents());
	}

	public EList<EObject> eCrossReferences() {
		return mappingMetaDataRegistry.getAdapters(target.eCrossReferences());
	}

	public boolean eDeliver() {
		return target.eDeliver();
	}

	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		return ((InternalEObject)target).eDerivedOperationID(baseOperationID, baseClass);
	}

	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		return ((InternalEObject)target).eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	public Resource.Internal eDirectResource() {
		Resource.Internal directResource = ((InternalEObject)target).eDirectResource();
		return directResource != null ? eInternalResource() : null;
	}

	public Object eGet(EStructuralFeature feature) {
		return eGet(feature, false);
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		EStructuralFeatureMap<?> featureMap = getClassMap().getAdaptingFeatureMap(target, feature);
		if (featureMap == null) {
			if (feature.isMany())
				return Collections.emptyList();
			else
				return null;
		}
		Object ecoreValue = featureMap.getEcoreValue(target, resolve);
		return featureMap.exportValueOrValues(this, ecoreValue);
	}

	public Object eGet(EStructuralFeature feature, boolean resolve, boolean coreType) {
		throw new UnsupportedOperationException(getClass().getName() + ".eGet");
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		throw new UnsupportedOperationException(getClass().getName() + ".eGet");
	}

	public InternalEObject eInternalContainer() {
		return (InternalEObject) mappingMetaDataRegistry.getAdapter(target.eContainer());
	}

	public Resource.Internal eInternalResource() {
		return mappingMetaDataRegistry.getAdapter(target.eResource(), null);
	}

	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, Class<?> baseClass, NotificationChain notifications) {
		return notifications;
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, Class<?> baseClass, NotificationChain notifications) {
		return notifications;
	}

	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		return ((InternalEObject)target).eInvoke(operationID, arguments);
	}

	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		return ((InternalEObject)target).eInvoke(operation, arguments);
	}

	public boolean eIsProxy() {
		return target.eIsProxy();
	}

	public boolean eIsSet(EStructuralFeature feature) {
		EStructuralFeatureMap<?> featureMap = getClassMap().getAdaptingFeatureMap(target, feature);
		return featureMap != null ? featureMap.isSetEcore(target) : false;
	}

	public boolean eIsSet(int featureID) {
		throw new UnsupportedOperationException(getClass().getName() + ".eIsSet");
	}

	public void eNotify(Notification notification) {
		target.eNotify(notification);
	}

	public boolean eNotificationRequired() {
		return ((InternalEObject)target).eNotificationRequired();
	}

	public EObject eObjectForURIFragmentSegment(String uriFragmentSegment) {
		throw new UnsupportedOperationException(getClass().getName() + ".eObjectForURIFragmentSegment");
	}

	public URI eProxyURI() {
		return ((InternalEObject)target).eProxyURI();
	}

	public EObject eResolveProxy(InternalEObject proxy) {
		if (proxy == null)
			return null;
		EObject resolved = ((InternalEObject)target).eResolveProxy((InternalEObject)((AdaptingEObject)proxy).target);
		return mappingMetaDataRegistry.getAdapter(resolved);
	}

	public Resource eResource() {
		return eInternalResource();
	}

	public void eSet(EStructuralFeature feature, Object adaptingValue) {
		EStructuralFeatureMap<?> featureMap = getClassMap().getAdaptingFeatureMap(target, feature);
		if (featureMap == null)
			return;
		Object ecoreValue = featureMap.importValueOrValues(eResource(), this, adaptingValue);
		featureMap.setEcoreValue(target, ecoreValue);
	}

	public void eSet(int featureID, Object newValue) {
		throw new UnsupportedOperationException(getClass().getName() + ".eSet");
	}

	public void eSetClass(EClass class1) {
		throw new UnsupportedOperationException(getClass().getName() + ".eSetClass");
	}

	public void eSetDeliver(boolean deliver) {
		target.eSetDeliver(deliver);
	}

	public void eSetProxyURI(URI uri) {
		((InternalEObject)target).eSetProxyURI(uri);
	}

	public NotificationChain eSetResource(Resource.Internal resource, NotificationChain notifications) {
		throw new UnsupportedOperationException(getClass().getName() + ".eSetResource");
	}

	public void eSetStore(EStore store) {
		throw new UnsupportedOperationException(getClass().getName() + ".eSetStore");
	}

	public Setting eSetting(EStructuralFeature feature) {
		throw new UnsupportedOperationException(getClass().getName() + ".eSetting");
	}

	public EStore eStore() {
		throw new UnsupportedOperationException(getClass().getName() + ".eStore");
	}

	public void eUnset(EStructuralFeature feature) {
		EStructuralFeatureMap<?> featureMap = getClassMap().getAdaptingFeatureMap(target, feature);
		if (featureMap != null)
			featureMap.unsetEcore(target);
	}

	public String eURIFragmentSegment(EStructuralFeature adaptingFeature, EObject object) {
		EStructuralFeatureMap<? extends EStructuralFeature> featureMap = getClassMap().getAdaptingFeatureMap(target, adaptingFeature);
		EStructuralFeature ecoreFeature = featureMap.getEcoreStructuralFeature();
		return ((InternalEObject)target).eURIFragmentSegment(ecoreFeature, (EObject)((Adapter)object).getTarget());
	}

	public void eUnset(int featureID) {
		throw new UnsupportedOperationException(getClass().getName() + ".eUnset");
	}

	/**
	 *	Return the EClassMap defining the mapping between the Adapting and Ecore classes.
	 *  This is the classMap field by default, but may be Ecore-object state dependent
     *  in derived classes.
     */
	public EClassMap getClassMap() {
		return classMap;
	}

	public MappingMetaData getMappingMetaData() {
		return getClassMap().getMappingMetaData();
	}

	public MappingMetaDataRegistry getMappingMetaDataRegistry() {
		return mappingMetaDataRegistry;
	}
	
	public EObject getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		return (type instanceof Class<?>) && ((Class<?>)type).isAssignableFrom(getClass());
	}

	public boolean isXmiExtension() {
		return false;
	}

	public void notifyChanged(Notification notification) {}

	public void postLoad() {
		EClass ecoreEClass = getClassMap().getEcoreEClass();
//		for (EStructuralFeatureMap<?> featureMap : classMap.getFeatureMaps()) {
		for (EStructuralFeature ecoreEFeature : ecoreEClass.getEAllStructuralFeatures()) { // FIXME
			EStructuralFeatureMap<?> featureMap = mappingMetaDataRegistry.getEcoreEStructuralFeatureMap(ecoreEFeature);
			if (featureMap != null) {
				AbstractFeatureElement<?> adaptingFeatureElement = featureMap.getAdaptingFeatureElement();
				if (adaptingFeatureElement instanceof ExtensionFeatureElement<?,?>)
					featureMap.importFeature(this, this, target);
			}
		}		
	}

	public void postSave() {}

	public void preLoad() {}

	public void preSave() {
		EClass ecoreEClass = getClassMap().getEcoreEClass();
		for (EStructuralFeature ecoreEFeature : ecoreEClass.getEAllStructuralFeatures()) { // FIXME
			EStructuralFeatureMap<?> featureMap = mappingMetaDataRegistry.getEcoreEStructuralFeatureMap(ecoreEFeature);
			if (featureMap != null) {
				AbstractFeatureElement<?> adaptingFeatureElement = featureMap.getAdaptingFeatureElement();
				if (adaptingFeatureElement instanceof ExtensionFeatureElement<?,?>)
					featureMap.exportFeature(target, this);
			}
		}		
	}

	public void setTarget(Notifier newTarget) {
		// NB set null during unload
		assert (newTarget == null) || classMap.getEcoreEClass().isInstance(newTarget);
		classMap = newTarget != null ? mappingMetaDataRegistry.getEcoreEClassMap(((EObject)newTarget).eClass()) : null;
		target = (EObject) newTarget;
	}	
	
	@Override public String toString() {
		return mappingMetaDataRegistry.getName() + "(" + MappingUtils.formatFullName(target) + ")";
	}
}
