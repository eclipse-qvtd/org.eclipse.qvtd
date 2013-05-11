/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel;

import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getConditionExpression <em>Condition Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGPredicate()
 * @model
 * @generated
 */
public interface CGPredicate extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getPredicates <em>Predicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' container reference.
	 * @see #setMapping(CGMapping)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGPredicate_Mapping()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getPredicates
	 * @model opposite="predicates" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGMapping getMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getMapping <em>Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' container reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(CGMapping value);

	/**
	 * Returns the value of the '<em><b>Condition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Expression</em>' containment reference.
	 * @see #setConditionExpression(CGValuedElement)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGPredicate_ConditionExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getConditionExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getConditionExpression <em>Condition Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Expression</em>' containment reference.
	 * @see #getConditionExpression()
	 * @generated
	 */
	void setConditionExpression(CGValuedElement value);

} // CGPredicate
