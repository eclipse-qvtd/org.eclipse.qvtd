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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Value CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DefaultValueCSImpl#getInitialiser <em>Initialiser</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DefaultValueCSImpl#getPropertyId <em>Property Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefaultValueCSImpl extends ModelElementCSImpl implements DefaultValueCS {
	/**
	 * The cached value of the '{@link #getInitialiser() <em>Initialiser</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialiser()
	 * @generated
	 * @ordered
	 */
	protected ExpCS initialiser;

	/**
	 * The cached value of the '{@link #getPropertyId() <em>Property Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyId()
	 * @generated
	 * @ordered
	 */
	protected Variable propertyId;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultValueCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationCSTPackage.Literals.DEFAULT_VALUE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getInitialiser() {
		return initialiser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialiser(ExpCS newInitialiser, NotificationChain msgs) {
		ExpCS oldInitialiser = initialiser;
		initialiser = newInitialiser;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.DEFAULT_VALUE_CS__INITIALISER, oldInitialiser, newInitialiser);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialiser(ExpCS newInitialiser) {
		if (newInitialiser != initialiser) {
			NotificationChain msgs = null;
			if (initialiser != null)
				msgs = ((InternalEObject)initialiser).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.DEFAULT_VALUE_CS__INITIALISER, null, msgs);
			if (newInitialiser != null)
				msgs = ((InternalEObject)newInitialiser).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.DEFAULT_VALUE_CS__INITIALISER, null, msgs);
			msgs = basicSetInitialiser(newInitialiser, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.DEFAULT_VALUE_CS__INITIALISER, newInitialiser, newInitialiser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getPropertyId() {
		if (propertyId != null && ((EObject)propertyId).eIsProxy()) {
			InternalEObject oldPropertyId = (InternalEObject)propertyId;
			propertyId = (Variable)eResolveProxy(oldPropertyId);
			if (propertyId != oldPropertyId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationCSTPackage.DEFAULT_VALUE_CS__PROPERTY_ID, oldPropertyId, propertyId));
			}
		}
		return propertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetPropertyId() {
		return propertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyId(Variable newPropertyId) {
		Variable oldPropertyId = propertyId;
		propertyId = newPropertyId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.DEFAULT_VALUE_CS__PROPERTY_ID, oldPropertyId, propertyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSTPackage.DEFAULT_VALUE_CS__INITIALISER:
				return basicSetInitialiser(null, msgs);
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
			case QVTrelationCSTPackage.DEFAULT_VALUE_CS__INITIALISER:
				return getInitialiser();
			case QVTrelationCSTPackage.DEFAULT_VALUE_CS__PROPERTY_ID:
				if (resolve) return getPropertyId();
				return basicGetPropertyId();
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
			case QVTrelationCSTPackage.DEFAULT_VALUE_CS__INITIALISER:
				setInitialiser((ExpCS)newValue);
				return;
			case QVTrelationCSTPackage.DEFAULT_VALUE_CS__PROPERTY_ID:
				setPropertyId((Variable)newValue);
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
			case QVTrelationCSTPackage.DEFAULT_VALUE_CS__INITIALISER:
				setInitialiser((ExpCS)null);
				return;
			case QVTrelationCSTPackage.DEFAULT_VALUE_CS__PROPERTY_ID:
				setPropertyId((Variable)null);
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
			case QVTrelationCSTPackage.DEFAULT_VALUE_CS__INITIALISER:
				return initialiser != null;
			case QVTrelationCSTPackage.DEFAULT_VALUE_CS__PROPERTY_ID:
				return propertyId != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return ((QVTrelationCSVisitor<R>)visitor).visitDefaultValueCS(this);
	}
} //DefaultValueCSImpl
