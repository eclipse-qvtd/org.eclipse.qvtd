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
import org.eclipse.ocl.pivot.CollectionKind;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigableEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeConnection;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RootCompositionRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SchedulerConstants;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class RootRegion2Mapping extends AbstractScheduledRegion2Mapping
{
	/**
	 * Mapping from the type to allInstances variable.
	 */
	private final @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull Variable> classDatumAnalysis2variable = new HashMap<@NonNull ClassDatumAnalysis, @NonNull Variable>();

	/**
	 * Mapping from the scheduled Nodes to their QVTi variables.
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Variable> node2variable = new HashMap<@NonNull Node, @NonNull Variable>();
//	private Variable rootsVariable = null;

//	private final @NonNull Map<@NonNull NodeConnection, @NonNull ConnectionVariable> connection2variable = new HashMap<@NonNull NodeConnection, @NonNull ConnectionVariable>();

	public RootRegion2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull RootCompositionRegion region) {
		super(visitor, region);
		//
		//	Create domains
		//
		Set<@NonNull TypedModel> checkableTypedModels = new HashSet<@NonNull TypedModel>();
		for (@NonNull Node node : region.getNodes()) {
			ClassDatumAnalysis classDatumAnalysis = node.getClassDatumAnalysis();
			Type type = classDatumAnalysis.getClassDatum().getType();
			if (!(type instanceof DataType) && !(type instanceof AnyType) && !(type instanceof VoidType) && !(type instanceof InvalidType)) {
				TypedModel qvtpTypedModel = classDatumAnalysis.getTypedModel();
				TypedModel qvtiTypedModel = visitor.getQVTiTypedModel(qvtpTypedModel);
				if (qvtiTypedModel != null) {
					checkableTypedModels.add(qvtiTypedModel);
				}
			}
		}
		for (@NonNull TypedModel qvtiTypedModel : checkableTypedModels) {
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

	private @NonNull OCLExpression createObjectsOfKindExpression(@NonNull Node resultNode) {	// FIXME compute input typed model
		ClassDatumAnalysis classDatumAnalysis = resultNode.getClassDatumAnalysis();
		Variable allInstancesVariable = classDatumAnalysis2variable.get(classDatumAnalysis);
		if (allInstancesVariable == null) {
			Type collectionType = classDatumAnalysis.getCompleteClass().getPrimaryClass();
			Type elementType = ((CollectionType)collectionType).getElementType();
			assert elementType != null;
			assert !(elementType instanceof CollectionType);
			StandardLibraryInternal standardLibrary = (StandardLibraryInternal)visitor.getStandardLibrary();
			TypedModel typedModel = visitor.getQVTiTypedModel(classDatumAnalysis.getTypedModel());
			assert typedModel != null;
			Variable contextVariable = QVTbaseUtil.getContextVariable(standardLibrary, typedModel);
			VariableExp modelExp = helper.createVariableExp(contextVariable);
			TypeExp typeExp = helper.createTypeExp(elementType);
			OCLExpression asSource = helper.createOperationCallExp(modelExp, "objectsOfKind", typeExp);
			allInstancesVariable = PivotUtil.createVariable(resultNode.getName(), asSource);
			mapping.getBottomPattern().getVariable().add(allInstancesVariable);
			classDatumAnalysis2variable.put(classDatumAnalysis, allInstancesVariable);
		}
		return helper.createVariableExp(allInstancesVariable);
	}
	
	private @NonNull ConnectionVariable createRootConnectionVariable(@NonNull CorePattern pattern, @NonNull String name, @NonNull Type type, @Nullable OCLExpression initExpression) {
//		Type variableType = visitor.getEnvironmentFactory().getCompleteEnvironment().getSetType(node.getCompleteClass().getPrimaryClass(), true, null, null);
//		assert variableType != null;
		ConnectionVariable variable = helper.createConnectionVariable(getSafeName(name), type, initExpression);
		pattern.getVariable().add(variable);
//		Variable oldVariable = node2variable.put(node, variable);
//		assert oldVariable == null;
		return variable;
	}

	private void createRootConnectionVariables() {
		BottomPattern bottomPattern = mapping.getBottomPattern();
		assert bottomPattern != null;
		List<@NonNull NodeConnection> rootConnections = new ArrayList<@NonNull NodeConnection>(region.getRootConnections());
		Collections.sort(rootConnections, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull NodeConnection rootConnection : rootConnections) {
			Type commonType = getConnectionSourcesType(rootConnection);
			Node regionNode = rootConnection.basicGetSource(region);
			String name = rootConnection.getName();
			assert name != null;
			if (regionNode != null) {
				OCLExpression initExpression = createObjectsOfKindExpression(regionNode);
				List<@NonNull Edge> incomingEdges = regionNode.getIncomingEdges();
				switch (incomingEdges.size()) {
					case 0: break;
					case 1: initExpression = getFilteredExpression(initExpression, (NavigableEdge) incomingEdges.get(0)); break;
					default: assert false;
				}
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

	@Override
	protected @NonNull OCLExpression createSelectByKind(@NonNull Node resultNode) {
		throw new UnsupportedOperationException();
/*		Variable resultVariable = node2variable.get(resultNode);
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
		for (@NonNull Region callableRegion : region.getCallableChildren()) {
			mappingStatement = createCall(mappingStatement, callableRegion, null);
		}
		mapping.setMappingStatement(mappingStatement);
	}

	private @NonNull OCLExpression getFilteredExpression(@NonNull OCLExpression initExpression, @NonNull NavigableEdge edge) {
		Type collectionType = initExpression.getType();
		assert collectionType != null;
		Type elementType = ((CollectionType)collectionType).getElementType();
		assert elementType != null;
		@NonNull Variable asIterator = PivotUtil.createVariable("i", elementType, true, null);
		Property child2parentProperty = edge.getProperty().getOpposite();
		assert child2parentProperty != null;
		OCLExpression propertyCallExp = helper.createNavigationCallExp(helper.createVariableExp(asIterator), child2parentProperty);
		if (edge.getSource().isExplicitNull()) {
			OCLExpression equalsExp = helper.createOperationCallExp(propertyCallExp, "=", helper.createNullLiteralExp());
			initExpression = helper.createIteratorExp(initExpression, getSelectIteration(), Collections.singletonList(asIterator), equalsExp);
		}
		else {
//			OCLExpression equalsExp = helper.createOperationCallExp(propertyCallExp, getOclIsKindOfOperation(), createTypeExp());
			OCLExpression notEqualsExp = helper.createOperationCallExp(propertyCallExp, "<>", helper.createNullLiteralExp());
			initExpression = helper.createIteratorExp(initExpression, getSelectIteration(), Collections.singletonList(asIterator), notEqualsExp);
		}
		return initExpression;
	}

	@Override
	public @NonNull List<@NonNull Node> getGuardNodes() {
		return SchedulerConstants.EMPTY_NODE_LIST;
	}

	@Override
	public @NonNull Variable getGuardVariable(@NonNull Node node) {
		Variable variable = node2variable.get(node);
		assert variable != null;
		return variable;
	}

/*	private @NonNull OCLExpression getRootsVariable(@NonNull Node resultNode) {	// FIXME compute input typed model
		Variable rootsVariable2 = rootsVariable;
		if (rootsVariable2 == null) {
			StandardLibraryInternal standardLibrary = (StandardLibraryInternal)visitor.getStandardLibrary();
			TypedModel typedModel = visitor.getQVTiTypedModel(resultNode.getClassDatumAnalysis().getTypedModel());
			assert typedModel != null;
			Variable contextVariable = QVTbaseUtil.getContextVariable(standardLibrary, typedModel);
			VariableExp modelExp = helper.createVariableExp(contextVariable);
			OCLExpression asSource = createOperationCallExp(modelExp, getRootObjectsOperation());
			rootsVariable = rootsVariable2 = PivotUtil.createVariable("roots", asSource);
			mapping.getBottomPattern().getVariable().add(rootsVariable2);
		}
		return helper.createVariableExp(rootsVariable2);
	} */

	protected @NonNull Iteration getSelectIteration() {
		org.eclipse.ocl.pivot.Class collectionType = ((StandardLibraryInternal)visitor.getStandardLibrary()).getSetType();
		Operation selectIteration = NameUtil.getNameable(collectionType.getOwnedOperations(), "select");
		assert selectIteration != null;
		return (Iteration) selectIteration;
	}

	protected Type getType(@NonNull IdResolver idResolver, @NonNull NodeConnection rootConnection) {
		Type commonType = null;
		for (@NonNull Node node : rootConnection.getSources()) {
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
}