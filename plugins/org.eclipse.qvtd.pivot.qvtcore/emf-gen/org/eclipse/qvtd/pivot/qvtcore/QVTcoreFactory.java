/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage
 * @generated
 */
public interface QVTcoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTcoreFactory eINSTANCE = org.eclipse.qvtd.pivot.qvtcore.impl.QVTcoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bottom Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bottom Pattern</em>'.
	 * @generated
	 */
	@NonNull BottomPattern createBottomPattern();

	/**
	 * Returns a new object of class '<em>Bottom Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bottom Variable</em>'.
	 * @generated
	 */
	@NonNull BottomVariable createBottomVariable();

	/**
	 * Returns a new object of class '<em>Core Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Domain</em>'.
	 * @generated
	 */
	@NonNull CoreDomain createCoreDomain();

	/**
	 * Returns a new object of class '<em>Core Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Model</em>'.
	 * @generated
	 */
	@NonNull CoreModel createCoreModel();

	/**
	 * Returns a new object of class '<em>Core Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Pattern</em>'.
	 * @generated
	 */
	@NonNull CorePattern createCorePattern();

	/**
	 * Returns a new object of class '<em>Enforcement Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enforcement Operation</em>'.
	 * @generated
	 */
	@NonNull EnforcementOperation createEnforcementOperation();

	/**
	 * Returns a new object of class '<em>Guard Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Guard Pattern</em>'.
	 * @generated
	 */
	@NonNull GuardPattern createGuardPattern();

	/**
	 * Returns a new object of class '<em>Guard Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Guard Variable</em>'.
	 * @generated
	 */
	@NonNull GuardVariable createGuardVariable();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	@NonNull Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Opposite Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opposite Property Assignment</em>'.
	 * @generated
	 */
	@NonNull OppositePropertyAssignment createOppositePropertyAssignment();

	/**
	 * Returns a new object of class '<em>Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Assignment</em>'.
	 * @generated
	 */
	@NonNull PropertyAssignment createPropertyAssignment();

	/**
	 * Returns a new object of class '<em>Realized Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Realized Variable</em>'.
	 * @generated
	 */
	@NonNull RealizedVariable createRealizedVariable();

	/**
	 * Returns a new object of class '<em>Variable Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Assignment</em>'.
	 * @generated
	 */
	@NonNull VariableAssignment createVariableAssignment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTcorePackage getQVTcorePackage();

} //QVTcoreFactory
