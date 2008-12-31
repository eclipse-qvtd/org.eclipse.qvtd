/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: Function.java,v 1.3 2008/12/31 17:42:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase;

import org.eclipse.emf.ecore.EOperation;

import org.eclipse.ocl.ecore.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.Function#getQueryExpression <em>Query Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getFunction()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='IsSideEffectFree\r\nEveryFunctionParameterIsAFunctionParameter'"
 * @generated
 */
public interface Function extends EOperation {
	/**
	 * Returns the value of the '<em><b>Query Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Expression</em>' containment reference.
	 * @see #setQueryExpression(OCLExpression)
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getFunction_QueryExpression()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpression getQueryExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Function#getQueryExpression <em>Query Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Expression</em>' containment reference.
	 * @see #getQueryExpression()
	 * @generated
	 */
	void setQueryExpression(OCLExpression value);

} // Function
