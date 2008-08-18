/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ModelDeclCSImpl.java,v 1.2 2008/08/18 07:55:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.impl.CSTNodeImpl;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ModelDeclCSImpl#getModelId <em>Model Id</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ModelDeclCSImpl#getMetaModelId <em>Meta Model Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelDeclCSImpl extends CSTNodeImpl implements ModelDeclCS {
	/**
	 * The cached value of the '{@link #getModelId() <em>Model Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelId()
	 * @generated
	 * @ordered
	 */
	protected IdentifierCS modelId;

	/**
	 * The cached value of the '{@link #getMetaModelId() <em>Meta Model Id</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelId()
	 * @generated
	 * @ordered
	 */
	protected EList<IdentifierCS> metaModelId;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelDeclCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrCSTPackage.Literals.MODEL_DECL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierCS getModelId() {
		return modelId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelId(IdentifierCS newModelId, NotificationChain msgs) {
		IdentifierCS oldModelId = modelId;
		modelId = newModelId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.MODEL_DECL_CS__MODEL_ID, oldModelId, newModelId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelId(IdentifierCS newModelId) {
		if (newModelId != modelId) {
			NotificationChain msgs = null;
			if (modelId != null)
				msgs = ((InternalEObject)modelId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.MODEL_DECL_CS__MODEL_ID, null, msgs);
			if (newModelId != null)
				msgs = ((InternalEObject)newModelId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.MODEL_DECL_CS__MODEL_ID, null, msgs);
			msgs = basicSetModelId(newModelId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.MODEL_DECL_CS__MODEL_ID, newModelId, newModelId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IdentifierCS> getMetaModelId() {
		if (metaModelId == null) {
			metaModelId = new EObjectContainmentEList<IdentifierCS>(IdentifierCS.class, this, QVTrCSTPackage.MODEL_DECL_CS__META_MODEL_ID);
		}
		return metaModelId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrCSTPackage.MODEL_DECL_CS__MODEL_ID:
				return basicSetModelId(null, msgs);
			case QVTrCSTPackage.MODEL_DECL_CS__META_MODEL_ID:
				return ((InternalEList<?>)getMetaModelId()).basicRemove(otherEnd, msgs);
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
			case QVTrCSTPackage.MODEL_DECL_CS__MODEL_ID:
				return getModelId();
			case QVTrCSTPackage.MODEL_DECL_CS__META_MODEL_ID:
				return getMetaModelId();
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
			case QVTrCSTPackage.MODEL_DECL_CS__MODEL_ID:
				setModelId((IdentifierCS)newValue);
				return;
			case QVTrCSTPackage.MODEL_DECL_CS__META_MODEL_ID:
				getMetaModelId().clear();
				getMetaModelId().addAll((Collection<? extends IdentifierCS>)newValue);
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
			case QVTrCSTPackage.MODEL_DECL_CS__MODEL_ID:
				setModelId((IdentifierCS)null);
				return;
			case QVTrCSTPackage.MODEL_DECL_CS__META_MODEL_ID:
				getMetaModelId().clear();
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
			case QVTrCSTPackage.MODEL_DECL_CS__MODEL_ID:
				return modelId != null;
			case QVTrCSTPackage.MODEL_DECL_CS__META_MODEL_ID:
				return metaModelId != null && !metaModelId.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelDeclCSImpl
