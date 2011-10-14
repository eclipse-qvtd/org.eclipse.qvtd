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
 * $Id: Variable.java,v 1.1 2008/07/23 09:56:31 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EssentialOCL;

import org.eclipse.qvt.declarative.emof.EMOF.Parameter;
import org.eclipse.qvt.declarative.emof.EMOF.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EssentialOCL.Variable#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EssentialOCL.Variable#getLetExp <em>Let Exp</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EssentialOCL.Variable#getRepresentedParameter <em>Represented Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Expression</em>' containment reference.
	 * @see #setInitExpression(OclExpression)
	 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getVariable_InitExpression()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='initializedElement'"
	 * @generated
	 */
	OclExpression getInitExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EssentialOCL.Variable#getInitExpression <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Expression</em>' containment reference.
	 * @see #getInitExpression()
	 * @generated
	 */
	void setInitExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Let Exp</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.EssentialOCL.LetExp#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Let Exp</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Let Exp</em>' container reference.
	 * @see #setLetExp(LetExp)
	 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getVariable_LetExp()
	 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.LetExp#getVariable
	 * @model opposite="variable"
	 * @generated
	 */
	LetExp getLetExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EssentialOCL.Variable#getLetExp <em>Let Exp</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Let Exp</em>' container reference.
	 * @see #getLetExp()
	 * @generated
	 */
	void setLetExp(LetExp value);

	/**
	 * Returns the value of the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Represented Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Represented Parameter</em>' reference.
	 * @see #setRepresentedParameter(Parameter)
	 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getVariable_RepresentedParameter()
	 * @model
	 * @generated
	 */
	Parameter getRepresentedParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EssentialOCL.Variable#getRepresentedParameter <em>Represented Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented Parameter</em>' reference.
	 * @see #getRepresentedParameter()
	 * @generated
	 */
	void setRepresentedParameter(Parameter value);

} // Variable
