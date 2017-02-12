/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.schedule;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getProductions <em>Productions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getRequisites <em>Requisites</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getSchedule <em>Schedule</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getMappingAction()
 * @model
 * @generated
 */
public interface MappingAction extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' reference.
	 * @see #setMapping(Mapping)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getMappingAction_Mapping()
	 * @model required="true"
	 * @generated
	 */
	Mapping getMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getMapping <em>Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(Mapping value);

	/**
	 * Returns the value of the '<em><b>Productions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getProducedBy <em>Produced By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Productions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Productions</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getMappingAction_Productions()
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractDatum#getProducedBy
	 * @model opposite="producedBy"
	 * @generated
	 */
	EList<AbstractDatum> getProductions();

	/**
	 * Returns the value of the '<em><b>Requisites</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getRequiredBy <em>Required By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requisites</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requisites</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getMappingAction_Requisites()
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractDatum#getRequiredBy
	 * @model opposite="requiredBy"
	 * @generated
	 */
	EList<AbstractDatum> getRequisites();

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.Schedule#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' container reference.
	 * @see #setSchedule(Schedule)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getMappingAction_Schedule()
	 * @see org.eclipse.qvtd.pivot.schedule.Schedule#getActions
	 * @model opposite="actions" required="true" transient="false"
	 * @generated
	 */
	Schedule getSchedule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getSchedule <em>Schedule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule</em>' container reference.
	 * @see #getSchedule()
	 * @generated
	 */
	void setSchedule(Schedule value);

} // MappingAction
