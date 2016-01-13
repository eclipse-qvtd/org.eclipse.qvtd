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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.qvtd.pivot.schedule.utilities.DOTStringBuilder;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder.GraphNode;

/**
 * AbstractEdge.
 */
public abstract class AbstractConnection implements Connection, GraphStringBuilder.GraphEdge, GraphStringBuilder.GraphNode
{
	private /*@LazyNonNull*/ ConnectionRole connectionRole;
	protected final @NonNull ScheduledRegion region;
	private @NonNull Set<Node> sourceNodes;
	private @NonNull Map<Node, @NonNull ConnectionRole> targetNode2role = new HashMap<Node, @NonNull ConnectionRole>();
	protected final @Nullable String name;

	protected AbstractConnection(@NonNull ScheduledRegion region, @NonNull Set<Node> sourceNodes, @NonNull String name) {
		this.region = region;
		this.name = name;
		this.sourceNodes = sourceNodes;
		region.addConnection(this);
		for (@SuppressWarnings("null")@NonNull Node sourceNode : sourceNodes) {
			sourceNode.addOutgoingConnection(this);
		}
	}

	@Override
	public void addPassedTargetNode(@NonNull Node targetNode) {
		mergeRole(Connections.PASSED);
		assert !targetNode2role.containsKey(targetNode);
		targetNode2role.put(targetNode, Connections.PASSED);
		targetNode.addIncomingConnection(this);
	}

	@Override
	public void addUsedTargetNode(@NonNull Node targetNode, boolean mustBeLater) {
		mergeRole(mustBeLater ? Connections.MANDATORY : Connections.PREFERRED);
		assert !targetNode2role.containsKey(targetNode);
		targetNode2role.put(targetNode, mustBeLater ? Connections.MANDATORY : Connections.PREFERRED);
		targetNode.addIncomingConnection(this);
	}

	@Override
	public void appendEdgeAttributes(@NonNull GraphStringBuilder s) {
		s.setColor(getColor());
		if (isRegion2Region()) {
			String indexText = getIndexText();
			if (indexText != null) {
				s.setLabel(indexText);
			}
		}
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		String arrowhead = getArrowhead();
		if (arrowhead != null) {
			s.setArrowhead(arrowhead);
		}
		s.setPenwidth(getPenwidth());
		s.appendAttributedEdge(this);
	}

	@Override
	public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
		s.setColor(getColor());
		if (isRegion2Region()) {
			String indexText = getIndexText();
			if (indexText != null) {
				s.setLabel(indexText);
			}
		}
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		String arrowhead = getArrowhead();
		if (arrowhead != null) {
			s.setArrowhead(arrowhead);
		}
		s.setPenwidth(getPenwidth());
		s.appendAttributedEdge(source, this, target);
	}

	@Override
	public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
		String name = getName();
		String indexText = getIndexText();
		if (indexText != null) {
			name = name + "\\n " + indexText;
		}
		s.setLabel(name);
		s.setShape(getShape());
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		s.setColor(getColor());
		s.setPenwidth(getPenwidth());
		s.appendAttributedNode(nodeName);
	}

	@Override
	public @Nullable Node basicGetSource(@NonNull Region sourceRegion) {
		Node sourceNode = null;
		for (Node node : sourceNodes) {
			if (node.getRegion() == sourceRegion) {
				assert sourceNode == null;
				sourceNode = node;
			}
		}
		return sourceNode;
	}

	@Override
	public void destroy() {
		for (Node sourceNode : sourceNodes) {
			sourceNode.removeOutgoingConnection(this);
		}
		for (Node targetNode : targetNode2role.keySet()) {
			targetNode.removeIncomingConnection(this);
		}
		region.removeConnection(this);
	}

	@Override
	public String getArrowhead() {
		return getConnectionRole().getArrowhead();
	}

	@Override
	public @NonNull String getColor() {
		return getConnectionRole().getColor();
	}

	@Override
	public @NonNull ConnectionRole getConnectionRole() {
		assert connectionRole != null;
		return connectionRole;
	}

	@Override
	public @Nullable String getLabel() {
		return name;
	}

	@Override
	public @Nullable String getName() {
		return name;
	}

	public @NonNull Integer getPenwidth() {
		Integer penwidth = getConnectionRole().getPenwidth();
		return /*connectionRole.isRealized() ? 2*penwidth :*/ penwidth;
	}

//	@Override
//	public @NonNull Region getRegion() {
//		return region;
//	}

	public @NonNull String getShape() {
		return "ellipse";
	}

	@Override
	public @NonNull GraphNode getSource() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Node getSource(@NonNull Region sourceRegion) {
		Node sourceNode = null;
		for (Node node : sourceNodes) {
			if (node.getRegion() == sourceRegion) {
				assert sourceNode == null;
				sourceNode = node;
			}
		}
		assert sourceNode != null;
		return sourceNode;
	}

	@Override
	public @NonNull String getSourceDisplayNames() {
		StringBuilder s = new StringBuilder();
		for (Node source : getSources()) {
			if (s.length() > 0) {
				s.append(",");
			}
			s.append(source.getDisplayName());
		}
		return s.toString();
	}

	private @NonNull Map<Region, @NonNull Integer> getSourceRegion2count() {
		Map<Region, @NonNull Integer> sourceRegion2count = new HashMap<Region, @NonNull Integer>();
		for (@SuppressWarnings("null")@NonNull Node source : getSources()) {
			Region sourceRegion = source.getRegion();
			Integer count = sourceRegion2count.get(sourceRegion);
			sourceRegion2count.put(sourceRegion, count = (count != null ? count.intValue() : 0) + 1);
		}
		return sourceRegion2count;
	}

	@Override
	public @NonNull Iterable<Node> getSources() {
		return sourceNodes;
	}

	public @Nullable String getStyle() {
		return getConnectionRole().getStyle();
	}

	@Override
	public @NonNull GraphNode getTarget() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Node getTarget(@NonNull Region targetRegion) {
		Node targetNode = null;
		for (Node node : targetNode2role.keySet()) {
			if (node.getRegion() == targetRegion) {
				assert targetNode == null;
				targetNode = node;
			}
		}
		assert targetNode != null;
		return targetNode;
	}

	@Override
	public @NonNull Iterable<Node> getTargets() {
		return targetNode2role.keySet();
	}

	@Override
	public @NonNull Type getType(@NonNull IdResolver idResolver) {
//		System.out.println("commonType of " + this);
		Type commonType = null;
		for (Node node : getSources()) {
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
	}

	@Override
	public boolean isMandatory() {
		return getConnectionRole().isMandatory();
	}

	public boolean isNode2Node() {
		return (sourceNodes.size() == 1) && (targetNode2role.size() == 1);
	}

	/**
	 * Return true if this connections should be ordered since its source could be ordered.
	 */
	private boolean isOrdered() {
		boolean isOrdered = false;
		for (Node sourceNode1 : getSources()) {
			Region sourceRegion = sourceNode1.getRegion();
			for (Connection passedConnection : sourceRegion.getParentPassedConnections()) {
				for (Node sourceNode2 : passedConnection.getSources()) {
					Type sourceType2 = sourceNode2.getClassDatumAnalysis().getCompleteClass().getPrimaryClass();
					if ((sourceType2 instanceof CollectionType) && ((CollectionType)sourceType2).isOrdered()) {
						return true;
					}
				}
			}
		}
		return isOrdered;
	}

	@Override
	public boolean isPassed() {
		return getConnectionRole().isPassed();
	}

	@Override
	public boolean isPassed(@NonNull Region targetRegion) {
		for (Node targetNode : targetNode2role.keySet()) {
			if (targetNode.getRegion() == targetRegion) {
				ConnectionRole role = targetNode2role.get(targetNode);
				assert role != null;
				if (role.isPassed()) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isRegion2Region() {
		return isRegion2Region(getSourceRegion2count());
	}

	public boolean isRegion2Region(@NonNull Map<Region, Integer> sourceRegion2count) {
		return (sourceRegion2count.size() == 1) && (targetNode2role.size() == 1);
	}

	@Override
	public boolean isUsed() {
		return getConnectionRole().isPreferred();
	}

	@Override
	public boolean isUsed(@NonNull Node targetNode) {
		ConnectionRole targetConnectionRole = targetNode2role.get(targetNode);
		assert targetConnectionRole != null;
		return targetConnectionRole.isPreferred();
	}

	protected void mergeRole(@NonNull ConnectionRole connectionRole) {
		if (this.connectionRole == null) {
			this.connectionRole = connectionRole;
		}
		else if (this.connectionRole != connectionRole) {
			this.connectionRole = this.connectionRole.merge(connectionRole);
		}
	}

	public String toDOT() {
		DOTStringBuilder s = new DOTStringBuilder();
		toDOT(s);
		return s.toString();
	}

	public void toDOT(@NonNull DOTStringBuilder s) {
		s.appendEdge(this);
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		if (isNode2Node()) {
			@SuppressWarnings("null")@NonNull Node sourceNode = sourceNodes.iterator().next();
			@SuppressWarnings("null")@NonNull Node targetNode = targetNode2role.keySet().iterator().next();
			s.appendEdge(sourceNode, this, targetNode);
		}
		else {
			s.appendNode(this);
			for (@SuppressWarnings("null")@NonNull Node source : getSources()) {
				s.appendEdge(source, this, this);
			}
			for (@SuppressWarnings("null")@NonNull Node target : getTargets()) {
				ConnectionRole role = targetNode2role.get(target);
				assert role != null;
				s.appendEdge(this, role, target);
			}
		}
	}

	@Override
	public void toRegionGraph(@NonNull GraphStringBuilder s) {
		Map<Region, @NonNull Integer> sourceRegion2count = getSourceRegion2count();
		Map<Region, @NonNull List<ConnectionRole>> targetRegion2roles = new HashMap<Region, @NonNull List<ConnectionRole>>();
		for (@SuppressWarnings("null")@NonNull Node target : targetNode2role.keySet()) {
			ConnectionRole role = targetNode2role.get(target);
			Region targetRegion = target.getRegion();
			List<ConnectionRole> roles = targetRegion2roles.get(targetRegion);
			if (roles == null) {
				roles = new ArrayList<ConnectionRole>();
				targetRegion2roles.put(targetRegion, roles);
			}
			roles.add(role);
		}
		if (isRegion2Region(sourceRegion2count)) {
			@SuppressWarnings("null")@NonNull Region sourceRegion = sourceRegion2count.keySet().iterator().next();
			@SuppressWarnings("null")@NonNull Region targetRegion = targetRegion2roles.keySet().iterator().next();
			s.appendEdge(sourceRegion, this, targetRegion);
		}
		else {
			s.appendNode(this);
			for (@SuppressWarnings("null")@NonNull Region sourceRegion : sourceRegion2count.keySet()) {
				Integer counts = sourceRegion2count.get(sourceRegion);
				assert counts != null;
				for (int i = counts; i > 0; i--) {
					s.appendEdge(sourceRegion, this, this);
				}
			}
			for (@SuppressWarnings("null")@NonNull Region targetRegion : targetRegion2roles.keySet()) {
				List<ConnectionRole> roles = targetRegion2roles.get(targetRegion);
				assert roles != null;
				for (@SuppressWarnings("null")@NonNull ConnectionRole role : roles) {
					s.appendEdge(this, role, targetRegion);
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (connectionRole != null) {
			s.append(connectionRole);
		}
		s.append(getName());
		s.append("(");
		for (@SuppressWarnings("null")@NonNull Node sourceNode : sourceNodes) {
			s.append(sourceNode.getDisplayName());
			s.append(" ");
		}
		s.append("=>");
		for (@SuppressWarnings("null")@NonNull Node targetNode : targetNode2role.keySet()) {
			s.append(" ");
			ConnectionRole targetConnectionRole = targetNode2role.get(targetNode);
			s.append(targetConnectionRole);
			s.append(targetNode.getDisplayName());
		}
		s.append(")");
        return s.toString();
    }
}