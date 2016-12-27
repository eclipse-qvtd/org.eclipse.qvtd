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
 * A representation of the model object '<em><b>var Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.varDecl#getIdList <em>Id List</em>}</li>
 *   <li>{@link delphi.varDecl#getType <em>Type</em>}</li>
 *   <li>{@link delphi.varDecl#getAbsId <em>Abs Id</em>}</li>
 *   <li>{@link delphi.varDecl#getAbsConst <em>Abs Const</em>}</li>
 *   <li>{@link delphi.varDecl#getAbsIniti <em>Abs Initi</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getvarDecl()
 * @model
 * @generated
 */
public interface varDecl extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Id List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id List</em>' containment reference.
	 * @see #setIdList(identList)
	 * @see delphi.DelphiPackage#getvarDecl_IdList()
	 * @model containment="true"
	 * @generated
	 */
	identList getIdList();

	/**
	 * Sets the value of the '{@link delphi.varDecl#getIdList <em>Id List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id List</em>' containment reference.
	 * @see #getIdList()
	 * @generated
	 */
	void setIdList(identList value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(type)
	 * @see delphi.DelphiPackage#getvarDecl_Type()
	 * @model containment="true"
	 * @generated
	 */
	type getType();

	/**
	 * Sets the value of the '{@link delphi.varDecl#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(type value);

	/**
	 * Returns the value of the '<em><b>Abs Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abs Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abs Id</em>' containment reference.
	 * @see #setAbsId(ident)
	 * @see delphi.DelphiPackage#getvarDecl_AbsId()
	 * @model containment="true"
	 * @generated
	 */
	ident getAbsId();

	/**
	 * Sets the value of the '{@link delphi.varDecl#getAbsId <em>Abs Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abs Id</em>' containment reference.
	 * @see #getAbsId()
	 * @generated
	 */
	void setAbsId(ident value);

	/**
	 * Returns the value of the '<em><b>Abs Const</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abs Const</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abs Const</em>' containment reference.
	 * @see #setAbsConst(constExpr)
	 * @see delphi.DelphiPackage#getvarDecl_AbsConst()
	 * @model containment="true"
	 * @generated
	 */
	constExpr getAbsConst();

	/**
	 * Sets the value of the '{@link delphi.varDecl#getAbsConst <em>Abs Const</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abs Const</em>' containment reference.
	 * @see #getAbsConst()
	 * @generated
	 */
	void setAbsConst(constExpr value);

	/**
	 * Returns the value of the '<em><b>Abs Initi</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abs Initi</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abs Initi</em>' containment reference.
	 * @see #setAbsIniti(constExpr)
	 * @see delphi.DelphiPackage#getvarDecl_AbsIniti()
	 * @model containment="true"
	 * @generated
	 */
	constExpr getAbsIniti();

	/**
	 * Sets the value of the '{@link delphi.varDecl#getAbsIniti <em>Abs Initi</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abs Initi</em>' containment reference.
	 * @see #getAbsIniti()
	 * @generated
	 */
	void setAbsIniti(constExpr value);

} // varDecl
