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
 * A representation of the model object '<em><b>Variable Catch Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.VariableCatchBlock#getExceptionVariable <em>Exception Variable</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getVariableCatchBlock()
 * @model
 * @generated
 */
public interface VariableCatchBlock extends CatchBlock {
	/**
	 * Returns the value of the '<em><b>Exception Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception Variable</em>' containment reference.
	 * @see #setExceptionVariable(DataDefinition)
	 * @see astm.AstmPackage#getVariableCatchBlock_ExceptionVariable()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!VariableCatchBlock!exceptionVariable'"
	 * @generated
	 */
	DataDefinition getExceptionVariable();

	/**
	 * Sets the value of the '{@link astm.VariableCatchBlock#getExceptionVariable <em>Exception Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Variable</em>' containment reference.
	 * @see #getExceptionVariable()
	 * @generated
	 */
	void setExceptionVariable(DataDefinition value);

} // VariableCatchBlock
