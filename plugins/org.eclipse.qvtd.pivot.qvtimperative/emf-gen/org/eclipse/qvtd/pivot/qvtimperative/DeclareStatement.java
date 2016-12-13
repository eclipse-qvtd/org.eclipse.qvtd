/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A DeclareStatement declares a variable and initial value.
 * 
 * syntax: oclText[check var name : type := expression;]
 * 
 * oclText[type] or oclText[expression] but not both may be omitted. An omitted type is deduced from the initial expression values.
 * 
 * oclText[check] may be omitted when the expression type is necessarily conformant.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#isIsCheck <em>Is Check</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getDeclareStatement()
 * @generated
 */
public interface DeclareStatement extends VariableStatement, ObservableStatement {
	/**
	 * Returns the value of the '<em><b>Is Check</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if the initial expression's type must be  checked for conformance with the variable's type.
	 * A non-conforming vlaue is a predicate failure causing the mapping to fail without doing anything.
	 * This is a derivation of not ownedInit.type.conformsTo(self.type).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Check</em>' attribute.
	 * @see #setIsCheck(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getDeclareStatement_IsCheck()
	 * @generated
	 */
	boolean isIsCheck();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#isIsCheck <em>Is Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Check</em>' attribute.
	 * @see #isIsCheck()
	 * @generated
	 */
	void setIsCheck(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression computing the variable's value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getDeclareStatement_OwnedExpression()
	 * @generated
	 */
	OCLExpression getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(OCLExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleTypeForCheckedValue(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleTypeForUncheckedValue(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PredicateVariable
