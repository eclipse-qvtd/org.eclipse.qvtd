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
 * A representation of the model object '<em><b>factor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.factor#getDesignator <em>Designator</em>}</li>
 *   <li>{@link delphi.factor#getExpList <em>Exp List</em>}</li>
 *   <li>{@link delphi.factor#getNumber <em>Number</em>}</li>
 *   <li>{@link delphi.factor#getString <em>String</em>}</li>
 *   <li>{@link delphi.factor#getNestedExp <em>Nested Exp</em>}</li>
 *   <li>{@link delphi.factor#getExp <em>Exp</em>}</li>
 *   <li>{@link delphi.factor#getSetConstuctor <em>Set Constuctor</em>}</li>
 *   <li>{@link delphi.factor#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getfactor()
 * @model
 * @generated
 */
public interface factor extends term {
	/**
	 * Returns the value of the '<em><b>Designator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Designator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Designator</em>' containment reference.
	 * @see #setDesignator(designator)
	 * @see delphi.DelphiPackage#getfactor_Designator()
	 * @model containment="true"
	 * @generated
	 */
	designator getDesignator();

	/**
	 * Sets the value of the '{@link delphi.factor#getDesignator <em>Designator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Designator</em>' containment reference.
	 * @see #getDesignator()
	 * @generated
	 */
	void setDesignator(designator value);

	/**
	 * Returns the value of the '<em><b>Exp List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp List</em>' containment reference.
	 * @see #setExpList(exprList)
	 * @see delphi.DelphiPackage#getfactor_ExpList()
	 * @model containment="true"
	 * @generated
	 */
	exprList getExpList();

	/**
	 * Sets the value of the '{@link delphi.factor#getExpList <em>Exp List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp List</em>' containment reference.
	 * @see #getExpList()
	 * @generated
	 */
	void setExpList(exprList value);

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(String)
	 * @see delphi.DelphiPackage#getfactor_Number()
	 * @model
	 * @generated
	 */
	String getNumber();

	/**
	 * Sets the value of the '{@link delphi.factor#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(String value);

	/**
	 * Returns the value of the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String</em>' attribute.
	 * @see #setString(String)
	 * @see delphi.DelphiPackage#getfactor_String()
	 * @model
	 * @generated
	 */
	String getString();

	/**
	 * Sets the value of the '{@link delphi.factor#getString <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' attribute.
	 * @see #getString()
	 * @generated
	 */
	void setString(String value);

	/**
	 * Returns the value of the '<em><b>Nested Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Exp</em>' containment reference.
	 * @see #setNestedExp(expression)
	 * @see delphi.DelphiPackage#getfactor_NestedExp()
	 * @model containment="true"
	 * @generated
	 */
	expression getNestedExp();

	/**
	 * Sets the value of the '{@link delphi.factor#getNestedExp <em>Nested Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nested Exp</em>' containment reference.
	 * @see #getNestedExp()
	 * @generated
	 */
	void setNestedExp(expression value);

	/**
	 * Returns the value of the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp</em>' containment reference.
	 * @see #setExp(expression)
	 * @see delphi.DelphiPackage#getfactor_Exp()
	 * @model containment="true"
	 * @generated
	 */
	expression getExp();

	/**
	 * Sets the value of the '{@link delphi.factor#getExp <em>Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp</em>' containment reference.
	 * @see #getExp()
	 * @generated
	 */
	void setExp(expression value);

	/**
	 * Returns the value of the '<em><b>Set Constuctor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Constuctor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Constuctor</em>' containment reference.
	 * @see #setSetConstuctor(setConstructor)
	 * @see delphi.DelphiPackage#getfactor_SetConstuctor()
	 * @model containment="true"
	 * @generated
	 */
	setConstructor getSetConstuctor();

	/**
	 * Sets the value of the '{@link delphi.factor#getSetConstuctor <em>Set Constuctor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Constuctor</em>' containment reference.
	 * @see #getSetConstuctor()
	 * @generated
	 */
	void setSetConstuctor(setConstructor value);

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
	 * @see delphi.DelphiPackage#getfactor_TypeRef()
	 * @model containment="true"
	 * @generated
	 */
	typeId getTypeRef();

	/**
	 * Sets the value of the '{@link delphi.factor#getTypeRef <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Ref</em>' containment reference.
	 * @see #getTypeRef()
	 * @generated
	 */
	void setTypeRef(typeId value);

} // factor
