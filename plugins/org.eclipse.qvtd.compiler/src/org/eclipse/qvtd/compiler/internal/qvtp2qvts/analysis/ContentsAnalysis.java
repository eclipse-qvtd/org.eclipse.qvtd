/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *     E.D.Willink - use Complete model
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigableEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SchedulerConstants;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;

import com.google.common.collect.Sets;

/**
 * A ContentsAnalysis provides an analysis of many (all) regions to facilitate lookup of all producers consumers of particular types and properties.
 */
public class ContentsAnalysis
{
	public static @NonNull BinaryOperator<@NonNull String> stringJoin(@NonNull String delimiter) {
		return (a, b) -> String.valueOf(a) + delimiter + String.valueOf(b);
	}

	protected final @NonNull SchedulerConstants schedulerConstants;

	/**
	 * The Speculation or Realized Nodes that produce each ClassDatum.
	 */
	private final @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull List<@NonNull Node>> classDatumAnalysis2newNodes = new HashMap<>();

	/**
	 * The input model classes that may be used as independent inputs by mappings and the nodes at which they are consumed.
	 * In the worst case a flat schedule just permutes allInstances() to provide all mapping inputs.
	 */
	private final @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull List<@NonNull Node>> classDatumAnalysis2oldNodes = new HashMap<>();

	/**
	 * The Realized Edges that produce each PropertyDatum (or its opposite).
	 */
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull List<@NonNull NavigableEdge>> propertyDatum2newEdges = new HashMap<>();

	public ContentsAnalysis(@NonNull SchedulerConstants schedulerConstants) {
		this.schedulerConstants = schedulerConstants;
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
			for (@NonNull PropertyDatum superAbstractDatum : ClassUtil.nullFree(propertyDatum.getSuper())) {
				addNewEdge(newEdge, superAbstractDatum);
			}
		}
	}

	private void addNewNode(@NonNull Node newNode) {
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getElementalClassDatumAnalysis(newNode);
		for (@NonNull ClassDatumAnalysis superClassDatumAnalysis : classDatumAnalysis.getSuperClassDatumAnalyses()) {
			List<@NonNull Node> nodes = classDatumAnalysis2newNodes.get(superClassDatumAnalysis);
			if (nodes == null) {
				nodes = new ArrayList<>();
				classDatumAnalysis2newNodes.put(superClassDatumAnalysis, nodes);
			}
			nodes.add(newNode);
		}
	}

	private void addOldNode(@NonNull Node oldNode) {
		//		assert !"EObject".equals(headNode.getCompleteClass().getName());
		//		Region region = oldNode.getRegion();
		//		Region invokingRegion = region.getInvokingRegion();
		//		assert (invokingRegion == this) || (invokingRegion == null);
		ClassDatumAnalysis classDatumAnalysis = oldNode.getClassDatumAnalysis();
		List<@NonNull Node> nodes = classDatumAnalysis2oldNodes.get(classDatumAnalysis);
		if (nodes == null) {
			nodes = new ArrayList<>();
			classDatumAnalysis2oldNodes.put(classDatumAnalysis, nodes);
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
		ClassDatumAnalysis classDatumAnalysis = producedEdge.getEdgeSource().getClassDatumAnalysis();
		ClassDatum forwardClassDatum = classDatumAnalysis.getElementalClassDatum();
		//		PropertyDatum forwardPropertyDatum = getSchedulerConstants().getPropertyDatum(forwardClassDatum, property);
		//		if (forwardPropertyDatum.getClassDatum() == forwardClassDatum) {
		//			return forwardPropertyDatum;
		//		}
		Iterable<@NonNull PropertyDatum> forwardPropertyDatums = schedulerConstants.getAllPropertyDatums(forwardClassDatum);
		for (PropertyDatum propertyDatum : forwardPropertyDatums) {
			if ((propertyDatum.getProperty() == forwardProperty) && (propertyDatum.getClassDatum() == forwardClassDatum)) {
				return propertyDatum;
			}
		}
		PropertyDatum bestPropertyDatum = null;
		for (PropertyDatum propertyDatum : forwardPropertyDatums) {
			if (propertyDatum.getProperty() == forwardProperty) {
				if (bestPropertyDatum == null) {
					bestPropertyDatum = propertyDatum;
				}
				else {
					CompleteClass completeClass = propertyDatum.getClassDatum().getCompleteClass();
					assert completeClass != null;
					Set<@NonNull CompleteClass> allSuperCompleteClasses = Sets.newHashSet(completeClass.getProperSuperCompleteClasses());
					if (allSuperCompleteClasses.contains(bestPropertyDatum.getClassDatum().getCompleteClass())) {
						bestPropertyDatum = propertyDatum;
					}
				}
			}
		}
		if (bestPropertyDatum != null) {
			return bestPropertyDatum;
		}
		Property reverseProperty = forwardProperty.getOpposite();
		classDatumAnalysis = producedEdge.getEdgeTarget().getClassDatumAnalysis();
		ClassDatum reverseClassDatum = classDatumAnalysis.getElementalClassDatum();
		Iterable<@NonNull PropertyDatum> reversePropertyDatums = schedulerConstants.getAllPropertyDatums(reverseClassDatum);
		for (PropertyDatum propertyDatum : reversePropertyDatums) {
			if ((propertyDatum.getProperty() == reverseProperty) && (propertyDatum.getClassDatum() == reverseClassDatum)) {
				return propertyDatum;
			}
		}
		for (PropertyDatum propertyDatum : reversePropertyDatums) {
			if (propertyDatum.getProperty() == reverseProperty) {
				if (bestPropertyDatum == null) {
					bestPropertyDatum = propertyDatum;
				}
				else {
					CompleteClass completeClass = propertyDatum.getClassDatum().getCompleteClass();
					assert completeClass != null;
					Set<@NonNull CompleteClass> allSuperCompleteClasses = Sets.newHashSet(completeClass.getProperSuperCompleteClasses());
					if (allSuperCompleteClasses.contains(bestPropertyDatum.getClassDatum().getCompleteClass())) {
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
		Stream<String> entries = classDatumAnalysis2oldNodes.keySet().stream().map(
			k -> {
				List<Node> list = classDatumAnalysis2oldNodes.get(k);
				assert list != null;
				return String.valueOf(k) + " : " + list.stream().map(
					p -> p.getDisplayName()
						).sorted().reduce("", stringJoin("\n\t\t"));
			}
				);
		return entries.sorted();
	}

	public Stream<String> dumpClass2newNode() {
		Stream<String> entries = classDatumAnalysis2newNodes.keySet().stream().map(
			k -> {
				List<Node> list = classDatumAnalysis2newNodes.get(k);
				assert list != null;
				return k.getDomainUsage() + " " + String.valueOf(k) + " : " +
				list.stream().map(
					p -> p.getDisplayName()
						).sorted().reduce("", stringJoin("\n\t\t")
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
			Property property = entry.getKey().getProperty();
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

	public @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatumAnalysis requiredClassDatumAnalysis) {
		Property property = edge.getProperty();
		if (property.eContainer() == null) {			// Ignore pseudo-properties such as «iterate»
			return null;
		}
		PropertyDatum propertyDatum = basicGetPropertyDatum(edge);
		if (propertyDatum == null) {
			if (property == schedulerConstants.getStandardLibraryHelper().getOclContainerProperty()) {
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
		CompleteClass requiredClass = requiredClassDatumAnalysis.getCompleteClass();
		List<@NonNull NavigableEdge> conformantRealizedEdges = null;
		for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
			Node targetNode = realizedEdge.getEdgeTarget();
			CompleteClass realizedClass = targetNode.getCompleteClass();
			if (realizedClass.conformsTo(requiredClass) /*|| realizedClass.conformsTo(requiredClass.getBehavioralClass())*/) {
				if (conformantRealizedEdges == null) {
					conformantRealizedEdges = new ArrayList<>();
				}
				conformantRealizedEdges.add(realizedEdge);
			}
		}
		return conformantRealizedEdges;
	}

	public @Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		return classDatumAnalysis2newNodes.get(classDatumAnalysis);
	}

	public @Nullable Iterable<@NonNull Node> getOldNodes(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		return classDatumAnalysis2oldNodes.get(classDatumAnalysis);
	}

	/**
	 * Return true if this node is consumed solely by casts (or recursions) and so need not be considered as a true consumer.
	 * The downstream usages will consume more accurately.
	 */
	private boolean isOnlyCastOrRecursed(@NonNull Node predicatedNode) {
		boolean isCast = false;
		for (Edge outgoingEdge : predicatedNode.getOutgoingEdges()) {
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
				for (@NonNull PropertyDatum superAbstractDatum : ClassUtil.nullFree(propertyDatum.getSuper())) {
					removeNewEdge(newEdge, superAbstractDatum);
				}
			}
		}
	}

	private void removeNewNode(@NonNull Node newNode) {
		ClassDatumAnalysis classDatumAnalysis = newNode.getClassDatumAnalysis();
		List<@NonNull Node> nodes = classDatumAnalysis2newNodes.get(classDatumAnalysis);
		if (nodes != null) {
			nodes.remove(newNode);
		}
	}

	private void removeOldNode(@NonNull Node oldNode) {
		ClassDatumAnalysis classDatumAnalysis = oldNode.getClassDatumAnalysis();
		List<@NonNull Node> nodes = classDatumAnalysis2oldNodes.get(classDatumAnalysis);
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
