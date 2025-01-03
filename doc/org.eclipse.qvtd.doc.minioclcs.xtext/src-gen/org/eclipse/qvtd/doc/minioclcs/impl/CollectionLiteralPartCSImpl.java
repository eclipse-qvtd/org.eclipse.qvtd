/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 * generated by Xtext 2.16.0
 */
package org.eclipse.qvtd.doc.minioclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.qvtd.doc.minioclcs.CollectionLiteralPartCS;
import org.eclipse.qvtd.doc.minioclcs.ExpCS;
import org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.CollectionLiteralPartCSImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.CollectionLiteralPartCSImpl#getLast <em>Last</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionLiteralPartCSImpl extends CSTraceImpl implements CollectionLiteralPartCS
{
  /**
	 * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFirst()
	 * @generated
	 * @ordered
	 */
  protected ExpCS first;

  /**
	 * The cached value of the '{@link #getLast() <em>Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLast()
	 * @generated
	 * @ordered
	 */
  protected ExpCS last;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CollectionLiteralPartCSImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return MinioclcsPackage.Literals.COLLECTION_LITERAL_PART_CS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public ExpCS getFirst()
  {
		return first;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetFirst(ExpCS newFirst, NotificationChain msgs)
  {
		ExpCS oldFirst = first;
		first = newFirst;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinioclcsPackage.COLLECTION_LITERAL_PART_CS__FIRST, oldFirst, newFirst);
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
  public void setFirst(ExpCS newFirst)
  {
		if (newFirst != first) {
			NotificationChain msgs = null;
			if (first != null)
				msgs = ((InternalEObject)first).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.COLLECTION_LITERAL_PART_CS__FIRST, null, msgs);
			if (newFirst != null)
				msgs = ((InternalEObject)newFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.COLLECTION_LITERAL_PART_CS__FIRST, null, msgs);
			msgs = basicSetFirst(newFirst, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.COLLECTION_LITERAL_PART_CS__FIRST, newFirst, newFirst));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public ExpCS getLast()
  {
		return last;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLast(ExpCS newLast, NotificationChain msgs)
  {
		ExpCS oldLast = last;
		last = newLast;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinioclcsPackage.COLLECTION_LITERAL_PART_CS__LAST, oldLast, newLast);
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
  public void setLast(ExpCS newLast)
  {
		if (newLast != last) {
			NotificationChain msgs = null;
			if (last != null)
				msgs = ((InternalEObject)last).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.COLLECTION_LITERAL_PART_CS__LAST, null, msgs);
			if (newLast != null)
				msgs = ((InternalEObject)newLast).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.COLLECTION_LITERAL_PART_CS__LAST, null, msgs);
			msgs = basicSetLast(newLast, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.COLLECTION_LITERAL_PART_CS__LAST, newLast, newLast));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case MinioclcsPackage.COLLECTION_LITERAL_PART_CS__FIRST:
				return basicSetFirst(null, msgs);
			case MinioclcsPackage.COLLECTION_LITERAL_PART_CS__LAST:
				return basicSetLast(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case MinioclcsPackage.COLLECTION_LITERAL_PART_CS__FIRST:
				return getFirst();
			case MinioclcsPackage.COLLECTION_LITERAL_PART_CS__LAST:
				return getLast();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case MinioclcsPackage.COLLECTION_LITERAL_PART_CS__FIRST:
				setFirst((ExpCS)newValue);
				return;
			case MinioclcsPackage.COLLECTION_LITERAL_PART_CS__LAST:
				setLast((ExpCS)newValue);
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case MinioclcsPackage.COLLECTION_LITERAL_PART_CS__FIRST:
				setFirst((ExpCS)null);
				return;
			case MinioclcsPackage.COLLECTION_LITERAL_PART_CS__LAST:
				setLast((ExpCS)null);
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case MinioclcsPackage.COLLECTION_LITERAL_PART_CS__FIRST:
				return first != null;
			case MinioclcsPackage.COLLECTION_LITERAL_PART_CS__LAST:
				return last != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionLiteralPartCSImpl
