/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getSlotExpression <em>Slot Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getTargetProperty <em>Target Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getPropertyAssignment()
 * @model
 * @generated
 */
public interface PropertyAssignment extends Assignment {
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
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getPropertyAssignment_SlotExpression()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='slotAssignment'"
	 * @generated
	 */
	OCLExpression getSlotExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getSlotExpression <em>Slot Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot Expression</em>' containment reference.
	 * @see #getSlotExpression()
	 * @generated
	 */
	void setSlotExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Target Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Property</em>' reference.
	 * @see #setTargetProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getPropertyAssignment_TargetProperty()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='assignment'"
	 * @generated
	 */
	Property getTargetProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getTargetProperty <em>Target Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Property</em>' reference.
	 * @see #getTargetProperty()
	 * @generated
	 */
	void setTargetProperty(Property value);

} // PropertyAssignment
