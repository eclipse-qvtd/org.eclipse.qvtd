/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.xtext.qvtbasecs.impl.AbstractTransformationCSImpl;
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
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl#getOwnedQueries <em>Owned Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl#getOwnedRelations <em>Owned Relations</em>}</li>
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
	public static final int TRANSFORMATION_CS_FEATURE_COUNT = AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 5;

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
			ownedModelDecls = new EObjectContainmentEList<ModelDeclCS>(ModelDeclCS.class, this, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 0);
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
			extends_ = new EObjectResolvingEList<Transformation>(Transformation.class, this, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1);
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
			ownedKeyDecls = new EObjectContainmentEList<KeyDeclCS>(KeyDeclCS.class, this, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2);
		}
		return ownedKeyDecls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<QueryCS> getOwnedQueries() {
		if (ownedQueries == null) {
			ownedQueries = new EObjectContainmentEList<QueryCS>(QueryCS.class, this, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3);
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
			ownedRelations = new EObjectContainmentEList<RelationCS>(RelationCS.class, this, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4);
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
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getOwnedModelDecls()).basicRemove(otherEnd, msgs);
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getOwnedKeyDecls()).basicRemove(otherEnd, msgs);
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getOwnedQueries()).basicRemove(otherEnd, msgs);
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4:
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
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 0:
				return getOwnedModelDecls();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1:
				return getExtends();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2:
				return getOwnedKeyDecls();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3:
				return getOwnedQueries();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4:
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
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 0:
				getOwnedModelDecls().clear();
				getOwnedModelDecls().addAll((Collection<? extends ModelDeclCS>)newValue);
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1:
				getExtends().clear();
				getExtends().addAll((Collection<? extends Transformation>)newValue);
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2:
				getOwnedKeyDecls().clear();
				getOwnedKeyDecls().addAll((Collection<? extends KeyDeclCS>)newValue);
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3:
				getOwnedQueries().clear();
				getOwnedQueries().addAll((Collection<? extends QueryCS>)newValue);
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4:
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
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 0:
				getOwnedModelDecls().clear();
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1:
				getExtends().clear();
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2:
				getOwnedKeyDecls().clear();
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3:
				getOwnedQueries().clear();
				return;
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4:
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
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 0:
				return ownedModelDecls != null && !ownedModelDecls.isEmpty();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1:
				return extends_ != null && !extends_.isEmpty();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2:
				return ownedKeyDecls != null && !ownedKeyDecls.isEmpty();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3:
				return ownedQueries != null && !ownedQueries.isEmpty();
			case AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4:
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
