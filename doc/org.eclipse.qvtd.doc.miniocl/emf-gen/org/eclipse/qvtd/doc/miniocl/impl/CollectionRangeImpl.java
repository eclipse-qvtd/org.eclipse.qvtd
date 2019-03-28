/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.doc.miniocl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.qvtd.doc.miniocl.CollectionRange;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.OCLExpression;

import org.eclipse.qvtd.doc.miniocl.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.CollectionRangeImpl#getOwnedFirst <em>Owned First</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.CollectionRangeImpl#getOwnedLast <em>Owned Last</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionRangeImpl extends CollectionLiteralPartImpl implements CollectionRange {
	/**
	 * The number of structural features of the '<em>Collection Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_RANGE_FEATURE_COUNT = CollectionLiteralPartImpl.COLLECTION_LITERAL_PART_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Collection Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_RANGE_OPERATION_COUNT = CollectionLiteralPartImpl.COLLECTION_LITERAL_PART_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getOwnedFirst() <em>Owned First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFirst()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedFirst;

	/**
	 * The cached value of the '{@link #getOwnedLast() <em>Owned Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLast()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedLast;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.COLLECTION_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedFirst() {
		return ownedFirst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedFirst(OCLExpression newOwnedFirst, NotificationChain msgs) {
		OCLExpression oldOwnedFirst = ownedFirst;
		ownedFirst = newOwnedFirst;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 1, oldOwnedFirst, newOwnedFirst);
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
	public void setOwnedFirst(OCLExpression newOwnedFirst) {
		if (newOwnedFirst != ownedFirst) {
			NotificationChain msgs = null;
			if (ownedFirst != null)
				msgs = ((InternalEObject)ownedFirst).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (1), null, msgs);
			if (newOwnedFirst != null)
				msgs = ((InternalEObject)newOwnedFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (1), null, msgs);
			msgs = basicSetOwnedFirst(newOwnedFirst, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 1, newOwnedFirst, newOwnedFirst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedLast() {
		return ownedLast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedLast(OCLExpression newOwnedLast, NotificationChain msgs) {
		OCLExpression oldOwnedLast = ownedLast;
		ownedLast = newOwnedLast;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 2, oldOwnedLast, newOwnedLast);
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
	public void setOwnedLast(OCLExpression newOwnedLast) {
		if (newOwnedLast != ownedLast) {
			NotificationChain msgs = null;
			if (ownedLast != null)
				msgs = ((InternalEObject)ownedLast).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (2), null, msgs);
			if (newOwnedLast != null)
				msgs = ((InternalEObject)newOwnedLast).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (2), null, msgs);
			msgs = basicSetOwnedLast(newOwnedLast, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, newOwnedLast, newOwnedLast));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 1:
				return basicSetOwnedFirst(null, msgs);
			case 2:
				return basicSetOwnedLast(null, msgs);
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
			case 1:
				return getOwnedFirst();
			case 2:
				return getOwnedLast();
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
			case 1:
				setOwnedFirst((OCLExpression)newValue);
				return;
			case 2:
				setOwnedLast((OCLExpression)newValue);
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
			case 1:
				setOwnedFirst((OCLExpression)null);
				return;
			case 2:
				setOwnedLast((OCLExpression)null);
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
			case 1:
				return ownedFirst != null;
			case 2:
				return ownedLast != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCollectionRange(this);
	}

} //CollectionRangeImpl
