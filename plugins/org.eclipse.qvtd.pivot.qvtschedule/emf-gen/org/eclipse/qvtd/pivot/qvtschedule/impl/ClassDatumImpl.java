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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.internal.ModelImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getReferredTypedModel <em>Referred Typed Model</em>}</li>
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
	public static final int CLASS_DATUM_FEATURE_COUNT = AbstractDatumImpl.ABSTRACT_DATUM_FEATURE_COUNT + 6;

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
	 * The cached value of the '{@link #getReferredTypedModel() <em>Referred Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredTypedModel()
	 * @generated
	 * @ordered
	 */
	protected TypedModel referredTypedModel;

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
			completeClasses = new EObjectResolvingEList<CompleteClass>(CompleteClass.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0);
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
			ownedPropertyDatums = new EObjectContainmentWithInverseEList<PropertyDatum>(PropertyDatum.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1);
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
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2)) return null;
		return (ScheduleModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningScheduleModel(ScheduleModel newOwningScheduleModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningScheduleModel, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningScheduleModel(ScheduleModel newOwningScheduleModel) {
		if (newOwningScheduleModel != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2) && newOwningScheduleModel != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, newOwningScheduleModel, newOwningScheduleModel));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, oldReferredClass, referredClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, oldReferredClass, referredClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getReferredTypedModel() {
		if (referredTypedModel != null && referredTypedModel.eIsProxy()) {
			InternalEObject oldReferredTypedModel = (InternalEObject)referredTypedModel;
			referredTypedModel = (TypedModel)eResolveProxy(oldReferredTypedModel);
			if (referredTypedModel != oldReferredTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, oldReferredTypedModel, referredTypedModel));
			}
		}
		return referredTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetReferredTypedModel() {
		return referredTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredTypedModel(TypedModel newReferredTypedModel) {
		TypedModel oldReferredTypedModel = referredTypedModel;
		referredTypedModel = newReferredTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, oldReferredTypedModel, referredTypedModel));
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPropertyDatums()).basicAdd(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getOwnedPropertyDatums()).basicRemove(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return getCompleteClasses();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return getOwnedPropertyDatums();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return getOwningScheduleModel();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				if (resolve) return getReferredClass();
			return basicGetReferredClass();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				if (resolve) return getReferredTypedModel();
			return basicGetReferredTypedModel();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				getCompleteClasses().clear();
			getCompleteClasses().addAll((Collection<? extends CompleteClass>)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				getOwnedPropertyDatums().clear();
			getOwnedPropertyDatums().addAll((Collection<? extends PropertyDatum>)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setOwningScheduleModel((ScheduleModel)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setReferredClass((org.eclipse.ocl.pivot.Class)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setReferredTypedModel((TypedModel)newValue);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				getCompleteClasses().clear();
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				getOwnedPropertyDatums().clear();
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setOwningScheduleModel((ScheduleModel)null);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setReferredClass((org.eclipse.ocl.pivot.Class)null);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setReferredTypedModel((TypedModel)null);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return completeClasses != null && !completeClasses.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return ownedPropertyDatums != null && !ownedPropertyDatums.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return getOwningScheduleModel() != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return referredClass != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return referredTypedModel != null;
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
		if (visitor instanceof QVTscheduleVisitor) {
			return (R) ((QVTscheduleVisitor<?>)visitor).visitClassDatum(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public @Nullable List<@NonNull CompleteClass> basicGetCompleteClasses() {
		return completeClasses != null ? ClassUtil.nullFree(completeClasses) : null;
	}

	@Override
	public @NonNull Type getCollectionElementType() {
		Type collectionType = getPrimaryClass();
		Type elementType = ((CollectionType)collectionType).getElementType();
		assert elementType != null;
		return elementType;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getPrimaryClass() {
		List<CompleteClass> completeClasses2 = completeClasses;
		if ((completeClasses2 == null) || (completeClasses2.size() != 1)) {
			throw new IllegalStateException("No unique CompleteClass for " + this);
		}
		return completeClasses2.get(0).getPrimaryClass();
	}

	@Override
	public boolean isCheckable() {
		List<CompleteClass> completeClasses2 = completeClasses;
		if (completeClasses2 == null) {
			return false;
		}
		for (CompleteClass completeClass : completeClasses2) {
			org.eclipse.ocl.pivot.Class type = completeClass.getPrimaryClass();
			if ((type instanceof DataType) || (type instanceof AnyType) || (type instanceof VoidType) || (type instanceof InvalidType)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isCollectionType() {
		List<CompleteClass> completeClasses2 = completeClasses;
		if (completeClasses2 != null) {
			for (CompleteClass completeClass : completeClasses2) {
				org.eclipse.ocl.pivot.Class primaryClass = completeClass.getPrimaryClass();
				if (primaryClass instanceof CollectionType) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isDataType() {
		List<CompleteClass> completeClasses2 = completeClasses;
		if (completeClasses2 != null) {
			for (CompleteClass completeClass : completeClasses2) {
				assert completeClass != null;
				if (PivotUtil.isDataType(completeClass)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = null;
		List<CompleteClass> completeClasses2 = completeClasses;
		if (completeClasses2 != null) {
			for (CompleteClass completeClass : completeClasses2) {
				if (s == null) {
					s = new StringBuilder();
				}
				else {
					s.append("&&");
				}
				org.eclipse.ocl.pivot.Class primaryClass = completeClass.getPrimaryClass();
				org.eclipse.ocl.pivot.Package primaryPackage = primaryClass.getOwningPackage();
				s.append(String.valueOf(getReferredTypedModel()));
				s.append("!");
				s.append(primaryPackage != null ? String.valueOf(primaryPackage.getName()) : "null");
				s.append("::");
				s.append(primaryClass.toString());
			}
		}
		return s != null ? s.toString() : PivotConstantsInternal.NULL_MARKER;
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
