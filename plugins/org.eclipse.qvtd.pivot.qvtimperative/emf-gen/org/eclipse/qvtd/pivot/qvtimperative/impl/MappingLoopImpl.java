/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl#getOwnedIterators <em>Owned Iterators</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl#getOwnedMappingStatements <em>Owned Mapping Statements</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl#getOwnedSource <em>Owned Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingLoopImpl extends MappingStatementImpl implements MappingLoop {
	/**
	 * The cached value of the '{@link #getOwnedIterators() <em>Owned Iterators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<LoopVariable> ownedIterators;

	/**
	 * The cached value of the '{@link #getOwnedMappingStatements() <em>Owned Mapping Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappingStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingStatement> ownedMappingStatements;

	/**
	 * The cached value of the '{@link #getOwnedSource() <em>Owned Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSource()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedSource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.MAPPING_LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LoopVariable> getOwnedIterators() {
		if (ownedIterators == null) {
			ownedIterators = new EObjectContainmentWithInverseEList<LoopVariable>(LoopVariable.class, this, QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS, QVTimperativePackage.LOOP_VARIABLE__OWNING_MAPPING_LOOP);
		}
		return ownedIterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingStatement> getOwnedMappingStatements() {
		if (ownedMappingStatements == null) {
			ownedMappingStatements = new EObjectContainmentEList<MappingStatement>(MappingStatement.class, this, QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS);
		}
		return ownedMappingStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedSource() {
		return ownedSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSource(OCLExpression newOwnedSource, NotificationChain msgs) {
		OCLExpression oldOwnedSource = ownedSource;
		ownedSource = newOwnedSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_LOOP__OWNED_SOURCE, oldOwnedSource, newOwnedSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedSource(OCLExpression newOwnedSource) {
		if (newOwnedSource != ownedSource) {
			NotificationChain msgs = null;
			if (ownedSource != null)
				msgs = ((InternalEObject)ownedSource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.MAPPING_LOOP__OWNED_SOURCE, null, msgs);
			if (newOwnedSource != null)
				msgs = ((InternalEObject)newOwnedSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.MAPPING_LOOP__OWNED_SOURCE, null, msgs);
			msgs = basicSetOwnedSource(newOwnedSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_LOOP__OWNED_SOURCE, newOwnedSource, newOwnedSource));
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
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedIterators()).basicAdd(otherEnd, msgs);
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
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				return ((InternalEList<?>)getOwnedIterators()).basicRemove(otherEnd, msgs);
			case QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS:
				return ((InternalEList<?>)getOwnedMappingStatements()).basicRemove(otherEnd, msgs);
			case QVTimperativePackage.MAPPING_LOOP__OWNED_SOURCE:
				return basicSetOwnedSource(null, msgs);
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
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				return getOwnedIterators();
			case QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS:
				return getOwnedMappingStatements();
			case QVTimperativePackage.MAPPING_LOOP__OWNED_SOURCE:
				return getOwnedSource();
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
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				getOwnedIterators().clear();
				getOwnedIterators().addAll((Collection<? extends LoopVariable>)newValue);
				return;
			case QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS:
				getOwnedMappingStatements().clear();
				getOwnedMappingStatements().addAll((Collection<? extends MappingStatement>)newValue);
				return;
			case QVTimperativePackage.MAPPING_LOOP__OWNED_SOURCE:
				setOwnedSource((OCLExpression)newValue);
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
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				getOwnedIterators().clear();
				return;
			case QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS:
				getOwnedMappingStatements().clear();
				return;
			case QVTimperativePackage.MAPPING_LOOP__OWNED_SOURCE:
				setOwnedSource((OCLExpression)null);
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
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				return ownedIterators != null && !ownedIterators.isEmpty();
			case QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS:
				return ownedMappingStatements != null && !ownedMappingStatements.isEmpty();
			case QVTimperativePackage.MAPPING_LOOP__OWNED_SOURCE:
				return ownedSource != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTimperativeVisitor<?>)visitor).visitMappingLoop(this);
	}
} //MappingLoopImpl
