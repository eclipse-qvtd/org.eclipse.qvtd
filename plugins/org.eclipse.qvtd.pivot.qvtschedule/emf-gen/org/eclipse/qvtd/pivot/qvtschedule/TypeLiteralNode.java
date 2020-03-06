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
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.ocl.pivot.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Literal Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A TypeLiteralNode supports a type literal value in a QVTs graph.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode#getTypeValue <em>Type Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getTypeLiteralNode()
 * @model
 * @generated
 */
public interface TypeLiteralNode extends OperationNode {
	/**
	 * Returns the value of the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type for the type literal.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Value</em>' reference.
	 * @see #setTypeValue(Type)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getTypeLiteralNode_TypeValue()
	 * @model required="true"
	 * @generated
	 */
	Type getTypeValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode#getTypeValue <em>Type Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Value</em>' reference.
	 * @see #getTypeValue()
	 * @generated
	 */
	void setTypeValue(Type value);

} // TypeLiteralNode
