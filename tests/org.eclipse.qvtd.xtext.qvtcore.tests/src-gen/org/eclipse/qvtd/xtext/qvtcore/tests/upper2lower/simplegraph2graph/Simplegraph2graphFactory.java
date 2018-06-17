/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage
 * @generated
 */
public interface Simplegraph2graphFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Simplegraph2graphFactory eINSTANCE = org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Simplegraph2graphFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Graph2 Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph2 Graph</em>'.
	 * @generated
	 */
	Graph2Graph createGraph2Graph();

	/**
	 * Returns a new object of class '<em>Edge2 Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge2 Edge</em>'.
	 * @generated
	 */
	Edge2Edge createEdge2Edge();

	/**
	 * Returns a new object of class '<em>Node2 Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node2 Node</em>'.
	 * @generated
	 */
	Node2Node createNode2Node();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Simplegraph2graphPackage getSimplegraph2graphPackage();

} //Simplegraph2graphFactory
