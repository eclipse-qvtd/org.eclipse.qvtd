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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGNamedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Typed Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl#getModelIndex <em>Model Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGTypedModelImpl extends CGNamedElementImpl implements CGTypedModel {
	/**
	 * The default value of the '{@link #getModelIndex() <em>Model Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int MODEL_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getModelIndex() <em>Model Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelIndex()
	 * @generated
	 * @ordered
	 */
	protected int modelIndex = MODEL_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGTypedModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_TYPED_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGTransformation getTransformation() {
		if (eContainerFeatureID() != QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION) return null;
		return (CGTransformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(CGTransformation newTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTransformation, QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformation(CGTransformation newTransformation) {
		if (newTransformation != eInternalContainer() || (eContainerFeatureID() != QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION && newTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, QVTiCGModelPackage.CG_TRANSFORMATION__TYPED_MODELS, CGTransformation.class, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION, newTransformation, newTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getModelIndex() {
		return modelIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelIndex(int newModelIndex) {
		int oldModelIndex = modelIndex;
		modelIndex = newModelIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_TYPED_MODEL__MODEL_INDEX, oldModelIndex, modelIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTransformation((CGTransformation)otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION:
				return basicSetTransformation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION:
				return eInternalContainer().eInverseRemove(this, QVTiCGModelPackage.CG_TRANSFORMATION__TYPED_MODELS, CGTransformation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION:
				return getTransformation();
			case QVTiCGModelPackage.CG_TYPED_MODEL__MODEL_INDEX:
				return getModelIndex();
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
			case QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION:
				setTransformation((CGTransformation)newValue);
				return;
			case QVTiCGModelPackage.CG_TYPED_MODEL__MODEL_INDEX:
				setModelIndex((Integer)newValue);
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
			case QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION:
				setTransformation((CGTransformation)null);
				return;
			case QVTiCGModelPackage.CG_TYPED_MODEL__MODEL_INDEX:
				setModelIndex(MODEL_INDEX_EDEFAULT);
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
			case QVTiCGModelPackage.CG_TYPED_MODEL__TRANSFORMATION:
				return getTransformation() != null;
			case QVTiCGModelPackage.CG_TYPED_MODEL__MODEL_INDEX:
				return modelIndex != MODEL_INDEX_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return ((QVTiCGModelVisitor<R>)visitor).visitCGTypedModel(this);
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //CGTypedModelImpl
