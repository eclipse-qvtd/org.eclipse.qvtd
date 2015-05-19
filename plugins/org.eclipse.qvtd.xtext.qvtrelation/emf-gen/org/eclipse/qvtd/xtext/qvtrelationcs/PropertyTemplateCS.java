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

import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Template CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwningObjectTemplate <em>Owning Object Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getPropertyId <em>Property Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwnedOppositePropertyId <em>Owned Opposite Property Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getPropertyTemplateCS()
 * @model
 * @generated
 */
public interface PropertyTemplateCS extends ModelElementCS {
	/**
	 * Returns the value of the '<em><b>Owning Object Template</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS#getOwnedPropertyTemplates <em>Owned Property Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Object Template</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Object Template</em>' container reference.
	 * @see #setOwningObjectTemplate(ObjectTemplateCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getPropertyTemplateCS_OwningObjectTemplate()
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS#getOwnedPropertyTemplates
	 * @model opposite="ownedPropertyTemplates" resolveProxies="false" transient="false"
	 * @generated
	 */
	ObjectTemplateCS getOwningObjectTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwningObjectTemplate <em>Owning Object Template</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Object Template</em>' container reference.
	 * @see #getOwningObjectTemplate()
	 * @generated
	 */
	void setOwningObjectTemplate(ObjectTemplateCS value);

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
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getPropertyTemplateCS_PropertyId()
	 * @model
	 * @generated
	 */
	Property getPropertyId();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getPropertyId <em>Property Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Id</em>' reference.
	 * @see #getPropertyId()
	 * @generated
	 */
	void setPropertyId(Property value);

	/**
	 * Returns the value of the '<em><b>Owned Opposite Property Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Opposite Property Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Opposite Property Id</em>' containment reference.
	 * @see #setOwnedOppositePropertyId(PathNameCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getPropertyTemplateCS_OwnedOppositePropertyId()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getOwnedOppositePropertyId();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwnedOppositePropertyId <em>Owned Opposite Property Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Opposite Property Id</em>' containment reference.
	 * @see #getOwnedOppositePropertyId()
	 * @generated
	 */
	void setOwnedOppositePropertyId(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getPropertyTemplateCS_OwnedExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(ExpCS value);

} // PropertyTemplateCS
