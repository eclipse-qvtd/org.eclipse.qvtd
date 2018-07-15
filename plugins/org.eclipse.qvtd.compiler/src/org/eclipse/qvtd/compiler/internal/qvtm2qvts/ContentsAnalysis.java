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
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Sets;

/**
 * A ContentsAnalysis provides an analysis of many (all) regions to facilitate lookup of all producers consumers of particular types and properties.
 */
public class ContentsAnalysis
{
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The Speculation or Realized Nodes that produce each ClassDatum.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull Node>> classDatum2newNodes = new HashMap<>();

	/**
	 * The input model classes that may be used as independent inputs by mappings and the nodes at which they are consumed.
	 * In the worst case a flat schedule just permutes allInstances() to provide all mapping inputs.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull Node>> classDatum2oldNodes = new HashMap<>();

	/**
	 * The Realized Edges that produce each PropertyDatum (or its opposite).
	 */
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull List<@NonNull NavigableEdge>> propertyDatum2newEdges = new HashMap<>();

	public ContentsAnalysis(@NonNull ScheduleManager scheduleManager) {
		this.scheduleManager = scheduleManager;
	}

	private void addNewEdge(@NonNull NavigableEdge newEdge) {
		PropertyDatum propertyDatum = basicGetPropertyDatum(newEdge);
		if (propertyDatum == null) {
			propertyDatum = basicGetPropertyDatum(newEdge);		// FIXME debugging
		}
		assert propertyDatum != null;
		addNewEdge(newEdge, propertyDatum);
	}
	private void addNewEdge(@NonNull NavigableEdge newEdge, @NonNull PropertyDatum propertyDatum) {
		List<@NonNull NavigableEdge> edges = propertyDatum2newEdges.get(propertyDatum);
		if (edges == null) {
			edges = new ArrayList<>();
			propertyDatum2newEdges.put(propertyDatum, edges);
		}
		if (!edges.contains(newEdge)) {
			edges.add(newEdge);
			for (@NonNull PropertyDatum superAbstractDatum : ClassUtil.nullFree(propertyDatum.getSuperPropertyDatums())) {
				addNewEdge(newEdge, superAbstractDatum);
			}
		}
	}

	private void addNewNode(@NonNull Node newNode) {
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(newNode);
		ClassDatum elementalClassDatum = scheduleManager.getElementalClassDatum(classDatum);
		for (@NonNull ClassDatum superClassDatum : scheduleManager.getSuperClassDatums(elementalClassDatum)) {
			List<@NonNull Node> nodes = classDatum2newNodes.get(superClassDatum);
			if (nodes == null) {
				nodes = new ArrayList<>();
				classDatum2newNodes.put(superClassDatum, nodes);
			}
			nodes.add(newNode);
		}
	}

	private void addOldNode(@NonNull Node oldNode) {
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
		if (!nodes.contains(oldNode)) {
			nodes.add(oldNode);
		}
	}

	public void addRegion(@NonNull Region region) {
		for (@NonNull Node oldNode : region.getOldNodes()) {
			if (!oldNode.isDependency() && !oldNode.isConstant()) {
				if (oldNode.isHead()) {
					//					if (oldNode.isLoaded()) {
					addOldNode(oldNode);
					//					}
				}
				else {
					//					if (!oldNode.isLoaded()) {
					if (!isOnlyCastOrRecursed(oldNode)) {			// FIXME Eliminate cast nodes
						addOldNode(oldNode);
					}
					//					}
				}
			}
		}
		for (@NonNull Node newNode : region.getNewNodes()) {
			if (newNode.isClass()) {
				addNewNode(newNode);
			}
		}
		for (@NonNull NavigableEdge newEdge : region.getRealizedNavigationEdges()) {
			addNewEdge(newEdge);
		}
	}

	private @Nullable PropertyDatum basicGetPropertyDatum(@NonNull NavigableEdge producedEdge) {
		assert !producedEdge.isCast();				// Handled by caller
		Property forwardProperty = producedEdge.getProperty();
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(producedEdge.getEdgeSource());
		ClassDatum forwardClassDatum = scheduleManager.getElementalClassDatum(classDatum);
		//		PropertyDatum forwardPropertyDatum = getScheduleModel().getPropertyDatum(forwardClassDatum, property);
		//		if (forwardPropertyDatum.getClassDatum() == forwardClassDatum) {
		//			return forwardPropertyDatum;
		//		}
		Iterable<@NonNull PropertyDatum> forwardPropertyDatums = scheduleManager.getAllPropertyDatums(forwardClassDatum);
		for (PropertyDatum propertyDatum : forwardPropertyDatums) {
			if ((propertyDatum.getReferredProperty() == forwardProperty) && (propertyDatum.getOwningClassDatum() == forwardClassDatum)) {
				return propertyDatum;
			}
		}
		PropertyDatum bestPropertyDatum = null;
		for (PropertyDatum propertyDatum : forwardPropertyDatums) {
			if (propertyDatum.getReferredProperty() == forwardProperty) {
				if (bestPropertyDatum == null) {
					bestPropertyDatum = propertyDatum;
				}
				else {
					CompleteClass completeClass = propertyDatum.getOwningClassDatum().getCompleteClass();
					assert completeClass != null;
					Set<@NonNull CompleteClass> allSuperCompleteClasses = Sets.newHashSet(completeClass.getProperSuperCompleteClasses());
					if (allSuperCompleteClasses.contains(bestPropertyDatum.getOwningClassDatum().getCompleteClass())) {
						bestPropertyDatum = propertyDatum;
					}
				}
			}
		}
		if (bestPropertyDatum != null) {
			return bestPropertyDatum;
		}
		Property reverseProperty = forwardProperty.getOpposite();
		classDatum = QVTscheduleUtil.getClassDatum(producedEdge.getEdgeTarget());
		ClassDatum reverseClassDatum = scheduleManager.getElementalClassDatum(classDatum);
		Iterable<@NonNull PropertyDatum> reversePropertyDatums = scheduleManager.getAllPropertyDatums(reverseClassDatum);
		for (PropertyDatum propertyDatum : reversePropertyDatums) {
			if ((propertyDatum.getReferredProperty() == reverseProperty) && (propertyDatum.getOwningClassDatum() == reverseClassDatum)) {
				return propertyDatum;
			}
		}
		for (PropertyDatum propertyDatum : reversePropertyDatums) {
			if (propertyDatum.getReferredProperty() == reverseProperty) {
				if (bestPropertyDatum == null) {
					bestPropertyDatum = propertyDatum;
				}
				else {
					CompleteClass completeClass = propertyDatum.getOwningClassDatum().getCompleteClass();
					assert completeClass != null;
					Set<@NonNull CompleteClass> allSuperCompleteClasses = Sets.newHashSet(completeClass.getProperSuperCompleteClasses());
					if (allSuperCompleteClasses.contains(bestPropertyDatum.getOwningClassDatum().getCompleteClass())) {
						bestPropertyDatum = propertyDatum;
					}
				}
			}
		}
		if (bestPropertyDatum != null) {
			return bestPropertyDatum;
		}
		return null;
	}

	public Stream<String> dumpClass2oldNode() {
		Stream<String> entries = classDatum2oldNodes.keySet().stream().map(
			k -> {
				List<Node> list = classDatum2oldNodes.get(k);
				assert list != null;
				return String.valueOf(k) + " : " + list.stream().map(
					p -> p.getDisplayName()
						).sorted().reduce("", QVTscheduleUtil.stringJoin("\n\t\t"));
			}
				);
		return entries.sorted();
	}

	public Stream<String> dumpClass2newNode() {
		Stream<String> entries = classDatum2newNodes.keySet().stream().map(
			k -> {
				List<Node> list = classDatum2newNodes.get(k);
				assert list != null;
				return scheduleManager.getDomainUsage(k) + " " + String.valueOf(k) + " : " +
				list.stream().map(
					p -> p.getDisplayName()
						).sorted().reduce("", QVTscheduleUtil.stringJoin("\n\t\t")
								);
			}
				);
		return entries.sorted();
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

	public @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatum requiredClassDatum) {
		Property property = edge.getProperty();
		if (property.eContainer() == null) {			// Ignore pseudo-properties such as «iterate»
			return null;
		}
		PropertyDatum propertyDatum = basicGetPropertyDatum(edge);
		if (propertyDatum == null) {
			if (property == scheduleManager.getStandardLibraryHelper().getOclContainerProperty()) {
				return getCompositeNewEdges(edge);
			}
			propertyDatum = basicGetPropertyDatum(edge);				// FIXME debugging
		}
		if (propertyDatum == null) {			// May be null for edges only used by operation dependencies
			return null;
		}
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
		PropertyDatum propertyDatum = basicGetPropertyDatum(newEdge);
		if (propertyDatum == null) {
			propertyDatum = basicGetPropertyDatum(newEdge);		// FIXME debugging
		}
		assert propertyDatum != null;
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

	public void removeRegion(@NonNull Region region) {
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