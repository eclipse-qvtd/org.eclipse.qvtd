/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingSequenceCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Loop CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingLoopCSImpl#getOwnedIterator <em>Owned Iterator</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingLoopCSImpl#getOwnedInExpression <em>Owned In Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingLoopCSImpl#getOwnedMappingSequence <em>Owned Mapping Sequence</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingLoopCSImpl extends MappingStatementCSImpl implements MappingLoopCS {
	/**
	 * The cached value of the '{@link #getOwnedIterator() <em>Owned Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedIterator()
	 * @generated
	 * @ordered
	 */
	protected VariableCS ownedIterator;

	/**
	 * The cached value of the '{@link #getOwnedInExpression() <em>Owned In Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedInExpression;

	/**
	 * The cached value of the '{@link #getOwnedMappingSequence() <em>Owned Mapping Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappingSequence()
	 * @generated
	 * @ordered
	 */
	protected MappingSequenceCS ownedMappingSequence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingLoopCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableCS getOwnedIterator() {
		return ownedIterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedIterator(VariableCS newOwnedIterator, NotificationChain msgs) {
		VariableCS oldOwnedIterator = ownedIterator;
		ownedIterator = newOwnedIterator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_ITERATOR, oldOwnedIterator, newOwnedIterator);
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
	public void setOwnedIterator(VariableCS newOwnedIterator) {
		if (newOwnedIterator != ownedIterator) {
			NotificationChain msgs = null;
			if (ownedIterator != null)
				msgs = ((InternalEObject)ownedIterator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_ITERATOR, null, msgs);
			if (newOwnedIterator != null)
				msgs = ((InternalEObject)newOwnedIterator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_ITERATOR, null, msgs);
			msgs = basicSetOwnedIterator(newOwnedIterator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_ITERATOR, newOwnedIterator, newOwnedIterator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedInExpression() {
		return ownedInExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedInExpression(ExpCS newOwnedInExpression, NotificationChain msgs) {
		ExpCS oldOwnedInExpression = ownedInExpression;
		ownedInExpression = newOwnedInExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION, oldOwnedInExpression, newOwnedInExpression);
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
	public void setOwnedInExpression(ExpCS newOwnedInExpression) {
		if (newOwnedInExpression != ownedInExpression) {
			NotificationChain msgs = null;
			if (ownedInExpression != null)
				msgs = ((InternalEObject)ownedInExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION, null, msgs);
			if (newOwnedInExpression != null)
				msgs = ((InternalEObject)newOwnedInExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION, null, msgs);
			msgs = basicSetOwnedInExpression(newOwnedInExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION, newOwnedInExpression, newOwnedInExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingSequenceCS getOwnedMappingSequence() {
		return ownedMappingSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedMappingSequence(MappingSequenceCS newOwnedMappingSequence, NotificationChain msgs) {
		MappingSequenceCS oldOwnedMappingSequence = ownedMappingSequence;
		ownedMappingSequence = newOwnedMappingSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE, oldOwnedMappingSequence, newOwnedMappingSequence);
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
	public void setOwnedMappingSequence(MappingSequenceCS newOwnedMappingSequence) {
		if (newOwnedMappingSequence != ownedMappingSequence) {
			NotificationChain msgs = null;
			if (ownedMappingSequence != null)
				msgs = ((InternalEObject)ownedMappingSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE, null, msgs);
			if (newOwnedMappingSequence != null)
				msgs = ((InternalEObject)newOwnedMappingSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE, null, msgs);
			msgs = basicSetOwnedMappingSequence(newOwnedMappingSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE, newOwnedMappingSequence, newOwnedMappingSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_ITERATOR:
				return basicSetOwnedIterator(null, msgs);
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION:
				return basicSetOwnedInExpression(null, msgs);
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE:
				return basicSetOwnedMappingSequence(null, msgs);
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
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_ITERATOR:
				return getOwnedIterator();
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION:
				return getOwnedInExpression();
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE:
				return getOwnedMappingSequence();
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
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_ITERATOR:
				setOwnedIterator((VariableCS)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION:
				setOwnedInExpression((ExpCS)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE:
				setOwnedMappingSequence((MappingSequenceCS)newValue);
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
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_ITERATOR:
				setOwnedIterator((VariableCS)null);
				return;
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION:
				setOwnedInExpression((ExpCS)null);
				return;
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE:
				setOwnedMappingSequence((MappingSequenceCS)null);
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
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_ITERATOR:
				return ownedIterator != null;
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION:
				return ownedInExpression != null;
			case QVTimperativeCSPackage.MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE:
				return ownedMappingSequence != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitMappingLoopCS(this);
	}

} //MappingLoopCSImpl
