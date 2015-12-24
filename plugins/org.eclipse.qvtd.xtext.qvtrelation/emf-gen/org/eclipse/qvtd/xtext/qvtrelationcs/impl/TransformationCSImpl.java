/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.impl.ClassCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl#getOwnedModelDecls <em>Owned Model Decls</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl#getOwnedKeyDecls <em>Owned Key Decls</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl#getOwnedQueries <em>Owned Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl#getOwnedRelations <em>Owned Relations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationCSImpl extends ClassCSImpl implements TransformationCS {
	/**
	 * The cached value of the '{@link #getOwnedModelDecls() <em>Owned Model Decls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedModelDecls()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelDeclCS> ownedModelDecls;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<Transformation> extends_;

	/**
	 * The cached value of the '{@link #getOwnedKeyDecls() <em>Owned Key Decls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedKeyDecls()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyDeclCS> ownedKeyDecls;

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
	 * The cached value of the '{@link #getOwnedQueries() <em>Owned Queries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<QueryCS> ownedQueries;

	/**
	 * The cached value of the '{@link #getOwnedRelations() <em>Owned Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationCS> ownedRelations;

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
		return QVTrelationCSPackage.Literals.TRANSFORMATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModelDeclCS> getOwnedModelDecls() {
		if (ownedModelDecls == null) {
			ownedModelDecls = new EObjectContainmentEList<ModelDeclCS>(ModelDeclCS.class, this, QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_MODEL_DECLS);
		}
		return ownedModelDecls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Transformation> getExtends() {
		if (extends_ == null) {
			extends_ = new EObjectResolvingEList<Transformation>(Transformation.class, this, QVTrelationCSPackage.TRANSFORMATION_CS__EXTENDS);
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<KeyDeclCS> getOwnedKeyDecls() {
		if (ownedKeyDecls == null) {
			ownedKeyDecls = new EObjectContainmentEList<KeyDeclCS>(KeyDeclCS.class, this, QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_KEY_DECLS);
		}
		return ownedKeyDecls;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_PATH_NAME, oldOwnedPathName, newOwnedPathName);
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
				msgs = ((InternalEObject)ownedPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_PATH_NAME, null, msgs);
			if (newOwnedPathName != null)
				msgs = ((InternalEObject)newOwnedPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_PATH_NAME, null, msgs);
			msgs = basicSetOwnedPathName(newOwnedPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_PATH_NAME, newOwnedPathName, newOwnedPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<QueryCS> getOwnedQueries() {
		if (ownedQueries == null) {
			ownedQueries = new EObjectContainmentEList<QueryCS>(QueryCS.class, this, QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_QUERIES);
		}
		return ownedQueries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelationCS> getOwnedRelations() {
		if (ownedRelations == null) {
			ownedRelations = new EObjectContainmentEList<RelationCS>(RelationCS.class, this, QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_RELATIONS);
		}
		return ownedRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_MODEL_DECLS:
				return ((InternalEList<?>)getOwnedModelDecls()).basicRemove(otherEnd, msgs);
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_KEY_DECLS:
				return ((InternalEList<?>)getOwnedKeyDecls()).basicRemove(otherEnd, msgs);
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_PATH_NAME:
				return basicSetOwnedPathName(null, msgs);
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_QUERIES:
				return ((InternalEList<?>)getOwnedQueries()).basicRemove(otherEnd, msgs);
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_RELATIONS:
				return ((InternalEList<?>)getOwnedRelations()).basicRemove(otherEnd, msgs);
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
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_MODEL_DECLS:
				return getOwnedModelDecls();
			case QVTrelationCSPackage.TRANSFORMATION_CS__EXTENDS:
				return getExtends();
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_KEY_DECLS:
				return getOwnedKeyDecls();
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_PATH_NAME:
				return getOwnedPathName();
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_QUERIES:
				return getOwnedQueries();
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_RELATIONS:
				return getOwnedRelations();
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
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_MODEL_DECLS:
				getOwnedModelDecls().clear();
				getOwnedModelDecls().addAll((Collection<? extends ModelDeclCS>)newValue);
				return;
			case QVTrelationCSPackage.TRANSFORMATION_CS__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends Transformation>)newValue);
				return;
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_KEY_DECLS:
				getOwnedKeyDecls().clear();
				getOwnedKeyDecls().addAll((Collection<? extends KeyDeclCS>)newValue);
				return;
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathNameCS)newValue);
				return;
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_QUERIES:
				getOwnedQueries().clear();
				getOwnedQueries().addAll((Collection<? extends QueryCS>)newValue);
				return;
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_RELATIONS:
				getOwnedRelations().clear();
				getOwnedRelations().addAll((Collection<? extends RelationCS>)newValue);
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
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_MODEL_DECLS:
				getOwnedModelDecls().clear();
				return;
			case QVTrelationCSPackage.TRANSFORMATION_CS__EXTENDS:
				getExtends().clear();
				return;
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_KEY_DECLS:
				getOwnedKeyDecls().clear();
				return;
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathNameCS)null);
				return;
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_QUERIES:
				getOwnedQueries().clear();
				return;
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_RELATIONS:
				getOwnedRelations().clear();
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
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_MODEL_DECLS:
				return ownedModelDecls != null && !ownedModelDecls.isEmpty();
			case QVTrelationCSPackage.TRANSFORMATION_CS__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_KEY_DECLS:
				return ownedKeyDecls != null && !ownedKeyDecls.isEmpty();
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_PATH_NAME:
				return ownedPathName != null;
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_QUERIES:
				return ownedQueries != null && !ownedQueries.isEmpty();
			case QVTrelationCSPackage.TRANSFORMATION_CS__OWNED_RELATIONS:
				return ownedRelations != null && !ownedRelations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTrelationCSVisitor<?>)visitor).visitTransformationCS(this);
	}
} //TransformationCSImpl
