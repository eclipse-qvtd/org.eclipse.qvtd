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

import cs2as.company.util.Visitable;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CS Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cs2as.companies.CSTrace#getAst <em>Ast</em>}</li>
 * </ul>
 *
 * @see cs2as.companies.CompaniesPackage#getCSTrace()
 * @model abstract="true"
 * @generated
 */
public interface CSTrace extends EObject {
	/**
	 * Returns the value of the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ast</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ast</em>' reference.
	 * @see #setAst(Visitable)
	 * @see cs2as.companies.CompaniesPackage#getCSTrace_Ast()
	 * @model type="cs2as.company.Visitable" transient="true"
	 * @generated
	 */
	Visitable getAst();

	/**
	 * Sets the value of the '{@link cs2as.companies.CSTrace#getAst <em>Ast</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ast</em>' reference.
	 * @see #getAst()
	 * @generated
	 */
	void setAst(Visitable value);

} // CSTrace
