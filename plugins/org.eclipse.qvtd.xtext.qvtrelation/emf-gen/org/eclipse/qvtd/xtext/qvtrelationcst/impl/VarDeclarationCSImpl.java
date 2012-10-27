/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
package org.eclipse.qvtd.xtext.qvtrelationcst.impl;

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
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationCSImpl#getVarDeclarationIds <em>Var Declaration Ids</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationCSImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VarDeclarationCSImpl extends ModelElementCSImpl implements VarDeclarationCS {
	/**
	 * The cached value of the '{@link #getVarDeclarationIds() <em>Var Declaration Ids</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarDeclarationIds()
	 * @generated
	 * @ordered
	 */
	protected EList<VarDeclarationIdCS> varDeclarationIds;
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS type;

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
		return QVTrelationCSTPackage.Literals.VAR_DECLARATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VarDeclarationIdCS> getVarDeclarationIds() {
		if (varDeclarationIds == null) {
			varDeclarationIds = new EObjectContainmentEList<VarDeclarationIdCS>(VarDeclarationIdCS.class, this, QVTrelationCSTPackage.VAR_DECLARATION_CS__VAR_DECLARATION_IDS);
		}
		return varDeclarationIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedRefCS getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(TypedRefCS newType, NotificationChain msgs) {
		TypedRefCS oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.VAR_DECLARATION_CS__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypedRefCS newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.VAR_DECLARATION_CS__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.VAR_DECLARATION_CS__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.VAR_DECLARATION_CS__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSTPackage.VAR_DECLARATION_CS__VAR_DECLARATION_IDS:
				return ((InternalEList<?>)getVarDeclarationIds()).basicRemove(otherEnd, msgs);
			case QVTrelationCSTPackage.VAR_DECLARATION_CS__TYPE:
				return basicSetType(null, msgs);
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
			case QVTrelationCSTPackage.VAR_DECLARATION_CS__VAR_DECLARATION_IDS:
				return getVarDeclarationIds();
			case QVTrelationCSTPackage.VAR_DECLARATION_CS__TYPE:
				return getType();
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
			case QVTrelationCSTPackage.VAR_DECLARATION_CS__VAR_DECLARATION_IDS:
				getVarDeclarationIds().clear();
				getVarDeclarationIds().addAll((Collection<? extends VarDeclarationIdCS>)newValue);
				return;
			case QVTrelationCSTPackage.VAR_DECLARATION_CS__TYPE:
				setType((TypedRefCS)newValue);
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
			case QVTrelationCSTPackage.VAR_DECLARATION_CS__VAR_DECLARATION_IDS:
				getVarDeclarationIds().clear();
				return;
			case QVTrelationCSTPackage.VAR_DECLARATION_CS__TYPE:
				setType((TypedRefCS)null);
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
			case QVTrelationCSTPackage.VAR_DECLARATION_CS__VAR_DECLARATION_IDS:
				return varDeclarationIds != null && !varDeclarationIds.isEmpty();
			case QVTrelationCSTPackage.VAR_DECLARATION_CS__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return ((QVTrelationCSVisitor<R>)visitor).visitVarDeclarationCS(this);
	}
} //VarDeclarationCSImpl
