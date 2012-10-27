/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.pivot.qvtcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bottom Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl#getArea <em>Area</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl#getEnforcementOperation <em>Enforcement Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl#getRealizedVariable <em>Realized Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BottomPatternImpl extends CorePatternImpl implements BottomPattern {
	/**
	 * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignment()
	 * @generated
	 * @ordered
	 */
	protected EList<Assignment> assignment;

	/**
	 * The cached value of the '{@link #getEnforcementOperation() <em>Enforcement Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnforcementOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<EnforcementOperation> enforcementOperation;

	/**
	 * The cached value of the '{@link #getRealizedVariable() <em>Realized Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<RealizedVariable> realizedVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BottomPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.BOTTOM_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Area getArea() {
		if (eContainerFeatureID() != QVTcorePackage.BOTTOM_PATTERN__AREA) return null;
		return (Area)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArea(Area newArea, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newArea, QVTcorePackage.BOTTOM_PATTERN__AREA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArea(Area newArea) {
		if (newArea != eInternalContainer() || (eContainerFeatureID() != QVTcorePackage.BOTTOM_PATTERN__AREA && newArea != null)) {
			if (EcoreUtil.isAncestor(this, newArea))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newArea != null)
				msgs = ((InternalEObject)newArea).eInverseAdd(this, QVTcorePackage.AREA__BOTTOM_PATTERN, Area.class, msgs);
			msgs = basicSetArea(newArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.BOTTOM_PATTERN__AREA, newArea, newArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assignment> getAssignment() {
		if (assignment == null) {
			assignment = new EObjectContainmentWithInverseEList<Assignment>(Assignment.class, this, QVTcorePackage.BOTTOM_PATTERN__ASSIGNMENT, QVTcorePackage.ASSIGNMENT__BOTTOM_PATTERN);
		}
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnforcementOperation> getEnforcementOperation() {
		if (enforcementOperation == null) {
			enforcementOperation = new EObjectContainmentWithInverseEList<EnforcementOperation>(EnforcementOperation.class, this, QVTcorePackage.BOTTOM_PATTERN__ENFORCEMENT_OPERATION, QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN);
		}
		return enforcementOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RealizedVariable> getRealizedVariable() {
		if (realizedVariable == null) {
			realizedVariable = new EObjectContainmentEList<RealizedVariable>(RealizedVariable.class, this, QVTcorePackage.BOTTOM_PATTERN__REALIZED_VARIABLE);
		}
		return realizedVariable;
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
			case QVTcorePackage.BOTTOM_PATTERN__AREA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetArea((Area)otherEnd, msgs);
			case QVTcorePackage.BOTTOM_PATTERN__ASSIGNMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssignment()).basicAdd(otherEnd, msgs);
			case QVTcorePackage.BOTTOM_PATTERN__ENFORCEMENT_OPERATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEnforcementOperation()).basicAdd(otherEnd, msgs);
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
			case QVTcorePackage.BOTTOM_PATTERN__AREA:
				return basicSetArea(null, msgs);
			case QVTcorePackage.BOTTOM_PATTERN__ASSIGNMENT:
				return ((InternalEList<?>)getAssignment()).basicRemove(otherEnd, msgs);
			case QVTcorePackage.BOTTOM_PATTERN__ENFORCEMENT_OPERATION:
				return ((InternalEList<?>)getEnforcementOperation()).basicRemove(otherEnd, msgs);
			case QVTcorePackage.BOTTOM_PATTERN__REALIZED_VARIABLE:
				return ((InternalEList<?>)getRealizedVariable()).basicRemove(otherEnd, msgs);
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
			case QVTcorePackage.BOTTOM_PATTERN__AREA:
				return eInternalContainer().eInverseRemove(this, QVTcorePackage.AREA__BOTTOM_PATTERN, Area.class, msgs);
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
			case QVTcorePackage.BOTTOM_PATTERN__AREA:
				return getArea();
			case QVTcorePackage.BOTTOM_PATTERN__ASSIGNMENT:
				return getAssignment();
			case QVTcorePackage.BOTTOM_PATTERN__ENFORCEMENT_OPERATION:
				return getEnforcementOperation();
			case QVTcorePackage.BOTTOM_PATTERN__REALIZED_VARIABLE:
				return getRealizedVariable();
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
			case QVTcorePackage.BOTTOM_PATTERN__AREA:
				setArea((Area)newValue);
				return;
			case QVTcorePackage.BOTTOM_PATTERN__ASSIGNMENT:
				getAssignment().clear();
				getAssignment().addAll((Collection<? extends Assignment>)newValue);
				return;
			case QVTcorePackage.BOTTOM_PATTERN__ENFORCEMENT_OPERATION:
				getEnforcementOperation().clear();
				getEnforcementOperation().addAll((Collection<? extends EnforcementOperation>)newValue);
				return;
			case QVTcorePackage.BOTTOM_PATTERN__REALIZED_VARIABLE:
				getRealizedVariable().clear();
				getRealizedVariable().addAll((Collection<? extends RealizedVariable>)newValue);
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
			case QVTcorePackage.BOTTOM_PATTERN__AREA:
				setArea((Area)null);
				return;
			case QVTcorePackage.BOTTOM_PATTERN__ASSIGNMENT:
				getAssignment().clear();
				return;
			case QVTcorePackage.BOTTOM_PATTERN__ENFORCEMENT_OPERATION:
				getEnforcementOperation().clear();
				return;
			case QVTcorePackage.BOTTOM_PATTERN__REALIZED_VARIABLE:
				getRealizedVariable().clear();
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
			case QVTcorePackage.BOTTOM_PATTERN__AREA:
				return getArea() != null;
			case QVTcorePackage.BOTTOM_PATTERN__ASSIGNMENT:
				return assignment != null && !assignment.isEmpty();
			case QVTcorePackage.BOTTOM_PATTERN__ENFORCEMENT_OPERATION:
				return enforcementOperation != null && !enforcementOperation.isEmpty();
			case QVTcorePackage.BOTTOM_PATTERN__REALIZED_VARIABLE:
				return realizedVariable != null && !realizedVariable.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return ((QVTcoreVisitor<R>)visitor).visitBottomPattern(this);
	}
} //BottomPatternImpl
