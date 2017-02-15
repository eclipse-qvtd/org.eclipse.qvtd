/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.ContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RootMappingAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.ScheduleModel2;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.LateConsumerMerger;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.Partitioner;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * QVTs2QVTi supervises the serialization of a QVTs schedule as a QVTi transformation.
 */
public class QVTs2QVTs extends QVTimperativeHelper
{

	/**
	 * Return true if the predicates of calledNode are not in conflict with the navigable paths from callingNode.
	 * called2calling identifies already identified conflict free pairs that do not need re-assessment.
	 */
	private static boolean isCompatiblePattern(@NonNull Region region, @NonNull Node calledNode, @NonNull Node callingNode, @NonNull Map<@NonNull Node, @NonNull Node> called2calling) {
		Node oldPrevNode = called2calling.put(calledNode, callingNode);
		if (oldPrevNode != null) {
			return oldPrevNode == callingNode;
		}
		for (@NonNull NavigableEdge calledEdge : calledNode.getNavigationEdges()) {
			Node nextCalledNode = calledEdge.getEdgeTarget();
			if (!nextCalledNode.isRealized() && !nextCalledNode.isDataType()) {  // FIXME why exclude AttributeNodes?
				Edge nextCallingEdge = callingNode.getNavigationEdge(QVTscheduleUtil.getProperty(calledEdge));
				if (nextCallingEdge != null) {
					Node nextCallingNode = nextCallingEdge.getEdgeTarget();
					if ((nextCallingNode.isExplicitNull() != nextCalledNode.isExplicitNull())) {
						return false;
					}
					if (!isCompatiblePattern(region, nextCalledNode, nextCallingNode, called2calling)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	protected final @NonNull ProblemHandler problemHandler;
	protected final @NonNull String rootName;
	private final @NonNull LoadingRegion rootContainmentRegion;
	private ContentsAnalysis contentsAnalysis;
	private final @NonNull RootMappingAnalysis rootAnalysis;

	protected final @NonNull CompleteModel completeModel;
	private final @NonNull Map<@NonNull Region, org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis> region2regionAnalysis = new HashMap<>();


	/**
	 * The input models that may introduce model elements for transformation.
	 */
	private final @NonNull Map<@NonNull Model, @NonNull DomainUsage> inputModels = new HashMap<>();
	private final @NonNull StandardLibraryHelper standardLibraryHelper;
	//	private final @NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges = new HashMap<>();
	//	private final @NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges = new HashMap<>();

	public QVTs2QVTs(@NonNull ProblemHandler problemHandler, @NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull String rootName) {
		super(environmentFactory);
		this.standardLibraryHelper = new StandardLibraryHelper(standardLibrary);
		this.problemHandler = problemHandler;
		this.rootName = rootName;
		this.rootContainmentRegion = QVTscheduleFactory.eINSTANCE.createLoadingRegion();

		this.rootAnalysis = new RootMappingAnalysis(rootContainmentRegion);
		this.completeModel = environmentFactory.getCompleteModel();
	}

	private void computeInputModels(@NonNull ScheduledRegion rootScheduledRegion) {
		for (ClassDatumAnalysis classDatumAnalysis : ((ScheduleModel2)rootScheduledRegion.getScheduleModel()).getClassDatumAnalyses()) {
			DomainUsage domainUsage = classDatumAnalysis.getDomainUsage();
			if (domainUsage.isInput() && !domainUsage.isOutput()) {
				Type type = classDatumAnalysis.getClassDatum().getCompleteClass().getPrimaryClass();
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
	}

	/**
	 * Create a RootContainmentRegion that introduces model elements directly from the input model root, or from
	 * composition relationships that form part of an extended metamodel that is not known until run-time.
	 */
	private @NonNull LoadingRegion createRootContainmentRegion(@NonNull ScheduledRegion rootScheduledRegion) {
		rootContainmentRegion.setInvokingRegion(rootScheduledRegion);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			rootContainmentRegion.writeDebugGraphs(null);
		}
		return rootContainmentRegion;
	}

	/**
	 * Create the Passed and Used Connections between all introducers and their corresponding consuming nodes.
	 */
	private void createConnections(@NonNull ScheduledRegion rootScheduledRegion) {
		List<@NonNull Region> sortedCallableRegions = new ArrayList<>();
		Iterables.addAll(sortedCallableRegions, rootScheduledRegion.getCallableRegions());
		Collections.sort(sortedCallableRegions, NameUtil.NAMEABLE_COMPARATOR);
		for (Region region : sortedCallableRegions) {
			createIncomingConnections(region);
		}
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			rootScheduledRegion.writeDebugGraphs("4-bindings", true, true, false);
		}
		//		for (Region region : sortedCallableRegions) {
		//			region.checkIncomingConnections();
		//		}
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

	/**
	 * Create an EdgeConnection for the predicatedEdge and/or its target node.
	 */
	private void createEdgeConnection(@NonNull Region region, @NonNull NavigableEdge predicatedEdge) {
		assert predicatedEdge.isNavigation();
		assert predicatedEdge.getIncomingConnection() == null;
		if (predicatedEdge.isCast()) {
			return;			// casts are handled as an extension of a true navigation
		}
		Property predicatedProperty = predicatedEdge.getProperty();
		if (predicatedProperty.isIsImplicit()) {
			return;			// unnavigable opposites are handled by the navigable property
		}
		ScheduledRegion invokingRegion2 = region.getInvokingRegion();
		assert invokingRegion2 != null;
		NavigableEdge castEdge = QVTscheduleUtil.getCastTarget(predicatedEdge);
		Node castTarget = QVTscheduleUtil.getCastTarget(castEdge.getEdgeTarget());
		ClassDatumAnalysis classDatumAnalysis = RegionUtil.getClassDatumAnalysis(castTarget);
		if (classDatumAnalysis.getClassDatum().getCompleteClass().getPrimaryClass() instanceof DataType) {
			Iterable<@NonNull NavigableEdge> realizedEdges = getNewEdges(predicatedEdge, classDatumAnalysis);
			if (realizedEdges != null) {
				List<@NonNull Node> sourceNodes = new ArrayList<>();
				for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
					if (RegionUtil.isElementallyConformantSource(realizedEdge, predicatedEdge) && QVTscheduleUtil.isConformantTarget(realizedEdge, predicatedEdge)) {
						sourceNodes.add(realizedEdge.getEdgeTarget());
					}
				}
				NodeConnection nodeConnection = invokingRegion2.getAttributeConnection(sourceNodes, predicatedEdge.getEdgeSource().getCompleteClass(), predicatedProperty, classDatumAnalysis.getClassDatum());
				nodeConnection.addUsedTargetNode(castTarget, false);
				if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
					QVTscheduleConstants.CONNECTION_CREATION.println("  Attribute NodeConnection \"" + nodeConnection + "\" to " + castTarget);
					//					Scheduler.CONNECTIONS.println("    classDatumAnalysis " + classDatumAnalysis);
					//					for (@NonNull Node sourceNode : sourceNodes) {
					//						Scheduler.CONNECTIONS.println("    from " + sourceNode.getRegion());
					//						Scheduler.CONNECTIONS.println("       " + sourceNode);
					//					}
					//					for (@NonNull NavigationEdge realizedEdge : realizedEdges) {
					//						Scheduler.CONNECTIONS.println("    edge " + realizedEdge);
					//					}
				}
			}
		}
		else {
			Iterable<@NonNull Node> sourceNodes = getNewNodes(classDatumAnalysis);
			//			if (sourceNodes != null) {
			Iterable<@NonNull NavigableEdge> realizedEdges = getNewEdges(predicatedEdge, classDatumAnalysis);
			if (realizedEdges != null) {
				Set<@NonNull Region> edgeSourceRegions = new HashSet<>();
				Set<@NonNull Region> nodeSourceRegions = new HashSet<>();
				for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
					edgeSourceRegions.add(QVTscheduleUtil.getRegion(realizedEdge));
				}
				if (sourceNodes != null) {
					for (@NonNull Node sourceNode : sourceNodes) {
						nodeSourceRegions.add(QVTscheduleUtil.getRegion(sourceNode));
					}
				}
				//
				// Create an EdgeConnection for the edge realizations unless all edges are sources by node sources.
				//
				if (!nodeSourceRegions.containsAll(edgeSourceRegions)) {	// If edges are assigned independently of their targets.
					Set<@NonNull Region> conformantEdgeSourceRegions = null;
					List<@NonNull NavigableEdge> thoseEdges = null;
					for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
						if (RegionUtil.isElementallyConformantSource(realizedEdge, predicatedEdge) && QVTscheduleUtil.isConformantTarget(realizedEdge, predicatedEdge)) {
							if (thoseEdges == null) {
								thoseEdges = new ArrayList<>();
								conformantEdgeSourceRegions = new HashSet<>();
							}
							if (!thoseEdges.contains(realizedEdge)) {
								thoseEdges.add(realizedEdge);
								assert conformantEdgeSourceRegions != null;
								conformantEdgeSourceRegions.add(QVTscheduleUtil.getRegion(realizedEdge));
							}
						}
					}
					if ((thoseEdges != null) && !nodeSourceRegions.containsAll(conformantEdgeSourceRegions)) {
						EdgeConnection edgeConnection = invokingRegion2.getEdgeConnection(thoseEdges, predicatedProperty);
						if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
							QVTscheduleConstants.CONNECTION_CREATION.println("  EdgeConnection \"" + edgeConnection + "\" to " + predicatedEdge);
						}
						if (!Iterables.contains(edgeConnection.getTargetEdges(), castEdge)) {
							edgeConnection.addUsedTargetEdge(castEdge, false);
							if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
								for (@NonNull NavigableEdge thatEdge : thoseEdges) {
									QVTscheduleConstants.CONNECTION_CREATION.println("    from " + thatEdge.getRegion() + "  : " + thatEdge);
								}
							}
						}
					}
				}
			}
			//
			// Create a NodeConnection for the node realizations.
			//
			if ((sourceNodes != null)
					&& !castTarget.isLoaded()			// WIP and !isOnlyCast
					&& !castTarget.isConstant()
					&& !castTarget.isHead()
					&& !castTarget.isOperation()
					&& !castTarget.isTrue()
					&& (castTarget.getIncomingConnection() == null)
					//			 && !castTarget.isAttributeNode()
					//			 && !rootScheduledRegion.isOnlyCastOrRecursed(predicatedNode)
					//			 && !hasEdgeConnection(predicatedNode)
					) {
				NodeConnection predicatedConnection = invokingRegion2.getNodeConnection(sourceNodes, classDatumAnalysis.getClassDatum());
				predicatedConnection.addUsedTargetNode(castTarget, false);
				if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
					QVTscheduleConstants.CONNECTION_CREATION.println("  NodeConnection \"" + predicatedConnection + "\" to " + castTarget);
					for (@NonNull Node sourceNode : sourceNodes) {
						QVTscheduleConstants.CONNECTION_CREATION.println("    from " + sourceNode.getRegion() + " : " + sourceNode);
					}
				}
			}
			//			}
		}
	}

	/**
	 * Create and return a NodeConnection to the nodes that can provide the sources for headNode.
	 * Returns null if the pattern surrounding the headNode conflicts with the pattern
	 * surrounding all possible sources.
	 */
	private @Nullable NodeConnection createHeadConnection(@NonNull Region region, @NonNull Node headNode) {
		ScheduledRegion invokingRegion2 = region.getInvokingRegion();
		ClassDatumAnalysis classDatumAnalysis = RegionUtil.getClassDatumAnalysis(headNode);
		List<@NonNull Node> headSources = null;
		//
		//	Locate compatible introducers and non-recursive producers
		//
		Iterable<@NonNull Node> sourceNodes = getIntroducingOrNewNodes(headNode);
		if (sourceNodes != null) {
			for (@NonNull Node sourceNode : sourceNodes) {
				//				Region sourceRegion = sourceNode.getRegion();
				//				if (sourceRegion != this) {
				Map<@NonNull Node, @NonNull Node> called2calling = new HashMap<>();
				if (isCompatiblePattern(region, headNode, sourceNode, called2calling)) {
					if (headSources == null) {
						headSources = new ArrayList<>();
					}
					headSources.add(sourceNode);
				}
				//				}
			}
		}
		if (headSources == null) {
			return null;
		}
		//
		//	Connect up the head
		//
		NodeConnection headConnection = invokingRegion2.getNodeConnection(headSources, classDatumAnalysis.getClassDatum());
		if (headNode.isDependency()) {
			headConnection.addUsedTargetNode(headNode, false);
		}
		else {
			headConnection.addPassedTargetNode(headNode);
		}
		if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
			QVTscheduleConstants.CONNECTION_CREATION.println((headNode.isDependency() ? "  Extra NodeConnection " : "  Head NodeConnection \"") + headConnection + "\" to " + headNode);
			for (@NonNull Node sourceNode : headSources) {
				QVTscheduleConstants.CONNECTION_CREATION.println("    from " + sourceNode.getRegion() + " : " + sourceNode);
			}
		}
		return headConnection;
	}

	/**
	 * Return the Connections to each of the head nodes. Returns null if the pattern surrounding any headNode conflicts with the pattern
	 * surrounding all its possible sources. (Any head with no sources is a non-invocation.)
	 */
	private @Nullable Iterable<@NonNull NodeConnection> createHeadConnections(@NonNull Region region) {
		List<@NonNull NodeConnection> headConnections = null;
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(region)) {
			if (headNode.isTrue()) { /* true nodes do not need connections. */ }
			else if (headNode.isDependency()) {
				createHeadConnection(region, headNode);	/** Dependency nodes have extra not-head connections. */
			}
			else {
				NodeConnection headConnection = createHeadConnection(region, headNode);
				if (headConnection == null) {
					region.getScheduleModel().addRegionError(region, "createHeadConnections abandoned for " + headNode);
					region.getScheduleModel().addRegionError(region, "createHeadConnections abandoned for " + headNode);
					headConnection = createHeadConnection(region, headNode);	// FIXME debugging
					return null;										//  so matching only fails for unmatchable real heads
				}
				else {
					if (headConnections == null) {
						headConnections = new ArrayList<>();
					}
					headConnections.add(headConnection);
				}
				// FIXME. If there are multiple heads and an internal node is reachable from more than one head, then the possible
				// sources for the internal node are the intersection of the alternatives which may eliminate some call paths.
			}
		}
		return headConnections;
	}

	/**
	 * Create the connections that establish the inter-region dependencies.
	 *
	 * Every node/edge must have a connection to all its possible sources to ensure that the compile-time / run-time
	 * scheduler delays the execution of this region until the sources are available.
	 *
	 * Connections may be omitted when we can prove that the connection is available as a consequence of some restriction.
	 * - a connection to a CONSTANT source is unnecessary (always available)
	 * - a connection to a LOADED source is unnecessary (always available)
	 * - a connection to a source whose navigation path is incompatible with the head-to-target path is unnecessary
	 * - a connection to a node that is only used in cast form is unnecessary (the cast node provides more precision)
	 * - a connection to a cast edge is unnecessary (the cast edge extends a navigation edge that has a connection)
	 *
	 * Connections to attribute nodes are connected to just the node; a 'duplicate' edge connection is unnecessary
	 *
	 * Connections to realized nodes can be omitted if they are at one end of a realized edge
	 *
	 * Connections to edges account for type conformance of the nodes ends. The edge ends extend to account for casts.
	 *
	 * Each head node has a passed connection from its sources.
	 * Consistently related nodes navigable from the head have a bindable connection to the correspondingly related sources.
	 * Inconsistently related nodes navigable from the head have a computable connection to all compatibly typed sources.
	 * Unrelated nodes such as the internals of computations are not connected; their dependencies should be in dependency heads.
	 * Edges dependent on realization elsewhere are represented by connection from all head nodes of the dependent region
	 * to all heads of the realizing region.
	 */
	public void createIncomingConnections(@NonNull Region region) {
		if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
			QVTscheduleConstants.CONNECTION_CREATION.println("connecting " + region);
		}
		//		assert !(this instanceof RootCompositionRegion);
		assert !"RootCompositionRegion".equals(region.eClass().getName());
		Iterable<@NonNull NodeConnection> headConnections = createHeadConnections(region);
		if (headConnections != null) {
			for (@NonNull NavigableEdge predicatedEdge : region.getPredicatedNavigationEdges()) {
				if (!predicatedEdge.isCast()) {
					createEdgeConnection(region, predicatedEdge);
				}
			}
		}
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

	private void createLocalSchedule(@NonNull ScheduledRegion scheduledRegion) {
		//
		//	Partition single region recursive connections into base cases recursive case connections with associated region recursions.
		//
		//		splitConnectionVariables();
		//
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduledRegion.writeDebugGraphs("5-cycled", true, true, false);
		}
	}

	private void createLocalSchedule2(@NonNull ScheduledRegion scheduledRegion, @NonNull List<@NonNull Region> orderedRegions) {
		//		region2order.computeRegionIndexes(getCallableRegions());
		//		Iterable<Region> sortedCallableRegions = regionOrdering;//AbstractRegion.EarliestRegionComparator.sort(getCallableRegions());
		//
		//	Index all predicated and realized edges by typed model and property.
		//
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges = new HashMap<>();
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges = new HashMap<>();
		for (@NonNull Region region : orderedRegions) {
			QVTscheduleConstants.POLLED_PROPERTIES.println("building indexes for " + region + " " + region.getIndexRangeText());
			RegionAnalysis regionAnalysis = RegionAnalysis.get(region);
			regionAnalysis.buildNavigationEdgesIndex(typedModel2property2predicatedEdges, typedModel2property2realizedEdges);
		}
		//
		//	Eliminate dependencies that are satisfied by the linear invocation indexes.
		//
		for (@NonNull Region region : orderedRegions) {
			//			int earliestPassedConnectionSourceIndex = region.getEarliestPassedConnectionSourceIndex();
			int earliestIndex = region.getIndexes().get(0);
			List<@NonNull DatumConnection<?>> redundantConnections = null;
			for (@NonNull DatumConnection<?> usedConnection : region.getIncomingConnections()) {
				if (!usedConnection.isPassed(region)) {
					boolean isRedundant = true;
					for (@NonNull Region sourceRegion : usedConnection.getSourceRegions()) {
						List<@NonNull Integer> indexes = sourceRegion.getIndexes();
						int lastIndex = indexes.get(indexes.size()-1);
						if (lastIndex >= earliestIndex) {
							isRedundant = false;
							break;
						}
					}
					if (isRedundant) {
						if (redundantConnections == null) {
							redundantConnections = new ArrayList<>();
						}
						redundantConnections.add(usedConnection);
					}
				}
			}
			if (redundantConnections != null) {
				for (@NonNull DatumConnection<?> redundantConnection : redundantConnections) {
					redundantConnection.removeTargetRegion(region);
				}
			}
		}
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduledRegion.writeDebugGraphs("7-pruned", true, true, false);
		}

		boolean noLateConsumerMerge = scheduledRegion.getScheduleModel().isNoLateConsumerMerge();
		if (!noLateConsumerMerge) {
			lateMerge(scheduledRegion, orderedRegions, typedModel2property2predicatedEdges, typedModel2property2realizedEdges);
		}

		for (@NonNull Region region : orderedRegions) {
			getRegionAnalysis(region).computeCheckedOrEnforcedEdges(typedModel2property2predicatedEdges, typedModel2property2realizedEdges);
		}
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
			if ((headNodeGroups.size() == 1) && !(calledRegion instanceof CompositionRegion)) {
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
//							mergedRegion.writeDOTfile("-6-merged");
//							mergedRegion.writeGraphMLfile("-6-merged");
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
		//
		//	Propagate early results down to later mappings that need them.
		//
		/*		for (Region calledRegion : sortedRegions) {
			calledRegion.refineBindings(this);
		} */
		/*		HashMap<Node, List<Node>> outerNode2outerNodes = new HashMap<>();
		Map<Region, Map<NavigationEdge, NavigationEdge>> region2innerEdge2outerEdge = new HashMap<>();
		propagateCommonNavigations(rootContainmentRegion, outerNode2outerNodes, region2innerEdge2outerEdge);
		for (@SuppressWarnings("null")@NonNull Map.Entry<Region, Map<NavigationEdge, NavigationEdge>> entry1 : region2innerEdge2outerEdge.entrySet()) {
			Region innerRegion = entry1.getKey();
			for (@SuppressWarnings("null")@NonNull NavigationEdge innerEdge : entry1.getValue().keySet()) {
				Node innerNode = innerEdge.getTarget();
				List<NavigationEdge> bestPath = null;
				for (@SuppressWarnings("null")@NonNull List<Node> headGroup : innerRegion.getHeadNodeGroups()) {
					for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
						bestPath = getBestPath(bestPath, getPath(headNode, innerNode, new HashSet<>()));
					}
				}
				assert bestPath != null;
				for (@SuppressWarnings("null")@NonNull Node node : innerRegion.getNodes()) {
					for (@SuppressWarnings("null")@NonNull Edge edge : node.getIncomingPassedBindingEdges()) {	// ??? joins
						assert edge.getTarget() == node;
						Region outerRegion = edge.getSource().getRegion();
						Map<Edge, Edge> innerEdge2outerEdge = createPath(edge.getSource(), bestPath);
						for (@SuppressWarnings("null")@NonNull Map.Entry<Edge, Edge> entry : innerEdge2outerEdge.entrySet()) {
							Edge outerEdge = entry.getValue();
							Edge innerEdge2 = entry.getKey();
							Edges.USED_BINDING.createEdge(outerRegion, outerEdge.getTarget(), innerEdge2.getName(), innerEdge2.getTarget());
						}
//						innerNode2outerNode.put(node, edge.getSource());
//						propagateSharedNodes(edge.getSource(), node, innerNode2outerNode);




//						propagatePassedEdges(edge.getSource(), node, innerNode2outerNode, innerNode2edge);
					}
				}
			} */
		/*			Map<Node, Edge> innerNode2edge = new HashMap<>();
			Map<Node, Node> innerNode2outerNode = new HashMap<>();
//			for (NavigationEdge innerEdge : entry1.getValue().keySet()) {
//				innerNode2edge.put(innerEdge.getSource(), innerEdge);
//			}
			for (Node node : innerRegion.getNodes()) {
				for (Edge edge : node.getIncomingPassedBindingEdges()) {	// ??? joins
					assert edge.getTarget() == node;

					Node outerNode = createPath(edge.getRegion(), bestEdge);

					innerNode2outerNode.put(node, edge.getSource());
					propagateSharedNodes(edge.getSource(), node, innerNode2outerNode);




					propagatePassedEdges(edge.getSource(), node, innerNode2outerNode, innerNode2edge);
				}
			}
			for (Map.Entry<NavigationEdge, NavigationEdge> entry2 : entry1.getValue().entrySet()) {
				NavigationEdge innerEdge = entry2.getKey();
				NavigationEdge outerEdge = entry2.getValue();
				propagateEdge(outerEdge.getSource(), innerEdge.getSource());
				propagateEdge(outerEdge.getTarget(), innerEdge.getTarget());
			} */
		//		}
		//		firstPassRegion.writeDOTfile();
		//		firstPassRegion.writeGraphMLfile();
		//
		//		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
		//			writeDebugGraphs("9-final", true, true, true);
		//		}
	}

	public @NonNull ScheduledRegion createRootRegion(@NonNull Iterable<@NonNull ? extends Region> allRegions) {
		ScheduledRegion rootRegion = null;
		for (@NonNull Region region : Lists.newArrayList(allRegions)) {
			if (region.getInvokingRegion() == null) {
				if (rootRegion == null) {
					rootRegion = QVTscheduleFactory.eINSTANCE.createScheduledRegion();
					rootRegion.setScheduleModel(RegionUtil.getScheduleModel(region));
					rootRegion.setName(rootName);
				}
				region.setInvokingRegion(rootRegion);
			}
		}
		assert rootRegion != null;
		return rootRegion;
	}

	public void createSchedule1(@NonNull ScheduledRegion rootScheduledRegion) {
		//
		//	Identify the input models.
		//
		computeInputModels(rootScheduledRegion);
		if (QVTm2QVTs.DUMP_INPUT_MODEL_TO_DOMAIN_USAGE.isActive()) {
			QVTm2QVTs.DUMP_INPUT_MODEL_TO_DOMAIN_USAGE.println(dumpInputModels().reduce("", QVTscheduleUtil.stringJoin("\n\t")));
		}
		//
		//	Identify the content of each region.
		//
		for (@NonNull Region region : RegionUtil.getRegions(rootScheduledRegion)) {
			contentsAnalysis.addRegion(region);
		}
		if (QVTm2QVTs.DUMP_CLASS_TO_REALIZED_NODES.isActive()) {
			QVTm2QVTs.DUMP_CLASS_TO_REALIZED_NODES.println(contentsAnalysis.dumpClass2newNode().reduce("", QVTscheduleUtil.stringJoin("\n\t")));
		}
		if (QVTm2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.isActive()) {
			QVTm2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.println(contentsAnalysis.dumpClass2oldNode().reduce("", QVTscheduleUtil.stringJoin("\n\t")));
		}
		//
		//	Create the root containment region to introduce all root and otherwise contained consumed classes.
		//
		createRootContainmentRegion(rootScheduledRegion);
		//
		//	Create a connection between each consumer and the corresponding introducer/producer.
		//
		createConnections(rootScheduledRegion);
		//		createSchedule2();
	}

	protected void createSchedule2(@NonNull ScheduledRegion rootScheduledRegion) {
		//
		//	Replace multi-region recursions by single nested region recursions.
		//
		List<@NonNull ScheduledRegion> allScheduledRegions = new ArrayList<>();
		allScheduledRegions.add(rootScheduledRegion);
		//		CyclesAnalyzer cyclesAnalyzer = new CyclesAnalyzer(rootScheduledRegion, rootScheduledRegion.getCallableRegions());
		//		List<@NonNull RegionCycle> regionCycles = cyclesAnalyzer.getOrderedCycles();
		//		if (regionCycles != null) {
		/*			for (@NonNull RegionCycle regionCycle : regionCycles) {
				Iterable<@NonNull Region> regions = regionCycle.getRegions();
				if (Iterables.size(regions) == 1) {
					regions.iterator().next().setIsCyclic();
				}
				else {
					CyclicScheduledRegion cyclicRegion = createCyclicRegion(regions);
					allScheduledRegions.add(cyclicRegion);
				}
			} */
		//		}
		//		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
		//			rootScheduledRegion.writeDebugGraphs("4-cycles", true, true, false);
		//		}
		//
		//	Create the schedule for each directed acyclic scheduled region.
		//
		/*		for (@NonNull Region region : rootScheduledRegion.getCallableRegions()) {
			Splitter splitter = new Splitter(region);
			Split split = splitter.split();
			if (split != null) {
				//				split.install();
			}
		} */
		//
		//	Create the schedule for each directed acyclic scheduled region.
		//
		for (@NonNull ScheduledRegion scheduledRegion : allScheduledRegions) {
			createLocalSchedule(scheduledRegion);
		}
		ScheduleIndexer scheduleIndexer = new ScheduleIndexer(rootScheduledRegion);
		scheduleIndexer.schedule(rootScheduledRegion);
		for (@NonNull ScheduledRegion scheduledRegion : allScheduledRegions) {
			createLocalSchedule2(scheduledRegion, scheduleIndexer.getOrdering());
		}
	}

	private Stream<String> dumpInputModels() {
		Stream<String> entries = inputModels.keySet().stream().map(
			k -> String.valueOf(k) + " : " + String.valueOf(inputModels.get(k)));
		return entries.sorted();
	}

	public @Nullable Iterable<@NonNull Node> getIntroducingOrNewNodes(@NonNull Node headNode) {
		ClassDatumAnalysis classDatumAnalysis = RegionUtil.getClassDatumAnalysis(headNode);
		if (!classDatumAnalysis.getDomainUsage().isInput()) {
			return contentsAnalysis.getNewNodes(classDatumAnalysis);	// FIXME also dependsOn ??
		}
		List<@NonNull Node> nodes = new ArrayList<>();
		nodes.add(rootAnalysis.getIntroducerNode(headNode));
		for (@NonNull TypedModel dependsOn : QVTbaseUtil.getDependsOns(RegionUtil.getTypedModel(classDatumAnalysis))) {
			ClassDatumAnalysis classDatumAnalysis2 = ((ScheduleModel2)headNode.getRegion().getScheduleModel()).getClassDatumAnalysis(headNode.getCompleteClass().getPrimaryClass(), dependsOn);
			Iterable<@NonNull Node> newNodes = contentsAnalysis.getNewNodes(classDatumAnalysis2);
			if (newNodes != null) {
				for (@NonNull Node newNode : newNodes) {
					if (!nodes.contains(newNode)) {
						nodes.add(newNode);
					}
				}
			}
		}
		return nodes;
	}

	public @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatumAnalysis requiredClassDatumAnalysis) {
		return contentsAnalysis.getNewEdges(edge, requiredClassDatumAnalysis);
	}

	public @Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		return contentsAnalysis.getNewNodes(classDatumAnalysis);
	}

	public @NonNull RegionAnalysis getRegionAnalysis(@NonNull Region region) {
		RegionAnalysis regionAnalysis = region2regionAnalysis.get(region);
		if (regionAnalysis == null) {
			regionAnalysis = RegionAnalysis.get(/*this,*/ region);
			region2regionAnalysis.put(region, regionAnalysis);
		}
		return regionAnalysis;
	}

	public @NonNull StandardLibraryHelper getStandardLibraryHelper() {
		return standardLibraryHelper ;
	}

	private void lateMerge(@NonNull ScheduledRegion scheduledRegion, @NonNull List<@NonNull Region> orderedRegions,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		Map<@NonNull Region, @NonNull List<@NonNull Region>> newRegion2oldRegions = LateConsumerMerger.merge(scheduledRegion);
		for (Map.Entry<@NonNull Region, @NonNull List<@NonNull Region>> entry : newRegion2oldRegions.entrySet()) {
			Region newRegion = entry.getKey();
			List<@NonNull Region> oldRegions = entry.getValue();
			assert oldRegions.size() >= 2;
			int orderedRegionIndex = orderedRegions.indexOf(oldRegions.get(0));
			for (@NonNull Region oldRegion : oldRegions) {
				orderedRegions.remove(oldRegion);
				oldRegion.setInvokingRegion(null);
			}
			orderedRegions.add(orderedRegionIndex, newRegion);
			QVTscheduleConstants.POLLED_PROPERTIES.println("building indexes for " + newRegion + " " + newRegion.getIndexRangeText());
			RegionAnalysis regionAnalysis = RegionAnalysis.get(newRegion);
			regionAnalysis.buildNavigationEdgesIndex(typedModel2property2predicatedEdges, typedModel2property2realizedEdges);
		}
	}

	protected void splitRegions() {
	}

	public @NonNull ScheduledRegion transform(@NonNull ScheduleModel scheduleModel, @NonNull Iterable<@NonNull ? extends Region> activeRegions) throws CompilerChainException {
		this.contentsAnalysis = new ContentsAnalysis(scheduleModel);
		((LoadingRegionImpl)rootContainmentRegion).setFixmeScheduleModel(scheduleModel);
		//		for (@NonNull Region region : activeRegions) {
		//			System.out.println("activeRegions " + region);
		//		}
		Iterable<@NonNull MappingRegion> partitionedRegions = Partitioner.partition(problemHandler, activeRegions);
		if (!Iterables.isEmpty(partitionedRegions)) {
			//			for (@NonNull Region region : partitionedRegions) {
			//				System.out.println("partitionedRegions " + region);
			//			}
			activeRegions = partitionedRegions;
		}
		ScheduledRegion rootRegion = createRootRegion(activeRegions);
		createSchedule1(rootRegion);
		createSchedule2(rootRegion);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			rootRegion.writeDebugGraphs("9-final", true, true, true);
		}
		return rootRegion;
	}
}
