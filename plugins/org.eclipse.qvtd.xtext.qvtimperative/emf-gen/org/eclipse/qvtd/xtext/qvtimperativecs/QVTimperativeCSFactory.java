/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage
 * @generated
 */
public interface QVTimperativeCSFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTimperativeCSFactory eINSTANCE = org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mapping CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping CS</em>'.
	 * @generated
	 */
	MappingCS createMappingCS();

	/**
	 * Returns a new object of class '<em>Mapping Call Binding CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call Binding CS</em>'.
	 * @generated
	 */
	MappingCallBindingCS createMappingCallBindingCS();

	/**
	 * Returns a new object of class '<em>Mapping Call CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call CS</em>'.
	 * @generated
	 */
	MappingCallCS createMappingCallCS();

	/**
	 * Returns a new object of class '<em>Mapping Loop CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Loop CS</em>'.
	 * @generated
	 */
	MappingLoopCS createMappingLoopCS();

	/**
	 * Returns a new object of class '<em>Mapping Sequence CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Sequence CS</em>'.
	 * @generated
	 */
	MappingSequenceCS createMappingSequenceCS();

	/**
	 * Returns a new object of class '<em>Top Level CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Level CS</em>'.
	 * @generated
	 */
	TopLevelCS createTopLevelCS();

	/**
	 * Returns a new object of class '<em>Imperative Domain CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Domain CS</em>'.
	 * @generated
	 */
	ImperativeDomainCS createImperativeDomainCS();

	/**
	 * Returns a new object of class '<em>Imperative Predicate Or Assignment CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Predicate Or Assignment CS</em>'.
	 * @generated
	 */
	ImperativePredicateOrAssignmentCS createImperativePredicateOrAssignmentCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTimperativeCSPackage getQVTimperativeCSPackage();

} //QVTimperativeCSTFactory
