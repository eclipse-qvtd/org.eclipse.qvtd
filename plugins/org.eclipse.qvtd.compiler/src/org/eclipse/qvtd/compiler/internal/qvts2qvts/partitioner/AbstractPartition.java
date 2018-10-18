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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;
import com.google.common.collect.Iterables;

public abstract class AbstractPartition implements Partition
{
	protected final @NonNull String name;
	private @Nullable String symbolName = null;

	/**
	 * The pass numbers in the overall schedule at which this partition can be executed. The first pass is the pass at which ALL
	 * invocations occur. Subsequent passes are when a referenced value may become available enabling a deferred execution.
	 */
	private final @NonNull List<@NonNull Integer> passes = new ArrayList<>();

	protected AbstractPartition(@NonNull String name) {
		this.name = name;
	}

	@Override
	public void addEnforcedEdge(@NonNull NavigableEdge usedEdge) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public boolean addPass(int passNumber) {
		if (passes.size() > 0) {
			assert passNumber > passes.get(0);		// Should not move earlier, or repeatedly first
		}
		for (int i = 0; i < passes.size(); i++) {
			Integer aPassNumber = passes.get(i);
			if (passNumber == aPassNumber) {
				return false;
			}
			if (passNumber < aPassNumber) {
				passes.add(i, passNumber);
				return true;
			}
		}
		passes.add(passNumber);
		return true;
	}

	@Override
	public void buildNavigationEdgesIndex(
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public void computeCheckedOrEnforcedEdges(
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME

	}

	protected void computeSymbolName(@NonNull SymbolNameBuilder sIn) {
		SymbolNameBuilder s = null;
		//		List<String> names = new ArrayList<>();
		//		for (@NonNull MappingAction action : getMappingActions()) {
		//			names.add(action.getMapping().getName());
		//		}
		//		Collections.sort(names);
		Set<@NonNull Node> bestToOneSubRegion = null;
		Node bestNamingNode = null;
		int bestToOneSubRegionSize = 0;
		for (@NonNull Node node : getHeadNodes()) {
			if (node.isOld() && !node.isConstant()) {
				bestNamingNode = node;
				break;
			}
		}
		if (bestNamingNode == null) {
			for (@NonNull Node node : getPartialNodes()) {
				if (node.isNew() || node.isPredicated() || node.isSpeculated()) {
					Set<@NonNull Node> toOneSubRegion = computeToOneSubRegion(new HashSet<>(), node);
					int toOneSubRegionSize = toOneSubRegion.size();
					Boolean isBetter = null;
					if ((bestToOneSubRegion == null) || (bestNamingNode == null)) {
						isBetter = true;
					}
					else if (toOneSubRegionSize > bestToOneSubRegionSize) {
						isBetter = true;
					}
					else if (toOneSubRegionSize < bestToOneSubRegionSize) {
						isBetter = false;
					}
					else if (node.isNew() && !bestNamingNode.isNew()) {
						isBetter = true;
					}
					else {
						int bestRealizedNavigationEdgesSize = Iterables.size(bestNamingNode.getRealizedNavigationEdges());
						int realizedNavigationEdgesSize = Iterables.size(node.getRealizedNavigationEdges());
						if (realizedNavigationEdgesSize > bestRealizedNavigationEdgesSize) {
							isBetter = true;
						}
						else if (realizedNavigationEdgesSize < bestRealizedNavigationEdgesSize) {
							isBetter = false;
						}
						else {
							int diff = ClassUtil.safeCompareTo(bestNamingNode.getCompleteClass().getName(), node.getCompleteClass().getName());
							if (diff > 0) {
								isBetter = true;
							}
							else if (diff < 0) {
								isBetter = false;
							}
						}
					}
					if (isBetter == Boolean.TRUE) {
						bestToOneSubRegion = toOneSubRegion;
						bestToOneSubRegionSize = toOneSubRegionSize;
						bestNamingNode = node;
					}
				}
			}
		}
		if (bestNamingNode != null) {
			List<@NonNull String> edgeNames = new ArrayList<>();
			for (@NonNull NavigableEdge edge : bestNamingNode.getRealizedNavigationEdges()) {
				String name = PivotUtil.getName(QVTscheduleUtil.getProperty(edge));
				edgeNames.add(name);
			}
			if (edgeNames.size() > 0) {
				s = sIn;
				s.appendName(bestNamingNode.getCompleteClass().getName());
				Collections.sort(edgeNames);
				for (@NonNull String edgeName : edgeNames) {
					s.appendString("_");
					s.appendString(edgeName);
				}
			}
			else {
				for (@NonNull Edge edge : getPartialEdges()) {
					if (edge.isNavigation() && isRealized(edge)) {
						NavigableEdge navigableEdge = (org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge) edge;
						String name = PivotUtil.getName(QVTscheduleUtil.getProperty(navigableEdge));
						edgeNames.add(name);
					}
				}
				if (edgeNames.size() > 0) {
					s = sIn;
					s.appendName(bestNamingNode.getCompleteClass().getName());
					s.appendString("_");
					Collections.sort(edgeNames);
					for (@NonNull String edgeName : edgeNames) {
						s.appendString("_");
						s.appendString(edgeName);
					}
				}
			}
		}
		if ((s == null) && (bestNamingNode != null)) {
			s = sIn;
			//			s.appendString(getSymbolNamePrefix());
			s.appendName(bestNamingNode.getCompleteClass().getName());
			List<@NonNull String> headNames = new ArrayList<>();
			for (@NonNull Node headNode : getHeadNodes()) {
				String name = headNode.getCompleteClass().getName();
				if (name != null) {
					headNames.add(name);
				}
			}
			for (@NonNull String headName : headNames) {
				s.appendString("_");
				s.appendString(headName);
			}
		}
		if (s == null) {
			for (@NonNull Node headNode : getHeadNodes()) {
				s = sIn;
				//				s.appendString(getSymbolNamePrefix());
				s.appendName(headNode.getCompleteClass().getName());
				List<@NonNull String> edgeNames = new ArrayList<>();
				for (@NonNull NavigableEdge edge : headNode.getNavigableEdges()) {
					String propertyName = PivotUtil.getName(QVTscheduleUtil.getProperty(edge));
					edgeNames.add(edge.getEdgeTarget().isNullLiteral() ? propertyName + "0" : propertyName);
				}
				Collections.sort(edgeNames);
				for (@NonNull String edgeName : edgeNames) {
					s.appendString("_");
					s.appendName(edgeName);
				}
				break;
			}
		}
	}

	private @NonNull Set<@NonNull Node> computeToOneSubRegion(@NonNull Set<@NonNull Node> toOneSubRegion, @NonNull Node atNode) {
		if (toOneSubRegion.add(atNode)) {
			for (@NonNull NavigableEdge edge : atNode.getNavigableEdges()) {
				assert edge.getEdgeSource() == atNode;
				Property source2target = edge.getProperty();
				if (!source2target.isIsMany() && !source2target.isIsImplicit()) {
					computeToOneSubRegion(toOneSubRegion, edge.getEdgeTarget());
				}
			}
		}
		return toOneSubRegion;
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @Nullable Set<@NonNull NavigableEdge> getCheckedEdges(@NonNull TypedModel typedModel) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull String getColor() {
		return QVTscheduleConstants.REGION_COLOR;
	}

	@Override
	public @Nullable Iterable<@NonNull NavigableEdge> getEnforcedEdges(@NonNull TypedModel typedModel, @NonNull Property asProperty) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @Nullable Iterable<@NonNull Partition> getExplicitPredecessors() {
		return null;
	}

	@Override
	public int getFirstPass() {
		int size = passes.size();
		assert size > 0;
		return passes.get(0);
	}

	@Override
	public @NonNull String getGraphName() {
		return name;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getHeadNodes() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public int getLastPass() {
		assert passes.size() > 0;
		return passes.get(passes.size()-1);
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @NonNull MappingRegion getMicroMappingRegion() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPartialNodes() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull String getPassRangeText() {
		return getFirstPass() + ".." + getLastPass();
	}

	@Override
	public @NonNull List<@NonNull Integer> getPasses() {
		return passes;
	}

	@Override
	public @Nullable String getPassesText() {
		StringBuilder s = null;
		for (@NonNull Integer pass : passes) {
			if (s == null) {
				s = new StringBuilder();
			}
			else {
				s.append(",");
			}
			s.append(pass.toString());
		}
		return s != null ? s.toString() : null;
	}

	@Override
	public @NonNull ReachabilityForest getReachabilityForest() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Region getRegion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @Nullable Role getRole(@NonNull Edge edge) {
		if (QVTscheduleUtil.getOwningRegion(QVTscheduleUtil.getTargetNode(edge)) != getRegion()) {
			return null;
		}
		else {
			return edge.getEdgeRole();
		}
	}

	@Override
	public @Nullable Role getRole(@NonNull Node node) {
		if (QVTscheduleUtil.getOwningRegion(node) != getRegion()) {
			return null;
		}
		else {
			return node.getNodeRole();
		}
	}

	@Override
	public final @NonNull String getSymbolName() {
		String symbolName2 = symbolName;
		if (symbolName2 == null) {
			SymbolNameBuilder s1 = new SymbolNameBuilder(0);			// No limit
			SymbolNameBuilder s2 = new SymbolNameBuilder(50);			// 50 character inner limit
			computeSymbolName(s2);
			s1.appendString(getSymbolNamePrefix());
			s1.appendString(s2.toString());
			s1.appendString(String.valueOf(getSymbolNameSuffix()));
			ScheduleModel scheduleModel = QVTscheduleUtil.basicGetContainingScheduleModel(getRegion());
			if (scheduleModel != null) {
				symbolName2 = scheduleModel.reserveSymbolName(s1, this);
				//				System.out.println("Reserved '" + symbolName2 + "' for " + this);
			}
			else {
				symbolName2 = s1.toString();
				System.err.println("Failed to reserve '" + symbolName2 + "' for " + this);
			}
			symbolName = symbolName2;
			//			if ((symbolName != null) && symbolName.contains("mTmapIfExp__DmapOclExpression_d2qvtrExpression_glob")) {
			//				getClass().toString();
			//			}
		}
		return symbolName2;
	}

	protected @NonNull String getSymbolNamePrefix() {
		return QVTscheduleConstants.REGION_SYMBOL_NAME_PREFIX;
	}

	protected String getSymbolNameSuffix() {
		return QVTscheduleConstants.REGION_SYMBOL_NAME_SUFFIX;
	}

	@Override
	public boolean isHead(@NonNull ConnectionEnd connectionEnd) {
		return Iterables.contains(getHeadNodes(), connectionEnd);
	}

	@Override
	public void setPass(int pass) {
		assert passes.isEmpty();
		addPass(pass);
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull String toString() {
		return name;
	}
}