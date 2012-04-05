/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
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
 * $Id: KeyDeclCSImpl.java,v 1.2 2008/08/18 07:55:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.impl.CSTNodeImpl;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.KeyDeclCSImpl#getClassId <em>Class Id</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.KeyDeclCSImpl#getPropertyId <em>Property Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyDeclCSImpl extends CSTNodeImpl implements KeyDeclCS {
	/**
	 * The cached value of the '{@link #getClassId() <em>Class Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassId()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS classId;

	/**
	 * The cached value of the '{@link #getPropertyId() <em>Property Id</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyId()
	 * @generated
	 * @ordered
	 */
	protected EList<IdentifiedCS> propertyId;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyDeclCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrCSTPackage.Literals.KEY_DECL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getClassId() {
		return classId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassId(PathNameCS newClassId, NotificationChain msgs) {
		PathNameCS oldClassId = classId;
		classId = newClassId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.KEY_DECL_CS__CLASS_ID, oldClassId, newClassId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassId(PathNameCS newClassId) {
		if (newClassId != classId) {
			NotificationChain msgs = null;
			if (classId != null)
				msgs = ((InternalEObject)classId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.KEY_DECL_CS__CLASS_ID, null, msgs);
			if (newClassId != null)
				msgs = ((InternalEObject)newClassId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.KEY_DECL_CS__CLASS_ID, null, msgs);
			msgs = basicSetClassId(newClassId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.KEY_DECL_CS__CLASS_ID, newClassId, newClassId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IdentifiedCS> getPropertyId() {
		if (propertyId == null) {
			propertyId = new EObjectContainmentEList<IdentifiedCS>(IdentifiedCS.class, this, QVTrCSTPackage.KEY_DECL_CS__PROPERTY_ID);
		}
		return propertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrCSTPackage.KEY_DECL_CS__CLASS_ID:
				return basicSetClassId(null, msgs);
			case QVTrCSTPackage.KEY_DECL_CS__PROPERTY_ID:
				return ((InternalEList<?>)getPropertyId()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTrCSTPackage.KEY_DECL_CS__CLASS_ID:
				return getClassId();
			case QVTrCSTPackage.KEY_DECL_CS__PROPERTY_ID:
				return getPropertyId();
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
			case QVTrCSTPackage.KEY_DECL_CS__CLASS_ID:
				setClassId((PathNameCS)newValue);
				return;
			case QVTrCSTPackage.KEY_DECL_CS__PROPERTY_ID:
				getPropertyId().clear();
				getPropertyId().addAll((Collection<? extends IdentifiedCS>)newValue);
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
			case QVTrCSTPackage.KEY_DECL_CS__CLASS_ID:
				setClassId((PathNameCS)null);
				return;
			case QVTrCSTPackage.KEY_DECL_CS__PROPERTY_ID:
				getPropertyId().clear();
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
			case QVTrCSTPackage.KEY_DECL_CS__CLASS_ID:
				return classId != null;
			case QVTrCSTPackage.KEY_DECL_CS__PROPERTY_ID:
				return propertyId != null && !propertyId.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //KeyDeclCSImpl
