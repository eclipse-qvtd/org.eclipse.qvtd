/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
			case 2: return createBasicPartition();
			case 3: return createBooleanLiteralNode();
			case 4: return createCastEdge();
			case 5: return createClassDatum();
			case 6: return createCluster();
			case 7: return createCollectionLiteralNode();
			case 8: return createCollectionPartEdge();
			case 9: return createCollectionRangeNode();
			case 10: return createComposedNode();
			case 14: return createCyclicMappingRegion();
			case 15: return createCyclicPartition();
			case 16: return createDependencyEdge();
			case 17: return createDependencyNode();
			case 18: return createDispatchRegion();
			case 20: return createEdgeConnection();
			case 21: return createEnumLiteralNode();
			case 22: return createErrorNode();
			case 24: return createIfNode();
			case 25: return createIncludesEdge();
			case 26: return createInputNode();
			case 27: return createIteratedEdge();
			case 28: return createIteratorNode();
			case 29: return createKeyPartEdge();
			case 30: return createKeyedValueNode();
			case 31: return createLoadingPartition();
			case 32: return createLoadingRegion();
			case 33: return createMapLiteralNode();
			case 34: return createMapPartEdge();
			case 35: return createMapPartNode();
			case 39: return createMergedPartition();
			case 41: return createNavigationEdge();
			case 43: return createNodeConnection();
			case 44: return createNonPartition();
			case 45: return createNullLiteralNode();
			case 46: return createNumericLiteralNode();
			case 47: return createOperationCallNode();
			case 49: return createOperationRegion();
			case 50: return createOperationParameterEdge();
			case 51: return createOperationSelfEdge();
			case 53: return createPatternTypedNode();
			case 54: return createPatternVariableNode();
			case 55: return createPredicateEdge();
			case 56: return createPropertyDatum();
			case 57: return createRecursionEdge();
			case 59: return createRootPartition();
			case 60: return createRootRegion();
			case 61: return createRuleRegion();
			case 62: return createScheduleModel();
			case 63: return createShadowNode();
			case 64: return createShadowPartEdge();
			case 65: return createStringLiteralNode();
			case 66: return createSuccessEdge();
			case 67: return createSuccessNode();
			case 69: return createTupleLiteralNode();
			case 70: return createTuplePartEdge();
			case 71: return createTypeLiteralNode();
			case 72: return createUnknownNode();
			case 74: return createVerdictRegion();
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
			case 75:
				return createConnectionRoleFromString(eDataType, initialValue);
			case 76:
				return createRoleFromString(eDataType, initialValue);
			case 77:
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
			case 75:
				return convertConnectionRoleToString(eDataType, instanceValue);
			case 76:
				return convertRoleToString(eDataType, instanceValue);
			case 77:
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
