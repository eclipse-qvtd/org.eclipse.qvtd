/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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

import org.eclipse.ocl.xtext.basecs.PathNameCS;

import org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

import org.eclipse.qvtd.pivot.qvtbase.Transformation;

import org.eclipse.qvtd.xtext.qvtbasecs.JavaClassCS;
import org.eclipse.qvtd.xtext.qvtbasecs.JavaImplementationCS;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
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
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl#isIsTransient <em>Is Transient</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QueryCSImpl extends TypedElementCSImpl implements QueryCS {
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
	 * The cached value of the '{@link #getOwnedPathName() <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS ownedPathName;

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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativeCSPackage.QUERY_CS__IMPLEMENTATION, oldImplementation, implementation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.QUERY_CS__IMPLEMENTATION, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS getOwnedPathName() {
		return ownedPathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPathName(PathNameCS newOwnedPathName, NotificationChain msgs) {
		PathNameCS oldOwnedPathName = ownedPathName;
		ownedPathName = newOwnedPathName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.QUERY_CS__OWNED_PATH_NAME, oldOwnedPathName, newOwnedPathName);
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
	public void setOwnedPathName(PathNameCS newOwnedPathName) {
		if (newOwnedPathName != ownedPathName) {
			NotificationChain msgs = null;
			if (ownedPathName != null)
				msgs = ((InternalEObject)ownedPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.QUERY_CS__OWNED_PATH_NAME, null, msgs);
			if (newOwnedPathName != null)
				msgs = ((InternalEObject)newOwnedPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.QUERY_CS__OWNED_PATH_NAME, null, msgs);
			msgs = basicSetOwnedPathName(newOwnedPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.QUERY_CS__OWNED_PATH_NAME, newOwnedPathName, newOwnedPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Transformation getTransformation() {
		if (ownedPathName == null) {
			return null;
		}
		return (Transformation) ownedPathName.getReferredElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ParamDeclarationCS> getOwnedParameters() {
		if (ownedParameters == null) {
			ownedParameters = new EObjectContainmentEList<ParamDeclarationCS>(ParamDeclarationCS.class, this, QVTimperativeCSPackage.QUERY_CS__OWNED_PARAMETERS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.QUERY_CS__OWNED_EXPRESSION, oldOwnedExpression, newOwnedExpression);
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
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.QUERY_CS__OWNED_EXPRESSION, null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.QUERY_CS__OWNED_EXPRESSION, null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.QUERY_CS__OWNED_EXPRESSION, newOwnedExpression, newOwnedExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.QUERY_CS__IS_TRANSIENT, oldIsTransient, isTransient));
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
			case QVTimperativeCSPackage.QUERY_CS__OWNED_PATH_NAME:
				return basicSetOwnedPathName(null, msgs);
			case QVTimperativeCSPackage.QUERY_CS__OWNED_PARAMETERS:
				return ((InternalEList<?>)getOwnedParameters()).basicRemove(otherEnd, msgs);
			case QVTimperativeCSPackage.QUERY_CS__OWNED_EXPRESSION:
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
			case QVTimperativeCSPackage.QUERY_CS__IMPLEMENTATION:
				if (resolve) return getImplementation();
				return basicGetImplementation();
			case QVTimperativeCSPackage.QUERY_CS__OWNED_PATH_NAME:
				return getOwnedPathName();
			case QVTimperativeCSPackage.QUERY_CS__TRANSFORMATION:
				return getTransformation();
			case QVTimperativeCSPackage.QUERY_CS__OWNED_PARAMETERS:
				return getOwnedParameters();
			case QVTimperativeCSPackage.QUERY_CS__OWNED_EXPRESSION:
				return getOwnedExpression();
			case QVTimperativeCSPackage.QUERY_CS__IS_TRANSIENT:
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
			case QVTimperativeCSPackage.QUERY_CS__IMPLEMENTATION:
				setImplementation((JavaClassCS)newValue);
				return;
			case QVTimperativeCSPackage.QUERY_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathNameCS)newValue);
				return;
			case QVTimperativeCSPackage.QUERY_CS__OWNED_PARAMETERS:
				getOwnedParameters().clear();
				getOwnedParameters().addAll((Collection<? extends ParamDeclarationCS>)newValue);
				return;
			case QVTimperativeCSPackage.QUERY_CS__OWNED_EXPRESSION:
				setOwnedExpression((ExpCS)newValue);
				return;
			case QVTimperativeCSPackage.QUERY_CS__IS_TRANSIENT:
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
			case QVTimperativeCSPackage.QUERY_CS__IMPLEMENTATION:
				setImplementation((JavaClassCS)null);
				return;
			case QVTimperativeCSPackage.QUERY_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathNameCS)null);
				return;
			case QVTimperativeCSPackage.QUERY_CS__OWNED_PARAMETERS:
				getOwnedParameters().clear();
				return;
			case QVTimperativeCSPackage.QUERY_CS__OWNED_EXPRESSION:
				setOwnedExpression((ExpCS)null);
				return;
			case QVTimperativeCSPackage.QUERY_CS__IS_TRANSIENT:
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
			case QVTimperativeCSPackage.QUERY_CS__IMPLEMENTATION:
				return implementation != null;
			case QVTimperativeCSPackage.QUERY_CS__OWNED_PATH_NAME:
				return ownedPathName != null;
			case QVTimperativeCSPackage.QUERY_CS__TRANSFORMATION:
				return getTransformation() != null;
			case QVTimperativeCSPackage.QUERY_CS__OWNED_PARAMETERS:
				return ownedParameters != null && !ownedParameters.isEmpty();
			case QVTimperativeCSPackage.QUERY_CS__OWNED_EXPRESSION:
				return ownedExpression != null;
			case QVTimperativeCSPackage.QUERY_CS__IS_TRANSIENT:
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
				case QVTimperativeCSPackage.QUERY_CS__IMPLEMENTATION: return QVTbaseCSPackage.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION;
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
				case QVTbaseCSPackage.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION: return QVTimperativeCSPackage.QUERY_CS__IMPLEMENTATION;
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
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitQueryCS(this);
	}

} //QueryCSImpl
