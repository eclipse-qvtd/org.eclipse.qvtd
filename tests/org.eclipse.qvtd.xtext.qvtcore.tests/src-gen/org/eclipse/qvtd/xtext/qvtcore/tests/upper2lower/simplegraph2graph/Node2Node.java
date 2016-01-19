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
package org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph;

import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node2 Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getNode1 <em>Node1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getNode2 <em>Node2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getNode2Node()
 * @model
 * @generated
 */
public interface Node2Node extends Element2Element {
	/**
	 * Returns the value of the '<em><b>Node1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node1</em>' reference.
	 * @see #setNode1(Node)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getNode2Node_Node1()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle1'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='upperGraph'"
	 * @generated
	 */
	Node getNode1();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getNode1 <em>Node1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node1</em>' reference.
	 * @see #getNode1()
	 * @generated
	 */
	void setNode1(Node value);

	/**
	 * Returns the value of the '<em><b>Node2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node2</em>' reference.
	 * @see #setNode2(Node)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getNode2Node_Node2()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle2'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='lowerGraph'"
	 * @generated
	 */
	Node getNode2();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getNode2 <em>Node2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node2</em>' reference.
	 * @see #getNode2()
	 * @generated
	 */
	void setNode2(Node value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getNode2Node_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

} // Node2Node
