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
 * $Id: AssignmentCSImpl.java,v 1.1 2008/07/23 10:06:41 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.impl.OCLExpressionCSImpl;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AssignmentCSImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AssignmentCSImpl#getInitialiser <em>Initialiser</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AssignmentCSImpl#isDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignmentCSImpl extends OCLExpressionCSImpl implements AssignmentCS {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS target;

	/**
	 * The cached value of the '{@link #getInitialiser() <em>Initialiser</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialiser()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS initialiser;

	/**
	 * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean default_ = DEFAULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignmentCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcCSTPackage.Literals.ASSIGNMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(OCLExpressionCS newTarget, NotificationChain msgs) {
		OCLExpressionCS oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.ASSIGNMENT_CS__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(OCLExpressionCS newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.ASSIGNMENT_CS__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.ASSIGNMENT_CS__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.ASSIGNMENT_CS__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getInitialiser() {
		return initialiser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialiser(OCLExpressionCS newInitialiser, NotificationChain msgs) {
		OCLExpressionCS oldInitialiser = initialiser;
		initialiser = newInitialiser;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.ASSIGNMENT_CS__INITIALISER, oldInitialiser, newInitialiser);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialiser(OCLExpressionCS newInitialiser) {
		if (newInitialiser != initialiser) {
			NotificationChain msgs = null;
			if (initialiser != null)
				msgs = ((InternalEObject)initialiser).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.ASSIGNMENT_CS__INITIALISER, null, msgs);
			if (newInitialiser != null)
				msgs = ((InternalEObject)newInitialiser).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.ASSIGNMENT_CS__INITIALISER, null, msgs);
			msgs = basicSetInitialiser(newInitialiser, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.ASSIGNMENT_CS__INITIALISER, newInitialiser, newInitialiser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(boolean newDefault) {
		boolean oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.ASSIGNMENT_CS__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcCSTPackage.ASSIGNMENT_CS__TARGET:
				return basicSetTarget(null, msgs);
			case QVTcCSTPackage.ASSIGNMENT_CS__INITIALISER:
				return basicSetInitialiser(null, msgs);
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
			case QVTcCSTPackage.ASSIGNMENT_CS__TARGET:
				return getTarget();
			case QVTcCSTPackage.ASSIGNMENT_CS__INITIALISER:
				return getInitialiser();
			case QVTcCSTPackage.ASSIGNMENT_CS__DEFAULT:
				return isDefault() ? Boolean.TRUE : Boolean.FALSE;
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
			case QVTcCSTPackage.ASSIGNMENT_CS__TARGET:
				setTarget((OCLExpressionCS)newValue);
				return;
			case QVTcCSTPackage.ASSIGNMENT_CS__INITIALISER:
				setInitialiser((OCLExpressionCS)newValue);
				return;
			case QVTcCSTPackage.ASSIGNMENT_CS__DEFAULT:
				setDefault(((Boolean)newValue).booleanValue());
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
			case QVTcCSTPackage.ASSIGNMENT_CS__TARGET:
				setTarget((OCLExpressionCS)null);
				return;
			case QVTcCSTPackage.ASSIGNMENT_CS__INITIALISER:
				setInitialiser((OCLExpressionCS)null);
				return;
			case QVTcCSTPackage.ASSIGNMENT_CS__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
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
			case QVTcCSTPackage.ASSIGNMENT_CS__TARGET:
				return target != null;
			case QVTcCSTPackage.ASSIGNMENT_CS__INITIALISER:
				return initialiser != null;
			case QVTcCSTPackage.ASSIGNMENT_CS__DEFAULT:
				return default_ != DEFAULT_EDEFAULT;
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
		result.append(" (default: ");
		result.append(default_);
		result.append(')');
		return result.toString();
	}

} //AssignmentCSImpl
