/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.schedule.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.SchedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.MappingActionImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.MappingActionImpl#getProductions <em>Productions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.MappingActionImpl#getRequisites <em>Requisites</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.MappingActionImpl#getSchedule <em>Schedule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingActionImpl extends MinimalEObjectImpl.Container implements MappingAction {
	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
	protected Mapping mapping;

	/**
	 * The cached value of the '{@link #getProductions() <em>Productions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductions()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> productions;
	/**
	 * The cached value of the '{@link #getRequisites() <em>Requisites</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequisites()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> requisites;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulePackage.Literals.MAPPING_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mapping getMapping() {
		if (mapping != null && mapping.eIsProxy()) {
			InternalEObject oldMapping = (InternalEObject)mapping;
			mapping = (Mapping)eResolveProxy(oldMapping);
			if (mapping != oldMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulePackage.MAPPING_ACTION__MAPPING, oldMapping, mapping));
			}
		}
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping basicGetMapping() {
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMapping(Mapping newMapping) {
		Mapping oldMapping = mapping;
		mapping = newMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.MAPPING_ACTION__MAPPING, oldMapping, mapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractDatum> getProductions() {
		if (productions == null) {
			productions = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, SchedulePackage.MAPPING_ACTION__PRODUCTIONS, SchedulePackage.ABSTRACT_DATUM__PRODUCED_BY);
		}
		return productions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractDatum> getRequisites() {
		if (requisites == null) {
			requisites = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, SchedulePackage.MAPPING_ACTION__REQUISITES, SchedulePackage.ABSTRACT_DATUM__REQUIRED_BY);
		}
		return requisites;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Schedule getSchedule() {
		if (eContainerFeatureID() != SchedulePackage.MAPPING_ACTION__SCHEDULE) return null;
		return (Schedule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchedule(Schedule newSchedule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSchedule, SchedulePackage.MAPPING_ACTION__SCHEDULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSchedule(Schedule newSchedule) {
		if (newSchedule != eInternalContainer() || (eContainerFeatureID() != SchedulePackage.MAPPING_ACTION__SCHEDULE && newSchedule != null)) {
			if (EcoreUtil.isAncestor(this, newSchedule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSchedule != null)
				msgs = ((InternalEObject)newSchedule).eInverseAdd(this, SchedulePackage.SCHEDULE__ACTIONS, Schedule.class, msgs);
			msgs = basicSetSchedule(newSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.MAPPING_ACTION__SCHEDULE, newSchedule, newSchedule));
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
			case SchedulePackage.MAPPING_ACTION__PRODUCTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProductions()).basicAdd(otherEnd, msgs);
			case SchedulePackage.MAPPING_ACTION__REQUISITES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequisites()).basicAdd(otherEnd, msgs);
			case SchedulePackage.MAPPING_ACTION__SCHEDULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSchedule((Schedule)otherEnd, msgs);
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
			case SchedulePackage.MAPPING_ACTION__PRODUCTIONS:
				return ((InternalEList<?>)getProductions()).basicRemove(otherEnd, msgs);
			case SchedulePackage.MAPPING_ACTION__REQUISITES:
				return ((InternalEList<?>)getRequisites()).basicRemove(otherEnd, msgs);
			case SchedulePackage.MAPPING_ACTION__SCHEDULE:
				return basicSetSchedule(null, msgs);
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
			case SchedulePackage.MAPPING_ACTION__SCHEDULE:
				return eInternalContainer().eInverseRemove(this, SchedulePackage.SCHEDULE__ACTIONS, Schedule.class, msgs);
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
			case SchedulePackage.MAPPING_ACTION__MAPPING:
				if (resolve) return getMapping();
				return basicGetMapping();
			case SchedulePackage.MAPPING_ACTION__PRODUCTIONS:
				return getProductions();
			case SchedulePackage.MAPPING_ACTION__REQUISITES:
				return getRequisites();
			case SchedulePackage.MAPPING_ACTION__SCHEDULE:
				return getSchedule();
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
			case SchedulePackage.MAPPING_ACTION__MAPPING:
				setMapping((Mapping)newValue);
				return;
			case SchedulePackage.MAPPING_ACTION__PRODUCTIONS:
				getProductions().clear();
				getProductions().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case SchedulePackage.MAPPING_ACTION__REQUISITES:
				getRequisites().clear();
				getRequisites().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case SchedulePackage.MAPPING_ACTION__SCHEDULE:
				setSchedule((Schedule)newValue);
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
			case SchedulePackage.MAPPING_ACTION__MAPPING:
				setMapping((Mapping)null);
				return;
			case SchedulePackage.MAPPING_ACTION__PRODUCTIONS:
				getProductions().clear();
				return;
			case SchedulePackage.MAPPING_ACTION__REQUISITES:
				getRequisites().clear();
				return;
			case SchedulePackage.MAPPING_ACTION__SCHEDULE:
				setSchedule((Schedule)null);
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
			case SchedulePackage.MAPPING_ACTION__MAPPING:
				return mapping != null;
			case SchedulePackage.MAPPING_ACTION__PRODUCTIONS:
				return productions != null && !productions.isEmpty();
			case SchedulePackage.MAPPING_ACTION__REQUISITES:
				return requisites != null && !requisites.isEmpty();
			case SchedulePackage.MAPPING_ACTION__SCHEDULE:
				return getSchedule() != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		return mapping.toString();
	}
} //MappingActionImpl
