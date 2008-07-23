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
 * $Id: EnforcementOperationCS.java,v 1.1 2008/07/23 10:06:42 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst;

import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OperationCallExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enforcement Operation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS#isDeletion <em>Deletion</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS#getOperationCall <em>Operation Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getEnforcementOperationCS()
 * @model
 * @generated
 */
public interface EnforcementOperationCS extends CSTNode
{
	/**
	 * Returns the value of the '<em><b>Deletion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deletion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deletion</em>' attribute.
	 * @see #setDeletion(boolean)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getEnforcementOperationCS_Deletion()
	 * @model
	 * @generated
	 */
	boolean isDeletion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS#isDeletion <em>Deletion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deletion</em>' attribute.
	 * @see #isDeletion()
	 * @generated
	 */
	void setDeletion(boolean value);

	/**
	 * Returns the value of the '<em><b>Operation Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Call</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Call</em>' containment reference.
	 * @see #setOperationCall(OperationCallExpCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getEnforcementOperationCS_OperationCall()
	 * @model containment="true"
	 * @generated
	 */
	OperationCallExpCS getOperationCall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS#getOperationCall <em>Operation Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Call</em>' containment reference.
	 * @see #getOperationCall()
	 * @generated
	 */
	void setOperationCall(OperationCallExpCS value);

} // EnforcementOperationCS
