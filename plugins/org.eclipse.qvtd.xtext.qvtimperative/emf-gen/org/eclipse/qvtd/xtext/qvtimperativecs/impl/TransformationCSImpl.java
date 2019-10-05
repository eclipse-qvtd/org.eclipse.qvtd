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

import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.qvtd.xtext.qvtbasecs.impl.AbstractTransformationCSImpl;

import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;

import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.TransformationCSImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.TransformationCSImpl#getOwnedDirections <em>Owned Directions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.TransformationCSImpl#getOwnedMappings <em>Owned Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.TransformationCSImpl#getOwnedQueries <em>Owned Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.TransformationCSImpl#getOwnedContextType <em>Owned Context Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationCSImpl extends AbstractTransformationCSImpl implements TransformationCS {
	/**
	 * The number of structural features of the '<em>Transformation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFORMATION_CS_FEATURE_COUNT = AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 5;
	/**
	 * The cached value of the '{@link #getOwnedDirections() <em>Owned Directions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDirections()
	 * @generated
	 * @ordered
	 */
	protected EList<DirectionCS> ownedDirections;

	/**
	 * The cached value of the '{@link #getOwnedMappings() <em>Owned Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingCS> ownedMappings;
	/**
	 * The cached value of the '{@link #getOwnedQueries() <em>Owned Queries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<QueryCS> ownedQueries;
	/**
	 * The cached value of the '{@link #getOwnedContextType() <em>Owned Context Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedContextType()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS ownedContextType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.TRANSFORMATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public org.eclipse.ocl.pivot.Package getPackage() {
		if (ownedPathName == null) {
			return null;
		}
		return (org.eclipse.ocl.pivot.Package) ownedPathName.getReferredElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DirectionCS> getOwnedDirections() {
		if (ownedDirections == null) {
			ownedDirections = new EObjectContainmentEList<DirectionCS>(DirectionCS.class, this, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1);
		}
		return ownedDirections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingCS> getOwnedMappings() {
		if (ownedMappings == null) {
			ownedMappings = new EObjectContainmentEList<MappingCS>(MappingCS.class, this, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2);
		}
		return ownedMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<QueryCS> getOwnedQueries() {
		if (ownedQueries == null) {
			ownedQueries = new EObjectContainmentEList<QueryCS>(QueryCS.class, this, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3);
		}
		return ownedQueries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedRefCS getOwnedContextType() {
		return ownedContextType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedContextType(TypedRefCS newOwnedContextType, NotificationChain msgs) {
		TypedRefCS oldOwnedContextType = ownedContextType;
		ownedContextType = newOwnedContextType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4, oldOwnedContextType, newOwnedContextType);
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
	public void setOwnedContextType(TypedRefCS newOwnedContextType) {
		if (newOwnedContextType != ownedContextType) {
			NotificationChain msgs = null;
			if (ownedContextType != null)
				msgs = ((InternalEObject)ownedContextType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4), null, msgs);
			if (newOwnedContextType != null)
				msgs = ((InternalEObject)newOwnedContextType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4), null, msgs);
			msgs = basicSetOwnedContextType(newOwnedContextType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4, newOwnedContextType, newOwnedContextType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getOwnedDirections()).basicRemove(otherEnd, msgs);
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getOwnedMappings()).basicRemove(otherEnd, msgs);
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getOwnedQueries()).basicRemove(otherEnd, msgs);
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4:
				return basicSetOwnedContextType(null, msgs);
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
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 0:
				return getPackage();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1:
				return getOwnedDirections();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2:
				return getOwnedMappings();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3:
				return getOwnedQueries();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4:
				return getOwnedContextType();
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
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1:
				getOwnedDirections().clear();
				getOwnedDirections().addAll((Collection<? extends DirectionCS>)newValue);
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2:
				getOwnedMappings().clear();
				getOwnedMappings().addAll((Collection<? extends MappingCS>)newValue);
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3:
				getOwnedQueries().clear();
				getOwnedQueries().addAll((Collection<? extends QueryCS>)newValue);
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4:
				setOwnedContextType((TypedRefCS)newValue);
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
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1:
				getOwnedDirections().clear();
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2:
				getOwnedMappings().clear();
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3:
				getOwnedQueries().clear();
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4:
				setOwnedContextType((TypedRefCS)null);
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
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 0:
				return getPackage() != null;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1:
				return ownedDirections != null && !ownedDirections.isEmpty();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2:
				return ownedMappings != null && !ownedMappings.isEmpty();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3:
				return ownedQueries != null && !ownedQueries.isEmpty();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4:
				return ownedContextType != null;
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
		if (visitor instanceof QVTimperativeCSVisitor) {
			return (R) ((QVTimperativeCSVisitor<?>)visitor).visitTransformationCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //TransformationCSImpl
