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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ConnectionManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.ToGraphPartitionVisitor;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.AbstractToGraphVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public abstract class AbstractAcyclicPartition extends AbstractPartition2
{
	protected final @NonNull RegionAnalysis regionAnalysis;
	protected final @NonNull Region originalRegion;
	//	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;

	/**
	 * The per-typed model predicated navigable edges for which an execution may be attempted before assignment.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges = null;

	/**
	 * The per-typed model realized navigable edges for which an execution may be attempted elsewhere before assignment here.
	 * Sub-index is both by property and its opposite.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>>> typedModel2property2enforcedEdges = null;

	@SuppressWarnings("unused")			// Used in the debugger
	private final @NonNull ToDOT toDot = new ToDOT(this){};

	protected AbstractAcyclicPartition(@NonNull String name, @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull RegionAnalysis regionAnalysis) {
		super(name, partitionedTransformationAnalysis);
		this.regionAnalysis = regionAnalysis;
		this.originalRegion = regionAnalysis.getRegion();
		//		this.transformationAnalysis = regionAnalysis.getTransformationAnalysis();
	}

	private void addCheckedEdge(@NonNull NavigableEdge predicatedEdge) {
		Role role = getRole(predicatedEdge);
		assert (role != null) && role.isPredicated();
		Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges2 = typedModel2checkedEdges;
		assert typedModel2checkedEdges2 != null;
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(predicatedEdge.getEdgeSource());
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		Set<@NonNull NavigableEdge> checkedEdges = typedModel2checkedEdges2.get(typedModel);
		if (checkedEdges == null) {
			checkedEdges = new HashSet<>();
			typedModel2checkedEdges2.put(typedModel, checkedEdges);
		}
		checkedEdges.add(predicatedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("    checked " + predicatedEdge.getProperty() +
			" at " + getPassRangeText() + " in " + typedModel + " for " + this);
	}

	@Override
	public void addEnforcedEdge(@NonNull NavigableEdge realizedEdge) {
		Role role = getRole(realizedEdge);
		assert (role != null) && role.isRealized();
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>>> typedModel2property2enforcedEdges2 = typedModel2property2enforcedEdges;
		assert typedModel2property2enforcedEdges2 != null;
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(realizedEdge.getEdgeSource());
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>> property2enforcedEdges2 = typedModel2property2enforcedEdges2.get(typedModel);
		if (property2enforcedEdges2 == null) {
			property2enforcedEdges2 = new HashMap<>();
			typedModel2property2enforcedEdges2.put(typedModel, property2enforcedEdges2);
		}
		Property asProperty = QVTscheduleUtil.getProperty(realizedEdge);
		Set<@NonNull NavigableEdge> enforcedEdges = property2enforcedEdges2.get(asProperty);
		if (enforcedEdges == null) {
			enforcedEdges = new HashSet<>();
			property2enforcedEdges2.put(asProperty, enforcedEdges);
			Property asOpposite = asProperty.getOpposite();
			if (asOpposite != null) {
				property2enforcedEdges2.put(asOpposite, enforcedEdges);
			}
		}
		enforcedEdges.add(realizedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("    enforced " + asProperty +
			" at " + getPassRangeText() +
			" in " + typedModel + " for " + this);
	}

	@Override
	public void analyzePartition() {
		analyze();
	}

	@Override
	public void buildNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		buildPredicatedNavigationEdgesIndex2(typedModel2property2predicatedEdges);
		buildRealizedNavigationEdgesIndex2(typedModel2property2realizedEdges);
		typedModel2checkedEdges = new HashMap<>();
		typedModel2property2enforcedEdges = new HashMap<>();
	}

	private void buildPredicatedNavigationEdgesIndex2(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges) {
		for (@NonNull Edge edge : getPartialEdges()) {
			if (edge.isNavigation() && isPredicated(edge)) {
				NavigationEdge predicatedEdge = (NavigationEdge) edge;
				assert !predicatedEdge.isCast();
				Property property = QVTscheduleUtil.getProperty(predicatedEdge);
				Node predicatedNode = predicatedEdge.getEdgeSource();
				ClassDatum classDatum = QVTscheduleUtil.getClassDatum(predicatedNode);
				TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
				Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2predicatedEdges = typedModel2property2predicatedEdges.get(typedModel);
				if (property2predicatedEdges == null) {
					property2predicatedEdges = new HashMap<>();
					typedModel2property2predicatedEdges.put(typedModel, property2predicatedEdges);
				}
				List<@NonNull NavigableEdge> predicatedEdges = property2predicatedEdges.get(property);
				if (predicatedEdges == null) {
					predicatedEdges = new ArrayList<>();
					property2predicatedEdges.put(property, predicatedEdges);
				}
				predicatedEdges.add(predicatedEdge);
				QVTscheduleConstants.POLLED_PROPERTIES.println("  " + typedModel + " predicated for " + property);
			}
		}
	}

	private void buildRealizedNavigationEdgesIndex2(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		for (@NonNull Edge edge : getPartialEdges()) {
			if (edge.isNavigation() && isRealized(edge)) {
				NavigationEdge realizedEdge = (NavigationEdge) edge;
				Property property = QVTscheduleUtil.getProperty(realizedEdge);
				Node realizedNode = realizedEdge.getEdgeSource();
				ClassDatum classDatum = QVTscheduleUtil.getClassDatum(realizedNode);
				TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
				Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
				if (property2realizedEdges == null) {
					property2realizedEdges = new HashMap<>();
					typedModel2property2realizedEdges.put(typedModel, property2realizedEdges);
				}
				List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(property);
				if (realizedEdges == null) {
					realizedEdges = new ArrayList<>();
					property2realizedEdges.put(property, realizedEdges);
				}
				realizedEdges.add(realizedEdge);
				QVTscheduleConstants.POLLED_PROPERTIES.println("  " + typedModel + " realized for " + property);
			}
		}
	}

	@Override
	public void computeCheckedOrEnforcedEdges(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		boolean doDebug = QVTscheduleConstants.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			QVTscheduleConstants.POLLED_PROPERTIES.println("analyzing " + this + " (" + getPassRangeText() + ")");
		}
		ConnectionManager connectionManager = scheduleManager.getConnectionManager();
		for (@NonNull Edge edge : getPartialEdges()) {
			if (edge.isNavigation() && isPredicated(edge)) {
				NavigationEdge predicatedEdge = (NavigationEdge) edge;
				assert !predicatedEdge.isCast();
				Property property = predicatedEdge.getProperty();
				if (doDebug) {
					QVTscheduleConstants.POLLED_PROPERTIES.println("  analyzing " + predicatedEdge.getEdgeSource().getName() + "::" + property.getName() + " : " + predicatedEdge.getEdgeSource().getCompleteClass());
				}
				EdgeConnection edgeConnection = predicatedEdge.getIncomingConnection();
				if (edgeConnection != null) {
					boolean isChecked = false;
					for (@NonNull Partition usedPartition : connectionManager.getSourcePartitions(edgeConnection)) {
						if (usedPartition.getLastPass() >= getFirstPass()) {
							addCheckedEdge(predicatedEdge);
							isChecked = true;
						}
					}
					if (isChecked) {
						for (@NonNull NavigableEdge usedEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
							Region sourceRegion = QVTscheduleUtil.getOwningRegion(usedEdge);
							RegionAnalysis sourceRegionAnalysis = scheduleManager.getRegionAnalysis(sourceRegion);
							for (@NonNull Partition sourcePartition : sourceRegionAnalysis.getPartitions()) {
								Role sourceRole = sourcePartition.getRole(usedEdge);
								if ((sourceRole != null) && !sourceRole.isAwaited()) {
									sourcePartition.addEnforcedEdge(usedEdge);
								}
							}
						}
					}
				}

				Node laterNode = predicatedEdge.getEdgeSource();
				Node predicatedSourceNode = predicatedEdge.getEdgeSource();
				Node predicatedTargetNode = predicatedEdge.getEdgeTarget();
				NodeConnection usedConnection = connectionManager.getIncomingUsedConnection(predicatedTargetNode);
				if (usedConnection != null) {
					for (@NonNull Partition usedPartition : connectionManager.getSourcePartitions(usedConnection)) {
						if (usedPartition.getLastPass() >= getFirstPass()) {			// FIXME =
							CompleteClass predicatedSourceType = predicatedSourceNode.getCompleteClass();
							CompleteClass predicatedTargetType = predicatedTargetNode.getCompleteClass();
							ClassDatum classDatum = laterNode.getClassDatum();
							TypedModel typedModel = classDatum.getReferredTypedModel();
							Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
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
												assert getLastPass() >= usedPartition.getFirstPass();
												//														isNotHazardous = null;
											}
											else {
												//														isNotHazardous = "incompatible";
											}
											assert getLastPass() >= usedPartition.getFirstPass();
											//													isNotHazardous = null;
											//											}
											//												if (isNotHazardous == null) {
											addCheckedEdge(predicatedEdge);
											usedPartition.addEnforcedEdge(realizedEdge);
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
										else if (usedPartition.getLastPass() < getFirstPass()) {
											checkIsHazardFreeBecause = "later";
											enforceIsHazardFreeBecause = null; 		// Enforce required for later check
										}
										else {
											// The QVTi AS has insufficient precision to identify which of multiple references is hazardous
											checkIsHazardFreeBecause = null;
											enforceIsHazardFreeBecause = null;
										}
										if (checkIsHazardFreeBecause == null) {
											addCheckedEdge(predicatedEdge);
										}
										else if (doDebug) {
											QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored check for " + this + "::" + laterNode.getName() + "(" + getPassRangeText() + ")" +
													" " + checkIsHazardFreeBecause + " (" + usedPartition.getPassRangeText() + ")" + usedPartition + "::" + realizedEdge.getEdgeSource().getName());
										}
										if (enforceIsHazardFreeBecause == null) {
											usedPartition.addEnforcedEdge(realizedEdge);
										}
										else if (doDebug) {
											QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored enforce " + this + "::" + laterNode.getName() + "(" + getPassRangeText() + ")" +
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

	@Override
	public @Nullable Set<@NonNull NavigableEdge> getCheckedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2checkedEdges != null;
		return typedModel2checkedEdges.get(typedModel);
	}

	@Override
	public @Nullable Iterable<@NonNull NavigableEdge> getEnforcedEdges(@NonNull TypedModel typedModel, @NonNull Property asProperty) {
		assert typedModel2property2enforcedEdges != null;
		Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>> property2enforcedEdge = typedModel2property2enforcedEdges.get(typedModel);
		if (property2enforcedEdge != null) {
			Set<@NonNull NavigableEdge> enforcedEdges = property2enforcedEdge.get(asProperty);
			return enforcedEdges;
		}
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull Partition> getExplicitPredecessors() {
		return null;
	}

	@Override
	public @NonNull Region getOriginalRegion() {
		return originalRegion;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		AbstractToGraphVisitor visitor = ToGraphPartitionVisitor.createVisitor(s, getScheduleManager(), true);
		visitor.visit(this);
	}
}