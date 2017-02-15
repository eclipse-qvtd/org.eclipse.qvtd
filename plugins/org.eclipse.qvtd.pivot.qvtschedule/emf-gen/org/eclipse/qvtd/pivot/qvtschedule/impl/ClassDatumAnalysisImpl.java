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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Datum Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl#getClassDatum <em>Class Datum</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl#getCompleteClass <em>Complete Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl#getDomainUsage <em>Domain Usage</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl#getElementalClassDatum <em>Elemental Class Datum</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl#getProducedBy <em>Produced By</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl#getRequiredBy <em>Required By</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl#getScheduleModel <em>Schedule Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl#getSuperClassDatumAnalyses <em>Super Class Datum Analyses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassDatumAnalysisImpl extends ElementImpl implements ClassDatumAnalysis {
	/**
	 * The cached value of the '{@link #getClassDatum() <em>Class Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassDatum()
	 * @generated
	 * @ordered
	 */
	protected ClassDatum classDatum;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassDatum getClassDatum() {
		if (classDatum != null && classDatum.eIsProxy()) {
			InternalEObject oldClassDatum = (InternalEObject)classDatum;
			classDatum = (ClassDatum)eResolveProxy(oldClassDatum);
			if (classDatum != oldClassDatum) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.CLASS_DATUM_ANALYSIS__CLASS_DATUM, oldClassDatum, classDatum));
			}
		}
		return classDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDatum basicGetClassDatum() {
		return classDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassDatumGen(ClassDatum newClassDatum) {
		ClassDatum oldClassDatum = classDatum;
		classDatum = newClassDatum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CLASS_DATUM_ANALYSIS__CLASS_DATUM, oldClassDatum, classDatum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getProducedByGen() {
		if (producedBy == null) {
			producedBy = new EObjectResolvingEList<Mapping>(Mapping.class, this, QVTschedulePackage.CLASS_DATUM_ANALYSIS__PRODUCED_BY);
		}
		return producedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getRequiredByGen() {
		if (requiredBy == null) {
			requiredBy = new EObjectResolvingEList<Mapping>(Mapping.class, this, QVTschedulePackage.CLASS_DATUM_ANALYSIS__REQUIRED_BY);
		}
		return requiredBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassDatumAnalysis> getSuperClassDatumAnalysesGen() {
		if (superClassDatumAnalyses == null) {
			superClassDatumAnalyses = new EObjectResolvingEList<ClassDatumAnalysis>(ClassDatumAnalysis.class, this, QVTschedulePackage.CLASS_DATUM_ANALYSIS__SUPER_CLASS_DATUM_ANALYSES);
		}
		return superClassDatumAnalyses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleModel(ScheduleModel newScheduleModel) {
		ScheduleModel oldScheduleModel = scheduleModel;
		scheduleModel = newScheduleModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CLASS_DATUM_ANALYSIS__SCHEDULE_MODEL, oldScheduleModel, scheduleModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__CLASS_DATUM:
				if (resolve) return getClassDatum();
				return basicGetClassDatum();
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__COMPLETE_CLASS:
				return getCompleteClass();
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__DOMAIN_USAGE:
				return getDomainUsage();
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__ELEMENTAL_CLASS_DATUM:
				return getElementalClassDatum();
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__PRODUCED_BY:
				return getProducedBy();
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__REQUIRED_BY:
				return getRequiredBy();
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__SCHEDULE_MODEL:
				if (resolve) return getScheduleModel();
				return basicGetScheduleModel();
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__SUPER_CLASS_DATUM_ANALYSES:
				return getSuperClassDatumAnalyses();
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__TYPED_MODEL:
				return getTypedModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__CLASS_DATUM:
				setClassDatum((ClassDatum)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__PRODUCED_BY:
				getProducedBy().clear();
				getProducedBy().addAll((Collection<? extends Mapping>)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__REQUIRED_BY:
				getRequiredBy().clear();
				getRequiredBy().addAll((Collection<? extends Mapping>)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__SCHEDULE_MODEL:
				setScheduleModel((ScheduleModel)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__SUPER_CLASS_DATUM_ANALYSES:
				getSuperClassDatumAnalyses().clear();
				getSuperClassDatumAnalyses().addAll((Collection<? extends ClassDatumAnalysis>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__CLASS_DATUM:
				setClassDatum((ClassDatum)null);
				return;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__PRODUCED_BY:
				getProducedBy().clear();
				return;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__REQUIRED_BY:
				getRequiredBy().clear();
				return;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__SCHEDULE_MODEL:
				setScheduleModel((ScheduleModel)null);
				return;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__SUPER_CLASS_DATUM_ANALYSES:
				getSuperClassDatumAnalyses().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__CLASS_DATUM:
				return classDatum != null;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__COMPLETE_CLASS:
				return getCompleteClass() != null;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__DOMAIN_USAGE:
				return getDomainUsage() != null;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__ELEMENTAL_CLASS_DATUM:
				return getElementalClassDatum() != null;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__PRODUCED_BY:
				return producedBy != null && !producedBy.isEmpty();
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__REQUIRED_BY:
				return requiredBy != null && !requiredBy.isEmpty();
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__SCHEDULE_MODEL:
				return scheduleModel != null;
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__SUPER_CLASS_DATUM_ANALYSES:
				return superClassDatumAnalyses != null && !superClassDatumAnalyses.isEmpty();
			case QVTschedulePackage.CLASS_DATUM_ANALYSIS__TYPED_MODEL:
				return getTypedModel() != null;
		}
		return super.eIsSet(featureID);
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

	/**
	 * The cached value of the '{@link #getProducedBy() <em>Produced By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProducedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> producedBy;

	/**
	 * The cached value of the '{@link #getRequiredBy() <em>Required By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> requiredBy;

	/**
	 * The cached value of the '{@link #getScheduleModel() <em>Schedule Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduleModel()
	 * @generated
	 * @ordered
	 */
	protected ScheduleModel scheduleModel;

	/**
	 * The cached value of the '{@link #getSuperClassDatumAnalyses() <em>Super Class Datum Analyses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClassDatumAnalyses()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassDatumAnalysis> superClassDatumAnalyses;

	private /*final @NonNull*/ DomainUsage domainUsage;
	private /*final @NonNull*/ ClassDatum elementalClassDatum;

	/**
	 * The non-to-one properties that may terminate in a given ClassDatum.
	 */
	private /* @LazyNonNull*/ List<@NonNull Property> multiOpposites = null;

	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull Node>> introducer2assignmentNodes = new HashMap<>();
	private final @NonNull Map<@NonNull MappingRegion, @NonNull List<@NonNull Node>> consumer2predicateNodes = new HashMap<>();
	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull Node>> producer2assignmentNodes = new HashMap<>();

	@Override
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

	@Override
	public void addIntroduction(@NonNull Region introducer, @NonNull Node introducingNode) {
		List<@NonNull Node> assignmentNodes = introducer2assignmentNodes.get(introducer);
		if (assignmentNodes == null) {
			assignmentNodes = new ArrayList<@NonNull Node>();
			introducer2assignmentNodes.put(introducer, assignmentNodes);
		}
		assert !assignmentNodes.contains(introducingNode);
		assignmentNodes.add(introducingNode);
	}

	@Override
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

	public @NonNull Iterable<Node> getConsumingNodes() {
		return Iterables.concat(consumer2predicateNodes.values());
	}

	@Override
	public @NonNull List</*@NonNull*/ MappingRegion> getConsumingRegions() {
		return new ArrayList<>(consumer2predicateNodes.keySet());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DomainUsage getDomainUsage() {
		return domainUsage;
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

	@Override
	public EList<Mapping> getProducedBy() {
		EList<Mapping> producedBy2 = producedBy;
		if (producedBy2  == null) {
			producedBy2 = producedBy = getProducedByGen();
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

	@Override
	public EList<Mapping> getRequiredBy() {
		EList<Mapping> requiredBy2 = requiredBy;
		if (requiredBy2  == null) {
			requiredBy2 = requiredBy = getRequiredByGen();
			for (@NonNull MappingAction consumingAction : ClassUtil.nullFree(classDatum.getRequiredBy())) {
				Mapping mapping = consumingAction.getMapping();
				assert mapping != null;
				requiredBy2.add(mapping);
			}
		}
		return requiredBy2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduleModel getScheduleModel() {
		if (scheduleModel != null && scheduleModel.eIsProxy()) {
			InternalEObject oldScheduleModel = (InternalEObject)scheduleModel;
			scheduleModel = (ScheduleModel)eResolveProxy(oldScheduleModel);
			if (scheduleModel != oldScheduleModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.CLASS_DATUM_ANALYSIS__SCHEDULE_MODEL, oldScheduleModel, scheduleModel));
			}
		}
		return scheduleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduleModel basicGetScheduleModel() {
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

	@Override
	public EList<ClassDatumAnalysis> getSuperClassDatumAnalyses() {
		EList<ClassDatumAnalysis> superClassDatumAnalyses2 = superClassDatumAnalyses;
		if (superClassDatumAnalyses2  == null) {
			superClassDatumAnalyses2 = getSuperClassDatumAnalysesGen();
			CompleteClass completeClass = getCompleteClass();
			for (@NonNull CompleteClass completeSuperClass : completeClass.getSuperCompleteClasses()) {
				superClassDatumAnalyses2.add(scheduleModel.getClassDatumAnalysis(completeSuperClass, ClassUtil.nonNullState(domainUsage.getTypedModel(completeClass))));
			}
		}
		return superClassDatumAnalyses2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public TypedModel getTypedModel() {
		return QVTscheduleUtil.getClassDatum(this).getTypedModel();
	}

	public boolean hasNoProducers() {
		return producer2assignmentNodes.size() == 0;
	}

	@Override
	public void setClassDatum(ClassDatum newClassDatum) {
		setClassDatumGen(newClassDatum);
		TypedModel typedModel = QVTscheduleUtil.getTypedModel(this);
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public CompleteClass getCompleteClass() {
		CompleteClass completeClass = classDatum.getCompleteClass();
		assert completeClass != null;
		return completeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ClassDatum getElementalClassDatum() {
		return elementalClassDatum;
	}

	@Override
	public String toString() {
		return classDatum.toString();
	}

} //ClassDatumAnalysisImpl
