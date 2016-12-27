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
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.Expression#getExpressionType <em>Expression Type</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getExpression()
 * @model abstract="true"
 * @generated
 */
public interface Expression extends GASTMSyntaxObject {
	/**
	 * Returns the value of the '<em><b>Expression Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Type</em>' containment reference.
	 * @see #setExpressionType(TypeReference)
	 * @see astm.AstmPackage#getExpression_ExpressionType()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!Expression!expressionType'"
	 * @generated
	 */
	TypeReference getExpressionType();

	/**
	 * Sets the value of the '{@link astm.Expression#getExpressionType <em>Expression Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Type</em>' containment reference.
	 * @see #getExpressionType()
	 * @generated
	 */
	void setExpressionType(TypeReference value);

} // Expression
