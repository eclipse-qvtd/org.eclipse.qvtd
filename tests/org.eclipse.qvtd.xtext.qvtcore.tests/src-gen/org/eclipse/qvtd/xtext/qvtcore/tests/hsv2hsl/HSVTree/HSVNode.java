/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HSV Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode#getHsv <em>Hsv</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVTreePackage#getHSVNode()
 * @model
 * @generated
 */
public interface HSVNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(HSVNode)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVTreePackage#getHSVNode_Parent()
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	HSVNode getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(HSVNode value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVTreePackage#getHSVNode_Children()
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<HSVNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Hsv</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hsv</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hsv</em>' attribute.
	 * @see #setHsv(String)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVTreePackage#getHSVNode_Hsv()
	 * @model default="" dataType="org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSV" required="true"
	 * @generated
	 */
	String getHsv();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode#getHsv <em>Hsv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hsv</em>' attribute.
	 * @see #getHsv()
	 * @generated
	 */
	void setHsv(String value);

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
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVTreePackage#getHSVNode_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // HSVNode