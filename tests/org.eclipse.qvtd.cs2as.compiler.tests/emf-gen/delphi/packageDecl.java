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
package delphi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>package Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.packageDecl#getRequires <em>Requires</em>}</li>
 *   <li>{@link delphi.packageDecl#getContains <em>Contains</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getpackageDecl()
 * @model
 * @generated
 */
public interface packageDecl extends file {
	/**
	 * Returns the value of the '<em><b>Requires</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requires</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' containment reference.
	 * @see #setRequires(requiresClause)
	 * @see delphi.DelphiPackage#getpackageDecl_Requires()
	 * @model containment="true"
	 * @generated
	 */
	requiresClause getRequires();

	/**
	 * Sets the value of the '{@link delphi.packageDecl#getRequires <em>Requires</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requires</em>' containment reference.
	 * @see #getRequires()
	 * @generated
	 */
	void setRequires(requiresClause value);

	/**
	 * Returns the value of the '<em><b>Contains</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains</em>' containment reference.
	 * @see #setContains(containsClause)
	 * @see delphi.DelphiPackage#getpackageDecl_Contains()
	 * @model containment="true"
	 * @generated
	 */
	containsClause getContains();

	/**
	 * Sets the value of the '{@link delphi.packageDecl#getContains <em>Contains</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contains</em>' containment reference.
	 * @see #getContains()
	 * @generated
	 */
	void setContains(containsClause value);

} // packageDecl
