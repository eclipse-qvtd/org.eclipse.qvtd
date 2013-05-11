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
import org.eclipse.ocl.examples.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getSlotValue <em>Slot Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getInitValue <em>Init Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGPropertyAssignment()
 * @model
 * @generated
 */
public interface CGPropertyAssignment extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' container reference.
	 * @see #setMapping(CGMapping)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGPropertyAssignment_Mapping()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getAssignments
	 * @model opposite="assignments" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGMapping getMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMapping <em>Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' container reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(CGMapping value);

	/**
	 * Returns the value of the '<em><b>Slot Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot Value</em>' containment reference.
	 * @see #setSlotValue(CGValuedElement)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGPropertyAssignment_SlotValue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getSlotValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getSlotValue <em>Slot Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot Value</em>' containment reference.
	 * @see #getSlotValue()
	 * @generated
	 */
	void setSlotValue(CGValuedElement value);

	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' attribute.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGPropertyAssignment_ReferredProperty()
	 * @model dataType="org.eclipse.ocl.examples.codegen.cgmodel.Property" required="true"
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getReferredProperty <em>Referred Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' attribute.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Value</em>' containment reference.
	 * @see #setInitValue(CGValuedElement)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGPropertyAssignment_InitValue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getInitValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getInitValue <em>Init Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Value</em>' containment reference.
	 * @see #getInitValue()
	 * @generated
	 */
	void setInitValue(CGValuedElement value);

} // CGAssignment
