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
package org.eclipse.qvtd.xtext.qvtcorecst.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage;
import org.eclipse.qvtd.xtext.qvtcorecst.util.QVTcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Direction CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.DirectionCSImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.DirectionCSImpl#getUses <em>Uses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DirectionCSImpl extends NamedElementCSImpl implements DirectionCS {
	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Package> imports;

	/**
	 * The cached value of the '{@link #getUses() <em>Uses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUses()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreDomain> uses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectionCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreCSTPackage.Literals.DIRECTION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.ocl.examples.pivot.Package> getImports() {
		if (imports == null) {
			imports = new EObjectResolvingEList<org.eclipse.ocl.examples.pivot.Package>(org.eclipse.ocl.examples.pivot.Package.class, this, QVTcoreCSTPackage.DIRECTION_CS__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreDomain> getUses() {
		if (uses == null) {
			uses = new EObjectResolvingEList<CoreDomain>(CoreDomain.class, this, QVTcoreCSTPackage.DIRECTION_CS__USES);
		}
		return uses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTcoreCSTPackage.DIRECTION_CS__IMPORTS:
				return getImports();
			case QVTcoreCSTPackage.DIRECTION_CS__USES:
				return getUses();
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
			case QVTcoreCSTPackage.DIRECTION_CS__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case QVTcoreCSTPackage.DIRECTION_CS__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends CoreDomain>)newValue);
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
			case QVTcoreCSTPackage.DIRECTION_CS__IMPORTS:
				getImports().clear();
				return;
			case QVTcoreCSTPackage.DIRECTION_CS__USES:
				getUses().clear();
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
			case QVTcoreCSTPackage.DIRECTION_CS__IMPORTS:
				return imports != null && !imports.isEmpty();
			case QVTcoreCSTPackage.DIRECTION_CS__USES:
				return uses != null && !uses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return ((QVTcoreCSVisitor<R>)visitor).visitDirectionCS(this);
	}
} //DirectionCSImpl
