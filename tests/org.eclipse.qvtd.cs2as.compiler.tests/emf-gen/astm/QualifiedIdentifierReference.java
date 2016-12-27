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
 * A representation of the model object '<em><b>Qualified Identifier Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.QualifiedIdentifierReference#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link astm.QualifiedIdentifierReference#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getQualifiedIdentifierReference()
 * @model abstract="true"
 * @generated
 */
public interface QualifiedIdentifierReference extends NameReference {
	/**
	 * Returns the value of the '<em><b>Qualifiers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifiers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifiers</em>' containment reference.
	 * @see #setQualifiers(Expression)
	 * @see astm.AstmPackage#getQualifiedIdentifierReference_Qualifiers()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!QualifiedIdentifierReference!qualifiers'"
	 * @generated
	 */
	Expression getQualifiers();

	/**
	 * Sets the value of the '{@link astm.QualifiedIdentifierReference#getQualifiers <em>Qualifiers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualifiers</em>' containment reference.
	 * @see #getQualifiers()
	 * @generated
	 */
	void setQualifiers(Expression value);

	/**
	 * Returns the value of the '<em><b>Member</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' containment reference.
	 * @see #setMember(IdentifierReference)
	 * @see astm.AstmPackage#getQualifiedIdentifierReference_Member()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!QualifiedIdentifierReference!member'"
	 * @generated
	 */
	IdentifierReference getMember();

	/**
	 * Sets the value of the '{@link astm.QualifiedIdentifierReference#getMember <em>Member</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member</em>' containment reference.
	 * @see #getMember()
	 * @generated
	 */
	void setMember(IdentifierReference value);

} // QualifiedIdentifierReference
