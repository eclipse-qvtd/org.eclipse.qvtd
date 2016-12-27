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
 * A representation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.ConditionalExpression#getCondition <em>Condition</em>}</li>
 *   <li>{@link astm.ConditionalExpression#getOnTrueOperand <em>On True Operand</em>}</li>
 *   <li>{@link astm.ConditionalExpression#getOnFalseOperand <em>On False Operand</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getConditionalExpression()
 * @model
 * @generated
 */
public interface ConditionalExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see astm.AstmPackage#getConditionalExpression_Condition()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!ConditionalExpression!condition'"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link astm.ConditionalExpression#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>On True Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On True Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On True Operand</em>' containment reference.
	 * @see #setOnTrueOperand(Expression)
	 * @see astm.AstmPackage#getConditionalExpression_OnTrueOperand()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!ConditionalExpression!onTrueOperand'"
	 * @generated
	 */
	Expression getOnTrueOperand();

	/**
	 * Sets the value of the '{@link astm.ConditionalExpression#getOnTrueOperand <em>On True Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On True Operand</em>' containment reference.
	 * @see #getOnTrueOperand()
	 * @generated
	 */
	void setOnTrueOperand(Expression value);

	/**
	 * Returns the value of the '<em><b>On False Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On False Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On False Operand</em>' containment reference.
	 * @see #setOnFalseOperand(Expression)
	 * @see astm.AstmPackage#getConditionalExpression_OnFalseOperand()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!ConditionalExpression!onFalseOperand'"
	 * @generated
	 */
	Expression getOnFalseOperand();

	/**
	 * Sets the value of the '{@link astm.ConditionalExpression#getOnFalseOperand <em>On False Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On False Operand</em>' containment reference.
	 * @see #getOnFalseOperand()
	 * @generated
	 */
	void setOnFalseOperand(Expression value);

} // ConditionalExpression
