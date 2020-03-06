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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningRootRegion <em>Owning Root Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getTargetName <em>Target Name</em>}</li>
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
	 * Returns the value of the '<em><b>Owning Root Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedLoadingRegion <em>Owned Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Root Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Root Region</em>' container reference.
	 * @see #setOwningRootRegion(RootRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getLoadingRegion_OwningRootRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootRegion#getOwnedLoadingRegion
	 * @model opposite="ownedLoadingRegion" required="true" transient="false"
	 * @generated
	 */
	RootRegion getOwningRootRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningRootRegion <em>Owning Root Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Root Region</em>' container reference.
	 * @see #getOwningRootRegion()
	 * @generated
	 */
	void setOwningRootRegion(RootRegion value);

	/**
	 * Returns the value of the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the NamedElement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Name</em>' attribute.
	 * @see #setTargetName(String)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getLoadingRegion_TargetName()
	 * @model dataType="org.eclipse.ocl.pivot.String"
	 * @generated
	 */
	String getTargetName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getTargetName <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Name</em>' attribute.
	 * @see #getTargetName()
	 * @generated
	 */
	void setTargetName(String value);
} // RootCompositionRegion
