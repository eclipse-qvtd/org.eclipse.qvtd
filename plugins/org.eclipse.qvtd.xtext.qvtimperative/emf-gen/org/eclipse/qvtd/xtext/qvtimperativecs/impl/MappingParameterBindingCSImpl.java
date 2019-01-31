/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Parameter Binding CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingParameterBindingCSImpl#getOwningMappingCall <em>Owning Mapping Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingParameterBindingCSImpl extends ExpCSImpl implements MappingParameterBindingCS {
	/**
	 * The number of structural features of the '<em>Mapping Parameter Binding CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_PARAMETER_BINDING_CS_FEATURE_COUNT = ExpCSImpl.EXP_CS_FEATURE_COUNT + 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingParameterBindingCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.MAPPING_PARAMETER_BINDING_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingCallCS getOwningMappingCall() {
		if (eContainerFeatureID() != (ExpCSImpl.EXP_CS_FEATURE_COUNT + 0)) return null;
		return (MappingCallCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningMappingCall(MappingCallCS newOwningMappingCall, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningMappingCall, ExpCSImpl.EXP_CS_FEATURE_COUNT + 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningMappingCall(MappingCallCS newOwningMappingCall) {
		if (newOwningMappingCall != eInternalContainer() || (eContainerFeatureID() != (ExpCSImpl.EXP_CS_FEATURE_COUNT + 0) && newOwningMappingCall != null)) {
			if (EcoreUtil.isAncestor(this, newOwningMappingCall))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningMappingCall != null)
				msgs = ((InternalEObject)newOwningMappingCall).eInverseAdd(this, MappingStatementCSImpl.MAPPING_STATEMENT_CS_FEATURE_COUNT + 2, MappingCallCS.class, msgs);
			msgs = basicSetOwningMappingCall(newOwningMappingCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 0, newOwningMappingCall, newOwningMappingCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningMappingCall((MappingCallCS)otherEnd, msgs);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				return basicSetOwningMappingCall(null, msgs);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				return eInternalContainer().eInverseRemove(this, MappingStatementCSImpl.MAPPING_STATEMENT_CS_FEATURE_COUNT + 2, MappingCallCS.class, msgs);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				return getOwningMappingCall();
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				setOwningMappingCall((MappingCallCS)newValue);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				setOwningMappingCall((MappingCallCS)null);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				return getOwningMappingCall() != null;
		}
		return super.eIsSet(featureID);
	}


} //MappingParameterBindingCSImpl
