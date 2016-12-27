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
import delphi.designatorPart;
import delphi.designatorSubPart;
import delphi.exprList;

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
 * An implementation of the model object '<em><b>designator Sub Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.designatorSubPartImpl#getPart <em>Part</em>}</li>
 *   <li>{@link delphi.impl.designatorSubPartImpl#getExprList <em>Expr List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class designatorSubPartImpl extends CSTraceImpl implements designatorSubPart {
	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected designatorPart part;

	/**
	 * The cached value of the '{@link #getExprList() <em>Expr List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExprList()
	 * @generated
	 * @ordered
	 */
	protected EList<exprList> exprList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected designatorSubPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.DESIGNATOR_SUB_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designatorPart getPart() {
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPart(designatorPart newPart, NotificationChain msgs) {
		designatorPart oldPart = part;
		part = newPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.DESIGNATOR_SUB_PART__PART, oldPart, newPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPart(designatorPart newPart) {
		if (newPart != part) {
			NotificationChain msgs = null;
			if (part != null)
				msgs = ((InternalEObject)part).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.DESIGNATOR_SUB_PART__PART, null, msgs);
			if (newPart != null)
				msgs = ((InternalEObject)newPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.DESIGNATOR_SUB_PART__PART, null, msgs);
			msgs = basicSetPart(newPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.DESIGNATOR_SUB_PART__PART, newPart, newPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<exprList> getExprList() {
		if (exprList == null) {
			exprList = new EObjectContainmentEList<exprList>(exprList.class, this, DelphiPackage.DESIGNATOR_SUB_PART__EXPR_LIST);
		}
		return exprList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.DESIGNATOR_SUB_PART__PART:
				return basicSetPart(null, msgs);
			case DelphiPackage.DESIGNATOR_SUB_PART__EXPR_LIST:
				return ((InternalEList<?>)getExprList()).basicRemove(otherEnd, msgs);
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
			case DelphiPackage.DESIGNATOR_SUB_PART__PART:
				return getPart();
			case DelphiPackage.DESIGNATOR_SUB_PART__EXPR_LIST:
				return getExprList();
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
			case DelphiPackage.DESIGNATOR_SUB_PART__PART:
				setPart((designatorPart)newValue);
				return;
			case DelphiPackage.DESIGNATOR_SUB_PART__EXPR_LIST:
				getExprList().clear();
				getExprList().addAll((Collection<? extends exprList>)newValue);
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
			case DelphiPackage.DESIGNATOR_SUB_PART__PART:
				setPart((designatorPart)null);
				return;
			case DelphiPackage.DESIGNATOR_SUB_PART__EXPR_LIST:
				getExprList().clear();
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
			case DelphiPackage.DESIGNATOR_SUB_PART__PART:
				return part != null;
			case DelphiPackage.DESIGNATOR_SUB_PART__EXPR_LIST:
				return exprList != null && !exprList.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //designatorSubPartImpl
