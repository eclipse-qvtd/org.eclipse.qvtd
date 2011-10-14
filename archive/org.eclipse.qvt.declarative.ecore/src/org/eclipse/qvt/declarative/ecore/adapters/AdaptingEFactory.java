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
 * $Id: AdaptingEFactory.java,v 1.3 2009/12/20 08:30:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.adapters;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An AdaptingEFactory is used in place of the normal EFactoryImpl for an adapting model
 * adapting an ecore model. All functionality except create() is delegated to the standard
 * factory. Creation is realised by the derived MappingMetaData so that the appropriate adapter
 * is created.
 */
public abstract class AdaptingEFactory implements EFactory
{
	protected final EPackage adaptedEPackage;
	protected final EFactory adaptedEFactory;
	
	public AdaptingEFactory(EPackage adaptedEPackage) {
		this.adaptedEPackage = adaptedEPackage;
		this.adaptedEFactory = adaptedEPackage.getEFactoryInstance();
	}
	
	public String convertToString(EDataType dataType, Object instanceValue) {
		return adaptedEFactory.convertToString(dataType, instanceValue);
	}

	public Object createFromString(EDataType dataType, String literalValue) {
		return adaptedEFactory.createFromString(dataType, literalValue);
	}

	public EPackage getEPackage() {
		return adaptedEFactory.getEPackage();
	}

	public void setEPackage(EPackage value) {
		adaptedEFactory.setEPackage(value);
	}

	public EAnnotation getEAnnotation(String source) {
		return adaptedEFactory.getEAnnotation(source);
	}

	public EList<EAnnotation> getEAnnotations() {
		return adaptedEFactory.getEAnnotations();
	}

	public TreeIterator<EObject> eAllContents() {
		return adaptedEFactory.eAllContents();
	}

	public EClass eClass() {
		return adaptedEFactory.eClass();
	}

	public EObject eContainer() {
		return adaptedEFactory.eContainer();
	}

	public EStructuralFeature eContainingFeature() {
		return adaptedEFactory.eContainingFeature();
	}

	public EReference eContainmentFeature() {
		return adaptedEFactory.eContainmentFeature();
	}

	public EList<EObject> eContents() {
		return adaptedEFactory.eContents();
	}

	public EList<EObject> eCrossReferences() {
		return adaptedEFactory.eCrossReferences();
	}

	public Object eGet(EStructuralFeature feature) {
		return adaptedEFactory.eGet(feature);
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return adaptedEFactory.eGet(feature, resolve);
	}

	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		return adaptedEFactory.eInvoke(operation, arguments);
	}

	public boolean eIsProxy() {
		return adaptedEFactory.eIsProxy();
	}

	public boolean eIsSet(EStructuralFeature feature) {
		return adaptedEFactory.eIsSet(feature);
	}

	public Resource eResource() {
		return adaptedEFactory.eResource();
	}

	public void eSet(EStructuralFeature feature, Object newValue) {
		adaptedEFactory.eSet(feature, newValue);
	}

	public void eUnset(EStructuralFeature feature) {
		adaptedEFactory.eUnset(feature);
	}

	public EList<Adapter> eAdapters() {
		return adaptedEFactory.eAdapters();
	}

	public boolean eDeliver() {
		return adaptedEFactory.eDeliver();
	}

	public void eNotify(Notification notification) {
		adaptedEFactory.eNotify(notification);
	}

	public void eSetDeliver(boolean deliver) {
		adaptedEFactory.eSetDeliver(deliver);
	}
}