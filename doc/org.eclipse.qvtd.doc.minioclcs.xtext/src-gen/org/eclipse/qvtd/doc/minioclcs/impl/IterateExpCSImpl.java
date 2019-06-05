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

import org.eclipse.qvtd.doc.minioclcs.AccVarCS;
import org.eclipse.qvtd.doc.minioclcs.IterateExpCS;
import org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterate Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.IterateExpCSImpl#getAccVar <em>Acc Var</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IterateExpCSImpl extends LoopExpCSImpl implements IterateExpCS
{
  /**
	 * The cached value of the '{@link #getAccVar() <em>Acc Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAccVar()
	 * @generated
	 * @ordered
	 */
  protected AccVarCS accVar;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected IterateExpCSImpl()
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
		return MinioclcsPackage.Literals.ITERATE_EXP_CS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public AccVarCS getAccVar()
  {
		return accVar;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetAccVar(AccVarCS newAccVar, NotificationChain msgs)
  {
		AccVarCS oldAccVar = accVar;
		accVar = newAccVar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinioclcsPackage.ITERATE_EXP_CS__ACC_VAR, oldAccVar, newAccVar);
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
  public void setAccVar(AccVarCS newAccVar)
  {
		if (newAccVar != accVar) {
			NotificationChain msgs = null;
			if (accVar != null)
				msgs = ((InternalEObject)accVar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.ITERATE_EXP_CS__ACC_VAR, null, msgs);
			if (newAccVar != null)
				msgs = ((InternalEObject)newAccVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.ITERATE_EXP_CS__ACC_VAR, null, msgs);
			msgs = basicSetAccVar(newAccVar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.ITERATE_EXP_CS__ACC_VAR, newAccVar, newAccVar));
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
			case MinioclcsPackage.ITERATE_EXP_CS__ACC_VAR:
				return basicSetAccVar(null, msgs);
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
			case MinioclcsPackage.ITERATE_EXP_CS__ACC_VAR:
				return getAccVar();
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
			case MinioclcsPackage.ITERATE_EXP_CS__ACC_VAR:
				setAccVar((AccVarCS)newValue);
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
			case MinioclcsPackage.ITERATE_EXP_CS__ACC_VAR:
				setAccVar((AccVarCS)null);
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
			case MinioclcsPackage.ITERATE_EXP_CS__ACC_VAR:
				return accVar != null;
		}
		return super.eIsSet(featureID);
	}

} //IterateExpCSImpl
