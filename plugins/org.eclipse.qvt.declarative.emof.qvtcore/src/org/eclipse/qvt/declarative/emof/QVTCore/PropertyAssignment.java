/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: PropertyAssignment.java,v 1.1 2008/07/23 09:58:27 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTCore;

import org.eclipse.qvt.declarative.emof.EMOF.Property;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTCore.PropertyAssignment#getSlotExpression <em>Slot Expression</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTCore.PropertyAssignment#getTargetProperty <em>Target Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage#getPropertyAssignment()
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
	 * @see #setSlotExpression(OclExpression)
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage#getPropertyAssignment_SlotExpression()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='slotAssignment'"
	 * @generated
	 */
	OclExpression getSlotExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTCore.PropertyAssignment#getSlotExpression <em>Slot Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot Expression</em>' containment reference.
	 * @see #getSlotExpression()
	 * @generated
	 */
	void setSlotExpression(OclExpression value);

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
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage#getPropertyAssignment_TargetProperty()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='assignment'"
	 * @generated
	 */
	Property getTargetProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTCore.PropertyAssignment#getTargetProperty <em>Target Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Property</em>' reference.
	 * @see #getTargetProperty()
	 * @generated
	 */
	void setTargetProperty(Property value);

} // PropertyAssignment
