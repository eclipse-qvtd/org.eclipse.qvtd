/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Direction CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DirectionCSImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DirectionCSImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DirectionCSImpl#isIsChecked <em>Is Checked</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DirectionCSImpl#isIsEnforced <em>Is Enforced</em>}</li>
 * </ul>
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
	protected EList<org.eclipse.ocl.pivot.Package> imports;

	/**
	 * The cached value of the '{@link #getUses() <em>Uses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUses()
	 * @generated
	 * @ordered
	 */
	protected EList<ImperativeDomain> uses;

	/**
	 * The default value of the '{@link #isIsChecked() <em>Is Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsChecked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CHECKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsChecked() <em>Is Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsChecked()
	 * @generated
	 * @ordered
	 */
	protected boolean isChecked = IS_CHECKED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsEnforced() <em>Is Enforced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforced()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEnforced() <em>Is Enforced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforced()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforced = IS_ENFORCED_EDEFAULT;

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
		return QVTimperativeCSPackage.Literals.DIRECTION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<org.eclipse.ocl.pivot.Package> getImports() {
		if (imports == null) {
			imports = new EObjectResolvingEList<org.eclipse.ocl.pivot.Package>(org.eclipse.ocl.pivot.Package.class, this, QVTimperativeCSPackage.DIRECTION_CS__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImperativeDomain> getUses() {
		if (uses == null) {
			uses = new EObjectResolvingEList<ImperativeDomain>(ImperativeDomain.class, this, QVTimperativeCSPackage.DIRECTION_CS__USES);
		}
		return uses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsChecked() {
		return isChecked;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsChecked(boolean newIsChecked) {
		boolean oldIsChecked = isChecked;
		isChecked = newIsChecked;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.DIRECTION_CS__IS_CHECKED, oldIsChecked, isChecked));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsEnforced() {
		return isEnforced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsEnforced(boolean newIsEnforced) {
		boolean oldIsEnforced = isEnforced;
		isEnforced = newIsEnforced;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.DIRECTION_CS__IS_ENFORCED, oldIsEnforced, isEnforced));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTimperativeCSPackage.DIRECTION_CS__IMPORTS:
				return getImports();
			case QVTimperativeCSPackage.DIRECTION_CS__USES:
				return getUses();
			case QVTimperativeCSPackage.DIRECTION_CS__IS_CHECKED:
				return isIsChecked();
			case QVTimperativeCSPackage.DIRECTION_CS__IS_ENFORCED:
				return isIsEnforced();
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
			case QVTimperativeCSPackage.DIRECTION_CS__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends org.eclipse.ocl.pivot.Package>)newValue);
				return;
			case QVTimperativeCSPackage.DIRECTION_CS__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends ImperativeDomain>)newValue);
				return;
			case QVTimperativeCSPackage.DIRECTION_CS__IS_CHECKED:
				setIsChecked((Boolean)newValue);
				return;
			case QVTimperativeCSPackage.DIRECTION_CS__IS_ENFORCED:
				setIsEnforced((Boolean)newValue);
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
			case QVTimperativeCSPackage.DIRECTION_CS__IMPORTS:
				getImports().clear();
				return;
			case QVTimperativeCSPackage.DIRECTION_CS__USES:
				getUses().clear();
				return;
			case QVTimperativeCSPackage.DIRECTION_CS__IS_CHECKED:
				setIsChecked(IS_CHECKED_EDEFAULT);
				return;
			case QVTimperativeCSPackage.DIRECTION_CS__IS_ENFORCED:
				setIsEnforced(IS_ENFORCED_EDEFAULT);
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
			case QVTimperativeCSPackage.DIRECTION_CS__IMPORTS:
				return imports != null && !imports.isEmpty();
			case QVTimperativeCSPackage.DIRECTION_CS__USES:
				return uses != null && !uses.isEmpty();
			case QVTimperativeCSPackage.DIRECTION_CS__IS_CHECKED:
				return isChecked != IS_CHECKED_EDEFAULT;
			case QVTimperativeCSPackage.DIRECTION_CS__IS_ENFORCED:
				return isEnforced != IS_ENFORCED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitDirectionCS(this);
	}

} //DirectionCSImpl
