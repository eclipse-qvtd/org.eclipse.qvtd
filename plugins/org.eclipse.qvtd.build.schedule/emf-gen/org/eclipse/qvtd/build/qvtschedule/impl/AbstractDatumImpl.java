/**
 */
package org.eclipse.qvtd.build.qvtschedule.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.qvtd.build.qvtschedule.AbstractAction;
import org.eclipse.qvtd.build.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.build.qvtschedule.DataParameter;
import org.eclipse.qvtd.build.qvtschedule.Schedule;
import org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl#getSuper <em>Super</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl#getDataParameter <em>Data Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractDatumImpl extends MinimalEObjectImpl.Container implements AbstractDatum {
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
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected CoreDomain domain;

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
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAction> targets;

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
		return qvtschedulePackage.Literals.ABSTRACT_DATUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getSuper() {
		if (super_ == null) {
			super_ = new EObjectResolvingEList<AbstractDatum>(AbstractDatum.class, this, qvtschedulePackage.ABSTRACT_DATUM__SUPER);
		}
		return super_;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, qvtschedulePackage.ABSTRACT_DATUM__DOMAIN, oldDomain, domain));
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
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.ABSTRACT_DATUM__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAction> getSources() {
		if (sources == null) {
			sources = new EObjectWithInverseResolvingEList.ManyInverse<AbstractAction>(AbstractAction.class, this, qvtschedulePackage.ABSTRACT_DATUM__SOURCES, qvtschedulePackage.ABSTRACT_ACTION__RESULTS);
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAction> getTargets() {
		if (targets == null) {
			targets = new EObjectWithInverseResolvingEList.ManyInverse<AbstractAction>(AbstractAction.class, this, qvtschedulePackage.ABSTRACT_DATUM__TARGETS, qvtschedulePackage.ABSTRACT_ACTION__ARGUMENTS);
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schedule getSchedule() {
		if (eContainerFeatureID() != qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE) return null;
		return (Schedule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchedule(Schedule newSchedule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSchedule, qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedule(Schedule newSchedule) {
		if (newSchedule != eInternalContainer() || (eContainerFeatureID() != qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE && newSchedule != null)) {
			if (EcoreUtil.isAncestor(this, newSchedule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSchedule != null)
				msgs = ((InternalEObject)newSchedule).eInverseAdd(this, qvtschedulePackage.SCHEDULE__DATUMS, Schedule.class, msgs);
			msgs = basicSetSchedule(newSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE, newSchedule, newSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataParameter> getDataParameter() {
		if (dataParameter == null) {
			dataParameter = new EObjectWithInverseResolvingEList<DataParameter>(DataParameter.class, this, qvtschedulePackage.ABSTRACT_DATUM__DATA_PARAMETER, qvtschedulePackage.DATA_PARAMETER__DATUM);
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
			case qvtschedulePackage.ABSTRACT_DATUM__SOURCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSources()).basicAdd(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_DATUM__TARGETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargets()).basicAdd(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSchedule((Schedule)otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
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
			case qvtschedulePackage.ABSTRACT_DATUM__SOURCES:
				return ((InternalEList<?>)getSources()).basicRemove(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_DATUM__TARGETS:
				return ((InternalEList<?>)getTargets()).basicRemove(otherEnd, msgs);
			case qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE:
				return basicSetSchedule(null, msgs);
			case qvtschedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
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
			case qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE:
				return eInternalContainer().eInverseRemove(this, qvtschedulePackage.SCHEDULE__DATUMS, Schedule.class, msgs);
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
			case qvtschedulePackage.ABSTRACT_DATUM__SUPER:
				return getSuper();
			case qvtschedulePackage.ABSTRACT_DATUM__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case qvtschedulePackage.ABSTRACT_DATUM__SOURCES:
				return getSources();
			case qvtschedulePackage.ABSTRACT_DATUM__TARGETS:
				return getTargets();
			case qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE:
				return getSchedule();
			case qvtschedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
				return getDataParameter();
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
			case qvtschedulePackage.ABSTRACT_DATUM__SUPER:
				getSuper().clear();
				getSuper().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_DATUM__DOMAIN:
				setDomain((CoreDomain)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_DATUM__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends AbstractAction>)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_DATUM__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends AbstractAction>)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE:
				setSchedule((Schedule)newValue);
				return;
			case qvtschedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
				getDataParameter().clear();
				getDataParameter().addAll((Collection<? extends DataParameter>)newValue);
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
			case qvtschedulePackage.ABSTRACT_DATUM__SUPER:
				getSuper().clear();
				return;
			case qvtschedulePackage.ABSTRACT_DATUM__DOMAIN:
				setDomain((CoreDomain)null);
				return;
			case qvtschedulePackage.ABSTRACT_DATUM__SOURCES:
				getSources().clear();
				return;
			case qvtschedulePackage.ABSTRACT_DATUM__TARGETS:
				getTargets().clear();
				return;
			case qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE:
				setSchedule((Schedule)null);
				return;
			case qvtschedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
				getDataParameter().clear();
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
			case qvtschedulePackage.ABSTRACT_DATUM__SUPER:
				return super_ != null && !super_.isEmpty();
			case qvtschedulePackage.ABSTRACT_DATUM__DOMAIN:
				return domain != null;
			case qvtschedulePackage.ABSTRACT_DATUM__SOURCES:
				return sources != null && !sources.isEmpty();
			case qvtschedulePackage.ABSTRACT_DATUM__TARGETS:
				return targets != null && !targets.isEmpty();
			case qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE:
				return getSchedule() != null;
			case qvtschedulePackage.ABSTRACT_DATUM__DATA_PARAMETER:
				return dataParameter != null && !dataParameter.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractDatumImpl
