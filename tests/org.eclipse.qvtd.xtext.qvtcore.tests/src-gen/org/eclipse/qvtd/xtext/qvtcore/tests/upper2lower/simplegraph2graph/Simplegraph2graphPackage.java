/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphFactory
 * @model kind="package"
 * @generated
 */
public interface Simplegraph2graphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simplegraph2graph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/SimpleGraph2Graph";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simplegraph2graph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Simplegraph2graphPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Simplegraph2graphPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph <em>Graph2 Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph2 Graph</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph
	 * @generated
	 */
	EClass getGraph2Graph();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getGraph1 <em>Graph1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Graph1</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getGraph1()
	 * @see #getGraph2Graph()
	 * @generated
	 */
	EReference getGraph2Graph_Graph1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getGraph2 <em>Graph2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Graph2</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getGraph2()
	 * @see #getGraph2Graph()
	 * @generated
	 */
	EReference getGraph2Graph_Graph2();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getElement2Element <em>Element2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element2 Element</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getElement2Element()
	 * @see #getGraph2Graph()
	 * @generated
	 */
	EReference getGraph2Graph_Element2Element();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph#getName()
	 * @see #getGraph2Graph()
	 * @generated
	 */
	EAttribute getGraph2Graph_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Element2Element <em>Element2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element2 Element</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Element2Element
	 * @generated
	 */
	EClass getElement2Element();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Element2Element#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Element2Element#getOwner()
	 * @see #getElement2Element()
	 * @generated
	 */
	EReference getElement2Element_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Edge2Edge <em>Edge2 Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge2 Edge</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Edge2Edge
	 * @generated
	 */
	EClass getEdge2Edge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Edge2Edge#getEdge1 <em>Edge1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Edge1</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Edge2Edge#getEdge1()
	 * @see #getEdge2Edge()
	 * @generated
	 */
	EReference getEdge2Edge_Edge1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Edge2Edge#getEdge2 <em>Edge2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Edge2</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Edge2Edge#getEdge2()
	 * @see #getEdge2Edge()
	 * @generated
	 */
	EReference getEdge2Edge_Edge2();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Edge2Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Edge2Edge#getTarget()
	 * @see #getEdge2Edge()
	 * @generated
	 */
	EReference getEdge2Edge_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Edge2Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Edge2Edge#getSource()
	 * @see #getEdge2Edge()
	 * @generated
	 */
	EReference getEdge2Edge_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node <em>Node2 Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node2 Node</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node
	 * @generated
	 */
	EClass getNode2Node();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getNode1 <em>Node1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node1</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getNode1()
	 * @see #getNode2Node()
	 * @generated
	 */
	EReference getNode2Node_Node1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getNode2 <em>Node2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node2</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getNode2()
	 * @see #getNode2Node()
	 * @generated
	 */
	EReference getNode2Node_Node2();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Node2Node#getLabel()
	 * @see #getNode2Node()
	 * @generated
	 */
	EAttribute getNode2Node_Label();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Simplegraph2graphFactory getSimplegraph2graphFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Graph2GraphImpl <em>Graph2 Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Graph2GraphImpl
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Simplegraph2graphPackageImpl#getGraph2Graph()
		 * @generated
		 */
		EClass GRAPH2_GRAPH = eINSTANCE.getGraph2Graph();

		/**
		 * The meta object literal for the '<em><b>Graph1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH2_GRAPH__GRAPH1 = eINSTANCE.getGraph2Graph_Graph1();

		/**
		 * The meta object literal for the '<em><b>Graph2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH2_GRAPH__GRAPH2 = eINSTANCE.getGraph2Graph_Graph2();

		/**
		 * The meta object literal for the '<em><b>Element2 Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH2_GRAPH__ELEMENT2_ELEMENT = eINSTANCE.getGraph2Graph_Element2Element();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH2_GRAPH__NAME = eINSTANCE.getGraph2Graph_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Element2ElementImpl <em>Element2 Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Element2ElementImpl
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Simplegraph2graphPackageImpl#getElement2Element()
		 * @generated
		 */
		EClass ELEMENT2_ELEMENT = eINSTANCE.getElement2Element();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT2_ELEMENT__OWNER = eINSTANCE.getElement2Element_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Edge2EdgeImpl <em>Edge2 Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Edge2EdgeImpl
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Simplegraph2graphPackageImpl#getEdge2Edge()
		 * @generated
		 */
		EClass EDGE2_EDGE = eINSTANCE.getEdge2Edge();

		/**
		 * The meta object literal for the '<em><b>Edge1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE2_EDGE__EDGE1 = eINSTANCE.getEdge2Edge_Edge1();

		/**
		 * The meta object literal for the '<em><b>Edge2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE2_EDGE__EDGE2 = eINSTANCE.getEdge2Edge_Edge2();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE2_EDGE__TARGET = eINSTANCE.getEdge2Edge_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE2_EDGE__SOURCE = eINSTANCE.getEdge2Edge_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Node2NodeImpl <em>Node2 Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Node2NodeImpl
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Simplegraph2graphPackageImpl#getNode2Node()
		 * @generated
		 */
		EClass NODE2_NODE = eINSTANCE.getNode2Node();

		/**
		 * The meta object literal for the '<em><b>Node1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE2_NODE__NODE1 = eINSTANCE.getNode2Node_Node1();

		/**
		 * The meta object literal for the '<em><b>Node2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE2_NODE__NODE2 = eINSTANCE.getNode2Node_Node2();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE2_NODE__LABEL = eINSTANCE.getNode2Node_Label();

	}

} //Simplegraph2graphPackage
