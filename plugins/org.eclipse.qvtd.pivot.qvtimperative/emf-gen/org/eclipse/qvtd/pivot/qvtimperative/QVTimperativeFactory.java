/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
	 * Returns a new object of class '<em>Connection Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Assignment</em>'.
	 * @generated
	 */
	ConnectionAssignment createConnectionAssignment();

	/**
	 * Returns a new object of class '<em>Imperative Bottom Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Bottom Pattern</em>'.
	 * @generated
	 */
	ImperativeBottomPattern createImperativeBottomPattern();

	/**
	 * Returns a new object of class '<em>Imperative Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Domain</em>'.
	 * @generated
	 */
	ImperativeDomain createImperativeDomain();

	/**
	 * Returns a new object of class '<em>Imperative Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Model</em>'.
	 * @generated
	 */
	ImperativeModel createImperativeModel();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Mapping Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call</em>'.
	 * @generated
	 */
	MappingCall createMappingCall();

	/**
	 * Returns a new object of class '<em>Mapping Call Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call Binding</em>'.
	 * @generated
	 */
	MappingCallBinding createMappingCallBinding();

	/**
	 * Returns a new object of class '<em>Mapping Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Loop</em>'.
	 * @generated
	 */
	MappingLoop createMappingLoop();

	/**
	 * Returns a new object of class '<em>Mapping Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Sequence</em>'.
	 * @generated
	 */
	MappingSequence createMappingSequence();

	/**
	 * Returns a new object of class '<em>Variable Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Predicate</em>'.
	 * @generated
	 */
	VariablePredicate createVariablePredicate();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTimperativePackage getQVTimperativePackage();

} //QVTimperativeFactory
