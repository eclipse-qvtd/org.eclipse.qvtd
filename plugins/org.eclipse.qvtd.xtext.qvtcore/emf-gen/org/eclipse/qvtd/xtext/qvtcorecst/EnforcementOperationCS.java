/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
package org.eclipse.qvtd.xtext.qvtcorecst;

import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enforcement Operation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS#isDeletion <em>Deletion</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS#getOperationCall <em>Operation Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getEnforcementOperationCS()
 * @model
 * @generated
 */
public interface EnforcementOperationCS extends ModelElementCS {
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
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getEnforcementOperationCS_Deletion()
	 * @model
	 * @generated
	 */
	boolean isDeletion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS#isDeletion <em>Deletion</em>}' attribute.
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
	 * @see #setOperationCall(InvocationExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getEnforcementOperationCS_OperationCall()
	 * @model containment="true"
	 * @generated
	 */
	InvocationExpCS getOperationCall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS#getOperationCall <em>Operation Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Call</em>' containment reference.
	 * @see #getOperationCall()
	 * @generated
	 */
	void setOperationCall(InvocationExpCS value);

} // EnforcementOperationCS
