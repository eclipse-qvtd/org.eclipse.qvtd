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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>department manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cs2as.companies.department_manager#getEmployee <em>Employee</em>}</li>
 * </ul>
 *
 * @see cs2as.companies.CompaniesPackage#getdepartment_manager()
 * @model
 * @generated
 */
public interface department_manager extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Employee</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employee</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employee</em>' containment reference.
	 * @see #setEmployee(employee)
	 * @see cs2as.companies.CompaniesPackage#getdepartment_manager_Employee()
	 * @model containment="true"
	 * @generated
	 */
	employee getEmployee();

	/**
	 * Sets the value of the '{@link cs2as.companies.department_manager#getEmployee <em>Employee</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Employee</em>' containment reference.
	 * @see #getEmployee()
	 * @generated
	 */
	void setEmployee(employee value);

} // department_manager
