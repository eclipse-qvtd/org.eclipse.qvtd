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
 * A representation of the model object '<em><b>procedure Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.procedureDecl#getHeading <em>Heading</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getprocedureDecl()
 * @model
 * @generated
 */
public interface procedureDecl extends procedureDeclSection {
	/**
	 * Returns the value of the '<em><b>Heading</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heading</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heading</em>' containment reference.
	 * @see #setHeading(procedureHeading)
	 * @see delphi.DelphiPackage#getprocedureDecl_Heading()
	 * @model containment="true"
	 * @generated
	 */
	procedureHeading getHeading();

	/**
	 * Sets the value of the '{@link delphi.procedureDecl#getHeading <em>Heading</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heading</em>' containment reference.
	 * @see #getHeading()
	 * @generated
	 */
	void setHeading(procedureHeading value);

} // procedureDecl
