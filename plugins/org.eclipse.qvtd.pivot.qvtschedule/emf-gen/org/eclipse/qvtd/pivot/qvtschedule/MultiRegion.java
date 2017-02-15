/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;

/**
 * <!-- begin-model-doc -->
 * The MultiRegion supervises the many Region instances that realize a transformation
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMultiRegion()
 * @model
 * @generated
 */
public interface MultiRegion extends Element
{
	/**
	 * Returns the value of the '<em><b>Schedule Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getMultiRegion <em>Multi Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Model</em>' container reference.
	 * @see #setScheduleModel(ScheduleModel)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMultiRegion_ScheduleModel()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getMultiRegion
	 * @model opposite="multiRegion" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!MultiRegion!scheduleModel'"
	 * @generated
	 */
	ScheduleModel getScheduleModel();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.MultiRegion#getScheduleModel <em>Schedule Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Model</em>' container reference.
	 * @see #getScheduleModel()
	 * @generated
	 */
	void setScheduleModel(ScheduleModel value);
	void addRegion(@NonNull Region region);
	@NonNull List<@NonNull Region> getActiveRegions();
	@NonNull Iterable<@NonNull OperationRegion> getOperationRegions();
	void setActiveRegions(@NonNull Iterable<@NonNull ? extends Region> activeRegions);	// FIXME eliminate
}
