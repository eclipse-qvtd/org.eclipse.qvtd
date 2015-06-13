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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedAssociationStatuses <em>Owned Association Statuses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedClassStatuses <em>Owned Class Statuses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedMappingStatuses <em>Owned Mapping Statuses</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getTransformationStatus()
 * @model
 * @generated
 */
public interface TransformationStatus extends EvaluationElement {
	/**
	 * Returns the value of the '<em><b>Owned Association Statuses</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getOwningTransformationStatus <em>Owning Transformation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Association Statuses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Association Statuses</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getTransformationStatus_OwnedAssociationStatuses()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getOwningTransformationStatus
	 * @model opposite="owningTransformationStatus" containment="true" ordered="false"
	 * @generated
	 */
	EList<AssociationStatus> getOwnedAssociationStatuses();

	/**
	 * Returns the value of the '<em><b>Owned Class Statuses</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getOwningTransformationStatus <em>Owning Transformation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Class Statuses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Class Statuses</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getTransformationStatus_OwnedClassStatuses()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getOwningTransformationStatus
	 * @model opposite="owningTransformationStatus" containment="true" ordered="false"
	 * @generated
	 */
	EList<ClassStatus> getOwnedClassStatuses();

	/**
	 * Returns the value of the '<em><b>Owned Mapping Statuses</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getOwningTransformationStatus <em>Owning Transformation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mapping Statuses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Mapping Statuses</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getTransformationStatus_OwnedMappingStatuses()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getOwningTransformationStatus
	 * @model opposite="owningTransformationStatus" containment="true" ordered="false"
	 * @generated
	 */
	EList<MappingStatus> getOwnedMappingStatuses();

} // TransformationStatus
