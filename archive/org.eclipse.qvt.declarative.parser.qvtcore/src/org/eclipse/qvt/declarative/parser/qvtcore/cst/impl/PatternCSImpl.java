/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: PatternCSImpl.java,v 1.1 2008/07/23 10:06:41 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.impl.CSTNodeImpl;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.UnrealizedVariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.PatternCSImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.PatternCSImpl#getUnrealizedVariables <em>Unrealized Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PatternCSImpl extends CSTNodeImpl implements PatternCS {
	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpressionCS> constraints;

	/**
	 * The cached value of the '{@link #getUnrealizedVariables() <em>Unrealized Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnrealizedVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<UnrealizedVariableCS> unrealizedVariables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcCSTPackage.Literals.PATTERN_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpressionCS> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<OCLExpressionCS>(OCLExpressionCS.class, this, QVTcCSTPackage.PATTERN_CS__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnrealizedVariableCS> getUnrealizedVariables() {
		if (unrealizedVariables == null) {
			unrealizedVariables = new EObjectContainmentEList<UnrealizedVariableCS>(UnrealizedVariableCS.class, this, QVTcCSTPackage.PATTERN_CS__UNREALIZED_VARIABLES);
		}
		return unrealizedVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcCSTPackage.PATTERN_CS__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case QVTcCSTPackage.PATTERN_CS__UNREALIZED_VARIABLES:
				return ((InternalEList<?>)getUnrealizedVariables()).basicRemove(otherEnd, msgs);
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
			case QVTcCSTPackage.PATTERN_CS__CONSTRAINTS:
				return getConstraints();
			case QVTcCSTPackage.PATTERN_CS__UNREALIZED_VARIABLES:
				return getUnrealizedVariables();
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
			case QVTcCSTPackage.PATTERN_CS__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends OCLExpressionCS>)newValue);
				return;
			case QVTcCSTPackage.PATTERN_CS__UNREALIZED_VARIABLES:
				getUnrealizedVariables().clear();
				getUnrealizedVariables().addAll((Collection<? extends UnrealizedVariableCS>)newValue);
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
			case QVTcCSTPackage.PATTERN_CS__CONSTRAINTS:
				getConstraints().clear();
				return;
			case QVTcCSTPackage.PATTERN_CS__UNREALIZED_VARIABLES:
				getUnrealizedVariables().clear();
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
			case QVTcCSTPackage.PATTERN_CS__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case QVTcCSTPackage.PATTERN_CS__UNREALIZED_VARIABLES:
				return unrealizedVariables != null && !unrealizedVariables.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PatternCSImpl
