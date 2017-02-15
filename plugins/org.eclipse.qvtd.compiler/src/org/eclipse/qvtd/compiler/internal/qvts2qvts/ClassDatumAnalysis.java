/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.ScheduleModel2;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.MappingAction;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

public class ClassDatumAnalysis implements Adapter
{
	public static @Nullable ClassDatumAnalysis find(@NonNull ClassDatum classDatum) {
		return ClassUtil.getAdapter(ClassDatumAnalysis.class, classDatum);
	}

	public static @NonNull ClassDatumAnalysis get(@NonNull Node node) {
		ClassDatum classDatum = RegionUtil.getClassDatum(node);
		ClassDatumAnalysis adapter = ClassUtil.getAdapter(ClassDatumAnalysis.class, classDatum);
		if (adapter == null) {
			adapter = ((ScheduleModel2)node.getRegion().getScheduleModel()).getClassDatumAnalysis(classDatum);
		}
		return adapter;
	}

	protected final @NonNull ScheduleModel2 scheduleModel;
	protected final @NonNull ClassDatum classDatum;
	protected final @NonNull DomainUsage domainUsage;
	protected final @NonNull ClassDatum elementalClassDatum;

	private @Nullable List<@NonNull Mapping> producedBy = null;
	private @Nullable List<@NonNull Mapping> requiredBy = null;
	private @Nullable List<@NonNull ClassDatumAnalysis> superClassDatumAnalyses = null;


	/**
	 * The non-to-one properties that may terminate in a given ClassDatum.
	 */
	private /* @LazyNonNull*/ List<@NonNull Property> multiOpposites = null;

	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull Node>> introducer2assignmentNodes = new HashMap<>();
	private final @NonNull Map<@NonNull MappingRegion, @NonNull List<@NonNull Node>> consumer2predicateNodes = new HashMap<>();
	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull Node>> producer2assignmentNodes = new HashMap<>();

	public ClassDatumAnalysis(@NonNull ScheduleModel2 scheduleModel, @NonNull ClassDatum classDatum) {
		this.scheduleModel = scheduleModel;
		this.classDatum = classDatum;
		classDatum.eAdapters().add(this);
		TypedModel typedModel = QVTscheduleUtil.getTypedModel(classDatum);
		this.domainUsage = scheduleModel.getDomainUsage(typedModel);
		Type type = classDatum.getCompleteClass().getPrimaryClass();
		Type elementType = type;
		while (elementType instanceof CollectionType) {
			elementType = ((CollectionType)elementType).getElementType();
		}
		if ((elementType == null) || (elementType == type) || !(elementType instanceof org.eclipse.ocl.pivot.Class)) {
			elementalClassDatum = classDatum;
		}
		else {
			elementalClassDatum = scheduleModel.getClassDatum((org.eclipse.ocl.pivot.Class)elementType, typedModel);
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

	public @NonNull Iterable<@NonNull Node> getConsumingNodes() {
		return Iterables.concat(consumer2predicateNodes.values());
	}

	public @NonNull List<@NonNull MappingRegion> getConsumingRegions() {
		return new ArrayList<>(consumer2predicateNodes.keySet());
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
			EnvironmentFactory environmentFactory = scheduleModel.getEnvironmentFactory();
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
				Collections.sort(multiOpposites2, QVTscheduleUtil.MultiOppositeComparator.INSTANCE);		// Container first, deterministic order by name later
			}
		}
		return multiOpposites2;
	}

	public @NonNull List<@NonNull Mapping> getProducedBy() {
		List<@NonNull Mapping> producedBy2 = producedBy;
		if (producedBy2  == null) {
			producedBy = producedBy2 = new ArrayList<>();
			for (@NonNull MappingAction producingAction : ClassUtil.nullFree(classDatum.getProducedBy())) {
				Mapping mapping = producingAction.getMapping();
				assert mapping != null;
				producedBy2.add(mapping);
			}
		}
		return producedBy2;
	}

	public @NonNull Iterable<Node> getProducingNodes() {
		return Iterables.concat(consumer2predicateNodes.values());
	}

	public @NonNull Set<Region> getProducingRegions() {
		return producer2assignmentNodes.keySet();
	}

	public @NonNull List<@NonNull Mapping> getRequiredBy() {
		List<@NonNull Mapping> requiredBy2 = requiredBy;
		if (requiredBy2  == null) {
			requiredBy = requiredBy2 = new ArrayList<>();
			for (@NonNull MappingAction consumingAction : ClassUtil.nullFree(classDatum.getRequiredBy())) {
				Mapping mapping = consumingAction.getMapping();
				assert mapping != null;
				requiredBy2.add(mapping);
			}
		}
		return requiredBy2;
	}

	public @NonNull ScheduleModel2 getScheduleModel() {
		return scheduleModel;
	}

	public @Nullable Node getSingleProducer() {
		Iterator<List<Node>> values = producer2assignmentNodes.values().iterator();
		if (!values.hasNext()) {
			return null;
		}
		List<Node> firstProductions = values.next();
		return !values.hasNext() && (firstProductions.size() == 1) ? firstProductions.get(0) : null;
	}

	public List<@NonNull ClassDatumAnalysis> getSuperClassDatumAnalyses() {
		List<@NonNull ClassDatumAnalysis> superClassDatumAnalyses2 = superClassDatumAnalyses;
		if (superClassDatumAnalyses2  == null) {
			superClassDatumAnalyses = superClassDatumAnalyses2 = new ArrayList<>();
			CompleteClass completeClass = getClassDatum().getCompleteClass();
			for (@NonNull CompleteClass completeSuperClass : completeClass.getSuperCompleteClasses()) {
				superClassDatumAnalyses2.add(scheduleModel.getClassDatumAnalysis(completeSuperClass, ClassUtil.nonNullState(domainUsage.getTypedModel(completeClass))));
			}
		}
		return superClassDatumAnalyses2;
	}


	@Override
	public Notifier getTarget() {
		return classDatum;
	}

	public boolean hasNoProducers() {
		return producer2assignmentNodes.size() == 0;
	}

	@Override
	public String toString() {
		return classDatum.toString();
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ClassDatumAnalysis.class;
	}

	@Override
	public void notifyChanged(Notification notification) {}

	@Override
	public void setTarget(Notifier newTarget) {}

}
