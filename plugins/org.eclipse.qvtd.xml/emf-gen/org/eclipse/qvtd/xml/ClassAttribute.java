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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xml.ClassAttribute#getEcoreReference <em>Ecore Reference</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xml.ClassAttribute#getEObjects <em>EObjects</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xml.XMLmodelPackage#getClassAttribute()
 * @model
 * @generated
 */
public interface ClassAttribute extends Attribute {
	/**
	 * Returns the value of the '<em><b>Ecore Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Reference</em>' reference.
	 * @see #setEcoreReference(EReference)
	 * @see org.eclipse.qvtd.xml.XMLmodelPackage#getClassAttribute_EcoreReference()
	 * @model resolveProxies="false" required="true" transient="true"
	 * @generated
	 */
	EReference getEcoreReference();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xml.ClassAttribute#getEcoreReference <em>Ecore Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Reference</em>' reference.
	 * @see #getEcoreReference()
	 * @generated
	 */
	void setEcoreReference(EReference value);

	/**
	 * Returns the value of the '<em><b>EObjects</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EObjects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EObjects</em>' reference list.
	 * @see org.eclipse.qvtd.xml.XMLmodelPackage#getClassAttribute_EObjects()
	 * @model resolveProxies="false" required="true" transient="true"
	 * @generated
	 */
	EList<EObject> getEObjects();

} // ClassAttribute
