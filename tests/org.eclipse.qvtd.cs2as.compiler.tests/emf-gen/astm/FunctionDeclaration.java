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
 * A representation of the model object '<em><b>Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.FunctionDeclaration#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link astm.FunctionDeclaration#getFunctionMemberAttributes <em>Function Member Attributes</em>}</li>
 *   <li>{@link astm.FunctionDeclaration#getReturnType <em>Return Type</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getFunctionDeclaration()
 * @model
 * @generated
 */
public interface FunctionDeclaration extends Declaration {
	/**
	 * Returns the value of the '<em><b>Formal Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link astm.FormalParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formal Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formal Parameters</em>' containment reference list.
	 * @see astm.AstmPackage#getFunctionDeclaration_FormalParameters()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!FunctionDeclaration!formalParameters'"
	 * @generated
	 */
	EList<FormalParameterDeclaration> getFormalParameters();

	/**
	 * Returns the value of the '<em><b>Function Member Attributes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Member Attributes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Member Attributes</em>' containment reference.
	 * @see #setFunctionMemberAttributes(FunctionMemberAttributes)
	 * @see astm.AstmPackage#getFunctionDeclaration_FunctionMemberAttributes()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!FunctionDeclaration!functionMemberAttributes'"
	 * @generated
	 */
	FunctionMemberAttributes getFunctionMemberAttributes();

	/**
	 * Sets the value of the '{@link astm.FunctionDeclaration#getFunctionMemberAttributes <em>Function Member Attributes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Member Attributes</em>' containment reference.
	 * @see #getFunctionMemberAttributes()
	 * @generated
	 */
	void setFunctionMemberAttributes(FunctionMemberAttributes value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(TypeReference)
	 * @see astm.AstmPackage#getFunctionDeclaration_ReturnType()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!FunctionDeclaration!returnType'"
	 * @generated
	 */
	TypeReference getReturnType();

	/**
	 * Sets the value of the '{@link astm.FunctionDeclaration#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(TypeReference value);

} // FunctionDeclaration
