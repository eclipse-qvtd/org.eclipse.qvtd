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

import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.DataParameter#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.DataParameter#getSecondaryParameter <em>Secondary Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.DataParameter#getDatum <em>Datum</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getDataParameter()
 * @model
 * @generated
 */
public interface DataParameter extends ScheduleElement {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getDataParameter_Variable()
	 * @model required="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.DataParameter#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Secondary Parameter</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.SecondaryParameter#getDataParameter <em>Data Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Parameter</em>' reference.
	 * @see #setSecondaryParameter(SecondaryParameter)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getDataParameter_SecondaryParameter()
	 * @see org.eclipse.qvtd.pivot.schedule.SecondaryParameter#getDataParameter
	 * @model opposite="dataParameter"
	 * @generated
	 */
	SecondaryParameter getSecondaryParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.DataParameter#getSecondaryParameter <em>Secondary Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secondary Parameter</em>' reference.
	 * @see #getSecondaryParameter()
	 * @generated
	 */
	void setSecondaryParameter(SecondaryParameter value);

	/**
	 * Returns the value of the '<em><b>Datum</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getDataParameter <em>Data Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datum</em>' reference.
	 * @see #setDatum(AbstractDatum)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getDataParameter_Datum()
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractDatum#getDataParameter
	 * @model opposite="dataParameter" required="true"
	 * @generated
	 */
	AbstractDatum getDatum();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.DataParameter#getDatum <em>Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datum</em>' reference.
	 * @see #getDatum()
	 * @generated
	 */
	void setDatum(AbstractDatum value);

} // DataParameter
