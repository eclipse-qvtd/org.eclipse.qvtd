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
 * $Id: TransformationCSImpl.java,v 1.2 2008/08/18 07:55:54 ewillink Exp $
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
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TransformationCSImpl#getModelDecl <em>Model Decl</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TransformationCSImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TransformationCSImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TransformationCSImpl#getKeyDecl <em>Key Decl</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TransformationCSImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TransformationCSImpl#getRelation <em>Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationCSImpl extends CSTNodeImpl implements TransformationCS {
	/**
	 * The cached value of the '{@link #getModelDecl() <em>Model Decl</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelDecl()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelDeclCS> modelDecl;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected IdentifierCS extends_;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected IdentifierCS identifier;

	/**
	 * The cached value of the '{@link #getKeyDecl() <em>Key Decl</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyDecl()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyDeclCS> keyDecl;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected EList<QueryCS> query;

	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationCS> relation;

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
		return QVTrCSTPackage.Literals.TRANSFORMATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelDeclCS> getModelDecl() {
		if (modelDecl == null) {
			modelDecl = new EObjectContainmentEList<ModelDeclCS>(ModelDeclCS.class, this, QVTrCSTPackage.TRANSFORMATION_CS__MODEL_DECL);
		}
		return modelDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierCS getExtends() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtends(IdentifierCS newExtends, NotificationChain msgs) {
		IdentifierCS oldExtends = extends_;
		extends_ = newExtends;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.TRANSFORMATION_CS__EXTENDS, oldExtends, newExtends);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtends(IdentifierCS newExtends) {
		if (newExtends != extends_) {
			NotificationChain msgs = null;
			if (extends_ != null)
				msgs = ((InternalEObject)extends_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.TRANSFORMATION_CS__EXTENDS, null, msgs);
			if (newExtends != null)
				msgs = ((InternalEObject)newExtends).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.TRANSFORMATION_CS__EXTENDS, null, msgs);
			msgs = basicSetExtends(newExtends, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.TRANSFORMATION_CS__EXTENDS, newExtends, newExtends));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierCS getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifier(IdentifierCS newIdentifier, NotificationChain msgs) {
		IdentifierCS oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.TRANSFORMATION_CS__IDENTIFIER, oldIdentifier, newIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(IdentifierCS newIdentifier) {
		if (newIdentifier != identifier) {
			NotificationChain msgs = null;
			if (identifier != null)
				msgs = ((InternalEObject)identifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.TRANSFORMATION_CS__IDENTIFIER, null, msgs);
			if (newIdentifier != null)
				msgs = ((InternalEObject)newIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.TRANSFORMATION_CS__IDENTIFIER, null, msgs);
			msgs = basicSetIdentifier(newIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.TRANSFORMATION_CS__IDENTIFIER, newIdentifier, newIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KeyDeclCS> getKeyDecl() {
		if (keyDecl == null) {
			keyDecl = new EObjectContainmentEList<KeyDeclCS>(KeyDeclCS.class, this, QVTrCSTPackage.TRANSFORMATION_CS__KEY_DECL);
		}
		return keyDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QueryCS> getQuery() {
		if (query == null) {
			query = new EObjectContainmentEList<QueryCS>(QueryCS.class, this, QVTrCSTPackage.TRANSFORMATION_CS__QUERY);
		}
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RelationCS> getRelation() {
		if (relation == null) {
			relation = new EObjectContainmentEList<RelationCS>(RelationCS.class, this, QVTrCSTPackage.TRANSFORMATION_CS__RELATION);
		}
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrCSTPackage.TRANSFORMATION_CS__MODEL_DECL:
				return ((InternalEList<?>)getModelDecl()).basicRemove(otherEnd, msgs);
			case QVTrCSTPackage.TRANSFORMATION_CS__EXTENDS:
				return basicSetExtends(null, msgs);
			case QVTrCSTPackage.TRANSFORMATION_CS__IDENTIFIER:
				return basicSetIdentifier(null, msgs);
			case QVTrCSTPackage.TRANSFORMATION_CS__KEY_DECL:
				return ((InternalEList<?>)getKeyDecl()).basicRemove(otherEnd, msgs);
			case QVTrCSTPackage.TRANSFORMATION_CS__QUERY:
				return ((InternalEList<?>)getQuery()).basicRemove(otherEnd, msgs);
			case QVTrCSTPackage.TRANSFORMATION_CS__RELATION:
				return ((InternalEList<?>)getRelation()).basicRemove(otherEnd, msgs);
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
			case QVTrCSTPackage.TRANSFORMATION_CS__MODEL_DECL:
				return getModelDecl();
			case QVTrCSTPackage.TRANSFORMATION_CS__EXTENDS:
				return getExtends();
			case QVTrCSTPackage.TRANSFORMATION_CS__IDENTIFIER:
				return getIdentifier();
			case QVTrCSTPackage.TRANSFORMATION_CS__KEY_DECL:
				return getKeyDecl();
			case QVTrCSTPackage.TRANSFORMATION_CS__QUERY:
				return getQuery();
			case QVTrCSTPackage.TRANSFORMATION_CS__RELATION:
				return getRelation();
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
			case QVTrCSTPackage.TRANSFORMATION_CS__MODEL_DECL:
				getModelDecl().clear();
				getModelDecl().addAll((Collection<? extends ModelDeclCS>)newValue);
				return;
			case QVTrCSTPackage.TRANSFORMATION_CS__EXTENDS:
				setExtends((IdentifierCS)newValue);
				return;
			case QVTrCSTPackage.TRANSFORMATION_CS__IDENTIFIER:
				setIdentifier((IdentifierCS)newValue);
				return;
			case QVTrCSTPackage.TRANSFORMATION_CS__KEY_DECL:
				getKeyDecl().clear();
				getKeyDecl().addAll((Collection<? extends KeyDeclCS>)newValue);
				return;
			case QVTrCSTPackage.TRANSFORMATION_CS__QUERY:
				getQuery().clear();
				getQuery().addAll((Collection<? extends QueryCS>)newValue);
				return;
			case QVTrCSTPackage.TRANSFORMATION_CS__RELATION:
				getRelation().clear();
				getRelation().addAll((Collection<? extends RelationCS>)newValue);
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
			case QVTrCSTPackage.TRANSFORMATION_CS__MODEL_DECL:
				getModelDecl().clear();
				return;
			case QVTrCSTPackage.TRANSFORMATION_CS__EXTENDS:
				setExtends((IdentifierCS)null);
				return;
			case QVTrCSTPackage.TRANSFORMATION_CS__IDENTIFIER:
				setIdentifier((IdentifierCS)null);
				return;
			case QVTrCSTPackage.TRANSFORMATION_CS__KEY_DECL:
				getKeyDecl().clear();
				return;
			case QVTrCSTPackage.TRANSFORMATION_CS__QUERY:
				getQuery().clear();
				return;
			case QVTrCSTPackage.TRANSFORMATION_CS__RELATION:
				getRelation().clear();
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
			case QVTrCSTPackage.TRANSFORMATION_CS__MODEL_DECL:
				return modelDecl != null && !modelDecl.isEmpty();
			case QVTrCSTPackage.TRANSFORMATION_CS__EXTENDS:
				return extends_ != null;
			case QVTrCSTPackage.TRANSFORMATION_CS__IDENTIFIER:
				return identifier != null;
			case QVTrCSTPackage.TRANSFORMATION_CS__KEY_DECL:
				return keyDecl != null && !keyDecl.isEmpty();
			case QVTrCSTPackage.TRANSFORMATION_CS__QUERY:
				return query != null && !query.isEmpty();
			case QVTrCSTPackage.TRANSFORMATION_CS__RELATION:
				return relation != null && !relation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransformationCSImpl
