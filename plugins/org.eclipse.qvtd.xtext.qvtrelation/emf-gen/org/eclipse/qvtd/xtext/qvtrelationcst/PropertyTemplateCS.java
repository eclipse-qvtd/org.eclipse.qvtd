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

import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Template CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getObjectTemplate <em>Object Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getPropertyId <em>Property Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#isOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getPropertyTemplateCS()
 * @model
 * @generated
 */
public interface PropertyTemplateCS extends ModelElementCS {
	/**
	 * Returns the value of the '<em><b>Object Template</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS#getPropertyTemplates <em>Property Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Template</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Template</em>' container reference.
	 * @see #setObjectTemplate(ObjectTemplateCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getPropertyTemplateCS_ObjectTemplate()
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS#getPropertyTemplates
	 * @model opposite="propertyTemplates" resolveProxies="false" transient="false"
	 * @generated
	 */
	ObjectTemplateCS getObjectTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getObjectTemplate <em>Object Template</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Template</em>' container reference.
	 * @see #getObjectTemplate()
	 * @generated
	 */
	void setObjectTemplate(ObjectTemplateCS value);

	/**
	 * Returns the value of the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Id</em>' reference.
	 * @see #setPropertyId(Property)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getPropertyTemplateCS_PropertyId()
	 * @model
	 * @generated
	 */
	Property getPropertyId();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getPropertyId <em>Property Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Id</em>' reference.
	 * @see #getPropertyId()
	 * @generated
	 */
	void setPropertyId(Property value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getPropertyTemplateCS_Expression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' attribute.
	 * @see #setOpposite(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getPropertyTemplateCS_Opposite()
	 * @model default="false"
	 * @generated
	 */
	boolean isOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#isOpposite <em>Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' attribute.
	 * @see #isOpposite()
	 * @generated
	 */
	void setOpposite(boolean value);

} // PropertyTemplateCS
