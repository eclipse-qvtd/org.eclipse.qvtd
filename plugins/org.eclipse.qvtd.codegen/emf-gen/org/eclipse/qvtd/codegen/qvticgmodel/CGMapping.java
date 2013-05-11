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

import java.util.List;

import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getGuardVariables <em>Guard Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getPredicates <em>Predicates</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getRealizedVariables <em>Realized Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getMappingCalls <em>Mapping Calls</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping()
 * @model
 * @generated
 */
public interface CGMapping extends CGTypedElement {

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(CGTransformation)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_Transformation()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getMappings
	 * @model opposite="mappings" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGTransformation getTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(CGTransformation value);

	/**
	 * Returns the value of the '<em><b>Guard Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameters of this operation, with 'self' as the first parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Guard Variables</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_GuardVariables()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getMapping
	 * @model opposite="mapping" containment="true" ordered="false"
	 * @generated
	 */
	List<CGGuardVariable> getGuardVariables();

	/**
	 * Returns the value of the '<em><b>Predicates</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicates</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_Predicates()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getMapping
	 * @model opposite="mapping" containment="true"
	 * @generated
	 */
	List<CGPredicate> getPredicates();

	/**
	 * Returns the value of the '<em><b>Mapping Calls</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Calls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Calls</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_MappingCalls()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getMapping
	 * @model opposite="mapping" containment="true"
	 * @generated
	 */
	List<CGMappingCall> getMappingCalls();

	/**
	 * Returns the value of the '<em><b>Realized Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Variables</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_RealizedVariables()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getMapping
	 * @model opposite="mapping" containment="true"
	 * @generated
	 */
	List<CGRealizedVariable> getRealizedVariables();

	/**
	 * Returns the value of the '<em><b>Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignments</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_Assignments()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMapping
	 * @model opposite="mapping" containment="true"
	 * @generated
	 */
	List<CGPropertyAssignment> getAssignments();
} // CGMapping
