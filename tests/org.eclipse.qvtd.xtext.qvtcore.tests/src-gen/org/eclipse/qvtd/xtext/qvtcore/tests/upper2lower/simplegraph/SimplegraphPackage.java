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
package org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph;

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
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.SimplegraphFactory
 * @model kind="package"
 * @generated
 */
public interface SimplegraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simplegraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/SimpleGraph";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simplegraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimplegraphPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.SimplegraphPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node#getIncoming()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Incoming();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node#getOutgoing()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Outgoing();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Node#getLabel()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Label();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Element#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Element#getGraph()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Graph();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Graph#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Graph#getElement()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Element();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Graph#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Graph#getName()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimplegraphFactory getSimplegraphFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.NodeImpl
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.SimplegraphPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMING = eINSTANCE.getNode_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOING = eINSTANCE.getNode_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__LABEL = eINSTANCE.getNode_Label();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.EdgeImpl
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.SimplegraphPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.ElementImpl
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.SimplegraphPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__GRAPH = eINSTANCE.getElement_Graph();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.GraphImpl
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.impl.SimplegraphPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__ELEMENT = eINSTANCE.getGraph_Element();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__NAME = eINSTANCE.getGraph_Name();

	}

} //SimplegraphPackage
