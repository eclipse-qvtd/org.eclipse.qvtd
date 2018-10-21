/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Composition Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A LoadingRegion provides a graphical representation of the model elements to be loaded from input models.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getLoadingPartition <em>Loading Partition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningScheduledRegion <em>Owning Scheduled Region</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getLoadingRegion()
 * @model
 * @generated
 */
public interface LoadingRegion extends Region {

	/**
	 * Returns the value of the '<em><b>Loading Partition</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition#getReferredLoadingRegion <em>Referred Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loading Partition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loading Partition</em>' reference.
	 * @see #setLoadingPartition(LoadingPartition)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getLoadingRegion_LoadingPartition()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition#getReferredLoadingRegion
	 * @model opposite="referredLoadingRegion" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!LoadingRegion!loadingPartition'"
	 * @generated
	 */
	LoadingPartition getLoadingPartition();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getLoadingPartition <em>Loading Partition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loading Partition</em>' reference.
	 * @see #getLoadingPartition()
	 * @generated
	 */
	void setLoadingPartition(LoadingPartition value);

	/**
	 * Returns the value of the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedLoadingRegion <em>Owned Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Scheduled Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Scheduled Region</em>' container reference.
	 * @see #setOwningScheduledRegion(ScheduledRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getLoadingRegion_OwningScheduledRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedLoadingRegion
	 * @model opposite="ownedLoadingRegion" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!LoadingRegion!owningScheduledRegion'"
	 * @generated
	 */
	ScheduledRegion getOwningScheduledRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningScheduledRegion <em>Owning Scheduled Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Scheduled Region</em>' container reference.
	 * @see #getOwningScheduledRegion()
	 * @generated
	 */
	void setOwningScheduledRegion(ScheduledRegion value);
} // RootCompositionRegion
