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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.CastEdgeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.ComposedNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.DependencyNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.ErrorNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.ExpressionEdgeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.InputNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.IteratedEdgeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.IteratorNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.NavigationEdgeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.NullNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.OperationNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.PatternTypedNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.PatternVariableNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.PredicateEdgeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.RecursionEdgeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.TrueNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.UnknownNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.VariableNodeImpl;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeRole;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;
import org.eclipse.qvtd.pivot.qvtschedule.Phase;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public class RegionUtil extends QVTscheduleUtil
{
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
		Phase phase = mergeToLessKnownPhase(sourceNode.getNodeRole(), targetNode.getNodeRole()).getPhase();
		assert phase != null;
		EdgeRole edgeRole = getEdgeRole(phase);
		return CastEdgeImpl.createEdge(edgeRole, sourceNode, source2targetProperty, targetNode);
	}

	public static @NonNull Node createComposingNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		NodeRole nodeRole = getNodeRole(Phase.LOADED);
		return ComposedNodeImpl.create(nodeRole, region, name, classDatumAnalysis);
	}

	public static @NonNull Node createDataTypeNode(@NonNull Node sourceNode, @NonNull Property property) {
		NodeRole nodeRole = getPatternNodeRole(sourceNode, property);
		return createPatternNode(nodeRole, sourceNode, property, sourceNode.isMatched() && isMatched(property));
	}

	public static @NonNull Node createDataTypeNode(@NonNull Node sourceNode, @NonNull NavigationCallExp navigationCallExp) {
		Property property = PivotUtil.getReferredProperty(navigationCallExp);
		boolean isMatched = sourceNode.isMatched() && isMatched(property);
		NodeRole nodeRole = getPatternNodeRole(sourceNode, property);
		assert sourceNode.isClass() || (property.getOpposite() != null);	// FIXME review is this relevant?
		String name = property.getName();
		assert name != null;
		Region region = sourceNode.getRegion();
		Node node = PatternTypedNodeImpl.create(nodeRole, region, name, region.getClassDatumAnalysis(navigationCallExp), isMatched);
		node.addTypedElement(navigationCallExp);
		return node;
	}

	public static @NonNull Node createDataTypeNode(@NonNull Node targetNode, @NonNull NavigationAssignment navigationAssignment) {
		NodeRole nodeRole = targetNode.getNodeRole();
		Property property = QVTcoreUtil.getTargetProperty(navigationAssignment);
		//		PatternNodeRole nodeRole = PatternNodeRole.getDataTypeNodeRole(targetNode, property);
		//		assert sourceNode.isClass();	// FIXME review is this relevant?
		String name = property.getName();
		assert name != null;
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
		assert type != null;
		TypedModel typedModel = targetNode.getClassDatumAnalysis().getTypedModel();
		Region region = targetNode.getRegion();
		ClassDatum classDatum = region.getSchedulerConstants().getClassDatum(type, typedModel);
		//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
		ClassDatumAnalysis classDatumAnalysis = region.getSchedulerConstants().getClassDatumAnalysis(classDatum);
		Node node = PatternTypedNodeImpl.create(nodeRole, region, name, classDatumAnalysis, true);
		node.addTypedElement(property);
		return node;
	}

	public static @NonNull Node createDependencyClassNode(@NonNull Node parentNode, @NonNull NavigationAssignment navigationAssignment) {
		assert parentNode.isClass();
		SchedulerConstants schedulerConstants = parentNode.getRegion().getSchedulerConstants();
		Property property = QVTcoreUtil.getTargetProperty(navigationAssignment);
		assert property != null;
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
		assert type != null;
		TypedModel typedModel = parentNode.getClassDatumAnalysis().getTypedModel();
		ClassDatum classDatum = schedulerConstants.getClassDatum(type, typedModel);
		//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(classDatum);
		String name = property.getName();
		assert name != null;
		return createDependencyNode(parentNode.getRegion(), name, classDatumAnalysis);
	}

	public static @NonNull Node createDependencyNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		NodeRole nodeRole = getNodeRole(Phase.PREDICATED);
		return DependencyNodeImpl.create(nodeRole, region, name, classDatumAnalysis);
	}

	public static @NonNull Node createErrorNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		NodeRole nodeRole = getNodeRole(Phase.OTHER);
		return ErrorNodeImpl.create(nodeRole, region, name, classDatumAnalysis);
	}

	public static @NonNull Edge createExpressionEdge(@NonNull Node sourceNode, @NonNull String name, @NonNull Node targetNode) {
		EdgeRole edgeRole = getEdgeRole(getPhase(sourceNode.getNodeRole()));
		return ExpressionEdgeImpl.create(edgeRole, sourceNode, name, targetNode);
	}

	public static @NonNull Node createInputNode(@NonNull Region region, @NonNull Phase nodeRolePhase, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		NodeRole nodeRole = getNodeRole(nodeRolePhase);
		return InputNodeImpl.create(nodeRole, region, name, classDatumAnalysis);
	}

	public static @NonNull Edge createIteratedEdge(@NonNull Node sourceNode, @NonNull String name,@NonNull Node targetNode) {
		EdgeRole edgeRole = getEdgeRole(getPhase(sourceNode.getNodeRole()));
		return IteratedEdgeImpl.create(edgeRole, sourceNode, name, targetNode);
	}

	public static @NonNull VariableNodeImpl createIteratorNode(@NonNull Variable iterator, @NonNull Node sourceNode) {
		NodeRole nodeRole = getNodeRole(getPhase(sourceNode.getNodeRole()));
		return IteratorNodeImpl.create(nodeRole, sourceNode.getRegion(), iterator);
	}

	public static @NonNull VariableNodeImpl createLetVariableNode(@NonNull Variable letVariable, @NonNull Node inNode) {
		NodeRole nodeRole = getNodeRole(getPhase(inNode.getNodeRole()));
		return PatternVariableNodeImpl.create(nodeRole, inNode.getRegion(), letVariable, inNode.isMatched());
	}

	public static @NonNull VariableNodeImpl createLoadedStepNode(@NonNull Region region, @NonNull VariableDeclaration stepVariable) {
		NodeRole nodeRole = getNodeRole(Phase.LOADED);
		return PatternVariableNodeImpl.create(nodeRole, region, stepVariable, true);
	}

	public static @NonNull NavigableEdge createNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		Phase phase = mergeToLessKnownPhase(sourceNode.getNodeRole(), targetNode.getNodeRole()).getPhase();
		assert phase != null;
		EdgeRole edgeRole = getEdgeRole(phase);
		return NavigationEdgeImpl.createEdge(edgeRole, sourceNode, source2targetProperty, targetNode, isPartial);
	}

	public static @NonNull Node createNullNode(@NonNull Region region, boolean isMatched, @Nullable TypedElement typedElement) {
		NodeRole nodeRole = getNodeRole(Phase.CONSTANT);
		if (typedElement != null) {
			NullNodeImpl node = NullNodeImpl.create(nodeRole, region, "«null»", region.getClassDatumAnalysis(typedElement), isMatched);
			node.addTypedElement(typedElement);
			return node;
		}
		else {
			return NullNodeImpl.create(nodeRole, region, "«null»", region.getSchedulerConstants().getOclVoidClassDatumAnalysis(), isMatched);
		}
	}

	public static @NonNull VariableNodeImpl createOldNode(@NonNull Region region, @NonNull VariableDeclaration variable) {
		DomainUsage domainUsage = region.getSchedulerConstants().getDomainUsage(variable);
		boolean isEnforceable = domainUsage.isOutput() || domainUsage.isMiddle();
		Phase phase = isEnforceable ? Phase.PREDICATED : Phase.LOADED;
		NodeRole nodeRole = getNodeRole(phase);
		return PatternVariableNodeImpl.create(nodeRole, region, variable, true);
	}

	public static @NonNull Node createOperationElementNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Node sourceNode) {
		NodeRole nodeRole = getNodeRole(getPhase(sourceNode.getNodeRole()));
		return PatternTypedNodeImpl.create(nodeRole, region, name, classDatumAnalysis, true);
	}

	public static @NonNull Node createOperationNode(@NonNull Region region, boolean isMatched, @NonNull String name, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
		Phase nodePhase = getOperationNodePhase(region, typedElement, argNodes);
		NodeRole nodeRole = getNodeRole(nodePhase);
		Node node = OperationNodeImpl.create(nodeRole, region, name, region.getClassDatumAnalysis(typedElement), isMatched);
		node.addTypedElement(typedElement);
		return node;
	}

	public static @NonNull Node createOperationParameterNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		NodeRole nodeRole = getNodeRole(Phase.PREDICATED);
		Node node = PatternTypedNodeImpl.create(nodeRole, region, name, classDatumAnalysis, true);
		node.setHead();
		return node;
	}

	public static @NonNull Node createOperationResultNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Node sourceNode) {
		NodeRole nodeRole = getNodeRole(getPhase(sourceNode.getNodeRole()));
		return PatternTypedNodeImpl.create(nodeRole, region, name, classDatumAnalysis, false);
	}

	public static @NonNull Node createPatternNode(@NonNull NodeRole nodeRole, @NonNull Node sourceNode, @NonNull Property source2targetProperty, boolean isMatched) {
		Region region = sourceNode.getRegion();
		assert sourceNode.isClass();
		SchedulerConstants schedulerConstants = region.getSchedulerConstants();
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)source2targetProperty.getType();
		assert type != null;
		Type elementType = PivotUtil.getElementalType(type);
		TypedModel typedModel = elementType instanceof DataType ? schedulerConstants.getDomainAnalysis().getPrimitiveTypeModel() : sourceNode.getClassDatumAnalysis().getTypedModel();
		assert typedModel != null;
		ClassDatum classDatum = schedulerConstants.getClassDatum(type, typedModel);
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(classDatum);
		String name = source2targetProperty.getName();
		assert name != null;
		return PatternTypedNodeImpl.create(nodeRole, region, name, classDatumAnalysis, isMatched);
	}

	public static @NonNull Edge createPredicateEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		EdgeRole edgeRole = getEdgeRole(getPhase(sourceNode.getNodeRole()));
		return PredicateEdgeImpl.create(edgeRole, sourceNode, name, targetNode);
	}

	public static @NonNull Node createRealizedDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		NodeRole nodeRole = getNodeRole(Phase.REALIZED);
		return createPatternNode(nodeRole, sourceNode, source2targetProperty, sourceNode.isMatched());
	}

	public static @NonNull Edge createRealizedExpressionEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		EdgeRole edgeRole = getEdgeRole(Phase.REALIZED);
		return ExpressionEdgeImpl.create(edgeRole, sourceNode, name, targetNode);
	}

	public static @NonNull NavigableEdge createRealizedNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		EdgeRole edgeRole = getEdgeRole(Phase.REALIZED);
		return NavigationEdgeImpl.createEdge(edgeRole, sourceNode, source2targetProperty, targetNode, isPartial);
	}

	public static @NonNull VariableNodeImpl createRealizedStepNode(@NonNull Region region, @NonNull Variable stepVariable) {
		NodeRole nodeRole = getNodeRole(Phase.REALIZED);
		return PatternVariableNodeImpl.create(nodeRole, region, stepVariable, true);
	}

	public static @NonNull Edge createRecursionEdge(@NonNull Node sourceNode, @NonNull Node targetNode, boolean isPrimary) {
		EdgeRole edgeRole = getEdgeRole(Phase.OTHER);
		return RecursionEdgeImpl.create(edgeRole, sourceNode, targetNode, isPrimary);
	}

	public static @NonNull Node createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode, boolean isMatched) {
		Region region = sourceNode.getRegion();
		DomainUsage domainUsage = region.getSchedulerConstants().getDomainUsage(callExp);
		boolean isMiddleOrOutput = domainUsage.isOutput() || domainUsage.isMiddle();
		boolean isDirty = false;
		if (callExp instanceof NavigationCallExp) {
			Property referredProperty = PivotUtil.getReferredProperty((NavigationCallExp)callExp);
			isDirty = region.getSchedulerConstants().isDirty(referredProperty);
		}
		Phase phase = sourceNode.isPredicated() || isMiddleOrOutput || isDirty ? Phase.PREDICATED : Phase.LOADED;
		NodeRole stepNodeRole = getNodeRole(phase);
		Node node = PatternTypedNodeImpl.create(stepNodeRole, region, name, region.getClassDatumAnalysis(callExp), isMatched);
		node.addTypedElement(callExp);
		return node;
	}

	public static @NonNull Node createStepNode(@NonNull Region region, @NonNull Node typedNode, boolean isMatched) {
		NodeRole stepNodeRole = typedNode.getNodeRole();
		return PatternTypedNodeImpl.create(stepNodeRole, region, typedNode.getName(), typedNode.getClassDatumAnalysis(), isMatched);
	}

	public static @NonNull Node createTrueNode(@NonNull Region region) {
		SchedulerConstants schedulerConstants = region.getSchedulerConstants();
		org.eclipse.ocl.pivot.Class booleanType = schedulerConstants.getStandardLibrary().getBooleanType();
		DomainUsage primitiveUsage = schedulerConstants.getDomainAnalysis().getPrimitiveUsage();
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(booleanType, ClassUtil.nonNullState(primitiveUsage.getTypedModel(null)));
		NodeRole nodeRole = getNodeRole(Phase.CONSTANT);
		Node node = TrueNodeImpl.create(nodeRole, region, "«true»", classDatumAnalysis);
		node.setHead();
		return node;
	}

	public static @NonNull Node createUnknownNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement) {
		NodeRole nodeRole = getNodeRole(Phase.OTHER);
		return UnknownNodeImpl.create(nodeRole, region, name, region.getClassDatumAnalysis(typedElement));
	}

	/**
	 * Return the edge unless it is subject to a cast chain in which case return the final cast.
	 */
	public static @NonNull NavigableEdge getCastTarget(@NonNull NavigableEdge edge) {
		@NonNull NavigableEdge sourceEdge = edge;
		while (true) {
			@Nullable NavigableEdge targetEdge = null;
			for (@NonNull Edge nextEdge : sourceEdge.getEdgeTarget().getOutgoingEdges()) {
				if (nextEdge.isRecursion()) {
					continue;
				}
				if (!nextEdge.isCast()) {
					return sourceEdge;
				}
				if (targetEdge != null) {			// FIXME multi-cast support
					return sourceEdge;
				}
				targetEdge = (NavigableEdge) nextEdge;
			}
			if (targetEdge == null) {
				return sourceEdge;
			}
			sourceEdge = targetEdge;
		}
	}

	/**
	 * Return the node unless it is subject to a cast chain in which case return the final cast.
	 */
	public static @NonNull Node getCastTarget(@NonNull Node node) {
		@NonNull Node sourceNode = node;
		while (true) {
			@Nullable Node targetNode = null;
			for (@NonNull Edge edge : sourceNode.getOutgoingEdges()) {
				if (edge.isRecursion() || edge.isSecondary()) {
					continue;
				}
				if (!edge.isCast()) {
					return sourceNode;
				}
				if (targetNode != null) {			// FIXME multi-cast support
					return sourceNode;
				}
				targetNode = edge.getEdgeTarget();
			}
			if (targetNode == null) {
				return sourceNode;
			}
			sourceNode = targetNode;
		}
	}

	/**
	 * Return all nodes to which node is transitively cast or just node in the total absence of casts.
	 * If includeUsedIntermediates is set, cast edge inputs that are used by non-cast edges are also returned.
	 */
	public static @NonNull Iterable<@NonNull Node> getCastTargets(@NonNull Node node, boolean includeUsedIntermediates) {
		for (@NonNull Edge edge : node.getOutgoingEdges()) {
			if (edge.isRecursion() || edge.isSecondary()) {
				continue;
			}
			else if (edge.isCast()) {
				Set<@NonNull Node> castTargets = new HashSet<>();
				getCastTargets(node, includeUsedIntermediates, new HashSet<>(), castTargets);
				return castTargets;
			}
		}
		return Collections.singletonList(node);
	}
	private static void getCastTargets(@NonNull Node sourceNode, boolean includeUsedIntermediates, @NonNull Set<@NonNull Node> castSources, @NonNull Set<@NonNull Node> castTargets) {
		if (castSources.add(sourceNode)) {
			boolean hasCast = false;
			for (@NonNull Edge edge : sourceNode.getOutgoingEdges()) {
				if (edge.isRecursion() || edge.isSecondary()) {
					continue;
				}
				else if (edge.isCast()) {
					hasCast = true;
					getCastTargets(edge.getEdgeTarget(), includeUsedIntermediates, castSources, castTargets);
				}
				else if (includeUsedIntermediates) {
					castTargets.add(sourceNode);
				}
			}
			if (!hasCast) {
				castTargets.add(sourceNode);
			}
		}
	}

	public static @NonNull Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> getCompleteClass2Nodes(@NonNull Region region) {
		Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2nodes = new HashMap<>();
		for (@NonNull Node node : region.getNodes()) {
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

	public static @NonNull Phase getOperationNodePhase(@NonNull Region region, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
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
				DomainUsage usage = region.getSchedulerConstants().getDomainUsage(typedElement);
				if (!usage.isInput()) {
					isRealized = true;
				}
			}
		}
		if (isRealized) {
			return Phase.REALIZED;
		}
		else if (isPredicated) {
			return Phase.PREDICATED;
		}
		else if (isLoaded) {
			return Phase.LOADED;
		}
		else {
			return Phase.CONSTANT;
		}
	}

	private static @NonNull NodeRole getPatternNodeRole(@NonNull Node sourceNode, @NonNull Property property) {
		Phase phase;
		switch (sourceNode.getNodeRole().getPhase()) {
			case REALIZED: phase = Phase.REALIZED; break;
			case PREDICATED: phase = Phase.PREDICATED; break;
			case LOADED: {
				boolean isDirty = sourceNode.getRegion().getSchedulerConstants().isDirty(property);
				phase = isDirty ? Phase.PREDICATED : Phase.LOADED; break;
			}
			case CONSTANT: phase = Phase.CONSTANT; break;
			default: throw new UnsupportedOperationException();
		}
		return getNodeRole(phase);
	}

	/**
	 * Return true if the target of thatEdge is compatible with the target of thisEdge.
	 */
	public static boolean isConformantTarget(@NonNull NavigableEdge thatEdge, @NonNull NavigableEdge thisEdge) {
		Node thatTarget = getCastTarget(thatEdge.getEdgeTarget());
		Node thisTarget = getCastTarget(thisEdge.getEdgeTarget());
		CompleteClass thatType = thatTarget.getCompleteClass();
		CompleteClass thisType = thisTarget.getCompleteClass();
		if (thatType.conformsTo(thisType)) {
			return true;
		}
		if (thatTarget.isRealized()) {
			return false;
		}
		if (thisType.conformsTo(thatType)) {
			return true;
		}
		return false;
	}

	/**
	 * Return true if the elemental source type of thatEdge is compatible with the source type of thisEdge.
	 */
	public static boolean isElementallyConformantSource(@NonNull NavigableEdge thatEdge, @NonNull NavigableEdge thisEdge) {
		Node thatSource = thatEdge.getEdgeSource();
		CompleteClass thatType = ClassUtil.nonNullState(thatSource.getClassDatumAnalysis().getElementalClassDatum().getCompleteClass());
		CompleteClass thisType = ClassUtil.nonNullState(thisEdge.getEdgeSource().getClassDatumAnalysis().getElementalClassDatum().getCompleteClass());
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
}