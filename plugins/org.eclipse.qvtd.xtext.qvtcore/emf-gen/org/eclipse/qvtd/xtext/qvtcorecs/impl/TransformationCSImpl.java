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
package org.eclipse.qvtd.xtext.qvtcorecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.xtext.basecs.StructuralFeatureCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.qvtd.xtext.qvtbasecs.impl.AbstractTransformationCSImpl;

import org.eclipse.qvtd.xtext.qvtcorecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;
import org.eclipse.qvtd.xtext.qvtcorecs.TransformationCS;

import org.eclipse.qvtd.xtext.qvtcorecs.util.QVTcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TransformationCSImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TransformationCSImpl#getOwnedDirections <em>Owned Directions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TransformationCSImpl#getOwnedProperties <em>Owned Properties</em>}</li>
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
	public static final int TRANSFORMATION_CS_FEATURE_COUNT = AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3;
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
	 * The cached value of the '{@link #getOwnedProperties() <em>Owned Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<StructuralFeatureCS> ownedProperties;

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
		return QVTcoreCSPackage.Literals.TRANSFORMATION_CS;
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
	public EList<StructuralFeatureCS> getOwnedProperties() {
		if (ownedProperties == null) {
			ownedProperties = new EObjectContainmentEList<StructuralFeatureCS>(StructuralFeatureCS.class, this, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2);
		}
		return ownedProperties;
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
				return ((InternalEList<?>)getOwnedProperties()).basicRemove(otherEnd, msgs);
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
				return getOwnedProperties();
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
				getOwnedProperties().clear();
				getOwnedProperties().addAll((Collection<? extends StructuralFeatureCS>)newValue);
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
				getOwnedProperties().clear();
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
				return ownedProperties != null && !ownedProperties.isEmpty();
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
		if (visitor instanceof QVTcoreCSVisitor) {
			return (R) ((QVTcoreCSVisitor<?>)visitor).visitTransformationCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //TransformationCSImpl
