/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative.impl;

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

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtimperative.IfStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;

import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.IfStatementImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.IfStatementImpl#getOwnedThenStatements <em>Owned Then Statements</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.IfStatementImpl#getOwnedElseStatements <em>Owned Else Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfStatementImpl extends ObservableStatementImpl implements IfStatement {
	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedExpression;

	/**
	 * The cached value of the '{@link #getOwnedThenStatements() <em>Owned Then Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedThenStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> ownedThenStatements;

	/**
	 * The cached value of the '{@link #getOwnedElseStatements() <em>Owned Else Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElseStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> ownedElseStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.IF_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedExpression() {
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(OCLExpression newOwnedExpression, NotificationChain msgs) {
		OCLExpression oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.IF_STATEMENT__OWNED_EXPRESSION, oldOwnedExpression, newOwnedExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedExpression(OCLExpression newOwnedExpression) {
		if (newOwnedExpression != ownedExpression) {
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.IF_STATEMENT__OWNED_EXPRESSION, null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.IF_STATEMENT__OWNED_EXPRESSION, null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.IF_STATEMENT__OWNED_EXPRESSION, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Statement> getOwnedThenStatements() {
		if (ownedThenStatements == null) {
			ownedThenStatements = new EObjectContainmentEList<Statement>(Statement.class, this, QVTimperativePackage.IF_STATEMENT__OWNED_THEN_STATEMENTS);
		}
		return ownedThenStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Statement> getOwnedElseStatements() {
		if (ownedElseStatements == null) {
			ownedElseStatements = new EObjectContainmentEList<Statement>(Statement.class, this, QVTimperativePackage.IF_STATEMENT__OWNED_ELSE_STATEMENTS);
		}
		return ownedElseStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.IF_STATEMENT__OWNED_EXPRESSION:
				return basicSetOwnedExpression(null, msgs);
			case QVTimperativePackage.IF_STATEMENT__OWNED_THEN_STATEMENTS:
				return ((InternalEList<?>)getOwnedThenStatements()).basicRemove(otherEnd, msgs);
			case QVTimperativePackage.IF_STATEMENT__OWNED_ELSE_STATEMENTS:
				return ((InternalEList<?>)getOwnedElseStatements()).basicRemove(otherEnd, msgs);
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
			case QVTimperativePackage.IF_STATEMENT__OWNED_EXPRESSION:
				return getOwnedExpression();
			case QVTimperativePackage.IF_STATEMENT__OWNED_THEN_STATEMENTS:
				return getOwnedThenStatements();
			case QVTimperativePackage.IF_STATEMENT__OWNED_ELSE_STATEMENTS:
				return getOwnedElseStatements();
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
			case QVTimperativePackage.IF_STATEMENT__OWNED_EXPRESSION:
				setOwnedExpression((OCLExpression)newValue);
				return;
			case QVTimperativePackage.IF_STATEMENT__OWNED_THEN_STATEMENTS:
				getOwnedThenStatements().clear();
				getOwnedThenStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case QVTimperativePackage.IF_STATEMENT__OWNED_ELSE_STATEMENTS:
				getOwnedElseStatements().clear();
				getOwnedElseStatements().addAll((Collection<? extends Statement>)newValue);
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
			case QVTimperativePackage.IF_STATEMENT__OWNED_EXPRESSION:
				setOwnedExpression((OCLExpression)null);
				return;
			case QVTimperativePackage.IF_STATEMENT__OWNED_THEN_STATEMENTS:
				getOwnedThenStatements().clear();
				return;
			case QVTimperativePackage.IF_STATEMENT__OWNED_ELSE_STATEMENTS:
				getOwnedElseStatements().clear();
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
			case QVTimperativePackage.IF_STATEMENT__OWNED_EXPRESSION:
				return ownedExpression != null;
			case QVTimperativePackage.IF_STATEMENT__OWNED_THEN_STATEMENTS:
				return ownedThenStatements != null && !ownedThenStatements.isEmpty();
			case QVTimperativePackage.IF_STATEMENT__OWNED_ELSE_STATEMENTS:
				return ownedElseStatements != null && !ownedElseStatements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTimperativeVisitor<?>)visitor).visitIfStatement(this);
	}

} //IfStatementImpl
