/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.cst;

import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS#getGuardExpression <em>Guard Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getTemplateCS()
 * @model abstract="true"
 * @generated
 */
public interface TemplateCS extends TemplateVariableCS, OCLExpressionCS {

	/**
	 * Returns the value of the '<em><b>Guard Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard Expression</em>' containment reference.
	 * @see #setGuardExpression(OCLExpressionCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getTemplateCS_GuardExpression()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpressionCS getGuardExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS#getGuardExpression <em>Guard Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard Expression</em>' containment reference.
	 * @see #getGuardExpression()
	 * @generated
	 */
	void setGuardExpression(OCLExpressionCS value);

} // TemplateCS
