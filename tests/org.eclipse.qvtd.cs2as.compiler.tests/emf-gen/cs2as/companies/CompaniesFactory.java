/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package cs2as.companies;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cs2as.companies.CompaniesPackage
 * @generated
 */
public interface CompaniesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompaniesFactory eINSTANCE = cs2as.companies.impl.CompaniesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>company</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>company</em>'.
	 * @generated
	 */
	company createcompany();

	/**
	 * Returns a new object of class '<em>department</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>department</em>'.
	 * @generated
	 */
	department createdepartment();

	/**
	 * Returns a new object of class '<em>department manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>department manager</em>'.
	 * @generated
	 */
	department_manager createdepartment_manager();

	/**
	 * Returns a new object of class '<em>department employees</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>department employees</em>'.
	 * @generated
	 */
	department_employees createdepartment_employees();

	/**
	 * Returns a new object of class '<em>employee</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>employee</em>'.
	 * @generated
	 */
	employee createemployee();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CompaniesPackage getCompaniesPackage();

} //CompaniesFactory
