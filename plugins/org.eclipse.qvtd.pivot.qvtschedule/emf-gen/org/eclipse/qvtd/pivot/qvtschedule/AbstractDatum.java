/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getConsumingRegions <em>Consuming Regions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getProducingRegions <em>Producing Regions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getAbstractDatum()
 * @model abstract="true"
 * @generated
 */
public interface AbstractDatum extends Element {
	/**
	 * Returns the value of the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Typed Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Typed Model</em>' reference.
	 * @see #setReferredTypedModel(TypedModel)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getAbstractDatum_ReferredTypedModel()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!AbstractDatum!referredTypedModel'"
	 * @generated
	 */
	TypedModel getReferredTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getReferredTypedModel <em>Referred Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Typed Model</em>' reference.
	 * @see #getReferredTypedModel()
	 * @generated
	 */
	void setReferredTypedModel(TypedModel value);

	/**
	 * Returns the value of the '<em><b>Consuming Regions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion#getConsumedDatums <em>Consumed Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consuming Regions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consuming Regions</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getAbstractDatum_ConsumingRegions()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RuleRegion#getConsumedDatums
	 * @model opposite="consumedDatums" resolveProxies="false" transient="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!AbstractDatum!consumingRegions'"
	 * @generated
	 */
	EList<RuleRegion> getConsumingRegions();

	/**
	 * Returns the value of the '<em><b>Producing Regions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion#getProducedDatums <em>Produced Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Producing Regions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Producing Regions</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getAbstractDatum_ProducingRegions()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RuleRegion#getProducedDatums
	 * @model opposite="producedDatums" resolveProxies="false" transient="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!AbstractDatum!producingRegions'"
	 * @generated
	 */
	EList<RuleRegion> getProducingRegions();

} // AbstractDatum
