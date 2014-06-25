/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvtd.build.etl.qvtscheduling.DataTypeDatum;
import org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction;
import org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding;
import org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingBindingImpl#getMappingAction <em>Mapping Action</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingBindingImpl#isLoop <em>Loop</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingBindingImpl#getDatum <em>Datum</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingBindingImpl extends MinimalEObjectImpl.Container implements MappingBinding {
	/**
	 * The default value of the '{@link #isLoop() <em>Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOOP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLoop() <em>Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoop()
	 * @generated
	 * @ordered
	 */
	protected boolean loop = LOOP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDatum() <em>Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatum()
	 * @generated
	 * @ordered
	 */
	protected DataTypeDatum datum;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtSchedulingPackage.Literals.MAPPING_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingAction getMappingAction() {
		if (eContainerFeatureID() != QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION) return null;
		return (MappingAction)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingAction(MappingAction newMappingAction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappingAction, QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingAction(MappingAction newMappingAction) {
		if (newMappingAction != eInternalContainer() || (eContainerFeatureID() != QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION && newMappingAction != null)) {
			if (EcoreUtil.isAncestor(this, newMappingAction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappingAction != null)
				msgs = ((InternalEObject)newMappingAction).eInverseAdd(this, QvtSchedulingPackage.MAPPING_ACTION__MAPPING_BINDINGS, MappingAction.class, msgs);
			msgs = basicSetMappingAction(newMappingAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION, newMappingAction, newMappingAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLoop() {
		return loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoop(boolean newLoop) {
		boolean oldLoop = loop;
		loop = newLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtSchedulingPackage.MAPPING_BINDING__LOOP, oldLoop, loop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeDatum getDatum() {
		if (datum != null && datum.eIsProxy()) {
			InternalEObject oldDatum = (InternalEObject)datum;
			datum = (DataTypeDatum)eResolveProxy(oldDatum);
			if (datum != oldDatum) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtSchedulingPackage.MAPPING_BINDING__DATUM, oldDatum, datum));
			}
		}
		return datum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeDatum basicGetDatum() {
		return datum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatum(DataTypeDatum newDatum) {
		DataTypeDatum oldDatum = datum;
		datum = newDatum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtSchedulingPackage.MAPPING_BINDING__DATUM, oldDatum, datum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappingAction((MappingAction)otherEnd, msgs);
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
			case QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION:
				return basicSetMappingAction(null, msgs);
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
			case QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION:
				return eInternalContainer().eInverseRemove(this, QvtSchedulingPackage.MAPPING_ACTION__MAPPING_BINDINGS, MappingAction.class, msgs);
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
			case QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION:
				return getMappingAction();
			case QvtSchedulingPackage.MAPPING_BINDING__LOOP:
				return isLoop();
			case QvtSchedulingPackage.MAPPING_BINDING__DATUM:
				if (resolve) return getDatum();
				return basicGetDatum();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION:
				setMappingAction((MappingAction)newValue);
				return;
			case QvtSchedulingPackage.MAPPING_BINDING__LOOP:
				setLoop((Boolean)newValue);
				return;
			case QvtSchedulingPackage.MAPPING_BINDING__DATUM:
				setDatum((DataTypeDatum)newValue);
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
			case QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION:
				setMappingAction((MappingAction)null);
				return;
			case QvtSchedulingPackage.MAPPING_BINDING__LOOP:
				setLoop(LOOP_EDEFAULT);
				return;
			case QvtSchedulingPackage.MAPPING_BINDING__DATUM:
				setDatum((DataTypeDatum)null);
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
			case QvtSchedulingPackage.MAPPING_BINDING__MAPPING_ACTION:
				return getMappingAction() != null;
			case QvtSchedulingPackage.MAPPING_BINDING__LOOP:
				return loop != LOOP_EDEFAULT;
			case QvtSchedulingPackage.MAPPING_BINDING__DATUM:
				return datum != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (loop: ");
		result.append(loop);
		result.append(')');
		return result.toString();
	}

} //MappingBindingImpl
