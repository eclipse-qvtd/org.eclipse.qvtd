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

import java.util.List;

import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedAssignments <em>Owned Assignments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedBody <em>Owned Body</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedConnectionAssignments <em>Owned Connection Assignments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedGuardVariables <em>Owned Guard Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedRealizedVariables <em>Owned Realized Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwningTransformation <em>Owning Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#isUseClass <em>Use Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping()
 * @model
 * @generated
 */
public interface CGMapping extends CGNamedElement {

	/**
	 * Returns the value of the '<em><b>Owned Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Assignments</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_OwnedAssignments()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwningMapping
	 * @model opposite="owningMapping" containment="true"
	 * @generated
	 */
	List<CGPropertyAssignment> getOwnedAssignments();

	/**
	 * Returns the value of the '<em><b>Owned Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Body</em>' containment reference.
	 * @see #setOwnedBody(CGValuedElement)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_OwnedBody()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getOwnedBody();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedBody <em>Owned Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Body</em>' containment reference.
	 * @see #getOwnedBody()
	 * @generated
	 */
	void setOwnedBody(CGValuedElement value);

	/**
	 * Returns the value of the '<em><b>Owned Connection Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Connection Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Connection Assignments</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_OwnedConnectionAssignments()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwningMapping
	 * @model opposite="owningMapping" containment="true"
	 * @generated
	 */
	List<CGConnectionAssignment> getOwnedConnectionAssignments();

	/**
	 * Returns the value of the '<em><b>Owned Guard Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameters of this operation, with 'self' as the first parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Guard Variables</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_OwnedGuardVariables()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getOwningMapping
	 * @model opposite="owningMapping" containment="true" ordered="false"
	 * @generated
	 */
	List<CGGuardVariable> getOwnedGuardVariables();

	/**
	 * Returns the value of the '<em><b>Owned Realized Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Realized Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Realized Variables</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_OwnedRealizedVariables()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getOwningMapping
	 * @model opposite="owningMapping" containment="true"
	 * @generated
	 */
	List<CGRealizedVariable> getOwnedRealizedVariables();

	/**
	 * Returns the value of the '<em><b>Owning Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedMappings <em>Owned Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Transformation</em>' container reference.
	 * @see #setOwningTransformation(CGTransformation)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_OwningTransformation()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedMappings
	 * @model opposite="ownedMappings" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGTransformation getOwningTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwningTransformation <em>Owning Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Transformation</em>' container reference.
	 * @see #getOwningTransformation()
	 * @generated
	 */
	void setOwningTransformation(CGTransformation value);

	/**
	 * Returns the value of the '<em><b>Use Class</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Class</em>' attribute.
	 * @see #setUseClass(boolean)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMapping_UseClass()
	 * @model default="false"
	 * @generated
	 */
	boolean isUseClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#isUseClass <em>Use Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Class</em>' attribute.
	 * @see #isUseClass()
	 * @generated
	 */
	void setUseClass(boolean value);
} // CGMapping
