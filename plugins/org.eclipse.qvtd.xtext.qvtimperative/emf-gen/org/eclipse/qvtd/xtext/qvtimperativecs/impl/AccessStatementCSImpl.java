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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;

import org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.qvtd.xtext.qvtimperativecs.AccessStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;

import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Access Statement CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.AccessStatementCSImpl#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.AccessStatementCSImpl#getSourceVariable <em>Source Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AccessStatementCSImpl extends TypedElementCSImpl implements AccessStatementCS {
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
	 * The cached value of the '{@link #getSourceVariable() <em>Source Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration sourceVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessStatementCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.ACCESS_STATEMENT_CS;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_PROPERTY, oldSourceProperty, sourceProperty));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_PROPERTY, oldSourceProperty, sourceProperty));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_VARIABLE, oldSourceVariable, sourceVariable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_VARIABLE, oldSourceVariable, sourceVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_PROPERTY:
				if (resolve) return getSourceProperty();
				return basicGetSourceProperty();
			case QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_VARIABLE:
				if (resolve) return getSourceVariable();
				return basicGetSourceVariable();
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
			case QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_PROPERTY:
				setSourceProperty((Property)newValue);
				return;
			case QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_VARIABLE:
				setSourceVariable((VariableDeclaration)newValue);
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
			case QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_PROPERTY:
				setSourceProperty((Property)null);
				return;
			case QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_VARIABLE:
				setSourceVariable((VariableDeclaration)null);
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
			case QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_PROPERTY:
				return sourceProperty != null;
			case QVTimperativeCSPackage.ACCESS_STATEMENT_CS__SOURCE_VARIABLE:
				return sourceVariable != null;
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
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitAccessStatementCS(this);
	}

} //AccessStatementCSImpl
