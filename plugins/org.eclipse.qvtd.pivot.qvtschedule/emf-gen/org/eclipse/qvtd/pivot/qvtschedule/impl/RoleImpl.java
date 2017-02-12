/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Phase;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl#getPhase <em>Phase</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl#isLoaded <em>Loaded</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl#isNew <em>New</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl#isOld <em>Old</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl#isPredicated <em>Predicated</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl#isRealized <em>Realized</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl#isSpeculated <em>Speculated</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl#isSpeculation <em>Speculation</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RoleImpl extends ElementImpl implements Role {
	/**
	 * The default value of the '{@link #getPhase() <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhase()
	 * @generated
	 * @ordered
	 */
	protected static final Phase PHASE_EDEFAULT = Phase.CONSTANT;
	/**
	 * The cached value of the '{@link #getPhase() <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhase()
	 * @generated
	 * @ordered
	 */
	protected Phase phase = PHASE_EDEFAULT;

	/**
	 * The default value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSTANT_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isLoaded() <em>Loaded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoaded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOADED_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isNew() <em>New</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNew()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEW_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isOld() <em>Old</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOld()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OLD_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isPredicated() <em>Predicated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPredicated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PREDICATED_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isRealized() <em>Realized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRealized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REALIZED_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isSpeculated() <em>Speculated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpeculated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SPECULATED_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isSpeculation() <em>Speculation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpeculation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SPECULATION_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Phase getPhase() {
		return phase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPhase(Phase newPhase) {
		Phase oldPhase = phase;
		phase = newPhase == null ? PHASE_EDEFAULT : newPhase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.ROLE__PHASE, oldPhase, phase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isConstant() {
		/**
		 * phase = Phase::CONSTANT
		 */
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtschedule.@NonNull Phase phase = this.getPhase();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull EnumerationLiteralId BOXED_phase = QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId(ClassUtil.nonNullState(phase.getName()));
		final /*@NonInvalid*/ boolean eq = BOXED_phase == QVTscheduleTables.ELITid_CONSTANT;
		return eq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLoaded() {
		/**
		 * phase = Phase::LOADED
		 */
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtschedule.@NonNull Phase phase = this.getPhase();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull EnumerationLiteralId BOXED_phase = QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId(ClassUtil.nonNullState(phase.getName()));
		final /*@NonInvalid*/ boolean eq = BOXED_phase == QVTscheduleTables.ELITid_LOADED;
		return eq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNew() {
		/**
		 * phase = Phase::SPECULATION or phase = Phase::REALIZED
		 */
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtschedule.@NonNull Phase phase_0 = this.getPhase();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull EnumerationLiteralId BOXED_phase_0 = QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId(ClassUtil.nonNullState(phase_0.getName()));
		final /*@NonInvalid*/ boolean eq = BOXED_phase_0 == QVTscheduleTables.ELITid_SPECULATION;
		/*@NonInvalid*/ boolean or;
		if (eq) {
			or = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ boolean eq_0 = BOXED_phase_0 == QVTscheduleTables.ELITid_REALIZED;
			or = eq_0;
		}
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isOld() {
		/**
		 * phase = Phase::CONSTANT or phase = Phase::LOADED or phase = Phase::PREDICATED or phase = Phase::SPECULATED
		 */
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtschedule.@NonNull Phase phase_2 = this.getPhase();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull EnumerationLiteralId BOXED_phase_2 = QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId(ClassUtil.nonNullState(phase_2.getName()));
		final /*@NonInvalid*/ boolean eq = BOXED_phase_2 == QVTscheduleTables.ELITid_CONSTANT;
		/*@NonInvalid*/ boolean or;
		if (eq) {
			or = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ boolean eq_0 = BOXED_phase_2 == QVTscheduleTables.ELITid_LOADED;
			or = eq_0;
		}
		/*@NonInvalid*/ boolean or_0;
		if (or) {
			or_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ boolean eq_1 = BOXED_phase_2 == QVTscheduleTables.ELITid_PREDICATED;
			or_0 = eq_1;
		}
		/*@NonInvalid*/ boolean or_1;
		if (or_0) {
			or_1 = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ boolean eq_2 = BOXED_phase_2 == QVTscheduleTables.ELITid_SPECULATED;
			or_1 = eq_2;
		}
		return or_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPredicated() {
		/**
		 * phase = Phase::PREDICATED
		 */
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtschedule.@NonNull Phase phase = this.getPhase();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull EnumerationLiteralId BOXED_phase = QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId(ClassUtil.nonNullState(phase.getName()));
		final /*@NonInvalid*/ boolean eq = BOXED_phase == QVTscheduleTables.ELITid_PREDICATED;
		return eq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRealized() {
		/**
		 * phase = Phase::REALIZED
		 */
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtschedule.@NonNull Phase phase = this.getPhase();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull EnumerationLiteralId BOXED_phase = QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId(ClassUtil.nonNullState(phase.getName()));
		final /*@NonInvalid*/ boolean eq = BOXED_phase == QVTscheduleTables.ELITid_REALIZED;
		return eq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSpeculated() {
		/**
		 * phase = Phase::SPECULATED
		 */
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtschedule.@NonNull Phase phase = this.getPhase();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull EnumerationLiteralId BOXED_phase = QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId(ClassUtil.nonNullState(phase.getName()));
		final /*@NonInvalid*/ boolean eq = BOXED_phase == QVTscheduleTables.ELITid_SPECULATED;
		return eq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSpeculation() {
		/**
		 * phase = Phase::SPECULATION
		 */
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtschedule.@NonNull Phase phase = this.getPhase();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull EnumerationLiteralId BOXED_phase = QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId(ClassUtil.nonNullState(phase.getName()));
		final /*@NonInvalid*/ boolean eq = BOXED_phase == QVTscheduleTables.ELITid_SPECULATION;
		return eq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.ROLE__PHASE:
				return getPhase();
			case QVTschedulePackage.ROLE__CONSTANT:
				return isConstant();
			case QVTschedulePackage.ROLE__LOADED:
				return isLoaded();
			case QVTschedulePackage.ROLE__NEW:
				return isNew();
			case QVTschedulePackage.ROLE__OLD:
				return isOld();
			case QVTschedulePackage.ROLE__PREDICATED:
				return isPredicated();
			case QVTschedulePackage.ROLE__REALIZED:
				return isRealized();
			case QVTschedulePackage.ROLE__SPECULATED:
				return isSpeculated();
			case QVTschedulePackage.ROLE__SPECULATION:
				return isSpeculation();
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
			case QVTschedulePackage.ROLE__PHASE:
				setPhase((Phase)newValue);
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
			case QVTschedulePackage.ROLE__PHASE:
				setPhase(PHASE_EDEFAULT);
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
			case QVTschedulePackage.ROLE__PHASE:
				return phase != PHASE_EDEFAULT;
			case QVTschedulePackage.ROLE__CONSTANT:
				return isConstant() != CONSTANT_EDEFAULT;
			case QVTschedulePackage.ROLE__LOADED:
				return isLoaded() != LOADED_EDEFAULT;
			case QVTschedulePackage.ROLE__NEW:
				return isNew() != NEW_EDEFAULT;
			case QVTschedulePackage.ROLE__OLD:
				return isOld() != OLD_EDEFAULT;
			case QVTschedulePackage.ROLE__PREDICATED:
				return isPredicated() != PREDICATED_EDEFAULT;
			case QVTschedulePackage.ROLE__REALIZED:
				return isRealized() != REALIZED_EDEFAULT;
			case QVTschedulePackage.ROLE__SPECULATED:
				return isSpeculated() != SPECULATED_EDEFAULT;
			case QVTschedulePackage.ROLE__SPECULATION:
				return isSpeculation() != SPECULATION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public int compareTo(Role o) {
		return phase.compareTo(o.getPhase());
	}

	@Override
	public String toString() {
		return phase + "-" + getClass().getSimpleName();
	}
} //RoleImpl
