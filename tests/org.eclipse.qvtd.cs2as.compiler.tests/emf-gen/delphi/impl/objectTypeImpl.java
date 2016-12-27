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
import delphi.methodList;
import delphi.objFieldList;
import delphi.objHeritage;
import delphi.objectType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>object Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.objectTypeImpl#getHeritage <em>Heritage</em>}</li>
 *   <li>{@link delphi.impl.objectTypeImpl#getFieldList <em>Field List</em>}</li>
 *   <li>{@link delphi.impl.objectTypeImpl#getMethodList <em>Method List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class objectTypeImpl extends restrictedTypeImpl implements objectType {
	/**
	 * The cached value of the '{@link #getHeritage() <em>Heritage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeritage()
	 * @generated
	 * @ordered
	 */
	protected objHeritage heritage;

	/**
	 * The cached value of the '{@link #getFieldList() <em>Field List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldList()
	 * @generated
	 * @ordered
	 */
	protected objFieldList fieldList;

	/**
	 * The cached value of the '{@link #getMethodList() <em>Method List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodList()
	 * @generated
	 * @ordered
	 */
	protected methodList methodList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected objectTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.OBJECT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public objHeritage getHeritage() {
		return heritage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeritage(objHeritage newHeritage, NotificationChain msgs) {
		objHeritage oldHeritage = heritage;
		heritage = newHeritage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.OBJECT_TYPE__HERITAGE, oldHeritage, newHeritage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeritage(objHeritage newHeritage) {
		if (newHeritage != heritage) {
			NotificationChain msgs = null;
			if (heritage != null)
				msgs = ((InternalEObject)heritage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.OBJECT_TYPE__HERITAGE, null, msgs);
			if (newHeritage != null)
				msgs = ((InternalEObject)newHeritage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.OBJECT_TYPE__HERITAGE, null, msgs);
			msgs = basicSetHeritage(newHeritage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.OBJECT_TYPE__HERITAGE, newHeritage, newHeritage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public objFieldList getFieldList() {
		return fieldList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFieldList(objFieldList newFieldList, NotificationChain msgs) {
		objFieldList oldFieldList = fieldList;
		fieldList = newFieldList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.OBJECT_TYPE__FIELD_LIST, oldFieldList, newFieldList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldList(objFieldList newFieldList) {
		if (newFieldList != fieldList) {
			NotificationChain msgs = null;
			if (fieldList != null)
				msgs = ((InternalEObject)fieldList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.OBJECT_TYPE__FIELD_LIST, null, msgs);
			if (newFieldList != null)
				msgs = ((InternalEObject)newFieldList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.OBJECT_TYPE__FIELD_LIST, null, msgs);
			msgs = basicSetFieldList(newFieldList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.OBJECT_TYPE__FIELD_LIST, newFieldList, newFieldList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public methodList getMethodList() {
		return methodList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMethodList(methodList newMethodList, NotificationChain msgs) {
		methodList oldMethodList = methodList;
		methodList = newMethodList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.OBJECT_TYPE__METHOD_LIST, oldMethodList, newMethodList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodList(methodList newMethodList) {
		if (newMethodList != methodList) {
			NotificationChain msgs = null;
			if (methodList != null)
				msgs = ((InternalEObject)methodList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.OBJECT_TYPE__METHOD_LIST, null, msgs);
			if (newMethodList != null)
				msgs = ((InternalEObject)newMethodList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.OBJECT_TYPE__METHOD_LIST, null, msgs);
			msgs = basicSetMethodList(newMethodList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.OBJECT_TYPE__METHOD_LIST, newMethodList, newMethodList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.OBJECT_TYPE__HERITAGE:
				return basicSetHeritage(null, msgs);
			case DelphiPackage.OBJECT_TYPE__FIELD_LIST:
				return basicSetFieldList(null, msgs);
			case DelphiPackage.OBJECT_TYPE__METHOD_LIST:
				return basicSetMethodList(null, msgs);
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
			case DelphiPackage.OBJECT_TYPE__HERITAGE:
				return getHeritage();
			case DelphiPackage.OBJECT_TYPE__FIELD_LIST:
				return getFieldList();
			case DelphiPackage.OBJECT_TYPE__METHOD_LIST:
				return getMethodList();
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
			case DelphiPackage.OBJECT_TYPE__HERITAGE:
				setHeritage((objHeritage)newValue);
				return;
			case DelphiPackage.OBJECT_TYPE__FIELD_LIST:
				setFieldList((objFieldList)newValue);
				return;
			case DelphiPackage.OBJECT_TYPE__METHOD_LIST:
				setMethodList((methodList)newValue);
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
			case DelphiPackage.OBJECT_TYPE__HERITAGE:
				setHeritage((objHeritage)null);
				return;
			case DelphiPackage.OBJECT_TYPE__FIELD_LIST:
				setFieldList((objFieldList)null);
				return;
			case DelphiPackage.OBJECT_TYPE__METHOD_LIST:
				setMethodList((methodList)null);
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
			case DelphiPackage.OBJECT_TYPE__HERITAGE:
				return heritage != null;
			case DelphiPackage.OBJECT_TYPE__FIELD_LIST:
				return fieldList != null;
			case DelphiPackage.OBJECT_TYPE__METHOD_LIST:
				return methodList != null;
		}
		return super.eIsSet(featureID);
	}


} //objectTypeImpl
