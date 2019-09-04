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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGVariableImpl;

import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;

import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiEquivalenceUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Realized Variable Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariablePartImpl#getOwningRealizedVariable <em>Owning Realized Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariablePartImpl#getInit <em>Init</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariablePartImpl#getExecutorProperty <em>Executor Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGRealizedVariablePartImpl extends CGValuedElementImpl implements CGRealizedVariablePart {
	/**
	 * The number of structural features of the '<em>CG Realized Variable Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CG_REALIZED_VARIABLE_PART_FEATURE_COUNT = CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 3;


	/**
	 * The cached value of the '{@link #getInit() <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInit()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement init;

	/**
	 * The cached value of the '{@link #getExecutorProperty() <em>Executor Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutorProperty()
	 * @generated
	 * @ordered
	 */
	protected CGExecutorProperty executorProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGRealizedVariablePartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_REALIZED_VARIABLE_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGRealizedVariable getOwningRealizedVariable() {
		if (eContainerFeatureID() != (CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0)) return null;
		return (CGRealizedVariable)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRealizedVariable(CGRealizedVariable newOwningRealizedVariable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRealizedVariable, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRealizedVariable(CGRealizedVariable newOwningRealizedVariable) {
		if (newOwningRealizedVariable != eInternalContainer() || (eContainerFeatureID() != (CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0) && newOwningRealizedVariable != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRealizedVariable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRealizedVariable != null)
				msgs = ((InternalEObject)newOwningRealizedVariable).eInverseAdd(this, CGVariableImpl.CG_VARIABLE_FEATURE_COUNT + 3, CGRealizedVariable.class, msgs);
			msgs = basicSetOwningRealizedVariable(newOwningRealizedVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0, newOwningRealizedVariable, newOwningRealizedVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGValuedElement getInit() {
		return init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInit(CGValuedElement newInit, NotificationChain msgs) {
		CGValuedElement oldInit = init;
		init = newInit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1, oldInit, newInit);
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
	public void setInit(CGValuedElement newInit) {
		if (newInit != init) {
			NotificationChain msgs = null;
			if (init != null)
				msgs = ((InternalEObject)init).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1), null, msgs);
			if (newInit != null)
				msgs = ((InternalEObject)newInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1), null, msgs);
			msgs = basicSetInit(newInit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1, newInit, newInit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGExecutorProperty getExecutorProperty() {
		return executorProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExecutorProperty(CGExecutorProperty newExecutorProperty) {
		CGExecutorProperty oldExecutorProperty = executorProperty;
		executorProperty = newExecutorProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2, oldExecutorProperty, executorProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRealizedVariable((CGRealizedVariable)otherEnd, msgs);
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				return basicSetOwningRealizedVariable(null, msgs);
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				return basicSetInit(null, msgs);
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				return eInternalContainer().eInverseRemove(this, CGVariableImpl.CG_VARIABLE_FEATURE_COUNT + 3, CGRealizedVariable.class, msgs);
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				return getOwningRealizedVariable();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				return getInit();
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2:
				return getExecutorProperty();
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
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0:
				setOwningRealizedVariable((CGRealizedVariable)newValue);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				setInit((CGValuedElement)newValue);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2:
				setExecutorProperty((CGExecutorProperty)newValue);
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
				setOwningRealizedVariable((CGRealizedVariable)null);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				setInit((CGValuedElement)null);
				return;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2:
				setExecutorProperty((CGExecutorProperty)null);
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
				return getOwningRealizedVariable() != null;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1:
				return init != null;
			case CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2:
				return executorProperty != null;
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
			return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGRealizedVariablePart(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public @Nullable EClassifier getEcoreClassifier() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isBoxed() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isCommonable() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isConstant() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isEcore() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public @Nullable Boolean isEquivalentToInternal(@NonNull CGValuedElement thatValue) {
		return (getClass() == thatValue.getClass()) ? QVTiEquivalenceUtil.isEquivalent(this, (CGRealizedVariablePart)thatValue) : null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isGlobal() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isUnboxed() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	public boolean isUncommonable() {
		return true;
	}
} //CGRealizedVariablePartImpl
