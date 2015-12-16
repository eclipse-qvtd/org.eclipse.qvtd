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
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.xtext.basecs.PathNameCS;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.qvtd.xtext.qvtcorebasecs.impl.DomainCSImpl;

import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeDomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;

import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imperative Domain CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.ImperativeDomainCSImpl#getCheckedProperties <em>Checked Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.ImperativeDomainCSImpl#getEnforcedProperties <em>Enforced Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImperativeDomainCSImpl extends DomainCSImpl implements ImperativeDomainCS {
	/**
	 * The cached value of the '{@link #getCheckedProperties() <em>Checked Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<PathNameCS> checkedProperties;

	/**
	 * The cached value of the '{@link #getEnforcedProperties() <em>Enforced Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnforcedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<PathNameCS> enforcedProperties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativeDomainCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.IMPERATIVE_DOMAIN_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PathNameCS> getCheckedProperties() {
		if (checkedProperties == null) {
			checkedProperties = new EObjectContainmentEList<PathNameCS>(PathNameCS.class, this, QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__CHECKED_PROPERTIES);
		}
		return checkedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PathNameCS> getEnforcedProperties() {
		if (enforcedProperties == null) {
			enforcedProperties = new EObjectContainmentEList<PathNameCS>(PathNameCS.class, this, QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__ENFORCED_PROPERTIES);
		}
		return enforcedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__CHECKED_PROPERTIES:
				return ((InternalEList<?>)getCheckedProperties()).basicRemove(otherEnd, msgs);
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__ENFORCED_PROPERTIES:
				return ((InternalEList<?>)getEnforcedProperties()).basicRemove(otherEnd, msgs);
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
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__CHECKED_PROPERTIES:
				return getCheckedProperties();
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__ENFORCED_PROPERTIES:
				return getEnforcedProperties();
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
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__CHECKED_PROPERTIES:
				getCheckedProperties().clear();
				getCheckedProperties().addAll((Collection<? extends PathNameCS>)newValue);
				return;
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__ENFORCED_PROPERTIES:
				getEnforcedProperties().clear();
				getEnforcedProperties().addAll((Collection<? extends PathNameCS>)newValue);
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
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__CHECKED_PROPERTIES:
				getCheckedProperties().clear();
				return;
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__ENFORCED_PROPERTIES:
				getEnforcedProperties().clear();
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
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__CHECKED_PROPERTIES:
				return checkedProperties != null && !checkedProperties.isEmpty();
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS__ENFORCED_PROPERTIES:
				return enforcedProperties != null && !enforcedProperties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitImperativeDomainCS(this);
	}

} //ImperativeDomainCSImpl
