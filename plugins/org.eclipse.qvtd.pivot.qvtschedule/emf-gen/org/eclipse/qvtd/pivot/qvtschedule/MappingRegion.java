/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
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
public interface MappingRegion extends Region
{

	/**
	 * Returns the value of the '<em><b>Head Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingRegion_HeadNodes()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!MappingRegion!headNodes'"
	 * @generated
	 */
	@Override
	List<Node> getHeadNodes();

	/**
	 * Returns the value of the '<em><b>Mapping Partitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getReferedMappingRegion <em>Refered Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Partitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Partitions</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingRegion_MappingPartitions()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getReferedMappingRegion
	 * @model opposite="referedMappingRegion"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!MappingRegion!mappingPartitions'"
	 * @generated
	 */
	List<MappingPartition> getMappingPartitions();

	/**
	 * Returns the value of the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedMappingRegions <em>Owned Mapping Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The overall ScheduleModel in which this MappingRegion is contained.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Schedule Model</em>' container reference.
	 * @see #setOwningScheduleModel(ScheduleModel)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingRegion_OwningScheduleModel()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedMappingRegions
	 * @model opposite="ownedMappingRegions" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!MappingRegion!owningScheduleModel'"
	 * @generated
	 */
	ScheduleModel getOwningScheduleModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Schedule Model</em>' container reference.
	 * @see #getOwningScheduleModel()
	 * @generated
	 */
	void setOwningScheduleModel(ScheduleModel value);
}