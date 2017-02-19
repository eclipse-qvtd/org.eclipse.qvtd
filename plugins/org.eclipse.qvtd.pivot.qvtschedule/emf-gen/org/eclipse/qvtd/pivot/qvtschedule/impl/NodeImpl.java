/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.SchedulerConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Visitor2;

import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class NodeImpl extends ElementImpl implements Node {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.NODE;
	}

	private @Nullable NodeRole nodeRole;						// null is only permitted during construction
	private @Nullable Region region;							// null is only permitted during construction
	private @Nullable String name;								// null is only permitted during construction
	private @Nullable ClassDatumAnalysis classDatumAnalysis;	// null is only permitted during construction
	private boolean isDataType;
	private boolean isHead = false;
	private boolean isContained = false;
	private @Nullable NodeConnection incomingConnection = null;
	private @Nullable List<@NonNull Edge> incomingEdges = null;
	private @Nullable List<@NonNull NodeConnection> outgoingConnections = null;
	private @Nullable List<@NonNull Edge> outgoingEdges = null;

	private final @NonNull List<@NonNull TypedElement> typedElements = new ArrayList<>();

	private /*@LazyNonNull*/ Utility utility = null;		// Set by post region build analysis

	@Override
	public <R> R accept(@NonNull Visitor2<R> visitor) {
		return visitor.visitNode(this);
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
		assert edge.getEdgeTarget() == this;
		//		assert edge.getRegion() == getRegion();
		List<@NonNull Edge> incomingEdges2 = incomingEdges;
		if (incomingEdges2 == null) {
			incomingEdges = incomingEdges2 = new ArrayList<>();
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
			outgoingConnections = outgoingConnections2 = new ArrayList<>();
		}
		else {
			assert !outgoingConnections2.contains(connection);
		}
		outgoingConnections2.add(connection);
	}

	@Override
	public final void addOutgoingEdge(@NonNull Edge edge) {
		assert edge.getEdgeSource() == this;
		//		assert edge.getRegion() == getRegion();
		List<@NonNull Edge> outgoingEdges2 = outgoingEdges;
		if (outgoingEdges2 == null) {
			outgoingEdges = outgoingEdges2 = new ArrayList<>();
		}
		else {
			assert !outgoingEdges2.contains(edge);
		}
		outgoingEdges2.add(edge);
	}

	@Override
	public void addTypedElement(@NonNull TypedElement typedElement) {
		if (!typedElements.contains(typedElement)) {
			typedElements.add(typedElement);
			Region region2 = region;
			assert region2 != null;
			//			if (isPattern() && isMatched() && !isRealized() && (typedElements.size() == 1) && !region2.isOperationRegion()) {	// FIXME this is not a sound diagnosis
			//				boolean isMatched = RegionUtil.isMatched(typedElement);
			//				if (!isMatched) {
			//					isMatched = RegionUtil.isMatched(typedElement);
			//				}
			//				if (!isMatched) {
			//					region2.getMultiRegion().getSchedulerConstants().addProblem(region2.createWarning("Cannot add unmatched " + typedElement + " to " + this));
			//				}
			//			}
		}
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
		if (!isUnconditional()) {
			s.setFillColor(getFillColor());
		}
		s.setPenwidth(getPenwidth());
		s.appendAttributedNode(nodeName);
		//		if (isHead) {
		//			s.append("}");
		//		}
	}

	@Override
	public void destroy() {
		assert region != null;
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
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getIncomingEdges(), QVTscheduleUtil.IsExpressionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getCastEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(getOutgoingEdges(), QVTscheduleUtil.IsCastEdgePredicate.INSTANCE);
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
		return ClassUtil.nonNullState(classDatumAnalysis);
	}

	protected @NonNull String getColor() {
		assert nodeRole != null;
		return QVTscheduleUtil.getColor(nodeRole);
	}

	@Override
	public @NonNull CompleteClass getCompleteClass() {
		assert classDatumAnalysis != null;
		return classDatumAnalysis.getCompleteClass();
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getComputationEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getOutgoingEdges(), QVTscheduleUtil.IsComputationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull String getDisplayName() {
		assert region != null;
		return region.getName() + "::" + getName();
	}

	protected @NonNull String getFillColor() {
		assert nodeRole != null;
		return QVTscheduleUtil.getFillColor(nodeRole);
	}

	@Override
	public final @Nullable NodeConnection getIncomingConnection() {
		return incomingConnection;
	}

	@Override
	public final @NonNull List<@NonNull Edge> getIncomingEdges() {
		return incomingEdges != null ? incomingEdges : QVTscheduleConstants.EMPTY_EDGE_LIST;
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
	public @NonNull String getName() {
		return ClassUtil.nonNullState(name);
	}

	@Override
	public @Nullable NavigableEdge getNavigationEdge(@NonNull Property source2targetProperty) {
		for (@NonNull Edge edge : getOutgoingEdges()) {
			if (edge instanceof NavigableEdge) {
				NavigableEdge navigationEdge = (NavigableEdge)edge;
				if (navigationEdge.getProperty() == source2targetProperty) {
					return navigationEdge;
				}
			}
		}
		return null;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getNavigationEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(getOutgoingEdges(), QVTscheduleUtil.IsNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @Nullable Node getNavigationTarget(@NonNull Property source2targetProperty) {
		for (@NonNull Edge edge : getOutgoingEdges()) {
			if (edge instanceof NavigableEdge) {
				NavigableEdge navigationEdge = (NavigableEdge)edge;
				if (navigationEdge.getProperty() == source2targetProperty) {
					return navigationEdge.getEdgeTarget();
				}
			}
		}
		return null;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getNavigationTargets() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getOutgoingEdges(), QVTscheduleUtil.IsNavigationEdgePredicate.INSTANCE);
		@NonNull Iterable<@NonNull Node> transform = Iterables.transform(filter, QVTscheduleUtil.EdgeTargetFunction.INSTANCE);
		return transform;
	}

	@Override
	public @NonNull NodeRole getNodeRole() {
		return ClassUtil.nonNullState(nodeRole);
	}

	@Override
	public final @NonNull List<@NonNull NodeConnection> getOutgoingConnections() {
		return outgoingConnections != null ? outgoingConnections : QVTscheduleConstants.EMPTY_NODE_CONNECTION_LIST;
	}

	@Override
	public final @NonNull List<@NonNull Edge> getOutgoingEdges() {
		return outgoingEdges != null ? outgoingEdges : QVTscheduleConstants.EMPTY_EDGE_LIST;
	}

	@Override
	public final @NonNull Iterable<@NonNull NodeConnection> getOutgoingPassedConnections() {
		@NonNull Iterable<@NonNull NodeConnection> filter = Iterables.filter(getOutgoingConnections(), QVTscheduleUtil.IsPassedBindingEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NodeConnection> getOutgoingUsedBindingEdges() {
		@NonNull Iterable<@NonNull NodeConnection> filter = Iterables.filter(getOutgoingConnections(), QVTscheduleUtil.IsUsedBindingEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPassedBindingSources() {
		List<@NonNull Node> sources = new ArrayList<>();
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
		List<@NonNull Node> targets = new ArrayList<>();
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
		return isHead() ? QVTscheduleConstants.HEAD_WIDTH : !isExpression() ? 2*QVTscheduleConstants.LINE_WIDTH : QVTscheduleConstants.LINE_WIDTH;
	}

	@Override
	public final @Nullable Edge getPredicateEdge(@NonNull Property source2targetProperty) {
		for (@NonNull Edge edge : getOutgoingEdges()) {
			if (edge.isPredicated() && (edge instanceof NavigableEdge)) {
				if (((NavigableEdge)edge).getProperty() == source2targetProperty) {
					return edge;
				}
			}
		}
		return null;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getPredicateEdges() {
		@SuppressWarnings("unchecked")
		Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(getOutgoingEdges(), QVTscheduleUtil.IsPredicatedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getRealizedNavigationEdges() {
		@SuppressWarnings("unchecked")
		Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(getOutgoingEdges(), QVTscheduleUtil.IsRealizedNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getRecursionEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getOutgoingEdges(), QVTscheduleUtil.IsRecursionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getRecursionSources() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getIncomingEdges(), QVTscheduleUtil.IsRecursionEdgePredicate.INSTANCE);
		@NonNull Iterable<@NonNull Node> transform = Iterables.transform(filter, QVTscheduleUtil.EdgeSourceFunction.INSTANCE);
		return transform;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getRecursionTargets() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getOutgoingEdges(), QVTscheduleUtil.IsRecursionEdgePredicate.INSTANCE);
		@NonNull Iterable<@NonNull Node> transform = Iterables.transform(filter, QVTscheduleUtil.EdgeTargetFunction.INSTANCE);
		return transform;
	}

	@Override
	public @NonNull Region getRegion() {
		return ClassUtil.nonNullState(region);
	}

	@Override
	public final @NonNull Iterable<@NonNull ? extends Edge> getResultEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(getOutgoingEdges(), QVTscheduleUtil.IsExpressionEdgePredicate.INSTANCE);
		return filter;
	}

	//	@Override
	public @NonNull SchedulerConstants getSchedulerConstants() {
		assert region != null;
		return region.getSchedulerConstants();
	}

	protected @Nullable String getShape() {
		return null;
	}

	protected @Nullable String getStyle() {
		StringBuilder s = new StringBuilder();
		if (isDataType()) {
			s.append("rounded");
		}
		if (!isMatched()) {
			if (s.length() > 0) {
				s.append(",");
			}
			s.append("dashed");
		}
		if (!isUnconditional()) {
			if (s.length() > 0) {
				s.append(",");
			}
			s.append("filled");
		}
		return "\"" + s.toString() + "\"";
	}

	@Override
	public @NonNull Iterable<@NonNull TypedElement> getTypedElements() {
		return typedElements;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getUsedBindingSources() {
		List<@NonNull Node> sources = new ArrayList<>();
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
	public @NonNull Utility getUtility() {
		return ClassUtil.nonNullState(utility);
	}

	protected void initialize(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		this.nodeRole = nodeRole;
		this.region = region;
		this.name = name;
		this.classDatumAnalysis = classDatumAnalysis;
		this.isDataType = classDatumAnalysis.getCompleteClass().getPrimaryClass() instanceof DataType;
		region.addNode(this);
	}

	@Override
	public final boolean isClass() {
		return !isDataType;
	}

	@Override
	public boolean isComposed() {
		return false;
	}

	@Override
	public boolean isConstant() {
		assert nodeRole != null;
		return nodeRole.isConstant();
	}

	@Override
	public boolean isContained() {
		return isContained;
	}

	@Override
	public final boolean isDataType() {
		return isDataType;
	}

	@Override
	public boolean isDependency() {
		return false;
	}

	@Override
	public boolean isExplicitNull() {
		return false;
	}

	@Override
	public boolean isExpression() {
		return false;
	}

	@Override
	public boolean isHead() {
		return isHead;
	}

	@Override
	public boolean isIterator() {
		return false;
	}

	@Override
	public boolean isLoaded() {
		assert nodeRole != null;
		return nodeRole.isLoaded();
	}

	@Override
	public boolean isMatched() {
		return false;
	}

	@Override
	public boolean isNew() {
		assert nodeRole != null;
		return nodeRole.isNew();
	}

	@Override
	public boolean isOld() {
		assert nodeRole != null;
		return nodeRole.isOld();
	}

	@Override
	public boolean isOperation() {
		return false;
	}

	@Override
	public boolean isPattern() {
		return false;
	}

	@Override
	public boolean isPredicated() {
		assert nodeRole != null;
		if (nodeRole.isSpeculated()) {
			assert nodeRole != null;
			return nodeRole.isPredicated();
		}
		else {
			assert nodeRole != null;
			return nodeRole.isPredicated();
		}
	}

	@Override
	public boolean isRealized() {
		assert nodeRole != null;
		return nodeRole.isRealized();
	}

	@Override
	public boolean isRequired() {
		for (@NonNull TypedElement typedElement : getTypedElements()) {
			if (typedElement.isIsRequired()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isSpeculated() {
		assert nodeRole != null;
		return nodeRole.isSpeculated();
	}

	@Override
	public boolean isSpeculation() {
		assert nodeRole != null;
		return nodeRole.isSpeculation();
	}

	@Override
	public boolean isTrue() {
		return false;
	}

	@Override
	public boolean isUnconditional() {
		return (utility == Utility.STRONGLY_MATCHED) || (utility == Utility.WEAKLY_MATCHED);
	}

	@Override
	public boolean refineClassDatumAnalysis(@NonNull ClassDatumAnalysis newClassDatumAnalysis) {
		ClassDatumAnalysis classDatumAnalysis2 = classDatumAnalysis;
		assert classDatumAnalysis2 != null;
		CompleteClass oldCompleteClass = classDatumAnalysis2.getCompleteClass();
		CompleteClass newCompleteClass = newClassDatumAnalysis.getCompleteClass();
		if (oldCompleteClass.conformsTo(newCompleteClass)) {
			DomainUsageAnalysis.Root domainAnalysis = getSchedulerConstants().getDomainAnalysis();
			DomainUsage.Internal oldDomainUsage = (DomainUsage.Internal) classDatumAnalysis2.getDomainUsage();
			DomainUsage.Internal newDomainUsage = (DomainUsage.Internal) newClassDatumAnalysis.getDomainUsage();
			int refinedBitMask = oldDomainUsage.getMask() & newDomainUsage.getMask();
			DomainUsage refinedDomainUsage = domainAnalysis.getConstantUsage(refinedBitMask);
			TypedModel refinedTypedModel = refinedDomainUsage.getTypedModel(oldCompleteClass);
			assert refinedTypedModel != null;
			classDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis(oldCompleteClass, refinedTypedModel);
			return true;
		}
		else if (newCompleteClass.conformsTo(oldCompleteClass)) {
			DomainUsageAnalysis.Root domainAnalysis = getSchedulerConstants().getDomainAnalysis();
			DomainUsage.Internal oldDomainUsage = (DomainUsage.Internal) classDatumAnalysis2.getDomainUsage();
			DomainUsage.Internal newDomainUsage = (DomainUsage.Internal) newClassDatumAnalysis.getDomainUsage();
			int refinedBitMask = oldDomainUsage.getMask() & newDomainUsage.getMask();
			DomainUsage refinedDomainUsage = domainAnalysis.getConstantUsage(refinedBitMask);
			TypedModel refinedTypedModel = refinedDomainUsage.getTypedModel(newCompleteClass);
			assert refinedTypedModel != null;
			classDatumAnalysis = getSchedulerConstants().getClassDatumAnalysis(newCompleteClass, refinedTypedModel);
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
		assert edge.getEdgeTarget() == this;
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
		@SuppressWarnings("unused")
		boolean wasRemoved = outgoingConnections2.remove(connection);
		//		assert wasRemoved;
	}

	@Override
	public final void removeOutgoingEdge(@NonNull Edge edge) {
		assert edge.getEdgeSource() == this;
		//		assert edge.getRegion() == getRegion();
		List<Edge> outgoingEdges2 = outgoingEdges;
		assert outgoingEdges2 != null;
		boolean wasRemoved = outgoingEdges2.remove(edge);
		assert wasRemoved;
	}

	@Override
	public void resetHead() {
		this.isHead = false;
	}

	@Override
	public void setContained(boolean isContained) {
		this.isContained = isContained;
	}

	@Override
	public void setHead() {
		this.isHead = true;
	}

	public void setLabel(@NonNull GraphStringBuilder s) {
		StringBuilder n = new StringBuilder();
		n.append(getName());
		if (!isExplicitNull() && !isTrue()) {
			n.append("\\n");
			n.append(PrettyPrinter.printType(getCompleteClass().getPrimaryClass()));
		}
		@NonNull String string = n.toString();
		s.setLabel(string);
	}

	@Override
	public void setUtility(@NonNull Utility utility) {
		assert this.utility == null;
		this.utility  = utility;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.appendNode(this);
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getNodeRole().getPhase());
		s.append("-");
		s.append(getClass().getSimpleName().replace("Impl",  ""));
		s.append("(");
		s.append(getName());
		s.append(" : ");
		s.append(String.valueOf(classDatumAnalysis));
		s.append(")");
		return s.toString();
	}

} //NodeImpl