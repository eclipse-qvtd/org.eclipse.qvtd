/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction;
import org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum;
import org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData;
import org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distinct Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.DistinctDataImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.DistinctDataImpl#getPrimaryArgument <em>Primary Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.DistinctDataImpl#getSecondaryArgument <em>Secondary Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DistinctDataImpl extends MinimalEObjectImpl.Container implements DistinctData {
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
	 * The cached value of the '{@link #getPrimaryArgument() <em>Primary Argument</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> primaryArgument;

	/**
	 * The cached value of the '{@link #getSecondaryArgument() <em>Secondary Argument</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondaryArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> secondaryArgument;

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
		return QvtSchedulingPackage.Literals.DISTINCT_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractAction> getTargets() {
		if (targets == null) {
			targets = new EObjectWithInverseResolvingEList.ManyInverse<AbstractAction>(AbstractAction.class, this, QvtSchedulingPackage.DISTINCT_DATA__TARGETS, QvtSchedulingPackage.ABSTRACT_ACTION__DISTINCT_ARGUMENTS);
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getPrimaryArgument() {
		if (primaryArgument == null) {
			primaryArgument = new EObjectWithInverseResolvingEList<AbstractDatum>(AbstractDatum.class, this, QvtSchedulingPackage.DISTINCT_DATA__PRIMARY_ARGUMENT, QvtSchedulingPackage.ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA);
		}
		return primaryArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDatum> getSecondaryArgument() {
		if (secondaryArgument == null) {
			secondaryArgument = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, QvtSchedulingPackage.DISTINCT_DATA__SECONDARY_ARGUMENT, QvtSchedulingPackage.ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA);
		}
		return secondaryArgument;
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
			case QvtSchedulingPackage.DISTINCT_DATA__TARGETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargets()).basicAdd(otherEnd, msgs);
			case QvtSchedulingPackage.DISTINCT_DATA__PRIMARY_ARGUMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPrimaryArgument()).basicAdd(otherEnd, msgs);
			case QvtSchedulingPackage.DISTINCT_DATA__SECONDARY_ARGUMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSecondaryArgument()).basicAdd(otherEnd, msgs);
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
			case QvtSchedulingPackage.DISTINCT_DATA__TARGETS:
				return ((InternalEList<?>)getTargets()).basicRemove(otherEnd, msgs);
			case QvtSchedulingPackage.DISTINCT_DATA__PRIMARY_ARGUMENT:
				return ((InternalEList<?>)getPrimaryArgument()).basicRemove(otherEnd, msgs);
			case QvtSchedulingPackage.DISTINCT_DATA__SECONDARY_ARGUMENT:
				return ((InternalEList<?>)getSecondaryArgument()).basicRemove(otherEnd, msgs);
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
			case QvtSchedulingPackage.DISTINCT_DATA__TARGETS:
				return getTargets();
			case QvtSchedulingPackage.DISTINCT_DATA__PRIMARY_ARGUMENT:
				return getPrimaryArgument();
			case QvtSchedulingPackage.DISTINCT_DATA__SECONDARY_ARGUMENT:
				return getSecondaryArgument();
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
			case QvtSchedulingPackage.DISTINCT_DATA__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends AbstractAction>)newValue);
				return;
			case QvtSchedulingPackage.DISTINCT_DATA__PRIMARY_ARGUMENT:
				getPrimaryArgument().clear();
				getPrimaryArgument().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case QvtSchedulingPackage.DISTINCT_DATA__SECONDARY_ARGUMENT:
				getSecondaryArgument().clear();
				getSecondaryArgument().addAll((Collection<? extends AbstractDatum>)newValue);
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
			case QvtSchedulingPackage.DISTINCT_DATA__TARGETS:
				getTargets().clear();
				return;
			case QvtSchedulingPackage.DISTINCT_DATA__PRIMARY_ARGUMENT:
				getPrimaryArgument().clear();
				return;
			case QvtSchedulingPackage.DISTINCT_DATA__SECONDARY_ARGUMENT:
				getSecondaryArgument().clear();
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
			case QvtSchedulingPackage.DISTINCT_DATA__TARGETS:
				return targets != null && !targets.isEmpty();
			case QvtSchedulingPackage.DISTINCT_DATA__PRIMARY_ARGUMENT:
				return primaryArgument != null && !primaryArgument.isEmpty();
			case QvtSchedulingPackage.DISTINCT_DATA__SECONDARY_ARGUMENT:
				return secondaryArgument != null && !secondaryArgument.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DistinctDataImpl
