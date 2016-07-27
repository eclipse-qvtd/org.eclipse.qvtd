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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Region2Depth;
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
	public static final @NonNull TracingOption EDGE_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/edgeOrder");
	public static final @NonNull TracingOption REGION_CYCLES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionCycles");
	public static final @NonNull TracingOption REGION_DEPTH = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionDepth");
	//	public static final @NonNull TracingOption REGION_LOCALITY = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionLocality");
	public static final @NonNull TracingOption REGION_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionOrder");
	public static final @NonNull TracingOption REGION_STACK = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionStack");
	public static final @NonNull TracingOption REGION_TRAVERSAL = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionTraversal");

	/**
	 * The Region to which each action is allocated.
	 */
	private final @NonNull Map<@NonNull AbstractAction, @NonNull SimpleMappingRegion> action2mappingRegion = new HashMap<>();

	private final @NonNull List<@NonNull AbstractAction> orderedActions;

	public QVTp2QVTs(@NonNull EnvironmentFactory environmentFactory, @NonNull Schedule schedule, @NonNull QVTp2QVTg qvtp2qvtg) {
		super(environmentFactory, schedule, qvtp2qvtg);
		DependencyUtil.NaturalOrderer orderer = new DependencyUtil.NaturalOrderer(schedule);
		List<@NonNull AbstractAction> orderedActions = orderer.computeOrdering();	// FIXME ??is this ordering still needed??
		if (orderedActions == null) {
			throw new IllegalArgumentException(orderer.diagnoseOrderingFailure());
		}
		this.orderedActions = orderedActions;
	}

	private Map<@NonNull OperationDatum, @NonNull OperationRegion> map = new HashMap<>();

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

	/**
	 * Replace those orderedRegions that may be aggregated as part of a GuardedRegion decision tree by GuardedRegions.
	 * orderedRegions should be naturally ordered to ensure that non-recursive dependencies are inherently satisfied.
	 *
	 * Returns the orderedRegions plus the new aggregates less those aggregated.
	 */
	public @NonNull List<@NonNull Region> earlyRegionMerge(@NonNull List<@NonNull AbstractSimpleMappingRegion> orderedRegions) {
		Region2Depth region2depths = new Region2Depth();
		List<@NonNull Region> outputRegions = new ArrayList<>();
		LinkedHashSet<@NonNull AbstractSimpleMappingRegion> residualInputRegions = new LinkedHashSet<>(orderedRegions);	// order preserving fast random removal
		while (!residualInputRegions.isEmpty()) {
			@NonNull AbstractMappingRegion candidateRegion = residualInputRegions.iterator().next();
			boolean isMerged = false;
			if (isEarlyMergePrimaryCandidate(candidateRegion)) {
				List<@NonNull AbstractMappingRegion> secondaryRegions = selectSecondaryRegions(candidateRegion);
				if (secondaryRegions != null) {
					AbstractMappingRegion primaryRegion = candidateRegion;
					MergedMappingRegion mergedRegion = null;
					for (@NonNull AbstractMappingRegion secondaryRegion : secondaryRegions) {
						assert secondaryRegion != null;
						if (residualInputRegions.contains(secondaryRegion)) {
							Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode = primaryRegion.canMerge(secondaryRegion, region2depths, false);
							if (secondaryNode2primaryNode != null) {
								boolean isSharedHead = isSharedHead(primaryRegion, secondaryRegion);
								if (!isSharedHead || (secondaryRegion.canMerge(primaryRegion, region2depths, false) != null)) {
									if (mergedRegion == null) {
										mergedRegion = new MergedMappingRegion(primaryRegion);
										residualInputRegions.remove(primaryRegion);
										primaryRegion = mergedRegion;
									}
									mergedRegion.mergeRegion(secondaryRegion, secondaryNode2primaryNode);
									residualInputRegions.remove(secondaryRegion);
									region2depths.addRegion(mergedRegion);
								}
							}
						}
					}
					if (mergedRegion != null) {
						//						mergedRegion.resolveRecursion();
						if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
							mergedRegion.writeDebugGraphs("2-merged");
						}
						//						GuardedRegion guardedRegion = createGuardedRegion(mergedRegion, mergeableRegions);
						//						outputRegions.add(guardedRegion);
						outputRegions.add(mergedRegion);
						isMerged = true;
					}
				}
			}
			if (!isMerged) {
				outputRegions.add(candidateRegion);
			}
			residualInputRegions.remove(candidateRegion);
		}
		return outputRegions;
	}

	public @NonNull AbstractSimpleMappingRegion getMappingRegion(@NonNull AbstractAction action) {
		AbstractSimpleMappingRegion mappingRegion = action2mappingRegion.get(action);
		assert mappingRegion != null;
		return mappingRegion;
	}

	/**
	 * The primary region in a GuardedRegion must be single-headed. It may be multiply-produced, e.g. recursed.
	 */
	private boolean isEarlyMergePrimaryCandidate(@NonNull Region mappingRegion) {
		List<@NonNull Node> headNodes = mappingRegion.getHeadNodes();
		return headNodes.size() == 1;
	}

	/**
	 * The secondary region in a GuardedRegion must be single-headed and at least one its head nodes must be a class in use within
	 * the primary region. It may be multiply-produced, e.g. recursed.
	 */
	private boolean isEarlyMergeSecondaryCandidate(@NonNull Region primaryRegion,
			@NonNull Region secondaryRegion, @NonNull Set<ClassDatumAnalysis> toOneReachableClasses) {
		List<@NonNull Node> secondaryHeadNodes = secondaryRegion.getHeadNodes();
		if (secondaryHeadNodes.size() == 1) {
			Node classNode = secondaryHeadNodes.get(0);
			ClassDatumAnalysis classDatumAnalysis = classNode.getClassDatumAnalysis();
			if (toOneReachableClasses.contains(classDatumAnalysis)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return true if any primaryRegion head coincides with a secondaryRegion head.
	 */
	private boolean isSharedHead(@NonNull Region primaryRegion, @NonNull Region secondaryRegion) {
		for (Node primaryHead : primaryRegion.getHeadNodes()) {
			ClassDatumAnalysis primaryClassDatumAnalysis = primaryHead.getClassDatumAnalysis();
			for (Node secondaryHead : secondaryRegion.getHeadNodes()) {
				if (primaryClassDatumAnalysis == secondaryHead.getClassDatumAnalysis()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return a list of single-headed to-one navigable regions whose head is transitively to-one reachable from the primaryRegion's head.
	 */
	private @Nullable List<@NonNull AbstractMappingRegion> selectSecondaryRegions(@NonNull AbstractMappingRegion primaryRegion) {
		//
		//	All regions that consume one of the primary nodes.
		//
		Set<@NonNull AbstractMappingRegion> allConsumingRegions = new HashSet<>();
		allConsumingRegions.add(primaryRegion);
		//
		//	All classes reachable from the primary head.
		//
		Set<@NonNull ClassDatumAnalysis> toOneReachableClasses = new HashSet<>();
		List<@NonNull AbstractMappingRegion> secondaryRegions = null;
		List<@NonNull AbstractMappingRegion> allConsumingRegionsList = new ArrayList<>(allConsumingRegions);	// CME-proof iterable List shadowing a mutating Set
		for (int i = 0; i < allConsumingRegionsList.size(); i++) {
			@NonNull AbstractMappingRegion secondaryRegion = allConsumingRegionsList.get(i);
			if ((i == 0) || isEarlyMergeSecondaryCandidate(primaryRegion, secondaryRegion, toOneReachableClasses)) {
				if (i > 0) {
					if (secondaryRegions == null) {
						secondaryRegions = new ArrayList<>();
					}
					secondaryRegions.add(secondaryRegion);
				}
				for (@NonNull Node predicatedNode : secondaryRegion.getMatchableNodes()) {
					if (predicatedNode.isClassNode()) {							// Ignore nulls, attributes
						ClassDatumAnalysis predicatedClassDatumAnalysis = predicatedNode.getClassDatumAnalysis();
						if (toOneReachableClasses.add(predicatedClassDatumAnalysis)) {
							for (@NonNull AbstractMappingRegion consumingRegion : predicatedClassDatumAnalysis.getConsumingRegions()) {
								if (allConsumingRegions.add(consumingRegion)) {
									allConsumingRegionsList.add(consumingRegion);
								}
							}
						}
					}
				}
				if (secondaryRegion instanceof AbstractSimpleMappingRegion) {
					for (@NonNull Node assignedNode : ((AbstractSimpleMappingRegion)secondaryRegion).getComputedNodes()) {
						if (assignedNode.isClassNode()) {							// Ignore nulls, attributes
							ClassDatumAnalysis consumingClassDatumAnalysis = assignedNode.getClassDatumAnalysis();
							if (toOneReachableClasses.add(consumingClassDatumAnalysis)) {
								for (@NonNull AbstractMappingRegion consumingRegion : consumingClassDatumAnalysis.getConsumingRegions()) {
									if (allConsumingRegions.add(consumingRegion)) {
										allConsumingRegionsList.add(consumingRegion);
									}
								}
							}
						}
					}
				}
			}
		}
		assert allConsumingRegionsList.size() == allConsumingRegions.size();					// Check same changes to CME-proof shadow
		return secondaryRegions;
	}

	public @NonNull MultiRegion transform() throws IOException {
		MultiRegion multiRegion = new MultiRegion(this);
		//
		//	Extract salient characteristics from within each MappingAction.
		//
		for (@NonNull AbstractAction abstractAction : orderedActions) {
			if (abstractAction instanceof MappingAction) {
				MappingAction mappingAction = (MappingAction) abstractAction;
				SimpleMappingRegion mappingRegion = new SimpleMappingRegion(multiRegion, mappingAction);
				action2mappingRegion.put(abstractAction, mappingRegion);
			}
		}
		List<@NonNull SimpleMappingRegion> mappingRegions = new ArrayList<>(action2mappingRegion.values());
		Collections.sort(mappingRegions, NameUtil.NAMEABLE_COMPARATOR);		// Stabilize side effect of symbol name disambiguator suffixes
		for (@NonNull SimpleMappingRegion mappingRegion : mappingRegions) {
			mappingRegion.registerConsumptionsAndProductions();
		}
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			for (@NonNull AbstractSimpleMappingRegion mappingRegion : mappingRegions) {
				mappingRegion.writeDebugGraphs("1-create");
			}
		}
		List<@NonNull AbstractSimpleMappingRegion> orderedRegions = new ArrayList<>();
		for (@NonNull AbstractAction abstractAction : orderedActions) {
			AbstractSimpleMappingRegion mappingRegion = action2mappingRegion.get(abstractAction);
			assert mappingRegion != null;
			orderedRegions.add(mappingRegion);
			mappingRegion.resolveRecursion();
		}
		List<@NonNull Region> activeRegions = new ArrayList<>(earlyRegionMerge(orderedRegions));
		for (@NonNull OperationRegion operationRegion : multiRegion.getOperationRegions()) {
			activeRegions.add(operationRegion);
		}
		multiRegion.setActiveRegions(activeRegions);
		return multiRegion;
	}
}
