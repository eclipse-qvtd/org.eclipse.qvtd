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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

/**
 * @generated
 */
public interface ScheduleModel extends Model
{
	/**
	 * Returns the value of the '<em><b>Loading Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loading Region</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loading Region</em>' reference.
	 * @see #setLoadingRegion(LoadingRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduleModel_LoadingRegion()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduleModel!loadingRegion'"
	 * @generated
	 */
	LoadingRegion getLoadingRegion();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getLoadingRegion <em>Loading Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loading Region</em>' reference.
	 * @see #getLoadingRegion()
	 * @generated
	 */
	void setLoadingRegion(LoadingRegion value);
	/**
	 * Returns the value of the '<em><b>Scheduled Region</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getScheduleModel <em>Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduled Region</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduled Region</em>' containment reference.
	 * @see #setScheduledRegion(ScheduledRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduleModel_ScheduledRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getScheduleModel
	 * @model opposite="scheduleModel" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduleModel!scheduledRegion'"
	 * @generated
	 */
	ScheduledRegion getScheduledRegion();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getScheduledRegion <em>Scheduled Region</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduled Region</em>' containment reference.
	 * @see #getScheduledRegion()
	 * @generated
	 */
	void setScheduledRegion(ScheduledRegion value);

	@NonNull String reserveSymbolName(@NonNull SymbolNameBuilder symbolNameBuilder, @NonNull Symbolable symbolable);
	void writeCallDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix);
	void writeCallGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix);
	void writeDOTfile(@NonNull Region region, @Nullable String suffix);
	void writeGraphMLfile(@NonNull Region region, @Nullable String suffix);
	void writeRegionDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix);
	void writeRegionGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix);
}