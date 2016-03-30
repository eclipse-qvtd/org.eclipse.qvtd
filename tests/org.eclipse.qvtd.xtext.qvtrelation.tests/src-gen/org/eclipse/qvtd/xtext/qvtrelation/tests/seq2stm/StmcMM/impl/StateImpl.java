/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl;

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

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateImpl#getInTransition <em>In Transition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateImpl#getOutTransition <em>Out Transition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateImpl extends MinimalEObjectImpl.Container implements State {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInTransition() <em>In Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTransition()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> inTransition;

	/**
	 * The cached value of the '{@link #getOutTransition() <em>Out Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutTransition()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outTransition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StmcMMPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StmcMMPackage.STATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getOwner() {
		if (eContainerFeatureID() != StmcMMPackage.STATE__OWNER) return null;
		return (StateMachine)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(StateMachine newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, StmcMMPackage.STATE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(StateMachine newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != StmcMMPackage.STATE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, StmcMMPackage.STATE_MACHINE__STATE, StateMachine.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StmcMMPackage.STATE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getInTransition() {
		if (inTransition == null) {
			inTransition = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, StmcMMPackage.STATE__IN_TRANSITION, StmcMMPackage.TRANSITION__TO_STATE);
		}
		return inTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutTransition() {
		if (outTransition == null) {
			outTransition = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, StmcMMPackage.STATE__OUT_TRANSITION, StmcMMPackage.TRANSITION__FROM_STATE);
		}
		return outTransition;
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
			case StmcMMPackage.STATE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((StateMachine)otherEnd, msgs);
			case StmcMMPackage.STATE__IN_TRANSITION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInTransition()).basicAdd(otherEnd, msgs);
			case StmcMMPackage.STATE__OUT_TRANSITION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutTransition()).basicAdd(otherEnd, msgs);
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
			case StmcMMPackage.STATE__OWNER:
				return basicSetOwner(null, msgs);
			case StmcMMPackage.STATE__IN_TRANSITION:
				return ((InternalEList<?>)getInTransition()).basicRemove(otherEnd, msgs);
			case StmcMMPackage.STATE__OUT_TRANSITION:
				return ((InternalEList<?>)getOutTransition()).basicRemove(otherEnd, msgs);
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
			case StmcMMPackage.STATE__OWNER:
				return eInternalContainer().eInverseRemove(this, StmcMMPackage.STATE_MACHINE__STATE, StateMachine.class, msgs);
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
			case StmcMMPackage.STATE__NAME:
				return getName();
			case StmcMMPackage.STATE__OWNER:
				return getOwner();
			case StmcMMPackage.STATE__IN_TRANSITION:
				return getInTransition();
			case StmcMMPackage.STATE__OUT_TRANSITION:
				return getOutTransition();
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
			case StmcMMPackage.STATE__NAME:
				setName((String)newValue);
				return;
			case StmcMMPackage.STATE__OWNER:
				setOwner((StateMachine)newValue);
				return;
			case StmcMMPackage.STATE__IN_TRANSITION:
				getInTransition().clear();
				getInTransition().addAll((Collection<? extends Transition>)newValue);
				return;
			case StmcMMPackage.STATE__OUT_TRANSITION:
				getOutTransition().clear();
				getOutTransition().addAll((Collection<? extends Transition>)newValue);
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
			case StmcMMPackage.STATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StmcMMPackage.STATE__OWNER:
				setOwner((StateMachine)null);
				return;
			case StmcMMPackage.STATE__IN_TRANSITION:
				getInTransition().clear();
				return;
			case StmcMMPackage.STATE__OUT_TRANSITION:
				getOutTransition().clear();
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
			case StmcMMPackage.STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StmcMMPackage.STATE__OWNER:
				return getOwner() != null;
			case StmcMMPackage.STATE__IN_TRANSITION:
				return inTransition != null && !inTransition.isEmpty();
			case StmcMMPackage.STATE__OUT_TRANSITION:
				return outTransition != null && !outTransition.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //StateImpl
