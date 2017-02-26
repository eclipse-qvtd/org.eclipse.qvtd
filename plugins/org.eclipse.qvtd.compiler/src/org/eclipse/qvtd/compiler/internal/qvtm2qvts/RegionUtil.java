/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.ComposedNode;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.ErrorNode;
import org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.InputNode;
import org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge;
import org.eclipse.qvtd.pivot.qvtschedule.IteratorNode;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NullNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.TrueNode;
import org.eclipse.qvtd.pivot.qvtschedule.UnknownNode;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public class RegionUtil extends QVTscheduleUtil
{
	public static class Internal
	{
		public static @NonNull List<@NonNull Node> getHeadNodesList(@NonNull Region region) {
			return ClassUtil.nullFree(region.getHeadNodes());
		}
	}

	public static boolean containsNone(@NonNull Iterable<@NonNull Node> firstNodes, @NonNull Iterable<@NonNull Node> secondNodes) {
		for (@NonNull Node firstNode : firstNodes) {
			for (@NonNull Node secondNode : secondNodes) {
				if (firstNode == secondNode) {
					return false;
				}
			}
		}
		return true;
	}

	public static @NonNull NavigableEdge createCastEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		Role phase = mergeToLessKnownPhase(getNodeRole(sourceNode), getNodeRole(targetNode));
		assert phase != null;
		Role edgeRole = phase;
		CastEdge castEdge = QVTscheduleFactory.eINSTANCE.createCastEdge();
		castEdge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		castEdge.initializeProperty(source2targetProperty);
		return castEdge;
	}

	/**
	 * Create, install and return the edgeRole edge for source2targetProperty from sourceNode to targetNode. If
	 * source2targetProperty has an opposite, the opposite edge is also created and installed.
	 */
	public static @NonNull NavigableEdge createEdge(@NonNull Role edgeRole,
			@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		CastEdge castEdge = QVTscheduleFactory.eINSTANCE.createCastEdge();
		castEdge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		castEdge.initializeProperty(source2targetProperty);
		return castEdge;
	}



	public static @NonNull Node createComposingNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		Role nodeRole = Role.LOADED;
		ComposedNode node = QVTscheduleFactory.eINSTANCE.createComposedNode();
		node.initialize(nodeRole, region, name, classDatumAnalysis.getClassDatum());
		return node;
	}

	public static @NonNull Node createDataTypeNode(@NonNull Node sourceNode, @NonNull Property property) {
		Role nodeRole = getPatternNodeRole(sourceNode, property);
		return createPatternNode(nodeRole, sourceNode, property, sourceNode.isMatched() && isMatched(property));
	}

	public static @NonNull Node createDataTypeNode(@NonNull String name, @NonNull Node sourceNode, @NonNull NavigationCallExp navigationCallExp) {
		Property property = PivotUtil.getReferredProperty(navigationCallExp);
		boolean isMatched = sourceNode.isMatched() && isMatched(property);
		Role nodeRole = getPatternNodeRole(sourceNode, property);
		assert sourceNode.isClass() || (property.getOpposite() != null);	// FIXME review is this relevant?
		//		String name = property.getName();
		//		assert name != null;
		Region region = getOwningRegion(sourceNode);
		ScheduleManager scheduleManager = getScheduleManager(region);
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, scheduleManager.getClassDatum(navigationCallExp));
		node.setMatched(isMatched);
		node.addTypedElement(navigationCallExp);
		return node;
	}

	public static @NonNull Node createDataTypeNode(@NonNull Node targetNode, @NonNull NavigationAssignment navigationAssignment) {
		Role nodeRole = getNodeRole(targetNode);
		Property property = QVTcoreUtil.getTargetProperty(navigationAssignment);
		//		PatternNodeRole nodeRole = PatternNodeRole.getDataTypeNodeRole(targetNode, property);
		//		assert sourceNode.isClass();	// FIXME review is this relevant?
		String name = property.getName();
		assert name != null;
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
		assert type != null;
		TypedModel typedModel = getTypedModel(getClassDatumAnalysis(targetNode));
		Region region = getOwningRegion(targetNode);
		ScheduleManager scheduleManager = RegionUtil.getScheduleManager(region);
		ClassDatum classDatum = scheduleManager.getClassDatum(type, typedModel);
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(true);
		node.addTypedElement(property);
		return node;
	}

	public static @NonNull Node createDependencyClassNode(@NonNull Node parentNode, @NonNull NavigationAssignment navigationAssignment) {
		assert parentNode.isClass();
		ScheduleManager scheduleManager = RegionUtil.getScheduleManager(getOwningRegion(parentNode));
		Property property = QVTcoreUtil.getTargetProperty(navigationAssignment);
		assert property != null;
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
		assert type != null;
		TypedModel typedModel = getTypedModel(getClassDatumAnalysis(parentNode));
		ClassDatum classDatum = scheduleManager.getClassDatum(type, typedModel);
		//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
		ClassDatumAnalysis classDatumAnalysis = scheduleManager.getClassDatumAnalysis(classDatum);
		String name = property.getName();
		assert name != null;
		return createDependencyNode(RegionUtil.getOwningRegion(parentNode), name, classDatumAnalysis);
	}

	public static @NonNull Node createDependencyNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		Role nodeRole = Role.PREDICATED;
		DependencyNode node = QVTscheduleFactory.eINSTANCE.createDependencyNode();
		node.initialize(nodeRole, region, name, classDatumAnalysis.getClassDatum());
		return node;
	}

	public static @NonNull Node createErrorNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		Role nodeRole = Role.OTHER;
		ErrorNode node = QVTscheduleFactory.eINSTANCE.createErrorNode();
		node.initialize(nodeRole, region, name, classDatumAnalysis.getClassDatum());
		return node;
	}

	//
	//	equals edges seem to be a legacy relic. They are used to equate two nodes that have been carelessly created as distinct. The difficulties
	//	of ensuring that downstream code accommodates the duality far outweight the difficulties of creating a single node in the first place.
	//
	//	This method is not used by any tests, but one anticipated usage arises if a variable has multiple initializers,
	//	in which case a hard inkitializer such as an operation call is preferred, and then other initializers are
	//	checked as predicates using equals edges.
	//
	public static @NonNull Edge createEqualsEdge(@NonNull Node sourceNode, @NonNull Node targetNode) {
		return createExpressionEdge(sourceNode, QVTscheduleConstants.EQUALS_NAME, targetNode);
	}

	public static @NonNull Edge createExpressionEdge(@NonNull Node sourceNode, @NonNull String name, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		ExpressionEdge edge = QVTscheduleFactory.eINSTANCE.createExpressionEdge();
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public static @NonNull Node createInputNode(@NonNull Region region, @NonNull Role nodeRole, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		InputNode node = QVTscheduleFactory.eINSTANCE.createInputNode();
		node.initialize(nodeRole, region, name, classDatumAnalysis.getClassDatum());
		return node;
	}

	public static @NonNull Edge createIteratedEdge(@NonNull Node sourceNode, @NonNull String name,@NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		IteratedEdge edge = QVTscheduleFactory.eINSTANCE.createIteratedEdge();
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public static @NonNull VariableNode createIteratorNode(@NonNull Variable iterator, @NonNull Node sourceNode) {
		Region region = getOwningRegion(sourceNode);
		ScheduleManager scheduleManager = getScheduleManager(region);
		Role nodeRole = getNodeRole(sourceNode);
		IteratorNode node = QVTscheduleFactory.eINSTANCE.createIteratorNode();
		node.initialize(nodeRole, region, getName(iterator), scheduleManager.getClassDatum(iterator));
		node.initializeVariable(region, iterator);
		return node;
	}

	public static @NonNull VariableNode createLetVariableNode(@NonNull Variable letVariable, @NonNull Node inNode) {
		Region region = getOwningRegion(inNode);
		ScheduleManager scheduleManager = getScheduleManager(region);
		Role nodeRole = getNodeRole(inNode);
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, getName(letVariable), scheduleManager.getClassDatum(letVariable));
		node.initializeVariable(region, letVariable);
		node.setMatched(inNode.isMatched());
		return node;
	}

	public static @NonNull VariableNode createLoadedStepNode(@NonNull Region region, @NonNull VariableDeclaration stepVariable) {
		ScheduleManager scheduleManager = getScheduleManager(region);
		Role nodeRole = Role.LOADED;
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, getName(stepVariable), scheduleManager.getClassDatum(stepVariable));
		node.initializeVariable(region, stepVariable);
		node.setMatched(true);
		return node;
	}

	public static @NonNull NavigableEdge createNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		Role phase = mergeToLessKnownPhase(getNodeRole(sourceNode), getNodeRole(targetNode));
		assert phase != null;
		Role edgeRole = phase;
		NavigationEdge edge = QVTscheduleFactory.eINSTANCE.createNavigationEdge();
		edge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		edge.initializeProperty(source2targetProperty, isPartial);
		return edge;
	}

	public static @NonNull Node createNullNode(@NonNull Region region, boolean isMatched, @Nullable TypedElement typedElement) {
		ScheduleManager scheduleManager = getScheduleManager(region);
		Role nodeRole = Role.CONSTANT;
		ClassDatum classDatum;
		if (typedElement != null) {
			classDatum = scheduleManager.getClassDatum(typedElement);
		}
		else {
			classDatum = scheduleManager.getOclVoidClassDatumAnalysis().getClassDatum();
		}
		NullNode node = QVTscheduleFactory.eINSTANCE.createNullNode();
		node.initialize(nodeRole, region, "«null»", classDatum);
		node.setMatched(isMatched);
		if (typedElement != null) {
			node.addTypedElement(typedElement);
		}
		return node;
	}

	public static @NonNull VariableNode createOldNode(@NonNull Region region, @NonNull VariableDeclaration variable) {
		ScheduleManager scheduleManager = getScheduleManager(region);
		DomainUsage domainUsage = scheduleManager.getDomainUsage(variable);
		boolean isEnforceable = domainUsage.isOutput() || domainUsage.isMiddle();
		Role phase = isEnforceable ? Role.PREDICATED : Role.LOADED;
		Role nodeRole = phase;
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, getName(variable), scheduleManager.getClassDatum(variable));
		node.initializeVariable(region, variable);
		node.setMatched(true);
		return node;
	}

	public static @NonNull Node createOperationElementNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Node sourceNode) {
		Role nodeRole = getNodeRole(sourceNode);
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatumAnalysis.getClassDatum());
		node.setMatched(true);
		return node;
	}

	public static @NonNull Node createOperationNode(@NonNull Region region, boolean isMatched, @NonNull String name, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
		ScheduleManager scheduleManager = getScheduleManager(region);
		Role nodeRole = getOperationNodePhase(region, typedElement, argNodes);
		OperationNode node = QVTscheduleFactory.eINSTANCE.createOperationNode();
		node.initialize(nodeRole, region, name, scheduleManager.getClassDatum(typedElement));
		node.setMatched(isMatched);
		node.addTypedElement(typedElement);
		return node;
	}

	public static @NonNull Node createOperationParameterNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		Role nodeRole = Role.PREDICATED;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatumAnalysis.getClassDatum());
		node.setMatched(true);
		node.setHead();
		return node;
	}

	public static @NonNull Node createOperationResultNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Node sourceNode) {
		Role nodeRole = getNodeRole(sourceNode);
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatumAnalysis.getClassDatum());
		node.setMatched(false);
		return node;
	}

	public static @NonNull Node createPatternNode(@NonNull Role nodeRole, @NonNull Node sourceNode, @NonNull Property source2targetProperty, boolean isMatched) {
		Region region = getOwningRegion(sourceNode);
		assert sourceNode.isClass();
		ScheduleManager scheduleManager = getScheduleManager(region);
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)source2targetProperty.getType();
		assert type != null;
		Type elementType = PivotUtil.getElementalType(type);
		TypedModel typedModel = elementType instanceof DataType ? scheduleManager.getDomainAnalysis().getPrimitiveTypeModel() : sourceNode.getClassDatum().getReferredTypedModel();
		assert typedModel != null;
		ClassDatum classDatum = scheduleManager.getClassDatum(type, typedModel);
		String name = source2targetProperty.getName();
		assert name != null;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(isMatched);
		return node;
	}

	public static @NonNull Edge createPredicateEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		PredicateEdge edge = QVTscheduleFactory.eINSTANCE.createPredicateEdge();
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public static @NonNull Node createRealizedDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		Role nodeRole = Role.REALIZED;
		return createPatternNode(nodeRole, sourceNode, source2targetProperty, sourceNode.isMatched());
	}

	public static @NonNull Edge createRealizedExpressionEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		Role edgeRole = Role.REALIZED;
		ExpressionEdge edge = QVTscheduleFactory.eINSTANCE.createExpressionEdge();
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public static @NonNull NavigableEdge createRealizedNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		Role edgeRole = Role.REALIZED;
		NavigationEdge forwardEdge = QVTscheduleFactory.eINSTANCE.createNavigationEdge();
		forwardEdge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		forwardEdge.initializeProperty(source2targetProperty, isPartial);
		return forwardEdge;
	}

	public static @NonNull VariableNode createRealizedStepNode(@NonNull Region region, @NonNull Variable stepVariable) {
		ScheduleManager scheduleManager = getScheduleManager(region);
		Role nodeRole = Role.REALIZED;
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, getName(stepVariable), scheduleManager.getClassDatum(stepVariable));
		node.initializeVariable(region, stepVariable);
		node.setMatched(true);
		return node;
	}

	public static @NonNull Edge createRecursionEdge(@NonNull Node sourceNode, @NonNull Node targetNode, boolean isPrimary) {
		Role edgeRole = Role.OTHER;
		RecursionEdge edge = QVTscheduleFactory.eINSTANCE.createRecursionEdge();
		edge.initialize(edgeRole, sourceNode, null, targetNode);
		edge.setPrimary(isPrimary);
		return edge;
	}

	public static @NonNull RegionProblem createRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new RegionProblem(CompilerProblem.Severity.ERROR, region, boundMessage);
	}

	public static @NonNull RegionProblem createRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new RegionProblem(CompilerProblem.Severity.WARNING, region, boundMessage);
	}

	public static @NonNull Node createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode, boolean isMatched) {
		Region region = getOwningRegion(sourceNode);
		ScheduleManager scheduleManager = getScheduleManager(region);
		DomainUsage domainUsage = scheduleManager.getDomainUsage(callExp);
		boolean isMiddleOrOutput = domainUsage.isOutput() || domainUsage.isMiddle();
		boolean isDirty = false;
		if (callExp instanceof NavigationCallExp) {
			Property referredProperty = PivotUtil.getReferredProperty((NavigationCallExp)callExp);
			isDirty = scheduleManager.isDirty(referredProperty);
		}
		Role phase = sourceNode.isPredicated() || isMiddleOrOutput || isDirty ? Role.PREDICATED : Role.LOADED;
		Role stepNodeRole = phase;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(stepNodeRole, region, name, scheduleManager.getClassDatum(callExp));
		node.setMatched(isMatched);
		node.addTypedElement(callExp);
		return node;
	}

	public static @NonNull Node createStepNode(@NonNull Region region, @NonNull Node typedNode, boolean isMatched) {
		Role stepNodeRole = getNodeRole(typedNode);
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(stepNodeRole, region, getName(typedNode), getClassDatum(typedNode));
		node.setMatched(isMatched);
		return node;
	}

	public static @NonNull Node createTrueNode(@NonNull Region region) {
		ScheduleManager scheduleManager = getScheduleManager(region);
		org.eclipse.ocl.pivot.Class booleanType = scheduleManager.getStandardLibrary().getBooleanType();
		DomainUsage primitiveUsage = scheduleManager.getDomainAnalysis().getPrimitiveUsage();
		ClassDatumAnalysis classDatumAnalysis = scheduleManager.getClassDatumAnalysis(booleanType, ClassUtil.nonNullState(primitiveUsage.getTypedModel(null)));
		Role nodeRole = Role.CONSTANT;
		TrueNode node = QVTscheduleFactory.eINSTANCE.createTrueNode();
		node.initialize(nodeRole, region, "«true»", classDatumAnalysis.getClassDatum());
		node.setHead();
		return node;
	}

	public static @NonNull Node createUnknownNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement) {
		ScheduleManager scheduleManager = getScheduleManager(region);
		Role nodeRole = Role.OTHER;
		UnknownNode node = QVTscheduleFactory.eINSTANCE.createUnknownNode();
		node.initialize(nodeRole, region, name, scheduleManager.getClassDatum(typedElement));
		return node;
	}

	public static @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull Node node) {
		return ClassDatumAnalysis.get(node);
	}

	public static @NonNull CompleteClass getCompleteClass(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		return ClassUtil.nonNullState(classDatumAnalysis.getClassDatum().getCompleteClass());
	}

	public static @NonNull Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> getCompleteClass2Nodes(@NonNull Region region) {
		Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2nodes = new HashMap<>();
		for (@NonNull Node node : RegionUtil.getOwnedNodes(region)) {
			CompleteClass completeClass = node.getCompleteClass();
			List<@NonNull Node> mergedNodes = completeClass2nodes.get(completeClass);
			if (mergedNodes == null) {
				mergedNodes = new ArrayList<>();
				completeClass2nodes.put(completeClass, mergedNodes);
			}
			if (!mergedNodes.contains(node)) {
				mergedNodes.add(node);
			}
		}
		return completeClass2nodes;
	}

	public static @NonNull Iterable<@NonNull MappingRegion> getConsumingRegions(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		return ClassUtil.nullFree(classDatumAnalysis.getConsumingRegions());
	}

	public static @NonNull ClassDatum getElementalClassDatum(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		return ClassUtil.nonNullState(classDatumAnalysis.getElementalClassDatum());
	}

	public static @NonNull Role getOperationNodePhase(@NonNull Region region, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
		boolean isLoaded = false;
		boolean isPredicated = false;
		boolean isRealized = false;
		if (argNodes != null) {
			for (Node argNode : argNodes) {
				if (argNode.isRealized()) {
					isRealized = true;
				}
				else if (argNode.isPredicated()) {
					isPredicated = true;
				}
				else if (argNode.isLoaded()) {
					isLoaded = true;
				}
			}
		}
		if (typedElement instanceof OperationCallExp) {
			Operation asOperation = ((OperationCallExp)typedElement).getReferredOperation();
			if (QVTbaseUtil.isIdentification(asOperation)) {
				//				DomainUsage usage = getScheduleManager(region).getDomainUsage(typedElement);
				//				if (!usage.isInput()) {
				isRealized = true;
				//				}
			}
		}
		if (isRealized) {
			return Role.REALIZED;
		}
		else if (isPredicated) {
			return Role.PREDICATED;
		}
		else if (isLoaded) {
			return Role.LOADED;
		}
		else {
			return Role.CONSTANT;
		}
	}

	private static @NonNull Role getPatternNodeRole(@NonNull Node sourceNode, @NonNull Property property) {
		Role phase;
		switch (getNodeRole(sourceNode)) {
			case REALIZED: phase = Role.REALIZED; break;
			case PREDICATED: phase = Role.PREDICATED; break;
			case LOADED: {
				boolean isDirty = getScheduleManager(getOwningRegion(sourceNode)).isDirty(property);
				phase = isDirty ? Role.PREDICATED : Role.LOADED; break;
			}
			case CONSTANT: phase = Role.CONSTANT; break;
			default: throw new UnsupportedOperationException();
		}
		return phase;
	}

	public static @NonNull ScheduleManager getScheduleManager(@NonNull Region region) {
		return ScheduleManager.get(getScheduleModel(region));
	}

	public static @NonNull TypedModel getTypedModel(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		return ClassUtil.nonNullState(classDatumAnalysis.getClassDatum().getReferredTypedModel());
	}

	/**
	 * Return true if the elemental source type of thatEdge is compatible with the source type of thisEdge.
	 */
	public static boolean isElementallyConformantSource(@NonNull NavigableEdge thatEdge, @NonNull NavigableEdge thisEdge) {
		Node thatSource = thatEdge.getEdgeSource();
		CompleteClass thatType = ClassUtil.nonNullState(getClassDatumAnalysis(thatSource).getElementalClassDatum().getCompleteClass());
		CompleteClass thisType = ClassUtil.nonNullState(getClassDatumAnalysis(thisEdge.getEdgeSource()).getElementalClassDatum().getCompleteClass());
		if (thatType.conformsTo(thisType)) {
			return true;
		}
		if (thatSource.isRealized()) {
			return false;
		}
		if (thisType.conformsTo(thatType)) {
			return true;
		}
		return false;
	}

	public static boolean isMatched(@NonNull TypedElement typedElement) {
		boolean isMatched = false;
		Type type = typedElement.getType();
		if (type instanceof CollectionType) {
			//			IntegerValue lowerValue = ((CollectionType)type).getLowerValue();
			//			if (lowerValue.signum() > 0) {
			isMatched = true;
			assert typedElement.isIsRequired();
			//			}
		}
		else {
			isMatched = typedElement.isIsRequired();
		}
		if (!isMatched) {
			return false;
		}
		return isUnconditional(typedElement);
	}

	/*	public static boolean isRealizedIncludes(@NonNull Edge edge) {	// FIXME includes should be a pseudo-navigation edge
		if (!edge.isRealized()) {
			return false;
		}
		if (!edge.isComputation()) {
			return false;
		}
		return "«includes»".equals(edge.getName()) || "«includesAll»".equals(edge.getName());
	} */

	public static boolean isUnconditional(@NonNull TypedElement typedElement) {
		EObject eContainer = typedElement.eContainer();
		if (eContainer instanceof IfExp) {
			IfExp ifExp = (IfExp)eContainer;
			if ((typedElement == ifExp.getOwnedThen()) || (typedElement == ifExp.getOwnedElse())) {
				return false;
			}
		}
		else if (eContainer instanceof LoopExp) {
			LoopExp loopExp = (LoopExp)eContainer;
			if (typedElement == loopExp.getOwnedBody()) {
				return false;
			}
		}
		if (eContainer instanceof TypedElement) {
			return isUnconditional((TypedElement) eContainer);
		}
		return true;
	}

	public static boolean isUnconditional(@NonNull Edge edge) {
		for (@NonNull TypedElement typedElement : edge.getEdgeSource().getTypedElements()) {
			if (!isUnconditional(typedElement)) {
				return false;
			}
		}
		return true;
	}

	public static Node.@NonNull Utility mergeToStrongerUtility(Node.@NonNull Utility nodeUtility1, Node.@NonNull Utility nodeUtility2) {
		if ((nodeUtility1 == Node.Utility.STRONGLY_MATCHED) || (nodeUtility2 == Node.Utility.STRONGLY_MATCHED)) {
			return Node.Utility.STRONGLY_MATCHED;
		}
		else if ((nodeUtility1 == Node.Utility.WEAKLY_MATCHED) || (nodeUtility2 == Node.Utility.WEAKLY_MATCHED)) {
			return Node.Utility.WEAKLY_MATCHED;
		}
		else if ((nodeUtility1 == Node.Utility.CONDITIONAL) || (nodeUtility2 == Node.Utility.CONDITIONAL)) {
			return Node.Utility.CONDITIONAL;
		}
		else if ((nodeUtility1 == Node.Utility.DEPENDENCY) || (nodeUtility2 == Node.Utility.DEPENDENCY)) {
			return Node.Utility.DEPENDENCY;
		}
		else {
			return Node.Utility.DEAD;
		}
	}

	/**
	 * Return the variable name associated with oclExpression, or null if none found.
	 * This enables the user's choice of name to be used for the expression node that implements it.
	 */
	public static @Nullable String recoverVariableName(@NonNull NamedElement namedElement) {
		EObject eContainer = namedElement.eContainer();
		EReference eContainmentFeature = namedElement.eContainmentFeature();
		if ((eContainmentFeature == PivotPackage.Literals.VARIABLE__OWNED_INIT) && (eContainer instanceof Variable)) {
			return ((Variable)eContainer).getName();
		}
		else if ((eContainmentFeature == QVTcorePackage.Literals.ASSIGNMENT__VALUE) && (eContainer instanceof VariableAssignment)) {
			return ((VariableAssignment)eContainer).getTargetVariable().getName();
		}
		else if ((eContainmentFeature == PivotPackage.Literals.CALL_EXP__OWNED_SOURCE) && (eContainer instanceof OperationCallExp)) {
			OperationCallExp operationCallExp = (OperationCallExp)eContainer;
			if (PivotUtil.isSameOperation(operationCallExp.getReferredOperation().getOperationId(), OperationId.OCLANY_EQUALS)) {
				OCLExpression argument = PivotUtil.getOwnedArgument(operationCallExp, 0);
				if (argument instanceof VariableExp) {
					return PivotUtil.getReferredVariable((VariableExp)argument).getName();
				}
			}
		}
		else if ((eContainmentFeature == PivotPackage.Literals.OPERATION_CALL_EXP__OWNED_ARGUMENTS) && (eContainer instanceof OperationCallExp)) {
			OperationCallExp operationCallExp = (OperationCallExp)eContainer;
			if (PivotUtil.isSameOperation(operationCallExp.getReferredOperation().getOperationId(), OperationId.OCLANY_EQUALS)) {
				OCLExpression source = PivotUtil.getOwnedSource(operationCallExp);
				if (source instanceof VariableExp) {
					return PivotUtil.getReferredVariable((VariableExp)source).getName();
				}
			}
		}
		return null;
	}
}