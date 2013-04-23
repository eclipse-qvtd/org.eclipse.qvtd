/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.qvtd.xtext.qvtimperativecst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpCSImpl;
import org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecst.QVTimperativeCSTPackage;
import org.eclipse.qvtd.xtext.qvtimperativecst.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Call Binding CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecst.impl.MappingCallBindingCSImpl#getMappingCall <em>Mapping Call</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecst.impl.MappingCallBindingCSImpl#getReferredVariable <em>Referred Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecst.impl.MappingCallBindingCSImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecst.impl.MappingCallBindingCSImpl#isIsLoop <em>Is Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingCallBindingCSImpl extends ExpCSImpl implements MappingCallBindingCS {
	/**
	 * The cached value of the '{@link #getReferredVariable() <em>Referred Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable referredVariable;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected ExpCS value;

	/**
	 * The default value of the '{@link #isIsLoop() <em>Is Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLoop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LOOP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsLoop() <em>Is Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLoop()
	 * @generated
	 * @ordered
	 */
	protected boolean isLoop = IS_LOOP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingCallBindingCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSTPackage.Literals.MAPPING_CALL_BINDING_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingCallCS getMappingCall() {
		if (eContainerFeatureID() != QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__MAPPING_CALL) return null;
		return (MappingCallCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingCall(MappingCallCS newMappingCall, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappingCall, QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__MAPPING_CALL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingCall(MappingCallCS newMappingCall) {
		if (newMappingCall != eInternalContainer() || (eContainerFeatureID() != QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__MAPPING_CALL && newMappingCall != null)) {
			if (EcoreUtil.isAncestor(this, newMappingCall))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappingCall != null)
				msgs = ((InternalEObject)newMappingCall).eInverseAdd(this, QVTimperativeCSTPackage.MAPPING_CALL_CS__BINDINGS, MappingCallCS.class, msgs);
			msgs = basicSetMappingCall(newMappingCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__MAPPING_CALL, newMappingCall, newMappingCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getReferredVariable() {
		if (referredVariable != null && ((EObject)referredVariable).eIsProxy()) {
			InternalEObject oldReferredVariable = (InternalEObject)referredVariable;
			referredVariable = (Variable)eResolveProxy(oldReferredVariable);
			if (referredVariable != oldReferredVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE, oldReferredVariable, referredVariable));
			}
		}
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetReferredVariable() {
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredVariable(Variable newReferredVariable) {
		Variable oldReferredVariable = referredVariable;
		referredVariable = newReferredVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE, oldReferredVariable, referredVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(ExpCS newValue, NotificationChain msgs) {
		ExpCS oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(ExpCS newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsLoop() {
		return isLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsLoop(boolean newIsLoop) {
		boolean oldIsLoop = isLoop;
		isLoop = newIsLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__IS_LOOP, oldIsLoop, isLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__MAPPING_CALL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappingCall((MappingCallCS)otherEnd, msgs);
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
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__MAPPING_CALL:
				return basicSetMappingCall(null, msgs);
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__VALUE:
				return basicSetValue(null, msgs);
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
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__MAPPING_CALL:
				return eInternalContainer().eInverseRemove(this, QVTimperativeCSTPackage.MAPPING_CALL_CS__BINDINGS, MappingCallCS.class, msgs);
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
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__MAPPING_CALL:
				return getMappingCall();
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE:
				if (resolve) return getReferredVariable();
				return basicGetReferredVariable();
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__VALUE:
				return getValue();
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__IS_LOOP:
				return isIsLoop();
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
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__MAPPING_CALL:
				setMappingCall((MappingCallCS)newValue);
				return;
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE:
				setReferredVariable((Variable)newValue);
				return;
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__VALUE:
				setValue((ExpCS)newValue);
				return;
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__IS_LOOP:
				setIsLoop((Boolean)newValue);
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
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__MAPPING_CALL:
				setMappingCall((MappingCallCS)null);
				return;
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE:
				setReferredVariable((Variable)null);
				return;
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__VALUE:
				setValue((ExpCS)null);
				return;
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__IS_LOOP:
				setIsLoop(IS_LOOP_EDEFAULT);
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
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__MAPPING_CALL:
				return getMappingCall() != null;
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE:
				return referredVariable != null;
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__VALUE:
				return value != null;
			case QVTimperativeCSTPackage.MAPPING_CALL_BINDING_CS__IS_LOOP:
				return isLoop != IS_LOOP_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return ((QVTimperativeCSVisitor<R>)visitor).visitMappingCallBindingCS(this);
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //MappingCallBindingCSImpl
