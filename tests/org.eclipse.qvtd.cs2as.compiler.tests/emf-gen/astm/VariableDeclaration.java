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
 * A representation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.VariableDeclaration#isIsMutable <em>Is Mutable</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getVariableDeclaration()
 * @model
 * @generated
 */
public interface VariableDeclaration extends Declaration {
	/**
	 * Returns the value of the '<em><b>Is Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Mutable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Mutable</em>' attribute.
	 * @see #setIsMutable(boolean)
	 * @see astm.AstmPackage#getVariableDeclaration_IsMutable()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!VariableDeclaration!isMutable'"
	 * @generated
	 */
	boolean isIsMutable();

	/**
	 * Sets the value of the '{@link astm.VariableDeclaration#isIsMutable <em>Is Mutable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Mutable</em>' attribute.
	 * @see #isIsMutable()
	 * @generated
	 */
	void setIsMutable(boolean value);

} // VariableDeclaration
