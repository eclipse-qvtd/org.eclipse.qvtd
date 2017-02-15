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
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;

public class RootRegion2Mapping extends AbstractScheduledRegion2Mapping
{
	/**
	 * Mapping from the type to allInstances variable.
	 */
	private final @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull AppendParameter> classDatumAnalysis2variable = new HashMap<>();

	/**
	 * Mapping from the scheduled Nodes to their QVTi variables.
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Variable> node2variable = new HashMap<>();
	//	private Variable rootsVariable = null;

	//	private final @NonNull Map<@NonNull NodeConnection, @NonNull ConnectionVariable> connection2variable = new HashMap<@NonNull NodeConnection, @NonNull ConnectionVariable>();

	public RootRegion2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull LoadingRegion region) {
		super(visitor, region);
		//
		//	Create domains
		//
		Set<@NonNull ImperativeTypedModel> checkableTypedModels = new HashSet<>();
		for (@NonNull Node node : RegionUtil.getNodes(region)) {
			ClassDatumAnalysis classDatumAnalysis = node.getClassDatumAnalysis();
			org.eclipse.ocl.pivot.Class type = classDatumAnalysis.getCompleteClass().getPrimaryClass();
			if (!(type instanceof DataType) && !(type instanceof AnyType) && !(type instanceof VoidType) && !(type instanceof InvalidType)) {
				TypedModel qvtmTypedModel = classDatumAnalysis.getTypedModel();
				ImperativeTypedModel qvtiTypedModel = visitor.getQVTiTypedModel(qvtmTypedModel);
				if (qvtiTypedModel != null) {
					checkableTypedModels.add(qvtiTypedModel);
				}
			}
		}
	}

	private @NonNull ConnectionVariable createRootConnectionVariable(@NonNull String name, boolean isStrict, @NonNull Type type, @Nullable OCLExpression initExpression) {
		//		Type variableType = visitor.getEnvironmentFactory().getCompleteEnvironment().getSetType(node.getCompleteClass().getPrimaryClass(), true, null, null);
		//		assert variableType != null;
		BufferStatement variable = helper.createBufferStatement(getSafeName(name), isStrict, type, true, initExpression);
		mapping.getOwnedStatements().add(variable);
		//		Variable oldVariable = node2variable.put(node, variable);
		//		assert oldVariable == null;
		return variable;
	}

	private void createRootConnectionVariables() {
		List<@NonNull NodeConnection> rootConnections = new ArrayList<>(region.getRootConnections());
		Collections.sort(rootConnections, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull NodeConnection rootConnection : rootConnections) {
			Type commonType = getConnectionSourcesType(rootConnection);
			Node regionNode = rootConnection.basicGetSource(region);
			String name = rootConnection.getName();
			assert name != null;
			if (regionNode != null) {
				ClassDatumAnalysis classDatumAnalysis = regionNode.getClassDatumAnalysis();
				AppendParameter allInstancesVariable = classDatumAnalysis2variable.get(classDatumAnalysis);
				if (allInstancesVariable == null) {
					Type collectionType = classDatumAnalysis.getCompleteClass().getPrimaryClass();
					Type elementType = ((CollectionType)collectionType).getElementType();
					assert elementType != null;
					assert !(elementType instanceof CollectionType);
					String safeName = getSafeName(name);
					allInstancesVariable = helper.createAppendParameter(safeName, elementType, true); //DeclareStatement(safeName, sourceType, true, asSource);
					mapping.getOwnedMappingParameters().add(allInstancesVariable);
					classDatumAnalysis2variable.put(classDatumAnalysis, allInstancesVariable);
				}
				connection2variable.put(rootConnection, allInstancesVariable);
			}
			else {
				connection2variable.put(rootConnection, createRootConnectionVariable(name, false, commonType, null));
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
		for (@NonNull Region callableRegion : region.getCallableChildren()) {
			if (isInstall(callableRegion)) {
				ownedStatements.add(createInstall(callableRegion));
			}
			else {
				ownedStatements.add(createCall(callableRegion, null));
			}
		}
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
		for (@NonNull Node node : RegionUtil.getSourceEnds(rootConnection)) {
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

	protected boolean isInstall(@NonNull Region calledRegion) {
		AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
		for (@NonNull Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
			NodeConnection callingConnection = calledGuardNode.getIncomingPassedConnection();
			if (callingConnection == null) {
				return false;
			}
		}
		return true;
	}
}