/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.FromAttribute;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.FromAttributeOwner;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>From Attribute Owner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.impl.FromAttributeOwnerImpl#getFromAttributes <em>From Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FromAttributeOwnerImpl extends MinimalEObjectImpl.Container implements FromAttributeOwner {
	/**
	 * The number of structural features of the '<em>From Attribute Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FROM_ATTRIBUTE_OWNER_FEATURE_COUNT = 1;
	/**
	 * The number of operations of the '<em>From Attribute Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FROM_ATTRIBUTE_OWNER_OPERATION_COUNT = 0;
	/**
	 * The cached value of the '{@link #getFromAttributes() <em>From Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<FromAttribute> fromAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FromAttributeOwnerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Simpleuml2rdbmsPackage.Literals.FROM_ATTRIBUTE_OWNER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FromAttribute> getFromAttributes() {
		if (fromAttributes == null) {
			fromAttributes = new EObjectContainmentWithInverseEList<FromAttribute>(FromAttribute.class, this, 0, 4);
		}
		return fromAttributes;
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
			case 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFromAttributes()).basicAdd(otherEnd, msgs);
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
			case 0:
				return ((InternalEList<?>)getFromAttributes()).basicRemove(otherEnd, msgs);
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
			case 0:
				return getFromAttributes();
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
			case 0:
				getFromAttributes().clear();
				getFromAttributes().addAll((Collection<? extends FromAttribute>)newValue);
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
			case 0:
				getFromAttributes().clear();
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
			case 0:
				return fromAttributes != null && !fromAttributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //FromAttributeOwnerImpl
