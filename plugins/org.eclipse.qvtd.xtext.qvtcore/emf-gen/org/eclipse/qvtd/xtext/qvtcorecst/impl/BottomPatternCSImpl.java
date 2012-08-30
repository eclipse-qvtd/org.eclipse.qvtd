/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorecst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage;
import org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorecst.util.QVTcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bottom Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.BottomPatternCSImpl#getEnforcementOperations <em>Enforcement Operations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.BottomPatternCSImpl#getRealizedVariables <em>Realized Variables</em>}</li>
 * </ul>
 * </p>
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
		return QVTcoreCSTPackage.Literals.BOTTOM_PATTERN_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnforcementOperationCS> getEnforcementOperations() {
		if (enforcementOperations == null) {
			enforcementOperations = new EObjectContainmentEList<EnforcementOperationCS>(EnforcementOperationCS.class, this, QVTcoreCSTPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS);
		}
		return enforcementOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RealizedVariableCS> getRealizedVariables() {
		if (realizedVariables == null) {
			realizedVariables = new EObjectContainmentEList<RealizedVariableCS>(RealizedVariableCS.class, this, QVTcoreCSTPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES);
		}
		return realizedVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcoreCSTPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS:
				return ((InternalEList<?>)getEnforcementOperations()).basicRemove(otherEnd, msgs);
			case QVTcoreCSTPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES:
				return ((InternalEList<?>)getRealizedVariables()).basicRemove(otherEnd, msgs);
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
			case QVTcoreCSTPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS:
				return getEnforcementOperations();
			case QVTcoreCSTPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES:
				return getRealizedVariables();
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
			case QVTcoreCSTPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS:
				getEnforcementOperations().clear();
				getEnforcementOperations().addAll((Collection<? extends EnforcementOperationCS>)newValue);
				return;
			case QVTcoreCSTPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES:
				getRealizedVariables().clear();
				getRealizedVariables().addAll((Collection<? extends RealizedVariableCS>)newValue);
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
			case QVTcoreCSTPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS:
				getEnforcementOperations().clear();
				return;
			case QVTcoreCSTPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES:
				getRealizedVariables().clear();
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
			case QVTcoreCSTPackage.BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS:
				return enforcementOperations != null && !enforcementOperations.isEmpty();
			case QVTcoreCSTPackage.BOTTOM_PATTERN_CS__REALIZED_VARIABLES:
				return realizedVariables != null && !realizedVariables.isEmpty();
		}
		return super.eIsSet(featureID);
	}


	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(BaseCSVisitor<R> visitor) {
		return (R) visitor.getAdapter(QVTcoreCSVisitor.class).visitBottomPatternCS(this);
	}
} //BottomPatternCSImpl
