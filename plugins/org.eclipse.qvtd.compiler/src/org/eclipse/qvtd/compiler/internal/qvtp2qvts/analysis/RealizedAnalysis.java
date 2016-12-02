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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigableEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SchedulerConstants;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;

import com.google.common.collect.Sets;

/**
 * A RealizedAnalysis identifies all realized nodes and edges.
 */
public class RealizedAnalysis
{
	protected final @NonNull SchedulerConstants schedulerConstants;

	/**
	 * The Realized Nodes that produce each ClassDatum.
	 */
	private final @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull List<@NonNull Node>> classDatumAnalysis2realizedNodes = new HashMap<>();

	/**
	 * The Realized Edges that produce each PropertyDatum (or its opposite).
	 */
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull List<@NonNull NavigableEdge>> propertyDatum2realizedEdges = new HashMap<>();

	public RealizedAnalysis(@NonNull SchedulerConstants schedulerConstants) {
		this.schedulerConstants = schedulerConstants;
	}

	private void addRealizedEdge(@NonNull NavigableEdge producedEdge) {
		PropertyDatum propertyDatum = basicGetPropertyDatum(producedEdge);
		if (propertyDatum == null) {
			propertyDatum = basicGetPropertyDatum(producedEdge);		// FIXME debugging
		}
		assert propertyDatum != null;
		addRealizedEdge(producedEdge, propertyDatum);
	}
	private void addRealizedEdge(@NonNull NavigableEdge producedEdge, @NonNull PropertyDatum propertyDatum) {
		List<@NonNull NavigableEdge> edges = propertyDatum2realizedEdges.get(propertyDatum);
		if (edges == null) {
			edges = new ArrayList<>();
			propertyDatum2realizedEdges.put(propertyDatum, edges);
		}
		if (!edges.contains(producedEdge)) {
			edges.add(producedEdge);
			for (@NonNull PropertyDatum superAbstractDatum : ClassUtil.nullFree(propertyDatum.getSuper())) {
				addRealizedEdge(producedEdge, superAbstractDatum);
			}
		}
	}

	private void addRealizedNode(@NonNull Node producedNode) {
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getElementalClassDatumAnalysis(producedNode);
		for (@NonNull ClassDatumAnalysis superClassDatumAnalysis : classDatumAnalysis.getSuperClassDatumAnalyses()) {
			List<@NonNull Node> nodes = classDatumAnalysis2realizedNodes.get(superClassDatumAnalysis);
			if (nodes == null) {
				nodes = new ArrayList<>();
				classDatumAnalysis2realizedNodes.put(superClassDatumAnalysis, nodes);
			}
			nodes.add(producedNode);
		}
	}

	public void addRegion(Region region) {
		for (@NonNull Node assignedNode : region.getNewNodes()) {
			if (assignedNode.isClass()) {
				addRealizedNode(assignedNode);
			}
		}
		for (@NonNull NavigableEdge realizedNavigationEdge : region.getRealizedNavigationEdges()) {
			addRealizedEdge(realizedNavigationEdge);
		}
	}

	protected @Nullable PropertyDatum basicGetPropertyDatum(@NonNull NavigableEdge producedEdge) {
		assert !producedEdge.isCast();				// Handled by caller
		Property forwardProperty = producedEdge.getProperty();
		ClassDatumAnalysis classDatumAnalysis = producedEdge.getSource().getClassDatumAnalysis();
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
		classDatumAnalysis = producedEdge.getTarget().getClassDatumAnalysis();
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
	private @Nullable Iterable<@NonNull NavigableEdge> getCompositeRealizedEdges(@NonNull NavigableEdge predicatedEdge) {
		Set<@NonNull NavigableEdge> realizedEdges = null;
		for (Map.Entry<@NonNull PropertyDatum, @NonNull List<@NonNull NavigableEdge>> entry : propertyDatum2realizedEdges.entrySet()) {
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

	public @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull List<@NonNull Node>> getClassDatumAnalysis2realizedNodes(){
		return classDatumAnalysis2realizedNodes;
	}

	public @Nullable Iterable<@NonNull NavigableEdge> getRealizedEdges(@NonNull NavigableEdge edge, @NonNull ClassDatumAnalysis requiredClassDatumAnalysis) {
		Property property = edge.getProperty();
		if (property.eContainer() == null) {			// Ignore pseudo-properties such as «iterate»
			return null;
		}
		PropertyDatum propertyDatum = basicGetPropertyDatum(edge);
		if (propertyDatum == null) {
			if (property == schedulerConstants.getStandardLibraryHelper().getOclContainerProperty()) {
				return getCompositeRealizedEdges(edge);
			}
			propertyDatum = basicGetPropertyDatum(edge);				// FIXME debugging
		}
		if (propertyDatum == null) {			// May be null for edges only used by operation dependencies
			return null;
		}
		Iterable<@NonNull NavigableEdge> realizedEdges = propertyDatum2realizedEdges.get(propertyDatum);
		if (realizedEdges == null) {
			return null;
		}
		CompleteClass requiredClass = requiredClassDatumAnalysis.getCompleteClass();
		List<@NonNull NavigableEdge> conformantRealizedEdges = null;
		for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
			Node targetNode = realizedEdge.getTarget();
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

	public @Nullable Iterable<@NonNull Node> getRealizedNodes(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		return classDatumAnalysis2realizedNodes.get(classDatumAnalysis);
	}
}
