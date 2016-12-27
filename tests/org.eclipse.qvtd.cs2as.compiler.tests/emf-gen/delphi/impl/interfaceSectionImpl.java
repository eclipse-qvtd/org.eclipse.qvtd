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
import delphi.interfaceDecl;
import delphi.interfaceSection;
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
 * An implementation of the model object '<em><b>interface Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.interfaceSectionImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link delphi.impl.interfaceSectionImpl#getInterfaceDecl <em>Interface Decl</em>}</li>
 * </ul>
 *
 * @generated
 */
public class interfaceSectionImpl extends CSTraceImpl implements interfaceSection {
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
	 * The cached value of the '{@link #getInterfaceDecl() <em>Interface Decl</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceDecl()
	 * @generated
	 * @ordered
	 */
	protected EList<interfaceDecl> interfaceDecl;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected interfaceSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.INTERFACE_SECTION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.INTERFACE_SECTION__USES, oldUses, newUses);
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
				msgs = ((InternalEObject)uses).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.INTERFACE_SECTION__USES, null, msgs);
			if (newUses != null)
				msgs = ((InternalEObject)newUses).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.INTERFACE_SECTION__USES, null, msgs);
			msgs = basicSetUses(newUses, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.INTERFACE_SECTION__USES, newUses, newUses));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<interfaceDecl> getInterfaceDecl() {
		if (interfaceDecl == null) {
			interfaceDecl = new EObjectContainmentEList<interfaceDecl>(interfaceDecl.class, this, DelphiPackage.INTERFACE_SECTION__INTERFACE_DECL);
		}
		return interfaceDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.INTERFACE_SECTION__USES:
				return basicSetUses(null, msgs);
			case DelphiPackage.INTERFACE_SECTION__INTERFACE_DECL:
				return ((InternalEList<?>)getInterfaceDecl()).basicRemove(otherEnd, msgs);
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
			case DelphiPackage.INTERFACE_SECTION__USES:
				return getUses();
			case DelphiPackage.INTERFACE_SECTION__INTERFACE_DECL:
				return getInterfaceDecl();
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
			case DelphiPackage.INTERFACE_SECTION__USES:
				setUses((usesClause)newValue);
				return;
			case DelphiPackage.INTERFACE_SECTION__INTERFACE_DECL:
				getInterfaceDecl().clear();
				getInterfaceDecl().addAll((Collection<? extends interfaceDecl>)newValue);
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
			case DelphiPackage.INTERFACE_SECTION__USES:
				setUses((usesClause)null);
				return;
			case DelphiPackage.INTERFACE_SECTION__INTERFACE_DECL:
				getInterfaceDecl().clear();
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
			case DelphiPackage.INTERFACE_SECTION__USES:
				return uses != null;
			case DelphiPackage.INTERFACE_SECTION__INTERFACE_DECL:
				return interfaceDecl != null && !interfaceDecl.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //interfaceSectionImpl
