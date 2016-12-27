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
 * A representation of the model object '<em><b>procedure Decl Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.procedureDeclSection#getDirective <em>Directive</em>}</li>
 *   <li>{@link delphi.procedureDeclSection#getPort <em>Port</em>}</li>
 *   <li>{@link delphi.procedureDeclSection#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getprocedureDeclSection()
 * @model
 * @generated
 */
public interface procedureDeclSection extends declSection {
	/**
	 * Returns the value of the '<em><b>Directive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directive</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directive</em>' containment reference.
	 * @see #setDirective(directive)
	 * @see delphi.DelphiPackage#getprocedureDeclSection_Directive()
	 * @model containment="true"
	 * @generated
	 */
	directive getDirective();

	/**
	 * Sets the value of the '{@link delphi.procedureDeclSection#getDirective <em>Directive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directive</em>' containment reference.
	 * @see #getDirective()
	 * @generated
	 */
	void setDirective(directive value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(String)
	 * @see delphi.DelphiPackage#getprocedureDeclSection_Port()
	 * @model
	 * @generated
	 */
	String getPort();

	/**
	 * Sets the value of the '{@link delphi.procedureDeclSection#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(String value);

	/**
	 * Returns the value of the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' containment reference.
	 * @see #setBlock(block)
	 * @see delphi.DelphiPackage#getprocedureDeclSection_Block()
	 * @model containment="true"
	 * @generated
	 */
	block getBlock();

	/**
	 * Sets the value of the '{@link delphi.procedureDeclSection#getBlock <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' containment reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(block value);

} // procedureDeclSection
