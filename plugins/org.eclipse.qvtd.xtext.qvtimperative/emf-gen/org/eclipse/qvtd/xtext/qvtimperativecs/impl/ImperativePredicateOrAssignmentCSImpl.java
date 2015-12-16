/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.qvtd.xtext.qvtcorebasecs.impl.PredicateOrAssignmentCSImpl;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativePredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;

import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imperative Predicate Or Assignment CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.ImperativePredicateOrAssignmentCSImpl#isIsAccumulate <em>Is Accumulate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImperativePredicateOrAssignmentCSImpl extends PredicateOrAssignmentCSImpl implements ImperativePredicateOrAssignmentCS {
	/**
	 * The default value of the '{@link #isIsAccumulate() <em>Is Accumulate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAccumulate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ACCUMULATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAccumulate() <em>Is Accumulate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAccumulate()
	 * @generated
	 * @ordered
	 */
	protected boolean isAccumulate = IS_ACCUMULATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativePredicateOrAssignmentCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsAccumulate() {
		return isAccumulate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAccumulate(boolean newIsAccumulate) {
		boolean oldIsAccumulate = isAccumulate;
		isAccumulate = newIsAccumulate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS__IS_ACCUMULATE, oldIsAccumulate, isAccumulate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTimperativeCSPackage.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS__IS_ACCUMULATE:
				return isIsAccumulate();
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
			case QVTimperativeCSPackage.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS__IS_ACCUMULATE:
				setIsAccumulate((Boolean)newValue);
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
			case QVTimperativeCSPackage.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS__IS_ACCUMULATE:
				setIsAccumulate(IS_ACCUMULATE_EDEFAULT);
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
			case QVTimperativeCSPackage.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS__IS_ACCUMULATE:
				return isAccumulate != IS_ACCUMULATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitImperativePredicateOrAssignmentCS(this);
	}

} //ImperativePredicateOrAssignmentCSImpl
