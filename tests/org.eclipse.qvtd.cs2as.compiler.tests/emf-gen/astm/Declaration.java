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
package astm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.Declaration#getDefRef <em>Def Ref</em>}</li>
 *   <li>{@link astm.Declaration#getIdentifierName <em>Identifier Name</em>}</li>
 *   <li>{@link astm.Declaration#getDeclarationType <em>Declaration Type</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface Declaration extends DeclarationOrDefinition {
	/**
	 * Returns the value of the '<em><b>Def Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Def Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Def Ref</em>' containment reference.
	 * @see #setDefRef(Definition)
	 * @see astm.AstmPackage#getDeclaration_DefRef()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!Declaration!defRef'"
	 * @generated
	 */
	Definition getDefRef();

	/**
	 * Sets the value of the '{@link astm.Declaration#getDefRef <em>Def Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Def Ref</em>' containment reference.
	 * @see #getDefRef()
	 * @generated
	 */
	void setDefRef(Definition value);

	/**
	 * Returns the value of the '<em><b>Identifier Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier Name</em>' containment reference.
	 * @see #setIdentifierName(Name)
	 * @see astm.AstmPackage#getDeclaration_IdentifierName()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!Declaration!identifierName'"
	 * @generated
	 */
	Name getIdentifierName();

	/**
	 * Sets the value of the '{@link astm.Declaration#getIdentifierName <em>Identifier Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier Name</em>' containment reference.
	 * @see #getIdentifierName()
	 * @generated
	 */
	void setIdentifierName(Name value);

	/**
	 * Returns the value of the '<em><b>Declaration Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration Type</em>' containment reference.
	 * @see #setDeclarationType(TypeReference)
	 * @see astm.AstmPackage#getDeclaration_DeclarationType()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!Declaration!declarationType'"
	 * @generated
	 */
	TypeReference getDeclarationType();

	/**
	 * Sets the value of the '{@link astm.Declaration#getDeclarationType <em>Declaration Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration Type</em>' containment reference.
	 * @see #getDeclarationType()
	 * @generated
	 */
	void setDeclarationType(TypeReference value);

} // Declaration
