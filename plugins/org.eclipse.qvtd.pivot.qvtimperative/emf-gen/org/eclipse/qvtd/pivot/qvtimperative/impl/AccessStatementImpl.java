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
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtimperative.AccessStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;

import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Access Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AccessStatementImpl#getSourceVariable <em>Source Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AccessStatementImpl#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AccessStatementImpl#isIsOpposite <em>Is Opposite</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AccessStatementImpl extends VariableStatementImpl implements AccessStatement {
	/**
	 * The cached value of the '{@link #getSourceVariable() <em>Source Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration sourceVariable;

	/**
	 * The cached value of the '{@link #getSourceProperty() <em>Source Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceProperty()
	 * @generated
	 * @ordered
	 */
	protected Property sourceProperty;

	/**
	 * The default value of the '{@link #isIsOpposite() <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOpposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_OPPOSITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOpposite() <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOpposite()
	 * @generated
	 * @ordered
	 */
	protected boolean isOpposite = IS_OPPOSITE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.ACCESS_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getSourceVariable() {
		if (sourceVariable != null && sourceVariable.eIsProxy()) {
			InternalEObject oldSourceVariable = (InternalEObject)sourceVariable;
			sourceVariable = (VariableDeclaration)eResolveProxy(oldSourceVariable);
			if (sourceVariable != oldSourceVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.ACCESS_STATEMENT__SOURCE_VARIABLE, oldSourceVariable, sourceVariable));
			}
		}
		return sourceVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetSourceVariable() {
		return sourceVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceVariable(VariableDeclaration newSourceVariable) {
		VariableDeclaration oldSourceVariable = sourceVariable;
		sourceVariable = newSourceVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.ACCESS_STATEMENT__SOURCE_VARIABLE, oldSourceVariable, sourceVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getSourceProperty() {
		if (sourceProperty != null && sourceProperty.eIsProxy()) {
			InternalEObject oldSourceProperty = (InternalEObject)sourceProperty;
			sourceProperty = (Property)eResolveProxy(oldSourceProperty);
			if (sourceProperty != oldSourceProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.ACCESS_STATEMENT__SOURCE_PROPERTY, oldSourceProperty, sourceProperty));
			}
		}
		return sourceProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetSourceProperty() {
		return sourceProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceProperty(Property newSourceProperty) {
		Property oldSourceProperty = sourceProperty;
		sourceProperty = newSourceProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.ACCESS_STATEMENT__SOURCE_PROPERTY, oldSourceProperty, sourceProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOpposite() {
		return isOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOpposite(boolean newIsOpposite) {
		boolean oldIsOpposite = isOpposite;
		isOpposite = newIsOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.ACCESS_STATEMENT__IS_OPPOSITE, oldIsOpposite, isOpposite));
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
			case QVTimperativePackage.ACCESS_STATEMENT__SOURCE_VARIABLE:
				if (resolve) return getSourceVariable();
				return basicGetSourceVariable();
			case QVTimperativePackage.ACCESS_STATEMENT__SOURCE_PROPERTY:
				if (resolve) return getSourceProperty();
				return basicGetSourceProperty();
			case QVTimperativePackage.ACCESS_STATEMENT__IS_OPPOSITE:
				return isIsOpposite();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTimperativePackage.ACCESS_STATEMENT__SOURCE_VARIABLE:
				setSourceVariable((VariableDeclaration)newValue);
				return;
			case QVTimperativePackage.ACCESS_STATEMENT__SOURCE_PROPERTY:
				setSourceProperty((Property)newValue);
				return;
			case QVTimperativePackage.ACCESS_STATEMENT__IS_OPPOSITE:
				setIsOpposite((Boolean)newValue);
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
			case QVTimperativePackage.ACCESS_STATEMENT__SOURCE_VARIABLE:
				setSourceVariable((VariableDeclaration)null);
				return;
			case QVTimperativePackage.ACCESS_STATEMENT__SOURCE_PROPERTY:
				setSourceProperty((Property)null);
				return;
			case QVTimperativePackage.ACCESS_STATEMENT__IS_OPPOSITE:
				setIsOpposite(IS_OPPOSITE_EDEFAULT);
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
			case QVTimperativePackage.ACCESS_STATEMENT__SOURCE_VARIABLE:
				return sourceVariable != null;
			case QVTimperativePackage.ACCESS_STATEMENT__SOURCE_PROPERTY:
				return sourceProperty != null;
			case QVTimperativePackage.ACCESS_STATEMENT__IS_OPPOSITE:
				return isOpposite != IS_OPPOSITE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTimperativeVisitor<?>)visitor).visitAccessStatement(this);
	}

} //AccessStatementImpl
