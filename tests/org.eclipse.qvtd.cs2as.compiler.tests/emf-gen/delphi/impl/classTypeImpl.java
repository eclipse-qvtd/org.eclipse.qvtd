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
import delphi.classFieldList;
import delphi.classHeritage;
import delphi.classMethodList;
import delphi.classPropertyList;
import delphi.classType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>class Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.classTypeImpl#getHeritage <em>Heritage</em>}</li>
 *   <li>{@link delphi.impl.classTypeImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link delphi.impl.classTypeImpl#getFieldList <em>Field List</em>}</li>
 *   <li>{@link delphi.impl.classTypeImpl#getMethodList <em>Method List</em>}</li>
 *   <li>{@link delphi.impl.classTypeImpl#getPropList <em>Prop List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class classTypeImpl extends restrictedTypeImpl implements classType {
	/**
	 * The cached value of the '{@link #getHeritage() <em>Heritage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeritage()
	 * @generated
	 * @ordered
	 */
	protected classHeritage heritage;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final String VISIBILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected String visibility = VISIBILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFieldList() <em>Field List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldList()
	 * @generated
	 * @ordered
	 */
	protected classFieldList fieldList;

	/**
	 * The cached value of the '{@link #getMethodList() <em>Method List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodList()
	 * @generated
	 * @ordered
	 */
	protected classMethodList methodList;

	/**
	 * The cached value of the '{@link #getPropList() <em>Prop List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropList()
	 * @generated
	 * @ordered
	 */
	protected classPropertyList propList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected classTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.CLASS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classHeritage getHeritage() {
		return heritage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeritage(classHeritage newHeritage, NotificationChain msgs) {
		classHeritage oldHeritage = heritage;
		heritage = newHeritage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.CLASS_TYPE__HERITAGE, oldHeritage, newHeritage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeritage(classHeritage newHeritage) {
		if (newHeritage != heritage) {
			NotificationChain msgs = null;
			if (heritage != null)
				msgs = ((InternalEObject)heritage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CLASS_TYPE__HERITAGE, null, msgs);
			if (newHeritage != null)
				msgs = ((InternalEObject)newHeritage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CLASS_TYPE__HERITAGE, null, msgs);
			msgs = basicSetHeritage(newHeritage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.CLASS_TYPE__HERITAGE, newHeritage, newHeritage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(String newVisibility) {
		String oldVisibility = visibility;
		visibility = newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.CLASS_TYPE__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classFieldList getFieldList() {
		return fieldList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFieldList(classFieldList newFieldList, NotificationChain msgs) {
		classFieldList oldFieldList = fieldList;
		fieldList = newFieldList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.CLASS_TYPE__FIELD_LIST, oldFieldList, newFieldList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldList(classFieldList newFieldList) {
		if (newFieldList != fieldList) {
			NotificationChain msgs = null;
			if (fieldList != null)
				msgs = ((InternalEObject)fieldList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CLASS_TYPE__FIELD_LIST, null, msgs);
			if (newFieldList != null)
				msgs = ((InternalEObject)newFieldList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CLASS_TYPE__FIELD_LIST, null, msgs);
			msgs = basicSetFieldList(newFieldList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.CLASS_TYPE__FIELD_LIST, newFieldList, newFieldList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classMethodList getMethodList() {
		return methodList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMethodList(classMethodList newMethodList, NotificationChain msgs) {
		classMethodList oldMethodList = methodList;
		methodList = newMethodList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.CLASS_TYPE__METHOD_LIST, oldMethodList, newMethodList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodList(classMethodList newMethodList) {
		if (newMethodList != methodList) {
			NotificationChain msgs = null;
			if (methodList != null)
				msgs = ((InternalEObject)methodList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CLASS_TYPE__METHOD_LIST, null, msgs);
			if (newMethodList != null)
				msgs = ((InternalEObject)newMethodList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CLASS_TYPE__METHOD_LIST, null, msgs);
			msgs = basicSetMethodList(newMethodList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.CLASS_TYPE__METHOD_LIST, newMethodList, newMethodList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classPropertyList getPropList() {
		return propList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropList(classPropertyList newPropList, NotificationChain msgs) {
		classPropertyList oldPropList = propList;
		propList = newPropList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.CLASS_TYPE__PROP_LIST, oldPropList, newPropList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropList(classPropertyList newPropList) {
		if (newPropList != propList) {
			NotificationChain msgs = null;
			if (propList != null)
				msgs = ((InternalEObject)propList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CLASS_TYPE__PROP_LIST, null, msgs);
			if (newPropList != null)
				msgs = ((InternalEObject)newPropList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CLASS_TYPE__PROP_LIST, null, msgs);
			msgs = basicSetPropList(newPropList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.CLASS_TYPE__PROP_LIST, newPropList, newPropList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.CLASS_TYPE__HERITAGE:
				return basicSetHeritage(null, msgs);
			case DelphiPackage.CLASS_TYPE__FIELD_LIST:
				return basicSetFieldList(null, msgs);
			case DelphiPackage.CLASS_TYPE__METHOD_LIST:
				return basicSetMethodList(null, msgs);
			case DelphiPackage.CLASS_TYPE__PROP_LIST:
				return basicSetPropList(null, msgs);
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
			case DelphiPackage.CLASS_TYPE__HERITAGE:
				return getHeritage();
			case DelphiPackage.CLASS_TYPE__VISIBILITY:
				return getVisibility();
			case DelphiPackage.CLASS_TYPE__FIELD_LIST:
				return getFieldList();
			case DelphiPackage.CLASS_TYPE__METHOD_LIST:
				return getMethodList();
			case DelphiPackage.CLASS_TYPE__PROP_LIST:
				return getPropList();
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
			case DelphiPackage.CLASS_TYPE__HERITAGE:
				setHeritage((classHeritage)newValue);
				return;
			case DelphiPackage.CLASS_TYPE__VISIBILITY:
				setVisibility((String)newValue);
				return;
			case DelphiPackage.CLASS_TYPE__FIELD_LIST:
				setFieldList((classFieldList)newValue);
				return;
			case DelphiPackage.CLASS_TYPE__METHOD_LIST:
				setMethodList((classMethodList)newValue);
				return;
			case DelphiPackage.CLASS_TYPE__PROP_LIST:
				setPropList((classPropertyList)newValue);
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
			case DelphiPackage.CLASS_TYPE__HERITAGE:
				setHeritage((classHeritage)null);
				return;
			case DelphiPackage.CLASS_TYPE__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case DelphiPackage.CLASS_TYPE__FIELD_LIST:
				setFieldList((classFieldList)null);
				return;
			case DelphiPackage.CLASS_TYPE__METHOD_LIST:
				setMethodList((classMethodList)null);
				return;
			case DelphiPackage.CLASS_TYPE__PROP_LIST:
				setPropList((classPropertyList)null);
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
			case DelphiPackage.CLASS_TYPE__HERITAGE:
				return heritage != null;
			case DelphiPackage.CLASS_TYPE__VISIBILITY:
				return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
			case DelphiPackage.CLASS_TYPE__FIELD_LIST:
				return fieldList != null;
			case DelphiPackage.CLASS_TYPE__METHOD_LIST:
				return methodList != null;
			case DelphiPackage.CLASS_TYPE__PROP_LIST:
				return propList != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (visibility: ");
		result.append(visibility);
		result.append(')');
		return result.toString();
	}


} //classTypeImpl
