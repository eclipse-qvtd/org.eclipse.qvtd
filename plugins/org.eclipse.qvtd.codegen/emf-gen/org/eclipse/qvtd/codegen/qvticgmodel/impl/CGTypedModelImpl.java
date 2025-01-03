/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGClassImpl;
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
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl#getModelIndex <em>Model Index</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl#getOwningTransformation <em>Owning Transformation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGTypedModelImpl extends CGNamedElementImpl implements CGTypedModel {
	/**
	 * The number of structural features of the '<em>CG Typed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CG_TYPED_MODEL_FEATURE_COUNT = CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 2;

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
	@Override
	public int getModelIndex() {
		return modelIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelIndex(int newModelIndex) {
		int oldModelIndex = modelIndex;
		modelIndex = newModelIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 0, oldModelIndex, modelIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGTransformation getOwningTransformation() {
		if (eContainerFeatureID() != (CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 1)) return null;
		return (CGTransformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTransformation(CGTransformation newOwningTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTransformation, CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTransformation(CGTransformation newOwningTransformation) {
		if (newOwningTransformation != eInternalContainer() || (eContainerFeatureID() != (CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 1) && newOwningTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTransformation != null)
				msgs = ((InternalEObject)newOwningTransformation).eInverseAdd(this, CGClassImpl.CG_CLASS_FEATURE_COUNT + 1, CGTransformation.class, msgs);
			msgs = basicSetOwningTransformation(newOwningTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 1, newOwningTransformation, newOwningTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (modelIndex: ");
		result.append(modelIndex);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 1:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTransformation((CGTransformation)otherEnd, msgs);
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
			case CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return basicSetOwningTransformation(null, msgs);
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
			case CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return eInternalContainer().eInverseRemove(this, CGClassImpl.CG_CLASS_FEATURE_COUNT + 1, CGTransformation.class, msgs);
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
			case CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 0:
				return getModelIndex();
			case CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return getOwningTransformation();
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
			case CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 0:
				setModelIndex((Integer)newValue);
				return;
			case CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 1:
				setOwningTransformation((CGTransformation)newValue);
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
			case CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 0:
				setModelIndex(MODEL_INDEX_EDEFAULT);
				return;
			case CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 1:
				setOwningTransformation((CGTransformation)null);
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
			case CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 0:
				return modelIndex != MODEL_INDEX_EDEFAULT;
			case CGNamedElementImpl.CG_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return getOwningTransformation() != null;
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
		if (visitor instanceof QVTiCGModelVisitor) {
			return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGTypedModel(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //CGTypedModelImpl
