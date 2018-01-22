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
import org.eclipse.ocl.pivot.Model;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameAdapter;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

/**
 * @generated
 */
public interface ScheduleModel extends Model
{
	/**
	 * Returns the value of the '<em><b>Owned Class Datums</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Class Datums</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Class Datums</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduleModel_OwnedClassDatums()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwningScheduleModel
	 * @model opposite="owningScheduleModel" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduleModel!ownedClassDatums'"
	 * @generated
	 */
	EList<ClassDatum> getOwnedClassDatums();
	/**
	 * Returns the value of the '<em><b>Owned Operation Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operation Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operation Regions</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduleModel_OwnedOperationRegions()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getOwningScheduleModel
	 * @model opposite="owningScheduleModel" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduleModel!ownedOperationRegions'"
	 * @generated
	 */
	EList<OperationRegion> getOwnedOperationRegions();
	/**
	 * Returns the value of the '<em><b>Owned Mapping Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mapping Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Mapping Regions</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduleModel_OwnedMappingRegions()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getOwningScheduleModel
	 * @model opposite="owningScheduleModel" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduleModel!ownedMappingRegions'"
	 * @generated
	 */
	EList<MappingRegion> getOwnedMappingRegions();
	/**
	 * Returns the value of the '<em><b>Owned Scheduled Region</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Scheduled Region</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Scheduled Region</em>' containment reference.
	 * @see #setOwnedScheduledRegion(ScheduledRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduleModel_OwnedScheduledRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwningScheduleModel
	 * @model opposite="owningScheduleModel" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduleModel!ownedScheduledRegion'"
	 * @generated
	 */
	ScheduledRegion getOwnedScheduledRegion();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedScheduledRegion <em>Owned Scheduled Region</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Scheduled Region</em>' containment reference.
	 * @see #getOwnedScheduledRegion()
	 * @generated
	 */
	void setOwnedScheduledRegion(ScheduledRegion value);
	@NonNull SymbolNameAdapter getSymbolNameAdapter();
	@NonNull String reserveSymbolName(@NonNull SymbolNameBuilder symbolNameBuilder, @NonNull Object object);
}