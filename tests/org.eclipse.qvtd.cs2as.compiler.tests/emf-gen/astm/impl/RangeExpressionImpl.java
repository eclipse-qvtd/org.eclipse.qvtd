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

import astm.AstmPackage;
import astm.Expression;
import astm.RangeExpression;

import astm.util.Visitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.RangeExpressionImpl#getFromExpression <em>From Expression</em>}</li>
 *   <li>{@link astm.impl.RangeExpressionImpl#getToExpression <em>To Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RangeExpressionImpl extends ExpressionImpl implements RangeExpression {
	/**
	 * The cached value of the '{@link #getFromExpression() <em>From Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression fromExpression;

	/**
	 * The cached value of the '{@link #getToExpression() <em>To Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression toExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.RANGE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getFromExpression() {
		return fromExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFromExpression(Expression newFromExpression, NotificationChain msgs) {
		Expression oldFromExpression = fromExpression;
		fromExpression = newFromExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.RANGE_EXPRESSION__FROM_EXPRESSION, oldFromExpression, newFromExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromExpression(Expression newFromExpression) {
		if (newFromExpression != fromExpression) {
			NotificationChain msgs = null;
			if (fromExpression != null)
				msgs = ((InternalEObject)fromExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.RANGE_EXPRESSION__FROM_EXPRESSION, null, msgs);
			if (newFromExpression != null)
				msgs = ((InternalEObject)newFromExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.RANGE_EXPRESSION__FROM_EXPRESSION, null, msgs);
			msgs = basicSetFromExpression(newFromExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.RANGE_EXPRESSION__FROM_EXPRESSION, newFromExpression, newFromExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getToExpression() {
		return toExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToExpression(Expression newToExpression, NotificationChain msgs) {
		Expression oldToExpression = toExpression;
		toExpression = newToExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.RANGE_EXPRESSION__TO_EXPRESSION, oldToExpression, newToExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToExpression(Expression newToExpression) {
		if (newToExpression != toExpression) {
			NotificationChain msgs = null;
			if (toExpression != null)
				msgs = ((InternalEObject)toExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.RANGE_EXPRESSION__TO_EXPRESSION, null, msgs);
			if (newToExpression != null)
				msgs = ((InternalEObject)newToExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.RANGE_EXPRESSION__TO_EXPRESSION, null, msgs);
			msgs = basicSetToExpression(newToExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.RANGE_EXPRESSION__TO_EXPRESSION, newToExpression, newToExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.RANGE_EXPRESSION__FROM_EXPRESSION:
				return basicSetFromExpression(null, msgs);
			case AstmPackage.RANGE_EXPRESSION__TO_EXPRESSION:
				return basicSetToExpression(null, msgs);
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
			case AstmPackage.RANGE_EXPRESSION__FROM_EXPRESSION:
				return getFromExpression();
			case AstmPackage.RANGE_EXPRESSION__TO_EXPRESSION:
				return getToExpression();
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
			case AstmPackage.RANGE_EXPRESSION__FROM_EXPRESSION:
				setFromExpression((Expression)newValue);
				return;
			case AstmPackage.RANGE_EXPRESSION__TO_EXPRESSION:
				setToExpression((Expression)newValue);
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
			case AstmPackage.RANGE_EXPRESSION__FROM_EXPRESSION:
				setFromExpression((Expression)null);
				return;
			case AstmPackage.RANGE_EXPRESSION__TO_EXPRESSION:
				setToExpression((Expression)null);
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
			case AstmPackage.RANGE_EXPRESSION__FROM_EXPRESSION:
				return fromExpression != null;
			case AstmPackage.RANGE_EXPRESSION__TO_EXPRESSION:
				return toExpression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitRangeExpression(this);
	}

} //RangeExpressionImpl
