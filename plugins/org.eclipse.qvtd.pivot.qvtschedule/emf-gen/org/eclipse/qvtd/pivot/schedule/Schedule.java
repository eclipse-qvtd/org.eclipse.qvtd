/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.Schedule#getDatums <em>Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.Schedule#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getSchedule()
 * @model
 * @generated
 */
public interface Schedule extends EObject {
	/**
	 * Returns the value of the '<em><b>Datums</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.ClassDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.ClassDatum#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datums</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datums</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getSchedule_Datums()
	 * @see org.eclipse.qvtd.pivot.schedule.ClassDatum#getSchedule
	 * @model opposite="schedule" containment="true"
	 * @generated
	 */
	EList<ClassDatum> getDatums();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.MappingAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getSchedule_Actions()
	 * @see org.eclipse.qvtd.pivot.schedule.MappingAction#getSchedule
	 * @model opposite="schedule" containment="true"
	 * @generated
	 */
	EList<MappingAction> getActions();

} // Schedule
