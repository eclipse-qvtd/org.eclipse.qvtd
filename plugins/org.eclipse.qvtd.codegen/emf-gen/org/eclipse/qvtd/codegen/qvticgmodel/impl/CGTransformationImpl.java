/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGClassImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl#getOwnedMappings <em>Owned Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl#getOwnedTypedModels <em>Owned Typed Models</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGTransformationImpl extends CGClassImpl implements CGTransformation {
	/**
	 * The cached value of the '{@link #getOwnedMappings() <em>Owned Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<CGMapping> ownedMappings;

	/**
	 * The cached value of the '{@link #getOwnedTypedModels() <em>Owned Typed Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTypedModels()
	 * @generated
	 * @ordered
	 */
	protected EList<CGTypedModel> ownedTypedModels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGTransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGMapping> getOwnedMappings() {
		if (ownedMappings == null) {
			ownedMappings = new EObjectContainmentWithInverseEList<CGMapping>(CGMapping.class, this, QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_MAPPINGS, QVTiCGModelPackage.CG_MAPPING__OWNING_TRANSFORMATION);
		}
		return ownedMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<CGTypedModel> getOwnedTypedModels() {
		if (ownedTypedModels == null) {
			ownedTypedModels = new EObjectContainmentWithInverseEList<CGTypedModel>(CGTypedModel.class, this, QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_TYPED_MODELS, QVTiCGModelPackage.CG_TYPED_MODEL__OWNING_TRANSFORMATION);
		}
		return ownedTypedModels;
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_MAPPINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMappings()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_TYPED_MODELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTypedModels()).basicAdd(otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_MAPPINGS:
				return ((InternalEList<?>)getOwnedMappings()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_TYPED_MODELS:
				return ((InternalEList<?>)getOwnedTypedModels()).basicRemove(otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_MAPPINGS:
				return getOwnedMappings();
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_TYPED_MODELS:
				return getOwnedTypedModels();
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_MAPPINGS:
				getOwnedMappings().clear();
				getOwnedMappings().addAll((Collection<? extends CGMapping>)newValue);
				return;
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_TYPED_MODELS:
				getOwnedTypedModels().clear();
				getOwnedTypedModels().addAll((Collection<? extends CGTypedModel>)newValue);
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_MAPPINGS:
				getOwnedMappings().clear();
				return;
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_TYPED_MODELS:
				getOwnedTypedModels().clear();
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_MAPPINGS:
				return ownedMappings != null && !ownedMappings.isEmpty();
			case QVTiCGModelPackage.CG_TRANSFORMATION__OWNED_TYPED_MODELS:
				return ownedTypedModels != null && !ownedTypedModels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGTransformation(this);
	}

} //CGTransformationImpl
