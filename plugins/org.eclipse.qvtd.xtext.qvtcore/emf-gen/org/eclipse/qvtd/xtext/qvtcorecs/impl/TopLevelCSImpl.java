/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.impl.RootPackageCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;
import org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtcorecs.util.QVTcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TopLevelCSImpl#getOwnedTransformations <em>Owned Transformations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TopLevelCSImpl#getOwnedQueries <em>Owned Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TopLevelCSImpl#getOwnedMappings <em>Owned Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TopLevelCSImpl extends RootPackageCSImpl implements TopLevelCS {
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
	 * The cached value of the '{@link #getOwnedQueries() <em>Owned Queries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<QueryCS> ownedQueries;

	/**
	 * The cached value of the '{@link #getOwnedMappings() <em>Owned Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingCS> ownedMappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopLevelCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreCSPackage.Literals.TOP_LEVEL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<TransformationCS> getOwnedTransformations() {
		if (ownedTransformations == null) {
			ownedTransformations = new EObjectContainmentEList<TransformationCS>(TransformationCS.class, this, QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS);
		}
		return ownedTransformations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<QueryCS> getOwnedQueries() {
		if (ownedQueries == null) {
			ownedQueries = new EObjectContainmentEList<QueryCS>(QueryCS.class, this, QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_QUERIES);
		}
		return ownedQueries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingCS> getOwnedMappings() {
		if (ownedMappings == null) {
			ownedMappings = new EObjectContainmentEList<MappingCS>(MappingCS.class, this, QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_MAPPINGS);
		}
		return ownedMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
				return ((InternalEList<?>)getOwnedTransformations()).basicRemove(otherEnd, msgs);
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_QUERIES:
				return ((InternalEList<?>)getOwnedQueries()).basicRemove(otherEnd, msgs);
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_MAPPINGS:
				return ((InternalEList<?>)getOwnedMappings()).basicRemove(otherEnd, msgs);
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
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
				return getOwnedTransformations();
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_QUERIES:
				return getOwnedQueries();
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_MAPPINGS:
				return getOwnedMappings();
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
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
				getOwnedTransformations().clear();
				getOwnedTransformations().addAll((Collection<? extends TransformationCS>)newValue);
				return;
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_QUERIES:
				getOwnedQueries().clear();
				getOwnedQueries().addAll((Collection<? extends QueryCS>)newValue);
				return;
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_MAPPINGS:
				getOwnedMappings().clear();
				getOwnedMappings().addAll((Collection<? extends MappingCS>)newValue);
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
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
				getOwnedTransformations().clear();
				return;
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_QUERIES:
				getOwnedQueries().clear();
				return;
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_MAPPINGS:
				getOwnedMappings().clear();
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
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
				return ownedTransformations != null && !ownedTransformations.isEmpty();
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_QUERIES:
				return ownedQueries != null && !ownedQueries.isEmpty();
			case QVTcoreCSPackage.TOP_LEVEL_CS__OWNED_MAPPINGS:
				return ownedMappings != null && !ownedMappings.isEmpty();
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
		return (R) ((QVTcoreCSVisitor<?>)visitor).visitTopLevelCS(this);
	}
} //TopLevelCSImpl
