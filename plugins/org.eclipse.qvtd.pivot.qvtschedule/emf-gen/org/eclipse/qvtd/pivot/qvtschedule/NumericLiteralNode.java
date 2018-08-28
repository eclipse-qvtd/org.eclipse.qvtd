/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtschedule;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Literal Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A StringLiteralNode supports a String literal value in a QVTs graph.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode#getNumericValue <em>Numeric Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNumericLiteralNode()
 * @model
 * @generated
 */
public interface NumericLiteralNode extends OperationNode {
	/**
	 * Returns the value of the '<em><b>Numeric Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The numeric literal value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Numeric Value</em>' attribute.
	 * @see #setNumericValue(Number)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNumericLiteralNode_NumericValue()
	 * @model dataType="org.eclipse.qvtd.pivot.qvtschedule.Number" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!NumericLiteralNode!numericValue'"
	 * @generated
	 */
	Number getNumericValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode#getNumericValue <em>Numeric Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numeric Value</em>' attribute.
	 * @see #getNumericValue()
	 * @generated
	 */
	void setNumericValue(Number value);

} // NumericLiteralNode
