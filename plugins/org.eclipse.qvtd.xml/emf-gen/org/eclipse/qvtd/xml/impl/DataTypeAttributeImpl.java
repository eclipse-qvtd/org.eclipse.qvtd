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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.qvtd.xml.DataTypeAttribute;
import org.eclipse.qvtd.xml.XMLmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xml.impl.DataTypeAttributeImpl#getEcoreAttribute <em>Ecore Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataTypeAttributeImpl extends AttributeImpl implements DataTypeAttribute {
	/**
	 * The number of structural features of the '<em>Data Type Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DATA_TYPE_ATTRIBUTE_FEATURE_COUNT = AttributeImpl.ATTRIBUTE_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Data Type Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DATA_TYPE_ATTRIBUTE_OPERATION_COUNT = AttributeImpl.ATTRIBUTE_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getEcoreAttribute() <em>Ecore Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute ecoreAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XMLmodelPackage.Literals.DATA_TYPE_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEcoreAttribute() {
		return ecoreAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEcoreAttribute(EAttribute newEcoreAttribute) {
		EAttribute oldEcoreAttribute = ecoreAttribute;
		ecoreAttribute = newEcoreAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttributeImpl.ATTRIBUTE_FEATURE_COUNT + 0, oldEcoreAttribute, ecoreAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AttributeImpl.ATTRIBUTE_FEATURE_COUNT + 0:
				return getEcoreAttribute();
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
			case AttributeImpl.ATTRIBUTE_FEATURE_COUNT + 0:
				setEcoreAttribute((EAttribute)newValue);
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
			case AttributeImpl.ATTRIBUTE_FEATURE_COUNT + 0:
				setEcoreAttribute((EAttribute)null);
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
			case AttributeImpl.ATTRIBUTE_FEATURE_COUNT + 0:
				return ecoreAttribute != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public EStructuralFeature getEcoreFeature() {
		return getEcoreAttribute();
	}
} //DataTypeAttributeImpl
