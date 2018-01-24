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
package org.eclipse.qvtd.pivot.qvtschedule.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.Nameable;
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
				if (result == null) result = caseNameable(abstractDatum);
				if (result == null) result = caseVisitable(abstractDatum);
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
				if (result == null) result = caseNameable(castEdge);
				if (result == null) result = caseVisitable(castEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.CLASS_DATUM: {
				ClassDatum classDatum = (ClassDatum)theEObject;
				T result = caseClassDatum(classDatum);
				if (result == null) result = caseAbstractDatum(classDatum);
				if (result == null) result = caseNamedElement(classDatum);
				if (result == null) result = caseElement(classDatum);
				if (result == null) result = caseNameable(classDatum);
				if (result == null) result = caseVisitable(classDatum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.COMPOSED_NODE: {
				ComposedNode composedNode = (ComposedNode)theEObject;
				T result = caseComposedNode(composedNode);
				if (result == null) result = caseNode(composedNode);
				if (result == null) result = caseElement(composedNode);
				if (result == null) result = caseConnectionEnd(composedNode);
				if (result == null) result = caseNameable(composedNode);
				if (result == null) result = caseVisitable(composedNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.CONNECTION: {
				Connection connection = (Connection)theEObject;
				T result = caseConnection(connection);
				if (result == null) result = caseElement(connection);
				if (result == null) result = caseNameable(connection);
				if (result == null) result = caseSymbolable(connection);
				if (result == null) result = caseVisitable(connection);
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
				if (result == null) result = caseNameable(datumConnection);
				if (result == null) result = caseSymbolable(datumConnection);
				if (result == null) result = caseVisitable(datumConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.DEPENDENCY_NODE: {
				DependencyNode dependencyNode = (DependencyNode)theEObject;
				T result = caseDependencyNode(dependencyNode);
				if (result == null) result = caseNode(dependencyNode);
				if (result == null) result = caseElement(dependencyNode);
				if (result == null) result = caseConnectionEnd(dependencyNode);
				if (result == null) result = caseNameable(dependencyNode);
				if (result == null) result = caseVisitable(dependencyNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.EDGE: {
				Edge edge = (Edge)theEObject;
				T result = caseEdge(edge);
				if (result == null) result = caseElement(edge);
				if (result == null) result = caseNameable(edge);
				if (result == null) result = caseVisitable(edge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.EDGE_CONNECTION: {
				EdgeConnection edgeConnection = (EdgeConnection)theEObject;
				T result = caseEdgeConnection(edgeConnection);
				if (result == null) result = caseDatumConnection(edgeConnection);
				if (result == null) result = caseConnection(edgeConnection);
				if (result == null) result = caseElement(edgeConnection);
				if (result == null) result = caseNameable(edgeConnection);
				if (result == null) result = caseSymbolable(edgeConnection);
				if (result == null) result = caseVisitable(edgeConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.ERROR_NODE: {
				ErrorNode errorNode = (ErrorNode)theEObject;
				T result = caseErrorNode(errorNode);
				if (result == null) result = caseNode(errorNode);
				if (result == null) result = caseElement(errorNode);
				if (result == null) result = caseConnectionEnd(errorNode);
				if (result == null) result = caseNameable(errorNode);
				if (result == null) result = caseVisitable(errorNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.EXPRESSION_EDGE: {
				ExpressionEdge expressionEdge = (ExpressionEdge)theEObject;
				T result = caseExpressionEdge(expressionEdge);
				if (result == null) result = caseEdge(expressionEdge);
				if (result == null) result = caseElement(expressionEdge);
				if (result == null) result = caseNameable(expressionEdge);
				if (result == null) result = caseVisitable(expressionEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.INPUT_NODE: {
				InputNode inputNode = (InputNode)theEObject;
				T result = caseInputNode(inputNode);
				if (result == null) result = caseNode(inputNode);
				if (result == null) result = caseElement(inputNode);
				if (result == null) result = caseConnectionEnd(inputNode);
				if (result == null) result = caseNameable(inputNode);
				if (result == null) result = caseVisitable(inputNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.ITERATED_EDGE: {
				IteratedEdge iteratedEdge = (IteratedEdge)theEObject;
				T result = caseIteratedEdge(iteratedEdge);
				if (result == null) result = caseEdge(iteratedEdge);
				if (result == null) result = caseElement(iteratedEdge);
				if (result == null) result = caseNameable(iteratedEdge);
				if (result == null) result = caseVisitable(iteratedEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.ITERATOR_NODE: {
				IteratorNode iteratorNode = (IteratorNode)theEObject;
				T result = caseIteratorNode(iteratorNode);
				if (result == null) result = caseVariableNode(iteratorNode);
				if (result == null) result = caseNode(iteratorNode);
				if (result == null) result = caseElement(iteratorNode);
				if (result == null) result = caseConnectionEnd(iteratorNode);
				if (result == null) result = caseNameable(iteratorNode);
				if (result == null) result = caseVisitable(iteratorNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.LOADING_REGION: {
				LoadingRegion loadingRegion = (LoadingRegion)theEObject;
				T result = caseLoadingRegion(loadingRegion);
				if (result == null) result = caseRegion(loadingRegion);
				if (result == null) result = caseElement(loadingRegion);
				if (result == null) result = caseNameable(loadingRegion);
				if (result == null) result = caseSymbolable(loadingRegion);
				if (result == null) result = caseVisitable(loadingRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.MAPPING_REGION: {
				MappingRegion mappingRegion = (MappingRegion)theEObject;
				T result = caseMappingRegion(mappingRegion);
				if (result == null) result = caseRegion(mappingRegion);
				if (result == null) result = caseElement(mappingRegion);
				if (result == null) result = caseNameable(mappingRegion);
				if (result == null) result = caseSymbolable(mappingRegion);
				if (result == null) result = caseVisitable(mappingRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.MICRO_MAPPING_REGION: {
				MicroMappingRegion microMappingRegion = (MicroMappingRegion)theEObject;
				T result = caseMicroMappingRegion(microMappingRegion);
				if (result == null) result = caseMappingRegion(microMappingRegion);
				if (result == null) result = caseRegion(microMappingRegion);
				if (result == null) result = caseElement(microMappingRegion);
				if (result == null) result = caseNameable(microMappingRegion);
				if (result == null) result = caseSymbolable(microMappingRegion);
				if (result == null) result = caseVisitable(microMappingRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NAMED_MAPPING_REGION: {
				NamedMappingRegion namedMappingRegion = (NamedMappingRegion)theEObject;
				T result = caseNamedMappingRegion(namedMappingRegion);
				if (result == null) result = caseMappingRegion(namedMappingRegion);
				if (result == null) result = caseRegion(namedMappingRegion);
				if (result == null) result = caseElement(namedMappingRegion);
				if (result == null) result = caseNameable(namedMappingRegion);
				if (result == null) result = caseSymbolable(namedMappingRegion);
				if (result == null) result = caseVisitable(namedMappingRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NAVIGABLE_EDGE: {
				NavigableEdge navigableEdge = (NavigableEdge)theEObject;
				T result = caseNavigableEdge(navigableEdge);
				if (result == null) result = caseEdge(navigableEdge);
				if (result == null) result = caseConnectionEnd(navigableEdge);
				if (result == null) result = caseElement(navigableEdge);
				if (result == null) result = caseNameable(navigableEdge);
				if (result == null) result = caseVisitable(navigableEdge);
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
				if (result == null) result = caseNameable(navigationEdge);
				if (result == null) result = caseVisitable(navigationEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NODE: {
				Node node = (Node)theEObject;
				T result = caseNode(node);
				if (result == null) result = caseElement(node);
				if (result == null) result = caseConnectionEnd(node);
				if (result == null) result = caseNameable(node);
				if (result == null) result = caseVisitable(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NODE_CONNECTION: {
				NodeConnection nodeConnection = (NodeConnection)theEObject;
				T result = caseNodeConnection(nodeConnection);
				if (result == null) result = caseDatumConnection(nodeConnection);
				if (result == null) result = caseConnection(nodeConnection);
				if (result == null) result = caseElement(nodeConnection);
				if (result == null) result = caseNameable(nodeConnection);
				if (result == null) result = caseSymbolable(nodeConnection);
				if (result == null) result = caseVisitable(nodeConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.NULL_NODE: {
				NullNode nullNode = (NullNode)theEObject;
				T result = caseNullNode(nullNode);
				if (result == null) result = caseNode(nullNode);
				if (result == null) result = caseElement(nullNode);
				if (result == null) result = caseConnectionEnd(nullNode);
				if (result == null) result = caseNameable(nullNode);
				if (result == null) result = caseVisitable(nullNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.OPERATION_NODE: {
				OperationNode operationNode = (OperationNode)theEObject;
				T result = caseOperationNode(operationNode);
				if (result == null) result = caseNode(operationNode);
				if (result == null) result = caseElement(operationNode);
				if (result == null) result = caseConnectionEnd(operationNode);
				if (result == null) result = caseNameable(operationNode);
				if (result == null) result = caseVisitable(operationNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.OPERATION_REGION: {
				OperationRegion operationRegion = (OperationRegion)theEObject;
				T result = caseOperationRegion(operationRegion);
				if (result == null) result = caseRegion(operationRegion);
				if (result == null) result = caseElement(operationRegion);
				if (result == null) result = caseNameable(operationRegion);
				if (result == null) result = caseSymbolable(operationRegion);
				if (result == null) result = caseVisitable(operationRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.PATTERN_TYPED_NODE: {
				PatternTypedNode patternTypedNode = (PatternTypedNode)theEObject;
				T result = casePatternTypedNode(patternTypedNode);
				if (result == null) result = caseNode(patternTypedNode);
				if (result == null) result = caseElement(patternTypedNode);
				if (result == null) result = caseConnectionEnd(patternTypedNode);
				if (result == null) result = caseNameable(patternTypedNode);
				if (result == null) result = caseVisitable(patternTypedNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.PATTERN_VARIABLE_NODE: {
				PatternVariableNode patternVariableNode = (PatternVariableNode)theEObject;
				T result = casePatternVariableNode(patternVariableNode);
				if (result == null) result = caseVariableNode(patternVariableNode);
				if (result == null) result = caseNode(patternVariableNode);
				if (result == null) result = caseElement(patternVariableNode);
				if (result == null) result = caseConnectionEnd(patternVariableNode);
				if (result == null) result = caseNameable(patternVariableNode);
				if (result == null) result = caseVisitable(patternVariableNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.PREDICATE_EDGE: {
				PredicateEdge predicateEdge = (PredicateEdge)theEObject;
				T result = casePredicateEdge(predicateEdge);
				if (result == null) result = caseEdge(predicateEdge);
				if (result == null) result = caseElement(predicateEdge);
				if (result == null) result = caseNameable(predicateEdge);
				if (result == null) result = caseVisitable(predicateEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.PROPERTY_DATUM: {
				PropertyDatum propertyDatum = (PropertyDatum)theEObject;
				T result = casePropertyDatum(propertyDatum);
				if (result == null) result = caseAbstractDatum(propertyDatum);
				if (result == null) result = caseNamedElement(propertyDatum);
				if (result == null) result = caseElement(propertyDatum);
				if (result == null) result = caseNameable(propertyDatum);
				if (result == null) result = caseVisitable(propertyDatum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.RECURSION_EDGE: {
				RecursionEdge recursionEdge = (RecursionEdge)theEObject;
				T result = caseRecursionEdge(recursionEdge);
				if (result == null) result = caseEdge(recursionEdge);
				if (result == null) result = caseElement(recursionEdge);
				if (result == null) result = caseNameable(recursionEdge);
				if (result == null) result = caseVisitable(recursionEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.REGION: {
				Region region = (Region)theEObject;
				T result = caseRegion(region);
				if (result == null) result = caseElement(region);
				if (result == null) result = caseNameable(region);
				if (result == null) result = caseSymbolable(region);
				if (result == null) result = caseVisitable(region);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.RULE_REGION: {
				RuleRegion ruleRegion = (RuleRegion)theEObject;
				T result = caseRuleRegion(ruleRegion);
				if (result == null) result = caseMappingRegion(ruleRegion);
				if (result == null) result = caseRegion(ruleRegion);
				if (result == null) result = caseElement(ruleRegion);
				if (result == null) result = caseNameable(ruleRegion);
				if (result == null) result = caseSymbolable(ruleRegion);
				if (result == null) result = caseVisitable(ruleRegion);
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
				if (result == null) result = caseNameable(scheduleModel);
				if (result == null) result = caseVisitable(scheduleModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.SCHEDULED_REGION: {
				ScheduledRegion scheduledRegion = (ScheduledRegion)theEObject;
				T result = caseScheduledRegion(scheduledRegion);
				if (result == null) result = caseRegion(scheduledRegion);
				if (result == null) result = caseElement(scheduledRegion);
				if (result == null) result = caseNameable(scheduledRegion);
				if (result == null) result = caseSymbolable(scheduledRegion);
				if (result == null) result = caseVisitable(scheduledRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.STATUS_NODE: {
				StatusNode statusNode = (StatusNode)theEObject;
				T result = caseStatusNode(statusNode);
				if (result == null) result = caseNode(statusNode);
				if (result == null) result = caseElement(statusNode);
				if (result == null) result = caseConnectionEnd(statusNode);
				if (result == null) result = caseNameable(statusNode);
				if (result == null) result = caseVisitable(statusNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.SYMBOLABLE: {
				Symbolable symbolable = (Symbolable)theEObject;
				T result = caseSymbolable(symbolable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.TRUE_NODE: {
				TrueNode trueNode = (TrueNode)theEObject;
				T result = caseTrueNode(trueNode);
				if (result == null) result = caseNode(trueNode);
				if (result == null) result = caseElement(trueNode);
				if (result == null) result = caseConnectionEnd(trueNode);
				if (result == null) result = caseNameable(trueNode);
				if (result == null) result = caseVisitable(trueNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.UNKNOWN_NODE: {
				UnknownNode unknownNode = (UnknownNode)theEObject;
				T result = caseUnknownNode(unknownNode);
				if (result == null) result = caseNode(unknownNode);
				if (result == null) result = caseElement(unknownNode);
				if (result == null) result = caseConnectionEnd(unknownNode);
				if (result == null) result = caseNameable(unknownNode);
				if (result == null) result = caseVisitable(unknownNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTschedulePackage.VARIABLE_NODE: {
				VariableNode variableNode = (VariableNode)theEObject;
				T result = caseVariableNode(variableNode);
				if (result == null) result = caseNode(variableNode);
				if (result == null) result = caseElement(variableNode);
				if (result == null) result = caseConnectionEnd(variableNode);
				if (result == null) result = caseNameable(variableNode);
				if (result == null) result = caseVisitable(variableNode);
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
	 * Returns the result of interpreting the object as an instance of '<em>Status Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Status Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatusNode(StatusNode object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>True Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrueNode(TrueNode object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Null Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullNode(NullNode object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitable(Visitable object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
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
