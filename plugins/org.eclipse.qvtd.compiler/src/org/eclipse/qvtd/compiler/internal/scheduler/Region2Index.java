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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 * Region2Index determines an earliest and latest schedule index for some regions.
 */
public class Region2Index
{
	/**
	 * The lazily computed parents (invokers) of each edge.
	 */
	private @NonNull Map<Region, Iterable<Region>> region2callingRegions = new HashMap<Region, Iterable<Region>>();

	/**
	 * The lazily computed map of the caller to called region ancestry of each region.
	 */
	private @NonNull Map<Region, Map<Region, List<Region>>> region2ancestorRegion2calledRegions = new HashMap<Region, Map<Region, List<Region>>>();

	/**
	 * The map for all regions with child indexes from used region to possibly repeated called region.
	 */
	private @NonNull Map<Region, Map<Region, List<Region>>> region2earlierRegion2mandatoryLaterRegions = new HashMap<Region, Map<Region, List<Region>>>();
	private @NonNull Map<Region, Map<Region, List<Region>>> region2earlierRegion2preferredLaterRegions = new HashMap<Region, Map<Region, List<Region>>>();

	private @NonNull Map<Region, Integer> region2earliestIndex = new HashMap<Region, Integer>();
	private @NonNull Map<Region, Integer> region2latestIndex = new HashMap<Region, Integer>();

	/**
	 * The ordering of called region for each region.
	 */
	private @NonNull Map<Region, List<Region>> region2sortedCalledRegions = new HashMap<Region, List<Region>>();

	/**
	 * Accumulate an ordering that requires earlierRegion to be computed before laterRegion at commonREgion.
	 */
	private void accumulateOrdering(@NonNull Region commonRegion, @NonNull Region earlierRegion, @NonNull Region laterRegion, int mandatoryUses, int preferredUses) {
		Scheduler.EDGE_ORDER.println("        " + mandatoryUses + ":" + preferredUses + " * " + earlierRegion.getName() + " before " + laterRegion.getName());
		if (mandatoryUses > 0) {
			Map<Region, List<Region>> earlierRegion2laterRegions = region2earlierRegion2mandatoryLaterRegions.get(commonRegion);
			if (earlierRegion2laterRegions == null) {
				earlierRegion2laterRegions = new HashMap<Region, List<Region>>();
				region2earlierRegion2mandatoryLaterRegions.put(commonRegion, earlierRegion2laterRegions);
			}
			List<Region> laterRegions = earlierRegion2laterRegions.get(earlierRegion);
			if (laterRegions == null) {
				laterRegions = new ArrayList<Region>();
				earlierRegion2laterRegions.put(earlierRegion, laterRegions);
			}
			for (int i = 0; i < mandatoryUses; i++) {
				laterRegions.add(laterRegion);		// Multiple entries are counted and voted upon
			}
		}
		if (preferredUses > 0) {
			Map<Region, List<Region>> earlierRegion2laterRegions = region2earlierRegion2preferredLaterRegions.get(commonRegion);
			if (earlierRegion2laterRegions == null) {
				earlierRegion2laterRegions = new HashMap<Region, List<Region>>();
				region2earlierRegion2preferredLaterRegions.put(commonRegion, earlierRegion2laterRegions);
			}
			List<Region> laterRegions = earlierRegion2laterRegions.get(earlierRegion);
			if (laterRegions == null) {
				laterRegions = new ArrayList<Region>();
				earlierRegion2laterRegions.put(earlierRegion, laterRegions);
			}
			for (int i = 0; i < preferredUses; i++) {
				laterRegions.add(laterRegion);		// Multiple entries are counted and voted upon
			}
		}
	}
	
	private int assignEarliestAndLatestScheduleIndexes(int index, @NonNull Region region) {
		Integer earliestIndex = region2earliestIndex.get(region);
		if (earliestIndex == null) {
			region2earliestIndex.put(region, index);
		}
		else {
			assert index > earliestIndex;
		}
		Integer latestIndex = region2latestIndex.get(region);
		if (latestIndex != null) {
			assert index > latestIndex;
		}
		region2latestIndex.put(region, index);
		Scheduler.REGION_TRAVERSAL.println(index + "/" + earliestIndex + ".." + "N-" + latestIndex +  " : " + region);
		List<Region> allCalledRegions = getSortedCalledRegions(region);
		for (@SuppressWarnings("null")@NonNull Region calledRegion : allCalledRegions) {
			index = assignEarliestAndLatestScheduleIndexes(++index, calledRegion);
		}
		return index;
	}

	public void computeRegionIndexes(@NonNull Iterable<Region> callableRegions) {
		throw new UnsupportedOperationException();
/*		//
		//	For each region, for each passed binding, propagate a dependency that the passed binding should be after
		//	each used binding in the region. The propagation follows the ancestry of the region to put a dependency
		//	at each node that sources both passed and used bindings.
		//
		for (@SuppressWarnings("null")@NonNull Region region : callableRegions) {
			assert !region.isConnectionRegion();
			Scheduler.EDGE_ORDER.println(region.getName());
//			@NonNull Map<Region, Integer> earlierRegion2uses = region.getUsedRegions();
			@NonNull Set<Region> earlierRegions = new HashSet<Region>();
			@NonNull Map<Region, Integer> earlierRegion2mandatoryUses = new HashMap<Region, Integer>();
			@NonNull Map<Region, Integer> earlierRegion2preferredUses = new HashMap<Region, Integer>();
			@NonNull List<Connection> usedConnections = region.getUsedConnections();
			for (Connection usedConnection : usedConnections) {
				boolean isMandatory = usedConnection.isMandatory();
				@NonNull Map<Region, Integer> earlierRegion2Uses = isMandatory ? earlierRegion2mandatoryUses : earlierRegion2preferredUses;
				for (Node source : usedConnection.getSources()) {
				if (sourceOrConnection.isConnection()) {
					for (Connection connectionConnection : sourceOrConnection.getIncomingPassedConnections()) {
						Node source = connectionConnection.getSource();
						Region earlierRegion = source.getRegion();
						earlierRegions.add(earlierRegion);
						Integer uses = earlierRegion2Uses.get(earlierRegion);
						earlierRegion2Uses.put(earlierRegion, uses != null ? uses+1 : 1);
					}
				}
				else {
					Region earlierRegion = sourceOrConnection.getRegion();
					earlierRegions.add(earlierRegion);
					Integer uses = earlierRegion2Uses.get(earlierRegion);
					earlierRegion2Uses.put(earlierRegion, uses != null ? uses+1 : 1);
				}
			}
			
			@NonNull Iterable<Region> laterRegions = region.getCallingRegions();
			for (@SuppressWarnings("null")@NonNull Region earlierRegion : earlierRegions) {
				Integer mandatoryUses1 = earlierRegion2mandatoryUses.get(earlierRegion);
				Integer preferredUses1 = earlierRegion2preferredUses.get(earlierRegion);
				int mandatoryUses = mandatoryUses1 != null ? mandatoryUses1.intValue() : 0;
				int preferredUses = preferredUses1 != null ? preferredUses1.intValue() : 0;
				Scheduler.EDGE_ORDER.println("  uses: " + mandatoryUses + ":" + preferredUses + " * " + earlierRegion.getName());
				Map<Region, List<Region>> earlierRegion2regions = getRegion2CalledRegions(earlierRegion);
				Set<Region> earlierAncestorRegions = earlierRegion2regions.keySet();
				for (@NonNull Region laterRegion : laterRegions) {
					Scheduler.EDGE_ORDER.println("    by: " + laterRegion.getName());
					Map<Region, List<Region>> laterRegion2regions = getRegion2CalledRegions(region);
					Set<Region> commonAncestorRegions = new HashSet<Region>(laterRegion2regions.keySet());
					commonAncestorRegions.retainAll(earlierAncestorRegions);
					for (@SuppressWarnings("null")@NonNull Region commonAncestorRegion : commonAncestorRegions) {
						Scheduler.EDGE_ORDER.println("      at: " + commonAncestorRegion.getName());
						for (@SuppressWarnings("null")@NonNull Region earlierCommonAncestorRegion : earlierRegion2regions.get(commonAncestorRegion)) {
							for (@SuppressWarnings("null")@NonNull Region laterCommonAncestorRegion : laterRegion2regions.get(commonAncestorRegion)) {
								if (laterCommonAncestorRegion != earlierCommonAncestorRegion) {
									accumulateOrdering(commonAncestorRegion, earlierCommonAncestorRegion, laterCommonAncestorRegion, mandatoryUses, preferredUses);
								}
							}
						}
					}
				}
			}
		}
		//
		//	Sort the child regions of each region to maximise the number of earlier/later satisfied pairings.
		//
//		for (Entry<Region, Map<Region, List<Region>>> entry : region2earlierRegion2laterRegions.entrySet()) {
		for (Region region : callableRegions) {
			Map<Region, List<Region>> earlierRegion2mandatoryLaterRegions = region2earlierRegion2mandatoryLaterRegions.get(region);
			Map<Region, List<Region>> earlierRegion2preferredLaterRegions = region2earlierRegion2preferredLaterRegions.get(region);
			Set<Region> earlierRegions = new HashSet<Region>();
			if (earlierRegion2mandatoryLaterRegions != null) {
				earlierRegions.addAll(earlierRegion2mandatoryLaterRegions.keySet());
			}
			if (earlierRegion2preferredLaterRegions != null) {
				earlierRegions.addAll(earlierRegion2preferredLaterRegions.keySet());
			}
			final Map<Region, Integer> calledRegion2mandatoryScore = new HashMap<Region, Integer>();
			final Map<Region, Integer> calledRegion2preferredScore = new HashMap<Region, Integer>();
			for (Region earlierRegion : earlierRegions) {
				List<Region> mandatoryLaterRegions = earlierRegion2mandatoryLaterRegions != null ? earlierRegion2mandatoryLaterRegions.get(earlierRegion) : null;
				List<Region> preferredLaterRegions = earlierRegion2preferredLaterRegions != null ? earlierRegion2preferredLaterRegions.get(earlierRegion) : null;
				if (mandatoryLaterRegions == null) {
					mandatoryLaterRegions = Collections.emptyList();
				}
				if (preferredLaterRegions == null) {
					preferredLaterRegions = Collections.emptyList();
				}
				Integer mandatoryScore = calledRegion2mandatoryScore.get(earlierRegion);
				Integer preferredScore = calledRegion2preferredScore.get(earlierRegion);
				calledRegion2mandatoryScore.put(earlierRegion, (mandatoryScore != null ? mandatoryScore.intValue() : 0) + mandatoryLaterRegions.size());
				calledRegion2preferredScore.put(earlierRegion, (preferredScore != null ? preferredScore.intValue() : 0) + preferredLaterRegions.size());
				for (Region mandatoryLaterRegion : mandatoryLaterRegions) {
					mandatoryScore = calledRegion2mandatoryScore.get(mandatoryLaterRegion);
					calledRegion2mandatoryScore.put(mandatoryLaterRegion, (mandatoryScore != null ? mandatoryScore.intValue() : 0) - 1);
				}
				for (Region preferredLaterRegion : preferredLaterRegions) {
					preferredScore = calledRegion2preferredScore.get(preferredLaterRegion);
					calledRegion2preferredScore.put(preferredLaterRegion, (preferredScore != null ? preferredScore.intValue() : 0) - 1);
				}
			}
			List<Region> sortedCalledRegions = new ArrayList<Region>(calledRegion2mandatoryScore.keySet());
			Collections.sort(sortedCalledRegions, new Comparator<Region>()
			{
				@Override
				public int compare(Region o1, Region o2) {
					int s1 = calledRegion2mandatoryScore.get(o1);
					int s2 = calledRegion2mandatoryScore.get(o2);
					if (s1 != s2) {
						return s2 - s1;			// most positive first
					}
					s1 = calledRegion2preferredScore.get(o1);
					s2 = calledRegion2preferredScore.get(o2);
					if (s1 != s2) {
						return s2 - s1;			// most positive first
					}
					return ClassUtil.safeCompareTo(o1.toString(), o2.toString());
				}
			});
			region2sortedCalledRegions.put(region, sortedCalledRegions);
			Scheduler.EDGE_ORDER.println(region.toString());
			for (Region calledRegion : sortedCalledRegions) {
				List<Region> mandatoryLaterRegions = earlierRegion2mandatoryLaterRegions != null ? earlierRegion2mandatoryLaterRegions.get(calledRegion) : null;
				List<Region> preferredLaterRegions = earlierRegion2preferredLaterRegions != null ? earlierRegion2preferredLaterRegions.get(calledRegion) : null;
				int mandatorySize = mandatoryLaterRegions != null ? mandatoryLaterRegions.size() : 0;
				int preferredSize = preferredLaterRegions != null ? preferredLaterRegions.size() : 0;
				Scheduler.EDGE_ORDER.println("  " + calledRegion2mandatoryScore.get(calledRegion) + "/" + mandatorySize + "," + calledRegion2preferredScore.get(calledRegion) + "/" + preferredSize + " : " + calledRegion.getName());
			}
		}
		//
		//	Perform a schedule traversal to assign schedule indexes
		//
		for (Region region : callableRegions) {
			if (region.isRootRegion()) {
				assignEarliestAndLatestScheduleIndexes(0, region);
			}
		}
		//
		//	Assign the per-region schedule index ranges.
		//
		for (Region region : callableRegions) {
			Integer earliestIndex = region2earliestIndex.get(region);
			Integer latestIndex = region2latestIndex.get(region);
			region.setIndexes(earliestIndex, latestIndex);
		}
		Iterable<Region> sortedCallableRegions = AbstractRegion.EarliestRegionComparator.sort(callableRegions);
		//
		//	Print out the per-region schedule index ranges.
		//
		for (Region region : sortedCallableRegions) {
			Integer earliestIndex = region2earliestIndex.get(region);
			Integer latestIndex = region2latestIndex.get(region);
			Scheduler.REGION_ORDER.println(earliestIndex + ".." + latestIndex + " " + region);
		}
		//
		//	Index all predicated and realized edges by typed model and property.
		//
		Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2predicatedEdges = new HashMap<TypedModel, Map<Property, List<NavigationEdge>>>();
		Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2realizedEdges = new HashMap<TypedModel, Map<Property, List<NavigationEdge>>>();
		for (@SuppressWarnings("null")@NonNull Region region : sortedCallableRegions) {
			QVTs2QVTiVisitor.POLLED_PROPERTIES.println("building indexes for " + region + " " + region.getEarliestIndex() + ".." + region.getLatestIndex());
			region.buildPredicatedNavigationEdgesIndex(typedModel2property2predicatedEdges);
			region.buildRealizedNavigationEdgesIndex(typedModel2property2realizedEdges);
		}
		//
		//
		//
/ *		boolean doDebug = QVTs2QVTiVisitor.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			for (TypedModel typedModel : typedModel2property2predicatedEdges.keySet()) {
				Map<Property, List<NavigationEdge>> property2predicatedEdges = typedModel2property2predicatedEdges.get(typedModel);
				for (Property property : property2predicatedEdges.keySet()) {
					List<NavigationEdge> predicatedEdges = property2predicatedEdges.get(property);
					for (NavigationEdge predicatedEdge : predicatedEdges) {
						Region region = predicatedEdge.getRegion();
						QVTs2QVTiVisitor.POLLED_PROPERTIES.println(typedModel + " predicated at " + region.getEarliestIndex()
						+ ".." + region.getLatestIndex() + " for " + property + " in " + region);
					}
				}
			}
			for (TypedModel typedModel : typedModel2property2realizedEdges.keySet()) {
				Map<Property, List<NavigationEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
				for (Property property : property2realizedEdges.keySet()) {
					List<NavigationEdge> realizedEdges = property2realizedEdges.get(property);
					for (NavigationEdge realizedEdge : realizedEdges) {
						Region region = realizedEdge.getRegion();
						QVTs2QVTiVisitor.POLLED_PROPERTIES.println(typedModel + " realized at " + region.getEarliestIndex()
						+ ".." + region.getLatestIndex() + " for " + property + " in " + region);
					}
				}
			}
		} * /
		for (@SuppressWarnings("null")@NonNull Region region : sortedCallableRegions) {
			region.computeCheckedOrEnforcedEdges(typedModel2property2predicatedEdges, typedModel2property2realizedEdges);
		} */
	}

/*	private @NonNull Iterable<Region> getCalledRegions(@NonNull Region callingRegion) {
		Iterable<Region> calledRegions = region2callingRegions.get(callingRegion);
		if (calledRegions == null) {
			calledRegions = callingRegion.getCalledRegions();
			region2callingRegions.put(callingRegion, calledRegions);
		}
		return calledRegions;
	} */

	private @NonNull Iterable<Region> getCallingRegions(@NonNull Region calledRegion) {
		Iterable<Region> callingRegions = region2callingRegions.get(calledRegion);
		if (callingRegions == null) {
			callingRegions = calledRegion.getCallingRegions();
			region2callingRegions.put(calledRegion, callingRegions);
		}
		return callingRegions;
	}

/*	private @NonNull Set<Region> getAllCallingRegions(@NonNull Region calledRegion) {
		Set<Region> allCallingRegions = region2allCallingRegions.get(calledRegion);
		if (allCallingRegions == null) {
			allCallingRegions = new HashSet<Region>();
			getAllCallingRegions(calledRegion, allCallingRegions);
			region2allCallingRegions.put(calledRegion, allCallingRegions);
		}
		return allCallingRegions;
	}
	private void getAllCallingRegions(@NonNull Region calledRegion, @NonNull Set<Region> allCallingRegions) {
		for (@SuppressWarnings("null")@NonNull Region callingRegion : getCallingRegions(calledRegion)) {
			if (allCallingRegions.add(callingRegion)) {
				getAllCallingRegions(callingRegion, allCallingRegions);
			}
		}
	} */

	/**
	 * Return a lazily computed Map from all the ancestor regions of calledRegion to all their child regions that form part of the ancestry of the region.
	 */
	private @NonNull Map<Region, List<Region>> getRegion2CalledRegions(@NonNull Region calledRegion) {
		Map<Region, List<Region>> ancestorRegion2calledRegions = region2ancestorRegion2calledRegions.get(calledRegion);
		if (ancestorRegion2calledRegions == null) {
			ancestorRegion2calledRegions = new HashMap<Region, List<Region>>();
//			ancestorRegion2calledRegions.put(calledRegion, new ArrayList<Region>());
			for (@SuppressWarnings("null")@NonNull Region callingRegion : getCallingRegions(calledRegion)) {
				List<Region> calledRegions = ancestorRegion2calledRegions.get(callingRegion);
				if (calledRegions == null) {
					calledRegions = new ArrayList<Region>();
					ancestorRegion2calledRegions.put(callingRegion, calledRegions);
				}
				if (!calledRegions.contains(calledRegion)) {
					calledRegions.add(calledRegion);
				}
				for (@SuppressWarnings("null")Map.@NonNull Entry<Region, List<Region>> ancestor : getRegion2CalledRegions(callingRegion).entrySet()) {
					Region ancestorCallingRegion = ancestor.getKey();
					List<Region> ancestorCalledRegions = ancestorRegion2calledRegions.get(ancestorCallingRegion);
					if (ancestorCalledRegions == null) {
						ancestorCalledRegions = new ArrayList<Region>();
						ancestorRegion2calledRegions.put(ancestorCallingRegion, ancestorCalledRegions);
					}
					for (Region ancestorCalledRegion : ancestor.getValue()) {
						if (!ancestorCalledRegions.contains(ancestorCalledRegion)) {
							ancestorCalledRegions.add(ancestorCalledRegion);
						}
					}
				}
			}
			region2ancestorRegion2calledRegions.put(calledRegion, ancestorRegion2calledRegions);
		}
		return ancestorRegion2calledRegions;
	}

	/**
	 * Return the called region of region in sorted order. Explicitly ordered first, unordered last in alphabetical order.
	 */
	private @NonNull List<Region> getSortedCalledRegions(@NonNull Region callingRegion) {
		List<Region> sortedCalledRegions = region2sortedCalledRegions.get(callingRegion);
		List<Region> allCalledRegions = new ArrayList<Region>();
		if (sortedCalledRegions != null) {
			allCalledRegions.addAll(sortedCalledRegions);
		}
		List<Region> extraRegions = null;
		for (Region calledRegion : callingRegion.getCalledRegions()) {
			if (!allCalledRegions.contains(calledRegion)) {
				if (extraRegions == null) {
					extraRegions = new ArrayList<Region>();
				}
				if (!extraRegions.contains(calledRegion)) {
					extraRegions.add(calledRegion);
				}
			}
		}
		if (extraRegions != null) {
			if (extraRegions.size() > 1) {
				Collections.sort(extraRegions, NameUtil.NAMEABLE_COMPARATOR);
			}
			allCalledRegions.addAll(extraRegions);
		}
		return allCalledRegions;
	}
}