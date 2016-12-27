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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Qualified Identifier Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.TypeQualifiedIdentifierReference#getAggregateType <em>Aggregate Type</em>}</li>
 *   <li>{@link astm.TypeQualifiedIdentifierReference#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getTypeQualifiedIdentifierReference()
 * @model
 * @generated
 */
public interface TypeQualifiedIdentifierReference extends NameReference {
	/**
	 * Returns the value of the '<em><b>Aggregate Type</b></em>' containment reference list.
	 * The list contents are of type {@link astm.TypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregate Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregate Type</em>' containment reference list.
	 * @see astm.AstmPackage#getTypeQualifiedIdentifierReference_AggregateType()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!TypeQualifiedIdentifierReference!aggregateType'"
	 * @generated
	 */
	EList<TypeReference> getAggregateType();

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
	 * @see astm.AstmPackage#getTypeQualifiedIdentifierReference_Member()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!TypeQualifiedIdentifierReference!member'"
	 * @generated
	 */
	IdentifierReference getMember();

	/**
	 * Sets the value of the '{@link astm.TypeQualifiedIdentifierReference#getMember <em>Member</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member</em>' containment reference.
	 * @see #getMember()
	 * @generated
	 */
	void setMember(IdentifierReference value);

} // TypeQualifiedIdentifierReference
