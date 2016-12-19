/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.HSLNode;

import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HSV Node2 HSL Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getHsv <em>Hsv</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getHls <em>Hls</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getRgb <em>Rgb</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSV2HSLPackage#getHSVNode2HSLNode()
 * @model
 * @generated
 */
public interface HSVNode2HSLNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(HSVNode2HSLNode)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSV2HSLPackage#getHSVNode2HSLNode_Parent()
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	HSVNode2HSLNode getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(HSVNode2HSLNode value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSV2HSLPackage#getHSVNode2HSLNode_Children()
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<HSVNode2HSLNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Hsv</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hsv</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hsv</em>' reference.
	 * @see #setHsv(HSVNode)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSV2HSLPackage#getHSVNode2HSLNode_Hsv()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle' upper='1'"
	 * @generated
	 */
	HSVNode getHsv();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getHsv <em>Hsv</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hsv</em>' reference.
	 * @see #getHsv()
	 * @generated
	 */
	void setHsv(HSVNode value);

	/**
	 * Returns the value of the '<em><b>Hls</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hls</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hls</em>' reference.
	 * @see #setHls(HSLNode)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSV2HSLPackage#getHSVNode2HSLNode_Hls()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle' upper='1'"
	 * @generated
	 */
	HSLNode getHls();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getHls <em>Hls</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hls</em>' reference.
	 * @see #getHls()
	 * @generated
	 */
	void setHls(HSLNode value);

	/**
	 * Returns the value of the '<em><b>Rgb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rgb</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rgb</em>' attribute.
	 * @see #setRgb(String)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSV2HSLPackage#getHSVNode2HSLNode_Rgb()
	 * @model dataType="org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.RGB" required="true"
	 * @generated
	 */
	String getRgb();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getRgb <em>Rgb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rgb</em>' attribute.
	 * @see #getRgb()
	 * @generated
	 */
	void setRgb(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSV2HSLPackage#getHSVNode2HSLNode_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSVNode2HSLNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // HSVNode2HSLNode
