/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.m2m.atl.common.OCL.OclExpression;
import org.eclipse.m2m.atl.common.OCL.Operation;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Operation Call Exp Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperationCallExp_OperationImpl#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperationCallExp_OperationImpl#getAtl_atlOperations <em>Atl atl Operations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperationCallExp_OperationImpl#getAtl_atlSource <em>Atl atl Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperationCallExp_OperationImpl#getPrimitive_operationName <em>Primitive operation Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperationCallExp_OperationImpl#getQvtr_qvtrOperation <em>Qvtr qvtr Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperationCallExp_OperationImpl#getQvtr_qvtrSource <em>Qvtr qvtr Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapOperationCallExp_OperationImpl extends TI_mapOperationCallExp_OperationImpl implements TC_mapOperationCallExp_Operation {
	/**
	 * The cached value of the '{@link #getAtl_atlModule() <em>Atl atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlModule()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.m2m.atl.common.ATL.Module atl_atlModule;

	/**
	 * The cached value of the '{@link #getAtl_atlOperations() <em>Atl atl Operations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> atl_atlOperations;

	/**
	 * The cached value of the '{@link #getAtl_atlSource() <em>Atl atl Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlSource()
	 * @generated
	 * @ordered
	 */
	protected OclExpression atl_atlSource;

	/**
	 * The default value of the '{@link #getPrimitive_operationName() <em>Primitive operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_operationName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMITIVE_OPERATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive_operationName() <em>Primitive operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_operationName()
	 * @generated
	 * @ordered
	 */
	protected String primitive_operationName = PRIMITIVE_OPERATION_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrOperation() <em>Qvtr qvtr Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrOperation()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Operation qvtr_qvtrOperation;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrSource() <em>Qvtr qvtr Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrSource()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression qvtr_qvtrSource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapOperationCallExp_OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_OPERATION_CALL_EXP_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.m2m.atl.common.ATL.Module getAtl_atlModule() {
		if (atl_atlModule != null && atl_atlModule.eIsProxy()) {
			InternalEObject oldAtl_atlModule = atl_atlModule;
			atl_atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldAtl_atlModule);
			if (atl_atlModule != oldAtl_atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
			}
		}
		return atl_atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.m2m.atl.common.ATL.Module basicGetAtl_atlModule() {
		return atl_atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlModule(org.eclipse.m2m.atl.common.ATL.Module newAtl_atlModule) {
		org.eclipse.m2m.atl.common.ATL.Module oldAtl_atlModule = atl_atlModule;
		atl_atlModule = newAtl_atlModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Operation> getAtl_atlOperations() {
		if (atl_atlOperations == null) {
			atl_atlOperations = new EObjectResolvingEList<Operation>(Operation.class, this, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_OPERATIONS);
		}
		return atl_atlOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getAtl_atlSource() {
		if (atl_atlSource != null && atl_atlSource.eIsProxy()) {
			InternalEObject oldAtl_atlSource = atl_atlSource;
			atl_atlSource = (OclExpression)eResolveProxy(oldAtl_atlSource);
			if (atl_atlSource != oldAtl_atlSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_SOURCE, oldAtl_atlSource, atl_atlSource));
			}
		}
		return atl_atlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetAtl_atlSource() {
		return atl_atlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlSource(OclExpression newAtl_atlSource) {
		OclExpression oldAtl_atlSource = atl_atlSource;
		atl_atlSource = newAtl_atlSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_SOURCE, oldAtl_atlSource, atl_atlSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimitive_operationName() {
		return primitive_operationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitive_operationName(String newPrimitive_operationName) {
		String oldPrimitive_operationName = primitive_operationName;
		primitive_operationName = newPrimitive_operationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__PRIMITIVE_OPERATION_NAME, oldPrimitive_operationName, primitive_operationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Operation getQvtr_qvtrOperation() {
		if (qvtr_qvtrOperation != null && qvtr_qvtrOperation.eIsProxy()) {
			InternalEObject oldQvtr_qvtrOperation = (InternalEObject)qvtr_qvtrOperation;
			qvtr_qvtrOperation = (org.eclipse.ocl.pivot.Operation)eResolveProxy(oldQvtr_qvtrOperation);
			if (qvtr_qvtrOperation != oldQvtr_qvtrOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_OPERATION, oldQvtr_qvtrOperation, qvtr_qvtrOperation));
			}
		}
		return qvtr_qvtrOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Operation basicGetQvtr_qvtrOperation() {
		return qvtr_qvtrOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrOperation(org.eclipse.ocl.pivot.Operation newQvtr_qvtrOperation) {
		org.eclipse.ocl.pivot.Operation oldQvtr_qvtrOperation = qvtr_qvtrOperation;
		qvtr_qvtrOperation = newQvtr_qvtrOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_OPERATION, oldQvtr_qvtrOperation, qvtr_qvtrOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getQvtr_qvtrSource() {
		if (qvtr_qvtrSource != null && qvtr_qvtrSource.eIsProxy()) {
			InternalEObject oldQvtr_qvtrSource = (InternalEObject)qvtr_qvtrSource;
			qvtr_qvtrSource = (OCLExpression)eResolveProxy(oldQvtr_qvtrSource);
			if (qvtr_qvtrSource != oldQvtr_qvtrSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_SOURCE, oldQvtr_qvtrSource, qvtr_qvtrSource));
			}
		}
		return qvtr_qvtrSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetQvtr_qvtrSource() {
		return qvtr_qvtrSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrSource(OCLExpression newQvtr_qvtrSource) {
		OCLExpression oldQvtr_qvtrSource = qvtr_qvtrSource;
		qvtr_qvtrSource = newQvtr_qvtrSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_SOURCE, oldQvtr_qvtrSource, qvtr_qvtrSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_MODULE:
				if (resolve) return getAtl_atlModule();
				return basicGetAtl_atlModule();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_OPERATIONS:
				return getAtl_atlOperations();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_SOURCE:
				if (resolve) return getAtl_atlSource();
				return basicGetAtl_atlSource();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__PRIMITIVE_OPERATION_NAME:
				return getPrimitive_operationName();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_OPERATION:
				if (resolve) return getQvtr_qvtrOperation();
				return basicGetQvtr_qvtrOperation();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_SOURCE:
				if (resolve) return getQvtr_qvtrSource();
				return basicGetQvtr_qvtrSource();
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
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_OPERATIONS:
				getAtl_atlOperations().clear();
				getAtl_atlOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_SOURCE:
				setAtl_atlSource((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__PRIMITIVE_OPERATION_NAME:
				setPrimitive_operationName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_OPERATION:
				setQvtr_qvtrOperation((org.eclipse.ocl.pivot.Operation)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_SOURCE:
				setQvtr_qvtrSource((OCLExpression)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_OPERATIONS:
				getAtl_atlOperations().clear();
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_SOURCE:
				setAtl_atlSource((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__PRIMITIVE_OPERATION_NAME:
				setPrimitive_operationName(PRIMITIVE_OPERATION_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_OPERATION:
				setQvtr_qvtrOperation((org.eclipse.ocl.pivot.Operation)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_SOURCE:
				setQvtr_qvtrSource((OCLExpression)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_MODULE:
				return atl_atlModule != null;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_OPERATIONS:
				return atl_atlOperations != null && !atl_atlOperations.isEmpty();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_SOURCE:
				return atl_atlSource != null;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__PRIMITIVE_OPERATION_NAME:
				return PRIMITIVE_OPERATION_NAME_EDEFAULT == null ? primitive_operationName != null : !PRIMITIVE_OPERATION_NAME_EDEFAULT.equals(primitive_operationName);
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_OPERATION:
				return qvtr_qvtrOperation != null;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_SOURCE:
				return qvtr_qvtrSource != null;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (primitive_operationName: ");
		result.append(primitive_operationName);
		result.append(')');
		return result.toString();
	}

} //TC_mapOperationCallExp_OperationImpl
