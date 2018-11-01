/**
 * <copyright>
 * 
 * Copyright (c) 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.xml;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xml.ClassElement#getEcoreClass <em>Ecore Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xml.XMLmodelPackage#getClassElement()
 * @model
 * @generated
 */
public interface ClassElement extends Element {
	/**
	 * Returns the value of the '<em><b>Ecore Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Class</em>' reference.
	 * @see #setEcoreClass(EClass)
	 * @see org.eclipse.qvtd.xml.XMLmodelPackage#getClassElement_EcoreClass()
	 * @model resolveProxies="false" required="true" transient="true"
	 * @generated
	 */
	EClass getEcoreClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xml.ClassElement#getEcoreClass <em>Ecore Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Class</em>' reference.
	 * @see #getEcoreClass()
	 * @generated
	 */
	void setEcoreClass(EClass value);

} // ClassElement
