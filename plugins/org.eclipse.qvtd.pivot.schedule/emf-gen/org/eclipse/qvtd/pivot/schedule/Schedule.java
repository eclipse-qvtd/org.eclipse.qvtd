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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.schedule.util.ScheduleVisitor;

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
public interface Schedule extends ScheduleElement {
	/**
	 * Returns the value of the '<em><b>Datums</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datums</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datums</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getSchedule_Datums()
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractDatum#getSchedule
	 * @model opposite="schedule" containment="true"
	 * @generated
	 */
	EList<AbstractDatum> getDatums();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.AbstractAction#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getSchedule_Actions()
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractAction#getSchedule
	 * @model opposite="schedule" containment="true"
	 * @generated
	 */
	EList<AbstractAction> getActions();

	/**
	 * Accept a visit from a visitor and return the result of a call to the derived type-specific visitXXX in the visitor.
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build/templates/model/Class/insert.javajetinc
	public <R> R accept(@NonNull ScheduleVisitor<R> visitor);

} // Schedule
