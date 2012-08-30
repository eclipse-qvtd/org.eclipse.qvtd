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
package org.eclipse.qvtd.xtext.qvtrelationcst;

import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Value CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS#getInitialiser <em>Initialiser</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS#getPropertyId <em>Property Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getDefaultValueCS()
 * @model
 * @generated
 */
public interface DefaultValueCS extends ModelElementCS {
	/**
	 * Returns the value of the '<em><b>Initialiser</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialiser</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialiser</em>' containment reference.
	 * @see #setInitialiser(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getDefaultValueCS_Initialiser()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpCS getInitialiser();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS#getInitialiser <em>Initialiser</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialiser</em>' containment reference.
	 * @see #getInitialiser()
	 * @generated
	 */
	void setInitialiser(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Id</em>' reference.
	 * @see #setPropertyId(Variable)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getDefaultValueCS_PropertyId()
	 * @model required="true"
	 * @generated
	 */
	Variable getPropertyId();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS#getPropertyId <em>Property Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Id</em>' reference.
	 * @see #getPropertyId()
	 * @generated
	 */
	void setPropertyId(Variable value);

} // DefaultValueCS
