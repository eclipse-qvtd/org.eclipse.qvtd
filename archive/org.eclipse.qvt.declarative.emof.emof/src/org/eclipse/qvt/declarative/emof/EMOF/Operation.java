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
 * $Id: Operation.java,v 1.1 2008/07/23 09:55:18 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EMOF;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EMOF.Operation#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EMOF.Operation#getOwnedParameter <em>Owned Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EMOF.Operation#getRaisedException <em>Raised Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends TypedElement, MultiplicityElement {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.EMOF.Class#getOwnedOperation <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' container reference.
	 * @see #setClass(org.eclipse.qvt.declarative.emof.EMOF.Class)
	 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getOperation_Class()
	 * @see org.eclipse.qvt.declarative.emof.EMOF.Class#getOwnedOperation
	 * @model opposite="ownedOperation"
	 * @generated
	 */
	org.eclipse.qvt.declarative.emof.EMOF.Class getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EMOF.Operation#getClass_ <em>Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' container reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(org.eclipse.qvt.declarative.emof.EMOF.Class value);

	/**
	 * Returns the value of the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EMOF.Parameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.EMOF.Parameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameter</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getOperation_OwnedParameter()
	 * @see org.eclipse.qvt.declarative.emof.EMOF.Parameter#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	EList<Parameter> getOwnedParameter();

	/**
	 * Returns the value of the '<em><b>Raised Exception</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EMOF.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raised Exception</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raised Exception</em>' reference list.
	 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getOperation_RaisedException()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Type> getRaisedException();

} // Operation
