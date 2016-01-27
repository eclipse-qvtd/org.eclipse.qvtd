/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.schedule2qvti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.scheduler.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.scheduler.Connection;
import org.eclipse.qvtd.compiler.internal.scheduler.Edge;
import org.eclipse.qvtd.compiler.internal.scheduler.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.scheduler.Node;
import org.eclipse.qvtd.compiler.internal.scheduler.Region;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class CompositionRegion2Mapping extends AbstractRegion2Mapping
{	
	/**
	 * The one and only head node.
	 */
	private Node headNode = null;

	/**
	 * QVTi variable for the head node
	 */
	private Variable headVariable = null;

	/**
	 * QVTi variable for the children node
	 */
	private Variable childrenVariable = null;

	/**
	 * Mapping from the scheduled Nodes to their QVTi variables.
	 */
	private final @NonNull Map<Node, Variable> node2variable = new HashMap<Node, Variable>();

	public CompositionRegion2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull Region region) {
		super(visitor, region);
		//
		//	Create the domain
		//
		Node headNode = getHeadNode();
		ClassDatumAnalysis classDatumAnalysis = headNode.getClassDatumAnalysis();
		assert !(classDatumAnalysis.getClassDatum().getType() instanceof DataType);
		TypedModel typedModel = classDatumAnalysis.getTypedModel();
		TypedModel qvtiTypedModel = visitor.getQVTiTypedModel(typedModel);
		assert qvtiTypedModel != null;
		Area area;
		if (qvtiTypedModel != typedModel) {			// == occurs for objects such as EObject/EAnnotation that may be in multiple domains
			CoreDomain domain = QVTimperativeUtil.createImperativeDomain(qvtiTypedModel);
			domain.setIsCheckable(true);
			mapping.getDomain().add(domain);
			area = domain;
		}
		else {
			area = mapping;
		}
		//
		//	Create guard variable for head node.
		//
		headVariable = createVariable(headNode);
		area.getGuardPattern().getVariable().add(headVariable);
		//
		//	Create any connectionVariable guards
		//
		createConnectionGuardVariables();
	}
	
	/**
	 * Create a MappingLoop over those elements of childrenVariable that are type compatible with sourceElement, binding
	 * each loop element in a MappingCall to targetNode.
	 */
	private @NonNull MappingStatement createChildLoop(@NonNull Variable childrenVariable, @NonNull Node sourceNode, @NonNull Node targetNode) {
		//
		//	Create loop source expression, using selectByKind if necessary
		//
		OCLExpression sourceExpression = PivotUtil.createVariableExp(childrenVariable);
		Type type = childrenVariable.getType();
		assert type instanceof CollectionType;
		type = sourceExpression.getType();
		CollectionType childrenCollectionType = (CollectionType)type;
		Type childrenElementType = childrenCollectionType.getElementType();
		assert childrenElementType != null;
			Type elementType = targetNode.getCompleteClass().getPrimaryClass();
			assert elementType != null;
			if (!childrenElementType.conformsTo(visitor.getStandardLibrary(), elementType)) {
				sourceExpression = createSelectByKind(sourceNode);
			}
			//
			//	Create the loop variable.
			//
			Variable loopVariable = PivotUtil.createVariable(getSafeName("aChild"), elementType, true, null);
			//
			//	Create loop over mapping calls of prevailing loop variable value
			//
			AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(targetNode.getRegion());
			Mapping calledMapping = calledRegion2Mapping.getMapping();
			VariableExp loopVariableExpression = PivotUtil.createVariableExp(loopVariable);
			Variable guardVariable = calledRegion2Mapping.getGuardVariable(targetNode);
			List<MappingCallBinding> mappingCallBindings = new ArrayList<MappingCallBinding>();
			MappingCallBinding mappingCallBinding = QVTimperativeUtil.createMappingCallBinding(guardVariable, loopVariableExpression);
			setLegacyIsPolled(calledMapping, mappingCallBinding);
			mappingCallBindings.add(mappingCallBinding);
			List<Node> calledGuardNodes = new ArrayList<Node>(calledRegion2Mapping.getGuardNodes());
			calledGuardNodes.remove(targetNode);
			if (calledGuardNodes.size() > 0) {
				assert calledGuardNodes.size() == 1;
				@SuppressWarnings("null")@NonNull Node calledGuardNode = calledGuardNodes.get(0);
				Variable guardVariable2 = calledRegion2Mapping.getGuardVariable(calledGuardNode);
				OCLExpression headVariableExpression = createVariableExp(getHeadNode());
				mappingCallBinding = QVTimperativeUtil.createMappingCallBinding(guardVariable2, headVariableExpression);
				setLegacyIsPolled(calledMapping, mappingCallBinding);
				mappingCallBindings.add(mappingCallBinding);
			}
			if (connection2variable != null) {
				for (@SuppressWarnings("null")@NonNull Variable connectionVariable : connection2variable.values()) {
					OCLExpression connectionVariableExpression = PivotUtil.createVariableExp(connectionVariable);
					mappingCallBinding = QVTimperativeUtil.createMappingCallBinding(connectionVariable, connectionVariableExpression);
					setLegacyIsPolled(calledMapping, mappingCallBinding);
					mappingCallBindings.add(mappingCallBinding);
				}
			}
			MappingCall mappingCall = QVTimperativeUtil.createMappingCall(calledMapping, mappingCallBindings);
			return QVTimperativeUtil.createMappingLoop(sourceExpression, loopVariable, mappingCall);
	}

	private @NonNull OCLExpression createSelectByKind(@NonNull Node resultNode) {
		Variable resultVariable = node2variable.get(resultNode);
		if (resultVariable == null) {
			OCLExpression asSource = PivotUtil.createVariableExp(getChildrenVariable());
			CompleteClass sourceCompleteClass = resultNode.getCompleteClass();
			CollectionType sourceCollectionType = (CollectionType) sourceCompleteClass.getPrimaryClass();
			Type sourceElementType = sourceCollectionType.getElementType();
			assert sourceElementType != null;
			CompleteClass sourceElementClass = visitor.getEnvironmentFactory().getCompleteModel().getCompleteClass(sourceElementType);
			OCLExpression asTypeExp = createTypeExp(sourceElementClass);
			OCLExpression selectExp = createOperationCallExp(asSource, getSelectByKindOperation(), asTypeExp);
			resultVariable = PivotUtil.createVariable(resultNode.getName(), selectExp);
			mapping.getBottomPattern().getVariable().add(resultVariable);
			node2variable.put(resultNode, resultVariable);
		}
		return PivotUtil.createVariableExp(resultVariable);
	}

	@Override
	public void createStatements() {
		Variable childrenVariable = getChildrenVariable();
		//
		//	Create accumulation assignments for connections.
		//
		if (connection2variable != null) {
			for (Connection connection : connection2variable.keySet()) {
				Variable connectionVariable = connection2variable.get(connection);
				assert connectionVariable != null;
				Node resultNode = connection.getSource(region);
				OCLExpression sourceExpression = createSelectByKind(resultNode);
				createConnectionAssignment(connectionVariable, sourceExpression);
			}
		}
		//
		//	Create a loop for each distinct consumer of the children.
		//
		MappingStatement mappingStatement = null;
		for (@SuppressWarnings("null")@NonNull Region childRegion : region.getCallableChildren()) {
				Region calledRegion = childRegion;
				AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
				for (@SuppressWarnings("null")@NonNull Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
					for (Node callingNode : calledGuardNode.getPassedBindingSources()) {
						if (callingNode.getRegion() == region) {
							MappingStatement mappingLoop = createChildLoop(childrenVariable, callingNode, calledGuardNode);
							mappingStatement = QVTimperativeUtil.addMappingStatement(mappingStatement, mappingLoop);
						}
					}
				}
//			}
		}	
		//
		//	Create a loop for each distinct child recursion.
		//
		for (@SuppressWarnings("null")@NonNull Edge recursionEdge : region.getRecursionEdges()) {
			Node sourceNode = recursionEdge.getSource();
			Node targetNode = recursionEdge.getTarget();
			assert targetNode == headNode;		// FIXME contra-Recursion
			MappingStatement mappingLoop = createChildLoop(childrenVariable, sourceNode, targetNode);
			mappingStatement = QVTimperativeUtil.addMappingStatement(mappingStatement, mappingLoop);
		}
		mapping.setMappingStatement(mappingStatement);
	}

	private @NonNull OCLExpression createVariableExp(@NonNull Node node) {
		assert node == headNode;
		assert !headNode.isAttributeNode();
		Variable headVariable2 = headVariable;
		assert headVariable2 != null;
		return PivotUtil.createVariableExp(headVariable2);
	}

	protected @NonNull Variable getChildrenVariable() {
		Variable childrenVariable2 = childrenVariable;
		if (childrenVariable2 == null) {
			Node headNode = getHeadNode();
			//
			//	Create an unrealized variable for the raw navigation result.
			//
			Property property = null;
			for (NavigationEdge edge : headNode.getNavigationEdges()) {
				Property navigationProperty = edge.getProperty();
				if (property == null) {
					property = navigationProperty;
				}
				else {
					assert property == navigationProperty;
				}
			}
			assert property != null;
			//
			//	Cache the children in a middle bottom pattern variable.
			//
			OCLExpression parentExpression = createVariableExp(headNode);
			OCLExpression initExpression = PivotUtil.createNavigationCallExp(parentExpression, property);
			Type asType = initExpression.getType();
			if (!(asType instanceof CollectionType)) {
				// FIXME if we have a 1:1 containment relationship we really don't need the bloat of a CompositionRegion at all.
				initExpression = createOclAsSetCallExp(initExpression);
				asType = initExpression.getType();
			}
			else {
				// FIXME this redundant selectByKind avoids an out-of-order CG of a boxed CSE
				Type childrenElementType2 = ((CollectionType)asType).getElementType();
				assert childrenElementType2 != null;
				CompleteClass sourceCompleteClass = visitor.getEnvironmentFactory().getCompleteModel().getCompleteClass(childrenElementType2);
				OCLExpression asTypeExp2 = createTypeExp(sourceCompleteClass);
				initExpression = createOperationCallExp(initExpression, getSelectByKindOperation(), asTypeExp2);
			}
			assert asType != null;
			childrenVariable = childrenVariable2 = PivotUtil.createVariable(getSafeName("allChildren"), asType, true, initExpression);
			mapping.getBottomPattern().getVariable().add(childrenVariable2);
		}
		return childrenVariable2;
	}

	@Override
	public @NonNull List<Node> getGuardNodes() {
		return Collections.singletonList(getHeadNode());
	}

	@Override
	public @NonNull Variable getGuardVariable(@NonNull Node node) {
		assert node == headNode;
		Variable headVariable2 = headVariable;
		assert headVariable2 != null;
		return headVariable2;
	}

	private @NonNull Node getHeadNode() {
		Node headNode2 = headNode;
		if (headNode2 == null) {
			List<List<Node>> headNodeGroups = region.getHeadNodeGroups();
			assert headNodeGroups.size() == 1;
			List<Node> headGroupNodes = headNodeGroups.get(0);
			assert headGroupNodes.size() == 1;
			headNode2 = headGroupNodes.get(0);
			assert headNode2 != null;
			headNode = headNode2;
		}
		return headNode2;
	}

	protected @NonNull VariableExp getHeadVariableExp() {
		return PivotUtil.createVariableExp(getGuardVariable(getHeadNode()));
	}
}