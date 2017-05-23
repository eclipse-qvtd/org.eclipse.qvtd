/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package test.hsl.HSLTree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HSL Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link test.hsl.HSLTree.HSLNode#getParent <em>Parent</em>}</li>
 *   <li>{@link test.hsl.HSLTree.HSLNode#getChildren <em>Children</em>}</li>
 *   <li>{@link test.hsl.HSLTree.HSLNode#getHsl <em>Hsl</em>}</li>
 *   <li>{@link test.hsl.HSLTree.HSLNode#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see test.hsl.HSLTree.HSLTreePackage#getHSLNode()
 * @model
 * @generated
 */
public interface HSLNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link test.hsl.HSLTree.HSLNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(HSLNode)
	 * @see test.hsl.HSLTree.HSLTreePackage#getHSLNode_Parent()
	 * @see test.hsl.HSLTree.HSLNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	HSLNode getParent();

	/**
	 * Sets the value of the '{@link test.hsl.HSLTree.HSLNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(HSLNode value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link test.hsl.HSLTree.HSLNode}.
	 * It is bidirectional and its opposite is '{@link test.hsl.HSLTree.HSLNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see test.hsl.HSLTree.HSLTreePackage#getHSLNode_Children()
	 * @see test.hsl.HSLTree.HSLNode#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<HSLNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Hsl</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hsl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hsl</em>' attribute.
	 * @see #setHsl(String)
	 * @see test.hsl.HSLTree.HSLTreePackage#getHSLNode_Hsl()
	 * @model default="1" dataType="test.hsl.HSLTree.HSL" required="true"
	 * @generated
	 */
	String getHsl();

	/**
	 * Sets the value of the '{@link test.hsl.HSLTree.HSLNode#getHsl <em>Hsl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hsl</em>' attribute.
	 * @see #getHsl()
	 * @generated
	 */
	void setHsl(String value);

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
	 * @see test.hsl.HSLTree.HSLTreePackage#getHSLNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link test.hsl.HSLTree.HSLNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // HSLNode
