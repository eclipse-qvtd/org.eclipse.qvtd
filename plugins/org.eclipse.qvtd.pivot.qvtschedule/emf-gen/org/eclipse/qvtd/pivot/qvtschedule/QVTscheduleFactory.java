/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage
 * @generated
 */
public interface QVTscheduleFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTscheduleFactory eINSTANCE = org.eclipse.qvtd.pivot.qvtschedule.impl.QVTscheduleFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Basic Mapping Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Mapping Region</em>'.
	 * @generated
	 */
	@NonNull BasicMappingRegion createBasicMappingRegion();

	/**
	 * Returns a new object of class '<em>Cast Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cast Edge</em>'.
	 * @generated
	 */
	@NonNull CastEdge createCastEdge();

	/**
	 * Returns a new object of class '<em>Class Datum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Datum</em>'.
	 * @generated
	 */
	@NonNull ClassDatum createClassDatum();

	/**
	 * Returns a new object of class '<em>Class Datum Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Datum Analysis</em>'.
	 * @generated
	 */
	@NonNull ClassDatumAnalysis createClassDatumAnalysis();

	/**
	 * Returns a new object of class '<em>Composed Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composed Node</em>'.
	 * @generated
	 */
	@NonNull ComposedNode createComposedNode();

	/**
	 * Returns a new object of class '<em>Dependency Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Node</em>'.
	 * @generated
	 */
	@NonNull DependencyNode createDependencyNode();

	/**
	 * Returns a new object of class '<em>Edge Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Connection</em>'.
	 * @generated
	 */
	@NonNull EdgeConnection createEdgeConnection();

	/**
	 * Returns a new object of class '<em>Error Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Node</em>'.
	 * @generated
	 */
	@NonNull ErrorNode createErrorNode();

	/**
	 * Returns a new object of class '<em>Expression Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Edge</em>'.
	 * @generated
	 */
	@NonNull ExpressionEdge createExpressionEdge();

	/**
	 * Returns a new object of class '<em>Input Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Node</em>'.
	 * @generated
	 */
	@NonNull InputNode createInputNode();

	/**
	 * Returns a new object of class '<em>Iterated Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterated Edge</em>'.
	 * @generated
	 */
	@NonNull IteratedEdge createIteratedEdge();

	/**
	 * Returns a new object of class '<em>Iterator Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterator Node</em>'.
	 * @generated
	 */
	@NonNull IteratorNode createIteratorNode();

	/**
	 * Returns a new object of class '<em>Mapping Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Action</em>'.
	 * @generated
	 */
	@NonNull MappingAction createMappingAction();

	/**
	 * Returns a new object of class '<em>Micro Mapping Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Micro Mapping Region</em>'.
	 * @generated
	 */
	@NonNull MicroMappingRegion createMicroMappingRegion();

	/**
	 * Returns a new object of class '<em>Multi Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Region</em>'.
	 * @generated
	 */
	@NonNull MultiRegion createMultiRegion();

	/**
	 * Returns a new object of class '<em>Named Mapping Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Mapping Region</em>'.
	 * @generated
	 */
	@NonNull NamedMappingRegion createNamedMappingRegion();

	/**
	 * Returns a new object of class '<em>Navigation Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigation Edge</em>'.
	 * @generated
	 */
	@NonNull NavigationEdge createNavigationEdge();

	/**
	 * Returns a new object of class '<em>Node Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Connection</em>'.
	 * @generated
	 */
	@NonNull NodeConnection createNodeConnection();

	/**
	 * Returns a new object of class '<em>Null Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Node</em>'.
	 * @generated
	 */
	@NonNull NullNode createNullNode();

	/**
	 * Returns a new object of class '<em>Operation Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Node</em>'.
	 * @generated
	 */
	@NonNull OperationNode createOperationNode();

	/**
	 * Returns a new object of class '<em>Operation Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Region</em>'.
	 * @generated
	 */
	@NonNull OperationRegion createOperationRegion();

	/**
	 * Returns a new object of class '<em>Pattern Typed Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Typed Node</em>'.
	 * @generated
	 */
	@NonNull PatternTypedNode createPatternTypedNode();

	/**
	 * Returns a new object of class '<em>Pattern Variable Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Variable Node</em>'.
	 * @generated
	 */
	@NonNull PatternVariableNode createPatternVariableNode();

	/**
	 * Returns a new object of class '<em>Predicate Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predicate Edge</em>'.
	 * @generated
	 */
	@NonNull PredicateEdge createPredicateEdge();

	/**
	 * Returns a new object of class '<em>Property Datum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Datum</em>'.
	 * @generated
	 */
	@NonNull PropertyDatum createPropertyDatum();

	/**
	 * Returns a new object of class '<em>Recursion Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recursion Edge</em>'.
	 * @generated
	 */
	@NonNull RecursionEdge createRecursionEdge();

	/**
	 * Returns a new object of class '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role</em>'.
	 * @generated
	 */
	@NonNull Role createRole();

	/**
	 * Returns a new object of class '<em>Root Composition Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Composition Region</em>'.
	 * @generated
	 */
	@NonNull RootCompositionRegion createRootCompositionRegion();

	/**
	 * Returns a new object of class '<em>Scheduled Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduled Region</em>'.
	 * @generated
	 */
	@NonNull ScheduledRegion createScheduledRegion();

	/**
	 * Returns a new object of class '<em>True Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>True Node</em>'.
	 * @generated
	 */
	@NonNull TrueNode createTrueNode();

	/**
	 * Returns a new object of class '<em>Unknown Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unknown Node</em>'.
	 * @generated
	 */
	@NonNull UnknownNode createUnknownNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTschedulePackage getQVTschedulePackage();

} //QVTscheduleFactory
