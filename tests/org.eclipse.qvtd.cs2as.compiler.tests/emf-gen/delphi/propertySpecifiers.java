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
 * A representation of the model object '<em><b>property Specifiers</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.propertySpecifiers#getIndex <em>Index</em>}</li>
 *   <li>{@link delphi.propertySpecifiers#getReadId <em>Read Id</em>}</li>
 *   <li>{@link delphi.propertySpecifiers#getWriteId <em>Write Id</em>}</li>
 *   <li>{@link delphi.propertySpecifiers#getStoreId <em>Store Id</em>}</li>
 *   <li>{@link delphi.propertySpecifiers#getStoreExp <em>Store Exp</em>}</li>
 *   <li>{@link delphi.propertySpecifiers#getDefaulExp <em>Defaul Exp</em>}</li>
 *   <li>{@link delphi.propertySpecifiers#getImplement <em>Implement</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getpropertySpecifiers()
 * @model
 * @generated
 */
public interface propertySpecifiers extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' containment reference.
	 * @see #setIndex(constExpr)
	 * @see delphi.DelphiPackage#getpropertySpecifiers_Index()
	 * @model containment="true"
	 * @generated
	 */
	constExpr getIndex();

	/**
	 * Sets the value of the '{@link delphi.propertySpecifiers#getIndex <em>Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' containment reference.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(constExpr value);

	/**
	 * Returns the value of the '<em><b>Read Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Id</em>' containment reference.
	 * @see #setReadId(ident)
	 * @see delphi.DelphiPackage#getpropertySpecifiers_ReadId()
	 * @model containment="true"
	 * @generated
	 */
	ident getReadId();

	/**
	 * Sets the value of the '{@link delphi.propertySpecifiers#getReadId <em>Read Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Id</em>' containment reference.
	 * @see #getReadId()
	 * @generated
	 */
	void setReadId(ident value);

	/**
	 * Returns the value of the '<em><b>Write Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Id</em>' containment reference.
	 * @see #setWriteId(ident)
	 * @see delphi.DelphiPackage#getpropertySpecifiers_WriteId()
	 * @model containment="true"
	 * @generated
	 */
	ident getWriteId();

	/**
	 * Sets the value of the '{@link delphi.propertySpecifiers#getWriteId <em>Write Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Id</em>' containment reference.
	 * @see #getWriteId()
	 * @generated
	 */
	void setWriteId(ident value);

	/**
	 * Returns the value of the '<em><b>Store Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Id</em>' containment reference.
	 * @see #setStoreId(ident)
	 * @see delphi.DelphiPackage#getpropertySpecifiers_StoreId()
	 * @model containment="true"
	 * @generated
	 */
	ident getStoreId();

	/**
	 * Sets the value of the '{@link delphi.propertySpecifiers#getStoreId <em>Store Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Id</em>' containment reference.
	 * @see #getStoreId()
	 * @generated
	 */
	void setStoreId(ident value);

	/**
	 * Returns the value of the '<em><b>Store Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Exp</em>' containment reference.
	 * @see #setStoreExp(constExpr)
	 * @see delphi.DelphiPackage#getpropertySpecifiers_StoreExp()
	 * @model containment="true"
	 * @generated
	 */
	constExpr getStoreExp();

	/**
	 * Sets the value of the '{@link delphi.propertySpecifiers#getStoreExp <em>Store Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Exp</em>' containment reference.
	 * @see #getStoreExp()
	 * @generated
	 */
	void setStoreExp(constExpr value);

	/**
	 * Returns the value of the '<em><b>Defaul Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defaul Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defaul Exp</em>' containment reference.
	 * @see #setDefaulExp(constExpr)
	 * @see delphi.DelphiPackage#getpropertySpecifiers_DefaulExp()
	 * @model containment="true"
	 * @generated
	 */
	constExpr getDefaulExp();

	/**
	 * Sets the value of the '{@link delphi.propertySpecifiers#getDefaulExp <em>Defaul Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defaul Exp</em>' containment reference.
	 * @see #getDefaulExp()
	 * @generated
	 */
	void setDefaulExp(constExpr value);

	/**
	 * Returns the value of the '<em><b>Implement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implement</em>' containment reference.
	 * @see #setImplement(typeId)
	 * @see delphi.DelphiPackage#getpropertySpecifiers_Implement()
	 * @model containment="true"
	 * @generated
	 */
	typeId getImplement();

	/**
	 * Sets the value of the '{@link delphi.propertySpecifiers#getImplement <em>Implement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implement</em>' containment reference.
	 * @see #getImplement()
	 * @generated
	 */
	void setImplement(typeId value);

} // propertySpecifiers
