/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QVTcoreBaseCSPackage
 * @generated
 */
public interface QVTcoreBaseCSFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTcoreBaseCSFactory eINSTANCE = org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Assignment CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment CS</em>'.
	 * @generated
	 */
	AssignmentCS createAssignmentCS();

	/**
	 * Returns a new object of class '<em>Bottom Pattern CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bottom Pattern CS</em>'.
	 * @generated
	 */
	BottomPatternCS createBottomPatternCS();

	/**
	 * Returns a new object of class '<em>Direction CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Direction CS</em>'.
	 * @generated
	 */
	DirectionCS createDirectionCS();

	/**
	 * Returns a new object of class '<em>Domain CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain CS</em>'.
	 * @generated
	 */
	DomainCS createDomainCS();

	/**
	 * Returns a new object of class '<em>Enforcement Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enforcement Operation CS</em>'.
	 * @generated
	 */
	EnforcementOperationCS createEnforcementOperationCS();

	/**
	 * Returns a new object of class '<em>Guard Pattern CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Guard Pattern CS</em>'.
	 * @generated
	 */
	GuardPatternCS createGuardPatternCS();

	/**
	 * Returns a new object of class '<em>Param Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Param Declaration CS</em>'.
	 * @generated
	 */
	ParamDeclarationCS createParamDeclarationCS();

	/**
	 * Returns a new object of class '<em>Query CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query CS</em>'.
	 * @generated
	 */
	QueryCS createQueryCS();

	/**
	 * Returns a new object of class '<em>Realized Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Realized Variable CS</em>'.
	 * @generated
	 */
	RealizedVariableCS createRealizedVariableCS();

	/**
	 * Returns a new object of class '<em>Transformation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation CS</em>'.
	 * @generated
	 */
	TransformationCS createTransformationCS();

	/**
	 * Returns a new object of class '<em>Unrealized Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unrealized Variable CS</em>'.
	 * @generated
	 */
	UnrealizedVariableCS createUnrealizedVariableCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTcoreBaseCSPackage getQVTcoreBaseCSPackage();

} //QVTcoreBaseCSTFactory
