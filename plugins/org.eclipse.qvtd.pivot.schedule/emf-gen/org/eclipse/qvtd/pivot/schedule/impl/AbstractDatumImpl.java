/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.DataParameter;
import org.eclipse.qvtd.pivot.schedule.SchedulePackage;
import org.eclipse.qvtd.pivot.schedule.Schedule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl#getSuper <em>Super</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl#getSub <em>Sub</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl#getProducedBy <em>Produced By</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl#getRequiredBy <em>Required By</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl#getDataParameter <em>Data Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractDatumImpl extends ScheduleElementImpl implements AbstractDatum {
	/**
	 * The cached value of the '{@link #getSuper() <em>Super</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuper()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> super_;

	/**
	 * The cached value of the '{@link #getSub() <em>Sub</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSub()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> sub;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected CoreDomain domain;

	/**
	 * The cached value of the '{@link #getProducedBy() <em>Produced By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProducedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAction> producedBy;

	/**
	 * The cached value of the '{@link #getRequiredBy() <em>Required By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredBy()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAction> requiredBy;

	/**
	 * The cached value of the '{@link #getDataParameter() <em>Data Parameter</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<DataParameter> dataParameter;

	/**
	 * The cached value of the '{@link #getTypedModel() <em>Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedModel()
	 * @generated
	 * @ordered
	 */
	protected TypedModel typedModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractDatumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulePackage.Literals.ABSTRACT_DATUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getSuper() {
		if (super_ == null) {
			super_ = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, SchedulePackage.ABSTRACT_DATUM__SUPER, SchedulePackage.ABSTRACT_DATUM__SUB);
		}
		return super_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getSub() {
		if (sub == null) {
			sub = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, SchedulePackage.ABSTRACT_DATUM__SUB, SchedulePackage.ABSTRACT_DATUM__SUPER);
		}
		return sub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreDomain getDomainGen() {
		if (domain != null && domain.eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = (CoreDomain)eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulePackage.ABSTRACT_DATUM__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
	}
	public CoreDomain getDomain() {		// FIXME Eliminate domain altogether
		CoreDomain domainGen = getDomainGen();
		TypedModel typedModel2 = getTypedModel();
		if (domainGen == null) {
			assert typedModel2 == null;
		}
		else {
			assert domainGen.getTypedModel() == typedModel2;
		}
		return domainGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreDomain basicGetDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainGen(CoreDomain newDomain) {
		CoreDomain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.ABSTRACT_DATUM__DOMAIN, oldDomain, domain));
	}
	public void setDomain(CoreDomain newDomain) {
		setDomainGen(newDomain);
		setTypedModel(newDomain != null ? newDomain.getTypedModel() : null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel getTypedModel() {
		if (typedModel != null && typedModel.eIsProxy()) {
			InternalEObject oldTypedModel = (InternalEObject)typedModel;
			typedModel = (TypedModel)eResolveProxy(oldTypedModel);
			if (typedModel != oldTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulePackage.ABSTRACT_DATUM__TYPED_MODEL, oldTypedModel, typedModel));
			}
		}
		return typedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetTypedModel() {
		return typedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedModel(TypedModel newTypedModel) {
		TypedModel oldTypedModel = typedModel;
		typedModel = newTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.ABSTRACT_DATUM__TYPED_MODEL, oldTypedModel, typedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAction> getProducedBy() {
		if (producedBy == null) {
			producedBy = new EObjectWithInverseResolvingEList.ManyInverse<AbstractAction>(AbstractAction.class, this, SchedulePackage.ABSTRACT_DATUM__PRODUCED_BY, SchedulePackage.ABSTRACT_ACTION__PRODUCTIONS);
		}
		return producedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAction> getRequiredBy() {
		if (requiredBy == null) {
			requiredBy = new EObjectWithInverseResolvingEList.ManyInverse<AbstractAction>(AbstractAction.class, this, SchedulePackage.ABSTRACT_DATUM__REQUIRED_BY, SchedulePackage.ABSTRACT_ACTION__REQUISITES);
		}
		return requiredBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schedule getSchedule() {
		if (eContainerFeatureID() != SchedulePackage.ABSTRACT_DATUM__SCHEDULE) return null;
		return (Schedule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchedule(Schedule newSchedule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSchedule, SchedulePackage.ABSTRACT_DATUM__SCHEDULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedule(Schedule newSchedule) {
		if (newSchedule != eInternalContainer() || (eContainerFeatureID() != SchedulePackage.ABSTRACT_DATUM__SCHEDULE && newSchedule != null)) {
			if (EcoreUtil.isAncestor(this, newSchedule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSchedule != null)
				msgs = ((InternalEObject)newSchedule).eInverseAdd(this, SchedulePackage.SCHEDULE__DATUMS, Schedule.class, msgs);
			msgs = basicSetSchedule(newSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.ABSTRACT_DATUM__SCHEDULE, newSchedule, newSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataParameter> getDataParameter() {
		if (dataParameter == null) {
			dataParameter = new EObjectWithInverseResolvingEList<DataParameter>(DataParameter.class, this, SchedulePackage.ABSTRACT_DATUM__DATA_PARAMETER, SchedulePackage.DATA_PARAMETER__DATUM);
		}
		return dataParameter;
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
			case SchedulePackage.ABSTRACT_DATUM__SUPER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSuper()).basicAdd(otherEnd, msgs);
			case SchedulePackage.ABSTRACT_DATUM__SUB:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSub()).basicAdd(otherEnd, msgs);
			case SchedulePackage.ABSTRACT_DATUM__PRODUCED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProducedBy()).basicAdd(otherEnd, msgs);
			case SchedulePackage.ABSTRACT_DATUM__REQUIRED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredBy()).basicAdd(otherEnd, msgs);
			case SchedulePackage.ABSTRACT_DATUM__SCHEDULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSchedule((Schedule)otherEnd, msgs);
			case SchedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDataParameter()).basicAdd(otherEnd, msgs);
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
			case SchedulePackage.ABSTRACT_DATUM__SUPER:
				return ((InternalEList<?>)getSuper()).basicRemove(otherEnd, msgs);
			case SchedulePackage.ABSTRACT_DATUM__SUB:
				return ((InternalEList<?>)getSub()).basicRemove(otherEnd, msgs);
			case SchedulePackage.ABSTRACT_DATUM__PRODUCED_BY:
				return ((InternalEList<?>)getProducedBy()).basicRemove(otherEnd, msgs);
			case SchedulePackage.ABSTRACT_DATUM__REQUIRED_BY:
				return ((InternalEList<?>)getRequiredBy()).basicRemove(otherEnd, msgs);
			case SchedulePackage.ABSTRACT_DATUM__SCHEDULE:
				return basicSetSchedule(null, msgs);
			case SchedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
				return ((InternalEList<?>)getDataParameter()).basicRemove(otherEnd, msgs);
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
			case SchedulePackage.ABSTRACT_DATUM__SCHEDULE:
				return eInternalContainer().eInverseRemove(this, SchedulePackage.SCHEDULE__DATUMS, Schedule.class, msgs);
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
			case SchedulePackage.ABSTRACT_DATUM__SUPER:
				return getSuper();
			case SchedulePackage.ABSTRACT_DATUM__SUB:
				return getSub();
			case SchedulePackage.ABSTRACT_DATUM__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case SchedulePackage.ABSTRACT_DATUM__PRODUCED_BY:
				return getProducedBy();
			case SchedulePackage.ABSTRACT_DATUM__REQUIRED_BY:
				return getRequiredBy();
			case SchedulePackage.ABSTRACT_DATUM__SCHEDULE:
				return getSchedule();
			case SchedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
				return getDataParameter();
			case SchedulePackage.ABSTRACT_DATUM__TYPED_MODEL:
				if (resolve) return getTypedModel();
				return basicGetTypedModel();
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
			case SchedulePackage.ABSTRACT_DATUM__SUPER:
				getSuper().clear();
				getSuper().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case SchedulePackage.ABSTRACT_DATUM__SUB:
				getSub().clear();
				getSub().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case SchedulePackage.ABSTRACT_DATUM__DOMAIN:
				setDomain((CoreDomain)newValue);
				return;
			case SchedulePackage.ABSTRACT_DATUM__PRODUCED_BY:
				getProducedBy().clear();
				getProducedBy().addAll((Collection<? extends AbstractAction>)newValue);
				return;
			case SchedulePackage.ABSTRACT_DATUM__REQUIRED_BY:
				getRequiredBy().clear();
				getRequiredBy().addAll((Collection<? extends AbstractAction>)newValue);
				return;
			case SchedulePackage.ABSTRACT_DATUM__SCHEDULE:
				setSchedule((Schedule)newValue);
				return;
			case SchedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
				getDataParameter().clear();
				getDataParameter().addAll((Collection<? extends DataParameter>)newValue);
				return;
			case SchedulePackage.ABSTRACT_DATUM__TYPED_MODEL:
				setTypedModel((TypedModel)newValue);
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
			case SchedulePackage.ABSTRACT_DATUM__SUPER:
				getSuper().clear();
				return;
			case SchedulePackage.ABSTRACT_DATUM__SUB:
				getSub().clear();
				return;
			case SchedulePackage.ABSTRACT_DATUM__DOMAIN:
				setDomain((CoreDomain)null);
				return;
			case SchedulePackage.ABSTRACT_DATUM__PRODUCED_BY:
				getProducedBy().clear();
				return;
			case SchedulePackage.ABSTRACT_DATUM__REQUIRED_BY:
				getRequiredBy().clear();
				return;
			case SchedulePackage.ABSTRACT_DATUM__SCHEDULE:
				setSchedule((Schedule)null);
				return;
			case SchedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
				getDataParameter().clear();
				return;
			case SchedulePackage.ABSTRACT_DATUM__TYPED_MODEL:
				setTypedModel((TypedModel)null);
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
			case SchedulePackage.ABSTRACT_DATUM__SUPER:
				return super_ != null && !super_.isEmpty();
			case SchedulePackage.ABSTRACT_DATUM__SUB:
				return sub != null && !sub.isEmpty();
			case SchedulePackage.ABSTRACT_DATUM__DOMAIN:
				return domain != null;
			case SchedulePackage.ABSTRACT_DATUM__PRODUCED_BY:
				return producedBy != null && !producedBy.isEmpty();
			case SchedulePackage.ABSTRACT_DATUM__REQUIRED_BY:
				return requiredBy != null && !requiredBy.isEmpty();
			case SchedulePackage.ABSTRACT_DATUM__SCHEDULE:
				return getSchedule() != null;
			case SchedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
				return dataParameter != null && !dataParameter.isEmpty();
			case SchedulePackage.ABSTRACT_DATUM__TYPED_MODEL:
				return typedModel != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractDatumImpl
