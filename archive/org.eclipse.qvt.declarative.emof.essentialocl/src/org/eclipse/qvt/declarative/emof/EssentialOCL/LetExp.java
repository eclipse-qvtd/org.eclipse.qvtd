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
 * $Id: LetExp.java,v 1.1 2008/07/23 09:56:32 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EssentialOCL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EssentialOCL.LetExp#getIn <em>In</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EssentialOCL.LetExp#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getLetExp()
 * @model
 * @generated
 */
public interface LetExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' containment reference.
	 * @see #setIn(OclExpression)
	 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getLetExp_In()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getIn();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EssentialOCL.LetExp#getIn <em>In</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In</em>' containment reference.
	 * @see #getIn()
	 * @generated
	 */
	void setIn(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.EssentialOCL.Variable#getLetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(Variable)
	 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getLetExp_Variable()
	 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.Variable#getLetExp
	 * @model opposite="letExp" containment="true" required="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EssentialOCL.LetExp#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

} // LetExp
