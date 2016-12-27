/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package delphi.impl;

import delphi.DelphiPackage;
import delphi.arrayConstant;
import delphi.typedConstant;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>array Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.arrayConstantImpl#getTypedConstant <em>Typed Constant</em>}</li>
 * </ul>
 *
 * @generated
 */
public class arrayConstantImpl extends CSTraceImpl implements arrayConstant {
	/**
	 * The cached value of the '{@link #getTypedConstant() <em>Typed Constant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedConstant()
	 * @generated
	 * @ordered
	 */
	protected typedConstant typedConstant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected arrayConstantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.ARRAY_CONSTANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public typedConstant getTypedConstant() {
		return typedConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypedConstant(typedConstant newTypedConstant, NotificationChain msgs) {
		typedConstant oldTypedConstant = typedConstant;
		typedConstant = newTypedConstant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.ARRAY_CONSTANT__TYPED_CONSTANT, oldTypedConstant, newTypedConstant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedConstant(typedConstant newTypedConstant) {
		if (newTypedConstant != typedConstant) {
			NotificationChain msgs = null;
			if (typedConstant != null)
				msgs = ((InternalEObject)typedConstant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.ARRAY_CONSTANT__TYPED_CONSTANT, null, msgs);
			if (newTypedConstant != null)
				msgs = ((InternalEObject)newTypedConstant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.ARRAY_CONSTANT__TYPED_CONSTANT, null, msgs);
			msgs = basicSetTypedConstant(newTypedConstant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.ARRAY_CONSTANT__TYPED_CONSTANT, newTypedConstant, newTypedConstant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.ARRAY_CONSTANT__TYPED_CONSTANT:
				return basicSetTypedConstant(null, msgs);
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
			case DelphiPackage.ARRAY_CONSTANT__TYPED_CONSTANT:
				return getTypedConstant();
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
			case DelphiPackage.ARRAY_CONSTANT__TYPED_CONSTANT:
				setTypedConstant((typedConstant)newValue);
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
			case DelphiPackage.ARRAY_CONSTANT__TYPED_CONSTANT:
				setTypedConstant((typedConstant)null);
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
			case DelphiPackage.ARRAY_CONSTANT__TYPED_CONSTANT:
				return typedConstant != null;
		}
		return super.eIsSet(featureID);
	}


} //arrayConstantImpl
