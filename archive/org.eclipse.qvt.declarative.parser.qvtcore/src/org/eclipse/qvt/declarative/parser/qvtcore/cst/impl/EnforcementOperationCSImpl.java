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
 * $Id: EnforcementOperationCSImpl.java,v 1.1 2008/07/23 10:06:41 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.impl.CSTNodeImpl;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enforcement Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.EnforcementOperationCSImpl#isDeletion <em>Deletion</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.EnforcementOperationCSImpl#getOperationCall <em>Operation Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnforcementOperationCSImpl extends CSTNodeImpl implements EnforcementOperationCS
{
	/**
	 * The default value of the '{@link #isDeletion() <em>Deletion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeletion()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELETION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeletion() <em>Deletion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeletion()
	 * @generated
	 * @ordered
	 */
	protected boolean deletion = DELETION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOperationCall() <em>Operation Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationCall()
	 * @generated
	 * @ordered
	 */
	protected OperationCallExpCS operationCall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnforcementOperationCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return QVTcCSTPackage.Literals.ENFORCEMENT_OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeletion()
	{
		return deletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeletion(boolean newDeletion)
	{
		boolean oldDeletion = deletion;
		deletion = newDeletion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__DELETION, oldDeletion, deletion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExpCS getOperationCall()
	{
		return operationCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationCall(OperationCallExpCS newOperationCall, NotificationChain msgs)
	{
		OperationCallExpCS oldOperationCall = operationCall;
		operationCall = newOperationCall;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL, oldOperationCall, newOperationCall);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationCall(OperationCallExpCS newOperationCall)
	{
		if (newOperationCall != operationCall) {
			NotificationChain msgs = null;
			if (operationCall != null)
				msgs = ((InternalEObject)operationCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL, null, msgs);
			if (newOperationCall != null)
				msgs = ((InternalEObject)newOperationCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL, null, msgs);
			msgs = basicSetOperationCall(newOperationCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL, newOperationCall, newOperationCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL:
				return basicSetOperationCall(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__DELETION:
				return isDeletion() ? Boolean.TRUE : Boolean.FALSE;
			case QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL:
				return getOperationCall();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__DELETION:
				setDeletion(((Boolean)newValue).booleanValue());
				return;
			case QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL:
				setOperationCall((OperationCallExpCS)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__DELETION:
				setDeletion(DELETION_EDEFAULT);
				return;
			case QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL:
				setOperationCall((OperationCallExpCS)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__DELETION:
				return deletion != DELETION_EDEFAULT;
			case QVTcCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL:
				return operationCall != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (deletion: ");
		result.append(deletion);
		result.append(')');
		return result.toString();
	}

} //EnforcementOperationCSImpl
