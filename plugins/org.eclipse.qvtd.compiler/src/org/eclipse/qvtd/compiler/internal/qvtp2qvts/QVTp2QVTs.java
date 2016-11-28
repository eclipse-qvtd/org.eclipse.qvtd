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
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.EarlyMerger;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;

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
	public static final @NonNull TracingOption EDGE_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/edgeOrder");
	public static final @NonNull TracingOption REGION_CYCLES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionCycles");
	public static final @NonNull TracingOption REGION_DEPTH = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionDepth");
	//	public static final @NonNull TracingOption REGION_LOCALITY = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionLocality");
	public static final @NonNull TracingOption REGION_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionOrder");
	public static final @NonNull TracingOption REGION_STACK = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionStack");
	public static final @NonNull TracingOption REGION_TRAVERSAL = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionTraversal");

	protected final @NonNull ProblemHandler problemHandler;

	/**
	 * The Region to which each mapping is allocated.
	 */
	private final @NonNull Map<@NonNull Mapping, @NonNull BasicMappingRegion> mapping2mappingRegion = new HashMap<>();

	public QVTp2QVTs(@NonNull ProblemHandler problemHandler, @NonNull EnvironmentFactory environmentFactory, @NonNull Transformation asTransformation) {
		super(environmentFactory, asTransformation);
		this.problemHandler = problemHandler;
	}

	private Map<@NonNull OperationDatum, @NonNull OperationRegion> map = new HashMap<>();

	public void addProblem(@NonNull CompilerProblem problem) {
		problemHandler.addProblem(problem);
	}

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
					operationRegion.writeDebugGraphs(null);
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
		List<@NonNull OCLExpression> ownedArguments = ClassUtil.nullFree(operationCallExp.getOwnedArguments());
		@NonNull ClassDatum[] classDatums = new @NonNull ClassDatum[1 + ownedArguments.size()];
		int i = 0;
		@SuppressWarnings("null")@NonNull OCLExpression source = operationCallExp.getOwnedSource();
		classDatums[i++] = getClassDatum(source);
		for (@NonNull OCLExpression argument : ownedArguments) {
			classDatums[i++] = getClassDatum(argument);
		}
		String operationName = operationCallExp.getReferredOperation().getName();
		assert operationName != null;
		return new OperationDatum(this, operationName, classDatums);
	}

	@Override
	protected @NonNull ClassDatumAnalysis createClassDatumAnalysis(@NonNull ClassDatum classDatum) {
		return new ClassDatumAnalysis(this, classDatum);
	}

	public @NonNull MappingRegion getMappingRegion(@NonNull Mapping mapping) {
		MappingRegion mappingRegion = mapping2mappingRegion.get(mapping);
		assert mappingRegion != null;
		return mappingRegion;
	}

	public @NonNull MultiRegion transform() throws IOException {
		MultiRegion multiRegion = new MultiRegion(this);
		Iterable<@NonNull Mapping> orderedMappings = getOrderedMappings();
		//
		//	Extract salient characteristics from within each MappingAction.
		//
		for (@NonNull Mapping mapping : orderedMappings) {
			BasicMappingRegion mappingRegion = BasicMappingRegion.createMappingRegion(multiRegion, mapping);
			mapping2mappingRegion.put(mapping, mappingRegion);
		}
		List<@NonNull BasicMappingRegion> mappingRegions = new ArrayList<>(mapping2mappingRegion.values());
		Collections.sort(mappingRegions, NameUtil.NAMEABLE_COMPARATOR);		// Stabilize side effect of symbol name disambiguator suffixes
		for (@NonNull BasicMappingRegion mappingRegion : mappingRegions) {
			mappingRegion.registerConsumptionsAndProductions();
		}
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			for (@NonNull MappingRegion mappingRegion : mappingRegions) {
				mappingRegion.writeDebugGraphs(null);
			}
		}
		List<@NonNull MappingRegion> orderedRegions = new ArrayList<>();
		for (@NonNull Mapping mapping : orderedMappings) {
			BasicMappingRegion mappingRegion = mapping2mappingRegion.get(mapping);
			assert mappingRegion != null;
			orderedRegions.add(mappingRegion);
			//			mappingRegion.resolveRecursion();
		}
		List<@NonNull Region> activeRegions = new ArrayList<>(EarlyMerger.merge(orderedRegions));
		//		for (@NonNull Region activeRegion : activeRegions) {
		//			((AbstractRegion)activeRegion).resolveRecursion();
		//		}
		for (@NonNull OperationRegion operationRegion : multiRegion.getOperationRegions()) {
			activeRegions.add(operationRegion);
		}
		multiRegion.setActiveRegions(activeRegions);
		return multiRegion;
	}
}
