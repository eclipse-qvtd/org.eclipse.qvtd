/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ConnectivityChecker;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.LoadingRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.HorizontalPartitionMerger;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.CyclicPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionedTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartitionAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * QVTs2QVTi supervises the serialization of a QVTs schedule as a QVTi transformation.
 */
public class QVTs2QVTs extends QVTimperativeHelper
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ProblemHandler problemHandler;
	protected final @NonNull String rootName;
	//	private final @NonNull LoadingRegion loadingRegion;
	private final @NonNull LoadingRegionAnalysis loadingRegionAnalysis;

	protected final @NonNull CompleteModel completeModel;
	private final @NonNull Map<@NonNull Region, @NonNull RegionAnalysis> region2regionAnalysis = new HashMap<>();


	/**
	 * The input models that may introduce model elements for transformation.
	 */
	private final @NonNull Map<@NonNull Model, org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage> inputModels = new HashMap<>();
	private final @NonNull StandardLibraryHelper standardLibraryHelper;
	//	private final @NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges = new HashMap<>();
	//	private final @NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges = new HashMap<>();

	public QVTs2QVTs(@NonNull ProblemHandler problemHandler, @NonNull ScheduleManager qvtm2qvts, @NonNull String rootName) {
		super(qvtm2qvts.getEnvironmentFactory());
		this.scheduleManager = qvtm2qvts;
		this.standardLibraryHelper = new StandardLibraryHelper(standardLibrary);
		this.problemHandler = problemHandler;
		this.rootName = rootName;
		this.loadingRegionAnalysis = new LoadingRegionAnalysis(scheduleManager, createLoadingRegion());		// FIXME Should treat LoadingRegion uniformly
		this.completeModel = environmentFactory.getCompleteModel();
		scheduleManager.createConnectionManager(problemHandler, loadingRegionAnalysis);
	}

	private void computeInputModels() {
		for (@NonNull ClassDatum classDatum : scheduleManager.getClassDatums()) {
			DomainUsage domainUsage = scheduleManager.getDomainUsage(classDatum);
			if (domainUsage.isInput() && !domainUsage.isOutput()) {
				Type type = classDatum.getCompleteClass().getPrimaryClass();
				org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getContainingPackage(type);
				if ((asPackage != null) && !PivotConstants.ORPHANAGE_URI.equals(asPackage.getURI())) {
					Model model = PivotUtil.getContainingModel(type);
					if (model != null) {
						inputModels.put(model, domainUsage);
					}
				}
			}
			//			if (!domainUsage.isEnforceable()) {
			//				Model model = PivotUtil.getContainingModel(classDatumAnalysis.getClassDatum().getType());
			//				if ((model != null) && !PivotConstants.ORPHANAGE_URI.equals(model.getExternalURI())) {
			//					inputModels.put(model, domainUsage);
			//				}
			//			}
		}
		if (QVTm2QVTs.DUMP_INPUT_MODEL_TO_DOMAIN_USAGE.isActive()) {
			QVTm2QVTs.DUMP_INPUT_MODEL_TO_DOMAIN_USAGE.println(dumpInputModels().reduce("", QVTscheduleUtil.stringJoin("\n\t")));
		}
	}

	/**
	 * Create a RootContainmentRegion that introduces model elements directly from the input model root, or from
	 * composition relationships that form part of an extended metamodel that is not known until run-time.
	 */
	private @NonNull LoadingRegion createRootContainmentRegion(@NonNull RootPartitionAnalysis rootPartitionAnalysis) {
		ScheduledRegion rootScheduledRegion = rootPartitionAnalysis.getScheduledRegion();
		LoadingRegion loadingRegion = loadingRegionAnalysis.getRegion();
		//		loadingRegion.setOwningScheduledRegion(rootScheduledRegion);
		assert rootScheduledRegion.getOwnedLoadingRegion() == loadingRegion;
		scheduleManager.writeDebugGraphs(loadingRegion, null);
		return loadingRegion;
	}

	/**
	 * Create a NodeConnection to the realized node for each attribute.
	 *
	private void createAttributeConnections() {
		ScheduledRegion invokingRegion2 = invokingRegion;
		assert invokingRegion2 != null;
		RootScheduledRegion rootScheduledRegion = invokingRegion2.getRootScheduledRegion();
		for (@NonNull NavigationEdge predicatedEdge : getPredicatedNavigationEdges()) {
			Node predicatedTarget = predicatedEdge.getTarget();
			if (predicatedEdge.isNavigation()
			 && !predicatedEdge.isCast()
			 && (predicatedTarget.getIncomingConnection() == null)
			 && predicatedTarget.isAttributeNode()) {			// FIXME isCast does not need to be isNavigation now that it can be isNavigable
				Iterable<@NonNull NavigationEdge> realizedEdges = rootScheduledRegion.getRealizedEdges(predicatedEdge);
				if (realizedEdges != null) {
					Property predicatedProperty = predicatedEdge.getProperty();
					assert !predicatedProperty.isIsImplicit();
					ClassDatumAnalysis classDatumAnalysis = predicatedTarget.getClassDatumAnalysis();
					List<@NonNull Node> sourceNodes = new ArrayList<>();
					for (@NonNull NavigationEdge realizedEdge : realizedEdges) {
						sourceNodes.add(realizedEdge.getTarget());
					}
					NodeConnection nodeConnection = invokingRegion2.getNodeConnection(sourceNodes, classDatumAnalysis);
					nodeConnection.addUsedTargetNode(predicatedTarget, false);
					if (Scheduler.CONNECTIONS.isActive()) {
						Scheduler.CONNECTIONS.println("  Attribute NodeConnection to " + predicatedTarget);
					}
				}
			}
		}
	} */

	protected @NonNull LoadingRegion createLoadingRegion() {
		LoadingRegion loadingRegion = QVTscheduleFactory.eINSTANCE.createLoadingRegion();
		loadingRegion.setName("«load»"); //__root__ _QVTscheduleConstants.ROOT_MAPPING_NAME);
		SymbolNameBuilder s = new SymbolNameBuilder();
		s.appendString("__load__"); //QVTscheduleUtil.ROOT_MAPPING_NAME);
		loadingRegion.setSymbolName(scheduleManager.getScheduleModel().reserveSymbolName(s, loadingRegion));
		return loadingRegion;
	}

	/**
	 * Create a NodeConnection to the realized node for each node, unless there is already an EdgeConnection for any edge to/from the node.
	 *
	private void createNodeConnections() {
		ScheduledRegion invokingRegion2 = invokingRegion;
		assert invokingRegion2 != null;
		RootScheduledRegion rootScheduledRegion = invokingRegion2.getRootScheduledRegion();
		for (@NonNull Node predicatedNode : getPredicatedNodes()) {
			if (!predicatedNode.isLoaded()			// WIP and !isOnlyCast
			 && !predicatedNode.isConstant()
			 && !predicatedNode.isHead()
			 && !predicatedNode.isOperation()
			 && !predicatedNode.isTrue()
			 && (predicatedNode.getIncomingConnection() == null)
			 && !predicatedNode.isAttributeNode()
			 && !rootScheduledRegion.isOnlyCastOrRecursed(predicatedNode)
			 && !hasEdgeConnection(predicatedNode)) {
				ClassDatumAnalysis classDatumAnalysis = predicatedNode.getClassDatumAnalysis();
				Iterable<@NonNull Node> sourceNodes = rootScheduledRegion.getIntroducingOrProducingNodes(classDatumAnalysis);
				if (sourceNodes != null) {
					NodeConnection predicatedConnection = invokingRegion2.getNodeConnection(sourceNodes, classDatumAnalysis);
					predicatedConnection.addUsedTargetNode(predicatedNode, false);
					if (Scheduler.CONNECTIONS.isActive()) {
						Scheduler.CONNECTIONS.println("  NodeConnection from " + predicatedNode);
					}
				}
			}
		}
	} */

	/**
	 * Create a NodeConnection to the realized node for each node in the pattern related to a head node.
	 *
	private void createRelatedConnections(@NonNull NodeConnection headConnection) {
		@NonNull Iterable<@NonNull Node> headSources = headConnection.getSources();
		/**
	 * Each bindable node is navigable within the guard/predicate from the head and has an equivalent node in every possible caller.
	 * A bindable node may therefore by passed by value from each of a known set of calling nodes to each called node.
	 * /
		Map<@NonNull NavigationEdge, @NonNull List<@NonNull NavigationEdge>> related2bindableSources = new HashMap<>();
		/**
	 * Each computable node is navigable within the guard/predicate from the head but does not have an equivalent node in every possible caller.
	 * A computable node cannot always be passed by value. It is therefore recomputed within a known set of calling regions at each called node.
	 * /
		Map<@NonNull Node, @NonNull List<@NonNull Region>> related2computableSources = new HashMap<>();
		ScheduledRegion invokingRegion2 = invokingRegion;
		assert invokingRegion2 != null;
		RootScheduledRegion rootScheduledRegion = invokingRegion2.getRootScheduledRegion();
		//
		//	Categorize the corresponding sources for each related node as uniformly bindable else re-computable.
		//
		for (@NonNull Node headSource : headSources) {
			Region sourceRegion = headSource.getRegion();
			assert this != sourceRegion;
			for (@NonNull Node headNode : headConnection.getTargets()) {
				if ((headNode.getRegion() == this) && headNode.isHead()) {
					Map<@NonNull Node, @Nullable Node> calledNode2callingNode = new HashMap<>();
					Map<@NonNull NavigationEdge, @Nullable NavigationEdge> calledEdge2callingEdge = new HashMap<>();
					computeCompatiblePattern(headNode, headSource, calledNode2callingNode, calledEdge2callingEdge);
					for (Map./*@NonNull* /Entry<@NonNull NavigationEdge, @Nullable NavigationEdge> entry : calledEdge2callingEdge.entrySet()) {
						@NonNull NavigationEdge calledEdge = entry.getKey();
						@NonNull Node calledNode = calledEdge.getTarget();
						assert calledNode.isHead() == (calledNode == headNode);		// FIXME validating more efficient test
						if (!calledNode.isHead()
						 && !calledNode.isLoaded()
						 && !calledNode.isConstant()
						 && !rootScheduledRegion.isOnlyCastOrRecursed(calledNode)) {
							@Nullable NavigationEdge callingEdge = entry.getValue();
							if ((callingEdge != null) && !related2computableSources.containsKey(calledNode)) {
								List<@NonNull NavigationEdge> bindableSources = related2bindableSources.get(calledEdge);
								if (bindableSources == null) {
									bindableSources = new ArrayList<>();
									related2bindableSources.put(calledEdge, bindableSources);
								}
								assert !bindableSources.contains(callingEdge);
								bindableSources.add(callingEdge);
							}
							else {
								List<@NonNull Region> computableSources = related2computableSources.get(calledNode);
								if (computableSources == null) {
									computableSources = new ArrayList<>();
									related2computableSources.put(calledNode, computableSources);
								}
								assert !computableSources.contains(sourceRegion);
								computableSources.add(sourceRegion);
								if (related2bindableSources.containsKey(calledEdge)) {
									List<@NonNull NavigationEdge> bindableSources = related2bindableSources.remove(calledEdge);
									assert bindableSources != null;
									for (@NonNull NavigationEdge bindableSource : bindableSources) {
										Region bindableRegion = bindableSource.getRegion();
										assert !computableSources.contains(sourceRegion);
										computableSources.add(bindableRegion);
									}
								}
							}
						}
					}
				}
			}
		}
		assert Sets.intersection(related2bindableSources.keySet(), related2computableSources.keySet()).isEmpty();
		//
		//	Connect the uniformly bindable calling sources to their called nodes.
		//
		for (Map./*@NonNull* /Entry<@NonNull NavigationEdge, @NonNull List<@NonNull NavigationEdge>> entry : related2bindableSources.entrySet()) {
			@NonNull NavigationEdge calledEdge = entry.getKey();
			@NonNull Node calledNode = calledEdge.getTarget();
			assert !calledNode.isLoaded() && !calledNode.isConstant();
			@NonNull List<@NonNull NavigationEdge> bindableEdges = entry.getValue();
			EdgeConnection bindableConnection = invokingRegion2.getEdgeConnection(bindableEdges, calledEdge.getProperty());
			bindableConnection.addUsedTargetEdge(calledEdge, false);
			if (Scheduler.CONNECTIONS.isActive()) {
				Scheduler.CONNECTIONS.println("  Bindable EdgeConnection to " + calledEdge);
			}
		}
		//
		//	Connect the introducing/producing nodes of the not uniformly bindable calling sources to their called nodes.
		//
		for (Map./*@NonNull* /Entry<@NonNull Node, @NonNull List<@NonNull Region>> entry : related2computableSources.entrySet()) {
			@NonNull Node calledNode = entry.getKey();
			assert !calledNode.isLoaded() && !calledNode.isConstant() && !rootScheduledRegion.isOnlyCastOrRecursed(calledNode);
			ClassDatumAnalysis classDatumAnalysis = calledNode.getClassDatumAnalysis();
			Iterable<@NonNull Node> introducingOrProducingNodes = rootScheduledRegion.getIntroducingOrProducingNodes(classDatumAnalysis);
			if (introducingOrProducingNodes != null) {
				@NonNull List<@NonNull Region> computableRegions = entry.getValue();
				List<@NonNull Node> computableSourceNodes = null;
				assert calledNode.getRegion() == this;		// FIXME just checking simpler test
				for (@NonNull Node computableSourceNode : introducingOrProducingNodes) {
					Region sourceRegion = computableSourceNode.getRegion();
					if ((computableSourceNode.getRegion() != this) && !computableRegions.contains(sourceRegion)) {		// FIXME only if a Recursion Edge
						if (computableSourceNodes == null) {
							computableSourceNodes = new ArrayList<>();
						}
						computableSourceNodes.add(computableSourceNode);
					}
				}
				if (computableSourceNodes != null) {
					NodeConnection computableConnection = invokingRegion2.getNodeConnection(computableSourceNodes, classDatumAnalysis);
					computableConnection.addUsedTargetNode(calledNode, false);
					if (Scheduler.CONNECTIONS.isActive()) {
						Scheduler.CONNECTIONS.println("  Computable NodeConnection to " + calledNode);
					}
				}
			}
		}
	} */

	private Stream<String> dumpInputModels() {
		Stream<String> entries = inputModels.keySet().stream().map(
			k -> String.valueOf(k) + " : " + String.valueOf(inputModels.get(k)));
		return entries.sorted();
	}

	public @NonNull List<@NonNull Iterable<@NonNull PartitionAnalysis>> getMergedPartitionSchedule(@NonNull RootPartitionAnalysis rootPartitionAnalysis) {
		ScheduledRegion scheduledRegion = rootPartitionAnalysis.getScheduledRegion();
		assert scheduledRegion != null;
		List<Region> activeRegions = scheduledRegion.getActiveRegions();
		activeRegions.clear();
		List<@NonNull Iterable<@NonNull PartitionAnalysis>> partitionSchedule1 = mergePartitionsHorizontally(rootPartitionAnalysis.getPartitionSchedule());
		List<@NonNull Iterable<@NonNull PartitionAnalysis>> partitionSchedule2 = mergePartitionsVertically(partitionSchedule1);
		for (@NonNull Iterable<@NonNull PartitionAnalysis> concurrentPartitions : partitionSchedule2) {
			List<@NonNull Region> concurrentRegions = new ArrayList<>();
			for (@NonNull PartitionAnalysis partitionAnalysis : concurrentPartitions) {
				Partition partition = partitionAnalysis.getPartition();
				if (partitionAnalysis instanceof CyclicPartitionAnalysis) {
					getRegionSchedule(((CyclicPartitionAnalysis)partitionAnalysis));
					for (@NonNull MappingRegion mappingRegion : ((CyclicPartitionAnalysis)partitionAnalysis).createMicroMappingRegions()) {
						activeRegions.add(mappingRegion);
						concurrentRegions.add(mappingRegion);
					}
				}
				else if (!(partition instanceof LoadingPartition)) {
					MappingRegion mappingRegion = partitionAnalysis.createMicroMappingRegion();
					//	scheduleManager.wipAddPartition(partition, mappingRegion);
					activeRegions.add(mappingRegion);
					concurrentRegions.add(mappingRegion);
				}
				else {
					activeRegions.add(partition.getRegion());
				}
			}
		}
		return partitionSchedule2;
	}

	public @NonNull RegionAnalysis getRegionAnalysis(@NonNull Region region) {
		RegionAnalysis regionAnalysis = region2regionAnalysis.get(region);
		if (regionAnalysis == null) {
			regionAnalysis = scheduleManager.getRegionAnalysis(region);
			region2regionAnalysis.put(region, regionAnalysis);
		}
		return regionAnalysis;
	}

	public @NonNull List<@NonNull Collection<@NonNull Region>> getRegionSchedule(@NonNull CyclicPartitionAnalysis cyclicPartitionAnalysis) {
		List<@NonNull Collection<@NonNull Region>> regionSchedule = new ArrayList<>();
		for (@NonNull Iterable<@NonNull PartitionAnalysis> concurrentPartitions : cyclicPartitionAnalysis.getPartitionSchedule()) {
			List<@NonNull Region> concurrentRegions = new ArrayList<>();
			for (@NonNull PartitionAnalysis partitionAnalysis : concurrentPartitions) {
				if (partitionAnalysis instanceof CyclicPartitionAnalysis) {
					getRegionSchedule(((CyclicPartitionAnalysis)partitionAnalysis));
					Iterables.addAll(concurrentRegions, ((CyclicPartitionAnalysis)partitionAnalysis).createMicroMappingRegions());
				}
				else {
					MappingRegion partitionedRegion = partitionAnalysis.createMicroMappingRegion();
					concurrentRegions.add(partitionedRegion);
					//	scheduleManager.wipAddPartition(partition, partitionedRegion);
				}
			}
			regionSchedule.add(concurrentRegions);
		}
		return regionSchedule;
	}

	/*	public @NonNull List<@NonNull Collection<@NonNull Region>> getRegionSchedule2(@NonNull RootPartitionAnalysis rootPartitionAnalysis, @NonNull List<@NonNull Iterable<@NonNull Partition>> partitionSchedule) {
		ScheduledRegion scheduledRegion = rootPartitionAnalysis.getScheduledRegion();
		List<@NonNull Collection<@NonNull Region>> regionSchedule = new ArrayList<>();
		assert scheduledRegion != null;
		LoadingRegion loadingRegion = scheduledRegion.getOwnedLoadingRegion();
		if (loadingRegion != null) {
			regionSchedule.add(Lists.newArrayList(loadingRegion));
		}
		for (@NonNull Iterable<@NonNull Partition> concurrentPartitions : partitionSchedule) {
			List<@NonNull Region> concurrentRegions = new ArrayList<>();
			for (@NonNull Partition partition : concurrentPartitions) {
				if (partition instanceof CyclicPartition) {
					getRegionSchedule(((CyclicPartition)partition));
					for (@NonNull PartitionAnalysis partitionAnalysis : ((CyclicPartition)partition).getPartitionAnalyses()) {
						MappingRegion mappingRegion = partitionAnalysis.getPartition().getMicroMappingRegion();
						concurrentRegions.add(mappingRegion);
					}
				}
				else if (!(partition instanceof LoadingPartition)) {
					MappingRegion mappingRegion = partition.getMicroMappingRegion();
					concurrentRegions.add(mappingRegion);
				}
			}
			if (concurrentRegions.size() > 0) {
				regionSchedule.add(concurrentRegions);
			}
		}
		return regionSchedule;
	} */

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull StandardLibraryHelper getStandardLibraryHelper() {
		return standardLibraryHelper ;
	}

	/*	private void lateMerge(@NonNull RootPartition rootPartition, @NonNull List<@NonNull Collection<@NonNull Region>> parallelSchedule,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		Map<@NonNull Region, @NonNull Integer> region2depth = new HashMap<>();
		int parallelDepth = 0;
		for (@NonNull Iterable<@NonNull Region> orderedRegions : parallelSchedule) {
			for (@NonNull Region region : orderedRegions) {
				region2depth.put(region,  parallelDepth);
			}
			parallelDepth++;
		}
		Map<@NonNull MappingRegion, @NonNull List<@NonNull MappingRegion>> newRegion2oldRegions = LateConsumerMerger.merge(scheduleManager, rootPartition);
		for (Map.Entry<@NonNull MappingRegion, @NonNull List<@NonNull MappingRegion>> entry : newRegion2oldRegions.entrySet()) {
			MappingRegion newRegion = entry.getKey();
			List<@NonNull MappingRegion> oldRegions = entry.getValue();
			assert oldRegions.size() >= 2;
			//	int orderedRegionIndex = orderedRegions.indexOf(oldRegions.get(0));
			Integer orderedRegionIndex = region2depth.get(oldRegions.get(0));
			assert orderedRegionIndex != null;
			for (@NonNull MappingRegion oldRegion : oldRegions) {
				//				orderedRegions.remove(oldRegion);
				Integer depth = region2depth.get(oldRegion);
				assert depth != null;
				parallelSchedule.get(depth).remove(oldRegion);
				scheduleManager.setScheduledRegion(oldRegion, null);
			}
			//	orderedRegions.add(orderedRegionIndex, newRegion);
			parallelSchedule.get(orderedRegionIndex).add(newRegion);
			QVTscheduleConstants.POLLED_PROPERTIES.println("building indexes for " + newRegion + " " + scheduleManager.wipGetPartition(newRegion).getPassRangeText());
			//			RegionAnalysis regionAnalysis = scheduleManager.getRegionAnalysis(newRegion);
			//			regionAnalysis.buildNavigationEdgesIndex(typedModel2property2predicatedEdges, typedModel2property2realizedEdges);
		}
	} */

	private @NonNull List<@NonNull Iterable<@NonNull PartitionAnalysis>> mergePartitionsHorizontally(@NonNull List<@NonNull Iterable<@NonNull PartitionAnalysis>> partitionSchedule) {
		for (int i = 0; i < partitionSchedule.size(); i++) {
			Iterable<@NonNull PartitionAnalysis> oldConcurrency = partitionSchedule.get(i);
			if (Iterables.size(oldConcurrency) > 1) {
				Map<@NonNull Region, @NonNull List<@NonNull PartitionAnalysis>> region2partitions = new HashMap<>();
				for (@NonNull PartitionAnalysis partitionAnalysis : oldConcurrency) {
					Partition partition = partitionAnalysis.getPartition();
					if (!(partition instanceof CyclicPartition)) {
						Region region = QVTscheduleUtil.getRegion(partition);
						List<@NonNull PartitionAnalysis> partitions = region2partitions.get(region);
						if (partitions == null) {
							partitions = new ArrayList<>();
							region2partitions.put(region, partitions);
						}
						partitions.add(partitionAnalysis);
					}
				}
				Set<@NonNull PartitionAnalysis> newConcurrency = null;
				for (@NonNull Region region : region2partitions.keySet()) {
					if (!(region instanceof CyclicMappingRegion)) {
						List<@NonNull PartitionAnalysis> partitions = region2partitions.get(region);
						assert partitions != null;
						if (partitions.size() > 1) {
							RegionAnalysis regionAnalysis = scheduleManager.getRegionAnalysis(region);
							HorizontalPartitionMerger horizontalMerger = new HorizontalPartitionMerger(regionAnalysis, partitions);
							Map<@NonNull PartitionAnalysis, @Nullable PartitionAnalysis> old2new = horizontalMerger.merge();
							if (old2new != null) {
								if (newConcurrency == null) {
									newConcurrency = Sets.newHashSet(oldConcurrency);
								}
								for (@NonNull PartitionAnalysis oldPartition : old2new.keySet()) {
									newConcurrency.remove(oldPartition);
									PartitionAnalysis newPartition = old2new.get(oldPartition);
									assert newPartition != null;
									newConcurrency.add(newPartition);
								}
							}
							if (newConcurrency != null) {
								partitionSchedule.set(i, newConcurrency);
							}
						}
					}
				}
			}
		}
		return partitionSchedule;
	}

	private @NonNull List<@NonNull Iterable<@NonNull PartitionAnalysis>> mergePartitionsVertically(@NonNull List<@NonNull Iterable<@NonNull PartitionAnalysis>> partitionSchedule) {
		return partitionSchedule;
	}

	protected @NonNull PartitionedTransformationAnalysis partition(ScheduleManager scheduleManager, @NonNull ScheduledRegion scheduledRegion, @NonNull Iterable<? extends @NonNull Region> activeRegions) throws CompilerChainException {
		AbstractTransformationAnalysis transformationAnalysis = scheduleManager.getTransformationAnalysis(scheduledRegion);
		PartitionedTransformationAnalysis partitionedTransformationAnalysis = transformationAnalysis.partition(problemHandler, activeRegions);
		RootPartitionAnalysis rootPartitionAnalysis = partitionedTransformationAnalysis.getRootPartitionAnalysis();
		rootPartitionAnalysis.setScheduledRegion(scheduledRegion);
		//	scheduledRegion2rootPartition.put(scheduledRegion, rootPartition);
		//	Iterable<@NonNull MappingRegion> partitionedRegions = rootPartition.getPartitionedRegions();
		//	if (!Iterables.isEmpty(partitionedRegions)) {
		//			for (@NonNull Region region : partitionedRegions) {
		//				System.out.println("partitionedRegions " + region);
		//			}
		//	scheduledRegion2partitionedRegions.put(scheduledRegion, partitionedRegions);
		//	}
		//	else {
		//		scheduledRegion2partitionedRegions.put(scheduledRegion, activeRegions);
		//	}
		return partitionedTransformationAnalysis;
	}

	/**
	 * Remove the used connections whose consumers are necessarily after their last producer.
	 */
	protected void pruneRedundantConnections(@NonNull ConnectionManager connectionManager, @NonNull ScheduledRegion scheduledRegion) {
		List<@NonNull Connection> redundantConnections = null;
		for (@NonNull Connection connection : QVTscheduleUtil.getOwnedConnections(scheduledRegion)) {
			if (!connection.isPassed() && !connection.isMandatory()) {
				boolean isRedundant = true;
				int lastPass = connection.getLastPass();
				for (@NonNull Partition targetPartition : connection.getTargetPartitions()) {
					int firstPass = targetPartition.getFirstPass();
					if (firstPass <= lastPass) {
						isRedundant = false;
						break;
					}
				}
				if (isRedundant) {
					if (redundantConnections == null) {
						redundantConnections = new ArrayList<>();
					}
					redundantConnections.add(connection);
				}
			}
		}
		if (redundantConnections != null) {
			for (@NonNull Connection redundantConnection : redundantConnections) {
				redundantConnection.destroy();
				//				connectionManager.removeTargetRegion(redundantConnection, scheduleManager.wipGetRegion(partition));
			}
		}
	}

	protected void schedule(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		RootPartitionAnalysis rootPartitionAnalysis = partitionedTransformationAnalysis.getRootPartitionAnalysis();
		RootPartition rootPartition = rootPartitionAnalysis.getPartition();
		ScheduledRegion scheduledRegion = rootPartitionAnalysis.getScheduledRegion();
		ConnectionManager connectionManager = scheduleManager.getConnectionManager();
		List<@NonNull Iterable<@NonNull PartitionAnalysis>> partitionSchedule = rootPartitionAnalysis.getPartitionSchedule();
		//
		//	Create a connection between each consumer and the corresponding introducer/producer.
		//
		connectionManager.createConnections(scheduledRegion, partitionSchedule);
		ScheduleAnalysis scheduleAnalysis = new ScheduleAnalysis(partitionedTransformationAnalysis, connectionManager, rootPartitionAnalysis);
		scheduleAnalysis.schedule(rootPartition, partitionSchedule);

		//
		//	Index all predicated and realized edges by typed model and property.
		//
		partitionedTransformationAnalysis.analyzePartitionEdges(partitionSchedule);

		//	Iterable<@NonNull Region> mappingRegions = QVTscheduleUtil.getActiveRegions(scheduledRegion);
		//	assert Iterables.isEmpty(mappingRegions);
		List<@NonNull Iterable<@NonNull PartitionAnalysis>> mergedPartitionSchedule = getMergedPartitionSchedule(rootPartitionAnalysis);		// FIXME separate side effects
		//
		//	Identify the input models.
		//
		computeInputModels();
		//
		//	Identify the content of each region.
		//
		//	PartitionedContentsAnalysis partitionedContentsAnalysis = connectionManager.getPartitionedContentsAnalysis();
		//	partitionedContentsAnalysis.analyzeRegions(rootPartition.getScheduledRegion());
		//
		//	Create the root containment region to introduce all root and otherwise contained consumed classes.
		//
		createRootContainmentRegion(rootPartitionAnalysis);

		List<@NonNull RootPartition> allRootPartitions = new ArrayList<>();
		allRootPartitions.add(rootPartition);
		//
		// Remove the used connections whose consumers are necessarily after their last producer.
		//
		pruneRedundantConnections(connectionManager, scheduledRegion);
		scheduleManager.writeDebugGraphs("8-pruned", true, true, false);

		/*	boolean noLateConsumerMerge = scheduleManager.isNoLateConsumerMerge();
		if (!noLateConsumerMerge) {
			List<@NonNull Collection<@NonNull Region>> regionSchedule = getRegionSchedule2(rootPartition, mergedPartitionSchedule);		// FIXME separate side effects
			lateMerge(rootPartition, regionSchedule, typedModel2property2predicatedEdges, typedModel2property2realizedEdges);
		} */

		partitionedTransformationAnalysis.computeCheckedOrEnforcedEdges(mergedPartitionSchedule);

		/*	suspended - just an optimization - needs more hierarchical consideration
			//
			//	Redirect ordered consumers to depend on each other's heads thereby respecting the ordering and
			//	making earlier results available to later mappings.
			//
			if (region2orderingEdge2usedEdges != null) {
				for (@SuppressWarnings("null")@NonNull Region commonRegion : region2orderingEdge2usedEdges.keySet()) {
					@SuppressWarnings("null")@NonNull Map<Edge, Set<Edge>> orderingEdge2usedEdges = region2orderingEdge2usedEdges.get(commonRegion);
					convertConsumedOrdering(commonRegion, orderingEdge2usedEdges);
				}
			}
			writeDOTfile("-5-reconsume");
			writeGraphMLfile("-5-reconsume"); */
		/*	suspended - just an optimization - needs more hierarchical consideration
			//
			//	Merge again now that dependencies may be available.
			//
			Region2Depth region2depths = new Region2Depth();
			List<Region> sortedRegions = region2depths.getSortedRegions(getRegions());
			for (Region calledRegion : sortedRegions) {
				List<List<Node>> headNodeGroups = calledRegion.getHeadNodeGroups();
				if ((headNodeGroups.size() == 1) && !(calledRegion instanceof LoadingRegion)) {
					Region callingRegion = null;
					boolean isMergeable = true;
					for (Node headNode : headNodeGroups.get(0)) {
						for (Node callingNode : headNode.getPassedBindingSources()) {
							if (callingRegion == null) {
								callingRegion = callingNode.getRegion();
							}
							else if (callingRegion != callingNode.getRegion()) {
								isMergeable = false;
								break;
							}
						}
					}
					if ((callingRegion != null) && isMergeable && callingRegion.isLateMergeable(calledRegion, region2depths)) {
						Map<Node, Node> node2mergedNode = callingRegion.canMerge(calledRegion, region2depths, true);
						if (node2mergedNode != null) {
							MergedRegion mergedRegion;
							if (callingRegion instanceof MergedRegion) {
								mergedRegion = (MergedRegion)callingRegion;
							}
							else {
								getRegions().remove(calledRegion);
								mergedRegion = new MergedRegion((MergeableRegion)callingRegion);
								Region invokingRegion = callingRegion.getInvokingRegion();
								assert invokingRegion != null;
								List<Region> regions = invokingRegion.getRegions();
								int index = regions.indexOf(callingRegion);
								assert index >= 0;
								regions.set(index, mergedRegion);
//								mergedRegion.writeDOTfile("-6-merged");
//								mergedRegion.writeGraphMLfile("-6-merged");
							}
							mergedRegion.mergeRegion(calledRegion, node2mergedNode);
							getRegions().remove(calledRegion);
							mergedRegion.writeDOTfile("-6-merged");
							mergedRegion.writeGraphMLfile("-6-merged");
							mergedRegion.resolveRecursion();
							mergedRegion.writeDOTfile("-7-merged");
							mergedRegion.writeGraphMLfile("-7-merged");
							region2depths.addRegion(mergedRegion);
						}
					}
				}
			} */
		if (ConnectivityChecker.CONNECTIVITY.isActive()) {
			//			ConnectivityChecker.checkConnectivity(scheduleManager);
		}
	}

	public @NonNull Iterable<@NonNull ScheduledRegion> transform(@NonNull ScheduleManager scheduleManager, @NonNull Map<@NonNull ScheduledRegion, Iterable<@NonNull MappingRegion>> scheduledRegion2activeRegions) throws CompilerChainException {
		ConnectionManager connectionManager = scheduleManager.getConnectionManager();
		LoadingRegion loadingRegion = loadingRegionAnalysis.getRegion();
		Iterable<@NonNull ScheduledRegion> scheduledRegions = scheduledRegion2activeRegions.keySet();
		List<@NonNull PartitionedTransformationAnalysis> partitionedTransformationAnalyses = new ArrayList<>();
		for (@NonNull ScheduledRegion scheduledRegion : scheduledRegions) {
			assert scheduledRegion.getActiveRegions().isEmpty();
			Iterable<? extends @NonNull MappingRegion> activeRegions = scheduledRegion2activeRegions.get(scheduledRegion);
			assert activeRegions != null;
			List<@NonNull Region> activeRegions2 = new ArrayList<>();
			activeRegions2.add(loadingRegion);
			Iterables.addAll(activeRegions2, activeRegions);
			Collections.sort(activeRegions2, NameUtil.NAMEABLE_COMPARATOR);
			scheduledRegion.getActiveRegions().addAll(activeRegions2);
			//			RootPartition rootPartition = partition(scheduleManager, scheduledRegion, activeRegions2);
			//			rootPartitions.add(rootPartition);
			//
			//	Create a connection between each consumer and the corresponding introducer/producer.
			//
			for (@NonNull Region region : activeRegions2) {
				if (!(region instanceof LoadingRegion)) {
					connectionManager.createIncomingConnections(scheduledRegion, region);
				}
			}
		}
		scheduleManager.writeDebugGraphs("4-pre-partition", true, true, false);
		//
		for (@NonNull ScheduledRegion scheduledRegion : scheduledRegions) {
			Iterable<@NonNull Region> activeRegions2 = QVTscheduleUtil.getActiveRegions(scheduledRegion);
			PartitionedTransformationAnalysis partitionedTransformationAnalysis = partition(scheduleManager, scheduledRegion, activeRegions2);
			partitionedTransformationAnalyses.add(partitionedTransformationAnalysis);
			for (@NonNull Region region : QVTscheduleUtil.getActiveRegions(scheduledRegion)) {
				connectionManager.createPartitionConnections(scheduledRegion, region);
			}
		}
		//		getRegionAnalysis(loadingRegion).setPartitions(Collections.singletonList(new NonPartition(loadingRegion));
		scheduleManager.writeDebugGraphs("5-post-partition", true, true, false);
		//
		for (@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis : partitionedTransformationAnalyses) {
			schedule(partitionedTransformationAnalysis);
		}
		scheduleManager.writeDebugGraphs("9-final", true, true, false);
		return scheduledRegions;
	}
	/*	public @NonNull Iterable<@NonNull ScheduledRegion> ztransform(@NonNull ScheduleManager scheduleManager, @NonNull Map<@NonNull ScheduledRegion, Iterable<@NonNull MappingRegion>> scheduledRegion2activeRegions) throws CompilerChainException {
		LoadingRegion loadingRegion = loadingRegionAnalysis.getRegion();
		Iterable<@NonNull ScheduledRegion> scheduledRegions = scheduledRegion2activeRegions.keySet();
		List<@NonNull RootPartition> rootPartitions = new ArrayList<>();
		for (@NonNull ScheduledRegion scheduledRegion : scheduledRegions) {
			assert scheduledRegion.getActiveRegions().isEmpty();
			Iterable<? extends @NonNull MappingRegion> activeRegions = scheduledRegion2activeRegions.get(scheduledRegion);
			assert activeRegions != null;
			List<Region> mappingRegions = Lists.newArrayList(activeRegions);
			mappingRegions.add(loadingRegion);
			Collections.sort(mappingRegions, NameUtil.NAMEABLE_COMPARATOR);
			Iterables.addAll(scheduledRegion.getActiveRegions(), mappingRegions);
			//
			//	Create a connection between each consumer and the corresponding introducer/producer.
			//
			ConnectionManager connectionManager = getConnectionManager(scheduledRegion);
			for (@NonNull Region region : mappingRegions) {
				connectionManager.createIncomingConnections(region);
			}
		}
		scheduleManager.writeDebugGraphs("4-pre-partition", true, true, false);
		//
		for (@NonNull ScheduledRegion scheduledRegion : scheduledRegions) {
			RootPartition rootPartition = partition(scheduleManager, scheduledRegion);
			rootPartitions.add(rootPartition);
			ConnectionManager connectionManager = getConnectionManager(scheduledRegion);
			for (@NonNull Region region : QVTscheduleUtil.getActiveRegions(scheduledRegion)) {
				connectionManager.createPartitionConnections(region);
			}
		}
		//		getRegionAnalysis(loadingRegion).setPartitions(Collections.singletonList(new NonPartition(loadingRegion));
		scheduleManager.writeDebugGraphs("5-post-partition", true, true, false);
		//
		for (@NonNull RootPartition rootPartition : rootPartitions) {
			schedule(rootPartition);
		}
		scheduleManager.writeDebugGraphs("9-final", true, true, false);
		return scheduledRegions;
	} */
}
