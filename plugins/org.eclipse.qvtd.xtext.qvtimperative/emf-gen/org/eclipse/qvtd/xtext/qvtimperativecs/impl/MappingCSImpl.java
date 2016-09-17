/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

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
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.InoutVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.StatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedInPathName <em>Owned In Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedGuardVariables <em>Owned Guard Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedInoutVariables <em>Owned Inout Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedStatements <em>Owned Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingCSImpl extends NamedElementCSImpl implements MappingCS {
	/**
	 * The cached value of the '{@link #getOwnedInPathName() <em>Owned In Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS ownedInPathName;
	/**
	 * The cached value of the '{@link #getOwnedGuardVariables() <em>Owned Guard Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedGuardVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<GuardVariableCS> ownedGuardVariables;
	/**
	 * The cached value of the '{@link #getOwnedInoutVariables() <em>Owned Inout Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInoutVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<InoutVariableCS> ownedInoutVariables;
	/**
	 * The cached value of the '{@link #getOwnedStatements() <em>Owned Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<StatementCS> ownedStatements;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.MAPPING_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS getOwnedInPathName() {
		return ownedInPathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedInPathName(PathNameCS newOwnedInPathName, NotificationChain msgs) {
		PathNameCS oldOwnedInPathName = ownedInPathName;
		ownedInPathName = newOwnedInPathName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, oldOwnedInPathName, newOwnedInPathName);
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
	public void setOwnedInPathName(PathNameCS newOwnedInPathName) {
		if (newOwnedInPathName != ownedInPathName) {
			NotificationChain msgs = null;
			if (ownedInPathName != null)
				msgs = ((InternalEObject)ownedInPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, null, msgs);
			if (newOwnedInPathName != null)
				msgs = ((InternalEObject)newOwnedInPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, null, msgs);
			msgs = basicSetOwnedInPathName(newOwnedInPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, newOwnedInPathName, newOwnedInPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GuardVariableCS> getOwnedGuardVariables() {
		if (ownedGuardVariables == null) {
			ownedGuardVariables = new EObjectContainmentEList<GuardVariableCS>(GuardVariableCS.class, this, QVTimperativeCSPackage.MAPPING_CS__OWNED_GUARD_VARIABLES);
		}
		return ownedGuardVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<StatementCS> getOwnedStatements() {
		if (ownedStatements == null) {
			ownedStatements = new EObjectContainmentEList<StatementCS>(StatementCS.class, this, QVTimperativeCSPackage.MAPPING_CS__OWNED_STATEMENTS);
		}
		return ownedStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InoutVariableCS> getOwnedInoutVariables() {
		if (ownedInoutVariables == null) {
			ownedInoutVariables = new EObjectContainmentEList<InoutVariableCS>(InoutVariableCS.class, this, QVTimperativeCSPackage.MAPPING_CS__OWNED_INOUT_VARIABLES);
		}
		return ownedInoutVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				return basicSetOwnedInPathName(null, msgs);
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_GUARD_VARIABLES:
				return ((InternalEList<?>)getOwnedGuardVariables()).basicRemove(otherEnd, msgs);
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_INOUT_VARIABLES:
				return ((InternalEList<?>)getOwnedInoutVariables()).basicRemove(otherEnd, msgs);
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_STATEMENTS:
				return ((InternalEList<?>)getOwnedStatements()).basicRemove(otherEnd, msgs);
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				return getOwnedInPathName();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_GUARD_VARIABLES:
				return getOwnedGuardVariables();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_INOUT_VARIABLES:
				return getOwnedInoutVariables();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_STATEMENTS:
				return getOwnedStatements();
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				setOwnedInPathName((PathNameCS)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_GUARD_VARIABLES:
				getOwnedGuardVariables().clear();
				getOwnedGuardVariables().addAll((Collection<? extends GuardVariableCS>)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_INOUT_VARIABLES:
				getOwnedInoutVariables().clear();
				getOwnedInoutVariables().addAll((Collection<? extends InoutVariableCS>)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_STATEMENTS:
				getOwnedStatements().clear();
				getOwnedStatements().addAll((Collection<? extends StatementCS>)newValue);
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				setOwnedInPathName((PathNameCS)null);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_GUARD_VARIABLES:
				getOwnedGuardVariables().clear();
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_INOUT_VARIABLES:
				getOwnedInoutVariables().clear();
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_STATEMENTS:
				getOwnedStatements().clear();
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				return ownedInPathName != null;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_GUARD_VARIABLES:
				return ownedGuardVariables != null && !ownedGuardVariables.isEmpty();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_INOUT_VARIABLES:
				return ownedInoutVariables != null && !ownedInoutVariables.isEmpty();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_STATEMENTS:
				return ownedStatements != null && !ownedStatements.isEmpty();
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
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitMappingCS(this);
	}
} //MappingCSImpl
