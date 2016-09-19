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
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingParameterCS;
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
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedParameters <em>Owned Parameters</em>}</li>
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
	 * The cached value of the '{@link #getOwnedParameters() <em>Owned Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingParameterCS> ownedParameters;
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
	public EList<MappingParameterCS> getOwnedParameters() {
		if (ownedParameters == null) {
			ownedParameters = new EObjectContainmentEList<MappingParameterCS>(MappingParameterCS.class, this, QVTimperativeCSPackage.MAPPING_CS__OWNED_PARAMETERS);
		}
		return ownedParameters;
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				return basicSetOwnedInPathName(null, msgs);
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_PARAMETERS:
				return ((InternalEList<?>)getOwnedParameters()).basicRemove(otherEnd, msgs);
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_PARAMETERS:
				return getOwnedParameters();
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_PARAMETERS:
				getOwnedParameters().clear();
				getOwnedParameters().addAll((Collection<? extends MappingParameterCS>)newValue);
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_PARAMETERS:
				getOwnedParameters().clear();
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_PARAMETERS:
				return ownedParameters != null && !ownedParameters.isEmpty();
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
