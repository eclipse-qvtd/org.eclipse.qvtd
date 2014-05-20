/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel;

import java.util.List;

import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Mapping Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getMappingCalls <em>Mapping Calls</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getPredicates <em>Predicates</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getRealizedVariables <em>Realized Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingExp()
 * @model
 * @generated
 */
public interface CGMappingExp extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMappingExp <em>Mapping Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignments</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingExp_Assignments()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMappingExp
	 * @model opposite="mappingExp" containment="true"
	 * @generated
	 */
	List<CGPropertyAssignment> getAssignments();

	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' reference.
	 * @see #setMapping(CGMapping)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingExp_Mapping()
	 * @model resolveProxies="false" required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	CGMapping getMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getMapping <em>Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(CGMapping value);

	/**
	 * Returns the value of the '<em><b>Mapping Calls</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getMappingExp <em>Mapping Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Calls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Calls</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingExp_MappingCalls()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getMappingExp
	 * @model opposite="mappingExp" containment="true"
	 * @generated
	 */
	List<CGMappingCall> getMappingCalls();

	/**
	 * Returns the value of the '<em><b>Predicates</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getMappingExp <em>Mapping Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicates</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingExp_Predicates()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getMappingExp
	 * @model opposite="mappingExp" containment="true"
	 * @generated
	 */
	List<CGPredicate> getPredicates();

	/**
	 * Returns the value of the '<em><b>Realized Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Variables</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingExp_RealizedVariables()
	 * @model containment="true"
	 * @generated
	 */
	List<CGValuedElement> getRealizedVariables();

} // CGMappingExp
