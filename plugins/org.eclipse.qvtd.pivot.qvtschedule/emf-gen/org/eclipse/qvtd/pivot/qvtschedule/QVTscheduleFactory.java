/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
	 * Returns a new object of class '<em>Basic Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Partition</em>'.
	 * @generated
	 */
	@NonNull BasicPartition createBasicPartition();

	/**
	 * Returns a new object of class '<em>Boolean Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal Node</em>'.
	 * @generated
	 */
	@NonNull BooleanLiteralNode createBooleanLiteralNode();

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
	 * Returns a new object of class '<em>Cluster</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cluster</em>'.
	 * @generated
	 */
	@NonNull Cluster createCluster();

	/**
	 * Returns a new object of class '<em>Collection Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Literal Node</em>'.
	 * @generated
	 */
	@NonNull CollectionLiteralNode createCollectionLiteralNode();

	/**
	 * Returns a new object of class '<em>Collection Part Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Part Edge</em>'.
	 * @generated
	 */
	@NonNull CollectionPartEdge createCollectionPartEdge();

	/**
	 * Returns a new object of class '<em>Collection Range Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Range Node</em>'.
	 * @generated
	 */
	@NonNull CollectionRangeNode createCollectionRangeNode();

	/**
	 * Returns a new object of class '<em>Composed Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composed Node</em>'.
	 * @generated
	 */
	@NonNull ComposedNode createComposedNode();

	/**
	 * Returns a new object of class '<em>Cyclic Mapping Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cyclic Mapping Region</em>'.
	 * @generated
	 */
	@NonNull CyclicMappingRegion createCyclicMappingRegion();

	/**
	 * Returns a new object of class '<em>Cyclic Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cyclic Partition</em>'.
	 * @generated
	 */
	@NonNull CyclicPartition createCyclicPartition();

	/**
	 * Returns a new object of class '<em>Dependency Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Edge</em>'.
	 * @generated
	 */
	@NonNull DependencyEdge createDependencyEdge();

	/**
	 * Returns a new object of class '<em>Dependency Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Node</em>'.
	 * @generated
	 */
	@NonNull DependencyNode createDependencyNode();

	/**
	 * Returns a new object of class '<em>Dispatch Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dispatch Region</em>'.
	 * @generated
	 */
	@NonNull DispatchRegion createDispatchRegion();

	/**
	 * Returns a new object of class '<em>Edge Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Connection</em>'.
	 * @generated
	 */
	@NonNull EdgeConnection createEdgeConnection();

	/**
	 * Returns a new object of class '<em>Enum Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal Node</em>'.
	 * @generated
	 */
	@NonNull EnumLiteralNode createEnumLiteralNode();

	/**
	 * Returns a new object of class '<em>Error Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Node</em>'.
	 * @generated
	 */
	@NonNull ErrorNode createErrorNode();

	/**
	 * Returns a new object of class '<em>If Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Node</em>'.
	 * @generated
	 */
	@NonNull IfNode createIfNode();

	/**
	 * Returns a new object of class '<em>Includes Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Includes Edge</em>'.
	 * @generated
	 */
	@NonNull IncludesEdge createIncludesEdge();

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
	 * Returns a new object of class '<em>Key Part Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key Part Edge</em>'.
	 * @generated
	 */
	@NonNull KeyPartEdge createKeyPartEdge();

	/**
	 * Returns a new object of class '<em>Keyed Value Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Keyed Value Node</em>'.
	 * @generated
	 */
	@NonNull KeyedValueNode createKeyedValueNode();

	/**
	 * Returns a new object of class '<em>Loading Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loading Partition</em>'.
	 * @generated
	 */
	@NonNull LoadingPartition createLoadingPartition();

	/**
	 * Returns a new object of class '<em>Loading Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loading Region</em>'.
	 * @generated
	 */
	@NonNull LoadingRegion createLoadingRegion();

	/**
	 * Returns a new object of class '<em>Map Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Literal Node</em>'.
	 * @generated
	 */
	@NonNull MapLiteralNode createMapLiteralNode();

	/**
	 * Returns a new object of class '<em>Map Part Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Part Edge</em>'.
	 * @generated
	 */
	@NonNull MapPartEdge createMapPartEdge();

	/**
	 * Returns a new object of class '<em>Map Part Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Part Node</em>'.
	 * @generated
	 */
	@NonNull MapPartNode createMapPartNode();

	/**
	 * Returns a new object of class '<em>Merged Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Merged Partition</em>'.
	 * @generated
	 */
	@NonNull MergedPartition createMergedPartition();

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
	 * Returns a new object of class '<em>Non Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Partition</em>'.
	 * @generated
	 */
	@NonNull NonPartition createNonPartition();

	/**
	 * Returns a new object of class '<em>Null Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Literal Node</em>'.
	 * @generated
	 */
	@NonNull NullLiteralNode createNullLiteralNode();

	/**
	 * Returns a new object of class '<em>Numeric Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Literal Node</em>'.
	 * @generated
	 */
	@NonNull NumericLiteralNode createNumericLiteralNode();

	/**
	 * Returns a new object of class '<em>Operation Call Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Call Node</em>'.
	 * @generated
	 */
	@NonNull OperationCallNode createOperationCallNode();

	/**
	 * Returns a new object of class '<em>Operation Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Region</em>'.
	 * @generated
	 */
	@NonNull OperationRegion createOperationRegion();

	/**
	 * Returns a new object of class '<em>Operation Parameter Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Parameter Edge</em>'.
	 * @generated
	 */
	@NonNull OperationParameterEdge createOperationParameterEdge();

	/**
	 * Returns a new object of class '<em>Operation Self Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Self Edge</em>'.
	 * @generated
	 */
	@NonNull OperationSelfEdge createOperationSelfEdge();

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
	 * Returns a new object of class '<em>Root Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Partition</em>'.
	 * @generated
	 */
	@NonNull RootPartition createRootPartition();

	/**
	 * Returns a new object of class '<em>Root Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Region</em>'.
	 * @generated
	 */
	RootRegion createRootRegion();

	/**
	 * Returns a new object of class '<em>Rule Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Region</em>'.
	 * @generated
	 */
	@NonNull RuleRegion createRuleRegion();

	/**
	 * Returns a new object of class '<em>Schedule Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule Model</em>'.
	 * @generated
	 */
	@NonNull ScheduleModel createScheduleModel();

	/**
	 * Returns a new object of class '<em>Shadow Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shadow Node</em>'.
	 * @generated
	 */
	@NonNull ShadowNode createShadowNode();

	/**
	 * Returns a new object of class '<em>Shadow Part Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shadow Part Edge</em>'.
	 * @generated
	 */
	@NonNull ShadowPartEdge createShadowPartEdge();

	/**
	 * Returns a new object of class '<em>String Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal Node</em>'.
	 * @generated
	 */
	@NonNull StringLiteralNode createStringLiteralNode();

	/**
	 * Returns a new object of class '<em>Success Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Success Edge</em>'.
	 * @generated
	 */
	@NonNull SuccessEdge createSuccessEdge();

	/**
	 * Returns a new object of class '<em>Success Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Success Node</em>'.
	 * @generated
	 */
	@NonNull SuccessNode createSuccessNode();

	/**
	 * Returns a new object of class '<em>Tuple Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Literal Node</em>'.
	 * @generated
	 */
	@NonNull TupleLiteralNode createTupleLiteralNode();

	/**
	 * Returns a new object of class '<em>Tuple Part Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Part Edge</em>'.
	 * @generated
	 */
	@NonNull TuplePartEdge createTuplePartEdge();

	/**
	 * Returns a new object of class '<em>Type Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Literal Node</em>'.
	 * @generated
	 */
	@NonNull TypeLiteralNode createTypeLiteralNode();

	/**
	 * Returns a new object of class '<em>Unknown Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unknown Node</em>'.
	 * @generated
	 */
	@NonNull UnknownNode createUnknownNode();

	/**
	 * Returns a new object of class '<em>Verdict Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verdict Region</em>'.
	 * @generated
	 */
	@NonNull VerdictRegion createVerdictRegion();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTschedulePackage getQVTschedulePackage();

} //QVTscheduleFactory
