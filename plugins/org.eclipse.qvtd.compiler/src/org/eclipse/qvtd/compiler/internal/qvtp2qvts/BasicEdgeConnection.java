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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;

import com.google.common.collect.Lists;

/**
 * A RegionConnection supports a dependency between regions..
 */
public class BasicEdgeConnection extends AbstractConnection<@NonNull NavigationEdge> implements EdgeConnection
{
	protected final @NonNull Property property;

	public BasicEdgeConnection(@NonNull ScheduledRegion region, @NonNull Set<@NonNull NavigationEdge> sourceEdges, @NonNull SymbolNameBuilder symbolNameBuilder, @NonNull Property property) {
		super(region, sourceEdges, symbolNameBuilder);
		this.property = property;
		assert !property.isIsImplicit();
		region.addEdgeConnection(this);
		for (@NonNull NavigationEdge sourceEdge : sourceEdges) {
			sourceEdge.addOutgoingConnection(this);
		}
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitBasicEdgeConnection(this);
	}

	@Override
	public void addUsedTargetEdge(@NonNull NavigationEdge targetEdge, boolean mustBeLater) {
		//		if (getSourceRegions().contains(targetEdge.getRegion())) {
		//			System.out.println("Cyclic dependency arbitrarily ignored: " + this);
		//			mergeRole(Connections.PREFERRED_EDGE);
		//			return;
		//		}
		mergeRole(mustBeLater ? Connections.MANDATORY_EDGE : Connections.PREFERRED_EDGE);
		assert !targetEnd2role.containsKey(targetEdge);
		targetEnd2role.put(targetEdge, mustBeLater ? Connections.MANDATORY_EDGE : Connections.PREFERRED_EDGE);
		targetEdge.addIncomingConnection(this);
		//		assert Sets.intersection(getSourceRegions(), getTargetRegions()).isEmpty();
	}

	@Override
	public void destroy() {
		for (@NonNull NavigationEdge sourceEdge : sourceEnds) {
			sourceEdge.removeOutgoingConnection(this);
		}
		for (@NonNull NavigationEdge targetNode : targetEnd2role.keySet()) {
			targetNode.removeIncomingConnection(this);
		}
		super.destroy();
	}

	@Override
	public @NonNull Property getProperty() {
		return property;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getSourceNodes() {
		List<@NonNull Node> sourceNodes = new ArrayList<@NonNull Node>();
		for (@NonNull NavigationEdge sourceEdge : sourceEnds) {
			sourceNodes.add(sourceEdge.getSource());
		}
		return sourceNodes;
	}

	@Override
	public @NonNull Iterable<@NonNull NavigationEdge> getTargetEdges() {
		return targetEnd2role.keySet();
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getTargetNodes() {
		List<@NonNull Node> targetNodes = new ArrayList<@NonNull Node>();
		for (@NonNull NavigationEdge targetEdge : targetEnd2role.keySet()) {
			targetNodes.add(targetEdge.getTarget());
		}
		return targetNodes;
	}

	@Override
	public @NonNull Map<@NonNull NavigationEdge, @NonNull ConnectionRole> getTargets() {
		return targetEnd2role;
	}

	/*	@Override
	public @NonNull Type getType(@NonNull IdResolver idResolver) {
//		System.out.println("commonType of " + this);
		Type commonType = null;
		for (@NonNull Node node : getSources()) {
			Type nodeType = node.getCompleteClass().getPrimaryClass();
//			System.out.println("  nodeType " + nodeType);
			if (!(nodeType instanceof CollectionType)) {		// RealizedVariable accumulated on Connection
				CompleteEnvironment environment = idResolver.getEnvironment();
				nodeType = isOrdered() ? environment.getOrderedSetType(nodeType, true, null, null) : environment.getSetType(nodeType, true, null, null);
			}
			if (commonType == null) {
				commonType = nodeType;
			}
			else {
				commonType = commonType.getCommonType(idResolver, nodeType);
			}
		}
//		System.out.println("=> " + commonType);
		assert commonType != null;
		return commonType;
	} */

	public boolean isEdge2Edge() {
		return (sourceEnds.size() == 1) && (targetEnd2role.size() == 1);
	}

	//	@Override
	//	public boolean isInput() {
	//		return false;
	//	}

	@Override
	public boolean isMandatory() {
		return false;
	}

	//	@Override
	//	public boolean isOutput() {
	//		return false;
	//	}

	@Override
	public boolean isPassed() {
		return false;
	}

	@Override
	public boolean isPassed(@NonNull Region targetRegion) {
		return false;
	}

	/*	@Override
	public void removeSource(@NonNull Node sourceNode) {
		boolean wasRemoved = sourceNodes.remove(sourceNode);
		assert wasRemoved;
	}

	@Override
	public void removeTarget(@NonNull Node targetNode) {
		ConnectionRole oldRole = targetNode2role.remove(targetNode);
		assert oldRole != null;
	} */

	private void removeTarget(@NonNull NavigationEdge targetEdge) {
		ConnectionRole oldRole = targetEnd2role.remove(targetEdge);
		assert oldRole != null;
	}

	@Override
	public void removeTargetRegion(@NonNull Region targetRegion) {
		for (@NonNull NavigationEdge targetEdge : Lists.newArrayList(getTargetEdges())) {
			if (targetEdge.getRegion() == targetRegion) {
				targetEdge.removeIncomingConnection(this);
				removeTarget(targetEdge);
			}
		}
		if (targetEnd2role.isEmpty()) {
			destroy();
		}
	}

	@Override
	public void toCallGraph(@NonNull GraphStringBuilder s) {
		/*		if (isNode2Node()) {
			s.appendNode(this);
//			@SuppressWarnings("null")@NonNull Node sourceNode = sourceNodes.iterator().next();
//			@SuppressWarnings("null")@NonNull Node targetNode = targetNode2role.keySet().iterator().next();
//			s.appendEdge(sourceNode, this, targetNode);
		}
		else {
			s.appendNode(this);
//			for (@SuppressWarnings("null")@NonNull Node source : getSources()) {
//				s.appendEdge(source, this, this);
//			}
//			for (@SuppressWarnings("null")@NonNull Node target : getTargets()) {
//				@SuppressWarnings("null")@NonNull ConnectionRole role = targetNode2role.get(target);
//				s.appendEdge(this, role, target);
//			}
		} */
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		if (isEdge2Edge()) {
			NavigationEdge sourceEdge = sourceEnds.iterator().next();
			NavigationEdge targetEdge = targetEnd2role.keySet().iterator().next();
			s.appendEdge(sourceEdge.getTarget(), this, targetEdge.getTarget());
		}
		else {
			s.appendNode(this);
			for (@NonNull NavigationEdge source : getSources()) {
				s.appendEdge(source.getTarget(), this, this);
			}
			for (@NonNull NavigationEdge target : getTargetEdges()) {
				ConnectionRole role = targetEnd2role.get(target);
				assert role != null;
				s.appendEdge(this, role, target.getTarget());
			}
		}
	}
}