/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public class LoadingPartition2Mapping extends AbstractRootRegion2Mapping
{
	/**
	 * Mapping from the type to allInstances variable.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull AppendParameter> classDatum2variable = new HashMap<>();

	/**
	 * Mapping from the scheduled Nodes to their QVTi variables.
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Variable> node2variable = new HashMap<>();
	//	private Variable rootsVariable = null;

	//	private final @NonNull Map<@NonNull NodeConnection, @NonNull ConnectionVariable> connection2variable = new HashMap<@NonNull NodeConnection, @NonNull ConnectionVariable>();

	public LoadingPartition2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull EntryPoint entryPoint, @NonNull LoadingPartition partition) {
		super(visitor, entryPoint, partition);
	}

	private @NonNull BufferStatement createRootConnectionVariable(@NonNull String name, boolean isStrict, @NonNull Type type, @Nullable OCLExpression initExpression) {
		//		Type variableType = visitor.getEnvironmentFactory().getCompleteEnvironment().getSetType(node.getCompleteClass().getPrimaryClass(), true, null, null);
		//		assert variableType != null;
		BufferStatement variable = helper.createBufferStatement(getSafeName(name), isStrict, type, true, initExpression);
		mapping.getOwnedStatements().add(variable);
		//		Variable oldVariable = node2variable.put(node, variable);
		//		assert oldVariable == null;
		return variable;
	}

	private void createRootConnectionVariables() {
		List<@NonNull NodeConnection> rootConnections = new ArrayList<>(QVTscheduleUtil.getRootConnections(partition));
		Collections.sort(rootConnections, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull NodeConnection rootConnection : rootConnections) {
			Type commonType = getConnectionSourcesType(rootConnection);
			Node regionNode = rootConnection.basicGetSource(partition);
			String name = rootConnection.getName();
			assert name != null;
			if (regionNode != null) {
				ClassDatum classDatum = QVTscheduleUtil.getClassDatum(regionNode);
				AppendParameter allInstancesVariable = classDatum2variable.get(classDatum);
				if (allInstancesVariable == null) {
					Type elementType = classDatum.getCollectionElementType();
					assert !(elementType instanceof CollectionType);
					String safeName = getSafeName(name);
					allInstancesVariable = helper.createAppendParameter(safeName, elementType, true); //DeclareStatement(safeName, sourceType, true, asSource);
					mapping.getOwnedMappingParameters().add(allInstancesVariable);
					classDatum2variable.put(classDatum, allInstancesVariable);
				}
				connection2variable.put(rootConnection, allInstancesVariable);
			}
			else {
				BufferStatement rootConnectionVariable = createRootConnectionVariable(name, false, commonType, null);
				int firstPass = rootConnection.getFirstPass();
				int lastPass = rootConnection.getLastPass();
				rootConnectionVariable.setFirstPass(firstPass);
				if (lastPass > firstPass) {
					rootConnectionVariable.setLastPass(lastPass);
				}
				connection2variable.put(rootConnection, rootConnectionVariable);
			}
		}
	}

	@Override
	protected @NonNull OCLExpression createSelectByKind(@NonNull Node resultNode) {
		throw new UnsupportedOperationException();
		/*refactored code inlined at call point -- ?? ok, but needs usage analysis
		OCLExpression initExpression = createObjectsOfKindExpression(resultNode);
		List<@NonNull Edge> incomingEdges = resultNode.getIncomingEdges();
		switch (incomingEdges.size()) {
			case 0: break;
			case 1: initExpression = getFilteredExpression(initExpression, (NavigableEdge) incomingEdges.get(0)); break;
			default: assert false;
		}
		return initExpression; */
		/*very old code
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
		return helper.createVariableExp(resultVariable); */
	}

	@Override
	public @NonNull List<@NonNull Node> getGuardNodes() {
		return QVTscheduleConstants.EMPTY_NODE_LIST;
	}

	@Override
	public @NonNull MappingParameter getGuardVariable(@NonNull Node node) {
		Variable variable = node2variable.get(node);
		assert variable != null;
		return (MappingParameter) variable;
	}

	protected @NonNull Iteration getSelectIteration() {
		org.eclipse.ocl.pivot.Class collectionType = ((StandardLibraryInternal)visitor.getStandardLibrary()).getSetType();
		Operation selectIteration = NameUtil.getNameable(collectionType.getOwnedOperations(), "select");
		assert selectIteration != null;
		return (Iteration) selectIteration;
	}

	protected Type getType(@NonNull IdResolver idResolver, @NonNull NodeConnection rootConnection) {
		Type commonType = null;
		for (@NonNull Node node : QVTscheduleUtil.getSourceEnds(rootConnection)) {
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(node);
			for (@NonNull CompleteClass completeClass : QVTscheduleUtil.getCompleteClasses(classDatum)) {	// ??? never multiple
				Type nodeType = completeClass.getPrimaryClass();
				if (commonType == null) {
					commonType = nodeType;
				}
				else {
					commonType = commonType.getCommonType(idResolver, nodeType);
				}
			}
		}
		return commonType;
	}

	protected boolean isInstall(@NonNull Partition calledPartition) {
		AbstractPartition2Mapping calledRegion2Mapping = visitor.getPartition2Mapping(calledPartition);
		for (@NonNull Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
			NodeConnection callingConnection = calledGuardNode.getIncomingPassedConnection();
			if (callingConnection == null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void synthesizeCallStatements() {
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
								OCLExpression collection1 = helper.createVariableExp(connectionVariable);
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
		List<Statement> ownedStatements = mapping.getOwnedStatements();
		for (@NonNull Partition callablePartition : connectionManager.getCallableChildren(partition)) {
			if (!CompilerUtil.isAbstract(callablePartition)) {
				if (isInstall(callablePartition)) {
					ownedStatements.add(createInstall(callablePartition));
				}
				else {
					ownedStatements.add(createCall(callablePartition, null));
				}
			}
		}
	}

	@Override
	public void synthesizeLocalStatements() {
		//
		//	Create domains
		//
		Set<@NonNull ImperativeTypedModel> checkableTypedModels = new HashSet<>();
		for (@NonNull Node node : partition.getPartialNodes()) {
			ClassDatum classDatum = node.getClassDatum();
			if (classDatum.isCheckable()) {
				TypedModel qvtmTypedModel = classDatum.getReferredTypedModel();
				ImperativeTypedModel qvtiTypedModel = visitor.getQVTiTypedModel(qvtmTypedModel);
				if (qvtiTypedModel != null) {
					checkableTypedModels.add(qvtiTypedModel);
				}
			}
		}
	}
}