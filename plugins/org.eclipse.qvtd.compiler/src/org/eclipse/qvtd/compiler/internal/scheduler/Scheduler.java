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
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.etl.scheduling.QVTp2QVTg;
import org.eclipse.qvtd.compiler.internal.schedule2qvti.QVTs2QVTiVisitor;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameReservation;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.utilities.DependencyUtil;

public class Scheduler extends SchedulerConstants
{
	public static final @NonNull TracingOption CONNECTION_CREATION = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/connectionCreation");
	public static final @NonNull TracingOption CONNECTION_ROUTING = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/connectionRouting");
	public static final @NonNull TracingOption DEBUG_GRAPHS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/debugGraphs");
	public static final @NonNull TracingOption DEPENDENCY_ANALYSIS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dependencyAnalysis");
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
	private final @NonNull Map<@NonNull AbstractAction, @NonNull SimpleMappingRegion> action2mappingRegion = new HashMap<@NonNull AbstractAction, @NonNull SimpleMappingRegion>();

	private final @NonNull List<@NonNull AbstractAction> orderedActions;

	public Scheduler(@NonNull EnvironmentFactory environmentFactory, @NonNull Schedule schedule, @NonNull QVTp2QVTg qvtp2qvtg) {
		super(environmentFactory, schedule, qvtp2qvtg);
		DependencyUtil.NaturalOrderer orderer = new DependencyUtil.NaturalOrderer(schedule);
		List<@NonNull AbstractAction> orderedActions = orderer.computeOrdering();
		if (orderedActions == null) {
			throw new IllegalArgumentException(orderer.diagnoseOrderingFailure());
		}
		this.orderedActions = orderedActions;
	}
	
	private Map<OperationDatum, OperationRegion> map = new HashMap<OperationDatum, OperationRegion>();

	public @NonNull OperationRegion analyzeOperation(@NonNull SuperRegion superRegion, @NonNull OperationCallExp operationCallExp) {
		Operation operation = operationCallExp.getReferredOperation();
		LanguageExpression bodyExpression = operation.getBodyExpression();
		assert  bodyExpression != null;
		ExpressionInOCL specification;
		try {
			specification = getEnvironmentFactory().getMetamodelManager().parseSpecification(bodyExpression);
			OperationDatum operationDatum = createOperationDatum(operationCallExp);
			OperationRegion operationRegion = map.get(operationDatum);
			if (operationRegion == null) {
				operationRegion = new OperationRegion(superRegion, operationDatum, specification, operationCallExp);
				map.put(operationDatum, operationRegion);
				if (Scheduler.DEBUG_GRAPHS.isActive()) {
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
		List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
		@NonNull ClassDatum[] classDatums = new @NonNull ClassDatum[1 + ownedArguments.size()];
		int i = 0;
		@SuppressWarnings("null")@NonNull OCLExpression source = operationCallExp.getOwnedSource();
		classDatums[i++] = getClassDatum(source);
		for (@SuppressWarnings("null")@NonNull OCLExpression argument : ownedArguments) {
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

	/**
	 * Unify the head groups of each mapping region to create a simple uniform ClassDatum to HeadNodeGroup map.
	 */
	private @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull HeadNodeGroup> createHeadGroups() {
		Map<@NonNull ClassDatumAnalysis, @NonNull HeadNodeGroup> classDatumAnalysis2headGroup = new HashMap<@NonNull ClassDatumAnalysis, @NonNull HeadNodeGroup>();
		for (@NonNull SimpleMappingRegion mappingRegion : action2mappingRegion.values()) {
			List<@NonNull Node> headNodes = mappingRegion.getHeadNodes();
			if (headNodes.size() == 1) {
				Node headNode = headNodes.get(0);
				HeadNodeGroup headNodeGroup = classDatumAnalysis2headGroup.get(headNode.getClassDatumAnalysis());
				if (headNodeGroup == null) {
					headNodeGroup = new HeadNodeGroup();
				}
				headNodeGroup.addMappingRegion(mappingRegion, headNodes);
				classDatumAnalysis2headGroup.put(headNode.getClassDatumAnalysis(), headNodeGroup);
			}
		}
		return classDatumAnalysis2headGroup;
	}

	private @NonNull List<@NonNull Region> createSuperRegions() {
		SuperRegion superRegion = new SuperRegion(this);
		//
		//	Extract salient characteristics from within each MappingAction.
		//
		for (int i = 0; i < orderedActions.size(); i++) {
			@NonNull AbstractAction abstractAction = orderedActions.get(i);
			if (abstractAction instanceof MappingAction) {
				MappingAction mappingAction = (MappingAction) abstractAction;
				SimpleMappingRegion mappingRegion = new SimpleMappingRegion(superRegion, mappingAction, i);
				action2mappingRegion.put(abstractAction, mappingRegion);
			}
		}
		List<@NonNull SimpleMappingRegion> mappingRegions = new ArrayList<@NonNull SimpleMappingRegion>(action2mappingRegion.values());
		Collections.sort(mappingRegions, NameUtil.NAMEABLE_COMPARATOR);		// Stabilize side effect of symbol name disambiguator suffixes
		for (@NonNull SimpleMappingRegion mappingRegion : mappingRegions) {
			mappingRegion.registerConsumptionsAndProductions();
		}
		if (Scheduler.DEBUG_GRAPHS.isActive()) {
			for (@NonNull SimpleMappingRegion mappingRegion : mappingRegions) {
				mappingRegion.writeDebugGraphs("1-create");
			}
		}
		@SuppressWarnings("unused")
		Map<@NonNull ClassDatumAnalysis, @NonNull HeadNodeGroup> classDatumAnalysis2headNodeGroup = createHeadGroups();
		List<@NonNull SimpleMappingRegion> orderedRegions = new ArrayList<@NonNull SimpleMappingRegion>();
		for (@NonNull AbstractAction abstractAction : orderedActions) {
			SimpleMappingRegion mappingRegion = action2mappingRegion.get(abstractAction);
			assert mappingRegion != null;
			orderedRegions.add(mappingRegion);
			mappingRegion.resolveRecursion();
		}
		List<@NonNull Region> allRegions = new ArrayList<@NonNull Region>(earlyRegionMerge(orderedRegions));
//		@NonNull List<Region> allRegions = superRegion.identifyRegions();
		for (@NonNull OperationRegion operationRegion : superRegion.getOperationRegions()) {
			allRegions.add(operationRegion);
		}
		return allRegions;
	}

	private @NonNull RootScheduledRegion createRootRegion(@NonNull List<@NonNull Region> allRegions) {
		RootScheduledRegion rootRegion = null;
		for (@NonNull Region region : new ArrayList<@NonNull Region>(allRegions)) {
			if (region.getInvokingRegion() == null) {
				if (rootRegion == null) {
					String name = ClassUtil.nonNullState(getDependencyGraph().eResource().getURI().trimFileExtension().trimFileExtension().lastSegment());
					rootRegion = new RootScheduledRegion(name, region);
				}
				rootRegion.addRegion(region);
			}
		}
		assert rootRegion != null;
		return rootRegion;
	}

	/**
	 * Replace those orderedRegions that may be aggregated as part of a GuardedRegion decision tree by GuardedRegions.
	 * orderedRegions should be naturally ordered to ensure that non-recursive dependencies are inherently satisfied.
	 * 
	 * Returns the orderedRegions plus the new aggregates less those aggregated. 
	 */
	public @NonNull List<@NonNull Region> earlyRegionMerge(@NonNull List<@NonNull SimpleMappingRegion> orderedRegions) {
		Region2Depth region2depths = new Region2Depth();
		List<@NonNull Region> outputRegions = new ArrayList<@NonNull Region>();
		LinkedHashSet<@NonNull SimpleMappingRegion> residualInputRegions = new LinkedHashSet<@NonNull SimpleMappingRegion>(orderedRegions);	// order preserving fast random removal
		while (!residualInputRegions.isEmpty()) {
			@NonNull Region candidateRegion = residualInputRegions.iterator().next();
			boolean isMerged = false;
			if (isEarlyMergePrimaryCandidate(candidateRegion)) {
				List<@NonNull Region> secondaryRegions = selectSecondaryRegions(candidateRegion);
				if (secondaryRegions != null) {
					Region primaryRegion = candidateRegion;
					MergedMappingRegion mergedRegion = null;
					for (@NonNull Region secondaryRegion : secondaryRegions) {
						assert secondaryRegion != null;
						if (residualInputRegions.contains(secondaryRegion)) {
							Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode = primaryRegion.canMerge(secondaryRegion, region2depths, false);
							if (secondaryNode2primaryNode != null) {
								boolean isSharedHead = isSharedHead(primaryRegion, secondaryRegion);
								if (!isSharedHead || (secondaryRegion.canMerge(primaryRegion, region2depths, false) != null)) {
									if (mergedRegion == null) {
										mergedRegion = new MergedMappingRegion((MergeableRegion)primaryRegion);
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
						if (Scheduler.DEBUG_GRAPHS.isActive()) {
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

	public @NonNull SimpleMappingRegion getMappingRegion(@NonNull AbstractAction action) {
		SimpleMappingRegion mappingRegion = action2mappingRegion.get(action);
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

	public @NonNull RootScheduledRegion qvtp2qvts() throws IOException {
		List<@NonNull Region> allRegions = createSuperRegions();
		RootScheduledRegion rootRegion = createRootRegion(allRegions);
		rootRegion.createSchedule();
		return rootRegion;
	}

	public @NonNull Resource qvts2qvti(@NonNull RootScheduledRegion scheduledRegion, @NonNull URI qvtiURI, @NonNull SymbolNameReservation symbolNameReservation) {
		Transformation transformation = getTransformation();
		QVTs2QVTiVisitor visitor = new QVTs2QVTiVisitor(getEnvironmentFactory(), transformation, symbolNameReservation);
		Model model = (Model)scheduledRegion.accept(visitor);
		assert model != null;
		model.setExternalURI(qvtiURI.toString());
		Resource eResource = getDependencyGraph().eResource();
		Resource resource = eResource.getResourceSet().createResource(qvtiURI);
		resource.getContents().add(model);
		return resource;
	}

	/**
	 * Return a list of single-headed to-one navigable regions whose head is transitively to-one reachable from the primaryRegion's head.
	 */
	private @Nullable List<@NonNull Region> selectSecondaryRegions(@NonNull Region primaryRegion) {
		//
		//	All regions that consume one of the primary nodes.
		//
		Set<@NonNull Region> allConsumingRegions = new HashSet<@NonNull Region>();
		allConsumingRegions.add(primaryRegion);
		//
		//	All classes reachable from the primary head.
		//
		Set<@NonNull ClassDatumAnalysis> toOneReachableClasses = new HashSet<@NonNull ClassDatumAnalysis>();
		List<@NonNull Region> secondaryRegions = null;
		List<@NonNull Region> allConsumingRegionsList = new ArrayList<@NonNull Region>(allConsumingRegions);	// CME-proof iterable List shadowing a mutating Set 
		for (int i = 0; i < allConsumingRegionsList.size(); i++) {
			@NonNull Region secondaryRegion = allConsumingRegionsList.get(i);
			if ((i == 0) || isEarlyMergeSecondaryCandidate(primaryRegion, secondaryRegion, toOneReachableClasses)) {
				if (i > 0) {
					if (secondaryRegions == null) {
						secondaryRegions = new ArrayList<@NonNull Region>();
					}
					secondaryRegions.add(secondaryRegion);
				}
				for (@NonNull Node predicatedNode : secondaryRegion.getMatchableNodes()) {
					if (predicatedNode.isClassNode()) {							// Ignore nulls, attributes
						ClassDatumAnalysis predicatedClassDatumAnalysis = predicatedNode.getClassDatumAnalysis();
						if (toOneReachableClasses.add(predicatedClassDatumAnalysis)) {
							for (@NonNull Region consumingRegion : predicatedClassDatumAnalysis.getConsumingRegions()) {
								if (allConsumingRegions.add(consumingRegion)) {
									allConsumingRegionsList.add(consumingRegion);
								}
							}
						}
					}
				}
				if (secondaryRegion instanceof SimpleMappingRegion) {
					for (@NonNull Node assignedNode : ((SimpleMappingRegion)secondaryRegion).getComputedNodes()) {
						if (assignedNode.isClassNode()) {							// Ignore nulls, attributes
							ClassDatumAnalysis consumingClassDatumAnalysis = assignedNode.getClassDatumAnalysis();
							if (toOneReachableClasses.add(consumingClassDatumAnalysis)) {
								for (@NonNull Region consumingRegion : consumingClassDatumAnalysis.getConsumingRegions()) {
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
}
