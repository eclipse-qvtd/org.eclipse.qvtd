/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel;

import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Variable Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate#getPredicateVariable <em>Predicate Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGVariablePredicate()
 * @model
 * @generated
 */
public interface CGVariablePredicate extends CGPredicate {
	/**
	 * Returns the value of the '<em><b>Predicate Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate Variable</em>' containment reference.
	 * @see #setPredicateVariable(CGVariable)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGVariablePredicate_PredicateVariable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGVariable getPredicateVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate#getPredicateVariable <em>Predicate Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate Variable</em>' containment reference.
	 * @see #getPredicateVariable()
	 * @generated
	 */
	void setPredicateVariable(CGVariable value);

} // CGVariablePredicate
