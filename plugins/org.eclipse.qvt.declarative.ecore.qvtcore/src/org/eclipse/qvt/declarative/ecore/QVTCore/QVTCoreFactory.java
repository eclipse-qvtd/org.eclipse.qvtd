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
 * $Id: QVTCoreFactory.java,v 1.1 2008/07/23 09:43:24 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage
 * @generated
 */
public interface QVTCoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTCoreFactory eINSTANCE = org.eclipse.qvt.declarative.ecore.QVTCore.impl.QVTCoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bottom Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bottom Pattern</em>'.
	 * @generated
	 */
	BottomPattern createBottomPattern();

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
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTCorePackage getQVTCorePackage();

} //QVTCoreFactory
