/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
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
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NullNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.StatusNode;
import org.eclipse.qvtd.pivot.qvtschedule.TrueNode;
import org.eclipse.qvtd.pivot.qvtschedule.UnknownNode;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A RegionHelper provides stateless utility methods, mostly construction, for use within a Region
 * supervised by a ScheduleManager.
 */
public class RegionHelper extends QVTscheduleUtil
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull Region region;

	public RegionHelper(@NonNull ScheduleManager scheduleManager, @NonNull Region region) {
		this.scheduleManager = scheduleManager;
		this.region = region;
	}

	public @NonNull NavigableEdge createCastEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		Role phase = mergeToLessKnownPhase(getNodeRole(sourceNode), getNodeRole(targetNode));
		Role edgeRole = phase;
		CastEdge castEdge = QVTscheduleFactory.eINSTANCE.createCastEdge();
		castEdge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		castEdge.initializeProperty(source2targetProperty);
		return castEdge;
	}

	public @NonNull Node createComposingNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		Role nodeRole = Role.LOADED;
		ComposedNode node = QVTscheduleFactory.eINSTANCE.createComposedNode();
		node.initialize(nodeRole, region, name, classDatum);
		return node;
	}

	public @NonNull Node createDataTypeNode(@NonNull String name, @NonNull Node sourceNode, @NonNull NavigationCallExp navigationCallExp) {
		Property property = PivotUtil.getReferredProperty(navigationCallExp);
		boolean isMatched = sourceNode.isMatched() && isMatched(property);
		Role nodeRole = getPatternNodeRole(sourceNode, property);
		assert sourceNode.isClass() || (property.getOpposite() != null);	// FIXME review is this relevant?
		//		String name = property.getName();
		//		assert name != null;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, scheduleManager.getClassDatum(navigationCallExp));
		node.setMatched(isMatched);
		node.addTypedElement(navigationCallExp);
		return node;
	}

	public @NonNull Node createDataTypeNode(@NonNull Node targetNode, @NonNull NavigationAssignment navigationAssignment) {
		Role nodeRole = getNodeRole(targetNode);
		Property property = QVTcoreUtil.getTargetProperty(navigationAssignment);
		//		PatternNodeRole nodeRole = PatternNodeRole.getDataTypeNodeRole(targetNode, property);
		//		assert sourceNode.isClass();	// FIXME review is this relevant?
		String name = property.getName();
		assert name != null;
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
		assert type != null;
		TypedModel typedModel = getTypedModel(getClassDatum(targetNode));
		ClassDatum classDatum = scheduleManager.getClassDatum(typedModel, type);
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(true);
		node.addTypedElement(property);
		return node;
	}

	public @NonNull Node createDataTypeNode(@NonNull Node sourceNode, @NonNull Property property) {
		Role nodeRole = getPatternNodeRole(sourceNode, property);
		return createPatternNode(nodeRole, sourceNode, property, sourceNode.isMatched() && isMatched(property));
	}

	public @NonNull Node createDependencyClassNode(@NonNull Node parentNode, @NonNull NavigationAssignment navigationAssignment) {
		assert parentNode.isClass();
		Property property = QVTcoreUtil.getTargetProperty(navigationAssignment);
		assert property != null;
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)property.getType();
		assert type != null;
		TypedModel typedModel = getTypedModel(getClassDatum(parentNode));
		ClassDatum classDatum = scheduleManager.getClassDatum(typedModel, type);
		//				DomainUsage domainUsage = parentNode.getClassDatumAnalysis().getDomainUsage();
		String name = property.getName();
		assert name != null;
		return createDependencyNode(name, classDatum);
	}

	public @NonNull Node createDependencyNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		Role nodeRole = Role.PREDICATED;
		DependencyNode node = QVTscheduleFactory.eINSTANCE.createDependencyNode();
		node.initialize(nodeRole, region, name, classDatum);
		return node;
	}

	/**
	 * Create, install and return the edgeRole edge for source2targetProperty from sourceNode to targetNode. If
	 * source2targetProperty has an opposite, the opposite edge is also created and installed.
	 *
	public @NonNull NavigableEdge createEdge(@NonNull Role edgeRole,
			@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		CastEdge castEdge = QVTscheduleFactory.eINSTANCE.createCastEdge();
		castEdge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		castEdge.initializeProperty(source2targetProperty);
		return castEdge;
	} */

	//
	//	equals edges seem to be a legacy relic. They are used to equate two nodes that have been carelessly created as distinct. The difficulties
	//	of ensuring that downstream code accommodates the duality far outweight the difficulties of creating a single node in the first place.
	//
	//	This method is not used by any tests, but one anticipated usage arises if a variable has multiple initializers,
	//	in which case a hard inkitializer such as an operation call is preferred, and then other initializers are
	//	checked as predicates using equals edges.
	//
	public @NonNull Edge createEqualsEdge(@NonNull Node sourceNode, @NonNull Node targetNode) {
		System.err.println("Unexpected " + QVTscheduleConstants.EQUALS_NAME + " edge from " + sourceNode + " to " + targetNode);
		return createExpressionEdge(sourceNode, QVTscheduleConstants.EQUALS_NAME, targetNode);
	}

	public @NonNull Node createErrorNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		Role nodeRole = Role.OTHER;
		ErrorNode node = QVTscheduleFactory.eINSTANCE.createErrorNode();
		node.initialize(nodeRole, region, name, classDatum);
		return node;
	}

	public @NonNull Edge createExpressionEdge(@NonNull Node sourceNode, @NonNull String name, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		ExpressionEdge edge = QVTscheduleFactory.eINSTANCE.createExpressionEdge();
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull Node createInputNode(@NonNull Role nodeRole, @NonNull String name, @NonNull ClassDatum classDatum) {
		InputNode node = QVTscheduleFactory.eINSTANCE.createInputNode();
		node.initialize(nodeRole, region, name, classDatum);
		return node;
	}

	public @NonNull Edge createIteratedEdge(@NonNull Node sourceNode, @NonNull String name, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		IteratedEdge edge = QVTscheduleFactory.eINSTANCE.createIteratedEdge();
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull VariableNode createIteratorNode(@NonNull Variable iterator, @NonNull Node sourceNode) {
		Role nodeRole = getNodeRole(sourceNode);
		IteratorNode node = QVTscheduleFactory.eINSTANCE.createIteratorNode();
		node.initialize(nodeRole, region, getName(iterator), scheduleManager.getClassDatum(iterator));
		node.initializeVariable(region, iterator);
		return node;
	}

	public @NonNull VariableNode createLetVariableNode(@NonNull Variable letVariable, @NonNull Node inNode) {
		Role nodeRole = getNodeRole(inNode);
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, getName(letVariable), scheduleManager.getClassDatum(letVariable));
		node.initializeVariable(region, letVariable);
		node.setMatched(inNode.isMatched());
		return node;
	}

	public @NonNull VariableNode createLoadedStepNode(@NonNull VariableDeclaration stepVariable) {
		Role nodeRole = Role.LOADED;
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, getName(stepVariable), scheduleManager.getClassDatum(stepVariable));
		node.initializeVariable(region, stepVariable);
		node.setMatched(true);
		return node;
	}

	public @NonNull NavigableEdge createNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		Role phase = mergeToLessKnownPhase(getNodeRole(sourceNode), getNodeRole(targetNode));
		Role edgeRole = phase;
		NavigationEdge edge = QVTscheduleFactory.eINSTANCE.createNavigationEdge();
		edge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		edge.initializeProperty(source2targetProperty, isPartial);
		return edge;
	}

	public @NonNull Node createNullNode(boolean isMatched, @Nullable TypedElement typedElement) {
		Role nodeRole = Role.CONSTANT;
		ClassDatum classDatum;
		if (typedElement != null) {
			classDatum = scheduleManager.getClassDatum(typedElement);
		}
		else {
			classDatum = scheduleManager.getOclVoidClassDatum();
		}
		NullNode node = QVTscheduleFactory.eINSTANCE.createNullNode();
		node.initialize(nodeRole, region, "«null»", classDatum);
		node.setMatched(isMatched);
		if (typedElement != null) {
			node.addTypedElement(typedElement);
		}
		return node;
	}

	public @NonNull VariableNode createOldNode(@NonNull VariableDeclaration variable) {
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

	public @NonNull Node createOperationElementNode(@NonNull String name, @NonNull ClassDatum classDatum, @NonNull Node sourceNode) {
		Role nodeRole = getNodeRole(sourceNode);
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(true);
		return node;
	}

	public @NonNull Node createOperationNode(boolean isMatched, @NonNull String name, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
		Role nodeRole = getOperationNodePhase(region, typedElement, argNodes);
		OperationNode node = QVTscheduleFactory.eINSTANCE.createOperationNode();
		node.initialize(nodeRole, region, name, scheduleManager.getClassDatum(typedElement));
		node.setMatched(isMatched);
		node.addTypedElement(typedElement);
		return node;
	}

	public @NonNull Node createOperationParameterNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		Role nodeRole = Role.PREDICATED;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(true);
		node.setHead();
		return node;
	}

	public @NonNull Node createOperationResultNode(@NonNull String name, @NonNull ClassDatum classDatum, @NonNull Node sourceNode) {
		Role nodeRole = getNodeRole(sourceNode);
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(false);
		return node;
	}

	public @NonNull Node createPatternNode(@NonNull Role nodeRole, @NonNull Node sourceNode, @NonNull Property source2targetProperty, boolean isMatched) {
		assert sourceNode.isClass();
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)source2targetProperty.getType();
		assert type != null;
		Type elementType = PivotUtil.getElementalType(type);
		TypedModel typedModel = elementType instanceof DataType ? scheduleManager.getDomainAnalysis().getPrimitiveTypeModel() : sourceNode.getClassDatum().getReferredTypedModel();
		assert typedModel != null;
		ClassDatum classDatum = scheduleManager.getClassDatum(typedModel, type);
		String name = source2targetProperty.getName();
		assert name != null;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(nodeRole, region, name, classDatum);
		node.setMatched(isMatched);
		return node;
	}

	public @NonNull Edge createPredicateEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		Role edgeRole = getNodeRole(sourceNode);
		PredicateEdge edge = QVTscheduleFactory.eINSTANCE.createPredicateEdge();
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull Node createPredicatedStepNode(@NonNull Node typedNode, boolean isMatched) {
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(Role.PREDICATED, region, getName(typedNode), getClassDatum(typedNode));
		node.setMatched(isMatched);
		return node;
	}

	public @NonNull Node createRealizedDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		Role nodeRole = Role.REALIZED;
		return createPatternNode(nodeRole, sourceNode, source2targetProperty, sourceNode.isMatched());
	}

	public @NonNull Edge createRealizedExpressionEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		Role edgeRole = Role.REALIZED;
		ExpressionEdge edge = QVTscheduleFactory.eINSTANCE.createExpressionEdge();
		edge.initialize(edgeRole, sourceNode, name, targetNode);
		return edge;
	}

	public @NonNull NavigableEdge createRealizedNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		Role edgeRole = Role.REALIZED;
		NavigationEdge forwardEdge = QVTscheduleFactory.eINSTANCE.createNavigationEdge();
		forwardEdge.initialize(edgeRole, sourceNode, source2targetProperty.getName(), targetNode);
		forwardEdge.initializeProperty(source2targetProperty, isPartial);
		return forwardEdge;
	}

	public @NonNull VariableNode createRealizedStepNode(@NonNull Variable stepVariable) {
		Role nodeRole = Role.REALIZED;
		PatternVariableNode node = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		node.initialize(nodeRole, region, getName(stepVariable), scheduleManager.getClassDatum(stepVariable));
		node.initializeVariable(region, stepVariable);
		node.setMatched(true);
		return node;
	}

	/*	public @NonNull Edge createRecursionEdge(@NonNull Node sourceNode, @NonNull Node targetNode, boolean isPrimary) {
		Role edgeRole = Role.OTHER;
		RecursionEdge edge = QVTscheduleFactory.eINSTANCE.createRecursionEdge();
		edge.initialize(edgeRole, sourceNode, null, targetNode);
		edge.setPrimary(isPrimary);
		return edge;
	} */

	public @NonNull StatusNode createStatusNode() {
		org.eclipse.ocl.pivot.Class booleanType = scheduleManager.getStandardLibrary().getBooleanType();
		DomainUsage primitiveUsage = scheduleManager.getDomainAnalysis().getPrimitiveUsage();
		ClassDatum classDatum = scheduleManager.getClassDatum(ClassUtil.nonNullState(primitiveUsage.getTypedModel(null)), booleanType);
		Role nodeRole = Role.REALIZED;
		StatusNode node = QVTscheduleFactory.eINSTANCE.createStatusNode();
		node.initialize(nodeRole, region, "«status»", classDatum);
		node.setHead();
		return node;
	}

	public @NonNull Node createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode, boolean isMatched) {
		DomainUsage domainUsage = scheduleManager.getDomainUsage(callExp);
		boolean isMiddleOrOutput = domainUsage.isOutput() || domainUsage.isMiddle();
		boolean isDirty = false;
		if (callExp instanceof NavigationCallExp) {
			Property referredProperty = PivotUtil.getReferredProperty((NavigationCallExp)callExp);
			isDirty = scheduleManager.isDirty(referredProperty);
		}
		Role phase = /*sourceNode.isPredicated() ||*/ isMiddleOrOutput || isDirty ? Role.PREDICATED : Role.LOADED;
		Role stepNodeRole = phase;
		PatternTypedNode node = QVTscheduleFactory.eINSTANCE.createPatternTypedNode();
		node.initialize(stepNodeRole, region, name, scheduleManager.getClassDatum(callExp));
		node.setMatched(isMatched);
		node.addTypedElement(callExp);
		return node;
	}

	public @NonNull Node createTrueNode() {
		org.eclipse.ocl.pivot.Class booleanType = scheduleManager.getStandardLibrary().getBooleanType();
		DomainUsage primitiveUsage = scheduleManager.getDomainAnalysis().getPrimitiveUsage();
		ClassDatum classDatum = scheduleManager.getClassDatum(ClassUtil.nonNullState(primitiveUsage.getTypedModel(null)), booleanType);
		Role nodeRole = Role.CONSTANT;
		TrueNode node = QVTscheduleFactory.eINSTANCE.createTrueNode();
		node.initialize(nodeRole, region, "«true»", classDatum);
		node.setHead();
		return node;
	}

	public @NonNull Node createUnknownNode(@NonNull String name, @NonNull TypedElement typedElement) {
		Role nodeRole = Role.OTHER;
		UnknownNode node = QVTscheduleFactory.eINSTANCE.createUnknownNode();
		node.initialize(nodeRole, region, name, scheduleManager.getClassDatum(typedElement));
		return node;
	}

	protected @NonNull Role getPatternNodeRole(@NonNull Node sourceNode, @NonNull Property property) {
		Role phase;
		switch (getNodeRole(sourceNode)) {
			case REALIZED: phase = Role.REALIZED; break;
			case PREDICATED: phase = Role.PREDICATED; break;
			case LOADED: {
				boolean isDirty = scheduleManager.isDirty(property);
				phase = isDirty ? Role.PREDICATED : Role.LOADED; break;
			}
			case CONSTANT: phase = Role.CONSTANT; break;
			default: throw new UnsupportedOperationException();
		}
		return phase;
	}

	public @NonNull Region getRegion() {
		return region;
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}
}