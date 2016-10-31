/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.MappingAction;

import com.google.common.collect.Iterables;

public class ClassDatumAnalysis
{
	protected static final class MultiOppositeComparator implements Comparator<@NonNull Property>
	{
		public static final Comparator<@NonNull ? super Property> INSTANCE = new MultiOppositeComparator();

		@Override
		public int compare(@NonNull Property o1, @NonNull Property o2) {
			boolean c1 = o1.isIsComposite();
			boolean c2 = o1.isIsComposite();
			if (c1 != c2) {
				return Boolean.compare(c1, c2);
			}
			else {
				return ClassUtil.safeCompareTo(o1.getName(), o2.getName());
			}
		}
	}

	protected final @NonNull SchedulerConstants schedulerConstants;
	protected final @NonNull ClassDatum classDatum;
	protected final @NonNull ClassDatum elementalClassDatum;
	protected final @NonNull DomainUsage domainUsage;

	/**
	 * The non-to-one properties that may terminate in a given ClassDatum.
	 */
	private /* @LazyNonNull*/ List<@NonNull Property> multiOpposites = null;

	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull Node>> introducer2assignmentNodes = new HashMap<>();
	private final @NonNull Map<@NonNull MappingRegion, @NonNull List<@NonNull Node>> consumer2predicateNodes = new HashMap<>();
	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull Node>> producer2assignmentNodes = new HashMap<>();
	private /*@LazyNonNull*/ List<@NonNull ClassDatumAnalysis> superClassDatumAnalyses = null;
	private /*@LazyNonNull*/ List<@NonNull Mapping> producedBy = null;
	private /*@LazyNonNull*/ List<@NonNull Mapping> requiredBy = null;

	public ClassDatumAnalysis(@NonNull SchedulerConstants schedulerConstants, @NonNull ClassDatum classDatum) {
		this.schedulerConstants = schedulerConstants;
		this.classDatum = classDatum;
		TypedModel typedModel = ClassUtil.nonNullState(classDatum.getTypedModel());
		this.domainUsage = schedulerConstants.getDomainUsage(typedModel);
		Type type = classDatum.getCompleteClass().getPrimaryClass();
		Type elementType = type;
		while (elementType instanceof CollectionType) {
			elementType = ((CollectionType)elementType).getElementType();
		}
		if ((elementType == null) || (elementType == type) || !(elementType instanceof org.eclipse.ocl.pivot.Class)) {
			elementalClassDatum = classDatum;
		}
		else {
			elementalClassDatum = schedulerConstants.getClassDatum((org.eclipse.ocl.pivot.Class)elementType, typedModel);
		}
	}

	public void addConsumption(@NonNull MappingRegion consumer, @NonNull Node consumingNode) {
		List<@NonNull Node> predicateNodes = consumer2predicateNodes.get(consumer);
		if (predicateNodes == null) {
			predicateNodes = new ArrayList<@NonNull Node>();
			consumer2predicateNodes.put(consumer, predicateNodes);
		}
		if (!predicateNodes.contains(consumingNode)) {			// predicate may consume multiple producers
			predicateNodes.add(consumingNode);
		}
	}

	public void addIntroduction(@NonNull Region introducer, @NonNull Node introducingNode) {
		List<@NonNull Node> assignmentNodes = introducer2assignmentNodes.get(introducer);
		if (assignmentNodes == null) {
			assignmentNodes = new ArrayList<@NonNull Node>();
			introducer2assignmentNodes.put(introducer, assignmentNodes);
		}
		assert !assignmentNodes.contains(introducingNode);
		assignmentNodes.add(introducingNode);
	}

	public void addProduction(@NonNull MappingRegion producer, @NonNull Node producingNode) {
		List<@NonNull Node> assignmentNodes = producer2assignmentNodes.get(producer);
		if (assignmentNodes == null) {
			assignmentNodes = new ArrayList<@NonNull Node>();
			producer2assignmentNodes.put(producer, assignmentNodes);
		}
		if (!assignmentNodes.contains(producingNode)) {			// assignment may be recursive
			assignmentNodes.add(producingNode);
		}
	}

	public @NonNull ClassDatum getClassDatum() {
		return classDatum;
	}

	public @NonNull CompleteClass getCompleteClass() {
		CompleteClass completeClass = classDatum.getCompleteClass();
		assert completeClass != null;
		return completeClass;
	}

	public @NonNull Iterable<Node> getConsumingNodes() {
		return Iterables.concat(consumer2predicateNodes.values());
	}

	public @NonNull Set<@NonNull MappingRegion> getConsumingRegions() {
		return consumer2predicateNodes.keySet();
	}

	public @NonNull DomainUsage getDomainUsage() {
		return domainUsage;
	}

	public @NonNull ClassDatum getElementalClassDatum() {
		return elementalClassDatum;
	}

	public @Nullable List<Property> getMultiOpposites() {
		List<@NonNull Property> multiOpposites2 = multiOpposites;
		if (multiOpposites2 == null) {
			EnvironmentFactory environmentFactory = schedulerConstants.getEnvironmentFactory();
			CompleteClass completeClass = classDatum.getCompleteClass();
			assert completeClass != null;
			for (@NonNull Property property : completeClass.getProperties((FeatureFilter)null)) {
				Property oppositeProperty = property.getOpposite();
				if ((oppositeProperty != null) && oppositeProperty.isIsMany() && !oppositeProperty.isIsDerived()) {
					Type childrenType = oppositeProperty.getType();
					if (childrenType instanceof CollectionType) {
						Type childType = ((CollectionType)childrenType).getElementType();
						assert childType != null;
						CompleteClass childCompleteClass = environmentFactory.getCompleteModel().getCompleteClass(childType);
						if (completeClass.conformsTo(childCompleteClass)) {					// FIXME bi-conforming types
							if (multiOpposites2 == null) {
								multiOpposites = multiOpposites2 = new ArrayList<@NonNull Property>();
							}
							multiOpposites2.add(oppositeProperty);
						}
					}
				}
			}
			if (multiOpposites2 != null) {
				Collections.sort(multiOpposites2, MultiOppositeComparator.INSTANCE);		// Container first, deterministic order by name later
			}
		}
		return multiOpposites2;
	}

	public @NonNull Iterable<@NonNull Mapping> getProducedBy() {
		List<@NonNull Mapping> producedBy2 = producedBy;
		if (producedBy2  == null) {
			producedBy2 = producedBy = new ArrayList<>();
			for (@NonNull MappingAction producingAction : ClassUtil.nullFree(classDatum.getProducedBy())) {
				Mapping mapping = producingAction.getMapping();
				assert mapping != null;
				producedBy2.add(mapping);
			}
		}
		return producedBy2;
	}

	//	@SuppressWarnings("null")
	//	public @NonNull Collection<MappingRegion> getProducers() {
	//		return producer2assignmentNodes.keySet();
	//	}

	public @NonNull Iterable<Node> getProducingNodes() {
		return Iterables.concat(consumer2predicateNodes.values());
	}

	public @NonNull Set<Region> getProducingRegions() {
		return producer2assignmentNodes.keySet();
	}

	public @NonNull Iterable<@NonNull Mapping> getRequiredBy() {
		List<@NonNull Mapping> requiredBy2 = requiredBy;
		if (requiredBy2  == null) {
			requiredBy2 = requiredBy = new ArrayList<>();
			for (@NonNull MappingAction consumingAction : ClassUtil.nullFree(classDatum.getRequiredBy())) {
				Mapping mapping = consumingAction.getMapping();
				assert mapping != null;
				requiredBy2.add(mapping);
			}
		}
		return requiredBy2;
	}

	public @Nullable Node getSingleProducer() {
		Iterator<List<Node>> values = producer2assignmentNodes.values().iterator();
		if (!values.hasNext()) {
			return null;
		}
		List<Node> firstProductions = values.next();
		return !values.hasNext() && (firstProductions.size() == 1) ? firstProductions.get(0) : null;
	}

	public @NonNull Iterable<@NonNull ClassDatumAnalysis> getSuperClassDatumAnalyses() {
		List<@NonNull ClassDatumAnalysis> superClassDatumAnalyses2 = superClassDatumAnalyses;
		if (superClassDatumAnalyses2  == null) {
			superClassDatumAnalyses = superClassDatumAnalyses2 = new ArrayList<@NonNull ClassDatumAnalysis>();
			CompleteClass completeClass = getCompleteClass();
			for (@NonNull CompleteClass completeSuperClass : completeClass.getSuperCompleteClasses()) {
				superClassDatumAnalyses2.add(schedulerConstants.getClassDatumAnalysis(completeSuperClass, ClassUtil.nonNullState(domainUsage.getTypedModel(completeClass))));
			}
		}
		return superClassDatumAnalyses2;
	}

	public @NonNull TypedModel getTypedModel() {
		return ClassUtil.nonNullState(classDatum.getTypedModel());
	}

	public boolean hasNoProducers() {
		return producer2assignmentNodes.size() == 0;
	}

	@Override
	public String toString() {
		return classDatum.toString();
	}
}