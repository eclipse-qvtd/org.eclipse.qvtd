/**
 * <copyright>
 *
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xml.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.qvtd.xml.ClassAttribute;
import org.eclipse.qvtd.xml.XMLmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xml.impl.ClassAttributeImpl#getEcoreReference <em>Ecore Reference</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xml.impl.ClassAttributeImpl#getEObjects <em>EObjects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassAttributeImpl extends AttributeImpl implements ClassAttribute {
	/**
	 * The cached value of the '{@link #getEcoreReference() <em>Ecore Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreReference()
	 * @generated
	 * @ordered
	 */
	protected EReference ecoreReference;

	/**
	 * The cached value of the '{@link #getEObjects() <em>EObjects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> eObjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XMLmodelPackage.Literals.CLASS_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEcoreReference() {
		return ecoreReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEcoreReference(EReference newEcoreReference) {
		EReference oldEcoreReference = ecoreReference;
		ecoreReference = newEcoreReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XMLmodelPackage.CLASS_ATTRIBUTE__ECORE_REFERENCE, oldEcoreReference, ecoreReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getEObjects() {
		if (eObjects == null) {
			eObjects = new EObjectEList<EObject>(EObject.class, this, XMLmodelPackage.CLASS_ATTRIBUTE__EOBJECTS);
		}
		return eObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XMLmodelPackage.CLASS_ATTRIBUTE__ECORE_REFERENCE:
				return getEcoreReference();
			case XMLmodelPackage.CLASS_ATTRIBUTE__EOBJECTS:
				return getEObjects();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XMLmodelPackage.CLASS_ATTRIBUTE__ECORE_REFERENCE:
				setEcoreReference((EReference)newValue);
				return;
			case XMLmodelPackage.CLASS_ATTRIBUTE__EOBJECTS:
				getEObjects().clear();
				getEObjects().addAll((Collection<? extends EObject>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case XMLmodelPackage.CLASS_ATTRIBUTE__ECORE_REFERENCE:
				setEcoreReference((EReference)null);
				return;
			case XMLmodelPackage.CLASS_ATTRIBUTE__EOBJECTS:
				getEObjects().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XMLmodelPackage.CLASS_ATTRIBUTE__ECORE_REFERENCE:
				return ecoreReference != null;
			case XMLmodelPackage.CLASS_ATTRIBUTE__EOBJECTS:
				return eObjects != null && !eObjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public EStructuralFeature getEcoreFeature() {
		return getEcoreReference();
	}
} //ClassAttributeImpl
