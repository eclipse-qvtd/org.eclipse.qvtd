/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ConnectionManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public abstract class MappingPartitionAnalysis<@NonNull P extends MappingPartition> extends AbstractPartitionAnalysis<P>
{
	/**
	 * The trace nodes and their corresponding global success node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 *
	private final @NonNull Map<@NonNull Node, @Nullable SuccessEdge> traceNode2globalSuccessEdge = new HashMap<>(); */

	/**
	 * The trace nodes and their corresponding local success node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 *
	private final @NonNull Map<@NonNull Node, @Nullable SuccessEdge> traceNode2localSuccessEdge = new HashMap<>(); */

	/**
	 * The map from node to the trace edge by which the node may be located by lookup in a trace node once its trace edge is realized..
	 *
	private final @NonNull Map<@NonNull Node, @NonNull Edge> node2traceEdge = new HashMap<>(); */

	protected MappingPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull P partition) {
		super(partitionedTransformationAnalysis, partition);
	}

	private void addCheckedEdge(@NonNull NavigableEdge checkedEdge) {
		Role role = partition.getRole(checkedEdge);
		assert (role != null) && role.isChecked();
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(checkedEdge.getEdgeSource());
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		partition.addCheckedEdge(typedModel, checkedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("    checked " + checkedEdge.getProperty() +
			" at " + partition.getPassRangeText() + " in " + typedModel + " for " + partition);
	}

	@Override
	public void addEnforcedEdge(@NonNull NavigableEdge realizedEdge) {
		Role role = partition.getRole(realizedEdge);
		assert (role != null) && role.isRealized();
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(realizedEdge.getEdgeSource());
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		Property asProperty = partition.addEnforcedEdge(typedModel, realizedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("    enforced " + asProperty +
			" at " + partition.getPassRangeText() +
			" in " + typedModel + " for " + partition);
	}

	/*	private void analyzeGlobalSuccessEdge(@NonNull Node traceNode) {
		SuccessEdge globalSuccessEdge = null;
		Property globalSuccessProperty = scheduleManager.basicGetGlobalSuccessProperty(traceNode);
		if (globalSuccessProperty != null) {
			NavigationEdge statusNavigationEdge = QVTscheduleUtil.basicGetNavigationEdge(traceNode, globalSuccessProperty);
			if (statusNavigationEdge != null) {
				globalSuccessEdge = (SuccessEdge) statusNavigationEdge;
			}
			else {		// Never needed
				/*				if (!(region instanceof DispatchRegion) && !(region instanceof VerdictRegion)) {
					RegionHelper<@NonNull MappingRegion> regionHelper = new RegionHelper<>(scheduleManager, (MappingRegion)region);
					successEdge = regionHelper.createRealizedSuccess(traceNode, successProperty, null);		// FIXME This creates a premature success in a speculation
					Node successNode = QVTscheduleUtil.getTargetNode(successEdge);
					successNode.setUtility(Node.Utility.STRONGLY_MATCHED);		// FIXME is this really neded
				} * /
			}
		}
		traceNode2globalSuccessEdge.put(traceNode, globalSuccessEdge);
	} */

	/*	private void analyzeLocalSuccessEdge(@NonNull Node traceNode) {
		SuccessEdge localSuccessEdge = null;
		Property localSuccessProperty = scheduleManager.basicGetLocalSuccessProperty(traceNode);
		if (localSuccessProperty != null) {
			NavigationEdge statusNavigationEdge = QVTscheduleUtil.basicGetNavigationEdge(traceNode, localSuccessProperty);
			if (statusNavigationEdge != null) {
				localSuccessEdge = (SuccessEdge) statusNavigationEdge;
			}
			else {		// Never needed
				/*				if (!(region instanceof DispatchRegion) && !(region instanceof VerdictRegion)) {
					RegionHelper<@NonNull MappingRegion> regionHelper = new RegionHelper<>(scheduleManager, (MappingRegion)region);
					successEdge = regionHelper.createRealizedSuccess(traceNode, successProperty, null);		// FIXME This creates a premature success in a speculation
					Node successNode = QVTscheduleUtil.getTargetNode(successEdge);
					successNode.setUtility(Node.Utility.STRONGLY_MATCHED);		// FIXME is this really neded
				} * /
			}
		}
		traceNode2localSuccessEdge.put(traceNode, localSuccessEdge);
	} */

	@Override
	public void analyzePartition() {
		analyzeNodes();
		analyzeEdges();
	}

	@Override
	public void analyzePartitionEdges() {
		for (@NonNull Edge edge : getPartialEdges()) {
			if (edge.isNavigation()) {
				NavigationEdge navigationEdge = (NavigationEdge) edge;
				Node sourceNode = navigationEdge.getEdgeSource();
				ClassDatum classDatum = QVTscheduleUtil.getClassDatum(sourceNode);
				TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
				if (isPredicated(edge)) {
					assert !navigationEdge.isCast();
					partitionedTransformationAnalysis.addCheckedEdge(typedModel, navigationEdge);
				}
				else if (isRealized(edge)) {
					partitionedTransformationAnalysis.addRealizedEdge(typedModel, navigationEdge);
				}
			}
		}
		partition.initTypedModelAnalysis();
	}

	/*	private void analyzeTraceEdges(@NonNull Node traceNode) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
			if (((edge.isCast() || edge.isNavigation()) && partition.isRealized(edge))) {
				Node tracedNode = QVTscheduleUtil.getTargetNode(edge);
				node2traceEdge.put(tracedNode, edge);
			}
		}
	} */

	/*	private @NonNull Iterable<@NonNull Node> analyzeTraceNodes() {
		/*		if (realizedMiddleNodes.size() == 0) {
			return Collections.emptyList();
		}
		if (realizedMiddleNodes.size() == 1) {
			return Collections.singletonList(realizedMiddleNodes.get(0));
		}
		Iterable<@NonNull Node> headNodes = RuleHeadAnalysis.computeRealizedHeadNodes(region, realizedMiddleNodes);
		if (Iterables.size(headNodes) == 0) {
			return Collections.emptyList();
		}
		else {
			return Collections.singletonList(headNodes.iterator().next());
		} * /
		return Iterables.concat(getPredicatedMiddleNodes(), getRealizedMiddleNodes());
	} */

	/*	public @Nullable SuccessEdge basicGetGlobalSuccessEdge(@NonNull Node traceNode) {
		return traceNode2globalSuccessEdge.get(traceNode);
	}

	public @Nullable Node basicGetGlobalSuccessNode(@NonNull Node traceNode) {
		SuccessEdge successEdge = traceNode2globalSuccessEdge.get(traceNode);
		return successEdge != null ? successEdge.getTargetNode() : null;
	}

	public @Nullable SuccessEdge basicGetLocalSuccessEdge(@NonNull Node traceNode) {
		return traceNode2localSuccessEdge.get(traceNode);
	}

	public @Nullable Node basicGetLocalSuccessNode(@NonNull Node traceNode) {
		SuccessEdge successEdge = traceNode2localSuccessEdge.get(traceNode);
		return successEdge != null ? successEdge.getTargetNode() : null;
	} */

	@Override
	public void computeCheckedOrEnforcedEdges() {
		String name = getName();
		if ("classComplexAttributes«local»".equals(name)) {
			getClass();
		}
		boolean doDebug = QVTscheduleConstants.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			QVTscheduleConstants.POLLED_PROPERTIES.println("analyzing " + this + " (" + partition.getPassRangeText() + ")");
		}
		ConnectionManager connectionManager = scheduleManager.getConnectionManager();
		for (@NonNull Edge edge : getPartialEdges()) {
			if (edge.isNavigation() && isChecked(edge)) {
				NavigationEdge checkedEdge = (NavigationEdge) edge;
				assert !checkedEdge.isCast();
				Property property = checkedEdge.getProperty();
				if (doDebug) {
					QVTscheduleConstants.POLLED_PROPERTIES.println("  analyzing " + checkedEdge.getEdgeSource().getName() + "::" + property.getName() + " : " + checkedEdge.getEdgeSource().getCompleteClass());
				}
				EdgeConnection edgeConnection = checkedEdge.getIncomingConnection();
				if (edgeConnection != null) {
					boolean isChecked = false;
					for (@NonNull Partition usedPartition : edgeConnection.getSourcePartitions()) {
						if (usedPartition.getLastPass() >= partition.getFirstPass()) {
							addCheckedEdge(checkedEdge);
							isChecked = true;
						}
					}
					if (isChecked) {
						for (@NonNull NavigableEdge usedEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
							Region sourceRegion = QVTscheduleUtil.getOwningRegion(usedEdge);
							RegionAnalysis sourceRegionAnalysis = scheduleManager.getRegionAnalysis(sourceRegion);
							for (@NonNull PartitionAnalysis sourcePartitionAnalysis : sourceRegionAnalysis.getPartitionAnalyses()) {
								Role sourceRole = sourcePartitionAnalysis.getPartition().getRole(usedEdge);
								if ((sourceRole != null) && !sourceRole.isChecked()) {
									sourcePartitionAnalysis.addEnforcedEdge(usedEdge);
								}
							}
						}
					}
				}

				Node laterNode = checkedEdge.getEdgeSource();
				Node predicatedSourceNode = checkedEdge.getEdgeSource();
				Node predicatedTargetNode = checkedEdge.getEdgeTarget();
				NodeConnection usedConnection = connectionManager.getIncomingUsedConnection(predicatedTargetNode);
				if (usedConnection != null) {
					for (@NonNull Partition usedPartition : usedConnection.getSourcePartitions()) {
						if (usedPartition.getLastPass() >= partition.getFirstPass()) {			// FIXME =
							CompleteClass predicatedSourceType = predicatedSourceNode.getCompleteClass();
							CompleteClass predicatedTargetType = predicatedTargetNode.getCompleteClass();
							ClassDatum classDatum = QVTscheduleUtil.getClassDatum(laterNode);
							TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
							Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2realizedEdges = partitionedTransformationAnalysis.getProperty2RealizedEdges(typedModel);
							assert property2realizedEdges != null;
							Property oclContainerProperty = scheduleManager.getStandardLibraryHelper().getOclContainerProperty();
							if (property == oclContainerProperty) {
								//								Node containerNode = predicatedEdge.getTarget();
								//								Node containedNode = predicatedEdge.getSource();
								//								CompleteClass containerType = containerNode.getCompleteClass();
								//								CompleteClass containedType = containedNode.getCompleteClass();
								for (@NonNull Property candidateProperty : property2realizedEdges.keySet()) {
									if (candidateProperty.isIsComposite()) {
										//										CompleteClass candidateContainerType = completeModel.getCompleteClass(candidateProperty.getOwningClass());
										//										CompleteClass candidateContainedType = completeModel.getCompleteClass(candidateProperty.getType());
										//									if (candidateContainerType.conformsTo(containerType) && containedType.conformsTo(candidateContainedType)) {
										List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(candidateProperty);
										assert realizedEdges != null;
										for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
											// FIXME recheck for narrower types ??
											//												String isNotHazardous;
											//											if (region == earlierRegion) {
											//												isNotHazardous = "same region";	// FIXME must handle recursion
											//											}
											//											else if (earlierRegion.getLatestIndex() < getEarliestIndex()) {
											//												isNotHazardous = "later";// FIXME must handle any possible reads of any possible write
											//											}
											//											else {
											Node realizedSourceNode = realizedEdge.getEdgeSource();
											Node realizedTargetNode = realizedEdge.getEdgeTarget();
											CompleteClass realizedSourceType = realizedSourceNode.getCompleteClass();
											CompleteClass realizedTargetType = realizedTargetNode.getCompleteClass();
											if (realizedSourceType.conformsTo(predicatedSourceType) && realizedTargetType.conformsTo(predicatedTargetType)) {
												assert partition.getLastPass() >= usedPartition.getFirstPass();
												//														isNotHazardous = null;
											}
											else {
												//														isNotHazardous = "incompatible";
											}
											assert partition.getLastPass() >= usedPartition.getFirstPass();
											//													isNotHazardous = null;
											//											}
											//												if (isNotHazardous == null) {
											addCheckedEdge(checkedEdge);
											AbstractPartitionAnalysis<?> usedPartitionAnalysis = partitionedTransformationAnalysis.getPartitionAnalysis(usedPartition);
											usedPartitionAnalysis.addEnforcedEdge(realizedEdge);
											//												}
											//												else if (doDebug) {
											//													QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    ignored " + region + "::" + laterNode.getName() + "(" + getEarliestIndex() + ".." + getLatestIndex() + ")" +
											//															" " + isNotHazardous + " (" + earlierRegion.getEarliestIndex() + ".." + earlierRegion.getLatestIndex() + ")" + earlierRegion + "::" + realizedEdge.getSource().getName());
											//												}
											//										}
										}
									}
								}
							}
							else {
								assert property2realizedEdges != null : "No realized typed model for " + typedModel;
								List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(property);
								if (realizedEdges == null) {
									System.err.println("No realized edges for " + typedModel + "!" + property + " in " + this);
								}
								else {
									for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
										Role role = usedPartition.getRole(realizedEdge);
										if (role != null)  {
											//	Region earlierRegion = QVTscheduleUtil.getOwningRegion(realizedEdge);
											String checkIsHazardFreeBecause;
											String enforceIsHazardFreeBecause;
											Node realizedSourceNode = realizedEdge.getEdgeSource();
											Node realizedTargetNode = realizedEdge.getEdgeTarget();
											CompleteClass realizedSourceType = realizedSourceNode.getCompleteClass();
											CompleteClass realizedTargetType = realizedTargetNode.getCompleteClass();
											if (!realizedSourceType.conformsTo(predicatedSourceType)) {
												checkIsHazardFreeBecause = "incompatible-source";
												enforceIsHazardFreeBecause = "incompatible-source";
											}
											else if (!QVTscheduleUtil.conformsToClassOrBehavioralClass(realizedTargetType, predicatedTargetType)) {
												checkIsHazardFreeBecause = "incompatible-target";
												enforceIsHazardFreeBecause = "incompatible-target";
											}
											//	else if (region == earlierRegion) {	// FIXME old commented out code for partitions
											//		checkIsHazardFreeBecause = null; 		// Same region requires inter-recursion check
											//		enforceIsHazardFreeBecause = null; 		// Same region requires inter-recursion enforce to be available for check
											//	}
											else if (usedPartition.getLastPass() < partition.getFirstPass()) {
												checkIsHazardFreeBecause = "later";
												enforceIsHazardFreeBecause = null; 		// Enforce required for later check
											}
											else {
												// The QVTi AS has insufficient precision to identify which of multiple references is hazardous
												checkIsHazardFreeBecause = null;
												enforceIsHazardFreeBecause = null;
											}
											if (checkIsHazardFreeBecause == null) {
												addCheckedEdge(checkedEdge);
											}
											else if (doDebug) {
												QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored check for " + this + "::" + laterNode.getName() + "(" + partition.getPassRangeText() + ")" +
														" " + checkIsHazardFreeBecause + " (" + usedPartition.getPassRangeText() + ")" + usedPartition + "::" + realizedEdge.getEdgeSource().getName());
											}
											if (enforceIsHazardFreeBecause == null) {
												AbstractPartitionAnalysis<?> usedPartitionAnalysis = partitionedTransformationAnalysis.getPartitionAnalysis(usedPartition);
												usedPartitionAnalysis.addEnforcedEdge(realizedEdge);
											}
											else if (doDebug) {
												QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored enforce " + this + "::" + laterNode.getName() + "(" + partition.getPassRangeText() + ")" +
														" " + enforceIsHazardFreeBecause + " (" + usedPartition.getPassRangeText() + ")" + usedPartition + "::" + realizedEdge.getEdgeSource().getName());
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/*	public @NonNull SuccessEdge getGlobalSuccessEdge(@NonNull Node traceNode) {
		return ClassUtil.nonNullState(traceNode2globalSuccessEdge.get(traceNode));
	}

	public @NonNull Node getGlobalSuccessNode(@NonNull Node traceNode) {
		SuccessEdge successEdge = ClassUtil.nonNullState(traceNode2globalSuccessEdge.get(traceNode));
		return QVTscheduleUtil.getTargetNode(successEdge);
	}

	public @NonNull SuccessEdge getLocalSuccessEdge(@NonNull Node traceNode) {
		return ClassUtil.nonNullState(traceNode2localSuccessEdge.get(traceNode));
	}

	public @NonNull Node getLocalSuccessNode(@NonNull Node traceNode) {
		SuccessEdge successEdge = ClassUtil.nonNullState(traceNode2localSuccessEdge.get(traceNode));
		return QVTscheduleUtil.getTargetNode(successEdge);
	} */

	@Override
	protected @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		return partition.getPartialEdges();
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getPartialNodes() {
		return partition.getPartialNodes();
	}

	public abstract @NonNull ReachabilityForest getReachabilityForest();

	/*	public @Nullable Edge getTraceEdge(@NonNull Node node) {
		return node2traceEdge.get(node);
	} */

	@Override
	protected boolean isConstant(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isConstant();
	}

	@Override
	protected boolean isConstant(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isConstant();
	}

	@Override
	protected boolean isLoaded(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isLoaded();
	}

	@Override
	protected boolean isLoaded(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isLoaded();
	}

	@Override
	protected boolean isNew(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isNew();
	}

	@Override
	protected boolean isNew(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isNew();
	}

	protected boolean isOld(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isOld();
	}

	@Override
	protected boolean isPredicated(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isPredicated();
	}

	@Override
	protected boolean isPredicated(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isPredicated();
	}

	@Override
	protected boolean isRealized(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isRealized();
	}

	@Override
	protected boolean isRealized(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isRealized();
	}

	@Override
	protected boolean isSpeculated(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isSpeculated();
	}

	@Override
	protected boolean isSpeculated(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isSpeculated();
	}

	@Override
	protected boolean isSpeculation(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isSpeculation();
	}
}
