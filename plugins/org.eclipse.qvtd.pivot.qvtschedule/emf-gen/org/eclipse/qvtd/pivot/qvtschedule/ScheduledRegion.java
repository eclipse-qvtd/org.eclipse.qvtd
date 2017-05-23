/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface ScheduledRegion extends Region
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduledRegion_Name()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduledRegion!name'"
	 * @generated
	 */
	@Override
	String getName();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);
	/**
	 * Returns the value of the '<em><b>Owned Connections</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Connection}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningScheduledRegion <em>Owning Scheduled Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Connections</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduledRegion_OwnedConnections()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningScheduledRegion
	 * @model opposite="owningScheduledRegion" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduledRegion!ownedConnections'"
	 * @generated
	 */
	EList<Connection> getOwnedConnections();
	/**
	 * Returns the value of the '<em><b>Owned Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Region}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwningScheduledRegion <em>Owning Scheduled Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Regions</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduledRegion_OwnedRegions()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getOwningScheduledRegion
	 * @model opposite="owningScheduledRegion" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduledRegion!ownedRegions'"
	 * @generated
	 */
	EList<Region> getOwnedRegions();
	/**
	 * Returns the value of the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedScheduledRegion <em>Owned Scheduled Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Schedule Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Schedule Model</em>' container reference.
	 * @see #setOwningScheduleModel(ScheduleModel)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduledRegion_OwningScheduleModel()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedScheduledRegion
	 * @model opposite="ownedScheduledRegion" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduledRegion!owningScheduleModel'"
	 * @generated
	 */
	ScheduleModel getOwningScheduleModel();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Schedule Model</em>' container reference.
	 * @see #getOwningScheduleModel()
	 * @generated
	 */
	void setOwningScheduleModel(ScheduleModel value);
	@NonNull Iterable<@NonNull Region> getCallableRegions();
	@Nullable Region getNormalizedRegion(@NonNull Region region);
}