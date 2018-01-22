/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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
	EList<Node> getHeadNodes();

	/**
	 * Returns the value of the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedMappingRegions <em>Owned Mapping Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Scheduled Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Scheduled Region</em>' container reference.
	 * @see #setOwningScheduledRegion(ScheduledRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingRegion_OwningScheduledRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedMappingRegions
	 * @model opposite="ownedMappingRegions" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!MappingRegion!owningScheduledRegion'"
	 * @generated
	 */
	ScheduledRegion getOwningScheduledRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getOwningScheduledRegion <em>Owning Scheduled Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Scheduled Region</em>' container reference.
	 * @see #getOwningScheduledRegion()
	 * @generated
	 */
	void setOwningScheduledRegion(ScheduledRegion value);
}