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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Mapping Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getMappingCalls <em>Mapping Calls</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getPredicates <em>Predicates</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl#getRealizedVariables <em>Realized Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGMappingExpImpl extends CGValuedElementImpl implements CGMappingExp {
	/**
	 * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<CGPropertyAssignment> assignments;

	/**
	 * The cached value of the '{@link #getMappingCalls() <em>Mapping Calls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingCalls()
	 * @generated
	 * @ordered
	 */
	protected EList<CGMappingCall> mappingCalls;

	/**
	 * The cached value of the '{@link #getPredicates() <em>Predicates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicates()
	 * @generated
	 * @ordered
	 */
	protected EList<CGPredicate> predicates;

	/**
	 * The cached value of the '{@link #getRealizedVariables() <em>Realized Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<CGRealizedVariable> realizedVariables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGMappingExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_MAPPING_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGPropertyAssignment> getAssignments() {
		if (assignments == null) {
			assignments = new EObjectContainmentWithInverseEList<CGPropertyAssignment>(CGPropertyAssignment.class, this, QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP);
		}
		return assignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGMapping getMapping() {
		// TODO: implement this method to return the 'Mapping' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapping(CGMapping newMapping) {
		// TODO: implement this method to set the 'Mapping' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGMappingCall> getMappingCalls() {
		if (mappingCalls == null) {
			mappingCalls = new EObjectContainmentWithInverseEList<CGMappingCall>(CGMappingCall.class, this, QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING_CALLS, QVTiCGModelPackage.CG_MAPPING_CALL__MAPPING_EXP);
		}
		return mappingCalls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGPredicate> getPredicates() {
		if (predicates == null) {
			predicates = new EObjectContainmentWithInverseEList<CGPredicate>(CGPredicate.class, this, QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES, QVTiCGModelPackage.CG_PREDICATE__MAPPING_EXP);
		}
		return predicates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CGRealizedVariable> getRealizedVariables() {
		if (realizedVariables == null) {
			realizedVariables = new EObjectContainmentWithInverseEList<CGRealizedVariable>(CGRealizedVariable.class, this, QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES, QVTiCGModelPackage.CG_REALIZED_VARIABLE__MAPPING_EXP);
		}
		return realizedVariables;
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssignments()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING_CALLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappingCalls()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPredicates()).basicAdd(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRealizedVariables()).basicAdd(otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING_CALLS:
				return ((InternalEList<?>)getMappingCalls()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				return ((InternalEList<?>)getPredicates()).basicRemove(otherEnd, msgs);
			case QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES:
				return ((InternalEList<?>)getRealizedVariables()).basicRemove(otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				return getAssignments();
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING:
				return getMapping();
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING_CALLS:
				return getMappingCalls();
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				return getPredicates();
			case QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES:
				return getRealizedVariables();
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				getAssignments().clear();
				getAssignments().addAll((Collection<? extends CGPropertyAssignment>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING:
				setMapping((CGMapping)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING_CALLS:
				getMappingCalls().clear();
				getMappingCalls().addAll((Collection<? extends CGMappingCall>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				getPredicates().clear();
				getPredicates().addAll((Collection<? extends CGPredicate>)newValue);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES:
				getRealizedVariables().clear();
				getRealizedVariables().addAll((Collection<? extends CGRealizedVariable>)newValue);
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				getAssignments().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING:
				setMapping((CGMapping)null);
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING_CALLS:
				getMappingCalls().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				getPredicates().clear();
				return;
			case QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES:
				getRealizedVariables().clear();
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
			case QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS:
				return assignments != null && !assignments.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING:
				return getMapping() != null;
			case QVTiCGModelPackage.CG_MAPPING_EXP__MAPPING_CALLS:
				return mappingCalls != null && !mappingCalls.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING_EXP__PREDICATES:
				return predicates != null && !predicates.isEmpty();
			case QVTiCGModelPackage.CG_MAPPING_EXP__REALIZED_VARIABLES:
				return realizedVariables != null && !realizedVariables.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGMappingExp(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable TypeId getPivotTypeId() {
		return TypeId.BOOLEAN;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isBoxed() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isUnboxed() {
		return true;
	}

} //CGMappingExpImpl
