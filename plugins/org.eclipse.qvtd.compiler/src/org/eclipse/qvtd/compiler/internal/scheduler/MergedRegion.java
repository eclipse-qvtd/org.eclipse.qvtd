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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * A MergedRegion contains MergedNodes and MergedEeges each of which provides th merged of one or more SimpleRegions/Nodes/Edges..
 */
public class MergedRegion extends AbstractRegion
{
	private final @NonNull List<MergeableRegion> mergedRegions = new ArrayList<MergeableRegion>();
	private final @NonNull Map<SimpleNode, MergedNode> simpleNode2mergedNode = new HashMap<SimpleNode, MergedNode>();
	private final @NonNull Map<SimpleEdge, MergedEdge> simpleEdge2mergedEdge = new HashMap<SimpleEdge, MergedEdge>();
	private @Nullable Map<Node, Node> recursiveBindings = null;

	public MergedRegion(@NonNull MergeableRegion primaryRegion) {
		super(primaryRegion.getSuperRegion());
//		addPrimaryRegion(primaryRegion);
		mergedRegions.add(primaryRegion);
		createMergedRegion(primaryRegion);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitMergedRegion(this);
	}

	private void addEdgeToMergedEdge(@NonNull Edge edge, @NonNull MergedEdge mergedEdge) {
		mergedEdge.addEdge(edge);
//		for (SimpleEdge simpleEdge : edge.getSimpleEdges()) {
//			addSimpleEdgeToMergedEdge(simpleEdge, mergedEdge);
//		}
	}

	private void addNodeToMergedNode(@NonNull Node node, @NonNull MergedNode mergedNode) {
		for (@SuppressWarnings("null")@NonNull SimpleNode simpleNode : node.getSimpleNodes()) {
			addSimpleNodeToMergedNode(simpleNode, mergedNode);
		}
	}

	@SuppressWarnings("unused")
	private void addSimpleEdgeToMergedEdge(@NonNull SimpleEdge simpleEdge, @NonNull MergedEdge mergedEdge) {
		mergedEdge.addEdge(simpleEdge);
	}

	private void addSimpleNodeToMergedNode(@NonNull SimpleNode simpleNode, @NonNull MergedNode mergedNode) {
		mergedNode.addNode(simpleNode);
		simpleNode2mergedNode.put(simpleNode, mergedNode);
		for (Edge incomingEdge : new ArrayList<Edge>(simpleNode.getIncomingEdges())) {
			if (incomingEdge.getSource().getRegion() != incomingEdge.getTarget().getRegion()) {
				if (mergedNode == incomingEdge.getSource()) {
					incomingEdge.destroy();
				}
				else {
					incomingEdge.setTarget(mergedNode);
				}
			}
		}	
		for (Edge outgoingEdge : new ArrayList<Edge>(simpleNode.getOutgoingEdges())) {
			if (outgoingEdge.getSource().getRegion() != outgoingEdge.getTarget().getRegion()) {
				if (mergedNode == outgoingEdge.getTarget()) {
					outgoingEdge.destroy();
				}
				else {
					outgoingEdge.setSource(mergedNode);
				}
			}
		}	
	}

//	private void addPrimaryRegion(@NonNull Region primaryRegion) {
//		mergedRegions.add(primaryRegion);
//		createMergedRegion(primaryRegion);
//	}

	private void createMergedRegion(@NonNull Region region) {
/*		for (@SuppressWarnings("null")@NonNull Region nestedRegion : region.getRegions()) {
			MergedRegion nestedMergedRegion = new MergedRegion((MergeableRegion)nestedRegion);
			addRegion(nestedMergedRegion);
			for (Node node : nestedMergedRegion.getNodes()) {
				MergedNode mergedNode = (MergedNode)node;
				for (SimpleNode simpleNode : mergedNode.getNodes()) {
					simpleNode2mergedNode.put(simpleNode, mergedNode);
				}
			}
			for (Edge edge : nestedMergedRegion.getEdges()) {
				MergedEdge mergedEdge = (MergedEdge)edge;
				for (SimpleEdge simpleEdge : mergedEdge.getEdges()) {
					simpleEdge2mergedEdge.put(simpleEdge, mergedEdge);
				}
			}
		} */
		for (@SuppressWarnings("null")@NonNull Node node : region.getNodes()) {
			createMergedNode(node);
		}
		for (@SuppressWarnings("null")@NonNull Edge edge : region.getEdges()) {
			if (edge instanceof NavigationEdge) {
				createMergedNavigationEdge(edge.getSource(), (NavigationEdge)edge, edge.getTarget());
			}
			else if (edge.isMergeable()) {
				createMergedEdge(edge.getSource(), edge, edge.getTarget());
			}
			else {
				System.out.println("Unmerged edge" + edge);
			}
		}
	}

	@Override
	protected @NonNull List<List<Node>> computeHeadNodeGroups() {
		// TODO Auto-generated method stub
		return super.computeHeadNodeGroups();
	}

	private @NonNull MergedEdge createMergedEdge(@NonNull Node sourceNode, @NonNull Edge edge, @NonNull Node targetNode) {
		MergedNode mergedSource = getMergedNode(sourceNode);
		MergedNode mergedTarget = getMergedNode(targetNode);
		MergedEdge mergedEdge = new MergedEdge(this, mergedSource, edge, mergedTarget);
		for (SimpleEdge simpleEdge : edge.getSimpleEdges()) {
			MergedEdge oldEdge = simpleEdge2mergedEdge.put(simpleEdge, mergedEdge);
			assert oldEdge == null;
		}
		return mergedEdge;
	}

	private @NonNull MergedNavigationEdge createMergedNavigationEdge(@NonNull Node sourceNode, @NonNull NavigationEdge edge,  @NonNull Node targetNode) {
		MergedNode mergedSource = getMergedNode(sourceNode);
		MergedNode mergedTarget = getMergedNode(targetNode);
		MergedNavigationEdge mergedEdge = new MergedNavigationEdge(this, mergedSource, edge, mergedTarget);
		for (SimpleEdge simpleEdge : edge.getSimpleEdges()) {
			MergedEdge oldEdge = simpleEdge2mergedEdge.put(simpleEdge, mergedEdge);
			assert oldEdge == null;
		}
		return mergedEdge;
	}

	private @NonNull MergedNode createMergedNode(@NonNull Node node) {
		MergedNode mergedNode = new MergedNode(this, node);
		addNodeToMergedNode(node, mergedNode);
		return mergedNode;
	}
	
	private @Nullable MergedNode findMergedNode(@Nullable Node node) {
		if (node instanceof MergedNode) {
			return (MergedNode) node;
		}
		else if (node != null) {
			return simpleNode2mergedNode.get(node);
		}
		else {
			return null;
		}
	}
	
	@Override
	public @NonNull String getName() {
		List<String> names = new ArrayList<String>();
		for (Region region : mergedRegions) {
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
		return "green";
	}
	
	@Override
	public @NonNull Iterable<MergeableRegion> getMergeableRegions() {
		return mergedRegions;
	}

	public @NonNull MergedNode getMergedNode(@NonNull Node node) {
		if (node instanceof MergedNode) {
			return (MergedNode)node;
		}
		MergedNode mergedNode = simpleNode2mergedNode.get(node);
		if (mergedNode != null) {
			return mergedNode;
		}
		return ClassUtil.nonNullState(mergedNode);
//		MergedNode mergedNode = simpleNode2mergedNode.get(node);
//		if (mergedNode == null) {
//			mergedNode = createMergedNode(node);
//		}
//		return mergedNode;
	}

	public @Nullable Map<Node, Node> getRecursiveBindings() {
		return recursiveBindings;
	}

/*	public @NonNull Map<MergedNode, Node> getSharedPredicate(@NonNull MappingRegion mappingRegion) {
		List<MappingRegion> requiredRegions = new ArrayList<MappingRegion>();
		Map<MergedNode, Node> bindings = new HashMap<MergedNode, Node>();
		for (@SuppressWarnings("null")@NonNull Edge edge : mappingRegion.getEdges()) {
			if (edge.isPredicated()) {
				Node source = edge.getSource();
				Node target = edge.getTarget();
				MergedNode mergedSource = simpleNode2mergedNode.get(source);
				MergedNode mergedTarget = simpleNode2mergedNode.get(target);
				assert (mergedSource != null) && (mergedTarget != null);
				MappingRegion introductorySourceRegion = mergedSource.getIntroductoryRegion();
				MappingRegion introductoryTargetRegion = mergedTarget.getIntroductoryRegion();
				if (introductorySourceRegion != mappingRegion) {
					if (!requiredRegions.contains(introductorySourceRegion)) {
						requiredRegions.add(introductorySourceRegion);
					}
				}
				else if ((introductoryTargetRegion != mappingRegion) && target.isClassNode()) {
					if (!requiredRegions.contains(introductoryTargetRegion)) {
						requiredRegions.add(introductoryTargetRegion);
					}
				}
				else {
					Node oldSource = bindings.put(mergedSource, source);
					Node oldTarget = bindings.put(mergedTarget, target);
					assert (oldSource == source) || (oldSource == null);
					assert (oldTarget == target) || (oldTarget == null);
				}
			}
		}
		for (int i = 0; i < requiredRegions.size(); i++) {
			MappingRegion requiredRegion = requiredRegions.get(i);
			for (@SuppressWarnings("null")@NonNull Edge edge : requiredRegion.getEdges()) {
				if (edge.isPredicated()) {
					Node source = edge.getSource();
					Node target = edge.getTarget();
					MergedNode mergedSource = simpleNode2mergedNode.get(source);
					MergedNode mergedTarget = simpleNode2mergedNode.get(target);
					assert (mergedSource != null) && (mergedTarget != null);
					MappingRegion introductorySourceRegion = mergedSource.getIntroductoryRegion();
					MappingRegion introductoryTargetRegion = mergedTarget.getIntroductoryRegion();
					if (introductorySourceRegion != requiredRegion) {
						if (!requiredRegions.contains(introductorySourceRegion)) {
							requiredRegions.add(introductorySourceRegion);
						}
					}
					else if ((introductoryTargetRegion != requiredRegion) && target.isClassNode()) {
						if (!requiredRegions.contains(introductoryTargetRegion)) {
							requiredRegions.add(introductoryTargetRegion);
						}
					}
					else {
						Node oldSource = bindings.put(mergedSource, null);
						Node oldTarget = bindings.put(mergedTarget, null);
						assert oldSource == null;
						assert oldTarget == null;
					}
				}
			}
		}
		return bindings;
	} */

/*	@Override
	public boolean isIterationRegion() {
		for (Region mergedRegion : mergedRegions) {
			if (mergedRegion.isIterationRegion()) {
				return true;
			}
		}
		return false;
	} */

/*	private void mergeNestedRegions(@NonNull List<Region> nestedRegions) {
		if (!nestedRegions.isEmpty()) {
			Map<Node, Node> node2clone = new HashMap<Node, Node>();
			for (Node mergedNode : getNodes()) {
				for (Node originalNode : ((MergedNode)mergedNode).getNodes()) {
					node2clone.put(originalNode, mergedNode);
				}
			}
			for (@SuppressWarnings("null")@NonNull Region nestedSecondaryRegion : nestedRegions) {
				nestedSecondaryRegion.cloneIn(this, node2clone);
			}
		}
	} */

	public void mergeRegion(@NonNull Region secondaryRegion, @NonNull Map<Node, Node> secondaryNode2primaryNode) {
//		Region secondaryRegion = secondaryNode2mergedNode.keySet().iterator().next().getRegion();
		//
		//	Merge the regions
		//
		for (@SuppressWarnings("null")@NonNull MergeableRegion mergeableRegion : secondaryRegion.getMergeableRegions()) {
			mergedRegions.add(mergeableRegion);
		}
/*		for (@SuppressWarnings("null")@NonNull Region nestedRegion : secondaryRegion.getRegions()) {
			MergedRegion nestedMergedRegion = new MergedRegion((MergeableRegion)nestedRegion);
			addRegion(nestedMergedRegion);
//			for (Node mergedNode : nestedMergedRegion.getNodes()) {
//				for (Node node : ((MergedNode)mergedNode).getNodes()) {
//					secondaryNode2mergedNode.put(node, (MergedNode) mergedNode);
//				}
//			}
		} */
		//
		//	Merge the overlapping nodes
		//
		for (@SuppressWarnings("null")Map.@NonNull Entry<Node, Node> entry : secondaryNode2primaryNode.entrySet()) {
			@SuppressWarnings("null")@NonNull Node secondaryNode = entry.getKey();
			@SuppressWarnings("null")@NonNull Node primaryNode = entry.getValue();
//			assert mergedRegions.contains(primaryNode.getRegion());
			MergedNode mergedNode = getMergedNode(primaryNode);
			addNodeToMergedNode(secondaryNode, mergedNode);
		}
		//
		//	Merge the additional nodes
		//
		for (@SuppressWarnings("null")@NonNull Node secondaryNode : secondaryRegion.getNodes()) {
			Node primaryNode = secondaryNode2primaryNode.get(secondaryNode);
			MergedNode mergedNode1 = findMergedNode(primaryNode);
			if (mergedNode1 == null) {
				mergedNode1 = createMergedNode(secondaryNode);
				secondaryNode2primaryNode.put(secondaryNode, mergedNode1);
			}
//			MergedNode mergedNode2 = getMergedNode(secondaryNode);
			assert mergedNode1 != null;
//			assert mergedNode1 == mergedNode2;
//			assert simpleNode2mergedNode.get(secondaryNode) != null;
		}
		//
		//	Merge the edges
		//
//		for (@SuppressWarnings("null")@NonNull Node secondarySourceNode : secondaryRegion.getNodes()) {
//			MergedNode mergedSourceNode = getMergedNode(secondarySourceNode);
//			for (@SuppressWarnings("null")@NonNull Edge secondaryEdge : secondarySourceNode.getMergeableEdges()) {
		for (@SuppressWarnings("null")@NonNull Edge secondaryEdge : secondaryRegion.getEdges()) {
			if (secondaryEdge.isMergeable()) {
				Node primarySource = ClassUtil.nonNullState(secondaryNode2primaryNode.get(secondaryEdge.getSource()));
				Node primaryTarget = ClassUtil.nonNullState(secondaryNode2primaryNode.get(secondaryEdge.getTarget()));
				MergedNode mergedSourceNode = getMergedNode(primarySource);
//				Node secondaryTargetNode = secondaryEdge.getTarget();
				if (secondaryEdge instanceof NavigationEdge) {
					NavigationEdge secondaryNavigationEdge = (NavigationEdge)secondaryEdge;
					MergedNavigationEdge mergedEdge = (MergedNavigationEdge) mergedSourceNode.getNavigationEdge(secondaryNavigationEdge.getProperty());
					if (mergedEdge == null) {
						createMergedNavigationEdge(primarySource, secondaryNavigationEdge, primaryTarget);
					}
					else {
//						MergedNode mergedTargetNode1 = getMergedNode(secondaryTargetNode);
//						Node mergedTargetNode2 = secondaryNode2primaryNode.get(secondaryTargetNode);
//						assert mergedTargetNode1 == mergedTargetNode2;
						addEdgeToMergedEdge(secondaryEdge, mergedEdge);
					}
				}
				else {
					createMergedEdge(primarySource, secondaryEdge, primaryTarget);
				}
			}
		}
		//
		//	Prune dead casts
		//
/*		List<Node> deadNodes = null;
		for (Edge castEdge : getCastEdges()) {
			Node sourceNode = castEdge.getSource();
			List<Edge> incomingEdges = sourceNode.getIncomingEdges();
			if ((incomingEdges == null) || incomingEdges.isEmpty()) {
				if (deadNodes == null) {
					deadNodes = new ArrayList<Node>();
				}
				deadNodes.add(sourceNode);
			}
		}
		if (deadNodes != null) {
			for (Node deadNode : deadNodes) {
				deadNode.destroy();
			}
		} */
		
		//
//		mergedRegions.add(secondaryRegion);
	}
}