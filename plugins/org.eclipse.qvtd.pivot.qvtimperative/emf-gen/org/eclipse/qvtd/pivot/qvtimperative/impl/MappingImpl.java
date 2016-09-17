/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl;
import org.eclipse.qvtd.pivot.qvtimperative.GuardVariable;
import org.eclipse.qvtd.pivot.qvtimperative.InConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#getOwnedGuardVariables <em>Owned Guard Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#getInoutVariables <em>Inout Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#getOwnedStatements <em>Owned Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingImpl extends RuleImpl implements Mapping {
	/**
	 * The cached value of the '{@link #getOwnedGuardVariables() <em>Owned Guard Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedGuardVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<GuardVariable> ownedGuardVariables;

	/**
	 * The cached value of the '{@link #getInoutVariables() <em>Inout Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInoutVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<InConnectionVariable> inoutVariables;

	/**
	 * The cached value of the '{@link #getOwnedStatements() <em>Owned Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> ownedStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GuardVariable> getOwnedGuardVariables() {
		if (ownedGuardVariables == null) {
			ownedGuardVariables = new EObjectContainmentEList<GuardVariable>(GuardVariable.class, this, QVTimperativePackage.MAPPING__OWNED_GUARD_VARIABLES);
		}
		return ownedGuardVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InConnectionVariable> getInoutVariables() {
		if (inoutVariables == null) {
			inoutVariables = new EObjectContainmentEList<InConnectionVariable>(InConnectionVariable.class, this, QVTimperativePackage.MAPPING__INOUT_VARIABLES);
		}
		return inoutVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Statement> getOwnedStatements() {
		if (ownedStatements == null) {
			ownedStatements = new EObjectContainmentEList<Statement>(Statement.class, this, QVTimperativePackage.MAPPING__OWNED_STATEMENTS);
		}
		return ownedStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.MAPPING__OWNED_GUARD_VARIABLES:
				return ((InternalEList<?>)getOwnedGuardVariables()).basicRemove(otherEnd, msgs);
			case QVTimperativePackage.MAPPING__INOUT_VARIABLES:
				return ((InternalEList<?>)getInoutVariables()).basicRemove(otherEnd, msgs);
			case QVTimperativePackage.MAPPING__OWNED_STATEMENTS:
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
			case QVTimperativePackage.MAPPING__OWNED_GUARD_VARIABLES:
				return getOwnedGuardVariables();
			case QVTimperativePackage.MAPPING__INOUT_VARIABLES:
				return getInoutVariables();
			case QVTimperativePackage.MAPPING__OWNED_STATEMENTS:
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
			case QVTimperativePackage.MAPPING__OWNED_GUARD_VARIABLES:
				getOwnedGuardVariables().clear();
				getOwnedGuardVariables().addAll((Collection<? extends GuardVariable>)newValue);
				return;
			case QVTimperativePackage.MAPPING__INOUT_VARIABLES:
				getInoutVariables().clear();
				getInoutVariables().addAll((Collection<? extends InConnectionVariable>)newValue);
				return;
			case QVTimperativePackage.MAPPING__OWNED_STATEMENTS:
				getOwnedStatements().clear();
				getOwnedStatements().addAll((Collection<? extends Statement>)newValue);
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
			case QVTimperativePackage.MAPPING__OWNED_GUARD_VARIABLES:
				getOwnedGuardVariables().clear();
				return;
			case QVTimperativePackage.MAPPING__INOUT_VARIABLES:
				getInoutVariables().clear();
				return;
			case QVTimperativePackage.MAPPING__OWNED_STATEMENTS:
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
			case QVTimperativePackage.MAPPING__OWNED_GUARD_VARIABLES:
				return ownedGuardVariables != null && !ownedGuardVariables.isEmpty();
			case QVTimperativePackage.MAPPING__INOUT_VARIABLES:
				return inoutVariables != null && !inoutVariables.isEmpty();
			case QVTimperativePackage.MAPPING__OWNED_STATEMENTS:
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
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTimperativeVisitor<?>)visitor).visitMapping(this);
	}
} //MappingImpl
