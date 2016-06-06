/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface UmlxFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UmlxFactory INSTANCE = org.eclipse.qvtd.umlx.impl.UmlxFactoryImpl.eINSTANCE;

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>Rel Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Diagram</em>'.
	 * @generated
	 */
	RelDiagram createRelDiagram();

	/**
	 * Returns a new object of class '<em>Rel Domain Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Domain Node</em>'.
	 * @generated
	 */
	RelDomainNode createRelDomainNode();

	/**
	 * Returns a new object of class '<em>Rel Invocation Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Invocation Edge</em>'.
	 * @generated
	 */
	RelInvocationEdge createRelInvocationEdge();

	/**
	 * Returns a new object of class '<em>Rel Invocation Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Invocation Node</em>'.
	 * @generated
	 */
	RelInvocationNode createRelInvocationNode();

	/**
	 * Returns a new object of class '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Pattern Edge</em>'.
	 * @generated
	 */
	RelPatternEdge createRelPatternEdge();

	/**
	 * Returns a new object of class '<em>Rel Pattern Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Pattern Node</em>'.
	 * @generated
	 */
	RelPatternNode createRelPatternNode();

	/**
	 * Returns a new object of class '<em>Tx Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Diagram</em>'.
	 * @generated
	 */
	TxDiagram createTxDiagram();

	/**
	 * Returns a new object of class '<em>Tx Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Node</em>'.
	 * @generated
	 */
	TxNode createTxNode();

	/**
	 * Returns a new object of class '<em>Tx Package Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Package Node</em>'.
	 * @generated
	 */
	TxPackageNode createTxPackageNode();

	/**
	 * Returns a new object of class '<em>Tx Transformation Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Transformation Node</em>'.
	 * @generated
	 */
	TxTransformationNode createTxTransformationNode();

	/**
	 * Returns a new object of class '<em>Tx Typed Model Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Typed Model Node</em>'.
	 * @generated
	 */
	TxTypedModelNode createTxTypedModelNode();

} //UmlxFactory
