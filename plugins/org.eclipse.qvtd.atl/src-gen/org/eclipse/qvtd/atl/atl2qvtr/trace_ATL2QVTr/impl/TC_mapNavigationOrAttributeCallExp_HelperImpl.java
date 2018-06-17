/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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

import org.eclipse.m2m.atl.common.OCL.Attribute;
import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Navigation Or Attribute Call Exp Helper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapNavigationOrAttributeCallExp_HelperImpl#getAtl_atlAttributes <em>Atl atl Attributes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapNavigationOrAttributeCallExp_HelperImpl#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapNavigationOrAttributeCallExp_HelperImpl#getAtl_atlSource <em>Atl atl Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapNavigationOrAttributeCallExp_HelperImpl#getPrimitive_propertyName <em>Primitive property Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapNavigationOrAttributeCallExp_HelperImpl#getQvtr_qvtrOperation <em>Qvtr qvtr Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapNavigationOrAttributeCallExp_HelperImpl#getQvtr_qvtrSource <em>Qvtr qvtr Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapNavigationOrAttributeCallExp_HelperImpl#getQvtr_qvtrSourceArgument <em>Qvtr qvtr Source Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapNavigationOrAttributeCallExp_HelperImpl#getQvtr_qvtrThisVariable <em>Qvtr qvtr This Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapNavigationOrAttributeCallExp_HelperImpl#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapNavigationOrAttributeCallExp_HelperImpl extends TI_mapNavigationOrAttributeCallExp_HelperImpl implements TC_mapNavigationOrAttributeCallExp_Helper {
	/**
	 * The cached value of the '{@link #getAtl_atlAttributes() <em>Atl atl Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> atl_atlAttributes;

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
	 * The default value of the '{@link #getPrimitive_propertyName() <em>Primitive property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_propertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMITIVE_PROPERTY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive_propertyName() <em>Primitive property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_propertyName()
	 * @generated
	 * @ordered
	 */
	protected String primitive_propertyName = PRIMITIVE_PROPERTY_NAME_EDEFAULT;

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
	protected VariableExp qvtr_qvtrSource;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrSourceArgument() <em>Qvtr qvtr Source Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrSourceArgument()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression qvtr_qvtrSourceArgument;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrThisVariable() <em>Qvtr qvtr This Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrThisVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration qvtr_qvtrThisVariable;

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
	protected TC_mapNavigationOrAttributeCallExp_HelperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attribute> getAtl_atlAttributes() {
		if (atl_atlAttributes == null) {
			atl_atlAttributes = new EObjectResolvingEList<Attribute>(Attribute.class, this, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_ATTRIBUTES);
		}
		return atl_atlAttributes;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_SOURCE, oldAtl_atlSource, atl_atlSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_SOURCE, oldAtl_atlSource, atl_atlSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimitive_propertyName() {
		return primitive_propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitive_propertyName(String newPrimitive_propertyName) {
		String oldPrimitive_propertyName = primitive_propertyName;
		primitive_propertyName = newPrimitive_propertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__PRIMITIVE_PROPERTY_NAME, oldPrimitive_propertyName, primitive_propertyName));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_OPERATION, oldQvtr_qvtrOperation, qvtr_qvtrOperation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_OPERATION, oldQvtr_qvtrOperation, qvtr_qvtrOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableExp getQvtr_qvtrSource() {
		if (qvtr_qvtrSource != null && qvtr_qvtrSource.eIsProxy()) {
			InternalEObject oldQvtr_qvtrSource = (InternalEObject)qvtr_qvtrSource;
			qvtr_qvtrSource = (VariableExp)eResolveProxy(oldQvtr_qvtrSource);
			if (qvtr_qvtrSource != oldQvtr_qvtrSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE, oldQvtr_qvtrSource, qvtr_qvtrSource));
			}
		}
		return qvtr_qvtrSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExp basicGetQvtr_qvtrSource() {
		return qvtr_qvtrSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrSource(VariableExp newQvtr_qvtrSource) {
		VariableExp oldQvtr_qvtrSource = qvtr_qvtrSource;
		qvtr_qvtrSource = newQvtr_qvtrSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE, oldQvtr_qvtrSource, qvtr_qvtrSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getQvtr_qvtrSourceArgument() {
		if (qvtr_qvtrSourceArgument != null && qvtr_qvtrSourceArgument.eIsProxy()) {
			InternalEObject oldQvtr_qvtrSourceArgument = (InternalEObject)qvtr_qvtrSourceArgument;
			qvtr_qvtrSourceArgument = (OCLExpression)eResolveProxy(oldQvtr_qvtrSourceArgument);
			if (qvtr_qvtrSourceArgument != oldQvtr_qvtrSourceArgument) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE_ARGUMENT, oldQvtr_qvtrSourceArgument, qvtr_qvtrSourceArgument));
			}
		}
		return qvtr_qvtrSourceArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetQvtr_qvtrSourceArgument() {
		return qvtr_qvtrSourceArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrSourceArgument(OCLExpression newQvtr_qvtrSourceArgument) {
		OCLExpression oldQvtr_qvtrSourceArgument = qvtr_qvtrSourceArgument;
		qvtr_qvtrSourceArgument = newQvtr_qvtrSourceArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE_ARGUMENT, oldQvtr_qvtrSourceArgument, qvtr_qvtrSourceArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDeclaration getQvtr_qvtrThisVariable() {
		if (qvtr_qvtrThisVariable != null && qvtr_qvtrThisVariable.eIsProxy()) {
			InternalEObject oldQvtr_qvtrThisVariable = (InternalEObject)qvtr_qvtrThisVariable;
			qvtr_qvtrThisVariable = (VariableDeclaration)eResolveProxy(oldQvtr_qvtrThisVariable);
			if (qvtr_qvtrThisVariable != oldQvtr_qvtrThisVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_THIS_VARIABLE, oldQvtr_qvtrThisVariable, qvtr_qvtrThisVariable));
			}
		}
		return qvtr_qvtrThisVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetQvtr_qvtrThisVariable() {
		return qvtr_qvtrThisVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrThisVariable(VariableDeclaration newQvtr_qvtrThisVariable) {
		VariableDeclaration oldQvtr_qvtrThisVariable = qvtr_qvtrThisVariable;
		qvtr_qvtrThisVariable = newQvtr_qvtrThisVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_THIS_VARIABLE, oldQvtr_qvtrThisVariable, qvtr_qvtrThisVariable));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_ATTRIBUTES:
				return getAtl_atlAttributes();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_MODULE:
				if (resolve) return getAtl_atlModule();
				return basicGetAtl_atlModule();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_SOURCE:
				if (resolve) return getAtl_atlSource();
				return basicGetAtl_atlSource();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__PRIMITIVE_PROPERTY_NAME:
				return getPrimitive_propertyName();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_OPERATION:
				if (resolve) return getQvtr_qvtrOperation();
				return basicGetQvtr_qvtrOperation();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE:
				if (resolve) return getQvtr_qvtrSource();
				return basicGetQvtr_qvtrSource();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE_ARGUMENT:
				if (resolve) return getQvtr_qvtrSourceArgument();
				return basicGetQvtr_qvtrSourceArgument();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_THIS_VARIABLE:
				if (resolve) return getQvtr_qvtrThisVariable();
				return basicGetQvtr_qvtrThisVariable();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_TRANSFORMATION:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_ATTRIBUTES:
				getAtl_atlAttributes().clear();
				getAtl_atlAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_SOURCE:
				setAtl_atlSource((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__PRIMITIVE_PROPERTY_NAME:
				setPrimitive_propertyName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_OPERATION:
				setQvtr_qvtrOperation((Operation)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE:
				setQvtr_qvtrSource((VariableExp)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE_ARGUMENT:
				setQvtr_qvtrSourceArgument((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_THIS_VARIABLE:
				setQvtr_qvtrThisVariable((VariableDeclaration)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_TRANSFORMATION:
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
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_ATTRIBUTES:
				getAtl_atlAttributes().clear();
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_SOURCE:
				setAtl_atlSource((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__PRIMITIVE_PROPERTY_NAME:
				setPrimitive_propertyName(PRIMITIVE_PROPERTY_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_OPERATION:
				setQvtr_qvtrOperation((Operation)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE:
				setQvtr_qvtrSource((VariableExp)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE_ARGUMENT:
				setQvtr_qvtrSourceArgument((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_THIS_VARIABLE:
				setQvtr_qvtrThisVariable((VariableDeclaration)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_TRANSFORMATION:
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
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_ATTRIBUTES:
				return atl_atlAttributes != null && !atl_atlAttributes.isEmpty();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_MODULE:
				return atl_atlModule != null;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_SOURCE:
				return atl_atlSource != null;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__PRIMITIVE_PROPERTY_NAME:
				return PRIMITIVE_PROPERTY_NAME_EDEFAULT == null ? primitive_propertyName != null : !PRIMITIVE_PROPERTY_NAME_EDEFAULT.equals(primitive_propertyName);
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_OPERATION:
				return qvtr_qvtrOperation != null;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE:
				return qvtr_qvtrSource != null;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE_ARGUMENT:
				return qvtr_qvtrSourceArgument != null;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_THIS_VARIABLE:
				return qvtr_qvtrThisVariable != null;
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_TRANSFORMATION:
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
		result.append(" (primitive_propertyName: ");
		result.append(primitive_propertyName);
		result.append(')');
		return result.toString();
	}

} //TC_mapNavigationOrAttributeCallExp_HelperImpl
