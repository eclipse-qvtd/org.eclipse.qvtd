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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.ClassDatum#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.ClassDatum#getPropertyDatums <em>Property Datums</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getClassDatum()
 * @model
 * @generated
 */
public interface ClassDatum extends AbstractDatum {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(org.eclipse.ocl.pivot.Class)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getClassDatum_Type()
	 * @model required="true" derived="true"
	 * @generated
	 */
	org.eclipse.ocl.pivot.Class getType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.ClassDatum#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(org.eclipse.ocl.pivot.Class value);

	/**
	 * Returns the value of the '<em><b>Property Datums</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.PropertyDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.PropertyDatum#getClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Datums</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Datums</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getClassDatum_PropertyDatums()
	 * @see org.eclipse.qvtd.pivot.schedule.PropertyDatum#getClassDatum
	 * @model opposite="classDatum" containment="true"
	 * @generated
	 */
	EList<PropertyDatum> getPropertyDatums();

} // ClassDatum
