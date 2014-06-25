/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.pivot.Type;

import org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction;
import org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum;
import org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData;
import org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage;

import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl#getPrimaryDistinctData <em>Primary Distinct Data</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl#getSecondaryDistinctData <em>Secondary Distinct Data</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl#getSuper <em>Super</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl#getTargets <em>Targets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractDatumImpl extends MinimalEObjectImpl.Container implements AbstractDatum {
	/**
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAction> sources;

	/**
	 * The cached value of the '{@link #getPrimaryDistinctData() <em>Primary Distinct Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryDistinctData()
	 * @generated
	 * @ordered
	 */
	protected DistinctData primaryDistinctData;

	/**
	 * The cached value of the '{@link #getSecondaryDistinctData() <em>Secondary Distinct Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondaryDistinctData()
	 * @generated
	 * @ordered
	 */
	protected EList<DistinctData> secondaryDistinctData;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected AbstractDatum parent;

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
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

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
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAction> targets;

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
		return QvtSchedulingPackage.Literals.ABSTRACT_DATUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAction> getSources() {
		if (sources == null) {
			sources = new EObjectWithInverseResolvingEList.ManyInverse<AbstractAction>(AbstractAction.class, this, QvtSchedulingPackage.ABSTRACT_DATUM__SOURCES, QvtSchedulingPackage.ABSTRACT_ACTION__RESULTS);
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistinctData getPrimaryDistinctData() {
		if (primaryDistinctData != null && primaryDistinctData.eIsProxy()) {
			InternalEObject oldPrimaryDistinctData = (InternalEObject)primaryDistinctData;
			primaryDistinctData = (DistinctData)eResolveProxy(oldPrimaryDistinctData);
			if (primaryDistinctData != oldPrimaryDistinctData) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtSchedulingPackage.ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA, oldPrimaryDistinctData, primaryDistinctData));
			}
		}
		return primaryDistinctData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistinctData basicGetPrimaryDistinctData() {
		return primaryDistinctData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimaryDistinctData(DistinctData newPrimaryDistinctData, NotificationChain msgs) {
		DistinctData oldPrimaryDistinctData = primaryDistinctData;
		primaryDistinctData = newPrimaryDistinctData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtSchedulingPackage.ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA, oldPrimaryDistinctData, newPrimaryDistinctData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryDistinctData(DistinctData newPrimaryDistinctData) {
		if (newPrimaryDistinctData != primaryDistinctData) {
			NotificationChain msgs = null;
			if (primaryDistinctData != null)
				msgs = ((InternalEObject)primaryDistinctData).eInverseRemove(this, QvtSchedulingPackage.DISTINCT_DATA__PRIMARY_ARGUMENT, DistinctData.class, msgs);
			if (newPrimaryDistinctData != null)
				msgs = ((InternalEObject)newPrimaryDistinctData).eInverseAdd(this, QvtSchedulingPackage.DISTINCT_DATA__PRIMARY_ARGUMENT, DistinctData.class, msgs);
			msgs = basicSetPrimaryDistinctData(newPrimaryDistinctData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtSchedulingPackage.ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA, newPrimaryDistinctData, newPrimaryDistinctData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DistinctData> getSecondaryDistinctData() {
		if (secondaryDistinctData == null) {
			secondaryDistinctData = new EObjectWithInverseResolvingEList.ManyInverse<DistinctData>(DistinctData.class, this, QvtSchedulingPackage.ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA, QvtSchedulingPackage.DISTINCT_DATA__SECONDARY_ARGUMENT);
		}
		return secondaryDistinctData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractDatum getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (AbstractDatum)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtSchedulingPackage.ABSTRACT_DATUM__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractDatum basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(AbstractDatum newParent) {
		AbstractDatum oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtSchedulingPackage.ABSTRACT_DATUM__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getSuper() {
		if (super_ == null) {
			super_ = new EObjectResolvingEList<AbstractDatum>(AbstractDatum.class, this, QvtSchedulingPackage.ABSTRACT_DATUM__SUPER);
		}
		return super_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && ((EObject)type).eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtSchedulingPackage.ABSTRACT_DATUM__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtSchedulingPackage.ABSTRACT_DATUM__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreDomain getDomain() {
		if (domain != null && domain.eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = (CoreDomain)eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtSchedulingPackage.ABSTRACT_DATUM__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
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
	public void setDomain(CoreDomain newDomain) {
		CoreDomain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtSchedulingPackage.ABSTRACT_DATUM__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAction> getTargets() {
		if (targets == null) {
			targets = new EObjectWithInverseResolvingEList.ManyInverse<AbstractAction>(AbstractAction.class, this, QvtSchedulingPackage.ABSTRACT_DATUM__TARGETS, QvtSchedulingPackage.ABSTRACT_ACTION__ARGUMENTS);
		}
		return targets;
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
			case QvtSchedulingPackage.ABSTRACT_DATUM__SOURCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSources()).basicAdd(otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA:
				if (primaryDistinctData != null)
					msgs = ((InternalEObject)primaryDistinctData).eInverseRemove(this, QvtSchedulingPackage.DISTINCT_DATA__PRIMARY_ARGUMENT, DistinctData.class, msgs);
				return basicSetPrimaryDistinctData((DistinctData)otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSecondaryDistinctData()).basicAdd(otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_DATUM__TARGETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargets()).basicAdd(otherEnd, msgs);
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
			case QvtSchedulingPackage.ABSTRACT_DATUM__SOURCES:
				return ((InternalEList<?>)getSources()).basicRemove(otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA:
				return basicSetPrimaryDistinctData(null, msgs);
			case QvtSchedulingPackage.ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA:
				return ((InternalEList<?>)getSecondaryDistinctData()).basicRemove(otherEnd, msgs);
			case QvtSchedulingPackage.ABSTRACT_DATUM__TARGETS:
				return ((InternalEList<?>)getTargets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtSchedulingPackage.ABSTRACT_DATUM__SOURCES:
				return getSources();
			case QvtSchedulingPackage.ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA:
				if (resolve) return getPrimaryDistinctData();
				return basicGetPrimaryDistinctData();
			case QvtSchedulingPackage.ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA:
				return getSecondaryDistinctData();
			case QvtSchedulingPackage.ABSTRACT_DATUM__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case QvtSchedulingPackage.ABSTRACT_DATUM__SUPER:
				return getSuper();
			case QvtSchedulingPackage.ABSTRACT_DATUM__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case QvtSchedulingPackage.ABSTRACT_DATUM__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case QvtSchedulingPackage.ABSTRACT_DATUM__TARGETS:
				return getTargets();
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
			case QvtSchedulingPackage.ABSTRACT_DATUM__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends AbstractAction>)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA:
				setPrimaryDistinctData((DistinctData)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA:
				getSecondaryDistinctData().clear();
				getSecondaryDistinctData().addAll((Collection<? extends DistinctData>)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__PARENT:
				setParent((AbstractDatum)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__SUPER:
				getSuper().clear();
				getSuper().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__TYPE:
				setType((Type)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__DOMAIN:
				setDomain((CoreDomain)newValue);
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends AbstractAction>)newValue);
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
			case QvtSchedulingPackage.ABSTRACT_DATUM__SOURCES:
				getSources().clear();
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA:
				setPrimaryDistinctData((DistinctData)null);
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA:
				getSecondaryDistinctData().clear();
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__PARENT:
				setParent((AbstractDatum)null);
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__SUPER:
				getSuper().clear();
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__TYPE:
				setType((Type)null);
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__DOMAIN:
				setDomain((CoreDomain)null);
				return;
			case QvtSchedulingPackage.ABSTRACT_DATUM__TARGETS:
				getTargets().clear();
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
			case QvtSchedulingPackage.ABSTRACT_DATUM__SOURCES:
				return sources != null && !sources.isEmpty();
			case QvtSchedulingPackage.ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA:
				return primaryDistinctData != null;
			case QvtSchedulingPackage.ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA:
				return secondaryDistinctData != null && !secondaryDistinctData.isEmpty();
			case QvtSchedulingPackage.ABSTRACT_DATUM__PARENT:
				return parent != null;
			case QvtSchedulingPackage.ABSTRACT_DATUM__SUPER:
				return super_ != null && !super_.isEmpty();
			case QvtSchedulingPackage.ABSTRACT_DATUM__TYPE:
				return type != null;
			case QvtSchedulingPackage.ABSTRACT_DATUM__DOMAIN:
				return domain != null;
			case QvtSchedulingPackage.ABSTRACT_DATUM__TARGETS:
				return targets != null && !targets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractDatumImpl
