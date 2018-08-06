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
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public class RegionAnalysis extends AbstractPartialRegionAnalysis<@NonNull RegionAnalysis>
{
	protected final @NonNull TransformationAnalysis transformationAnalysis;

	/**
	 * The per-typed model predicated navigable edges for which an execution may be attempted before assignment.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges = null;

	/**
	 * The per-typed model realized navigable edges for which an execution may be attempted elsewhere before assignment here.
	 * Sub-index is both by property and its opposite.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>>> typedModel2property2enforcedEdges = null;

	/**
	 * The edges to be realized iff speculation succeeds.
	 */
	private final @NonNull List<@NonNull NavigableEdge> corollaryEdges = new ArrayList<>();

	/**
	 * The nodes to be realized iff speculation succeeds.
	 */
	private final @NonNull List<@NonNull Node> corollaryNodes = new ArrayList<>();

	/**
	 * The actual and pseudo-RegionAnalysis-es that must be unconditionally successful for this RegionAnalysis
	 * to be unconditionally successful. null prior to determination.
	 *
	private @Nullable Iterable<@NonNull RegionAnalysis> fallibilities = null; */

	/**
	 * The edges that may be left unsynthesized when this RegionAnalysis is used in an infallible cycle.
	 *
	private @Nullable Iterable<@NonNull Edge> fallibleEdges = null; */

	public RegionAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull Region region) {
		super(transformationAnalysis, region);
		this.transformationAnalysis = transformationAnalysis;
		List<@NonNull Node> alreadyRealized = analyze();
		analyzeCorollaries(alreadyRealized);
	}

	private void addCheckedEdge(@NonNull NavigableEdge predicatedEdge) {
		assert predicatedEdge.isPredicated();
		assert predicatedEdge.getOwningRegion() == region;
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
			" at " + region.getIndexRangeText() + " in " + typedModel + " for " + region);
	}

	private void addEnforcedEdge(@NonNull NavigableEdge realizedEdge) {
		assert realizedEdge.isRealized();
		assert realizedEdge.getOwningRegion() == region;
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
			" at " + region.getIndexRangeText() +
			" in " + typedModel + " for " + region);
	}

	/**
	 * Identify what gets realized as a consequence of the mapping succeeding.
	 *<p>
	 * The corollaries are realized nodes and edges that are logically realized at the same time as the trace node.
	 * However since the trace node may be created speculatively to host matched and success statuses,
	 * corollary realization is deferred until the speculation has been successfully resolved.
	 */
	private void analyzeCorollaries(@NonNull List<@NonNull Node> alreadyRealizedNodes) {
		for (int i = 0; i < alreadyRealizedNodes.size(); i++) {
			Node alreadyRealizedNode = alreadyRealizedNodes.get(i);
			for (@NonNull NavigationEdge edge : alreadyRealizedNode.getRealizedNavigationEdges()) {
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				if (targetNode.isRealized() && !targetNode.isSuccess()) {
					assert !corollaryEdges.contains(edge);
					corollaryEdges.add(edge);
					if (!alreadyRealizedNodes.contains(targetNode)) {
						alreadyRealizedNodes.add(targetNode);
						assert !corollaryNodes.contains(targetNode);
						if (!corollaryNodes.contains(targetNode)) {		// Overrides have a base and derived edge to the same rootVariable node
							corollaryNodes.add(targetNode);
						}
					}
					transformationAnalysis.addCorollary(edge);
				}
			}
		}
	}

	public void buildNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		buildPredicatedNavigationEdgesIndex2(typedModel2property2predicatedEdges);
		buildRealizedNavigationEdgesIndex2(typedModel2property2realizedEdges);
		typedModel2checkedEdges = new HashMap<>();
		typedModel2property2enforcedEdges = new HashMap<>();
	}

	private void buildPredicatedNavigationEdgesIndex2(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges) {
		for (@NonNull NavigationEdge predicatedEdge : region.getPredicatedNavigationEdges()) {
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

	private void buildRealizedNavigationEdgesIndex2(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		for (@NonNull NavigableEdge realizedEdge : region.getRealizedNavigationEdges()) {
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

	public void computeCheckedOrEnforcedEdges(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		boolean doDebug = QVTscheduleConstants.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			QVTscheduleConstants.POLLED_PROPERTIES.println("analyzing " + region + " (" + region.getIndexRangeText() + ")");
		}
		for (@NonNull NavigationEdge predicatedEdge : region.getPredicatedNavigationEdges()) {
			assert !predicatedEdge.isCast();
			Property property = predicatedEdge.getProperty();
			if (doDebug) {
				QVTscheduleConstants.POLLED_PROPERTIES.println("  analyzing " + predicatedEdge.getEdgeSource().getName() + "::" + property.getName() + " : " + predicatedEdge.getEdgeSource().getCompleteClass());
			}
			EdgeConnection edgeConnection = predicatedEdge.getIncomingConnection();
			if (edgeConnection != null) {
				boolean isChecked = false;
				for (@NonNull NavigableEdge usedEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
					Region usedRegion = QVTscheduleUtil.getOwningRegion(usedEdge);
					transformationAnalysis.getRegionAnalysis(usedRegion).addEnforcedEdge(usedEdge);
					if (usedRegion.getFinalExecutionIndex() >= region.getInvocationIndex()) {
						addCheckedEdge(predicatedEdge);
						isChecked = true;
					}
				}
				if (isChecked) {
					for (@NonNull NavigableEdge usedEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
						Region usedRegion = QVTscheduleUtil.getOwningRegion(usedEdge);
						scheduleManager.getRegionAnalysis(usedRegion).addEnforcedEdge(usedEdge);
					}
				}
			}

			Node laterNode = predicatedEdge.getEdgeSource();
			Node predicatedSourceNode = predicatedEdge.getEdgeSource();
			Node predicatedTargetNode = predicatedEdge.getEdgeTarget();
			NodeConnection usedConnection = predicatedTargetNode.getIncomingUsedConnection();
			if (usedConnection != null) {
				for (@NonNull Node usedSourceNode : QVTscheduleUtil.getSourceEnds(usedConnection)) {
					Region usedRegion = QVTscheduleUtil.getOwningRegion(usedSourceNode);
					if (usedRegion.getFinalExecutionIndex() >= region.getInvocationIndex()) {			// FIXME =
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
										Region earlierRegion = realizedEdge.getOwningRegion();
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
											assert region.getFinalExecutionIndex() >= earlierRegion.getInvocationIndex();
											//														isNotHazardous = null;
										}
										else {
											//														isNotHazardous = "incompatible";
										}
										assert region.getFinalExecutionIndex() >= earlierRegion.getInvocationIndex();
										//													isNotHazardous = null;
										//											}
										//												if (isNotHazardous == null) {
										addCheckedEdge(predicatedEdge);
										scheduleManager.getRegionAnalysis(earlierRegion).addEnforcedEdge(realizedEdge);
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
								System.err.println("No realized edges for " + typedModel + "!" + property + " in " + region);
							}
							else {
								for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
									Region earlierRegion = QVTscheduleUtil.getOwningRegion(realizedEdge);
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
									else if (region == earlierRegion) {
										checkIsHazardFreeBecause = null; 		// Same region requires inter-recursion check
										enforceIsHazardFreeBecause = null; 		// Same region requires inter-recursion enforce to be available for check
									}
									else if (earlierRegion.getFinalExecutionIndex() < region.getInvocationIndex()) {
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
										QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored check for " + region + "::" + laterNode.getName() + "(" + region.getIndexRangeText() + ")" +
												" " + checkIsHazardFreeBecause + " (" + earlierRegion.getIndexRangeText() + ")" + earlierRegion + "::" + realizedEdge.getEdgeSource().getName());
									}
									if (enforceIsHazardFreeBecause == null) {
										scheduleManager.getRegionAnalysis(earlierRegion).addEnforcedEdge(realizedEdge);
									}
									else if (doDebug) {
										QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored enforce " + region + "::" + laterNode.getName() + "(" + region.getIndexRangeText() + ")" +
												" " + enforceIsHazardFreeBecause + " (" + earlierRegion.getIndexRangeText() + ")" + earlierRegion + "::" + realizedEdge.getEdgeSource().getName());
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public @Nullable Set<@NonNull NavigableEdge> getCheckedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2checkedEdges != null;
		return typedModel2checkedEdges.get(typedModel);
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getCorollaryEdges() {
		return corollaryEdges;
	}

	public @NonNull Iterable<@NonNull Node> getCorollaryNodes() {
		return corollaryNodes;
	}

	public @Nullable Iterable<@NonNull NavigableEdge> getEnforcedEdges(@NonNull TypedModel typedModel, @NonNull Property asProperty) {
		assert typedModel2property2enforcedEdges != null;
		Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>> property2enforcedEdge = typedModel2property2enforcedEdges.get(typedModel);
		if (property2enforcedEdge != null) {
			Set<@NonNull NavigableEdge> enforcedEdges = property2enforcedEdge.get(asProperty);
			return enforcedEdges;
		}
		return null;
	}

	//	public @NonNull Iterable<@NonNull RegionAnalysis> getFallibilities() {
	//		return ClassUtil.nonNullState(fallibilities);
	//	}

	//	public @NonNull Iterable<@NonNull Edge> getFallibleEdges() {
	//		return ClassUtil.nonNullState(fallibleEdges);
	//	}

	@Override
	public @NonNull String getName() {
		return String.valueOf(region);
	}

	public @NonNull TransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
	}

	//	public void setFallibilities(@NonNull Iterable<@NonNull RegionAnalysis> fallibilities) {
	//		this.fallibilities = fallibilities;
	//	}

	//	public void setFallibleEdges(@NonNull Iterable<@NonNull Edge> fallibleEdges) {
	//		this.fallibleEdges  = fallibleEdges;
	//	}

	@Override
	public String toString() {
		return region.toString();
	}
}