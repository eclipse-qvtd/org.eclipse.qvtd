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

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.qvtd.xml.DTD;
import org.eclipse.qvtd.xml.XMLmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DTD</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xml.impl.DTDImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xml.impl.DTDImpl#getPublicId <em>Public Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xml.impl.DTDImpl#getSystemId <em>System Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DTDImpl extends NodeImpl implements DTD {
	/**
	 * The number of structural features of the '<em>DTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DTD_FEATURE_COUNT = NodeImpl.NODE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>DTD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DTD_OPERATION_COUNT = NodeImpl.NODE_OPERATION_COUNT + 0;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublicId() <em>Public Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicId()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLIC_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublicId() <em>Public Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicId()
	 * @generated
	 * @ordered
	 */
	protected String publicId = PUBLIC_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemId() <em>System Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemId()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemId() <em>System Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemId()
	 * @generated
	 * @ordered
	 */
	protected String systemId = SYSTEM_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DTDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XMLmodelPackage.Literals.DTD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 1, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPublicId() {
		return publicId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPublicId(String newPublicId) {
		String oldPublicId = publicId;
		publicId = newPublicId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, oldPublicId, publicId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSystemId() {
		return systemId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSystemId(String newSystemId) {
		String oldSystemId = systemId;
		systemId = newSystemId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 3, oldSystemId, systemId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case 1:
				return getName();
			case 2:
				return getPublicId();
			case 3:
				return getSystemId();
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
			case 1:
				setName((String)newValue);
				return;
			case 2:
				setPublicId((String)newValue);
				return;
			case 3:
				setSystemId((String)newValue);
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
			case 1:
				setName(NAME_EDEFAULT);
				return;
			case 2:
				setPublicId(PUBLIC_ID_EDEFAULT);
				return;
			case 3:
				setSystemId(SYSTEM_ID_EDEFAULT);
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
			case 1:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case 2:
				return PUBLIC_ID_EDEFAULT == null ? publicId != null : !PUBLIC_ID_EDEFAULT.equals(publicId);
			case 3:
				return SYSTEM_ID_EDEFAULT == null ? systemId != null : !SYSTEM_ID_EDEFAULT.equals(systemId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", publicId: ");
		result.append(publicId);
		result.append(", systemId: ");
		result.append(systemId);
		result.append(')');
		return result.toString();
	}

} //DTDImpl
