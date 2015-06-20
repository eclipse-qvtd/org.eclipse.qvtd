/**
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package tree2talltree.tree2talltree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tree2talltree.talltree.TallNode;

import tree2talltree.tree.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node2 Tall Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tree2talltree.tree2talltree.Node2TallNode#getChildren <em>Children</em>}</li>
 *   <li>{@link tree2talltree.tree2talltree.Node2TallNode#getName <em>Name</em>}</li>
 *   <li>{@link tree2talltree.tree2talltree.Node2TallNode#getParent <em>Parent</em>}</li>
 *   <li>{@link tree2talltree.tree2talltree.Node2TallNode#getNode <em>Node</em>}</li>
 *   <li>{@link tree2talltree.tree2talltree.Node2TallNode#getTallNode <em>Tall Node</em>}</li>
 * </ul>
 *
 * @see tree2talltree.tree2talltree.Tree2talltreePackage#getNode2TallNode()
 * @model
 * @generated
 */
public interface Node2TallNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link tree2talltree.tree2talltree.Node2TallNode}.
	 * It is bidirectional and its opposite is '{@link tree2talltree.tree2talltree.Node2TallNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see tree2talltree.tree2talltree.Tree2talltreePackage#getNode2TallNode_Children()
	 * @see tree2talltree.tree2talltree.Node2TallNode#getParent
	 * @model opposite="parent" containment="true" ordered="false"
	 * @generated
	 */
	EList<Node2TallNode> getChildren();

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
	 * @see tree2talltree.tree2talltree.Tree2talltreePackage#getNode2TallNode_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link tree2talltree.tree2talltree.Node2TallNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link tree2talltree.tree2talltree.Node2TallNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Node2TallNode)
	 * @see tree2talltree.tree2talltree.Tree2talltreePackage#getNode2TallNode_Parent()
	 * @see tree2talltree.tree2talltree.Node2TallNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	Node2TallNode getParent();

	/**
	 * Sets the value of the '{@link tree2talltree.tree2talltree.Node2TallNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Node2TallNode value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(Node)
	 * @see tree2talltree.tree2talltree.Tree2talltreePackage#getNode2TallNode_Node()
	 * @model required="true"
	 * @generated
	 */
	Node getNode();

	/**
	 * Sets the value of the '{@link tree2talltree.tree2talltree.Node2TallNode#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Node value);

	/**
	 * Returns the value of the '<em><b>Tall Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tall Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tall Node</em>' reference.
	 * @see #setTallNode(TallNode)
	 * @see tree2talltree.tree2talltree.Tree2talltreePackage#getNode2TallNode_TallNode()
	 * @model required="true"
	 * @generated
	 */
	TallNode getTallNode();

	/**
	 * Sets the value of the '{@link tree2talltree.tree2talltree.Node2TallNode#getTallNode <em>Tall Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tall Node</em>' reference.
	 * @see #getTallNode()
	 * @generated
	 */
	void setTallNode(TallNode value);

} // Node2TallNode
