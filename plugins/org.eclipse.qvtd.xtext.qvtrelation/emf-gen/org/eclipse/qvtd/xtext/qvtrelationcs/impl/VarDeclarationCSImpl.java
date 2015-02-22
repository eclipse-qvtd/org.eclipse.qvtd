/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.VarDeclarationCSImpl#getOwnedVarDeclarationIds <em>Owned Var Declaration Ids</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.VarDeclarationCSImpl#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VarDeclarationCSImpl extends ModelElementCSImpl implements VarDeclarationCS {
	/**
	 * The cached value of the '{@link #getOwnedVarDeclarationIds() <em>Owned Var Declaration Ids</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVarDeclarationIds()
	 * @generated
	 * @ordered
	 */
	protected EList<VarDeclarationIdCS> ownedVarDeclarationIds;
	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS ownedType;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VarDeclarationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationCSPackage.Literals.VAR_DECLARATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VarDeclarationIdCS> getOwnedVarDeclarationIds() {
		if (ownedVarDeclarationIds == null) {
			ownedVarDeclarationIds = new EObjectContainmentEList<VarDeclarationIdCS>(VarDeclarationIdCS.class, this, QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS);
		}
		return ownedVarDeclarationIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedRefCS getOwnedType() {
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedType(TypedRefCS newOwnedType, NotificationChain msgs) {
		TypedRefCS oldOwnedType = ownedType;
		ownedType = newOwnedType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_TYPE, oldOwnedType, newOwnedType);
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
	public void setOwnedType(TypedRefCS newOwnedType) {
		if (newOwnedType != ownedType) {
			NotificationChain msgs = null;
			if (ownedType != null)
				msgs = ((InternalEObject)ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_TYPE, null, msgs);
			if (newOwnedType != null)
				msgs = ((InternalEObject)newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_TYPE, null, msgs);
			msgs = basicSetOwnedType(newOwnedType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_TYPE, newOwnedType, newOwnedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS:
				return ((InternalEList<?>)getOwnedVarDeclarationIds()).basicRemove(otherEnd, msgs);
			case QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_TYPE:
				return basicSetOwnedType(null, msgs);
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
			case QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS:
				return getOwnedVarDeclarationIds();
			case QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_TYPE:
				return getOwnedType();
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
			case QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS:
				getOwnedVarDeclarationIds().clear();
				getOwnedVarDeclarationIds().addAll((Collection<? extends VarDeclarationIdCS>)newValue);
				return;
			case QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_TYPE:
				setOwnedType((TypedRefCS)newValue);
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
			case QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS:
				getOwnedVarDeclarationIds().clear();
				return;
			case QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_TYPE:
				setOwnedType((TypedRefCS)null);
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
			case QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS:
				return ownedVarDeclarationIds != null && !ownedVarDeclarationIds.isEmpty();
			case QVTrelationCSPackage.VAR_DECLARATION_CS__OWNED_TYPE:
				return ownedType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTrelationCSVisitor<?>)visitor).visitVarDeclarationCS(this);
	}
} //VarDeclarationCSImpl
