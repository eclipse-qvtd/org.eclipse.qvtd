/**
 * <copyright>
 * 
 * Copyright (c) 2015, 2016 Willink Transformations and others.
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
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Connection Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getConnectionVariable <em>Connection Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwnedInitValue <em>Owned Init Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwningMapping <em>Owning Mapping</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGConnectionAssignment()
 * @model
 * @generated
 */
public interface CGConnectionAssignment extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Owning Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedConnectionAssignments <em>Owned Connection Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Mapping</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Mapping</em>' container reference.
	 * @see #setOwningMapping(CGMapping)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGConnectionAssignment_OwningMapping()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedConnectionAssignments
	 * @model opposite="ownedConnectionAssignments" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGMapping getOwningMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwningMapping <em>Owning Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Mapping</em>' container reference.
	 * @see #getOwningMapping()
	 * @generated
	 */
	void setOwningMapping(CGMapping value);

	/**
	 * Returns the value of the '<em><b>Connection Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Variable</em>' reference.
	 * @see #setConnectionVariable(CGVariable)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGConnectionAssignment_ConnectionVariable()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	CGVariable getConnectionVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getConnectionVariable <em>Connection Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Variable</em>' reference.
	 * @see #getConnectionVariable()
	 * @generated
	 */
	void setConnectionVariable(CGVariable value);

	/**
	 * Returns the value of the '<em><b>Owned Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Init Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Init Value</em>' containment reference.
	 * @see #setOwnedInitValue(CGValuedElement)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGConnectionAssignment_OwnedInitValue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getOwnedInitValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwnedInitValue <em>Owned Init Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Init Value</em>' containment reference.
	 * @see #getOwnedInitValue()
	 * @generated
	 */
	void setOwnedInitValue(CGValuedElement value);

} // CGConnectionAssignment
