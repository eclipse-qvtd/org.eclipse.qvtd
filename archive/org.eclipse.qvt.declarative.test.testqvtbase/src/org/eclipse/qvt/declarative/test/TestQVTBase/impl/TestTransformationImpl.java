/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: TestTransformationImpl.java,v 1.2 2008/12/31 18:14:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.TestQVTBase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvt.declarative.ecore.QVTBase.impl.TransformationImpl;

import org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestTransformationImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestTransformationImpl#getStringBag <em>String Bag</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestTransformationImpl#getStringOrderedSet <em>String Ordered Set</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestTransformationImpl#getStringSequence <em>String Sequence</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestTransformationImpl#getStringSet <em>String Set</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestTransformationImpl#getString <em>String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestTransformationImpl extends TransformationImpl implements TestTransformation {
	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> contents;

	/**
	 * The cached value of the '{@link #getStringBag() <em>String Bag</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringBag()
	 * @generated
	 * @ordered
	 */
	protected EList<String> stringBag;

	/**
	 * The cached value of the '{@link #getStringOrderedSet() <em>String Ordered Set</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringOrderedSet()
	 * @generated
	 * @ordered
	 */
	protected EList<String> stringOrderedSet;

	/**
	 * The cached value of the '{@link #getStringSequence() <em>String Sequence</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<String> stringSequence;

	/**
	 * The cached value of the '{@link #getStringSet() <em>String Set</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringSet()
	 * @generated
	 * @ordered
	 */
	protected EList<String> stringSet;

	/**
	 * The default value of the '{@link #getString() <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getString()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getString() <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getString()
	 * @generated
	 * @ordered
	 */
	protected String string = STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestTransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestQVTBasePackage.Literals.TEST_TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getContents() {
		if (contents == null) {
			contents = new EObjectContainmentEList<EObject>(EObject.class, this, TestQVTBasePackage.TEST_TRANSFORMATION__CONTENTS);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStringBag() {
		if (stringBag == null) {
			stringBag = new EDataTypeEList<String>(String.class, this, TestQVTBasePackage.TEST_TRANSFORMATION__STRING_BAG);
		}
		return stringBag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStringOrderedSet() {
		if (stringOrderedSet == null) {
			stringOrderedSet = new EDataTypeUniqueEList<String>(String.class, this, TestQVTBasePackage.TEST_TRANSFORMATION__STRING_ORDERED_SET);
		}
		return stringOrderedSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStringSequence() {
		if (stringSequence == null) {
			stringSequence = new EDataTypeEList<String>(String.class, this, TestQVTBasePackage.TEST_TRANSFORMATION__STRING_SEQUENCE);
		}
		return stringSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStringSet() {
		if (stringSet == null) {
			stringSet = new EDataTypeUniqueEList<String>(String.class, this, TestQVTBasePackage.TEST_TRANSFORMATION__STRING_SET);
		}
		return stringSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getString() {
		return string;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setString(String newString) {
		String oldString = string;
		string = newString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestQVTBasePackage.TEST_TRANSFORMATION__STRING, oldString, string));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestQVTBasePackage.TEST_TRANSFORMATION__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
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
			case TestQVTBasePackage.TEST_TRANSFORMATION__CONTENTS:
				return getContents();
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_BAG:
				return getStringBag();
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_ORDERED_SET:
				return getStringOrderedSet();
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_SEQUENCE:
				return getStringSequence();
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_SET:
				return getStringSet();
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING:
				return getString();
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
			case TestQVTBasePackage.TEST_TRANSFORMATION__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends EObject>)newValue);
				return;
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_BAG:
				getStringBag().clear();
				getStringBag().addAll((Collection<? extends String>)newValue);
				return;
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_ORDERED_SET:
				getStringOrderedSet().clear();
				getStringOrderedSet().addAll((Collection<? extends String>)newValue);
				return;
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_SEQUENCE:
				getStringSequence().clear();
				getStringSequence().addAll((Collection<? extends String>)newValue);
				return;
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_SET:
				getStringSet().clear();
				getStringSet().addAll((Collection<? extends String>)newValue);
				return;
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING:
				setString((String)newValue);
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
			case TestQVTBasePackage.TEST_TRANSFORMATION__CONTENTS:
				getContents().clear();
				return;
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_BAG:
				getStringBag().clear();
				return;
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_ORDERED_SET:
				getStringOrderedSet().clear();
				return;
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_SEQUENCE:
				getStringSequence().clear();
				return;
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_SET:
				getStringSet().clear();
				return;
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING:
				setString(STRING_EDEFAULT);
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
			case TestQVTBasePackage.TEST_TRANSFORMATION__CONTENTS:
				return contents != null && !contents.isEmpty();
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_BAG:
				return stringBag != null && !stringBag.isEmpty();
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_ORDERED_SET:
				return stringOrderedSet != null && !stringOrderedSet.isEmpty();
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_SEQUENCE:
				return stringSequence != null && !stringSequence.isEmpty();
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING_SET:
				return stringSet != null && !stringSet.isEmpty();
			case TestQVTBasePackage.TEST_TRANSFORMATION__STRING:
				return STRING_EDEFAULT == null ? string != null : !STRING_EDEFAULT.equals(string);
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
		result.append(" (stringBag: ");
		result.append(stringBag);
		result.append(", stringOrderedSet: ");
		result.append(stringOrderedSet);
		result.append(", stringSequence: ");
		result.append(stringSequence);
		result.append(", stringSet: ");
		result.append(stringSet);
		result.append(", string: ");
		result.append(string);
		result.append(')');
		return result.toString();
	}

} //TestTransformationImpl
