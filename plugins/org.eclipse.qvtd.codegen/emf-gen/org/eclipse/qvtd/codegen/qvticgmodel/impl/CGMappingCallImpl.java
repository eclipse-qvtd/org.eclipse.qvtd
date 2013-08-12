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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Mapping Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallImpl#getMappingExp <em>Mapping Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallImpl#getMappingCallBindings <em>Mapping Call Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGMappingCallImpl extends CGValuedElementImpl implements CGMappingCall {
	/**
	 * The cached value of the '{@link #getMappingCallBindings() <em>Mapping Call Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingCallBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<CGMappingCallBinding> mappingCallBindings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGMappingCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_MAPPING_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGMappingExp getMappingExp() {
		if (eContainerFeatureID() != QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP) return null;
		return (CGMappingExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingExp(CGMappingExp newMappingExp, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappingExp, QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingExp(CGMappingExp newMappingExp) {
		if (newMappingExp != eInternalContainer() || (eContainerFeatureID() != QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP && newMappingExp != null)) {
			if (EcoreUtil.isAncestor(this, newMappingExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappingExp != null)
				msgs = ((InternalEObject)newMappingExp).eInverseAdd(this, QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING_CALLS, CGMappingExp.class, msgs);
			msgs = basicSetMappingExp(newMappingExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP, newMappingExp, newMappingExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGMappingCallBinding> getMappingCallBindings() {
		if (mappingCallBindings == null) {
			mappingCallBindings = new EObjectContainmentEList<CGMappingCallBinding>(CGMappingCallBinding.class, this, QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_CALL_BINDINGS);
		}
		return mappingCallBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappingExp((CGMappingExp)otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP:
				return basicSetMappingExp(null, msgs);
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_CALL_BINDINGS:
				return ((InternalEList<?>)getMappingCallBindings()).basicRemove(otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP:
				return eInternalContainer().eInverseRemove(this, QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING_CALLS, CGMappingExp.class, msgs);
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
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP:
				return getMappingExp();
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_CALL_BINDINGS:
				return getMappingCallBindings();
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
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP:
				setMappingExp((CGMappingExp)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_CALL_BINDINGS:
				getMappingCallBindings().clear();
				getMappingCallBindings().addAll((Collection<? extends CGMappingCallBinding>)newValue);
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
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP:
				setMappingExp((CGMappingExp)null);
				return;
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_CALL_BINDINGS:
				getMappingCallBindings().clear();
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
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP:
				return getMappingExp() != null;
			case QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_CALL_BINDINGS:
				return mappingCallBindings != null && !mappingCallBindings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGMappingCall(this);
	}

} //CGMappingCallImpl
