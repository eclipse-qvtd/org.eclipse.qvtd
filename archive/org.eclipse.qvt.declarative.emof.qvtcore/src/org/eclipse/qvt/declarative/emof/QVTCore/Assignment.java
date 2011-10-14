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
 * $Id: Assignment.java,v 1.1 2008/07/23 09:58:27 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTCore;

import org.eclipse.qvt.declarative.emof.EMOF.Element;

import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getBottomPattern <em>Bottom Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getIsDefault <em>Is Default</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage#getAssignment()
 * @model abstract="true"
 * @generated
 */
public interface Assignment extends Element {
	/**
	 * Returns the value of the '<em><b>Bottom Pattern</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern#getAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Pattern</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Pattern</em>' container reference.
	 * @see #setBottomPattern(BottomPattern)
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage#getAssignment_BottomPattern()
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern#getAssignment
	 * @model opposite="assignment" required="true"
	 * @generated
	 */
	BottomPattern getBottomPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getBottomPattern <em>Bottom Pattern</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Pattern</em>' container reference.
	 * @see #getBottomPattern()
	 * @generated
	 */
	void setBottomPattern(BottomPattern value);

	/**
	 * Returns the value of the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Default</em>' attribute.
	 * @see #setIsDefault(Boolean)
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage#getAssignment_IsDefault()
	 * @model dataType="org.eclipse.qvt.declarative.emof.EMOF.Boolean"
	 * @generated
	 */
	Boolean getIsDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getIsDefault <em>Is Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Default</em>' attribute.
	 * @see #getIsDefault()
	 * @generated
	 */
	void setIsDefault(Boolean value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OclExpression)
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage#getAssignment_Value()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='valueAssignment'"
	 * @generated
	 */
	OclExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OclExpression value);

} // Assignment
