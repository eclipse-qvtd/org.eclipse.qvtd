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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionKind;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.qvtd.compiler.internal.scheduler.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.scheduler.Connection;
import org.eclipse.qvtd.compiler.internal.scheduler.Node;
import org.eclipse.qvtd.compiler.internal.scheduler.Region;
import org.eclipse.qvtd.compiler.internal.scheduler.SchedulerConstants;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class RootRegion2Mapping extends AbstractRegion2Mapping
{
	/**
	 * Mapping from the scheduled Nodes to their QVTi variables.
	 */
	private final @NonNull Map<Node, Variable> node2variable = new HashMap<Node, Variable>();
	private Variable rootsVariable = null;

	private final @NonNull Map<Connection, Variable> connection2variable = new HashMap<Connection, Variable>();

	public RootRegion2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull Region region) {
		super(visitor, region);
		//
		//	Create domains
		//
		Set<TypedModel> checkableTypedModels = new HashSet<TypedModel>();
		for (Node node : region.getNodes()) {
			ClassDatumAnalysis classDatumAnalysis = node.getClassDatumAnalysis();
			Type type = classDatumAnalysis.getClassDatum().getType();
			if (!(type instanceof DataType) && !(type instanceof AnyType) && !(type instanceof VoidType) && !(type instanceof InvalidType)) {
				TypedModel typedModel = classDatumAnalysis.getTypedModel();
				checkableTypedModels.add(visitor.getQVTiTypedModel(typedModel));
			}
		}
		for (@SuppressWarnings("null")@NonNull TypedModel qvtiTypedModel : checkableTypedModels) {
			CoreDomain domain = QVTimperativeUtil.createImperativeDomain(qvtiTypedModel);
			domain.setIsCheckable(true);
			mapping.getDomain().add(domain);
//			CoreDomain oldDomain = typedModel2domain.put(qvtiTypedModel, domain);
//			assert oldDomain == null;
		}
/*		for (ConnectionRegion connectionRegion : rootConnections) {
			SimpleNode connectionNode = connectionRegion.getConnectionNode();
			CompleteClass completeClass = connectionNode.getCompleteClass();
//			NullLiteralExp initExpression = ValueUtil.createSetOfEach((CollectionTypeId)completeClass.getPrimaryClass().getTypeId());
			CollectionLiteralExp initExpression = PivotFactory.eINSTANCE.createCollectionLiteralExp();
			CollectionType collectionType = visitor.getEnvironmentFactory().getCompleteEnvironment().getSetType(completeClass.getPrimaryClass(), true, null, null);
			initExpression.setType(collectionType);
			initExpression.setKind(TypeUtil.getCollectionKind(collectionType));
			connection2variable.put(connectionRegion, createConnectionVariable(mapping.getBottomPattern(), connectionNode, initExpression));
		} */
	}

	private @NonNull MappingCallBinding createMappingCallBinding(@NonNull OCLExpression sourceExpression, @NonNull Node targetNode,
			@NonNull Map<Variable, OCLExpression> loopVariables) {
/*		ConnectionRegion connectionRegion = null;
		for (Connection incomingPassedConnection : targetNode.getIncomingPassedConnections()) {
			Region sourceRegion = incomingPassedConnection.getSource().getRegion();
			if (sourceRegion.isConnectionRegion()) {
				connectionRegion = (ConnectionRegion)sourceRegion;
				break;
			}
		} */
//		OCLExpression sourceExpression;
//		if (connectionRegion != null) {
//			Variable connectionVariable = connection2variable.get(connectionRegion);
//			assert connectionVariable != null;
//			sourceExpression = PivotUtil.createVariableExp(connectionVariable);
//		}
//		else {
//			sourceExpression = createSelectByKind(sourceNode);
//		}
		Type type = sourceExpression.getType();
		if (type instanceof CollectionType) {
			Type elementType = ((CollectionType)type).getElementType();
			assert elementType != null;
			Variable loopVariable = PivotUtil.createVariable("loop" + loopVariables.size(), elementType, true, sourceExpression);
			loopVariables.put(loopVariable, sourceExpression);
			sourceExpression = PivotUtil.createVariableExp(loopVariable);
		}
		AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(targetNode.getRegion());
		Variable guardVariable = calledRegion2Mapping.getGuardVariable(targetNode);
		return QVTimperativeUtil.createMappingCallBinding(guardVariable, sourceExpression);
	}
	
	private @NonNull Variable createRootConnectionVariable(@NonNull CorePattern pattern, @NonNull String name, @NonNull Type type, @Nullable OCLExpression initExpression) {
//		Type variableType = visitor.getEnvironmentFactory().getCompleteEnvironment().getSetType(node.getCompleteClass().getPrimaryClass(), true, null, null);
//		assert variableType != null;
		Variable variable = PivotUtil.createVariable(getSafeName(name), type, true, initExpression);
		pattern.getVariable().add(variable);
//		Variable oldVariable = node2variable.put(node, variable);
//		assert oldVariable == null;
		return variable;
	}

	private void createRootConnectionVariables() {
		IdResolver idResolver = visitor.getEnvironmentFactory().getIdResolver();
		BottomPattern bottomPattern = mapping.getBottomPattern();
		assert bottomPattern != null;
		List<Connection> rootConnections = new ArrayList<Connection>(region.getRootConnections());
		Collections.sort(rootConnections, NameUtil.NAMEABLE_COMPARATOR);
		for (Connection rootConnection : rootConnections) {
			Type commonType = rootConnection.getType(idResolver);
			Node regionNode = rootConnection.basicGetSource(region);
			String name = rootConnection.getName();
			assert name != null;
			if (regionNode != null) {
				OCLExpression initExpression = createSelectByKind(regionNode);
				connection2variable.put(rootConnection, createRootConnectionVariable(bottomPattern, name, commonType, initExpression));
			}
			else if (commonType instanceof CollectionType) {
				CollectionLiteralExp initExpression = PivotFactory.eINSTANCE.createCollectionLiteralExp();
				initExpression.setType(commonType);
				initExpression.setKind(TypeUtil.getCollectionKind((CollectionType) commonType));
				initExpression.setIsRequired(true);
				connection2variable.put(rootConnection, createRootConnectionVariable(bottomPattern, name, commonType, initExpression));
			}
			else {
				CollectionLiteralExp initExpression = PivotFactory.eINSTANCE.createCollectionLiteralExp();
				CollectionType setType = visitor.getEnvironmentFactory().getCompleteEnvironment().getSetType(commonType, true, null, null);
				initExpression.setType(setType);
				initExpression.setKind(CollectionKind.SET);
				initExpression.setIsRequired(true);
				connection2variable.put(rootConnection, createRootConnectionVariable(bottomPattern, name, setType, initExpression));
			}
		}
	}

	protected Type getType(@NonNull IdResolver idResolver, @NonNull Connection rootConnection) {
		Type commonType = null;
		for (Node node : rootConnection.getSources()) {
			Type nodeType = node.getCompleteClass().getPrimaryClass();
			if (commonType == null) {
				commonType = nodeType;
			}
			else {
				commonType = commonType.getCommonType(idResolver, nodeType);
			}
		}
		return commonType;
	}

	private @NonNull OCLExpression createSelectByKind(@NonNull Node resultNode) {
		Variable resultVariable = node2variable.get(resultNode);
		if (resultVariable == null) {
			OCLExpression asSource = getRootsVariable(resultNode);
			CompleteClass sourceCompleteClass = resultNode.getCompleteClass();
			CollectionType sourceCollectionType = (CollectionType) sourceCompleteClass.getPrimaryClass();
			Type elementType = sourceCollectionType.getElementType();
			assert elementType != null;
			CompleteClass sourceElementClass = visitor.getEnvironmentFactory().getCompleteModel().getCompleteClass(elementType);
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
//		BottomPattern bottomPattern = mapping.getBottomPattern();
		createRootConnectionVariables();
/*		//
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
		mapping.getBottomPattern().getVariable().add(childrenVariable); */
		//
		//	Create union assignments for connections.
		//
//		if (connection2variable != null) {
/*			Operation asOperation = NameUtil.getNameable(visitor.getStandardLibrary().getCollectionType().getOwnedOperations(), "union");
			for (Node node : region.getNodes()) {
				if (node.isComposed()) {
					for (InterRegionEdge edge : node.getOutgoingPassedBindingEdges()) {
						Node connectionNode = edge.getTarget();
						Region connectionRegion = connectionNode.getRegion();
						Variable connectionVariable = connection2variable.get(connectionRegion);
						if (connectionVariable != null) {
							OCLExpression collection1 = PivotUtil.createVariableExp(connectionVariable);
							OCLExpression collection2 = createSelectByKind(node);
							OCLExpression union = createOperationCallExp(collection1, asOperation, collection2);
							VariableAssignment variableAssignment = QVTcoreBaseFactory.eINSTANCE.createVariableAssignment();
							variableAssignment.setTargetVariable(connectionVariable);
							variableAssignment.setValue(union);
							bottomPattern.getAssignment().add(variableAssignment);
						}
					}
				}
			}
			bottomPattern.getVariable().addAll(connection2variable.values());
//		} */
		MappingStatement mappingStatement = null;
/*		ChainNode chain = visitor.getChain(region);
		for (ChainNode child : chain.getChildren()) {
			Region calledRegion = child.getRegion();
			if (!calledRegion.isConnectionRegion()) {
				mappingStatement = createCalls(mappingStatement, calledRegion);
			}
			else if (Iterables.isEmpty(child.getChildren())) {
//				mappingStatement = createCalls(mappingStatement, calledRegion);
			}
			else {
				assert calledRegion.isConnectionRegion();
				assert !Iterables.isEmpty(child.getChildren());
				for (ChainNode connectionChild : child.getChildren()) {
					Region connectionedRegion = connectionChild.getRegion();
					assert !connectionedRegion.isConnectionRegion();
					mappingStatement = createCalls(mappingStatement, connectionedRegion);
				}
			}
		} */
		for (@SuppressWarnings("null")@NonNull Region callableRegion : region.getCallableChildren()) {
			mappingStatement = createCalls(mappingStatement, callableRegion);
		}
		mapping.setMappingStatement(mappingStatement);
	}

	protected MappingStatement createCalls(@Nullable MappingStatement mappingStatement, @NonNull Region calledRegion) {
//		Iterable<Connection> connectionRegions = getConnectionRegions(calledRegion);
//		assert !calledRegion.isConnectionRegion();
		AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
		Mapping calledMapping = calledRegion2Mapping.getMapping();
		Map<Variable, OCLExpression> loopVariables = new HashMap<Variable, OCLExpression>();
		List<MappingCallBinding> mappingCallBindings = new ArrayList<MappingCallBinding>();
		for (@SuppressWarnings("null")@NonNull Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
			for (Connection callingConnection : calledGuardNode.getIncomingPassedConnections()) {
				Variable connectionVariable = connection2variable.get(callingConnection);
				MappingCallBinding mappingCallBinding;
				if (connectionVariable != null) {
					mappingCallBinding = createMappingCallBinding(PivotUtil.createVariableExp(connectionVariable), calledGuardNode, loopVariables);
				}
				else {
					Node callingNode = callingConnection.getSource(region);
					mappingCallBinding = createMappingCallBinding(createSelectByKind(callingNode), calledGuardNode, loopVariables);
				}
				setLegacyIsPolled(calledMapping, mappingCallBinding);
				mappingCallBindings.add(mappingCallBinding);
			}
			for (Node callingNode : calledGuardNode.getUsedBindingSources()) {
				if (callingNode.getRegion() == region) {
					MappingCallBinding mappingCallBinding = createMappingCallBinding(createSelectByKind(callingNode), calledGuardNode, loopVariables);
					setLegacyIsPolled(calledMapping, mappingCallBinding);
					mappingCallBindings.add(mappingCallBinding);
				}
			}
		}
		for (@SuppressWarnings("null")@NonNull Connection intermediateConnection : calledRegion.getIntermediateConnections()) {
			Variable calledConnectionVariable = calledRegion2Mapping.getConnectionVariable(intermediateConnection);
			Variable callingConnectionVariable = connection2variable.get(intermediateConnection);
			assert callingConnectionVariable != null;
			OCLExpression sourceExpression = PivotUtil.createVariableExp(callingConnectionVariable);
			mappingCallBindings.add(QVTimperativeUtil.createMappingCallBinding(calledConnectionVariable, sourceExpression));
		}
		Collections.sort(mappingCallBindings, QVTimperativeUtil.MappingCallBindingComparator.INSTANCE);
		MappingStatement mappingCallStatement = QVTimperativeUtil.createMappingCall(calledMapping, mappingCallBindings);
		for (Map.Entry<Variable, OCLExpression> loopEntry : loopVariables.entrySet()) {
			@SuppressWarnings("null")@NonNull Variable loopVariable = loopEntry.getKey();
			@SuppressWarnings("null")@NonNull OCLExpression loopSource = loopEntry.getValue();
			mappingCallStatement = QVTimperativeUtil.createMappingLoop(loopSource, loopVariable, mappingCallStatement);
		}				
		mappingStatement = QVTimperativeUtil.addMappingStatement(mappingStatement, mappingCallStatement);
		return mappingStatement;
	}

	@Override
	public @NonNull List<Node> getGuardNodes() {
		return SchedulerConstants.EMPTY_NODE_LIST;
	}

	@Override
	public @NonNull Variable getGuardVariable(@NonNull Node node) {
		Variable variable = node2variable.get(node);
		assert variable != null;
		return variable;
	}

	private @NonNull OCLExpression getRootsVariable(@NonNull Node resultNode) {	// FIXME compute input typed model
		Variable rootsVariable2 = rootsVariable;
		if (rootsVariable2 == null) {
			StandardLibraryInternal standardLibrary = (StandardLibraryInternal)visitor.getStandardLibrary();
			TypedModel typedModel = visitor.getQVTiTypedModel(resultNode.getClassDatumAnalysis().getTypedModel());
			assert typedModel != null;
			Variable contextVariable = QVTbaseUtil.getContextVariable(standardLibrary, typedModel);
			VariableExp modelExp = PivotUtil.createVariableExp(contextVariable);
			OCLExpression asSource = createOperationCallExp(modelExp, getRootObjectsOperation());
			rootsVariable = rootsVariable2 = PivotUtil.createVariable("roots", asSource);
			mapping.getBottomPattern().getVariable().add(rootsVariable2);
		}
		return PivotUtil.createVariableExp(rootsVariable2);
	}
}