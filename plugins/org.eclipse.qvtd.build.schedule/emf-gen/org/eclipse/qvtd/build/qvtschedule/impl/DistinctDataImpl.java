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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.build.qvtschedule.AbstractAction;
import org.eclipse.qvtd.build.qvtschedule.DataParameter;
import org.eclipse.qvtd.build.qvtschedule.DistinctData;
import org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distinct Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.DistinctDataImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.DistinctDataImpl#getPrimaryArguments <em>Primary Arguments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.DistinctDataImpl#getSecondaryArguments <em>Secondary Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DistinctDataImpl extends MinimalEObjectImpl.Container implements DistinctData {
	/**
	 * The cached value of the '{@link #getPrimaryArguments() <em>Primary Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<DataParameter> primaryArguments;

	/**
	 * The cached value of the '{@link #getSecondaryArguments() <em>Secondary Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondaryArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<DataParameter> secondaryArguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DistinctDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return qvtschedulePackage.Literals.DISTINCT_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction getTarget() {
		if (eContainerFeatureID() != qvtschedulePackage.DISTINCT_DATA__TARGET) return null;
		return (AbstractAction)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(AbstractAction newTarget, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTarget, qvtschedulePackage.DISTINCT_DATA__TARGET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(AbstractAction newTarget) {
		if (newTarget != eInternalContainer() || (eContainerFeatureID() != qvtschedulePackage.DISTINCT_DATA__TARGET && newTarget != null)) {
			if (EcoreUtil.isAncestor(this, newTarget))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, qvtschedulePackage.ABSTRACT_ACTION__DISTINCT_ARGUMENTS, AbstractAction.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.DISTINCT_DATA__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataParameter> getPrimaryArguments() {
		if (primaryArguments == null) {
			primaryArguments = new EObjectContainmentWithInverseEList<DataParameter>(DataParameter.class, this, qvtschedulePackage.DISTINCT_DATA__PRIMARY_ARGUMENTS, qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA);
		}
		return primaryArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataParameter> getSecondaryArguments() {
		if (secondaryArguments == null) {
			secondaryArguments = new EObjectContainmentWithInverseEList<DataParameter>(DataParameter.class, this, qvtschedulePackage.DISTINCT_DATA__SECONDARY_ARGUMENTS, qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA);
		}
		return secondaryArguments;
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
			case qvtschedulePackage.DISTINCT_DATA__TARGET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTarget((AbstractAction)otherEnd, msgs);
			case qvtschedulePackage.DISTINCT_DATA__PRIMARY_ARGUMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPrimaryArguments()).basicAdd(otherEnd, msgs);
			case qvtschedulePackage.DISTINCT_DATA__SECONDARY_ARGUMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSecondaryArguments()).basicAdd(otherEnd, msgs);
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
			case qvtschedulePackage.DISTINCT_DATA__TARGET:
				return basicSetTarget(null, msgs);
			case qvtschedulePackage.DISTINCT_DATA__PRIMARY_ARGUMENTS:
				return ((InternalEList<?>)getPrimaryArguments()).basicRemove(otherEnd, msgs);
			case qvtschedulePackage.DISTINCT_DATA__SECONDARY_ARGUMENTS:
				return ((InternalEList<?>)getSecondaryArguments()).basicRemove(otherEnd, msgs);
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
			case qvtschedulePackage.DISTINCT_DATA__TARGET:
				return eInternalContainer().eInverseRemove(this, qvtschedulePackage.ABSTRACT_ACTION__DISTINCT_ARGUMENTS, AbstractAction.class, msgs);
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
			case qvtschedulePackage.DISTINCT_DATA__TARGET:
				return getTarget();
			case qvtschedulePackage.DISTINCT_DATA__PRIMARY_ARGUMENTS:
				return getPrimaryArguments();
			case qvtschedulePackage.DISTINCT_DATA__SECONDARY_ARGUMENTS:
				return getSecondaryArguments();
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
			case qvtschedulePackage.DISTINCT_DATA__TARGET:
				setTarget((AbstractAction)newValue);
				return;
			case qvtschedulePackage.DISTINCT_DATA__PRIMARY_ARGUMENTS:
				getPrimaryArguments().clear();
				getPrimaryArguments().addAll((Collection<? extends DataParameter>)newValue);
				return;
			case qvtschedulePackage.DISTINCT_DATA__SECONDARY_ARGUMENTS:
				getSecondaryArguments().clear();
				getSecondaryArguments().addAll((Collection<? extends DataParameter>)newValue);
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
			case qvtschedulePackage.DISTINCT_DATA__TARGET:
				setTarget((AbstractAction)null);
				return;
			case qvtschedulePackage.DISTINCT_DATA__PRIMARY_ARGUMENTS:
				getPrimaryArguments().clear();
				return;
			case qvtschedulePackage.DISTINCT_DATA__SECONDARY_ARGUMENTS:
				getSecondaryArguments().clear();
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
			case qvtschedulePackage.DISTINCT_DATA__TARGET:
				return getTarget() != null;
			case qvtschedulePackage.DISTINCT_DATA__PRIMARY_ARGUMENTS:
				return primaryArguments != null && !primaryArguments.isEmpty();
			case qvtschedulePackage.DISTINCT_DATA__SECONDARY_ARGUMENTS:
				return secondaryArguments != null && !secondaryArguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DistinctDataImpl
