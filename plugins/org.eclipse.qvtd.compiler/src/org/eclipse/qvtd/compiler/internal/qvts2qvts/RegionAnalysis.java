/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public class RegionAnalysis implements Adapter
{
	public static @Nullable RegionAnalysis find(@NonNull Region region) {
		return ClassUtil.getAdapter(RegionAnalysis.class, region);
	}

	public static @NonNull RegionAnalysis get(@NonNull Region region) {
		RegionAnalysis adapter = ClassUtil.getAdapter(RegionAnalysis.class, region);
		if (adapter == null) {
			adapter = new RegionAnalysis(region);
		}
		return adapter;
	}

	protected final @NonNull Region region;

	/**
	 * The per-typed model predicated navigable edges for which an execution may be attempted before assignment.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges = null;

	/**
	 * The per-typed model realized navigable edges for which an execution may be attempted elsewhere before assignment here.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2enforcedEdges = null;

	public RegionAnalysis(@NonNull Region region) {
		region.eAdapters().add(this);
		this.region = region;
	}

	private void addCheckedEdge(@NonNull NavigableEdge predicatedEdge) {
		assert predicatedEdge.isPredicated();
		assert predicatedEdge.getOwningRegion() == region;
		Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges2 = typedModel2checkedEdges;
		assert typedModel2checkedEdges2 != null;
		ClassDatum classDatum = RegionUtil.getClassDatum(predicatedEdge.getEdgeSource());
		TypedModel typedModel = RegionUtil.getReferredTypedModel(classDatum);
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
		Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2enforcedEdges2 = typedModel2enforcedEdges;
		assert typedModel2enforcedEdges2 != null;
		ClassDatum classDatum = RegionUtil.getClassDatum(realizedEdge.getEdgeSource());
		TypedModel typedModel = RegionUtil.getReferredTypedModel(classDatum);
		Set<@NonNull NavigableEdge> enforcedEdges = typedModel2enforcedEdges2.get(typedModel);
		if (enforcedEdges == null) {
			enforcedEdges = new HashSet<>();
			typedModel2enforcedEdges2.put(typedModel, enforcedEdges);
		}
		enforcedEdges.add(realizedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("    enforced " + realizedEdge.getProperty() +
			" at " + region.getIndexRangeText() +
			" in " + typedModel + " for " + region);
	}

	public void buildNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		buildPredicatedNavigationEdgesIndex2(typedModel2property2predicatedEdges);
		buildRealizedNavigationEdgesIndex2(typedModel2property2realizedEdges);
		typedModel2checkedEdges = new HashMap<>();
		typedModel2enforcedEdges = new HashMap<>();
	}

	private void buildPredicatedNavigationEdgesIndex2(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges) {
		for (@NonNull NavigableEdge predicatedEdge : region.getPredicatedNavigationEdges()) {
			if (!predicatedEdge.isCast()) {
				Property property = QVTscheduleUtil.getProperty(predicatedEdge);
				Node predicatedNode = predicatedEdge.getEdgeSource();
				ClassDatum classDatum = RegionUtil.getClassDatum(predicatedNode);
				TypedModel typedModel = RegionUtil.getReferredTypedModel(classDatum);
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
		for (@NonNull NavigableEdge realizedEdge : region.getRealizedNavigationEdges()) {
			Property property = QVTscheduleUtil.getProperty(realizedEdge);
			Node realizedNode = realizedEdge.getEdgeSource();
			ClassDatum classDatum = RegionUtil.getClassDatum(realizedNode);
			TypedModel typedModel = RegionUtil.getReferredTypedModel(classDatum);
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
		//		CompleteModel completeModel = getScheduleModel().getEnvironmentFactory().getCompleteModel();
		boolean doDebug = QVTscheduleConstants.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			QVTscheduleConstants.POLLED_PROPERTIES.println("analyzing " + region + " (" + region.getIndexRangeText() + ")");
		}
		for (@NonNull NavigableEdge predicatedEdge : region.getPredicatedNavigationEdges()) {
			if (!predicatedEdge.isCast()) {
				Property property = predicatedEdge.getProperty();
				if (doDebug) {
					QVTscheduleConstants.POLLED_PROPERTIES.println("  analyzing " + predicatedEdge.getEdgeSource().getName() + "::" + property.getName() + " : " + predicatedEdge.getEdgeSource().getCompleteClass());
				}
				EdgeConnection edgeConnection = predicatedEdge.getIncomingConnection();
				if (edgeConnection != null) {
					boolean isChecked = false;
					for (@NonNull NavigableEdge usedEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
						Region usedRegion = QVTscheduleUtil.getOwningRegion(usedEdge);
						get(usedRegion).addEnforcedEdge(usedEdge);
						if (usedRegion.getFinalExecutionIndex() >= region.getInvocationIndex()) {
							addCheckedEdge(predicatedEdge);
							isChecked = true;
						}
					}
					if (isChecked) {
						for (@NonNull NavigableEdge usedEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
							Region usedRegion = QVTscheduleUtil.getOwningRegion(usedEdge);
							get(usedRegion).addEnforcedEdge(usedEdge);
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
							Property oclContainerProperty = RegionUtil.getScheduleManager(region).getStandardLibraryHelper().getOclContainerProperty();
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
											get(earlierRegion).addEnforcedEdge(realizedEdge);
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
									System.err.println("No realized edges for " + property + " in " + typedModel);
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
										if (!realizedSourceType.conformsTo(predicatedSourceType) || !realizedTargetType.conformsTo(predicatedTargetType)) {
											checkIsHazardFreeBecause = "incompatible";
											enforceIsHazardFreeBecause = "incompatible";
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
											get(earlierRegion).addEnforcedEdge(realizedEdge);
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
	}

	public @Nullable Set<@NonNull NavigableEdge> getCheckedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2checkedEdges != null;
		return typedModel2checkedEdges.get(typedModel);
	}

	public @Nullable Set<@NonNull NavigableEdge> getEnforcedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2enforcedEdges != null;
		return typedModel2enforcedEdges.get(typedModel);
	}

	@Override
	public Notifier getTarget() {
		return region;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == RegionAnalysis.class;
	}

	@Override
	public void notifyChanged(Notification notification) {}

	@Override
	public void setTarget(Notifier newTarget) {}
}