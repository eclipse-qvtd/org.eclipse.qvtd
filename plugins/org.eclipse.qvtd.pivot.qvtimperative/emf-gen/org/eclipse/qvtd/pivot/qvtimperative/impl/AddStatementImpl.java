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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl#getObservedProperties <em>Observed Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl#getTargetVariable <em>Target Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl#isIsEnforcedUnique <em>Is Enforced Unique</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AddStatementImpl extends MappingStatementImpl implements AddStatement {
	/**
	 * The cached value of the '{@link #getObservedProperties() <em>Observed Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> observedProperties;

	/**
	 * The cached value of the '{@link #getTargetVariable() <em>Target Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetVariable()
	 * @generated
	 * @ordered
	 */
	protected ConnectionVariable targetVariable;

	/**
	 * The default value of the '{@link #isIsEnforcedUnique() <em>Is Enforced Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforcedUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCED_UNIQUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEnforcedUnique() <em>Is Enforced Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforcedUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforcedUnique = IS_ENFORCED_UNIQUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.ADD_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getObservedProperties() {
		if (observedProperties == null) {
			observedProperties = new EObjectResolvingEList<Property>(Property.class, this, QVTimperativePackage.ADD_STATEMENT__OBSERVED_PROPERTIES);
		}
		return observedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionVariable getTargetVariable() {
		if (targetVariable != null && targetVariable.eIsProxy()) {
			InternalEObject oldTargetVariable = (InternalEObject)targetVariable;
			targetVariable = (ConnectionVariable)eResolveProxy(oldTargetVariable);
			if (targetVariable != oldTargetVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE, oldTargetVariable, targetVariable));
			}
		}
		return targetVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionVariable basicGetTargetVariable() {
		return targetVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetVariable(ConnectionVariable newTargetVariable) {
		ConnectionVariable oldTargetVariable = targetVariable;
		targetVariable = newTargetVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE, oldTargetVariable, targetVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsEnforcedUnique() {
		return isEnforcedUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsEnforcedUnique(boolean newIsEnforcedUnique) {
		boolean oldIsEnforcedUnique = isEnforcedUnique;
		isEnforcedUnique = newIsEnforcedUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.ADD_STATEMENT__IS_ENFORCED_UNIQUE, oldIsEnforcedUnique, isEnforcedUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedExpression() {
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(OCLExpression newOwnedExpression, NotificationChain msgs) {
		OCLExpression oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.ADD_STATEMENT__OWNED_EXPRESSION, oldOwnedExpression, newOwnedExpression);
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
	public void setOwnedExpression(OCLExpression newOwnedExpression) {
		if (newOwnedExpression != ownedExpression) {
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.ADD_STATEMENT__OWNED_EXPRESSION, null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.ADD_STATEMENT__OWNED_EXPRESSION, null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.ADD_STATEMENT__OWNED_EXPRESSION, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
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
			case QVTimperativePackage.ADD_STATEMENT__OWNED_EXPRESSION:
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
			case QVTimperativePackage.ADD_STATEMENT__OBSERVED_PROPERTIES:
				return getObservedProperties();
			case QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE:
				if (resolve) return getTargetVariable();
				return basicGetTargetVariable();
			case QVTimperativePackage.ADD_STATEMENT__IS_ENFORCED_UNIQUE:
				return isIsEnforcedUnique();
			case QVTimperativePackage.ADD_STATEMENT__OWNED_EXPRESSION:
				return getOwnedExpression();
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
			case QVTimperativePackage.ADD_STATEMENT__OBSERVED_PROPERTIES:
				getObservedProperties().clear();
				getObservedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE:
				setTargetVariable((ConnectionVariable)newValue);
				return;
			case QVTimperativePackage.ADD_STATEMENT__IS_ENFORCED_UNIQUE:
				setIsEnforcedUnique((Boolean)newValue);
				return;
			case QVTimperativePackage.ADD_STATEMENT__OWNED_EXPRESSION:
				setOwnedExpression((OCLExpression)newValue);
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
			case QVTimperativePackage.ADD_STATEMENT__OBSERVED_PROPERTIES:
				getObservedProperties().clear();
				return;
			case QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE:
				setTargetVariable((ConnectionVariable)null);
				return;
			case QVTimperativePackage.ADD_STATEMENT__IS_ENFORCED_UNIQUE:
				setIsEnforcedUnique(IS_ENFORCED_UNIQUE_EDEFAULT);
				return;
			case QVTimperativePackage.ADD_STATEMENT__OWNED_EXPRESSION:
				setOwnedExpression((OCLExpression)null);
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
			case QVTimperativePackage.ADD_STATEMENT__OBSERVED_PROPERTIES:
				return observedProperties != null && !observedProperties.isEmpty();
			case QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE:
				return targetVariable != null;
			case QVTimperativePackage.ADD_STATEMENT__IS_ENFORCED_UNIQUE:
				return isEnforcedUnique != IS_ENFORCED_UNIQUE_EDEFAULT;
			case QVTimperativePackage.ADD_STATEMENT__OWNED_EXPRESSION:
				return ownedExpression != null;
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
		if (baseClass == ObservableStatement.class) {
			switch (derivedFeatureID) {
				case QVTimperativePackage.ADD_STATEMENT__OBSERVED_PROPERTIES: return QVTimperativePackage.OBSERVABLE_STATEMENT__OBSERVED_PROPERTIES;
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
		if (baseClass == ObservableStatement.class) {
			switch (baseFeatureID) {
				case QVTimperativePackage.OBSERVABLE_STATEMENT__OBSERVED_PROPERTIES: return QVTimperativePackage.ADD_STATEMENT__OBSERVED_PROPERTIES;
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
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTimperativeVisitor<?>)visitor).visitAddStatement(this);
	}

} //AddStatementImpl