/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2016 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtcorebase;

import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment#getSlotExpression <em>Slot Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage#getNavigationAssignment()
 * @model abstract="true"
 * @generated
 */
public interface NavigationAssignment extends Assignment {
	/**
	 * Returns the value of the '<em><b>Slot Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot Expression</em>' containment reference.
	 * @see #setSlotExpression(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage#getNavigationAssignment_SlotExpression()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='slotAssignment'"
	 * @generated
	 */
	OCLExpression getSlotExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment#getSlotExpression <em>Slot Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot Expression</em>' containment reference.
	 * @see #getSlotExpression()
	 * @generated
	 */
	void setSlotExpression(OCLExpression value);

} // NavigationAssignment
