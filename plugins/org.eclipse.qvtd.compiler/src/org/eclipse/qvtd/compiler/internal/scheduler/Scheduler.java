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
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.etl.scheduling.QVTp2QVTg;
import org.eclipse.qvtd.compiler.internal.schedule2qvti.QVTs2QVTiVisitor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.utilities.DependencyUtil;

public class Scheduler extends SchedulerConstants
{
	public static final @NonNull TracingOption DEPENDENCY_ANALYSIS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dependencyAnalysis");
	public static final @NonNull TracingOption DUMP_CLASS_TO_CONSUMING_NODES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dump/class2consumingNodes");
	public static final @NonNull TracingOption DUMP_CLASS_TO_CONTAINING_PROPERTIES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dump/class2containingProperty");
	public static final @NonNull TracingOption DUMP_CLASS_TO_REALIZED_NODES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dump/class2realizedNodes");
	public static final @NonNull TracingOption DUMP_INPUT_MODEL_TO_DOMAIN_USAGE = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dump/inputModel2domainUsage");
	public static final @NonNull TracingOption DUMP_PROPERTY_TO_CONSUMING_CLASSES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/dump/property2consumingClass");
	public static final @NonNull TracingOption EDGE_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/edgeOrder");
	public static final @NonNull TracingOption REGION_DEPTH = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionDepth");
	public static final @NonNull TracingOption REGION_LOCALITY = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionLocality");
	public static final @NonNull TracingOption REGION_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionOrder");
	public static final @NonNull TracingOption REGION_STACK = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionStack");
	public static final @NonNull TracingOption REGION_TRAVERSAL = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/regionTraversal");
	
	/**
	 * The Region to which each action is allocated.
	 */
	private final @NonNull Map<AbstractAction, MappingRegion> action2mappingRegion = new HashMap<AbstractAction, MappingRegion>();

	private final @NonNull List<AbstractAction> orderedActions;

	public Scheduler(@NonNull EnvironmentFactory environmentFactory, @NonNull Schedule schedule, @NonNull RootDomainUsageAnalysis domainAnalysis, @NonNull QVTp2QVTg qvtp2qvtg) {
		super(environmentFactory, schedule, domainAnalysis, qvtp2qvtg);
		DependencyUtil.NaturalOrderer orderer = new DependencyUtil.NaturalOrderer(schedule);
		List<AbstractAction> orderedActions = orderer.computeOrdering();
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
				writeDOTfile(operationRegion, "-1-create");
				writeGraphMLfile(operationRegion, "-1-create");
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
	private @NonNull Map<ClassDatumAnalysis, HeadNodeGroup> createHeadGroups() {
		Map<ClassDatumAnalysis, HeadNodeGroup> classDatumAnalysis2headGroup = new HashMap<ClassDatumAnalysis, HeadNodeGroup>();
		for (@SuppressWarnings("null")@NonNull MappingRegion mappingRegion : action2mappingRegion.values()) {
			List<List<Node>> headNodeGroups = mappingRegion.getHeadNodeGroups();
			if (headNodeGroups.size() == 1) {
//			for (@SuppressWarnings("null")@NonNull List<ClassNode> headNodes : headNodeGroups) {
				@SuppressWarnings("null")@NonNull List<Node> headNodes = headNodeGroups.get(0);
				HeadNodeGroup sharedHeadNodeGroup = null;
				for (@SuppressWarnings("null")@NonNull Node headNode : headNodes) {
					HeadNodeGroup headNodeGroup = classDatumAnalysis2headGroup.get(headNode.getClassDatumAnalysis());
					if (headNodeGroup == null) {
						if (sharedHeadNodeGroup == null) {
							sharedHeadNodeGroup = headNodeGroup = new HeadNodeGroup();
						}
						else {
							headNodeGroup = sharedHeadNodeGroup;
						}
					}
					else {
						if (sharedHeadNodeGroup == null) {
							sharedHeadNodeGroup = headNodeGroup;
						}
						else {
							for (@SuppressWarnings("null")Map.@NonNull Entry<MappingRegion, List<Node>> oldEntry : headNodeGroup) {
								@SuppressWarnings("null")@NonNull MappingRegion oldMappingRegion = oldEntry.getKey();
								@SuppressWarnings("null")@NonNull List<Node> oldClassNodes = oldEntry.getValue();
								sharedHeadNodeGroup.addMappingRegion(oldMappingRegion, oldClassNodes);
								for (@SuppressWarnings("null")@NonNull Node oldHeadNode : oldClassNodes) {
									classDatumAnalysis2headGroup.put(oldHeadNode.getClassDatumAnalysis(), sharedHeadNodeGroup);
								}
							}
							headNodeGroup = sharedHeadNodeGroup;
						}
					}
//					head2group.put(headNode, headNodeGroup);
				}
				assert sharedHeadNodeGroup != null;
				sharedHeadNodeGroup.addMappingRegion(mappingRegion, headNodes);
				for (@SuppressWarnings("null")@NonNull Node headNode : headNodes) {
					classDatumAnalysis2headGroup.put(headNode.getClassDatumAnalysis(), sharedHeadNodeGroup);
				}
			}
		}
		return classDatumAnalysis2headGroup;
	}

	private @NonNull List<Region> createSuperRegions() {
		SuperRegion superRegion = new SuperRegion(this);
		//
		//	Extract salient characteristics from within each MappingAction.
		//
		for (int i = 0; i < orderedActions.size(); i++) {
			@SuppressWarnings("null")@NonNull AbstractAction abstractAction = orderedActions.get(i);
			if (abstractAction instanceof MappingAction) {
				MappingAction mappingAction = (MappingAction) abstractAction;
				MappingRegion mappingRegion = new MappingRegion(superRegion, mappingAction, i);
				action2mappingRegion.put(abstractAction, mappingRegion);
			}
		}
		for (@SuppressWarnings("null")@NonNull MappingRegion mappingRegion : action2mappingRegion.values()) {
			mappingRegion.registerConsumptionsAndProductions();
		}
		for (@SuppressWarnings("null")@NonNull MappingRegion mappingRegion : action2mappingRegion.values()) {
			writeDOTfile(mappingRegion, "-1-create");
			writeGraphMLfile(mappingRegion, "-1-create");
		}
		@SuppressWarnings("unused")
		Map<ClassDatumAnalysis, HeadNodeGroup> classDatumAnalysis2headNodeGroup = createHeadGroups();
		List<MappingRegion> orderedRegions = new ArrayList<MappingRegion>();
		for (@SuppressWarnings("null")@NonNull AbstractAction abstractAction : orderedActions) {
			MappingRegion mappingRegion = action2mappingRegion.get(abstractAction);
			assert mappingRegion != null;
			orderedRegions.add(mappingRegion);
			mappingRegion.resolveRecursion();
		}
		List<Region> allRegions = new ArrayList<Region>(earlyRegionMerge(orderedRegions));
//		@NonNull List<Region> allRegions = superRegion.identifyRegions();
		for (OperationRegion operationRegion : superRegion.getOperationRegions()) {
			allRegions.add(operationRegion);
		}
		return allRegions;
	}

	private @NonNull ScheduledRegion createRootRegion(@NonNull List<Region> allRegions) {
		ScheduledRegion rootRegion = null;
		for (Region region : new ArrayList<Region>(allRegions)) {
			if (region.getInvokingRegion() == null) {
				if (rootRegion == null) {
					@SuppressWarnings("null")@NonNull String name = getDependencyGraph().eResource().getURI().trimFileExtension().lastSegment();
					rootRegion = new ScheduledRegion(name, region);
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
	public @NonNull List<Region> earlyRegionMerge(@NonNull List<MappingRegion> orderedRegions) {
		Region2Depth region2depths = new Region2Depth();
		List<Region> outputRegions = new ArrayList<Region>();
		LinkedHashSet<MappingRegion> residualInputRegions = new LinkedHashSet<MappingRegion>(orderedRegions);	// order preserving fast random removal
		while (!residualInputRegions.isEmpty()) {
			@SuppressWarnings("null")@NonNull Region candidateRegion = residualInputRegions.iterator().next();
			boolean isMerged = false;
			if (isEarlyMergePrimaryCandidate(candidateRegion)) {
				List<Region> secondaryRegions = selectSecondaryRegions(candidateRegion);
				if (secondaryRegions != null) {
					Region primaryRegion = candidateRegion;
					MergedRegion mergedRegion = null;
					for (Region secondaryRegion : secondaryRegions) {
						assert secondaryRegion != null;
						if (residualInputRegions.contains(secondaryRegion)) {
							Map<Node, Node> secondaryNode2primaryNode = primaryRegion.canMerge(secondaryRegion, region2depths, false);
							if (secondaryNode2primaryNode != null) {
								boolean isSharedHead = isSharedHead(primaryRegion, secondaryRegion);
								if (!isSharedHead || (secondaryRegion.canMerge(primaryRegion, region2depths, false) != null)) {
									if (mergedRegion == null) {
										mergedRegion = new MergedRegion((MergeableRegion)primaryRegion);
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
						writeDOTfile(mergedRegion, "-2-merged");
						writeGraphMLfile(mergedRegion, "-2-merged");
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

	public @NonNull MappingRegion getMappingRegion(@NonNull AbstractAction action) {
		MappingRegion mappingRegion = action2mappingRegion.get(action);
		assert mappingRegion != null;
		return mappingRegion;
	}

	/**
	 * The primary region in a GuardedRegion must be single-headed. It may be multiply-produced, e.g. recursed.
	 */
	private boolean isEarlyMergePrimaryCandidate(@NonNull Region mappingRegion) {
		List<List<Node>> headNodeGroups = mappingRegion.getHeadNodeGroups();
		return headNodeGroups.size() == 1;
	}

	/**
	 * The secondary region in a GuardedRegion must be single-headed and at least one its head nodes must be a class in use within
	 * the primary region. It may be multiply-produced, e.g. recursed.
	 */
	private boolean isEarlyMergeSecondaryCandidate(@NonNull Region primaryRegion,
			@NonNull Region secondaryRegion, @NonNull Set<ClassDatumAnalysis> toOneReachableClasses) {
		List<List<Node>> secondaryHeadNodeGroups = secondaryRegion.getHeadNodeGroups();
		if (secondaryHeadNodeGroups.size() == 1) {
			for (Node classNode : secondaryHeadNodeGroups.get(0)) {
				ClassDatumAnalysis classDatumAnalysis = classNode.getClassDatumAnalysis();
				if (toOneReachableClasses.contains(classDatumAnalysis)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return true if any primaryRegion head coincides with a secondaryRegion head.
	 */
	private boolean isSharedHead(@NonNull Region primaryRegion, @NonNull Region secondaryRegion) {
		for (List<Node> primaryHeads : primaryRegion.getHeadNodeGroups()) {
			for (Node primaryHead : primaryHeads) {
				ClassDatumAnalysis primaryClassDatumAnalysis = primaryHead.getClassDatumAnalysis();
				for (List<Node> secondaryHeads : secondaryRegion.getHeadNodeGroups()) {
					for (Node secondaryHead : secondaryHeads) {
						if (primaryClassDatumAnalysis == secondaryHead.getClassDatumAnalysis()) {
							return true;
						}
					}
					
				}
			}
		}
		return false;
	}

	public @NonNull ScheduledRegion qvtp2qvts() throws IOException {
		List<Region> allRegions = createSuperRegions();
		ScheduledRegion rootRegion = createRootRegion(allRegions);
		rootRegion.createSchedule();
		//
/*		for (Region region : allRegions) {
			if (region instanceof CompositeStartRegion) {
//				if (region.getAllMappingRegions().size() > 1) {
					writeDOTfile(region);
//				}
			}
		} */
		writeRegionDOTfile(rootRegion, "-9r-final");
		writeRegionGraphMLfile(rootRegion, "-9r-final");
		writeDOTfile(rootRegion, "-9-final");
		writeGraphMLfile(rootRegion, "-9-final");
		return rootRegion;
	}

	public Resource qvts2qvti(@NonNull ScheduledRegion scheduledRegion, String qvtias) throws IOException {
		Transformation transformation = getTransformation();
		QVTs2QVTiVisitor visitor = new QVTs2QVTiVisitor(getEnvironmentFactory(), transformation, scheduledRegion.getRegionOrderer());
		Model model = (Model)scheduledRegion.accept(visitor);
		assert model != null;model.setExternalURI(qvtias);
		Resource eResource = getDependencyGraph().eResource();
		Resource resource = eResource.getResourceSet().createResource(URI.createURI(qvtias));
		resource.getContents().add(model);
		Map<Object, Object> saveOptions = XMIUtil.createSaveOptions();
		resource.save(saveOptions);
		return resource;
	}

	/**
	 * Return a list of single-headed to-one navigable regions whose head is transitively to-one reachable from the primaryRegion's head.
	 */
	private @Nullable List<Region> selectSecondaryRegions(@NonNull Region primaryRegion) {
		//
		//	All regions that consume one of the primary nodes.
		//
		Set<Region> allConsumingRegions = new HashSet<Region>();
		allConsumingRegions.add(primaryRegion);
		//
		//	All classes reachable from the primary head.
		//
		Set<ClassDatumAnalysis> toOneReachableClasses = new HashSet<ClassDatumAnalysis>();
		List<Region> secondaryRegions = null;
		List<Region> allConsumingRegionsList = new ArrayList<Region>(allConsumingRegions);	// CME-proof iterable List shadowing a mutating Set 
		for (int i = 0; i < allConsumingRegionsList.size(); i++) {
			@SuppressWarnings("null")@NonNull Region secondaryRegion = allConsumingRegionsList.get(i);
			if ((i == 0) || isEarlyMergeSecondaryCandidate(primaryRegion, secondaryRegion, toOneReachableClasses)) {
				if (i > 0) {
					if (secondaryRegions == null) {
						secondaryRegions = new ArrayList<Region>();
					}
					secondaryRegions.add(secondaryRegion);
				}
				for (@SuppressWarnings("null")@NonNull Node predicatedNode : secondaryRegion.getMatchableNodes()) {
					if (predicatedNode.isClassNode()) {							// Ignore nulls, attributes
						ClassDatumAnalysis predicatedClassDatumAnalysis = predicatedNode.getClassDatumAnalysis();
						if (toOneReachableClasses.add(predicatedClassDatumAnalysis)) {
							for (Region consumingRegion : predicatedClassDatumAnalysis.getConsumingRegions()) {
								if (allConsumingRegions.add(consumingRegion)) {
									allConsumingRegionsList.add(consumingRegion);
								}
							}
						}
					}
				}
				if (secondaryRegion instanceof MappingRegion) {
					for (Node assignedNode : ((MappingRegion)secondaryRegion).getComputedNodes()) {
						if (assignedNode.isClassNode()) {							// Ignore nulls, attributes
							ClassDatumAnalysis consumingClassDatumAnalysis = assignedNode.getClassDatumAnalysis();
							if (toOneReachableClasses.add(consumingClassDatumAnalysis)) {
								for (Region consumingRegion : consumingClassDatumAnalysis.getConsumingRegions()) {
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
