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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public interface RootRegion extends Region
{
	/**
	 * Returns the value of the '<em><b>Active Regions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Region}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getRootRegion <em>Root Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Regions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Regions</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRootRegion_ActiveRegions()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getRootRegion
	 * @model opposite="rootRegion"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!RootRegion!activeRegions'"
	 * @generated
	 */
	List<Region> getActiveRegions();
	/**
	 * Returns the value of the '<em><b>Owned Connections</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Connection}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningRootRegion <em>Owning Root Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Connections</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRootRegion_OwnedConnections()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningRootRegion
	 * @model opposite="owningRootRegion" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!RootRegion!ownedConnections'"
	 * @generated
	 */
	List<Connection> getOwnedConnections();
	/**
	 * Returns the value of the '<em><b>Owned Loading Region</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningRootRegion <em>Owning Root Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Loading Region</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Loading Region</em>' containment reference.
	 * @see #setOwnedLoadingRegion(LoadingRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRootRegion_OwnedLoadingRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningRootRegion
	 * @model opposite="owningRootRegion" containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!RootRegion!ownedLoadingRegion'"
	 * @generated
	 */
	LoadingRegion getOwnedLoadingRegion();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedLoadingRegion <em>Owned Loading Region</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Loading Region</em>' containment reference.
	 * @see #getOwnedLoadingRegion()
	 * @generated
	 */
	void setOwnedLoadingRegion(LoadingRegion value);
	/**
	 * Returns the value of the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedRootRegions <em>Owned Root Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Schedule Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The overall ScheduleModel in which this RootRegion is contained.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Schedule Model</em>' container reference.
	 * @see #setOwningScheduleModel(ScheduleModel)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRootRegion_OwningScheduleModel()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedRootRegions
	 * @model opposite="ownedRootRegions" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!RootRegion!owningScheduleModel'"
	 * @generated
	 */
	ScheduleModel getOwningScheduleModel();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Schedule Model</em>' container reference.
	 * @see #getOwningScheduleModel()
	 * @generated
	 */
	void setOwningScheduleModel(ScheduleModel value);
	/**
	 * Returns the value of the '<em><b>Referred Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Transformation represented by this RootRegion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Transformation</em>' reference.
	 * @see #setReferredTransformation(Transformation)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRootRegion_ReferredTransformation()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!RootRegion!referredTransformation'"
	 * @generated
	 */
	Transformation getReferredTransformation();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getReferredTransformation <em>Referred Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Transformation</em>' reference.
	 * @see #getReferredTransformation()
	 * @generated
	 */
	void setReferredTransformation(Transformation value);
	/**
	 * Returns the value of the '<em><b>Owned Root Partition</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.RootPartition#getOwningRootRegion <em>Owning Root Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Root Partition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Root Partition</em>' containment reference.
	 * @see #setOwnedRootPartition(RootPartition)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRootRegion_OwnedRootPartition()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootPartition#getOwningRootRegion
	 * @model opposite="owningRootRegion" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!RootRegion!ownedRootPartition'"
	 * @generated
	 */
	RootPartition getOwnedRootPartition();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedRootPartition <em>Owned Root Partition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Root Partition</em>' containment reference.
	 * @see #getOwnedRootPartition()
	 * @generated
	 */
	void setOwnedRootPartition(RootPartition value);
	@NonNull Iterable<@NonNull Region> getCallableRegions();
	@Nullable Region getNormalizedRegion(@NonNull Region region);
}