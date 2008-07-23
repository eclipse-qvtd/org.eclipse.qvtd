/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.impl.CSTNodeImpl;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Value CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DefaultValueCSImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DefaultValueCSImpl#getInitialiser <em>Initialiser</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefaultValueCSImpl extends CSTNodeImpl implements DefaultValueCS {
	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected IdentifierCS identifier;

	/**
	 * The cached value of the '{@link #getInitialiser() <em>Initialiser</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialiser()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS initialiser;

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
		return QVTrCSTPackage.Literals.DEFAULT_VALUE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierCS getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifier(IdentifierCS newIdentifier, NotificationChain msgs) {
		IdentifierCS oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DEFAULT_VALUE_CS__IDENTIFIER, oldIdentifier, newIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(IdentifierCS newIdentifier) {
		if (newIdentifier != identifier) {
			NotificationChain msgs = null;
			if (identifier != null)
				msgs = ((InternalEObject)identifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.DEFAULT_VALUE_CS__IDENTIFIER, null, msgs);
			if (newIdentifier != null)
				msgs = ((InternalEObject)newIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.DEFAULT_VALUE_CS__IDENTIFIER, null, msgs);
			msgs = basicSetIdentifier(newIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DEFAULT_VALUE_CS__IDENTIFIER, newIdentifier, newIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getInitialiser() {
		return initialiser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialiser(OCLExpressionCS newInitialiser, NotificationChain msgs) {
		OCLExpressionCS oldInitialiser = initialiser;
		initialiser = newInitialiser;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DEFAULT_VALUE_CS__INITIALISER, oldInitialiser, newInitialiser);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialiser(OCLExpressionCS newInitialiser) {
		if (newInitialiser != initialiser) {
			NotificationChain msgs = null;
			if (initialiser != null)
				msgs = ((InternalEObject)initialiser).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.DEFAULT_VALUE_CS__INITIALISER, null, msgs);
			if (newInitialiser != null)
				msgs = ((InternalEObject)newInitialiser).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.DEFAULT_VALUE_CS__INITIALISER, null, msgs);
			msgs = basicSetInitialiser(newInitialiser, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DEFAULT_VALUE_CS__INITIALISER, newInitialiser, newInitialiser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrCSTPackage.DEFAULT_VALUE_CS__IDENTIFIER:
				return basicSetIdentifier(null, msgs);
			case QVTrCSTPackage.DEFAULT_VALUE_CS__INITIALISER:
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
			case QVTrCSTPackage.DEFAULT_VALUE_CS__IDENTIFIER:
				return getIdentifier();
			case QVTrCSTPackage.DEFAULT_VALUE_CS__INITIALISER:
				return getInitialiser();
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
			case QVTrCSTPackage.DEFAULT_VALUE_CS__IDENTIFIER:
				setIdentifier((IdentifierCS)newValue);
				return;
			case QVTrCSTPackage.DEFAULT_VALUE_CS__INITIALISER:
				setInitialiser((OCLExpressionCS)newValue);
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
			case QVTrCSTPackage.DEFAULT_VALUE_CS__IDENTIFIER:
				setIdentifier((IdentifierCS)null);
				return;
			case QVTrCSTPackage.DEFAULT_VALUE_CS__INITIALISER:
				setInitialiser((OCLExpressionCS)null);
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
			case QVTrCSTPackage.DEFAULT_VALUE_CS__IDENTIFIER:
				return identifier != null;
			case QVTrCSTPackage.DEFAULT_VALUE_CS__INITIALISER:
				return initialiser != null;
		}
		return super.eIsSet(featureID);
	}

} //DefaultValueCSImpl
