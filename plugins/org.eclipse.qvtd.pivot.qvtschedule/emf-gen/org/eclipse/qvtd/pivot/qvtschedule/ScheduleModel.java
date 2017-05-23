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
	 * Returns the value of the '<em><b>Owned Mapping Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.MappingAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mapping Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Mapping Actions</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduleModel_OwnedMappingActions()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getOwningScheduleModel
	 * @model opposite="owningScheduleModel" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduleModel!ownedMappingActions'"
	 * @generated
	 */
	EList<MappingAction> getOwnedMappingActions();
	/**
	 * Returns the value of the '<em><b>Owned Other Mapping Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Other Mapping Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Other Mapping Regions</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduleModel_OwnedOtherMappingRegions()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduleModel!ownedOtherMappingRegions'"
	 * @generated
	 */
	EList<MappingRegion> getOwnedOtherMappingRegions();
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