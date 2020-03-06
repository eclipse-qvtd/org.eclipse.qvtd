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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loading Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition#getReferredLoadingRegion <em>Referred Loading Region</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getLoadingPartition()
 * @model
 * @generated
 */
public interface LoadingPartition extends MappingPartition {

	/**
	 * Returns the value of the '<em><b>Referred Loading Region</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getLoadingPartition <em>Loading Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Loading Region</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Loading Region</em>' reference.
	 * @see #setReferredLoadingRegion(LoadingRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getLoadingPartition_ReferredLoadingRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getLoadingPartition
	 * @model opposite="loadingPartition" required="true"
	 * @generated
	 */
	LoadingRegion getReferredLoadingRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition#getReferredLoadingRegion <em>Referred Loading Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Loading Region</em>' reference.
	 * @see #getReferredLoadingRegion()
	 * @generated
	 */
	void setReferredLoadingRegion(LoadingRegion value);
} // LoadingPartition
