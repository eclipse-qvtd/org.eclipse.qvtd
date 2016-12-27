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
import delphi.designator;
import delphi.exprList;
import delphi.expression;
import delphi.factor;
import delphi.setConstructor;
import delphi.typeId;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.factorImpl#getDesignator <em>Designator</em>}</li>
 *   <li>{@link delphi.impl.factorImpl#getExpList <em>Exp List</em>}</li>
 *   <li>{@link delphi.impl.factorImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link delphi.impl.factorImpl#getString <em>String</em>}</li>
 *   <li>{@link delphi.impl.factorImpl#getNestedExp <em>Nested Exp</em>}</li>
 *   <li>{@link delphi.impl.factorImpl#getExp <em>Exp</em>}</li>
 *   <li>{@link delphi.impl.factorImpl#getSetConstuctor <em>Set Constuctor</em>}</li>
 *   <li>{@link delphi.impl.factorImpl#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class factorImpl extends termImpl implements factor {
	/**
	 * The cached value of the '{@link #getDesignator() <em>Designator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesignator()
	 * @generated
	 * @ordered
	 */
	protected designator designator;

	/**
	 * The cached value of the '{@link #getExpList() <em>Exp List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpList()
	 * @generated
	 * @ordered
	 */
	protected exprList expList;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected String number = NUMBER_EDEFAULT;

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
	 * The cached value of the '{@link #getNestedExp() <em>Nested Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedExp()
	 * @generated
	 * @ordered
	 */
	protected expression nestedExp;

	/**
	 * The cached value of the '{@link #getExp() <em>Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExp()
	 * @generated
	 * @ordered
	 */
	protected expression exp;

	/**
	 * The cached value of the '{@link #getSetConstuctor() <em>Set Constuctor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetConstuctor()
	 * @generated
	 * @ordered
	 */
	protected setConstructor setConstuctor;

	/**
	 * The cached value of the '{@link #getTypeRef() <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeRef()
	 * @generated
	 * @ordered
	 */
	protected typeId typeRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected factorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.FACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designator getDesignator() {
		return designator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDesignator(designator newDesignator, NotificationChain msgs) {
		designator oldDesignator = designator;
		designator = newDesignator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__DESIGNATOR, oldDesignator, newDesignator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesignator(designator newDesignator) {
		if (newDesignator != designator) {
			NotificationChain msgs = null;
			if (designator != null)
				msgs = ((InternalEObject)designator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__DESIGNATOR, null, msgs);
			if (newDesignator != null)
				msgs = ((InternalEObject)newDesignator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__DESIGNATOR, null, msgs);
			msgs = basicSetDesignator(newDesignator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__DESIGNATOR, newDesignator, newDesignator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public exprList getExpList() {
		return expList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpList(exprList newExpList, NotificationChain msgs) {
		exprList oldExpList = expList;
		expList = newExpList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__EXP_LIST, oldExpList, newExpList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpList(exprList newExpList) {
		if (newExpList != expList) {
			NotificationChain msgs = null;
			if (expList != null)
				msgs = ((InternalEObject)expList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__EXP_LIST, null, msgs);
			if (newExpList != null)
				msgs = ((InternalEObject)newExpList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__EXP_LIST, null, msgs);
			msgs = basicSetExpList(newExpList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__EXP_LIST, newExpList, newExpList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(String newNumber) {
		String oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__NUMBER, oldNumber, number));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__STRING, oldString, string));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public expression getNestedExp() {
		return nestedExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestedExp(expression newNestedExp, NotificationChain msgs) {
		expression oldNestedExp = nestedExp;
		nestedExp = newNestedExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__NESTED_EXP, oldNestedExp, newNestedExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestedExp(expression newNestedExp) {
		if (newNestedExp != nestedExp) {
			NotificationChain msgs = null;
			if (nestedExp != null)
				msgs = ((InternalEObject)nestedExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__NESTED_EXP, null, msgs);
			if (newNestedExp != null)
				msgs = ((InternalEObject)newNestedExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__NESTED_EXP, null, msgs);
			msgs = basicSetNestedExp(newNestedExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__NESTED_EXP, newNestedExp, newNestedExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public expression getExp() {
		return exp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExp(expression newExp, NotificationChain msgs) {
		expression oldExp = exp;
		exp = newExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__EXP, oldExp, newExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExp(expression newExp) {
		if (newExp != exp) {
			NotificationChain msgs = null;
			if (exp != null)
				msgs = ((InternalEObject)exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__EXP, null, msgs);
			if (newExp != null)
				msgs = ((InternalEObject)newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__EXP, null, msgs);
			msgs = basicSetExp(newExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__EXP, newExp, newExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public setConstructor getSetConstuctor() {
		return setConstuctor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSetConstuctor(setConstructor newSetConstuctor, NotificationChain msgs) {
		setConstructor oldSetConstuctor = setConstuctor;
		setConstuctor = newSetConstuctor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__SET_CONSTUCTOR, oldSetConstuctor, newSetConstuctor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetConstuctor(setConstructor newSetConstuctor) {
		if (newSetConstuctor != setConstuctor) {
			NotificationChain msgs = null;
			if (setConstuctor != null)
				msgs = ((InternalEObject)setConstuctor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__SET_CONSTUCTOR, null, msgs);
			if (newSetConstuctor != null)
				msgs = ((InternalEObject)newSetConstuctor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__SET_CONSTUCTOR, null, msgs);
			msgs = basicSetSetConstuctor(newSetConstuctor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__SET_CONSTUCTOR, newSetConstuctor, newSetConstuctor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public typeId getTypeRef() {
		return typeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeRef(typeId newTypeRef, NotificationChain msgs) {
		typeId oldTypeRef = typeRef;
		typeRef = newTypeRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__TYPE_REF, oldTypeRef, newTypeRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeRef(typeId newTypeRef) {
		if (newTypeRef != typeRef) {
			NotificationChain msgs = null;
			if (typeRef != null)
				msgs = ((InternalEObject)typeRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__TYPE_REF, null, msgs);
			if (newTypeRef != null)
				msgs = ((InternalEObject)newTypeRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FACTOR__TYPE_REF, null, msgs);
			msgs = basicSetTypeRef(newTypeRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.FACTOR__TYPE_REF, newTypeRef, newTypeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.FACTOR__DESIGNATOR:
				return basicSetDesignator(null, msgs);
			case DelphiPackage.FACTOR__EXP_LIST:
				return basicSetExpList(null, msgs);
			case DelphiPackage.FACTOR__NESTED_EXP:
				return basicSetNestedExp(null, msgs);
			case DelphiPackage.FACTOR__EXP:
				return basicSetExp(null, msgs);
			case DelphiPackage.FACTOR__SET_CONSTUCTOR:
				return basicSetSetConstuctor(null, msgs);
			case DelphiPackage.FACTOR__TYPE_REF:
				return basicSetTypeRef(null, msgs);
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
			case DelphiPackage.FACTOR__DESIGNATOR:
				return getDesignator();
			case DelphiPackage.FACTOR__EXP_LIST:
				return getExpList();
			case DelphiPackage.FACTOR__NUMBER:
				return getNumber();
			case DelphiPackage.FACTOR__STRING:
				return getString();
			case DelphiPackage.FACTOR__NESTED_EXP:
				return getNestedExp();
			case DelphiPackage.FACTOR__EXP:
				return getExp();
			case DelphiPackage.FACTOR__SET_CONSTUCTOR:
				return getSetConstuctor();
			case DelphiPackage.FACTOR__TYPE_REF:
				return getTypeRef();
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
			case DelphiPackage.FACTOR__DESIGNATOR:
				setDesignator((designator)newValue);
				return;
			case DelphiPackage.FACTOR__EXP_LIST:
				setExpList((exprList)newValue);
				return;
			case DelphiPackage.FACTOR__NUMBER:
				setNumber((String)newValue);
				return;
			case DelphiPackage.FACTOR__STRING:
				setString((String)newValue);
				return;
			case DelphiPackage.FACTOR__NESTED_EXP:
				setNestedExp((expression)newValue);
				return;
			case DelphiPackage.FACTOR__EXP:
				setExp((expression)newValue);
				return;
			case DelphiPackage.FACTOR__SET_CONSTUCTOR:
				setSetConstuctor((setConstructor)newValue);
				return;
			case DelphiPackage.FACTOR__TYPE_REF:
				setTypeRef((typeId)newValue);
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
			case DelphiPackage.FACTOR__DESIGNATOR:
				setDesignator((designator)null);
				return;
			case DelphiPackage.FACTOR__EXP_LIST:
				setExpList((exprList)null);
				return;
			case DelphiPackage.FACTOR__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case DelphiPackage.FACTOR__STRING:
				setString(STRING_EDEFAULT);
				return;
			case DelphiPackage.FACTOR__NESTED_EXP:
				setNestedExp((expression)null);
				return;
			case DelphiPackage.FACTOR__EXP:
				setExp((expression)null);
				return;
			case DelphiPackage.FACTOR__SET_CONSTUCTOR:
				setSetConstuctor((setConstructor)null);
				return;
			case DelphiPackage.FACTOR__TYPE_REF:
				setTypeRef((typeId)null);
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
			case DelphiPackage.FACTOR__DESIGNATOR:
				return designator != null;
			case DelphiPackage.FACTOR__EXP_LIST:
				return expList != null;
			case DelphiPackage.FACTOR__NUMBER:
				return NUMBER_EDEFAULT == null ? number != null : !NUMBER_EDEFAULT.equals(number);
			case DelphiPackage.FACTOR__STRING:
				return STRING_EDEFAULT == null ? string != null : !STRING_EDEFAULT.equals(string);
			case DelphiPackage.FACTOR__NESTED_EXP:
				return nestedExp != null;
			case DelphiPackage.FACTOR__EXP:
				return exp != null;
			case DelphiPackage.FACTOR__SET_CONSTUCTOR:
				return setConstuctor != null;
			case DelphiPackage.FACTOR__TYPE_REF:
				return typeRef != null;
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
		result.append(" (number: ");
		result.append(number);
		result.append(", string: ");
		result.append(string);
		result.append(')');
		return result.toString();
	}


} //factorImpl
