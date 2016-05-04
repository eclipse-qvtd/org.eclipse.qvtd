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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A CyclicScheduledRegion contains the inner regions of a cycle.
 */
public class CyclicScheduledRegion extends AbstractScheduledRegion
{
	public static NodeRole.@NonNull Phase mergePhase(NodeRole.@NonNull Phase phase1, NodeRole.@Nullable Phase phase2) {
		if (phase2 == null) {
			return phase1;
		}
		switch (phase1) {
			case CONSTANT:{
				switch (phase2) {
					case CONSTANT: return NodeRole.Phase.CONSTANT;
					case LOADED: return NodeRole.Phase.LOADED;
					case PREDICATED: return NodeRole.Phase.PREDICATED;
					case REALIZED: return NodeRole.Phase.REALIZED;
				}
			}
			case LOADED:{
				switch (phase2) {
					case CONSTANT: return NodeRole.Phase.LOADED;
					case LOADED: return NodeRole.Phase.LOADED;
					case PREDICATED: return NodeRole.Phase.PREDICATED;
					case REALIZED: return NodeRole.Phase.REALIZED;
				}
			}
			case PREDICATED:{
				switch (phase2) {
					case CONSTANT: return NodeRole.Phase.PREDICATED;
					case LOADED: return NodeRole.Phase.PREDICATED;
					case PREDICATED: return NodeRole.Phase.PREDICATED;
					case REALIZED: return NodeRole.Phase.REALIZED;
				}
			}
			case REALIZED:{
				switch (phase2) {
					case CONSTANT: return NodeRole.Phase.REALIZED;
					case LOADED: return NodeRole.Phase.REALIZED;
					case PREDICATED: return NodeRole.Phase.REALIZED;
					case REALIZED: return NodeRole.Phase.REALIZED;
				}
			}
		}
		throw new UnsupportedOperationException();
	}

	protected final @NonNull ScheduledRegion parentScheduledRegion;

	/**
	 * The nodes to which inputs are passed.
	 */
	private @NonNull List<@NonNull Node> headNodes = new ArrayList<@NonNull Node>();

	/**
	 * The nodes to which inputs are passed.
	 */
//	private @NonNull List<@NonNull Node> extraGuardNodes = new ArrayList<@NonNull Node>();

	/**
	 * The nodes from which outputs are passed.
	 */
//	private @NonNull List<@NonNull Node> tailNodes = new ArrayList<@NonNull Node>();

	public CyclicScheduledRegion(@NonNull ScheduledRegion parentScheduledRegion, @NonNull Iterable<@NonNull Region> regions) {
		super(parentScheduledRegion.getSuperRegion());
		this.parentScheduledRegion = parentScheduledRegion;
		for (@NonNull Region region : regions) {
			addRegion(region);
		}
		createHeadNodes();
//		createExtraHeadNodes();
//		createTailNodes();
//		relocateInternalConnections();
//		for (@NonNull Node headNode : headNodes) {
//			for (@NonNull Node tailNode : tailNodes) {
//				Edges.PRIMARY_RECURSION.createEdge(this, headNode, tailNode);
//			}
//		}
//		toGraph(new DOTStringBuilder());
//		toGraph(new GraphMLStringBuilder());
	}

	@Override
	public @Nullable <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCyclicScheduledRegion(this);
	}

/*	private void createExtraHeadNodes() {
		Map<@NonNull ClassDatumAnalysis, @NonNull Set<@NonNull Node>> type2extraNodes = new HashMap<@NonNull ClassDatumAnalysis, @NonNull Set<@NonNull Node>>();
		for (@NonNull Region innerRegion : getRegions()) {
			for (@NonNull Node guardNode : innerRegion.getGuardNodes()) {
				if (guardNode.getNodeRole().isExtraGuardVariable()) {
					ClassDatumAnalysis classDatumAnalysis = guardNode.getClassDatumAnalysis();
					Set<@NonNull Node> extraNodes = type2extraNodes.get(classDatumAnalysis);
					if (extraNodes == null) {
						extraNodes = new HashSet<@NonNull Node>();
						type2extraNodes.put(classDatumAnalysis, extraNodes);
					}
					extraNodes.add(guardNode);
				}
			}
		}
		int i = 0;
		for (@NonNull ClassDatumAnalysis classDatumAnalysis : type2extraNodes.keySet()) {
			Set<@NonNull Node> extraNodes = type2extraNodes.get(classDatumAnalysis);
			assert extraNodes != null;
			NodeRole.Phase nodeRolePhase = null;
			for (@NonNull Node extraNode : extraNodes) {
				NodeRole.Phase targetNodeRolePhase = extraNode.getNodeRole().getPhase();
				nodeRolePhase = mergePhase(targetNodeRolePhase, nodeRolePhase);
			}
			assert nodeRolePhase != null;
			Node extraGuardNode = Nodes.INPUT.createNode(this, nodeRolePhase, "«extra-" + (extraGuardNodes.size()+1) + "»", classDatumAnalysis);
			extraGuardNodes.add(extraGuardNode);
			NodeConnection nodeConnection = getNodeConnection(Collections.singletonList(extraGuardNode), classDatumAnalysis);
			for (@NonNull Node extraNode : extraNodes) {
				nodeConnection.addUsedTargetNode(extraNode, false);
			}
		}
	} */

	@Override
	protected @NonNull SymbolNameBuilder computeSymbolName() {
		List<@NonNull String> names = new ArrayList<@NonNull String>();
		for (@NonNull NodeConnection connection : getIncomingPassedConnections()) {
			String name = connection.getClassDatumAnalysis().getCompleteClass().getName();
			assert name != null;
			names.add(name);
		}
		Collections.sort(names);
		SymbolNameBuilder s = new SymbolNameBuilder();
		s.appendString("r_");
		for (@NonNull String name : names) {
			s.appendString("_");
			s.appendName(name);
		}
		return s;
	}

	private void createHeadNodes() {
		//
		//	Identify the same-typed passed connections to be merged.
		//
		Map<@NonNull ClassDatumAnalysis, @NonNull Set<@NonNull NodeConnection>> classDatumAnalysis2connections = new HashMap<@NonNull ClassDatumAnalysis, @NonNull Set<@NonNull NodeConnection>>();
		for (@NonNull Region innerRegion : getRegions()) {
			for (@NonNull NodeConnection connection : innerRegion.getIncomingPassedConnections()) {
				ClassDatumAnalysis classDatumAnalysis = connection.getClassDatumAnalysis();
				Set<@NonNull NodeConnection> connections = classDatumAnalysis2connections.get(classDatumAnalysis);
				if (connections == null) {
					connections = new HashSet<@NonNull NodeConnection>();
					classDatumAnalysis2connections.put(classDatumAnalysis, connections);
				}
				connections.add(connection);
			}
		}
		//
		//	Create a head to partition each same-typed set of incoming connection into an external and internal connection.
		//
		for (@NonNull ClassDatumAnalysis classDatumAnalysis : classDatumAnalysis2connections.keySet()) {
			Set<@NonNull NodeConnection> oldConnections = classDatumAnalysis2connections.get(classDatumAnalysis);
			assert oldConnections != null;
			Node headNode = createHeadNode(classDatumAnalysis, oldConnections);
			headNodes.add(headNode);
		}
	}

	private @NonNull Node createHeadNode(@NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull Set<@NonNull NodeConnection> oldConnections) {
		//
		//	Identify the sources of the same-typed connections.
		//
		Set<@NonNull Region> regions = new HashSet<@NonNull Region>(getRegions());
		Set<@NonNull Node> externalSourceNodes = new HashSet<@NonNull Node>();
		Set<@NonNull Node> internalSourceNodes = new HashSet<@NonNull Node>();
		ScheduledRegion commonRegion = null;
		for (@NonNull NodeConnection oldConnection : oldConnections) {
			if (commonRegion == null) {
				commonRegion = oldConnection.getRegion();
			}
			else {
				// FIXME compute common regions
			}
			for (@NonNull Node sourceNode : oldConnection.getSources()) {
				Region sourceRegion = sourceNode.getRegion();
				if (!regions.contains(sourceRegion)) {
					externalSourceNodes.add(sourceNode);
				}
				else {
					internalSourceNodes.add(sourceNode);
				}
			}
		}
		assert commonRegion != null;
		//
		//	Identify whether the head is LOADED/PREDICATED and what it connects to internally.
		//
		NodeRole.Phase nodeRolePhase = null;
		Map<@NonNull Node, @NonNull NodeConnection> targetNode2oldConnection = new HashMap<@NonNull Node, @NonNull NodeConnection>();
		for (@NonNull NodeConnection oldConnection : oldConnections) {
			for (Map.Entry<@NonNull Node, @NonNull ConnectionRole> entry : oldConnection.getTargets().entrySet()) {
				@NonNull Node targetNode = entry.getKey();
				@NonNull ConnectionRole connectionRole = entry.getValue();
				if (connectionRole.isPassed()) {
					Region targetRegion = targetNode.getRegion();
					if (regions.contains(targetRegion)) {
						NodeRole.Phase targetNodeRolePhase = targetNode.getNodeRole().getPhase();
						nodeRolePhase = mergePhase(targetNodeRolePhase, nodeRolePhase);
						targetNode2oldConnection.put(targetNode, oldConnection);
					}
				}
			}
		}
		assert nodeRolePhase != null;
		//
		//	Create the head.
		//
		String name = "«head" + (headNodes.size() > 0 ? Integer.toString(headNodes.size()) : "") + "»";
		Node headNode = Nodes.INPUT.createNode(this, nodeRolePhase, name, classDatumAnalysis);
		System.out.println("Create: " + headNode);
		//
		//	Create the external connection from the composite externalSources to the new head.
		//
		NodeConnection newExternalConnection = commonRegion.getNodeConnection(externalSourceNodes, classDatumAnalysis);
		newExternalConnection.addPassedTargetNode(headNode);
		//
		//	Create the internal connection from the head to the old targets disconnecting them from their old connections.
		//
		NodeConnection newInternalConnection = getNodeConnection(Collections.singletonList(headNode), classDatumAnalysis);
		for (Map.Entry<@NonNull Node, @NonNull NodeConnection> entry : targetNode2oldConnection.entrySet()) {
			@NonNull Node targetNode = entry.getKey();
			@NonNull NodeConnection oldConnection = entry.getValue();
			targetNode.removeIncomingConnection(oldConnection);
			oldConnection.removeTarget(targetNode);
			newInternalConnection.addPassedTargetNode(targetNode);
		}
		//
		//	Destroy obsolete connections.
		//
		for (@NonNull NodeConnection oldConnection : oldConnections) {
			if ((newExternalConnection != oldConnection) && Iterables.isEmpty(oldConnection.getTargetNodes())) {
				oldConnection.destroy();
				System.out.println("Destroy: " + oldConnection);
			}
		}
		return headNode;
	}
/*			@NonNull NodeConnection externalConnection;
			if (externalConnections.size() > 1) {
				Set<@NonNull Node> externalSourceNodes = null;
//				Set<@NonNull Node> internalSourceNodes = null;
				for (@NonNull Node sourceNode : connection.getSources()) {
					Region sourceRegion = sourceNode.getRegion();
					if (!regions.contains(sourceRegion)) {
					}
//					else {}				-- internalSources resolved after unifying connections 
//						if (internalSourceNodes == null) {
//							internalSourceNodes = new HashSet<@NonNull Node>();
//						}
//						internalSourceNodes.add(sourceNode);
//					}
				}
				if (externalSourceNodes != null) {
					Set<@NonNull NodeConnection> connections = classDatumAnalysis2connections.get(externalSourceNodes);
					if (connections == null) {
						connections = new HashSet<@NonNull NodeConnection>();
						externalSourceNodes2connections.put(externalSourceNodes, connections);
					}
					connections.add(connection);
				}
			}
		}
		//
		//	Create a replacement connection to each passed set of externalSources without the internal sources.
		//
		for (@NonNull Set<@NonNull Node> externalSourceNodes : externalSourceNodes2connections.keySet()) {
			Set<@NonNull NodeConnection> oldConnections = externalSourceNodes2connections.get(externalSourceNodes);
			assert oldConnections != null;
			Set<@NonNull Node> internalTargetNodes = new HashSet<@NonNull Node>();
			NodeRole.Phase nodeRolePhase = null;
			NodeConnection anOldConnection = oldConnections.iterator().next();
			ClassDatumAnalysis classDatumAnalysis = anOldConnection.getClassDatumAnalysis();
			NodeConnection newExternalConnection = anOldConnection.getRegion().getNodeConnection(externalSourceNodes, classDatumAnalysis);
			for (@NonNull NodeConnection oldConnection : oldConnections) {
				if (newExternalConnection != oldConnection) {
					for (Map.Entry<@NonNull Node, @NonNull ConnectionRole> entry : oldConnection.getTargets().entrySet()) {
						@NonNull Node targetNode = entry.getKey();
						@NonNull ConnectionRole connectionRole = entry.getValue();
						if (connectionRole.isPassed()) {
							Region targetRegion = targetNode.getRegion();
							if (regions.contains(targetRegion)) {
								targetNode.removeIncomingConnection(oldConnection);
								oldConnection.removeTarget(targetNode);
								newExternalConnection.addPassedTargetNode(targetNode);
								internalTargetNodes.add(targetNode);
								NodeRole.Phase targetNodeRolePhase = targetNode.getNodeRole().getPhase();
								nodeRolePhase = mergePhase(targetNodeRolePhase, nodeRolePhase);
							}
						}
					}
				}
			}
			assert nodeRolePhase != null;
			String name = "-head-" + classDatumAnalysis.toString(); //outerConnection.getName();
			Node headNode = Nodes.INPUT.createNode(this, nodeRolePhase, name, classDatumAnalysis);
			headNodes.add(headNode);
			newExternalConnection.addPassedTargetNode(headNode);
			for (@NonNull NodeConnection oldConnection : oldConnections) {
				if ((newExternalConnection != oldConnection) && Iterables.isEmpty(oldConnection.getTargetNodes())) {
					oldConnection.destroy();
				}
			}
			NodeConnection newInternalConnection = getNodeConnection(Collections.singletonList(headNode), classDatumAnalysis);
			for (@NonNull Node internalTargetNode : internalTargetNodes) {
				newInternalConnection.addPassedTargetNode(internalTargetNode);
			}
		} */
/*		for (@NonNull NodeConnection outerConnection : incomingConnections2headNodes.keySet()) {
			Set<@NonNull Node> targetNodes = incomingConnections2headNodes.get(outerConnection);
			assert targetNodes != null;
			NodeRole.Phase nodeRolePhase = null;
			for (@NonNull Node targetNode : targetNodes) {
				NodeRole.Phase targetNodeRolePhase = targetNode.getNodeRole().getPhase();
				nodeRolePhase = mergePhase(targetNodeRolePhase, nodeRolePhase);
			}
			assert nodeRolePhase != null;
			ClassDatumAnalysis classDatumAnalysis = outerConnection.getClassDatumAnalysis();
			String name = "-head-" + classDatumAnalysis.toString(); //outerConnection.getName();
			Node headNode = Nodes.INPUT.createNode(this, nodeRolePhase, name, classDatumAnalysis);
			outerConnection.addPassedTargetNode(headNode);
//			List<@NonNull Node> headNodeList = Collections.singletonList(headNode);
//			NodeConnection innerConnection = getNodeConnection(headNodeList, classDatumAnalysis);
//			for (@NonNull Node targetNode : targetNodes) {
//				targetNode.removeIncomingConnection(outerConnection);
//				outerConnection.removeTarget(targetNode);
//				if (!Iterables.contains(innerConnection.getTargetNodes(), targetNode)) {
//					innerConnection.addPassedTargetNode(targetNode);
//				}
//			}
//			addConnection(innerConnection);
//			outerConnection.addSubConnection(innerConnection);
			headNodes.add(headNode);
		} */
//	}

	/**
	 * Every outgoing connection that passes a value must have a tail node to accumulate the value to be passed.
	 *
	private void createTailNodes() {
		Map<@NonNull NodeConnection, @NonNull Set<@NonNull Node>> outgoingConnections2tailNodes = new HashMap<@NonNull NodeConnection, @NonNull Set<@NonNull Node>>();
		Set<@NonNull Region> regions = new HashSet<@NonNull Region>(getRegions());
		for (@NonNull Region innerRegion : regions) {
			for (@NonNull NodeConnection connection : innerRegion.getOutgoingPassedConnections()) {
				for (@NonNull Node targetNode : connection.getTargetNodes()) {
					Region targetRegion = targetNode.getRegion();
					if (!regions.contains(targetRegion)) {
						Set<@NonNull Node> innerTailNodes = outgoingConnections2tailNodes.get(connection);
						if (innerTailNodes == null) {
							innerTailNodes = new HashSet<@NonNull Node>();
							outgoingConnections2tailNodes.put(connection, innerTailNodes);
						}
						for (@NonNull Node sourceNode : connection.getSourceNodes()) {
							Region sourceRegion = sourceNode.getRegion();
							if (regions.contains(sourceRegion)) {
								innerTailNodes.add(sourceNode);
							}
						}
					}
				}
			}
		}
		for (@NonNull NodeConnection outerConnection : outgoingConnections2tailNodes.keySet()) {
			Set<@NonNull Node> sourceNodes = outgoingConnections2tailNodes.get(outerConnection);
			assert sourceNodes != null;
			NodeRole.Phase nodeRolePhase = null;
			for (@NonNull Node sourceNode : sourceNodes) {
				NodeRole.Phase sourceNodeRolePhase = sourceNode.getNodeRole().getPhase();
				nodeRolePhase = mergePhase(sourceNodeRolePhase, nodeRolePhase);
			}
			assert nodeRolePhase != null;
			ClassDatumAnalysis classDatumAnalysis = outerConnection.getClassDatumAnalysis();
			String name = "-tail-" + classDatumAnalysis.toString(); //outerConnection.getName();
			Node tailNode = Nodes.OUTPUT.createNode(this, nodeRolePhase, name, classDatumAnalysis);
//			@NonNull List<@NonNull Node> tailNodeList = Collections.singletonList(tailNode);
			NodeConnection innerConnection = getNodeConnection(sourceNodes, classDatumAnalysis);
			innerConnection.addPassedTargetNode(tailNode);
//			addConnection(innerConnection);
			tailNodes.add(tailNode);
			outerConnection.getRegion().replaceSources(outerConnection, sourceNodes, tailNode);
//			outerConnection.addSubConnection(innerConnection);
		}
	}*/
	
	@Override
	public @NonNull String getName() {
		List<@NonNull String> names = new ArrayList<@NonNull String>();
		for (@NonNull Region region : getRegions()) {
			names.add(region.getName());
		}
		Collections.sort(names);;
		StringBuilder s = new StringBuilder();
//		s.append(getClass().getSimpleName());
		for (String name : names) {
			if (s.length() > 0) {
				s.append("\\n");
			}
			s.append(name);
		}
		return s.toString();
	}
	
	@Override
	public @NonNull String getColor() {
		return "brown";
	}

//	@Override
//	public @NonNull Collection<@NonNull Connection> getConnections() {
//		return Sets.newHashSet(Iterables.concat(getIncomingConnections(), getOutgoingConnections()));
//	}

//	@Override
//	public @NonNull List<@NonNull NodeConnection> getHeadConnections() {
//		return getIncomingPassedConnections();
//	}

	@Override
	public @NonNull List<@NonNull Node> getHeadNodes() {
		return headNodes;
	}

	@Override
	public @NonNull Iterable<@NonNull DatumConnection> getIncomingConnections() {		// FIXME cache
		return Sets.newHashSet(Iterables.concat(getIncomingPassedConnections(), getIncomingUsedConnections()));
/*		Set<@NonNull DatumConnection> connections = new HashSet<@NonNull DatumConnection>();
		Set<@NonNull Region> regions = new HashSet<@NonNull Region>(getRegions());
		for (@NonNull Region region : regions) {
			for (@NonNull DatumConnection connection : region.getIncomingConnections()) {
				for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
					if (!regions.contains(sourceRegion) && !connections.contains(connection)) {
						connections.add(connection);
					}
				}
			}
		}
		return connections; */
	}

/*	@Override
	public @NonNull List<@NonNull NodeConnection> getIncomingPassedConnections() {		// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<@NonNull NodeConnection>();
		Set<@NonNull Region> regions = new HashSet<@NonNull Region>(getRegions());
		for (@NonNull Region region : regions) {
			for (@NonNull NodeConnection connection : region.getIncomingPassedConnections()) {
				for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
					if (!regions.contains(sourceRegion) && !connections.contains(connection)) {
						connections.add(connection);
					}
				}
			}
		}
		return connections;
	} */

	@Override
	public @NonNull List<@NonNull NodeConnection> getIncomingUsedConnections() {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<@NonNull NodeConnection>();
		Set<@NonNull Region> regions = new HashSet<@NonNull Region>(getRegions());
		for (@NonNull Region region : regions) {
			for (@NonNull NodeConnection connection : region.getIncomingUsedConnections()) {
				for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
					if (!regions.contains(sourceRegion) && !connections.contains(connection)) {
						connections.add(connection);
					}
				}
			}
		}
		return connections;
	}

	@Override
	public @NonNull List<@NonNull DatumConnection> getNextConnections() {			// FIXME cache
		Set<@NonNull DatumConnection> connections = new HashSet<@NonNull DatumConnection>();
		for (@NonNull Node headNode : headNodes) {
			for (@NonNull NodeConnection connection : headNode.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
		}
		Iterables.addAll(connections, getOutgoingUsedConnections());
		return Lists.newArrayList(connections);
/*		List<@NonNull DatumConnection> connections = new ArrayList<@NonNull DatumConnection>();
		Set<@NonNull Region> regions = new HashSet<@NonNull Region>(getRegions());
		for (@NonNull Region region : regions) {
			for (@NonNull DatumConnection connection : region.getOutgoingConnections()) {
				for (@NonNull Region targetRegion : connection.getTargetRegions()) {
					if (!regions.contains(targetRegion) && !connections.contains(connection)) {
						connections.add(connection);
					}
				}
			}
		}
		return connections; */
	}

	@Override
	public @NonNull List<@NonNull DatumConnection> getOutgoingConnections() {			// FIXME cache
		Set<@NonNull DatumConnection> connections = new HashSet<@NonNull DatumConnection>();
		Iterables.addAll(connections, getOutgoingPassedConnections());
		Iterables.addAll(connections, getOutgoingUsedConnections());
		return Lists.newArrayList(connections);
/*		List<@NonNull DatumConnection> connections = new ArrayList<@NonNull DatumConnection>();
		Set<@NonNull Region> regions = new HashSet<@NonNull Region>(getRegions());
		for (@NonNull Region region : regions) {
			for (@NonNull DatumConnection connection : region.getOutgoingConnections()) {
				for (@NonNull Region targetRegion : connection.getTargetRegions()) {
					if (!regions.contains(targetRegion) && !connections.contains(connection)) {
						connections.add(connection);
					}
				}
			}
		}
		return connections; */
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getOutgoingPassedConnections() {			// FIXME cache
//		throw new UnsupportedOperationException();
/*		List<@NonNull NodeConnection> connections = new ArrayList<@NonNull NodeConnection>();
		for (@NonNull Node headNode : headNodes) {
			for (@NonNull NodeConnection connection : headNode.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
		}
		return connections; */
		Set<@NonNull NodeConnection> connections = new HashSet<@NonNull NodeConnection>();
		Set<@NonNull Region> regions = new HashSet<@NonNull Region>(getRegions());
		for (@NonNull Region region : regions) {
//			System.out.println("Region: " + region);
			for (@NonNull NodeConnection connection : region.getOutgoingPassedConnections()) {
//				System.out.println("  connection: " + connection);
				for (Map.Entry<@NonNull Node, @NonNull ConnectionRole> targetEntry : connection.getTargets().entrySet()) {
					if (targetEntry.getValue().isPassed()) { // && !connections.contains(connection)) {
						Node targetNode = targetEntry.getKey();
						Region targetRegion = targetNode.getRegion();
//						System.out.println("    target region: " + targetRegion);
						if (!regions.contains(targetRegion)) {
//							System.out.println("      add: ");
							connections.add(connection);
						}
					}
				}
			}
		}
//		for (@NonNull NodeConnection connection : connections) {
//			System.out.println("  -- " + connection);
//		}
		return connections;
	}

	@Override
	public @NonNull List<@NonNull NodeConnection> getOutgoingUsedConnections() {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<@NonNull NodeConnection>();
		Set<@NonNull Region> regions = new HashSet<@NonNull Region>(getRegions());
		for (@NonNull Region region : regions) {
			for (@NonNull NodeConnection connection : region.getOutgoingUsedConnections()) {
				for (@NonNull Region targetRegion : connection.getTargetRegions()) {
					if (!regions.contains(targetRegion) && !connections.contains(connection)) {
						connections.add(connection);
					}
				}
			}
		}
		return connections;
	}

	@Override
	public @NonNull RootScheduledRegion getRootScheduledRegion() {
		return parentScheduledRegion.getRootScheduledRegion();
	}

	@Override
	public boolean isCyclicScheduledRegion() {
		return true;
	}

	/**
	 * Every outgoing connection whose source and target regions are internal is relocated to this region.
	 *
	private void relocateInternalConnections() {
		Set<@NonNull Region> regions = new HashSet<@NonNull Region>(getRegions());
		for (@NonNull Region innerRegion : regions) {
			for (@NonNull DatumConnection connection : innerRegion.getOutgoingConnections()) {
				boolean isInternal = true;
				for (@NonNull Region targetRegion : connection.getTargetRegions()) {
					if (!regions.contains(targetRegion)) {
						isInternal = false;
						break;
					}
				}
				if (isInternal) {
					for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
						if (!regions.contains(sourceRegion)) {
							isInternal = false;
							break;
						}
					}
				}
				if (isInternal && (connection.getRegion() != this)) {
					if (connection instanceof EdgeConnection) {
						EdgeConnection oldEdgeConnection = (EdgeConnection)connection;
						EdgeConnection newEdgeConnection = getEdgeConnection(oldEdgeConnection.getSources(), oldEdgeConnection.getProperty());
						Map<@NonNull NavigationEdge, @NonNull ConnectionRole> targets = new HashMap<@NonNull NavigationEdge, @NonNull ConnectionRole>(oldEdgeConnection.getTargets());
						connection.getRegion().removeConnection(connection);
						for (Map.Entry<@NonNull NavigationEdge, @NonNull ConnectionRole> entry : targets.entrySet()) {
							newEdgeConnection.addUsedTargetEdge(entry.getKey(), entry.getValue().isMandatory());
						}
					}
					else {
						NodeConnection oldNodeConnection = (NodeConnection)connection;
						NodeConnection newNodeConnection = getNodeConnection(oldNodeConnection.getSources(), oldNodeConnection.getClassDatumAnalysis());
						Map<@NonNull Node, @NonNull ConnectionRole> targets = new HashMap<@NonNull Node, @NonNull ConnectionRole>(oldNodeConnection.getTargets());
						connection.getRegion().removeConnection(connection);
						for (Map.Entry<@NonNull Node, @NonNull ConnectionRole> entry : targets.entrySet()) {
							newNodeConnection.addUsedTargetNode(entry.getKey(), entry.getValue().isMandatory());
						}
					}
				}
			}
		}
	} */
	
	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@NonNull Region region : getRegions()) {
			region.toGraph(s);
		}
		for (@NonNull Node node : getNodes()) {
			s.appendNode(node);
		}
		for (@NonNull Edge edge : getEdges()) {
			s.appendEdge(edge.getSource(), edge, edge.getTarget());
		}
		for (@NonNull Connection connection : getConnections()) {
			connection.toGraph(s);
		}
		s.popCluster();
	}
}