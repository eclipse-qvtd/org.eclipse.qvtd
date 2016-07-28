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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;

public class RegionMerger extends AbstractVisitor<@NonNull Visitable>
{
	public static @NonNull MappingRegion createMergedRegion(@NonNull MappingRegion primaryRegion, @NonNull MappingRegion secondaryRegion, @NonNull Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode) {
		RegionMerger regionMerger = new RegionMerger(primaryRegion, secondaryRegion, secondaryNode2primaryNode);
		return (MappingRegion) secondaryRegion.accept(regionMerger);
	}

	protected final @NonNull MappingRegion primaryRegion;
	protected final @NonNull MappingRegion secondaryRegion;
	protected final @NonNull Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode;
	protected final @NonNull MappingRegion mergedRegion;
	protected final @NonNull Map<@NonNull Node, @NonNull Node> oldNode2mergedNode = new HashMap<>();
	protected final @NonNull Map<@NonNull Edge, @NonNull List<@NonNull Edge>> oldEdge2oldEdges = new HashMap<>();
	protected final @NonNull Map<@NonNull Edge, @NonNull Edge> oldEdge2mergedEdge = new HashMap<>();

	protected RegionMerger(@NonNull MappingRegion primaryRegion, @NonNull MappingRegion secondaryRegion, @NonNull Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode) {
		this.primaryRegion = primaryRegion;
		this.secondaryRegion = secondaryRegion;
		this.secondaryNode2primaryNode = secondaryNode2primaryNode;
		this.mergedRegion = new MergedMappingRegion(primaryRegion, secondaryRegion);
	}

	protected void accumulateEdge(@NonNull Map<@NonNull Node, @NonNull Map<@NonNull Node, @NonNull List<@NonNull List<@NonNull Edge>>>> mergedSourceNode2mergedTargetNode2listOfOldEdges, @NonNull Edge oldEdge) {
		//		List<@NonNull Edge> oldOldEdges2 = oldEdge2oldEdges.get(oldEdge);
		//		assert oldOldEdges2 == null;
		Node mergedSourceNode = oldNode2mergedNode.get(oldEdge.getSource());
		Node mergedTargetNode = oldNode2mergedNode.get(oldEdge.getTarget());
		assert (mergedSourceNode != null) && (mergedTargetNode != null);
		Map<@NonNull Node, @NonNull List<@NonNull List<@NonNull Edge>>> mergedTargetNode2listOfOldEdges = mergedSourceNode2mergedTargetNode2listOfOldEdges.get(mergedSourceNode);
		if (mergedTargetNode2listOfOldEdges == null) {
			mergedTargetNode2listOfOldEdges = new HashMap<>();
			mergedSourceNode2mergedTargetNode2listOfOldEdges.put(mergedSourceNode, mergedTargetNode2listOfOldEdges);
		}
		List<@NonNull List<@NonNull Edge>> listOfOldEdges = mergedTargetNode2listOfOldEdges.get(mergedTargetNode);
		if (listOfOldEdges == null) {
			listOfOldEdges = new ArrayList<>();
			mergedTargetNode2listOfOldEdges.put(mergedTargetNode, listOfOldEdges);
		}
		List<@NonNull Edge> matchingOldEdges = null;
		for (@NonNull List<@NonNull Edge> oldEdges : listOfOldEdges) {
			if (sameEdge(oldEdge, oldEdges)) {
				matchingOldEdges = oldEdges;
				break;
			}
		}
		if (matchingOldEdges == null) {
			matchingOldEdges = new ArrayList<>();
			listOfOldEdges.add(matchingOldEdges);
		}
		matchingOldEdges.add(oldEdge);
		List<@NonNull Edge> oldOldEdges = oldEdge2oldEdges.put(oldEdge, matchingOldEdges);
		assert oldOldEdges == null;
	}

	private void checkEdges(@NonNull Region oldRegion) {
		for (@NonNull Edge oldEdge : oldRegion.getEdges()) {
			assert oldEdge.getRegion() == oldRegion;
			if (!oldEdge.isRecursion()) {		// FIXME Remove this irregularity
				List<@NonNull Edge> oldEdges = oldEdge2oldEdges.get(oldEdge);
				assert oldEdges != null;
				assert oldEdges.contains(oldEdge);
				Edge mergedEdge = oldEdge2mergedEdge.get(oldEdge);
				assert mergedEdge != null;
				assert mergedEdge.getRegion() == mergedRegion;
			}
		}
	}

	private void checkNodes(@NonNull Region oldRegion) {
		for (@NonNull Node oldNode : oldRegion.getNodes()) {
			assert oldNode.getRegion() == oldRegion;
			Node mergedNode = oldNode2mergedNode.get(oldNode);
			assert mergedNode != null;
			assert mergedNode.getRegion() == mergedRegion;
		}
	}

	protected void createMergedEdge(@NonNull Iterable<@NonNull Edge> oldEdges) {
		Edge mergedEdge = null;
		for (@NonNull Edge oldEdge : oldEdges) {
			mergedEdge = (Edge)oldEdge.accept(this);
			break;
		}
		assert mergedEdge != null;
		for (@NonNull Edge oldEdge : oldEdges) {
			oldEdge2mergedEdge.put(oldEdge, mergedEdge);
		}
	}

	private boolean sameEdge(@NonNull Edge newEdge, @NonNull Iterable<@NonNull Edge> oldEdges) {
		if (newEdge instanceof NavigationEdge) {
			Property newProperty = ((NavigationEdge)newEdge).getProperty();
			for (@NonNull Edge oldEdge : oldEdges) {
				if (oldEdge instanceof NavigationEdge) {
					Property oldProperty = ((NavigationEdge)oldEdge).getProperty();
					if (oldProperty == newProperty) {
						return true;
					}
				}
			}
		}
		else {
			Class<? extends @NonNull Edge> newClass = newEdge.getClass();
			for (@NonNull Edge oldEdge : oldEdges) {
				Class<? extends @NonNull Edge> oldClass = oldEdge.getClass();
				if (oldClass == newClass) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public @NonNull Visitable visitBasicSimpleEdge(@NonNull BasicSimpleEdge basicSimpleEdge) {
		Node mergedSourceNode = oldNode2mergedNode.get(basicSimpleEdge.getSource());
		Node mergedTargetNode = oldNode2mergedNode.get(basicSimpleEdge.getTarget());
		assert (mergedSourceNode != null) && (mergedTargetNode != null);
		EdgeRole edgeRole = null;
		List<@NonNull Edge> oldEdges = oldEdge2oldEdges.get(basicSimpleEdge);
		assert oldEdges != null;
		for (@NonNull Edge oldEdge : oldEdges) {
			EdgeRole edgeRole2 = oldEdge.getEdgeRole();
			edgeRole = edgeRole != null ? edgeRole.merge(edgeRole2) : edgeRole2;
		}
		assert edgeRole != null;
		return new BasicSimpleEdge(edgeRole, mergedRegion, mergedSourceNode, basicSimpleEdge.getName(), mergedTargetNode);
	}

	@Override
	public @NonNull Visitable visitSimpleNavigationEdge(@NonNull SimpleNavigationEdge simpleNavigationEdge) {
		Node mergedSourceNode = oldNode2mergedNode.get(simpleNavigationEdge.getSource());
		Node mergedTargetNode = oldNode2mergedNode.get(simpleNavigationEdge.getTarget());
		assert (mergedSourceNode != null) && (mergedTargetNode != null);
		EdgeRole edgeRole = null;
		List<@NonNull Edge> oldEdges = oldEdge2oldEdges.get(simpleNavigationEdge);
		assert oldEdges != null;
		for (@NonNull Edge oldEdge : oldEdges) {
			EdgeRole edgeRole2 = ((SimpleNavigationEdge)oldEdge).getEdgeRole();
			edgeRole = edgeRole != null ? edgeRole.merge(edgeRole2) : edgeRole2;
		}
		assert edgeRole != null;
		return new SimpleNavigationEdge((EdgeRole.Navigation)edgeRole, mergedRegion, mergedSourceNode, simpleNavigationEdge.getProperty(), mergedTargetNode);
	}

	@Override
	public @NonNull MappingRegion visitMappingRegion(@NonNull MappingRegion mappingRegion) {
		Set<@NonNull Node> toBeMergedNodes = new HashSet<>(primaryRegion.getNodes());
		toBeMergedNodes.removeAll(secondaryNode2primaryNode.values());
		toBeMergedNodes.addAll(secondaryRegion.getNodes());
		for (@NonNull Node toBeMergedNode : toBeMergedNodes) {
			toBeMergedNode.accept(this);
		}
		//
		//
		//
		Map<@NonNull Node, @NonNull Map<@NonNull Node, @NonNull List<@NonNull List<@NonNull Edge>>>> mergedSourceNode2mergedTargetNode2listOfOldEdges = new HashMap<>();
		for (@NonNull Edge oldEdge : primaryRegion.getEdges()) {
			if (!oldEdge.isRecursion()) {		// FIXME Remove this irregularity
				accumulateEdge(mergedSourceNode2mergedTargetNode2listOfOldEdges, oldEdge);
			}
		}
		for (@NonNull Edge oldEdge : secondaryRegion.getEdges()) {
			if (!oldEdge.isRecursion()) {		// FIXME Remove this irregularity
				accumulateEdge(mergedSourceNode2mergedTargetNode2listOfOldEdges, oldEdge);
			}
		}
		for (@NonNull Map<@NonNull Node, @NonNull List<@NonNull List<@NonNull Edge>>> mergedTargetNode2listOfOldEdges : mergedSourceNode2mergedTargetNode2listOfOldEdges.values()) {
			for (@NonNull List<@NonNull List<@NonNull Edge>> listOfOldEdges : mergedTargetNode2listOfOldEdges.values()) {
				assert listOfOldEdges != null;
				for (@NonNull List<@NonNull Edge> oldEdges : listOfOldEdges) {
					createMergedEdge(oldEdges);
				}
			}
		}
		checkNodes(primaryRegion);
		checkNodes(secondaryRegion);
		checkEdges(primaryRegion);
		checkEdges(secondaryRegion);
		return mergedRegion;
	}

	@Override
	public @NonNull SimpleTypedNode visitSimpleTypedNode(@NonNull SimpleTypedNode simpleTypedNode) {
		NodeRole nodeRole = simpleTypedNode.getNodeRole();
		Node primaryNode = secondaryNode2primaryNode.get(simpleTypedNode);
		if (primaryNode != null) {
			nodeRole = nodeRole.merge(primaryNode.getNodeRole());
		}
		SimpleTypedNode mergedNode = new SimpleTypedNode(nodeRole, mergedRegion, simpleTypedNode.getName(), simpleTypedNode.getClassDatumAnalysis());
		oldNode2mergedNode.put(simpleTypedNode, mergedNode);
		for (@NonNull TypedElement typedElement : simpleTypedNode.getTypedElements()) {
			mergedNode.addTypedElement(typedElement);
		}
		if (primaryNode != null) {
			oldNode2mergedNode.put(primaryNode, mergedNode);
			for (@NonNull TypedElement typedElement : primaryNode.getTypedElements()) {
				mergedNode.addTypedElement(typedElement);
			}
		}
		return mergedNode;
	}

	@Override
	public @NonNull SimpleVariableNode visitSimpleVariableNode(@NonNull SimpleVariableNode simpleVariableNode) {
		NodeRole nodeRole = simpleVariableNode.getNodeRole();
		Node primaryNode = secondaryNode2primaryNode.get(simpleVariableNode);
		if (primaryNode != null) {
			nodeRole = nodeRole.merge(primaryNode.getNodeRole());
		}
		@NonNull VariableDeclaration variableDeclaration = (VariableDeclaration)simpleVariableNode.getTypedElements().iterator().next();
		SimpleVariableNode mergedNode = new SimpleVariableNode(nodeRole, mergedRegion, variableDeclaration);
		oldNode2mergedNode.put(simpleVariableNode, mergedNode);
		for (@NonNull TypedElement typedElement : simpleVariableNode.getTypedElements()) {
			mergedNode.addTypedElement(typedElement);
		}
		if (primaryNode != null) {
			oldNode2mergedNode.put(primaryNode, mergedNode);
			for (@NonNull TypedElement typedElement : primaryNode.getTypedElements()) {
				mergedNode.addTypedElement(typedElement);
			}
		}
		return mergedNode;
	}
}
