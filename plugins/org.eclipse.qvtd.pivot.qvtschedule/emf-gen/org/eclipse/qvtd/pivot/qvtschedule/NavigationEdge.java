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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A NavigationEdge supports the directed Property-based relationship between Nodes within a Region.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#getOppositeEdge <em>Opposite Edge</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#isPartial <em>Partial</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#isSecondary <em>Secondary</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNavigationEdge()
 * @model
 * @generated
 */
public interface NavigationEdge extends NavigableEdge {

	/**
	 * Returns the value of the '<em><b>Opposite Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Non-null if this edge is part of a bidirectional pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Opposite Edge</em>' reference.
	 * @see #setOppositeEdge(NavigationEdge)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNavigationEdge_OppositeEdge()
	 * @model
	 * @generated
	 */
	NavigationEdge getOppositeEdge();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#getOppositeEdge <em>Opposite Edge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite Edge</em>' reference.
	 * @see #getOppositeEdge()
	 * @generated
	 */
	void setOppositeEdge(NavigationEdge value);

	/**
	 * Returns the value of the '<em><b>Partial</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this edge is a partial many-to-one relationship.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Partial</em>' attribute.
	 * @see #setPartial(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNavigationEdge_Partial()
	 * @model default="false" required="true"
	 * @generated
	 */
	@Override
	boolean isPartial();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#isPartial <em>Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partial</em>' attribute.
	 * @see #isPartial()
	 * @generated
	 */
	void setPartial(boolean value);

	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property to navigate from source to target.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNavigationEdge_ReferredProperty()
	 * @model transient="true"
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Secondary</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this edge is the auto-created second half of a bidirectional pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Secondary</em>' attribute.
	 * @see #setSecondary(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNavigationEdge_Secondary()
	 * @model default="false" required="true"
	 * @generated
	 */
	@Override
	boolean isSecondary();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#isSecondary <em>Secondary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secondary</em>' attribute.
	 * @see #isSecondary()
	 * @generated
	 */
	void setSecondary(boolean value);

	void initializeProperty(@NonNull Property property, boolean isPartial);
} // NavigationEdge
