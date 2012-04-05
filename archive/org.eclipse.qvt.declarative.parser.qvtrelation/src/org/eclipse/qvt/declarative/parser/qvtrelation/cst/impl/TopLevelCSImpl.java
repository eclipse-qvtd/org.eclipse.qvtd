/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.impl.CSTNodeImpl;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.UnitCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TopLevelCSImpl#getImportClause <em>Import Clause</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TopLevelCSImpl#getTransformation <em>Transformation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopLevelCSImpl extends CSTNodeImpl implements TopLevelCS {
	/**
	 * The cached value of the '{@link #getImportClause() <em>Import Clause</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportClause()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitCS> importClause;

	/**
	 * The cached value of the '{@link #getTransformation() <em>Transformation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformation()
	 * @generated
	 * @ordered
	 */
	protected EList<TransformationCS> transformation;

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
		return QVTrCSTPackage.Literals.TOP_LEVEL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnitCS> getImportClause() {
		if (importClause == null) {
			importClause = new EObjectContainmentEList<UnitCS>(UnitCS.class, this, QVTrCSTPackage.TOP_LEVEL_CS__IMPORT_CLAUSE);
		}
		return importClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransformationCS> getTransformation() {
		if (transformation == null) {
			transformation = new EObjectContainmentEList<TransformationCS>(TransformationCS.class, this, QVTrCSTPackage.TOP_LEVEL_CS__TRANSFORMATION);
		}
		return transformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrCSTPackage.TOP_LEVEL_CS__IMPORT_CLAUSE:
				return ((InternalEList<?>)getImportClause()).basicRemove(otherEnd, msgs);
			case QVTrCSTPackage.TOP_LEVEL_CS__TRANSFORMATION:
				return ((InternalEList<?>)getTransformation()).basicRemove(otherEnd, msgs);
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
			case QVTrCSTPackage.TOP_LEVEL_CS__IMPORT_CLAUSE:
				return getImportClause();
			case QVTrCSTPackage.TOP_LEVEL_CS__TRANSFORMATION:
				return getTransformation();
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
			case QVTrCSTPackage.TOP_LEVEL_CS__IMPORT_CLAUSE:
				getImportClause().clear();
				getImportClause().addAll((Collection<? extends UnitCS>)newValue);
				return;
			case QVTrCSTPackage.TOP_LEVEL_CS__TRANSFORMATION:
				getTransformation().clear();
				getTransformation().addAll((Collection<? extends TransformationCS>)newValue);
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
			case QVTrCSTPackage.TOP_LEVEL_CS__IMPORT_CLAUSE:
				getImportClause().clear();
				return;
			case QVTrCSTPackage.TOP_LEVEL_CS__TRANSFORMATION:
				getTransformation().clear();
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
			case QVTrCSTPackage.TOP_LEVEL_CS__IMPORT_CLAUSE:
				return importClause != null && !importClause.isEmpty();
			case QVTrCSTPackage.TOP_LEVEL_CS__TRANSFORMATION:
				return transformation != null && !transformation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TopLevelCSImpl
