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
 * A representation of the model object '<em><b>constant Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.constantDecl#getId <em>Id</em>}</li>
 *   <li>{@link delphi.constantDecl#getConst <em>Const</em>}</li>
 *   <li>{@link delphi.constantDecl#getPort <em>Port</em>}</li>
 *   <li>{@link delphi.constantDecl#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link delphi.constantDecl#getTypedConstat <em>Typed Constat</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getconstantDecl()
 * @model
 * @generated
 */
public interface constantDecl extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' containment reference.
	 * @see #setId(ident)
	 * @see delphi.DelphiPackage#getconstantDecl_Id()
	 * @model containment="true"
	 * @generated
	 */
	ident getId();

	/**
	 * Sets the value of the '{@link delphi.constantDecl#getId <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' containment reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(ident value);

	/**
	 * Returns the value of the '<em><b>Const</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Const</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Const</em>' containment reference.
	 * @see #setConst(constExpr)
	 * @see delphi.DelphiPackage#getconstantDecl_Const()
	 * @model containment="true"
	 * @generated
	 */
	constExpr getConst();

	/**
	 * Sets the value of the '{@link delphi.constantDecl#getConst <em>Const</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Const</em>' containment reference.
	 * @see #getConst()
	 * @generated
	 */
	void setConst(constExpr value);

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
	 * @see delphi.DelphiPackage#getconstantDecl_Port()
	 * @model
	 * @generated
	 */
	String getPort();

	/**
	 * Sets the value of the '{@link delphi.constantDecl#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(String value);

	/**
	 * Returns the value of the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Ref</em>' containment reference.
	 * @see #setTypeRef(typeId)
	 * @see delphi.DelphiPackage#getconstantDecl_TypeRef()
	 * @model containment="true"
	 * @generated
	 */
	typeId getTypeRef();

	/**
	 * Sets the value of the '{@link delphi.constantDecl#getTypeRef <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Ref</em>' containment reference.
	 * @see #getTypeRef()
	 * @generated
	 */
	void setTypeRef(typeId value);

	/**
	 * Returns the value of the '<em><b>Typed Constat</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Constat</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Constat</em>' containment reference.
	 * @see #setTypedConstat(typedConstant)
	 * @see delphi.DelphiPackage#getconstantDecl_TypedConstat()
	 * @model containment="true"
	 * @generated
	 */
	typedConstant getTypedConstat();

	/**
	 * Sets the value of the '{@link delphi.constantDecl#getTypedConstat <em>Typed Constat</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Constat</em>' containment reference.
	 * @see #getTypedConstat()
	 * @generated
	 */
	void setTypedConstat(typedConstant value);

} // constantDecl
