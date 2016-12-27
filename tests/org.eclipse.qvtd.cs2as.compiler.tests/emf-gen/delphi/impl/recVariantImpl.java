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
import delphi.fieldList;
import delphi.recVariant;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>rec Variant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.recVariantImpl#getConstExp <em>Const Exp</em>}</li>
 *   <li>{@link delphi.impl.recVariantImpl#getFieldList <em>Field List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class recVariantImpl extends CSTraceImpl implements recVariant {
	/**
	 * The cached value of the '{@link #getConstExp() <em>Const Exp</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstExp()
	 * @generated
	 * @ordered
	 */
	protected EList<constExpr> constExp;

	/**
	 * The cached value of the '{@link #getFieldList() <em>Field List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldList()
	 * @generated
	 * @ordered
	 */
	protected fieldList fieldList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected recVariantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.REC_VARIANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<constExpr> getConstExp() {
		if (constExp == null) {
			constExp = new EObjectContainmentEList<constExpr>(constExpr.class, this, DelphiPackage.REC_VARIANT__CONST_EXP);
		}
		return constExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fieldList getFieldList() {
		return fieldList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFieldList(fieldList newFieldList, NotificationChain msgs) {
		fieldList oldFieldList = fieldList;
		fieldList = newFieldList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.REC_VARIANT__FIELD_LIST, oldFieldList, newFieldList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldList(fieldList newFieldList) {
		if (newFieldList != fieldList) {
			NotificationChain msgs = null;
			if (fieldList != null)
				msgs = ((InternalEObject)fieldList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.REC_VARIANT__FIELD_LIST, null, msgs);
			if (newFieldList != null)
				msgs = ((InternalEObject)newFieldList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.REC_VARIANT__FIELD_LIST, null, msgs);
			msgs = basicSetFieldList(newFieldList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.REC_VARIANT__FIELD_LIST, newFieldList, newFieldList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.REC_VARIANT__CONST_EXP:
				return ((InternalEList<?>)getConstExp()).basicRemove(otherEnd, msgs);
			case DelphiPackage.REC_VARIANT__FIELD_LIST:
				return basicSetFieldList(null, msgs);
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
			case DelphiPackage.REC_VARIANT__CONST_EXP:
				return getConstExp();
			case DelphiPackage.REC_VARIANT__FIELD_LIST:
				return getFieldList();
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
			case DelphiPackage.REC_VARIANT__CONST_EXP:
				getConstExp().clear();
				getConstExp().addAll((Collection<? extends constExpr>)newValue);
				return;
			case DelphiPackage.REC_VARIANT__FIELD_LIST:
				setFieldList((fieldList)newValue);
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
			case DelphiPackage.REC_VARIANT__CONST_EXP:
				getConstExp().clear();
				return;
			case DelphiPackage.REC_VARIANT__FIELD_LIST:
				setFieldList((fieldList)null);
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
			case DelphiPackage.REC_VARIANT__CONST_EXP:
				return constExp != null && !constExp.isEmpty();
			case DelphiPackage.REC_VARIANT__FIELD_LIST:
				return fieldList != null;
		}
		return super.eIsSet(featureID);
	}


} //recVariantImpl
