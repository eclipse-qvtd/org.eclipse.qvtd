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

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getSuper <em>Super</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getSub <em>Sub</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getProducedBy <em>Produced By</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getRequiredBy <em>Required By</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getDataParameter <em>Data Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getAbstractDatum()
 * @model abstract="true"
 * @generated
 */
public interface AbstractDatum extends ScheduleElement {
	/**
	 * Returns the value of the '<em><b>Super</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getSub <em>Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getAbstractDatum_Super()
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractDatum#getSub
	 * @model opposite="sub"
	 * @generated
	 */
	EList<AbstractDatum> getSuper();

	/**
	 * Returns the value of the '<em><b>Sub</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getAbstractDatum_Sub()
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractDatum#getSuper
	 * @model opposite="super"
	 * @generated
	 */
	EList<AbstractDatum> getSub();

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(CoreDomain)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getAbstractDatum_Domain()
	 * @model
	 * @generated
	 */
	CoreDomain getDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(CoreDomain value);

	/**
	 * Returns the value of the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Model</em>' reference.
	 * @see #setTypedModel(TypedModel)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getAbstractDatum_TypedModel()
	 * @model
	 * @generated
	 */
	TypedModel getTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getTypedModel <em>Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Model</em>' reference.
	 * @see #getTypedModel()
	 * @generated
	 */
	void setTypedModel(TypedModel value);

	/**
	 * Returns the value of the '<em><b>Produced By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.AbstractAction#getProductions <em>Productions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Produced By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Produced By</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getAbstractDatum_ProducedBy()
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractAction#getProductions
	 * @model opposite="productions"
	 * @generated
	 */
	EList<AbstractAction> getProducedBy();

	/**
	 * Returns the value of the '<em><b>Required By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.AbstractAction#getRequisites <em>Requisites</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required By</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getAbstractDatum_RequiredBy()
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractAction#getRequisites
	 * @model opposite="requisites" derived="true"
	 * @generated
	 */
	EList<AbstractAction> getRequiredBy();

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.Schedule#getDatums <em>Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' container reference.
	 * @see #setSchedule(Schedule)
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getAbstractDatum_Schedule()
	 * @see org.eclipse.qvtd.pivot.schedule.Schedule#getDatums
	 * @model opposite="datums" transient="false"
	 * @generated
	 */
	Schedule getSchedule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getSchedule <em>Schedule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule</em>' container reference.
	 * @see #getSchedule()
	 * @generated
	 */
	void setSchedule(Schedule value);

	/**
	 * Returns the value of the '<em><b>Data Parameter</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.schedule.DataParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.schedule.DataParameter#getDatum <em>Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Parameter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Parameter</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#getAbstractDatum_DataParameter()
	 * @see org.eclipse.qvtd.pivot.schedule.DataParameter#getDatum
	 * @model opposite="datum"
	 * @generated
	 */
	EList<DataParameter> getDataParameter();

} // AbstractDatum
