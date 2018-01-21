/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *     E.D.Willink - use Complete model
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;

/**
 * A RootMappingAnalysis provides an analysis of what is introduced by the root mapping.
 */
public class RootMappingAnalysis
{
	protected final @NonNull LoadingRegion loadingRegion;

	/**
	 * The null node that is the 'container' of all root model elements.
	 */
	private /*@LazyNonNull*/ Node nullNode = null;

	/**
	 * The introducer node for each consumed ClassDatumAnalysis and for each known container property where the containing property is known.
	 * The null containing property is used for introducer nodes required to be at the root.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull Map<@Nullable Property, @NonNull Node>> classDatum2property2node = new HashMap<>();

	/**
	 * The introducer node for each consumed ClassDatumAnalysis and for each known containing type where the containing property is just oclContainer.
	 * The null type is used when no containing property or type is known.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull Map<@Nullable ClassDatum, @NonNull Node>> classDatum2type2node = new HashMap<>();

	public RootMappingAnalysis(@NonNull LoadingRegion loadingRegion) {
		this.loadingRegion = loadingRegion;
	}

	public @NonNull Node getIntroducerNode(@NonNull Node consumerNode) {
		ScheduleManager scheduleManager = RegionUtil.getScheduleManager(loadingRegion);
		//
		//	Identify the containment pattern.
		//
		NavigableEdge containerEdge = null;
		Property parent2childProperty = null;
		ClassDatum containingClassDatum = null;
		for (@NonNull NavigableEdge edge : consumerNode.getNavigationEdges()) {
			Property property = edge.getProperty().getOpposite();
			if ((property != null) && property.isIsComposite() && !property.isIsRequired()) {
				containerEdge = edge;
				parent2childProperty = property;
				if (property == scheduleManager.getStandardLibraryHelper().getOclContainerProperty()) {
					containingClassDatum = RegionUtil.getClassDatum(edge.getEdgeSource());
				}
				break;
			}
		}
		CompleteEnvironment completeEnvironment = scheduleManager.getEnvironmentFactory().getCompleteEnvironment();
		ClassDatum consumedClassDatum = /*getCastTarget(consumerNode)*/RegionUtil.getClassDatum(consumerNode);
		org.eclipse.ocl.pivot.Class elementType = consumedClassDatum.getCompleteClass().getPrimaryClass();
		TypedModel typedModel = RegionUtil.getTypedModel(consumedClassDatum);
		CollectionType childCollectionType = completeEnvironment.getSetType(elementType, true,  null, null);
		ClassDatum childrenClassDatum = scheduleManager.getClassDatum(childCollectionType, typedModel);
		//
		//	Create / re-use the appropriate containment pattern.
		//
		Node introducedNode;
		if (parent2childProperty == null) {												// No known containment, owned by null type
			Map<@Nullable ClassDatum, @NonNull Node> type2node = classDatum2type2node.get(consumedClassDatum);
			if (type2node == null) {
				type2node = new HashMap<>();
				classDatum2type2node.put(consumedClassDatum, type2node);
			}
			introducedNode = type2node.get(null);
			if (introducedNode == null) {
				introducedNode = RegionUtil.createComposingNode(loadingRegion, "«" + elementType.getName() + "»", childrenClassDatum);
				type2node.put(null, introducedNode);
			}
		}
		else if ((containerEdge != null) && containerEdge.getEdgeTarget().isExplicitNull()) {		// At root, owned by null property
			Map<@Nullable Property, @NonNull Node> property2node = classDatum2property2node.get(consumedClassDatum);
			if (property2node == null) {
				property2node = new HashMap<>();
				classDatum2property2node.put(consumedClassDatum, property2node);
			}
			introducedNode = property2node.get(null);
			if (introducedNode == null) {
				introducedNode = RegionUtil.createComposingNode(loadingRegion, "«" + elementType.getName() + "-null»", childrenClassDatum);
				property2node.put(null, introducedNode);
				RegionUtil.createNavigationEdge(getNullNode(), parent2childProperty, introducedNode, false);
			}
		}
		else if (containingClassDatum != null) {								// Non-root oclContainer ownership
			Map<@Nullable ClassDatum, @NonNull Node> type2node = classDatum2type2node.get(consumedClassDatum);
			if (type2node == null) {
				type2node = new HashMap<>();
				classDatum2type2node.put(consumedClassDatum, type2node);
			}
			introducedNode = type2node.get(containingClassDatum);
			if (introducedNode == null) {
				introducedNode = RegionUtil.createComposingNode(loadingRegion, "«" + elementType.getName() + "-oclContents»", childrenClassDatum);
				type2node.put(containingClassDatum, introducedNode);
				Node containerNode = RegionUtil.createComposingNode(loadingRegion, "«" + containingClassDatum.getCompleteClass().getName() + "-oclContainer»", containingClassDatum);
				RegionUtil.createNavigationEdge(containerNode, parent2childProperty, introducedNode, false);
			}
		}
		else {																			// Knonw distinctive containment
			Map<@Nullable Property, @NonNull Node> property2node = classDatum2property2node.get(consumedClassDatum);
			if (property2node == null) {
				property2node = new HashMap<>();
				classDatum2property2node.put(consumedClassDatum, property2node);
			}
			introducedNode = property2node.get(parent2childProperty);
			if (introducedNode == null) {
				introducedNode = RegionUtil.createComposingNode(loadingRegion, "«" + elementType.getName() + "-" + parent2childProperty.getName() + "»", childrenClassDatum);
				property2node.put(parent2childProperty, introducedNode);
				org.eclipse.ocl.pivot.Class owningClass = parent2childProperty.getOwningClass();
				assert owningClass != null;
				containingClassDatum = scheduleManager.getClassDatum(owningClass, typedModel);
				Node containerNode = RegionUtil.createComposingNode(loadingRegion, "«" + owningClass.getName() + "-" + parent2childProperty.getName() + "»", containingClassDatum);
				RegionUtil.createNavigationEdge(containerNode, parent2childProperty, introducedNode, false);
			}
		}
		return introducedNode;
	}

	protected @NonNull Node getNullNode() {
		Node nullNode2 = nullNode;
		if (nullNode2 == null) {
			nullNode = nullNode2 = RegionUtil.createNullNode(loadingRegion, true, null);
		}
		return nullNode2;
	}
}
