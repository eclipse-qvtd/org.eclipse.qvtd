/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
 * A representation of the model object '<em><b>Buffer Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A BufferStatement declares a connection buffer and optionally assigns initial content.
 *
 * syntax: oclText[buffer name : type := expression;]
 *
 * oclText[type] or oclText[expression] but not both may be omitted. An omitted type is deduced from the initial expression values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getFirstPass <em>First Pass</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getLastPass <em>Last Pass</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getBufferStatement()
 * @generated
 */
public interface BufferStatement extends ConnectionVariable, VariableStatement, ObservableStatement {
	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional expression computing initial content values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getBufferStatement_OwnedExpression()
	 * @generated
	 */
	OCLExpression getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>First Pass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The earliest (inclusive) pass in which this buffer is written to.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>First Pass</em>' attribute.
	 * @see #setFirstPass(Integer)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getBufferStatement_FirstPass()
	 * @generated
	 */
	Integer getFirstPass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getFirstPass <em>First Pass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Pass</em>' attribute.
	 * @see #getFirstPass()
	 * @generated
	 */
	void setFirstPass(Integer value);

	/**
	 * Returns the value of the '<em><b>Last Pass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The latest (inclusive) pass in which this buffer is written to.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Last Pass</em>' attribute.
	 * @see #setLastPass(Integer)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getBufferStatement_LastPass()
	 * @generated
	 */
	Integer getLastPass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getLastPass <em>Last Pass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Pass</em>' attribute.
	 * @see #getLastPass()
	 * @generated
	 */
	void setLastPass(Integer value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleTypeForValue(DiagnosticChain diagnostics, Map<Object, Object> context);

} // BufferStatement
