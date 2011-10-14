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
 * $Id: PropertyTemplateItem.java,v 1.2 2008/09/09 20:54:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTTemplate;

import org.eclipse.qvt.declarative.emof.EMOF.Element;
import org.eclipse.qvt.declarative.emof.EMOF.Property;

import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Template Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTTemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTTemplate.PropertyTemplateItem#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTTemplate.PropertyTemplateItem#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTTemplate.PropertyTemplateItem#getIsOpposite <em>Is Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage#getPropertyTemplateItem()
 * @model
 * @generated
 */
public interface PropertyTemplateItem extends Element {
	/**
	 * Returns the value of the '<em><b>Obj Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.QVTTemplate.ObjectTemplateExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obj Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj Container</em>' container reference.
	 * @see #setObjContainer(ObjectTemplateExp)
	 * @see org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage#getPropertyTemplateItem_ObjContainer()
	 * @see org.eclipse.qvt.declarative.emof.QVTTemplate.ObjectTemplateExp#getPart
	 * @model opposite="part" required="true"
	 * @generated
	 */
	ObjectTemplateExp getObjContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTTemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj Container</em>' container reference.
	 * @see #getObjContainer()
	 * @generated
	 */
	void setObjContainer(ObjectTemplateExp value);

	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage#getPropertyTemplateItem_ReferredProperty()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='propertyItem'"
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTTemplate.PropertyTemplateItem#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OclExpression)
	 * @see org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage#getPropertyTemplateItem_Value()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='propertyItem'"
	 * @generated
	 */
	OclExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTTemplate.PropertyTemplateItem#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Is Opposite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Opposite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Opposite</em>' attribute.
	 * @see #setIsOpposite(Boolean)
	 * @see org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage#getPropertyTemplateItem_IsOpposite()
	 * @model default="false" dataType="org.eclipse.qvt.declarative.emof.EMOF.Boolean"
	 * @generated
	 */
	Boolean getIsOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTTemplate.PropertyTemplateItem#getIsOpposite <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Opposite</em>' attribute.
	 * @see #getIsOpposite()
	 * @generated
	 */
	void setIsOpposite(Boolean value);

} // PropertyTemplateItem
