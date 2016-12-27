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
import delphi.formalParameters;
import delphi.ident;
import delphi.methodHeading;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>method Heading</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.methodHeadingImpl#getId <em>Id</em>}</li>
 *   <li>{@link delphi.impl.methodHeadingImpl#getFormalParams <em>Formal Params</em>}</li>
 * </ul>
 *
 * @generated
 */
public class methodHeadingImpl extends CSTraceImpl implements methodHeading {
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected ident id;

	/**
	 * The cached value of the '{@link #getFormalParams() <em>Formal Params</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormalParams()
	 * @generated
	 * @ordered
	 */
	protected formalParameters formalParams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected methodHeadingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.METHOD_HEADING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ident getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetId(ident newId, NotificationChain msgs) {
		ident oldId = id;
		id = newId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.METHOD_HEADING__ID, oldId, newId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(ident newId) {
		if (newId != id) {
			NotificationChain msgs = null;
			if (id != null)
				msgs = ((InternalEObject)id).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.METHOD_HEADING__ID, null, msgs);
			if (newId != null)
				msgs = ((InternalEObject)newId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.METHOD_HEADING__ID, null, msgs);
			msgs = basicSetId(newId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.METHOD_HEADING__ID, newId, newId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public formalParameters getFormalParams() {
		return formalParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFormalParams(formalParameters newFormalParams, NotificationChain msgs) {
		formalParameters oldFormalParams = formalParams;
		formalParams = newFormalParams;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.METHOD_HEADING__FORMAL_PARAMS, oldFormalParams, newFormalParams);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormalParams(formalParameters newFormalParams) {
		if (newFormalParams != formalParams) {
			NotificationChain msgs = null;
			if (formalParams != null)
				msgs = ((InternalEObject)formalParams).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.METHOD_HEADING__FORMAL_PARAMS, null, msgs);
			if (newFormalParams != null)
				msgs = ((InternalEObject)newFormalParams).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.METHOD_HEADING__FORMAL_PARAMS, null, msgs);
			msgs = basicSetFormalParams(newFormalParams, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.METHOD_HEADING__FORMAL_PARAMS, newFormalParams, newFormalParams));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.METHOD_HEADING__ID:
				return basicSetId(null, msgs);
			case DelphiPackage.METHOD_HEADING__FORMAL_PARAMS:
				return basicSetFormalParams(null, msgs);
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
			case DelphiPackage.METHOD_HEADING__ID:
				return getId();
			case DelphiPackage.METHOD_HEADING__FORMAL_PARAMS:
				return getFormalParams();
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
			case DelphiPackage.METHOD_HEADING__ID:
				setId((ident)newValue);
				return;
			case DelphiPackage.METHOD_HEADING__FORMAL_PARAMS:
				setFormalParams((formalParameters)newValue);
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
			case DelphiPackage.METHOD_HEADING__ID:
				setId((ident)null);
				return;
			case DelphiPackage.METHOD_HEADING__FORMAL_PARAMS:
				setFormalParams((formalParameters)null);
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
			case DelphiPackage.METHOD_HEADING__ID:
				return id != null;
			case DelphiPackage.METHOD_HEADING__FORMAL_PARAMS:
				return formalParams != null;
		}
		return super.eIsSet(featureID);
	}


} //methodHeadingImpl
