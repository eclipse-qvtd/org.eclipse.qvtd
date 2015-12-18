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
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
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
	 * The QVTi variable for each connection.
	 */
	private Map<Connection, Variable> connection2variable = null;

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
		CoreDomain domain = QVTimperativeUtil.createImperativeDomain(qvtiTypedModel);
		domain.setIsCheckable(true);
		mapping.getDomain().add(domain);
		//
		//	Create guard variable for head node.
		//
		headVariable = createVariable(headNode);
		domain.getGuardPattern().getVariable().add(headVariable);
		//
		//	Create and connectionVariable guards
		//
		List<Connection> intermediateConnections = region.getIntermediateConnections();
		if (intermediateConnections.size() > 0) {
			connection2variable =new HashMap<Connection, Variable>();
			for (Connection connection : intermediateConnections) {
				Variable connectionVariable = createVariable(connection);
				connection2variable.put(connection, connectionVariable);
				mapping.getGuardPattern().getVariable().add(connectionVariable);
			}
		}
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
//		if (!(type instanceof CollectionType)) {
//			sourceExpression = createOclAsSetCallExp(sourceExpression);
//			type = sourceExpression.getType();
//		}
			CollectionType childrenCollectionType = (CollectionType)type;
			Type childrenElementType = childrenCollectionType.getElementType();
			assert childrenElementType != null;
//			CollectionType type = (CollectionType)sourceExpression.getType();
			Type elementType = targetNode.getCompleteClass().getPrimaryClass();
			assert elementType != null;
			if (!childrenElementType.conformsTo(visitor.getStandardLibrary(), elementType)) {
				CompleteClass sourceCompleteClass = sourceNode.getCompleteClass();
				org.eclipse.ocl.pivot.Class sourcePrimaryClass = sourceCompleteClass.getPrimaryClass();
				if (sourcePrimaryClass instanceof CollectionType) {
					Type sourceElementType = ((CollectionType)sourcePrimaryClass).getElementType();
					sourceCompleteClass = visitor.getEnvironmentFactory().getCompleteModel().getCompleteClass(sourceElementType);
				}
				OCLExpression asTypeExp = createTypeExp(sourceCompleteClass);
				sourceExpression = createOperationCallExp(sourceExpression, getSelectByKindOperation(), asTypeExp);
			}
			//
			//	Create the loop variable.
			//
			Variable loopVariable = PivotUtil.createVariable(getSafeName("aChild"), elementType, true, null);
//			mapping.getBottomPattern().getVariable().add(loopVariable);
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
				for (Variable connectionVariable : connection2variable.values()) {
					OCLExpression connectionVariableExpression = PivotUtil.createVariableExp(connectionVariable);
					mappingCallBinding = QVTimperativeUtil.createMappingCallBinding(connectionVariable, connectionVariableExpression);
					setLegacyIsPolled(calledMapping, mappingCallBinding);
					mappingCallBindings.add(mappingCallBinding);
				}
			}
			MappingCall mappingCall = QVTimperativeUtil.createMappingCall(calledMapping, mappingCallBindings);
			return QVTimperativeUtil.createMappingLoop(sourceExpression, loopVariable, mappingCall);
//		}
/*		else {
			Type childrenElementType = type;
			assert childrenElementType != null;
			OCLExpression sourceExpression = PivotUtil.createVariableExp(childrenVariable);
//			CollectionType type = (CollectionType)sourceExpression.getType();
			Type elementType = targetNode.getCompleteClass().getPrimaryClass();
			assert elementType != null;
			if (!childrenElementType.conformsTo(visitor.getStandardLibrary(), elementType)) {
				OCLExpression asTypeExp = createTypeExp(sourceNode.getCompleteClass());
				sourceExpression = createOperationCallExp(sourceExpression, getSelectByKindOperation(), asTypeExp);
			}
			AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(targetNode.getRegion());
			Variable guardVariable = calledRegion2Mapping.getGuardVariable(targetNode);
			List<MappingCallBinding> mappingCallBindings = new ArrayList<MappingCallBinding>();
			mappingCallBindings.add(QVTimperativeUtil.createMappingCallBinding(guardVariable, sourceExpression));
			List<Node> calledGuardNodes = new ArrayList<Node>(calledRegion2Mapping.getGuardNodes());
			calledGuardNodes.remove(targetNode);
			if (calledGuardNodes.size() > 0) {
				assert calledGuardNodes.size() == 1;
				@SuppressWarnings("null")@NonNull Node calledGuardNode = calledGuardNodes.get(0);
				Variable guardVariable2 = calledRegion2Mapping.getGuardVariable(calledGuardNode);
				OCLExpression headVariableExpression = createVariableExp(getHeadNode());
				mappingCallBindings.add(QVTimperativeUtil.createMappingCallBinding(guardVariable2, headVariableExpression));
			}
			MappingCall mappingCall = QVTimperativeUtil.createMappingCall(calledRegion2Mapping.getMapping(), mappingCallBindings);
			return mappingCall;
		} */
	}

	@Override
	public void createConnections() {
		//
		//	Create guard variables for connections.
		//
/*		ChainNode chain = visitor.getChain(region);
		for (Connection connection : chain.getConnections()) {
			ChainNode child = chain.getChild(connection);
			Region childRegion = child.getRegion();
			if (childRegion.isConnectionRegion()) {
				Type connectionClass = null;
				int bestDepth = Integer.MAX_VALUE;
				for (Connection connectionConnection : childRegion.getParentPassedConnections()) {
					Node connectionSource = connectionConnection.getSource();
					int depth = visitor.getRegion2Depth().getRegionDepth(connectionSource.getRegion());
					if ((connectionClass == null) || (depth < bestDepth)) {
						connectionClass = connectionSource.getCompleteClass().getPrimaryClass();
						bestDepth = depth;
					}
				}
				assert connectionClass != null;
				Variable connectionVariable =  PivotUtil.createVariable(getSafeName(connection.getSource()), connectionClass, true, null);
				mapping.getGuardPattern().getVariable().add(connectionVariable);
				if (connectionRegion2connectionVariable == null) {
					connectionRegion2connectionVariable = new HashMap<Connection, Variable>();
				}
				Variable oldConnectionVariable = connectionRegion2connectionVariable.put((Connection) childRegion, connectionVariable);
				assert oldConnectionVariable == null;
			}
		} */
	}

	@Override
	public void createStatements() {
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
			initExpression = createOclAsSetCallExp(initExpression);
			asType = initExpression.getType();
		}
		assert asType != null;
		Variable childrenVariable = PivotUtil.createVariable(getSafeName("allChildren"), asType, true, initExpression);
		mapping.getBottomPattern().getVariable().add(childrenVariable);
		//
		//	Create union assignments for connections.
		//
		if (connection2variable != null) {
			for (Variable connectionVariable : connection2variable.values()) {
				OCLExpression childrenExpression = PivotUtil.createVariableExp(childrenVariable);
				ConnectionAssignment connectionAssignment = QVTimperativeFactory.eINSTANCE.createConnectionAssignment();
				connectionAssignment.setTargetVariable(connectionVariable);
				connectionAssignment.setValue(childrenExpression);
				mapping.getBottomPattern().getAssignment().add(connectionAssignment);
			}
		}
		//
		//	Create a loop for each distinct consumer of the children.
		//
		MappingStatement mappingStatement = null;
//		for (@SuppressWarnings("null")@NonNull Node sourceNode : AbstractNode.getSortedTargets(region.getComposedNodes())) {
//			for (@SuppressWarnings("null")@NonNull Node targetNode : AbstractNode.getSortedTargets(sourceNode.getPassedBindingTargets())) {
//				MappingStatement mappingLoop = createChildLoop(childrenVariable, sourceNode, targetNode);
//				mappingStatement = QVTimperativeUtil.addMappingStatement(mappingStatement, mappingLoop);
//			}		
//		}
		for (Region childRegion : region.getCallableChildren()) {
//			ChainNode child = chain.getChild(connection);
//			Region childRegion = child.getRegion();
//			if (childRegion.isConnectionRegion() && Iterables.isEmpty(child.getConnections())) {
//			}
//			else if (childRegion.isConnectionRegion() && !Iterables.isEmpty(child.getConnections())) {
//			}
//			else {
				Region calledRegion = childRegion;
				AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
//				Map<Variable, OCLExpression> loopVariables = new HashMap<Variable, OCLExpression>();
//				List<MappingCallBinding> mappingCallBindings = new ArrayList<MappingCallBinding>();
				for (@SuppressWarnings("null")@NonNull Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
					for (Node callingNode : calledGuardNode.getPassedBindingSources()) {
						if (callingNode.getRegion() == region) {
//							MappingCallBinding mappingCallBinding = createMappingCallBinding(callingNode, calledGuardNode, loopVariables);
//							mappingCallBindings.add(mappingCallBinding);
							MappingStatement mappingLoop = createChildLoop(childrenVariable, callingNode, calledGuardNode);
							mappingStatement = QVTimperativeUtil.addMappingStatement(mappingStatement, mappingLoop);
						}
					}
				}
//			}
		}	
/*		for (@SuppressWarnings("null")@NonNull Region calledRegion : getEarliestFirstCalledRegions()) {
			AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
//			Map<Variable, OCLExpression> loopVariables = new HashMap<Variable, OCLExpression>();
//			List<MappingCallBinding> mappingCallBindings = new ArrayList<MappingCallBinding>();
			for (@SuppressWarnings("null")@NonNull Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
				for (Node callingNode : calledGuardNode.getPassedBindingSources()) {
					if (callingNode.getRegion() == region) {
//						MappingCallBinding mappingCallBinding = createMappingCallBinding(callingNode, calledGuardNode, loopVariables);
//						mappingCallBindings.add(mappingCallBinding);
						MappingStatement mappingLoop = createChildLoop(childrenVariable, callingNode, calledGuardNode);
						mappingStatement = QVTimperativeUtil.addMappingStatement(mappingStatement, mappingLoop);
					}
				}
			}	
		} */
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

	@Override
	public @NonNull Variable getConnectionVariable(@NonNull Connection connection) {
		assert connection2variable != null;
		Variable connectionVariable = connection2variable.get(connection);
		assert connectionVariable != null;
		return connectionVariable;
	}

	@SuppressWarnings("null")
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
}