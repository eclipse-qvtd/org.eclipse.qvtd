/**
 * <copyright>
 *
 * Copyright (c) 2015, 2016 Willink Transformations and others.
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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Connection Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionAssignmentImpl#getConnectionVariable <em>Connection Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionAssignmentImpl#getOwnedInitValue <em>Owned Init Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionAssignmentImpl#getOwningMapping <em>Owning Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGConnectionAssignmentImpl extends CGValuedElementImpl implements CGConnectionAssignment {
	/**
	 * The cached value of the '{@link #getConnectionVariable() <em>Connection Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionVariable()
	 * @generated
	 * @ordered
	 */
	protected CGVariable connectionVariable;

	/**
	 * The cached value of the '{@link #getOwnedInitValue() <em>Owned Init Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInitValue()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement ownedInitValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGConnectionAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_CONNECTION_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGMapping getOwningMapping() {
		if (eContainerFeatureID() != QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING) return null;
		return (CGMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningMapping(CGMapping newOwningMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningMapping, QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningMapping(CGMapping newOwningMapping) {
		if (newOwningMapping != eInternalContainer() || (eContainerFeatureID() != QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING && newOwningMapping != null)) {
			if (EcoreUtil.isAncestor(this, newOwningMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningMapping != null)
				msgs = ((InternalEObject)newOwningMapping).eInverseAdd(this, QVTiCGModelPackage.CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS, CGMapping.class, msgs);
			msgs = basicSetOwningMapping(newOwningMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING, newOwningMapping, newOwningMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGVariable getConnectionVariable() {
		return connectionVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnectionVariable(CGVariable newConnectionVariable) {
		CGVariable oldConnectionVariable = connectionVariable;
		connectionVariable = newConnectionVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__CONNECTION_VARIABLE, oldConnectionVariable, connectionVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGValuedElement getOwnedInitValue() {
		return ownedInitValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedInitValue(CGValuedElement newOwnedInitValue, NotificationChain msgs) {
		CGValuedElement oldOwnedInitValue = ownedInitValue;
		ownedInitValue = newOwnedInitValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE, oldOwnedInitValue, newOwnedInitValue);
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
	public void setOwnedInitValue(CGValuedElement newOwnedInitValue) {
		if (newOwnedInitValue != ownedInitValue) {
			NotificationChain msgs = null;
			if (ownedInitValue != null)
				msgs = ((InternalEObject)ownedInitValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE, null, msgs);
			if (newOwnedInitValue != null)
				msgs = ((InternalEObject)newOwnedInitValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE, null, msgs);
			msgs = basicSetOwnedInitValue(newOwnedInitValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE, newOwnedInitValue, newOwnedInitValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningMapping((CGMapping)otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE:
				return basicSetOwnedInitValue(null, msgs);
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING:
				return basicSetOwningMapping(null, msgs);
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
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING:
				return eInternalContainer().eInverseRemove(this, QVTiCGModelPackage.CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS, CGMapping.class, msgs);
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
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__CONNECTION_VARIABLE:
				return getConnectionVariable();
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE:
				return getOwnedInitValue();
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING:
				return getOwningMapping();
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
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__CONNECTION_VARIABLE:
				setConnectionVariable((CGVariable)newValue);
				return;
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE:
				setOwnedInitValue((CGValuedElement)newValue);
				return;
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING:
				setOwningMapping((CGMapping)newValue);
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
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__CONNECTION_VARIABLE:
				setConnectionVariable((CGVariable)null);
				return;
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE:
				setOwnedInitValue((CGValuedElement)null);
				return;
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING:
				setOwningMapping((CGMapping)null);
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
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__CONNECTION_VARIABLE:
				return connectionVariable != null;
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE:
				return ownedInitValue != null;
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING:
				return getOwningMapping() != null;
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
		return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGConnectionAssignment(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable EClassifier getEcoreClassifier() {
		return ownedInitValue != null ? ownedInitValue.getEcoreClassifier() : null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isBoxed() {
		return (ownedInitValue != null) && ownedInitValue.isBoxed();
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
		return (ownedInitValue != null) && ownedInitValue.isEcore();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable Boolean isEquivalentToInternal(@NonNull CGValuedElement thatValue) {
		throw new UnsupportedOperationException(getClass().getName() + ".isEquivalentToInternal()");
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isGlobal() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isUnboxed() {
		return (ownedInitValue != null) && ownedInitValue.isUnboxed();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isUncommonable() {
		return true;
	}
} //CGConnectionAssignmentImpl
