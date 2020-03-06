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

import org.eclipse.ocl.pivot.EnumerationLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An EnumLiteralNode supports an enumeration literal value in a QVTs graph.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode#getEnumValue <em>Enum Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getEnumLiteralNode()
 * @model
 * @generated
 */
public interface EnumLiteralNode extends OperationNode {
	/**
	 * Returns the value of the '<em><b>Enum Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The enumeration value for the enum literal.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Enum Value</em>' reference.
	 * @see #setEnumValue(EnumerationLiteral)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getEnumLiteralNode_EnumValue()
	 * @model required="true"
	 * @generated
	 */
	EnumerationLiteral getEnumValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode#getEnumValue <em>Enum Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Value</em>' reference.
	 * @see #getEnumValue()
	 * @generated
	 */
	void setEnumValue(EnumerationLiteral value);

} // EnumLiteralNode
