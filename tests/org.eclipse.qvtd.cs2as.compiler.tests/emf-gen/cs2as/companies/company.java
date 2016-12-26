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
 * A representation of the model object '<em><b>company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cs2as.companies.company#getName <em>Name</em>}</li>
 *   <li>{@link cs2as.companies.company#getDeparment <em>Deparment</em>}</li>
 * </ul>
 *
 * @see cs2as.companies.CompaniesPackage#getcompany()
 * @model
 * @generated
 */
public interface company extends CSTrace {
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
	 * @see cs2as.companies.CompaniesPackage#getcompany_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cs2as.companies.company#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see cs2as.companies.CompaniesPackage#getcompany_Deparment()
	 * @model containment="true"
	 * @generated
	 */
	EList<department> getDeparment();

} // company
