/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getCompleteClass <em>Complete Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getOwnedPropertyDatums <em>Owned Property Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getOwningScheduleModel <em>Owning Schedule Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getReferredClass <em>Referred Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getSuperClassDatums <em>Super Class Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getConsumingRegions <em>Consuming Regions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getProducingRegions <em>Producing Regions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassDatumImpl extends AbstractDatumImpl implements ClassDatum {
	/**
	 * The cached value of the '{@link #getCompleteClass() <em>Complete Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompleteClass()
	 * @generated
	 * @ordered
	 */
	protected CompleteClass completeClass;

	/**
	 * The cached value of the '{@link #getOwnedPropertyDatums() <em>Owned Property Datums</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPropertyDatums()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyDatum> ownedPropertyDatums;

	/**
	 * The cached value of the '{@link #getReferredClass() <em>Referred Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Class referredClass;

	/**
	 * The cached value of the '{@link #getSuperClassDatums() <em>Super Class Datums</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClassDatums()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassDatum> superClassDatums;

	/**
	 * The cached value of the '{@link #getConsumingRegions() <em>Consuming Regions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsumingRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<RuleRegion> consumingRegions;

	/**
	 * The cached value of the '{@link #getProducingRegions() <em>Producing Regions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProducingRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<RuleRegion> producingRegions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDatumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.CLASS_DATUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompleteClass getCompleteClass() {
		if (completeClass != null && completeClass.eIsProxy()) {
			InternalEObject oldCompleteClass = (InternalEObject)completeClass;
			completeClass = (CompleteClass)eResolveProxy(oldCompleteClass);
			if (completeClass != oldCompleteClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS, oldCompleteClass, completeClass));
			}
		}
		return completeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteClass basicGetCompleteClass() {
		return completeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompleteClass(CompleteClass newCompleteClass) {
		CompleteClass oldCompleteClass = completeClass;
		completeClass = newCompleteClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS, oldCompleteClass, completeClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyDatum> getOwnedPropertyDatums() {
		if (ownedPropertyDatums == null) {
			ownedPropertyDatums = new EObjectContainmentWithInverseEList<PropertyDatum>(PropertyDatum.class, this, QVTschedulePackage.CLASS_DATUM__OWNED_PROPERTY_DATUMS, QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM);
		}
		return ownedPropertyDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduleModel getOwningScheduleModel() {
		if (eContainerFeatureID() != QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL) return null;
		return (ScheduleModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningScheduleModel(ScheduleModel newOwningScheduleModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningScheduleModel, QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningScheduleModel(ScheduleModel newOwningScheduleModel) {
		if (newOwningScheduleModel != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL && newOwningScheduleModel != null)) {
			if (EcoreUtil.isAncestor(this, newOwningScheduleModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningScheduleModel != null)
				msgs = ((InternalEObject)newOwningScheduleModel).eInverseAdd(this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_CLASS_DATUMS, ScheduleModel.class, msgs);
			msgs = basicSetOwningScheduleModel(newOwningScheduleModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL, newOwningScheduleModel, newOwningScheduleModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Class getReferredClass() {
		if (referredClass != null && referredClass.eIsProxy()) {
			InternalEObject oldReferredClass = (InternalEObject)referredClass;
			referredClass = (org.eclipse.ocl.pivot.Class)eResolveProxy(oldReferredClass);
			if (referredClass != oldReferredClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.CLASS_DATUM__REFERRED_CLASS, oldReferredClass, referredClass));
			}
		}
		return referredClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Class basicGetReferredClass() {
		return referredClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredClass(org.eclipse.ocl.pivot.Class newReferredClass) {
		org.eclipse.ocl.pivot.Class oldReferredClass = referredClass;
		referredClass = newReferredClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CLASS_DATUM__REFERRED_CLASS, oldReferredClass, referredClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassDatum> getSuperClassDatums() {
		if (superClassDatums == null) {
			superClassDatums = new EObjectResolvingEList<ClassDatum>(ClassDatum.class, this, QVTschedulePackage.CLASS_DATUM__SUPER_CLASS_DATUMS);
		}
		return superClassDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RuleRegion> getConsumingRegions() {
		if (consumingRegions == null) {
			consumingRegions = new EObjectResolvingEList<RuleRegion>(RuleRegion.class, this, QVTschedulePackage.CLASS_DATUM__CONSUMING_REGIONS);
		}
		return consumingRegions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RuleRegion> getProducingRegions() {
		if (producingRegions == null) {
			producingRegions = new EObjectResolvingEList<RuleRegion>(RuleRegion.class, this, QVTschedulePackage.CLASS_DATUM__PRODUCING_REGIONS);
		}
		return producingRegions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.CLASS_DATUM__OWNED_PROPERTY_DATUMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPropertyDatums()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningScheduleModel((ScheduleModel)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.CLASS_DATUM__OWNED_PROPERTY_DATUMS:
				return ((InternalEList<?>)getOwnedPropertyDatums()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL:
				return basicSetOwningScheduleModel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_CLASS_DATUMS, ScheduleModel.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				if (resolve) return getCompleteClass();
				return basicGetCompleteClass();
			case QVTschedulePackage.CLASS_DATUM__OWNED_PROPERTY_DATUMS:
				return getOwnedPropertyDatums();
			case QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL:
				return getOwningScheduleModel();
			case QVTschedulePackage.CLASS_DATUM__REFERRED_CLASS:
				if (resolve) return getReferredClass();
				return basicGetReferredClass();
			case QVTschedulePackage.CLASS_DATUM__SUPER_CLASS_DATUMS:
				return getSuperClassDatums();
			case QVTschedulePackage.CLASS_DATUM__CONSUMING_REGIONS:
				return getConsumingRegions();
			case QVTschedulePackage.CLASS_DATUM__PRODUCING_REGIONS:
				return getProducingRegions();
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
			case QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				setCompleteClass((CompleteClass)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM__OWNED_PROPERTY_DATUMS:
				getOwnedPropertyDatums().clear();
				getOwnedPropertyDatums().addAll((Collection<? extends PropertyDatum>)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL:
				setOwningScheduleModel((ScheduleModel)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM__REFERRED_CLASS:
				setReferredClass((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM__SUPER_CLASS_DATUMS:
				getSuperClassDatums().clear();
				getSuperClassDatums().addAll((Collection<? extends ClassDatum>)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM__CONSUMING_REGIONS:
				getConsumingRegions().clear();
				getConsumingRegions().addAll((Collection<? extends RuleRegion>)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM__PRODUCING_REGIONS:
				getProducingRegions().clear();
				getProducingRegions().addAll((Collection<? extends RuleRegion>)newValue);
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
			case QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				setCompleteClass((CompleteClass)null);
				return;
			case QVTschedulePackage.CLASS_DATUM__OWNED_PROPERTY_DATUMS:
				getOwnedPropertyDatums().clear();
				return;
			case QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL:
				setOwningScheduleModel((ScheduleModel)null);
				return;
			case QVTschedulePackage.CLASS_DATUM__REFERRED_CLASS:
				setReferredClass((org.eclipse.ocl.pivot.Class)null);
				return;
			case QVTschedulePackage.CLASS_DATUM__SUPER_CLASS_DATUMS:
				getSuperClassDatums().clear();
				return;
			case QVTschedulePackage.CLASS_DATUM__CONSUMING_REGIONS:
				getConsumingRegions().clear();
				return;
			case QVTschedulePackage.CLASS_DATUM__PRODUCING_REGIONS:
				getProducingRegions().clear();
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
			case QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				return completeClass != null;
			case QVTschedulePackage.CLASS_DATUM__OWNED_PROPERTY_DATUMS:
				return ownedPropertyDatums != null && !ownedPropertyDatums.isEmpty();
			case QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL:
				return getOwningScheduleModel() != null;
			case QVTschedulePackage.CLASS_DATUM__REFERRED_CLASS:
				return referredClass != null;
			case QVTschedulePackage.CLASS_DATUM__SUPER_CLASS_DATUMS:
				return superClassDatums != null && !superClassDatums.isEmpty();
			case QVTschedulePackage.CLASS_DATUM__CONSUMING_REGIONS:
				return consumingRegions != null && !consumingRegions.isEmpty();
			case QVTschedulePackage.CLASS_DATUM__PRODUCING_REGIONS:
				return producingRegions != null && !producingRegions.isEmpty();
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitClassDatum(this);
	}

	@Override
	public String toString() {
		return String.valueOf(getReferredTypedModel()) + "!" + completeClass.getName();
	}

	/*	public @Nullable List<Property> getMultiOpposites() {
		List<@NonNull Property> multiOpposites2 = multiOpposites;
		if (multiOpposites2 == null) {
			EnvironmentFactory environmentFactory = scheduleManager.getEnvironmentFactory();
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
	} */

	/*	public @Nullable Node getSingleProducer() {
		Iterator<List<Node>> values = producer2assignmentNodes.values().iterator();
		if (!values.hasNext()) {
			return null;
		}
		List<Node> firstProductions = values.next();
		return !values.hasNext() && (firstProductions.size() == 1) ? firstProductions.get(0) : null;
	} */

	/*	public boolean hasNoProducers() {
		return producer2assignmentNodes.size() == 0;
	} */

} //ClassDatumImpl
