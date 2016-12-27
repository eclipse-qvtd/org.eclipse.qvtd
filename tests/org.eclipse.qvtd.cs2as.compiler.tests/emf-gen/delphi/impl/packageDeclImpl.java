/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package delphi.impl;

import delphi.DelphiPackage;
import delphi.containsClause;
import delphi.packageDecl;
import delphi.requiresClause;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>package Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.packageDeclImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link delphi.impl.packageDeclImpl#getContains <em>Contains</em>}</li>
 * </ul>
 *
 * @generated
 */
public class packageDeclImpl extends fileImpl implements packageDecl {
	/**
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected requiresClause requires;

	/**
	 * The cached value of the '{@link #getContains() <em>Contains</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContains()
	 * @generated
	 * @ordered
	 */
	protected containsClause contains;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected packageDeclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.PACKAGE_DECL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public requiresClause getRequires() {
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequires(requiresClause newRequires, NotificationChain msgs) {
		requiresClause oldRequires = requires;
		requires = newRequires;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PACKAGE_DECL__REQUIRES, oldRequires, newRequires);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequires(requiresClause newRequires) {
		if (newRequires != requires) {
			NotificationChain msgs = null;
			if (requires != null)
				msgs = ((InternalEObject)requires).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PACKAGE_DECL__REQUIRES, null, msgs);
			if (newRequires != null)
				msgs = ((InternalEObject)newRequires).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PACKAGE_DECL__REQUIRES, null, msgs);
			msgs = basicSetRequires(newRequires, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PACKAGE_DECL__REQUIRES, newRequires, newRequires));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public containsClause getContains() {
		return contains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContains(containsClause newContains, NotificationChain msgs) {
		containsClause oldContains = contains;
		contains = newContains;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PACKAGE_DECL__CONTAINS, oldContains, newContains);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContains(containsClause newContains) {
		if (newContains != contains) {
			NotificationChain msgs = null;
			if (contains != null)
				msgs = ((InternalEObject)contains).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PACKAGE_DECL__CONTAINS, null, msgs);
			if (newContains != null)
				msgs = ((InternalEObject)newContains).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PACKAGE_DECL__CONTAINS, null, msgs);
			msgs = basicSetContains(newContains, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PACKAGE_DECL__CONTAINS, newContains, newContains));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.PACKAGE_DECL__REQUIRES:
				return basicSetRequires(null, msgs);
			case DelphiPackage.PACKAGE_DECL__CONTAINS:
				return basicSetContains(null, msgs);
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
			case DelphiPackage.PACKAGE_DECL__REQUIRES:
				return getRequires();
			case DelphiPackage.PACKAGE_DECL__CONTAINS:
				return getContains();
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
			case DelphiPackage.PACKAGE_DECL__REQUIRES:
				setRequires((requiresClause)newValue);
				return;
			case DelphiPackage.PACKAGE_DECL__CONTAINS:
				setContains((containsClause)newValue);
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
			case DelphiPackage.PACKAGE_DECL__REQUIRES:
				setRequires((requiresClause)null);
				return;
			case DelphiPackage.PACKAGE_DECL__CONTAINS:
				setContains((containsClause)null);
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
			case DelphiPackage.PACKAGE_DECL__REQUIRES:
				return requires != null;
			case DelphiPackage.PACKAGE_DECL__CONTAINS:
				return contains != null;
		}
		return super.eIsSet(featureID);
	}


} //packageDeclImpl
