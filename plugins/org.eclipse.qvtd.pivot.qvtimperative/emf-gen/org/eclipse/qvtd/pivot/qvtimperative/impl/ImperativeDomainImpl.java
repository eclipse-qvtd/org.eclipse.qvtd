/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl;
import org.eclipse.qvtd.pivot.qvtimperative.GuardVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeDomainImpl#getCheckedProperties <em>Checked Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeDomainImpl#getOwnedGuardVariables <em>Owned Guard Variables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImperativeDomainImpl extends DomainImpl implements ImperativeDomain {
	/**
	 * The cached value of the '{@link #getCheckedProperties() <em>Checked Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> checkedProperties;

	/**
	 * The cached value of the '{@link #getOwnedGuardVariables() <em>Owned Guard Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedGuardVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<GuardVariable> ownedGuardVariables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativeDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.IMPERATIVE_DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getCheckedProperties() {
		if (checkedProperties == null) {
			checkedProperties = new EObjectResolvingEList<Property>(Property.class, this, QVTimperativePackage.IMPERATIVE_DOMAIN__CHECKED_PROPERTIES);
		}
		return checkedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GuardVariable> getOwnedGuardVariables() {
		if (ownedGuardVariables == null) {
			ownedGuardVariables = new EObjectContainmentEList<GuardVariable>(GuardVariable.class, this, QVTimperativePackage.IMPERATIVE_DOMAIN__OWNED_GUARD_VARIABLES);
		}
		return ownedGuardVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.IMPERATIVE_DOMAIN__OWNED_GUARD_VARIABLES:
				return ((InternalEList<?>)getOwnedGuardVariables()).basicRemove(otherEnd, msgs);
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
			case QVTimperativePackage.IMPERATIVE_DOMAIN__CHECKED_PROPERTIES:
				return getCheckedProperties();
			case QVTimperativePackage.IMPERATIVE_DOMAIN__OWNED_GUARD_VARIABLES:
				return getOwnedGuardVariables();
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
			case QVTimperativePackage.IMPERATIVE_DOMAIN__CHECKED_PROPERTIES:
				getCheckedProperties().clear();
				getCheckedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case QVTimperativePackage.IMPERATIVE_DOMAIN__OWNED_GUARD_VARIABLES:
				getOwnedGuardVariables().clear();
				getOwnedGuardVariables().addAll((Collection<? extends GuardVariable>)newValue);
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
			case QVTimperativePackage.IMPERATIVE_DOMAIN__CHECKED_PROPERTIES:
				getCheckedProperties().clear();
				return;
			case QVTimperativePackage.IMPERATIVE_DOMAIN__OWNED_GUARD_VARIABLES:
				getOwnedGuardVariables().clear();
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
			case QVTimperativePackage.IMPERATIVE_DOMAIN__CHECKED_PROPERTIES:
				return checkedProperties != null && !checkedProperties.isEmpty();
			case QVTimperativePackage.IMPERATIVE_DOMAIN__OWNED_GUARD_VARIABLES:
				return ownedGuardVariables != null && !ownedGuardVariables.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTimperativeVisitor<?>)visitor).visitImperativeDomain(this);
	}

} //CoreDomainImpl
