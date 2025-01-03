/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Graph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph2 Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getGraph1 <em>Graph1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getGraph2 <em>Graph2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getElement2Element <em>Element2 Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getGraph2Graph()
 * @model
 * @generated
 */
public interface Graph2Graph extends EObject {
	/**
	 * Returns the value of the '<em><b>Graph1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph1</em>' reference.
	 * @see #setGraph1(Graph)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getGraph2Graph_Graph1()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle1' upper='1'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='upperGraph'"
	 * @generated
	 */
	Graph getGraph1();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getGraph1 <em>Graph1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph1</em>' reference.
	 * @see #getGraph1()
	 * @generated
	 */
	void setGraph1(Graph value);

	/**
	 * Returns the value of the '<em><b>Graph2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph2</em>' reference.
	 * @see #setGraph2(Graph)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getGraph2Graph_Graph2()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle2' upper='1'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='lowerGraph'"
	 * @generated
	 */
	Graph getGraph2();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getGraph2 <em>Graph2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph2</em>' reference.
	 * @see #getGraph2()
	 * @generated
	 */
	void setGraph2(Graph value);

	/**
	 * Returns the value of the '<em><b>Element2 Element</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Element2Element}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Element2Element#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element2 Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element2 Element</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getGraph2Graph_Element2Element()
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Element2Element#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Element2Element> getElement2Element();

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
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getGraph2Graph_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Graph2Graph
