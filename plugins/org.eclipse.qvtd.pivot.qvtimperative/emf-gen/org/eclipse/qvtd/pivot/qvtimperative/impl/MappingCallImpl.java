/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl#isIsInstall <em>Is Install</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl#isIsInvoke <em>Is Invoke</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl#getReferredMapping <em>Referred Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingCallImpl extends MappingStatementImpl implements MappingCall {
	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingParameterBinding> binding;

	/**
	 * The default value of the '{@link #isIsInstall() <em>Is Install</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInstall()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INSTALL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInstall() <em>Is Install</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInstall()
	 * @generated
	 * @ordered
	 */
	protected boolean isInstall = IS_INSTALL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsInvoke() <em>Is Invoke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInvoke()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INVOKE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInvoke() <em>Is Invoke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInvoke()
	 * @generated
	 * @ordered
	 */
	protected boolean isInvoke = IS_INVOKE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredMapping() <em>Referred Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredMapping()
	 * @generated
	 * @ordered
	 */
	protected Mapping referredMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.MAPPING_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mapping getReferredMapping() {
		if (referredMapping != null && referredMapping.eIsProxy()) {
			InternalEObject oldReferredMapping = (InternalEObject)referredMapping;
			referredMapping = (Mapping)eResolveProxy(oldReferredMapping);
			if (referredMapping != oldReferredMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.MAPPING_CALL__REFERRED_MAPPING, oldReferredMapping, referredMapping));
			}
		}
		return referredMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping basicGetReferredMapping() {
		return referredMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredMapping(Mapping newReferredMapping) {
		Mapping oldReferredMapping = referredMapping;
		referredMapping = newReferredMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_CALL__REFERRED_MAPPING, oldReferredMapping, referredMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingParameterBinding> getBinding() {
		if (binding == null) {
			binding = new EObjectContainmentWithInverseEList<MappingParameterBinding>(MappingParameterBinding.class, this, QVTimperativePackage.MAPPING_CALL__BINDING, QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL);
		}
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsInstall() {
		return isInstall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsInstall(boolean newIsInstall) {
		boolean oldIsInstall = isInstall;
		isInstall = newIsInstall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_CALL__IS_INSTALL, oldIsInstall, isInstall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsInvoke() {
		return isInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsInvoke(boolean newIsInvoke) {
		boolean oldIsInvoke = isInvoke;
		isInvoke = newIsInvoke;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_CALL__IS_INVOKE, oldIsInvoke, isInvoke));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.MAPPING_CALL__BINDING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBinding()).basicAdd(otherEnd, msgs);
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
			case QVTimperativePackage.MAPPING_CALL__BINDING:
				return ((InternalEList<?>)getBinding()).basicRemove(otherEnd, msgs);
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
			case QVTimperativePackage.MAPPING_CALL__BINDING:
				return getBinding();
			case QVTimperativePackage.MAPPING_CALL__IS_INSTALL:
				return isIsInstall();
			case QVTimperativePackage.MAPPING_CALL__IS_INVOKE:
				return isIsInvoke();
			case QVTimperativePackage.MAPPING_CALL__REFERRED_MAPPING:
				if (resolve) return getReferredMapping();
				return basicGetReferredMapping();
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
			case QVTimperativePackage.MAPPING_CALL__BINDING:
				getBinding().clear();
				getBinding().addAll((Collection<? extends MappingParameterBinding>)newValue);
				return;
			case QVTimperativePackage.MAPPING_CALL__IS_INSTALL:
				setIsInstall((Boolean)newValue);
				return;
			case QVTimperativePackage.MAPPING_CALL__IS_INVOKE:
				setIsInvoke((Boolean)newValue);
				return;
			case QVTimperativePackage.MAPPING_CALL__REFERRED_MAPPING:
				setReferredMapping((Mapping)newValue);
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
			case QVTimperativePackage.MAPPING_CALL__BINDING:
				getBinding().clear();
				return;
			case QVTimperativePackage.MAPPING_CALL__IS_INSTALL:
				setIsInstall(IS_INSTALL_EDEFAULT);
				return;
			case QVTimperativePackage.MAPPING_CALL__IS_INVOKE:
				setIsInvoke(IS_INVOKE_EDEFAULT);
				return;
			case QVTimperativePackage.MAPPING_CALL__REFERRED_MAPPING:
				setReferredMapping((Mapping)null);
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
			case QVTimperativePackage.MAPPING_CALL__BINDING:
				return binding != null && !binding.isEmpty();
			case QVTimperativePackage.MAPPING_CALL__IS_INSTALL:
				return isInstall != IS_INSTALL_EDEFAULT;
			case QVTimperativePackage.MAPPING_CALL__IS_INVOKE:
				return isInvoke != IS_INVOKE_EDEFAULT;
			case QVTimperativePackage.MAPPING_CALL__REFERRED_MAPPING:
				return referredMapping != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ReferringElement.class) {
			switch (baseOperationID) {
				case PivotPackage.REFERRING_ELEMENT___GET_REFERRED_ELEMENT: return QVTimperativePackage.MAPPING_CALL___GET_REFERRED_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case QVTimperativePackage.MAPPING_CALL___GET_REFERRED_ELEMENT:
				return getReferredElement();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTimperativeVisitor<?>)visitor).visitMappingCall(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Element getReferredElement() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}
} //MappingCallImpl
