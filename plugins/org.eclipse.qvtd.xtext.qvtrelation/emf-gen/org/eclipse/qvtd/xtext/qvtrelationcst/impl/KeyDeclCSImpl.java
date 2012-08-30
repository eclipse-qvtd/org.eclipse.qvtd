/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtrelationcst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.KeyDeclCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.KeyDeclCSImpl#getPropertyIds <em>Property Ids</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.KeyDeclCSImpl#getClassId <em>Class Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyDeclCSImpl extends ModelElementCSImpl implements KeyDeclCS {
	/**
	 * The cached value of the '{@link #getPathName() <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS pathName;

	/**
	 * The cached value of the '{@link #getPropertyIds() <em>Property Ids</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyIds()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> propertyIds;

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
		return QVTrelationCSTPackage.Literals.KEY_DECL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getPathName() {
		return pathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathName(PathNameCS newPathName, NotificationChain msgs) {
		PathNameCS oldPathName = pathName;
		pathName = newPathName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.KEY_DECL_CS__PATH_NAME, oldPathName, newPathName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathName(PathNameCS newPathName) {
		if (newPathName != pathName) {
			NotificationChain msgs = null;
			if (pathName != null)
				msgs = ((InternalEObject)pathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.KEY_DECL_CS__PATH_NAME, null, msgs);
			if (newPathName != null)
				msgs = ((InternalEObject)newPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.KEY_DECL_CS__PATH_NAME, null, msgs);
			msgs = basicSetPathName(newPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.KEY_DECL_CS__PATH_NAME, newPathName, newPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getPropertyIds() {
		if (propertyIds == null) {
			propertyIds = new EObjectResolvingEList<Property>(Property.class, this, QVTrelationCSTPackage.KEY_DECL_CS__PROPERTY_IDS);
		}
		return propertyIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSTPackage.KEY_DECL_CS__PATH_NAME:
				return basicSetPathName(null, msgs);
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
			case QVTrelationCSTPackage.KEY_DECL_CS__PATH_NAME:
				return getPathName();
			case QVTrelationCSTPackage.KEY_DECL_CS__PROPERTY_IDS:
				return getPropertyIds();
			case QVTrelationCSTPackage.KEY_DECL_CS__CLASS_ID:
				return getClassId();
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
			case QVTrelationCSTPackage.KEY_DECL_CS__PATH_NAME:
				setPathName((PathNameCS)newValue);
				return;
			case QVTrelationCSTPackage.KEY_DECL_CS__PROPERTY_IDS:
				getPropertyIds().clear();
				getPropertyIds().addAll((Collection<? extends Property>)newValue);
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
			case QVTrelationCSTPackage.KEY_DECL_CS__PATH_NAME:
				setPathName((PathNameCS)null);
				return;
			case QVTrelationCSTPackage.KEY_DECL_CS__PROPERTY_IDS:
				getPropertyIds().clear();
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
			case QVTrelationCSTPackage.KEY_DECL_CS__PATH_NAME:
				return pathName != null;
			case QVTrelationCSTPackage.KEY_DECL_CS__PROPERTY_IDS:
				return propertyIds != null && !propertyIds.isEmpty();
			case QVTrelationCSTPackage.KEY_DECL_CS__CLASS_ID:
				return getClassId() != null;
		}
		return super.eIsSet(featureID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(BaseCSVisitor<R> visitor) {
		return (R) visitor.getAdapter(QVTrelationCSVisitor.class).visitKeyDeclCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public org.eclipse.ocl.examples.pivot.Class getClassId() {
		if (pathName == null) {
			return null;
		}
		return (org.eclipse.ocl.examples.pivot.Class) pathName.getElement();
	}
} //KeyDeclCSImpl
