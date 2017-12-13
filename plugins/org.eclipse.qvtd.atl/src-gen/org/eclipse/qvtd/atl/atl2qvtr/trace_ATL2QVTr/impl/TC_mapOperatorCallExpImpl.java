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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperatorCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Operator Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperatorCallExpImpl#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperatorCallExpImpl#getAtl_atlSource <em>Atl atl Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperatorCallExpImpl#getPrimitive_operationName <em>Primitive operation Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperatorCallExpImpl#getQvtr_qvtrOperation <em>Qvtr qvtr Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperatorCallExpImpl#getQvtr_qvtrSource <em>Qvtr qvtr Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperatorCallExpImpl#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapOperatorCallExpImpl extends TI_mapOperatorCallExpImpl implements TC_mapOperatorCallExp {
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
	protected Operation qvtr_qvtrOperation;

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
	 * The cached value of the '{@link #getQvtr_qvtrTransformation() <em>Qvtr qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrTransformation()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation qvtr_qvtrTransformation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapOperatorCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_OPERATOR_CALL_EXP;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_SOURCE, oldAtl_atlSource, atl_atlSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_SOURCE, oldAtl_atlSource, atl_atlSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__PRIMITIVE_OPERATION_NAME, oldPrimitive_operationName, primitive_operationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getQvtr_qvtrOperation() {
		if (qvtr_qvtrOperation != null && qvtr_qvtrOperation.eIsProxy()) {
			InternalEObject oldQvtr_qvtrOperation = (InternalEObject)qvtr_qvtrOperation;
			qvtr_qvtrOperation = (Operation)eResolveProxy(oldQvtr_qvtrOperation);
			if (qvtr_qvtrOperation != oldQvtr_qvtrOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_OPERATION, oldQvtr_qvtrOperation, qvtr_qvtrOperation));
			}
		}
		return qvtr_qvtrOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetQvtr_qvtrOperation() {
		return qvtr_qvtrOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrOperation(Operation newQvtr_qvtrOperation) {
		Operation oldQvtr_qvtrOperation = qvtr_qvtrOperation;
		qvtr_qvtrOperation = newQvtr_qvtrOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_OPERATION, oldQvtr_qvtrOperation, qvtr_qvtrOperation));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_SOURCE, oldQvtr_qvtrSource, qvtr_qvtrSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_SOURCE, oldQvtr_qvtrSource, qvtr_qvtrSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalTransformation getQvtr_qvtrTransformation() {
		if (qvtr_qvtrTransformation != null && qvtr_qvtrTransformation.eIsProxy()) {
			InternalEObject oldQvtr_qvtrTransformation = (InternalEObject)qvtr_qvtrTransformation;
			qvtr_qvtrTransformation = (RelationalTransformation)eResolveProxy(oldQvtr_qvtrTransformation);
			if (qvtr_qvtrTransformation != oldQvtr_qvtrTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
			}
		}
		return qvtr_qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetQvtr_qvtrTransformation() {
		return qvtr_qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrTransformation(RelationalTransformation newQvtr_qvtrTransformation) {
		RelationalTransformation oldQvtr_qvtrTransformation = qvtr_qvtrTransformation;
		qvtr_qvtrTransformation = newQvtr_qvtrTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_MODULE:
				if (resolve) return getAtl_atlModule();
				return basicGetAtl_atlModule();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_SOURCE:
				if (resolve) return getAtl_atlSource();
				return basicGetAtl_atlSource();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__PRIMITIVE_OPERATION_NAME:
				return getPrimitive_operationName();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_OPERATION:
				if (resolve) return getQvtr_qvtrOperation();
				return basicGetQvtr_qvtrOperation();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_SOURCE:
				if (resolve) return getQvtr_qvtrSource();
				return basicGetQvtr_qvtrSource();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_TRANSFORMATION:
				if (resolve) return getQvtr_qvtrTransformation();
				return basicGetQvtr_qvtrTransformation();
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
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_SOURCE:
				setAtl_atlSource((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__PRIMITIVE_OPERATION_NAME:
				setPrimitive_operationName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_OPERATION:
				setQvtr_qvtrOperation((Operation)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_SOURCE:
				setQvtr_qvtrSource((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_TRANSFORMATION:
				setQvtr_qvtrTransformation((RelationalTransformation)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_SOURCE:
				setAtl_atlSource((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__PRIMITIVE_OPERATION_NAME:
				setPrimitive_operationName(PRIMITIVE_OPERATION_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_OPERATION:
				setQvtr_qvtrOperation((Operation)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_SOURCE:
				setQvtr_qvtrSource((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_TRANSFORMATION:
				setQvtr_qvtrTransformation((RelationalTransformation)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_MODULE:
				return atl_atlModule != null;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_SOURCE:
				return atl_atlSource != null;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__PRIMITIVE_OPERATION_NAME:
				return PRIMITIVE_OPERATION_NAME_EDEFAULT == null ? primitive_operationName != null : !PRIMITIVE_OPERATION_NAME_EDEFAULT.equals(primitive_operationName);
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_OPERATION:
				return qvtr_qvtrOperation != null;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_SOURCE:
				return qvtr_qvtrSource != null;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_TRANSFORMATION:
				return qvtr_qvtrTransformation != null;
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

} //TC_mapOperatorCallExpImpl
