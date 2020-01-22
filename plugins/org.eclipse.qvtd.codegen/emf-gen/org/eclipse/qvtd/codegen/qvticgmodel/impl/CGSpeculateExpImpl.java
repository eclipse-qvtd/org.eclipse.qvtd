/**
 * <copyright>
 *
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Speculate Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSpeculateExpImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSpeculateExpImpl#getSpeculated <em>Speculated</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGSpeculateExpImpl extends CGValuedElementImpl implements CGSpeculateExp {
	/**
	 * The number of structural features of the '<em>CG Speculate Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CG_SPECULATE_EXP_FEATURE_COUNT = CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<CGSpeculatePart> parts;

	/**
	 * The cached value of the '{@link #getSpeculated() <em>Speculated</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeculated()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement speculated;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGSpeculateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_SPECULATE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGSpeculatePart> getParts() {
		if (parts == null) {
			parts = new EObjectContainmentEList<CGSpeculatePart>(CGSpeculatePart.class, this, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGValuedElement getSpeculated() {
		return speculated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpeculated(CGValuedElement newSpeculated, NotificationChain msgs) {
		CGValuedElement oldSpeculated = speculated;
		speculated = newSpeculated;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1, oldSpeculated, newSpeculated);
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
	public void setSpeculated(CGValuedElement newSpeculated) {
		if (newSpeculated != speculated) {
			NotificationChain msgs = null;
			if (speculated != null)
				msgs = ((InternalEObject)speculated).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1), null, msgs);
			if (newSpeculated != null)
				msgs = ((InternalEObject)newSpeculated).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1), null, msgs);
			msgs = basicSetSpeculated(newSpeculated, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1, newSpeculated, newSpeculated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				return basicSetSpeculated(null, msgs);
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				return getParts();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				return getSpeculated();
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				getParts().clear();
				getParts().addAll((Collection<? extends CGSpeculatePart>)newValue);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				setSpeculated((CGValuedElement)newValue);
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				getParts().clear();
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				setSpeculated((CGValuedElement)null);
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				return parts != null && !parts.isEmpty();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				return speculated != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		if (visitor instanceof QVTiCGModelVisitor) {
			return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGSpeculateExp(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable EClassifier getEcoreClassifier() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isBoxed() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isCommonable() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isEcore() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable Boolean isEquivalentToInternal(@NonNull CGValuedElement thatValue) {
		if (this == thatValue) {
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isUnboxed() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isUncommonable() {
		return true;
	}

} //CGSpeculateExpImpl
