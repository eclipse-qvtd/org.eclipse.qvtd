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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Template CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS#getPropertyTemplates <em>Property Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getObjectTemplateCS()
 * @model
 * @generated
 */
public interface ObjectTemplateCS extends TemplateCS {
	/**
	 * Returns the value of the '<em><b>Property Templates</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getObjectTemplate <em>Object Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Templates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Templates</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getObjectTemplateCS_PropertyTemplates()
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getObjectTemplate
	 * @model opposite="objectTemplate" containment="true"
	 * @generated
	 */
	EList<PropertyTemplateCS> getPropertyTemplates();

} // ObjectTemplateCS
