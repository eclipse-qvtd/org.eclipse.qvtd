/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Template CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS#getOwnedPropertyTemplates <em>Owned Property Templates</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getObjectTemplateCS()
 * @model
 * @generated
 */
public interface ObjectTemplateCS extends TemplateCS {
	/**
	 * Returns the value of the '<em><b>Owned Property Templates</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwningObjectTemplate <em>Owning Object Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property Templates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Property Templates</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getObjectTemplateCS_OwnedPropertyTemplates()
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwningObjectTemplate
	 * @model opposite="owningObjectTemplate" containment="true"
	 * @generated
	 */
	EList<PropertyTemplateCS> getOwnedPropertyTemplates();

} // ObjectTemplateCS
