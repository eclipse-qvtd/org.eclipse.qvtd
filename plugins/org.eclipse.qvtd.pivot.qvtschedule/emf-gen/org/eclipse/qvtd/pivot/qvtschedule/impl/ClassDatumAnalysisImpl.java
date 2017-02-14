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
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.MappingAction;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.SchedulerConstants;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Datum Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ClassDatumAnalysisImpl extends ElementImpl implements ClassDatumAnalysis {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDatumAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.CLASS_DATUM_ANALYSIS;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitClassDatumAnalysis(this);
	}

	private /*final @NonNull*/ SchedulerConstants schedulerConstants;
	private /*final @NonNull*/ ClassDatum classDatum;
	private /*final @NonNull*/ ClassDatum elementalClassDatum;
	private /*final @NonNull*/ DomainUsage domainUsage;

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

	public ClassDatumAnalysisImpl(@NonNull SchedulerConstants schedulerConstants, @NonNull ClassDatum classDatum) {
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

	@Override
	public @NonNull ClassDatum getClassDatum() {
		return classDatum;
	}

	@Override
	public @NonNull CompleteClass getCompleteClass() {
		CompleteClass completeClass = classDatum.getCompleteClass();
		assert completeClass != null;
		return completeClass;
	}

	public @NonNull Iterable<Node> getConsumingNodes() {
		return Iterables.concat(consumer2predicateNodes.values());
	}

	@Override
	public @NonNull List</*@NonNull*/ MappingRegion> getConsumingRegions() {
		return new ArrayList<>(consumer2predicateNodes.keySet());
	}

	@Override
	public @NonNull DomainUsage getDomainUsage() {
		return domainUsage;
	}

	@Override
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
				Collections.sort(multiOpposites2, QVTscheduleUtil.MultiOppositeComparator.INSTANCE);		// Container first, deterministic order by name later
			}
		}
		return multiOpposites2;
	}

	@Override
	public @NonNull List</*@NonNull*/ Mapping> getProducedBy() {
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

	@Override
	public @NonNull List</*@NonNull*/ Mapping> getRequiredBy() {
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

	@Override
	public @NonNull List</*@NonNull*/ ClassDatumAnalysis> getSuperClassDatumAnalyses() {
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

	@Override
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

} //ClassDatumAnalysisImpl
