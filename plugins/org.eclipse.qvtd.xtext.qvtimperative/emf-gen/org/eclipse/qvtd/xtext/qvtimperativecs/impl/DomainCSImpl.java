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
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DomainCSImpl#isIsCheck <em>Is Check</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DomainCSImpl#isIsEnforce <em>Is Enforce</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DomainCSImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DomainCSImpl#getCheckedProperties <em>Checked Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DomainCSImpl#getOwnedGuardVariables <em>Owned Guard Variables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainCSImpl extends NamedElementCSImpl implements DomainCS {
	/**
	 * The default value of the '{@link #isIsCheck() <em>Is Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheck()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CHECK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCheck() <em>Is Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheck()
	 * @generated
	 * @ordered
	 */
	protected boolean isCheck = IS_CHECK_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsEnforce() <em>Is Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforce()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEnforce() <em>Is Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforce()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforce = IS_ENFORCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected TypedModel direction;

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
	 * The cached value of the '{@link #getOwnedGuardVariables() <em>Owned Guard Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedGuardVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<GuardVariableCS> ownedGuardVariables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.DOMAIN_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsCheck() {
		return isCheck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsCheck(boolean newIsCheck) {
		boolean oldIsCheck = isCheck;
		isCheck = newIsCheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.DOMAIN_CS__IS_CHECK, oldIsCheck, isCheck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsEnforce() {
		return isEnforce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsEnforce(boolean newIsEnforce) {
		boolean oldIsEnforce = isEnforce;
		isEnforce = newIsEnforce;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.DOMAIN_CS__IS_ENFORCE, oldIsEnforce, isEnforce));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getDirection() {
		if (direction != null && direction.eIsProxy()) {
			InternalEObject oldDirection = (InternalEObject)direction;
			direction = (TypedModel)eResolveProxy(oldDirection);
			if (direction != oldDirection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativeCSPackage.DOMAIN_CS__DIRECTION, oldDirection, direction));
			}
		}
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDirection(TypedModel newDirection) {
		TypedModel oldDirection = direction;
		direction = newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.DOMAIN_CS__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PathNameCS> getCheckedProperties() {
		if (checkedProperties == null) {
			checkedProperties = new EObjectContainmentEList<PathNameCS>(PathNameCS.class, this, QVTimperativeCSPackage.DOMAIN_CS__CHECKED_PROPERTIES);
		}
		return checkedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GuardVariableCS> getOwnedGuardVariables() {
		if (ownedGuardVariables == null) {
			ownedGuardVariables = new EObjectContainmentEList<GuardVariableCS>(GuardVariableCS.class, this, QVTimperativeCSPackage.DOMAIN_CS__OWNED_GUARD_VARIABLES);
		}
		return ownedGuardVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativeCSPackage.DOMAIN_CS__CHECKED_PROPERTIES:
				return ((InternalEList<?>)getCheckedProperties()).basicRemove(otherEnd, msgs);
			case QVTimperativeCSPackage.DOMAIN_CS__OWNED_GUARD_VARIABLES:
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
			case QVTimperativeCSPackage.DOMAIN_CS__IS_CHECK:
				return isIsCheck();
			case QVTimperativeCSPackage.DOMAIN_CS__IS_ENFORCE:
				return isIsEnforce();
			case QVTimperativeCSPackage.DOMAIN_CS__DIRECTION:
				if (resolve) return getDirection();
				return basicGetDirection();
			case QVTimperativeCSPackage.DOMAIN_CS__CHECKED_PROPERTIES:
				return getCheckedProperties();
			case QVTimperativeCSPackage.DOMAIN_CS__OWNED_GUARD_VARIABLES:
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
			case QVTimperativeCSPackage.DOMAIN_CS__IS_CHECK:
				setIsCheck((Boolean)newValue);
				return;
			case QVTimperativeCSPackage.DOMAIN_CS__IS_ENFORCE:
				setIsEnforce((Boolean)newValue);
				return;
			case QVTimperativeCSPackage.DOMAIN_CS__DIRECTION:
				setDirection((TypedModel)newValue);
				return;
			case QVTimperativeCSPackage.DOMAIN_CS__CHECKED_PROPERTIES:
				getCheckedProperties().clear();
				getCheckedProperties().addAll((Collection<? extends PathNameCS>)newValue);
				return;
			case QVTimperativeCSPackage.DOMAIN_CS__OWNED_GUARD_VARIABLES:
				getOwnedGuardVariables().clear();
				getOwnedGuardVariables().addAll((Collection<? extends GuardVariableCS>)newValue);
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
			case QVTimperativeCSPackage.DOMAIN_CS__IS_CHECK:
				setIsCheck(IS_CHECK_EDEFAULT);
				return;
			case QVTimperativeCSPackage.DOMAIN_CS__IS_ENFORCE:
				setIsEnforce(IS_ENFORCE_EDEFAULT);
				return;
			case QVTimperativeCSPackage.DOMAIN_CS__DIRECTION:
				setDirection((TypedModel)null);
				return;
			case QVTimperativeCSPackage.DOMAIN_CS__CHECKED_PROPERTIES:
				getCheckedProperties().clear();
				return;
			case QVTimperativeCSPackage.DOMAIN_CS__OWNED_GUARD_VARIABLES:
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
			case QVTimperativeCSPackage.DOMAIN_CS__IS_CHECK:
				return isCheck != IS_CHECK_EDEFAULT;
			case QVTimperativeCSPackage.DOMAIN_CS__IS_ENFORCE:
				return isEnforce != IS_ENFORCE_EDEFAULT;
			case QVTimperativeCSPackage.DOMAIN_CS__DIRECTION:
				return direction != null;
			case QVTimperativeCSPackage.DOMAIN_CS__CHECKED_PROPERTIES:
				return checkedProperties != null && !checkedProperties.isEmpty();
			case QVTimperativeCSPackage.DOMAIN_CS__OWNED_GUARD_VARIABLES:
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
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitDomainCS(this);
	}

} //DomainCSImpl
