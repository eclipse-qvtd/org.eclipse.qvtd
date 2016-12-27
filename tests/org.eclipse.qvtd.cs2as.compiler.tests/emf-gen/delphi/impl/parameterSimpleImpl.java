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
import delphi.constExpr;
import delphi.ident;
import delphi.parameterSimple;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>parameter Simple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.parameterSimpleImpl#getIf <em>If</em>}</li>
 *   <li>{@link delphi.impl.parameterSimpleImpl#getInitExp <em>Init Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class parameterSimpleImpl extends parameterImpl implements parameterSimple {
	/**
	 * The cached value of the '{@link #getIf() <em>If</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIf()
	 * @generated
	 * @ordered
	 */
	protected ident if_;

	/**
	 * The cached value of the '{@link #getInitExp() <em>Init Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitExp()
	 * @generated
	 * @ordered
	 */
	protected constExpr initExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected parameterSimpleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.PARAMETER_SIMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ident getIf() {
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIf(ident newIf, NotificationChain msgs) {
		ident oldIf = if_;
		if_ = newIf;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PARAMETER_SIMPLE__IF, oldIf, newIf);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIf(ident newIf) {
		if (newIf != if_) {
			NotificationChain msgs = null;
			if (if_ != null)
				msgs = ((InternalEObject)if_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PARAMETER_SIMPLE__IF, null, msgs);
			if (newIf != null)
				msgs = ((InternalEObject)newIf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PARAMETER_SIMPLE__IF, null, msgs);
			msgs = basicSetIf(newIf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PARAMETER_SIMPLE__IF, newIf, newIf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constExpr getInitExp() {
		return initExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExp(constExpr newInitExp, NotificationChain msgs) {
		constExpr oldInitExp = initExp;
		initExp = newInitExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PARAMETER_SIMPLE__INIT_EXP, oldInitExp, newInitExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExp(constExpr newInitExp) {
		if (newInitExp != initExp) {
			NotificationChain msgs = null;
			if (initExp != null)
				msgs = ((InternalEObject)initExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PARAMETER_SIMPLE__INIT_EXP, null, msgs);
			if (newInitExp != null)
				msgs = ((InternalEObject)newInitExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PARAMETER_SIMPLE__INIT_EXP, null, msgs);
			msgs = basicSetInitExp(newInitExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PARAMETER_SIMPLE__INIT_EXP, newInitExp, newInitExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.PARAMETER_SIMPLE__IF:
				return basicSetIf(null, msgs);
			case DelphiPackage.PARAMETER_SIMPLE__INIT_EXP:
				return basicSetInitExp(null, msgs);
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
			case DelphiPackage.PARAMETER_SIMPLE__IF:
				return getIf();
			case DelphiPackage.PARAMETER_SIMPLE__INIT_EXP:
				return getInitExp();
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
			case DelphiPackage.PARAMETER_SIMPLE__IF:
				setIf((ident)newValue);
				return;
			case DelphiPackage.PARAMETER_SIMPLE__INIT_EXP:
				setInitExp((constExpr)newValue);
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
			case DelphiPackage.PARAMETER_SIMPLE__IF:
				setIf((ident)null);
				return;
			case DelphiPackage.PARAMETER_SIMPLE__INIT_EXP:
				setInitExp((constExpr)null);
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
			case DelphiPackage.PARAMETER_SIMPLE__IF:
				return if_ != null;
			case DelphiPackage.PARAMETER_SIMPLE__INIT_EXP:
				return initExp != null;
		}
		return super.eIsSet(featureID);
	}


} //parameterSimpleImpl
