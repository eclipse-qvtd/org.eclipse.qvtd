/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Mapping Call Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl#getValueOrValues <em>Value Or Values</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl#isLoop <em>Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGMappingCallBindingImpl extends CGValuedElementImpl implements CGMappingCallBinding {
	/**
	 * The cached value of the '{@link #getValueOrValues() <em>Value Or Values</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueOrValues()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement valueOrValues;

	/**
	 * The default value of the '{@link #isLoop() <em>Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOOP_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isLoop() <em>Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoop()
	 * @generated
	 * @ordered
	 */
	protected boolean loop = LOOP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGMappingCallBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_MAPPING_CALL_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGValuedElement getValueOrValues() {
		return valueOrValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueOrValues(CGValuedElement newValueOrValues, NotificationChain msgs) {
		CGValuedElement oldValueOrValues = valueOrValues;
		valueOrValues = newValueOrValues;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__VALUE_OR_VALUES, oldValueOrValues, newValueOrValues);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueOrValues(CGValuedElement newValueOrValues) {
		if (newValueOrValues != valueOrValues) {
			NotificationChain msgs = null;
			if (valueOrValues != null)
				msgs = ((InternalEObject)valueOrValues).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__VALUE_OR_VALUES, null, msgs);
			if (newValueOrValues != null)
				msgs = ((InternalEObject)newValueOrValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__VALUE_OR_VALUES, null, msgs);
			msgs = basicSetValueOrValues(newValueOrValues, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__VALUE_OR_VALUES, newValueOrValues, newValueOrValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLoop() {
		return loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoop(boolean newLoop) {
		boolean oldLoop = loop;
		loop = newLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__LOOP, oldLoop, loop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__VALUE_OR_VALUES:
				return basicSetValueOrValues(null, msgs);
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
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__VALUE_OR_VALUES:
				return getValueOrValues();
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__LOOP:
				return isLoop();
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
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__VALUE_OR_VALUES:
				setValueOrValues((CGValuedElement)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__LOOP:
				setLoop((Boolean)newValue);
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
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__VALUE_OR_VALUES:
				setValueOrValues((CGValuedElement)null);
				return;
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__LOOP:
				setLoop(LOOP_EDEFAULT);
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
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__VALUE_OR_VALUES:
				return valueOrValues != null;
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING__LOOP:
				return loop != LOOP_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return ((QVTiCGModelVisitor<R>)visitor).visitCGMappingCallBinding(this);
	}

	@Override
	public @NonNull CGValuedElement getReferredValuedElement() {
		return valueOrValues != null ? valueOrValues : this;
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //CGMappingCallBindingImpl
