/**
 */
package org.eclipse.qvtd.build.qvtschedule.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.build.qvtschedule.AbstractAction;
import org.eclipse.qvtd.build.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.build.qvtschedule.Schedule;
import org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Schedule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.ScheduleImpl#getDatums <em>Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.ScheduleImpl#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScheduleImpl extends MinimalEObjectImpl.Container implements Schedule {
	/**
	 * The cached value of the '{@link #getDatums() <em>Datums</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatums()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> datums;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractAction> actions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScheduleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return qvtschedulePackage.Literals.SCHEDULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getDatums() {
		if (datums == null) {
			datums = new EObjectContainmentWithInverseEList<AbstractDatum>(AbstractDatum.class, this, qvtschedulePackage.SCHEDULE__DATUMS, qvtschedulePackage.ABSTRACT_DATUM__SCHEDULE);
		}
		return datums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAction> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentWithInverseEList<AbstractAction>(AbstractAction.class, this, qvtschedulePackage.SCHEDULE__ACTIONS, qvtschedulePackage.ABSTRACT_ACTION__SCHEDULE);
		}
		return actions;
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
			case qvtschedulePackage.SCHEDULE__DATUMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDatums()).basicAdd(otherEnd, msgs);
			case qvtschedulePackage.SCHEDULE__ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getActions()).basicAdd(otherEnd, msgs);
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
			case qvtschedulePackage.SCHEDULE__DATUMS:
				return ((InternalEList<?>)getDatums()).basicRemove(otherEnd, msgs);
			case qvtschedulePackage.SCHEDULE__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
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
			case qvtschedulePackage.SCHEDULE__DATUMS:
				return getDatums();
			case qvtschedulePackage.SCHEDULE__ACTIONS:
				return getActions();
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
			case qvtschedulePackage.SCHEDULE__DATUMS:
				getDatums().clear();
				getDatums().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case qvtschedulePackage.SCHEDULE__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends AbstractAction>)newValue);
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
			case qvtschedulePackage.SCHEDULE__DATUMS:
				getDatums().clear();
				return;
			case qvtschedulePackage.SCHEDULE__ACTIONS:
				getActions().clear();
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
			case qvtschedulePackage.SCHEDULE__DATUMS:
				return datums != null && !datums.isEmpty();
			case qvtschedulePackage.SCHEDULE__ACTIONS:
				return actions != null && !actions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ScheduleImpl
