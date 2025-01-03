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
import org.eclipse.qvtd.doc.minioclcs.ExpCS;
import org.eclipse.qvtd.doc.minioclcs.LetVarCS;
import org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage;
import org.eclipse.qvtd.doc.minioclcs.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Let Var CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.LetVarCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.LetVarCSImpl#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.impl.LetVarCSImpl#getInitExp <em>Init Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LetVarCSImpl extends CSTraceImpl implements LetVarCS
{
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
	 * The cached value of the '{@link #getTypeRef() <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTypeRef()
	 * @generated
	 * @ordered
	 */
  protected PathNameCS typeRef;

  /**
	 * The cached value of the '{@link #getInitExp() <em>Init Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getInitExp()
	 * @generated
	 * @ordered
	 */
  protected ExpCS initExp;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected LetVarCSImpl()
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
		return MinioclcsPackage.Literals.LET_VAR_CS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String getName()
  {
		return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setName(String newName)
  {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.LET_VAR_CS__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public PathNameCS getTypeRef()
  {
		return typeRef;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTypeRef(PathNameCS newTypeRef, NotificationChain msgs)
  {
		PathNameCS oldTypeRef = typeRef;
		typeRef = newTypeRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinioclcsPackage.LET_VAR_CS__TYPE_REF, oldTypeRef, newTypeRef);
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
  public void setTypeRef(PathNameCS newTypeRef)
  {
		if (newTypeRef != typeRef) {
			NotificationChain msgs = null;
			if (typeRef != null)
				msgs = ((InternalEObject)typeRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.LET_VAR_CS__TYPE_REF, null, msgs);
			if (newTypeRef != null)
				msgs = ((InternalEObject)newTypeRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.LET_VAR_CS__TYPE_REF, null, msgs);
			msgs = basicSetTypeRef(newTypeRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.LET_VAR_CS__TYPE_REF, newTypeRef, newTypeRef));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public ExpCS getInitExp()
  {
		return initExp;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetInitExp(ExpCS newInitExp, NotificationChain msgs)
  {
		ExpCS oldInitExp = initExp;
		initExp = newInitExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinioclcsPackage.LET_VAR_CS__INIT_EXP, oldInitExp, newInitExp);
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
  public void setInitExp(ExpCS newInitExp)
  {
		if (newInitExp != initExp) {
			NotificationChain msgs = null;
			if (initExp != null)
				msgs = ((InternalEObject)initExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.LET_VAR_CS__INIT_EXP, null, msgs);
			if (newInitExp != null)
				msgs = ((InternalEObject)newInitExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinioclcsPackage.LET_VAR_CS__INIT_EXP, null, msgs);
			msgs = basicSetInitExp(newInitExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinioclcsPackage.LET_VAR_CS__INIT_EXP, newInitExp, newInitExp));
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
			case MinioclcsPackage.LET_VAR_CS__TYPE_REF:
				return basicSetTypeRef(null, msgs);
			case MinioclcsPackage.LET_VAR_CS__INIT_EXP:
				return basicSetInitExp(null, msgs);
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
			case MinioclcsPackage.LET_VAR_CS__NAME:
				return getName();
			case MinioclcsPackage.LET_VAR_CS__TYPE_REF:
				return getTypeRef();
			case MinioclcsPackage.LET_VAR_CS__INIT_EXP:
				return getInitExp();
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
			case MinioclcsPackage.LET_VAR_CS__NAME:
				setName((String)newValue);
				return;
			case MinioclcsPackage.LET_VAR_CS__TYPE_REF:
				setTypeRef((PathNameCS)newValue);
				return;
			case MinioclcsPackage.LET_VAR_CS__INIT_EXP:
				setInitExp((ExpCS)newValue);
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
			case MinioclcsPackage.LET_VAR_CS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MinioclcsPackage.LET_VAR_CS__TYPE_REF:
				setTypeRef((PathNameCS)null);
				return;
			case MinioclcsPackage.LET_VAR_CS__INIT_EXP:
				setInitExp((ExpCS)null);
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
			case MinioclcsPackage.LET_VAR_CS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MinioclcsPackage.LET_VAR_CS__TYPE_REF:
				return typeRef != null;
			case MinioclcsPackage.LET_VAR_CS__INIT_EXP:
				return initExp != null;
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString()
  {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LetVarCSImpl
