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

import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMappingExp <em>Mapping Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getSlotValue <em>Slot Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getInitValue <em>Init Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getExecutorProperty <em>Executor Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGPropertyAssignment()
 * @model
 * @generated
 */
public interface CGPropertyAssignment extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Mapping Exp</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Exp</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Exp</em>' container reference.
	 * @see #setMappingExp(CGMappingExp)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGPropertyAssignment_MappingExp()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getAssignments
	 * @model opposite="assignments" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGMappingExp getMappingExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMappingExp <em>Mapping Exp</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Exp</em>' container reference.
	 * @see #getMappingExp()
	 * @generated
	 */
	void setMappingExp(CGMappingExp value);

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

	/**
	 * Returns the value of the '<em><b>Executor Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executor Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executor Property</em>' reference.
	 * @see #setExecutorProperty(CGExecutorProperty)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGPropertyAssignment_ExecutorProperty()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	CGExecutorProperty getExecutorProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getExecutorProperty <em>Executor Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executor Property</em>' reference.
	 * @see #getExecutorProperty()
	 * @generated
	 */
	void setExecutorProperty(CGExecutorProperty value);

} // CGAssignment
