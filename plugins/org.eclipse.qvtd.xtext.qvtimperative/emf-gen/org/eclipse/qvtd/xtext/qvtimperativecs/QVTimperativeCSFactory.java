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
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

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
	 * Returns a new object of class '<em>Add Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Statement CS</em>'.
	 * @generated
	 */
	@NonNull AddStatementCS createAddStatementCS();

	/**
	 * Returns a new object of class '<em>Check Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check Statement CS</em>'.
	 * @generated
	 */
	@NonNull CheckStatementCS createCheckStatementCS();

	/**
	 * Returns a new object of class '<em>Direction CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Direction CS</em>'.
	 * @generated
	 */
	@NonNull DirectionCS createDirectionCS();

	/**
	 * Returns a new object of class '<em>Domain CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain CS</em>'.
	 * @generated
	 */
	@NonNull DomainCS createDomainCS();

	/**
	 * Returns a new object of class '<em>Guard Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Guard Variable CS</em>'.
	 * @generated
	 */
	@NonNull GuardVariableCS createGuardVariableCS();

	/**
	 * Returns a new object of class '<em>Inout Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inout Variable CS</em>'.
	 * @generated
	 */
	@NonNull InoutVariableCS createInoutVariableCS();

	/**
	 * Returns a new object of class '<em>Mapping CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping CS</em>'.
	 * @generated
	 */
	@NonNull MappingCS createMappingCS();

	/**
	 * Returns a new object of class '<em>Mapping Call Binding CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call Binding CS</em>'.
	 * @generated
	 */
	@NonNull MappingCallBindingCS createMappingCallBindingCS();

	/**
	 * Returns a new object of class '<em>Mapping Call CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call CS</em>'.
	 * @generated
	 */
	@NonNull MappingCallCS createMappingCallCS();

	/**
	 * Returns a new object of class '<em>Mapping Loop CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Loop CS</em>'.
	 * @generated
	 */
	@NonNull MappingLoopCS createMappingLoopCS();

	/**
	 * Returns a new object of class '<em>Param Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Param Declaration CS</em>'.
	 * @generated
	 */
	@NonNull ParamDeclarationCS createParamDeclarationCS();

	/**
	 * Returns a new object of class '<em>Predicate Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predicate Variable CS</em>'.
	 * @generated
	 */
	@NonNull PredicateVariableCS createPredicateVariableCS();

	/**
	 * Returns a new object of class '<em>Query CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query CS</em>'.
	 * @generated
	 */
	@NonNull QueryCS createQueryCS();

	/**
	 * Returns a new object of class '<em>New Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Statement CS</em>'.
	 * @generated
	 */
	@NonNull NewStatementCS createNewStatementCS();

	/**
	 * Returns a new object of class '<em>Out Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Out Variable CS</em>'.
	 * @generated
	 */
	@NonNull OutVariableCS createOutVariableCS();

	/**
	 * Returns a new object of class '<em>Set Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Statement CS</em>'.
	 * @generated
	 */
	@NonNull SetStatementCS createSetStatementCS();

	/**
	 * Returns a new object of class '<em>Top Level CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Level CS</em>'.
	 * @generated
	 */
	@NonNull TopLevelCS createTopLevelCS();

	/**
	 * Returns a new object of class '<em>Transformation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation CS</em>'.
	 * @generated
	 */
	@NonNull TransformationCS createTransformationCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTimperativeCSPackage getQVTimperativeCSPackage();

} //QVTimperativeCSTFactory
