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
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.qvtd.xtext.qvtimperativecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.RealizedVariableCS;

import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bottom Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.BottomPatternCSImpl#getOwnedEnforcementOperations <em>Owned Enforcement Operations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.BottomPatternCSImpl#getOwnedRealizedVariables <em>Owned Realized Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.BottomPatternCSImpl#getOwnedConstraints <em>Owned Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BottomPatternCSImpl extends PatternCSImpl implements BottomPatternCS {
	/**
	 * The cached value of the '{@link #getOwnedEnforcementOperations() <em>Owned Enforcement Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEnforcementOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<EnforcementOperationCS> ownedEnforcementOperations;

	/**
	 * The cached value of the '{@link #getOwnedRealizedVariables() <em>Owned Realized Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRealizedVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<RealizedVariableCS> ownedRealizedVariables;

	/**
	 * The cached value of the '{@link #getOwnedConstraints() <em>Owned Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<PredicateOrAssignmentCS> ownedConstraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BottomPatternCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.BOTTOM_PATTERN_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EnforcementOperationCS> getOwnedEnforcementOperations() {
		if (ownedEnforcementOperations == null) {
			ownedEnforcementOperations = new EObjectContainmentEList<EnforcementOperationCS>(EnforcementOperationCS.class, this, QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_ENFORCEMENT_OPERATIONS);
		}
		return ownedEnforcementOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RealizedVariableCS> getOwnedRealizedVariables() {
		if (ownedRealizedVariables == null) {
			ownedRealizedVariables = new EObjectContainmentEList<RealizedVariableCS>(RealizedVariableCS.class, this, QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES);
		}
		return ownedRealizedVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PredicateOrAssignmentCS> getOwnedConstraints() {
		if (ownedConstraints == null) {
			ownedConstraints = new EObjectContainmentEList<PredicateOrAssignmentCS>(PredicateOrAssignmentCS.class, this, QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS);
		}
		return ownedConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_ENFORCEMENT_OPERATIONS:
				return ((InternalEList<?>)getOwnedEnforcementOperations()).basicRemove(otherEnd, msgs);
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES:
				return ((InternalEList<?>)getOwnedRealizedVariables()).basicRemove(otherEnd, msgs);
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS:
				return ((InternalEList<?>)getOwnedConstraints()).basicRemove(otherEnd, msgs);
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
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_ENFORCEMENT_OPERATIONS:
				return getOwnedEnforcementOperations();
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES:
				return getOwnedRealizedVariables();
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS:
				return getOwnedConstraints();
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
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_ENFORCEMENT_OPERATIONS:
				getOwnedEnforcementOperations().clear();
				getOwnedEnforcementOperations().addAll((Collection<? extends EnforcementOperationCS>)newValue);
				return;
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES:
				getOwnedRealizedVariables().clear();
				getOwnedRealizedVariables().addAll((Collection<? extends RealizedVariableCS>)newValue);
				return;
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS:
				getOwnedConstraints().clear();
				getOwnedConstraints().addAll((Collection<? extends PredicateOrAssignmentCS>)newValue);
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
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_ENFORCEMENT_OPERATIONS:
				getOwnedEnforcementOperations().clear();
				return;
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES:
				getOwnedRealizedVariables().clear();
				return;
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS:
				getOwnedConstraints().clear();
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
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_ENFORCEMENT_OPERATIONS:
				return ownedEnforcementOperations != null && !ownedEnforcementOperations.isEmpty();
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES:
				return ownedRealizedVariables != null && !ownedRealizedVariables.isEmpty();
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS:
				return ownedConstraints != null && !ownedConstraints.isEmpty();
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
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitBottomPatternCS(this);
	}

} //BottomPatternCSImpl
