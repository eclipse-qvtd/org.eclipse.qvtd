/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.Parameter;

import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Parameter Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationParameterEdgeImpl#getReferredParameter <em>Referred Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationParameterEdgeImpl#getParameterIndex <em>Parameter Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationParameterEdgeImpl extends ArgumentEdgeImpl implements OperationParameterEdge {
	/**
	 * The number of structural features of the '<em>Operation Parameter Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OPERATION_PARAMETER_EDGE_FEATURE_COUNT = ArgumentEdgeImpl.ARGUMENT_EDGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operation Parameter Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OPERATION_PARAMETER_EDGE_OPERATION_COUNT = ArgumentEdgeImpl.ARGUMENT_EDGE_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getReferredParameter() <em>Referred Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter referredParameter;

	/**
	 * The default value of the '{@link #getParameterIndex() <em>Parameter Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int PARAMETER_INDEX_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getParameterIndex() <em>Parameter Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterIndex()
	 * @generated
	 * @ordered
	 */
	protected int parameterIndex = PARAMETER_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationParameterEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.OPERATION_PARAMETER_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getReferredParameter() {
		if (referredParameter != null && referredParameter.eIsProxy()) {
			InternalEObject oldReferredParameter = (InternalEObject)referredParameter;
			referredParameter = (Parameter)eResolveProxy(oldReferredParameter);
			if (referredParameter != oldReferredParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 7, oldReferredParameter, referredParameter));
			}
		}
		return referredParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetReferredParameter() {
		return referredParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredParameter(Parameter newReferredParameter) {
		Parameter oldReferredParameter = referredParameter;
		referredParameter = newReferredParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 7, oldReferredParameter, referredParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getParameterIndex() {
		return parameterIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameterIndex(int newParameterIndex) {
		int oldParameterIndex = parameterIndex;
		parameterIndex = newParameterIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 8, oldParameterIndex, parameterIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				if (resolve) return getReferredParameter();
				return basicGetReferredParameter();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				return getParameterIndex();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				setReferredParameter((Parameter)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				setParameterIndex((Integer)newValue);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				setReferredParameter((Parameter)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				setParameterIndex(PARAMETER_INDEX_EDEFAULT);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				return referredParameter != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				return parameterIndex != PARAMETER_INDEX_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTscheduleVisitor) {
			return (R) ((QVTscheduleVisitor<?>)visitor).visitOperationParameterEdge(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public @NonNull Edge createEdge(@NonNull Role edgeRole, @NonNull Utility utility, @NonNull Node sourceNode, @NonNull Node targetNode) {
		OperationParameterEdge newEdge = (OperationParameterEdge) super.createEdge(edgeRole, utility, sourceNode, targetNode);
		newEdge.setParameterIndex(getParameterIndex());
		newEdge.setReferredParameter(getReferredParameter());
		return newEdge;
	}

	@Override
	public @NonNull String toString() {
		return super.toString();
	}
} //OperationParameterEdgeImpl
