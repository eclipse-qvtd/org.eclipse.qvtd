/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningScheduledRegion2 <em>Owning Scheduled Region2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getLoadingRegion()
 * @model
 * @generated
 */
public interface LoadingRegion extends Region {

	/**
	 * Returns the value of the '<em><b>Owning Scheduled Region2</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedLoadingRegion <em>Owned Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Scheduled Region2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Scheduled Region2</em>' container reference.
	 * @see #setOwningScheduledRegion2(ScheduledRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getLoadingRegion_OwningScheduledRegion2()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedLoadingRegion
	 * @model opposite="ownedLoadingRegion" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!LoadingRegion!owningScheduledRegion2'"
	 * @generated
	 */
	ScheduledRegion getOwningScheduledRegion2();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningScheduledRegion2 <em>Owning Scheduled Region2</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Scheduled Region2</em>' container reference.
	 * @see #getOwningScheduledRegion2()
	 * @generated
	 */
	void setOwningScheduledRegion2(ScheduledRegion value);
} // RootCompositionRegion
