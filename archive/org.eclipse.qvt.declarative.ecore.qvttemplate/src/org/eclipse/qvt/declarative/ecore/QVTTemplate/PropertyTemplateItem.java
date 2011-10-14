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
 * $Id: PropertyTemplateItem.java,v 1.4 2009/01/27 21:17:48 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Template Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem#isIsOpposite <em>Is Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getPropertyTemplateItem()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ReferredPropertyIsDefinedByReferredClass\r\nValueElementTypeMatchesReferredPropertyElementType\r\nEveryExpressionVariableIsBoundByPattern\r\nObjectTypeMatchesPropertyType\r\nCollectionElementTypeMatchesPropertyType\r\nSetMatchesSet\r\nNonBagMatchesNonBag'"
 * @generated
 */
public interface PropertyTemplateItem extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Obj Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obj Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj Container</em>' container reference.
	 * @see #setObjContainer(ObjectTemplateExp)
	 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getPropertyTemplateItem_ObjContainer()
	 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp#getPart
	 * @model opposite="part" required="true"
	 * @generated
	 */
	ObjectTemplateExp getObjContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}' container reference.
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
	 * @see #setReferredProperty(EStructuralFeature)
	 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getPropertyTemplateItem_ReferredProperty()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='propertyItem'"
	 * @generated
	 */
	EStructuralFeature getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OCLExpression)
	 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getPropertyTemplateItem_Value()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='propertyItem'"
	 * @generated
	 */
	OCLExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OCLExpression value);

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
	 * @see #setIsOpposite(boolean)
	 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getPropertyTemplateItem_IsOpposite()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem#isIsOpposite <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Opposite</em>' attribute.
	 * @see #isIsOpposite()
	 * @generated
	 */
	void setIsOpposite(boolean value);

} // PropertyTemplateItem
