/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtrelationcst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl#getModelDecl <em>Model Decl</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl#getKeyDecl <em>Key Decl</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl#getRelation <em>Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationCSImpl extends NamedElementCSImpl implements TransformationCS {
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
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<Transformation> extends_;

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
		return QVTrelationCSTPackage.Literals.TRANSFORMATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelDeclCS> getModelDecl() {
		if (modelDecl == null) {
			modelDecl = new EObjectContainmentEList<ModelDeclCS>(ModelDeclCS.class, this, QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECL);
		}
		return modelDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transformation> getExtends() {
		if (extends_ == null) {
			extends_ = new EObjectResolvingEList<Transformation>(Transformation.class, this, QVTrelationCSTPackage.TRANSFORMATION_CS__EXTENDS);
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KeyDeclCS> getKeyDecl() {
		if (keyDecl == null) {
			keyDecl = new EObjectContainmentEList<KeyDeclCS>(KeyDeclCS.class, this, QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECL);
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
			query = new EObjectContainmentEList<QueryCS>(QueryCS.class, this, QVTrelationCSTPackage.TRANSFORMATION_CS__QUERY);
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
			relation = new EObjectContainmentEList<RelationCS>(RelationCS.class, this, QVTrelationCSTPackage.TRANSFORMATION_CS__RELATION);
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
			case QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECL:
				return ((InternalEList<?>)getModelDecl()).basicRemove(otherEnd, msgs);
			case QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECL:
				return ((InternalEList<?>)getKeyDecl()).basicRemove(otherEnd, msgs);
			case QVTrelationCSTPackage.TRANSFORMATION_CS__QUERY:
				return ((InternalEList<?>)getQuery()).basicRemove(otherEnd, msgs);
			case QVTrelationCSTPackage.TRANSFORMATION_CS__RELATION:
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
			case QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECL:
				return getModelDecl();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__EXTENDS:
				return getExtends();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECL:
				return getKeyDecl();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__QUERY:
				return getQuery();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__RELATION:
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
			case QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECL:
				getModelDecl().clear();
				getModelDecl().addAll((Collection<? extends ModelDeclCS>)newValue);
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends Transformation>)newValue);
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECL:
				getKeyDecl().clear();
				getKeyDecl().addAll((Collection<? extends KeyDeclCS>)newValue);
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__QUERY:
				getQuery().clear();
				getQuery().addAll((Collection<? extends QueryCS>)newValue);
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__RELATION:
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
			case QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECL:
				getModelDecl().clear();
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__EXTENDS:
				getExtends().clear();
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECL:
				getKeyDecl().clear();
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__QUERY:
				getQuery().clear();
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__RELATION:
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
			case QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECL:
				return modelDecl != null && !modelDecl.isEmpty();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECL:
				return keyDecl != null && !keyDecl.isEmpty();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__QUERY:
				return query != null && !query.isEmpty();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__RELATION:
				return relation != null && !relation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return (R) visitor.getAdapter(QVTrelationCSVisitor.class).visitTransformationCS(this);
	}
} //TransformationCSImpl
