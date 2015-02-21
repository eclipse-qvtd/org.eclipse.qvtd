/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebasecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage;
import org.eclipse.qvtd.xtext.qvtcorebasecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.util.QVTcoreBaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bottom Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.BottomPatternCSImpl#getEnforcementOperations <em>Enforcement Operations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.BottomPatternCSImpl#getRealizedVariables <em>Realized Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.BottomPatternCSImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BottomPatternCSImpl extends PatternCSImpl implements BottomPatternCS {
	/**
	 * The cached value of the '{@link #getEnforcementOperations() <em>Enforcement Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnforcementOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<EnforcementOperationCS> enforcementOperations;

	/**
	 * The cached value of the '{@link #getRealizedVariables() <em>Realized Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<RealizedVariableCS> realizedVariables;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<AssignmentCS> constraints;

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
		return QVTcoreBaseCSPackage.Literals.BOTTOM_PATTERN_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EnforcementOperationCS> getEnforcementOperations() {
		if (enforcementOperations == null) {
			enforcementOperations = new EObjectContainmentEList<EnforcementOperationCS>(EnforcementOperationCS.class, this, QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS);
		}
		return enforcementOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RealizedVariableCS> getRealizedVariables() {
		if (realizedVariables == null) {
			realizedVariables = new EObjectContainmentEList<RealizedVariableCS>(RealizedVariableCS.class, this, QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES);
		}
		return realizedVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AssignmentCS> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<AssignmentCS>(AssignmentCS.class, this, QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS:
				return ((InternalEList<?>)getEnforcementOperations()).basicRemove(otherEnd, msgs);
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES:
				return ((InternalEList<?>)getRealizedVariables()).basicRemove(otherEnd, msgs);
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS:
				return getEnforcementOperations();
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES:
				return getRealizedVariables();
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__CONSTRAINTS:
				return getConstraints();
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
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS:
				getEnforcementOperations().clear();
				getEnforcementOperations().addAll((Collection<? extends EnforcementOperationCS>)newValue);
				return;
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES:
				getRealizedVariables().clear();
				getRealizedVariables().addAll((Collection<? extends RealizedVariableCS>)newValue);
				return;
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends AssignmentCS>)newValue);
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
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS:
				getEnforcementOperations().clear();
				return;
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES:
				getRealizedVariables().clear();
				return;
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__CONSTRAINTS:
				getConstraints().clear();
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
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS:
				return enforcementOperations != null && !enforcementOperations.isEmpty();
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES:
				return realizedVariables != null && !realizedVariables.isEmpty();
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTcoreBaseCSVisitor<?>)visitor).visitBottomPatternCS(this);
	}
} //BottomPatternCSImpl
