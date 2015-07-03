/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs;

import org.eclipse.ocl.pivot.Variable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Template CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getElementTemplateCS()
 * @model
 * @generated
 */
public interface ElementTemplateCS extends TemplateVariableCS {

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' reference.
	 * @see #setIdentifier(Variable)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getElementTemplateCS_Identifier()
	 * @model
	 * @generated
	 */
	Variable getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS#getIdentifier <em>Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(Variable value);
} // ElementTemplateCS
