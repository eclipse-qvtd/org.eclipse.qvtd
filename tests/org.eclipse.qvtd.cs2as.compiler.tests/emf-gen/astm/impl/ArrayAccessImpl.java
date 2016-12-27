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
package astm.impl;

import astm.ArrayAccess;
import astm.AstmPackage;
import astm.Expression;

import astm.util.Visitor;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.ArrayAccessImpl#getArrayName <em>Array Name</em>}</li>
 *   <li>{@link astm.impl.ArrayAccessImpl#getSubscripts <em>Subscripts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArrayAccessImpl extends ExpressionImpl implements ArrayAccess {
	/**
	 * The cached value of the '{@link #getArrayName() <em>Array Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayName()
	 * @generated
	 * @ordered
	 */
	protected Expression arrayName;

	/**
	 * The cached value of the '{@link #getSubscripts() <em>Subscripts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubscripts()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> subscripts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.ARRAY_ACCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getArrayName() {
		return arrayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArrayName(Expression newArrayName, NotificationChain msgs) {
		Expression oldArrayName = arrayName;
		arrayName = newArrayName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.ARRAY_ACCESS__ARRAY_NAME, oldArrayName, newArrayName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrayName(Expression newArrayName) {
		if (newArrayName != arrayName) {
			NotificationChain msgs = null;
			if (arrayName != null)
				msgs = ((InternalEObject)arrayName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.ARRAY_ACCESS__ARRAY_NAME, null, msgs);
			if (newArrayName != null)
				msgs = ((InternalEObject)newArrayName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.ARRAY_ACCESS__ARRAY_NAME, null, msgs);
			msgs = basicSetArrayName(newArrayName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.ARRAY_ACCESS__ARRAY_NAME, newArrayName, newArrayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getSubscripts() {
		if (subscripts == null) {
			subscripts = new EObjectContainmentEList<Expression>(Expression.class, this, AstmPackage.ARRAY_ACCESS__SUBSCRIPTS);
		}
		return subscripts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.ARRAY_ACCESS__ARRAY_NAME:
				return basicSetArrayName(null, msgs);
			case AstmPackage.ARRAY_ACCESS__SUBSCRIPTS:
				return ((InternalEList<?>)getSubscripts()).basicRemove(otherEnd, msgs);
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
			case AstmPackage.ARRAY_ACCESS__ARRAY_NAME:
				return getArrayName();
			case AstmPackage.ARRAY_ACCESS__SUBSCRIPTS:
				return getSubscripts();
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
			case AstmPackage.ARRAY_ACCESS__ARRAY_NAME:
				setArrayName((Expression)newValue);
				return;
			case AstmPackage.ARRAY_ACCESS__SUBSCRIPTS:
				getSubscripts().clear();
				getSubscripts().addAll((Collection<? extends Expression>)newValue);
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
			case AstmPackage.ARRAY_ACCESS__ARRAY_NAME:
				setArrayName((Expression)null);
				return;
			case AstmPackage.ARRAY_ACCESS__SUBSCRIPTS:
				getSubscripts().clear();
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
			case AstmPackage.ARRAY_ACCESS__ARRAY_NAME:
				return arrayName != null;
			case AstmPackage.ARRAY_ACCESS__SUBSCRIPTS:
				return subscripts != null && !subscripts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitArrayAccess(this);
	}

} //ArrayAccessImpl
