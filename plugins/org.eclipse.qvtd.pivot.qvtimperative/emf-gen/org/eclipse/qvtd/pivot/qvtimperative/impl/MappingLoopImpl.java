/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl#getObservedProperties <em>Observed Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl#getOwnedIterators <em>Owned Iterators</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl#getOwnedMappingStatements <em>Owned Mapping Statements</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingLoopImpl extends MappingStatementImpl implements MappingLoop {
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
	 * The cached value of the '{@link #getOwnedIterators() <em>Owned Iterators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<LoopVariable> ownedIterators;

	/**
	 * The cached value of the '{@link #getOwnedMappingStatements() <em>Owned Mapping Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappingStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingStatement> ownedMappingStatements;

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
	protected MappingLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.MAPPING_LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getObservedProperties() {
		if (observedProperties == null) {
			observedProperties = new EObjectResolvingEList<Property>(Property.class, this, QVTimperativePackage.MAPPING_LOOP__OBSERVED_PROPERTIES);
		}
		return observedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LoopVariable> getOwnedIterators() {
		if (ownedIterators == null) {
			ownedIterators = new EObjectContainmentWithInverseEList<LoopVariable>(LoopVariable.class, this, QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS, QVTimperativePackage.LOOP_VARIABLE__OWNING_MAPPING_LOOP);
		}
		return ownedIterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingStatement> getOwnedMappingStatements() {
		if (ownedMappingStatements == null) {
			ownedMappingStatements = new EObjectContainmentEList<MappingStatement>(MappingStatement.class, this, QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS);
		}
		return ownedMappingStatements;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_LOOP__OWNED_EXPRESSION, oldOwnedExpression, newOwnedExpression);
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
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.MAPPING_LOOP__OWNED_EXPRESSION, null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.MAPPING_LOOP__OWNED_EXPRESSION, null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_LOOP__OWNED_EXPRESSION, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedIterators()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				return ((InternalEList<?>)getOwnedIterators()).basicRemove(otherEnd, msgs);
			case QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS:
				return ((InternalEList<?>)getOwnedMappingStatements()).basicRemove(otherEnd, msgs);
			case QVTimperativePackage.MAPPING_LOOP__OWNED_EXPRESSION:
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
			case QVTimperativePackage.MAPPING_LOOP__OBSERVED_PROPERTIES:
				return getObservedProperties();
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				return getOwnedIterators();
			case QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS:
				return getOwnedMappingStatements();
			case QVTimperativePackage.MAPPING_LOOP__OWNED_EXPRESSION:
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
			case QVTimperativePackage.MAPPING_LOOP__OBSERVED_PROPERTIES:
				getObservedProperties().clear();
				getObservedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				getOwnedIterators().clear();
				getOwnedIterators().addAll((Collection<? extends LoopVariable>)newValue);
				return;
			case QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS:
				getOwnedMappingStatements().clear();
				getOwnedMappingStatements().addAll((Collection<? extends MappingStatement>)newValue);
				return;
			case QVTimperativePackage.MAPPING_LOOP__OWNED_EXPRESSION:
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
			case QVTimperativePackage.MAPPING_LOOP__OBSERVED_PROPERTIES:
				getObservedProperties().clear();
				return;
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				getOwnedIterators().clear();
				return;
			case QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS:
				getOwnedMappingStatements().clear();
				return;
			case QVTimperativePackage.MAPPING_LOOP__OWNED_EXPRESSION:
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
			case QVTimperativePackage.MAPPING_LOOP__OBSERVED_PROPERTIES:
				return observedProperties != null && !observedProperties.isEmpty();
			case QVTimperativePackage.MAPPING_LOOP__OWNED_ITERATORS:
				return ownedIterators != null && !ownedIterators.isEmpty();
			case QVTimperativePackage.MAPPING_LOOP__OWNED_MAPPING_STATEMENTS:
				return ownedMappingStatements != null && !ownedMappingStatements.isEmpty();
			case QVTimperativePackage.MAPPING_LOOP__OWNED_EXPRESSION:
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
				case QVTimperativePackage.MAPPING_LOOP__OBSERVED_PROPERTIES: return QVTimperativePackage.OBSERVABLE_STATEMENT__OBSERVED_PROPERTIES;
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
				case QVTimperativePackage.OBSERVABLE_STATEMENT__OBSERVED_PROPERTIES: return QVTimperativePackage.MAPPING_LOOP__OBSERVED_PROPERTIES;
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
		return (R) ((QVTimperativeVisitor<?>)visitor).visitMappingLoop(this);
	}
} //MappingLoopImpl
