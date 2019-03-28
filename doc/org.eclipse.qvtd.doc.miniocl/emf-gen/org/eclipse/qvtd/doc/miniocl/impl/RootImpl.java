/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.doc.miniocl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.miniocl.Constraint;
import org.eclipse.qvtd.doc.miniocl.Import;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.Root;
import org.eclipse.qvtd.doc.miniocl.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.RootImpl#getOwnedConstraints <em>Owned Constraints</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.RootImpl#getOwnedImports <em>Owned Imports</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.RootImpl#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootImpl extends ElementImpl implements Root {
	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ROOT_FEATURE_COUNT = ElementImpl.ELEMENT_FEATURE_COUNT + 3;
	/**
	 * The number of operations of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ROOT_OPERATION_COUNT = ElementImpl.ELEMENT_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getOwnedConstraints() <em>Owned Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> ownedConstraints;
	/**
	 * The cached value of the '{@link #getOwnedImports() <em>Owned Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> ownedImports;
	/**
	 * The cached value of the '{@link #getOwnedPackages() <em>Owned Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.qvtd.doc.miniocl.Package> ownedPackages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Constraint> getOwnedConstraints() {
		if (ownedConstraints == null) {
			ownedConstraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, 0);
		}
		return ownedConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Import> getOwnedImports() {
		if (ownedImports == null) {
			ownedImports = new EObjectContainmentEList<Import>(Import.class, this, 1);
		}
		return ownedImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<org.eclipse.qvtd.doc.miniocl.Package> getOwnedPackages() {
		if (ownedPackages == null) {
			ownedPackages = new EObjectContainmentEList<org.eclipse.qvtd.doc.miniocl.Package>(org.eclipse.qvtd.doc.miniocl.Package.class, this, 2);
		}
		return ownedPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 0:
				return ((InternalEList<?>)getOwnedConstraints()).basicRemove(otherEnd, msgs);
			case 1:
				return ((InternalEList<?>)getOwnedImports()).basicRemove(otherEnd, msgs);
			case 2:
				return ((InternalEList<?>)getOwnedPackages()).basicRemove(otherEnd, msgs);
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
			case 0:
				return getOwnedConstraints();
			case 1:
				return getOwnedImports();
			case 2:
				return getOwnedPackages();
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
			case 0:
				getOwnedConstraints().clear();
				getOwnedConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case 1:
				getOwnedImports().clear();
				getOwnedImports().addAll((Collection<? extends Import>)newValue);
				return;
			case 2:
				getOwnedPackages().clear();
				getOwnedPackages().addAll((Collection<? extends org.eclipse.qvtd.doc.miniocl.Package>)newValue);
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
			case 0:
				getOwnedConstraints().clear();
				return;
			case 1:
				getOwnedImports().clear();
				return;
			case 2:
				getOwnedPackages().clear();
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
			case 0:
				return ownedConstraints != null && !ownedConstraints.isEmpty();
			case 1:
				return ownedImports != null && !ownedImports.isEmpty();
			case 2:
				return ownedPackages != null && !ownedPackages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitRoot(this);
	}

} //RootImpl
