/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getOwningCompositePartition <em>Owning Composite Partition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getReferedMappingRegion <em>Refered Mapping Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getRegion <em>Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getExplicitSuccessors <em>Explicit Successors</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingPartition()
 * @model abstract="true"
 * @generated
 */
public interface MappingPartition extends Partition {

	/**
	 * Returns the value of the '<em><b>Owning Composite Partition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.CompositePartition#getOwnedMappingPartitions <em>Owned Mapping Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Composite Partition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Composite Partition</em>' container reference.
	 * @see #setOwningCompositePartition(CompositePartition)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingPartition_OwningCompositePartition()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CompositePartition#getOwnedMappingPartitions
	 * @model opposite="ownedMappingPartitions" transient="false"
	 * @generated
	 */
	CompositePartition getOwningCompositePartition();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getOwningCompositePartition <em>Owning Composite Partition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Composite Partition</em>' container reference.
	 * @see #getOwningCompositePartition()
	 * @generated
	 */
	void setOwningCompositePartition(CompositePartition value);

	/**
	 * Returns the value of the '<em><b>Refered Mapping Region</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getMappingPartitions <em>Mapping Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refered Mapping Region</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refered Mapping Region</em>' reference.
	 * @see #setReferedMappingRegion(MappingRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingPartition_ReferedMappingRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getMappingPartitions
	 * @model opposite="mappingPartitions"
	 * @generated
	 */
	MappingRegion getReferedMappingRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingPartition#getReferedMappingRegion <em>Refered Mapping Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refered Mapping Region</em>' reference.
	 * @see #getReferedMappingRegion()
	 * @generated
	 */
	void setReferedMappingRegion(MappingRegion value);

	/**
	 * Returns the value of the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' reference.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingPartition_Region()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	@Override
	Region getRegion();

	/**
	 * Returns the value of the '<em><b>Explicit Successors</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getExplicitPredecessors <em>Explicit Predecessors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicit Successors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Successors</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingPartition_ExplicitSuccessors()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicPartition#getExplicitPredecessors
	 * @model opposite="explicitPredecessors" ordered="false"
	 * @generated
	 */
	List<BasicPartition> getExplicitSuccessors();
} // MappingPartition
