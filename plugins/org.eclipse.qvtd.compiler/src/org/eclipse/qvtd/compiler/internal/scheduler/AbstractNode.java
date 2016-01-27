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
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage.Internal;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.schedule.utilities.DOTStringBuilder;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

import com.google.common.collect.Iterables;

/**
 * AbstractNode provides the analysis and status of a node in the pattern match or construction of a Mapping
 * or Composite Region.
 */
public abstract class AbstractNode implements Node
{
	public static final class NodeComparator implements Comparator<Node>
	{	
		public static final @NonNull NodeComparator INSTANCE = new NodeComparator();
	
		@Override
		public int compare(Node o1, Node o2) {
			String n1 = NameUtil.getSafeName(o1);
			String n2 = NameUtil.getSafeName(o2);
			int diff = ClassUtil.safeCompareTo(n1, n2);
			if (diff != 0) {
				return diff;
			}
			n1 = o1.getCompleteClass().getPrimaryClass().toString();
			n2 = o2.getCompleteClass().getPrimaryClass().toString();
			diff = ClassUtil.safeCompareTo(n1, n2);
			if (diff != 0) {
				return diff;
			}
			return diff;
		}
	}

	private @NonNull NodeRole nodeRole;
	protected final @NonNull Region region;
	protected final @NonNull String name;
	private @Nullable List<Connection> incomingConnections = null;
	private @Nullable List<Edge> incomingEdges = null;
	private @Nullable List<Connection> outgoingConnections = null;
	private @Nullable List<Edge> outgoingEdges = null;

	private @NonNull ClassDatumAnalysis classDatumAnalysis;

	protected AbstractNode(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		this.nodeRole = nodeRole;
		this.region = region;
		this.name = name;
		this.classDatumAnalysis = classDatumAnalysis;
		region.addNode(this);
	}

	@Override
	public void destroy() {
		region.removeNode(this);
		List<Connection> incomingConnections2 = incomingConnections;
		if (incomingConnections2 != null) {
			while (!incomingConnections2.isEmpty()) {
				incomingConnections2.get(0).destroy();
			}
		}
		List<Connection> outgoingConnections2 = outgoingConnections;
		if (outgoingConnections2 != null) {
			while (!outgoingConnections2.isEmpty()) {
				outgoingConnections2.get(0).destroy();
			}
		}
		List<Edge> incomingEdges2 = incomingEdges;
		if (incomingEdges2 != null) {
			while (!incomingEdges2.isEmpty()) {
				incomingEdges2.get(0).destroy();
			}
		}
		List<Edge> outgoingEdges2 = outgoingEdges;
		if (outgoingEdges2 != null) {
			while (!outgoingEdges2.isEmpty()) {
				outgoingEdges2.get(0).destroy();
			}
		}
	}

	@Override
	public final void addIncomingConnection(@NonNull Connection connection) {
		assert Iterables.contains(connection.getTargets(), this);
//		assert edge.getRegion() == getRegion();
		List<Connection> incomingConnections2 = incomingConnections;
		if (incomingConnections2 == null) {
			incomingConnections = incomingConnections2 = new ArrayList<Connection>();
		}
		else {
			assert !incomingConnections2.contains(connection);
		}
		incomingConnections2.add(connection);
	}

	@Override
	public final void addIncomingEdge(@NonNull Edge edge) {
		assert edge.getTarget() == this;
//		assert edge.getRegion() == getRegion();
		List<Edge> incomingEdges2 = incomingEdges;
		if (incomingEdges2 == null) {
			incomingEdges = incomingEdges2 = new ArrayList<Edge>();
		}
		else {
			assert !incomingEdges2.contains(edge);
		}
		incomingEdges2.add(edge);
	}

	@Override
	public final void addOutgoingConnection(@NonNull Connection connection) {
		assert Iterables.contains(connection.getSources(), this);
//		assert edge.getRegion() == getRegion();
		List<Connection> outgoingConnections2 = outgoingConnections;
		if (outgoingConnections2 == null) {
			outgoingConnections = outgoingConnections2 = new ArrayList<Connection>();
		}
		else {
			assert !outgoingConnections2.contains(connection);
		}
		outgoingConnections2.add(connection);
	}

	@Override
	public final void addOutgoingEdge(@NonNull Edge edge) {
		assert edge.getSource() == this;
//		assert edge.getRegion() == getRegion();
		List<Edge> outgoingEdges2 = outgoingEdges;
		if (outgoingEdges2 == null) {
			outgoingEdges = outgoingEdges2 = new ArrayList<Edge>();
		}
		else {
			assert !outgoingEdges2.contains(edge);
		}
		outgoingEdges2.add(edge);
	}

	@Override
	public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
		boolean isHead = isHead();
		if (isHead) {
			s.setHead();
//			s.append("{rank=source;");
		}
		setLabel(s);
		String shape = getShape();
		if (shape != null) {
			s.setShape(shape);
		}
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		s.setColor(getColor());
		s.setPenwidth(getPenwidth());
		s.appendAttributedNode(nodeName);
//		if (isHead) {
//			s.append("}");
//		}
	}

	@Override
	public void getAllAncestors(@NonNull Set<Node> ancestors) {
		if (ancestors.add(this)) {
			Region region = getRegion();
			for (List<Node> headGroup : region.getHeadNodeGroups()) {
				for (Node headNode : headGroup) {
					for (Node passedBindingSource : headNode.getPassedBindingSources()) {
						passedBindingSource.getAllAncestors(ancestors);
					}
				}
			}
		}
	}

	@Override
	public final @NonNull Iterable<Edge> getArgumentEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(getIncomingEdges(), AbstractRegion.IsExpressionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @Nullable Edge getAssignmentEdge(@NonNull Property source2targetProperty) {
		for (Edge edge : getOutgoingEdges()) {
			if (edge.isRealized() && (edge instanceof NavigationEdge)) {
				if (((NavigationEdge)edge).getProperty() == source2targetProperty) {
					return edge;
				}
			}
		}
		return null;
	}

	@SuppressWarnings("null")
	@Override
	public final @NonNull Iterable<NavigationEdge> getAssignmentEdges() {
		@SuppressWarnings("unchecked")
		Iterable<NavigationEdge> filter = (Iterable<NavigationEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsAssignmentEdgePredicate.INSTANCE);
		return filter;
	}

/*	@Override
	public @NonNull Node getCastEquivalentNode() {
		List<Edge> outgoingEdges = getOutgoingEdges();
		if ((outgoingEdges != null) && (outgoingEdges.size() == 1)) {
			Edge edge = outgoingEdges.get(0);
			if (edge.isCast()) {
				return edge.getTarget();
			}
		}
		return this;
	} */
	
	@Override
	public final @NonNull ClassDatumAnalysis getClassDatumAnalysis() {
		return classDatumAnalysis;
	}

	protected @NonNull String getColor() {
		return nodeRole.getColor();
	}

	@Override
	public @NonNull CompleteClass getCompleteClass() {
		return classDatumAnalysis.getCompleteClass();
	}

//	@Override
//	public @Nullable Edge getComposedOrderingEdge(@NonNull Node targetNode) {
//		for (Edge edge : getComposedOrderingEdges()) {
//			if (edge.getTarget() == targetNode) {
//				return edge;
//			}
//		}
//		return null;
//	}

//	@Override
//	public final @NonNull Iterable<Edge> getComposedOrderingEdges() {
//		@SuppressWarnings("null")
//		@NonNull Iterable<Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsComposedOrderingEdgePredicate.INSTANCE);
//		return filter;
//	}

	@Override
	public final @NonNull Iterable<Edge> getComputationEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsComputationEdgePredicate.INSTANCE);
		return filter;
	}

//	@Override
//	public @Nullable Edge getConsumedOrderingEdge(@NonNull Node targetNode) {
//		for (Edge edge : getConsumedOrderingEdges()) {
//			if (edge.getTarget() == targetNode) {
//				return edge;
//			}
//		}
//		return null;
//	}

//	@Override
//	public final @NonNull Iterable<Edge> getConsumedOrderingEdges() {
//		@SuppressWarnings("null")
//		@NonNull Iterable<Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsConsumedOrderingEdgePredicate.INSTANCE);
//		return filter;
//	}

	@SuppressWarnings("null")
	@Override
	public final @NonNull Iterable<NavigationEdge> getContainerEdges() {
		@SuppressWarnings("unchecked")
		Iterable<NavigationEdge> filter = (Iterable<NavigationEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsContainerEdgePredicate.INSTANCE);
		return filter;
	}

	@SuppressWarnings("null")
	@Override
	public final @NonNull Iterable<NavigationEdge> getContainmentEdges() {
		@SuppressWarnings("unchecked")
		Iterable<NavigationEdge> filter = (Iterable<NavigationEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsContainmentEdgePredicate.INSTANCE);
		return filter;
	}
	
	@Override
	public @NonNull String getDisplayName() {
		return region.getName() + "::" + getName();
	}

	@Override
	public final @NonNull List<Connection> getIncomingConnections() {
		return incomingConnections != null ? incomingConnections : SchedulerConstants.EMPTY_CONNECTION_LIST;
	}

	@Override
	public final @NonNull List<Edge> getIncomingEdges() {
		return incomingEdges != null ? incomingEdges : SchedulerConstants.EMPTY_EDGE_LIST;
	}

	@Override
	public final @NonNull Iterable<Connection> getIncomingPassedConnections() {
		@SuppressWarnings({"null"})
		@NonNull Iterable<Connection> filter = Iterables.filter(getIncomingConnections(), ScheduledRegion.IsPassedBindingEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull Iterable<Connection> getIncomingUsedConnections() {
		@SuppressWarnings({"null"})
		@NonNull Iterable<Connection> filter = Iterables.filter(getIncomingConnections(), ScheduledRegion.IsUsedBindingEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull String getLabel() {
		return getName();
	}

	@Override
	public final @NonNull Iterable<Edge> getMergeableEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsMergeableEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @Nullable NavigationEdge getNavigationEdge(@NonNull Property source2targetProperty) {
		for (Edge edge : getOutgoingEdges()) {
			if (edge instanceof NavigationEdge) {
				NavigationEdge navigationEdge = (NavigationEdge)edge;
				if (navigationEdge.getProperty() == source2targetProperty) {
					return navigationEdge;
				}
			}
		}
		return null;
	}

	@Override
	public final @NonNull Iterable<NavigationEdge> getNavigationEdges() {
		@SuppressWarnings({"null", "unchecked"})
		@NonNull Iterable<NavigationEdge> filter = (Iterable<NavigationEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @Nullable Node getNavigationTarget(@NonNull Property source2targetProperty) {
		for (Edge edge : getOutgoingEdges()) {
			if (edge instanceof NavigationEdge) {
				NavigationEdge navigationEdge = (NavigationEdge)edge;
				if (navigationEdge.getProperty() == source2targetProperty) {
					return navigationEdge.getTarget();
				}
			}
		}
		return null;
	}

	@Override
	public @NonNull Iterable<Node> getNavigationTargets() {
		@SuppressWarnings("null")@NonNull Iterable<Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsNavigationEdgePredicate.INSTANCE);
		@SuppressWarnings("null")@NonNull Iterable<Node> transform = Iterables.transform(filter, AbstractRegion.EdgeTargetFunction.INSTANCE);
		return transform;
	}

	@Override
	public @NonNull NodeRole getNodeRole() {
		return nodeRole;
	}

	@Override
	public final @NonNull List<Connection> getOutgoingConnections() {
		return outgoingConnections != null ? outgoingConnections : SchedulerConstants.EMPTY_CONNECTION_LIST;
	}

	@Override
	public final @NonNull List<Edge> getOutgoingEdges() {
		return outgoingEdges != null ? outgoingEdges : SchedulerConstants.EMPTY_EDGE_LIST;
	}

	@Override
	public final @NonNull Iterable<Connection> getOutgoingPassedConnections() {
		@SuppressWarnings({"null"})
		@NonNull Iterable<Connection> filter = Iterables.filter(getOutgoingConnections(), ScheduledRegion.IsPassedBindingEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<Connection> getOutgoingUsedBindingEdges() {
		@SuppressWarnings({"null"})
		@NonNull Iterable<Connection> filter = Iterables.filter(getOutgoingConnections(), ScheduledRegion.IsUsedBindingEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull Iterable<Node> getPassedBindingSources() {
		List<Node> sources = new ArrayList<Node>();
		for (Connection connection : getIncomingPassedConnections()) {
			for (Node source : connection.getSources()) {
				if (!sources.contains(source)) {
					sources.add(source);
				}
			}
		}
		return sources;
	}

	@Override
	public @NonNull Iterable<Node> getPassedBindingTargets() {
		List<Node> targets = new ArrayList<Node>();
		for (Connection connection : getOutgoingPassedConnections()) {
			for (Node target : connection.getTargets()) {
				if (!targets.contains(target)) {
					targets.add(target);
				}
			}
		}
		return targets;
	}

	protected @NonNull Integer getPenwidth() {
		return nodeRole.getPenwidth();
	}

	@SuppressWarnings("null")
	@Override
	public final @NonNull Iterable<NavigationEdge> getPredicateEdges() {
		@SuppressWarnings("unchecked")
		Iterable<NavigationEdge> filter = (Iterable<NavigationEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsPredicatedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<Edge> getRecursionEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsRecursionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull Iterable<Node> getRecursionSources() {
		@SuppressWarnings("null")@NonNull Iterable<Edge> filter = Iterables.filter(getIncomingEdges(), AbstractRegion.IsRecursionEdgePredicate.INSTANCE);
		@SuppressWarnings("null")@NonNull Iterable<Node> transform = Iterables.transform(filter, AbstractRegion.EdgeSourceFunction.INSTANCE);
		return transform;
	}

	@Override
	public @NonNull Iterable<Node> getRecursionTargets() {
		@SuppressWarnings("null")@NonNull Iterable<Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsRecursionEdgePredicate.INSTANCE);
		@SuppressWarnings("null")@NonNull Iterable<Node> transform = Iterables.transform(filter, AbstractRegion.EdgeTargetFunction.INSTANCE);
		return transform;
	}

	@Override
	public @NonNull Region getRegion() {
		return region;
	}

	@Override
	public @NonNull SchedulerConstants getSchedulerConstants() {
		return region.getSchedulerConstants();
	}

	protected @Nullable String getShape() {
		return nodeRole.getShape();
	}

	protected @Nullable String getStyle() {
		return nodeRole.getStyle();
	}

	@Override
	public @NonNull Iterable<Node> getUsedBindingSources() {
		List<Node> sources = new ArrayList<Node>();
		for (Connection connection : getIncomingUsedConnections()) {
			for (Node source : connection.getSources()) {
				if (!sources.contains(source)) {
					sources.add(source);
				}
			}
		}
		return sources;
	}

	@Override
	public final boolean isAttributeNode() {
//		boolean isAttributeNode1 = nodeRole.isAttributeNode();		// FIXME OperationNode
		boolean isAttributeNode2 = (classDatumAnalysis.getClassDatum().getType() instanceof DataType) && !isNull();
//		assert isAttributeNode1 == isAttributeNode2;
		return isAttributeNode2;
	}

//	@Override
//	public boolean isCast() {
//		return false;
//	}

	@Override
	public final boolean isClassNode() {
//		boolean isClassNode1 = nodeRole.isClassNode();		// FIXME OperationNode
		boolean isClassNode2 = !(classDatumAnalysis.getClassDatum().getType() instanceof DataType) && !isNull();
//		assert isClassNode1 == isClassNode2;
		return isClassNode2;
	}

	@Override
	public boolean isComposed() {
		return nodeRole.isComposed();
	}

	@Override
	public boolean isConstant() {
		return nodeRole.isConstant();
	}
	
	@Override
	public boolean isExpression() {
		return nodeRole.isExpression();
	}

	@Override
	public boolean isGuard() {
		return nodeRole.isGuardVariable() || nodeRole.isHead();
	}

	@Override
	public boolean isGuardVariable() {
		return nodeRole.isGuardVariable();
	}

	@Override
	public boolean isHead() {
		return nodeRole.isHead();
	}

	@Override
	public boolean isInternal() {
		return nodeRole.isInternal();
	}

	@Override
	public boolean isIterator() {
		return nodeRole.isIterator();
	}

	@Override
	public boolean isKnown() {
		return nodeRole.isConstant() || nodeRole.isLoaded();
	}

	@Override
	public boolean isLoaded() {
		return nodeRole.isLoaded();
//		return classDatumAnalysis.getDomainUsage().isCheckable() && !isNull();
	}

	@Override
	public boolean isMatchable() {
		return nodeRole.isMatchable();
	}

	@Override
	public boolean isNavigable() {
		return nodeRole.isNavigable();
	}

	@Override
	public boolean isNull() {
		return nodeRole.isNull();
	}

	@Override
	public boolean isOperation() {
		return nodeRole.isOperation();
	}

	@Override
	public boolean isPredicated() {
		return nodeRole.isPredicated();
	}

	@Override
	public boolean isRealized() {
		return nodeRole.isRealized();
	}

	@Override
	public boolean isRealizedVariable() {
		return nodeRole.isRealizedVariable();
	}

	@Override
	public boolean isResult() {
		return nodeRole.isResult();
	}

	@Override
	public boolean isTrue() {
		return nodeRole.isTrue();
	}

	protected void mergeRole(@NonNull NodeRole nodeRole) {
		if (this.nodeRole != nodeRole) {
			this.nodeRole = this.nodeRole.merge(nodeRole);
		}
	}
 
	@Override
	public boolean refineClassDatumAnalysis(@NonNull ClassDatumAnalysis newClassDatumAnalysis) {
		CompleteClass oldCompleteClass = classDatumAnalysis.getCompleteClass();
		CompleteClass newCompleteClass = newClassDatumAnalysis.getCompleteClass();
		if (oldCompleteClass.conformsTo(newCompleteClass)) {
			RootDomainUsageAnalysis domainAnalysis = getSchedulerConstants().getDomainAnalysis();
			DomainUsage.Internal oldDomainUsage = (Internal) classDatumAnalysis.getDomainUsage();
			DomainUsage.Internal newDomainUsage = (Internal) newClassDatumAnalysis.getDomainUsage();
			int refinedBitMask = oldDomainUsage.getMask() & newDomainUsage.getMask();
			DomainUsage refinedDomainUsage = domainAnalysis.getConstantUsage(refinedBitMask);
			TypedModel refinedTypedModel = refinedDomainUsage.getTypedModel();
			assert refinedTypedModel != null;
			classDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis(oldCompleteClass.getPrimaryClass(), refinedTypedModel);
			return true;
		}
		else if (newCompleteClass.conformsTo(oldCompleteClass)) {
			RootDomainUsageAnalysis domainAnalysis = getSchedulerConstants().getDomainAnalysis();
			DomainUsage.Internal oldDomainUsage = (Internal) classDatumAnalysis.getDomainUsage();
			DomainUsage.Internal newDomainUsage = (Internal) newClassDatumAnalysis.getDomainUsage();
			int refinedBitMask = oldDomainUsage.getMask() & newDomainUsage.getMask();
			DomainUsage refinedDomainUsage = domainAnalysis.getConstantUsage(refinedBitMask);
			TypedModel refinedTypedModel = refinedDomainUsage.getTypedModel();
			assert refinedTypedModel != null;
			classDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis(newCompleteClass.getPrimaryClass(), refinedTypedModel);
			return true;
		}
		else if (oldCompleteClass.getPrimaryClass().getESObject() == EcorePackage.Literals.EOBJECT) {
			classDatumAnalysis = newClassDatumAnalysis;
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public final void removeIncomingConnection(@NonNull Connection connection) {
		assert Iterables.contains(connection.getTargets(), this);
//		assert edge.getRegion() == getRegion();
		List<Connection> incomingConnections2 = incomingConnections;
		assert incomingConnections2 != null;
		boolean wasRemoved = incomingConnections2.remove(connection);
		assert wasRemoved;
	}
	
	@Override
	public final void removeIncomingEdge(@NonNull Edge edge) {
		assert edge.getTarget() == this;
//		assert edge.getRegion() == getRegion();
		List<Edge> incomingEdges2 = incomingEdges;
		assert incomingEdges2 != null;
		boolean wasRemoved = incomingEdges2.remove(edge);
		assert wasRemoved;
	}

	@Override
	public final void removeOutgoingConnection(@NonNull Connection connection) {
		assert Iterables.contains(connection.getSources(), this);
//		assert edge.getRegion() == getRegion();
		List<Connection> outgoingConnections2 = outgoingConnections;
		assert outgoingConnections2 != null;
		boolean wasRemoved = outgoingConnections2.remove(connection);
		assert wasRemoved;
	}

	@Override
	public final void removeOutgoingEdge(@NonNull Edge edge) {
		assert edge.getSource() == this;
//		assert edge.getRegion() == getRegion();
		List<Edge> outgoingEdges2 = outgoingEdges;
		assert outgoingEdges2 != null;
		boolean wasRemoved = outgoingEdges2.remove(edge);
		assert wasRemoved;
	}

	@Override
	public void setHead() {
		this.nodeRole = this.nodeRole.setHead();
	}

	public void setLabel(@NonNull GraphStringBuilder s) {
		StringBuilder n = new StringBuilder();
		n.append(getName());
		if (!isExpression() && !isNull() && !isTrue()) {
			n.append("\\n");
			n.append(PrettyPrinter.printType(getCompleteClass().getPrimaryClass()));
		}
		@NonNull String string = n.toString();
		s.setLabel(string);
	}
	
	public String toDOT() {
		DOTStringBuilder s = new DOTStringBuilder();
		toDOT(s);
		return s.toString();
	}

	public void toDOT(@NonNull DOTStringBuilder s) {
		s.appendNode(this);
	}
	
	public String toGraphML() {
		GraphMLStringBuilder s = new GraphMLStringBuilder();
		toGraphML(s);
		return s.toString();
	}

	public void toGraphML(@NonNull GraphMLStringBuilder s) {
		s.appendNode(this);
	}

	@Override
	public String toString() {
        return nodeRole.toString() + "(" + getName() + " : " + classDatumAnalysis.toString() + ")";
    }
}