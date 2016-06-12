/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtcorebasecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.xtext.basecs.impl.RootPackageCSImpl;

import org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractTopLevelCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.AbstractTopLevelCSImpl#getOwnedQueries <em>Owned Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.AbstractTopLevelCSImpl#getOwnedTransformations <em>Owned Transformations</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractTopLevelCSImpl extends RootPackageCSImpl implements AbstractTopLevelCS {
	/**
	 * The cached value of the '{@link #getOwnedQueries() <em>Owned Queries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<QueryCS> ownedQueries;

	/**
	 * The cached value of the '{@link #getOwnedTransformations() <em>Owned Transformations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTransformations()
	 * @generated
	 * @ordered
	 */
	protected EList<TransformationCS> ownedTransformations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTopLevelCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreBaseCSPackage.Literals.ABSTRACT_TOP_LEVEL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<QueryCS> getOwnedQueries() {
		if (ownedQueries == null) {
			ownedQueries = new EObjectContainmentEList<QueryCS>(QueryCS.class, this, QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_QUERIES);
		}
		return ownedQueries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TransformationCS> getOwnedTransformations() {
		if (ownedTransformations == null) {
			ownedTransformations = new EObjectContainmentEList<TransformationCS>(TransformationCS.class, this, QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_TRANSFORMATIONS);
		}
		return ownedTransformations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_QUERIES:
				return ((InternalEList<?>)getOwnedQueries()).basicRemove(otherEnd, msgs);
			case QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
				return ((InternalEList<?>)getOwnedTransformations()).basicRemove(otherEnd, msgs);
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
			case QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_QUERIES:
				return getOwnedQueries();
			case QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
				return getOwnedTransformations();
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
			case QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_QUERIES:
				getOwnedQueries().clear();
				getOwnedQueries().addAll((Collection<? extends QueryCS>)newValue);
				return;
			case QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
				getOwnedTransformations().clear();
				getOwnedTransformations().addAll((Collection<? extends TransformationCS>)newValue);
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
			case QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_QUERIES:
				getOwnedQueries().clear();
				return;
			case QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
				getOwnedTransformations().clear();
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
			case QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_QUERIES:
				return ownedQueries != null && !ownedQueries.isEmpty();
			case QVTcoreBaseCSPackage.ABSTRACT_TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
				return ownedTransformations != null && !ownedTransformations.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //AbstractTopLevelCSImpl
