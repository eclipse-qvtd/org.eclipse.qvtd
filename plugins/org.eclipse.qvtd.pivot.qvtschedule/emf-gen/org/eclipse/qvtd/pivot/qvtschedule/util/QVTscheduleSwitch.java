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
package org.eclipse.qvtd.pivot.qvtschedule.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.qvtd.pivot.qvtschedule.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage
 * @generated
 */
public class QVTscheduleSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTschedulePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTscheduleSwitch() {
		if (modelPackage == null) {
			modelPackage = QVTschedulePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QVTschedulePackage.ABSTRACT_DATUM: {
				AbstractDatum abstractDatum = (AbstractDatum)theEObject;
				T result = caseAbstractDatum(abstractDatum);
				if (result == null) result = caseNamedElement(abstractDatum);
				if (result == null) result = caseElement(abstractDatum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.ARGUMENT_EDGE: {
				ArgumentEdge argumentEdge = (ArgumentEdge)theEObject;
				T result = caseArgumentEdge(argumentEdge);
				if (result == null) result = caseExpressionEdge(argumentEdge);
				if (result == null) result = caseEdge(argumentEdge);
				if (result == null) result = caseElement(argumentEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.BOOLEAN_LITERAL_NODE: {
				BooleanLiteralNode booleanLiteralNode = (BooleanLiteralNode)theEObject;
				T result = caseBooleanLiteralNode(booleanLiteralNode);
				if (result == null) result = caseOperationNode(booleanLiteralNode);
				if (result == null) result = caseMappingNode(booleanLiteralNode);
				if (result == null) result = caseNode(booleanLiteralNode);
				if (result == null) result = caseElement(booleanLiteralNode);
				if (result == null) result = caseConnectionEnd(booleanLiteralNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.CAST_EDGE: {
				CastEdge castEdge = (CastEdge)theEObject;
				T result = caseCastEdge(castEdge);
				if (result == null) result = caseNavigableEdge(castEdge);
				if (result == null) result = caseEdge(castEdge);
				if (result == null) result = caseConnectionEnd(castEdge);
				if (result == null) result = caseElement(castEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.CLASS_DATUM: {
				ClassDatum classDatum = (ClassDatum)theEObject;
				T result = caseClassDatum(classDatum);
				if (result == null) result = caseAbstractDatum(classDatum);
				if (result == null) result = caseNamedElement(classDatum);
				if (result == null) result = caseElement(classDatum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.CLUSTER: {
				Cluster cluster = (Cluster)theEObject;
				T result = caseCluster(cluster);
				if (result == null) result = caseNamedElement(cluster);
				if (result == null) result = caseSymbolable(cluster);
				if (result == null) result = caseElement(cluster);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.COLLECTION_LITERAL_NODE: {
				CollectionLiteralNode collectionLiteralNode = (CollectionLiteralNode)theEObject;
				T result = caseCollectionLiteralNode(collectionLiteralNode);
				if (result == null) result = caseOperationNode(collectionLiteralNode);
				if (result == null) result = caseMappingNode(collectionLiteralNode);
				if (result == null) result = caseNode(collectionLiteralNode);
				if (result == null) result = caseElement(collectionLiteralNode);
				if (result == null) result = caseConnectionEnd(collectionLiteralNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.COLLECTION_PART_EDGE: {
				CollectionPartEdge collectionPartEdge = (CollectionPartEdge)theEObject;
				T result = caseCollectionPartEdge(collectionPartEdge);
				if (result == null) result = caseArgumentEdge(collectionPartEdge);
				if (result == null) result = caseExpressionEdge(collectionPartEdge);
				if (result == null) result = caseEdge(collectionPartEdge);
				if (result == null) result = caseElement(collectionPartEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.COLLECTION_RANGE_NODE: {
				CollectionRangeNode collectionRangeNode = (CollectionRangeNode)theEObject;
				T result = caseCollectionRangeNode(collectionRangeNode);
				if (result == null) result = caseOperationNode(collectionRangeNode);
				if (result == null) result = caseMappingNode(collectionRangeNode);
				if (result == null) result = caseNode(collectionRangeNode);
				if (result == null) result = caseElement(collectionRangeNode);
				if (result == null) result = caseConnectionEnd(collectionRangeNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.COMPOSED_NODE: {
				ComposedNode composedNode = (ComposedNode)theEObject;
				T result = caseComposedNode(composedNode);
				if (result == null) result = caseNode(composedNode);
				if (result == null) result = caseElement(composedNode);
				if (result == null) result = caseConnectionEnd(composedNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.CONNECTION: {
				Connection connection = (Connection)theEObject;
				T result = caseConnection(connection);
				if (result == null) result = caseElement(connection);
				if (result == null) result = caseSymbolable(connection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.CONNECTION_END: {
				ConnectionEnd connectionEnd = (ConnectionEnd)theEObject;
				T result = caseConnectionEnd(connectionEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.DATUM_CONNECTION: {
				DatumConnection<?> datumConnection = (DatumConnection<?>)theEObject;
				T result = caseDatumConnection(datumConnection);
				if (result == null) result = caseConnection(datumConnection);
				if (result == null) result = caseElement(datumConnection);
				if (result == null) result = caseSymbolable(datumConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.DEPENDENCY_EDGE: {
				DependencyEdge dependencyEdge = (DependencyEdge)theEObject;
				T result = caseDependencyEdge(dependencyEdge);
				if (result == null) result = caseEdge(dependencyEdge);
				if (result == null) result = caseElement(dependencyEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.DEPENDENCY_NODE: {
				DependencyNode dependencyNode = (DependencyNode)theEObject;
				T result = caseDependencyNode(dependencyNode);
				if (result == null) result = caseNode(dependencyNode);
				if (result == null) result = caseElement(dependencyNode);
				if (result == null) result = caseConnectionEnd(dependencyNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.DISPATCH_REGION: {
				DispatchRegion dispatchRegion = (DispatchRegion)theEObject;
				T result = caseDispatchRegion(dispatchRegion);
				if (result == null) result = caseRuleRegion(dispatchRegion);
				if (result == null) result = caseMappingRegion(dispatchRegion);
				if (result == null) result = caseRegion(dispatchRegion);
				if (result == null) result = caseNamedElement(dispatchRegion);
				if (result == null) result = caseSymbolable(dispatchRegion);
				if (result == null) result = caseElement(dispatchRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.EDGE: {
				Edge edge = (Edge)theEObject;
				T result = caseEdge(edge);
				if (result == null) result = caseElement(edge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.EDGE_CONNECTION: {
				EdgeConnection edgeConnection = (EdgeConnection)theEObject;
				T result = caseEdgeConnection(edgeConnection);
				if (result == null) result = caseDatumConnection(edgeConnection);
				if (result == null) result = caseConnection(edgeConnection);
				if (result == null) result = caseElement(edgeConnection);
				if (result == null) result = caseSymbolable(edgeConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.ENUM_LITERAL_NODE: {
				EnumLiteralNode enumLiteralNode = (EnumLiteralNode)theEObject;
				T result = caseEnumLiteralNode(enumLiteralNode);
				if (result == null) result = caseOperationNode(enumLiteralNode);
				if (result == null) result = caseMappingNode(enumLiteralNode);
				if (result == null) result = caseNode(enumLiteralNode);
				if (result == null) result = caseElement(enumLiteralNode);
				if (result == null) result = caseConnectionEnd(enumLiteralNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.ERROR_NODE: {
				ErrorNode errorNode = (ErrorNode)theEObject;
				T result = caseErrorNode(errorNode);
				if (result == null) result = caseMappingNode(errorNode);
				if (result == null) result = caseNode(errorNode);
				if (result == null) result = caseElement(errorNode);
				if (result == null) result = caseConnectionEnd(errorNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.EXPRESSION_EDGE: {
				ExpressionEdge expressionEdge = (ExpressionEdge)theEObject;
				T result = caseExpressionEdge(expressionEdge);
				if (result == null) result = caseEdge(expressionEdge);
				if (result == null) result = caseElement(expressionEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.IF_NODE: {
				IfNode ifNode = (IfNode)theEObject;
				T result = caseIfNode(ifNode);
				if (result == null) result = caseOperationNode(ifNode);
				if (result == null) result = caseMappingNode(ifNode);
				if (result == null) result = caseNode(ifNode);
				if (result == null) result = caseElement(ifNode);
				if (result == null) result = caseConnectionEnd(ifNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.INCLUDES_EDGE: {
				IncludesEdge includesEdge = (IncludesEdge)theEObject;
				T result = caseIncludesEdge(includesEdge);
				if (result == null) result = caseExpressionEdge(includesEdge);
				if (result == null) result = caseEdge(includesEdge);
				if (result == null) result = caseElement(includesEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.INPUT_NODE: {
				InputNode inputNode = (InputNode)theEObject;
				T result = caseInputNode(inputNode);
				if (result == null) result = caseNode(inputNode);
				if (result == null) result = caseElement(inputNode);
				if (result == null) result = caseConnectionEnd(inputNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.ITERATED_EDGE: {
				IteratedEdge iteratedEdge = (IteratedEdge)theEObject;
				T result = caseIteratedEdge(iteratedEdge);
				if (result == null) result = caseEdge(iteratedEdge);
				if (result == null) result = caseElement(iteratedEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.ITERATOR_NODE: {
				IteratorNode iteratorNode = (IteratorNode)theEObject;
				T result = caseIteratorNode(iteratorNode);
				if (result == null) result = caseVariableNode(iteratorNode);
				if (result == null) result = caseMappingNode(iteratorNode);
				if (result == null) result = caseNode(iteratorNode);
				if (result == null) result = caseElement(iteratorNode);
				if (result == null) result = caseConnectionEnd(iteratorNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.KEY_PART_EDGE: {
				KeyPartEdge keyPartEdge = (KeyPartEdge)theEObject;
				T result = caseKeyPartEdge(keyPartEdge);
				if (result == null) result = caseArgumentEdge(keyPartEdge);
				if (result == null) result = caseExpressionEdge(keyPartEdge);
				if (result == null) result = caseEdge(keyPartEdge);
				if (result == null) result = caseElement(keyPartEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.KEYED_VALUE_NODE: {
				KeyedValueNode keyedValueNode = (KeyedValueNode)theEObject;
				T result = caseKeyedValueNode(keyedValueNode);
				if (result == null) result = caseOperationNode(keyedValueNode);
				if (result == null) result = caseMappingNode(keyedValueNode);
				if (result == null) result = caseNode(keyedValueNode);
				if (result == null) result = caseElement(keyedValueNode);
				if (result == null) result = caseConnectionEnd(keyedValueNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.LOADING_REGION: {
				LoadingRegion loadingRegion = (LoadingRegion)theEObject;
				T result = caseLoadingRegion(loadingRegion);
				if (result == null) result = caseRegion(loadingRegion);
				if (result == null) result = caseNamedElement(loadingRegion);
				if (result == null) result = caseSymbolable(loadingRegion);
				if (result == null) result = caseElement(loadingRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.MAP_LITERAL_NODE: {
				MapLiteralNode mapLiteralNode = (MapLiteralNode)theEObject;
				T result = caseMapLiteralNode(mapLiteralNode);
				if (result == null) result = caseOperationNode(mapLiteralNode);
				if (result == null) result = caseMappingNode(mapLiteralNode);
				if (result == null) result = caseNode(mapLiteralNode);
				if (result == null) result = caseElement(mapLiteralNode);
				if (result == null) result = caseConnectionEnd(mapLiteralNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.MAP_PART_EDGE: {
				MapPartEdge mapPartEdge = (MapPartEdge)theEObject;
				T result = caseMapPartEdge(mapPartEdge);
				if (result == null) result = caseArgumentEdge(mapPartEdge);
				if (result == null) result = caseExpressionEdge(mapPartEdge);
				if (result == null) result = caseEdge(mapPartEdge);
				if (result == null) result = caseElement(mapPartEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.MAP_PART_NODE: {
				MapPartNode mapPartNode = (MapPartNode)theEObject;
				T result = caseMapPartNode(mapPartNode);
				if (result == null) result = caseOperationNode(mapPartNode);
				if (result == null) result = caseMappingNode(mapPartNode);
				if (result == null) result = caseNode(mapPartNode);
				if (result == null) result = caseElement(mapPartNode);
				if (result == null) result = caseConnectionEnd(mapPartNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.MAPPING_NODE: {
				MappingNode mappingNode = (MappingNode)theEObject;
				T result = caseMappingNode(mappingNode);
				if (result == null) result = caseNode(mappingNode);
				if (result == null) result = caseElement(mappingNode);
				if (result == null) result = caseConnectionEnd(mappingNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.MAPPING_REGION: {
				MappingRegion mappingRegion = (MappingRegion)theEObject;
				T result = caseMappingRegion(mappingRegion);
				if (result == null) result = caseRegion(mappingRegion);
				if (result == null) result = caseNamedElement(mappingRegion);
				if (result == null) result = caseSymbolable(mappingRegion);
				if (result == null) result = caseElement(mappingRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.MICRO_MAPPING_REGION: {
				MicroMappingRegion microMappingRegion = (MicroMappingRegion)theEObject;
				T result = caseMicroMappingRegion(microMappingRegion);
				if (result == null) result = caseMappingRegion(microMappingRegion);
				if (result == null) result = caseRegion(microMappingRegion);
				if (result == null) result = caseNamedElement(microMappingRegion);
				if (result == null) result = caseSymbolable(microMappingRegion);
				if (result == null) result = caseElement(microMappingRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NAMED_MAPPING_REGION: {
				NamedMappingRegion namedMappingRegion = (NamedMappingRegion)theEObject;
				T result = caseNamedMappingRegion(namedMappingRegion);
				if (result == null) result = caseMappingRegion(namedMappingRegion);
				if (result == null) result = caseRegion(namedMappingRegion);
				if (result == null) result = caseNamedElement(namedMappingRegion);
				if (result == null) result = caseSymbolable(namedMappingRegion);
				if (result == null) result = caseElement(namedMappingRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NAVIGABLE_EDGE: {
				NavigableEdge navigableEdge = (NavigableEdge)theEObject;
				T result = caseNavigableEdge(navigableEdge);
				if (result == null) result = caseEdge(navigableEdge);
				if (result == null) result = caseConnectionEnd(navigableEdge);
				if (result == null) result = caseElement(navigableEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NAVIGATION_EDGE: {
				NavigationEdge navigationEdge = (NavigationEdge)theEObject;
				T result = caseNavigationEdge(navigationEdge);
				if (result == null) result = caseNavigableEdge(navigationEdge);
				if (result == null) result = caseEdge(navigationEdge);
				if (result == null) result = caseConnectionEnd(navigationEdge);
				if (result == null) result = caseElement(navigationEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NODE: {
				Node node = (Node)theEObject;
				T result = caseNode(node);
				if (result == null) result = caseElement(node);
				if (result == null) result = caseConnectionEnd(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NODE_CONNECTION: {
				NodeConnection nodeConnection = (NodeConnection)theEObject;
				T result = caseNodeConnection(nodeConnection);
				if (result == null) result = caseDatumConnection(nodeConnection);
				if (result == null) result = caseConnection(nodeConnection);
				if (result == null) result = caseElement(nodeConnection);
				if (result == null) result = caseSymbolable(nodeConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NULL_LITERAL_NODE: {
				NullLiteralNode nullLiteralNode = (NullLiteralNode)theEObject;
				T result = caseNullLiteralNode(nullLiteralNode);
				if (result == null) result = caseOperationNode(nullLiteralNode);
				if (result == null) result = caseMappingNode(nullLiteralNode);
				if (result == null) result = caseNode(nullLiteralNode);
				if (result == null) result = caseElement(nullLiteralNode);
				if (result == null) result = caseConnectionEnd(nullLiteralNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NUMERIC_LITERAL_NODE: {
				NumericLiteralNode numericLiteralNode = (NumericLiteralNode)theEObject;
				T result = caseNumericLiteralNode(numericLiteralNode);
				if (result == null) result = caseOperationNode(numericLiteralNode);
				if (result == null) result = caseMappingNode(numericLiteralNode);
				if (result == null) result = caseNode(numericLiteralNode);
				if (result == null) result = caseElement(numericLiteralNode);
				if (result == null) result = caseConnectionEnd(numericLiteralNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.OPERATION_CALL_NODE: {
				OperationCallNode operationCallNode = (OperationCallNode)theEObject;
				T result = caseOperationCallNode(operationCallNode);
				if (result == null) result = caseOperationNode(operationCallNode);
				if (result == null) result = caseMappingNode(operationCallNode);
				if (result == null) result = caseNode(operationCallNode);
				if (result == null) result = caseElement(operationCallNode);
				if (result == null) result = caseConnectionEnd(operationCallNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.OPERATION_NODE: {
				OperationNode operationNode = (OperationNode)theEObject;
				T result = caseOperationNode(operationNode);
				if (result == null) result = caseMappingNode(operationNode);
				if (result == null) result = caseNode(operationNode);
				if (result == null) result = caseElement(operationNode);
				if (result == null) result = caseConnectionEnd(operationNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.OPERATION_REGION: {
				OperationRegion operationRegion = (OperationRegion)theEObject;
				T result = caseOperationRegion(operationRegion);
				if (result == null) result = caseRegion(operationRegion);
				if (result == null) result = caseNamedElement(operationRegion);
				if (result == null) result = caseSymbolable(operationRegion);
				if (result == null) result = caseElement(operationRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.OPERATION_PARAMETER_EDGE: {
				OperationParameterEdge operationParameterEdge = (OperationParameterEdge)theEObject;
				T result = caseOperationParameterEdge(operationParameterEdge);
				if (result == null) result = caseArgumentEdge(operationParameterEdge);
				if (result == null) result = caseExpressionEdge(operationParameterEdge);
				if (result == null) result = caseEdge(operationParameterEdge);
				if (result == null) result = caseElement(operationParameterEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.OPERATION_SELF_EDGE: {
				OperationSelfEdge operationSelfEdge = (OperationSelfEdge)theEObject;
				T result = caseOperationSelfEdge(operationSelfEdge);
				if (result == null) result = caseArgumentEdge(operationSelfEdge);
				if (result == null) result = caseExpressionEdge(operationSelfEdge);
				if (result == null) result = caseEdge(operationSelfEdge);
				if (result == null) result = caseElement(operationSelfEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.PATTERN_TYPED_NODE: {
				PatternTypedNode patternTypedNode = (PatternTypedNode)theEObject;
				T result = casePatternTypedNode(patternTypedNode);
				if (result == null) result = caseMappingNode(patternTypedNode);
				if (result == null) result = caseNode(patternTypedNode);
				if (result == null) result = caseElement(patternTypedNode);
				if (result == null) result = caseConnectionEnd(patternTypedNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.PATTERN_VARIABLE_NODE: {
				PatternVariableNode patternVariableNode = (PatternVariableNode)theEObject;
				T result = casePatternVariableNode(patternVariableNode);
				if (result == null) result = caseVariableNode(patternVariableNode);
				if (result == null) result = caseMappingNode(patternVariableNode);
				if (result == null) result = caseNode(patternVariableNode);
				if (result == null) result = caseElement(patternVariableNode);
				if (result == null) result = caseConnectionEnd(patternVariableNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.PREDICATE_EDGE: {
				PredicateEdge predicateEdge = (PredicateEdge)theEObject;
				T result = casePredicateEdge(predicateEdge);
				if (result == null) result = caseEdge(predicateEdge);
				if (result == null) result = caseElement(predicateEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.PROPERTY_DATUM: {
				PropertyDatum propertyDatum = (PropertyDatum)theEObject;
				T result = casePropertyDatum(propertyDatum);
				if (result == null) result = caseAbstractDatum(propertyDatum);
				if (result == null) result = caseNamedElement(propertyDatum);
				if (result == null) result = caseElement(propertyDatum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.RECURSION_EDGE: {
				RecursionEdge recursionEdge = (RecursionEdge)theEObject;
				T result = caseRecursionEdge(recursionEdge);
				if (result == null) result = caseEdge(recursionEdge);
				if (result == null) result = caseElement(recursionEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.REGION: {
				Region region = (Region)theEObject;
				T result = caseRegion(region);
				if (result == null) result = caseNamedElement(region);
				if (result == null) result = caseSymbolable(region);
				if (result == null) result = caseElement(region);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.RULE_REGION: {
				RuleRegion ruleRegion = (RuleRegion)theEObject;
				T result = caseRuleRegion(ruleRegion);
				if (result == null) result = caseMappingRegion(ruleRegion);
				if (result == null) result = caseRegion(ruleRegion);
				if (result == null) result = caseNamedElement(ruleRegion);
				if (result == null) result = caseSymbolable(ruleRegion);
				if (result == null) result = caseElement(ruleRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.SCHEDULE_MODEL: {
				ScheduleModel scheduleModel = (ScheduleModel)theEObject;
				T result = caseScheduleModel(scheduleModel);
				if (result == null) result = caseModel(scheduleModel);
				if (result == null) result = caseNamespace(scheduleModel);
				if (result == null) result = caseNamedElement(scheduleModel);
				if (result == null) result = caseElement(scheduleModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.SCHEDULED_REGION: {
				ScheduledRegion scheduledRegion = (ScheduledRegion)theEObject;
				T result = caseScheduledRegion(scheduledRegion);
				if (result == null) result = caseRegion(scheduledRegion);
				if (result == null) result = caseNamedElement(scheduledRegion);
				if (result == null) result = caseSymbolable(scheduledRegion);
				if (result == null) result = caseElement(scheduledRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.SHADOW_NODE: {
				ShadowNode shadowNode = (ShadowNode)theEObject;
				T result = caseShadowNode(shadowNode);
				if (result == null) result = caseOperationNode(shadowNode);
				if (result == null) result = caseMappingNode(shadowNode);
				if (result == null) result = caseNode(shadowNode);
				if (result == null) result = caseElement(shadowNode);
				if (result == null) result = caseConnectionEnd(shadowNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.SHADOW_PART_EDGE: {
				ShadowPartEdge shadowPartEdge = (ShadowPartEdge)theEObject;
				T result = caseShadowPartEdge(shadowPartEdge);
				if (result == null) result = caseArgumentEdge(shadowPartEdge);
				if (result == null) result = caseExpressionEdge(shadowPartEdge);
				if (result == null) result = caseEdge(shadowPartEdge);
				if (result == null) result = caseElement(shadowPartEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.STRING_LITERAL_NODE: {
				StringLiteralNode stringLiteralNode = (StringLiteralNode)theEObject;
				T result = caseStringLiteralNode(stringLiteralNode);
				if (result == null) result = caseOperationNode(stringLiteralNode);
				if (result == null) result = caseMappingNode(stringLiteralNode);
				if (result == null) result = caseNode(stringLiteralNode);
				if (result == null) result = caseElement(stringLiteralNode);
				if (result == null) result = caseConnectionEnd(stringLiteralNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.SUCCESS_EDGE: {
				SuccessEdge successEdge = (SuccessEdge)theEObject;
				T result = caseSuccessEdge(successEdge);
				if (result == null) result = caseNavigationEdge(successEdge);
				if (result == null) result = caseNavigableEdge(successEdge);
				if (result == null) result = caseEdge(successEdge);
				if (result == null) result = caseConnectionEnd(successEdge);
				if (result == null) result = caseElement(successEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.SUCCESS_NODE: {
				SuccessNode successNode = (SuccessNode)theEObject;
				T result = caseSuccessNode(successNode);
				if (result == null) result = caseMappingNode(successNode);
				if (result == null) result = caseNode(successNode);
				if (result == null) result = caseElement(successNode);
				if (result == null) result = caseConnectionEnd(successNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.SYMBOLABLE: {
				Symbolable symbolable = (Symbolable)theEObject;
				T result = caseSymbolable(symbolable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.TUPLE_LITERAL_NODE: {
				TupleLiteralNode tupleLiteralNode = (TupleLiteralNode)theEObject;
				T result = caseTupleLiteralNode(tupleLiteralNode);
				if (result == null) result = caseOperationNode(tupleLiteralNode);
				if (result == null) result = caseMappingNode(tupleLiteralNode);
				if (result == null) result = caseNode(tupleLiteralNode);
				if (result == null) result = caseElement(tupleLiteralNode);
				if (result == null) result = caseConnectionEnd(tupleLiteralNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.TUPLE_PART_EDGE: {
				TuplePartEdge tuplePartEdge = (TuplePartEdge)theEObject;
				T result = caseTuplePartEdge(tuplePartEdge);
				if (result == null) result = caseArgumentEdge(tuplePartEdge);
				if (result == null) result = caseExpressionEdge(tuplePartEdge);
				if (result == null) result = caseEdge(tuplePartEdge);
				if (result == null) result = caseElement(tuplePartEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.TYPE_LITERAL_NODE: {
				TypeLiteralNode typeLiteralNode = (TypeLiteralNode)theEObject;
				T result = caseTypeLiteralNode(typeLiteralNode);
				if (result == null) result = caseOperationNode(typeLiteralNode);
				if (result == null) result = caseMappingNode(typeLiteralNode);
				if (result == null) result = caseNode(typeLiteralNode);
				if (result == null) result = caseElement(typeLiteralNode);
				if (result == null) result = caseConnectionEnd(typeLiteralNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.UNKNOWN_NODE: {
				UnknownNode unknownNode = (UnknownNode)theEObject;
				T result = caseUnknownNode(unknownNode);
				if (result == null) result = caseMappingNode(unknownNode);
				if (result == null) result = caseNode(unknownNode);
				if (result == null) result = caseElement(unknownNode);
				if (result == null) result = caseConnectionEnd(unknownNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.VARIABLE_NODE: {
				VariableNode variableNode = (VariableNode)theEObject;
				T result = caseVariableNode(variableNode);
				if (result == null) result = caseMappingNode(variableNode);
				if (result == null) result = caseNode(variableNode);
				if (result == null) result = caseElement(variableNode);
				if (result == null) result = caseConnectionEnd(variableNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.VERDICT_REGION: {
				VerdictRegion verdictRegion = (VerdictRegion)theEObject;
				T result = caseVerdictRegion(verdictRegion);
				if (result == null) result = caseRuleRegion(verdictRegion);
				if (result == null) result = caseMappingRegion(verdictRegion);
				if (result == null) result = caseRegion(verdictRegion);
				if (result == null) result = caseNamedElement(verdictRegion);
				if (result == null) result = caseSymbolable(verdictRegion);
				if (result == null) result = caseElement(verdictRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Datum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Datum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractDatum(AbstractDatum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Argument Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Argument Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArgumentEdge(ArgumentEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteralNode(BooleanLiteralNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cast Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cast Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCastEdge(CastEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Datum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Datum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassDatum(ClassDatum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cluster</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cluster</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCluster(Cluster object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionLiteralNode(CollectionLiteralNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Part Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Part Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionPartEdge(CollectionPartEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Range Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Range Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionRangeNode(CollectionRangeNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composed Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composed Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComposedNode(ComposedNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnection(Connection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionEnd(ConnectionEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Datum Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Datum Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CE extends ConnectionEnd> T caseDatumConnection(DatumConnection<CE> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyEdge(DependencyEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyNode(DependencyNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dispatch Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dispatch Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDispatchRegion(DispatchRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeConnection(EdgeConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteralNode(EnumLiteralNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedule Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedule Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduleModel(ScheduleModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduled Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduled Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduledRegion(ScheduledRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shadow Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shadow Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShadowNode(ShadowNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shadow Part Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shadow Part Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShadowPartEdge(ShadowPartEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralNode(StringLiteralNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Success Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Success Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuccessEdge(SuccessEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Success Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Success Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuccessNode(SuccessNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbolable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbolable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbolable(Symbolable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleLiteralNode(TupleLiteralNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Part Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Part Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTuplePartEdge(TuplePartEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Literal Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeLiteralNode(TypeLiteralNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unknown Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unknown Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnknownNode(UnknownNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableNode(VariableNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verdict Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verdict Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerdictRegion(VerdictRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorNode(ErrorNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionEdge(ExpressionEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfNode(IfNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Includes Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Includes Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncludesEdge(IncludesEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputNode(InputNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterated Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterated Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratedEdge(IteratedEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorNode(IteratorNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Part Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Part Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyPartEdge(KeyPartEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Keyed Value Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Keyed Value Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyedValueNode(KeyedValueNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loading Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loading Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoadingRegion(LoadingRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Literal Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapLiteralNode(MapLiteralNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Part Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Part Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapPartEdge(MapPartEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Part Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Part Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapPartNode(MapPartNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingNode(MappingNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingRegion(MappingRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Micro Mapping Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Micro Mapping Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMicroMappingRegion(MicroMappingRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Mapping Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Mapping Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedMappingRegion(NamedMappingRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigable Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigable Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigableEdge(NavigableEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationEdge(NavigationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeConnection(NodeConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Literal Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullLiteralNode(NullLiteralNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Literal Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Literal Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericLiteralNode(NumericLiteralNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallNode(OperationCallNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationNode(OperationNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationRegion(OperationRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Parameter Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Parameter Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationParameterEdge(OperationParameterEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Self Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Self Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationSelfEdge(OperationSelfEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Typed Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Typed Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternTypedNode(PatternTypedNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Variable Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Variable Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternVariableNode(PatternVariableNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredicateEdge(PredicateEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Datum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Datum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyDatum(PropertyDatum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recursion Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recursion Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecursionEdge(RecursionEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegion(Region object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleRegion(RuleRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //QVTscheduleSwitch
