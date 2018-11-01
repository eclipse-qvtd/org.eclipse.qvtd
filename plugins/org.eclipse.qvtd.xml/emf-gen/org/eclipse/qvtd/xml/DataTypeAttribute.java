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

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xml.DataTypeAttribute#getEcoreAttribute <em>Ecore Attribute</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xml.XMLmodelPackage#getDataTypeAttribute()
 * @model
 * @generated
 */
public interface DataTypeAttribute extends Attribute {
	/**
	 * Returns the value of the '<em><b>Ecore Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Attribute</em>' reference.
	 * @see #setEcoreAttribute(EAttribute)
	 * @see org.eclipse.qvtd.xml.XMLmodelPackage#getDataTypeAttribute_EcoreAttribute()
	 * @model resolveProxies="false" required="true" transient="true"
	 * @generated
	 */
	EAttribute getEcoreAttribute();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xml.DataTypeAttribute#getEcoreAttribute <em>Ecore Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Attribute</em>' reference.
	 * @see #getEcoreAttribute()
	 * @generated
	 */
	void setEcoreAttribute(EAttribute value);

} // DataTypeAttribute
