/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.atl.common.OCL.Attribute;
import org.eclipse.m2m.atl.common.OCL.OclExpression;
import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.OclType;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Context;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Helper Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_AttributeImpl#getAtl_atlDefinition <em>Atl atl Definition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_AttributeImpl#getAtl_atlExpression <em>Atl atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_AttributeImpl#getAtl_atlFeature <em>Atl atl Feature</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_AttributeImpl#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_AttributeImpl#getAtl_atlType <em>Atl atl Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_AttributeImpl#getInvocation_mapHelper_Context <em>Invocation map Helper Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_AttributeImpl#getPrimitive_attributeName <em>Primitive attribute Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_AttributeImpl#getQvtr_qvtrExpression <em>Qvtr qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_AttributeImpl#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapHelper_AttributeImpl extends TI_mapHelper_AttributeImpl implements TC_mapHelper_Attribute {
	/**
	 * The cached value of the '{@link #getAtl_atlDefinition() <em>Atl atl Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlDefinition()
	 * @generated
	 * @ordered
	 */
	protected OclFeatureDefinition atl_atlDefinition;

	/**
	 * The cached value of the '{@link #getAtl_atlExpression() <em>Atl atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression atl_atlExpression;

	/**
	 * The cached value of the '{@link #getAtl_atlFeature() <em>Atl atl Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlFeature()
	 * @generated
	 * @ordered
	 */
	protected Attribute atl_atlFeature;

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
	 * The cached value of the '{@link #getAtl_atlType() <em>Atl atl Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlType()
	 * @generated
	 * @ordered
	 */
	protected OclType atl_atlType;

	/**
	 * The cached value of the '{@link #getInvocation_mapHelper_Context() <em>Invocation map Helper Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvocation_mapHelper_Context()
	 * @generated
	 * @ordered
	 */
	protected TC_mapHelper_Context invocation_mapHelper_Context;

	/**
	 * The default value of the '{@link #getPrimitive_attributeName() <em>Primitive attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_attributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMITIVE_ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive_attributeName() <em>Primitive attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_attributeName()
	 * @generated
	 * @ordered
	 */
	protected String primitive_attributeName = PRIMITIVE_ATTRIBUTE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrExpression() <em>Qvtr qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression qvtr_qvtrExpression;

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
	protected TC_mapHelper_AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_HELPER_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclFeatureDefinition getAtl_atlDefinition() {
		if (atl_atlDefinition != null && atl_atlDefinition.eIsProxy()) {
			InternalEObject oldAtl_atlDefinition = atl_atlDefinition;
			atl_atlDefinition = (OclFeatureDefinition)eResolveProxy(oldAtl_atlDefinition);
			if (atl_atlDefinition != oldAtl_atlDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_DEFINITION, oldAtl_atlDefinition, atl_atlDefinition));
			}
		}
		return atl_atlDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclFeatureDefinition basicGetAtl_atlDefinition() {
		return atl_atlDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlDefinition(OclFeatureDefinition newAtl_atlDefinition) {
		OclFeatureDefinition oldAtl_atlDefinition = atl_atlDefinition;
		atl_atlDefinition = newAtl_atlDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_DEFINITION, oldAtl_atlDefinition, atl_atlDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getAtl_atlExpression() {
		if (atl_atlExpression != null && atl_atlExpression.eIsProxy()) {
			InternalEObject oldAtl_atlExpression = atl_atlExpression;
			atl_atlExpression = (OclExpression)eResolveProxy(oldAtl_atlExpression);
			if (atl_atlExpression != oldAtl_atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_EXPRESSION, oldAtl_atlExpression, atl_atlExpression));
			}
		}
		return atl_atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetAtl_atlExpression() {
		return atl_atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlExpression(OclExpression newAtl_atlExpression) {
		OclExpression oldAtl_atlExpression = atl_atlExpression;
		atl_atlExpression = newAtl_atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_EXPRESSION, oldAtl_atlExpression, atl_atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Attribute getAtl_atlFeature() {
		if (atl_atlFeature != null && atl_atlFeature.eIsProxy()) {
			InternalEObject oldAtl_atlFeature = atl_atlFeature;
			atl_atlFeature = (Attribute)eResolveProxy(oldAtl_atlFeature);
			if (atl_atlFeature != oldAtl_atlFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_FEATURE, oldAtl_atlFeature, atl_atlFeature));
			}
		}
		return atl_atlFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute basicGetAtl_atlFeature() {
		return atl_atlFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlFeature(Attribute newAtl_atlFeature) {
		Attribute oldAtl_atlFeature = atl_atlFeature;
		atl_atlFeature = newAtl_atlFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_FEATURE, oldAtl_atlFeature, atl_atlFeature));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclType getAtl_atlType() {
		if (atl_atlType != null && atl_atlType.eIsProxy()) {
			InternalEObject oldAtl_atlType = atl_atlType;
			atl_atlType = (OclType)eResolveProxy(oldAtl_atlType);
			if (atl_atlType != oldAtl_atlType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_TYPE, oldAtl_atlType, atl_atlType));
			}
		}
		return atl_atlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclType basicGetAtl_atlType() {
		return atl_atlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlType(OclType newAtl_atlType) {
		OclType oldAtl_atlType = atl_atlType;
		atl_atlType = newAtl_atlType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_TYPE, oldAtl_atlType, atl_atlType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TC_mapHelper_Context getInvocation_mapHelper_Context() {
		return invocation_mapHelper_Context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvocation_mapHelper_Context(TC_mapHelper_Context newInvocation_mapHelper_Context, NotificationChain msgs) {
		TC_mapHelper_Context oldInvocation_mapHelper_Context = invocation_mapHelper_Context;
		invocation_mapHelper_Context = newInvocation_mapHelper_Context;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__INVOCATION_MAP_HELPER_CONTEXT, oldInvocation_mapHelper_Context, newInvocation_mapHelper_Context);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInvocation_mapHelper_Context(TC_mapHelper_Context newInvocation_mapHelper_Context) {
		if (newInvocation_mapHelper_Context != invocation_mapHelper_Context) {
			NotificationChain msgs = null;
			if (invocation_mapHelper_Context != null)
				msgs = ((InternalEObject)invocation_mapHelper_Context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__INVOCATION_MAP_HELPER_CONTEXT, null, msgs);
			if (newInvocation_mapHelper_Context != null)
				msgs = ((InternalEObject)newInvocation_mapHelper_Context).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__INVOCATION_MAP_HELPER_CONTEXT, null, msgs);
			msgs = basicSetInvocation_mapHelper_Context(newInvocation_mapHelper_Context, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__INVOCATION_MAP_HELPER_CONTEXT, newInvocation_mapHelper_Context, newInvocation_mapHelper_Context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimitive_attributeName() {
		return primitive_attributeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitive_attributeName(String newPrimitive_attributeName) {
		String oldPrimitive_attributeName = primitive_attributeName;
		primitive_attributeName = newPrimitive_attributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__PRIMITIVE_ATTRIBUTE_NAME, oldPrimitive_attributeName, primitive_attributeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getQvtr_qvtrExpression() {
		if (qvtr_qvtrExpression != null && qvtr_qvtrExpression.eIsProxy()) {
			InternalEObject oldQvtr_qvtrExpression = (InternalEObject)qvtr_qvtrExpression;
			qvtr_qvtrExpression = (OCLExpression)eResolveProxy(oldQvtr_qvtrExpression);
			if (qvtr_qvtrExpression != oldQvtr_qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_EXPRESSION, oldQvtr_qvtrExpression, qvtr_qvtrExpression));
			}
		}
		return qvtr_qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetQvtr_qvtrExpression() {
		return qvtr_qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrExpression(OCLExpression newQvtr_qvtrExpression) {
		OCLExpression oldQvtr_qvtrExpression = qvtr_qvtrExpression;
		qvtr_qvtrExpression = newQvtr_qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_EXPRESSION, oldQvtr_qvtrExpression, qvtr_qvtrExpression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__INVOCATION_MAP_HELPER_CONTEXT:
				return basicSetInvocation_mapHelper_Context(null, msgs);
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
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_DEFINITION:
				if (resolve) return getAtl_atlDefinition();
				return basicGetAtl_atlDefinition();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_EXPRESSION:
				if (resolve) return getAtl_atlExpression();
				return basicGetAtl_atlExpression();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_FEATURE:
				if (resolve) return getAtl_atlFeature();
				return basicGetAtl_atlFeature();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_MODULE:
				if (resolve) return getAtl_atlModule();
				return basicGetAtl_atlModule();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_TYPE:
				if (resolve) return getAtl_atlType();
				return basicGetAtl_atlType();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__INVOCATION_MAP_HELPER_CONTEXT:
				return getInvocation_mapHelper_Context();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__PRIMITIVE_ATTRIBUTE_NAME:
				return getPrimitive_attributeName();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_EXPRESSION:
				if (resolve) return getQvtr_qvtrExpression();
				return basicGetQvtr_qvtrExpression();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_TRANSFORMATION:
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
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_DEFINITION:
				setAtl_atlDefinition((OclFeatureDefinition)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_EXPRESSION:
				setAtl_atlExpression((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_FEATURE:
				setAtl_atlFeature((Attribute)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_TYPE:
				setAtl_atlType((OclType)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__INVOCATION_MAP_HELPER_CONTEXT:
				setInvocation_mapHelper_Context((TC_mapHelper_Context)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__PRIMITIVE_ATTRIBUTE_NAME:
				setPrimitive_attributeName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_EXPRESSION:
				setQvtr_qvtrExpression((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_TRANSFORMATION:
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
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_DEFINITION:
				setAtl_atlDefinition((OclFeatureDefinition)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_EXPRESSION:
				setAtl_atlExpression((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_FEATURE:
				setAtl_atlFeature((Attribute)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_TYPE:
				setAtl_atlType((OclType)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__INVOCATION_MAP_HELPER_CONTEXT:
				setInvocation_mapHelper_Context((TC_mapHelper_Context)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__PRIMITIVE_ATTRIBUTE_NAME:
				setPrimitive_attributeName(PRIMITIVE_ATTRIBUTE_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_EXPRESSION:
				setQvtr_qvtrExpression((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_TRANSFORMATION:
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
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_DEFINITION:
				return atl_atlDefinition != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_EXPRESSION:
				return atl_atlExpression != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_FEATURE:
				return atl_atlFeature != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_MODULE:
				return atl_atlModule != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_TYPE:
				return atl_atlType != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__INVOCATION_MAP_HELPER_CONTEXT:
				return invocation_mapHelper_Context != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__PRIMITIVE_ATTRIBUTE_NAME:
				return PRIMITIVE_ATTRIBUTE_NAME_EDEFAULT == null ? primitive_attributeName != null : !PRIMITIVE_ATTRIBUTE_NAME_EDEFAULT.equals(primitive_attributeName);
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_EXPRESSION:
				return qvtr_qvtrExpression != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_TRANSFORMATION:
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
		result.append(" (primitive_attributeName: ");
		result.append(primitive_attributeName);
		result.append(')');
		return result.toString();
	}

} //TC_mapHelper_AttributeImpl
