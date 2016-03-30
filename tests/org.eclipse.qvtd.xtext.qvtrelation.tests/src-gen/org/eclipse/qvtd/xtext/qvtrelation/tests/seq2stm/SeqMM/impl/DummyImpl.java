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
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Dummy;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dummy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.DummyImpl#getHasInteraction <em>Has Interaction</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.DummyImpl#getContainedState <em>Contained State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DummyImpl extends MinimalEObjectImpl.Container implements Dummy {
	/**
	 * The cached value of the '{@link #getHasInteraction() <em>Has Interaction</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasInteraction()
	 * @generated
	 * @ordered
	 */
	protected EList<Interaction> hasInteraction;

	/**
	 * The cached value of the '{@link #getContainedState() <em>Contained State</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedState()
	 * @generated
	 * @ordered
	 */
	protected EList<State> containedState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DummyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeqMMPackage.Literals.DUMMY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interaction> getHasInteraction() {
		if (hasInteraction == null) {
			hasInteraction = new EObjectContainmentEList<Interaction>(Interaction.class, this, SeqMMPackage.DUMMY__HAS_INTERACTION);
		}
		return hasInteraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getContainedState() {
		if (containedState == null) {
			containedState = new EObjectContainmentEList<State>(State.class, this, SeqMMPackage.DUMMY__CONTAINED_STATE);
		}
		return containedState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeqMMPackage.DUMMY__HAS_INTERACTION:
				return ((InternalEList<?>)getHasInteraction()).basicRemove(otherEnd, msgs);
			case SeqMMPackage.DUMMY__CONTAINED_STATE:
				return ((InternalEList<?>)getContainedState()).basicRemove(otherEnd, msgs);
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
			case SeqMMPackage.DUMMY__HAS_INTERACTION:
				return getHasInteraction();
			case SeqMMPackage.DUMMY__CONTAINED_STATE:
				return getContainedState();
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
			case SeqMMPackage.DUMMY__HAS_INTERACTION:
				getHasInteraction().clear();
				getHasInteraction().addAll((Collection<? extends Interaction>)newValue);
				return;
			case SeqMMPackage.DUMMY__CONTAINED_STATE:
				getContainedState().clear();
				getContainedState().addAll((Collection<? extends State>)newValue);
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
			case SeqMMPackage.DUMMY__HAS_INTERACTION:
				getHasInteraction().clear();
				return;
			case SeqMMPackage.DUMMY__CONTAINED_STATE:
				getContainedState().clear();
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
			case SeqMMPackage.DUMMY__HAS_INTERACTION:
				return hasInteraction != null && !hasInteraction.isEmpty();
			case SeqMMPackage.DUMMY__CONTAINED_STATE:
				return containedState != null && !containedState.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DummyImpl
