/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example2.classes.impl;

import example2.classes.CallExp;
import example2.classes.ClassesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example2.classes.impl.CallExpImpl#getOwnedCallExp <em>Owned Call Exp</em>}</li>
 *   <li>{@link example2.classes.impl.CallExpImpl#getOwningSource <em>Owning Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CallExpImpl extends TypedElementImpl implements CallExp {
	/**
	 * The number of structural features of the '<em>Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALL_EXP_FEATURE_COUNT = TypedElementImpl.TYPED_ELEMENT_FEATURE_COUNT + 2;
	/**
	 * The number of operations of the '<em>Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALL_EXP_OPERATION_COUNT = TypedElementImpl.TYPED_ELEMENT_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getOwnedCallExp() <em>Owned Call Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCallExp()
	 * @generated
	 * @ordered
	 */
	protected CallExp ownedCallExp;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CallExp getOwnedCallExp() {
		return ownedCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedCallExp(CallExp newOwnedCallExp, NotificationChain msgs) {
		CallExp oldOwnedCallExp = ownedCallExp;
		ownedCallExp = newOwnedCallExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 1, oldOwnedCallExp, newOwnedCallExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedCallExp(CallExp newOwnedCallExp) {
		if (newOwnedCallExp != ownedCallExp) {
			NotificationChain msgs = null;
			if (ownedCallExp != null)
				msgs = ((InternalEObject)ownedCallExp).eInverseRemove(this, 2, CallExp.class, msgs);
			if (newOwnedCallExp != null)
				msgs = ((InternalEObject)newOwnedCallExp).eInverseAdd(this, 2, CallExp.class, msgs);
			msgs = basicSetOwnedCallExp(newOwnedCallExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 1, newOwnedCallExp, newOwnedCallExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CallExp getOwningSource() {
		if (eContainerFeatureID() != (2)) return null;
		return (CallExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningSource(CallExp newOwningSource, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningSource, 2, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningSource(CallExp newOwningSource) {
		if (newOwningSource != eInternalContainer() || (eContainerFeatureID() != (2) && newOwningSource != null)) {
			if (EcoreUtil.isAncestor(this, newOwningSource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningSource != null)
				msgs = ((InternalEObject)newOwningSource).eInverseAdd(this, 1, CallExp.class, msgs);
			msgs = basicSetOwningSource(newOwningSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, newOwningSource, newOwningSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 1:
				if (ownedCallExp != null)
					msgs = ((InternalEObject)ownedCallExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (1), null, msgs);
				return basicSetOwnedCallExp((CallExp)otherEnd, msgs);
			case 2:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningSource((CallExp)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 1:
				return basicSetOwnedCallExp(null, msgs);
			case 2:
				return basicSetOwningSource(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case 2:
				return eInternalContainer().eInverseRemove(this, 1, CallExp.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
				return getOwnedCallExp();
			case 2:
				return getOwningSource();
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
				setOwnedCallExp((CallExp)newValue);
				return;
			case 2:
				setOwningSource((CallExp)newValue);
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
				setOwnedCallExp((CallExp)null);
				return;
			case 2:
				setOwningSource((CallExp)null);
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
				return ownedCallExp != null;
			case 2:
				return getOwningSource() != null;
		}
		return super.eIsSet(featureID);
	}


} //CallExpImpl
