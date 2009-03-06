/**
 * <copyright>
 * 
 * Copyright (c) 2007,2009 E.D.Willink and others.
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
 * $Id: Constraint.java,v 1.1 2009/03/06 17:35:28 ewillink Exp $
 */
package org.eclipse.qvt.declarative.emof.FullOCL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvt.declarative.emof.EMOF.NamedElement;

import org.eclipse.qvt.declarative.emof.EssentialOCL.ExpressionInOcl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.FullOCL.Constraint#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.FullOCL.Constraint#getConstrainedElements <em>Constrained Elements</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.FullOCL.Constraint#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.FullOCL.FullOCLPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' attribute.
	 * @see #setStereotype(String)
	 * @see org.eclipse.qvt.declarative.emof.FullOCL.FullOCLPackage#getConstraint_Stereotype()
	 * @model dataType="org.eclipse.qvt.declarative.emof.EMOF.String"
	 * @generated
	 */
	String getStereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.FullOCL.Constraint#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(String value);

	/**
	 * Returns the value of the '<em><b>Constrained Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EMOF.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Elements</em>' reference list.
	 * @see org.eclipse.qvt.declarative.emof.FullOCL.FullOCLPackage#getConstraint_ConstrainedElements()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getConstrainedElements();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' containment reference.
	 * @see #setSpecification(ExpressionInOcl)
	 * @see org.eclipse.qvt.declarative.emof.FullOCL.FullOCLPackage#getConstraint_Specification()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpressionInOcl getSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.FullOCL.Constraint#getSpecification <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' containment reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(ExpressionInOcl value);

} // Constraint
