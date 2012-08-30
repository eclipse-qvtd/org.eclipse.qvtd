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
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.PackageCSImpl;
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
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl#getModelDecls <em>Model Decls</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl#getKeyDecls <em>Key Decls</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl#getQueries <em>Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl#getRelation <em>Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationCSImpl extends PackageCSImpl implements TransformationCS {
	/**
	 * The cached value of the '{@link #getModelDecls() <em>Model Decls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelDecls()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelDeclCS> modelDecls;

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
	 * The cached value of the '{@link #getKeyDecls() <em>Key Decls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyDecls()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyDeclCS> keyDecls;

	/**
	 * The cached value of the '{@link #getQueries() <em>Queries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<QueryCS> queries;

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
	public EList<ModelDeclCS> getModelDecls() {
		if (modelDecls == null) {
			modelDecls = new EObjectContainmentEList<ModelDeclCS>(ModelDeclCS.class, this, QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECLS);
		}
		return modelDecls;
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
	public EList<KeyDeclCS> getKeyDecls() {
		if (keyDecls == null) {
			keyDecls = new EObjectContainmentEList<KeyDeclCS>(KeyDeclCS.class, this, QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECLS);
		}
		return keyDecls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QueryCS> getQueries() {
		if (queries == null) {
			queries = new EObjectContainmentEList<QueryCS>(QueryCS.class, this, QVTrelationCSTPackage.TRANSFORMATION_CS__QUERIES);
		}
		return queries;
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
			case QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECLS:
				return ((InternalEList<?>)getModelDecls()).basicRemove(otherEnd, msgs);
			case QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECLS:
				return ((InternalEList<?>)getKeyDecls()).basicRemove(otherEnd, msgs);
			case QVTrelationCSTPackage.TRANSFORMATION_CS__QUERIES:
				return ((InternalEList<?>)getQueries()).basicRemove(otherEnd, msgs);
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
			case QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECLS:
				return getModelDecls();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__EXTENDS:
				return getExtends();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECLS:
				return getKeyDecls();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__QUERIES:
				return getQueries();
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
			case QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECLS:
				getModelDecls().clear();
				getModelDecls().addAll((Collection<? extends ModelDeclCS>)newValue);
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends Transformation>)newValue);
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECLS:
				getKeyDecls().clear();
				getKeyDecls().addAll((Collection<? extends KeyDeclCS>)newValue);
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__QUERIES:
				getQueries().clear();
				getQueries().addAll((Collection<? extends QueryCS>)newValue);
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
			case QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECLS:
				getModelDecls().clear();
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__EXTENDS:
				getExtends().clear();
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECLS:
				getKeyDecls().clear();
				return;
			case QVTrelationCSTPackage.TRANSFORMATION_CS__QUERIES:
				getQueries().clear();
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
			case QVTrelationCSTPackage.TRANSFORMATION_CS__MODEL_DECLS:
				return modelDecls != null && !modelDecls.isEmpty();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__KEY_DECLS:
				return keyDecls != null && !keyDecls.isEmpty();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__QUERIES:
				return queries != null && !queries.isEmpty();
			case QVTrelationCSTPackage.TRANSFORMATION_CS__RELATION:
				return relation != null && !relation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(BaseCSVisitor<R> visitor) {
		return (R) visitor.getAdapter(QVTrelationCSVisitor.class).visitTransformationCS(this);
	}
} //TransformationCSImpl
