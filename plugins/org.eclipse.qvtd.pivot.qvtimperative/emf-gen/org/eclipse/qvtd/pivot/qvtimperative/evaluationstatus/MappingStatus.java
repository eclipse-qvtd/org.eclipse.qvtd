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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getBoundValues <em>Bound Values</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#isIsBlocked <em>Is Blocked</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#isIsDirty <em>Is Dirty</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getOwningTransformationStatus <em>Owning Transformation Status</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getReferredMappingCall <em>Referred Mapping Call</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getMappingStatus()
 * @model
 * @generated
 */
public interface MappingStatus extends EvaluationElement {
	/**
	 * Returns the value of the '<em><b>Bound Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Values</em>' attribute list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getMappingStatus_BoundValues()
	 * @model dataType="org.eclipse.ocl.pivot.Object"
	 * @generated
	 */
	@NonNull EList<Object> getBoundValues();

	/**
	 * Returns the value of the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth</em>' attribute.
	 * @see #setDepth(Integer)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getMappingStatus_Depth()
	 * @model
	 * @generated
	 */
	Integer getDepth();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth</em>' attribute.
	 * @see #getDepth()
	 * @generated
	 */
	void setDepth(Integer value);

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getMappingStatus_Inputs()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus#getTargets
	 * @model opposite="targets" ordered="false"
	 * @generated
	 */
	EList<ElementStatus> getInputs();

	/**
	 * Returns the value of the '<em><b>Is Blocked</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Blocked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Blocked</em>' attribute.
	 * @see #setIsBlocked(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getMappingStatus_IsBlocked()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsBlocked();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#isIsBlocked <em>Is Blocked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Blocked</em>' attribute.
	 * @see #isIsBlocked()
	 * @generated
	 */
	void setIsBlocked(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Dirty</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Dirty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Dirty</em>' attribute.
	 * @see #setIsDirty(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getMappingStatus_IsDirty()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsDirty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#isIsDirty <em>Is Dirty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Dirty</em>' attribute.
	 * @see #isIsDirty()
	 * @generated
	 */
	void setIsDirty(boolean value);

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getMappingStatus_Outputs()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus#getSources
	 * @model opposite="sources" ordered="false"
	 * @generated
	 */
	EList<ElementStatus> getOutputs();

	/**
	 * Returns the value of the '<em><b>Owning Transformation Status</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedMappingStatuses <em>Owned Mapping Statuses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Transformation Status</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Transformation Status</em>' container reference.
	 * @see #setOwningTransformationStatus(TransformationStatus)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getMappingStatus_OwningTransformationStatus()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedMappingStatuses
	 * @model opposite="ownedMappingStatuses" required="true" transient="false"
	 * @generated
	 */
	TransformationStatus getOwningTransformationStatus();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getOwningTransformationStatus <em>Owning Transformation Status</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Transformation Status</em>' container reference.
	 * @see #getOwningTransformationStatus()
	 * @generated
	 */
	void setOwningTransformationStatus(TransformationStatus value);

	/**
	 * Returns the value of the '<em><b>Referred Mapping Call</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Mapping Call</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Mapping Call</em>' reference.
	 * @see #setReferredMappingCall(MappingCall)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getMappingStatus_ReferredMappingCall()
	 * @model required="true"
	 * @generated
	 */
	MappingCall getReferredMappingCall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getReferredMappingCall <em>Referred Mapping Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Mapping Call</em>' reference.
	 * @see #getReferredMappingCall()
	 * @generated
	 */
	void setReferredMappingCall(MappingCall value);
} // MappingStatus
