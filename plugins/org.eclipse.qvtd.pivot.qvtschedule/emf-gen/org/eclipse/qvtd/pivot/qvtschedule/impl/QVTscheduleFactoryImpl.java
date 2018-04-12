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
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QVTschedulePackage.BOOLEAN_VALUE_NODE: return createBooleanValueNode();
			case QVTschedulePackage.CAST_EDGE: return createCastEdge();
			case QVTschedulePackage.CLASS_DATUM: return createClassDatum();
			case QVTschedulePackage.COMPOSED_NODE: return createComposedNode();
			case QVTschedulePackage.DEPENDENCY_NODE: return createDependencyNode();
			case QVTschedulePackage.DISPATCH_REGION: return createDispatchRegion();
			case QVTschedulePackage.EDGE_CONNECTION: return createEdgeConnection();
			case QVTschedulePackage.ERROR_NODE: return createErrorNode();
			case QVTschedulePackage.EXPRESSION_EDGE: return createExpressionEdge();
			case QVTschedulePackage.INPUT_NODE: return createInputNode();
			case QVTschedulePackage.ITERATED_EDGE: return createIteratedEdge();
			case QVTschedulePackage.ITERATOR_NODE: return createIteratorNode();
			case QVTschedulePackage.KEYED_VALUE_NODE: return createKeyedValueNode();
			case QVTschedulePackage.LOADING_REGION: return createLoadingRegion();
			case QVTschedulePackage.MICRO_MAPPING_REGION: return createMicroMappingRegion();
			case QVTschedulePackage.NAMED_MAPPING_REGION: return createNamedMappingRegion();
			case QVTschedulePackage.NAVIGATION_EDGE: return createNavigationEdge();
			case QVTschedulePackage.NODE_CONNECTION: return createNodeConnection();
			case QVTschedulePackage.NULL_NODE: return createNullNode();
			case QVTschedulePackage.OPERATION_VALUE_NODE: return createOperationValueNode();
			case QVTschedulePackage.OPERATION_NODE: return createOperationNode();
			case QVTschedulePackage.OPERATION_REGION: return createOperationRegion();
			case QVTschedulePackage.PATTERN_TYPED_NODE: return createPatternTypedNode();
			case QVTschedulePackage.PATTERN_VARIABLE_NODE: return createPatternVariableNode();
			case QVTschedulePackage.PREDICATE_EDGE: return createPredicateEdge();
			case QVTschedulePackage.PROPERTY_DATUM: return createPropertyDatum();
			case QVTschedulePackage.RECURSION_EDGE: return createRecursionEdge();
			case QVTschedulePackage.RULE_REGION: return createRuleRegion();
			case QVTschedulePackage.SCHEDULE_MODEL: return createScheduleModel();
			case QVTschedulePackage.SCHEDULED_REGION: return createScheduledRegion();
			case QVTschedulePackage.SUCCESS_EDGE: return createSuccessEdge();
			case QVTschedulePackage.SUCCESS_NODE: return createSuccessNode();
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
	public @NonNull BooleanValueNode createBooleanValueNode() {
		BooleanValueNodeImpl booleanValueNode = new BooleanValueNodeImpl();
		return booleanValueNode;
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
	public @NonNull ExpressionEdge createExpressionEdge() {
		ExpressionEdgeImpl expressionEdge = new ExpressionEdgeImpl();
		return expressionEdge;
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
	public @NonNull MicroMappingRegion createMicroMappingRegion() {
		MicroMappingRegionImpl microMappingRegion = new MicroMappingRegionImpl();
		return microMappingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull NamedMappingRegion createNamedMappingRegion() {
		NamedMappingRegionImpl namedMappingRegion = new NamedMappingRegionImpl();
		return namedMappingRegion;
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
	public @NonNull NullNode createNullNode() {
		NullNodeImpl nullNode = new NullNodeImpl();
		return nullNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull OperationValueNode createOperationValueNode() {
		OperationValueNodeImpl operationValueNode = new OperationValueNodeImpl();
		return operationValueNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull OperationNode createOperationNode() {
		OperationNodeImpl operationNode = new OperationNodeImpl();
		return operationNode;
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
	public @NonNull ScheduledRegion createScheduledRegion() {
		ScheduledRegionImpl scheduledRegion = new ScheduledRegionImpl();
		return scheduledRegion;
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
