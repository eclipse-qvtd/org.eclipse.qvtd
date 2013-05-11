/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
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
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl#getTypedModels <em>Typed Models</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGTransformationImpl extends CGClassImpl implements CGTransformation {
	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<CGMapping> mappings;
	/**
	 * The cached value of the '{@link #getTypedModels() <em>Typed Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedModels()
	 * @generated
	 * @ordered
	 */
	protected EList<CGTypedModel> typedModels;
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
	public List<CGMapping> getMappings() {
		if (mappings == null) {
			mappings = new EObjectContainmentWithInverseEList<CGMapping>(CGMapping.class, this, QVTiCGModelPackage.CG_TRANSFORMATION__MAPPINGS, QVTiCGModelPackage.CG_MAPPING__TRANSFORMATION);
		}
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGTypedModel> getTypedModels() {
		if (typedModels == null) {
			typedModels = new EObjectContainmentWithInverseEList<CGTypedModel>(CGTypedModel.class, this, QVTiCGModelPackage.CG_TRANSFORMATION__TYPED_MODELS, QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION);
		}
		return typedModels;
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__MAPPINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappings()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_TRANSFORMATION__TYPED_MODELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypedModels()).basicAdd(otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__MAPPINGS:
				return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_TRANSFORMATION__TYPED_MODELS:
				return ((InternalEList<?>)getTypedModels()).basicRemove(otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__MAPPINGS:
				return getMappings();
			case QVTiCGModelPackage.CG_TRANSFORMATION__TYPED_MODELS:
				return getTypedModels();
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__MAPPINGS:
				getMappings().clear();
				getMappings().addAll((Collection<? extends CGMapping>)newValue);
				return;
			case QVTiCGModelPackage.CG_TRANSFORMATION__TYPED_MODELS:
				getTypedModels().clear();
				getTypedModels().addAll((Collection<? extends CGTypedModel>)newValue);
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__MAPPINGS:
				getMappings().clear();
				return;
			case QVTiCGModelPackage.CG_TRANSFORMATION__TYPED_MODELS:
				getTypedModels().clear();
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
			case QVTiCGModelPackage.CG_TRANSFORMATION__MAPPINGS:
				return mappings != null && !mappings.isEmpty();
			case QVTiCGModelPackage.CG_TRANSFORMATION__TYPED_MODELS:
				return typedModels != null && !typedModels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return ((QVTiCGModelVisitor<R>)visitor).visitCGTransformation(this);
	}
} //CGTransformationImpl
