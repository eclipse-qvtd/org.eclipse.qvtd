/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

import org.eclipse.qvtd.xtext.qvtbasecs.JavaClassCS;
import org.eclipse.qvtd.xtext.qvtbasecs.JavaImplementationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;

import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl#isIsTransient <em>Is Transient</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QueryCSImpl extends TypedElementCSImpl implements QueryCS {
	/**
	 * The number of structural features of the '<em>Query CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUERY_CS_FEATURE_COUNT = TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected JavaClassCS implementation;

	/**
	 * The cached value of the '{@link #getOwnedParameters() <em>Owned Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParamDeclarationCS> ownedParameters;

	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedExpression;

	/**
	 * The default value of the '{@link #isIsTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TRANSIENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTransient()
	 * @generated
	 * @ordered
	 */
	protected boolean isTransient = IS_TRANSIENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.QUERY_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavaClassCS getImplementation() {
		if (implementation != null && implementation.eIsProxy()) {
			InternalEObject oldImplementation = (InternalEObject)implementation;
			implementation = (JavaClassCS)eResolveProxy(oldImplementation);
			if (implementation != oldImplementation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0, oldImplementation, implementation));
			}
		}
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaClassCS basicGetImplementation() {
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImplementation(JavaClassCS newImplementation) {
		JavaClassCS oldImplementation = implementation;
		implementation = newImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ParamDeclarationCS> getOwnedParameters() {
		if (ownedParameters == null) {
			ownedParameters = new EObjectContainmentEList<ParamDeclarationCS>(ParamDeclarationCS.class, this, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1);
		}
		return ownedParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedExpression() {
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(ExpCS newOwnedExpression, NotificationChain msgs) {
		ExpCS oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2, oldOwnedExpression, newOwnedExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedExpression(ExpCS newOwnedExpression) {
		if (newOwnedExpression != ownedExpression) {
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2), null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2), null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsTransient() {
		return isTransient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsTransient(boolean newIsTransient) {
		boolean oldIsTransient = isTransient;
		isTransient = newIsTransient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3, oldIsTransient, isTransient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getOwnedParameters()).basicRemove(otherEnd, msgs);
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				return basicSetOwnedExpression(null, msgs);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				if (resolve) return getImplementation();
				return basicGetImplementation();
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				return getOwnedParameters();
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				return getOwnedExpression();
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				return isIsTransient();
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				setImplementation((JavaClassCS)newValue);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				getOwnedParameters().clear();
				getOwnedParameters().addAll((Collection<? extends ParamDeclarationCS>)newValue);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				setOwnedExpression((ExpCS)newValue);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				setIsTransient((Boolean)newValue);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				setImplementation((JavaClassCS)null);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				getOwnedParameters().clear();
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				setOwnedExpression((ExpCS)null);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				setIsTransient(IS_TRANSIENT_EDEFAULT);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				return implementation != null;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				return ownedParameters != null && !ownedParameters.isEmpty();
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				return ownedExpression != null;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				return isTransient != IS_TRANSIENT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == JavaImplementationCS.class) {
			switch (derivedFeatureID) {
				case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0: return ElementCSImpl.ELEMENT_CS_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == JavaImplementationCS.class) {
			switch (baseFeatureID) {
				case ElementCSImpl.ELEMENT_CS_FEATURE_COUNT + 0: return TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof QVTimperativeCSVisitor) {
			return (R) ((QVTimperativeCSVisitor<?>)visitor).visitQueryCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //QueryCSImpl
