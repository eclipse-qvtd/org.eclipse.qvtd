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
	 * Returns a new object of class '<em>Add Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Statement</em>'.
	 * @generated
	 */
	@NonNull AddStatement createAddStatement();

	/**
	 * Returns a new object of class '<em>Check Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check Statement</em>'.
	 * @generated
	 */
	@NonNull CheckStatement createCheckStatement();

	/**
	 * Returns a new object of class '<em>Declare Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Declare Statement</em>'.
	 * @generated
	 */
	DeclareStatement createDeclareStatement();

	/**
	 * Returns a new object of class '<em>Guard Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Guard Variable</em>'.
	 * @generated
	 */
	@NonNull GuardVariable createGuardVariable();

	/**
	 * Returns a new object of class '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Statement</em>'.
	 * @generated
	 */
	IfStatement createIfStatement();

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
	 * Returns a new object of class '<em>Imperative Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Typed Model</em>'.
	 * @generated
	 */
	ImperativeTypedModel createImperativeTypedModel();

	/**
	 * Returns a new object of class '<em>In Connection Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In Connection Variable</em>'.
	 * @generated
	 */
	@NonNull InConnectionVariable createInConnectionVariable();

	/**
	 * Returns a new object of class '<em>Initialize Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initialize Statement</em>'.
	 * @generated
	 */
	InitializeStatement createInitializeStatement();

	/**
	 * Returns a new object of class '<em>Loop Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Variable</em>'.
	 * @generated
	 */
	@NonNull LoopVariable createLoopVariable();

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
	 * Returns a new object of class '<em>New Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Statement</em>'.
	 * @generated
	 */
	@NonNull NewStatement createNewStatement();

	/**
	 * Returns a new object of class '<em>Out Connection Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Out Connection Variable</em>'.
	 * @generated
	 */
	@NonNull OutConnectionVariable createOutConnectionVariable();

	/**
	 * Returns a new object of class '<em>Set Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Statement</em>'.
	 * @generated
	 */
	@NonNull SetStatement createSetStatement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTimperativePackage getQVTimperativePackage();

} //QVTimperativeFactory
