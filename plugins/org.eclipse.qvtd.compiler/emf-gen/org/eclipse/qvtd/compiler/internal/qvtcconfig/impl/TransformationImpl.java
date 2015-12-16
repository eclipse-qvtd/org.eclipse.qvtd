/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.compiler.internal.qvtcconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.compiler.internal.qvtcconfig.Direction;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Import;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Transformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.TransformationImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.TransformationImpl#getImport <em>Import</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationImpl extends NamedElementImpl implements Transformation {
	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected EList<Direction> direction;

	/**
	 * The cached value of the '{@link #getImport() <em>Import</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImport()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> import_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcConfigPackage.Literals.TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Direction> getDirection() {
		if (direction == null) {
			direction = new EObjectContainmentEList<Direction>(Direction.class, this, QVTcConfigPackage.TRANSFORMATION__DIRECTION);
		}
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Import> getImport() {
		if (import_ == null) {
			import_ = new EObjectContainmentEList<Import>(Import.class, this, QVTcConfigPackage.TRANSFORMATION__IMPORT);
		}
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcConfigPackage.TRANSFORMATION__DIRECTION:
				return ((InternalEList<?>)getDirection()).basicRemove(otherEnd, msgs);
			case QVTcConfigPackage.TRANSFORMATION__IMPORT:
				return ((InternalEList<?>)getImport()).basicRemove(otherEnd, msgs);
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
			case QVTcConfigPackage.TRANSFORMATION__DIRECTION:
				return getDirection();
			case QVTcConfigPackage.TRANSFORMATION__IMPORT:
				return getImport();
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
			case QVTcConfigPackage.TRANSFORMATION__DIRECTION:
				getDirection().clear();
				getDirection().addAll((Collection<? extends Direction>)newValue);
				return;
			case QVTcConfigPackage.TRANSFORMATION__IMPORT:
				getImport().clear();
				getImport().addAll((Collection<? extends Import>)newValue);
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
			case QVTcConfigPackage.TRANSFORMATION__DIRECTION:
				getDirection().clear();
				return;
			case QVTcConfigPackage.TRANSFORMATION__IMPORT:
				getImport().clear();
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
			case QVTcConfigPackage.TRANSFORMATION__DIRECTION:
				return direction != null && !direction.isEmpty();
			case QVTcConfigPackage.TRANSFORMATION__IMPORT:
				return import_ != null && !import_.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransformationImpl
