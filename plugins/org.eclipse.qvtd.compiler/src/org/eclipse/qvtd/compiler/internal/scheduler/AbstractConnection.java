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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder.GraphNode;

/**
 * AbstractConnection.
 */
public abstract class AbstractConnection<CE extends ConnectionEnd> implements DatumConnection, GraphStringBuilder.GraphEdge, GraphStringBuilder.GraphNode
{
	protected final @NonNull ScheduledRegion region;
	protected final @NonNull String name;
	private /*@LazyNonNull*/ ConnectionRole connectionRole;
	protected @NonNull Set<@NonNull CE> sourceEnds;
	protected @NonNull Map<@NonNull CE, @NonNull ConnectionRole> targetEnd2role = new HashMap<@NonNull CE, @NonNull ConnectionRole>();
	
	/**
	 * The indexes in the overall schedule at which this connection propagates additional values.
	 */
	private @Nullable List<@NonNull Integer> indexes = null;

	protected AbstractConnection(@NonNull ScheduledRegion region, @NonNull Set<@NonNull CE> sourceEnds, @NonNull SymbolNameBuilder symbolNameBuilder) {
		this.region = region;
		this.name = region.getSchedulerConstants().reserveSymbolName(symbolNameBuilder, this);
		this.sourceEnds = sourceEnds;
	}
	
	@Override
	public boolean addIndex(int index) {
		List<@NonNull Integer> indexes2 = indexes;
		if (indexes2 == null) {
			indexes = indexes2 = new ArrayList<@NonNull Integer>();
		}
		for (int i = 0; i < indexes2.size(); i++) {
			Integer anIndex = indexes2.get(i);
			if (index == anIndex) {
				return false;
			}
			if (index < anIndex) {
				indexes2.add(i, index);
				return true;
			}
		}
		indexes2.add(index);
		return true;
	}

	@Override
	public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
		s.setColor(getColor());
/*		if (isRegion2Region()) {
			String indexText = getIndexText();
			if (indexText != null) {
				s.setLabel(indexText);
			}
		} */
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

	protected @Nullable ConnectionRole basicGetConnectionRole() {
		return connectionRole;
	}

	@Override
	public void destroy() {
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

	public @NonNull ConnectionRole getConnectionRole(@NonNull CE targetEnd) {
		ConnectionRole connectionRole = targetEnd2role.get(targetEnd);
		assert connectionRole != null;
		return connectionRole;
	}

	@Override
	public @NonNull ConnectionRole getConnectionRole() {
		assert connectionRole != null;
		return connectionRole;
	}

//	@Override
	public @Nullable String getIndexText() {
		List<@NonNull Integer> indexes2 = indexes;
		if (indexes2 == null) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		for (@NonNull Integer index : indexes2) {
			if (s.length() > 0) {
				s.append(",");
			}
			s.append(index.toString());
		}
		return s.toString();
	}

	@Override
	public @Nullable List<@NonNull Integer> getIndexes() {
		return indexes;
	}

	@Override
	public @NonNull String getLabel() {
		return name;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	public @NonNull Integer getPenwidth() {
		Integer penwidth = getConnectionRole().getPenwidth();
		return /*connectionRole.isRealized() ? 2*penwidth :*/ penwidth;
	}

	@Override
	public @NonNull ScheduledRegion getRegion() {
		return region;
	}

	public @NonNull String getShape() {
		return "ellipse";
	}

	@Override
	public @NonNull GraphNode getSource() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CE getSource(@NonNull Region sourceRegion) {
		@Nullable CE sourceEnd = null;
		for (@NonNull CE end : sourceEnds) {
			if (end.getRegion() == sourceRegion) {
				assert sourceEnd == null;
				sourceEnd = end;
			}
		}
		assert sourceEnd != null;
		return sourceEnd;
	}

	@Override
	public @NonNull String getSourceDisplayNames() {
		StringBuilder s = new StringBuilder();
		for (@NonNull CE source : getSources()) {
			if (s.length() > 0) {
				s.append(",");
			}
			s.append(source.getDisplayName());
		}
		return s.toString();
	}

	@Override
	public @NonNull Set<@NonNull Region> getSourceRegions() {
		Set<@NonNull Region> sourceRegions = new HashSet<@NonNull Region>();
		for (@NonNull ConnectionEnd sourceEnd : getSources()) {
			Region sourceRegion = sourceEnd.getRegion();
			sourceRegions.add(sourceRegion);
		}
		return sourceRegions;
	}

	@Override
	public @NonNull Iterable<@NonNull Region> getSourceRegions(@NonNull ScheduledRegion scheduledRegion) {
		Set<@NonNull Region> sourceRegions = new HashSet<@NonNull Region>();
		for (@NonNull ConnectionEnd sourceEnd : getSources()) {
			Region sourceRegion = sourceEnd.getRegion();
			sourceRegion = scheduledRegion.getNormalizedRegion(sourceRegion);
			if (sourceRegion != null) {
				sourceRegions.add(sourceRegion);
			}
		}
		return sourceRegions;
	}

	@Override
	public @NonNull Iterable<@NonNull CE> getSources() {
		return sourceEnds;
	}

	public @Nullable String getStyle() {
		return getConnectionRole().getStyle();
	}

	@Override
	public @NonNull String getSymbolName() {
		return name;
	}

	@Override
	public @NonNull GraphNode getTarget() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CE getTarget(@NonNull Region targetRegion) {
		@Nullable CE targetEnd = null;
		for (@NonNull CE end : targetEnd2role.keySet()) {
			if (end.getRegion() == targetRegion) {
				assert targetEnd == null;
				targetEnd = end;
			}
		}
		assert targetEnd != null;
		return targetEnd;
	}

	@Override
	public @NonNull Set<@NonNull Region> getTargetRegions() {
		Set<@NonNull Region> targetRegions = new HashSet<@NonNull Region>();
		for (@NonNull ConnectionEnd targetEnd : getTargets().keySet()) {
			Region targetRegion = targetEnd.getRegion();
			targetRegions.add(targetRegion);
		}
		return targetRegions;
	}

	@Override
	public @NonNull Iterable<@NonNull Region> getTargetRegions(@NonNull ScheduledRegion scheduledRegion) {
		Set<@NonNull Region> targetRegions = new HashSet<@NonNull Region>();
		for (@NonNull ConnectionEnd targetEnd : getTargets().keySet()) {
			Region targetRegion = targetEnd.getRegion();
			targetRegion = scheduledRegion.getNormalizedRegion(targetRegion);
			if (targetRegion != null) {
				targetRegions.add(targetRegion);
			}
		}
		return targetRegions;
	}

	@Override
	public @NonNull Map<@NonNull ? extends ConnectionEnd, @NonNull ConnectionRole> getTargets() {
		return targetEnd2role;
	}

//	private boolean isRegion2Region() {
//		return isRegion2Region(getSourceRegion2count());
//	}

	private boolean isRegion2Region(@NonNull Map<Region, Integer> sourceRegion2count, @NonNull Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles) {
		return (sourceRegion2count.size() == 1) && (targetRegion2roles.size() == 1) && (targetRegion2roles.values().iterator().next().size() == 1); //(targetEnd2role.size() == 1);
	}

	protected void mergeRole(@NonNull ConnectionRole connectionRole) {
		if (this.connectionRole == null) {
			this.connectionRole = connectionRole;
		}
		else if (this.connectionRole != connectionRole) {
			this.connectionRole = this.connectionRole.merge(connectionRole);
		}
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.appendEdge(getSource(), this, getTarget());
	}

	@Override
	public void toRegionGraph(@NonNull ScheduledRegion scheduledRegion, @NonNull GraphStringBuilder s) {
		Map<@NonNull Region, @NonNull Integer> sourceRegion2count = new HashMap<@NonNull Region, @NonNull Integer>();
		for (@NonNull Node source : getSourceNodes()) {
			Region sourceRegion = scheduledRegion.getNormalizedRegion(source.getRegion());
			if (sourceRegion != null) {
//				Integer count = sourceRegion2count.get(sourceRegion);
				sourceRegion2count.put(sourceRegion, 1); //(count != null ? count.intValue() : 0) + 1);
			}
		}
		Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles = new HashMap<@NonNull Region, @NonNull List<@NonNull ConnectionRole>>();
		for (@NonNull ConnectionEnd target : targetEnd2role.keySet()) {
			ConnectionRole role = targetEnd2role.get(target);
			assert role != null;
			Region targetRegion = scheduledRegion.getNormalizedRegion(target.getRegion());
			if (targetRegion != null) {
				List<@NonNull ConnectionRole> roles = targetRegion2roles.get(targetRegion);
				if (roles == null) {
					roles = new ArrayList<@NonNull ConnectionRole>();
					targetRegion2roles.put(targetRegion, roles);
				}
				if (!roles.contains(role)) {
					roles.add(role);
				}
			}
		}
		if (isRegion2Region(sourceRegion2count, targetRegion2roles)) {
			Region sourceRegion = sourceRegion2count.keySet().iterator().next();
			Region targetRegion = targetRegion2roles.keySet().iterator().next();
			s.appendEdge(sourceRegion, this, targetRegion);
		}
		else {
			s.appendNode(this);
			for (@NonNull Region sourceRegion : sourceRegion2count.keySet()) {
				Integer counts = sourceRegion2count.get(sourceRegion);
				assert counts != null;
				for (int i = counts; i > 0; i--) {
					s.appendEdge(sourceRegion, this, this);
				}
			}
			for (@NonNull Region targetRegion : targetRegion2roles.keySet()) {
				List<@NonNull ConnectionRole> roles = targetRegion2roles.get(targetRegion);
				assert roles != null;
				for (@NonNull ConnectionRole role : roles) {
					s.appendEdge(this, role, targetRegion);
//				GraphNode targetNode = /*targetRegion.isCyclicRegion() ? getTarget(targetRegion) :*/ targetRegion;
//				for (@SuppressWarnings("null")@NonNull ConnectionRole role : targetRegion2roles.get(targetRegion)) {
//					s.appendEdge(this, role, targetNode);
				}
			}
			Node headNode = null;
			if (sourceRegion2count.size() == 0) {
/*				@Nullable ConnectionEnd targetEnd = null;
				for (@NonNull ConnectionEnd end : targetEnd2role.keySet()) {
					if (end.getRegion() == scheduledRegion) {
						assert targetEnd == null;
						targetEnd = end;
					}
				}
				if (targetEnd instanceof Node) {
					Node node = (Node)targetEnd;
					if (node.isHead()) {
						headNode = node;
						s.appendEdge(headNode, this, this);
					}
				} */
				@Nullable ConnectionEnd sourceEnd = null;
				for (@NonNull ConnectionEnd end : sourceEnds) {
					if (end.getRegion() == scheduledRegion) {
						assert sourceEnd == null;
						sourceEnd = end;
					}
				}
				if (sourceEnd instanceof Node) {
					Node node = (Node)sourceEnd;
					if (node.isHead()) {
						headNode = node;
						s.appendEdge(headNode, this, this);
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return getSymbolName();
    }
	
	public String toString2() {
		StringBuilder s = new StringBuilder();
		ConnectionRole connectionRole = basicGetConnectionRole();
		if (connectionRole != null) {
			s.append(connectionRole);
		}
		s.append(getName());
		s.append("(");
		boolean isFirst = true;
		for (@NonNull ConnectionEnd sourceEnd : sourceEnds) {
			if (!isFirst) {
				s.append(",");
			}
			s.append(sourceEnd.getDisplayName());
			isFirst = false;
		}
		s.append(" => ");
		isFirst = true;
		for (@NonNull ConnectionEnd targetEnd : targetEnd2role.keySet()) {
			if (!isFirst) {
				s.append(",");
			}
			ConnectionRole targetConnectionRole = targetEnd2role.get(targetEnd);
			s.append(targetConnectionRole);
			s.append(targetEnd.getDisplayName());
			isFirst = false;
		}
		s.append(")");
        return s.toString();
    }
}