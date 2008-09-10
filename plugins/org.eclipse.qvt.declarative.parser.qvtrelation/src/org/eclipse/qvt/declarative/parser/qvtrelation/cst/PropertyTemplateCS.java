/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.cst;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Template CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getPropertyId <em>Property Id</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getOclExpression <em>Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#isOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getPropertyTemplateCS()
 * @model
 * @generated
 */
public interface PropertyTemplateCS extends CSTNode {
	/**
	 * Returns the value of the '<em><b>Property Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Id</em>' containment reference.
	 * @see #setPropertyId(IdentifiedCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getPropertyTemplateCS_PropertyId()
	 * @model containment="true"
	 * @generated
	 */
	IdentifiedCS getPropertyId();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getPropertyId <em>Property Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Id</em>' containment reference.
	 * @see #getPropertyId()
	 * @generated
	 */
	void setPropertyId(IdentifiedCS value);

	/**
	 * Returns the value of the '<em><b>Ocl Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Expression</em>' containment reference.
	 * @see #setOclExpression(OCLExpressionCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getPropertyTemplateCS_OclExpression()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpressionCS getOclExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getOclExpression <em>Ocl Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression</em>' containment reference.
	 * @see #getOclExpression()
	 * @generated
	 */
	void setOclExpression(OCLExpressionCS value);

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
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getPropertyTemplateCS_ReferredProperty()
	 * @model
	 * @generated
	 */
	EStructuralFeature getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(EStructuralFeature value);

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
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getPropertyTemplateCS_Opposite()
	 * @model default="false"
	 * @generated
	 */
	boolean isOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#isOpposite <em>Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' attribute.
	 * @see #isOpposite()
	 * @generated
	 */
	void setOpposite(boolean value);

} // PropertyTemplateCS
