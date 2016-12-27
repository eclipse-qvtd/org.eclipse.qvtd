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
import delphi.declSection;
import delphi.exportsStmt;
import delphi.implementationSection;
import delphi.usesClause;

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
 * An implementation of the model object '<em><b>implementation Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.implementationSectionImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link delphi.impl.implementationSectionImpl#getDeclSect <em>Decl Sect</em>}</li>
 *   <li>{@link delphi.impl.implementationSectionImpl#getExports <em>Exports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class implementationSectionImpl extends CSTraceImpl implements implementationSection {
	/**
	 * The cached value of the '{@link #getUses() <em>Uses</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUses()
	 * @generated
	 * @ordered
	 */
	protected usesClause uses;

	/**
	 * The cached value of the '{@link #getDeclSect() <em>Decl Sect</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclSect()
	 * @generated
	 * @ordered
	 */
	protected EList<declSection> declSect;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected implementationSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.IMPLEMENTATION_SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public usesClause getUses() {
		return uses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUses(usesClause newUses, NotificationChain msgs) {
		usesClause oldUses = uses;
		uses = newUses;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.IMPLEMENTATION_SECTION__USES, oldUses, newUses);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUses(usesClause newUses) {
		if (newUses != uses) {
			NotificationChain msgs = null;
			if (uses != null)
				msgs = ((InternalEObject)uses).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.IMPLEMENTATION_SECTION__USES, null, msgs);
			if (newUses != null)
				msgs = ((InternalEObject)newUses).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.IMPLEMENTATION_SECTION__USES, null, msgs);
			msgs = basicSetUses(newUses, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.IMPLEMENTATION_SECTION__USES, newUses, newUses));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<declSection> getDeclSect() {
		if (declSect == null) {
			declSect = new EObjectContainmentEList<declSection>(declSection.class, this, DelphiPackage.IMPLEMENTATION_SECTION__DECL_SECT);
		}
		return declSect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<exportsStmt> getExports() {
		if (exports == null) {
			exports = new EObjectContainmentEList<exportsStmt>(exportsStmt.class, this, DelphiPackage.IMPLEMENTATION_SECTION__EXPORTS);
		}
		return exports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.IMPLEMENTATION_SECTION__USES:
				return basicSetUses(null, msgs);
			case DelphiPackage.IMPLEMENTATION_SECTION__DECL_SECT:
				return ((InternalEList<?>)getDeclSect()).basicRemove(otherEnd, msgs);
			case DelphiPackage.IMPLEMENTATION_SECTION__EXPORTS:
				return ((InternalEList<?>)getExports()).basicRemove(otherEnd, msgs);
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
			case DelphiPackage.IMPLEMENTATION_SECTION__USES:
				return getUses();
			case DelphiPackage.IMPLEMENTATION_SECTION__DECL_SECT:
				return getDeclSect();
			case DelphiPackage.IMPLEMENTATION_SECTION__EXPORTS:
				return getExports();
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
			case DelphiPackage.IMPLEMENTATION_SECTION__USES:
				setUses((usesClause)newValue);
				return;
			case DelphiPackage.IMPLEMENTATION_SECTION__DECL_SECT:
				getDeclSect().clear();
				getDeclSect().addAll((Collection<? extends declSection>)newValue);
				return;
			case DelphiPackage.IMPLEMENTATION_SECTION__EXPORTS:
				getExports().clear();
				getExports().addAll((Collection<? extends exportsStmt>)newValue);
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
			case DelphiPackage.IMPLEMENTATION_SECTION__USES:
				setUses((usesClause)null);
				return;
			case DelphiPackage.IMPLEMENTATION_SECTION__DECL_SECT:
				getDeclSect().clear();
				return;
			case DelphiPackage.IMPLEMENTATION_SECTION__EXPORTS:
				getExports().clear();
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
			case DelphiPackage.IMPLEMENTATION_SECTION__USES:
				return uses != null;
			case DelphiPackage.IMPLEMENTATION_SECTION__DECL_SECT:
				return declSect != null && !declSect.isEmpty();
			case DelphiPackage.IMPLEMENTATION_SECTION__EXPORTS:
				return exports != null && !exports.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //implementationSectionImpl
