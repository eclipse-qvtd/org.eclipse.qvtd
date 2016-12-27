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
import delphi.classMethodList;
import delphi.classPropertyList;
import delphi.interfaceHeritage;
import delphi.interfaceType;

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
 * An implementation of the model object '<em><b>interface Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.interfaceTypeImpl#getHeritage <em>Heritage</em>}</li>
 *   <li>{@link delphi.impl.interfaceTypeImpl#getMethodList <em>Method List</em>}</li>
 *   <li>{@link delphi.impl.interfaceTypeImpl#getPropList <em>Prop List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class interfaceTypeImpl extends restrictedTypeImpl implements interfaceType {
	/**
	 * The cached value of the '{@link #getHeritage() <em>Heritage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeritage()
	 * @generated
	 * @ordered
	 */
	protected interfaceHeritage heritage;

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
	 * The cached value of the '{@link #getPropList() <em>Prop List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropList()
	 * @generated
	 * @ordered
	 */
	protected EList<classPropertyList> propList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected interfaceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.INTERFACE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interfaceHeritage getHeritage() {
		return heritage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeritage(interfaceHeritage newHeritage, NotificationChain msgs) {
		interfaceHeritage oldHeritage = heritage;
		heritage = newHeritage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.INTERFACE_TYPE__HERITAGE, oldHeritage, newHeritage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeritage(interfaceHeritage newHeritage) {
		if (newHeritage != heritage) {
			NotificationChain msgs = null;
			if (heritage != null)
				msgs = ((InternalEObject)heritage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.INTERFACE_TYPE__HERITAGE, null, msgs);
			if (newHeritage != null)
				msgs = ((InternalEObject)newHeritage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.INTERFACE_TYPE__HERITAGE, null, msgs);
			msgs = basicSetHeritage(newHeritage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.INTERFACE_TYPE__HERITAGE, newHeritage, newHeritage));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.INTERFACE_TYPE__METHOD_LIST, oldMethodList, newMethodList);
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
				msgs = ((InternalEObject)methodList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.INTERFACE_TYPE__METHOD_LIST, null, msgs);
			if (newMethodList != null)
				msgs = ((InternalEObject)newMethodList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.INTERFACE_TYPE__METHOD_LIST, null, msgs);
			msgs = basicSetMethodList(newMethodList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.INTERFACE_TYPE__METHOD_LIST, newMethodList, newMethodList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<classPropertyList> getPropList() {
		if (propList == null) {
			propList = new EObjectContainmentEList<classPropertyList>(classPropertyList.class, this, DelphiPackage.INTERFACE_TYPE__PROP_LIST);
		}
		return propList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.INTERFACE_TYPE__HERITAGE:
				return basicSetHeritage(null, msgs);
			case DelphiPackage.INTERFACE_TYPE__METHOD_LIST:
				return basicSetMethodList(null, msgs);
			case DelphiPackage.INTERFACE_TYPE__PROP_LIST:
				return ((InternalEList<?>)getPropList()).basicRemove(otherEnd, msgs);
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
			case DelphiPackage.INTERFACE_TYPE__HERITAGE:
				return getHeritage();
			case DelphiPackage.INTERFACE_TYPE__METHOD_LIST:
				return getMethodList();
			case DelphiPackage.INTERFACE_TYPE__PROP_LIST:
				return getPropList();
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
			case DelphiPackage.INTERFACE_TYPE__HERITAGE:
				setHeritage((interfaceHeritage)newValue);
				return;
			case DelphiPackage.INTERFACE_TYPE__METHOD_LIST:
				setMethodList((classMethodList)newValue);
				return;
			case DelphiPackage.INTERFACE_TYPE__PROP_LIST:
				getPropList().clear();
				getPropList().addAll((Collection<? extends classPropertyList>)newValue);
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
			case DelphiPackage.INTERFACE_TYPE__HERITAGE:
				setHeritage((interfaceHeritage)null);
				return;
			case DelphiPackage.INTERFACE_TYPE__METHOD_LIST:
				setMethodList((classMethodList)null);
				return;
			case DelphiPackage.INTERFACE_TYPE__PROP_LIST:
				getPropList().clear();
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
			case DelphiPackage.INTERFACE_TYPE__HERITAGE:
				return heritage != null;
			case DelphiPackage.INTERFACE_TYPE__METHOD_LIST:
				return methodList != null;
			case DelphiPackage.INTERFACE_TYPE__PROP_LIST:
				return propList != null && !propList.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //interfaceTypeImpl
