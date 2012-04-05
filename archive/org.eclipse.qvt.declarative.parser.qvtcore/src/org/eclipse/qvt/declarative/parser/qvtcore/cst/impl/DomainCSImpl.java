/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: DomainCSImpl.java,v 1.1 2008/07/23 10:06:41 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.DomainCSImpl#isCheck <em>Check</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.DomainCSImpl#isEnforce <em>Enforce</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainCSImpl extends AreaCSImpl implements DomainCS {
	/**
	 * The default value of the '{@link #isCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheck()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheck()
	 * @generated
	 * @ordered
	 */
	protected boolean check = CHECK_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnforce() <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnforce()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENFORCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnforce() <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnforce()
	 * @generated
	 * @ordered
	 */
	protected boolean enforce = ENFORCE_EDEFAULT;

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
		return QVTcCSTPackage.Literals.DOMAIN_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCheck() {
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheck(boolean newCheck) {
		boolean oldCheck = check;
		check = newCheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.DOMAIN_CS__CHECK, oldCheck, check));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnforce() {
		return enforce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnforce(boolean newEnforce) {
		boolean oldEnforce = enforce;
		enforce = newEnforce;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.DOMAIN_CS__ENFORCE, oldEnforce, enforce));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTcCSTPackage.DOMAIN_CS__CHECK:
				return isCheck() ? Boolean.TRUE : Boolean.FALSE;
			case QVTcCSTPackage.DOMAIN_CS__ENFORCE:
				return isEnforce() ? Boolean.TRUE : Boolean.FALSE;
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
			case QVTcCSTPackage.DOMAIN_CS__CHECK:
				setCheck(((Boolean)newValue).booleanValue());
				return;
			case QVTcCSTPackage.DOMAIN_CS__ENFORCE:
				setEnforce(((Boolean)newValue).booleanValue());
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
			case QVTcCSTPackage.DOMAIN_CS__CHECK:
				setCheck(CHECK_EDEFAULT);
				return;
			case QVTcCSTPackage.DOMAIN_CS__ENFORCE:
				setEnforce(ENFORCE_EDEFAULT);
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
			case QVTcCSTPackage.DOMAIN_CS__CHECK:
				return check != CHECK_EDEFAULT;
			case QVTcCSTPackage.DOMAIN_CS__ENFORCE:
				return enforce != ENFORCE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (check: ");
		result.append(check);
		result.append(", enforce: ");
		result.append(enforce);
		result.append(')');
		return result.toString();
	}

} //DomainCSImpl
