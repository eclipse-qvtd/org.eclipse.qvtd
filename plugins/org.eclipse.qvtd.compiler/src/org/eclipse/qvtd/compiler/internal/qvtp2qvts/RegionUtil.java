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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.CastEdgeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.ComposedNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.DependencyNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.EdgeRoleImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.ErrorNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.ExpressionEdgeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.InputNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.IteratedEdgeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.IteratorNodeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.NavigationEdgeImpl;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl.NodeRoleImpl;
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
import org.eclipse.qvtd.pivot.schedule.ClassDatum;

public class RegionUtil
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
		EdgeRole.Phase phase = mergeToLessKnownPhase(sourceNode.getNodeRole(), targetNode.getNodeRole()).getPhase();
		EdgeRole edgeRole = EdgeRoleImpl.getEdgeRole(phase);
		return CastEdgeImpl.createEdge(edgeRole, sourceNode, source2targetProperty, targetNode);
	}

	public static @NonNull Node createComposingNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(Role.Phase.LOADED);
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
		assert sourceNode.isClass();
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
		//		assert sourceNode.isClass();
		String name = property.getName();
		assert name != null;
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
		assert type != null;
		TypedModel typedModel = targetNode.getClassDatumAnalysis().getTypedModel();
		Region region = targetNode.getRegion();
		ClassDatum classDatum = region.getSchedulerConstants().getClassDatum(type, typedModel);
		//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
		ClassDatumAnalysis classDatumAnalysis = region.getSchedulerConstants().getClassDatumAnalysis(classDatum);
		return PatternTypedNodeImpl.create(nodeRole, region, name, classDatumAnalysis, true);
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
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(Role.Phase.PREDICATED);
		return DependencyNodeImpl.create(nodeRole, region, name, classDatumAnalysis);
	}

	public static @NonNull Node createErrorNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(Role.Phase.OTHER);
		return ErrorNodeImpl.create(nodeRole, region, name, classDatumAnalysis);
	}

	public static @NonNull Edge createExpressionEdge(@NonNull Node sourceNode, @NonNull String name, @NonNull Node targetNode) {
		EdgeRole edgeRole = EdgeRoleImpl.getEdgeRole(sourceNode.getNodeRole().getPhase());
		return ExpressionEdgeImpl.create(edgeRole, sourceNode, name, targetNode);
	}

	public static @NonNull Node createInputNode(@NonNull Region region, NodeRole.@NonNull Phase nodeRolePhase, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(nodeRolePhase);
		return InputNodeImpl.create(nodeRole, region, name, classDatumAnalysis);
	}

	public static @NonNull Edge createIteratedEdge(@NonNull Node sourceNode, @NonNull String name,@NonNull Node targetNode) {
		EdgeRole edgeRole = EdgeRoleImpl.getEdgeRole(sourceNode.getNodeRole().getPhase());
		return IteratedEdgeImpl.create(edgeRole, sourceNode, name, targetNode);
	}

	public static @NonNull VariableNodeImpl createIteratorNode(@NonNull Variable iterator, @NonNull Node sourceNode) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(sourceNode.getNodeRole().getPhase());
		return IteratorNodeImpl.create(nodeRole, sourceNode.getRegion(), iterator);
	}

	public static @NonNull VariableNodeImpl createLetVariableNode(@NonNull Variable letVariable, @NonNull Node inNode) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(inNode.getNodeRole().getPhase());
		return PatternVariableNodeImpl.create(nodeRole, inNode.getRegion(), letVariable, inNode.isMatched());
	}

	public static @NonNull VariableNodeImpl createLoadedStepNode(@NonNull Region region, @NonNull VariableDeclaration stepVariable) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(Role.Phase.LOADED);
		return PatternVariableNodeImpl.create(nodeRole, region, stepVariable, true);
	}

	public static @NonNull NavigableEdge createNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		EdgeRole.Phase phase = mergeToLessKnownPhase(sourceNode.getNodeRole(), targetNode.getNodeRole()).getPhase();
		EdgeRole edgeRole = EdgeRoleImpl.getEdgeRole(phase);
		return NavigationEdgeImpl.createEdge(edgeRole, sourceNode, source2targetProperty, targetNode);
	}

	public static @NonNull Node createNullNode(@NonNull Region region, boolean isMatched, @Nullable TypedElement typedElement) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(Role.Phase.CONSTANT);
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
		Role.Phase phase = isEnforceable ? Role.Phase.PREDICATED : Role.Phase.LOADED;
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(phase);
		return PatternVariableNodeImpl.create(nodeRole, region, variable, true);
	}

	public static @NonNull Node createOperationElementNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Node sourceNode) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(sourceNode.getNodeRole().getPhase());
		return PatternTypedNodeImpl.create(nodeRole, region, name, classDatumAnalysis, true);
	}

	public static @NonNull Node createOperationNode(@NonNull Region region, boolean isMatched, @NonNull String name, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
		Role.Phase nodePhase = getOperationNodePhase(region, typedElement, argNodes);
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(nodePhase);
		Node node = OperationNodeImpl.create(nodeRole, region, name, region.getClassDatumAnalysis(typedElement), isMatched);
		node.addTypedElement(typedElement);
		return node;
	}

	public static @NonNull Node createOperationParameterNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(Role.Phase.PREDICATED);
		Node node = PatternTypedNodeImpl.create(nodeRole, region, name, classDatumAnalysis, true);
		node.setHead();
		return node;
	}

	public static @NonNull Node createOperationResultNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Node sourceNode) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(sourceNode.getNodeRole().getPhase());
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
		EdgeRole edgeRole = EdgeRoleImpl.getEdgeRole(sourceNode.getNodeRole().getPhase());
		return PredicateEdgeImpl.create(edgeRole, sourceNode, name, targetNode);
	}

	public static @NonNull Node createRealizedDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(Role.Phase.REALIZED);
		return createPatternNode(nodeRole, sourceNode, source2targetProperty, sourceNode.isMatched());
	}

	public static @NonNull Edge createRealizedExpressionEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		EdgeRole edgeRole = EdgeRoleImpl.getEdgeRole(Role.Phase.REALIZED);
		return ExpressionEdgeImpl.create(edgeRole, sourceNode, name, targetNode);
	}

	public static @NonNull NavigableEdge createRealizedNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		EdgeRole edgeRole = EdgeRoleImpl.getEdgeRole(Role.Phase.REALIZED);
		return NavigationEdgeImpl.createEdge(edgeRole, sourceNode, source2targetProperty, targetNode);
	}

	public static @NonNull VariableNodeImpl createRealizedStepNode(@NonNull Region region, @NonNull Variable stepVariable) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(Role.Phase.REALIZED);
		return PatternVariableNodeImpl.create(nodeRole, region, stepVariable, true);
	}

	public static @NonNull Edge createRecursionEdge(@NonNull Node sourceNode, @NonNull Node targetNode, boolean isPrimary) {
		EdgeRole edgeRole = EdgeRoleImpl.getEdgeRole(Role.Phase.OTHER);
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
		Role.Phase phase = sourceNode.isPredicated() || isMiddleOrOutput || isDirty ? Role.Phase.PREDICATED : Role.Phase.LOADED;
		NodeRole stepNodeRole = NodeRoleImpl.getNodeRole(phase);
		Node node = PatternTypedNodeImpl.create(stepNodeRole, region, name, region.getClassDatumAnalysis(callExp), isMatched);
		node.addTypedElement(callExp);
		return node;
	}

	public static @NonNull Node createStepNode(@NonNull Region region, @NonNull Node typedNode, boolean isMatched) {
		NodeRole stepNodeRole = NodeRoleImpl.getNodeRole(Role.Phase.PREDICATED);
		return PatternTypedNodeImpl.create(stepNodeRole, region, typedNode.getName(), typedNode.getClassDatumAnalysis(), isMatched);
	}

	public static @NonNull Node createTrueNode(@NonNull Region region) {
		SchedulerConstants schedulerConstants = region.getSchedulerConstants();
		org.eclipse.ocl.pivot.Class booleanType = schedulerConstants.getStandardLibrary().getBooleanType();
		DomainUsage primitiveUsage = schedulerConstants.getDomainAnalysis().getPrimitiveUsage();
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(booleanType, ClassUtil.nonNullState(primitiveUsage.getTypedModel(null)));
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(Role.Phase.CONSTANT);
		Node node = TrueNodeImpl.create(nodeRole, region, "«true»", classDatumAnalysis);
		node.setHead();
		return node;
	}

	public static @NonNull Node createUnknownNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement) {
		NodeRole nodeRole = NodeRoleImpl.getNodeRole(Role.Phase.OTHER);
		return UnknownNodeImpl.create(nodeRole, region, name, region.getClassDatumAnalysis(typedElement));
	}

	/**
	 * Return the edge unless it is subject to a cast chain in which case return the final cast.
	 */
	public static @NonNull NavigableEdge getCastTarget(@NonNull NavigableEdge edge) {
		@NonNull NavigableEdge sourceEdge = edge;
		while (true) {
			@Nullable NavigableEdge targetEdge = null;
			for (@NonNull Edge nextEdge : sourceEdge.getTarget().getOutgoingEdges()) {
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
				targetNode = edge.getTarget();
			}
			if (targetNode == null) {
				return sourceNode;
			}
			sourceNode = targetNode;
		}
	}

	public static Role.@NonNull Phase getOperationNodePhase(@NonNull Region region, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
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
			return Role.Phase.REALIZED;
		}
		else if (isPredicated) {
			return Role.Phase.PREDICATED;
		}
		else if (isLoaded) {
			return Role.Phase.LOADED;
		}
		else {
			return Role.Phase.CONSTANT;
		}
	}

	private static @NonNull NodeRole getPatternNodeRole(@NonNull Node sourceNode, @NonNull Property property) {
		Role.Phase phase;
		switch (sourceNode.getNodeRole().getPhase()) {
			case REALIZED: phase = Role.Phase.REALIZED; break;
			case PREDICATED: phase = Role.Phase.PREDICATED; break;
			case LOADED: {
				boolean isDirty = sourceNode.getRegion().getSchedulerConstants().isDirty(property);
				phase = isDirty ? Role.Phase.PREDICATED : Role.Phase.LOADED; break;
			}
			case CONSTANT: phase = Role.Phase.CONSTANT; break;
			default: throw new UnsupportedOperationException();
		}
		return NodeRoleImpl.getNodeRole(phase);
	}

	/**
	 * Return true if the source of thatEdge is compatible with the source of thisEdge.
	 */
	public static boolean isConformantSource(@NonNull NavigableEdge thatEdge, @NonNull NavigableEdge thisEdge) {
		Node thatSource = thatEdge.getSource();
		CompleteClass thatType = thatSource.getCompleteClass();
		CompleteClass thisType = thisEdge.getSource().getCompleteClass();
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

	/**
	 * Return true if the target of thatEdge is compatible with the target of thisEdge.
	 */
	public static boolean isConformantTarget(@NonNull NavigableEdge thatEdge, @NonNull NavigableEdge thisEdge) {
		Node thatTarget = getCastTarget(thatEdge.getTarget());
		Node thisTarget = getCastTarget(thisEdge.getTarget());
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
		for (@NonNull TypedElement typedElement : edge.getSource().getTypedElements()) {
			if (!isUnconditional(typedElement)) {
				return false;
			}
		}
		return true;
	}

	public static <@NonNull R extends Role> R mergeToLessKnownPhase(R firstRole, R secondRole) {
		if (firstRole.isRealized()) {
			return firstRole;
		}
		else if (secondRole.isRealized()) {
			return secondRole;
		}
		else if (firstRole.isPredicated()){
			return firstRole;
		}
		else if (secondRole.isPredicated()){
			return secondRole;
		}
		else if (firstRole.isLoaded()) {
			return firstRole;
		}
		else if (secondRole.isLoaded()) {
			return secondRole;
		}
		else if (firstRole.isConstant()) {
			return firstRole;
		}
		else if (secondRole.isConstant()) {
			return secondRole;
		}
		throw new UnsupportedOperationException();
	}

	public static <@NonNull R extends Role> R mergeToMoreKnownPhase(@NonNull R firstRole, @NonNull R secondRole) {
		if (firstRole.isConstant()) {
			return firstRole;
		}
		else if (secondRole.isConstant()) {
			return secondRole;
		}
		else if (firstRole.isLoaded()) {
			return firstRole;
		}
		else if (secondRole.isLoaded()) {
			return secondRole;
		}
		else if (firstRole.isRealized()) {
			return firstRole;
		}
		else if (secondRole.isRealized()) {
			return secondRole;
		}
		else if (firstRole.isPredicated()){
			return firstRole;
		}
		else if (secondRole.isPredicated()){
			return secondRole;
		}
		throw new UnsupportedOperationException();
	}
}