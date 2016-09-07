/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage
 * @generated
 */
public interface QVTimperativeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTimperativeFactory eINSTANCE = org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bottom Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bottom Pattern</em>'.
	 * @generated
	 */
	BottomPattern createBottomPattern();

	/**
	 * Returns a new object of class '<em>Connection Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Assignment</em>'.
	 * @generated
	 */
	@NonNull ConnectionAssignment createConnectionAssignment();

	/**
	 * Returns a new object of class '<em>Connection Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Statement</em>'.
	 * @generated
	 */
	@NonNull ConnectionStatement createConnectionStatement();

	/**
	 * Returns a new object of class '<em>Connection Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Variable</em>'.
	 * @generated
	 */
	@NonNull ConnectionVariable createConnectionVariable();

	/**
	 * Returns a new object of class '<em>Core Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Domain</em>'.
	 * @generated
	 */
	CoreDomain createCoreDomain();

	/**
	 * Returns a new object of class '<em>Core Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Pattern</em>'.
	 * @generated
	 */
	CorePattern createCorePattern();

	/**
	 * Returns a new object of class '<em>Enforcement Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enforcement Operation</em>'.
	 * @generated
	 */
	EnforcementOperation createEnforcementOperation();

	/**
	 * Returns a new object of class '<em>Guard Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Guard Pattern</em>'.
	 * @generated
	 */
	GuardPattern createGuardPattern();

	/**
	 * Returns a new object of class '<em>Imperative Bottom Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Bottom Pattern</em>'.
	 * @generated
	 */
	@NonNull ImperativeBottomPattern createImperativeBottomPattern();

	/**
	 * Returns a new object of class '<em>Imperative Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Domain</em>'.
	 * @generated
	 */
	@NonNull ImperativeDomain createImperativeDomain();

	/**
	 * Returns a new object of class '<em>Imperative Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Model</em>'.
	 * @generated
	 */
	@NonNull ImperativeModel createImperativeModel();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	@NonNull Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Mapping Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call</em>'.
	 * @generated
	 */
	@NonNull MappingCall createMappingCall();

	/**
	 * Returns a new object of class '<em>Mapping Call Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call Binding</em>'.
	 * @generated
	 */
	@NonNull MappingCallBinding createMappingCallBinding();

	/**
	 * Returns a new object of class '<em>Mapping Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Loop</em>'.
	 * @generated
	 */
	@NonNull MappingLoop createMappingLoop();

	/**
	 * Returns a new object of class '<em>Mapping Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Sequence</em>'.
	 * @generated
	 */
	@NonNull MappingSequence createMappingSequence();

	/**
	 * Returns a new object of class '<em>Opposite Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opposite Property Assignment</em>'.
	 * @generated
	 */
	OppositePropertyAssignment createOppositePropertyAssignment();

	/**
	 * Returns a new object of class '<em>Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Assignment</em>'.
	 * @generated
	 */
	PropertyAssignment createPropertyAssignment();

	/**
	 * Returns a new object of class '<em>Realized Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Realized Variable</em>'.
	 * @generated
	 */
	RealizedVariable createRealizedVariable();

	/**
	 * Returns a new object of class '<em>Variable Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Assignment</em>'.
	 * @generated
	 */
	VariableAssignment createVariableAssignment();

	/**
	 * Returns a new object of class '<em>Variable Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Predicate</em>'.
	 * @generated
	 */
	@NonNull VariablePredicate createVariablePredicate();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTimperativePackage getQVTimperativePackage();

} //QVTimperativeFactory
