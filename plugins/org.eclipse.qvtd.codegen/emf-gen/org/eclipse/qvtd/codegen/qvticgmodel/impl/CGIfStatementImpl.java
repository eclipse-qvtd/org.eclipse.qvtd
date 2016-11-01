/**
 * <copyright>
 *
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;

import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

import org.eclipse.qvtd.codegen.qvticgmodel.CGIfStatement;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;

import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGIfStatementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGIfStatementImpl#getThenStatements <em>Then Statements</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGIfStatementImpl#getElseStatements <em>Else Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGIfStatementImpl extends CGValuedElementImpl implements CGIfStatement {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement condition;

	/**
	 * The cached value of the '{@link #getThenStatements() <em>Then Statements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenStatements()
	 * @generated
	 * @ordered
	 */
	protected CGSequence thenStatements;

	/**
	 * The cached value of the '{@link #getElseStatements() <em>Else Statements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseStatements()
	 * @generated
	 * @ordered
	 */
	protected CGSequence elseStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGIfStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_IF_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGValuedElement getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(CGValuedElement newCondition, NotificationChain msgs) {
		CGValuedElement oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_IF_STATEMENT__CONDITION, oldCondition, newCondition);
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
	public void setCondition(CGValuedElement newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_IF_STATEMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_IF_STATEMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_IF_STATEMENT__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGSequence getThenStatements() {
		return thenStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThenStatements(CGSequence newThenStatements, NotificationChain msgs) {
		CGSequence oldThenStatements = thenStatements;
		thenStatements = newThenStatements;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_IF_STATEMENT__THEN_STATEMENTS, oldThenStatements, newThenStatements);
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
	public void setThenStatements(CGSequence newThenStatements) {
		if (newThenStatements != thenStatements) {
			NotificationChain msgs = null;
			if (thenStatements != null)
				msgs = ((InternalEObject)thenStatements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_IF_STATEMENT__THEN_STATEMENTS, null, msgs);
			if (newThenStatements != null)
				msgs = ((InternalEObject)newThenStatements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_IF_STATEMENT__THEN_STATEMENTS, null, msgs);
			msgs = basicSetThenStatements(newThenStatements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_IF_STATEMENT__THEN_STATEMENTS, newThenStatements, newThenStatements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGSequence getElseStatements() {
		return elseStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseStatements(CGSequence newElseStatements, NotificationChain msgs) {
		CGSequence oldElseStatements = elseStatements;
		elseStatements = newElseStatements;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_IF_STATEMENT__ELSE_STATEMENTS, oldElseStatements, newElseStatements);
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
	public void setElseStatements(CGSequence newElseStatements) {
		if (newElseStatements != elseStatements) {
			NotificationChain msgs = null;
			if (elseStatements != null)
				msgs = ((InternalEObject)elseStatements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_IF_STATEMENT__ELSE_STATEMENTS, null, msgs);
			if (newElseStatements != null)
				msgs = ((InternalEObject)newElseStatements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_IF_STATEMENT__ELSE_STATEMENTS, null, msgs);
			msgs = basicSetElseStatements(newElseStatements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_IF_STATEMENT__ELSE_STATEMENTS, newElseStatements, newElseStatements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_IF_STATEMENT__CONDITION:
				return basicSetCondition(null, msgs);
			case QVTiCGModelPackage.CG_IF_STATEMENT__THEN_STATEMENTS:
				return basicSetThenStatements(null, msgs);
			case QVTiCGModelPackage.CG_IF_STATEMENT__ELSE_STATEMENTS:
				return basicSetElseStatements(null, msgs);
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
			case QVTiCGModelPackage.CG_IF_STATEMENT__CONDITION:
				return getCondition();
			case QVTiCGModelPackage.CG_IF_STATEMENT__THEN_STATEMENTS:
				return getThenStatements();
			case QVTiCGModelPackage.CG_IF_STATEMENT__ELSE_STATEMENTS:
				return getElseStatements();
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
			case QVTiCGModelPackage.CG_IF_STATEMENT__CONDITION:
				setCondition((CGValuedElement)newValue);
				return;
			case QVTiCGModelPackage.CG_IF_STATEMENT__THEN_STATEMENTS:
				setThenStatements((CGSequence)newValue);
				return;
			case QVTiCGModelPackage.CG_IF_STATEMENT__ELSE_STATEMENTS:
				setElseStatements((CGSequence)newValue);
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
			case QVTiCGModelPackage.CG_IF_STATEMENT__CONDITION:
				setCondition((CGValuedElement)null);
				return;
			case QVTiCGModelPackage.CG_IF_STATEMENT__THEN_STATEMENTS:
				setThenStatements((CGSequence)null);
				return;
			case QVTiCGModelPackage.CG_IF_STATEMENT__ELSE_STATEMENTS:
				setElseStatements((CGSequence)null);
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
			case QVTiCGModelPackage.CG_IF_STATEMENT__CONDITION:
				return condition != null;
			case QVTiCGModelPackage.CG_IF_STATEMENT__THEN_STATEMENTS:
				return thenStatements != null;
			case QVTiCGModelPackage.CG_IF_STATEMENT__ELSE_STATEMENTS:
				return elseStatements != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGIfStatement(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isCommonable() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable Boolean isEquivalentToInternal(@NonNull CGValuedElement thatValue) {
		if (this == thatValue) {
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isUncommonable() {
		return true;
	}

} //CGIfStatementImpl
