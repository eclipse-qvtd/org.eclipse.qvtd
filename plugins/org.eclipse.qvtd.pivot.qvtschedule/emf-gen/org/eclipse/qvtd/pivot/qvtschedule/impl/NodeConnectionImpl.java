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

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NodeConnectionImpl extends DatumConnectionImpl<Node> implements NodeConnection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.NODE_CONNECTION;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitNodeConnection(this);
	}

	private ClassDatumAnalysis classDatumAnalysis;

	/**
	 * The region that manages the data structures for the Connection.
	 */
	private Region commonRegion = null;

	/**
	 * The regions other than the common, source and target regions through which the Connection is passed.
	 */
	private List<@NonNull Region> intermediateRegions = null;

	public NodeConnectionImpl(@NonNull ScheduledRegion region, @NonNull Set<@NonNull Node> sourceNodes, @NonNull SymbolNameBuilder symbolNameBuilder, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		super(region, sourceNodes, symbolNameBuilder);
		this.classDatumAnalysis = classDatumAnalysis;
		region.addNodeConnection(this);
		for (@NonNull Node sourceNode : sourceNodes) {
			//			assert !sourceNode.isConstant();
			sourceNode.addOutgoingConnection(this);
		}
	}

	@Override
	public void addPassedTargetNode(@NonNull Node targetNode) {
		mergeRole(QVTscheduleConstants.PASSED);
		assert !targetEnd2role.containsKey(targetNode);
		targetEnd2role.put(targetNode, QVTscheduleConstants.PASSED);
		targetNode.addIncomingConnection(this);
		//		assert Sets.intersection(getSourceRegions(), getTargetRegions()).isEmpty();
	}

	@Override
	public void addUsedTargetNode(@NonNull Node targetNode, boolean mustBeLater) {
		ConnectionRole newConnectionRole = mustBeLater ? QVTscheduleConstants.MANDATORY_NODE : QVTscheduleConstants.PREFERRED_NODE;
		ConnectionRole oldConnectionRole = targetEnd2role.get(targetNode);
		if ((oldConnectionRole != null) && (oldConnectionRole != newConnectionRole)) {
			newConnectionRole = newConnectionRole.merge(oldConnectionRole);
		}
		mergeRole(newConnectionRole);
		targetEnd2role.put(targetNode, newConnectionRole);
		targetNode.addIncomingConnection(this);
		//		assert Sets.intersection(getSourceRegions(), getTargetRegions()).isEmpty();
	}

	@Override
	public @Nullable Node basicGetSource(@NonNull Region sourceRegion) {
		Node sourceNode = null;
		for (@NonNull Node node : sourceEnds) {
			if (node.getRegion() == sourceRegion) {
				assert sourceNode == null;
				sourceNode = node;
			}
		}
		return sourceNode;
	}

	@Override
	public void destroy() {
		for (@NonNull Node sourceNode : sourceEnds) {
			sourceNode.removeOutgoingConnection(this);
		}
		for (@NonNull Node targetNode : targetEnd2role.keySet()) {
			targetNode.removeIncomingConnection(this);
		}
		super.destroy();
	}

	@Override
	public @NonNull ClassDatumAnalysis getClassDatumAnalysis() {
		return classDatumAnalysis;
	}

	@Override
	public @Nullable Region getCommonRegion() {
		return commonRegion;
	}

	@Override
	public @NonNull List<@NonNull Region> getIntermediateRegions() {
		return intermediateRegions != null ? intermediateRegions : QVTscheduleConstants.EMPTY_REGION_LIST;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getSourceNodes() {
		return sourceEnds;
	}

	@Override
	public @NonNull Type getSourcesType(@NonNull IdResolver idResolver) {
		//		System.out.println("commonType of " + this);
		Type commonType = null;
		for (@NonNull Node node : getSources()) {
			Type nodeType = node.getCompleteClass().getPrimaryClass();
			if (nodeType instanceof CollectionType) {
				nodeType = ((CollectionType)nodeType).getElementType();		// FIXME needed for composed source nodes
				assert nodeType != null;
			}
			//			System.out.println("  nodeType " + nodeType);
			//			CompleteEnvironment environment = idResolver.getEnvironment();
			//			if (!(nodeType instanceof CollectionType)) {		// RealizedVariable accumulated on Connection
			//				nodeType = isOrdered() ? environment.getOrderedSetType(nodeType, true, null, null) : environment.getSetType(nodeType, true, null, null);
			//			}
			if (commonType == null) {
				commonType = nodeType;
			}
			else if (nodeType != commonType) {
				commonType = commonType.getCommonType(idResolver, nodeType);
			}
		}
		//		System.out.println("=> " + commonType);
		assert commonType != null;
		return commonType;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getTargetNodes() {
		return targetEnd2role.keySet();
	}

	@Override
	public @NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargets() {
		return targetEnd2role;
	}

	/*	@Override
	public boolean isInput() {
		boolean isInput = false;
		boolean isNonInput = false;
		for (@NonNull Node sourceNode : sourceEnds) {
			if (sourceNode.isInput()) {
				isInput = true;
			}
			else {
				isNonInput = true;
			}
		}
		assert !(isInput && isNonInput);
		return isInput;
	} */

	@Override
	public boolean isMandatory() {
		return getConnectionRole().isMandatory();
	}

	public boolean isNode2Node() {
		return (sourceEnds.size() == 1) && (targetEnd2role.size() == 1);
	}

	/**
	 * Return true if this connections should be ordered since its source could be ordered.
	 *
	private boolean isOrdered() {
		boolean isOrdered = false;
		for (@NonNull Node sourceNode1 : getSources()) {
			Region sourceRegion = sourceNode1.getRegion();
			for (@NonNull NodeConnection passedConnection : sourceRegion.getIncomingPassedConnections()) {
				for (@NonNull Node sourceNode2 : passedConnection.getSources()) {
					Type sourceType2 = sourceNode2.getClassDatumAnalysis().getCompleteClass().getPrimaryClass();
					if ((sourceType2 instanceof CollectionType) && ((CollectionType)sourceType2).isOrdered()) {
						return true;
					}
				}
			}
		}
		return isOrdered;
	} */

	/*	@Override
	public boolean isOutput() {
		boolean isOutput = false;
		boolean isNonOutput = false;
		for (@NonNull Node targetNode : targetEnd2role.keySet()) {
			if (targetNode.isOutput()) {
				isOutput = true;
			}
			else {
				isNonOutput = true;
			}
		}
		assert !(isOutput && isNonOutput);
		return isOutput;
	} */

	@Override
	public boolean isPassed() {
		return getConnectionRole().isPassed();
	}

	@Override
	public boolean isPassed(@NonNull Region targetRegion) {
		if (Iterables.contains(targetRegion.getIncomingPassedConnections(), this)) {		// FIXME unify cyclic/non-cyclic
			return true;
		}
		for (@NonNull Node targetNode : targetEnd2role.keySet()) {
			if (targetNode.getRegion() == targetRegion) {
				ConnectionRole role = targetEnd2role.get(targetNode);
				assert role != null;
				if (role.isPassed()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isUsed() {
		return getConnectionRole().isPreferred();
	}

	@Override
	public boolean isUsed(@NonNull Node targetNode) {
		ConnectionRole targetConnectionRole = targetEnd2role.get(targetNode);
		assert targetConnectionRole != null;
		return targetConnectionRole.isPreferred();
	}

	@Override
	public void removeSource(@NonNull Node sourceNode) {
		boolean wasRemoved = sourceEnds.remove(sourceNode);
		assert wasRemoved;
	}

	@Override
	public void removeTarget(@NonNull Node targetNode) {
		ConnectionRole oldRole = targetEnd2role.remove(targetNode);
		assert oldRole != null;
	}

	@Override
	public void removeTargetRegion(@NonNull Region targetRegion) {
		for (@NonNull Node targetNode : Lists.newArrayList(getTargetNodes())) {
			if (targetNode.getRegion() == targetRegion) {
				targetNode.removeIncomingConnection(this);
				removeTarget(targetNode);
			}
		}
		if (targetEnd2role.isEmpty()) {
			destroy();
		}
	}

	@Override
	public void setCommonRegion(@NonNull Region commonRegion, @NonNull List<@NonNull Region> intermediateRegions) {
		assert this.commonRegion == null;
		assert this.intermediateRegions == null;
		this.commonRegion = commonRegion;
		this.intermediateRegions = intermediateRegions;
		commonRegion.addRootConnection(this);
		for (@NonNull Region intermediateRegion : intermediateRegions) {
			intermediateRegion.addIntermediateConnection(this);
		}
		if (QVTscheduleConstants.CONNECTION_ROUTING.isActive()) {
			StringBuilder s = new StringBuilder();
			s.append(getSymbolName() + " common: " + commonRegion + " intermediate:");
			for (@NonNull Region intermediateRegion : intermediateRegions) {
				s.append(" " + intermediateRegion);
			}
			QVTscheduleConstants.CONNECTION_ROUTING.println(s.toString());
		}
	}

	@Override
	public void toCallGraph(@NonNull GraphStringBuilder s) {
		if (isNode2Node()) {
			s.appendNode(this);
			//			@SuppressWarnings("null")@NonNull Node sourceNode = sourceEnds.iterator().next();
			//			@SuppressWarnings("null")@NonNull Node targetNode = targetEnd2role.keySet().iterator().next();
			//			s.appendEdge(sourceNode, this, targetNode);
		}
		else {
			s.appendNode(this);
			//			for (@SuppressWarnings("null")@NonNull Node source : getSources()) {
			//				s.appendEdge(source, this, this);
			//			}
			//			for (@SuppressWarnings("null")@NonNull Node target : getTargets()) {
			//				@SuppressWarnings("null")@NonNull ConnectionRole role = targetEnd2role.get(target);
			//				s.appendEdge(this, role, target);
			//			}
		}
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		if (isNode2Node()) {
			Node sourceNode = sourceEnds.iterator().next();
			Node targetNode = targetEnd2role.keySet().iterator().next();
			s.appendEdge(sourceNode, this, targetNode);
		}
		else {
			s.appendNode(this);
			for (@NonNull Node source : getSources()) {
				s.appendEdge(source, this, this);
			}
			for (@NonNull Node target : getTargetNodes()) {
				ConnectionRole role = targetEnd2role.get(target);
				assert role != null;
				s.appendEdge(this, role, target);
			}
		}
	}
} //NodeConnectionImpl
