/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example2.classescs.impl;

import example2.classescs.ClassescsPackage;
import example2.classescs.NameExpCS;
import example2.classescs.OperationCS;

import example2.classescs.PathNameCS;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example2.classescs.impl.OperationCSImpl#getParams <em>Params</em>}</li>
 *   <li>{@link example2.classescs.impl.OperationCSImpl#getBodyExps <em>Body Exps</em>}</li>
 *   <li>{@link example2.classescs.impl.OperationCSImpl#getResultRef <em>Result Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationCSImpl extends NamedElementCSImpl implements OperationCS {
	/**
	 * The number of structural features of the '<em>Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OPERATION_CS_FEATURE_COUNT = NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 3;
	/**
	 * The number of operations of the '<em>Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OPERATION_CS_OPERATION_COUNT = NamedElementCSImpl.NAMED_ELEMENT_CS_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected EList<String> params;
	/**
	 * The cached value of the '{@link #getBodyExps() <em>Body Exps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyExps()
	 * @generated
	 * @ordered
	 */
	protected EList<NameExpCS> bodyExps;
	/**
	 * The cached value of the '{@link #getResultRef() <em>Result Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultRef()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS resultRef;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassescsPackage.Literals.OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getParams() {
		if (params == null) {
			params = new EDataTypeUniqueEList<String>(String.class, this, 2);
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NameExpCS> getBodyExps() {
		if (bodyExps == null) {
			bodyExps = new EObjectContainmentEList<NameExpCS>(NameExpCS.class, this, 3);
		}
		return bodyExps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS getResultRef() {
		return resultRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultRef(PathNameCS newResultRef, NotificationChain msgs) {
		PathNameCS oldResultRef = resultRef;
		resultRef = newResultRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 4, oldResultRef, newResultRef);
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
	public void setResultRef(PathNameCS newResultRef) {
		if (newResultRef != resultRef) {
			NotificationChain msgs = null;
			if (resultRef != null)
				msgs = ((InternalEObject)resultRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (4), null, msgs);
			if (newResultRef != null)
				msgs = ((InternalEObject)newResultRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (4), null, msgs);
			msgs = basicSetResultRef(newResultRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 4, newResultRef, newResultRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 3:
				return ((InternalEList<?>)getBodyExps()).basicRemove(otherEnd, msgs);
			case 4:
				return basicSetResultRef(null, msgs);
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
			case 2:
				return getParams();
			case 3:
				return getBodyExps();
			case 4:
				return getResultRef();
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
			case 2:
				getParams().clear();
				getParams().addAll((Collection<? extends String>)newValue);
				return;
			case 3:
				getBodyExps().clear();
				getBodyExps().addAll((Collection<? extends NameExpCS>)newValue);
				return;
			case 4:
				setResultRef((PathNameCS)newValue);
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
			case 2:
				getParams().clear();
				return;
			case 3:
				getBodyExps().clear();
				return;
			case 4:
				setResultRef((PathNameCS)null);
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
			case 2:
				return params != null && !params.isEmpty();
			case 3:
				return bodyExps != null && !bodyExps.isEmpty();
			case 4:
				return resultRef != null;
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
		result.append(" (params: ");
		result.append(params);
		result.append(')');
		return result.toString();
	}


} //OperationCSImpl
