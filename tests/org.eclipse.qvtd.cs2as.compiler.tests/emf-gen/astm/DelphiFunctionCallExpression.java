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
 * A representation of the model object '<em><b>Delphi Function Call Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.DelphiFunctionCallExpression#getApplyTo <em>Apply To</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getDelphiFunctionCallExpression()
 * @model
 * @generated
 */
public interface DelphiFunctionCallExpression extends FunctionCallExpression {
	/**
	 * Returns the value of the '<em><b>Apply To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Apply To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Apply To</em>' reference.
	 * @see #setApplyTo(DefinitionObject)
	 * @see astm.AstmPackage#getDelphiFunctionCallExpression_ApplyTo()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!DelphiFunctionCallExpression!applyTo'"
	 * @generated
	 */
	DefinitionObject getApplyTo();

	/**
	 * Sets the value of the '{@link astm.DelphiFunctionCallExpression#getApplyTo <em>Apply To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Apply To</em>' reference.
	 * @see #getApplyTo()
	 * @generated
	 */
	void setApplyTo(DefinitionObject value);

} // DelphiFunctionCallExpression
