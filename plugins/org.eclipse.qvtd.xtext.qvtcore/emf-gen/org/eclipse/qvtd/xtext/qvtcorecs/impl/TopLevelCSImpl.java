/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.qvtd.xtext.qvtcorecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;
import org.eclipse.qvtd.xtext.qvtcorecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtcorecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorecs.util.QVTcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TopLevelCSImpl#getOwnedMappings <em>Owned Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TopLevelCSImpl#getOwnedQueries <em>Owned Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TopLevelCSImpl#getOwnedTransformations <em>Owned Transformations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TopLevelCSImpl extends RootPackageCSImpl implements TopLevelCS {
	/**
	 * The number of structural features of the '<em>Top Level CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TOP_LEVEL_CS_FEATURE_COUNT = RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 3;

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
	@Override
	public EList<MappingCS> getOwnedMappings() {
		if (ownedMappings == null) {
			ownedMappings = new EObjectContainmentEList<MappingCS>(MappingCS.class, this, RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 0);
		}
		return ownedMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<QueryCS> getOwnedQueries() {
		if (ownedQueries == null) {
			ownedQueries = new EObjectContainmentEList<QueryCS>(QueryCS.class, this, RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 1);
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
			ownedTransformations = new EObjectContainmentEList<TransformationCS>(TransformationCS.class, this, RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 2);
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
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getOwnedMappings()).basicRemove(otherEnd, msgs);
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getOwnedQueries()).basicRemove(otherEnd, msgs);
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 2:
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
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 0:
				return getOwnedMappings();
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 1:
				return getOwnedQueries();
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 2:
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
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 0:
				getOwnedMappings().clear();
				getOwnedMappings().addAll((Collection<? extends MappingCS>)newValue);
				return;
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 1:
				getOwnedQueries().clear();
				getOwnedQueries().addAll((Collection<? extends QueryCS>)newValue);
				return;
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 2:
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
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 0:
				getOwnedMappings().clear();
				return;
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 1:
				getOwnedQueries().clear();
				return;
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 2:
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
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 0:
				return ownedMappings != null && !ownedMappings.isEmpty();
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 1:
				return ownedQueries != null && !ownedQueries.isEmpty();
			case RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 2:
				return ownedTransformations != null && !ownedTransformations.isEmpty();
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
