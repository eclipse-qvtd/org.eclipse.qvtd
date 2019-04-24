/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.Collection;

import java.util.List;
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
import org.eclipse.ocl.pivot.internal.ModelImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getCompleteClasses <em>Complete Classes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getOwnedPropertyDatums <em>Owned Property Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getOwningScheduleModel <em>Owning Schedule Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getReferredClass <em>Referred Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getSuperClassDatums <em>Super Class Datums</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassDatumImpl extends AbstractDatumImpl implements ClassDatum {
	/**
	 * The number of structural features of the '<em>Class Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_DATUM_FEATURE_COUNT = AbstractDatumImpl.ABSTRACT_DATUM_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Class Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_DATUM_OPERATION_COUNT = AbstractDatumImpl.ABSTRACT_DATUM_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getCompleteClasses() <em>Complete Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompleteClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<CompleteClass> completeClasses;

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
	public List<CompleteClass> getCompleteClasses() {
		if (completeClasses == null) {
			completeClasses = new EObjectResolvingEList<CompleteClass>(CompleteClass.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1);
		}
		return completeClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<PropertyDatum> getOwnedPropertyDatums() {
		if (ownedPropertyDatums == null) {
			ownedPropertyDatums = new EObjectContainmentWithInverseEList<PropertyDatum>(PropertyDatum.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2);
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
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3)) return null;
		return (ScheduleModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningScheduleModel(ScheduleModel newOwningScheduleModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningScheduleModel, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningScheduleModel(ScheduleModel newOwningScheduleModel) {
		if (newOwningScheduleModel != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3) && newOwningScheduleModel != null)) {
			if (EcoreUtil.isAncestor(this, newOwningScheduleModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningScheduleModel != null)
				msgs = ((InternalEObject)newOwningScheduleModel).eInverseAdd(this, ModelImpl.MODEL_FEATURE_COUNT + 0, ScheduleModel.class, msgs);
			msgs = basicSetOwningScheduleModel(newOwningScheduleModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, newOwningScheduleModel, newOwningScheduleModel));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, oldReferredClass, referredClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, oldReferredClass, referredClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ClassDatum> getSuperClassDatums() {
		if (superClassDatums == null) {
			superClassDatums = new EObjectResolvingEList<ClassDatum>(ClassDatum.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5);
		}
		return superClassDatums;
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPropertyDatums()).basicAdd(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getOwnedPropertyDatums()).basicRemove(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return eInternalContainer().eInverseRemove(this, ModelImpl.MODEL_FEATURE_COUNT + 0, ScheduleModel.class, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return getCompleteClasses();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return getOwnedPropertyDatums();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return getOwningScheduleModel();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				if (resolve) return getReferredClass();
				return basicGetReferredClass();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return getSuperClassDatums();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				getCompleteClasses().clear();
				getCompleteClasses().addAll((Collection<? extends CompleteClass>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				getOwnedPropertyDatums().clear();
				getOwnedPropertyDatums().addAll((Collection<? extends PropertyDatum>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setOwningScheduleModel((ScheduleModel)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setReferredClass((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				getSuperClassDatums().clear();
				getSuperClassDatums().addAll((Collection<? extends ClassDatum>)newValue);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				getCompleteClasses().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				getOwnedPropertyDatums().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setOwningScheduleModel((ScheduleModel)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setReferredClass((org.eclipse.ocl.pivot.Class)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				getSuperClassDatums().clear();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return completeClasses != null && !completeClasses.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return ownedPropertyDatums != null && !ownedPropertyDatums.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return getOwningScheduleModel() != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return referredClass != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return superClassDatums != null && !superClassDatums.isEmpty();
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
		if (completeClass == null) {
			return PivotConstantsInternal.NULL_MARKER;
		}
		org.eclipse.ocl.pivot.Class primaryClass = completeClass.getPrimaryClass();
		org.eclipse.ocl.pivot.Package primaryPackage = primaryClass.getOwningPackage();
		return String.valueOf(getReferredTypedModel()) + "!" + (primaryPackage != null ? String.valueOf(primaryPackage.getName()) : "null") + "::" + primaryClass.toString();
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
