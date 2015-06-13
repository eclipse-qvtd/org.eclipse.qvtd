/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getEFeature <em>EFeature</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getOwningClassStatus <em>Owning Class Status</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getAttributeStatus()
 * @model
 * @generated
 */
public interface AttributeStatus extends PropertyStatus {
	/**
	 * Returns the value of the '<em><b>EFeature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EFeature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EFeature</em>' reference.
	 * @see #setEFeature(EStructuralFeature)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getAttributeStatus_EFeature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getEFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getEFeature <em>EFeature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EFeature</em>' reference.
	 * @see #getEFeature()
	 * @generated
	 */
	void setEFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' attribute.
	 * @see #setObject(Object)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getAttributeStatus_Object()
	 * @model dataType="org.eclipse.ocl.pivot.Object"
	 * @generated
	 */
	Object getObject();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getObject <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' attribute.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(Object value);

	/**
	 * Returns the value of the '<em><b>Owning Class Status</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getOwnedAttributeStatuses <em>Owned Attribute Statuses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class Status</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class Status</em>' container reference.
	 * @see #setOwningClassStatus(ClassStatus)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getAttributeStatus_OwningClassStatus()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getOwnedAttributeStatuses
	 * @model opposite="ownedAttributeStatuses" required="true" transient="false"
	 * @generated
	 */
	ClassStatus getOwningClassStatus();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getOwningClassStatus <em>Owning Class Status</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Class Status</em>' container reference.
	 * @see #getOwningClassStatus()
	 * @generated
	 */
	void setOwningClassStatus(ClassStatus value);

} // AttributeStatus
