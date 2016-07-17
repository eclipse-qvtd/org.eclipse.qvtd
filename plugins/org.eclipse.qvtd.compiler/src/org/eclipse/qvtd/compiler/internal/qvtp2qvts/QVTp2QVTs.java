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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.utilities.DependencyUtil;

import com.google.common.collect.Iterables;

public class QVTp2QVTs extends SchedulerConstants
{
	public static final @NonNull TracingOption CONNECTION_CREATION = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/connectionCreation");
	public static final @NonNull TracingOption CONNECTION_ROUTING = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/connectionRouting");
	public static final @NonNull TracingOption DEBUG_GRAPHS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/debugGraphs");
	public static final @NonNull TracingOption DUMP_CLASS_TO_CONSUMING_NODES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dump/class2consumingNodes");
	public static final @NonNull TracingOption DUMP_CLASS_TO_CONTAINING_PROPERTIES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dump/class2containingProperty");
	public static final @NonNull TracingOption DUMP_CLASS_TO_REALIZED_NODES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dump/class2realizedNodes");
	public static final @NonNull TracingOption DUMP_INPUT_MODEL_TO_DOMAIN_USAGE = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dump/inputModel2domainUsage");
	public static final @NonNull TracingOption DUMP_PROPERTY_TO_CONSUMING_CLASSES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dump/property2consumingClass");

	/**
	 * The Region to which each action is allocated.
	 */
	private final @NonNull Map<@NonNull AbstractAction, @NonNull SimpleMappingRegion> action2mappingRegion = new HashMap<@NonNull AbstractAction, @NonNull SimpleMappingRegion>();

	private final @NonNull List<@NonNull AbstractAction> orderedActions;

	public QVTp2QVTs(@NonNull EnvironmentFactory environmentFactory, @NonNull Schedule dependencyGraph, @NonNull QVTp2QVTg qvtp2qvtg) {
		super(environmentFactory, dependencyGraph, qvtp2qvtg);
		DependencyUtil.NaturalOrderer orderer = new DependencyUtil.NaturalOrderer(dependencyGraph);
		List<@NonNull AbstractAction> orderedActions = orderer.computeOrdering();
		if (orderedActions == null) {
			throw new IllegalArgumentException(orderer.diagnoseOrderingFailure());
		}
		this.orderedActions = orderedActions;
	}

	private Map<OperationDatum, OperationRegion> map = new HashMap<OperationDatum, OperationRegion>();

	public @NonNull OperationRegion analyzeOperation(@NonNull MultiRegion multiRegion, @NonNull OperationCallExp operationCallExp) {
		Operation operation = operationCallExp.getReferredOperation();
		LanguageExpression bodyExpression = operation.getBodyExpression();
		assert  bodyExpression != null;
		ExpressionInOCL specification;
		try {
			specification = getEnvironmentFactory().getMetamodelManager().parseSpecification(bodyExpression);
			OperationDatum operationDatum = createOperationDatum(operationCallExp);
			OperationRegion operationRegion = map.get(operationDatum);
			if (operationRegion == null) {
				operationRegion = new OperationRegion(multiRegion, operationDatum, specification, operationCallExp);
				map.put(operationDatum, operationRegion);
				if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
					operationRegion.writeDebugGraphs("1-create");
				}
			}
			return operationRegion;
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UnsupportedOperationException(e);
		}
	}

	private @NonNull OperationDatum createOperationDatum(@NonNull OperationCallExp operationCallExp) {
		Iterable<@NonNull VariableDeclaration> externalVariables = QVTbaseUtil.getExternalVariables(operationCallExp);
		List<@NonNull OCLExpression> ownedArguments = ClassUtil.nullFree(operationCallExp.getOwnedArguments());
		@NonNull ClassDatum[] classDatums = new @NonNull ClassDatum[1 + ownedArguments.size() + Iterables.size(externalVariables)];
		int i = 0;
		@SuppressWarnings("null")@NonNull OCLExpression source = operationCallExp.getOwnedSource();
		classDatums[i++] = getClassDatum(source);
		for (@NonNull OCLExpression argument : ownedArguments) {
			classDatums[i++] = getClassDatum(argument);
		}
		for (@NonNull VariableDeclaration externalVariable : externalVariables) {
			classDatums[i++] = getClassDatum(externalVariable);
		}
		String operationName = operationCallExp.getReferredOperation().getName();
		assert operationName != null;
		return new OperationDatum(this, operationName, classDatums);
	}

	@Override
	protected @NonNull ClassDatumAnalysis createClassDatumAnalysis(@NonNull ClassDatum classDatum) {
		return new ClassDatumAnalysis(this, classDatum);
	}

	public @NonNull SimpleMappingRegion getMappingRegion(@NonNull AbstractAction action) {
		SimpleMappingRegion mappingRegion = action2mappingRegion.get(action);
		assert mappingRegion != null;
		return mappingRegion;
	}

	public @NonNull MultiRegion transform() throws IOException {
		MultiRegion multiRegion = new MultiRegion(this);
		//
		//	Extract salient characteristics from within each MappingAction.
		//
		for (int i = 0; i < orderedActions.size(); i++) {
			@NonNull AbstractAction abstractAction = orderedActions.get(i);
			if (abstractAction instanceof MappingAction) {
				MappingAction mappingAction = (MappingAction) abstractAction;
				SimpleMappingRegion mappingRegion = new SimpleMappingRegion(multiRegion, mappingAction, i);
				mappingRegion.initialize();
				action2mappingRegion.put(abstractAction, mappingRegion);
			}
		}
		List<@NonNull SimpleMappingRegion> mappingRegions = new ArrayList<@NonNull SimpleMappingRegion>(action2mappingRegion.values());
		Collections.sort(mappingRegions, NameUtil.NAMEABLE_COMPARATOR);		// Stabilize side effect of symbol name disambiguator suffixes
		for (@NonNull SimpleMappingRegion mappingRegion : mappingRegions) {
			mappingRegion.registerConsumptionsAndProductions();
		}
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			for (@NonNull SimpleMappingRegion mappingRegion : mappingRegions) {
				mappingRegion.writeDebugGraphs("1-create");
			}
		}
		List<@NonNull SimpleMappingRegion> orderedRegions = new ArrayList<@NonNull SimpleMappingRegion>();
		for (@NonNull AbstractAction abstractAction : orderedActions) {
			SimpleMappingRegion mappingRegion = action2mappingRegion.get(abstractAction);
			assert mappingRegion != null;
			orderedRegions.add(mappingRegion);
			mappingRegion.resolveRecursion();
		}
		multiRegion.setOrderedRegions(orderedRegions);
		return multiRegion;
	}
}
