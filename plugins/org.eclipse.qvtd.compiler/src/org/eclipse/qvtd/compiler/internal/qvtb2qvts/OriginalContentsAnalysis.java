/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * An OriginalContentsAnalysis provides an original, prior to partitioning, analysis of many (all) regions to facilitate lookup of all producers consumers of particular types and properties.
 *
 * The analysis is not updated by subsequent partitioning.
 */
public class OriginalContentsAnalysis
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull Property oclContainerProperty;
	private final @NonNull AbstractTransformationAnalysis transformationAnalysis;

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
	 * The Realized Edges that produce each base PropertyDatum (or its opposite).
	 */
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull List<@NonNull NavigableEdge>> basePropertyDatum2newEdges = new HashMap<>();

	/**
	 * The regions that consume each ClassDatum, eagerly computed by addRegion().
	 * (Uses only the super-ClassDatum hierarchy; no sub-ClassDatums.)
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull Set<@NonNull RuleRegion>> classDatum2consumingRegions = new HashMap<>();

	/**
	 * The regions that consume each ClassDatum, lazily computed from the ClassAnalysis.
	 * Should be identical to classDatum2consumingRegions, but historical accident leave two 'identical'
	 * algorithms with differences to smooth out.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull Set<@NonNull RuleRegion>> classDatum2consumingRegions2 = new HashMap<>();

	/**
	 * The regions that produce each ClassDatum, eagerly computed by addRegion().
	 * (Uses only the super-ClassDatum hierarchy; no sub-ClassDatums.)
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull Set<@NonNull RuleRegion>> classDatum2producingRegions = new HashMap<>();

	/**
	 * The regions that produce each ClassDatum, lazily computed from the ClassAnalysis.
	 * Should be identical to classDatum2producingRegions, but historical accident leave two 'identical'
	 * algorithms with differences to smooth out.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull Set<@NonNull RuleRegion>> classDatum2producingRegions2 = new HashMap<>();

	public OriginalContentsAnalysis(@NonNull ScheduleManager scheduleManager) {
		this.scheduleManager = scheduleManager;
		this.oclContainerProperty = scheduleManager.getStandardLibraryHelper().getOclContainerProperty();
		Iterable<@NonNull AbstractTransformationAnalysis> transformationAnalyses = scheduleManager.getTransformationAnalyses();
		assert Iterables.size(transformationAnalyses) == 1;
		this.transformationAnalysis = transformationAnalyses.iterator().next();
	}

	private void addNewEdge(@NonNull RuleRegion region, @NonNull NavigableEdge newEdge) {
		if (newEdge instanceof NavigationEdge) {
			PropertyDatum propertyDatum = getPropertyDatum((NavigationEdge) newEdge);
			addNewEdge(region, newEdge, propertyDatum);
		}
		else {
			// FIXME SharedEdge
		}
	}
	private void addNewEdge(@NonNull RuleRegion region, @NonNull NavigableEdge newEdge, @NonNull PropertyDatum propertyDatum) {
		@SuppressWarnings("unused") String name = propertyDatum.getName();
		PropertyDatum basePropertyDatum = scheduleManager.getBasePropertyDatum(propertyDatum);
		List<@NonNull NavigableEdge> edges = basePropertyDatum2newEdges.get(basePropertyDatum);
		if (edges == null) {
			edges = new ArrayList<>();
			basePropertyDatum2newEdges.put(basePropertyDatum, edges);
		}
		if (!edges.contains(newEdge)) {
			edges.add(newEdge);
			//		for (@NonNull PropertyDatum superAbstractDatum : ClassUtil.nullFree(propertyDatum.getSuperPropertyDatums())) {
			//			addNewEdge(region, newEdge, superAbstractDatum);
			//		}
		}
	}

	private void addNewNode(@NonNull RuleRegion region, @NonNull Node newNode) {
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(newNode);
		ClassDatum elementalClassDatum = scheduleManager.getElementalClassDatum(classDatum);
		for (@NonNull ClassDatum superClassDatum : scheduleManager.getSuperClassDatums(elementalClassDatum)) {
			List<@NonNull Node> nodes = classDatum2newNodes.get(superClassDatum);
			if (nodes == null) {
				nodes = new ArrayList<>();
				classDatum2newNodes.put(superClassDatum, nodes);
			}
			nodes.add(newNode);
			Set<@NonNull RuleRegion> regions = classDatum2producingRegions2.get(superClassDatum);
			if (regions == null) {
				regions = new HashSet<>();
				classDatum2producingRegions2.put(superClassDatum, regions);
			}
			regions.add(region);
		}
	}

	private void addOldNode(@NonNull RuleRegion region, @NonNull Node oldNode) {
		//		assert !"EObject".equals(headNode.getCompleteClass().getName());
		//		Region region = oldNode.getRegion();
		//		Region invokingRegion = region.getInvokingRegion();
		//		assert (invokingRegion == this) || (invokingRegion == null);
		//		ClassDatumAnalysis classDatumAnalysis = QVTscheduleUtil.getClassDatumAnalysis(oldNode);
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(oldNode);
		//	classDatum = scheduleManager.getElementalClassDatum(classDatum);
		for (@NonNull ClassDatum superClassDatum : scheduleManager.getSuperClassDatums(classDatum)) {
			List<@NonNull Node> nodes = classDatum2oldNodes.get(superClassDatum);
			if (nodes == null) {
				nodes = new ArrayList<>();
				classDatum2oldNodes.put(superClassDatum, nodes);
			}
			if (!nodes.contains(oldNode)) {
				nodes.add(oldNode);
			}
			Set<@NonNull RuleRegion> regions = classDatum2consumingRegions2.get(superClassDatum);
			if (regions == null) {
				regions = new HashSet<>();
				classDatum2consumingRegions2.put(superClassDatum, regions);
			}
			regions.add(region);
		}
	}

	public void addRegion(@NonNull RuleRegion region) {
		// FIXME Eliminate duplication wrt the use of ClassAnalysis to determine regions.
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
		for (Map.Entry<@NonNull PropertyDatum, @NonNull List<@NonNull NavigableEdge>> entry : basePropertyDatum2newEdges.entrySet()) {
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

	/**
	 * Return the regions that consume precisely classDatum.
	 */
	public @NonNull Iterable<@NonNull RuleRegion> getDirectlyConsumingRegions(@NonNull ClassDatum classDatum) {
		Set<@NonNull RuleRegion> consumingRegions = classDatum2consumingRegions.get(classDatum);
		if (consumingRegions == null) {
			PartialRegionClassAnalysis<@NonNull RegionsAnalysis> classAnalysis = transformationAnalysis.basicGetClassAnalysis(classDatum);
			consumingRegions = new HashSet<>();
			if (classAnalysis != null) {
				for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> subClassAnalysis : classAnalysis.getSubClassAnalyses()) {
					for (@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis> regionAnalysis : subClassAnalysis.getConsumers()) {
						consumingRegions.add((RuleRegion) regionAnalysis.getRegion());
					}
				}
			}
			classDatum2consumingRegions.put(classDatum, consumingRegions);
		}
		Set<@NonNull RuleRegion> consumingRegions2 = classDatum2consumingRegions2.get(classDatum);
		if (consumingRegions2 == null) {
			consumingRegions2 = new HashSet<>();
		}
		/*	if (!consumingRegions.equals(consumingRegions2)) {
			PartialRegionClassAnalysis<@NonNull RegionsAnalysis> classAnalysis = transformationAnalysis.basicGetClassAnalysis(classDatum);
			consumingRegions = new HashSet<>();
			if (classAnalysis != null) {
				for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> subClassAnalysis : classAnalysis.getSubClassAnalyses()) {
					for (@NonNull RegionAnalysis regionAnalysis : subClassAnalysis.getConsumers()) {
						consumingRegions.add((RuleRegion) regionAnalysis.getRegion());
					}
				}
			}
			classDatum2consumingRegions.put(classDatum, consumingRegions);
		} */
		assert consumingRegions.equals(consumingRegions2);
		return consumingRegions;
	}

	/**
	 * Return the regions that produce classDatum or one of its subClassDatums.
	 */
	public @NonNull Iterable<@NonNull RuleRegion> getIndirectlyProducingRegions(@NonNull ClassDatum classDatum) {
		Set<@NonNull RuleRegion> producingRegions = classDatum2producingRegions.get(classDatum);
		if (producingRegions == null) {
			PartialRegionClassAnalysis<@NonNull RegionsAnalysis> classAnalysis = transformationAnalysis.basicGetClassAnalysis(classDatum);
			producingRegions = new HashSet<>();
			if (classAnalysis != null) {
				for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> subClassAnalysis : classAnalysis.getSubClassAnalyses()) {
					for (@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis> regionAnalysis : subClassAnalysis.getExactProducers()) {
						producingRegions.add((RuleRegion) regionAnalysis.getRegion());
					}
				}
			}
			classDatum2producingRegions.put(classDatum, producingRegions);
		}
		Set<@NonNull RuleRegion> producingRegions2 = classDatum2producingRegions2.get(classDatum);
		if (producingRegions2 == null) {
			producingRegions2 = new HashSet<>();
		}
		assert producingRegions.equals(producingRegions2);
		return producingRegions;
	}

	public @Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatum classDatum) {
		Iterable<@NonNull Node> newNodes = classDatum2newNodes.get(classDatum);
		/*	PartialRegionClassAnalysis<@NonNull RegionsAnalysis> classAnalysis = transformationAnalysis.basicGetClassAnalysis(classDatum);
		Set<@NonNull RuleRegion> producingRegions = new HashSet<>();
		if (classAnalysis != null) {
			for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> subClassAnalysis : classAnalysis.getSubClassAnalyses()) {
				for (@NonNull RegionAnalysis regionAnalysis : subClassAnalysis.getProducers()) {
					producingRegions.add((RuleRegion) regionAnalysis.getRegion());
				}
			}
		} */
		return newNodes;
	}

	public @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatum requiredClassDatum) {
		Property property = edge.getProperty();
		if (property.eContainer() == null) {			// Ignore pseudo-properties such as «iterate»
			return null;
		}
		if (property == oclContainerProperty) {
			return getCompositeNewEdges(edge);
		}
		Iterable<@NonNull NavigableEdge> realizedEdges = null;
		if (edge instanceof NavigationEdge) {
			PropertyDatum propertyDatum = getPropertyDatum((NavigationEdge) edge);
			PropertyDatum basePropertyDatum = scheduleManager.getBasePropertyDatum(propertyDatum);
			//		if (propertyDatum == null) {
			//			propertyDatum = basicGetPropertyDatum(edge);				// FIXME debugging
			//		}
			//		if (propertyDatum == null) {			// May be null for edges only used by operation dependencies
			//			return null;
			//		}
			realizedEdges = basePropertyDatum2newEdges.get(basePropertyDatum);
		}
		else {
			// FIXME SharedEdge
		}
		if (realizedEdges == null) {
			return null;
		}
		List<@NonNull NavigableEdge> conformantRealizedEdges = null;
		for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
			boolean matches = false;
			Property realizedProperty = realizedEdge.getProperty();
			if (realizedProperty != property) {
				assert realizedProperty.getOpposite() == property;
				matches = true;
			}
			else {
				Node targetNode = realizedEdge.getEdgeTarget();
				ClassDatum realizedClassDatum = QVTscheduleUtil.getClassDatum(targetNode);
				if (QVTscheduleUtil.conformsToClassOrBehavioralClass(realizedClassDatum, requiredClassDatum)) {
					matches = true;
				}
			}
			if (matches) {
				if (conformantRealizedEdges == null) {
					conformantRealizedEdges = new ArrayList<>();
				}
				conformantRealizedEdges.add(realizedEdge);
			}
		}
		return conformantRealizedEdges;
	}

	/*	public @Nullable Iterable<@NonNull NavigableEdge> getNewInverseEdges(@NonNull NavigableEdge edge, @NonNull ClassDatum requiredClassDatum) {
		Property property = edge.getProperty();
		assert property.isIsMany();
		if (property.eContainer() == null) {			// Ignore pseudo-properties such as «iterate»
			return null;
		}
		assert property != oclContainerProperty;
		//		if (property == oclContainerProperty) {
		//		return getCompositeNewEdges(edge);
		//	}
		PropertyDatum propertyDatum = getPropertyDatum(edge);
		PropertyDatum basePropertyDatum = scheduleManager.getBasePropertyDatum(propertyDatum);
		PropertyDatum inversePropertyDatum = propertyDatum.getOpposite();
		//		if (propertyDatum == null) {
		//			propertyDatum = basicGetPropertyDatum(edge);				// FIXME debugging
		//		}
		//		if (propertyDatum == null) {			// May be null for edges only used by operation dependencies
		//			return null;
		//		}
		Iterable<@NonNull NavigableEdge> inverseRealizedEdges = propertyDatum2newEdges.get(inversePropertyDatum);
		if (inverseRealizedEdges == null) {
			return null;
		}
		CompleteClass requiredClass = QVTscheduleUtil.getCompleteClass(requiredClassDatum);
		List<@NonNull NavigableEdge> conformantRealizedEdges = null;
		for (@NonNull NavigableEdge inverseRealizedEdge : inverseRealizedEdges) {
			CompleteClass requiredCollectionCompleteClass = QVTscheduleUtil.getCompleteClass(requiredClassDatum);
			Type requiredElementType = QVTimperativeUtil.getElementType((CollectionType) requiredCollectionCompleteClass.getPrimaryClass());
			ClassDatum requiredElementClassDatum = scheduleManager.getClassDatum(QVTscheduleUtil.getReferredTypedModel(requiredClassDatum), (org.eclipse.ocl.pivot.Class)requiredElementType);
			CompleteClass requiredElementCompleteClass = QVTscheduleUtil.getCompleteClass(requiredElementClassDatum);

			ClassDatum requiredSourceClassDatum = propertyDatum.getOwningClassDatum();
			CompleteClass requiredSourceCompleteClass = QVTscheduleUtil.getCompleteClass(requiredSourceClassDatum);
			Node sourceNode = inverseRealizedEdge.getEdgeSource();
			Node targetNode = inverseRealizedEdge.getEdgeTarget();
			CompleteClass realizedSourceClass = sourceNode.getCompleteClass();
			CompleteClass realizedTargetClass = targetNode.getCompleteClass();
			if (QVTscheduleUtil.conformsToClassOrBehavioralClass(realizedTargetClass, requiredSourceCompleteClass)
					&& QVTscheduleUtil.conformsToClassOrBehavioralClass(realizedSourceClass, requiredElementCompleteClass)) {
				if (conformantRealizedEdges == null) {
					conformantRealizedEdges = new ArrayList<>();
				}
				conformantRealizedEdges.add(inverseRealizedEdge);
			}
		}
		return conformantRealizedEdges;
	} */

	public @Nullable Iterable<@NonNull Node> getOldNodes(@NonNull ClassDatum classDatum) {
		return classDatum2oldNodes.get(classDatum);
	}

	private @NonNull PropertyDatum getPropertyDatum(@NonNull NavigationEdge producedEdge) {
		assert !producedEdge.isCast();				// Handled by caller
		Property forwardProperty = QVTscheduleUtil.getReferredProperty(producedEdge);
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
			assert !outgoingEdge.isCast();
			if (!outgoingEdge.isRecursion()) {
				return false;
			}
			isCast = true;
		}
		return isCast;
	}

	/*	private void removeNewEdge(@NonNull NavigableEdge newEdge) {
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
	} */

	/*	private void removeNewNode(@NonNull Node newNode) {
		List<@NonNull Node> nodes = classDatum2newNodes.get(newNode.getClassDatum());
		if (nodes != null) {
			nodes.remove(newNode);
		}
	} */

	/*	private void removeOldNode(@NonNull Node oldNode) {
		List<@NonNull Node> nodes = classDatum2oldNodes.get(oldNode.getClassDatum());
		if (nodes != null) {
			nodes.remove(oldNode);
		}
	} */

	/*	public void removeRegion(@NonNull RuleRegion region) {
		for (@NonNull Node oldNode : region.getOldNodes()) {
			removeOldNode(oldNode);
		}
		for (@NonNull Node newNode : region.getNewNodes()) {
			removeNewNode(newNode);
		}
		for (@NonNull NavigableEdge newEdge : region.getRealizedNavigationEdges()) {
			removeNewEdge(newEdge);
		}
	} */
}
