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
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.CyclicScheduledRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeConnection;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

import com.google.common.collect.Iterables;

public class CyclicScheduledRegion2Mapping extends AbstractScheduledRegion2Mapping
{
	/**
	 * RecursionContext coordinates the variables associated with one (of many) recursive connections in a CyclicRegion.
	 */
	private class RecursionContext
	{
		/**
		 * The recursing type.
		 */
		private final @NonNull ClassDatumAnalysis classDatumAnalysis;
		
		/**
		 * A distinctive number for distinctive auto-generated per-recursion names.
		 */
		private final int index;

		/**
		 * The accumulated output connection for the recursed type.
		 */
		private NodeConnection accumulatedConnection;

		/**
		 * The guard variable for the recursed type.
		 */
		private final @NonNull Variable guardVariable;

		/**
		 * The local accumulation variable for the recursed type. Already processed values may be present.
		 */
		private final @NonNull ConnectionVariable localVariable;

		/**
		 * The filtered local accumulation variable for the recursed type. Already processed values have been removed.
		 */
		private @Nullable ConnectionVariable newVariable;

		/**
		 * The accumulated output variable for the recursed type.
		 */
		private ConnectionVariable accumulatedVariable;

		public RecursionContext(@NonNull Node headNode) {
			this.classDatumAnalysis = headNode.getClassDatumAnalysis();
			this.index = classDatumAnalysis2recursion.size();
			//
			//	Create/locate the domain and guard pattern for the guard.
			//
			GuardPattern guardPattern = getGuardPattern(classDatumAnalysis);
			//
			//	Create the domain guard variable.
			//
			org.eclipse.ocl.pivot.Class elementType = classDatumAnalysis.getCompleteClass().getPrimaryClass();
			guardVariable = PivotUtil.createVariable(getSafeName(headNode), elementType, false, null);
			guardPattern.getVariable().add(guardVariable);
			
			Iterable<@NonNull NodeConnection> outgoingConnections = headNode.getOutgoingPassedConnections();
			assert Iterables.size(outgoingConnections) == 1;
			NodeConnection outgoingConnection = Iterables.get(outgoingConnections, 0);
//			Class elementType = classDatumAnalysis.getCompleteClass().getPrimaryClass();
//			Variable variable = PivotUtil.createVariable(getSafeName(headNode), elementType, false, null);
//			guardPattern.getVariable().add(variable);
//			Variable oldVariable = classDatumAnalysis2headVariable.put(classDatumAnalysis, variable);
//			assert oldVariable == null;
			NodeConnection incomingConnection = headNode.getIncomingPassedConnection();
			assert incomingConnection != null;
			connection2variable.put(incomingConnection, guardVariable);
			//
			//	Create the local accumulation variable.
			//
//				Iterable<@NonNull NodeConnection> internallyPassedConnections = headNode.getOutgoingPassedConnections();
//				assert Iterables.size(internallyPassedConnections) == 1;
//				ClassDatumAnalysis incomingClassDatumAnalysis = incomingConnection.getClassDatumAnalysis();
//				NodeConnection internallyPassedConnection = Iterables.get(internallyPassedConnections, 0);
//				ClassDatumAnalysis outgoingClassDatumAnalysis = internallyPassedConnection.getClassDatumAnalysis();
//				if ((outgoingClassDatumAnalysis == incomingClassDatumAnalysis)
//				 && !incoming2outgoing.values().contains(internallyPassedConnection)) {	// Multiple should not occur, but line them up pair-wise
//					incoming2outgoing.put(incomingConnection, internallyPassedConnection);
			Type asType = getConnectionSourcesType(incomingConnection);
			String localName = "«local" + (index > 0 ? Integer.toString(index) : "") + "»";
			localVariable = helper.createConnectionVariable(localName, asType, null);
			mapping.getBottomPattern().getVariable().add(localVariable);
			connection2variable.put(outgoingConnection, localVariable);
	//
			if ((asType instanceof CollectionType) && ((CollectionType)asType).isUnique()) {
				String newName = "«new" + (index > 0 ? Integer.toString(index) : "") + "»";
				ConnectionVariable newVariable2 = newVariable = helper.createConnectionVariable(newName, asType, null);
				mapping.getBottomPattern().getVariable().add(newVariable2);
				connection2variable.put(outgoingConnection, newVariable2);
			}
			else {
				allRecursionsAreUnique = false;
			}
		}

		public @Nullable NodeConnection getAccumulatedConnection() {
			return accumulatedConnection;
		}

		public @Nullable ConnectionVariable getAccumulatedVariable() {
			return accumulatedVariable;
		}

		public @NonNull ClassDatumAnalysis getClassDatumAnalysis() {
			return classDatumAnalysis;
		}

		public @NonNull Variable getGuardVariable() {
			return guardVariable;
		}

		public @NonNull ConnectionVariable getLocalVariable() {
			return localVariable;
		}

		public @Nullable ConnectionVariable getNewVariable() {
			return newVariable;
		}

		public void setAccumulatedConnection(@NonNull NodeConnection accumulatedConnection) {
			this.accumulatedConnection = accumulatedConnection;
			//
			//	Select a/the outgoing recursive intermediate connection. 
			//
			NodeConnection intermediateConnection = accumulatedConnection;
			ConnectionVariable accumulatedVariable2 = accumulatedVariable = createConnectionVariable(intermediateConnection);
			mapping.getGuardPattern().getVariable().add(accumulatedVariable2);
			connection2variable.put(intermediateConnection, accumulatedVariable2);
		}
	}
	
	/**
	 * The recursions.
	 */
	private final @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull RecursionContext> classDatumAnalysis2recursion = new HashMap<@NonNull ClassDatumAnalysis, @NonNull RecursionContext>();

	/**
	 * True if all recursions use Set accumulators allowing the unqiueness to be determined by excliusion rather than 
	 * by re-invocation suppression.
	 */
	private boolean allRecursionsAreUnique = false;

	/**
	 * Cache of the domains created for each recursiing typed model
	 */
	private final @NonNull Map<@NonNull TypedModel, @NonNull ImperativeDomain> typedModel2domain = new HashMap<@NonNull TypedModel, @NonNull ImperativeDomain>();

	public CyclicScheduledRegion2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull CyclicScheduledRegion region) {
		super(visitor, region);
		//
		//	Create a guard for each head and place it in a corresponding domain.
		//	Create a local accumulation variable for each head and place it the the middle bottom domain.
		//	Create an outgoing accumulation variable for each head and place it the the middle guard domain.
		//
		for (@NonNull Node headNode : region.getHeadNodes()) {
			//
			//	Create/locate the domain and guard pattern for the guard.
			//
			RecursionContext newRecursion = new RecursionContext(headNode);
			RecursionContext oldRecursion = classDatumAnalysis2recursion.put(newRecursion.getClassDatumAnalysis(), newRecursion);
			assert oldRecursion == null;
		}
		for (@NonNull NodeConnection accumulatedConnection : region.getIntermediateConnections()) {
			ClassDatumAnalysis classDatumAnalysis = accumulatedConnection.getClassDatumAnalysis();
			RecursionContext recursion = classDatumAnalysis2recursion.get(classDatumAnalysis);
			if (recursion != null) {
				recursion.setAccumulatedConnection(accumulatedConnection);
			}
		}
		//
		//	Create any non-recursion connectionVariable guards
		//
		createConnectionGuardVariables();
	}

	/**
	 * Create the guard variables for the intermediate connections that are not recursions.
	 */
	@Override
	protected void createConnectionGuardVariables() {
		List<@NonNull NodeConnection> intermediateConnections = region.getIntermediateConnections();
		for (@NonNull NodeConnection intermediateConnection : intermediateConnections) {
			Variable connectionVariable = connection2variable.get(intermediateConnection);
			if (connectionVariable == null) {
				String name = intermediateConnection.getName();
				assert name != null;
				connectionVariable = helper.createConnectionVariable(name, getConnectionSourcesType(intermediateConnection), null);
				connection2variable.put(intermediateConnection, connectionVariable);
				mapping.getGuardPattern().getVariable().add(connectionVariable);
			}
		}
	}

	@Override
	public @NonNull MappingCall createMappingCall(@NonNull List<@NonNull MappingCallBinding> mappingCallBindings) {
		MappingCall mappingCall = super.createMappingCall(mappingCallBindings);
		if (!allRecursionsAreUnique) {
			mappingCall.setIsInfinite(true);		// FIXME share code
		}
		return mappingCall;
	}

	@Override
	protected @NonNull OCLExpression createSelectByKind(@NonNull Node resultNode) {
		throw new UnsupportedOperationException();
/*		Variable resultVariable = classDatumAnalysis2headVariable.get(resultNode.getClassDatumAnalysis());
		if (resultVariable == null) {
			OCLExpression asSource = createNullLiteralExp(); //PivotUtil.createVariableExp(getChildrenVariable());
			CompleteClass sourceCompleteClass = resultNode.getCompleteClass();
			CollectionType sourceCollectionType = (CollectionType) sourceCompleteClass.getPrimaryClass();
			Type sourceElementType = sourceCollectionType.getElementType();
			assert sourceElementType != null;
			CompleteClass sourceElementClass = visitor.getEnvironmentFactory().getCompleteModel().getCompleteClass(sourceElementType);
			OCLExpression asTypeExp = createTypeExp(sourceElementClass);
			OCLExpression selectExp = createOperationCallExp(asSource, getSelectByKindOperation(), asTypeExp);
			resultVariable = PivotUtil.createVariable(resultNode.getName(), selectExp);
			mapping.getBottomPattern().getVariable().add(resultVariable);
			classDatumAnalysis2headVariable.put(resultNode.getClassDatumAnalysis(), resultVariable);
		}
		return PivotUtil.createVariableExp(resultVariable); */
	}

	@Override
	public void createStatements() {
		MappingStatement mappingStatement = null;
		for (@NonNull Region callableRegion : region.getCallableChildren()) {
			AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(callableRegion);
			Map<@NonNull Variable, @NonNull OCLExpression> guardVariable2expression = new HashMap<@NonNull Variable, @NonNull OCLExpression>();
			for (@NonNull Node calledHeadNode : callableRegion.getHeadNodes()) {
				NodeConnection headConnection = calledHeadNode.getIncomingConnection();
				assert headConnection != null;
				Node callingHeadNode = Iterables.get(headConnection.getSourceNodes(), 0);
				Variable callingHeadVariable = getGuardVariable(callingHeadNode);
				Variable calledHeadVariable = calledRegion2Mapping.getGuardVariable(calledHeadNode);
				guardVariable2expression.put(calledHeadVariable, PivotUtil.createVariableExp(callingHeadVariable));
			}
			for (@NonNull NodeConnection intermediateConnection : callableRegion.getIntermediateConnections()) {
				RecursionContext recursion = classDatumAnalysis2recursion.get(intermediateConnection.getClassDatumAnalysis());
				if (recursion != null) {
					Variable callingLocalVariable = recursion.getLocalVariable();
//					NodeConnection tailConnection = recursion.getAccumulatedConnection();
//					if (tailConnection != null) {
						Variable calledTailVariable = calledRegion2Mapping.getConnectionVariable(intermediateConnection);
						guardVariable2expression.put(calledTailVariable, PivotUtil.createVariableExp(callingLocalVariable));
//					}
				}
			}
			mappingStatement = createCall(mappingStatement, callableRegion, guardVariable2expression);
		}
		//
		//	Create connection assignments to pass local creations to the accumulated result.
		//
		for (@NonNull RecursionContext recursion : classDatumAnalysis2recursion.values()) {
			ConnectionVariable accumulatedVariable = recursion.getAccumulatedVariable();
			if (accumulatedVariable != null) {
				ConnectionVariable localVariable = recursion.getLocalVariable();
				ConnectionVariable newVariable = recursion.getNewVariable();
				if (newVariable != null) {
					ParametersId parametersId = IdManager.getParametersId(TypeId.COLLECTION.getSpecializedId(TypeId.OCL_ANY));
					OperationId operationId = TypeId.COLLECTION.getOperationId(1, "excludingAll", parametersId);
					Operation operation = visitor.getEnvironmentFactory().getIdResolver().getOperation(operationId);
					VariableExp localVariableExp = PivotUtil.createVariableExp(localVariable);
					VariableExp resultVariableExp = PivotUtil.createVariableExp(accumulatedVariable);
					OperationCallExp excludingAllCallExp = PivotUtil.createOperationCallExp(localVariableExp, operation, resultVariableExp);
					excludingAllCallExp.setType(localVariableExp.getType());
					excludingAllCallExp.setIsRequired(localVariableExp.isIsRequired());
					
					
					ConnectionStatement connectionStatement1 = QVTimperativeFactory.eINSTANCE.createConnectionStatement();
					connectionStatement1.setTargetVariable(newVariable);
					connectionStatement1.setValue(excludingAllCallExp);
					mappingStatement = QVTimperativeUtil.addMappingStatement(mappingStatement, connectionStatement1);
				}
				else {
					newVariable = localVariable;
				}
				//
				ConnectionStatement connectionStatement2 = QVTimperativeFactory.eINSTANCE.createConnectionStatement();
				connectionStatement2.setTargetVariable(accumulatedVariable);
				connectionStatement2.setValue(PivotUtil.createVariableExp(newVariable));
				mappingStatement = QVTimperativeUtil.addMappingStatement(mappingStatement, connectionStatement2);
			}
		}
		//
		//	Create the recursive call recursing all the recursive connections.
		//
		Map<@NonNull Variable, @NonNull OCLExpression> guardVariable2expression = new HashMap<@NonNull Variable, @NonNull OCLExpression>();
		for (@NonNull RecursionContext recursion : classDatumAnalysis2recursion.values()) {
			Variable guardVariable = recursion.getGuardVariable();
			Variable newVariable = recursion.getNewVariable();
			if (newVariable == null) {
				newVariable = recursion.getLocalVariable();
			}
			VariableExp localVariableExp = PivotUtil.createVariableExp(newVariable);
			guardVariable2expression.put(guardVariable, localVariableExp);
		}
		mappingStatement = createCall(mappingStatement, region, guardVariable2expression);
		mapping.setMappingStatement(mappingStatement);
	}

	@Override
	public @NonNull List<@NonNull Node> getGuardNodes() {
		return getHeadNodes();
	}

	public @NonNull GuardPattern getGuardPattern(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		//
		//	Create/locate the domain and guard pattern for the guard.
		//
		TypedModel typedModel = visitor.getQVTiTypedModel(classDatumAnalysis.getTypedModel());
		GuardPattern guardPattern;
		if (typedModel != null) {
			ImperativeDomain domain = typedModel2domain.get(typedModel);
			if (domain == null) {
				domain = QVTimperativeUtil.createImperativeDomain(typedModel);
				domain.setIsCheckable(true);
				mapping.getDomain().add(domain);
				typedModel2domain.put(typedModel, domain);
			}
			guardPattern = domain.getGuardPattern();
		}
		else {
			guardPattern = mapping.getGuardPattern();
		}
		assert guardPattern != null;
		return guardPattern;
	}

	@Override
	public @NonNull Variable getGuardVariable(@NonNull Node node) {
		assert getHeadNodes().contains(node);
		ClassDatumAnalysis classDatumAnalysis = node.getClassDatumAnalysis();
		RecursionContext recursion = classDatumAnalysis2recursion.get(classDatumAnalysis);
		assert recursion != null;
		return recursion.getGuardVariable();
	}

	private @NonNull List<@NonNull Node> getHeadNodes() {
		return region.getHeadNodes();
	}
}