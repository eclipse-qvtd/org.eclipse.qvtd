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
	 * The number of structural features of the '<em>Class Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_ATTRIBUTE_FEATURE_COUNT = AttributeImpl.ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Class Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_ATTRIBUTE_OPERATION_COUNT = AttributeImpl.ATTRIBUTE_OPERATION_COUNT + 0;

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
			eNotify(new ENotificationImpl(this, Notification.SET, 4, oldEcoreReference, ecoreReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EObject> getEObjects() {
		if (eObjects == null) {
			eObjects = new EObjectEList<EObject>(EObject.class, this, 5);
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
			case 4:
				return getEcoreReference();
			case 5:
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
			case 4:
				setEcoreReference((EReference)newValue);
				return;
			case 5:
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
			case 4:
				setEcoreReference((EReference)null);
				return;
			case 5:
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
			case 4:
				return ecoreReference != null;
			case 5:
				return eObjects != null && !eObjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public EStructuralFeature getEcoreFeature() {
		return getEcoreReference();
	}
} //ClassAttributeImpl
