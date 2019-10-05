/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;
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
	 * @generated
	 */
	List<ClassDatum> getOwnedClassDatums();
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
	 * @generated
	 */
	List<OperationRegion> getOwnedOperationRegions();
	/**
	 * Returns the value of the '<em><b>Owned Root Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Root Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Root Regions</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduleModel_OwnedRootRegions()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwningScheduleModel
	 * @model opposite="owningScheduleModel" containment="true"
	 * @generated
	 */
	List<RootRegion> getOwnedRootRegions();
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
	 * @generated
	 */
	List<MappingRegion> getOwnedMappingRegions();

	@NonNull SymbolNameAdapter getSymbolNameAdapter();					// FIXME promote to Model/ModelImpl
	@NonNull String reserveSymbolName(@NonNull SymbolNameBuilder symbolNameBuilder, @NonNull Object object);
}