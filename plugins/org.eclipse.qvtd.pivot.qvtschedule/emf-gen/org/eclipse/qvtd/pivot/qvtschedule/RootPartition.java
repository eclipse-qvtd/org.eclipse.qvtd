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
 * A representation of the model object '<em><b>Root Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.RootPartition#getOwningRootRegion <em>Owning Root Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.RootPartition#getLoadingPartition <em>Loading Partition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRootPartition()
 * @model
 * @generated
 */
public interface RootPartition extends CompositePartition {

	/**
	 * Returns the value of the '<em><b>Owning Root Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedRootPartition <em>Owned Root Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Root Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Root Region</em>' container reference.
	 * @see #setOwningRootRegion(ScheduledRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRootPartition_OwningRootRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedRootPartition
	 * @model opposite="ownedRootPartition" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!RootPartition!owningRootRegion'"
	 * @generated
	 */
	ScheduledRegion getOwningRootRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.RootPartition#getOwningRootRegion <em>Owning Root Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Root Region</em>' container reference.
	 * @see #getOwningRootRegion()
	 * @generated
	 */
	void setOwningRootRegion(ScheduledRegion value);

	/**
	 * Returns the value of the '<em><b>Loading Partition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loading Partition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loading Partition</em>' reference.
	 * @see #setLoadingPartition(LoadingPartition)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRootPartition_LoadingPartition()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!RootPartition!loadingPartition'"
	 * @generated
	 */
	LoadingPartition getLoadingPartition();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.RootPartition#getLoadingPartition <em>Loading Partition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loading Partition</em>' reference.
	 * @see #getLoadingPartition()
	 * @generated
	 */
	void setLoadingPartition(LoadingPartition value);
} // RootPartition
