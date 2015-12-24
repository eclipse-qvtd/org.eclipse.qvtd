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
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

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
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.UnitCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TopLevelCSImpl#getOwnedImportClauses <em>Owned Import Clauses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TopLevelCSImpl#getOwnedTransformations <em>Owned Transformations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TopLevelCSImpl extends RootPackageCSImpl implements TopLevelCS {
	/**
	 * The cached value of the '{@link #getOwnedImportClauses() <em>Owned Import Clauses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImportClauses()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitCS> ownedImportClauses;

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
		return QVTrelationCSPackage.Literals.TOP_LEVEL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<UnitCS> getOwnedImportClauses() {
		if (ownedImportClauses == null) {
			ownedImportClauses = new EObjectContainmentEList<UnitCS>(UnitCS.class, this, QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_IMPORT_CLAUSES);
		}
		return ownedImportClauses;
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
			ownedTransformations = new EObjectContainmentEList<TransformationCS>(TransformationCS.class, this, QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS);
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
			case QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_IMPORT_CLAUSES:
				return ((InternalEList<?>)getOwnedImportClauses()).basicRemove(otherEnd, msgs);
			case QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
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
			case QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_IMPORT_CLAUSES:
				return getOwnedImportClauses();
			case QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
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
			case QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_IMPORT_CLAUSES:
				getOwnedImportClauses().clear();
				getOwnedImportClauses().addAll((Collection<? extends UnitCS>)newValue);
				return;
			case QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
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
			case QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_IMPORT_CLAUSES:
				getOwnedImportClauses().clear();
				return;
			case QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
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
			case QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_IMPORT_CLAUSES:
				return ownedImportClauses != null && !ownedImportClauses.isEmpty();
			case QVTrelationCSPackage.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS:
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
		return (R) ((QVTrelationCSVisitor<?>)visitor).visitTopLevelCS(this);
	}
} //TopLevelCSImpl
