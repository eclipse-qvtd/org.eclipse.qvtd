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
 * A representation of the model object '<em><b>statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.statement#getLabelId <em>Label Id</em>}</li>
 *   <li>{@link delphi.statement#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getstatement()
 * @model
 * @generated
 */
public interface statement extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Label Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Id</em>' attribute.
	 * @see #setLabelId(String)
	 * @see delphi.DelphiPackage#getstatement_LabelId()
	 * @model
	 * @generated
	 */
	String getLabelId();

	/**
	 * Sets the value of the '{@link delphi.statement#getLabelId <em>Label Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Id</em>' attribute.
	 * @see #getLabelId()
	 * @generated
	 */
	void setLabelId(String value);

	/**
	 * Returns the value of the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' containment reference.
	 * @see #setStatement(unlabelledStatement)
	 * @see delphi.DelphiPackage#getstatement_Statement()
	 * @model containment="true"
	 * @generated
	 */
	unlabelledStatement getStatement();

	/**
	 * Sets the value of the '{@link delphi.statement#getStatement <em>Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' containment reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(unlabelledStatement value);

} // statement
