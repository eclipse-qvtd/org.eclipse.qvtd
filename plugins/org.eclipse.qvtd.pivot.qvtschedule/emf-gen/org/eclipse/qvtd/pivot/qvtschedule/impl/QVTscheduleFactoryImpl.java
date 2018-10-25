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
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTscheduleFactoryImpl extends EFactoryImpl implements QVTscheduleFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTscheduleFactory init() {
		try {
			QVTscheduleFactory theQVTscheduleFactory = (QVTscheduleFactory)EPackage.Registry.INSTANCE.getEFactory(QVTschedulePackage.eNS_URI);
			if (theQVTscheduleFactory != null) {
				return theQVTscheduleFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTscheduleFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTscheduleFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QVTschedulePackage.BASIC_PARTITION: return createBasicPartition();
			case QVTschedulePackage.BOOLEAN_LITERAL_NODE: return createBooleanLiteralNode();
			case QVTschedulePackage.CAST_EDGE: return createCastEdge();
			case QVTschedulePackage.CLASS_DATUM: return createClassDatum();
			case QVTschedulePackage.CLUSTER: return createCluster();
			case QVTschedulePackage.COLLECTION_LITERAL_NODE: return createCollectionLiteralNode();
			case QVTschedulePackage.COLLECTION_PART_EDGE: return createCollectionPartEdge();
			case QVTschedulePackage.COLLECTION_RANGE_NODE: return createCollectionRangeNode();
			case QVTschedulePackage.COMPOSED_NODE: return createComposedNode();
			case QVTschedulePackage.CYCLIC_MAPPING_REGION: return createCyclicMappingRegion();
			case QVTschedulePackage.CYCLIC_PARTITION: return createCyclicPartition();
			case QVTschedulePackage.DEPENDENCY_EDGE: return createDependencyEdge();
			case QVTschedulePackage.DEPENDENCY_NODE: return createDependencyNode();
			case QVTschedulePackage.DISPATCH_REGION: return createDispatchRegion();
			case QVTschedulePackage.EDGE_CONNECTION: return createEdgeConnection();
			case QVTschedulePackage.ENUM_LITERAL_NODE: return createEnumLiteralNode();
			case QVTschedulePackage.ERROR_NODE: return createErrorNode();
			case QVTschedulePackage.IF_NODE: return createIfNode();
			case QVTschedulePackage.INCLUDES_EDGE: return createIncludesEdge();
			case QVTschedulePackage.INPUT_NODE: return createInputNode();
			case QVTschedulePackage.ITERATED_EDGE: return createIteratedEdge();
			case QVTschedulePackage.ITERATOR_NODE: return createIteratorNode();
			case QVTschedulePackage.KEY_PART_EDGE: return createKeyPartEdge();
			case QVTschedulePackage.KEYED_VALUE_NODE: return createKeyedValueNode();
			case QVTschedulePackage.LOADING_PARTITION: return createLoadingPartition();
			case QVTschedulePackage.LOADING_REGION: return createLoadingRegion();
			case QVTschedulePackage.MAP_LITERAL_NODE: return createMapLiteralNode();
			case QVTschedulePackage.MAP_PART_EDGE: return createMapPartEdge();
			case QVTschedulePackage.MAP_PART_NODE: return createMapPartNode();
			case QVTschedulePackage.MERGED_PARTITION: return createMergedPartition();
			case QVTschedulePackage.NAVIGATION_EDGE: return createNavigationEdge();
			case QVTschedulePackage.NODE_CONNECTION: return createNodeConnection();
			case QVTschedulePackage.NON_PARTITION: return createNonPartition();
			case QVTschedulePackage.NULL_LITERAL_NODE: return createNullLiteralNode();
			case QVTschedulePackage.NUMERIC_LITERAL_NODE: return createNumericLiteralNode();
			case QVTschedulePackage.OPERATION_CALL_NODE: return createOperationCallNode();
			case QVTschedulePackage.OPERATION_REGION: return createOperationRegion();
			case QVTschedulePackage.OPERATION_PARAMETER_EDGE: return createOperationParameterEdge();
			case QVTschedulePackage.OPERATION_SELF_EDGE: return createOperationSelfEdge();
			case QVTschedulePackage.PATTERN_TYPED_NODE: return createPatternTypedNode();
			case QVTschedulePackage.PATTERN_VARIABLE_NODE: return createPatternVariableNode();
			case QVTschedulePackage.PREDICATE_EDGE: return createPredicateEdge();
			case QVTschedulePackage.PROPERTY_DATUM: return createPropertyDatum();
			case QVTschedulePackage.RECURSION_EDGE: return createRecursionEdge();
			case QVTschedulePackage.ROOT_PARTITION: return createRootPartition();
			case QVTschedulePackage.ROOT_REGION: return createRootRegion();
			case QVTschedulePackage.RULE_REGION: return createRuleRegion();
			case QVTschedulePackage.SCHEDULE_MODEL: return createScheduleModel();
			case QVTschedulePackage.SHADOW_NODE: return createShadowNode();
			case QVTschedulePackage.SHADOW_PART_EDGE: return createShadowPartEdge();
			case QVTschedulePackage.STRING_LITERAL_NODE: return createStringLiteralNode();
			case QVTschedulePackage.SUCCESS_EDGE: return createSuccessEdge();
			case QVTschedulePackage.SUCCESS_NODE: return createSuccessNode();
			case QVTschedulePackage.TUPLE_LITERAL_NODE: return createTupleLiteralNode();
			case QVTschedulePackage.TUPLE_PART_EDGE: return createTuplePartEdge();
			case QVTschedulePackage.TYPE_LITERAL_NODE: return createTypeLiteralNode();
			case QVTschedulePackage.UNKNOWN_NODE: return createUnknownNode();
			case QVTschedulePackage.VERDICT_REGION: return createVerdictRegion();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case QVTschedulePackage.CONNECTION_ROLE:
				return createConnectionRoleFromString(eDataType, initialValue);
			case QVTschedulePackage.ROLE:
				return createRoleFromString(eDataType, initialValue);
			case QVTschedulePackage.NUMBER:
				return createNumberFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case QVTschedulePackage.CONNECTION_ROLE:
				return convertConnectionRoleToString(eDataType, instanceValue);
			case QVTschedulePackage.ROLE:
				return convertRoleToString(eDataType, instanceValue);
			case QVTschedulePackage.NUMBER:
				return convertNumberToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull BasicPartition createBasicPartition() {
		BasicPartitionImpl basicPartition = new BasicPartitionImpl();
		return basicPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull BooleanLiteralNode createBooleanLiteralNode() {
		BooleanLiteralNodeImpl booleanLiteralNode = new BooleanLiteralNodeImpl();
		return booleanLiteralNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CastEdge createCastEdge() {
		CastEdgeImpl castEdge = new CastEdgeImpl();
		return castEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ClassDatum createClassDatum() {
		ClassDatumImpl classDatum = new ClassDatumImpl();
		return classDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull Cluster createCluster() {
		ClusterImpl cluster = new ClusterImpl();
		return cluster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CollectionLiteralNode createCollectionLiteralNode() {
		CollectionLiteralNodeImpl collectionLiteralNode = new CollectionLiteralNodeImpl();
		return collectionLiteralNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CollectionPartEdge createCollectionPartEdge() {
		CollectionPartEdgeImpl collectionPartEdge = new CollectionPartEdgeImpl();
		return collectionPartEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CollectionRangeNode createCollectionRangeNode() {
		CollectionRangeNodeImpl collectionRangeNode = new CollectionRangeNodeImpl();
		return collectionRangeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ComposedNode createComposedNode() {
		ComposedNodeImpl composedNode = new ComposedNodeImpl();
		return composedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CyclicMappingRegion createCyclicMappingRegion() {
		CyclicMappingRegionImpl cyclicMappingRegion = new CyclicMappingRegionImpl();
		return cyclicMappingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CyclicPartition createCyclicPartition() {
		CyclicPartitionImpl cyclicPartition = new CyclicPartitionImpl();
		return cyclicPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull DependencyEdge createDependencyEdge() {
		DependencyEdgeImpl dependencyEdge = new DependencyEdgeImpl();
		return dependencyEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull DependencyNode createDependencyNode() {
		DependencyNodeImpl dependencyNode = new DependencyNodeImpl();
		return dependencyNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull DispatchRegion createDispatchRegion() {
		DispatchRegionImpl dispatchRegion = new DispatchRegionImpl();
		return dispatchRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull EdgeConnection createEdgeConnection() {
		EdgeConnectionImpl edgeConnection = new EdgeConnectionImpl();
		return edgeConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull EnumLiteralNode createEnumLiteralNode() {
		EnumLiteralNodeImpl enumLiteralNode = new EnumLiteralNodeImpl();
		return enumLiteralNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ErrorNode createErrorNode() {
		ErrorNodeImpl errorNode = new ErrorNodeImpl();
		return errorNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull IfNode createIfNode() {
		IfNodeImpl ifNode = new IfNodeImpl();
		return ifNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull IncludesEdge createIncludesEdge() {
		IncludesEdgeImpl includesEdge = new IncludesEdgeImpl();
		return includesEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull InputNode createInputNode() {
		InputNodeImpl inputNode = new InputNodeImpl();
		return inputNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull IteratedEdge createIteratedEdge() {
		IteratedEdgeImpl iteratedEdge = new IteratedEdgeImpl();
		return iteratedEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull IteratorNode createIteratorNode() {
		IteratorNodeImpl iteratorNode = new IteratorNodeImpl();
		return iteratorNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull KeyPartEdge createKeyPartEdge() {
		KeyPartEdgeImpl keyPartEdge = new KeyPartEdgeImpl();
		return keyPartEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull KeyedValueNode createKeyedValueNode() {
		KeyedValueNodeImpl keyedValueNode = new KeyedValueNodeImpl();
		return keyedValueNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LoadingPartition createLoadingPartition() {
		LoadingPartitionImpl loadingPartition = new LoadingPartitionImpl();
		return loadingPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LoadingRegion createLoadingRegion() {
		LoadingRegionImpl loadingRegion = new LoadingRegionImpl();
		return loadingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MapLiteralNode createMapLiteralNode() {
		MapLiteralNodeImpl mapLiteralNode = new MapLiteralNodeImpl();
		return mapLiteralNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MapPartEdge createMapPartEdge() {
		MapPartEdgeImpl mapPartEdge = new MapPartEdgeImpl();
		return mapPartEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MapPartNode createMapPartNode() {
		MapPartNodeImpl mapPartNode = new MapPartNodeImpl();
		return mapPartNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MergedPartition createMergedPartition() {
		MergedPartitionImpl mergedPartition = new MergedPartitionImpl();
		return mergedPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull NavigationEdge createNavigationEdge() {
		NavigationEdgeImpl navigationEdge = new NavigationEdgeImpl();
		return navigationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull NodeConnection createNodeConnection() {
		NodeConnectionImpl nodeConnection = new NodeConnectionImpl();
		return nodeConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull NonPartition createNonPartition() {
		NonPartitionImpl nonPartition = new NonPartitionImpl();
		return nonPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull NullLiteralNode createNullLiteralNode() {
		NullLiteralNodeImpl nullLiteralNode = new NullLiteralNodeImpl();
		return nullLiteralNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull NumericLiteralNode createNumericLiteralNode() {
		NumericLiteralNodeImpl numericLiteralNode = new NumericLiteralNodeImpl();
		return numericLiteralNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull OperationCallNode createOperationCallNode() {
		OperationCallNodeImpl operationCallNode = new OperationCallNodeImpl();
		return operationCallNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull OperationRegion createOperationRegion() {
		OperationRegionImpl operationRegion = new OperationRegionImpl();
		return operationRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull OperationParameterEdge createOperationParameterEdge() {
		OperationParameterEdgeImpl operationParameterEdge = new OperationParameterEdgeImpl();
		return operationParameterEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull OperationSelfEdge createOperationSelfEdge() {
		OperationSelfEdgeImpl operationSelfEdge = new OperationSelfEdgeImpl();
		return operationSelfEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull PatternTypedNode createPatternTypedNode() {
		PatternTypedNodeImpl patternTypedNode = new PatternTypedNodeImpl();
		return patternTypedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull PatternVariableNode createPatternVariableNode() {
		PatternVariableNodeImpl patternVariableNode = new PatternVariableNodeImpl();
		return patternVariableNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull PredicateEdge createPredicateEdge() {
		PredicateEdgeImpl predicateEdge = new PredicateEdgeImpl();
		return predicateEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull PropertyDatum createPropertyDatum() {
		PropertyDatumImpl propertyDatum = new PropertyDatumImpl();
		return propertyDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RecursionEdge createRecursionEdge() {
		RecursionEdgeImpl recursionEdge = new RecursionEdgeImpl();
		return recursionEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RootPartition createRootPartition() {
		RootPartitionImpl rootPartition = new RootPartitionImpl();
		return rootPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RootRegion createRootRegion() {
		RootRegionImpl rootRegion = new RootRegionImpl();
		return rootRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RuleRegion createRuleRegion() {
		RuleRegionImpl ruleRegion = new RuleRegionImpl();
		return ruleRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ScheduleModel createScheduleModel() {
		ScheduleModelImpl scheduleModel = new ScheduleModelImpl();
		return scheduleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ShadowNode createShadowNode() {
		ShadowNodeImpl shadowNode = new ShadowNodeImpl();
		return shadowNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ShadowPartEdge createShadowPartEdge() {
		ShadowPartEdgeImpl shadowPartEdge = new ShadowPartEdgeImpl();
		return shadowPartEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull StringLiteralNode createStringLiteralNode() {
		StringLiteralNodeImpl stringLiteralNode = new StringLiteralNodeImpl();
		return stringLiteralNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull SuccessEdge createSuccessEdge() {
		SuccessEdgeImpl successEdge = new SuccessEdgeImpl();
		return successEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull SuccessNode createSuccessNode() {
		SuccessNodeImpl successNode = new SuccessNodeImpl();
		return successNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TupleLiteralNode createTupleLiteralNode() {
		TupleLiteralNodeImpl tupleLiteralNode = new TupleLiteralNodeImpl();
		return tupleLiteralNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TuplePartEdge createTuplePartEdge() {
		TuplePartEdgeImpl tuplePartEdge = new TuplePartEdgeImpl();
		return tuplePartEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TypeLiteralNode createTypeLiteralNode() {
		TypeLiteralNodeImpl typeLiteralNode = new TypeLiteralNodeImpl();
		return typeLiteralNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull UnknownNode createUnknownNode() {
		UnknownNodeImpl unknownNode = new UnknownNodeImpl();
		return unknownNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull VerdictRegion createVerdictRegion() {
		VerdictRegionImpl verdictRegion = new VerdictRegionImpl();
		return verdictRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRole createConnectionRoleFromString(EDataType eDataType, String initialValue) {
		ConnectionRole result = ConnectionRole.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionRoleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role createRoleFromString(EDataType eDataType, String initialValue) {
		Role result = Role.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRoleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Number createNumberFromString(EDataType eDataType, String initialValue) {
		return (Number)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumberToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTschedulePackage getQVTschedulePackage() {
		return (QVTschedulePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTschedulePackage getPackage() {
		return QVTschedulePackage.eINSTANCE;
	}

} //QVTscheduleFactoryImpl
