/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *     E.D.Willink - use Complete model
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A ContentsAnalysis provides an analysis of many (all) regions to facilitate lookup of all producers consumers of particular types and properties.
 */
public class ContentsAnalysis<R extends Region>
{
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The Speculation or Realized Nodes that produce each ClassDatum.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull Node>> classDatum2newNodes = new HashMap<>();

	/**
	 * The Regions that produce each ClassDatum.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull R>> classDatum2producingRegions = new HashMap<>();

	/**
	 * The input model classes that may be used as independent inputs by mappings and the nodes at which they are consumed.
	 * In the worst case a flat schedule just permutes allInstances() to provide all mapping inputs.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull Node>> classDatum2oldNodes = new HashMap<>();

	/**
	 * The Regions that consume each ClassDatum.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull R>> classDatum2consumingRegions = new HashMap<>();

	/**
	 * The Realized Edges that produce each PropertyDatum (or its opposite).
	 */
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull List<@NonNull NavigableEdge>> propertyDatum2newEdges = new HashMap<>();

	public ContentsAnalysis(@NonNull ScheduleManager scheduleManager) {
		this.scheduleManager = scheduleManager;
	}

	private void addNewEdge(@NonNull R region, @NonNull NavigableEdge newEdge) {
		PropertyDatum propertyDatum = getPropertyDatum(newEdge);
		addNewEdge(region,newEdge, propertyDatum);
	}
	private void addNewEdge(@NonNull R region, @NonNull NavigableEdge newEdge, @NonNull PropertyDatum propertyDatum) {
		List<@NonNull NavigableEdge> edges = propertyDatum2newEdges.get(propertyDatum);
		if (edges == null) {
			edges = new ArrayList<>();
			propertyDatum2newEdges.put(propertyDatum, edges);
		}
		if (!edges.contains(newEdge)) {
			edges.add(newEdge);
			for (@NonNull PropertyDatum superAbstractDatum : ClassUtil.nullFree(propertyDatum.getSuperPropertyDatums())) {
				addNewEdge(region, newEdge, superAbstractDatum);
			}
		}
	}

	private void addNewNode(@NonNull R region, @NonNull Node newNode) {
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(newNode);
		ClassDatum elementalClassDatum = scheduleManager.getElementalClassDatum(classDatum);
		for (@NonNull ClassDatum superClassDatum : scheduleManager.getSuperClassDatums(elementalClassDatum)) {
			List<@NonNull Node> nodes = classDatum2newNodes.get(superClassDatum);
			if (nodes == null) {
				nodes = new ArrayList<>();
				classDatum2newNodes.put(superClassDatum, nodes);
			}
			List<@NonNull R> regions = classDatum2producingRegions.get(superClassDatum);
			if (regions == null) {
				regions = new ArrayList<>();
				classDatum2producingRegions.put(superClassDatum, regions);
			}
			nodes.add(newNode);
			if (!regions.contains(region)) {
				regions.add(region);
			}
		}
	}

	private void addOldNode(@NonNull R region, @NonNull Node oldNode) {
		//		assert !"EObject".equals(headNode.getCompleteClass().getName());
		//		Region region = oldNode.getRegion();
		//		Region invokingRegion = region.getInvokingRegion();
		//		assert (invokingRegion == this) || (invokingRegion == null);
		//		ClassDatumAnalysis classDatumAnalysis = QVTscheduleUtil.getClassDatumAnalysis(oldNode);
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(oldNode);
		List<@NonNull Node> nodes = classDatum2oldNodes.get(classDatum);
		if (nodes == null) {
			nodes = new ArrayList<>();
			classDatum2oldNodes.put(classDatum, nodes);
		}
		List<@NonNull R> regions = classDatum2consumingRegions.get(classDatum);
		if (regions == null) {
			regions = new ArrayList<>();
			classDatum2consumingRegions.put(classDatum, regions);
		}
		if (!nodes.contains(oldNode)) {
			nodes.add(oldNode);
		}
		if (!regions.contains(region)) {
			regions.add(region);
		}
	}

	public void addRegion(@NonNull R region) {
		for (@NonNull Node oldNode : region.getOldNodes()) {
			if (!oldNode.isDependency() && !oldNode.isConstant()) {
				if (oldNode.isHead()) {
					//					if (oldNode.isLoaded()) {
					addOldNode(region, oldNode);
					//					}
				}
				else {
					//					if (!oldNode.isLoaded()) {
					if (!isOnlyCastOrRecursed(oldNode)) {			// FIXME Eliminate cast nodes
						addOldNode(region, oldNode);
					}
					//					}
				}
			}
		}
		for (@NonNull Node newNode : region.getNewNodes()) {
			if (newNode.isClass()) {
				addNewNode(region, newNode);
			}
		}
		for (@NonNull NavigableEdge newEdge : region.getRealizedNavigationEdges()) {
			addNewEdge(region, newEdge);
		}
	}

	/*	private @Nullable PropertyDatum basicGetPropertyDatum(@NonNull NavigableEdge producedEdge) {
		assert !producedEdge.isCast();				// Handled by caller
		Property forwardProperty = QVTscheduleUtil.getProperty(producedEdge);
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(producedEdge.getEdgeSource());
		ClassDatum forwardClassDatum = scheduleManager.getElementalClassDatum(classDatum);
		return scheduleManager.getPropertyDatum(forwardClassDatum, forwardProperty);
	} */

	public @NonNull String dumpClass2newNode() {
		StringBuilder s = new StringBuilder();
		List<@NonNull ClassDatum> classDatums = new ArrayList<>(classDatum2newNodes.keySet());
		Collections.sort(classDatums, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull ClassDatum classDatum : classDatums) {
			s.append("\n\t" + classDatum + " : ");
			List<@NonNull Node> newNodes = new ArrayList<>(classDatum2newNodes.get(classDatum));
			Collections.sort(newNodes, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull Node newNode : newNodes) {
				s.append("\n\t\t" + newNode.getDisplayName());
			}
		}
		return s.toString();
	}

	public @NonNull String dumpClass2oldNode() {
		StringBuilder s = new StringBuilder();
		List<@NonNull ClassDatum> classDatums = new ArrayList<>(classDatum2oldNodes.keySet());
		Collections.sort(classDatums, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull ClassDatum classDatum : classDatums) {
			s.append("\n\t" + classDatum + " : ");
			List<@NonNull Node> oldNodes = new ArrayList<>(classDatum2oldNodes.get(classDatum));
			Collections.sort(oldNodes, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull Node oldNode : oldNodes) {
				s.append("\n\t\t" + oldNode.getDisplayName());
			}
		}
		return s.toString();
	}

	/**
	 * Return all Realized NavigationEdges corresponding to predicatedEdge that navigate an isComposite property in either direction.
	 * Returns null in the very unusual event that there are none.
	 *
	 * It is assumed that edge is an predicated oclContainer edge to which almost all containment edges are compatible for a pathological
	 * input model whose metamodel extends the transformed metamodel with derived classes that merge the containment relationship
	 * of predicated/realized candidates.
	 *
	 * FIXME In the event that the ends of the realized edges are realized variables, we do know the precise
	 * type and could filter accordingly; a not-yet-exploited optimisation.
	 */
	private @Nullable Iterable<@NonNull NavigableEdge> getCompositeNewEdges(@NonNull NavigableEdge predicatedEdge) {
		Set<@NonNull NavigableEdge> realizedEdges = null;
		for (Map.Entry<@NonNull PropertyDatum, @NonNull List<@NonNull NavigableEdge>> entry : propertyDatum2newEdges.entrySet()) {
			Property property = entry.getKey().getReferredProperty();
			if (property != null) {
				@Nullable Property compositeProperty = null;
				if (property.isIsComposite()) {
					compositeProperty = property;
				}
				else {
					Property oppositeProperty = property.getOpposite();
					if ((oppositeProperty != null) && oppositeProperty.isIsComposite()) {
						compositeProperty = oppositeProperty;
					}
				}
				if (compositeProperty != null) {
					if (realizedEdges == null) {
						realizedEdges = new HashSet<>();
					}
					realizedEdges.addAll(entry.getValue());
				}
			}
		}
		return realizedEdges;
	}

	public @NonNull Iterable<@NonNull R> getConsumingRegions(@NonNull ClassDatum classDatum) {
		List<@NonNull R> consumingRegions = classDatum2consumingRegions.get(classDatum);
		return consumingRegions != null ? consumingRegions : Collections.emptyList();
	}

	public @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatum requiredClassDatum) {
		Property property = edge.getProperty();
		if (property.eContainer() == null) {			// Ignore pseudo-properties such as «iterate»
			return null;
		}
		if (property == scheduleManager.getStandardLibraryHelper().getOclContainerProperty()) {
			return getCompositeNewEdges(edge);
		}
		PropertyDatum propertyDatum = getPropertyDatum(edge);
		//		if (propertyDatum == null) {
		//			propertyDatum = basicGetPropertyDatum(edge);				// FIXME debugging
		//		}
		//		if (propertyDatum == null) {			// May be null for edges only used by operation dependencies
		//			return null;
		//		}
		Iterable<@NonNull NavigableEdge> realizedEdges = propertyDatum2newEdges.get(propertyDatum);
		if (realizedEdges == null) {
			return null;
		}
		CompleteClass requiredClass = QVTscheduleUtil.getCompleteClass(requiredClassDatum);
		List<@NonNull NavigableEdge> conformantRealizedEdges = null;
		for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
			Node targetNode = realizedEdge.getEdgeTarget();
			CompleteClass realizedClass = targetNode.getCompleteClass();
			if (QVTscheduleUtil.conformsToClassOrBehavioralClass(realizedClass, requiredClass)) {
				if (conformantRealizedEdges == null) {
					conformantRealizedEdges = new ArrayList<>();
				}
				conformantRealizedEdges.add(realizedEdge);
			}
		}
		return conformantRealizedEdges;
	}

	public @Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatum classDatum) {
		return classDatum2newNodes.get(classDatum);
	}

	public @Nullable Iterable<@NonNull Node> getOldNodes(@NonNull ClassDatum classDatum) {
		return classDatum2oldNodes.get(classDatum);
	}

	public @NonNull Iterable<@NonNull R> getProducingRegions(@NonNull ClassDatum classDatum) {
		List<@NonNull R> producingRegions = classDatum2producingRegions.get(classDatum);
		return producingRegions != null ? producingRegions : Collections.emptyList();
	}

	private @NonNull PropertyDatum getPropertyDatum(@NonNull NavigableEdge producedEdge) {
		assert !producedEdge.isCast();				// Handled by caller
		Property forwardProperty = QVTscheduleUtil.getProperty(producedEdge);
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(producedEdge.getEdgeSource());
		ClassDatum forwardClassDatum = scheduleManager.getElementalClassDatum(classDatum);
		return scheduleManager.getPropertyDatum(forwardClassDatum, forwardProperty);
	}

	/**
	 * Return true if this node is consumed solely by casts (or recursions) and so need not be considered as a true consumer.
	 * The downstream usages will consume more accurately.
	 */
	private boolean isOnlyCastOrRecursed(@NonNull Node predicatedNode) {
		boolean isCast = false;
		for (Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(predicatedNode)) {
			if (!outgoingEdge.isCast() && !outgoingEdge.isRecursion()) {
				return false;
			}
			isCast = true;
		}
		return isCast;
	}

	private void removeNewEdge(@NonNull NavigableEdge newEdge) {
		PropertyDatum propertyDatum = getPropertyDatum(newEdge);
		removeNewEdge(newEdge, propertyDatum);
	}
	private void removeNewEdge(@NonNull NavigableEdge newEdge, @NonNull PropertyDatum propertyDatum) {
		List<@NonNull NavigableEdge> edges = propertyDatum2newEdges.get(propertyDatum);
		if (edges != null) {
			if (edges.remove(newEdge)) {
				for (@NonNull PropertyDatum superAbstractDatum : ClassUtil.nullFree(propertyDatum.getSuperPropertyDatums())) {
					removeNewEdge(newEdge, superAbstractDatum);
				}
			}
		}
	}

	private void removeNewNode(@NonNull Node newNode) {
		List<@NonNull Node> nodes = classDatum2newNodes.get(newNode.getClassDatum());
		if (nodes != null) {
			nodes.remove(newNode);
		}
	}

	private void removeOldNode(@NonNull Node oldNode) {
		List<@NonNull Node> nodes = classDatum2oldNodes.get(oldNode.getClassDatum());
		if (nodes != null) {
			nodes.remove(oldNode);
		}
	}

	public void removeRegion(@NonNull R region) {
		for (@NonNull Node oldNode : region.getOldNodes()) {
			removeOldNode(oldNode);
		}
		for (@NonNull Node newNode : region.getNewNodes()) {
			removeNewNode(newNode);
		}
		for (@NonNull NavigableEdge newEdge : region.getRealizedNavigationEdges()) {
			removeNewEdge(newEdge);
		}
	}
}
