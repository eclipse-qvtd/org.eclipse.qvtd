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
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;

import com.google.common.collect.Iterables;

/**
 * AbstractNode provides the analysis and status of a node in the pattern match or construction of a Mapping
 * or Composite Region.
 */
public abstract class AbstractNode implements Node
{
	public static final class NodeComparator implements Comparator<@NonNull Node>
	{	
		public static final @NonNull NodeComparator INSTANCE = new NodeComparator();
	
		@Override
		public int compare(@NonNull Node o1, @NonNull Node o2) {
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
	private @Nullable NodeConnection incomingConnection = null;
	private @Nullable List<@NonNull Edge> incomingEdges = null;
	private @Nullable List<@NonNull NodeConnection> outgoingConnections = null;
	private @Nullable List<@NonNull Edge> outgoingEdges = null;

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
		Connection incomingConnection2 = incomingConnection;
		if (incomingConnection2 != null) {
			incomingConnection2.destroy();
		}
		List<NodeConnection> outgoingConnections2 = outgoingConnections;
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
	public final void addIncomingConnection(@NonNull NodeConnection connection) {
		assert (incomingConnection == null) || (incomingConnection == connection);
		assert Iterables.contains(connection.getTargetNodes(), this);
//		assert edge.getRegion() == getRegion();
		incomingConnection = connection;
	}

	@Override
	public final void addIncomingEdge(@NonNull Edge edge) {
		assert edge.getTarget() == this;
//		assert edge.getRegion() == getRegion();
		List<@NonNull Edge> incomingEdges2 = incomingEdges;
		if (incomingEdges2 == null) {
			incomingEdges = incomingEdges2 = new ArrayList<@NonNull Edge>();
		}
		else {
			assert !incomingEdges2.contains(edge);
		}
		incomingEdges2.add(edge);
	}

	@Override
	public final void addOutgoingConnection(@NonNull NodeConnection connection) {
		assert Iterables.contains(connection.getSources(), this);
//		assert edge.getRegion() == getRegion();
		List<@NonNull NodeConnection> outgoingConnections2 = outgoingConnections;
		if (outgoingConnections2 == null) {
			outgoingConnections = outgoingConnections2 = new ArrayList<@NonNull NodeConnection>();
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
		List<@NonNull Edge> outgoingEdges2 = outgoingEdges;
		if (outgoingEdges2 == null) {
			outgoingEdges = outgoingEdges2 = new ArrayList<@NonNull Edge>();
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
	public void getAllAncestors(@NonNull Set<@NonNull Node> ancestors) {
		if (ancestors.add(this)) {
			Region region = getRegion();
			for (@NonNull Node headNode : region.getHeadNodes()) {
				for (@NonNull Node passedBindingSource : headNode.getPassedBindingSources()) {
					passedBindingSource.getAllAncestors(ancestors);
				}
			}
		}
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getArgumentEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getIncomingEdges(), AbstractRegion.IsExpressionEdgePredicate.INSTANCE);
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

	@Override
	public final @NonNull Iterable<@NonNull NavigationEdge> getAssignmentEdges() {
		@SuppressWarnings("unchecked")
		Iterable<@NonNull NavigationEdge> filter = (Iterable<@NonNull NavigationEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsAssignmentEdgePredicate.INSTANCE);
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
	public final @NonNull Iterable<@NonNull Edge> getComputationEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsComputationEdgePredicate.INSTANCE);
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
	
	@Override
	public @NonNull String getDisplayName() {
		return region.getName() + "::" + getName();
	}

	@Override
	public final @Nullable NodeConnection getIncomingConnection() {
		return incomingConnection;
	}

	@Override
	public final @NonNull List<@NonNull Edge> getIncomingEdges() {
		return incomingEdges != null ? incomingEdges : SchedulerConstants.EMPTY_EDGE_LIST;
	}

	@Override
	public final @Nullable NodeConnection getIncomingPassedConnection() {
		NodeConnection incomingConnection2 = incomingConnection;
		if ((incomingConnection2 != null) && incomingConnection2.isPassed()) {
			return incomingConnection2;
		}
		else {
			return null;
		}
	}

	@Override
	public @Nullable NodeConnection getIncomingUsedConnection() {
		NodeConnection incomingConnection2 = incomingConnection;
		if ((incomingConnection2 != null) && incomingConnection2.isUsed(this)) {
			return incomingConnection2;
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull String getLabel() {
		return getName();
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getMergeableEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsMergeableEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @Nullable NavigationEdge getNavigationEdge(@NonNull Property source2targetProperty) {
		for (@NonNull Edge edge : getOutgoingEdges()) {
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
	public final @NonNull Iterable<@NonNull NavigationEdge> getNavigationEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigationEdge> filter = (Iterable<@NonNull NavigationEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @Nullable Node getNavigationTarget(@NonNull Property source2targetProperty) {
		for (@NonNull Edge edge : getOutgoingEdges()) {
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
	public @NonNull Iterable<@NonNull Node> getNavigationTargets() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsNavigationEdgePredicate.INSTANCE);
		@NonNull Iterable<@NonNull Node> transform = Iterables.transform(filter, AbstractRegion.EdgeTargetFunction.INSTANCE);
		return transform;
	}

	@Override
	public @NonNull NodeRole getNodeRole() {
		return nodeRole;
	}

	@Override
	public final @NonNull List<@NonNull NodeConnection> getOutgoingConnections() {
		return outgoingConnections != null ? outgoingConnections : SchedulerConstants.EMPTY_NODE_CONNECTION_LIST;
	}

	@Override
	public final @NonNull List<@NonNull Edge> getOutgoingEdges() {
		return outgoingEdges != null ? outgoingEdges : SchedulerConstants.EMPTY_EDGE_LIST;
	}

	@Override
	public final @NonNull Iterable<@NonNull NodeConnection> getOutgoingPassedConnections() {
		@NonNull Iterable<@NonNull NodeConnection> filter = Iterables.filter(getOutgoingConnections(), RootScheduledRegion.IsPassedBindingEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NodeConnection> getOutgoingUsedBindingEdges() {
		@NonNull Iterable<@NonNull NodeConnection> filter = Iterables.filter(getOutgoingConnections(), RootScheduledRegion.IsUsedBindingEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPassedBindingSources() {
		List<@NonNull Node> sources = new ArrayList<@NonNull Node>();
		NodeConnection connection = getIncomingPassedConnection();
		if (connection != null) {
			for (@NonNull Node source : connection.getSources()) {
				if (!sources.contains(source)) {
					sources.add(source);
				}
			}
		}
		return sources;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPassedBindingTargets() {
		List<@NonNull Node> targets = new ArrayList<@NonNull Node>();
		for (@NonNull NodeConnection connection : getOutgoingPassedConnections()) {
			for (@NonNull Node target : connection.getTargetNodes()) {
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

	@Override
	public final @NonNull Iterable<@NonNull NavigationEdge> getPredicateEdges() {
		@SuppressWarnings("unchecked")
		Iterable<@NonNull NavigationEdge> filter = (Iterable<@NonNull NavigationEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsPredicatedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getRecursionEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsRecursionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getRecursionSources() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getIncomingEdges(), AbstractRegion.IsRecursionEdgePredicate.INSTANCE);
		@NonNull Iterable<@NonNull Node> transform = Iterables.transform(filter, AbstractRegion.EdgeSourceFunction.INSTANCE);
		return transform;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getRecursionTargets() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getOutgoingEdges(), AbstractRegion.IsRecursionEdgePredicate.INSTANCE);
		@NonNull Iterable<@NonNull Node> transform = Iterables.transform(filter, AbstractRegion.EdgeTargetFunction.INSTANCE);
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
	public @NonNull Iterable<@NonNull Node> getUsedBindingSources() {
		List<@NonNull Node> sources = new ArrayList<@NonNull Node>();
		NodeConnection connection = getIncomingUsedConnection();
		if (connection != null) {
			for (@NonNull Node source : connection.getSources()) {
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

//	@Override
//	public boolean isInput() {
//		return nodeRole.isInput();
//	}

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

//	@Override
//	public boolean isOutput() {
//		return nodeRole.isOutput();
//	}

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

	public void mergeRole(@NonNull NodeRole nodeRole) {
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
	public final void removeIncomingConnection(@NonNull NodeConnection connection) {
		assert Iterables.contains(connection.getTargetNodes(), this);
//		assert edge.getRegion() == getRegion();
		assert incomingConnection != null;
		incomingConnection = null;
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
	public final void removeOutgoingConnection(@NonNull NodeConnection connection) {
		assert Iterables.contains(connection.getSources(), this);
//		assert edge.getRegion() == getRegion();
		List<NodeConnection> outgoingConnections2 = outgoingConnections;
		assert outgoingConnections2 != null;
		boolean wasRemoved = outgoingConnections2.remove(connection);
//		assert wasRemoved;
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

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.appendNode(this);
	}

	@Override
	public @NonNull String toString() {
        return nodeRole.toString() + "(" + getName() + " : " + classDatumAnalysis.toString() + ")";
    }
}