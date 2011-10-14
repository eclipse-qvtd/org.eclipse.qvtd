/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
package org.eclipse.qvtd.pivot.qvttemplate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Template Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getReferredClass <em>Referred Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getObjectTemplateExp()
 * @model
 * @generated
 */
public interface ObjectTemplateExp extends TemplateExp {
	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getObjectTemplateExp_Part()
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getObjContainer
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
	 * @see #setReferredClass(org.eclipse.ocl.examples.pivot.Class)
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#getObjectTemplateExp_ReferredClass()
	 * @model required="true"
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Class getReferredClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getReferredClass <em>Referred Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Class</em>' reference.
	 * @see #getReferredClass()
	 * @generated
	 */
	void setReferredClass(org.eclipse.ocl.examples.pivot.Class value);

} // ObjectTemplateExp
