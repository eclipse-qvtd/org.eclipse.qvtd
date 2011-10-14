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
 * $Id: ObjectTemplateExp.java,v 1.2 2008/12/31 17:43:44 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Template Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp#getReferredClass <em>Referred Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getObjectTemplateExp()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ReferredClassIsDeclaredByDomain\r\nPartsAreUnique\r\nEveryEnforceablePartIsEnforced'"
 * @generated
 */
public interface ObjectTemplateExp extends TemplateExp {
	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getObjectTemplateExp_Part()
	 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem#getObjContainer
	 * @model opposite="objContainer" containment="true" ordered="false"
	 * @generated
	 */
	EList<PropertyTemplateItem> getPart();

	/**
	 * Returns the value of the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Class</em>' reference.
	 * @see #setReferredClass(EClass)
	 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getObjectTemplateExp_ReferredClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getReferredClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp#getReferredClass <em>Referred Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Class</em>' reference.
	 * @see #getReferredClass()
	 * @generated
	 */
	void setReferredClass(EClass value);

} // ObjectTemplateExp
