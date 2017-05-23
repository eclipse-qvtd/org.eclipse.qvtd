/**
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.umlx.UMLXPackage
 * @generated
 */
public interface UMLXFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UMLXFactory eINSTANCE = org.eclipse.qvtd.umlx.impl.UMLXFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Rel Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Diagram</em>'.
	 * @generated
	 */
	@NonNull RelDiagram createRelDiagram();

	/**
	 * Returns a new object of class '<em>Rel Domain Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Domain Node</em>'.
	 * @generated
	 */
	@NonNull RelDomainNode createRelDomainNode();

	/**
	 * Returns a new object of class '<em>Rel Invocation Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Invocation Edge</em>'.
	 * @generated
	 */
	@NonNull RelInvocationEdge createRelInvocationEdge();

	/**
	 * Returns a new object of class '<em>Rel Invocation Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Invocation Node</em>'.
	 * @generated
	 */
	@NonNull RelInvocationNode createRelInvocationNode();

	/**
	 * Returns a new object of class '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Pattern Edge</em>'.
	 * @generated
	 */
	@NonNull RelPatternEdge createRelPatternEdge();

	/**
	 * Returns a new object of class '<em>Rel Pattern Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rel Pattern Node</em>'.
	 * @generated
	 */
	@NonNull RelPatternNode createRelPatternNode();

	/**
	 * Returns a new object of class '<em>Tx Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Diagram</em>'.
	 * @generated
	 */
	@NonNull TxDiagram createTxDiagram();

	/**
	 * Returns a new object of class '<em>Tx Key Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Key Node</em>'.
	 * @generated
	 */
	@NonNull TxKeyNode createTxKeyNode();

	/**
	 * Returns a new object of class '<em>Tx Part Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Part Node</em>'.
	 * @generated
	 */
	@NonNull TxPartNode createTxPartNode();

	/**
	 * Returns a new object of class '<em>Tx Query Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Query Node</em>'.
	 * @generated
	 */
	@NonNull TxQueryNode createTxQueryNode();

	/**
	 * Returns a new object of class '<em>Tx Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Node</em>'.
	 * @generated
	 */
	@NonNull TxNode createTxNode();

	/**
	 * Returns a new object of class '<em>Tx Package Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Package Node</em>'.
	 * @generated
	 */
	@NonNull TxPackageNode createTxPackageNode();

	/**
	 * Returns a new object of class '<em>Tx Parameter Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Parameter Node</em>'.
	 * @generated
	 */
	@NonNull TxParameterNode createTxParameterNode();

	/**
	 * Returns a new object of class '<em>Tx Typed Model Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tx Typed Model Node</em>'.
	 * @generated
	 */
	@NonNull TxTypedModelNode createTxTypedModelNode();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	@NonNull UMLXModel createUMLXModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UMLXPackage getUMLXPackage();

} //UMLXFactory
