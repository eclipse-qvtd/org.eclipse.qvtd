/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl#getDefaultAssignment <em>Default Assignment</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl#getRootVariable <em>Root Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationDomainImpl extends DomainImpl implements RelationDomain {
	/**
	 * The cached value of the '{@link #getDefaultAssignment() <em>Default Assignment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultAssignment()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationDomainAssignment> defaultAssignment;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainPattern> pattern;

	/**
	 * The cached value of the '{@link #getRootVariable() <em>Root Variable</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> rootVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationPackage.Literals.RELATION_DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<RelationDomainAssignment> getDefaultAssignment() {
		if (defaultAssignment == null) {
			defaultAssignment = new EObjectContainmentEList<RelationDomainAssignment>(RelationDomainAssignment.class, this, QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT);
		}
		return defaultAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<DomainPattern> getPattern() {
		if (pattern == null) {
			pattern = new EObjectContainmentEList<DomainPattern>(DomainPattern.class, this, QVTrelationPackage.RELATION_DOMAIN__PATTERN);
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<Variable> getRootVariable() {
		if (rootVariable == null) {
			rootVariable = new EObjectResolvingEList<Variable>(Variable.class, this, QVTrelationPackage.RELATION_DOMAIN__ROOT_VARIABLE);
		}
		return rootVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT:
				return ((InternalEList<?>)getDefaultAssignment()).basicRemove(otherEnd, msgs);
			case QVTrelationPackage.RELATION_DOMAIN__PATTERN:
				return ((InternalEList<?>)getPattern()).basicRemove(otherEnd, msgs);
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
			case QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT:
				return getDefaultAssignment();
			case QVTrelationPackage.RELATION_DOMAIN__PATTERN:
				return getPattern();
			case QVTrelationPackage.RELATION_DOMAIN__ROOT_VARIABLE:
				return getRootVariable();
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
			case QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT:
				getDefaultAssignment().clear();
				getDefaultAssignment().addAll((Collection<? extends RelationDomainAssignment>)newValue);
				return;
			case QVTrelationPackage.RELATION_DOMAIN__PATTERN:
				getPattern().clear();
				getPattern().addAll((Collection<? extends DomainPattern>)newValue);
				return;
			case QVTrelationPackage.RELATION_DOMAIN__ROOT_VARIABLE:
				getRootVariable().clear();
				getRootVariable().addAll((Collection<? extends Variable>)newValue);
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
			case QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT:
				getDefaultAssignment().clear();
				return;
			case QVTrelationPackage.RELATION_DOMAIN__PATTERN:
				getPattern().clear();
				return;
			case QVTrelationPackage.RELATION_DOMAIN__ROOT_VARIABLE:
				getRootVariable().clear();
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
			case QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT:
				return defaultAssignment != null && !defaultAssignment.isEmpty();
			case QVTrelationPackage.RELATION_DOMAIN__PATTERN:
				return pattern != null && !pattern.isEmpty();
			case QVTrelationPackage.RELATION_DOMAIN__ROOT_VARIABLE:
				return rootVariable != null && !rootVariable.isEmpty();
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
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTrelationVisitor<?>)visitor).visitRelationDomain(this);
	}
} //RelationDomainImpl
