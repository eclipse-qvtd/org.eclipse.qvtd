/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.UniqueList;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.OriginalContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.LoadingRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.BasicPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionsAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MergedPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * ConnectionManager supervises the connections initially between rule-regions and ultimaately between partitions.
 */
public class ConnectionManager
{
	private static final @NonNull String JOIN_ATTRIBUTE_PREFIX = "ja";
	private static final @NonNull String JOIN_EDGE_PREFIX = "je_";
	private static final @NonNull String JOIN_INPUT_PREFIX = "ji";
	private static final @NonNull String JOIN_MIDDLE_PREFIX = "jm";
	private static final @NonNull String JOIN_OUTPUT_PREFIX = "jo";

	public static final @NonNull List<@NonNull Partition> EMPTY_PARTITION_LIST = Collections.emptyList();

	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull LoadingRegionAnalysis loadingRegionAnalysis;

	/**
	 * The per-class node connections that unite a set of sources via a shared connection.
	 */
	public final @NonNull Map<@NonNull ClassDatum, @NonNull Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection>> classDatum2nodes2nodeConnections = new HashMap<>();

	/**
	 * The edge connections that unite a set of sources via a shared connection.
	 */
	public final @NonNull Map<@NonNull Set<@NonNull NavigableEdge>, @NonNull EdgeConnection> edges2edgeConnection = new HashMap<>();

	/**
	 * Analysis of the contents of the partitioned mappings, null prior to partitioning.
	 */
	private final @NonNull OriginalContentsAnalysis originalContentsAnalysis;

	/**
	 * Ordered list of regions that call this region
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull List<@NonNull Partition>> partition2parents = new HashMap<>();

	/**
	 * Ordered list of regions that this region calls. May exclude some children whose dependencies are unsatisfied.
	 * May include non-children whose dependencies are satisfied by earlier child calls.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull List<@NonNull Partition>> partition2children = new HashMap<>();

	private final @NonNull Property oclContainerProperty;
	private final @NonNull Property oclContentsProperty;

	public ConnectionManager(@NonNull ProblemHandler problemHandler, @NonNull ScheduleManager scheduleManager, @NonNull LoadingRegionAnalysis loadingRegionAnalysis) {
		//	super(qvtm2qvts.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
		this.loadingRegionAnalysis = loadingRegionAnalysis;
		this.originalContentsAnalysis = scheduleManager.getOriginalContentsAnalysis();
		StandardLibraryHelper standardLibraryHelper = scheduleManager.getStandardLibraryHelper();
		this.oclContainerProperty = standardLibraryHelper.getOclContainerProperty();
		this.oclContentsProperty = standardLibraryHelper.getOclContentsProperty();
	}

	public void addCallToChild(@NonNull Partition parentPartition, @NonNull Partition childPartition) {
		List<@NonNull Partition> callableChildren = getCallableChildren(parentPartition);
		assert !callableChildren.contains(childPartition);
		callableChildren.add(childPartition);
		getCallableParents(childPartition).add(parentPartition);
	}

	/**
	 * Return the connections that need to have uniqueness enforced explicitly.
	 */
	public @NonNull Iterable<@NonNull NodeConnection> analyzeStrictness() {
		List<@NonNull NodeConnection> strictConnections = new ArrayList<>();
		for (@NonNull RootRegion rootRegion : QVTscheduleUtil.getOwnedRootRegions(scheduleManager.getScheduleModel())) {
			for (@NonNull Connection connection : QVTscheduleUtil.getOwnedConnections(rootRegion)) {
				if (connection instanceof NodeConnection) {		// EdgeConnections are not passed so need no enforcement
					//	boolean isDead = false;
					NodeConnection nodeConnection = (NodeConnection)connection;
					List<Node> passedTargetNodes = nodeConnection.getPassedTargetNodes();
					if (passedTargetNodes.size() > 0) {			// unpassed NodeConnections need no enforcement
						boolean isImplicitlyUnique = true;
						Iterable<Node> sourceNodes = nodeConnection.getSourceNodes();
						int size = Iterables.size(sourceNodes);
						if (size == 0) {
							//	isDead = true;
						}
						else if (size > 1) {					// multiple source need enforcement
							isImplicitlyUnique = false;
						}
						else {
							ClassDatum classDatum = nodeConnection.getClassDatum();
							if (classDatum.isDataType()) {		// DataTypes need enforcement
								isImplicitlyUnique = false;
							}
						}
						if (!isImplicitlyUnique) {
							strictConnections .add(nodeConnection);
						}
					}
				}
			}
		}
		return strictConnections;
	}

	/**
	 * Create the Passed and Used Connections between all introducers and their corresponding consuming nodes.
	 */
	public void createConnections(@NonNull RootRegion rootRegion, @NonNull Iterable<@NonNull Concurrency> partitionSchedule) {
		Set<@NonNull Region> regions = new HashSet<>();
		for (@NonNull Concurrency concurrency : partitionSchedule) {
			for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : concurrency) {
				regions.add(QVTscheduleUtil.getRegion(partitionAnalysis.getPartition()));
			}
		}
		//		for (@NonNull Region region : regions) {
		//			createIncomingConnections(rootRegion, region);
		//		}
		//		scheduleManager.writeDebugGraphs("4-bindings", true, true, false);
		//		for (Region region : sortedCallableRegions) {
		//			region.checkIncomingConnections();
		//		}
	}

	/**
	 * Create an EdgeConnection for the predicatedEdges and/or their target DataType node.
	 */
	private void createAttributeEdgeConnection(@Nullable StringBuilder s, @NonNull RootRegion rootRegion, @NonNull Region region, @NonNull Node castTargetNode, @NonNull Iterable<@NonNull NavigableEdge> predicatedEdges) {
		RootRegion invokingRegion2 = rootRegion;
		assert invokingRegion2 != null;
		Node castTarget = castTargetNode;
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(castTarget);
		for (@NonNull NavigableEdge predicatedEdge : predicatedEdges) {
			if (predicatedEdge.isNavigation()) {
				NavigationEdge predicatedNavigationEdge = (NavigationEdge)predicatedEdge;
				List<@NonNull NavigableEdge> attributeConnectionSourceEdges = null;
				List<@NonNull String> partialNames = new ArrayList<>();
				assert predicatedEdge.isNavigation();
				assert predicatedEdge.getIncomingConnection() == null;
				assert !predicatedEdge.isCast();
				Property predicatedProperty = QVTscheduleUtil.getReferredProperty(predicatedNavigationEdge);
				assert !predicatedProperty.isIsImplicit();
				assert classDatum.isDataType();
				Iterable<@NonNull NavigableEdge> realizedEdges = getNewEdges(predicatedEdge);
				if (realizedEdges != null) {
					ClassDatum predicatedSourceClassDatum = QVTscheduleUtil.getClassDatum(QVTscheduleUtil.getSourceNode(predicatedEdge));
					ClassDatum predicatedTargetClassDatum = QVTscheduleUtil.getClassDatum(QVTscheduleUtil.getTargetNode(predicatedEdge));
					Property oppositeProperty = predicatedProperty.getOpposite();
					if (predicatedProperty.isIsMany()) {
						predicatedTargetClassDatum = QVTscheduleUtil.getElementalClassDatum((CollectionClassDatum)predicatedTargetClassDatum);
					}
					for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
						if (realizedEdge.isNavigation()) {
							NavigationEdge predicatedRealizedEdge = (NavigationEdge)realizedEdge;
							Property realizedProperty = QVTscheduleUtil.getReferredProperty(predicatedRealizedEdge);
							ClassDatum firstClassDatum = QVTscheduleUtil.getClassDatum(QVTscheduleUtil.getSourceNode(realizedEdge));
							ClassDatum secondClassDatum = QVTscheduleUtil.getClassDatum(QVTscheduleUtil.getTargetNode(realizedEdge));
							if (realizedProperty.isIsMany()) {
								secondClassDatum = QVTscheduleUtil.getElementalClassDatum((CollectionClassDatum) secondClassDatum);
							}
							ClassDatum realizedSourceClassDatum;
							ClassDatum realizedTargetClassDatum;
							if (realizedProperty == predicatedProperty) {
								realizedSourceClassDatum = firstClassDatum;
								realizedTargetClassDatum = secondClassDatum;
							}
							else {
								assert realizedProperty == oppositeProperty;
								realizedSourceClassDatum = secondClassDatum;
								realizedTargetClassDatum = firstClassDatum;
							}
							boolean conformingSources = QVTscheduleUtil.conformantWith(predicatedSourceClassDatum, realizedSourceClassDatum);
							boolean conformingTargets;
							conformingTargets = QVTscheduleUtil.conformantWith(predicatedTargetClassDatum, realizedTargetClassDatum);
							if (conformingSources && conformingTargets) {
								if (attributeConnectionSourceEdges == null) {
									attributeConnectionSourceEdges = new ArrayList<>();
								}
								attributeConnectionSourceEdges.add(realizedEdge);
							}
						}
					}
					Node sourceNode = QVTscheduleUtil.getSourceNode(predicatedEdge);
					ClassDatum sourceClassDatum = QVTscheduleUtil.getClassDatum(sourceNode);
					partialNames.add(QVTscheduleUtil.getName(sourceClassDatum));
					partialNames.add(QVTscheduleUtil.getName(predicatedProperty));
				}
				if (attributeConnectionSourceEdges != null) {
					EdgeConnection edgeConnection = getAttributeConnection(invokingRegion2, attributeConnectionSourceEdges, partialNames, predicatedProperty);
					boolean differentProperty = false;
					if (predicatedProperty.isIsMany()) {
						for (@NonNull NavigableEdge sourceEdge : attributeConnectionSourceEdges) {
							if ((sourceEdge instanceof NavigationEdge) && ((NavigationEdge)sourceEdge).isPartial()) {
								differentProperty = true;
							}
						}
					}
					edgeConnection.addUsedTargetEdge(predicatedEdge, differentProperty);
					if (s != null) {
						s.append("\n    Attribute EdgeConnection \"" + edgeConnection + "\" to " + castTarget);
						for (@NonNull Edge sourceEdge : attributeConnectionSourceEdges) {
							s.append("\n      from " + sourceEdge.getOwningRegion() + " : " + sourceEdge.getSourceNode());
						}
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
		}
	}

	/**
	 * Create an EdgeConnection for the predicatedEdges and/or their target Class node.
	 */
	private void createClassEdgeConnection(@Nullable StringBuilder s, @NonNull RootRegion rootRegion, @NonNull Region region, @NonNull Node castTargetNode, @NonNull Iterable<@NonNull NavigableEdge> consumedEdges) {
		RootRegion invokingRegion2 = rootRegion;
		assert invokingRegion2 != null;
		Node castTarget = castTargetNode;
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(castTarget);
		for (@NonNull NavigableEdge consumedEdge : consumedEdges) {
			assert consumedEdge.isNavigation();
			assert consumedEdge.getIncomingConnection() == null;
			assert !consumedEdge.isCast();
			Property consumedProperty = QVTscheduleUtil.getReferredProperty((NavigationEdge)consumedEdge);
			assert !consumedProperty.isIsImplicit();
			boolean isDataType = classDatum.isDataType();
			assert !isDataType;
			Iterable<@NonNull Node> sourceNodes = getNewNodes(classDatum);
			Iterable<@NonNull NavigableEdge> producedEdges = getNewEdges(consumedEdge);
			if (producedEdges != null) {
				UniqueList<@NonNull Region> edgeSourceRegions = new UniqueList<>();
				for (@NonNull NavigableEdge producedEdge : producedEdges) {
					edgeSourceRegions.add(QVTscheduleUtil.getOwningRegion(producedEdge));
				}
				//
				// Create an EdgeConnection for the edge realizations.
				//
				UniqueList<@NonNull NavigableEdge> thoseEdges = null;
				for (@NonNull NavigableEdge producedEdge : producedEdges) {
					Node producedSource = QVTscheduleUtil.getSourceNode(producedEdge);
					Node producedTarget = QVTscheduleUtil.getTargetNode(producedEdge);
					Property producedProperty = QVTscheduleUtil.getReferredProperty((NavigationEdge)producedEdge);
					Node consumedSource;
					Node consumedTarget;
					// FIXME Workingaround Bug 560541 - should be able to exploit oclContainer/oclContents isComposite
					boolean producedContainer = (producedProperty == oclContainerProperty) || ((producedProperty.getOpposite() != null) && producedProperty.getOpposite().isIsComposite());
					boolean producedContainment = (producedProperty == oclContentsProperty) || producedProperty.isIsComposite();
					boolean consumedContainer = (consumedProperty == oclContainerProperty) || ((consumedProperty.getOpposite() != null) && consumedProperty.getOpposite().isIsComposite());
					boolean consumedContainment = (consumedProperty == oclContentsProperty) || consumedProperty.isIsComposite();
					if ((producedProperty == consumedProperty) || ((producedContainer == consumedContainer) && (producedContainment == consumedContainment))) {	// Normalize consumed direction to produced direction
						consumedSource = QVTscheduleUtil.getSourceNode(consumedEdge);
						consumedTarget = QVTscheduleUtil.getTargetNode(consumedEdge);
					}
					else {
						assert (producedProperty == consumedProperty.getOpposite()) || ((producedContainer == consumedContainment) && (producedContainment == consumedContainer));
						consumedSource = QVTscheduleUtil.getTargetNode(consumedEdge);
						consumedTarget = QVTscheduleUtil.getSourceNode(consumedEdge);
					}
					ClassDatum producedSourceClassDatum = QVTscheduleUtil.getClassDatum(producedSource);
					ClassDatum consumedSourceClassDatum = QVTscheduleUtil.getClassDatum(consumedSource);
					ClassDatum producedElementalSourceClassDatum = scheduleManager.getElementalClassDatum(producedSourceClassDatum);
					ClassDatum consumedElementalSourceClassDatum = scheduleManager.getElementalClassDatum(consumedSourceClassDatum);
					// FIXME This was irregular. Was changing to elemental throughout ok ? testOCL2QVTi_Source2Target_CG is a demanding test
					if (QVTscheduleUtil.conformsTo(producedElementalSourceClassDatum, consumedElementalSourceClassDatum)
							|| (!producedSource.isRealized() && QVTscheduleUtil.conformsTo(consumedElementalSourceClassDatum, producedElementalSourceClassDatum))) {
						ClassDatum producedTargetClassDatum = QVTscheduleUtil.getClassDatum(producedTarget);
						ClassDatum consumedTargetClassDatum = QVTscheduleUtil.getClassDatum(consumedTarget);
						ClassDatum producedElementalTargetClassDatum = scheduleManager.getElementalClassDatum(producedTargetClassDatum);
						ClassDatum consumedElementalTargetClassDatum = scheduleManager.getElementalClassDatum(consumedTargetClassDatum);
						if (QVTscheduleUtil.conformsToClassOrBehavioralClass(producedElementalTargetClassDatum, consumedElementalTargetClassDatum)
								|| (!producedTarget.isRealized() && QVTscheduleUtil.conformsToClassOrBehavioralClass(consumedElementalTargetClassDatum, producedElementalTargetClassDatum))) {
							if (thoseEdges == null) {
								thoseEdges = new UniqueList<>();
							}
							thoseEdges.add(producedEdge);
						}
					}
				}
				if (thoseEdges != null) {
					EdgeConnection edgeConnection = getEdgeConnection(invokingRegion2, thoseEdges, consumedProperty);
					if (s != null) {
						s.append("\n    EdgeConnection \"" + edgeConnection + "\" to " + consumedEdge);
					}
					if (!Iterables.contains(edgeConnection.getTargetEdges(), consumedEdge)) {
						edgeConnection.addUsedTargetEdge(consumedEdge, false);
						if (s != null) {
							for (@NonNull NavigableEdge thatEdge : thoseEdges) {
								s.append("\n      from " + thatEdge.getOwningRegion() + "  : " + thatEdge);
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
						&& (castTarget.getIncomingConnection() == null)
						//			 && !castTarget.isAttributeNode()
						//			 && !rootRootRegion.isOnlyCastOrRecursed(consumedNode)
						//			 && !hasEdgeConnection(consumedNode)
						) {
					NodeConnection nodeConnection = getNodeConnection(invokingRegion2, sourceNodes, classDatum, scheduleManager.getDomainUsage(classDatum));
					nodeConnection.addUsedTargetNode(castTarget, false);
					if (s != null) {
						s.append("\n    NodeConnection \"" + nodeConnection + "\" to " + castTarget);
						for (@NonNull Node sourceNode : sourceNodes) {
							s.append("\n      from " + sourceNode.getOwningRegion() + " : " + sourceNode);
						}
					}
				}
				//			}
			}
		}
	}

	private @NonNull EdgeConnection createEdgeConnection(@NonNull RootRegion rootRegion, @NonNull  Set<@NonNull NavigableEdge> sourceSet, @NonNull Property property, @NonNull SymbolNameBuilder s) {
		//	assert !property.isIsImplicit();				implicit opposite of a 1:N is the connected property
		EdgeConnection edgeConnection = QVTscheduleFactory.eINSTANCE.createEdgeConnection();

		//		protected ConnectionImpl(@NonNull RootRegion region, @NonNull Set<@NonNull CE> sourceEnds, @NonNull String name) {
		edgeConnection.setOwningRootRegion(rootRegion);
		edgeConnection.setName(scheduleManager.getScheduleModel().reserveSymbolName(s, edgeConnection));
		QVTscheduleUtil.getSourceEnds(edgeConnection).addAll(sourceSet);
		//		}

		//		public EdgeConnectionImpl(@NonNull RootRegion region, @NonNull Set<@NonNull NavigableEdge> sourceEdges, @NonNull String name, @NonNull Property property) {
		//			super(region, sourceEdges, name);
		edgeConnection.setReferredProperty(property);
		for (@NonNull NavigableEdge sourceEdge : sourceSet) {
			assert Iterables.contains(QVTscheduleUtil.getSourceEnds(edgeConnection), sourceEdge);
			//		assert edge.getRegion() == getRegion();
			List<EdgeConnection> outgoingConnections2 = sourceEdge.getOutgoingConnections();
			assert !outgoingConnections2.contains(edgeConnection);
			outgoingConnections2.add(edgeConnection);
		}
		//		}
		//		return new EdgeConnectionImpl(this, sourceSet, s, property);
		return edgeConnection;
	}

	/**
	 * Create and return a NodeConnection to the nodes that can provide the sources for headNode.
	 * Returns null if the pattern surrounding the headNode conflicts with the pattern
	 * surrounding all possible sources.
	 */
	private @Nullable NodeConnection createHeadConnection(@Nullable StringBuilder s, @NonNull RootRegion rootRegion, @NonNull Region region, @NonNull Node headNode) {
		RootRegion invokingRegion2 = rootRegion;
		List<@NonNull Node> headSources = null;
		//
		//	Locate compatible introducers and non-recursive producers
		//
		boolean isSpeculation = false;
		Iterable<@NonNull Node> sourceNodes = getIntroducingOrNewNodes(headNode);
		if (!scheduleManager.useActivators() && (sourceNodes != null)) {
			for (@NonNull Node sourceNode : sourceNodes) {
				if (sourceNode.isSpeculation()) {
					isSpeculation = true;
				}
			}
		}
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(headNode);
		if (isSpeculation && !headNode.isSpeculated()) {
			sourceNodes = originalContentsAnalysis.getOldNodes(classDatum);
			assert sourceNodes != null;
		}
		if (sourceNodes != null) {
			for (@NonNull Node sourceNode : sourceNodes) {
				boolean isSource = true;
				if (isSpeculation) {
					if (headNode.isSpeculated()) {
						//						if (!sourceNode.isOld()) {
						//							isSource = false;
						//						}
					}
					else {
						if (!sourceNode.isSpeculated() || !sourceNode.isHead()) {
							isSource = false;
						}
					}
				}
				//				Region sourceRegion = sourceNode.getRegion();
				//				if (sourceRegion != this) {
				if (isSource) {
					Map<@NonNull Node, @NonNull Node> called2calling = new HashMap<>();
					if (isCompatiblePattern(region, headNode, sourceNode, called2calling)) {
						if (headSources == null) {
							headSources = new ArrayList<>();
						}
						headSources.add(sourceNode);
					}
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
		NodeConnection headConnection = getNodeConnection(invokingRegion2, headSources, classDatum, scheduleManager.getDomainUsage(classDatum));
		if (headNode.isDependency()) {
			headConnection.addUsedTargetNode(headNode, false);
		}
		else {
			headConnection.addPassedTargetNode(headNode);
		}
		if (s != null) {
			s.append((headNode.isDependency() ? "\n    Extra NodeConnection " : "\n    Head NodeConnection \"") + headConnection + "\" to " + headNode);
			for (@NonNull Node sourceNode : headSources) {
				s.append("\n      from " + sourceNode.getOwningRegion() + " : " + sourceNode);
			}
		}
		return headConnection;
	}

	/**
	 * Return the Connections to each of the head nodes. Returns null after registering region error problems,
	 * if the pattern surrounding any headNode conflicts with the pattern
	 * surrounding all its possible sources. (Any head with no sources is a non-invocation.)
	 */
	private @Nullable Iterable<@NonNull NodeConnection> createHeadConnections(@Nullable StringBuilder s, @NonNull RootRegion rootRegion, @NonNull Region region) {
		List<@NonNull NodeConnection> headConnections = null;
		Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(region);
		if (Iterables.isEmpty(region.getHeadNodes())) {
			CompilerUtil.addRegionError(getProblemHandler(), region, "No head nodes");
		}
		for (@NonNull Node headNode : headNodes) {
			if (headNode.isDependency()) {
				createHeadConnection(s, rootRegion, region, headNode);	/** Dependency nodes have extra not-head connections. */
			}
			else {
				NodeConnection headConnection = createHeadConnection(s, rootRegion, region, headNode);
				if (headConnection == null) {
					if (!headNode.isThis()) {
						CompilerUtil.addRegionError(getProblemHandler(), region, "No incoming connections for " + headNode.getName());
						headConnection = createHeadConnection(s, rootRegion, region, headNode);	// FIXME debugging
						return null;										//  so matching only fails for unmatchable real heads
					}
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
		if (headConnections == null) {
			CompilerUtil.addRegionError(getProblemHandler(), region, "No incoming connections");
		}
		return headConnections;
	}

	/**
	 * Create the connections that establish the inter-region dependencies. A passed connection for each head node and
	 * used connections for each predicated edge. (Non-head nodes are necessarily connected by predicates to the head.)
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
	 * Connections to attribute nodes are connected to just the edge; the datatyped node can be ambiguous
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
	public void createIncomingConnections(@Nullable StringBuilder s, @NonNull RootRegion rootRegion, @NonNull Region region) {
		if (s != null) {
			s.append("\n  " + region);
		}
		assert !(region instanceof LoadingRegion);
		Iterable<@NonNull NodeConnection> headConnections = createHeadConnections(s, rootRegion, region);
		if (headConnections == null) {
			return;		// Error already reported.
		}
		//
		//	Gather multiple edges sharing the same target to avoid multiple incoming connections -- FIXME no need to gather
		//
		Map<@NonNull Node, @NonNull List<@NonNull NavigableEdge>> castTargetNode2predicatedEdges = new HashMap<>();
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			assert !edge.isCast();
			if (edge.isPredicated() && edge.isNavigation()) {
				NavigationEdge predicatedEdge = (NavigationEdge)edge;
				assert predicatedEdge.getIncomingConnection() == null;
				Property predicatedProperty = predicatedEdge.getReferredProperty();
				if (!predicatedProperty.isIsImplicit()) {		// unnavigable opposites are handled by the navigable property
					Node castTargetNode = predicatedEdge.getEdgeTarget();
					List<@NonNull NavigableEdge> predicatedEdges = castTargetNode2predicatedEdges.get(castTargetNode);
					if (predicatedEdges == null) {
						predicatedEdges = new ArrayList<>();
						castTargetNode2predicatedEdges.put(castTargetNode, predicatedEdges);
					}
					predicatedEdges.add(predicatedEdge);
				}
			}
		}
		for (@NonNull Node castTargetNode : castTargetNode2predicatedEdges.keySet()) {
			List<@NonNull NavigableEdge> predicatedEdges = castTargetNode2predicatedEdges.get(castTargetNode);
			assert predicatedEdges != null;
			if (castTargetNode.isClass()) {
				createClassEdgeConnection(s, rootRegion, region, castTargetNode, predicatedEdges);
			}
			else {
				createAttributeEdgeConnection(s, rootRegion, region, castTargetNode, predicatedEdges);
			}
		}
	}

	private @NonNull NodeConnection createNodeConnection(@NonNull RootRegion rootRegion, @NonNull Set<@NonNull Node> sourceSet, @NonNull ClassDatum classDatum, @NonNull SymbolNameBuilder s) {
		NodeConnection connection = QVTscheduleFactory.eINSTANCE.createNodeConnection();
		connection.setOwningRootRegion(rootRegion);
		connection.setName(scheduleManager.getScheduleModel().reserveSymbolName(s, connection));
		QVTscheduleUtil.getSourceEnds(connection).addAll(sourceSet);
		connection.setClassDatum(classDatum);
		for (@NonNull Node sourceNode : sourceSet) {
			//			assert !sourceNode.isConstant();
			assert Iterables.contains(QVTscheduleUtil.getSourceEnds(connection), sourceNode);
			//		assert edge.getRegion() == getRegion();
			List<NodeConnection> outgoingConnections2 = sourceNode.getOutgoingConnections();
			assert !outgoingConnections2.contains(connection);
			outgoingConnections2.add(connection);
		}
		return connection;
	}

	/**
	 * Create the Passed Node Connection between the trace node realized in an activator partition and predicated in other partitions.
	 * Create Used Edge Connections between each edge realized in the origial region and predicated in a aprtition.
	 */
	public void createPartitionConnections(@NonNull RootRegion rootRegion, @NonNull Region region) {
		Iterable<@NonNull MappingPartition> partitions = QVTscheduleUtil.getRegionPartitions(region);
		RegionAnalysis regionAnalysis = scheduleManager.getRegionAnalysis(region);
		if (Iterables.size(partitions) <= 1) {
			return;										// No trace connections if not actually partitioned
		}
		//
		//	Every (the) trace node that is realized in the original region and is predicated in one of the partitions requires
		//	a passed node connection.
		//
		Iterable <@NonNull Node> traceNodes = regionAnalysis.getTraceNodes();
		for (@NonNull Node traceNode : traceNodes) {
			Set<@NonNull Node> sourceNodes = new HashSet<>();
			for (@NonNull Partition partition : partitions) {
				Role nodeRole = QVTscheduleUtil.getRole(partition, traceNode);
				if ((nodeRole != null) && nodeRole.isNew()) {
					sourceNodes.add(traceNode);
				}
			}
			//
			if (!sourceNodes.isEmpty()) {
				ClassDatum classDatum = QVTscheduleUtil.getClassDatum(traceNode);
				NodeConnection connection = getNodeConnection(rootRegion, sourceNodes, classDatum, scheduleManager.getDomainUsage(classDatum));
				//
				Set<@NonNull Node> targetNodes = new HashSet<>();
				for (@NonNull Partition partition : partitions) {
					Role nodeRole = QVTscheduleUtil.getRole(partition, traceNode);
					if ((nodeRole != null) && nodeRole.isOld()) {
						if (targetNodes.add(traceNode)) {
							connection.addPassedTargetNode(traceNode);
						}
					}
				}
			}
		}
		//
		//	Every edge that is realized in the original region and is predicated in one of the partitions requires
		//	a used edge connection.
		//
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			if (edge.isRealized() && edge.isNavigation()) {
				NavigationEdge navigationEdge = (NavigationEdge)edge;
				if (!edge.isSecondary()) {
					boolean isAwaited = false;
					for (@NonNull PartitionAnalysis partitionAnalysis : regionAnalysis.getPartitionAnalyses()) {
						Role role = partitionAnalysis.getPartition().getRole(navigationEdge);
						if ((role != null) && role.isChecked()) {
							isAwaited = true;
							break;
						}
					}
					if (isAwaited) {
						Property property = QVTscheduleUtil.getReferredProperty(navigationEdge);
						EdgeConnection connection = getEdgeConnection(rootRegion, Collections.singleton(navigationEdge), property);
						connection.addUsedTargetEdge(navigationEdge, true);
					}
				}
			}
			else {
				// SharedEdge
			}
		}
	}

	private @NonNull EdgeConnection getAttributeConnection(@NonNull RootRegion rootRegion, @NonNull Iterable<@NonNull NavigableEdge> sourceEdges, @NonNull List<@NonNull String> partialNames, @NonNull Property property) {
		Set<@NonNull NavigableEdge> sourceSet = Sets.newHashSet(sourceEdges);
		EdgeConnection connection = edges2edgeConnection.get(sourceSet);
		if (connection == null) {
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString(JOIN_ATTRIBUTE_PREFIX);
			for (@NonNull String partialName : partialNames) {
				s.appendString("_");
				s.appendName(partialName);
			}
			connection = createEdgeConnection(rootRegion, sourceSet, property, s);
			edges2edgeConnection.put(sourceSet, connection);
		}
		return connection;
	}

	/**
	 * Return the regions that this region can actually call directly after taking account the connection dependencies.
	 */
	public @NonNull List<@NonNull Partition> getCallableChildren(@NonNull Partition partition) {
		List<@NonNull Partition> children = partition2children.get(partition);
		if (children == null) {
			children = new ArrayList<>();
			partition2children.put(partition, children);
		}
		return children;
	}

	/**
	 * Return the regions that can actually call this region directly after taking account the connection dependencies.
	 */
	public @NonNull List<@NonNull Partition> getCallableParents(@NonNull Partition partition) {
		List<@NonNull Partition> parents = partition2parents.get(partition);
		if (parents == null) {
			parents = new ArrayList<>();
			partition2parents.put(partition, parents);
		}
		return parents;
	}

	private @NonNull EdgeConnection getEdgeConnection(@NonNull RootRegion rootRegion, @NonNull Iterable<@NonNull NavigableEdge> sourceEdges, @NonNull Property property) {
		Set<@NonNull NavigableEdge> sourceSet = Sets.newHashSet(sourceEdges);
		EdgeConnection connection = edges2edgeConnection.get(sourceSet);
		if (connection == null) {
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString(JOIN_EDGE_PREFIX);
			s.appendName(property.getOwningClass().getName());
			s.appendString("_");
			s.appendName(property.getName());
			connection = createEdgeConnection(rootRegion, sourceSet, property, s);
			edges2edgeConnection.put(sourceSet, connection);
		}
		return connection;
	}

	private int getFirstConsumption(@NonNull Connection connection) {
		int firstConsumption = Integer.MAX_VALUE;
		for (@NonNull Partition targetPartition : connection.getTargetPartitions()) {
			int firstPass = targetPartition.getFirstPass();
			if (firstPass <= firstConsumption) {
				firstConsumption = firstPass;
			}
		}
		assert firstConsumption != Integer.MAX_VALUE;
		return firstConsumption;
	}

	public @NonNull Iterable<@NonNull Connection> getIncomingConnections(@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis) {		// FIXME cache
		Partition partition = partitionAnalysis.getPartition();
		/*	Region region = partition.getOriginalRegion();
			if (region != null) {
			List<@NonNull Connection> connections = new ArrayList<>();
			for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(region)) {
				NodeConnection connection = headNode.getIncomingPassedConnection();
				if ((connection != null) && !connections.contains(connection)) {
					connections.add(connection);
				}
			}
			for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
				/*			if (node.isDependency() || node.isPattern()) {
				if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
					NodeConnection connection = node.getIncomingUsedConnection();
					if ((connection != null) && !connections.contains(connection)) {
						connections.add(connection);
					}
				}
			}
			else if (node.isTrue()) {		// A <<success>> node * /
				NodeConnection connection = getIncomingUsedConnection(node);
				if ((connection != null) && !connections.contains(connection)) {
					connections.add(connection);
				}
				//			}
			}
			for (@NonNull NavigationEdge edge : region.getPredicatedNavigationEdges()) {
				EdgeConnection connection = edge.getIncomingConnection();
				if ((connection != null) && !connections.contains(connection)) {
					connections.add(connection);
				}
			}
			return connections;
		}
		else { */
		List<@NonNull Connection> connections = new ArrayList<>();
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(partition)) {
			NodeConnection connection = headNode.getIncomingPassedConnection();
			if ((connection != null) && !connections.contains(connection)) {
				connections.add(connection);
			}
		}
		for (@NonNull Node node : partition.getPartialNodes()) {
			/*			if (node.isDependency() || node.isPattern()) {
					if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
						NodeConnection connection = node.getIncomingUsedConnection();
						if ((connection != null) && !connections.contains(connection)) {
							connections.add(connection);
						}
					}
				}
				else if (node.isTrue()) {		// A <<success>> node */
			if (!node.isHead() || node.isDependency()) {
				NodeConnection connection = getIncomingUsedConnection(node);
				if ((connection != null) && !connections.contains(connection)) {
					connections.add(connection);
				}
			}
			//			}
		}
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			assert !edge.isCast();
			if (((PartitionAnalysis)partitionAnalysis).isChecked(edge) && edge.isNavigation()) {
				NavigableEdge navigationEdge = (NavigableEdge) edge;
				EdgeConnection connection = navigationEdge.getIncomingConnection();
				if ((connection != null) && !connections.contains(connection)) {
					connections.add(connection);
				}
			}
		}
		return connections;
		//	}
	}

	public @Nullable NodeConnection getIncomingUsedConnection(@NonNull Node node) {
		NodeConnection incomingConnection = node.getIncomingConnection();
		if ((incomingConnection != null) && incomingConnection.isUsed(node)) {
			return incomingConnection;
		}
		else {
			return null;
		}
	}

	private @Nullable Iterable<@NonNull Node> getIntroducingOrNewNodes(@NonNull Node headNode) {
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(headNode);
		if (!scheduleManager.isInput(scheduleManager.getDomainUsage(classDatum))) {
			return originalContentsAnalysis.getNewNodes(classDatum);	// FIXME also dependsOn ??
		}
		Set<@NonNull Node> nodes = new UniqueList<>();
		nodes.add(loadingRegionAnalysis.getIntroducerNode(headNode));
		for (@NonNull TypedModel iterates : QVTbaseUtil.getIterates(QVTscheduleUtil.getTypedModel(classDatum))) {
			ClassDatum classDatum2 = scheduleManager.getClassDatum(iterates, headNode.getCompleteClasses());
			Iterable<@NonNull Node> newNodes = originalContentsAnalysis.getNewNodes(classDatum2);
			if (newNodes != null) {
				for (@NonNull Node newNode : newNodes) {
					nodes.add(newNode);
				}
			}
		}
		return nodes;
	}

	private int getLastConsumption(@NonNull Connection connection) {
		int lastConsumption = -1;
		for (@NonNull Partition targetPartition : connection.getTargetPartitions()) {
			int lastPass = targetPartition.getLastPass();
			if (lastPass > lastConsumption) {
				lastConsumption = lastPass;
			}
		}
		assert lastConsumption >= 0;
		return lastConsumption;
	}

	public @NonNull List<@NonNull Connection> getLoopingConnections(@NonNull Partition partition) {
		List<@NonNull Connection> loopingConnections = new ArrayList<>();
		for (@NonNull Connection connection : getOutgoingConnections(partition)) {
			for (@NonNull Partition sourcePartition : connection.getSourcePartitions()) {
				if (partition == sourcePartition) {
					for (@NonNull Partition targetPartition : connection.getTargetPartitions()) {
						if ((partition == targetPartition) && !loopingConnections.contains(connection)) {
							loopingConnections.add(connection);
						}
					}
				}
			}
		}
		return loopingConnections;
	}

	private @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge) {
		return originalContentsAnalysis.getNewEdges(edge);
	}

	//	private @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull PropertyDatum propertyDatum) {
	//		return originalContentsAnalysis.getNewEdges(propertyDatum);
	//	}

	//	private @Nullable Iterable<@NonNull NavigableEdge> getNewInverseEdges(@NonNull NavigableEdge edge, @NonNull ClassDatum requiredClassDatum) {
	//		return originalContentsAnalysis.getNewInverseEdges(edge, requiredClassDatum);
	//	}

	private @Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatum classDatum) {
		return originalContentsAnalysis.getNewNodes(classDatum);
	}

	/**
	 * Return all the next connections from this region to another region.
	 * Where this is a hierarchical region the connections are those from the hierarchical head to its immediate internal regions.
	 */
	public @NonNull Iterable<@NonNull Connection> getNextConnections(@NonNull Partition partition) {
		return getOutgoingConnections(partition);
	}

	private @NonNull NodeConnection getNodeConnection(@NonNull RootRegion rootRegion, @NonNull Iterable<@NonNull Node> sourceNodes, @NonNull ClassDatum classDatum, @NonNull DomainUsage domainUsage) {
		Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection> nodes2connection = classDatum2nodes2nodeConnections.get(classDatum);
		if (nodes2connection == null) {
			nodes2connection = new HashMap<>();
			classDatum2nodes2nodeConnections.put(classDatum, nodes2connection);
		}
		Set<@NonNull Node> sourceSet = Sets.newHashSet(sourceNodes);
		NodeConnection connection = nodes2connection.get(sourceSet);
		if (connection == null) {
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString(scheduleManager.isInput(domainUsage) ? JOIN_INPUT_PREFIX : scheduleManager.isOutput(domainUsage) ? JOIN_OUTPUT_PREFIX : JOIN_MIDDLE_PREFIX);
			s.appendString("_");
			s.appendName(classDatum.getName());
			connection = createNodeConnection(rootRegion, sourceSet, classDatum, s);
			nodes2connection.put(sourceSet, connection);
		}
		return connection;
	}

	/**
	 * Return all connections from this (hierarchical) region to another (hierarchical) region.
	 */
	public @NonNull List<@NonNull Connection> getOutgoingConnections(@NonNull Partition partition) {			// FIXME cache
		List<@NonNull Connection> connections = new ArrayList<>();
		//		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
		for (@NonNull Node node : partition.getPartialNodes()) {
			Role role = partition.getRole(node);
			if ((role != null) && !role.isChecked()) { //(role.isNew() || role.isLoaded())) {
				for (@NonNull NodeConnection connection : QVTscheduleUtil.getOutgoingConnections(node)) {
					if (connection.isPassed()) {
						connections.add(connection);
					}
				}
				for (@NonNull NodeConnection connection : QVTscheduleUtil.getOutgoingConnections(node)) {
					if (connection.isUsed()) {
						connections.add(connection);
					}
				}
			}
		}
		//		for (@NonNull NavigableEdge edge : region.getNavigationEdges()) {
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			if (edge.isNavigation()) {
				Role role = partition.getRole(edge);
				if ((role != null) && !role.isChecked()) { // (role.isNew() || role.isLoaded())) {
					for (@NonNull EdgeConnection connection : QVTscheduleUtil.getOutgoingConnections((NavigableEdge) edge)) {
						connections.add(connection);
					}
				}
			}
		}
		return connections;
	}

	public @NonNull ProblemHandler getProblemHandler() {
		return scheduleManager.getProblemHandler();
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull Iterable<@NonNull Node> getPassedBindingSources(@NonNull Node node) {
		List<@NonNull Node> sources = new ArrayList<>();
		NodeConnection connection = node.getIncomingPassedConnection();
		if (connection != null) {
			for (@NonNull Node source : QVTscheduleUtil.getSourceEnds(connection)) {
				if (!sources.contains(source)) {
					sources.add(source);
				}
			}
		}
		return sources;
	}

	public @NonNull Iterable<@NonNull Node> getUsedBindingSources(@NonNull Node node) {
		List<@NonNull Node> sources = new ArrayList<>();
		NodeConnection connection = getIncomingUsedConnection(node);
		if (connection != null) {
			for (@NonNull Node source : QVTscheduleUtil.getSourceEnds(connection)) {
				if (!sources.contains(source)) {
					sources.add(source);
				}
			}
		}
		return sources;
	}

	/**
	 * Return true if the predicates of calledNode are not in conflict with the navigable paths from callingNode.
	 * called2calling identifies already identified conflict free pairs that do not need re-assessment.
	 */
	private boolean isCompatiblePattern(@NonNull Region region, @NonNull Node calledNode, @NonNull Node callingNode, @NonNull Map<@NonNull Node, @NonNull Node> called2calling) {
		Node oldPrevNode = called2calling.put(calledNode, callingNode);
		if (oldPrevNode != null) {
			return oldPrevNode == callingNode;
		}
		for (@NonNull Edge calledEdge : QVTscheduleUtil.getOutgoingEdges(calledNode)) {
			if (calledEdge instanceof NavigationEdge) {
				NavigationEdge calledNavigationEdge = (NavigationEdge)calledEdge;
				Node nextCalledNode = calledEdge.getEdgeTarget();
				if (!nextCalledNode.isRealized() && !nextCalledNode.isDataType()) {  // FIXME why exclude AttributeNodes?
					Edge nextCallingEdge = callingNode.getOutgoingNavigableEdge(QVTscheduleUtil.getReferredProperty(calledNavigationEdge));
					if (nextCallingEdge != null) {
						Node nextCallingNode = nextCallingEdge.getEdgeTarget();
						if ((nextCallingNode.isNullLiteral() != nextCalledNode.isNullLiteral())) {
							return false;
						}
						if (!isCompatiblePattern(region, nextCalledNode, nextCallingNode, called2calling)) {
							return false;
						}
					}
				}
			}
			else {
				// SharedEdge
			}
		}
		return true;
	}

	public boolean isHazardousRead(@Nullable StringBuilder s, @NonNull Partition partition, @NonNull NavigationEdge edge) {
		if (!edge.isSuccess()) {
			Role edgeRole = partition.getRole(edge);
			assert edgeRole != null;
			if (!edgeRole.isRealized()) {
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				if (sourceNode.isTrace()) {
					return false;		// Trace edges are not hazardous - defined by caller / realizer
				}
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				if (targetNode.isTrace()) {
					return false;		// Tolerate the opposite
				}
			}
		}
		Property property = QVTscheduleUtil.getReferredProperty(edge);
		@SuppressWarnings("unused") String name = property.getName();
		Property oppositeProperty = property.getOpposite();
		@SuppressWarnings("unused") String oppositeName = oppositeProperty != null ? oppositeProperty.getName() : null;
		int firstConsumption = partition.getFirstPass();
		int firstProduction = Integer.MAX_VALUE;
		int lastConsumption = partition.getLastPass();
		int lastProduction = -1;
		Connection edgeConnection = edge.getIncomingConnection();
		if (edgeConnection != null) {
			int firstWrite = edgeConnection.getFirstPass();
			if (firstWrite < firstProduction) {
				firstProduction = firstWrite;
			}
			int lastWrite = edgeConnection.getLastPass();
			if (lastWrite > lastProduction) {
				lastProduction = lastWrite;
			}
		}
		/*	else {
			Connection nodeConnection = QVTscheduleUtil.getTargetNode(edge).getIncomingConnection();
			if (nodeConnection != null) {
				int firstWrite = nodeConnection.getFirstPass();
				if (firstWrite < firstProduction) {
					firstProduction = firstWrite;
				}
				int lastWrite = nodeConnection.getLastPass();
				if (lastWrite > lastProduction) {
					lastProduction = lastWrite;
				}
			}
			throw new UnsupportedOperationException("WIP missing edgeConnection");
		} */
		if (s != null) {
			if (lastProduction < 0) {
				s.append("\n  unconnected");
			}
			else if (lastProduction < firstConsumption) {
				s.append("\n  no-observe produce:[" + firstProduction +".." + lastProduction +"] consume:[" + firstConsumption +".." + lastConsumption +"]");
			}
			else {
				s.append("\n  observe produce:[" + firstProduction +".." + lastProduction +"] consume:[" + firstConsumption +".." + lastConsumption +"]");
			}
			org.eclipse.ocl.pivot.Class owningClass = property.getOwningClass();
			s.append(" " + (owningClass != null ? owningClass.getName() : "«cast»") + "::" + property.getName());
			if (oppositeProperty !=null) {
				s.append(" <=> " + oppositeProperty.getOwningClass().getName() + "::" + oppositeProperty.getName());
			}
		}
		return (lastProduction >= 0) && (lastProduction >= firstConsumption);
	}

	public boolean isHazardousWrite(@Nullable StringBuilder s, @NonNull NavigationEdge edge) {
		Property property = QVTscheduleUtil.getReferredProperty(edge);
		@SuppressWarnings("unused") String name = property.getName();
		Property oppositeProperty = property.getOpposite();
		@SuppressWarnings("unused") String oppositeName = oppositeProperty != null ? oppositeProperty.getName() : null;
		int firstConsumption = Integer.MAX_VALUE;
		int firstProduction = Integer.MAX_VALUE;
		int lastConsumption = -1;
		int lastProduction = -1;
		for (@NonNull Connection connection : QVTscheduleUtil.getOutgoingConnections(edge)) {
			int firstRead = getFirstConsumption(connection);
			if (firstRead < firstConsumption) {
				firstConsumption = firstRead;
			}
			int lastRead = getLastConsumption(connection);
			if (lastRead > lastConsumption) {
				lastConsumption = lastRead;
			}
			int firstWrite = connection.getFirstPass();
			if (firstWrite < firstProduction) {
				firstProduction = firstWrite;
			}
			int lastWrite = connection.getLastPass();
			if (lastWrite > lastProduction) {
				lastProduction = lastWrite;
			}
		}
		if (s != null) {
			if (lastProduction < 0) {
				s.append("\n  unconnected");
			}
			else if (lastProduction < firstConsumption) {
				s.append("\n  no-notify produce:[" + firstProduction +".." + lastProduction +"] consume:[" + firstConsumption +".." + lastConsumption +"]");
			}
			else {
				s.append("\n  notify produce:[" + firstProduction +".." + lastProduction +"] consume:[" + firstConsumption +".." + lastConsumption +"]");
			}
			s.append(" " + property.getOwningClass().getName() + "::" + property.getName());
			if (oppositeProperty !=null) {
				s.append(" <=> " + oppositeProperty.getOwningClass().getName() + "::" + oppositeProperty.getName());
			}
		}
		return (lastProduction >= 0) && (lastProduction >= firstConsumption);
	}

	public void mergePartitionsInto(@NonNull MergedPartition newPartition, @NonNull Iterable<@NonNull BasicPartitionAnalysis> oldPartitionAnalyses) {
		List<@NonNull Partition> newCallableParents = getCallableParents(newPartition);
		for (@NonNull BasicPartitionAnalysis oldPartitionAnalysis : oldPartitionAnalyses) {
			Partition oldPartition = oldPartitionAnalysis.getPartition();
			for (@NonNull NodeConnection connection : QVTscheduleUtil.getIntermediateConnections(oldPartition)) {
				newPartition.getIntermediateConnections().add(connection);
				List<@NonNull Partition> intermediatePartitions = QVTscheduleUtil.getIntermediatePartitions(connection);
				boolean wasRemoved = intermediatePartitions.remove(oldPartition);
				assert wasRemoved;
				if (!intermediatePartitions.contains(newPartition)) {
					intermediatePartitions.add(newPartition);
				}
			}
			for (@NonNull NodeConnection connection : QVTscheduleUtil.getRootConnections(oldPartition)) {
				newPartition.getRootConnections().add(connection);
				//			Iterable<@NonNull Partition> sourcePartitions = connection.getSourcePartitions();
				//			boolean wasRemoved = intermediatePartitions.remove(subPartition);
				//			assert wasRemoved;
				//			if (!intermediatePartitions.contains(mergedPartition)) {
				//				intermediatePartitions.add(mergedPartition);
				//			}
			}
			List<@NonNull Partition> oldCallableParents = getCallableParents(oldPartition);
			for (@NonNull Partition parentPartition : oldCallableParents) {
				List<@NonNull Partition> parentPartitionCallableChildren = getCallableChildren(parentPartition);
				int oldIndex = parentPartitionCallableChildren.indexOf(oldPartition);
				int newIndex = parentPartitionCallableChildren.indexOf(newPartition);
				if (newIndex < 0) {
					parentPartitionCallableChildren.add(oldIndex, newPartition);
				}
				parentPartitionCallableChildren.remove(oldPartition);
				if (!newCallableParents.contains(parentPartition)) {
					newCallableParents.add(parentPartition);
				}
			}
			oldCallableParents.clear();
		}
	}

	/*	public void removeCallToChild(@NonNull Partition parentPartition, @NonNull Partition childPartition) {
		getCallableChildren(parentPartition).remove(childPartition);
		getCallableParents(childPartition).remove(parentPartition);
	} */

	/*	public void replaceCallToChild(@NonNull Partition parentPartition, @NonNull Partition oldPartition, @NonNull Partition newPartition) {
		List<@NonNull Partition> parentPartitionCallableChildren = getCallableChildren(parentPartition);
		int index = parentPartitionCallableChildren.indexOf(oldPartition);
		parentPartitionCallableChildren.remove(oldPartition);
		parentPartitionCallableChildren.add(index, newPartition);
		List<@NonNull Partition> oldPartitionCallableParents = getCallableParents(oldPartition);
		oldPartitionCallableParents.remove(parentPartition);
		oldPartitionCallableParents.add(parentPartition);
	} */
}
