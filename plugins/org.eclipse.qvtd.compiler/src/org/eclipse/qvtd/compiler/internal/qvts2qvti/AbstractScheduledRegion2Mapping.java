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
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

public abstract class AbstractScheduledRegion2Mapping extends AbstractRegion2Mapping
{
	protected AbstractScheduledRegion2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull Region region) {
		super(visitor, region);
		connection2variable = new HashMap<>();
	}

	protected @NonNull MappingStatement createCall(@NonNull Region calledRegion, @Nullable Map<@NonNull VariableDeclaration, @NonNull OCLExpression> guardVariable2expression) {
		//		Iterable<Connection> connectionRegions = getConnectionRegions(calledRegion);
		//		assert !calledRegion.isConnectionRegion();
		AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
		Map<@NonNull LoopVariable, @NonNull OCLExpression> loopVariables = new HashMap<>();
		List<@NonNull MappingParameterBinding> mappingParameterBindings = new ArrayList<>();
		for (@NonNull Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
			VariableDeclaration guardVariable = calledRegion2Mapping.getGuardVariable(calledGuardNode);
			NodeConnection callingConnection = calledGuardNode.getIncomingPassedConnection();
			if (callingConnection != null) {
				OCLExpression connectionExpression = null;
				if (guardVariable2expression != null) {
					connectionExpression = guardVariable2expression.get(guardVariable);
				}
				if (connectionExpression == null) {
					ConnectionVariable connectionVariable = connection2variable.get(callingConnection);
					if (connectionVariable != null) {
						connectionExpression = PivotUtil.createVariableExp(connectionVariable);
					}
					else {
						Node callingNode = callingConnection.getSource(region);
						connectionExpression = createSelectByKind(callingNode);
					}
				}
				Type type = connectionExpression.getType();
				assert type instanceof CollectionType;
				Type elementType = ((CollectionType)type).getElementType();
				assert elementType != null;
				LoopVariable loopVariable = helper.createLoopVariable("loop" + loopVariables.size(), elementType);//, true, connectionExpression);
				loopVariables.put(loopVariable, connectionExpression);
				mappingParameterBindings.add(helper.createLoopParameterBinding((GuardParameter) guardVariable, loopVariable));
			}
			for (@NonNull Node callingNode : calledGuardNode.getUsedBindingSources()) {
				if (callingNode.getOwningRegion() == region) {
					OCLExpression sourceExpression = createSelectByKind(callingNode);
					mappingParameterBindings.add(helper.createSimpleParameterBinding((SimpleParameter) guardVariable, sourceExpression));
				}
			}
		}
		/*		for (@NonNull NodeConnection headConnection : calledRegion.getHeadConnections()) {	// FIXME unify headConnections/headNodes
			Variable calledConnectionVariable = calledRegion2Mapping.getConnectionVariable(headConnection);
			Variable callingConnectionVariable = connection2variable.get(headConnection);
			assert callingConnectionVariable != null;
			OCLExpression sourceExpression = PivotUtil.createVariableExp(callingConnectionVariable);
			mappingParameterBindings.add(QVTimperativeUtil.createMappingParameterBinding(calledConnectionVariable, sourceExpression));
		} */
		for (@NonNull NodeConnection intermediateConnection : calledRegion.getIntermediateConnections()) {
			ConnectionVariable calledConnectionVariable = calledRegion2Mapping.getConnectionVariable(intermediateConnection);
			/*			OCLExpression connectionExpression = null;
			if (guardVariable2expression != null) {
				connectionExpression = guardVariable2expression.get(calledConnectionVariable);
			}
			if (connectionExpression == null) { */
			ConnectionVariable callingConnectionVariable = connection2variable.get(intermediateConnection);
			assert callingConnectionVariable != null;
			/*				OCLExpression sourceExpression = PivotUtil.createVariableExp(callingConnectionVariable);
				Type calledType = calledConnectionVariable.getType();
				Type callingType = callingConnectionVariable.getType();
				assert calledType != null;
				assert callingType != null;
				if (getCollectionDepth(calledType) < getCollectionDepth(callingType)) {
					LoopVariable loopVariable = helper.createLoopVariable("loop" + loopVariables.size(), calledType);//, true, sourceExpression);
					loopVariables.put(loopVariable, sourceExpression);
					sourceExpression = PivotUtil.createVariableExp(loopVariable);
				}
				connectionExpression = sourceExpression;
			} */
			mappingParameterBindings.add(helper.createAppendParameterBinding((AppendParameter)calledConnectionVariable, callingConnectionVariable));
		}
		Collections.sort(mappingParameterBindings, QVTimperativeUtil.MappingParameterBindingComparator.INSTANCE);
		MappingStatement mappingCallStatement = calledRegion2Mapping.createMappingCall(mappingParameterBindings);
		for (Map./*@NonNull*/Entry<@NonNull LoopVariable, @NonNull OCLExpression> loopEntry : loopVariables.entrySet()) {
			@NonNull LoopVariable loopVariable = loopEntry.getKey();
			@NonNull OCLExpression loopSource = loopEntry.getValue();
			mappingCallStatement = helper.createMappingLoop(loopSource, loopVariable, mappingCallStatement);
		}
		return mappingCallStatement;
	}

	protected @NonNull MappingStatement createInstall(@NonNull Region calledRegion) {
		//		Iterable<Connection> connectionRegions = getConnectionRegions(calledRegion);
		//		assert !calledRegion.isConnectionRegion();
		AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
		//		Mapping calledMapping = calledRegion2Mapping.getMapping();
		List<@NonNull MappingParameterBinding> mappingParameterBindings = new ArrayList<>();
		for (@NonNull Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
			if (!calledGuardNode.isDependency()) {
				VariableDeclaration guardVariable = calledRegion2Mapping.getGuardVariable(calledGuardNode);
				NodeConnection callingConnection = calledGuardNode.getIncomingPassedConnection();
				assert callingConnection != null;
				ConnectionVariable connectionVariable = connection2variable.get(callingConnection);
				assert connectionVariable != null;
				if (guardVariable instanceof AppendParameter) {
					mappingParameterBindings.add(helper.createAppendParameterBinding((AppendParameter) guardVariable, connectionVariable));
				}
				else if (guardVariable instanceof GuardParameter) {
					mappingParameterBindings.add(helper.createGuardParameterBinding((GuardParameter) guardVariable, connectionVariable));
				}
				else {
					throw new UnsupportedOperationException();
					/*			for (@NonNull Node callingNode : calledGuardNode.getUsedBindingSources()) {
						if (callingNode.getRegion() == region) {
							OCLExpression sourceExpression = createSelectByKind(callingNode);
							mappingParameterBindings.add(helper.createSimpleParameterBinding((SimpleParameter) guardVariable, sourceExpression));
						}
					} */
				}
			}
		}
		/*		for (@NonNull NodeConnection headConnection : calledRegion.getHeadConnections()) {	// FIXME unify headConnections/headNodes
			Variable calledConnectionVariable = calledRegion2Mapping.getConnectionVariable(headConnection);
			Variable callingConnectionVariable = connection2variable.get(headConnection);
			assert callingConnectionVariable != null;
			OCLExpression sourceExpression = PivotUtil.createVariableExp(callingConnectionVariable);
			mappingParameterBindings.add(QVTimperativeUtil.createMappingParameterBinding(calledConnectionVariable, sourceExpression));
		} */
		for (@NonNull NodeConnection intermediateConnection : calledRegion.getIntermediateConnections()) {
			ConnectionVariable calledConnectionVariable = calledRegion2Mapping.getConnectionVariable(intermediateConnection);
			/*			OCLExpression connectionExpression = null;
			if (guardVariable2expression != null) {
				connectionExpression = guardVariable2expression.get(calledConnectionVariable);
			}
			if (connectionExpression == null) { */
			ConnectionVariable callingConnectionVariable = connection2variable.get(intermediateConnection);
			assert callingConnectionVariable != null;
			/*				OCLExpression sourceExpression = PivotUtil.createVariableExp(callingConnectionVariable);
				Type calledType = calledConnectionVariable.getType();
				Type callingType = callingConnectionVariable.getType();
				assert calledType != null;
				assert callingType != null;
				if (getCollectionDepth(calledType) < getCollectionDepth(callingType)) {
					LoopVariable loopVariable = helper.createLoopVariable("loop" + loopVariables.size(), calledType);//, true, sourceExpression);
					loopVariables.put(loopVariable, sourceExpression);
					sourceExpression = PivotUtil.createVariableExp(loopVariable);
				}
				connectionExpression = sourceExpression;
			} */
			mappingParameterBindings.add(helper.createAppendParameterBinding((AppendParameter)calledConnectionVariable, callingConnectionVariable));
		}
		Collections.sort(mappingParameterBindings, QVTimperativeUtil.MappingParameterBindingComparator.INSTANCE);
		MappingCall mappingCallStatement = calledRegion2Mapping.createMappingCall(mappingParameterBindings);
		mappingCallStatement.setIsInstall(true);
		//		for (Map./*@NonNull*/Entry<@NonNull LoopVariable, @NonNull OCLExpression> loopEntry : loopVariables.entrySet()) {
		//			@NonNull LoopVariable loopVariable = loopEntry.getKey();
		//			@NonNull OCLExpression loopSource = loopEntry.getValue();
		//			mappingCallStatement = QVTimperativeUtil.createMappingLoop(loopSource, loopVariable, mappingCallStatement);
		//		}
		return mappingCallStatement;
	}

	protected abstract @NonNull OCLExpression createSelectByKind(@NonNull Node resultNode);
}