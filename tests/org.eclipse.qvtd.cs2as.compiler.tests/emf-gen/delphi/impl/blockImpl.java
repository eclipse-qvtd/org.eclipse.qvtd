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
import delphi.block;
import delphi.compoundStmt;
import delphi.declSection;
import delphi.exportsStmt;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.blockImpl#getDeclSect <em>Decl Sect</em>}</li>
 *   <li>{@link delphi.impl.blockImpl#getExports <em>Exports</em>}</li>
 *   <li>{@link delphi.impl.blockImpl#getCompound <em>Compound</em>}</li>
 * </ul>
 *
 * @generated
 */
public class blockImpl extends CSTraceImpl implements block {
	/**
	 * The cached value of the '{@link #getDeclSect() <em>Decl Sect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclSect()
	 * @generated
	 * @ordered
	 */
	protected declSection declSect;

	/**
	 * The cached value of the '{@link #getExports() <em>Exports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExports()
	 * @generated
	 * @ordered
	 */
	protected EList<exportsStmt> exports;

	/**
	 * The cached value of the '{@link #getCompound() <em>Compound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompound()
	 * @generated
	 * @ordered
	 */
	protected compoundStmt compound;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected blockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public declSection getDeclSect() {
		return declSect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclSect(declSection newDeclSect, NotificationChain msgs) {
		declSection oldDeclSect = declSect;
		declSect = newDeclSect;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.BLOCK__DECL_SECT, oldDeclSect, newDeclSect);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclSect(declSection newDeclSect) {
		if (newDeclSect != declSect) {
			NotificationChain msgs = null;
			if (declSect != null)
				msgs = ((InternalEObject)declSect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.BLOCK__DECL_SECT, null, msgs);
			if (newDeclSect != null)
				msgs = ((InternalEObject)newDeclSect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.BLOCK__DECL_SECT, null, msgs);
			msgs = basicSetDeclSect(newDeclSect, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.BLOCK__DECL_SECT, newDeclSect, newDeclSect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<exportsStmt> getExports() {
		if (exports == null) {
			exports = new EObjectContainmentEList<exportsStmt>(exportsStmt.class, this, DelphiPackage.BLOCK__EXPORTS);
		}
		return exports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public compoundStmt getCompound() {
		return compound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompound(compoundStmt newCompound, NotificationChain msgs) {
		compoundStmt oldCompound = compound;
		compound = newCompound;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.BLOCK__COMPOUND, oldCompound, newCompound);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompound(compoundStmt newCompound) {
		if (newCompound != compound) {
			NotificationChain msgs = null;
			if (compound != null)
				msgs = ((InternalEObject)compound).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.BLOCK__COMPOUND, null, msgs);
			if (newCompound != null)
				msgs = ((InternalEObject)newCompound).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.BLOCK__COMPOUND, null, msgs);
			msgs = basicSetCompound(newCompound, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.BLOCK__COMPOUND, newCompound, newCompound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.BLOCK__DECL_SECT:
				return basicSetDeclSect(null, msgs);
			case DelphiPackage.BLOCK__EXPORTS:
				return ((InternalEList<?>)getExports()).basicRemove(otherEnd, msgs);
			case DelphiPackage.BLOCK__COMPOUND:
				return basicSetCompound(null, msgs);
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
			case DelphiPackage.BLOCK__DECL_SECT:
				return getDeclSect();
			case DelphiPackage.BLOCK__EXPORTS:
				return getExports();
			case DelphiPackage.BLOCK__COMPOUND:
				return getCompound();
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
			case DelphiPackage.BLOCK__DECL_SECT:
				setDeclSect((declSection)newValue);
				return;
			case DelphiPackage.BLOCK__EXPORTS:
				getExports().clear();
				getExports().addAll((Collection<? extends exportsStmt>)newValue);
				return;
			case DelphiPackage.BLOCK__COMPOUND:
				setCompound((compoundStmt)newValue);
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
			case DelphiPackage.BLOCK__DECL_SECT:
				setDeclSect((declSection)null);
				return;
			case DelphiPackage.BLOCK__EXPORTS:
				getExports().clear();
				return;
			case DelphiPackage.BLOCK__COMPOUND:
				setCompound((compoundStmt)null);
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
			case DelphiPackage.BLOCK__DECL_SECT:
				return declSect != null;
			case DelphiPackage.BLOCK__EXPORTS:
				return exports != null && !exports.isEmpty();
			case DelphiPackage.BLOCK__COMPOUND:
				return compound != null;
		}
		return super.eIsSet(featureID);
	}


} //blockImpl
