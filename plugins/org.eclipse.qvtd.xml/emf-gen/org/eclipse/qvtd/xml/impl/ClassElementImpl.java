/**
 * <copyright>
 *
 * Copyright (c) 2018, 2021 Willink Transformations and others.
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.qvtd.xml.ClassElement;
import org.eclipse.qvtd.xml.XMLmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xml.impl.ClassElementImpl#getEcoreClass <em>Ecore Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassElementImpl extends ElementImpl implements ClassElement {
	/**
	 * The number of structural features of the '<em>Class Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_ELEMENT_FEATURE_COUNT = ElementImpl.ELEMENT_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Class Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_ELEMENT_OPERATION_COUNT = ElementImpl.ELEMENT_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getEcoreClass() <em>Ecore Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreClass()
	 * @generated
	 * @ordered
	 */
	protected EClass ecoreClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XMLmodelPackage.Literals.CLASS_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEcoreClass() {
		return ecoreClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEcoreClass(EClass newEcoreClass) {
		EClass oldEcoreClass = ecoreClass;
		ecoreClass = newEcoreClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 5, oldEcoreClass, ecoreClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case 5:
				return getEcoreClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case 5:
				setEcoreClass((EClass)newValue);
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
			case 5:
				setEcoreClass((EClass)null);
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
			case 5:
				return ecoreClass != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public EClassifier getEcoreClassifier() {
		return getEcoreClass();
	}
} //ClassElementImpl
