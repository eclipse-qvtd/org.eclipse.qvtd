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
package org.eclipse.qvtd.pivot.qvtrelation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.pivot.OCLExpression;

import org.eclipse.ocl.examples.pivot.internal.impl.OCLExpressionImpl;
import org.eclipse.ocl.examples.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationCallExpImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationCallExpImpl#getReferredRelation <em>Referred Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationCallExpImpl extends OCLExpressionImpl implements RelationCallExp {
	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> argument;

	/**
	 * The cached value of the '{@link #getReferredRelation() <em>Referred Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation referredRelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationPackage.Literals.RELATION_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression> getArgument() {
		if (argument == null) {
			argument = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getReferredRelation() {
		if (referredRelation != null && referredRelation.eIsProxy()) {
			InternalEObject oldReferredRelation = (InternalEObject)referredRelation;
			referredRelation = (Relation)eResolveProxy(oldReferredRelation);
			if (referredRelation != oldReferredRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION, oldReferredRelation, referredRelation));
			}
		}
		return referredRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetReferredRelation() {
		return referredRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredRelation(Relation newReferredRelation) {
		Relation oldReferredRelation = referredRelation;
		referredRelation = newReferredRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION, oldReferredRelation, referredRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT:
				return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
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
			case QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT:
				return getArgument();
			case QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				if (resolve) return getReferredRelation();
				return basicGetReferredRelation();
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
			case QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				setReferredRelation((Relation)newValue);
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
			case QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT:
				getArgument().clear();
				return;
			case QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				setReferredRelation((Relation)null);
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
			case QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT:
				return argument != null && !argument.isEmpty();
			case QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				return referredRelation != null;
		}
		return super.eIsSet(featureID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(Visitor<R> visitor) {
		return (R) visitor.getAdapter(QVTrelationVisitor.class).visitRelationCallExp(this);
	}
} //RelationCallExpImpl
