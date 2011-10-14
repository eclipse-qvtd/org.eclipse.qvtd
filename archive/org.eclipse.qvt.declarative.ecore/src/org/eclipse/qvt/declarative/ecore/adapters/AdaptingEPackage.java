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
 * $Id: AdaptingEPackage.java,v 1.3 2009/12/20 08:30:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.adapters;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvt.declarative.ecore.mappings.MappingUtils;

/**
 * An AdaptingEPackage is transiently used during XML loading of elements of
 * an adapting (e.g. EMOF-based) model to be realised as adapters to an equivalent
 * Ecore-based model. The AdaptingEPackage provides apparently the unchanged
 * adapting package with a changed eFactoryInstance, so that creation of elements
 * is redirected to an AdaptingEObject creation factory.
 */
public class AdaptingEPackage implements EPackage
{
	protected final EFactory eFactory;
	protected final EPackage ePackage;
	
	public AdaptingEPackage(EFactory eFactory, EPackage ePackage) {
		this.eFactory = eFactory;
		this.ePackage = ePackage;
	}

	public EList<Adapter> eAdapters() {
		return ePackage.eAdapters();
	}

	public TreeIterator<EObject> eAllContents() {
		return ePackage.eAllContents();
	}

	public EClass eClass() {
		return ePackage.eClass();
	}

	public EObject eContainer() {
		return ePackage.eContainer();
	}

	public EStructuralFeature eContainingFeature() {
		return ePackage.eContainingFeature();
	}

	public EReference eContainmentFeature() {
		return ePackage.eContainmentFeature();
	}

	public EList<EObject> eContents() {
		return ePackage.eContents();
	}

	public EList<EObject> eCrossReferences() {
		return ePackage.eCrossReferences();
	}

	public boolean eDeliver() {
		return ePackage.eDeliver();
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return ePackage.eGet(feature, resolve);
	}

	public Object eGet(EStructuralFeature feature) {
		return ePackage.eGet(feature);
	}

	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		return ePackage.eInvoke(operation, arguments);
	}

	public boolean eIsProxy() {
		return ePackage.eIsProxy();
	}

	public boolean eIsSet(EStructuralFeature feature) {
		return ePackage.eIsSet(feature);
	}

	public void eNotify(Notification notification) {
		ePackage.eNotify(notification);
	}

	public Resource eResource() {
		return ePackage.eResource();
	}

	public void eSet(EStructuralFeature feature, Object newValue) {
		ePackage.eSet(feature, newValue);
	}

	public void eSetDeliver(boolean deliver) {
		ePackage.eSetDeliver(deliver);
	}

	public void eUnset(EStructuralFeature feature) {
		ePackage.eUnset(feature);
	}

	public EAnnotation getEAnnotation(String source) {
		return ePackage.getEAnnotation(source);
	}

	public EList<EAnnotation> getEAnnotations() {
		return ePackage.getEAnnotations();
	}

	public EClassifier getEClassifier(String name) {
		return ePackage.getEClassifier(name);
	}

	public EList<EClassifier> getEClassifiers() {
		return ePackage.getEClassifiers();
	}

	public EFactory getEFactoryInstance() {
		return eFactory;
	}

	public EList<EPackage> getESubpackages() {
		return ePackage.getESubpackages();
	}

	public EPackage getESuperPackage() {
		return ePackage.getESuperPackage();
	}

	public String getName() {
		return ePackage.getName();
	}

	public String getNsPrefix() {
		return ePackage.getNsPrefix();
	}

	public String getNsURI() {
		return ePackage.getNsURI();
	}

	public void setEFactoryInstance(EFactory value) {
		ePackage.setEFactoryInstance(value);
	}

	public void setName(String value) {
		ePackage.setName(value);
	}

	public void setNsPrefix(String value) {
		ePackage.setNsPrefix(value);
	}

	public void setNsURI(String value) {
		ePackage.setNsURI(value);
	}
	
	@Override
	public String toString() {
		return "=>" + MappingUtils.formatFullName(ePackage);
	}
}
