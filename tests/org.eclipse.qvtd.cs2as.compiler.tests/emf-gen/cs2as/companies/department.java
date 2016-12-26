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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>department</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cs2as.companies.department#getName <em>Name</em>}</li>
 *   <li>{@link cs2as.companies.department#getDepartment_manager <em>Department manager</em>}</li>
 *   <li>{@link cs2as.companies.department#getDepartment_employees <em>Department employees</em>}</li>
 *   <li>{@link cs2as.companies.department#getDeparment <em>Deparment</em>}</li>
 * </ul>
 *
 * @see cs2as.companies.CompaniesPackage#getdepartment()
 * @model
 * @generated
 */
public interface department extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cs2as.companies.CompaniesPackage#getdepartment_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cs2as.companies.department#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Department manager</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Department manager</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Department manager</em>' containment reference.
	 * @see #setDepartment_manager(department_manager)
	 * @see cs2as.companies.CompaniesPackage#getdepartment_Department_manager()
	 * @model containment="true"
	 * @generated
	 */
	department_manager getDepartment_manager();

	/**
	 * Sets the value of the '{@link cs2as.companies.department#getDepartment_manager <em>Department manager</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Department manager</em>' containment reference.
	 * @see #getDepartment_manager()
	 * @generated
	 */
	void setDepartment_manager(department_manager value);

	/**
	 * Returns the value of the '<em><b>Department employees</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Department employees</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Department employees</em>' containment reference.
	 * @see #setDepartment_employees(department_employees)
	 * @see cs2as.companies.CompaniesPackage#getdepartment_Department_employees()
	 * @model containment="true"
	 * @generated
	 */
	department_employees getDepartment_employees();

	/**
	 * Sets the value of the '{@link cs2as.companies.department#getDepartment_employees <em>Department employees</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Department employees</em>' containment reference.
	 * @see #getDepartment_employees()
	 * @generated
	 */
	void setDepartment_employees(department_employees value);

	/**
	 * Returns the value of the '<em><b>Deparment</b></em>' containment reference list.
	 * The list contents are of type {@link cs2as.companies.department}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deparment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deparment</em>' containment reference list.
	 * @see cs2as.companies.CompaniesPackage#getdepartment_Deparment()
	 * @model containment="true"
	 * @generated
	 */
	EList<department> getDeparment();

} // department
