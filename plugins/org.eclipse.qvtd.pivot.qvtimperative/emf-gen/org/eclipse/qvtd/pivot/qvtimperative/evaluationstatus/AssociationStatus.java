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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getForwardEReference <em>Forward EReference</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getFromClassStatuses <em>From Class Statuses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#isIsInput <em>Is Input</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#isIsOutput <em>Is Output</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getOwningTransformationStatus <em>Owning Transformation Status</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getToClassStatuses <em>To Class Statuses</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getAssociationStatus()
 * @model
 * @generated
 */
public interface AssociationStatus extends PropertyStatus {
	/**
	 * Returns the value of the '<em><b>Forward EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward EReference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward EReference</em>' reference.
	 * @see #setForwardEReference(EReference)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getAssociationStatus_ForwardEReference()
	 * @model required="true"
	 * @generated
	 */
	EReference getForwardEReference();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getForwardEReference <em>Forward EReference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward EReference</em>' reference.
	 * @see #getForwardEReference()
	 * @generated
	 */
	void setForwardEReference(EReference value);

	/**
	 * Returns the value of the '<em><b>From Class Statuses</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Class Statuses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Class Statuses</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getAssociationStatus_FromClassStatuses()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ClassStatus> getFromClassStatuses();

	/**
	 * Returns the value of the '<em><b>Is Input</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Input</em>' attribute.
	 * @see #setIsInput(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getAssociationStatus_IsInput()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsInput();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#isIsInput <em>Is Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Input</em>' attribute.
	 * @see #isIsInput()
	 * @generated
	 */
	void setIsInput(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Output</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Output</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Output</em>' attribute.
	 * @see #setIsOutput(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getAssociationStatus_IsOutput()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsOutput();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#isIsOutput <em>Is Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Output</em>' attribute.
	 * @see #isIsOutput()
	 * @generated
	 */
	void setIsOutput(boolean value);

	/**
	 * Returns the value of the '<em><b>Owning Transformation Status</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedAssociationStatuses <em>Owned Association Statuses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Transformation Status</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Transformation Status</em>' container reference.
	 * @see #setOwningTransformationStatus(TransformationStatus)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getAssociationStatus_OwningTransformationStatus()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedAssociationStatuses
	 * @model opposite="ownedAssociationStatuses" required="true" transient="false"
	 * @generated
	 */
	TransformationStatus getOwningTransformationStatus();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getOwningTransformationStatus <em>Owning Transformation Status</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Transformation Status</em>' container reference.
	 * @see #getOwningTransformationStatus()
	 * @generated
	 */
	void setOwningTransformationStatus(TransformationStatus value);

	/**
	 * Returns the value of the '<em><b>To Class Statuses</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Class Statuses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Class Statuses</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getAssociationStatus_ToClassStatuses()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ClassStatus> getToClassStatuses();

} // AssociationStatus
